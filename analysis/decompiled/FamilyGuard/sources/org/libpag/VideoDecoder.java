package org.libpag;

/* loaded from: classes.dex */
public abstract class VideoDecoder {
    static {
        P4.a.a("pag");
    }

    public static native void RegisterSoftwareDecoderFactory(long j5);

    public static native void SetMaxHardwareDecoderCount(int i5);
}
