package org.libpag;

import z2.l;

/* loaded from: classes4.dex */
public abstract class VideoDecoder {
    static {
        l.j("pag");
    }

    public static native void RegisterSoftwareDecoderFactory(long j5);

    public static native void SetMaxHardwareDecoderCount(int i);
}
