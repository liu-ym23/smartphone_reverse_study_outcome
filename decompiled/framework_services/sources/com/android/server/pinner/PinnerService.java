package com.android.server.pinner;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.IActivityManager;
import android.app.UidObserver;
import android.app.pinner.IPinnerService;
import android.app.pinner.PinnedFileStat;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemProperties;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.app.ResolverActivity;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import com.android.server.wm.ActivityTaskManagerInternal;
import dalvik.system.DexFile;
import dalvik.system.VMRuntime;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class PinnerService extends SystemService {
    public static final String ANON_REGION_STAT_NAME = "[anon]";
    private static final boolean DEBUG = false;
    private static final long DEFAULT_ANON_SIZE = 0;
    private static final String DEVICE_CONFIG_KEY_ANON_SIZE = "pin_shared_anon_size";
    private static final String DEVICE_CONFIG_NAMESPACE_ANON_SIZE = "runtime_native";
    private static final int KEY_ASSISTANT = 2;
    private static final int KEY_CAMERA = 0;
    private static final int KEY_HOME = 1;
    private static final int MATCH_FLAGS = 851968;
    private static final long MAX_ANON_SIZE = 2147483648L;
    private static final int PAGE_SIZE = 0;
    private static final String PIN_META_FILENAME = "pinlist.meta";
    private static boolean PROP_PIN_PINLIST = false;
    private static final String SYSTEM_GROUP_NAME = "system";
    private static final String TAG = "PinnerService";
    private final IActivityManager mAm;
    private final ActivityManagerInternal mAmInternal;
    private final ActivityTaskManagerInternal mAtmInternal;
    private BinderService mBinderService;
    private final BroadcastReceiver mBroadcastReceiver;
    private final int mConfiguredAssistantPinBytes;
    private final int mConfiguredCameraPinBytes;
    private final int mConfiguredHomePinBytes;
    private long mConfiguredMaxPinnedMemory;
    private final int mConfiguredMaxPinnedMemoryPercentage;
    private final boolean mConfiguredToPinAssistant;
    private final boolean mConfiguredToPinCamera;
    private final int mConfiguredWebviewPinBytes;
    private final Context mContext;
    private long mCurrentPinnedMemory;
    private long mCurrentlyPinnedAnonSize;
    private final DeviceConfig.OnPropertiesChangedListener mDeviceConfigAnonSizeListener;
    private final DeviceConfigInterface mDeviceConfigInterface;
    private final Injector mInjector;
    private final ArrayMap<Integer, Integer> mPendingRepin;
    private long mPinAnonAddress;
    private long mPinAnonSize;
    private ArraySet<Integer> mPinKeys;
    private final ArrayMap<Integer, PinnedApp> mPinnedApps;
    private final ArrayMap<String, PinnedFile> mPinnedFiles;
    private PinnerHandler mPinnerHandler;
    private final UserManager mUserManager;

    /* JADX INFO: renamed from: com.android.server.pinner.PinnerService$4, reason: invalid class name */
    class AnonymousClass4 extends UidObserver {
        final /* synthetic */ PinnerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$uIwPx-PfZneISkHXky6n-dasd6g, reason: not valid java name */
        public static /* synthetic */ void m6591$r8$lambda$uIwPxPfZneISkHXky6ndasd6g(PinnerService r0, int r1) {
            PinnerService.m6584$$Nest$mhandleUidActive(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$zn9yx-8hgftZMcZVMIzK-q3RXh8, reason: not valid java name */
        public static /* synthetic */ void m6592$r8$lambda$zn9yx8hgftZMcZVMIzKq3RXh8(PinnerService r0, int r1) {
            PinnerService.m6585$$Nest$mhandleUidGone(r0, r1);
        }

        AnonymousClass4(PinnerService this$0) {
            this.this$0 = this$0;
        }

        public void onUidGone(int uid, boolean disabled) {
            PinnerService.m6579$$Nest$fgetmPinnerHandler(this.this$0).sendMessage(PooledLambda.obtainMessage(new PinnerService$4$$ExternalSyntheticLambda0(), this.this$0, Integer.valueOf(uid)));
        }

        public void onUidActive(int uid) {
            PinnerService.m6579$$Nest$fgetmPinnerHandler(this.this$0).sendMessage(PooledLambda.obtainMessage(new PinnerService$4$$ExternalSyntheticLambda1(), this.this$0, Integer.valueOf(uid)));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppKey {
    }

    public final class BinderService extends IPinnerService.Stub {
        final /* synthetic */ PinnerService this$0;

        public BinderService(PinnerService this$0) {
            this.this$0 = this$0;
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(PinnerService.m6573$$Nest$fgetmContext(this.this$0), PinnerService.TAG, pw) == true) goto L5;
            return;
        L5:
            HashSet<PinnedFile> shownPins = new HashSet();
            HashSet<String> shownGroups = new HashSet();
            HashSet<String> groupsToPrint = new HashSet();
            long bytesPinnedForApp = 4697254411347427328L;
            pw.format("Pinner Configs:\n", new Object[0]);
            pw.format("   Total Pinner quota: %d%% of total device memory\n", new Object[]{Integer.valueOf(PinnerService.m6572$$Nest$fgetmConfiguredMaxPinnedMemoryPercentage(this.this$0))});
            double r12 = 1048576.0d;
            pw.format("   Maximum Pinner quota: %d bytes (%.2f MB)\n", new Object[]{Long.valueOf(PinnerService.m6571$$Nest$fgetmConfiguredMaxPinnedMemory(this.this$0)), Double.valueOf(PinnerService.m6571$$Nest$fgetmConfiguredMaxPinnedMemory(this.this$0) / 1048576.0d)});
            pw.format("   Max Home App Pin Bytes (without deps): %d (%.2f MB)\n", new Object[]{Integer.valueOf(PinnerService.m6570$$Nest$fgetmConfiguredHomePinBytes(this.this$0)), Double.valueOf(((double) PinnerService.m6570$$Nest$fgetmConfiguredHomePinBytes(this.this$0)) / 1048576.0d)});
            pw.format("   Max Assistant App Pin Bytes (without deps): %d (%.2f MB)\n", new Object[]{Integer.valueOf(PinnerService.m6568$$Nest$fgetmConfiguredAssistantPinBytes(this.this$0)), Double.valueOf(((double) PinnerService.m6568$$Nest$fgetmConfiguredAssistantPinBytes(this.this$0)) / 1048576.0d)});
            pw.format("   Max Camera App Pin Bytes (without deps): %d (%.2f MB)\n", new Object[]{Integer.valueOf(PinnerService.m6569$$Nest$fgetmConfiguredCameraPinBytes(this.this$0)), Double.valueOf(((double) PinnerService.m6569$$Nest$fgetmConfiguredCameraPinBytes(this.this$0)) / 1048576.0d)});
            pw.format("\nPinned Files:\n", new Object[0]);
            PinnerService r8 = this.this$0;
            monitor-enter(r8);
            long bytesPinnedForAppDeps = 0;
            Iterator r0 = PinnerService.m6577$$Nest$fgetmPinnedApps(this.this$0).keySet().iterator();     // Catch: Throwable -> L105
        L9:
            if (r0.hasNext() == false) goto L44;
            int key = ((Integer) r0.next()).intValue();     // Catch: Throwable -> L42
            PinnedApp app = (PinnedApp) PinnerService.m6577$$Nest$fgetmPinnedApps(this.this$0).get(Integer.valueOf(key));     // Catch: Throwable -> L42
            pw.print(PinnerService.m6582$$Nest$mgetNameForKey(this.this$0, key));     // Catch: Throwable -> L42
            pw.print(" uid=");     // Catch: Throwable -> L42
            pw.print(app.uid);     // Catch: Throwable -> L42
            pw.print(" active=");     // Catch: Throwable -> L42
            pw.print(app.active);     // Catch: Throwable -> L42
            if (app.mFiles.isEmpty() == false) goto L113;
        L17:
            pw.println();     // Catch: Throwable -> L42
            double r19 = r12;
            Iterator<PinnedFile> r13 = ((PinnedApp) PinnerService.m6577$$Nest$fgetmPinnedApps(this.this$0).get(Integer.valueOf(key))).mFiles.iterator();     // Catch: Throwable -> L42
            long bytesPinnedForApp2 = bytesPinnedForApp;
            long bytesPinnedForApp3 = 0;
            long totalSize = bytesPinnedForAppDeps;
            long bytesPinnedForAppDeps2 = 0;
        L123:
        L38:
            th = th;
            PinnerService r23 = r8;
        L107:
            monitor-exit(r23);     // Catch: Throwable -> L82
            throw th;
        L20:
            if (r13.hasNext() == false) goto L40;
            PinnedFile pf = r13.next();     // Catch: Throwable -> L38
            Iterator r21 = r0;
            pw.print("  ");     // Catch: Throwable -> L38
            int key2 = key;
            PinnedApp app2 = app;
            long bytesPerMB = bytesPinnedForApp2;
            HashSet<String> shownGroups2 = shownGroups;
            HashSet<String> groupsToPrint2 = groupsToPrint;
            pw.format("%s pinned:%d bytes (%.2f MB) pinlist:%b\n", new Object[]{pf.fileName, Long.valueOf(pf.bytesPinned), Double.valueOf(pf.bytesPinned / r19), Boolean.valueOf(pf.used_pinlist)});     // Catch: Throwable -> L33
            totalSize = totalSize + pf.bytesPinned;     // Catch: Throwable -> L33
            bytesPinnedForApp3 = bytesPinnedForApp3 + pf.bytesPinned;     // Catch: Throwable -> L33
            shownPins.add(pf);     // Catch: Throwable -> L33
            Iterator<PinnedFile> r1 = pf.pinnedDeps.iterator();     // Catch: Throwable -> L33
        L27:
            if (r1.hasNext() == false) goto L35;
            PinnedFile dep = r1.next();     // Catch: Throwable -> L33
            pw.print("  ");     // Catch: Throwable -> L33
            long bytesPinnedForApp4 = bytesPinnedForApp3;
            PinnerService r14 = r8;
            pw.format("%s pinned:%d bytes (%.2f MB) pinlist:%b (Dependency)\n", new Object[]{dep.fileName, Long.valueOf(dep.bytesPinned), Double.valueOf(dep.bytesPinned / r19), Boolean.valueOf(dep.used_pinlist)});     // Catch: Throwable -> L31
            totalSize = totalSize + dep.bytesPinned;     // Catch: Throwable -> L31
            bytesPinnedForAppDeps2 = bytesPinnedForAppDeps2 + dep.bytesPinned;     // Catch: Throwable -> L31
            shownPins.add(dep);     // Catch: Throwable -> L31
            r8 = r14;
            bytesPinnedForApp3 = bytesPinnedForApp4;
        L31:
            th = th;
        L32:
            r23 = r14;
            goto L107
        L35:
            shownGroups = shownGroups2;
            groupsToPrint = groupsToPrint2;
            r0 = r21;
            key = key2;
            app = app2;
            bytesPinnedForApp2 = bytesPerMB;
        L33:
            th = th;
            r14 = r8;
        L36:
            th = th;
            r23 = r8;
            goto L107
        L40:
            Iterator r22 = r0;
            long bytesPerMB2 = bytesPinnedForApp2;
            HashSet<String> shownGroups3 = shownGroups;
            HashSet<String> groupsToPrint3 = groupsToPrint;
            PinnerService r15 = r8;
            long bytesPinnedForAppAndDeps = bytesPinnedForApp3 + bytesPinnedForAppDeps2;     // Catch: Throwable -> L31
            pw.format("Total Pinned = %d (%.2f MB) [App=%d (%.2f MB), Dependencies=%d (%.2f MB)]\n\n", new Object[]{Long.valueOf(bytesPinnedForAppAndDeps), Double.valueOf(bytesPinnedForAppAndDeps / r19), Long.valueOf(bytesPinnedForApp3), Double.valueOf(bytesPinnedForApp3 / r19), Long.valueOf(bytesPinnedForAppDeps2), Double.valueOf(bytesPinnedForAppDeps2 / r19)});     // Catch: Throwable -> L31
            r8 = r15;
            shownGroups = shownGroups3;
            groupsToPrint = groupsToPrint3;
            bytesPinnedForAppDeps = totalSize;
            r12 = r19;
            r0 = r22;
            bytesPinnedForApp = bytesPerMB2;
            goto L9
        L113:
            shownGroups.add(((PinnedFile) app.mFiles.getFirst()).groupName);     // Catch: Throwable -> L15
        L15:
            th = th;
            r23 = r8;
        L42:
            th = th;
            r23 = r8;
            goto L107
        L44:
            HashSet<String> shownGroups4 = shownGroups;
            HashSet<String> groupsToPrint4 = groupsToPrint;
            PinnerService r16 = r8;
            double r110 = r12;
            pw.println();     // Catch: Throwable -> L103
            Iterator r2 = PinnerService.m6578$$Nest$fgetmPinnedFiles(this.this$0).values().iterator();     // Catch: Throwable -> L103
        L46:
            if (r2.hasNext() == false) goto L61;
            PinnedFile pinnedFile = (PinnedFile) r2.next();     // Catch: Throwable -> L59
            HashSet<String> groupsToPrint5 = groupsToPrint4;
        L56:
            th = th;
            r23 = r16;
            goto L107
        L51:
            if (groupsToPrint5.contains(pinnedFile.groupName) == true) goto L58;
            if (shownGroups4.contains(pinnedFile.groupName) == true) goto L58;
            groupsToPrint5.add(pinnedFile.groupName);     // Catch: Throwable -> L56
        L58:
            groupsToPrint4 = groupsToPrint5;
        L59:
            th = th;
            r23 = r16;
            goto L107
        L61:
            HashSet<String> groupsToPrint6 = groupsToPrint4;
            Iterator<String> r3 = groupsToPrint6.iterator();     // Catch: Throwable -> L88
        L64:
            if (r3.hasNext() == false) goto L91;
            String group = r3.next();     // Catch: Throwable -> L88
            List<PinnedFile> groupPins = PinnerService.m6580$$Nest$mgetAllPinsForGroup(this.this$0, group);     // Catch: Throwable -> L88
            pw.print("\nGroup:" + group);     // Catch: Throwable -> L88
            long bytesPinnedForGroupNoDeps = 0;
            long bytesPinnedForGroupDeps = 0;
            pw.println();     // Catch: Throwable -> L88
            Iterator<PinnedFile> r17 = groupPins.iterator();     // Catch: Throwable -> L88
        L67:
            if (r17.hasNext() == false) goto L90;
            PinnedFile pinnedFile2 = r17.next();     // Catch: Throwable -> L88
            r3 = r3;
            if (shownPins.contains(pinnedFile2) == true) goto L67;
            String group2 = group;
            List<PinnedFile> groupPins2 = groupPins;
            String r5 = pinnedFile2.fileName;     // Catch: Throwable -> L88
            long totalSize2 = bytesPinnedForAppDeps;
            long totalSize3 = pinnedFile2.bytesPinned;     // Catch: Throwable -> L88
            Iterator<PinnedFile> r26 = r17;
            r23 = r16;
            pw.format("  %s pinned: %d bytes (%.2f MB) pinlist:%b\n", new Object[]{r5, Long.valueOf(totalSize3), Double.valueOf(pinnedFile2.bytesPinned / r110), Boolean.valueOf(pinnedFile2.used_pinlist)});     // Catch: Throwable -> L84
            bytesPinnedForAppDeps = totalSize2 + pinnedFile2.bytesPinned;     // Catch: Throwable -> L84
            bytesPinnedForGroupNoDeps = bytesPinnedForGroupNoDeps + pinnedFile2.bytesPinned;     // Catch: Throwable -> L84
            shownPins.add(pinnedFile2);     // Catch: Throwable -> L84
            Iterator<PinnedFile> r4 = pinnedFile2.pinnedDeps.iterator();     // Catch: Throwable -> L84
        L75:
            if (r4.hasNext() == false) goto L87;
            PinnedFile dep2 = r4.next();     // Catch: Throwable -> L84
            if (shownPins.contains(dep2) == true) goto L75;
            pw.print("  ");     // Catch: Throwable -> L84
            HashSet<String> groupsToPrint7 = groupsToPrint6;
            long bytesPinnedForGroupNoDeps2 = bytesPinnedForGroupNoDeps;
            pw.format("%s pinned:%d bytes (%.2f MB) pinlist:%b (Dependency)\n", new Object[]{dep2.fileName, Long.valueOf(dep2.bytesPinned), Double.valueOf(dep2.bytesPinned / r110), Boolean.valueOf(dep2.used_pinlist)});     // Catch: Throwable -> L82
            bytesPinnedForAppDeps = bytesPinnedForAppDeps + dep2.bytesPinned;     // Catch: Throwable -> L82
            bytesPinnedForGroupDeps = bytesPinnedForGroupDeps + dep2.bytesPinned;     // Catch: Throwable -> L82
            shownPins.add(dep2);     // Catch: Throwable -> L82
            bytesPinnedForGroupNoDeps = bytesPinnedForGroupNoDeps2;
            groupsToPrint6 = groupsToPrint7;
        L82:
            th = th;
            goto L107
        L87:
            group = group2;
            groupPins = groupPins2;
            r16 = r23;
            r17 = r26;
        L84:
            th = th;
            goto L107
        L90:
            long totalSize4 = bytesPinnedForAppDeps;
            long bytesPinnedForGroup = bytesPinnedForGroupNoDeps + bytesPinnedForGroupDeps;     // Catch: Throwable -> L82
            pw.format("Total Pinned = %d (%.2f MB) [Main=%d (%.2f MB), Dependencies=%d (%.2f MB)]\n\n", new Object[]{Long.valueOf(bytesPinnedForGroup), Double.valueOf(bytesPinnedForGroup / r110), Long.valueOf(bytesPinnedForGroupNoDeps), Double.valueOf(bytesPinnedForGroupNoDeps / r110), Long.valueOf(bytesPinnedForGroupDeps), Double.valueOf(bytesPinnedForGroupDeps / r110)});     // Catch: Throwable -> L82
            r3 = r3;
            bytesPinnedForAppDeps = totalSize4;
            r16 = r16;
            groupsToPrint6 = groupsToPrint6;
            goto L64
        L91:
            PinnerService r24 = r16;
            pw.println();     // Catch: Throwable -> L82
            if (PinnerService.m6576$$Nest$fgetmPinAnonAddress(this.this$0) == 0) goto L94;
            pw.format("Pinned anon region: %d (%.2f MB)\n", new Object[]{Long.valueOf(PinnerService.m6574$$Nest$fgetmCurrentlyPinnedAnonSize(this.this$0)), Double.valueOf(PinnerService.m6574$$Nest$fgetmCurrentlyPinnedAnonSize(this.this$0) / r110)});     // Catch: Throwable -> L82
            bytesPinnedForAppDeps = bytesPinnedForAppDeps + PinnerService.m6574$$Nest$fgetmCurrentlyPinnedAnonSize(this.this$0);     // Catch: Throwable -> L82
        L94:
            pw.format("Total pinned: %d bytes (%.2f MB)\n", new Object[]{Long.valueOf(bytesPinnedForAppDeps), Double.valueOf(bytesPinnedForAppDeps / r110)});     // Catch: Throwable -> L82
            pw.format("Available Pinner quota: %d bytes (%.2f MB)\n", new Object[]{Long.valueOf(PinnerService.m6581$$Nest$mgetAvailableGlobalQuota(this.this$0)), Double.valueOf(PinnerService.m6581$$Nest$mgetAvailableGlobalQuota(this.this$0) / r110)});     // Catch: Throwable -> L82
            pw.println();     // Catch: Throwable -> L82
            if (PinnerService.m6575$$Nest$fgetmPendingRepin(this.this$0).isEmpty() == true) goto L101;
            pw.print("Pending repin: ");     // Catch: Throwable -> L82
            Iterator r6 = PinnerService.m6575$$Nest$fgetmPendingRepin(this.this$0).values().iterator();     // Catch: Throwable -> L82
        L98:
            if (r6.hasNext() == false) goto L100;
            pw.print(PinnerService.m6582$$Nest$mgetNameForKey(this.this$0, ((Integer) r6.next()).intValue()));     // Catch: Throwable -> L82
            pw.print(' ');     // Catch: Throwable -> L82
            goto L98
        L100:
            pw.println();     // Catch: Throwable -> L82
        L101:
            monitor-exit(r24);     // Catch: Throwable -> L82
            return;
        L88:
            th = th;
            r23 = r16;
        L103:
            th = th;
            r23 = r16;
        L105:
            th = th;
            r23 = r8;
            goto L107
        }

        private void repin() {
            PinnerService.m6590$$Nest$msendUnpinAppsMessage(this.this$0);
            PinnerService.m6589$$Nest$msendPinAppsWithUpdatedKeysMessage(this.this$0, 0);
        }

        private void printError(FileDescriptor out, String message) {
            PrintWriter writer = new PrintWriter(new FileOutputStream(out));
            writer.println(message);
            writer.flush();
        }

        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            if (args.length >= 1) goto L6;
            printError(out, "Command is not given.");
            resultReceiver.send(-1, null);
            return;
        L6:
            String command = args[0];
            switch(command.hashCode()) {
                case 108401282: goto L10;
                default: goto L12;
            };
        L12:
            byte r4 = -1;
        L13:
            switch(r4) {
                case 0: goto L16;
                default: goto L14;
            };
        L14:
            printError(out, String.format("Unknown pinner command: %s. Supported commands: repin", new Object[]{command}));
            resultReceiver.send(-1, null);
            return;
        L16:
            repin();
            resultReceiver.send(0, null);
            return;
        L10:
            if (command.equals("repin") == false) goto L12;
            r4 = 0;
            goto L13
        }

        public List<PinnedFileStat> getPinnerStats() {
            getPinnerStats_enforcePermission();
            return this.this$0.getPinnerStats();
        }
    }

    public static class Injector {
        public Injector() {
        }

        protected DeviceConfigInterface getDeviceConfigInterface() {
            return DeviceConfigInterface.REAL;
        }

        protected void publishBinderService(PinnerService service, Binder binderService) {
            PinnerService.access$000(service, "pinner", binderService);
        }

        protected PinnedFile pinFileInternal(PinnerService service, String fileToPin, long maxBytesToPin, boolean attemptPinIntrospection) {
            return PinnerService.m6586$$Nest$mpinFileInternal(service, fileToPin, maxBytesToPin, attemptPinIntrospection);
        }
    }

    static final class PinRange {
        int length;
        int start;

        PinRange() {
        }
    }

    private final class PinnedApp {
        boolean active;
        final ArrayList<PinnedFile> mFiles;
        final int uid;

        /* synthetic */ PinnedApp(PinnerService r1, ApplicationInfo r2, PinnerServiceIA r3) {
            this(r1, r2);
        }

        private PinnedApp(PinnerService r2, ApplicationInfo appInfo) {
            this.mFiles = new ArrayList();
            this.uid = appInfo.uid;
            this.active = PinnerService.m6567$$Nest$fgetmAmInternal(r2).isUidActive(this.uid);
        }
    }

    public static class PinnedFileStats {
        public final String filename;
        public final int sizeKb;
        public final int uid;

        protected PinnedFileStats(int uid, PinnedFile file) {
            this.uid = uid;
            this.filename = file.fileName.substring(file.fileName.lastIndexOf(47) + 1);
            this.sizeKb = ((int) file.bytesPinned) / 1024;
        }
    }

    final class PinnerHandler extends Handler {
        static final int PIN_ONSTART_MSG = 4001;
        final /* synthetic */ PinnerService this$0;

        public PinnerHandler(PinnerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 4001: goto L5;
                default: goto L4;
            };
        L4:
            super.handleMessage(msg);
            return;
        L5:
            PinnerService.m6583$$Nest$mhandlePinOnStart(this.this$0);
        }
    }

    public static /* synthetic */ void $r8$lambda$2PfQLctqG4Okc7wNRRai0fQs5fU(PinnerService r0, int r1) {
        r0.pinApps(r1);
    }

    public static /* synthetic */ void $r8$lambda$52c9PjbzKP2HiaB_g7_gqvFiyJA(PinnerService r0, int r1) {
        r0.pinAppsWithUpdatedKeys(r1);
    }

    public static /* synthetic */ void $r8$lambda$5NlcqPFWoiYpj9p2T8d2xF4yH8M(PinnerService r0, int r1, int r2, boolean r3) {
        r0.pinApp(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$R6x7amq8T_0MOzvlOxQEMhh7D0U(PinnerService r0) {
        r0.unpinApps();
    }

    public static /* synthetic */ boolean $r8$lambda$vknxfPtf9El4XwvHudFnd4mofSM(String r0, PinnedFile r1) {
        return lambda$getAllPinsForGroup$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m6567$$Nest$fgetmAmInternal(PinnerService r0) {
        return r0.mAmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfiguredAssistantPinBytes, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6568$$Nest$fgetmConfiguredAssistantPinBytes(PinnerService r0) {
        return r0.mConfiguredAssistantPinBytes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfiguredCameraPinBytes, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6569$$Nest$fgetmConfiguredCameraPinBytes(PinnerService r0) {
        return r0.mConfiguredCameraPinBytes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfiguredHomePinBytes, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6570$$Nest$fgetmConfiguredHomePinBytes(PinnerService r0) {
        return r0.mConfiguredHomePinBytes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfiguredMaxPinnedMemory, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6571$$Nest$fgetmConfiguredMaxPinnedMemory(PinnerService r2) {
        return r2.mConfiguredMaxPinnedMemory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfiguredMaxPinnedMemoryPercentage, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6572$$Nest$fgetmConfiguredMaxPinnedMemoryPercentage(PinnerService r0) {
        return r0.mConfiguredMaxPinnedMemoryPercentage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6573$$Nest$fgetmContext(PinnerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentlyPinnedAnonSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6574$$Nest$fgetmCurrentlyPinnedAnonSize(PinnerService r2) {
        return r2.mCurrentlyPinnedAnonSize;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingRepin, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m6575$$Nest$fgetmPendingRepin(PinnerService r0) {
        return r0.mPendingRepin;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPinAnonAddress, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6576$$Nest$fgetmPinAnonAddress(PinnerService r2) {
        return r2.mPinAnonAddress;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPinnedApps, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m6577$$Nest$fgetmPinnedApps(PinnerService r0) {
        return r0.mPinnedApps;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPinnedFiles, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m6578$$Nest$fgetmPinnedFiles(PinnerService r0) {
        return r0.mPinnedFiles;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPinnerHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ PinnerHandler m6579$$Nest$fgetmPinnerHandler(PinnerService r0) {
        return r0.mPinnerHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAllPinsForGroup, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6580$$Nest$mgetAllPinsForGroup(PinnerService r0, String r1) {
        return r0.getAllPinsForGroup(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAvailableGlobalQuota, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6581$$Nest$mgetAvailableGlobalQuota(PinnerService r2) {
        return r2.getAvailableGlobalQuota();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNameForKey, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6582$$Nest$mgetNameForKey(PinnerService r0, int r1) {
        return r0.getNameForKey(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePinOnStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6583$$Nest$mhandlePinOnStart(PinnerService r0) {
        r0.handlePinOnStart();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUidActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6584$$Nest$mhandleUidActive(PinnerService r0, int r1) {
        r0.handleUidActive(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUidGone, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6585$$Nest$mhandleUidGone(PinnerService r0, int r1) {
        r0.handleUidGone(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpinFileInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PinnedFile m6586$$Nest$mpinFileInternal(PinnerService r0, String r1, long r2, boolean r4) {
        return r0.pinFileInternal(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshPinAnonConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6587$$Nest$mrefreshPinAnonConfig(PinnerService r0) {
        r0.refreshPinAnonConfig();
    }

    /* JADX INFO: renamed from: -$$Nest$msendPinAppMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6588$$Nest$msendPinAppMessage(PinnerService r0, int r1, int r2, boolean r3) {
        r0.sendPinAppMessage(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msendPinAppsWithUpdatedKeysMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6589$$Nest$msendPinAppsWithUpdatedKeysMessage(PinnerService r0, int r1) {
        r0.sendPinAppsWithUpdatedKeysMessage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendUnpinAppsMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6590$$Nest$msendUnpinAppsMessage(PinnerService r0) {
        r0.sendUnpinAppsMessage();
    }

    static /* synthetic */ void access$000(PinnerService x0, String x1, IBinder x2) {
        x0.publishBinderService(x1, x2);
    }

    static {
        PAGE_SIZE = (int) Os.sysconf(OsConstants._SC_PAGESIZE);
        PROP_PIN_PINLIST = SystemProperties.getBoolean("pinner.use_pinlist", true);
        DEFAULT_ANON_SIZE = SystemProperties.getLong("pinner.pin_shared_anon_size", 0);
    }

    public PinnerService(Context context) {
        this(context, new Injector());
    }

    public PinnerService(Context context, Injector injector) {
        super(context);
        this.mPinnedFiles = new ArrayMap();
        this.mPinnedApps = new ArrayMap();
        this.mPendingRepin = new ArrayMap();
        this.mCurrentPinnedMemory = 0;
        this.mPinnerHandler = null;
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mDeviceConfigAnonSizeListener = new AnonymousClass2(this);
        this.mContext = context;
        this.mInjector = injector;
        this.mDeviceConfigInterface = this.mInjector.getDeviceConfigInterface();
        this.mConfiguredToPinCamera = context.getResources().getBoolean(R.bool.config_quickSettingsSupported);
        this.mConfiguredCameraPinBytes = context.getResources().getInteger(R.integer.config_reevaluate_bootstrap_sim_data_usage_millis);
        this.mConfiguredAssistantPinBytes = context.getResources().getInteger(R.integer.config_reduceBrightColorsStrengthMin);
        this.mConfiguredHomePinBytes = context.getResources().getInteger(R.integer.config_requestVibrationParamsTimeout);
        this.mConfiguredToPinAssistant = context.getResources().getBoolean(R.bool.config_quickSettingsShowMediaPlayer);
        this.mConfiguredWebviewPinBytes = context.getResources().getInteger(R.integer.config_respectsActivityMinWidthHeightMultiWindow);
        this.mConfiguredMaxPinnedMemoryPercentage = context.getResources().getInteger(R.integer.config_reservedPrivilegedKeepaliveSlots);
        this.mPinKeys = createPinKeys();
        this.mPinnerHandler = new PinnerHandler(this, BackgroundThread.get().getLooper());
        this.mAtmInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mAm = ActivityManager.getService();
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_REPLACED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiver(this.mBroadcastReceiver, filter);
        registerUidListener();
        registerUserSetupCompleteListener();
        this.mDeviceConfigInterface.addOnPropertiesChangedListener(DEVICE_CONFIG_NAMESPACE_ANON_SIZE, new HandlerExecutor(this.mPinnerHandler), this.mDeviceConfigAnonSizeListener);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.android.server.SystemService
    public void onStart() {
        this.mConfiguredMaxPinnedMemory = (Process.getTotalMemory() * ((long) Math.clamp(this.mConfiguredMaxPinnedMemoryPercentage, 0, 100))) / 100;
        this.mBinderService = new BinderService(this);
        this.mInjector.publishBinderService(this, this.mBinderService);
        publishLocalService(PinnerService.class, this);
        this.mPinnerHandler.obtainMessage(4001).sendToTarget();
        sendPinAppsMessage(0);
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        int userId = to.getUserIdentifier();
        if (this.mUserManager.isManagedProfile(userId) == true) goto L6;
        sendPinAppsMessage(userId);
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        int userId = user.getUserIdentifier();
        if (userId != 0) goto L5;
        return;
    L5:
        if (this.mUserManager.isManagedProfile(userId) == true) goto L9;
        sendPinAppsMessage(userId);
        return;
    }

    public void update(ArraySet<String> updatedPackages, boolean force) {
        ArraySet<Integer> pinKeys = getPinKeys();
        int currentUser = ActivityManager.getCurrentUser();
        int i = pinKeys.size() - 1;
    L3:
        if (i < 0) goto L11;
        int key = pinKeys.valueAt(i).intValue();
        ApplicationInfo info = getInfoForKey(key, currentUser);
        if (info == null) goto L9;
        if (updatedPackages.contains(info.packageName) == false) goto L9;
        Slog.i(TAG, "Updating pinned files for " + info.packageName + " force=" + force);
        sendPinAppMessage(key, currentUser, force);
    L9:
        i = i - 1;
        goto L3
    }

    public List<PinnedFileStats> dumpDataForStatsd() {
        List<PinnedFileStats> pinnedFileStats = new ArrayList();
        monitor-enter(this);
        Iterator<PinnedFile> r1 = this.mPinnedFiles.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        PinnedFile pinnedFile = r1.next();     // Catch: Throwable -> L8
        pinnedFileStats.add(new PinnedFileStats(1000, pinnedFile));     // Catch: Throwable -> L8
        goto L6
    L10:
        Iterator<Integer> r2 = this.mPinnedApps.keySet().iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L18;
        int key = r2.next().intValue();     // Catch: Throwable -> L8
        PinnedApp app = this.mPinnedApps.get(Integer.valueOf(key));     // Catch: Throwable -> L8
        Iterator<PinnedFile> r4 = this.mPinnedApps.get(Integer.valueOf(key)).mFiles.iterator();     // Catch: Throwable -> L8
    L15:
        if (r4.hasNext() == false) goto L12;
        PinnedFile pinnedFile2 = r4.next();     // Catch: Throwable -> L8
        pinnedFileStats.add(new PinnedFileStats(app.uid, pinnedFile2));     // Catch: Throwable -> L8
        goto L15
    L18:
        monitor-exit(this);     // Catch: Throwable -> L8
        return pinnedFileStats;
    L8:
        th = move-exception;
        throw th;
    }

    private void handlePinOnStart() {
        String[] filesToPin = this.mContext.getResources().getStringArray(R.array.config_displayWhiteBalanceAmbientColorTemperatures);
        int r1 = filesToPin.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        String fileToPin = filesToPin[r2];
        pinFile(fileToPin, 2147483647L, null, "system", true);
        r2 = r2 + 1;
        goto L3
    L5:
        refreshPinAnonConfig();
    }

    private void registerUserSetupCompleteListener() {
        final Uri userSetupCompleteUri = android.provider.Settings.Secure.getUriFor("user_setup_complete");
        final Handler r3 = null;
        this.mContext.getContentResolver().registerContentObserver(userSetupCompleteUri, false, new AnonymousClass3(this, r3, userSetupCompleteUri), -1);
    }

    private void registerUidListener() {
        this.mAm.registerUidObserver(new AnonymousClass4(this), 10, 0, null);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to register uid observer", e);
    }

    private void handleUidGone(int uid) {
        updateActiveState(uid, false);
        monitor-enter(this);
        int key = this.mPendingRepin.getOrDefault(Integer.valueOf(uid), -1).intValue();     // Catch: Throwable -> L8
        if (key != (-1)) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPendingRepin.remove(Integer.valueOf(uid));     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        pinApp(key, ActivityManager.getCurrentUser(), false);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handleUidActive(int uid) {
        updateActiveState(uid, true);
    }

    private void updateActiveState(int uid, boolean active) {
        monitor-enter(this);
        int i = this.mPinnedApps.size() - 1;     // Catch: Throwable -> L8
    L4:
        if (i < 0) goto L12;
        PinnedApp app = this.mPinnedApps.valueAt(i);     // Catch: Throwable -> L8
        if (app.uid != uid) goto L10;
        app.active = active;     // Catch: Throwable -> L8
    L10:
        i = i - 1;     // Catch: Throwable -> L8
        goto L4
    L12:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void unpinApps() {
        ArraySet<Integer> pinKeys = getPinKeys();
        int i = pinKeys.size() - 1;
    L3:
        if (i < 0) goto L6;
        int key = pinKeys.valueAt(i).intValue();
        unpinApp(key);
        i = i - 1;
        goto L3
    }

    private void unpinApp(int key) {
        monitor-enter(this);
        PinnedApp app = this.mPinnedApps.get(Integer.valueOf(key));     // Catch: Throwable -> L7
        if (app != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mPinnedApps.remove(Integer.valueOf(key));     // Catch: Throwable -> L7
        ArrayList<PinnedFile> pinnedAppFiles = new ArrayList(app.mFiles);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        Iterator<PinnedFile> r0 = pinnedAppFiles.iterator();
    L13:
        if (r0.hasNext() == false) goto L15;
        PinnedFile pinnedFile = r0.next();
        unpinFile(pinnedFile.fileName);
        goto L13
    L15:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isResolverActivity(ActivityInfo info) {
        return ResolverActivity.class.getName().equals(info.name);
    }

    public int getWebviewPinQuota() {
        int quota = this.mConfiguredWebviewPinBytes;
        int overrideQuota = SystemProperties.getInt("pinner.pin_webview_size", -1);
        if (overrideQuota != (-1)) goto L5;
        return quota;
    L5:
        return overrideQuota;
    }

    private ApplicationInfo getCameraInfo(int userHandle) {
        Intent cameraIntent = new Intent("android.media.action.STILL_IMAGE_CAMERA");
        ApplicationInfo info = getApplicationInfoForIntent(cameraIntent, userHandle, false);
        if (info != null) goto L5;
        Intent cameraIntent2 = new Intent("android.media.action.STILL_IMAGE_CAMERA_SECURE");
        info = getApplicationInfoForIntent(cameraIntent2, userHandle, false);
    L5:
        if (info != null) goto L8;
        Intent cameraIntent3 = new Intent("android.media.action.STILL_IMAGE_CAMERA");
        return getApplicationInfoForIntent(cameraIntent3, userHandle, true);
    L8:
        return info;
    }

    private ApplicationInfo getHomeInfo(int userHandle) {
        Intent intent = this.mAtmInternal.getHomeIntent();
        return getApplicationInfoForIntent(intent, userHandle, false);
    }

    private ApplicationInfo getAssistantInfo(int userHandle) {
        Intent intent = new Intent("android.intent.action.ASSIST");
        return getApplicationInfoForIntent(intent, userHandle, true);
    }

    private ApplicationInfo getApplicationInfoForIntent(Intent intent, int userHandle, boolean defaultToSystemApp) {
        if (intent != null) goto L5;
        return null;
    L5:
        ResolveInfo resolveInfo = this.mContext.getPackageManager().resolveActivityAsUser(intent, MATCH_FLAGS, userHandle);
        if (resolveInfo != null) goto L9;
        return null;
    L9:
        if (isResolverActivity(resolveInfo.activityInfo) == false) goto L11;
        if (defaultToSystemApp == false) goto L23;
        List<ResolveInfo> infoList = this.mContext.getPackageManager().queryIntentActivitiesAsUser(intent, MATCH_FLAGS, userHandle);
        ApplicationInfo systemAppInfo = null;
        Iterator<ResolveInfo> r4 = infoList.iterator();
    L15:
        if (r4.hasNext() == false) goto L22;
        ResolveInfo info = r4.next();
        if ((info.activityInfo.applicationInfo.flags & 1) == 0) goto L15;
        if (systemAppInfo != null) goto L20;
        systemAppInfo = info.activityInfo.applicationInfo;
        goto L15
    L20:
        return null;
    L22:
        return systemAppInfo;
    L23:
        return null;
    L11:
        return resolveInfo.activityInfo.applicationInfo;
    }

    private void sendPinAppsMessage(int userHandle) {
        this.mPinnerHandler.sendMessage(PooledLambda.obtainMessage(new PinnerService$$ExternalSyntheticLambda3(), this, Integer.valueOf(userHandle)));
    }

    private void sendPinAppsWithUpdatedKeysMessage(int userHandle) {
        this.mPinnerHandler.sendMessage(PooledLambda.obtainMessage(new PinnerService$$ExternalSyntheticLambda1(), this, Integer.valueOf(userHandle)));
    }

    private void sendUnpinAppsMessage() {
        this.mPinnerHandler.sendMessage(PooledLambda.obtainMessage(new PinnerService$$ExternalSyntheticLambda0(), this));
    }

    private ArraySet<Integer> createPinKeys() {
        ArraySet<Integer> pinKeys = new ArraySet();
        if (this.mConfiguredToPinCamera == true) goto L5;
    L7:
        boolean shouldPinCamera = false;
    L9:
        if (shouldPinCamera == false) goto L12;
        pinKeys.add(0);
    L12:
        if (this.mConfiguredHomePinBytes <= 0) goto L15;
        pinKeys.add(1);
    L15:
        if (this.mConfiguredToPinAssistant == false) goto L17;
        pinKeys.add(2);
    L17:
        return pinKeys;
    L5:
        if (this.mDeviceConfigInterface.getBoolean("runtime_native_boot", "pin_camera", SystemProperties.getBoolean("pinner.pin_camera", true)) == false) goto L7;
        shouldPinCamera = true;
        goto L9
    }

    private synchronized ArraySet<Integer> getPinKeys() {
        monitor-enter(this);
        ArraySet<Integer> r0 = this.mPinKeys;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private void pinApps(int userHandle) {
        pinAppsInternal(userHandle, false);
    }

    private void pinAppsWithUpdatedKeys(int userHandle) {
        pinAppsInternal(userHandle, true);
    }

    private void pinAppsInternal(int userHandle, boolean updateKeys) {
        if (updateKeys == false) goto L17;
        ArraySet<Integer> newKeys = createPinKeys();
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mPinnedApps.isEmpty() == true) goto L12;
        Slog.e(TAG, "Attempted to update a list of apps, but apps were already pinned. Skipping.");     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.mPinKeys = newKeys;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    L17:
        ArraySet<Integer> currentPinKeys = getPinKeys();
        int i = currentPinKeys.size() - 1;
    L18:
        if (i < 0) goto L21;
        int key = currentPinKeys.valueAt(i).intValue();
        pinApp(key, userHandle, true);
        i = i - 1;
        goto L18
    }

    private void sendPinAppMessage(int key, int userHandle, boolean force) {
        this.mPinnerHandler.sendMessage(PooledLambda.obtainMessage(new PinnerService$$ExternalSyntheticLambda4(), this, Integer.valueOf(key), Integer.valueOf(userHandle), Boolean.valueOf(force)));
    }

    private void pinApp(int key, int userHandle, boolean force) {
        int uid = getUidForKey(key);
        if (force == false) goto L5;
    L13:
        ApplicationInfo info = getInfoForKey(key, userHandle);
        unpinApp(key);
        if (info == null) goto L19;
        pinAppInternal(key, info);
        return;
    L19:
        return;
    L5:
        if (uid == (-1)) goto L13;
        monitor-enter(this);
        this.mPendingRepin.put(Integer.valueOf(uid), Integer.valueOf(key));     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private int getUidForKey(int key) {
        monitor-enter(this);
        PinnedApp existing = this.mPinnedApps.get(Integer.valueOf(key));     // Catch: Throwable -> L8
        if (existing != null) goto L6;
    L10:
        int r1 = -1;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r1;
    L6:
        if (existing.active == false) goto L10;
        r1 = existing.uid;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private ApplicationInfo getInfoForKey(int key, int userHandle) {
        switch(key) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return getAssistantInfo(userHandle);
    L8:
        return getHomeInfo(userHandle);
    L10:
        return getCameraInfo(userHandle);
    }

    private String getNameForKey(int key) {
        switch(key) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "";
    L5:
        return "Assistant";
    L7:
        return "Home";
    L9:
        return "Camera";
    }

    private void refreshPinAnonConfig() {
        long newPinAnonSize = Math.max(0, Math.min(this.mDeviceConfigInterface.getLong(DEVICE_CONFIG_NAMESPACE_ANON_SIZE, DEVICE_CONFIG_KEY_ANON_SIZE, DEFAULT_ANON_SIZE), MAX_ANON_SIZE));
        if (newPinAnonSize == this.mPinAnonSize) goto L6;
        this.mPinAnonSize = newPinAnonSize;
        pinAnonRegion();
        return;
    }

    private void pinAnonRegion() {
        if (this.mPinAnonSize != 0) goto L6;
        Slog.d(TAG, "pinAnonRegion: releasing pinned region");
        unpinAnonRegion();
        return;
    L6:
        long alignedPinSize = this.mPinAnonSize;
        if ((alignedPinSize % ((long) PAGE_SIZE)) == 0) goto L9;
        long alignedPinSize2 = alignedPinSize - (alignedPinSize % ((long) PAGE_SIZE));
        Slog.e(TAG, "pinAnonRegion: aligning size to " + alignedPinSize2);
        long alignedPinSize3 = alignedPinSize2;
    L11:
        if (this.mPinAnonAddress == 0) goto L48;
        if (this.mCurrentlyPinnedAnonSize != alignedPinSize3) goto L16;
        Slog.d(TAG, "pinAnonRegion: already pinned region of size " + alignedPinSize3);
        return;
    L16:
        Slog.d(TAG, "pinAnonRegion: resetting pinned region for new size " + alignedPinSize3);
        unpinAnonRegion();
    L48:
        long address = Os.mmap(0, alignedPinSize3, OsConstants.PROT_READ | OsConstants.PROT_WRITE, OsConstants.MAP_SHARED | OsConstants.MAP_ANONYMOUS, new FileDescriptor(), 0);     // Catch: Throwable -> L24 Exception -> L26
        Unsafe tempUnsafe = null;
        Field[] r8 = Unsafe.class.getDeclaredFields();     // Catch: Throwable -> L24 Exception -> L26
        int r9 = r8.length;     // Catch: Throwable -> L24 Exception -> L26
        int r13 = 0;
    L20:
        if (r13 >= r9) goto L29;
        Field f = r8[r13];     // Catch: Throwable -> L24 Exception -> L26
        f.setAccessible(true);     // Catch: Throwable -> L24 Exception -> L26
        Object obj = f.get(null);     // Catch: Throwable -> L24 Exception -> L26
        if (Unsafe.class.isInstance(obj) == false) goto L28;
        tempUnsafe = (Unsafe) Unsafe.class.cast(obj);     // Catch: Throwable -> L24 Exception -> L26
    L28:
        r13 = r13 + 1;     // Catch: Throwable -> L24 Exception -> L26
        goto L20
    L29:
        if (tempUnsafe == null) goto L36;
        Method setMemory = Unsafe.class.getMethod("setMemory", new Class[]{Long.TYPE, Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L24 Exception -> L26
        setMemory.invoke(tempUnsafe, new Object[]{Long.valueOf(address), Long.valueOf(alignedPinSize3), (byte) 1});     // Catch: Throwable -> L24 Exception -> L26
        Os.mlock(address, alignedPinSize3);     // Catch: Throwable -> L24 Exception -> L26
        this.mCurrentlyPinnedAnonSize = alignedPinSize3;     // Catch: Throwable -> L24 Exception -> L26
        this.mPinAnonAddress = address;     // Catch: Throwable -> L24 Exception -> L26
        Slog.w(TAG, "pinAnonRegion success, size=" + this.mCurrentlyPinnedAnonSize);     // Catch: Throwable -> L24 Exception -> L26
        if ((-1) < 0) goto L52;
        PinnerUtils.safeMunmap(-1, alignedPinSize3);
        return;
    L52:
        return;
    L36:
        throw new Exception("Couldn't get Unsafe");     // Catch: Throwable -> L24 Exception -> L26
    L26:
        ex = move-exception;
        Slog.e(TAG, "Could not pin anon region of size " + alignedPinSize3, ex);     // Catch: Throwable -> L24
        if (0 < 0) goto L53;
        PinnerUtils.safeMunmap(0, alignedPinSize3);
        return;
    L53:
        return;
    L24:
        th = move-exception;
        if (0 < 0) goto L46;
        PinnerUtils.safeMunmap(0, alignedPinSize3);
    L46:
        throw th;
    L9:
        alignedPinSize3 = alignedPinSize;
        goto L11
    }

    private void unpinAnonRegion() {
        if (this.mPinAnonAddress == 0) goto L5;
        PinnerUtils.safeMunmap(this.mPinAnonAddress, this.mCurrentlyPinnedAnonSize);
    L5:
        this.mPinAnonAddress = 0;
        this.mCurrentlyPinnedAnonSize = 0;
    }

    private int getSizeLimitForKey(int key) {
        switch(key) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return 0;
    L6:
        return this.mConfiguredAssistantPinBytes;
    L8:
        return this.mConfiguredHomePinBytes;
    L10:
        return this.mConfiguredCameraPinBytes;
    }

    private long getAvailableGlobalQuota() {
        return this.mConfiguredMaxPinnedMemory - this.mCurrentPinnedMemory;
    }

    private void pinAppInternal(int key, ApplicationInfo appInfo) {
        if (appInfo != null) goto L4;
        return;
    L4:
        PinnedApp pinnedApp = new PinnedApp(this, appInfo, null);
        monitor-enter(this);
        this.mPinnedApps.put(Integer.valueOf(key), pinnedApp);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        int pinSizeLimit = getSizeLimitForKey(key);
        List<String> apks = new ArrayList();
        apks.add(appInfo.sourceDir);
        if (appInfo.splitSourceDirs == null) goto L14;
        String[] r0 = appInfo.splitSourceDirs;
        int r1 = r0.length;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L14;
        String splitApk = r0[r2];
        apks.add(splitApk);
        r2 = r2 + 1;
    L14:
        long apkPinSizeLimit = pinSizeLimit;
        Iterator<String> r11 = apks.iterator();
        long apkPinSizeLimit2 = apkPinSizeLimit;
    L16:
        if (r11.hasNext() == false) goto L30;
        String apk = r11.next();
        if (apkPinSizeLimit2 <= 0) goto L19;
        String pinGroup = getNameForKey(key);
        boolean shouldPinDeps = apk.equals(appInfo.sourceDir);
        PinnedFile pf = pinFile(apk, apkPinSizeLimit2, appInfo, pinGroup, shouldPinDeps);
        if (pf == null) goto L22;
        monitor-enter(this);
        pinnedApp.mFiles.add(pf);     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        apkPinSizeLimit2 = apkPinSizeLimit2 - pf.bytesPinned;
    L27:
        th = move-exception;
        throw th;
    L22:
        Slog.e(TAG, "Failed to pin " + apk);
        goto L16
    L19:
        Slog.w(TAG, "Reached to the pin size limit. Skipping: " + apk);
        goto L16
    L30:
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public PinnedFile pinFile(String fileToPin, long bytesRequestedToPin, ApplicationInfo appInfo, String groupName, boolean pinOptimizedDeps) {
        monitor-enter(this);
        PinnedFile existingPin = this.mPinnedFiles.get(fileToPin);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        if (existingPin != null) goto L9;
    L12:
        long remainingQuota = getAvailableGlobalQuota();
        if (remainingQuota > 0) goto L16;
        Slog.w(TAG, "Reached pin quota, skipping file: " + fileToPin);
        return null;
    L16:
        long bytesRequestedToPin2 = Math.min(bytesRequestedToPin, remainingQuota);
        boolean isApk = fileToPin.endsWith(".apk");
        PinnedFile pf = this.mInjector.pinFileInternal(this, fileToPin, bytesRequestedToPin2, isApk);
        if (pf != null) goto L20;
        Slog.e(TAG, "Failed to pin file = " + fileToPin);
        return null;
    L20:
        if (groupName == null) goto L22;
        String r0 = groupName;
    L23:
        pf.groupName = r0;
        this.mCurrentPinnedMemory += pf.bytesPinned;
        monitor-enter(this);
        this.mPinnedFiles.put(pf.fileName, pf);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        if (pinOptimizedDeps == false) goto L30;
        this.mCurrentPinnedMemory += pinOptimizedDexDependencies(pf, getAvailableGlobalQuota(), appInfo);
    L30:
        return pf;
    L31:
        th = th;
    L47:
        throw th;
    L35:
        th = th;
        goto L47
    L22:
        r0 = "";
        goto L23
    L9:
        if (existingPin.bytesPinned != bytesRequestedToPin) goto L11;
        return null;
    L11:
        unpinFile(fileToPin);
    L37:
        th = th;
    L43:
        throw th;
    L41:
        th = th;
        goto L43
    }

    private long pinOptimizedDexDependencies(PinnedFile pinnedFile, long maxBytesToPin, ApplicationInfo appInfo) {
        if (pinnedFile != null) goto L7;
        return 0;
    L7:
        if ((pinnedFile.fileName.endsWith(".jar") | pinnedFile.fileName.endsWith(".apk")) == false) goto L38;
        String abi = null;
        if (appInfo == null) goto L12;
        abi = appInfo.primaryCpuAbi;
    L12:
        if (abi != null) goto L14;
        String abi2 = Build.SUPPORTED_ABIS[0];
        String abi3 = abi2;
    L15:
        String arch = VMRuntime.getInstructionSet(abi3);
        String[] files = DexFile.getDexFileOutputPaths(pinnedFile.fileName, arch);     // Catch: IOException -> L18
        String[] files2 = files;
    L20:
        if (files2 != null) goto L22;
        return 0;
    L22:
        int r11 = files2.length;
        long bytesPinned = 0;
        int r14 = 0;
        long maxBytesToPin2 = maxBytesToPin;
    L23:
        if (r14 >= r11) goto L46;
        String file = files2[r14];
        unpinFile(file);
        PinnedFile df = this.mInjector.pinFileInternal(this, file, maxBytesToPin2, false);
        if (df == null) goto L26;
        df.groupName = pinnedFile.groupName;
        pinnedFile.pinnedDeps.add(df);
        long maxBytesToPin3 = maxBytesToPin2 - df.bytesPinned;
        long maxBytesToPin4 = df.bytesPinned;
        long bytesPinned2 = maxBytesToPin4 + bytesPinned;
        monitor-enter(this);
        this.mPinnedFiles.put(df.fileName, df);     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        r14 = r14 + 1;     // Catch: Throwable -> L33
        bytesPinned = bytesPinned2;
        maxBytesToPin2 = maxBytesToPin3;
    L33:
        th = move-exception;
        throw th;
    L26:
        Slog.i(TAG, "Failed to pin ART file = " + file);
        return bytesPinned;
    L46:
        return bytesPinned;
    L19:
        files2 = null;
        goto L20
    L14:
        abi3 = abi;
        goto L15
    L38:
        return 0;
    }

    private PinnedFile pinFileInternal(String fileToPin, long maxBytesToPin, boolean attemptPinIntrospection) {
        ZipFile fileAsZip = null;
        InputStream pinRangeStream = null;
        if (attemptPinIntrospection == true) goto L23;
    L7:
        if (fileAsZip == null) goto L10;
        pinRangeStream = maybeOpenPinMetaInZip(fileAsZip, fileToPin);     // Catch: Throwable -> L5
    L10:
        if (pinRangeStream == null) goto L12;
        boolean use_pinlist = true;
    L13:
        if (use_pinlist == false) goto L15;
        PinRangeSource pinRangeSource = new PinRangeSourceStream(pinRangeStream);     // Catch: Throwable -> L5
    L16:
        PinnedFile pinnedFile = pinFileRanges(fileToPin, maxBytesToPin, pinRangeSource);     // Catch: Throwable -> L5
        if (pinnedFile == null) goto L19;
        pinnedFile.used_pinlist = use_pinlist;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        PinnerUtils.safeClose(pinRangeStream);
        PinnerUtils.safeClose(fileAsZip);
        throw th;
    L19:
        PinnerUtils.safeClose(pinRangeStream);
        PinnerUtils.safeClose(fileAsZip);
        return pinnedFile;
    L15:
        pinRangeSource = new PinRangeSourceStatic(0, Integer.MAX_VALUE);     // Catch: Throwable -> L5
        goto L16
    L12:
        use_pinlist = false;
        goto L13
    L23:
        fileAsZip = maybeOpenZip(fileToPin);     // Catch: Throwable -> L5
        goto L7
    }

    private static ZipFile maybeOpenZip(String fileName) {
        ZipFile zip = new ZipFile(fileName);     // Catch: IOException -> L5
        return zip;
    L5:
        ex = move-exception;
        Slog.w(TAG, String.format("could not open \"%s\" as zip: pinning as blob", new Object[]{fileName}), ex);
        return null;
    }

    private static InputStream maybeOpenPinMetaInZip(ZipFile zipFile, String fileName) {
        if (PROP_PIN_PINLIST == true) goto L6;
        return null;
    L6:
        ZipEntry pinMetaEntry = zipFile.getEntry(PIN_META_FILENAME);
        if (pinMetaEntry != null) goto L10;
        pinMetaEntry = zipFile.getEntry("assets/pinlist.meta");
    L10:
        if (pinMetaEntry != null) goto L18;
        Slog.w(TAG, String.format("Could not find pinlist.meta for \"%s\": pinning as blob", new Object[]{fileName}));
        return null;
    L18:
        InputStream pinMetaStream = zipFile.getInputStream(pinMetaEntry);     // Catch: IOException -> L14
        return pinMetaStream;
    L14:
        ex = move-exception;
        Slog.w(TAG, String.format("error reading pin metadata \"%s\": pinning as blob", new Object[]{fileName}), ex);
        return null;
    }

    private static PinnedFile pinFileRanges(String fileToPin, long maxBytesToPin, PinRangeSource pinRangeSource) {
        FileDescriptor fd = new FileDescriptor();
        long address = -1;
        long mapSize = 0;
        long r8 = 0;
        int openFlags = OsConstants.O_RDONLY | OsConstants.O_CLOEXEC;     // Catch: Throwable -> L79 ErrnoException -> L81
        FileDescriptor fd2 = Os.open(fileToPin, openFlags, 0);     // Catch: Throwable -> L79 ErrnoException -> L81
    L115:
        long pinStart = (int) Math.min(Os.fstat(fd2).st_size, 2147483647L);
        long address2 = Os.mmap(0, pinStart, OsConstants.PROT_READ, OsConstants.MAP_SHARED, fd2, 0);     // Catch: Throwable -> L71 ErrnoException -> L73
        PinRange pinRange = new PinRange();     // Catch: Throwable -> L67 ErrnoException -> L69
        long bytesPinned = 0;
    L11:
        if ((maxBytesToPin % ((long) PAGE_SIZE)) != 0) goto L109;
        long maxBytesToPin2 = maxBytesToPin;
    L20:
        if (bytesPinned >= maxBytesToPin2) goto L54;
    L52:
        ex = e;
        long r26 = r8;
        mapSize = pinStart;
        address = address2;
        fd = fd2;
    L95:
        Slog.e(TAG, "Could not pin file " + fileToPin, ex);     // Catch: Throwable -> L90
        PinnerUtils.safeClose(fd);
        if (address < r26) goto L122;
        PinnerUtils.safeMunmap(address, mapSize);
        return null;
    L122:
        return null;
    L90:
        ex = th;
    L91:
        PinnerUtils.safeClose(fd);
        if (address < r26) goto L94;
        PinnerUtils.safeMunmap(address, mapSize);
    L94:
        throw ex;
    L50:
        ex = th;
        r26 = r8;
        mapSize = pinStart;
        address = address2;
        fd = fd2;
        goto L91
    L23:
        if (pinRangeSource.read(pinRange) == false) goto L54;
        long pinStart2 = pinRange.start;     // Catch: Throwable -> L50 ErrnoException -> L52
        r26 = r8;
        long pinLength = pinRange.length;     // Catch: Throwable -> L50 ErrnoException -> L52
        long mapSize2 = pinStart;
        long pinStart3 = PinnerUtils.clamp(0, pinStart2, mapSize2);     // Catch: Throwable -> L46 ErrnoException -> L48
        pinStart = mapSize2;
        long address3 = address2;
        PinRange pinRange2 = pinRange;
        long pinLength2 = Math.min(maxBytesToPin2 - bytesPinned, PinnerUtils.clamp(0, pinLength, pinStart - pinStart3)) + (pinStart3 % ((long) PAGE_SIZE));     // Catch: Throwable -> L33 ErrnoException -> L35
        long pinStart4 = pinStart3 - (pinStart3 % ((long) PAGE_SIZE));     // Catch: Throwable -> L33 ErrnoException -> L35
        if ((pinLength2 % ((long) PAGE_SIZE)) == r26) goto L37;
        long r9 = PAGE_SIZE;     // Catch: Throwable -> L33 ErrnoException -> L35
        long pinLength3 = PAGE_SIZE;     // Catch: Throwable -> L33 ErrnoException -> L35
        long pinLength4 = pinLength2 + (r9 - (pinLength2 % pinLength3));     // Catch: Throwable -> L33 ErrnoException -> L35
    L38:
        long pinLength5 = PinnerUtils.clamp(0, pinLength4, maxBytesToPin2 - bytesPinned);     // Catch: Throwable -> L33 ErrnoException -> L35
        if (pinLength5 <= r26) goto L41;
        Os.mlock(address3 + pinStart4, pinLength5);     // Catch: Throwable -> L33 ErrnoException -> L35
    L41:
        bytesPinned = bytesPinned + pinLength5;     // Catch: Throwable -> L33 ErrnoException -> L35
        pinRange = pinRange2;
        address2 = address3;
        r8 = r26;
        goto L20
    L37:
        pinLength4 = pinLength2;
    L35:
        ex = e;
        mapSize = pinStart;
        address = address3;
        fd = fd2;
    L33:
        ex = th;
        mapSize = pinStart;
        address = address3;
        fd = fd2;
        goto L91
    L44:
        ex = e;
        mapSize = pinStart;
        address = address2;
        fd = fd2;
    L42:
        ex = th;
        mapSize = pinStart;
        address = address2;
        fd = fd2;
        goto L91
    L48:
        ex = e;
        mapSize = mapSize2;
        address = address2;
        fd = fd2;
    L46:
        ex = th;
        mapSize = mapSize2;
        address = address2;
        fd = fd2;
        goto L91
    L54:
        address3 = address2;
        r26 = r8;
        long mapSize3 = pinStart;
        PinnedFile pinnedFile = new PinnedFile(address3, mapSize3, fileToPin, bytesPinned);     // Catch: Throwable -> L63 ErrnoException -> L65
        PinnerUtils.safeClose(fd2);
        if ((-1) < r26) goto L62;
        PinnerUtils.safeMunmap(-1, pinStart);
    L62:
        return pinnedFile;
    L65:
        ex = e;
        mapSize = mapSize3;
        address = address3;
        fd = fd2;
    L63:
        ex = th;
        mapSize = mapSize3;
        address = address3;
        fd = fd2;
        goto L91
    L109:
        maxBytesToPin2 = maxBytesToPin - (maxBytesToPin % ((long) PAGE_SIZE));
        goto L20
    L16:
        ex = e;
        address = address2;
        r26 = 0;
        mapSize = pinStart;
        fd = fd2;
    L14:
        ex = th;
        address = address2;
        r26 = 0;
        mapSize = pinStart;
        fd = fd2;
    L69:
        ex = e;
        r26 = 0;
        mapSize = pinStart;
        address = address2;
        fd = fd2;
    L67:
        ex = th;
        r26 = 0;
        mapSize = pinStart;
        address = address2;
        fd = fd2;
        goto L91
    L73:
        ex = e;
        r26 = 0;
        mapSize = pinStart;
        fd = fd2;
    L71:
        ex = th;
        r26 = 0;
        mapSize = pinStart;
        fd = fd2;
        goto L91
    L77:
        ex = e;
        r26 = 0;
        fd = fd2;
    L75:
        ex = th;
        r26 = 0;
        fd = fd2;
    L81:
        ex = e;
        r26 = 0;
    L79:
        ex = th;
        r26 = 0;
        goto L91
    }

    private List<PinnedFile> getAllPinsForGroup(final String group) {
        monitor-enter(this);
        List<PinnedFile> filesInGroup = this.mPinnedFiles.values().stream().filter(new PinnerService$$ExternalSyntheticLambda2(group)).toList();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return filesInGroup;
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getAllPinsForGroup$0(String group, PinnedFile pf) {
        return pf.groupName.equals(group);
    }

    public void unpinGroup(String group) {
        List<PinnedFile> pinnedFiles = getAllPinsForGroup(group);
        Iterator<PinnedFile> r1 = pinnedFiles.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PinnedFile pf = r1.next();
        unpinFile(pf.fileName);
        goto L4
    }

    public long unpinFile(String filename) {
        monitor-enter(this);
        PinnedFile pinnedFile = this.mPinnedFiles.get(filename);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (pinnedFile != null) goto L8;
        return 0;
    L8:
        long unpinnedBytes = pinnedFile.bytesPinned;
        pinnedFile.close();
        monitor-enter(this);
        this.mCurrentPinnedMemory -= pinnedFile.bytesPinned;     // Catch: Throwable -> L17
        this.mPinnedFiles.remove(pinnedFile.fileName);     // Catch: Throwable -> L17
        Iterator<PinnedFile> r3 = pinnedFile.pinnedDeps.iterator();     // Catch: Throwable -> L17
    L12:
        if (r3.hasNext() == false) goto L19;
        PinnedFile dep = r3.next();     // Catch: Throwable -> L17
        if (dep == null) goto L12;
        unpinnedBytes = unpinnedBytes - dep.bytesPinned;     // Catch: Throwable -> L17
        this.mCurrentPinnedMemory -= dep.bytesPinned;     // Catch: Throwable -> L17
        this.mPinnedFiles.remove(dep.fileName);     // Catch: Throwable -> L17
        goto L12
    L19:
        monitor-exit(this);     // Catch: Throwable -> L17
        return unpinnedBytes;
    L17:
        th = move-exception;
        throw th;
    L23:
        th = move-exception;
        throw th;
    }

    public List<PinnedFileStat> getPinnerStats() {
        ArrayList<PinnedFileStat> stats = new ArrayList();
        monitor-enter(this);
        Collection<PinnedFile> pinnedFiles = this.mPinnedFiles.values();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        Iterator<PinnedFile> r2 = pinnedFiles.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        PinnedFile pf = r2.next();
        PinnedFileStat stat = new PinnedFileStat(pf.fileName, pf.bytesPinned, pf.groupName);
        stats.add(stat);
        goto L8
    L11:
        if (this.mCurrentlyPinnedAnonSize <= 0) goto L13;
        stats.add(new PinnedFileStat(ANON_REGION_STAT_NAME, this.mCurrentlyPinnedAnonSize, ANON_REGION_STAT_NAME));
    L13:
        return stats;
    L14:
        th = move-exception;
        throw th;
    }
}
