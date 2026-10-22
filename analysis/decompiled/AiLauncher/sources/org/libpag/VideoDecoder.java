package org.libpag;

import gc.AbstractC4115a;

/* loaded from: classes5.dex */
public abstract class VideoDecoder {
    static {
        AbstractC4115a.e("pag");
    }

    public static native void RegisterSoftwareDecoderFactory(long j10);

    public static native void SetMaxHardwareDecoderCount(int i10);
}
