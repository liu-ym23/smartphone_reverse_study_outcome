package org.libpag;

/* loaded from: classes.dex */
public class PAGSolidLayer extends PAGLayer {
    static {
        P4.a.a("pag");
        nativeInit();
    }

    public PAGSolidLayer(long j5) {
        super(j5);
    }

    private static native void nativeInit();

    public native void setSolidColor(int i5);

    public native int solidColor();
}
