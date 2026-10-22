package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2182a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f2183b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f2182a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f2183b = cls2 != null;
    }

    public static boolean a() {
        return (f2182a == null || f2183b) ? false : true;
    }
}
