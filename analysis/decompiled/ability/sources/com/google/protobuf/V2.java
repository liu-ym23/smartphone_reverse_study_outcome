package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public abstract class V2 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f2878a;

    public V2(Unsafe unsafe) {
        this.f2878a = unsafe;
    }

    public final int a(Class cls) {
        return this.f2878a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f2878a.arrayIndexScale(cls);
    }

    public abstract void c(long j5, byte[] bArr, long j6);

    public abstract boolean d(Object obj, long j5);

    public abstract byte e(long j5);

    public abstract byte f(Object obj, long j5);

    public abstract double g(Object obj, long j5);

    public abstract float h(Object obj, long j5);

    public final int i(Object obj, long j5) {
        return this.f2878a.getInt(obj, j5);
    }

    public final long j(Object obj, long j5) {
        return this.f2878a.getLong(obj, j5);
    }

    public final Object k(Object obj, long j5) {
        return this.f2878a.getObject(obj, j5);
    }

    public final long l(Field field) {
        return this.f2878a.objectFieldOffset(field);
    }

    public abstract void m(Object obj, long j5, boolean z10);

    public abstract void n(Object obj, long j5, byte b);

    public abstract void o(Object obj, long j5, double d);

    public abstract void p(Object obj, long j5, float f);

    public final void q(Object obj, long j5, int i) {
        this.f2878a.putInt(obj, j5, i);
    }

    public final void r(Object obj, long j5, long j6) {
        this.f2878a.putLong(obj, j5, j6);
    }

    public final void s(Object obj, long j5, Object obj2) {
        this.f2878a.putObject(obj, j5, obj2);
    }

    public boolean t() {
        Unsafe unsafe = this.f2878a;
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
            W2.a(th);
            return false;
        }
    }

    public abstract boolean u();
}
