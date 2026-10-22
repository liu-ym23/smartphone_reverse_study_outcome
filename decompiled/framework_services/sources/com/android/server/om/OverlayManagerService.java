package com.android.server.om;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.IActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.om.IOverlayManager;
import android.content.om.OverlayConstraint;
import android.content.om.OverlayIdentifier;
import android.content.om.OverlayInfo;
import android.content.om.OverlayManagerTransaction;
import android.content.om.OverlayableInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.content.pm.UserPackage;
import android.content.pm.overlay.OverlayPaths;
import android.content.res.ApkAssets;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FabricatedOverlayInternal;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.EventLog;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.content.PackageMonitor;
import com.android.internal.content.om.OverlayConfig;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.AndroidPackageSplit;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import libcore.util.EmptyArray;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class OverlayManagerService extends SystemService {
    static final boolean DEBUG = false;
    private static final String DEFAULT_OVERLAYS_PROP = "ro.boot.vendor.overlay.theme";
    static final String TAG = "OverlayManager";
    private final OverlayActorEnforcer mActorEnforcer;
    private final OverlayManagerServiceImpl mImpl;
    private final Object mLock;
    private final PackageManagerHelperImpl mPackageManager;
    private final PackageMonitor mPackageMonitor;
    private int mPrevStartedUserId;
    private final IBinder mService;
    private final OverlayManagerSettings mSettings;
    private final AtomicFile mSettingsFile;
    private final UserManagerService mUserManager;

    /* JADX INFO: renamed from: com.android.server.om.OverlayManagerService$1, reason: invalid class name */
    class AnonymousClass1 extends IOverlayManager.Stub {
        final /* synthetic */ OverlayManagerService this$0;

        public static /* synthetic */ void $r8$lambda$brKP91vTER4zoSOxWJ1OnJjU4jQ(OverlayManagerService r0, UserPackage r1) {
            OverlayManagerService.m6348$$Nest$mupdateTargetPackagesLocked(r0, r1);
        }

        AnonymousClass1(OverlayManagerService this$0) {
            this.this$0 = this$0;
        }

        public Map<String, List<OverlayInfo>> getAllOverlays(int userIdArg) {
            Trace.traceBegin(67108864, "OMS#getAllOverlays " + userIdArg);     // Catch: Throwable -> L12
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "getAllOverlays");     // Catch: Throwable -> L12
            Object r3 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            Map<String, List<OverlayInfo>> r4 = OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).getOverlaysForUser(realUserId);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Trace.traceEnd(67108864);
            return r4;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        public List<OverlayInfo> getOverlayInfosForTarget(String targetPackageName, int userIdArg) {
            if (targetPackageName != null) goto L20;
            return Collections.emptyList();
        L20:
            Trace.traceBegin(67108864, "OMS#getOverlayInfosForTarget " + targetPackageName);     // Catch: Throwable -> L15
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "getOverlayInfosForTarget");     // Catch: Throwable -> L15
            Object r3 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r3);     // Catch: Throwable -> L15
            List<OverlayInfo> r4 = OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).getOverlayInfosForTarget(targetPackageName, realUserId);     // Catch: Throwable -> L12
            monitor-exit(r3);     // Catch: Throwable -> L12
            Trace.traceEnd(67108864);
            return r4;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        public OverlayInfo getOverlayInfo(String packageName, int userIdArg) {
            return getOverlayInfoByIdentifier(new OverlayIdentifier(packageName), userIdArg);
        }

        public OverlayInfo getOverlayInfoByIdentifier(OverlayIdentifier overlay, int userIdArg) {
            if (overlay != null) goto L4;
            return null;
        L4:
            if (overlay.getPackageName() != null) goto L23;
            return null;
        L23:
            Trace.traceBegin(67108864, "OMS#getOverlayInfo " + overlay);     // Catch: Throwable -> L16
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "getOverlayInfo");     // Catch: Throwable -> L16
            Object r3 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r3);     // Catch: Throwable -> L16
            OverlayInfo r4 = OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).getOverlayInfo(overlay, realUserId);     // Catch: Throwable -> L13
            monitor-exit(r3);     // Catch: Throwable -> L13
            Trace.traceEnd(67108864);
            return r4;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        public boolean setEnabled(String packageName, boolean enable, int userIdArg) {
            return setEnabled(packageName, enable, userIdArg, Collections.emptyList());
        }

        public boolean enableWithConstraints(String packageName, int userIdArg, List<OverlayConstraint> constraints) {
            return setEnabled(packageName, true, userIdArg, constraints);
        }

        private boolean setEnabled(String packageName, boolean enable, int userIdArg, List<OverlayConstraint> constraints) {
            if (packageName != null) goto L31;
            return false;
        L31:
            Trace.traceBegin(67108864, "OMS#setEnabled " + packageName + " " + enable);     // Catch: Throwable -> L14
            OverlayIdentifier overlay = new OverlayIdentifier(packageName);     // Catch: Throwable -> L14
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "setEnabled");     // Catch: Throwable -> L14
            enforceActor(overlay, "setEnabled", realUserId);     // Catch: Throwable -> L14
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
            Object r7 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r7);     // Catch: Throwable -> L25
            OverlayManagerService.m6349$$Nest$mupdateTargetPackagesLocked(this.this$0, OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setEnabled(overlay, enable, realUserId, constraints));     // Catch: Throwable -> L16 OverlayManagerServiceImpl.OperationFailedException -> L18
            monitor-exit(r7);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            Trace.traceEnd(67108864);
            return true;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L20:
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            Trace.traceEnd(67108864);
            return false;
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        public boolean setEnabledExclusive(String packageName, boolean enable, int userIdArg) {
            if (packageName == null) goto L31;
            if (enable == false) goto L31;
            Trace.traceBegin(67108864, "OMS#setEnabledExclusive " + packageName + " " + enable);     // Catch: Throwable -> L15
            OverlayIdentifier overlay = new OverlayIdentifier(packageName);     // Catch: Throwable -> L15
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "setEnabledExclusive");     // Catch: Throwable -> L15
            enforceActor(overlay, "setEnabledExclusive", realUserId);     // Catch: Throwable -> L15
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L15
            Object r7 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L26
            monitor-enter(r7);     // Catch: Throwable -> L26
            OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setEnabledExclusive(overlay, false, realUserId).ifPresent(new OverlayManagerService$1$$ExternalSyntheticLambda0(this.this$0));     // Catch: Throwable -> L17 OverlayManagerServiceImpl.OperationFailedException -> L19
            monitor-exit(r7);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L15
            Trace.traceEnd(67108864);
            return true;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L21:
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L15
            Trace.traceEnd(67108864);
            return false;
        L26:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L15
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        L31:
            return false;
        }

        public boolean setEnabledExclusiveInCategory(String packageName, int userIdArg) {
            if (packageName != null) goto L31;
            return false;
        L31:
            Trace.traceBegin(67108864, "OMS#setEnabledExclusiveInCategory " + packageName);     // Catch: Throwable -> L14
            OverlayIdentifier overlay = new OverlayIdentifier(packageName);     // Catch: Throwable -> L14
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "setEnabledExclusiveInCategory");     // Catch: Throwable -> L14
            enforceActor(overlay, "setEnabledExclusiveInCategory", realUserId);     // Catch: Throwable -> L14
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
            Object r7 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r7);     // Catch: Throwable -> L25
            OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setEnabledExclusive(overlay, true, realUserId).ifPresent(new OverlayManagerService$1$$ExternalSyntheticLambda0(this.this$0));     // Catch: Throwable -> L16 OverlayManagerServiceImpl.OperationFailedException -> L18
            monitor-exit(r7);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            Trace.traceEnd(67108864);
            return true;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L20:
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            Trace.traceEnd(67108864);
            return false;
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        public boolean setPriority(String packageName, String parentPackageName, int userIdArg) {
            if (packageName == null) goto L31;
            if (parentPackageName == null) goto L31;
            Trace.traceBegin(67108864, "OMS#setPriority " + packageName + " " + parentPackageName);     // Catch: Throwable -> L15
            OverlayIdentifier overlay = new OverlayIdentifier(packageName);     // Catch: Throwable -> L15
            OverlayIdentifier parentOverlay = new OverlayIdentifier(parentPackageName);     // Catch: Throwable -> L15
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "setPriority");     // Catch: Throwable -> L15
            enforceActor(overlay, "setPriority", realUserId);     // Catch: Throwable -> L15
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L15
            Object r8 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L26
            monitor-enter(r8);     // Catch: Throwable -> L26
            OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setPriority(overlay, parentOverlay, realUserId).ifPresent(new OverlayManagerService$1$$ExternalSyntheticLambda0(this.this$0));     // Catch: Throwable -> L17 OverlayManagerServiceImpl.OperationFailedException -> L19
            monitor-exit(r8);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L15
            Trace.traceEnd(67108864);
            return true;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L21:
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L15
            Trace.traceEnd(67108864);
            return false;
        L26:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L15
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        L31:
            return false;
        }

        public boolean setHighestPriority(String packageName, int userIdArg) {
            if (packageName != null) goto L31;
            return false;
        L31:
            Trace.traceBegin(67108864, "OMS#setHighestPriority " + packageName);     // Catch: Throwable -> L14
            OverlayIdentifier overlay = new OverlayIdentifier(packageName);     // Catch: Throwable -> L14
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "setHighestPriority");     // Catch: Throwable -> L14
            enforceActor(overlay, "setHighestPriority", realUserId);     // Catch: Throwable -> L14
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
            Object r7 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r7);     // Catch: Throwable -> L25
            OverlayManagerService.m6349$$Nest$mupdateTargetPackagesLocked(this.this$0, OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setHighestPriority(overlay, realUserId));     // Catch: Throwable -> L16 OverlayManagerServiceImpl.OperationFailedException -> L18
            monitor-exit(r7);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            Trace.traceEnd(67108864);
            return true;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L20:
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            Trace.traceEnd(67108864);
            return false;
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        public boolean setLowestPriority(String packageName, int userIdArg) {
            if (packageName != null) goto L31;
            return false;
        L31:
            Trace.traceBegin(67108864, "OMS#setLowestPriority " + packageName);     // Catch: Throwable -> L14
            OverlayIdentifier overlay = new OverlayIdentifier(packageName);     // Catch: Throwable -> L14
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "setLowestPriority");     // Catch: Throwable -> L14
            enforceActor(overlay, "setLowestPriority", realUserId);     // Catch: Throwable -> L14
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
            Object r7 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r7);     // Catch: Throwable -> L25
            OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setLowestPriority(overlay, realUserId).ifPresent(new OverlayManagerService$1$$ExternalSyntheticLambda0(this.this$0));     // Catch: Throwable -> L16 OverlayManagerServiceImpl.OperationFailedException -> L18
            monitor-exit(r7);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            Trace.traceEnd(67108864);
            return true;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L20:
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            Trace.traceEnd(67108864);
            return false;
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        public String[] getDefaultOverlayPackages() {
            Trace.traceBegin(67108864, "OMS#getDefaultOverlayPackages");     // Catch: Throwable -> L11
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.MODIFY_THEME_OVERLAY", null);     // Catch: Throwable -> L11
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
            Object r4 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            String[] r5 = OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).getDefaultOverlayPackages();     // Catch: Throwable -> L13
            monitor-exit(r4);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L11
            Trace.traceEnd(67108864);
            return r5;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        public void invalidateCachesForOverlay(String packageName, int userIdArg) {
            if (packageName != null) goto L4;
            return;
        L4:
            OverlayIdentifier overlay = new OverlayIdentifier(packageName);
            int realUserId = OverlayManagerService.handleIncomingUser(userIdArg, "invalidateCachesForOverlay");
            enforceActor(overlay, "invalidateCachesForOverlay", realUserId);
            long ident = Binder.clearCallingIdentity();
            Object r4 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L18
            monitor-enter(r4);     // Catch: Throwable -> L18
            OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).removeIdmapForOverlay(overlay, realUserId);     // Catch: Throwable -> L9 OverlayManagerServiceImpl.OperationFailedException -> L11
        L13:
            monitor-exit(r4);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L11:
            e = move-exception;
            Slog.w(OverlayManagerService.TAG, "invalidate caches for overlay '" + overlay + "' failed", e);     // Catch: Throwable -> L9
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void commit(OverlayManagerTransaction transaction) throws RemoteException {
            Trace.traceBegin(67108864, "OMS#commit " + transaction);     // Catch: Throwable -> L25
            Object r2 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r2);     // Catch: Throwable -> L25
            executeAllRequestsLocked(transaction);     // Catch: Throwable -> L9 Exception -> L11
            monitor-exit(r2);     // Catch: Throwable -> L9
            Trace.traceEnd(67108864);
            return;
        L11:
            e = move-exception;
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            OverlayManagerService.m6346$$Nest$mrestoreSettingsLocked(this.this$0);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L9
            Slog.d(OverlayManagerService.TAG, "commit failed: " + e.getMessage(), e);     // Catch: Throwable -> L9
            StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L9
            r7.append("commit failed");     // Catch: Throwable -> L9
            if (Build.IS_DEBUGGABLE == false) goto L17;
            String r8 = ": " + e.getMessage();     // Catch: Throwable -> L9
        L18:
            r7.append(r8);     // Catch: Throwable -> L9
            throw new SecurityException(r7.toString());     // Catch: Throwable -> L9
        L17:
            r8 = "";
            goto L18
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }

        private Set<UserPackage> executeRequestLocked(OverlayManagerTransaction.Request request) throws OverlayManagerServiceImpl.OperationFailedException {
            request.getClass();
            request.overlay.getClass();
            int callingUid = Binder.getCallingUid();
            if (request.type == 2) goto L9;
            if (request.type == 3) goto L9;
            int realUserId = OverlayManagerService.handleIncomingUser(request.userId, request.typeToString());
            enforceActor(request.overlay, request.typeToString(), realUserId);
        L20:
            long ident = Binder.clearCallingIdentity();
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L22:
            switch(request.type) {
                case 0: goto L37;
                case 1: goto L33;
                case 2: goto L30;
                case 3: goto L27;
                default: goto L24;
            };     // Catch: Throwable -> L25
        L27:
            Set<UserPackage> r4 = OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).unregisterFabricatedOverlay(request.overlay);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(ident);
            return r4;
        L30:
            FabricatedOverlayInternal fabricated = (FabricatedOverlayInternal) request.extras.getParcelable("fabricated_overlay", FabricatedOverlayInternal.class);     // Catch: Throwable -> L25
            fabricated.getClass();     // Catch: Throwable -> L25
            Set<UserPackage> r5 = OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).registerFabricatedOverlay(fabricated);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(ident);
            return r5;
        L33:
            Set<UserPackage> r6 = OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setEnabled(request.overlay, false, realUserId, request.constraints);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(ident);
            return r6;
        L24:
            throw new IllegalArgumentException("unsupported request: " + request);     // Catch: Throwable -> L25
        L37:
            Set<UserPackage> result = CollectionUtils.addAll(null, OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setEnabled(request.overlay, true, realUserId, request.constraints));     // Catch: Throwable -> L25
            Set<UserPackage> result2 = CollectionUtils.emptyIfNull(CollectionUtils.addAll(result, OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).setHighestPriority(request.overlay, realUserId)));     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(ident);
            return result2;
        L9:
            if (request.userId != (-1)) goto L45;
            if (callingUid == 2000) goto L42;
            realUserId = -1;
            String pkgName = request.overlay.getPackageName();
            if (callingUid == 0) goto L20;
            if (ArrayUtils.contains(OverlayManagerService.m6342$$Nest$fgetmPackageManager(this.this$0).getPackagesForUid(callingUid), pkgName) == true) goto L20;
            throw new IllegalArgumentException("UID " + callingUid + " does not own packageName " + pkgName);
        L42:
            EventLog.writeEvent(1397638484, new Object[]{"202768292", -1, ""});
            throw new IllegalArgumentException("Non-root shell cannot fabricate overlays");
        L45:
            throw new IllegalArgumentException(request.typeToString() + " unsupported for user " + request.userId);
        }

        private void executeAllRequestsLocked(OverlayManagerTransaction transaction) throws OverlayManagerServiceImpl.OperationFailedException {
            Set<UserPackage> affectedPackagesToUpdate = null;
            Iterator<OverlayManagerTransaction.Request> it = transaction.getRequests();
        L4:
            if (it.hasNext() == false) goto L6;
            OverlayManagerTransaction.Request request = it.next();
            affectedPackagesToUpdate = CollectionUtils.addAll(affectedPackagesToUpdate, executeRequestLocked(request));
            goto L4
        L6:
            long ident = Binder.clearCallingIdentity();
            OverlayManagerService.m6349$$Nest$mupdateTargetPackagesLocked(this.this$0, affectedPackagesToUpdate);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(ident);
            return;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new OverlayManagerShellCommand(this.this$0.getContext(), this).exec(this, in, out, err, args, callback, resultReceiver);
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            DumpState dumpState = new DumpState();
            int userId = -1;
            int opti = 0;
        L3:
            byte r4 = 0;
            if (opti >= args.length) goto L36;
            String opt = args[opti];
            if (opt == null) goto L36;
            if (opt.length() <= 0) goto L36;
            if (opt.charAt(0) != '-') goto L36;
            opti = opti + 1;
            if ("-a".equals(opt) == true) goto L3;
            if ("-h".equals(opt) == true) goto L17;
            if ("--user".equals(opt) == true) goto L22;
            if ("--verbose".equals(opt) == true) goto L32;
            pw.println("Unknown argument: " + opt + "; use -h for help");
            goto L3
        L32:
            dumpState.setVerbose(true);
            goto L3
        L22:
            if (opti >= args.length) goto L23;
            int userId2 = UserHandle.parseUserArg(args[opti]);     // Catch: Exception -> L27
            opti = opti + 1;
            userId = userId2;
        L27:
            e = move-exception;
            pw.println("Error: " + e.getMessage());
            return;
        L23:
            pw.println("Error: user missing argument");
            return;
        L17:
            pw.println("dump [-h] [--verbose] [--user USER_ID] [[FIELD] PACKAGE]");
            pw.println("  Print debugging information about the overlay manager.");
            pw.println("  With optional parameter PACKAGE, limit output to the specified");
            pw.println("  package. With optional parameter FIELD, limit output to");
            pw.println("  the value of that SettingsItem field. Field names are");
            pw.println("  case insensitive and out.println the m prefix can be omitted,");
            pw.println("  so the following are equivalent: mState, mstate, State, state.");
            return;
        L36:
            if (opti >= args.length) goto L75;
            String arg = args[opti];
            opti = opti + 1;
            switch(arg.hashCode()) {
                case -1750736508: goto L68;
                case -1248283232: goto L65;
                case -1165461084: goto L62;
                case -836029914: goto L59;
                case -831052100: goto L56;
                case 50511102: goto L53;
                case 109757585: goto L50;
                case 440941271: goto L47;
                case 909712337: goto L44;
                case 1693907299: goto L41;
                default: goto L70;
            };
        L70:
            r4 = -1;
        L71:
            switch(r4) {
                case 0: goto L73;
                case 1: goto L73;
                case 2: goto L73;
                case 3: goto L73;
                case 4: goto L73;
                case 5: goto L73;
                case 6: goto L73;
                case 7: goto L73;
                case 8: goto L73;
                case 9: goto L73;
                default: goto L72;
            };
        L72:
            dumpState.setOverlyIdentifier(arg);
            goto L75
        L73:
            dumpState.setField(arg);
            goto L75
        L41:
            if (arg.equals("basecodepath") == false) goto L114;
            r4 = 4;
            goto L71
        L114:
            r4 = -1;
            goto L71
        L44:
            if (arg.equals("packagename") == true) goto L71;
            r4 = -1;
            goto L71
        L47:
            if (arg.equals("isenabled") == false) goto L116;
            r4 = 6;
            goto L71
        L116:
            r4 = -1;
            goto L71
        L50:
            if (arg.equals("state") == false) goto L117;
            r4 = 5;
            goto L71
        L117:
            r4 = -1;
            goto L71
        L53:
            if (arg.equals("category") == false) goto L118;
            r4 = 9;
            goto L71
        L118:
            r4 = -1;
            goto L71
        L56:
            if (arg.equals("ismutable") == false) goto L119;
            r4 = 7;
            goto L71
        L119:
            r4 = -1;
            goto L71
        L59:
            if (arg.equals("userid") == false) goto L120;
            r4 = 1;
            goto L71
        L120:
            r4 = -1;
            goto L71
        L62:
            if (arg.equals("priority") == false) goto L121;
            r4 = 8;
            goto L71
        L121:
            r4 = -1;
            goto L71
        L65:
            if (arg.equals("targetpackagename") == false) goto L122;
            r4 = 2;
            goto L71
        L122:
            r4 = -1;
            goto L71
        L68:
            if (arg.equals("targetoverlayablename") == false) goto L123;
            r4 = 3;
            goto L71
        L123:
            r4 = -1;
        L75:
            if (dumpState.getPackageName() == null) goto L77;
        L79:
            enforceDumpPermission(ArchiveStreamFactory.DUMP);
            if (userId == (-1)) goto L82;
            int realUserId = OverlayManagerService.handleIncomingUser(userId, ArchiveStreamFactory.DUMP);
        L83:
            dumpState.setUserId(realUserId);
            Object r5 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);
            monitor-enter(r5);
            OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).dump(pw, dumpState);     // Catch: Throwable -> L88
            if (dumpState.getPackageName() != null) goto L90;
            OverlayManagerService.m6342$$Nest$fgetmPackageManager(this.this$0).dump(pw, dumpState);     // Catch: Throwable -> L88
        L90:
            monitor-exit(r5);     // Catch: Throwable -> L88
            return;
        L88:
            th = move-exception;
            throw th;
        L82:
            realUserId = userId;
            goto L83
        L77:
            if (opti >= args.length) goto L79;
            dumpState.setOverlyIdentifier(args[opti]);
            int r2 = opti + 1;
            goto L79
        }

        private void enforceDumpPermission(String message) {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.DUMP", message);
        }

        private void enforceActor(OverlayIdentifier overlay, String methodName, int realUserId) throws SecurityException {
            OverlayInfo overlayInfo = OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).getOverlayInfo(overlay, realUserId);
            if (overlayInfo == null) goto L7;
            int callingUid = Binder.getCallingUid();
            OverlayManagerService.m6339$$Nest$fgetmActorEnforcer(this.this$0).enforceActor(overlayInfo, methodName, callingUid, realUserId);
            return;
        L7:
            throw new IllegalArgumentException("Unable to retrieve overlay information for " + overlay);
        }

        public String getPartitionOrder() {
            return OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).getOverlayConfig().getPartitionOrder();
        }

        public boolean isDefaultPartitionOrder() {
            return OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).getOverlayConfig().isDefaultPartitionOrder();
        }
    }

    private final class OverlayManagerPackageMonitor extends PackageMonitor {
        final /* synthetic */ OverlayManagerService this$0;

        /* synthetic */ OverlayManagerPackageMonitor(OverlayManagerService r1, OverlayManagerServiceIA r2) {
            this(r1);
        }

        private OverlayManagerPackageMonitor(OverlayManagerService r1) {
            this.this$0 = r1;
        }

        public void onPackageAppearedWithExtras(String packageName, Bundle extras) {
            OverlayManagerService.m6343$$Nest$mhandlePackageAdd(this.this$0, packageName, extras, getChangingUserId());
        }

        public void onPackageChangedWithExtras(String packageName, Bundle extras) {
            OverlayManagerService.m6344$$Nest$mhandlePackageChange(this.this$0, packageName, extras, getChangingUserId());
        }

        public void onPackageDisappearedWithExtras(String packageName, Bundle extras) {
            OverlayManagerService.m6345$$Nest$mhandlePackageRemove(this.this$0, packageName, extras, getChangingUserId());
        }
    }

    private static final class PackageManagerHelperImpl implements PackageManagerHelper {
        private static final String TAB1 = "    ";
        private final ArrayMap<String, PackageStateUsers> mCache;
        private final Context mContext;
        private final ArraySet<Integer> mInitializedUsers;
        private final IPackageManager mPackageManager;
        private final PackageManagerInternal mPackageManagerInternal;

        private static class PackageStateUsers {
            private final Set<Integer> mInstalledUsers;
            private PackageState mPackageState;

            /* JADX INFO: renamed from: -$$Nest$fgetmInstalledUsers, reason: not valid java name */
            static /* bridge */ /* synthetic */ Set m6351$$Nest$fgetmInstalledUsers(PackageStateUsers r0) {
                return r0.mInstalledUsers;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmPackageState, reason: not valid java name */
            static /* bridge */ /* synthetic */ PackageState m6352$$Nest$fgetmPackageState(PackageStateUsers r0) {
                return r0.mPackageState;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmPackageState, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m6353$$Nest$fputmPackageState(PackageStateUsers r0, PackageState r1) {
                r0.mPackageState = r1;
            }

            /* synthetic */ PackageStateUsers(PackageState r1, OverlayManagerServiceIA r2) {
                this(r1);
            }

            private PackageStateUsers(PackageState packageState) {
                this.mInstalledUsers = new ArraySet();
                this.mPackageState = packageState;
            }
        }

        public static /* synthetic */ void $r8$lambda$OwbHhRYnQy2yMeQN_5EmmuVHt4k(PackageManagerHelperImpl r0, int r1, PackageStateInternal r2) {
            r0.lambda$initializeForUser$0(r1, r2);
        }

        PackageManagerHelperImpl(Context context) {
            this.mCache = new ArrayMap();
            this.mInitializedUsers = new ArraySet();
            this.mContext = context;
            this.mPackageManager = AppGlobals.getPackageManager();
            this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        }

        @Override // com.android.server.om.PackageManagerHelper
        public ArrayMap<String, PackageState> initializeForUser(final int userId) {
            if (this.mInitializedUsers.add(Integer.valueOf(userId)) == false) goto L5;
            this.mPackageManagerInternal.forEachPackageState(new OverlayManagerService$PackageManagerHelperImpl$$ExternalSyntheticLambda0(this, userId));
        L5:
            ArrayMap<String, PackageState> userPackages = new ArrayMap();
            ArrayMap<String, PackageStateUsers> r1 = this.mCache;
            monitor-enter(r1);
            int i = 0;
            int n = this.mCache.size();     // Catch: Throwable -> L13
        L9:
            if (i >= n) goto L17;
            PackageStateUsers pkg = this.mCache.valueAt(i);     // Catch: Throwable -> L13
            if (PackageStateUsers.m6351$$Nest$fgetmInstalledUsers(pkg).contains(Integer.valueOf(userId)) == false) goto L15;
            userPackages.put(this.mCache.keyAt(i), PackageStateUsers.m6352$$Nest$fgetmPackageState(pkg));     // Catch: Throwable -> L13
        L15:
            i = i + 1;     // Catch: Throwable -> L13
            goto L9
        L17:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return userPackages;
        L13:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$initializeForUser$0(int userId, PackageStateInternal packageState) {
            if (packageState.getPkg() != null) goto L5;
            return;
        L5:
            if (packageState.getUserStateOrDefault(userId).isInstalled() == false) goto L9;
            addPackageUser(packageState, userId);
            return;
        }

        @Override // com.android.server.om.PackageManagerHelper
        public PackageState getPackageStateForUser(String packageName, int userId) {
            ArrayMap<String, PackageStateUsers> r0 = this.mCache;
            monitor-enter(r0);
            PackageStateUsers pkg = this.mCache.get(packageName);     // Catch: Throwable -> L20
            monitor-exit(r0);     // Catch: Throwable -> L20
            if (pkg == null) goto L23;
            if (PackageStateUsers.m6351$$Nest$fgetmInstalledUsers(pkg).contains(Integer.valueOf(userId)) == false) goto L23;
            return PackageStateUsers.m6352$$Nest$fgetmPackageState(pkg);
        L23:
            if (this.mPackageManager.isPackageAvailable(packageName, userId) == true) goto L16;
            return null;
        L16:
            return addPackageUser(packageName, userId);
        L17:
            e = move-exception;
            Slog.w(OverlayManagerService.TAG, "Failed to check availability of package '" + packageName + "' for user " + userId, e);
            return null;
        L20:
            th = move-exception;
            throw th;
        }

        private PackageState addPackageUser(String packageName, int user) {
            PackageState pkg = this.mPackageManagerInternal.getPackageStateInternal(packageName);
            if (pkg != null) goto L7;
            Slog.w(OverlayManagerService.TAG, "Android package for '" + packageName + "' could not be found; continuing as if package was never added", new Throwable());
            return null;
        L7:
            return addPackageUser(pkg, user);
        }

        private PackageState addPackageUser(PackageState pkg, int user) {
            ArrayMap<String, PackageStateUsers> r0 = this.mCache;
            monitor-enter(r0);
            PackageStateUsers pkgUsers = this.mCache.get(pkg.getPackageName());     // Catch: Throwable -> L7
            if (pkgUsers != null) goto L9;
            pkgUsers = new PackageStateUsers(pkg, null);     // Catch: Throwable -> L7
            this.mCache.put(pkg.getPackageName(), pkgUsers);     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            PackageStateUsers.m6351$$Nest$fgetmInstalledUsers(pkgUsers).add(Integer.valueOf(user));
            return PackageStateUsers.m6352$$Nest$fgetmPackageState(pkgUsers);
        L9:
            PackageStateUsers.m6353$$Nest$fputmPackageState(pkgUsers, pkg);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        private void removePackageUser(String packageName, int user) {
            ArrayMap<String, PackageStateUsers> r0 = this.mCache;
            monitor-enter(r0);
            PackageStateUsers pkgUsers = this.mCache.get(packageName);     // Catch: Throwable -> L8
            if (pkgUsers != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            removePackageUser(pkgUsers, user);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void removePackageUser(PackageStateUsers pkg, int user) {
            PackageStateUsers.m6351$$Nest$fgetmInstalledUsers(pkg).remove(Integer.valueOf(user));
            if (PackageStateUsers.m6351$$Nest$fgetmInstalledUsers(pkg).isEmpty() == false) goto L12;
            ArrayMap<String, PackageStateUsers> r0 = this.mCache;
            monitor-enter(r0);
            this.mCache.remove(PackageStateUsers.m6352$$Nest$fgetmPackageState(pkg).getPackageName());     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public PackageState onPackageAdded(String packageName, int userId) {
            return addPackageUser(packageName, userId);
        }

        public PackageState onPackageUpdated(String packageName, int userId) {
            return addPackageUser(packageName, userId);
        }

        public void onPackageRemoved(String packageName, int userId) {
            removePackageUser(packageName, userId);
        }

        @Override // com.android.server.om.PackageManagerHelper
        public boolean isInstantApp(String packageName, int userId) {
            return this.mPackageManagerInternal.isInstantApp(packageName, userId);
        }

        @Override // com.android.server.om.PackageManagerHelper
        public Map<String, Map<String, String>> getNamedActors() {
            return SystemConfig.getInstance().getNamedActors();
        }

        @Override // com.android.server.om.PackageManagerHelper
        public boolean signaturesMatching(String packageName1, String packageName2, int userId) {
            if (this.mPackageManager.checkSignatures(packageName1, packageName2, userId) != 0) goto L11;
            return true;
        L11:
            return false;
        L8:
            return false;
        }

        @Override // com.android.server.om.PackageManagerHelper
        public String getConfigSignaturePackage() {
            String[] pkgs = this.mPackageManagerInternal.getKnownPackageNames(13, 0);
            if (pkgs.length != 0) goto L6;
            return null;
        L6:
            return pkgs[0];
        }

        @Override // com.android.server.om.PackageManagerHelper
        public OverlayableInfo getOverlayableForTarget(String packageName, String targetOverlayableName, int userId) throws IOException {
            PackageState packageState = getPackageStateForUser(packageName, userId);
            if (packageState != null) goto L5;
            AndroidPackage pkg = null;
        L6:
            if (pkg == null) goto L20;
            ApkAssets apkAssets = null;
            apkAssets = ApkAssets.loadFromPath(((AndroidPackageSplit) pkg.getSplits().get(0)).getPath(), 32);     // Catch: Throwable -> L13
            OverlayableInfo r3 = apkAssets.getOverlayableInfo(targetOverlayableName);     // Catch: Throwable -> L13
            apkAssets.close();     // Catch: Throwable -> L11
        L12:
            return r3;
        L13:
            th = move-exception;
            if (apkAssets != null) goto L23;
        L18:
            throw th;
        L23:
            apkAssets.close();     // Catch: Throwable -> L17
            goto L18
        L20:
            throw new IOException("Unable to get target package");
        L5:
            pkg = packageState.getAndroidPackage();
            goto L6
        }

        @Override // com.android.server.om.PackageManagerHelper
        public boolean doesTargetDefineOverlayable(String targetPackageName, int userId) throws IOException {
            PackageState packageState = getPackageStateForUser(targetPackageName, userId);
            if (packageState != null) goto L5;
            AndroidPackage pkg = null;
        L6:
            if (pkg == null) goto L20;
            ApkAssets apkAssets = null;
            apkAssets = ApkAssets.loadFromPath(((AndroidPackageSplit) pkg.getSplits().get(0)).getPath(), 32);     // Catch: Throwable -> L13
            boolean r3 = apkAssets.definesOverlayable();     // Catch: Throwable -> L13
            apkAssets.close();     // Catch: Throwable -> L11
        L12:
            return r3;
        L13:
            th = move-exception;
            if (apkAssets != null) goto L23;
        L18:
            throw th;
        L23:
            apkAssets.close();     // Catch: Throwable -> L17
            goto L18
        L20:
            throw new IOException("Unable to get target package");
        L5:
            pkg = packageState.getAndroidPackage();
            goto L6
        }

        @Override // com.android.server.om.PackageManagerHelper
        public void enforcePermission(String permission, String message) throws SecurityException {
            this.mContext.enforceCallingOrSelfPermission(permission, message);
        }

        public void forgetAllPackageInfos(int userId) {
            ArrayMap<String, PackageStateUsers> r0 = this.mCache;
            monitor-enter(r0);
            int i = this.mCache.size() - 1;     // Catch: Throwable -> L7
        L5:
            if (i < 0) goto L10;
            removePackageUser(this.mCache.valueAt(i), userId);     // Catch: Throwable -> L7
            i = i - 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.om.PackageManagerHelper
        public String[] getPackagesForUid(int uid) {
            return this.mPackageManager.getPackagesForUid(uid);
        L5:
            return null;
        }

        public void dump(PrintWriter pw, DumpState dumpState) {
            pw.println("AndroidPackage cache");
            ArrayMap<String, PackageStateUsers> r0 = this.mCache;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (dumpState.isVerbose() == true) goto L12;
            pw.println(TAB1 + this.mCache.size() + " package(s)");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (this.mCache.size() != 0) goto L16;
            pw.println("    <empty>");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L16:
            int i = 0;
            int n = this.mCache.size();     // Catch: Throwable -> L9
        L17:
            if (i >= n) goto L20;
            String packageName = this.mCache.keyAt(i);     // Catch: Throwable -> L9
            PackageStateUsers pkg = this.mCache.valueAt(i);     // Catch: Throwable -> L9
            pw.print(TAB1 + packageName + ": " + PackageStateUsers.m6352$$Nest$fgetmPackageState(pkg) + " users=");     // Catch: Throwable -> L9
            pw.println(TextUtils.join(", ", PackageStateUsers.m6351$$Nest$fgetmInstalledUsers(pkg)));     // Catch: Throwable -> L9
            i = i + 1;     // Catch: Throwable -> L9
            goto L17
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }
    }

    private final class UserLifecycleListener implements UserManagerInternal.UserLifecycleListener {
        final /* synthetic */ OverlayManagerService this$0;

        /* synthetic */ UserLifecycleListener(OverlayManagerService r1, OverlayManagerServiceIA r2) {
            this(r1);
        }

        private UserLifecycleListener(OverlayManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.pm.UserManagerInternal.UserLifecycleListener
        public void onUserCreated(UserInfo user, Object token) {
            if (OverlayManagerService.m6350$$Nest$smisHighPriorityUserCreation(user) == false) goto L16;
            int userId = user.id;
            Slog.i(OverlayManagerService.TAG, "Updating overlays for onUserCreated " + userId);     // Catch: Throwable -> L13
            Trace.traceBegin(67108864, "OMS#onUserCreated " + userId);     // Catch: Throwable -> L13
            Object r3 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L13
            monitor-enter(r3);     // Catch: Throwable -> L13
            OverlayManagerService.m6347$$Nest$mupdatePackageManagerLocked(this.this$0, OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).updateOverlaysForUser(userId));     // Catch: Throwable -> L10
            monitor-exit(r3);     // Catch: Throwable -> L10
            Trace.traceEnd(67108864);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        }
    }

    private final class UserReceiver extends BroadcastReceiver {
        final /* synthetic */ OverlayManagerService this$0;

        /* synthetic */ UserReceiver(OverlayManagerService r1, OverlayManagerServiceIA r2) {
            this(r1);
        }

        private UserReceiver(OverlayManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int userId = intent.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ);
            String r2 = intent.getAction();
            switch(r2.hashCode()) {
                case -2061058799: goto L9;
                case 1121780209: goto L6;
                default: goto L11;
            };
        L11:
            byte r3 = -1;
        L13:
            switch(r3) {
                case 0: goto L27;
                case 1: goto L15;
                default: goto L55;
            };
        L15:
            if (userId != (-10000)) goto L47;
            return;
        L47:
            Trace.traceBegin(67108864, "OMS ACTION_USER_REMOVED");     // Catch: Throwable -> L24
            Object r1 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L24
            monitor-enter(r1);     // Catch: Throwable -> L24
            OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).onUserRemoved(userId);     // Catch: Throwable -> L21
            OverlayManagerService.m6342$$Nest$fgetmPackageManager(this.this$0).forgetAllPackageInfos(userId);     // Catch: Throwable -> L21
            monitor-exit(r1);     // Catch: Throwable -> L21
            Trace.traceEnd(67108864);
            return;
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        L27:
            UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
            UserInfo userInfo = umi.getUserInfo(userId);
            if (userId != (-10000)) goto L30;
            return;
        L30:
            if (OverlayManagerService.m6350$$Nest$smisHighPriorityUserCreation(userInfo) == true) goto L53;
            Slog.i(OverlayManagerService.TAG, "Updating overlays for added user " + userId);     // Catch: Throwable -> L39
            Trace.traceBegin(67108864, "OMS ACTION_USER_ADDED");     // Catch: Throwable -> L39
            Object r4 = OverlayManagerService.m6341$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L39
            monitor-enter(r4);     // Catch: Throwable -> L39
            OverlayManagerService.m6347$$Nest$mupdatePackageManagerLocked(this.this$0, OverlayManagerService.m6340$$Nest$fgetmImpl(this.this$0).updateOverlaysForUser(userId));     // Catch: Throwable -> L36
            monitor-exit(r4);     // Catch: Throwable -> L36
            Trace.traceEnd(67108864);
            return;
        L36:
            th = move-exception;
            throw th;     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            Trace.traceEnd(67108864);
            throw th;
        L53:
            return;
        L55:
            return;
        L6:
            if (r2.equals("android.intent.action.USER_ADDED") == false) goto L11;
            r3 = 0;
            goto L13
        L9:
            if (r2.equals("android.intent.action.USER_REMOVED") == false) goto L11;
            r3 = 1;
            goto L13
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$FyERzJAuu-lT7jJKEeUlKoCzE78, reason: not valid java name */
    public static /* synthetic */ Bundle m6338$r8$lambda$FyERzJAuulT7jJKEeUlKoCzE78(int r0, Bundle r1) {
        return filterReceiverAccess(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$GzMpaQrsjSzVXIS6Ewd4ZVcwe0E(SparseArray r0, UserPackage r1) {
        lambda$groupTargetsByUserId$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$VKUwGCBEaC1c_ubMSsuE2Rf3650(int r0, ActivityManagerInternal r1, String r2) {
        lambda$broadcastActionOverlayChanged$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gmoodzoVnIfdn8kZYi3Op37no2g(OverlayManagerService r0, List r1, int r2, ArraySet r3) {
        r0.lambda$updateTargetPackagesLocked$1(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$rFdAtDXTB46MBaeMgzs6tfJWKtk(String r0, OverlayInfo r1) {
        return lambda$new$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActorEnforcer, reason: not valid java name */
    static /* bridge */ /* synthetic */ OverlayActorEnforcer m6339$$Nest$fgetmActorEnforcer(OverlayManagerService r0) {
        return r0.mActorEnforcer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ OverlayManagerServiceImpl m6340$$Nest$fgetmImpl(OverlayManagerService r0) {
        return r0.mImpl;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6341$$Nest$fgetmLock(OverlayManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerHelperImpl m6342$$Nest$fgetmPackageManager(OverlayManagerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageAdd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6343$$Nest$mhandlePackageAdd(OverlayManagerService r0, String r1, Bundle r2, int r3) {
        r0.handlePackageAdd(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6344$$Nest$mhandlePackageChange(OverlayManagerService r0, String r1, Bundle r2, int r3) {
        r0.handlePackageChange(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageRemove, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6345$$Nest$mhandlePackageRemove(OverlayManagerService r0, String r1, Bundle r2, int r3) {
        r0.handlePackageRemove(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mrestoreSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6346$$Nest$mrestoreSettingsLocked(OverlayManagerService r0) {
        r0.restoreSettingsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePackageManagerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m6347$$Nest$mupdatePackageManagerLocked(OverlayManagerService r0, Set r1) {
        return r0.updatePackageManagerLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTargetPackagesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6348$$Nest$mupdateTargetPackagesLocked(OverlayManagerService r0, UserPackage r1) {
        r0.updateTargetPackagesLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTargetPackagesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6349$$Nest$mupdateTargetPackagesLocked(OverlayManagerService r0, Set r1) {
        r0.updateTargetPackagesLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisHighPriorityUserCreation, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6350$$Nest$smisHighPriorityUserCreation(UserInfo r0) {
        return isHighPriorityUserCreation(r0);
    }

    public OverlayManagerService(Context context) {
        super(context);
        this.mLock = new Object();
        OverlayManagerServiceIA r3 = null;
        this.mPackageMonitor = new OverlayManagerPackageMonitor(this, r3);
        this.mPrevStartedUserId = -1;
        this.mService = new AnonymousClass1(this);
        Trace.traceBegin(67108864, "OMS#OverlayManagerService");     // Catch: Throwable -> L6
        this.mSettingsFile = new AtomicFile(new File(Environment.getDataSystemDirectory(), "overlays.xml"), "overlays");     // Catch: Throwable -> L6
        this.mPackageManager = new PackageManagerHelperImpl(context);     // Catch: Throwable -> L6
        this.mUserManager = UserManagerService.getInstance();     // Catch: Throwable -> L6
        IdmapManager im = new IdmapManager(IdmapDaemon.getInstance(), this.mPackageManager);     // Catch: Throwable -> L6
        this.mSettings = new OverlayManagerSettings();     // Catch: Throwable -> L6
        this.mImpl = new OverlayManagerServiceImpl(this.mPackageManager, im, this.mSettings, OverlayConfig.getSystemInstance(), getDefaultOverlayPackages());     // Catch: Throwable -> L6
        this.mActorEnforcer = new OverlayActorEnforcer(this.mPackageManager);     // Catch: Throwable -> L6
        HandlerThread packageMonitorThread = new HandlerThread(TAG);     // Catch: Throwable -> L6
        packageMonitorThread.start();     // Catch: Throwable -> L6
        this.mPackageMonitor.register(context, packageMonitorThread.getLooper(), UserHandle.ALL, true);     // Catch: Throwable -> L6
        IntentFilter userFilter = new IntentFilter();     // Catch: Throwable -> L6
        userFilter.addAction("android.intent.action.USER_ADDED");     // Catch: Throwable -> L6
        userFilter.addAction("android.intent.action.USER_REMOVED");     // Catch: Throwable -> L6
        getContext().registerReceiverAsUser(new UserReceiver(this, r3), UserHandle.ALL, userFilter, null, null);     // Catch: Throwable -> L6
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);     // Catch: Throwable -> L6
        umi.addUserLifecycleListener(new UserLifecycleListener(this, r3));     // Catch: Throwable -> L6
        restoreSettingsLocked();     // Catch: Throwable -> L6
        final String shellPkgName = TextUtils.emptyIfNull(getContext().getString(R.string.config_systemShell));     // Catch: Throwable -> L6
        this.mSettings.removeIf(new OverlayManagerService$$ExternalSyntheticLambda2(shellPkgName));     // Catch: Throwable -> L6
        initIfNeeded();     // Catch: Throwable -> L6
        onStartUser(0);     // Catch: Throwable -> L6
        publishBinderService("overlay", this.mService);     // Catch: Throwable -> L6
        publishLocalService(OverlayManagerService.class, this);     // Catch: Throwable -> L6
        Trace.traceEnd(67108864);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }

    private static /* synthetic */ boolean lambda$new$0(String shellPkgName, OverlayInfo overlayInfo) {
        if (overlayInfo.isFabricated == true) goto L5;
    L7:
        return false;
    L5:
        if (shellPkgName.equals(overlayInfo.packageName) == false) goto L7;
        return true;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    private void initIfNeeded() {
        UserManager um = (UserManager) getContext().getSystemService(UserManager.class);
        List<UserInfo> users = um.getAliveUsers();
        Object r2 = this.mLock;
        monitor-enter(r2);
        int userCount = users.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= userCount) goto L15;
        UserInfo userInfo = users.get(i);     // Catch: Throwable -> L11
        if (userInfo.supportsSwitchTo() == true) goto L13;
        if (userInfo.id == 0) goto L13;
        updatePackageManagerLocked(this.mImpl.updateOverlaysForUser(users.get(i).id));     // Catch: Throwable -> L11
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        onStartUser(user.getUserIdentifier());
    }

    private void onStartUser(int newUserId) {
        if (newUserId != this.mPrevStartedUserId) goto L5;
        return;
    L5:
        Slog.i(TAG, "Updating overlays for starting user " + newUserId);
        Trace.traceBegin(67108864, "OMS#onStartUser " + newUserId);     // Catch: Throwable -> L15
        Object r2 = this.mLock;     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        updateTargetPackagesLocked(this.mImpl.updateOverlaysForUser(newUserId));     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        Trace.traceEnd(67108864);
        this.mPrevStartedUserId = newUserId;
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }

    private static String[] getDefaultOverlayPackages() {
        String str = SystemProperties.get(DEFAULT_OVERLAYS_PROP);
        if (TextUtils.isEmpty(str) == true) goto L5;
        ArraySet<String> defaultPackages = new ArraySet();
        String[] r2 = str.split(";");
        int r3 = r2.length;
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L13;
        String packageName = r2[r5];
        if (TextUtils.isEmpty(packageName) == true) goto L11;
        defaultPackages.add(packageName);
    L11:
        r5 = r5 + 1;
        goto L7
    L13:
        return (String[]) defaultPackages.toArray(new String[0]);
    L5:
        return EmptyArray.STRING;
    }

    private int[] getUserIds(int uid) {
        if (uid != (-1)) goto L5;
        int[] userIds = this.mUserManager.getUserIds();
        return userIds;
    L5:
        int[] userIds2 = {UserHandle.getUserId(uid)};
        return userIds2;
    }

    static int handleIncomingUser(int userId, String message) {
        return ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, message, null);
    }

    private void handlePackageAdd(String packageName, Bundle extras, int userId) {
        boolean replacing = extras.getBoolean("android.intent.extra.REPLACING", false);
        if (replacing == false) goto L5;
        onPackageReplaced(packageName, userId);
        return;
    L5:
        onPackageAdded(packageName, userId);
    }

    private void handlePackageChange(String packageName, Bundle extras, int userId) {
        if ("android.intent.action.OVERLAY_CHANGED".equals(extras.getString("android.intent.extra.REASON")) == true) goto L6;
        onPackageChanged(packageName, userId);
        return;
    }

    private void handlePackageRemove(String packageName, Bundle extras, int userId) {
        boolean replacing = extras.getBoolean("android.intent.extra.REPLACING", false);
        boolean systemUpdateUninstall = extras.getBoolean("android.intent.extra.SYSTEM_UPDATE_UNINSTALL", false);
        if (replacing == false) goto L5;
        onPackageReplacing(packageName, systemUpdateUninstall, userId);
        return;
    L5:
        onPackageRemoved(packageName, userId);
    }

    private void onPackageAdded(String packageName, int userId) {
        Trace.traceBegin(67108864, "OMS#onPackageAdded " + packageName);     // Catch: Throwable -> L20
        Object r2 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        PackageState packageState = this.mPackageManager.onPackageAdded(packageName, userId);     // Catch: Throwable -> L11
        if (packageState != null) goto L8;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L11
        Trace.traceEnd(67108864);
        return;
    L8:
        if (this.mPackageManager.isInstantApp(packageName, userId) == true) goto L15;
        updateTargetPackagesLocked(this.mImpl.onPackageAdded(packageName, userId));     // Catch: Throwable -> L11 OverlayManagerServiceImpl.OperationFailedException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "onPackageAdded internal error", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }

    private void onPackageChanged(String packageName, int userId) {
        Trace.traceBegin(67108864, "OMS#onPackageChanged " + packageName);     // Catch: Throwable -> L20
        Object r2 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        PackageState packageState = this.mPackageManager.onPackageUpdated(packageName, userId);     // Catch: Throwable -> L11
        if (packageState != null) goto L8;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L11
        Trace.traceEnd(67108864);
        return;
    L8:
        if (this.mPackageManager.isInstantApp(packageName, userId) == true) goto L15;
        updateTargetPackagesLocked(this.mImpl.onPackageChanged(packageName, userId));     // Catch: Throwable -> L11 OverlayManagerServiceImpl.OperationFailedException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "onPackageChanged internal error", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }

    private void onPackageReplacing(String packageName, boolean systemUpdateUninstall, int userId) {
        Trace.traceBegin(67108864, "OMS#onPackageReplacing " + packageName);     // Catch: Throwable -> L20
        Object r2 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        PackageState packageState = this.mPackageManager.onPackageUpdated(packageName, userId);     // Catch: Throwable -> L11
        if (packageState != null) goto L8;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L11
        Trace.traceEnd(67108864);
        return;
    L8:
        if (this.mPackageManager.isInstantApp(packageName, userId) == true) goto L15;
        updateTargetPackagesLocked(this.mImpl.onPackageReplacing(packageName, systemUpdateUninstall, userId));     // Catch: Throwable -> L11 OverlayManagerServiceImpl.OperationFailedException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "onPackageReplacing internal error", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }

    private void onPackageReplaced(String packageName, int userId) {
        Trace.traceBegin(67108864, "OMS#onPackageReplaced " + packageName);     // Catch: Throwable -> L20
        Object r2 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        PackageState packageState = this.mPackageManager.onPackageUpdated(packageName, userId);     // Catch: Throwable -> L11
        if (packageState != null) goto L8;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L11
        Trace.traceEnd(67108864);
        return;
    L8:
        if (this.mPackageManager.isInstantApp(packageName, userId) == true) goto L15;
        updateTargetPackagesLocked(this.mImpl.onPackageReplaced(packageName, userId));     // Catch: Throwable -> L11 OverlayManagerServiceImpl.OperationFailedException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "onPackageReplaced internal error", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }

    private void onPackageRemoved(String packageName, int userId) {
        Trace.traceBegin(67108864, "OMS#onPackageRemoved " + packageName);     // Catch: Throwable -> L12
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        this.mPackageManager.onPackageRemoved(packageName, userId);     // Catch: Throwable -> L9
        updateTargetPackagesLocked(this.mImpl.onPackageRemoved(packageName, userId));     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Trace.traceEnd(67108864);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }

    private static boolean isHighPriorityUserCreation(UserInfo user) {
        if (user != null) goto L4;
    L6:
        return false;
    L4:
        if (user.isMain() == false) goto L6;
        return true;
    }

    private void updateTargetPackagesLocked(UserPackage updatedTarget) {
        if (updatedTarget == null) goto L5;
        updateTargetPackagesLocked(Set.of(updatedTarget));
        return;
    }

    private void updateTargetPackagesLocked(Set<UserPackage> updatedTargets) {
        if (CollectionUtils.isEmpty(updatedTargets) == false) goto L5;
        return;
    L5:
        persistSettingsLocked();
        SparseArray<ArraySet<String>> userTargets = groupTargetsByUserId(updatedTargets);
        int i = 0;
        int n = userTargets.size();
    L6:
        if (i >= n) goto L13;
        final ArraySet<String> targets = userTargets.valueAt(i);
        final int userId = userTargets.keyAt(i);
        final List<String> affectedPackages = updatePackageManagerLocked(targets, userId);
        if (affectedPackages.isEmpty() == true) goto L11;
        FgThread.getHandler().post(new OverlayManagerService$$ExternalSyntheticLambda4(this, affectedPackages, userId, targets));
    L11:
        i = i + 1;
        goto L6
    }

    private /* synthetic */ void lambda$updateTargetPackagesLocked$1(List affectedPackages, int userId, ArraySet targets) {
        updateActivityManager(affectedPackages, userId);
        broadcastActionOverlayChanged(targets, userId);
    }

    private static SparseArray<ArraySet<String>> groupTargetsByUserId(Set<UserPackage> targetsAndUsers) {
        final SparseArray<ArraySet<String>> userTargets = new SparseArray();
        CollectionUtils.forEach(targetsAndUsers, new OverlayManagerService$$ExternalSyntheticLambda0(userTargets));
        return userTargets;
    }

    private static /* synthetic */ void lambda$groupTargetsByUserId$2(SparseArray userTargets, UserPackage target) throws Exception {
        ArraySet<String> targets = (ArraySet) userTargets.get(target.userId);
        if (targets != null) goto L5;
        targets = new ArraySet();
        userTargets.put(target.userId, targets);
    L5:
        targets.add(target.packageName);
    }

    private static void broadcastActionOverlayChanged(Set<String> targetPackages, final int userId) {
        final ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        CollectionUtils.forEach(targetPackages, new OverlayManagerService$$ExternalSyntheticLambda3(userId, amInternal));
    }

    private static /* synthetic */ void lambda$broadcastActionOverlayChanged$3(int userId, ActivityManagerInternal amInternal, String target) throws Exception {
        Intent intent = new Intent("android.intent.action.OVERLAY_CHANGED", Uri.fromParts(Settings.ATTR_PACKAGE, target, null));
        intent.setFlags(67108864);
        intent.putExtra("android.intent.extra.PACKAGE_NAME", target);
        intent.putExtra("android.intent.extra.USER_ID", userId);
        amInternal.broadcastIntent(intent, null, null, false, userId, null, new OverlayManagerService$$ExternalSyntheticLambda1(), null);
    }

    private static Bundle filterReceiverAccess(int callingUid, Bundle extras) {
        String packageName = extras.getString("android.intent.extra.PACKAGE_NAME");
        int userId = extras.getInt("android.intent.extra.USER_ID");
        if (((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).filterAppAccess(packageName, callingUid, userId, false) == false) goto L6;
        return null;
    L6:
        return extras;
    }

    private void updateActivityManager(List<String> targetPackageNames, int userId) {
        IActivityManager am = ActivityManager.getService();
        am.scheduleApplicationInfoChanged(targetPackageNames, userId);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "updateActivityManager remote exception", e);
    }

    private SparseArray<List<String>> updatePackageManagerLocked(Set<UserPackage> targets) {
        if (CollectionUtils.isEmpty(targets) == true) goto L5;
        SparseArray<List<String>> affectedTargets = new SparseArray();
        SparseArray<ArraySet<String>> userTargets = groupTargetsByUserId(targets);
        int i = 0;
        int n = userTargets.size();
    L7:
        if (i >= n) goto L10;
        int userId = userTargets.keyAt(i);
        affectedTargets.put(userId, updatePackageManagerLocked(userTargets.valueAt(i), userId));
        i = i + 1;
        goto L7
    L10:
        return affectedTargets;
    L5:
        return new SparseArray();
    }

    private List<String> updatePackageManagerLocked(Collection<String> targetPackageNames, int userId) {
        Trace.traceBegin(67108864, "OMS#updatePackageManagerLocked " + targetPackageNames);     // Catch: Throwable -> L6
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L6
        boolean updateFrameworkRes = targetPackageNames.contains(PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L6
        if (updateFrameworkRes == false) goto L8;
        targetPackageNames = pm.getTargetPackageNames(userId);     // Catch: Throwable -> L6
    L8:
        ArrayMap<String, OverlayPaths> pendingChanges = new ArrayMap(targetPackageNames.size());     // Catch: Throwable -> L6
        Object r5 = this.mLock;     // Catch: Throwable -> L6
        monitor-enter(r5);     // Catch: Throwable -> L6
        OverlayPaths frameworkOverlays = this.mImpl.getEnabledOverlayPaths(PackageManagerService.PLATFORM_PACKAGE_NAME, userId, false);     // Catch: Throwable -> L16
        Iterator<String> r7 = targetPackageNames.iterator();     // Catch: Throwable -> L16
    L12:
        if (r7.hasNext() == false) goto L19;
        String targetPackageName = r7.next();     // Catch: Throwable -> L16
        OverlayPaths.Builder list = new OverlayPaths.Builder(frameworkOverlays);     // Catch: Throwable -> L16
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(targetPackageName) == true) goto L18;
        list.addAll(this.mImpl.getEnabledOverlayPaths(targetPackageName, userId, true));     // Catch: Throwable -> L16
    L18:
        pendingChanges.put(targetPackageName, list.build());     // Catch: Throwable -> L16
        goto L12
    L19:
        monitor-exit(r5);     // Catch: Throwable -> L16
        HashSet<String> updatedPackages = new HashSet();     // Catch: Throwable -> L6
        HashSet<String> invalidPackages = new HashSet();     // Catch: Throwable -> L6
        pm.setEnabledOverlayPackages(userId, pendingChanges, updatedPackages, invalidPackages);     // Catch: Throwable -> L6
        if (invalidPackages.isEmpty() == true) goto L29;
        Iterator<String> r8 = targetPackageNames.iterator();     // Catch: Throwable -> L6
    L24:
        if (r8.hasNext() == false) goto L29;
        String targetPackageName2 = r8.next();     // Catch: Throwable -> L6
        if (invalidPackages.contains(targetPackageName2) == false) goto L24;
        Slog.e(TAG, TextUtils.formatSimple("Failed to change enabled overlays for %s user %d", new Object[]{targetPackageName2, Integer.valueOf(userId)}));     // Catch: Throwable -> L6
    L29:
        ArrayList r9 = new ArrayList(updatedPackages);     // Catch: Throwable -> L6
        Trace.traceEnd(67108864);
        return r9;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }

    private void persistSettingsLocked() {
        FileOutputStream stream = null;
        stream = this.mSettingsFile.startWrite();     // Catch: Throwable -> L5
        this.mSettings.persist(stream);     // Catch: Throwable -> L5
        this.mSettingsFile.finishWrite(stream);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mSettingsFile.failWrite(stream);
        Slog.e(TAG, "failed to persist overlay state", e);
    }

    private void restoreSettingsLocked() {
        Trace.traceBegin(67108864, "OMS#restoreSettings");     // Catch: Throwable -> L24
        if (this.mSettingsFile.getBaseFile().exists() == true) goto L42;
        Trace.traceEnd(67108864);
        return;
    L42:
        FileInputStream stream = this.mSettingsFile.openRead();     // Catch: Throwable -> L24 Throwable -> L26
        this.mSettings.restore(stream);     // Catch: Throwable -> L12
        List<UserInfo> liveUsers = this.mUserManager.getUsers(true);     // Catch: Throwable -> L12
        int[] liveUserIds = new int[liveUsers.size()];     // Catch: Throwable -> L12
        int i = 0;
    L10:
        if (i >= liveUsers.size()) goto L14;
        liveUserIds[i] = liveUsers.get(i).getUserHandle().getIdentifier();     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L10
    L14:
        Arrays.sort(liveUserIds);     // Catch: Throwable -> L12
        int[] r5 = this.mSettings.getUsers();     // Catch: Throwable -> L12
        int r6 = r5.length;     // Catch: Throwable -> L12
        int r7 = 0;
    L15:
        if (r7 >= r6) goto L21;
        int userId = r5[r7];     // Catch: Throwable -> L12
        if (Arrays.binarySearch(liveUserIds, userId) >= 0) goto L19;
        this.mSettings.removeUser(userId);     // Catch: Throwable -> L12
    L19:
        r7 = r7 + 1;
        goto L15
    L21:
        if (stream == null) goto L38;
        stream.close();     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
    L38:
        Trace.traceEnd(67108864);
        return;
    L12:
        th = move-exception;
        if (stream != null) goto L46;
    L35:
        throw th;     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
    L46:
        stream.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
    L26:
        e = move-exception;
        Slog.e(TAG, "failed to restore overlay state", e);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Trace.traceEnd(67108864);
        throw th;
    }
}
