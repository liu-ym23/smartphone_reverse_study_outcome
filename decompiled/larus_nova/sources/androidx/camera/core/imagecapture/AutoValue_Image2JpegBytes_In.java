package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_Image2JpegBytes_In extends Image2JpegBytes.In {
    private final int jpegQuality;
    private final Packet<ImageProxy> packet;

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.jpegQuality;
    }

    public String toString() {
        return "In{packet=" + this.packet + ", jpegQuality=" + this.jpegQuality + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.imagecapture.Image2JpegBytes.In
    public int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.imagecapture.Image2JpegBytes.In
    public Packet<ImageProxy> getPacket() {
        return this.packet;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Image2JpegBytes.In) == false) goto L14;
        Image2JpegBytes.In r101 = (Image2JpegBytes.In) r100;
        if (this.packet.equals(r101.getPacket()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.jpegQuality != r101.getJpegQuality()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_Image2JpegBytes_In(Packet<ImageProxy> r100, int r101) {
        if (r100 == null) goto L7;
        this.packet = r100;
        this.jpegQuality = r101;
        return;
    L7:
        throw new NullPointerException("Null packet");
    }
}
