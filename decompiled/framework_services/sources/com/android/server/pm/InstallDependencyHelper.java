package com.android.server.pm;

import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.ResolveInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.dependencyinstaller.DependencyInstallerCallback;
import android.content.pm.dependencyinstaller.IDependencyInstallerCallback;
import android.content.pm.dependencyinstaller.IDependencyInstallerService;
import android.content.pm.parsing.PackageLite;
import android.os.Binder;
import android.os.Handler;
import android.os.OutcomeReceiver;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class InstallDependencyHelper {
    private static final boolean DEBUG = true;
    private static final long REQUEST_TIMEOUT_MILLIS = 0;
    private static final String TAG = null;
    private static final long UNBIND_TIMEOUT_MILLIS = 0;
    private final Context mContext;
    private final PackageInstallerService mPackageInstallerService;
    private final ArrayMap<Integer, ServiceConnector<IDependencyInstallerService>> mRemoteServices;
    private final SharedLibrariesImpl mSharedLibraries;
    private final List<DependencyInstallTracker> mTrackers;

    private static class CallOnceProxy implements OutcomeReceiver<Void, PackageManagerException> {
        private final OutcomeReceiver<Void, PackageManagerException> mCallback;
        private boolean mCalled;
        private final Handler mHandler;

        /* JADX INFO: renamed from: $r8$lambda$JKIEhxY3I6krJ8c-hvvA1canv4c, reason: not valid java name */
        public static /* synthetic */ void m6662$r8$lambda$JKIEhxY3I6krJ8chvvA1canv4c(CallOnceProxy r0, PackageManagerException r1) {
            r0.lambda$onError$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$WTuaETiNg7IebcFDIkwgeH9Gdn8(CallOnceProxy r0) {
            r0.lambda$onResult$0();
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onError(Throwable r1) {
            onError((PackageManagerException) r1);
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onResult(Void r1) {
            onResult2(r1);
        }

        CallOnceProxy(Handler handler, OutcomeReceiver<Void, PackageManagerException> callback) {
            this.mCalled = false;
            this.mHandler = handler;
            this.mCallback = callback;
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(Void result) {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mCalled == true) goto L8;
            this.mHandler.post(new InstallDependencyHelper$CallOnceProxy$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L6
            this.mCalled = true;     // Catch: Throwable -> L6
        L8:
            monitor-exit(this);     // Catch: Throwable -> L6
        }

        private /* synthetic */ void lambda$onResult$0() {
            this.mCallback.onResult(null);
        }

        public void onError(final PackageManagerException error) {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mCalled == true) goto L8;
            this.mHandler.post(new InstallDependencyHelper$CallOnceProxy$$ExternalSyntheticLambda0(this, error));     // Catch: Throwable -> L6
            this.mCalled = true;     // Catch: Throwable -> L6
        L8:
            monitor-exit(this);     // Catch: Throwable -> L6
        }

        private /* synthetic */ void lambda$onError$1(PackageManagerException error) {
            this.mCallback.onError(error);
        }
    }

    private static class DependencyInstallTracker {
        private final CallOnceProxy mCallback;
        private final ArraySet<Integer> mPendingSessionIds;

        DependencyInstallTracker(CallOnceProxy callback, ArraySet<Integer> pendingSessionIds) {
            this.mCallback = callback;
            this.mPendingSessionIds = pendingSessionIds;
        }

        public boolean onSessionComplete(int sessionId) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mPendingSessionIds.contains(Integer.valueOf(sessionId)) == true) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return true;
        L9:
            this.mPendingSessionIds.remove(Integer.valueOf(sessionId));     // Catch: Throwable -> L7
            if (this.mPendingSessionIds.isEmpty() == false) goto L15;
            this.mCallback.onResult2(null);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return false;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L7
            return true;
        }
    }

    private class DependencyInstallerCallbackCallOnce extends IDependencyInstallerCallback.Stub {
        private final CallOnceProxy mCallback;
        private boolean mDependencyInstallerCallbackInvoked;
        private final Handler mHandler;
        private final int mUserId;
        final /* synthetic */ InstallDependencyHelper this$0;

        /* JADX INFO: renamed from: $r8$lambda$Kt3-GGszpNON01-m61rud1b8C_c, reason: not valid java name */
        public static /* synthetic */ boolean m6663$r8$lambda$Kt3GGszpNON01m61rud1b8C_c(int r0, PackageInstaller.SessionInfo r1) {
            return lambda$validateSessionIds$2(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$T8pWQuu5GiV4_bkHl0Oll56UgMo(DependencyInstallerCallbackCallOnce r0) {
            r0.lambda$onFailureToResolveAllDependencies$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$rd2v2mEAXOx0nOy7DznzLts-3xg, reason: not valid java name */
        public static /* synthetic */ void m6664$r8$lambda$rd2v2mEAXOx0nOy7DznzLts3xg(DependencyInstallerCallbackCallOnce r0, int r1) {
            r0.lambda$onAllDependenciesResolved$0(r1);
        }

        DependencyInstallerCallbackCallOnce(InstallDependencyHelper r1, Handler handler, CallOnceProxy callback, int userId) {
            this.this$0 = r1;
            this.mDependencyInstallerCallbackInvoked = false;
            this.mHandler = handler;
            this.mCallback = callback;
            this.mUserId = userId;
        }

        public void onAllDependenciesResolved(int[] sessionIds) throws RemoteException {
            monitor-enter(this);
        L39:
            e = move-exception;
            throw e;
        L4:
            if (this.mDependencyInstallerCallbackInvoked == true) goto L42;
            this.mDependencyInstallerCallbackInvoked = true;     // Catch: Throwable -> L39
            monitor-exit(this);     // Catch: Throwable -> L39
            Slog.d(InstallDependencyHelper.m6659$$Nest$sfgetTAG(), "onAllDependenciesResolved started");
            ArraySet<Integer> validSessionIds = validateSessionIds(sessionIds);     // Catch: Exception -> L12
            if (validSessionIds.isEmpty() == false) goto L14;
            this.mCallback.onResult2(null);     // Catch: Exception -> L12
            return;
        L14:
            DependencyInstallTracker tracker = new DependencyInstallTracker(this.mCallback, validSessionIds);     // Catch: Exception -> L12
            List r2 = InstallDependencyHelper.m6657$$Nest$fgetmTrackers(this.this$0);     // Catch: Exception -> L12
            monitor-enter(r2);     // Catch: Exception -> L12
            InstallDependencyHelper.m6657$$Nest$fgetmTrackers(this.this$0).add(tracker);     // Catch: Throwable -> L27
            monitor-exit(r2);     // Catch: Throwable -> L27
            Iterator<Integer> r3 = validSessionIds.iterator();     // Catch: Exception -> L12
        L20:
            if (r3.hasNext() == false) goto L26;
            final int sessionId = r3.next().intValue();     // Catch: Exception -> L12
            PackageInstaller.SessionInfo sessionInfo = InstallDependencyHelper.m6655$$Nest$fgetmPackageInstallerService(this.this$0).getSessionInfo(sessionId);     // Catch: Exception -> L12
            if (sessionInfo != null) goto L20;
            Binder.withCleanCallingIdentity(new InstallDependencyHelper$DependencyInstallerCallbackCallOnce$$ExternalSyntheticLambda2(this, sessionId));     // Catch: Exception -> L12
            goto L20
        L26:
            return;
        L27:
            th = move-exception;
            throw th;     // Catch: Exception -> L12
        L12:
            e = move-exception;
            monitor-enter(this);
            this.mDependencyInstallerCallbackInvoked = false;     // Catch: Throwable -> L36
            throw e;
        L36:
            th = move-exception;
            throw th;
        L42:
            throw new IllegalStateException("Callback is being or has been already processed");     // Catch: Throwable -> L39
        }

        private /* synthetic */ void lambda$onAllDependenciesResolved$0(int sessionId) throws Exception {
            this.this$0.notifySessionComplete(sessionId);
        }

        public void onFailureToResolveAllDependencies() throws RemoteException {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mDependencyInstallerCallbackInvoked == true) goto L12;
            this.mDependencyInstallerCallbackInvoked = true;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            Binder.withCleanCallingIdentity(new InstallDependencyHelper$DependencyInstallerCallbackCallOnce$$ExternalSyntheticLambda0(this));
            return;
        L12:
            throw new IllegalStateException("Callback is being or has been already processed");     // Catch: Throwable -> L9
        }

        private /* synthetic */ void lambda$onFailureToResolveAllDependencies$1() throws Exception {
            InstallDependencyHelper.m6661$$Nest$smonError(this.mCallback, "Failed to resolve all dependencies automatically");
        }

        private ArraySet<Integer> validateSessionIds(int[] sessionIds) {
            ArraySet<Integer> validSessionIds = new ArraySet();
            List<PackageInstaller.SessionInfo> historicalSessions = null;
            int i = 0;
        L4:
            if (i >= sessionIds.length) goto L27;
            final int sessionId = sessionIds[i];
            PackageInstaller.SessionInfo sessionInfo = InstallDependencyHelper.m6655$$Nest$fgetmPackageInstallerService(this.this$0).getSessionInfo(sessionId);
            if (sessionInfo != null) goto L8;
            Slog.d(InstallDependencyHelper.m6659$$Nest$sfgetTAG(), "onAllDependenciesResolved cleaning up finished session: " + sessionId);
            if (historicalSessions != null) goto L17;
            historicalSessions = InstallDependencyHelper.m6655$$Nest$fgetmPackageInstallerService(this.this$0).getHistoricalSessions(this.mUserId).getList();
        L17:
            PackageInstaller.SessionInfo sessionInfo2 = historicalSessions.stream().filter(new InstallDependencyHelper$DependencyInstallerCallbackCallOnce$$ExternalSyntheticLambda1(sessionId)).findFirst().orElse(null);
            if (sessionInfo2 == null) goto L25;
            if (sessionInfo2.isSessionApplied == true) goto L21;
            throw new IllegalArgumentException("Session already finished: " + sessionId);
        L21:
            i = i + 1;
            goto L4
        L25:
            throw new IllegalArgumentException("Failed to find session: " + sessionId);
        L8:
            if (sessionInfo.isSessionFailed == true) goto L13;
            if (sessionInfo.isSessionApplied == true) goto L21;
            Slog.d(InstallDependencyHelper.m6659$$Nest$sfgetTAG(), "onAllDependenciesResolved pending session: " + sessionId);
            validSessionIds.add(Integer.valueOf(sessionId));
            goto L21
        L13:
            throw new IllegalArgumentException("Session already finished: " + sessionId);
        L27:
            return validSessionIds;
        }

        private static /* synthetic */ boolean lambda$validateSessionIds$2(int sessionId, PackageInstaller.SessionInfo s) {
            if (s.sessionId != sessionId) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$CZAXdst-99wNRnVuKlR5HvetTt8, reason: not valid java name */
    public static /* synthetic */ void m6654$r8$lambda$CZAXdst99wNRnVuKlR5HvetTt8(List r0, IDependencyInstallerCallback r1, IDependencyInstallerService r2) {
        lambda$resolveLibraryDependenciesIfNeededInternal$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageInstallerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageInstallerService m6655$$Nest$fgetmPackageInstallerService(InstallDependencyHelper r0) {
        return r0.mPackageInstallerService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteServices, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m6656$$Nest$fgetmRemoteServices(InstallDependencyHelper r0) {
        return r0.mRemoteServices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrackers, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6657$$Nest$fgetmTrackers(InstallDependencyHelper r0) {
        return r0.mTrackers;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetREQUEST_TIMEOUT_MILLIS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6658$$Nest$sfgetREQUEST_TIMEOUT_MILLIS() {
        return REQUEST_TIMEOUT_MILLIS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6659$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetUNBIND_TIMEOUT_MILLIS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6660$$Nest$sfgetUNBIND_TIMEOUT_MILLIS() {
        return UNBIND_TIMEOUT_MILLIS;
    }

    /* JADX INFO: renamed from: -$$Nest$smonError, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6661$$Nest$smonError(CallOnceProxy r0, String r1) {
        onError(r0, r1);
    }

    static {
        TAG = InstallDependencyHelper.class.getSimpleName();
        UNBIND_TIMEOUT_MILLIS = TimeUnit.HOURS.toMillis(6);
        REQUEST_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    }

    InstallDependencyHelper(Context context, SharedLibrariesImpl sharedLibraries, PackageInstallerService packageInstallerService) {
        this.mTrackers = new ArrayList();
        this.mRemoteServices = new ArrayMap();
        this.mContext = context;
        this.mSharedLibraries = sharedLibraries;
        this.mPackageInstallerService = packageInstallerService;
    }

    void resolveLibraryDependenciesIfNeeded(List<SharedLibraryInfo> missingLibraries, PackageLite pkg, Computer snapshot, int userId, Handler handler, OutcomeReceiver<Void, PackageManagerException> origCallback) {
        CallOnceProxy callback = new CallOnceProxy(handler, origCallback);
        resolveLibraryDependenciesIfNeededInternal(missingLibraries, pkg, snapshot, userId, handler, callback);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        onError(callback, e.getMessage());
    }

    private void resolveLibraryDependenciesIfNeededInternal(final List<SharedLibraryInfo> missing, PackageLite pkg, Computer snapshot, int userId, Handler handler, CallOnceProxy callback) {
        if (missing.isEmpty() == false) goto L6;
        Slog.d(TAG, "No missing dependency for " + pkg.getPackageName());
        callback.onResult2(null);
        return;
    L6:
        Slog.d(TAG, "Missing dependencies found for pkg: " + pkg.getPackageName() + " user: " + userId);
        if (bindToDependencyInstallerIfNeeded(userId, handler, snapshot) == true) goto L10;
        onError(callback, "Dependency Installer Service not found");
        return;
    L10:
        final DependencyInstallerCallbackCallOnce r0 = new DependencyInstallerCallbackCallOnce(this, handler, callback, userId);
        ArrayMap<Integer, ServiceConnector<IDependencyInstallerService>> r1 = this.mRemoteServices;
        monitor-enter(r1);
        boolean scheduleSuccess = this.mRemoteServices.get(Integer.valueOf(userId)).run(new InstallDependencyHelper$$ExternalSyntheticLambda0(missing, r0));     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        if (scheduleSuccess == true) goto L22;
        onError(callback, "Failed to schedule job on Dependency Installer Service");
        return;
    L22:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$resolveLibraryDependenciesIfNeededInternal$0(List missing, IDependencyInstallerCallback serviceCallback, IDependencyInstallerService service) throws Exception {
        service.onDependenciesRequired(missing, new DependencyInstallerCallback(serviceCallback.asBinder()));
    }

    List<SharedLibraryInfo> getMissingSharedLibraries(PackageLite pkg) throws PackageManagerException {
        return this.mSharedLibraries.collectMissingSharedLibraryInfos(pkg);
    }

    void notifySessionComplete(int sessionId) {
        Slog.d(TAG, "Session complete for " + sessionId);
        List<DependencyInstallTracker> r0 = this.mTrackers;
        monitor-enter(r0);
        List<DependencyInstallTracker> completedTrackers = new ArrayList();     // Catch: Throwable -> L10
        Iterator<DependencyInstallTracker> r2 = this.mTrackers.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        DependencyInstallTracker tracker = r2.next();     // Catch: Throwable -> L10
        if (tracker.onSessionComplete(sessionId) == true) goto L6;
        completedTrackers.add(tracker);     // Catch: Throwable -> L10
        goto L6
    L13:
        this.mTrackers.removeAll(completedTrackers);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static void onError(CallOnceProxy callback, String msg) {
        PackageManagerException pe = new PackageManagerException(-9, msg);
        callback.onError(pe);
        Slog.i(TAG, "Orig session error: " + msg);
    }

    private boolean bindToDependencyInstallerIfNeeded(final int userId, final Handler handler, Computer snapshot) {
        ArrayMap<Integer, ServiceConnector<IDependencyInstallerService>> r1 = this.mRemoteServices;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteServices.containsKey(Integer.valueOf(userId)) == false) goto L11;
        Slog.i(TAG, "DependencyInstallerService for user " + userId + " already bound");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return true;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        Slog.i(TAG, "Attempting to bind to Dependency Installer Service for user " + userId);
        RoleManager roleManager = (RoleManager) this.mContext.getSystemService(RoleManager.class);
        if (roleManager != null) goto L16;
        Slog.w(TAG, "Cannot find RoleManager system service");
        return false;
    L16:
        List<String> holders = roleManager.getRoleHoldersAsUser("android.app.role.SYSTEM_DEPENDENCY_INSTALLER", UserHandle.of(userId));
        if (holders.isEmpty() == false) goto L20;
        Slog.w(TAG, "No holders of ROLE_SYSTEM_DEPENDENCY_INSTALLER found for user " + userId);
        return false;
    L20:
        final Intent serviceIntent = new Intent("android.content.pm.action.INSTALL_DEPENDENCY");
        serviceIntent.setPackage((String) holders.getFirst());
        List<ResolveInfo> resolvedIntents = snapshot.queryIntentServicesInternal(serviceIntent, null, 0, userId, 1000, -1, false, false);
        if (resolvedIntents.isEmpty() == false) goto L24;
        Slog.w(TAG, "No package holding ROLE_SYSTEM_DEPENDENCY_INSTALLER found for user " + userId);
        return false;
    L24:
        ResolveInfo resolveInfo = (ResolveInfo) resolvedIntents.getFirst();
        final ComponentName componentName = resolveInfo.getComponentInfo().getComponentName();
        serviceIntent.setComponent(componentName);
        final Context r2 = this.mContext;
        final Function r6 = new InstallDependencyHelper$$ExternalSyntheticLambda1();
        final int r4 = 1;
        ServiceConnector<IDependencyInstallerService> serviceConnector = new AnonymousClass1(this, r2, serviceIntent, r4, userId, r6, handler);
        ArrayMap<Integer, ServiceConnector<IDependencyInstallerService>> r7 = this.mRemoteServices;
        monitor-enter(r7);
    L30:
        th = move-exception;
        throw th;
    L27:
        if (this.mRemoteServices.containsKey(Integer.valueOf(userId)) == false) goto L32;
        monitor-exit(r7);     // Catch: Throwable -> L30
        return true;
    L32:
        this.mRemoteServices.put(Integer.valueOf(userId), serviceConnector);     // Catch: Throwable -> L30
        serviceConnector.setServiceLifecycleCallbacks(new AnonymousClass2(this, componentName, userId));     // Catch: Throwable -> L30
        serviceConnector.connect();     // Catch: Throwable -> L30
        monitor-exit(r7);     // Catch: Throwable -> L30
        Slog.i(TAG, "Successfully bound to Dependency Installer Service for user " + userId);
        return true;
    }
}
