package com.android.server.rotationresolver;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.rotationresolver.RotationResolverInternal;
import android.service.rotationresolver.RotationResolutionRequest;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.util.LatencyTracker;
import com.android.server.infra.AbstractPerUserSystemService;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
final class RotationResolverManagerPerUserService extends AbstractPerUserSystemService<RotationResolverManagerPerUserService, RotationResolverManagerService> {
    private static final long CONNECTION_TTL_MILLIS = 60000;
    private static final String TAG = null;
    private ComponentName mComponentName;
    RemoteRotationResolverService.RotationRequest mCurrentRequest;
    private LatencyTracker mLatencyTracker;
    RemoteRotationResolverService mRemoteService;

    public static /* synthetic */ void $r8$lambda$m6ZojQSXE2L2OOpyDQ0ZRKjjQWA(RotationResolverManagerPerUserService r0) {
        r0.lambda$resolveRotationLocked$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLatencyTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ LatencyTracker m8005$$Nest$fgetmLatencyTracker(RotationResolverManagerPerUserService r0) {
        return r0.mLatencyTracker;
    }

    static {
        TAG = RotationResolverManagerPerUserService.class.getSimpleName();
    }

    RotationResolverManagerPerUserService(RotationResolverManagerService main, Object lock, int userId) {
        super(main, lock, userId);
        this.mLatencyTracker = LatencyTracker.getInstance(getContext());
    }

    void destroyLocked() {
        if (isVerbose() == false) goto L6;
        Slog.v(TAG, "destroyLocked()");
    L6:
        if (this.mCurrentRequest != null) goto L8;
        return;
    L8:
        Slog.d(TAG, "Trying to cancel the remote request. Reason: Service destroyed.");
        cancelLocked();
        if (this.mRemoteService == null) goto L12;
        this.mRemoteService.unbind();
        this.mRemoteService = null;
        return;
    }

    void resolveRotationLocked(final RotationResolverInternal.RotationResolverCallbackInternal callbackInternal, RotationResolutionRequest request, CancellationSignal cancellationSignalInternal) {
        if (isServiceAvailableLocked() == true) goto L6;
        Slog.w(TAG, "Service is not available at this moment.");
        callbackInternal.onFailure(0);
        RotationResolverManagerService.logRotationStats(request.getProposedRotation(), request.getCurrentRotation(), 7);
        return;
    L6:
        ensureRemoteServiceInitiated();
        if (this.mCurrentRequest != null) goto L9;
    L11:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLatencyTracker.onActionStart(9);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        RotationResolverInternal.RotationResolverCallbackInternal wrapper = new AnonymousClass1(this, callbackInternal);
        this.mCurrentRequest = new RemoteRotationResolverService.RotationRequest(wrapper, request, cancellationSignalInternal, this.mLock);
        cancellationSignalInternal.setOnCancelListener(new RotationResolverManagerPerUserService$$ExternalSyntheticLambda0(this));
        this.mRemoteService.resolveRotation(this.mCurrentRequest);
        this.mCurrentRequest.mIsDispatched = true;
        return;
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.mCurrentRequest.mIsFulfilled == true) goto L11;
        cancelLocked();
        goto L11
    }

    private /* synthetic */ void lambda$resolveRotationLocked$0() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentRequest != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mCurrentRequest.mIsFulfilled == true) goto L11;
        Slog.d(TAG, "Trying to cancel the remote request. Reason: Client cancelled.");     // Catch: Throwable -> L9
        this.mCurrentRequest.cancelInternal();     // Catch: Throwable -> L9
        goto L11
    }

    private void ensureRemoteServiceInitiated() {
        if (this.mRemoteService != null) goto L6;
        this.mRemoteService = new RemoteRotationResolverService(getContext(), this.mComponentName, getUserId(), 60000);
        return;
    }

    ComponentName getComponentName() {
        return this.mComponentName;
    }

    boolean isServiceAvailableLocked() {
        if (this.mComponentName != null) goto L6;
        this.mComponentName = updateServiceInfoLocked();
    L6:
        if (this.mComponentName == null) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 128, this.mUserId);     // Catch: RemoteException -> L10
        if (serviceInfo == null) goto L13;
        String permission = serviceInfo.permission;     // Catch: RemoteException -> L10
        if ("android.permission.BIND_ROTATION_RESOLVER_SERVICE".equals(permission) == true) goto L13;
        throw new SecurityException(String.format("Service %s requires %s permission. Found %s permission", new Object[]{serviceInfo.getComponentName(), "android.permission.BIND_ROTATION_RESOLVER_SERVICE", serviceInfo.permission}));     // Catch: RemoteException -> L10
    L13:
        return serviceInfo;
    L15:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    private void cancelLocked() {
        if (this.mCurrentRequest != null) goto L5;
        return;
    L5:
        this.mCurrentRequest.cancelInternal();
        this.mCurrentRequest = null;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected void dumpLocked(String prefix, PrintWriter pw) {
        super.dumpLocked(prefix, pw);
        dumpInternal(new IndentingPrintWriter(pw, "  "));
    }

    void dumpInternal(IndentingPrintWriter ipw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteService == null) goto L10;
        this.mRemoteService.dump("", ipw);     // Catch: Throwable -> L7
    L10:
        if (this.mCurrentRequest == null) goto L12;
        this.mCurrentRequest.dump(ipw);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }
}
