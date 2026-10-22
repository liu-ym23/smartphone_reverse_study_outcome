package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class JpegMetadataCorrector {
    private final IncorrectJpegMetadataQuirk mQuirk;

    public boolean needCorrectJpegMetadata() {
        if (this.mQuirk == null) goto L5;
        return true;
    L5:
        return false;
    }

    public JpegMetadataCorrector(Quirks r100) {
        this.mQuirk = (IncorrectJpegMetadataQuirk) r100.get(IncorrectJpegMetadataQuirk.class);
    }

    public byte[] jpegImageToJpegByteArray(ImageProxy r100) {
        IncorrectJpegMetadataQuirk r101 = this.mQuirk;
        if (r101 != null) goto L7;
        ByteBuffer r102 = r100.getPlanes()[0].getBuffer();
        byte[] r103 = new byte[r102.capacity()];
        r102.rewind();
        r102.get(r103);
        return r103;
    L7:
        return r101.jpegImageToJpegByteArray(r100);
    }
}
