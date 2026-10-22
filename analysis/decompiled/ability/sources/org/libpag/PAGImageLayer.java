package org.libpag;

import java.nio.ByteBuffer;
import z2.l;

/* loaded from: classes4.dex */
public class PAGImageLayer extends PAGLayer {
    static {
        l.j("pag");
        nativeInit();
    }

    public PAGImageLayer(long j5) {
        super(j5);
    }

    public static PAGImageLayer Make(int i, int i6, long j5) {
        long jNativeMake = nativeMake(i, i6, j5);
        if (jNativeMake == 0) {
            return null;
        }
        return new PAGImageLayer(jNativeMake);
    }

    private static native void nativeInit();

    private static native long nativeMake(int i, int i6, long j5);

    private native void replaceImage(long j5);

    private native void setImage(long j5);

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
