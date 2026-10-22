package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class CaptureCallbackConverter {
    private CaptureCallbackConverter() {
    }

    public static CameraCaptureSession.CaptureCallback toCaptureCallback(CameraCaptureCallback r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        toCaptureCallback(r100, r101);
        if (r101.size() != 1) goto L9;
        return (CameraCaptureSession.CaptureCallback) ListProtector.get(r101, 0);
    L9:
        return Camera2CaptureCallbacks.createComboCallback(r101);
    }

    public static void toCaptureCallback(CameraCaptureCallback r100, List<CameraCaptureSession.CaptureCallback> r101) {
        if ((r100 instanceof CameraCaptureCallbacks.ComboCameraCaptureCallback) == false) goto L9;
        Iterator<CameraCaptureCallback> r102 = ((CameraCaptureCallbacks.ComboCameraCaptureCallback) r100).getCallbacks().iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        toCaptureCallback(r102.next(), r101);
        goto L6
    L15:
        return;
    L9:
        if ((r100 instanceof CaptureCallbackContainer) == false) goto L11;
        r101.add(((CaptureCallbackContainer) r100).getCaptureCallback());
        return;
    L11:
        r101.add(new CaptureCallbackAdapter(r100));
    }
}
