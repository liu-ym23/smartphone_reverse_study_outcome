package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class CameraBurstCaptureCallback extends CameraCaptureSession.CaptureCallback {
    final Map<CaptureRequest, List<CameraCaptureSession.CaptureCallback>> mCallbackMap;
    CaptureSequenceCallback mCaptureSequenceCallback;

    public interface CaptureSequenceCallback {
        void onCaptureSequenceCompletedOrAborted(CameraCaptureSession r100, int r101, boolean r102);
    }

    public CameraBurstCaptureCallback() {
        this.mCaptureSequenceCallback = null;
        this.mCallbackMap = new HashMap();
    }

    private List<CameraCaptureSession.CaptureCallback> getCallbacks(CaptureRequest r100) {
        List<CameraCaptureSession.CaptureCallback> r101 = this.mCallbackMap.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return Collections.emptyList();
    }

    public void setCaptureSequenceCallback(CaptureSequenceCallback r100) {
        this.mCaptureSequenceCallback = r100;
    }

    public void addCamera2Callbacks(CaptureRequest r100, List<CameraCaptureSession.CaptureCallback> r101) {
        List<CameraCaptureSession.CaptureCallback> r102 = this.mCallbackMap.get(r100);
        if (r102 == null) goto L5;
        ArrayList r103 = new ArrayList(r101.size() + r102.size());
        r103.addAll(r101);
        r103.addAll(r102);
        this.mCallbackMap.put(r100, r103);
        return;
    L5:
        this.mCallbackMap.put(r100, r101);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession r100, int r101) {
        Iterator<List<CameraCaptureSession.CaptureCallback>> r102 = this.mCallbackMap.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Iterator<CameraCaptureSession.CaptureCallback> r103 = r102.next().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        r103.next().onCaptureSequenceAborted(r100, r101);
        goto L7
    L9:
        CaptureSequenceCallback r104 = this.mCaptureSequenceCallback;
        if (r104 == null) goto L15;
        r104.onCaptureSequenceCompletedOrAborted(r100, r101, true);
        return;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession r100, CaptureRequest r101, TotalCaptureResult r102) {
        Iterator<CameraCaptureSession.CaptureCallback> r103 = getCallbacks(r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onCaptureCompleted(r100, r101, r102);
        goto L4
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession r100, CaptureRequest r101, CaptureFailure r102) {
        Iterator<CameraCaptureSession.CaptureCallback> r103 = getCallbacks(r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onCaptureFailed(r100, r101, r102);
        goto L4
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession r100, CaptureRequest r101, CaptureResult r102) {
        Iterator<CameraCaptureSession.CaptureCallback> r103 = getCallbacks(r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onCaptureProgressed(r100, r101, r102);
        goto L4
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(CameraCaptureSession r100, int r101, long r102) {
        Iterator<List<CameraCaptureSession.CaptureCallback>> r103 = this.mCallbackMap.values().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Iterator<CameraCaptureSession.CaptureCallback> r104 = r103.next().iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        r104.next().onCaptureSequenceCompleted(r100, r101, r102);
        goto L7
    L9:
        CaptureSequenceCallback r105 = this.mCaptureSequenceCallback;
        if (r105 == null) goto L15;
        r105.onCaptureSequenceCompletedOrAborted(r100, r101, false);
        return;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(CameraCaptureSession r100, CaptureRequest r110, Surface r111, long r112) {
        Iterator<CameraCaptureSession.CaptureCallback> r101 = getCallbacks(r110).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ApiCompat.Api24Impl.onCaptureBufferLost(r101.next(), r100, r110, r111, r112);
        goto L4
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession r110, CaptureRequest r111, long r112, long r113) {
        Iterator<CameraCaptureSession.CaptureCallback> r100 = getCallbacks(r111).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onCaptureStarted(r110, r111, r112, r113);
        goto L4
    }
}
