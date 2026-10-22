package org.libpag;

import z2.l;

/* loaded from: classes4.dex */
public class PAGSolidLayer extends PAGLayer {
    static {
        l.j("pag");
        nativeInit();
    }

    public PAGSolidLayer(long j5) {
        super(j5);
    }

    private static native void nativeInit();

    public native void setSolidColor(int i);

    public native int solidColor();
}
