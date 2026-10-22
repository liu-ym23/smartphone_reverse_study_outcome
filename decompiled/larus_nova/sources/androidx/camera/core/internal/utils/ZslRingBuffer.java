package androidx.camera.core.internal.utils;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;

/* JADX INFO: loaded from: classes2.dex */
public final class ZslRingBuffer extends ArrayRingBuffer<ImageProxy> {
    private boolean isValidZslFrame(ImageInfo r100) {
        CameraCaptureResult r101 = CameraCaptureResults.retrieveCameraCaptureResult(r100);
        if (r101.getAfState() == CameraCaptureMetaData.AfState.LOCKED_FOCUSED) goto L8;
        if (r101.getAfState() == CameraCaptureMetaData.AfState.PASSIVE_FOCUSED) goto L8;
        return false;
    L8:
        if (r101.getAeState() == CameraCaptureMetaData.AeState.CONVERGED) goto L11;
        return false;
    L11:
        if (r101.getAwbState() == CameraCaptureMetaData.AwbState.CONVERGED) goto L13;
        return false;
    L13:
        return true;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void enqueue(ImageProxy r100) {
        if (isValidZslFrame(r100.getImageInfo()) == false) goto L5;
        super.enqueue(r100);
        return;
    L5:
        this.mOnRemoveCallback.onRemove((T) r100);
    }

    @Override // androidx.camera.core.internal.utils.ArrayRingBuffer, androidx.camera.core.internal.utils.RingBuffer
    public /* bridge */ /* synthetic */ void enqueue(Object r100) {
        enqueue((ImageProxy) r100);
    }

    public ZslRingBuffer(int r100, RingBuffer.OnRemoveCallback<ImageProxy> r101) {
        super(r100, r101);
    }
}
