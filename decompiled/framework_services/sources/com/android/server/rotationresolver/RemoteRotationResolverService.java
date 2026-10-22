package com.android.server.rotationresolver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.ICancellationSignal;
import android.os.RemoteException;
import android.os.SystemClock;
import android.rotationresolver.RotationResolverInternal;
import android.service.rotationresolver.IRotationResolverCallback;
import android.service.rotationresolver.IRotationResolverService;
import android.service.rotationresolver.RotationResolutionRequest;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
class RemoteRotationResolverService extends ServiceConnector.Impl<IRotationResolverService> {
    private static final String TAG = null;
    private final long mIdleUnbindTimeoutMs;

    static final class RotationRequest {
        final RotationResolverInternal.RotationResolverCallbackInternal mCallbackInternal;
        private ICancellationSignal mCancellation;
        private final CancellationSignal mCancellationSignalInternal;
        private final IRotationResolverCallback mIRotationResolverCallback;
        boolean mIsDispatched;
        boolean mIsFulfilled;
        private final Object mLock;
        final RotationResolutionRequest mRemoteRequest;
        private final long mRequestStartTimeMillis;

        private static class RotationResolverCallback extends IRotationResolverCallback.Stub {
            private final WeakReference<RotationRequest> mRequestWeakReference;

            RotationResolverCallback(RotationRequest request) {
                this.mRequestWeakReference = new WeakReference(request);
            }

            public void onSuccess(int rotation) {
                RotationRequest request = this.mRequestWeakReference.get();
                Object r1 = RotationRequest.m8002$$Nest$fgetmLock(request);
                monitor-enter(r1);
            L9:
                th = move-exception;
                throw th;
            L5:
                if (request.mIsFulfilled == false) goto L11;
                Slog.w(RemoteRotationResolverService.m7998$$Nest$sfgetTAG(), "Callback received after the rotation request is fulfilled.");     // Catch: Throwable -> L9
                monitor-exit(r1);     // Catch: Throwable -> L9
                return;
            L11:
                request.mIsFulfilled = true;     // Catch: Throwable -> L9
                request.mCallbackInternal.onSuccess(rotation);     // Catch: Throwable -> L9
                long timeToCalculate = SystemClock.elapsedRealtime() - RotationRequest.m8003$$Nest$fgetmRequestStartTimeMillis(request);     // Catch: Throwable -> L9
                RotationResolverManagerService.logRotationStatsWithTimeToCalculate(request.mRemoteRequest.getProposedRotation(), request.mRemoteRequest.getCurrentRotation(), RotationResolverManagerService.surfaceRotationToProto(rotation), timeToCalculate);     // Catch: Throwable -> L9
                Slog.d(RemoteRotationResolverService.m7998$$Nest$sfgetTAG(), "onSuccess:" + rotation);     // Catch: Throwable -> L9
                Slog.d(RemoteRotationResolverService.m7998$$Nest$sfgetTAG(), "timeToCalculate:" + timeToCalculate);     // Catch: Throwable -> L9
                monitor-exit(r1);     // Catch: Throwable -> L9
            }

            public void onFailure(int error) {
                RotationRequest request = this.mRequestWeakReference.get();
                Object r1 = RotationRequest.m8002$$Nest$fgetmLock(request);
                monitor-enter(r1);
            L9:
                th = move-exception;
                throw th;
            L5:
                if (request.mIsFulfilled == false) goto L11;
                Slog.w(RemoteRotationResolverService.m7998$$Nest$sfgetTAG(), "Callback received after the rotation request is fulfilled.");     // Catch: Throwable -> L9
                monitor-exit(r1);     // Catch: Throwable -> L9
                return;
            L11:
                request.mIsFulfilled = true;     // Catch: Throwable -> L9
                request.mCallbackInternal.onFailure(error);     // Catch: Throwable -> L9
                long timeToCalculate = SystemClock.elapsedRealtime() - RotationRequest.m8003$$Nest$fgetmRequestStartTimeMillis(request);     // Catch: Throwable -> L9
                RotationResolverManagerService.logRotationStatsWithTimeToCalculate(request.mRemoteRequest.getProposedRotation(), request.mRemoteRequest.getCurrentRotation(), RotationResolverManagerService.errorCodeToProto(error), timeToCalculate);     // Catch: Throwable -> L9
                Slog.d(RemoteRotationResolverService.m7998$$Nest$sfgetTAG(), "onFailure:" + error);     // Catch: Throwable -> L9
                Slog.d(RemoteRotationResolverService.m7998$$Nest$sfgetTAG(), "timeToCalculate:" + timeToCalculate);     // Catch: Throwable -> L9
                monitor-exit(r1);     // Catch: Throwable -> L9
            }

