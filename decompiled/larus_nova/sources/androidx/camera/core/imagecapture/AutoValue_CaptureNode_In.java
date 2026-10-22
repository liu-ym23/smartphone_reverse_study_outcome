package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.processing.Edge;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_CaptureNode_In extends CaptureNode.In {
    private final Edge<TakePictureManager.CaptureError> errorEdge;
    private final ImageReaderProxyProvider imageReaderProxyProvider;
    private final int inputFormat;
    private final int outputFormat;
    private final int postviewImageFormat;
    private final Size postviewSize;
    private final Edge<ProcessingRequest> requestEdge;
    private final Size size;
    private final boolean virtualCamera;

    public int hashCode() {
        int r100 = (((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat) * 1000003;
        if (this.virtualCamera == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 ^ r101) * 1000003;
        ImageReaderProxyProvider r103 = this.imageReaderProxyProvider;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 ^ r105) * 1000003;
        Size r107 = this.postviewSize;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return ((((((r106 ^ r104) * 1000003) ^ this.postviewImageFormat) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.errorEdge.hashCode();
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "In{size=" + this.size + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + ", virtualCamera=" + this.virtualCamera + ", imageReaderProxyProvider=" + this.imageReaderProxyProvider + ", postviewSize=" + this.postviewSize + ", postviewImageFormat=" + this.postviewImageFormat + ", requestEdge=" + this.requestEdge + ", errorEdge=" + this.errorEdge + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Edge<TakePictureManager.CaptureError> getErrorEdge() {
        return this.errorEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return this.imageReaderProxyProvider;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public int getPostviewImageFormat() {
        return this.postviewImageFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Size getPostviewSize() {
        return this.postviewSize;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public boolean isVirtualCamera() {
        return this.virtualCamera;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CaptureNode.In) == false) goto L38;
        CaptureNode.In r101 = (CaptureNode.In) r100;
        if (this.size.equals(r101.getSize()) == true) goto L10;
    L36:
        return false;
    L10:
        if (this.inputFormat != r101.getInputFormat()) goto L36;
        if (this.outputFormat != r101.getOutputFormat()) goto L36;
        if (this.virtualCamera != r101.isVirtualCamera()) goto L36;
        ImageReaderProxyProvider r102 = this.imageReaderProxyProvider;
        if (r102 != null) goto L21;
        if (r101.getImageReaderProxyProvider() != null) goto L36;
    L22:
        Size r103 = this.postviewSize;
        if (r103 != null) goto L28;
        if (r101.getPostviewSize() != null) goto L36;
    L30:
        if (this.postviewImageFormat != r101.getPostviewImageFormat()) goto L36;
        if (this.requestEdge.equals(r101.getRequestEdge()) == false) goto L36;
        if (this.errorEdge.equals(r101.getErrorEdge()) == false) goto L36;
        return true;
    L28:
        if (r103.equals(r101.getPostviewSize()) == false) goto L36;
    L21:
        if (r102.equals(r101.getImageReaderProxyProvider()) == false) goto L36;
    L38:
        return false;
    }

    public AutoValue_CaptureNode_In(Size r100, int r101, int r102, boolean r103, ImageReaderProxyProvider r104, Size r105, int r106, Edge<ProcessingRequest> r107, Edge<TakePictureManager.CaptureError> r108) {
        if (r100 == null) goto L15;
        this.size = r100;
        this.inputFormat = r101;
        this.outputFormat = r102;
        this.virtualCamera = r103;
        this.imageReaderProxyProvider = r104;
        this.postviewSize = r105;
        this.postviewImageFormat = r106;
        if (r107 == null) goto L13;
        this.requestEdge = r107;
        if (r108 == null) goto L11;
        this.errorEdge = r108;
        return;
    L11:
        throw new NullPointerException("Null errorEdge");
    L13:
        throw new NullPointerException("Null requestEdge");
    L15:
        throw new NullPointerException("Null size");
    }
}
