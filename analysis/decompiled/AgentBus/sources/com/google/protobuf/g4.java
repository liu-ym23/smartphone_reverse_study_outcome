package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class g4 extends h4 {
    @Override // com.google.protobuf.h4
    public final boolean c(long j2, Object obj) {
        return this.f2391a.getBoolean(obj, j2);
    }

    @Override // com.google.protobuf.h4
    public final byte d(long j2, Object obj) {
        return this.f2391a.getByte(obj, j2);
    }

    @Override // com.google.protobuf.h4
    public final double e(long j2, Object obj) {
        return this.f2391a.getDouble(obj, j2);
    }

    @Override // com.google.protobuf.h4
    public final float f(long j2, Object obj) {
        return this.f2391a.getFloat(obj, j2);
    }

    @Override // com.google.protobuf.h4
    public final void k(Object obj, long j2, boolean z4) {
        this.f2391a.putBoolean(obj, j2, z4);
    }

    @Override // com.google.protobuf.h4
    public final void l(Object obj, long j2, byte b10) {
        this.f2391a.putByte(obj, j2, b10);
    }

    @Override // com.google.protobuf.h4
    public final void m(Object obj, long j2, double d6) {
        this.f2391a.putDouble(obj, j2, d6);
    }

    @Override // com.google.protobuf.h4
    public final void n(Object obj, long j2, float f10) {
        this.f2391a.putFloat(obj, j2, f10);
    }

    @Override // com.google.protobuf.h4
    public final boolean r() {
        if (!super.r()) {
            return false;
        }
        try {
            Class<?> cls = this.f2391a.getClass();
            Class cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            i4.a(th);
            return false;
        }
    }

    @Override // com.google.protobuf.h4
    public final boolean s() {
        Unsafe unsafe = this.f2391a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (i4.e() != null) {
                    try {
                        Class<?> cls3 = this.f2391a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        i4.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                i4.a(th2);
            }
        }
        return false;
    }
}
