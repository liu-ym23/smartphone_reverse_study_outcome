package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_ProcessingNode_InputPacket extends ProcessingNode.InputPacket {
    private final ImageProxy imageProxy;
    private final ProcessingRequest processingRequest;

    public int hashCode() {
        return ((this.processingRequest.hashCode() ^ 1000003) * 1000003) ^ this.imageProxy.hashCode();
    }

    public String toString() {
        return "InputPacket{processingRequest=" + this.processingRequest + ", imageProxy=" + this.imageProxy + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.InputPacket
    public ImageProxy getImageProxy() {
        return this.imageProxy;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.InputPacket
    public ProcessingRequest getProcessingRequest() {
        return this.processingRequest;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProcessingNode.InputPacket) == false) goto L14;
        ProcessingNode.InputPacket r101 = (ProcessingNode.InputPacket) r100;
        if (this.processingRequest.equals(r101.getProcessingRequest()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.imageProxy.equals(r101.getImageProxy()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_ProcessingNode_InputPacket(ProcessingRequest r100, ImageProxy r101) {
        if (r100 == null) goto L11;
        this.processingRequest = r100;
        if (r101 == null) goto L9;
        this.imageProxy = r101;
        return;
    L9:
        throw new NullPointerException("Null imageProxy");
    L11:
        throw new NullPointerException("Null processingRequest");
    }
}
