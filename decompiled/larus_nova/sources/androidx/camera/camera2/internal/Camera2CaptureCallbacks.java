package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Camera2CaptureCallbacks {

    public static final class ComboSessionCaptureCallback extends CameraCaptureSession.CaptureCallback {
        private final List<CameraCaptureSession.CaptureCallback> mCallbacks;

        public ComboSessionCaptureCallback(List<CameraCaptureSession.CaptureCallback> r100) {
            this.mCallbacks = new ArrayList();
            Iterator<CameraCaptureSession.CaptureCallback> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            CameraCaptureSession.CaptureCallback r102 = r101.next();
            if ((r102 instanceof NoOpSessionCaptureCallback) == true) goto L4;
            this.mCallbacks.add(r102);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession r100, int r101) {
            Iterator<CameraCaptureSession.CaptureCallback> r102 = this.mCallbacks.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onCaptureSequenceAborted(r100, r101);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession r100, CaptureRequest r101, TotalCaptureResult r102) {
            Iterator<CameraCaptureSession.CaptureCallback> r103 = this.mCallbacks.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r103.next().onCaptureCompleted(r100, r101, r102);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession r100, CaptureRequest r101, CaptureFailure r102) {
            Iterator<CameraCaptureSession.CaptureCallback> r103 = this.mCallbacks.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r103.next().onCaptureFailed(r100, r101, r102);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession r100, CaptureRequest r101, CaptureResult r102) {
            Iterator<CameraCaptureSession.CaptureCallback> r103 = this.mCallbacks.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r103.next().onCaptureProgressed(r100, r101, r102);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession r100, int r101, long r102) {
            Iterator<CameraCaptureSession.CaptureCallback> r103 = this.mCallbacks.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r103.next().onCaptureSequenceCompleted(r100, r101, r102);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(CameraCaptureSession r100, CaptureRequest r110, Surface r111, long r112) {
            Iterator<CameraCaptureSession.CaptureCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ApiCompat.Api24Impl.onCaptureBufferLost(r101.next(), r100, r110, r111, r112);
            goto L4
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession r110, CaptureRequest r111, long r112, long r113) {
            Iterator<CameraCaptureSession.CaptureCallback> r100 = this.mCallbacks.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().onCaptureStarted(r110, r111, r112, r113);
            goto L4
        }
    }

    public static final class NoOpSessionCaptureCallback extends CameraCaptureSession.CaptureCallback {
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(CameraCaptureSession r100, CaptureRequest r101, Surface r102, long r103) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession r100, CaptureRequest r101, TotalCaptureResult r102) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession r100, CaptureRequest r101, CaptureFailure r102) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession r100, CaptureRequest r101, CaptureResult r102) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession r100, int r101) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession r100, int r101, long r102) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession r100, CaptureRequest r101, long r102, long r103) {
        }

        public NoOpSessionCaptureCallback() {
        }
    }

    public static CameraCaptureSession.CaptureCallback createNoOpCallback() {
        return new NoOpSessionCaptureCallback();
    }

    private Camera2CaptureCallbacks() {
    }

    public static CameraCaptureSession.CaptureCallback createComboCallback(CameraCaptureSession.CaptureCallback... r100) {
        return createComboCallback(Arrays.asList(r100));
    }

    public static CameraCaptureSession.CaptureCallback createComboCallback(List<CameraCaptureSession.CaptureCallback> r100) {
        return new ComboSessionCaptureCallback(r100);
    }
}
