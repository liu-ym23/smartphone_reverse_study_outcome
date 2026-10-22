package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class SynchronizedCaptureSessionStateCallbacks extends SynchronizedCaptureSession.StateCallback {
    private final List<SynchronizedCaptureSession.StateCallback> mCallbacks;

    public static class Adapter extends SynchronizedCaptureSession.StateCallback {
        private final CameraCaptureSession.StateCallback mCameraCaptureSessionStateCallback;

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSessionFinished(SynchronizedCaptureSession r100) {
        }

        public Adapter(List<CameraCaptureSession.StateCallback> r100) {
            this(CameraCaptureSessionStateCallbacks.createComboCallback(r100));
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onActive(SynchronizedCaptureSession r100) {
            this.mCameraCaptureSessionStateCallback.onActive(r100.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onCaptureQueueEmpty(SynchronizedCaptureSession r100) {
            ApiCompat.Api26Impl.onCaptureQueueEmpty(this.mCameraCaptureSessionStateCallback, r100.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onClosed(SynchronizedCaptureSession r100) {
            this.mCameraCaptureSessionStateCallback.onClosed(r100.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigureFailed(SynchronizedCaptureSession r100) {
            this.mCameraCaptureSessionStateCallback.onConfigureFailed(r100.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigured(SynchronizedCaptureSession r100) {
            this.mCameraCaptureSessionStateCallback.onConfigured(r100.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onReady(SynchronizedCaptureSession r100) {
            this.mCameraCaptureSessionStateCallback.onReady(r100.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public Adapter(CameraCaptureSession.StateCallback r100) {
            this.mCameraCaptureSessionStateCallback = r100;
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSurfacePrepared(SynchronizedCaptureSession r100, Surface r101) {
            ApiCompat.Api23Impl.onSurfacePrepared(this.mCameraCaptureSessionStateCallback, r100.toCameraCaptureSessionCompat().toCameraCaptureSession(), r101);
        }
    }

    public SynchronizedCaptureSessionStateCallbacks(List<SynchronizedCaptureSession.StateCallback> r100) {
        ArrayList r101 = new ArrayList();
        this.mCallbacks = r101;
        r101.addAll(r100);
    }

    public static SynchronizedCaptureSession.StateCallback createComboCallback(SynchronizedCaptureSession.StateCallback... r100) {
        return new SynchronizedCaptureSessionStateCallbacks(Arrays.asList(r100));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onActive(SynchronizedCaptureSession r100) {
        Iterator<SynchronizedCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onActive(r100);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onCaptureQueueEmpty(SynchronizedCaptureSession r100) {
        Iterator<SynchronizedCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onCaptureQueueEmpty(r100);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(SynchronizedCaptureSession r100) {
        Iterator<SynchronizedCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onClosed(r100);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigureFailed(SynchronizedCaptureSession r100) {
        Iterator<SynchronizedCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onConfigureFailed(r100);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(SynchronizedCaptureSession r100) {
        Iterator<SynchronizedCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onConfigured(r100);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onReady(SynchronizedCaptureSession r100) {
        Iterator<SynchronizedCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onReady(r100);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onSessionFinished(SynchronizedCaptureSession r100) {
        Iterator<SynchronizedCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onSessionFinished(r100);
        goto L4
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onSurfacePrepared(SynchronizedCaptureSession r100, Surface r101) {
        Iterator<SynchronizedCaptureSession.StateCallback> r102 = this.mCallbacks.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onSurfacePrepared(r100, r101);
        goto L4
    }
}