            public void onCancellable(ICancellationSignal cancellation) {
                RotationRequest request = this.mRequestWeakReference.get();
                Object r1 = RotationRequest.m8002$$Nest$fgetmLock(request);
                monitor-enter(r1);
                RotationRequest.m8004$$Nest$fputmCancellation(request, cancellation);     // Catch: Throwable -> L8
                if (RotationRequest.m8000$$Nest$fgetmCancellationSignalInternal(request).isCanceled() == true) goto L16;
            L12:
                monitor-exit(r1);     // Catch: Throwable -> L8
                return;
            L16:
                cancellation.cancel();     // Catch: Throwable -> L8 RemoteException -> L10
            L11:
                Slog.w(RemoteRotationResolverService.m7998$$Nest$sfgetTAG(), "Failed to cancel the remote request.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$g6SaDq2-VvQsiD7b1ptGiUXnvgY, reason: not valid java name */
        public static /* synthetic */ void m7999$r8$lambda$g6SaDq2VvQsiD7b1ptGiUXnvgY(RotationRequest r0) {
            r0.lambda$cancelInternal$0();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCancellationSignalInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ CancellationSignal m8000$$Nest$fgetmCancellationSignalInternal(RotationRequest r0) {
            return r0.mCancellationSignalInternal;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIRotationResolverCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IRotationResolverCallback m8001$$Nest$fgetmIRotationResolverCallback(RotationRequest r0) {
            return r0.mIRotationResolverCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m8002$$Nest$fgetmLock(RotationRequest r0) {
            return r0.mLock;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRequestStartTimeMillis, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m8003$$Nest$fgetmRequestStartTimeMillis(RotationRequest r2) {
            return r2.mRequestStartTimeMillis;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCancellation, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8004$$Nest$fputmCancellation(RotationRequest r0, ICancellationSignal r1) {
            r0.mCancellation = r1;
        }

        RotationRequest(RotationResolverInternal.RotationResolverCallbackInternal callbackInternal, RotationResolutionRequest request, CancellationSignal cancellationSignal, Object lock) {
            this.mCallbackInternal = callbackInternal;
            this.mRemoteRequest = request;
            this.mIRotationResolverCallback = new RotationResolverCallback(this);
            this.mCancellationSignalInternal = cancellationSignal;
            this.mRequestStartTimeMillis = SystemClock.elapsedRealtime();
            this.mLock = lock;
        }

        void cancelInternal() {
            Handler.getMain().post(new RemoteRotationResolverService$RotationRequest$$ExternalSyntheticLambda0(this));
            this.mCallbackInternal.onFailure(0);
        }

        private /* synthetic */ void lambda$cancelInternal$0() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mIsFulfilled == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.mIsFulfilled = true;     // Catch: Throwable -> L8
            if (this.mCancellation == null) goto L20;
            this.mCancellation.cancel();     // Catch: Throwable -> L8 RemoteException -> L15
            this.mCancellation = null;     // Catch: Throwable -> L8 RemoteException -> L15
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L19:
            Slog.w(RemoteRotationResolverService.m7998$$Nest$sfgetTAG(), "Failed to cancel request in remote service.");     // Catch: Throwable -> L8
            goto L20
        }

        void dump(IndentingPrintWriter ipw) {
            ipw.increaseIndent();
            ipw.println("is dispatched=" + this.mIsDispatched);
            ipw.println("is fulfilled:=" + this.mIsFulfilled);
            ipw.decreaseIndent();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1q5v-f7vdoGGzMma_uCOJBQU82c, reason: not valid java name */
    public static /* synthetic */ void m7996$r8$lambda$1q5vf7vdoGGzMma_uCOJBQU82c(RotationRequest r0) {
        lambda$resolveRotation$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$7o-FVN7NKxotOI_pb5e3VKpf3z4, reason: not valid java name */
    public static /* synthetic */ void m7997$r8$lambda$7oFVN7NKxotOI_pb5e3VKpf3z4(RotationRequest r0, RotationResolutionRequest r1, IRotationResolverService r2) {
        lambda$resolveRotation$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7998$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = RemoteRotationResolverService.class.getSimpleName();
    }

    RemoteRotationResolverService(Context context, ComponentName serviceName, int userId, long idleUnbindTimeoutMs) {
        super(context, new Intent("android.service.rotationresolver.RotationResolverService").setComponent(serviceName), 67112960, userId, new RemoteRotationResolverService$$ExternalSyntheticLambda2());
        this.mIdleUnbindTimeoutMs = idleUnbindTimeoutMs;
        connect();
    }

    protected long getAutoDisconnectTimeoutMs() {
        return -1;
    }

    public void resolveRotation(final RotationRequest request) {
        final RotationResolutionRequest remoteRequest = request.mRemoteRequest;
        post(new RemoteRotationResolverService$$ExternalSyntheticLambda0(request, remoteRequest));
        getJobHandler().postDelayed(new RemoteRotationResolverService$$ExternalSyntheticLambda1(request), request.mRemoteRequest.getTimeoutMillis());
    }

    private static /* synthetic */ void lambda$resolveRotation$0(RotationRequest request, RotationResolutionRequest remoteRequest, IRotationResolverService service) throws Exception {
        service.resolveRotation(RotationRequest.m8001$$Nest$fgetmIRotationResolverCallback(request), remoteRequest);
    }

    private static /* synthetic */ void lambda$resolveRotation$1(RotationRequest request) {
        Object r0 = RotationRequest.m8002$$Nest$fgetmLock(request);
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (request.mIsFulfilled == true) goto L9;
        request.mCallbackInternal.onFailure(1);     // Catch: Throwable -> L7
        Slog.d(TAG, "Trying to cancel the remote request. Reason: Timed out.");     // Catch: Throwable -> L7
        request.cancelInternal();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }
}
