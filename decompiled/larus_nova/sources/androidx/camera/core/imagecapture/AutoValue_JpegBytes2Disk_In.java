package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_JpegBytes2Disk_In extends JpegBytes2Disk.In {
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final Packet<byte[]> packet;

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.outputFileOptions.hashCode();
    }

    public String toString() {
        return "In{packet=" + this.packet + ", outputFileOptions=" + this.outputFileOptions + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.imagecapture.JpegBytes2Disk.In
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.JpegBytes2Disk.In
    public Packet<byte[]> getPacket() {
        return this.packet;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof JpegBytes2Disk.In) == false) goto L14;
        JpegBytes2Disk.In r101 = (JpegBytes2Disk.In) r100;
        if (this.packet.equals(r101.getPacket()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.outputFileOptions.equals(r101.getOutputFileOptions()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_JpegBytes2Disk_In(Packet<byte[]> r100, ImageCapture.OutputFileOptions r101) {
        if (r100 == null) goto L11;
        this.packet = r100;
        if (r101 == null) goto L9;
        this.outputFileOptions = r101;
        return;
    L9:
        throw new NullPointerException("Null outputFileOptions");
    L11:
        throw new NullPointerException("Null packet");
    }
}
