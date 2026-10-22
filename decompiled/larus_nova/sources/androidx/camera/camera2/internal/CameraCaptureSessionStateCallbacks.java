package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraCaptureSessionStateCallbacks {

    public static final class ComboSessionStateCallback extends CameraCaptureSession.StateCallback {
        private final List<CameraCaptureSession.StateCallback> mCallbacks;

        public ComboSessionStateCallback(List<CameraCaptureSession.StateCallback> r100) {
            this.mCallbacks = new ArrayList();
            Iterator<CameraCaptureSession.StateCallback> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            CameraCaptureSession.StateCallback r102 = r101.next();
            if ((r102 instanceof NoOpSessionStateCallback) == true) goto L4;
            this.mCallbacks.add(r102);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(CameraCaptureSession r100) {
            Iterator<CameraCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onActive(r100);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(CameraCaptureSession r100) {
            Iterator<CameraCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ApiCompat.Api26Impl.onCaptureQueueEmpty(r101.next(), r100);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession r100) {
            Iterator<CameraCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onClosed(r100);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession r100) {
            Iterator<CameraCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onConfigureFailed(r100);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession r100) {
            Iterator<CameraCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onConfigured(r100);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(CameraCaptureSession r100) {
            Iterator<CameraCaptureSession.StateCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onReady(r100);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(CameraCaptureSession r100, Surface r101) {
            Iterator<CameraCaptureSession.StateCallback> r102 = this.mCallbacks.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ApiCompat.Api23Impl.onSurfacePrepared(r102.next(), r100, r101);
            goto L4
        }
    }

    public static final class NoOpSessionStateCallback extends CameraCaptureSession.StateCallback {
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(CameraCaptureSession r100) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(CameraCaptureSession r100) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession r100) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession r100) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession r100) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(CameraCaptureSession r100) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(CameraCaptureSession r100, Surface r101) {
        }

        public NoOpSessionStateCallback() {
        }
    }

    public static CameraCaptureSession.StateCallback createNoOpCallback() {
        return new NoOpSessionStateCallback();
    }

    private CameraCaptureSessionStateCallbacks() {
    }

    public static CameraCaptureSession.StateCallback createComboCallback(List<CameraCaptureSession.StateCallback> r100) {
        if (r100.isEmpty() == false) goto L7;
        return createNoOpCallback();
    L7:
        if (r100.size() != 1) goto L11;
        return (CameraCaptureSession.StateCallback) ListProtector.get(r100, 0);
    L11:
        return new ComboSessionStateCallback(r100);
    }

    public static CameraCaptureSession.StateCallback createComboCallback(CameraCaptureSession.StateCallback... r100) {
        return createComboCallback(Arrays.asList(r100));
    }
}
