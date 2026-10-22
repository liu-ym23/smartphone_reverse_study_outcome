package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class CaptureSessionRepository {
    private final CameraDevice.StateCallback mCameraStateCallback;
    final Set<SynchronizedCaptureSession> mCaptureSessions;
    final Set<SynchronizedCaptureSession> mClosingCaptureSession;
    final Set<SynchronizedCaptureSession> mCreatingCaptureSessions;
    final Executor mExecutor;
    final Object mLock;

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.CaptureSessionRepository$1, reason: invalid class name */
    public class AnonymousClass1 extends CameraDevice.StateCallback {
        final /* synthetic */ CaptureSessionRepository this$0;

        public static /* synthetic */ void a(LinkedHashSet r100, int r101) {
            lambda$dispatchOnError$1(r100, r101);
        }

        public static /* synthetic */ void b(LinkedHashSet r100) {
            lambda$forceOnClosedCaptureSessions$0(r100);
        }

        private void cameraClosed() {
            Object r100 = this.this$0.mLock;
            monitor-enter(r100);
            List<SynchronizedCaptureSession> r101 = this.this$0.getSessionsInOrder();     // Catch: Throwable -> L11
            this.this$0.mCreatingCaptureSessions.clear();     // Catch: Throwable -> L11
            this.this$0.mCaptureSessions.clear();     // Catch: Throwable -> L11
            this.this$0.mClosingCaptureSession.clear();     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            Iterator<SynchronizedCaptureSession> r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L10;
            r102.next().finishClose();
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void forceOnClosedCaptureSessions() {
            final LinkedHashSet r100 = new LinkedHashSet();
            Object r101 = this.this$0.mLock;
            monitor-enter(r101);
            r100.addAll(this.this$0.mCreatingCaptureSessions);     // Catch: Throwable -> L8
            r100.addAll(this.this$0.mCaptureSessions);     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            this.this$0.mExecutor.execute(new c2(r100));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public AnonymousClass1(CaptureSessionRepository r100) {
            this.this$0 = r100;
        }

        private void dispatchOnError(final int r100) {
            final LinkedHashSet r101 = new LinkedHashSet();
            Object r102 = this.this$0.mLock;
            monitor-enter(r102);
            r101.addAll(this.this$0.mCreatingCaptureSessions);     // Catch: Throwable -> L8
            r101.addAll(this.this$0.mCaptureSessions);     // Catch: Throwable -> L8
            monitor-exit(r102);     // Catch: Throwable -> L8
            this.this$0.mExecutor.execute(new b2(r101, r100));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$forceOnClosedCaptureSessions$0(LinkedHashSet r100) {
            CaptureSessionRepository.forceOnClosed(r100);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice r100) {
            forceOnClosedCaptureSessions();
            cameraClosed();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice r100) {
            forceOnClosedCaptureSessions();
            cameraClosed();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice r110) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r110};
            f06.b r111 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE));
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r112 = r103;
            int r113 = r112.length;
            int r104 = 0;
        L8:
            if (r104 >= r113) goto L22;
            f06.a r105 = r112[r104];
            int r114 = r104;
            if (r105.preInvoke(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, "androidx/camera/camera2/internal/CaptureSessionRepository$1", "onOpened", this, r101, "void", r111).f474982a == true) goto L15;
            r100.add(r105);     // Catch: Exception -> L16
            goto L14
        L15:
            return;
        L14:
            r104 = r114 + 1;
            goto L8
        L22:
            return;
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        private static /* synthetic */ void lambda$dispatchOnError$1(LinkedHashSet r100, int r101) {
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((SynchronizedCaptureSession) r102.next()).onCameraDeviceError(r101);
            goto L4
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice r100, int r101) {
            forceOnClosedCaptureSessions();
            dispatchOnError(r101);
            cameraClosed();
        }
    }

    public List<SynchronizedCaptureSession> getCaptureSessions() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mCaptureSessions);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public List<SynchronizedCaptureSession> getClosingCaptureSession() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mClosingCaptureSession);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public List<SynchronizedCaptureSession> getCreatingCaptureSessions() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mCreatingCaptureSessions);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public List<SynchronizedCaptureSession> getSessionsInOrder() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L7
        r101.addAll(getCaptureSessions());     // Catch: Throwable -> L7
        r101.addAll(getCreatingCaptureSessions());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public CameraDevice.StateCallback getCameraStateCallback() {
        return this.mCameraStateCallback;
    }

    public CaptureSessionRepository(Executor r100) {
        this.mLock = new Object();
        this.mCaptureSessions = new LinkedHashSet();
        this.mClosingCaptureSession = new LinkedHashSet();
        this.mCreatingCaptureSessions = new LinkedHashSet();
        this.mCameraStateCallback = new AnonymousClass1(this);
        this.mExecutor = r100;
    }

    private void forceFinishCloseStaleSessions(SynchronizedCaptureSession r100) {
        Iterator<SynchronizedCaptureSession> r101 = getSessionsInOrder().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        SynchronizedCaptureSession r102 = r101.next();
        if (r102 == r100) goto L12;
        r102.finishClose();
        goto L4
    L12:
        return;
    }

    public static void forceOnClosed(Set<SynchronizedCaptureSession> r100) {
        Iterator<SynchronizedCaptureSession> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        SynchronizedCaptureSession r102 = r101.next();
        r102.getStateCallback().onClosed(r102);
        goto L4
    }

    public void onCaptureSessionClosed(SynchronizedCaptureSession r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mCaptureSessions.remove(r100);     // Catch: Throwable -> L7
        this.mClosingCaptureSession.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onCaptureSessionClosing(SynchronizedCaptureSession r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mClosingCaptureSession.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onCaptureSessionConfigureFail(SynchronizedCaptureSession r100) {
        forceFinishCloseStaleSessions(r100);
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mCreatingCaptureSessions.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onCaptureSessionCreated(SynchronizedCaptureSession r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mCaptureSessions.add(r100);     // Catch: Throwable -> L8
        this.mCreatingCaptureSessions.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        forceFinishCloseStaleSessions(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void onCreateCaptureSession(SynchronizedCaptureSession r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mCreatingCaptureSessions.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
