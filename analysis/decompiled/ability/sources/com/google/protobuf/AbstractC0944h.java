package com.google.protobuf;

/* renamed from: com.google.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0944h {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2921a;
    public static final boolean b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f2921a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        b = cls2 != null;
    }

    public static boolean a() {
        return (f2921a == null || b) ? false : true;
    }
}
