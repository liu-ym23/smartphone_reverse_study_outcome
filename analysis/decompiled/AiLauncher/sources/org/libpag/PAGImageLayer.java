package org.libpag;

import gc.AbstractC4115a;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class PAGImageLayer extends PAGLayer {
    static {
        AbstractC4115a.e("pag");
        nativeInit();
    }

    public PAGImageLayer(long j10) {
        super(j10);
    }

    public static PAGImageLayer Make(int i10, int i11, long j10) {
        long jNativeMake = nativeMake(i10, i11, j10);
        if (jNativeMake == 0) {
            return null;
        }
        return new PAGImageLayer(jNativeMake);
    }

    private static native void nativeInit();

    private static native long nativeMake(int i10, int i11, long j10);

    private native void replaceImage(long j10);

    private native void setImage(long j10);

    public native long contentDuration();

    public native PAGVideoRange[] getVideoRanges();

    public native ByteBuffer imageBytes();

    public void replaceImage(PAGImage pAGImage) {
        replaceImage(pAGImage == null ? 0L : pAGImage.nativeContext);
    }

    public void setImage(PAGImage pAGImage) {
        setImage(pAGImage == null ? 0L : pAGImage.nativeContext);
    }
}
