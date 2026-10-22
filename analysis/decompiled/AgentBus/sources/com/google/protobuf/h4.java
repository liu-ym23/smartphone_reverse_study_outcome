package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class h4 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f2391a;

    public h4(Unsafe unsafe) {
        this.f2391a = unsafe;
    }

    public final int a(Class cls) {
        return this.f2391a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f2391a.arrayIndexScale(cls);
    }

    public abstract boolean c(long j2, Object obj);

    public abstract byte d(long j2, Object obj);

    public abstract double e(long j2, Object obj);

    public abstract float f(long j2, Object obj);

    public final int g(long j2, Object obj) {
        return this.f2391a.getInt(obj, j2);
    }

    public final long h(long j2, Object obj) {
        return this.f2391a.getLong(obj, j2);
    }

    public final Object i(long j2, Object obj) {
        return this.f2391a.getObject(obj, j2);
    }

    public final long j(Field field) {
        return this.f2391a.objectFieldOffset(field);
    }

    public abstract void k(Object obj, long j2, boolean z4);

    public abstract void l(Object obj, long j2, byte b10);

    public abstract void m(Object obj, long j2, double d6);

    public abstract void n(Object obj, long j2, float f10);

    public final void o(int i2, long j2, Object obj) {
        this.f2391a.putInt(obj, j2, i2);
    }

    public final void p(Object obj, long j2, long j4) {
        this.f2391a.putLong(obj, j2, j4);
    }

    public final void q(long j2, Object obj, Object obj2) {
        this.f2391a.putObject(obj, j2, obj2);
    }

    public boolean r() {
        Unsafe unsafe = this.f2391a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            return true;
        } catch (Throwable th) {
            i4.a(th);
            return false;
        }
    }

    public abstract boolean s();
}
