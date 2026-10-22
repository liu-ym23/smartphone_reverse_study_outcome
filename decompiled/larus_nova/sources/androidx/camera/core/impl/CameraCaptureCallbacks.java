package androidx.camera.core.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraCaptureCallbacks {

    public static final class ComboCameraCaptureCallback extends CameraCaptureCallback {
        private final List<CameraCaptureCallback> mCallbacks;

        public List<CameraCaptureCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public ComboCameraCaptureCallback(List<CameraCaptureCallback> r100) {
            this.mCallbacks = new ArrayList();
            Iterator<CameraCaptureCallback> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            CameraCaptureCallback r102 = r101.next();
            if ((r102 instanceof NoOpCameraCaptureCallback) == true) goto L4;
            this.mCallbacks.add(r102);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCancelled(int r100) {
            Iterator<CameraCaptureCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onCaptureCancelled(r100);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureStarted(int r100) {
            Iterator<CameraCaptureCallback> r101 = this.mCallbacks.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().onCaptureStarted(r100);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(int r100, CameraCaptureResult r101) {
            Iterator<CameraCaptureCallback> r102 = this.mCallbacks.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onCaptureCompleted(r100, r101);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(int r100, CameraCaptureFailure r101) {
            Iterator<CameraCaptureCallback> r102 = this.mCallbacks.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onCaptureFailed(r100, r101);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureProcessProgressed(int r100, int r101) {
            Iterator<CameraCaptureCallback> r102 = this.mCallbacks.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onCaptureProcessProgressed(r100, r101);
            goto L4
        }
    }

    public static final class NoOpCameraCaptureCallback extends CameraCaptureCallback {
        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(int r100, CameraCaptureResult r101) {
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(int r100, CameraCaptureFailure r101) {
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureStarted(int r100) {
        }

        public NoOpCameraCaptureCallback() {
        }
    }

    public static CameraCaptureCallback createNoOpCallback() {
        return new NoOpCameraCaptureCallback();
    }

    private CameraCaptureCallbacks() {
    }

    public static CameraCaptureCallback createComboCallback(List<CameraCaptureCallback> r100) {
        if (r100.isEmpty() == false) goto L7;
        return createNoOpCallback();
    L7:
        if (r100.size() != 1) goto L11;
        return (CameraCaptureCallback) ListProtector.get(r100, 0);
    L11:
        return new ComboCameraCaptureCallback(r100);
    }

    public static CameraCaptureCallback createComboCallback(CameraCaptureCallback... r100) {
        return createComboCallback(Arrays.asList(r100));
    }
}
