package com.stepos.faiss;

/* loaded from: classes.dex */
public class Index {

    /* renamed from: a, reason: collision with root package name */
    public long f30126a;

    static {
        System.loadLibrary("faiss");
    }

    public Index() {
        this.f30126a = 0L;
        this.f30126a = create();
    }

    public static native void c_add(long j10, float[] fArr);

    private static native long[] c_search(long j10, float[] fArr, int i10, String str);

    private static native void c_write(long j10, String str);

    public static native long create();

    public static native String stringFromJNI(int i10);
}
