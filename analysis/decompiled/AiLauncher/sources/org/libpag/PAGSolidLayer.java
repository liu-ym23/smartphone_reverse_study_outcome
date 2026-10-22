package org.libpag;

import gc.AbstractC4115a;

/* loaded from: classes5.dex */
public class PAGSolidLayer extends PAGLayer {
    static {
        AbstractC4115a.e("pag");
        nativeInit();
    }

    public PAGSolidLayer(long j10) {
        super(j10);
    }

    private static native void nativeInit();

    public native void setSolidColor(int i10);

    public native int solidColor();
}
