package org.libpag;

/* loaded from: classes.dex */
public class PAGTextLayer extends PAGLayer {
    static {
        P4.a.a("pag");
        nativeInit();
    }

    public PAGTextLayer(long j5) {
        super(j5);
    }

    private static native void nativeInit();

    private native void setFont(String str, String str2);

    public native int fillColor();

    public native PAGFont font();

    public native float fontSize();

    public native void reset();

    public native void setFillColor(int i5);

    public void setFont(PAGFont pAGFont) {
        setFont(pAGFont.fontFamily, pAGFont.fontStyle);
    }

    public native void setFontSize(float f5);

    public native void setStrokeColor(int i5);

    public native void setText(String str);

    public native int strokeColor();

    public native String text();
}
