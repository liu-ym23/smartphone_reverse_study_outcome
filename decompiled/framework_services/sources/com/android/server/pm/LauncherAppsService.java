package com.android.server.pm;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.IApplicationThread;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyCache;
import android.app.admin.DevicePolicyManager;
import android.app.role.RoleManager;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.PermissionChecker;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ILauncherApps;
import android.content.pm.IOnAppsChangedListener;
import android.content.pm.IPackageInstallerCallback;
import android.content.pm.IPackageManager;
import android.content.pm.IShortcutChangeCallback;
import android.content.pm.IncrementalStatesInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.LauncherActivityInfoInternal;
import android.content.pm.LauncherApps;
import android.content.pm.LauncherUserInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutQueryWrapper;
import android.content.pm.ShortcutServiceInternal;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.window.IDumpCallback;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.Preconditions;
import com.android.internal.util.SizedInputStream;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.ArchiveState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.IExtTask;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class LauncherAppsService extends SystemService {
    private static final String PS_SETTINGS_INTENT = "com.android.settings.action.OPEN_PRIVATE_SPACE_SETTINGS";
    private static final String VC_FILE_SUFFIX = ".vc";
    private static final String WM_TRACE_DIR = "/data/misc/wmtrace/";
    private static final Set<PosixFilePermission> WM_TRACE_FILE_PERMISSIONS = null;
    private final LauncherAppsImpl mLauncherAppsImpl;

    static class BroadcastCookie {
        public final int callingPid;
        public final int callingUid;
        public final String packageName;
        public final UserHandle user;

        BroadcastCookie(UserHandle userHandle, String packageName, int callingPid, int callingUid) {
            this.user = userHandle;
            this.packageName = packageName;
            this.callingUid = callingUid;
            this.callingPid = callingPid;
        }
    }

    static class LauncherAppsImpl extends ILauncherApps.Stub {
        private static final boolean DEBUG = false;
        private static final String FLAG_NON_SYSTEM_ACCESS_TO_HIDDEN_PROFILES = "allow_3p_launchers_access_via_launcher_apps_apis";
        private static final String NAMESPACE_MULTIUSER = "multiuser";
        private static final String TAG = "LauncherAppsService";
        private final ActivityManagerInternal mActivityManagerInternal;
        private final ActivityTaskManagerInternal mActivityTaskManagerInternal;
        private final AppOpsManager mAppOpsManager;
        private final Handler mCallbackHandler;
        private final Context mContext;
        private final DevicePolicyManager mDpm;
        private final RemoteCallbackList<IDumpCallback> mDumpCallbacks;
        private final IPackageManager mIPM;
        final LauncherAppsServiceInternal mInternal;
        private boolean mIsWatchingPackageBroadcasts;
        private final PackageCallbackList<IOnAppsChangedListener> mListeners;
        private final ExecutorService mOnDumpExecutor;
        private PackageInstallerService mPackageInstallerService;
        private final PackageManagerInternal mPackageManagerInternal;
        private final MyPackageMonitor mPackageMonitor;
        private final PackageRemovedListener mPackageRemovedListener;
        private final RoleManager mRoleManager;
        private SecureSettingsObserver mSecureSettingsObserver;
        private final ShortcutChangeHandler mShortcutChangeHandler;
        private final ShortcutServiceInternal mShortcutServiceInternal;
        private final UserManager mUm;
        private final UsageStatsManagerInternal mUsageStatsManagerInternal;
        private final UserManagerInternal mUserManagerInternal;

        private class LauncherAppsShellCommand extends ShellCommand {
            final /* synthetic */ LauncherAppsImpl this$0;

            public static /* synthetic */ void $r8$lambda$33VqtH4sZozKU8I_ZIHFGeDl2R0(LauncherAppsShellCommand r0, ZipOutputStream r1, String r2, InputStream r3) {
                r0.lambda$dumpViewCaptureDataToShell$0(r1, r2, r3);
            }

            /* synthetic */ LauncherAppsShellCommand(LauncherAppsImpl r1, LauncherAppsServiceIA r2) {
                this(r1);
            }

            private LauncherAppsShellCommand(LauncherAppsImpl r1) {
                this.this$0 = r1;
            }

            public int onCommand(String cmd) {
                if ("dump-view-hierarchies".equals(cmd) == false) goto L7;
                dumpViewCaptureDataToShell();
                return 0;
            L7:
                return handleDefaultCommands(cmd);
            }

            private void dumpViewCaptureDataToShell() {
                final ZipOutputStream zipOs = new ZipOutputStream(getRawOutputStream());     // Catch: IOException -> L6
                LauncherAppsImpl.m6706$$Nest$mforEachViewCaptureWindow(this.this$0, new LauncherAppsService$LauncherAppsImpl$LauncherAppsShellCommand$$ExternalSyntheticLambda0(this, zipOs));     // Catch: Throwable -> L8
                zipOs.close();     // Catch: IOException -> L6
                return;
            L8:
                th = move-exception;
                zipOs.close();     // Catch: Throwable -> L11
            L13:
                throw th;     // Catch: IOException -> L6
            L11:
                th = move-exception;
                th.addSuppressed(th);     // Catch: IOException -> L6
            L6:
                e = move-exception;
                getErrPrintWriter().write("Failed to create or close zip output stream: " + e.getMessage());
            }

            private /* synthetic */ void lambda$dumpViewCaptureDataToShell$0(ZipOutputStream zipOs, String fileName, InputStream is) {
                zipOs.putNextEntry(new ZipEntry("FS" + fileName));     // Catch: IOException -> L4
                LauncherAppsImpl.m6711$$Nest$mtransferViewCaptureData(this.this$0, is, zipOs);     // Catch: IOException -> L4
                zipOs.closeEntry();     // Catch: IOException -> L4
                return;
            L4:
                e = move-exception;
                getErrPrintWriter().write("Failed to output " + fileName + " data to shell: " + e.getMessage());
            }

            public void onHelp() {
                PrintWriter pw = getOutPrintWriter();
                pw.println("Usage: cmd launcherapps COMMAND [options ...]");
                pw.println();
                pw.println("cmd launcherapps dump-view-hierarchies");
                pw.println("    Output captured view hierarchies. Files will be generated in ");
                pw.println("    `/data/misc/wmtrace/`. After pulling the data to your device,");
                pw.println("     you can upload / visualize it at `go/winscope`.");
                pw.println();
            }
        }

        final class LocalService extends LauncherAppsServiceInternal {
            final /* synthetic */ LauncherAppsImpl this$0;

            LocalService(LauncherAppsImpl this$0) {
                this.this$0 = this$0;
            }

            @Override // com.android.server.pm.LauncherAppsService.LauncherAppsServiceInternal
            public boolean startShortcut(int callerUid, int callerPid, String callingPackage, String packageName, String featureId, String shortcutId, Rect sourceBounds, Bundle startActivityOptions, int targetUserId) {
                return LauncherAppsImpl.m6710$$Nest$mstartShortcutInner(this.this$0, callerUid, callerPid, UserHandle.getUserId(callerUid), callingPackage, packageName, featureId, shortcutId, sourceBounds, startActivityOptions, targetUserId);
            }
        }

        private class MyPackageMonitor extends PackageMonitor implements ShortcutServiceInternal.ShortcutChangeListener {
            final /* synthetic */ LauncherAppsImpl this$0;

            /* JADX INFO: renamed from: $r8$lambda$vtWdDInHNEcUSDBzImmSY0mx-XU, reason: not valid java name */
            public static /* synthetic */ void m6713$r8$lambda$vtWdDInHNEcUSDBzImmSY0mxXU(MyPackageMonitor r0, String r1, int r2) {
                r0.lambda$onShortcutChanged$0(r1, r2);
            }

            /* synthetic */ MyPackageMonitor(LauncherAppsImpl r1, LauncherAppsServiceIA r2) {
                this(r1);
            }

            private MyPackageMonitor(LauncherAppsImpl r1) {
                this.this$0 = r1;
            }

            public void onPackageAdded(String packageName, int uid) {
                UserHandle user = new UserHandle(getChangingUserId());
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L3:
                if (i >= n) goto L21;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L8
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L8
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, user, "onPackageAdded") == true) goto L11;
                Slog.d(LauncherAppsImpl.TAG, "onPackageAdded: Skipping - profile not enabled or not accessible for user=" + user + ", packageName=" + packageName);     // Catch: Throwable -> L8
            L18:
                i = i + 1;
                goto L3
            L11:
                if (LauncherAppsImpl.m6709$$Nest$misPackageVisibleToListener(this.this$0, packageName, cookie, user) == true) goto L23;
                Slog.d(LauncherAppsImpl.TAG, "onPackageAdded: Skipping - package filtered for user=" + user + ", packageName=" + packageName);     // Catch: Throwable -> L8
                goto L18
            L23:
                Slog.d(LauncherAppsImpl.TAG, "onPackageAdded: triggering onPackageAdded for user=" + user + ", packageName=" + packageName);     // Catch: Throwable -> L8 RemoteException -> L16
                listener.onPackageAdded(user, packageName);     // Catch: Throwable -> L8 RemoteException -> L16
            L16:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "onPackageAdded: Callback failed ", re);     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L21:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                super.onPackageAdded(packageName, uid);
                LauncherAppsImpl.m6703$$Nest$fgetmPackageManagerInternal(this.this$0).registerInstalledLoadingProgressCallback(packageName, new PackageLoadingProgressCallback(this.this$0, packageName, user), user.getIdentifier());
            }

            public void onPackageModified(String packageName) {
                onPackageChanged(packageName);
                super.onPackageModified(packageName);
            }

            private void onPackageChanged(String packageName) {
                UserHandle user = new UserHandle(getChangingUserId());
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L3:
                if (i >= n) goto L19;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L12
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L12
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, user, "onPackageModified") == true) goto L8;
            L16:
                i = i + 1;
                goto L3
            L8:
                if (LauncherAppsImpl.m6709$$Nest$misPackageVisibleToListener(this.this$0, packageName, cookie, user) == false) goto L16;
                listener.onPackageChanged(user, packageName);     // Catch: Throwable -> L12 RemoteException -> L14
            L14:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "onPackageChanged: Callback failed ", re);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L19:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
            }

            public void onPackagesAvailable(String[] packages) {
                UserHandle user = new UserHandle(getChangingUserId());
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L3:
                if (i >= n) goto L19;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L12
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L12
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, user, "onPackagesAvailable") == false) goto L16;
                String[] filteredPackages = LauncherAppsImpl.m6707$$Nest$mgetFilteredPackageNames(this.this$0, packages, cookie, user);     // Catch: Throwable -> L12
                if (ArrayUtils.isEmpty(filteredPackages) == true) goto L16;
                listener.onPackagesAvailable(user, filteredPackages, isReplacing());     // Catch: Throwable -> L12 RemoteException -> L14
            L14:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "Callback failed ", re);     // Catch: Throwable -> L12
            L16:
                i = i + 1;
            L12:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L19:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                super.onPackagesAvailable(packages);
            }

            public void onPackagesUnavailable(String[] packages) {
                UserHandle user = new UserHandle(getChangingUserId());
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L3:
                if (i >= n) goto L19;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L12
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L12
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, user, "onPackagesUnavailable") == false) goto L16;
                String[] filteredPackages = LauncherAppsImpl.m6707$$Nest$mgetFilteredPackageNames(this.this$0, packages, cookie, user);     // Catch: Throwable -> L12
                if (ArrayUtils.isEmpty(filteredPackages) == true) goto L16;
                listener.onPackagesUnavailable(user, filteredPackages, isReplacing());     // Catch: Throwable -> L12 RemoteException -> L14
            L14:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "Callback failed ", re);     // Catch: Throwable -> L12
            L16:
                i = i + 1;
            L12:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L19:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                super.onPackagesUnavailable(packages);
            }

            public void onPackagesSuspended(String[] packages) {
                UserHandle user = new UserHandle(getChangingUserId());
                ArrayList<Pair<String, Bundle>> packagesWithExtras = new ArrayList();
                ArrayList<String> packagesWithoutExtras = new ArrayList();
                int r3 = packages.length;
                int r4 = 0;
            L3:
                if (r4 >= r3) goto L9;
                String pkg = packages[r4];
                Bundle launcherExtras = LauncherAppsImpl.m6703$$Nest$fgetmPackageManagerInternal(this.this$0).getSuspendedPackageLauncherExtras(pkg, user.getIdentifier());
                if (launcherExtras == null) goto L7;
                packagesWithExtras.add(new Pair(pkg, launcherExtras));
            L8:
                r4 = r4 + 1;
                goto L3
            L7:
                packagesWithoutExtras.add(pkg);
                goto L8
            L9:
                String[] packagesNullExtras = (String[]) packagesWithoutExtras.toArray(new String[packagesWithoutExtras.size()]);
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L10:
                if (i >= n) goto L36;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L18
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L18
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, user, "onPackagesSuspended") == false) goto L33;
                String[] filteredPackagesWithoutExtras = LauncherAppsImpl.m6707$$Nest$mgetFilteredPackageNames(this.this$0, packagesNullExtras, cookie, user);     // Catch: Throwable -> L18
                if (ArrayUtils.isEmpty(filteredPackagesWithoutExtras) == true) goto L22;
                listener.onPackagesSuspended(user, filteredPackagesWithoutExtras, null);     // Catch: Throwable -> L18 RemoteException -> L20
            L22:
                int idx = 0;
            L24:
                if (idx >= packagesWithExtras.size()) goto L33;
                Pair<String, Bundle> packageExtraPair = packagesWithExtras.get(idx);     // Catch: Throwable -> L18 RemoteException -> L20
                if (LauncherAppsImpl.m6709$$Nest$misPackageVisibleToListener(this.this$0, (String) packageExtraPair.first, cookie, user) == false) goto L29;
                listener.onPackagesSuspended(user, new String[]{(String) packageExtraPair.first}, (Bundle) packageExtraPair.second);     // Catch: Throwable -> L18 RemoteException -> L20
            L29:
                idx = idx + 1;
                goto L24
            L20:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "Callback failed ", re);     // Catch: Throwable -> L18
            L33:
                i = i + 1;
            L18:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L36:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
            }

            public void onPackagesUnsuspended(String[] packages) {
                UserHandle user = new UserHandle(getChangingUserId());
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L3:
                if (i >= n) goto L19;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L12
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L12
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, user, "onPackagesUnsuspended") == false) goto L16;
                String[] filteredPackages = LauncherAppsImpl.m6707$$Nest$mgetFilteredPackageNames(this.this$0, packages, cookie, user);     // Catch: Throwable -> L12
                if (ArrayUtils.isEmpty(filteredPackages) == true) goto L16;
                listener.onPackagesUnsuspended(user, filteredPackages);     // Catch: Throwable -> L12 RemoteException -> L14
            L14:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "Callback failed ", re);     // Catch: Throwable -> L12
            L16:
                i = i + 1;
            L12:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L19:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                super.onPackagesUnsuspended(packages);
            }

            private /* synthetic */ void lambda$onShortcutChanged$0(String packageName, int userId) {
                onShortcutChangedInner(packageName, userId);
            }

            public void onShortcutChanged(final String packageName, final int userId) {
                this.this$0.postToPackageMonitorHandler(new LauncherAppsService$LauncherAppsImpl$MyPackageMonitor$$ExternalSyntheticLambda0(this, packageName, userId));
            }

            private void onShortcutChangedInner(String packageName, int userId) {
                MyPackageMonitor r1 = this;
                String r15 = LauncherAppsImpl.TAG;
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(r1.this$0).beginBroadcast();
                UserHandle user = UserHandle.of(userId);     // Catch: Throwable -> L42 RuntimeException -> L44
                int i = 0;
            L5:
                if (i >= n) goto L40;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(r1.this$0).getBroadcastItem(i);     // Catch: Throwable -> L34 RuntimeException -> L37
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(r1.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L34 RuntimeException -> L37
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(r1.this$0, cookie, user, "onShortcutChanged") == true) goto L10;
                int n2 = n;
                UserHandle user2 = user;
                int i2 = i;
                String r5 = r15;
            L29:
                i = i2 + 1;
                user = user2;
                r15 = r5;
                n = n2;
                r1 = this;
                goto L5
            L10:
                if (LauncherAppsImpl.m6709$$Nest$misPackageVisibleToListener(r1.this$0, packageName, cookie, user) == true) goto L12;
                n2 = n;
                user2 = user;
                i2 = i;
                r5 = r15;
                goto L29
            L12:
                int launcherUserId = cookie.user.getIdentifier();     // Catch: Throwable -> L34 RuntimeException -> L37
                if (LauncherAppsImpl.m6704$$Nest$fgetmShortcutServiceInternal(r1.this$0).hasShortcutHostPermission(launcherUserId, cookie.packageName, cookie.callingPid, cookie.callingUid) == true) goto L15;
                n2 = n;
                user2 = user;
                i2 = i;
                r5 = r15;
                goto L29
            L15:
                ShortcutServiceInternal r0 = LauncherAppsImpl.m6704$$Nest$fgetmShortcutServiceInternal(r1.this$0);     // Catch: Throwable -> L34 RuntimeException -> L37
                user2 = user;
                String r18 = r15;
                i2 = i;
                n2 = n;
                List<ShortcutInfo> list = r0.getShortcuts(launcherUserId, cookie.packageName, 0, packageName, null, null, null, 1055, userId, cookie.callingPid, cookie.callingUid);     // Catch: Throwable -> L21 RuntimeException -> L32
            L59:
                listener.onShortcutChanged(user2, packageName, new ParceledListSlice(list));     // Catch: Throwable -> L21 RuntimeException -> L23 RemoteException -> L25
                r5 = r18;
                goto L29
            L25:
                re = move-exception;
                r5 = r18;
                Slog.d(r5, "Callback failed ", re);     // Catch: Throwable -> L21 RuntimeException -> L30
            L30:
                e = e;
            L31:
                r1 = this;
            L57:
                Log.w(r5, e.getMessage(), e);     // Catch: Throwable -> L50
            L41:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(r1.this$0).finishBroadcast();
                return;
            L50:
                th = th;
            L51:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(r1.this$0).finishBroadcast();
                throw th;
            L23:
                e = e;
                r1 = this;
                r5 = r18;
            L21:
                th = th;
                r1 = this;
            L32:
                e = e;
                r5 = r18;
                goto L31
            L37:
                e = e;
                r5 = r15;
                r1 = this;
            L34:
                th = th;
                r1 = this;
                goto L51
            L40:
                r1 = this;
                goto L41
            L44:
                e = e;
                r5 = LauncherAppsImpl.TAG;
            L42:
                th = th;
                goto L51
            }

            public void onPackageStateChanged(String packageName, int uid) {
                onPackageChanged(packageName);
                super.onPackageStateChanged(packageName, uid);
            }
        }

        class PackageCallbackList<T extends IInterface> extends RemoteCallbackList<T> {
            final /* synthetic */ LauncherAppsImpl this$0;

            PackageCallbackList(LauncherAppsImpl this$0) {
                this.this$0 = this$0;
            }

            @Override // android.os.RemoteCallbackList
            public void onCallbackDied(T callback, Object cookie) {
                this.this$0.checkCallbackCount();
            }
        }

        class PackageLoadingProgressCallback extends PackageManagerInternal.InstalledLoadingProgressCallback {
            private final String mPackageName;
            private final UserHandle mUser;
            final /* synthetic */ LauncherAppsImpl this$0;

            PackageLoadingProgressCallback(LauncherAppsImpl this$0, String packageName, UserHandle user) {
                this.this$0 = this$0;
                super(LauncherAppsImpl.m6700$$Nest$fgetmCallbackHandler(this$0));
                this.mPackageName = packageName;
                this.mUser = user;
            }

            @Override // android.content.pm.PackageManagerInternal.InstalledLoadingProgressCallback
            public void onLoadingProgressChanged(float progress) {
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L3:
                if (i >= n) goto L19;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L12
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L12
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, this.mUser, "onLoadingProgressChanged") == true) goto L8;
            L16:
                i = i + 1;
                goto L3
            L8:
                if (LauncherAppsImpl.m6709$$Nest$misPackageVisibleToListener(this.this$0, this.mPackageName, cookie, this.mUser) == false) goto L16;
                listener.onPackageLoadingProgressChanged(this.mUser, this.mPackageName, progress);     // Catch: Throwable -> L12 RemoteException -> L14
            L14:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "Callback failed ", re);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L19:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
            }
        }

        private class PackageRemovedListener extends BroadcastReceiver {
            final /* synthetic */ LauncherAppsImpl this$0;

            /* synthetic */ PackageRemovedListener(LauncherAppsImpl r1, LauncherAppsServiceIA r2) {
                this(r1);
            }

            private PackageRemovedListener(LauncherAppsImpl r1) {
                this.this$0 = r1;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int userId = intent.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ);
                if (userId != (-10000)) goto L6;
                Slog.w(LauncherAppsImpl.TAG, "Intent broadcast does not contain user handle: " + intent);
                return;
            L6:
                String action = intent.getAction();
                if ("android.intent.action.PACKAGE_REMOVED_INTERNAL".equals(action) == false) goto L42;
                String packageName = getPackageName(intent);
                int[] appIdAllowList = intent.getIntArrayExtra("android.intent.extra.VISIBILITY_ALLOW_LIST");
                if (packageName != null) goto L11;
                return;
            L11:
                if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) == true) goto L44;
                UserHandle user = new UserHandle(userId);
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L13:
                if (i >= n) goto L31;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L18
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L18
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, user, "onPackageRemoved") == true) goto L21;
                Slog.d(LauncherAppsImpl.TAG, "onPackageRemoved: Skipping - profile not enabled or not accessible for user=" + user + ", packageName=" + packageName);     // Catch: Throwable -> L18
            L28:
                i = i + 1;
                goto L13
            L21:
                if (LauncherAppsImpl.m6712$$Nest$smisCallingAppIdAllowed(appIdAllowList, UserHandle.getAppId(cookie.callingUid)) == true) goto L33;
                Slog.d(LauncherAppsImpl.TAG, "onPackageRemoved: Skipping - appId not allowed for user=" + user + ", packageName=" + packageName);     // Catch: Throwable -> L18
                goto L28
            L33:
                Slog.d(LauncherAppsImpl.TAG, "onPackageRemoved: triggering onPackageRemoved for user=" + user + ", packageName=" + packageName);     // Catch: Throwable -> L18 RemoteException -> L26
                listener.onPackageRemoved(user, packageName);     // Catch: Throwable -> L18 RemoteException -> L26
            L26:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "onPackageRemoved: Callback failed ", re);     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L31:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                return;
            L44:
                return;
            }

            private String getPackageName(Intent intent) {
                Uri uri = intent.getData();
                if (uri == null) goto L5;
                String pkg = uri.getSchemeSpecificPart();
                return pkg;
            L5:
                return null;
            }
        }

        class SecureSettingsObserver extends ContentObserver {
            final /* synthetic */ LauncherAppsImpl this$0;

            SecureSettingsObserver(LauncherAppsImpl this$0) {
                this.this$0 = this$0;
                super(LauncherAppsImpl.m6700$$Nest$fgetmCallbackHandler(this$0));
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange, uri);
                if (uri.equals(android.provider.Settings.Secure.getUriFor("hide_privatespace_entry_point")) == false) goto L33;
                UserHandle privateProfile = getPrivateProfile();
                if (privateProfile.getIdentifier() != (-10000)) goto L7;
                return;
            L7:
                int n = LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).beginBroadcast();
                int i = 0;
            L8:
                if (i >= n) goto L23;
                IOnAppsChangedListener listener = (IOnAppsChangedListener) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L14
                BroadcastCookie cookie = (BroadcastCookie) LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).getBroadcastCookie(i);     // Catch: Throwable -> L14
                if (LauncherAppsImpl.m6708$$Nest$misEnabledProfileOf(this.this$0, cookie, privateProfile, "onSecureSettingsChange") == true) goto L27;
                Log.d(LauncherAppsImpl.TAG, "onSecureSettingsChange: Skipping - profile not enabled or not accessible for package=" + cookie.packageName + ", packageUid=" + cookie.callingUid);     // Catch: Throwable -> L14
            L20:
                i = i + 1;
                goto L8
            L27:
                Log.d(LauncherAppsImpl.TAG, "onUserConfigChanged: triggering onUserConfigChanged");     // Catch: Throwable -> L14 RemoteException -> L18
                listener.onUserConfigChanged(LauncherAppsImpl.m6705$$Nest$fgetmUserManagerInternal(this.this$0).getLauncherUserInfo(privateProfile.getIdentifier()));     // Catch: Throwable -> L14 RemoteException -> L18
            L18:
                re = move-exception;
                Slog.d(LauncherAppsImpl.TAG, "onUserConfigChanged: Callback failed ", re);     // Catch: Throwable -> L14
            L14:
                th = move-exception;
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                throw th;
            L23:
                LauncherAppsImpl.m6702$$Nest$fgetmListeners(this.this$0).finishBroadcast();
                return;
            }

            public void register() {
                UserHandle privateProfile = getPrivateProfile();
                if (privateProfile.getIdentifier() != (-10000)) goto L5;
                int parentUserId = LauncherAppsImpl.m6701$$Nest$fgetmContext(this.this$0).getUserId();
            L6:
                LauncherAppsImpl.m6701$$Nest$fgetmContext(this.this$0).getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("hide_privatespace_entry_point"), true, this, parentUserId);
                return;
            L5:
                parentUserId = LauncherAppsImpl.m6705$$Nest$fgetmUserManagerInternal(this.this$0).getProfileParentId(privateProfile.getIdentifier());
                goto L6
            }

            public void unregister() {
                LauncherAppsImpl.m6701$$Nest$fgetmContext(this.this$0).getContentResolver().unregisterContentObserver(this);
            }

            private UserHandle getPrivateProfile() {
                UserInfo[] userInfos = LauncherAppsImpl.m6705$$Nest$fgetmUserManagerInternal(this.this$0).getUserInfos();
                int r1 = userInfos.length;
                int r2 = 0;
            L3:
                if (r2 >= r1) goto L10;
                UserInfo u = userInfos[r2];
                if (u.isPrivateProfile() == true) goto L7;
                r2 = r2 + 1;
                goto L3
            L7:
                return UserHandle.of(u.id);
            L10:
                return UserHandle.of(ProcessList.INVALID_ADJ);
            }
        }

        public static class ShortcutChangeHandler implements LauncherApps.ShortcutChangeCallback {
            private final RemoteCallbackList<IShortcutChangeCallback> mCallbacks;
            private final UserManagerInternal mUserManagerInternal;

            ShortcutChangeHandler(UserManagerInternal userManager) {
                this.mCallbacks = new RemoteCallbackList();
                this.mUserManagerInternal = userManager;
            }

            public synchronized void addShortcutChangeCallback(IShortcutChangeCallback callback, ShortcutQueryWrapper query, UserHandle user) {
                monitor-enter(this);
                this.mCallbacks.unregister(callback);     // Catch: Throwable -> L6
                this.mCallbacks.register(callback, new Pair(query, user));     // Catch: Throwable -> L6
                monitor-exit(this);
                return;
            L6:
                th = move-exception;
                throw th;
            }

            public synchronized void removeShortcutChangeCallback(IShortcutChangeCallback callback) {
                monitor-enter(this);
                this.mCallbacks.unregister(callback);     // Catch: Throwable -> L6
                monitor-exit(this);
                return;
            L6:
                th = move-exception;
                throw th;
            }

            public void onShortcutsAddedOrUpdated(String packageName, List<ShortcutInfo> shortcuts, UserHandle user) {
                onShortcutEvent(packageName, shortcuts, user, false);
            }

            public void onShortcutsRemoved(String packageName, List<ShortcutInfo> shortcuts, UserHandle user) {
                onShortcutEvent(packageName, shortcuts, user, true);
            }

            private void onShortcutEvent(String packageName, List<ShortcutInfo> shortcuts, UserHandle user, boolean shortcutsRemoved) {
                int count = this.mCallbacks.beginBroadcast();
                int i = 0;
            L3:
                if (i >= count) goto L18;
                IShortcutChangeCallback callback = this.mCallbacks.getBroadcastItem(i);
                Pair<ShortcutQueryWrapper, UserHandle> cookie = (Pair) this.mCallbacks.getBroadcastCookie(i);
                UserHandle callbackUser = (UserHandle) cookie.second;
                if (callbackUser != null) goto L7;
            L9:
                List<ShortcutInfo> matchedList = filterShortcutsByQuery(packageName, shortcuts, (ShortcutQueryWrapper) cookie.first, shortcutsRemoved);
                if (CollectionUtils.isEmpty(matchedList) == true) goto L17;
                if (shortcutsRemoved == true) goto L20;
                callback.onShortcutsAddedOrUpdated(packageName, matchedList, user);     // Catch: RemoteException -> L13
                goto L17
            L20:
                callback.onShortcutsRemoved(packageName, matchedList, user);     // Catch: RemoteException -> L13
            L17:
                i = i + 1;
                goto L3
            L7:
                if (hasUserAccess(callbackUser, user) == true) goto L9;
            L18:
                this.mCallbacks.finishBroadcast();
            }

            public static List<ShortcutInfo> filterShortcutsByQuery(String packageName, List<ShortcutInfo> shortcuts, ShortcutQueryWrapper query, boolean shortcutsRemoved) {
                long changedSince = query.getChangedSince();
                String queryPackage = query.getPackage();
                List<String> shortcutIds = query.getShortcutIds();
                List<LocusId> locusIds = query.getLocusIds();
                ComponentName activity = query.getActivity();
                int flags = query.getQueryFlags();
                if (queryPackage == null) goto L9;
                if (queryPackage.equals(packageName) == true) goto L9;
                return null;
            L9:
                List<ShortcutInfo> matches = new ArrayList();
                int r10 = 1;
                int r11 = 0;
                if ((flags & 1) == 0) goto L12;
                boolean matchDynamic = true;
            L14:
                if ((flags & 2) == 0) goto L16;
                boolean matchPinned = true;
            L18:
                if ((flags & 8) == 0) goto L20;
                boolean matchManifest = true;
            L22:
                if ((flags & 16) == 0) goto L24;
                boolean matchCached = true;
            L25:
                if (matchDynamic == true) goto L28;
                r10 = 0;
            L28:
                if (matchPinned == false) goto L30;
                int r15 = 2;
            L31:
                int r12 = r10 | r15;
                if (matchManifest == false) goto L34;
                int r16 = 32;
            L35:
                int r13 = r12 | r16;
                if (matchCached == false) goto L38;
                r11 = 1610629120;
            L38:
                int shortcutFlags = r13 | r11;
                int i = 0;
            L40:
                if (i >= shortcuts.size()) goto L65;
                long changedSince2 = changedSince;
                ShortcutInfo si = shortcuts.get(i);
                if (activity == null) goto L47;
                if (activity.equals(si.getActivity()) == true) goto L47;
            L63:
                i = i + 1;
                changedSince = changedSince2;
            L47:
                if (changedSince2 != 0) goto L49;
            L51:
                if (shortcutIds != null) goto L53;
            L55:
                if (locusIds != null) goto L57;
            L59:
                if (shortcutsRemoved == false) goto L61;
            L62:
                matches.add(si);
                goto L63
            L61:
                if ((si.getFlags() & shortcutFlags) == 0) goto L63;
            L57:
                if (locusIds.contains(si.getLocusId()) == true) goto L59;
            L53:
                if (shortcutIds.contains(si.getId()) == true) goto L55;
            L49:
                if (changedSince2 <= si.getLastChangedTimestamp()) goto L51;
            L65:
                return matches;
            L34:
                r16 = 0;
                goto L35
            L30:
                r15 = 0;
                goto L31
            L24:
                matchCached = false;
                goto L25
            L20:
                matchManifest = false;
                goto L22
            L16:
                matchPinned = false;
                goto L18
            L12:
                matchDynamic = false;
                goto L14
            }

            private boolean hasUserAccess(UserHandle callbackUser, UserHandle shortcutUser) {
                int callbackUserId = callbackUser.getIdentifier();
                int shortcutUserId = shortcutUser.getIdentifier();
                if (shortcutUser.equals(callbackUser) == false) goto L7;
                return true;
            L7:
                return this.mUserManagerInternal.isProfileAccessible(callbackUserId, shortcutUserId, null, false);
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$2ZezeExhdKA1bJZGD0jh-Yl-pb8, reason: not valid java name */
        public static /* synthetic */ ApplicationInfo m6695$r8$lambda$2ZezeExhdKA1bJZGD0jhYlpb8(LauncherAppsImpl r0, String r1, int r2, UserHandle r3) {
            return r0.lambda$getApplicationInfoForArchivedApp$2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$B64-Ee8xNeMWQNK5NaolG-5U02A, reason: not valid java name */
        public static /* synthetic */ boolean m6696$r8$lambda$B64Ee8xNeMWQNK5NaolG5U02A(LauncherAppsImpl r0, BroadcastCookie r1, int r2) {
            return r0.lambda$registerPackageInstallerCallback$0(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$HzPI4cBaxfeG3YbmmE9HM7Jic8E(LauncherAppsImpl r0, int r1, boolean r2, boolean r3) {
            r0.lambda$setArchiveCompatibilityOptions$5(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$NOerjkMCia-DRZT6-Ftw84L2WG0, reason: not valid java name */
        public static /* synthetic */ boolean m6697$r8$lambda$NOerjkMCiaDRZT6Ftw84L2WG0(LauncherAppsImpl r0, int r1, PackageInstaller.SessionInfo r2) {
            return r0.lambda$getAllSessions$1(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$cZMZiwYR50ZXOE--vIMN1x9s1dU, reason: not valid java name */
        public static /* synthetic */ void m6698$r8$lambda$cZMZiwYR50ZXOEvIMN1x9s1dU(LauncherAppsImpl r0, BiConsumer r1) {
            r0.lambda$forEachViewCaptureWindow$4(r1);
        }

        public static /* synthetic */ void $r8$lambda$kx0EDd9EHlGq1e2ICkr064uuOvo(LauncherAppsImpl r0, UserHandle r1, AndroidPackage r2) {
            r0.lambda$registerLoadingProgressForIncrementalApps$6(r1, r2);
        }

        public static /* synthetic */ boolean $r8$lambda$lEzHBj8aAbRJ5e_Cb2FZRpg2X0Y(ComponentName r0, ResolveInfo r1) {
            return lambda$getShortcutConfigActivityIntent$3(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$lNRUt_M-XrgBrBdVdi8x0Dx4VDQ, reason: not valid java name */
        public static /* synthetic */ void m6699$r8$lambda$lNRUt_MXrgBrBdVdi8x0Dx4VDQ(LauncherAppsImpl r0, String r1, InputStream r2) {
            r0.dumpViewCaptureDataToWmTrace(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbackHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ Handler m6700$$Nest$fgetmCallbackHandler(LauncherAppsImpl r0) {
            return r0.mCallbackHandler;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
        static /* bridge */ /* synthetic */ Context m6701$$Nest$fgetmContext(LauncherAppsImpl r0) {
            return r0.mContext;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
        static /* bridge */ /* synthetic */ PackageCallbackList m6702$$Nest$fgetmListeners(LauncherAppsImpl r0) {
            return r0.mListeners;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ PackageManagerInternal m6703$$Nest$fgetmPackageManagerInternal(LauncherAppsImpl r0) {
            return r0.mPackageManagerInternal;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShortcutServiceInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ ShortcutServiceInternal m6704$$Nest$fgetmShortcutServiceInternal(LauncherAppsImpl r0) {
            return r0.mShortcutServiceInternal;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserManagerInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ UserManagerInternal m6705$$Nest$fgetmUserManagerInternal(LauncherAppsImpl r0) {
            return r0.mUserManagerInternal;
        }

        /* JADX INFO: renamed from: -$$Nest$mforEachViewCaptureWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6706$$Nest$mforEachViewCaptureWindow(LauncherAppsImpl r0, BiConsumer r1) {
            r0.forEachViewCaptureWindow(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetFilteredPackageNames, reason: not valid java name */
        static /* bridge */ /* synthetic */ String[] m6707$$Nest$mgetFilteredPackageNames(LauncherAppsImpl r0, String[] r1, BroadcastCookie r2, UserHandle r3) {
            return r0.getFilteredPackageNames(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$misEnabledProfileOf, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6708$$Nest$misEnabledProfileOf(LauncherAppsImpl r0, BroadcastCookie r1, UserHandle r2, String r3) {
            return r0.isEnabledProfileOf(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$misPackageVisibleToListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6709$$Nest$misPackageVisibleToListener(LauncherAppsImpl r0, String r1, BroadcastCookie r2, UserHandle r3) {
            return r0.isPackageVisibleToListener(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mstartShortcutInner, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6710$$Nest$mstartShortcutInner(LauncherAppsImpl r0, int r1, int r2, int r3, String r4, String r5, String r6, String r7, Rect r8, Bundle r9, int r10) {
            return r0.startShortcutInner(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }

        /* JADX INFO: renamed from: -$$Nest$mtransferViewCaptureData, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6711$$Nest$mtransferViewCaptureData(LauncherAppsImpl r0, InputStream r1, OutputStream r2) {
            r0.transferViewCaptureData(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$smisCallingAppIdAllowed, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6712$$Nest$smisCallingAppIdAllowed(int[] r0, int r1) {
            return isCallingAppIdAllowed(r0, r1);
        }

        public LauncherAppsImpl(Context context) {
            this.mListeners = new PackageCallbackList(this);
            LauncherAppsServiceIA r1 = null;
            this.mPackageRemovedListener = new PackageRemovedListener(this, r1);
            this.mPackageMonitor = new MyPackageMonitor(this, r1);
            this.mIsWatchingPackageBroadcasts = false;
            this.mOnDumpExecutor = Executors.newSingleThreadExecutor();
            this.mDumpCallbacks = new RemoteCallbackList();
            this.mContext = context;
            this.mIPM = AppGlobals.getPackageManager();
            this.mUm = (UserManager) this.mContext.getSystemService("user");
            this.mRoleManager = (RoleManager) this.mContext.getSystemService(RoleManager.class);
            UserManagerInternal r0 = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
            r0.getClass();
            this.mUserManagerInternal = r0;
            UsageStatsManagerInternal r2 = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
            r2.getClass();
            this.mUsageStatsManagerInternal = r2;
            ActivityManagerInternal r3 = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
            r3.getClass();
            this.mActivityManagerInternal = r3;
            ActivityTaskManagerInternal r4 = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
            r4.getClass();
            this.mActivityTaskManagerInternal = r4;
            ShortcutServiceInternal r5 = (ShortcutServiceInternal) LocalServices.getService(ShortcutServiceInternal.class);
            r5.getClass();
            this.mShortcutServiceInternal = r5;
            PackageManagerInternal r6 = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            r6.getClass();
            this.mPackageManagerInternal = r6;
            this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
            this.mShortcutServiceInternal.addListener(this.mPackageMonitor);
            this.mShortcutChangeHandler = new ShortcutChangeHandler(this.mUserManagerInternal);
            this.mShortcutServiceInternal.addShortcutChangeCallback(this.mShortcutChangeHandler);
            this.mCallbackHandler = BackgroundThread.getHandler();
            this.mDpm = (DevicePolicyManager) this.mContext.getSystemService("device_policy");
            this.mInternal = new LocalService(this);
            registerSettingsObserver();
        }

        int injectBinderCallingUid() {
            return ILauncherApps.Stub.getCallingUid();
        }

        int injectBinderCallingPid() {
            return ILauncherApps.Stub.getCallingPid();
        }

        final int injectCallingUserId() {
            return UserHandle.getUserId(injectBinderCallingUid());
        }

        long injectClearCallingIdentity() {
            return Binder.clearCallingIdentity();
        }

        void injectRestoreCallingIdentity(long token) {
            Binder.restoreCallingIdentity(token);
        }

        private int getCallingUserId() {
            return UserHandle.getUserId(injectBinderCallingUid());
        }

        public void addOnAppsChangedListener(String callingPackage, IOnAppsChangedListener listener) throws RemoteException {
            verifyCallingPackage(callingPackage);
            PackageCallbackList<IOnAppsChangedListener> r0 = this.mListeners;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mListeners.getRegisteredCallbackCount() != 0) goto L9;
            startWatchingPackageBroadcasts();     // Catch: Throwable -> L7
        L9:
            this.mListeners.unregister(listener);     // Catch: Throwable -> L7
            this.mListeners.register(listener, new BroadcastCookie(UserHandle.of(getCallingUserId()), callingPackage, injectBinderCallingPid(), injectBinderCallingUid()));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void removeOnAppsChangedListener(IOnAppsChangedListener listener) throws RemoteException {
            PackageCallbackList<IOnAppsChangedListener> r0 = this.mListeners;
            monitor-enter(r0);
            this.mListeners.unregister(listener);     // Catch: Throwable -> L7
            if (this.mListeners.getRegisteredCallbackCount() != 0) goto L9;
            stopWatchingPackageBroadcasts();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void registerPackageInstallerCallback(String callingPackage, IPackageInstallerCallback callback) {
            verifyCallingPackage(callingPackage);
            final BroadcastCookie callerInfo = new BroadcastCookie(new UserHandle(getCallingUserId()), callingPackage, ILauncherApps.Stub.getCallingPid(), ILauncherApps.Stub.getCallingUid());
            getPackageInstallerService().registerCallback(callback, new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda4(this, callerInfo));
        }

        private /* synthetic */ boolean lambda$registerPackageInstallerCallback$0(BroadcastCookie callerInfo, int eventUserId) {
            return isEnabledProfileOf(callerInfo, new UserHandle(eventUserId), "shouldReceiveEvent");
        }

        public List<UserHandle> getUserProfiles() {
            if (canAccessHiddenProfile(ILauncherApps.Stub.getCallingUid(), ILauncherApps.Stub.getCallingPid()) == true) goto L5;
            int[] userIds = this.mUserManagerInternal.getProfileIdsExcludingHidden(getCallingUserId(), true);
        L6:
            List<UserHandle> result = new ArrayList(userIds.length);
            int r2 = userIds.length;
            int r3 = 0;
        L7:
            if (r3 >= r2) goto L9;
            int userId = userIds[r3];
            result.add(UserHandle.of(userId));
            r3 = r3 + 1;
            goto L7
        L9:
            return result;
        L5:
            userIds = this.mUserManagerInternal.getProfileIds(getCallingUserId(), true);
            goto L6
        }

        public ParceledListSlice<PackageInstaller.SessionInfo> getAllSessions(String callingPackage) {
            verifyCallingPackage(callingPackage);
            List<PackageInstaller.SessionInfo> sessionInfos = new ArrayList();
            final int callingUid = Binder.getCallingUid();
            if (canAccessHiddenProfile(callingUid, Binder.getCallingPid()) == true) goto L5;
            int[] userIds = this.mUserManagerInternal.getProfileIdsExcludingHidden(getCallingUserId(), true);
        L6:
            long token = Binder.clearCallingIdentity();
            int r5 = userIds.length;     // Catch: Throwable -> L11
            int r6 = 0;
        L8:
            if (r6 >= r5) goto L13;
            int userId = userIds[r6];     // Catch: Throwable -> L11
            sessionInfos.addAll(getPackageInstallerService().getAllSessions(userId).getList());     // Catch: Throwable -> L11
            r6 = r6 + 1;
            goto L8
        L13:
            Binder.restoreCallingIdentity(token);
            sessionInfos.removeIf(new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda6(this, callingUid));
            return new ParceledListSlice(sessionInfos);
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            userIds = this.mUserManagerInternal.getProfileIds(getCallingUserId(), true);
            goto L6
        }

        private /* synthetic */ boolean lambda$getAllSessions$1(int callingUid, PackageInstaller.SessionInfo info) {
            return shouldFilterSession(callingUid, info);
        }

        private boolean shouldFilterSession(int uid, PackageInstaller.SessionInfo session) {
            if (session != null) goto L6;
            return false;
        L6:
            if (uid != session.getInstallerUid()) goto L8;
            return false;
        L8:
            if (this.mPackageManagerInternal.canQueryPackage(uid, session.getAppPackageName()) == true) goto L13;
            return true;
        L13:
            return false;
        }

        private PackageInstallerService getPackageInstallerService() {
            if (this.mPackageInstallerService != null) goto L9;
            this.mPackageInstallerService = ServiceManager.getService(Settings.ATTR_PACKAGE).getPackageInstaller();     // Catch: RemoteException -> L6
        L6:
            e = move-exception;
            Slog.wtf(TAG, "Error getting IPackageInstaller", e);
        L9:
            return this.mPackageInstallerService;
        }

        private void startWatchingPackageBroadcasts() {
            if (this.mIsWatchingPackageBroadcasts == true) goto L10;
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.PACKAGE_REMOVED_INTERNAL");
            filter.addDataScheme(Settings.ATTR_PACKAGE);
            this.mContext.registerReceiverAsUser(this.mPackageRemovedListener, UserHandle.ALL, filter, null, this.mCallbackHandler);
            long identity = Binder.clearCallingIdentity();
            this.mPackageMonitor.register(this.mContext, UserHandle.ALL, this.mCallbackHandler);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            this.mIsWatchingPackageBroadcasts = true;
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private void stopWatchingPackageBroadcasts() {
            if (this.mIsWatchingPackageBroadcasts == false) goto L6;
            this.mContext.unregisterReceiver(this.mPackageRemovedListener);
            this.mPackageMonitor.unregister();
            this.mIsWatchingPackageBroadcasts = false;
            return;
        }

        void checkCallbackCount() {
            PackageCallbackList<IOnAppsChangedListener> r0 = this.mListeners;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mListeners.getRegisteredCallbackCount() != 0) goto L9;
            stopWatchingPackageBroadcasts();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private boolean canAccessProfile(int targetUserId, String message) {
            return canAccessProfile(injectBinderCallingUid(), injectCallingUserId(), injectBinderCallingPid(), targetUserId, message);
        }

        private boolean canAccessProfile(int callingUid, int callingUserId, int callingPid, int targetUserId, String message) {
            if (targetUserId != callingUserId) goto L6;
            return true;
        L6:
            if (injectHasInteractAcrossUsersFullPermission(callingPid, callingUid) == false) goto L8;
            return true;
        L8:
            UserInfo callingUserInfo = this.mUserManagerInternal.getUserInfo(callingUserId);
            if (callingUserInfo == null) goto L15;
            if (callingUserInfo.isProfile() == false) goto L15;
            Slog.w(TAG, message + " for another profile " + targetUserId + " from " + callingUserId + " not allowed");
            return false;
        L15:
            if (isHiddenProfile(UserHandle.of(targetUserId)) == false) goto L20;
            if (canAccessHiddenProfile(callingUid, callingPid) == true) goto L20;
            return false;
        L20:
            return this.mUserManagerInternal.isProfileAccessible(callingUserId, targetUserId, message, true);
        }

        private boolean isHiddenProfile(UserHandle targetUser) {
            UserProperties properties = this.mUserManagerInternal.getUserProperties(targetUser.getIdentifier());     // Catch: IllegalArgumentException -> L11
            if (properties != null) goto L6;
            return false;
        L6:
            if (properties.getProfileApiVisibility() == 1) goto L10;
            return false;
        L10:
            return true;
        L12:
            return false;
        }

        private void verifyCallingPackage(String callingPackage) {
            verifyCallingPackage(callingPackage, injectBinderCallingUid());
        }

        private boolean canAccessHiddenProfile(int callingUid, int callingPid) {
            boolean r1 = true;
            if (areHiddenApisChecksEnabled() == true) goto L5;
            return true;
        L5:
            long ident = injectClearCallingIdentity();
            AndroidPackage callingPackage = this.mPackageManagerInternal.getPackage(callingUid);     // Catch: Throwable -> L29
            if (callingPackage != null) goto L12;
            injectRestoreCallingIdentity(ident);
            return false;
        L12:
            if (this.mContext.checkPermission("android.permission.ACCESS_HIDDEN_PROFILES_FULL", callingPid, callingUid) != 0) goto L16;
            injectRestoreCallingIdentity(ident);
            return true;
        L16:
            if (isAccessToHiddenProfilesForNonSystemAppsForbidden() == false) goto L20;
            injectRestoreCallingIdentity(ident);
            return false;
        L20:
            if (this.mRoleManager.getRoleHoldersAsUser("android.app.role.HOME", UserHandle.getUserHandleForUid(callingUid)).contains(callingPackage.getPackageName()) == true) goto L23;
            injectRestoreCallingIdentity(ident);
            return false;
        L23:
            if (this.mContext.checkPermission("android.permission.ACCESS_HIDDEN_PROFILES", callingPid, callingUid) == 0) goto L27;
            r1 = false;
        L27:
            injectRestoreCallingIdentity(ident);
            return r1;
        L29:
            th = move-exception;
            injectRestoreCallingIdentity(ident);
            throw th;
        }

        private boolean isAccessToHiddenProfilesForNonSystemAppsForbidden() {
            return !DeviceConfig.getBoolean(NAMESPACE_MULTIUSER, FLAG_NON_SYSTEM_ACCESS_TO_HIDDEN_PROFILES, true);
        }

        private boolean areHiddenApisChecksEnabled() {
            return true;
        }

        void verifyCallingPackage(String callingPackage, int callerUid) {
            int packageUid = -1;
            packageUid = this.mIPM.getPackageUid(callingPackage, 794624, UserHandle.getUserId(callerUid));     // Catch: RemoteException -> L5
        L6:
            if (packageUid >= 0) goto L8;
            Log.e(TAG, "Package not found: " + callingPackage);
        L8:
            if (packageUid != callerUid) goto L11;
            return;
        L11:
            throw new SecurityException("Calling package name mismatch");
        }

        private LauncherActivityInfoInternal getHiddenAppActivityInfo(String packageName, int callingUid, UserHandle user) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(packageName, PackageManager.APP_DETAILS_ACTIVITY_CLASS_NAME));
            List<LauncherActivityInfoInternal> apps = queryIntentLauncherActivities(intent, callingUid, user);
            if (apps.size() > 0) goto L5;
            return null;
        L5:
            return apps.get(0);
        }

        public boolean shouldHideFromSuggestions(String packageName, UserHandle user) {
            int userId = user.getIdentifier();
            if (canAccessProfile(userId, "cannot get shouldHideFromSuggestions") == true) goto L6;
            return false;
        L6:
            if (PackageArchiver.isArchivingEnabled() == false) goto L12;
            if (packageName == null) goto L12;
            if (isPackageArchived(packageName, user) == false) goto L12;
            return true;
        L12:
            if (this.mPackageManagerInternal.filterAppAccess(packageName, Binder.getCallingUid(), userId) == false) goto L14;
            return false;
        L14:
            int flags = this.mPackageManagerInternal.getDistractingPackageRestrictions(packageName, userId);
            if ((flags & 1) != 0) goto L17;
            return false;
        L17:
            return true;
        }

        public ParceledListSlice<LauncherActivityInfoInternal> getLauncherActivities(String callingPackage, String packageName, UserHandle user) throws RemoteException {
            ParceledListSlice<LauncherActivityInfoInternal> launcherActivities = queryActivitiesForUser(callingPackage, new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(packageName), user);
            if (PackageArchiver.isArchivingEnabled() == false) goto L5;
            ParceledListSlice<LauncherActivityInfoInternal> launcherActivities2 = getActivitiesForArchivedApp(packageName, user, launcherActivities);
        L7:
            if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "show_hidden_icon_apps_enabled", 1) != 0) goto L9;
            return launcherActivities2;
        L9:
            if (launcherActivities2 != null) goto L12;
            return null;
        L12:
            int callingUid = injectBinderCallingUid();
            long ident = injectClearCallingIdentity();
        L39:
            th = move-exception;
            Throwable r14 = th;
        L61:
            injectRestoreCallingIdentity(ident);
            throw r14;
        L14:
            if (this.mUserManagerInternal.getUserInfo(user.getIdentifier()).isManagedProfile() == false) goto L18;
            injectRestoreCallingIdentity(ident);
            return launcherActivities2;
        L18:
            if (this.mDpm.getDeviceOwnerComponentOnAnyUser() == null) goto L21;
            injectRestoreCallingIdentity(ident);
            return launcherActivities2;
        L21:
            ArrayList<LauncherActivityInfoInternal> result = new ArrayList(launcherActivities2.getList());     // Catch: Throwable -> L39
            if (packageName == null) goto L42;
            if (result.size() <= 0) goto L27;
            injectRestoreCallingIdentity(ident);
            return launcherActivities2;
        L27:
            ApplicationInfo appInfo = this.mPackageManagerInternal.getApplicationInfo(packageName, 0, callingUid, user.getIdentifier());     // Catch: Throwable -> L34
            if (shouldShowSyntheticActivity(user, appInfo) == false) goto L36;
            LauncherActivityInfoInternal info = getHiddenAppActivityInfo(packageName, callingUid, user);     // Catch: Throwable -> L34
            if (info == null) goto L36;
            result.add(info);     // Catch: Throwable -> L34
        L36:
            ParceledListSlice<LauncherActivityInfoInternal> r2 = new ParceledListSlice(result);     // Catch: Throwable -> L34
            injectRestoreCallingIdentity(ident);
            return r2;
        L42:
            HashSet<String> visiblePackages = new HashSet();     // Catch: Throwable -> L34
            Iterator<LauncherActivityInfoInternal> r3 = result.iterator();     // Catch: Throwable -> L34
        L44:
            if (r3.hasNext() == false) goto L46;
            visiblePackages.add(r3.next().getActivityInfo().packageName);     // Catch: Throwable -> L34
            goto L44
        L46:
            List<ApplicationInfo> installedPackages = this.mPackageManagerInternal.getInstalledApplications(0, user.getIdentifier(), callingUid);     // Catch: Throwable -> L34
            Iterator<ApplicationInfo> r4 = installedPackages.iterator();     // Catch: Throwable -> L34
        L48:
            if (r4.hasNext() == false) goto L58;
            ApplicationInfo applicationInfo = r4.next();     // Catch: Throwable -> L34
            if (visiblePackages.contains(applicationInfo.packageName) == true) goto L48;
            if (shouldShowSyntheticActivity(user, applicationInfo) == false) goto L48;
            LauncherActivityInfoInternal info2 = getHiddenAppActivityInfo(applicationInfo.packageName, callingUid, user);     // Catch: Throwable -> L34
            if (info2 == null) goto L48;
            result.add(info2);     // Catch: Throwable -> L34
            goto L48
        L58:
            ParceledListSlice<LauncherActivityInfoInternal> r5 = new ParceledListSlice(result);     // Catch: Throwable -> L34
            injectRestoreCallingIdentity(ident);
            return r5;
        L34:
            th = move-exception;
            r14 = th;
            goto L61
        L5:
            launcherActivities2 = launcherActivities;
            goto L7
        }

        private ParceledListSlice<LauncherActivityInfoInternal> getActivitiesForArchivedApp(String packageName, UserHandle user, ParceledListSlice<LauncherActivityInfoInternal> launcherActivities) {
            List<LauncherActivityInfoInternal> archivedActivities = generateLauncherActivitiesForArchivedApp(packageName, user);
            if (archivedActivities.isEmpty() == false) goto L5;
            return launcherActivities;
        L5:
            if (launcherActivities == null) goto L7;
            List<LauncherActivityInfoInternal> result = launcherActivities.getList();
            result.addAll(archivedActivities);
            return new ParceledListSlice(result);
        L7:
            return new ParceledListSlice(archivedActivities);
        }

        private boolean shouldShowSyntheticActivity(UserHandle user, ApplicationInfo appInfo) {
            if (appInfo != null) goto L5;
        L21:
            return false;
        L5:
            if (appInfo.isSystemApp() == true) goto L21;
            if (appInfo.isUpdatedSystemApp() == true) goto L21;
            if (isManagedProfileAdmin(user, appInfo.packageName) == false) goto L12;
            return false;
        L12:
            AndroidPackage pkg = this.mPackageManagerInternal.getPackage(appInfo.packageName);
            if (pkg != null) goto L16;
            return false;
        L16:
            if (requestsPermissions(pkg) == true) goto L18;
            return false;
        L18:
            if (hasDefaultEnableLauncherActivity(appInfo.packageName) == false) goto L23;
            return true;
        L23:
            return false;
        }

        private boolean requestsPermissions(AndroidPackage pkg) {
            return !ArrayUtils.isEmpty(pkg.getRequestedPermissions());
        }

        private boolean hasDefaultEnableLauncherActivity(String packageName) {
            Intent matchIntent = new Intent("android.intent.action.MAIN");
            matchIntent.addCategory("android.intent.category.LAUNCHER");
            matchIntent.setPackage(packageName);
            List<ResolveInfo> infoList = this.mPackageManagerInternal.queryIntentActivities(matchIntent, matchIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 512, Binder.getCallingUid(), getCallingUserId());
            int size = infoList.size();
            int i = 0;
        L3:
            if (i >= size) goto L9;
            if (infoList.get(i).activityInfo.enabled == true) goto L6;
            i = i + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        private boolean isManagedProfileAdmin(UserHandle user, String packageName) {
            List<UserInfo> userInfoList = this.mUm.getProfiles(user.getIdentifier());
            int i = 0;
        L4:
            if (i >= userInfoList.size()) goto L16;
            UserInfo userInfo = userInfoList.get(i);
            if (userInfo.isManagedProfile() == false) goto L15;
            ComponentName componentName = this.mDpm.getProfileOwnerAsUser(userInfo.getUserHandle());
            if (componentName == null) goto L15;
            if (componentName.getPackageName().equals(packageName) == false) goto L15;
            return true;
        L15:
            i = i + 1;
            goto L4
        L16:
            return false;
        }

        public LauncherActivityInfoInternal resolveLauncherActivityInternal(String callingPackage, ComponentName component, UserHandle user) throws RemoteException {
            if (canAccessProfile(user.getIdentifier(), "Cannot resolve activity") == true) goto L5;
            return null;
        L5:
            if (component == null) goto L35;
            if (component.getPackageName() == null) goto L35;
            int callingUid = injectBinderCallingUid();
            long ident = Binder.clearCallingIdentity();
            ActivityInfo activityInfo = this.mPackageManagerInternal.getActivityInfo(component, 786432, callingUid, user.getIdentifier());     // Catch: Throwable -> L19
            if (activityInfo == null) goto L15;
            IncrementalStatesInfo incrementalStatesInfo = this.mPackageManagerInternal.getIncrementalStatesInfo(component.getPackageName(), callingUid, user.getIdentifier());     // Catch: Throwable -> L19
            if (incrementalStatesInfo != null) goto L27;
            Binder.restoreCallingIdentity(ident);
            return null;
        L27:
            LauncherActivityInfoInternal r1 = new LauncherActivityInfoInternal(activityInfo, incrementalStatesInfo, user, supportsMultiInstance(this.mIPM, activityInfo.getComponentName(), user.getIdentifier()));     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(ident);
            return r1;
        L15:
            if (PackageArchiver.isArchivingEnabled() == false) goto L21;
            LauncherActivityInfoInternal r0 = getMatchingArchivedAppActivityInfo(component, user);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(ident);
            return r0;
        L21:
            Binder.restoreCallingIdentity(ident);
            return null;
        L19:
            th = move-exception;
            Throwable r12 = th;
        L32:
            Binder.restoreCallingIdentity(ident);
            throw r12;
        L30:
            th = move-exception;
            r12 = th;
        L35:
            return null;
        }

        private LauncherActivityInfoInternal getMatchingArchivedAppActivityInfo(ComponentName component, UserHandle user) {
            List<LauncherActivityInfoInternal> archivedActivities = generateLauncherActivitiesForArchivedApp(component.getPackageName(), user);
            if (archivedActivities.isEmpty() == false) goto L5;
            return null;
        L5:
            int i = 0;
        L7:
            if (i >= archivedActivities.size()) goto L13;
            if (archivedActivities.get(i).getComponentName().equals(component) == true) goto L11;
            i = i + 1;
            goto L7
        L11:
            return archivedActivities.get(i);
        L13:
            Slog.w(TAG, TextUtils.formatSimple("Expected archived app component name: %s is not available!", new Object[]{component}));
            return null;
        }

        public ParceledListSlice getShortcutConfigActivities(String callingPackage, String packageName, UserHandle user) throws RemoteException {
            if (this.mShortcutServiceInternal.areShortcutsSupportedOnHomeScreen(user.getIdentifier()) == true) goto L7;
            return null;
        L7:
            return queryActivitiesForUser(callingPackage, new Intent("android.intent.action.CREATE_SHORTCUT").setPackage(packageName), user);
        }

        private ParceledListSlice<LauncherActivityInfoInternal> queryActivitiesForUser(String callingPackage, Intent intent, UserHandle user) {
            if (canAccessProfile(user.getIdentifier(), "Cannot retrieve activities") == true) goto L6;
            return null;
        L6:
            int callingUid = injectBinderCallingUid();
            long ident = injectClearCallingIdentity();
            ParceledListSlice<LauncherActivityInfoInternal> r3 = new ParceledListSlice(queryIntentLauncherActivities(intent, callingUid, user));     // Catch: Throwable -> L10
            injectRestoreCallingIdentity(ident);
            return r3;
        L10:
            th = move-exception;
            injectRestoreCallingIdentity(ident);
            throw th;
        }

        private boolean isPackageArchived(String packageName, UserHandle user) {
            return !getApplicationInfoForArchivedApp(packageName, user).isEmpty();
        }

        private List<LauncherActivityInfoInternal> generateLauncherActivitiesForArchivedApp(String packageName, UserHandle user) {
            if (canAccessProfile(user.getIdentifier(), "Cannot retrieve activities") == false) goto L5;
            if (packageName != null) goto L8;
            List<ApplicationInfo> applicationInfoList = getApplicationInfoListForAllArchivedApps(user);
        L9:
            List<LauncherActivityInfoInternal> launcherActivityList = new ArrayList();
            int i = 0;
        L11:
            if (i >= applicationInfoList.size()) goto L24;
            ApplicationInfo applicationInfo = applicationInfoList.get(i);
            PackageStateInternal packageState = this.mPackageManagerInternal.getPackageStateInternal(applicationInfo.packageName);
            if (packageState == null) goto L22;
            ArchiveState archiveState = packageState.getUserStateOrDefault(user.getIdentifier()).getArchiveState();
            if (archiveState != null) goto L18;
            Slog.w(TAG, TextUtils.formatSimple("Expected package: %s to be archived but missing ArchiveState in PackageState.", new Object[]{applicationInfo.packageName}));
            goto L22
        L18:
            List<ArchiveState.ArchiveActivityInfo> archiveActivityInfoList = archiveState.getActivityInfos();
            int j = 0;
        L20:
            if (j >= archiveActivityInfoList.size()) goto L22;
            launcherActivityList.add(constructLauncherActivityInfoForArchivedApp(this.mIPM, user, applicationInfo, archiveActivityInfoList.get(j)));
            j = j + 1;
        L22:
            i = i + 1;
            goto L11
        L24:
            return launcherActivityList;
        L8:
            applicationInfoList = getApplicationInfoForArchivedApp(packageName, user);
            goto L9
        L5:
            return List.of();
        }

        private static LauncherActivityInfoInternal constructLauncherActivityInfoForArchivedApp(IPackageManager pm, UserHandle user, ApplicationInfo applicationInfo, ArchiveState.ArchiveActivityInfo archiveActivityInfo) {
            ActivityInfo activityInfo = new ActivityInfo();
            activityInfo.isArchived = applicationInfo.isArchived;
            activityInfo.applicationInfo = applicationInfo;
            activityInfo.packageName = archiveActivityInfo.getOriginalComponentName().getPackageName();
            activityInfo.name = archiveActivityInfo.getOriginalComponentName().getClassName();
            activityInfo.nonLocalizedLabel = archiveActivityInfo.getTitle();
            return new LauncherActivityInfoInternal(activityInfo, new IncrementalStatesInfo(false, 0.0f, 0), user, supportsMultiInstance(pm, activityInfo.getComponentName(), user.getIdentifier()));
        }

        private List<ApplicationInfo> getApplicationInfoListForAllArchivedApps(UserHandle user) {
            int callingUid = injectBinderCallingUid();
            List<ApplicationInfo> installedApplicationInfoList = this.mPackageManagerInternal.getInstalledApplicationsCrossUser(4294967296L, user.getIdentifier(), callingUid);
            List<ApplicationInfo> archivedApplicationInfos = new ArrayList();
            int i = 0;
        L4:
            if (i >= installedApplicationInfoList.size()) goto L12;
            ApplicationInfo installedApplicationInfo = installedApplicationInfoList.get(i);
            if (installedApplicationInfo == null) goto L10;
            if (installedApplicationInfo.isArchived == false) goto L10;
            archivedApplicationInfos.add(installedApplicationInfo);
        L10:
            i = i + 1;
            goto L4
        L12:
            return archivedApplicationInfos;
        }

        private List<ApplicationInfo> getApplicationInfoForArchivedApp(final String packageName, final UserHandle user) {
            final int callingUid = injectBinderCallingUid();
            ApplicationInfo applicationInfo = (ApplicationInfo) Binder.withCleanCallingIdentity(new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda3(this, packageName, callingUid, user));
            if (applicationInfo == null) goto L10;
            if (applicationInfo.isArchived == false) goto L10;
            return List.of(applicationInfo);
        L10:
            return Collections.EMPTY_LIST;
        }

        private /* synthetic */ ApplicationInfo lambda$getApplicationInfoForArchivedApp$2(String packageName, int callingUid, UserHandle user) throws Exception {
            return this.mPackageManagerInternal.getApplicationInfo(packageName, 4294967296L, callingUid, user.getIdentifier());
        }

        private List<LauncherActivityInfoInternal> queryIntentLauncherActivities(Intent intent, int callingUid, UserHandle user) {
            List<ResolveInfo> apps = this.mPackageManagerInternal.queryIntentActivities(intent, intent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 786432, callingUid, user.getIdentifier());
            int numResolveInfos = apps.size();
            List<LauncherActivityInfoInternal> results = new ArrayList();
            int i = 0;
        L3:
            if (i >= numResolveInfos) goto L12;
            ResolveInfo ri = apps.get(i);
            String packageName = ri.activityInfo.packageName;
            if (packageName == null) goto L11;
            IncrementalStatesInfo incrementalStatesInfo = this.mPackageManagerInternal.getIncrementalStatesInfo(packageName, callingUid, user.getIdentifier());
            if (incrementalStatesInfo == null) goto L11;
            results.add(new LauncherActivityInfoInternal(ri.activityInfo, incrementalStatesInfo, user, supportsMultiInstance(this.mIPM, ri.activityInfo.getComponentName(), user.getIdentifier())));
        L11:
            i = i + 1;
            goto L3
        L12:
            boolean foundSimpleApp = false;
            int i2 = 0;
        L13:
            if (i2 >= numResolveInfos) goto L19;
            if ("com.android.cts.launcherapps.simpleapp".equals(apps.get(i2).activityInfo.packageName) == false) goto L17;
            foundSimpleApp = true;
        L17:
            i2 = i2 + 1;
            goto L13
        L19:
            if (foundSimpleApp == true) goto L42;
            if (intent.getPackage() != null) goto L23;
        L26:
            Intent simpleAppIntent = new Intent("android.intent.action.MAIN");
            simpleAppIntent.addCategory("android.intent.category.LAUNCHER");
            simpleAppIntent.setPackage("com.android.cts.launcherapps.simpleapp");
            List<ResolveInfo> fakeApps = this.mPackageManagerInternal.queryIntentActivities(simpleAppIntent, simpleAppIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 795136, 1000, user.getIdentifier());
            if (fakeApps == null) goto L42;
            if (fakeApps.isEmpty() == true) goto L42;
            Slog.d(TAG, "queryIntentLauncherActivities: applying PERFECT CTS patch for simpleapp. user=" + user.getIdentifier());
            Iterator<ResolveInfo> r8 = fakeApps.iterator();
        L32:
            if (r8.hasNext() == false) goto L42;
            ResolveInfo ri2 = r8.next();
            if (ri2.activityInfo == null) goto L38;
            if ("com.android.cts.launcherapps.simpleapp.SimpleActivity".equals(ri2.activityInfo.name) == false) goto L38;
            LauncherActivityInfoInternal info = new LauncherActivityInfoInternal(ri2.activityInfo, new IncrementalStatesInfo(false, 1.0f, 0), user, false);
            results.add(info);
        L38:
            apps = apps;
            numResolveInfos = numResolveInfos;
            goto L32
        L23:
            if ("com.android.cts.launcherapps.simpleapp".equals(intent.getPackage()) == true) goto L26;
        L42:
            return results;
        }

        public IntentSender getShortcutConfigActivityIntent(String callingPackage, final ComponentName component, UserHandle user) throws RemoteException {
            ensureShortcutPermission(callingPackage);
            IntentSender r4 = null;
            if (canAccessProfile(user.getIdentifier(), "Cannot check package") == true) goto L5;
            return null;
        L5:
            component.getClass();
            int callingUid = injectBinderCallingUid();
            long identity = Binder.clearCallingIdentity();
            Intent packageIntent = new Intent("android.intent.action.CREATE_SHORTCUT").setPackage(component.getPackageName());     // Catch: Throwable -> L17
            List<ResolveInfo> apps = this.mPackageManagerInternal.queryIntentActivities(packageIntent, packageIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 786432, callingUid, user.getIdentifier());     // Catch: Throwable -> L17
            if (apps.stream().anyMatch(new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda7(component)) == true) goto L10;
            Binder.restoreCallingIdentity(identity);
            return null;
        L10:
            Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT").setComponent(component);     // Catch: Throwable -> L17
            PendingIntent pi = PendingIntent.getActivityAsUser(this.mContext, 0, intent, 1409286144, null, user);     // Catch: Throwable -> L17
            if (pi == null) goto L15;
            r4 = pi.getIntentSender();     // Catch: Throwable -> L17
        L15:
            Binder.restoreCallingIdentity(identity);
            return r4;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private static /* synthetic */ boolean lambda$getShortcutConfigActivityIntent$3(ComponentName component, ResolveInfo ri) {
            return component.getClassName().equals(ri.activityInfo.name);
        }

        public PendingIntent getShortcutIntent(String callingPackage, String packageName, String shortcutId, Bundle opts, UserHandle user) throws RemoteException {
            callingPackage.getClass();
            packageName.getClass();
            shortcutId.getClass();
            user.getClass();
            ensureShortcutPermission(callingPackage);
            if (canAccessProfile(user.getIdentifier(), "Cannot get shortcuts") == true) goto L5;
            return null;
        L5:
            Intent[] intents = this.mShortcutServiceInternal.createShortcutIntents(getCallingUserId(), callingPackage, packageName, shortcutId, user.getIdentifier(), injectBinderCallingPid(), injectBinderCallingUid());
            if (intents != null) goto L8;
        L17:
            return null;
        L8:
            if (intents.length == 0) goto L17;
            long ident = Binder.clearCallingIdentity();
            PendingIntent r0 = injectCreatePendingIntent(0, intents, AudioFormat.DTS_HD, opts, packageName, this.mPackageManagerInternal.getPackageUid(packageName, 268435456, user.getIdentifier()));     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(ident);
            return r0;
        L14:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isPackageEnabled(String callingPackage, String packageName, UserHandle user) throws RemoteException {
            boolean r1 = false;
            if (canAccessProfile(user.getIdentifier(), "Cannot check package") == true) goto L5;
            return false;
        L5:
            int callingUid = injectBinderCallingUid();
            long ident = Binder.clearCallingIdentity();
        L24:
            th = move-exception;
            Throwable r12 = th;
        L26:
            Binder.restoreCallingIdentity(ident);
            throw r12;
        L7:
            if (PackageArchiver.isArchivingEnabled() == false) goto L9;
            long callingFlag = 786432 | 4294967296L;     // Catch: Throwable -> L24
            long callingFlag2 = callingFlag;
        L10:
            PackageInfo info = this.mPackageManagerInternal.getPackageInfo(packageName, callingFlag2, callingUid, user.getIdentifier());     // Catch: Throwable -> L19
            if (info != null) goto L15;
        L22:
            Binder.restoreCallingIdentity(ident);
            return r1;
        L15:
            if (info.applicationInfo.enabled == true) goto L21;
            if (info.applicationInfo.isArchived == false) goto L22;
        L21:
            r1 = true;
        L19:
            th = move-exception;
            r12 = th;
            goto L26
        L9:
            callingFlag2 = 786432;
            goto L10
        }

        public Bundle getSuspendedPackageLauncherExtras(String packageName, UserHandle user) {
            int callingUid = injectBinderCallingUid();
            int userId = user.getIdentifier();
            if (canAccessProfile(userId, "Cannot get launcher extras") == true) goto L6;
            return null;
        L6:
            if (this.mPackageManagerInternal.filterAppAccess(packageName, callingUid, userId) == false) goto L9;
            return null;
        L9:
            return this.mPackageManagerInternal.getSuspendedPackageLauncherExtras(packageName, userId);
        }

        public ApplicationInfo getApplicationInfo(String callingPackage, String packageName, int flags, UserHandle user) throws RemoteException {
            if (canAccessProfile(user.getIdentifier(), "Cannot check package") == true) goto L6;
            return null;
        L6:
            int callingUid = injectBinderCallingUid();
            long ident = Binder.clearCallingIdentity();
            ApplicationInfo info = this.mPackageManagerInternal.getApplicationInfo(packageName, flags, callingUid, user.getIdentifier());     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(ident);
            return info;
        L12:
            th = move-exception;
            Throwable r11 = th;
        L16:
            Binder.restoreCallingIdentity(ident);
            throw r11;
        L14:
            th = move-exception;
            r11 = th;
            goto L16
        }

        public LauncherApps.AppUsageLimit getAppUsageLimit(String callingPackage, String packageName, UserHandle user) {
            verifyCallingPackage(callingPackage);
            if (canAccessProfile(user.getIdentifier(), "Cannot access usage limit") == true) goto L6;
            return null;
        L6:
            if (this.mActivityTaskManagerInternal.isCallerRecents(Binder.getCallingUid()) == false) goto L13;
            UsageStatsManagerInternal.AppUsageLimitData data = this.mUsageStatsManagerInternal.getAppUsageLimit(packageName, user);
            if (data != null) goto L11;
            return null;
        L11:
            return new LauncherApps.AppUsageLimit(data.getTotalUsageLimit(), data.getUsageRemaining());
        L13:
            throw new SecurityException("Caller is not the recents app");
        }

        private void ensureShortcutPermission(String callingPackage) {
            ensureShortcutPermission(injectBinderCallingUid(), injectBinderCallingPid(), callingPackage);
        }

        private void ensureShortcutPermission(int callerUid, int callerPid, String callingPackage) {
            verifyCallingPackage(callingPackage, callerUid);
            if (this.mShortcutServiceInternal.hasShortcutHostPermission(UserHandle.getUserId(callerUid), callingPackage, callerPid, callerUid) == false) goto L6;
            return;
        L6:
            throw new SecurityException("Caller can't access shortcut information");
        }

        private void ensureStrictAccessShortcutsPermission(String callingPackage) {
            verifyCallingPackage(callingPackage);
            if (injectHasAccessShortcutsPermission(injectBinderCallingPid(), injectBinderCallingUid()) == false) goto L6;
            return;
        L6:
            throw new SecurityException("Caller can't access shortcut information");
        }

        boolean injectHasAccessShortcutsPermission(int callingPid, int callingUid) {
            if (this.mContext.checkPermission("android.permission.ACCESS_SHORTCUTS", callingPid, callingUid) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean injectHasInteractAcrossUsersFullPermission(int callingPid, int callingUid) {
            if (this.mContext.checkPermission("android.permission.INTERACT_ACROSS_USERS_FULL", callingPid, callingUid) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        PendingIntent injectCreatePendingIntent(int requestCode, Intent[] intents, int flags, Bundle options, String ownerPackage, int ownerUserId) {
            return this.mActivityManagerInternal.getPendingIntentActivityAsApp(requestCode, intents, flags, null, ownerPackage, ownerUserId);
        }

        public ParceledListSlice getShortcuts(String callingPackage, ShortcutQueryWrapper query, UserHandle targetUser) {
            ensureShortcutPermission(callingPackage);
            if (canAccessProfile(targetUser.getIdentifier(), "Cannot get shortcuts") == true) goto L6;
            Log.e(TAG, "return empty shortcuts because callingPackage " + callingPackage + " cannot access user " + targetUser.getIdentifier());
            return new ParceledListSlice(Collections.EMPTY_LIST);
        L6:
            long changedSince = query.getChangedSince();
            String packageName = query.getPackage();
            List<String> shortcutIds = query.getShortcutIds();
            List<LocusId> locusIds = query.getLocusIds();
            ComponentName componentName = query.getActivity();
            int flags = query.getQueryFlags();
            if (shortcutIds == null) goto L12;
            if (packageName != null) goto L12;
            throw new IllegalArgumentException("To query by shortcut ID, package name must also be set");
        L12:
            if (locusIds == null) goto L18;
            if (packageName != null) goto L18;
            throw new IllegalArgumentException("To query by locus ID, package name must also be set");
        L18:
            if ((query.getQueryFlags() & 2048) == 0) goto L21;
            ensureStrictAccessShortcutsPermission(callingPackage);
        L21:
            return new ParceledListSlice(this.mShortcutServiceInternal.getShortcuts(getCallingUserId(), callingPackage, changedSince, packageName, shortcutIds, locusIds, componentName, flags, targetUser.getIdentifier(), injectBinderCallingPid(), injectBinderCallingUid()));
        }

        public void registerShortcutChangeCallback(String callingPackage, ShortcutQueryWrapper query, IShortcutChangeCallback callback) {
            ensureShortcutPermission(callingPackage);
            if (query.getShortcutIds() == null) goto L10;
            if (query.getPackage() != null) goto L10;
            throw new IllegalArgumentException("To query by shortcut ID, package name must also be set");
        L10:
            if (query.getLocusIds() != null) goto L12;
        L16:
            UserHandle user = UserHandle.of(injectCallingUserId());
            if (injectHasInteractAcrossUsersFullPermission(injectBinderCallingPid(), injectBinderCallingUid()) == false) goto L19;
            user = null;
        L19:
            this.mShortcutChangeHandler.addShortcutChangeCallback(callback, query, user);
            return;
        L12:
            if (query.getPackage() != null) goto L16;
            throw new IllegalArgumentException("To query by locus ID, package name must also be set");
        }

        public void unregisterShortcutChangeCallback(String callingPackage, IShortcutChangeCallback callback) {
            ensureShortcutPermission(callingPackage);
            this.mShortcutChangeHandler.removeShortcutChangeCallback(callback);
        }

        public void pinShortcuts(String callingPackage, String packageName, List<String> ids, UserHandle targetUser) {
            if (this.mShortcutServiceInternal.areShortcutsSupportedOnHomeScreen(targetUser.getIdentifier()) == true) goto L5;
            ensureStrictAccessShortcutsPermission(callingPackage);
        L6:
            ensureShortcutPermission(callingPackage);
            if (canAccessProfile(targetUser.getIdentifier(), "Cannot pin shortcuts") == true) goto L9;
            return;
        L9:
            this.mShortcutServiceInternal.pinShortcuts(getCallingUserId(), callingPackage, packageName, ids, targetUser.getIdentifier());
            return;
        L5:
            ensureShortcutPermission(callingPackage);
            goto L6
        }

        public void cacheShortcuts(String callingPackage, String packageName, List<String> ids, UserHandle targetUser, int cacheFlags) {
            ensureStrictAccessShortcutsPermission(callingPackage);
            if (canAccessProfile(targetUser.getIdentifier(), "Cannot cache shortcuts") == true) goto L5;
            return;
        L5:
            this.mShortcutServiceInternal.cacheShortcuts(getCallingUserId(), callingPackage, packageName, ids, targetUser.getIdentifier(), toShortcutsCacheFlags(cacheFlags));
        }

        public void uncacheShortcuts(String callingPackage, String packageName, List<String> ids, UserHandle targetUser, int cacheFlags) {
            ensureStrictAccessShortcutsPermission(callingPackage);
            if (canAccessProfile(targetUser.getIdentifier(), "Cannot uncache shortcuts") == true) goto L5;
            return;
        L5:
            this.mShortcutServiceInternal.uncacheShortcuts(getCallingUserId(), callingPackage, packageName, ids, targetUser.getIdentifier(), toShortcutsCacheFlags(cacheFlags));
        }

        public int getShortcutIconResId(String callingPackage, String packageName, String id, int targetUserId) {
            ensureShortcutPermission(callingPackage);
            if (canAccessProfile(targetUserId, "Cannot access shortcuts") == true) goto L7;
            return 0;
        L7:
            return this.mShortcutServiceInternal.getShortcutIconResId(getCallingUserId(), callingPackage, packageName, id, targetUserId);
        }

        public ParcelFileDescriptor getShortcutIconFd(String callingPackage, String packageName, String id, int targetUserId) {
            ensureShortcutPermission(callingPackage);
            if (canAccessProfile(targetUserId, "Cannot access shortcuts") == true) goto L7;
            return null;
        L7:
            return this.mShortcutServiceInternal.getShortcutIconFd(getCallingUserId(), callingPackage, packageName, id, targetUserId);
        }

        public String getShortcutIconUri(String callingPackage, String packageName, String shortcutId, int userId) {
            ensureShortcutPermission(callingPackage);
            if (canAccessProfile(userId, "Cannot access shortcuts") == true) goto L7;
            return null;
        L7:
            return this.mShortcutServiceInternal.getShortcutIconUri(getCallingUserId(), callingPackage, packageName, shortcutId, userId);
        }

        public boolean hasShortcutHostPermission(String callingPackage) {
            verifyCallingPackage(callingPackage);
            return this.mShortcutServiceInternal.hasShortcutHostPermission(getCallingUserId(), callingPackage, injectBinderCallingPid(), injectBinderCallingUid());
        }

        public Map<String, LauncherActivityInfoInternal> getActivityOverrides(String callingPackage, int userId) {
            ensureShortcutPermission(callingPackage);
            int callingUid = Binder.getCallingUid();
            long callerIdentity = Binder.clearCallingIdentity();
            Map<String, LauncherActivityInfoInternal> shortcutOverridesInfo = new ArrayMap();     // Catch: Throwable -> L14
            UserHandle managedUserHandle = getManagedProfile(userId);     // Catch: Throwable -> L14
            if (managedUserHandle != null) goto L7;
            Binder.restoreCallingIdentity(callerIdentity);
            return shortcutOverridesInfo;
        L7:
            Map<String, String> packagesToOverride = DevicePolicyCache.getInstance().getLauncherShortcutOverrides();     // Catch: Throwable -> L14
            Iterator<Map.Entry<String, String>> r6 = packagesToOverride.entrySet().iterator();     // Catch: Throwable -> L14
        L9:
            if (r6.hasNext() == false) goto L17;
            Map.Entry<String, String> packageNames = r6.next();     // Catch: Throwable -> L14
            Intent intent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(packageNames.getValue());     // Catch: Throwable -> L14
            List<LauncherActivityInfoInternal> possibleShortcutOverrides = queryIntentLauncherActivities(intent, callingUid, managedUserHandle);     // Catch: Throwable -> L14
            if (possibleShortcutOverrides.isEmpty() == true) goto L9;
            shortcutOverridesInfo.put(packageNames.getKey(), possibleShortcutOverrides.get(0));     // Catch: Throwable -> L14
            goto L9
        L17:
            Binder.restoreCallingIdentity(callerIdentity);
            return shortcutOverridesInfo;
        L14:
            th = move-exception;
            Binder.restoreCallingIdentity(callerIdentity);
            throw th;
        }

        private UserHandle getManagedProfile(int userId) {
            Iterator r0 = this.mUm.getProfiles(userId).iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            UserInfo profile = (UserInfo) r0.next();
            if (profile.isManagedProfile() == false) goto L4;
            return profile.getUserHandle();
        L10:
            return null;
        }

        public boolean startShortcut(String callingPackage, String packageName, String featureId, String shortcutId, Rect sourceBounds, Bundle startActivityOptions, int targetUserId) {
            return startShortcutInner(injectBinderCallingUid(), injectBinderCallingPid(), injectCallingUserId(), callingPackage, packageName, featureId, shortcutId, sourceBounds, startActivityOptions, targetUserId);
        }

        private boolean startShortcutInner(int callerUid, int callerPid, int callingUserId, String callingPackage, String packageName, String featureId, String shortcutId, Rect sourceBounds, Bundle startActivityOptions, int targetUserId) {
            verifyCallingPackage(callingPackage, callerUid);
            if (canAccessProfile(targetUserId, "Cannot start activity") == true) goto L6;
            return false;
        L6:
            if (this.mShortcutServiceInternal.isPinnedByCaller(callingUserId, callingPackage, packageName, shortcutId, targetUserId) == true) goto L9;
            ensureShortcutPermission(callerUid, callerPid, callingPackage);
        L9:
            Intent[] intents = this.mShortcutServiceInternal.createShortcutIntents(getCallingUserId(), callingPackage, packageName, shortcutId, targetUserId, injectBinderCallingPid(), injectBinderCallingUid());
            if (intents == null) goto L37;
            if (intents.length == 0) goto L37;
            ActivityOptions options = ActivityOptions.fromBundle(startActivityOptions);
            if (options != null) goto L17;
        L25:
            intents[0].addFlags(268435456);
            intents[0].setSourceBounds(sourceBounds);
            intents[0].getSmtEx().putSmtExtra(IExtTask.EXTRA_FROM_SHORTCUT, true);
            String splashScreenThemeResName = this.mShortcutServiceInternal.getShortcutStartingThemeResName(callingUserId, callingPackage, packageName, shortcutId, targetUserId);
            if (splashScreenThemeResName != null) goto L28;
        L33:
            Bundle startActivityOptions2 = startActivityOptions;
        L35:
            return startShortcutIntentsAsPublisher(intents, packageName, featureId, startActivityOptions2, targetUserId);
        L28:
            if (splashScreenThemeResName.isEmpty() == true) goto L33;
            if (startActivityOptions != null) goto L31;
            Bundle startActivityOptions3 = new Bundle();
        L32:
            startActivityOptions3.putString("android.activity.splashScreenTheme", splashScreenThemeResName);
            startActivityOptions2 = startActivityOptions3;
            goto L35
        L31:
            startActivityOptions3 = startActivityOptions;
            goto L32
        L17:
            if (options.isApplyActivityFlagsForBubbles() == false) goto L20;
            intents[0].addFlags(524288);
            intents[0].addFlags(134217728);
        L20:
            if (options.isApplyMultipleTaskFlagForShortcut() == false) goto L23;
            intents[0].addFlags(134217728);
        L23:
            if (options.isApplyNoUserActionFlagForShortcut() == false) goto L25;
            intents[0].addFlags(262144);
        L37:
            return false;
        }

        private boolean startShortcutIntentsAsPublisher(Intent[] intents, String publisherPackage, String publishedFeatureId, Bundle startActivityOptions, int userId) {
            int code = this.mActivityTaskManagerInternal.startActivitiesAsPackage(publisherPackage, publishedFeatureId, userId, intents, getActivityOptionsForLauncher(startActivityOptions));     // Catch: SecurityException -> L11
            if (ActivityManager.isStartResultSuccessful(code) == false) goto L9;
            return true;
        L9:
            Log.e(TAG, "Couldn't start activity, code=" + code);     // Catch: SecurityException -> L11
            return false;
        L15:
            return false;
        }

        private Bundle getActivityOptionsForLauncher(Bundle startActivityOptions) {
            if (startActivityOptions == null) goto L5;
            ActivityOptions activityOptions = ActivityOptions.fromBundle(startActivityOptions);
            if (activityOptions.getPendingIntentBackgroundActivityStartMode() == 0) goto L9;
            return startActivityOptions;
        L9:
            return activityOptions.setPendingIntentBackgroundActivityStartMode(1).toBundle();
        L5:
            return ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle();
        }

        public boolean isActivityEnabled(String callingPackage, ComponentName component, UserHandle user) throws RemoteException {
            boolean r1 = false;
            if (canAccessProfile(user.getIdentifier(), "Cannot check component") == true) goto L6;
            return false;
        L6:
            if (PackageArchiver.isArchivingEnabled() == false) goto L21;
            if (component == null) goto L21;
            if (component.getPackageName() == null) goto L21;
            List<LauncherActivityInfoInternal> archiveActivities = generateLauncherActivitiesForArchivedApp(component.getPackageName(), user);
            if (archiveActivities.isEmpty() == true) goto L21;
            int i = 0;
        L14:
            if (i >= archiveActivities.size()) goto L20;
            if (archiveActivities.get(i).getComponentName().equals(component) == true) goto L17;
            i = i + 1;
            goto L14
        L17:
            return true;
        L20:
            return false;
        L21:
            int callingUid = injectBinderCallingUid();
            int state = this.mPackageManagerInternal.getComponentEnabledSetting(component, callingUid, user.getIdentifier());
            switch(state) {
                case 0: goto L27;
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L24;
                case 4: goto L24;
                default: goto L27;
            };
        L24:
            return false;
        L25:
            return true;
        L27:
            long ident = Binder.clearCallingIdentity();
            ActivityInfo info = this.mPackageManagerInternal.getActivityInfo(component, 786432, callingUid, user.getIdentifier());     // Catch: Throwable -> L35
            if (info == null) goto L37;
            if (info.isEnabled() == false) goto L37;
            r1 = true;
        L37:
            Binder.restoreCallingIdentity(ident);
            return r1;
        L35:
            th = move-exception;
            Throwable r14 = th;
        L41:
            Binder.restoreCallingIdentity(ident);
            throw r14;
        L39:
            th = move-exception;
            r14 = th;
            goto L41
        }

        public void startSessionDetailsActivityAsUser(IApplicationThread caller, String callingPackage, String callingFeatureId, PackageInstaller.SessionInfo sessionInfo, Rect sourceBounds, Bundle opts, UserHandle userHandle) throws RemoteException {
            int userId = userHandle.getIdentifier();
            if (canAccessProfile(userId, "Cannot start details activity") == true) goto L5;
            return;
        L5:
            Intent i = new Intent("android.intent.action.VIEW").setData(new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", sessionInfo.appPackageName).build()).putExtra("android.intent.extra.REFERRER", new Uri.Builder().scheme("android-app").authority(callingPackage).build());
            i.setSourceBounds(sourceBounds);
            this.mActivityTaskManagerInternal.startActivityAsUser(caller, callingPackage, callingFeatureId, i, null, 268435456, getActivityOptionsForLauncher(opts), userId);
        }

        public PendingIntent getActivityLaunchIntent(String callingPackage, ComponentName component, UserHandle user) {
            Log.d(TAG, "getActivityLaunchIntent callingPackage=" + callingPackage + " component=" + component + " user=" + user);     // Catch: Exception -> L5
        L8:
            if (this.mContext.checkPermission("android.permission.START_TASKS_FROM_RECENTS", injectBinderCallingPid(), injectBinderCallingUid()) == 0) goto L10;
            Log.d(TAG, "getActivityLaunchIntent no permission callingPid=" + injectBinderCallingPid() + " callingUid=" + injectBinderCallingUid());
            throw new SecurityException("Permission START_TASKS_FROM_RECENTS required");
        L10:
            if (canAccessProfile(user.getIdentifier(), "Cannot start activity") == false) goto L27;
            Intent launchIntent = getMainActivityLaunchIntent(component, user, false);
            if (launchIntent == null) goto L25;
            long ident = Binder.clearCallingIdentity();
            PendingIntent r13 = PendingIntent.getActivityAsUser(this.mContext, 0, launchIntent, 33554432, null, user);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(ident);
            return r13;
        L19:
            th = move-exception;
            Throwable r14 = th;
        L23:
            Binder.restoreCallingIdentity(ident);
            throw r14;
        L21:
            th = move-exception;
            r14 = th;
            goto L23
        L25:
            Log.d(TAG, "getActivityLaunchIntent cannot access profile user=" + user.getIdentifier() + " component=" + component);
            throw new SecurityException("Attempt to launch activity without  category Intent.CATEGORY_LAUNCHER " + component);
        L27:
            Log.d(TAG, "getActivityLaunchIntent cannot access profile user=" + user.getIdentifier());
            throw new ActivityNotFoundException("Activity could not be found");
        L5:
            e = move-exception;
            Log.e(TAG, "getActivityLaunchIntent is called and error occurred when printing the logs", e);
            goto L8
        }

        static boolean supportsMultiInstance(IPackageManager pm, ComponentName component, int userId) {
            return pm.getPropertyAsUser("android.window.PROPERTY_SUPPORTS_MULTI_INSTANCE_SYSTEM_UI", component.getPackageName(), component.getClassName(), userId).getBoolean();
        L11:
            return pm.getPropertyAsUser("android.window.PROPERTY_SUPPORTS_MULTI_INSTANCE_SYSTEM_UI", component.getPackageName(), null, userId).getBoolean();
        L9:
            return false;
        }

        public LauncherUserInfo getLauncherUserInfo(UserHandle user) {
            if (canAccessProfile(user.getIdentifier(), "Can't access LauncherUserInfo for another user") == true) goto L6;
            return null;
        L6:
            long ident = injectClearCallingIdentity();
            LauncherUserInfo r2 = this.mUserManagerInternal.getLauncherUserInfo(user.getIdentifier());     // Catch: Throwable -> L10
            injectRestoreCallingIdentity(ident);
            return r2;
        L10:
            th = move-exception;
            injectRestoreCallingIdentity(ident);
            throw th;
        }

        public List<String> getPreInstalledSystemPackages(UserHandle user) {
            if (canAccessProfile(user.getIdentifier(), "Can't access preinstalled packages for another user") == false) goto L5;
            long identity = Binder.clearCallingIdentity();
            String userType = this.mUserManagerInternal.getUserInfo(user.getIdentifier()).userType;     // Catch: Throwable -> L12
            Set<String> preInstalledPackages = this.mUm.getPreInstallableSystemPackages(userType);     // Catch: Throwable -> L12
            if (preInstalledPackages != null) goto L14;
            ArrayList r4 = new ArrayList();     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return r4;
        L14:
            List<String> r5 = List.copyOf(preInstalledPackages);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return r5;
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L5:
            return new ArrayList();
        }

        public IntentSender getAppMarketActivityIntent(String callingPackage, String packageName, UserHandle user) {
            if (canAccessProfile(user.getIdentifier(), "Can't access AppMarketActivity for another user") == true) goto L6;
            return null;
        L6:
            int callingUser = getCallingUserId();
            long identity = Binder.clearCallingIdentity();
            if (packageName != null) goto L13;
            IntentSender r0 = buildAppMarketIntentSenderForUser(user);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return r0;
        L13:
            String installerPackageName = getInstallerPackage(packageName, callingUser);     // Catch: Throwable -> L11
            if (installerPackageName != null) goto L16;
        L26:
            IntentSender r4 = buildAppMarketIntentSenderForUser(user);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return r4;
        L16:
            if (this.mPackageManagerInternal.getPackageUid(installerPackageName, 0, user.getIdentifier()) < 0) goto L26;
            Intent packageInfoIntent = buildMarketPackageInfoIntent(packageName, installerPackageName, callingPackage);     // Catch: Throwable -> L11
            if (this.mPackageManagerInternal.queryIntentActivities(packageInfoIntent, packageInfoIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 131072, Process.myUid(), user.getIdentifier()).isEmpty() == false) goto L23;
            IntentSender r5 = buildAppMarketIntentSenderForUser(user);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return r5;
        L23:
            IntentSender r6 = buildIntentSenderForUser(packageInfoIntent, user);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return r6;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public IntentSender getPrivateSpaceSettingsIntent() {
            IntentSender r2 = null;
            if (canAccessHiddenProfile(ILauncherApps.Stub.getCallingUid(), ILauncherApps.Stub.getCallingPid()) == true) goto L6;
            Slog.e(TAG, "Caller cannot access hidden profiles");
            return null;
        L6:
            int callingUser = getCallingUserId();
            int callingUid = ILauncherApps.Stub.getCallingUid();
            long identity = Binder.clearCallingIdentity();
            Intent psSettingsIntent = new Intent(LauncherAppsService.PS_SETTINGS_INTENT);     // Catch: Throwable -> L18
            psSettingsIntent.setFlags(268468224);     // Catch: Throwable -> L18
            List<ResolveInfo> ri = this.mPackageManagerInternal.queryIntentActivities(psSettingsIntent, psSettingsIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES, callingUid, callingUser);     // Catch: Throwable -> L18
            if (ri.isEmpty() == false) goto L11;
            Binder.restoreCallingIdentity(identity);
            return null;
        L11:
            PendingIntent pi = PendingIntent.getActivityAsUser(this.mContext, 0, psSettingsIntent, AudioFormat.DTS_HD, null, UserHandle.of(callingUser));     // Catch: Throwable -> L18
            if (pi == null) goto L16;
            r2 = pi.getIntentSender();     // Catch: Throwable -> L18
        L16:
            Binder.restoreCallingIdentity(identity);
            return r2;
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private IntentSender buildAppMarketIntentSenderForUser(UserHandle user) {
            Intent appMarketIntent = new Intent("android.intent.action.MAIN");
            appMarketIntent.addCategory("android.intent.category.APP_MARKET");
            appMarketIntent.setFlags(268468224);
            return buildIntentSenderForUser(appMarketIntent, user);
        }

        private IntentSender buildIntentSenderForUser(Intent intent, UserHandle user) {
            PendingIntent pi = PendingIntent.getActivityAsUser(this.mContext, 0, intent, AudioFormat.DTS_HD, null, user);
            if (pi != null) goto L6;
            return null;
        L6:
            return pi.getIntentSender();
        }

        private String getInstallerPackage(String packageName, int callingUserId) {
            InstallSourceInfo info = this.mIPM.getInstallSourceInfo(packageName, callingUserId);     // Catch: RemoteException -> L8
            if (info != null) goto L6;
            return null;
        L6:
            String installerPackageName = info.getInstallingPackageName();     // Catch: RemoteException -> L8
            return installerPackageName;
        L8:
            re = move-exception;
            Slog.e(TAG, "Couldn't find installer for " + packageName, re);
            return null;
        }

        private Intent buildMarketPackageInfoIntent(String packageName, String installerPackageName, String callingPackage) {
            return new Intent("android.intent.action.VIEW").setData(new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", packageName).build()).putExtra("android.intent.extra.REFERRER", new Uri.Builder().scheme("android-app").authority(callingPackage).build()).setPackage(installerPackageName).setFlags(268435456);
        }

        public void startActivityAsUser(IApplicationThread caller, String callingPackage, String callingFeatureId, ComponentName component, Rect sourceBounds, Bundle opts, UserHandle user) throws RemoteException {
            if (canAccessProfile(user.getIdentifier(), "Cannot start activity") == true) goto L5;
            return;
        L5:
            Intent launchIntent = getMainActivityLaunchIntent(component, user, true);
            if (launchIntent == null) goto L10;
            launchIntent.setSourceBounds(sourceBounds);
            this.mActivityTaskManagerInternal.startActivityAsUser(caller, callingPackage, callingFeatureId, launchIntent, null, 268435456, getActivityOptionsForLauncher(opts), user.getIdentifier());
            return;
        L10:
            throw new SecurityException("Attempt to launch activity without  category Intent.CATEGORY_LAUNCHER " + component);
        }

        private Intent getMainActivityLaunchIntent(ComponentName component, UserHandle user, boolean includeArchivedApps) {
            Intent launchIntent = new Intent("android.intent.action.MAIN");
            launchIntent.addCategory("android.intent.category.LAUNCHER");
            launchIntent.addFlags(270532608);
            launchIntent.setPackage(component.getPackageName());
            boolean canLaunch = false;
            int callingUid = injectBinderCallingUid();
            long ident = Binder.clearCallingIdentity();
            List<ResolveInfo> apps = this.mPackageManagerInternal.queryIntentActivities(launchIntent, launchIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 786432, callingUid, user.getIdentifier());     // Catch: Throwable -> L13
            int size = apps.size();     // Catch: Throwable -> L13
            int i = 0;
        L5:
            if (i >= size) goto L18;
            ActivityInfo activityInfo = apps.get(i).activityInfo;     // Catch: Throwable -> L13
            if (activityInfo.packageName.equals(component.getPackageName()) == false) goto L17;
            if (activityInfo.name.equals(component.getClassName()) == false) goto L17;
            if (activityInfo.exported == false) goto L16;
            launchIntent.setPackage(null);     // Catch: Throwable -> L13
            launchIntent.setComponent(component);     // Catch: Throwable -> L13
            canLaunch = true;
            goto L18
        L16:
            throw new SecurityException("Cannot launch non-exported components " + component);     // Catch: Throwable -> L13
        L17:
            i = i + 1;     // Catch: Throwable -> L13
        L18:
            if (canLaunch == true) goto L26;
            if (includeArchivedApps == false) goto L26;
            if (PackageArchiver.isArchivingEnabled() == false) goto L26;
            if (getMatchingArchivedAppActivityInfo(component, user) == null) goto L26;
            launchIntent.setPackage(null);     // Catch: Throwable -> L13
            launchIntent.setComponent(component);     // Catch: Throwable -> L13
            canLaunch = true;
        L26:
            if (canLaunch == false) goto L45;
            Binder.restoreCallingIdentity(ident);
            return launchIntent;
        L45:
            StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L13 Exception -> L35
            r0.append("getMainActivityLaunchIntent return null because it can't launch component=");     // Catch: Throwable -> L13 Exception -> L35
            r0.append(component);     // Catch: Throwable -> L13 Exception -> L35
            r0.append(" user=");     // Catch: Throwable -> L13 Exception -> L35
            r0.append(user);     // Catch: Throwable -> L31 Exception -> L33
            r0.append(" appsSize=");     // Catch: Throwable -> L31 Exception -> L33
            r0.append(size);     // Catch: Throwable -> L31 Exception -> L33
            r0.append(" includeArchivedApps=");     // Catch: Throwable -> L31 Exception -> L33
            r0.append(includeArchivedApps);     // Catch: Throwable -> L31 Exception -> L33
            r0.append(" isArchivingEnabled=");     // Catch: Throwable -> L31 Exception -> L33
            r0.append(PackageArchiver.isArchivingEnabled());     // Catch: Throwable -> L31 Exception -> L33
            r0.append(" matchingArchivedAppActivityInfo=");     // Catch: Throwable -> L31 Exception -> L33
            r0.append(getMatchingArchivedAppActivityInfo(component, user));     // Catch: Throwable -> L31 Exception -> L33
            Log.w(TAG, r0.toString());     // Catch: Throwable -> L31 Exception -> L33
        L39:
            Binder.restoreCallingIdentity(ident);
            return null;
        L33:
            e = e;
        L38:
            Log.e(TAG, "getMainActivityLaunchIntent return null and error occurred when printing the logs", e);     // Catch: Throwable -> L31
        L31:
            th = th;
        L43:
            Binder.restoreCallingIdentity(ident);
            throw th;
        L35:
            e = e;
        L13:
            th = th;
            goto L43
        }

        public void showAppDetailsAsUser(IApplicationThread caller, String callingPackage, String callingFeatureId, ComponentName component, Rect sourceBounds, Bundle opts, UserHandle user) throws RemoteException {
            if (canAccessProfile(user.getIdentifier(), "Cannot show app details") == true) goto L5;
            return;
        L5:
            long ident = Binder.clearCallingIdentity();
            String packageName = component.getPackageName();     // Catch: Throwable -> L10
            int uId = -1;
            uId = this.mContext.getPackageManager().getApplicationInfo(packageName, 4194304).uid;     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L13
        L15:
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts(Settings.ATTR_PACKAGE, packageName, null));     // Catch: Throwable -> L10
            intent.putExtra("uId", uId);     // Catch: Throwable -> L10
            int appId = -1;
            appId = this.mContext.getPackageManager().getApplicationInfoAsUser(packageName, 128, user.getIdentifier()).uid;     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L19
        L21:
            intent.putExtra("UID", appId);     // Catch: Throwable -> L10
            intent.setFlags(268468224);     // Catch: Throwable -> L10
            intent.setSourceBounds(sourceBounds);     // Catch: Throwable -> L26
            Binder.restoreCallingIdentity(ident);
            this.mActivityTaskManagerInternal.startActivityAsUser(caller, callingPackage, callingFeatureId, intent, null, 268435456, getActivityOptionsForLauncher(opts), user.getIdentifier());
            return;
        L26:
            th = th;
        L28:
            Binder.restoreCallingIdentity(ident);
            throw th;
        L19:
            e = move-exception;
            Log.d(TAG, "package not found: " + e);     // Catch: Throwable -> L10
            goto L21
        L13:
            e = move-exception;
            Log.d(TAG, "package not found: " + e);     // Catch: Throwable -> L10
        L10:
            th = th;
            goto L28
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback cb, ResultReceiver receiver) {
            int callingUid = injectBinderCallingUid();
            if (callingUid == 2000) goto L8;
            if (callingUid == 0) goto L8;
            throw new SecurityException("Caller must be shell");
        L8:
            long token = injectClearCallingIdentity();
            int status = new LauncherAppsShellCommand(this, null).exec(this, in, out, err, args, cb, receiver);     // Catch: Throwable -> L15
            if (receiver == null) goto L17;
            receiver.send(status, null);     // Catch: Throwable -> L15
        L17:
            injectRestoreCallingIdentity(token);
            return;
        L15:
            th = th;
        L21:
            injectRestoreCallingIdentity(token);
            throw th;
        L19:
            th = th;
            goto L21
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            super.dump(fd, pw, args);
            forEachViewCaptureWindow(new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda2(this));
        }

        private void dumpViewCaptureDataToWmTrace(String fileName, InputStream is) {
            Path outPath = Paths.get(fileName, new String[0]);
            OutputStream os = Files.newOutputStream(outPath, new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING});     // Catch: IOException -> L8
            transferViewCaptureData(is, os);     // Catch: Throwable -> L11
            Files.setPosixFilePermissions(outPath, LauncherAppsService.m6694$$Nest$sfgetWM_TRACE_FILE_PERMISSIONS());     // Catch: Throwable -> L11
            if (os == null) goto L26;
            os.close();     // Catch: IOException -> L8
            return;
        L26:
            return;
        L11:
            th = move-exception;
            if (os != null) goto L21;
        L18:
            throw th;     // Catch: IOException -> L8
        L21:
            os.close();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L8
        L8:
            e = move-exception;
            Log.d(TAG, "failed to write data to " + fileName + " in wmtrace dir", e);
        }

        private void transferViewCaptureData(InputStream is, OutputStream os) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(is);
            new SizedInputStream(dataInputStream, dataInputStream.readInt()).transferTo(os);
        }

        private void forEachViewCaptureWindow(final BiConsumer<String, InputStream> outputtingConsumer) {
            this.mOnDumpExecutor.submit(new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda0(this, outputtingConsumer)).get();     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            Log.e(TAG, "background work was interrupted", e);
        }

        private /* synthetic */ void lambda$forEachViewCaptureWindow$4(BiConsumer outputtingConsumer) {
            int i = this.mDumpCallbacks.beginBroadcast() - 1;     // Catch: Throwable -> L7
        L3:
            if (i < 0) goto L12;
            String packageName = (String) this.mDumpCallbacks.getBroadcastCookie(i);     // Catch: Throwable -> L7
            String fileName = LauncherAppsService.WM_TRACE_DIR + packageName + "_" + i + LauncherAppsService.VC_FILE_SUFFIX;     // Catch: Throwable -> L7
            ParcelFileDescriptor[] pipe = ParcelFileDescriptor.createPipe();     // Catch: Throwable -> L7 Exception -> L9
            this.mDumpCallbacks.getBroadcastItem(i).onDump(pipe[1]);     // Catch: Throwable -> L7 Exception -> L9
            ParcelFileDescriptor.AutoCloseInputStream r5 = new ParcelFileDescriptor.AutoCloseInputStream(pipe[0]);     // Catch: Throwable -> L7 Exception -> L9
            outputtingConsumer.accept(fileName, r5);     // Catch: Throwable -> L7 Exception -> L9
            r5.close();     // Catch: Throwable -> L7 Exception -> L9
        L11:
            i = i - 1;
        L9:
            e = move-exception;
            Log.d(TAG, "failed to pipe view capture data", e);     // Catch: Throwable -> L7
            goto L11
        L12:
            this.mDumpCallbacks.finishBroadcast();
            return;
        L7:
            th = move-exception;
            this.mDumpCallbacks.finishBroadcast();
            throw th;
        }

        public void saveViewCaptureData() {
            int status = PermissionChecker.checkCallingOrSelfPermissionForPreflight(this.mContext, "android.permission.READ_FRAME_BUFFER");
            if (status != 0) goto L5;
            forEachViewCaptureWindow(new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda2(this));
            return;
        L5:
            Log.w(TAG, "caller lacks permissions to save view capture data");
        }

        public void registerDumpCallback(IDumpCallback cb) {
            int status = PermissionChecker.checkCallingOrSelfPermissionForPreflight(this.mContext, "android.permission.READ_FRAME_BUFFER");
            if (status != 0) goto L5;
            String name = this.mContext.getPackageManager().getNameForUid(Binder.getCallingUid());
            this.mDumpCallbacks.register(cb, name);
            return;
        L5:
            Log.w(TAG, "caller lacks permissions to registerDumpCallback");
        }

        public void unRegisterDumpCallback(IDumpCallback cb) {
            int status = PermissionChecker.checkCallingOrSelfPermissionForPreflight(this.mContext, "android.permission.READ_FRAME_BUFFER");
            if (status != 0) goto L5;
            this.mDumpCallbacks.unregister(cb);
            return;
        L5:
            Log.w(TAG, "caller lacks permissions to unRegisterDumpCallback");
        }

        public void setArchiveCompatibilityOptions(final boolean enableIconOverlay, final boolean enableUnarchivalConfirmation) {
            final int callingUid = Binder.getCallingUid();
            Binder.withCleanCallingIdentity(new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda1(this, callingUid, enableIconOverlay, enableUnarchivalConfirmation));
        }

        private /* synthetic */ void lambda$setArchiveCompatibilityOptions$5(int r4, boolean r5, boolean r6) throws Exception {
            this.mAppOpsManager.setUidMode(145, r4, !r5 ? 1 : 0);
            this.mAppOpsManager.setUidMode(146, r4, !r6 ? 1 : 0);
        }

        private boolean isEnabledProfileOf(BroadcastCookie cookie, UserHandle user, String debugMsg) {
            if (isHiddenProfile(user) == false) goto L8;
            if (canAccessHiddenProfile(cookie.callingUid, cookie.callingPid) == true) goto L8;
            return false;
        L8:
            return this.mUserManagerInternal.isProfileAccessible(cookie.user.getIdentifier(), user.getIdentifier(), debugMsg, false);
        }

        private boolean isPackageVisibleToListener(String packageName, BroadcastCookie cookie, UserHandle user) {
            return !this.mPackageManagerInternal.filterAppAccess(packageName, cookie.callingUid, user.getIdentifier(), false);
        }

        private static boolean isCallingAppIdAllowed(int[] appIdAllowList, int appId) {
            if (appIdAllowList != null) goto L5;
        L12:
            return true;
        L5:
            if (appId < 10000) goto L12;
            if (Arrays.binarySearch(appIdAllowList, appId) > (-1)) goto L13;
            return false;
        L13:
            return true;
        }

        private String[] getFilteredPackageNames(String[] packageNames, BroadcastCookie cookie, UserHandle user) {
            List<String> filteredPackageNames = new ArrayList();
            int r1 = packageNames.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            String packageName = packageNames[r2];
            if (isPackageVisibleToListener(packageName, cookie, user) == false) goto L8;
            filteredPackageNames.add(packageName);
        L8:
            r2 = r2 + 1;
            goto L3
        L10:
            return (String[]) filteredPackageNames.toArray(new String[filteredPackageNames.size()]);
        }

        private int toShortcutsCacheFlags(int cacheFlags) {
            int ret = 0;
            if (cacheFlags != 0) goto L6;
            ret = 16384;
        L11:
            Preconditions.checkArgumentPositive(ret, "Invalid cache owner");
            return ret;
        L6:
            if (cacheFlags != 1) goto L9;
            ret = 1073741824;
            goto L11
        L9:
            if (cacheFlags != 2) goto L11;
            ret = 536870912;
            goto L11
        }

        void postToPackageMonitorHandler(Runnable r) {
            this.mCallbackHandler.post(r);
        }

        void registerLoadingProgressForIncrementalApps() {
            List<UserHandle> users = this.mUm.getUserProfiles();
            if (users != null) goto L5;
            return;
        L5:
            Iterator<UserHandle> r1 = users.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            final UserHandle user = r1.next();
            this.mPackageManagerInternal.forEachInstalledPackage(new LauncherAppsService$LauncherAppsImpl$$ExternalSyntheticLambda5(this, user), user.getIdentifier());
            goto L7
        }

        private /* synthetic */ void lambda$registerLoadingProgressForIncrementalApps$6(UserHandle user, AndroidPackage pkg) {
            String packageName = pkg.getPackageName();
            IncrementalStatesInfo info = this.mPackageManagerInternal.getIncrementalStatesInfo(packageName, Process.myUid(), user.getIdentifier());
            if (info != null) goto L5;
            return;
        L5:
            if (info.isLoading() == false) goto L9;
            this.mPackageManagerInternal.registerInstalledLoadingProgressCallback(packageName, new PackageLoadingProgressCallback(this, packageName, user), user.getIdentifier());
            return;
        }

        void registerSettingsObserver() {
            this.mSecureSettingsObserver = new SecureSettingsObserver(this);
            this.mSecureSettingsObserver.register();
        }
    }

    public static abstract class LauncherAppsServiceInternal {
        public abstract boolean startShortcut(int r1, int r2, String r3, String r4, String r5, String r6, Rect r7, Bundle r8, int r9);

        public LauncherAppsServiceInternal() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetWM_TRACE_FILE_PERMISSIONS, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m6694$$Nest$sfgetWM_TRACE_FILE_PERMISSIONS() {
        return WM_TRACE_FILE_PERMISSIONS;
    }

    static {
        WM_TRACE_FILE_PERMISSIONS = Set.of(PosixFilePermission.OWNER_WRITE, PosixFilePermission.GROUP_READ, PosixFilePermission.OTHERS_READ, PosixFilePermission.OWNER_READ);
    }

    public LauncherAppsService(Context context) {
        super(context);
        this.mLauncherAppsImpl = new LauncherAppsImpl(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("launcherapps", this.mLauncherAppsImpl);
        this.mLauncherAppsImpl.registerLoadingProgressForIncrementalApps();
        LocalServices.addService(LauncherAppsServiceInternal.class, this.mLauncherAppsImpl.mInternal);
    }
}
