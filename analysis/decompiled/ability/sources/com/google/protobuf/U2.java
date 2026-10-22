package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public final class U2 extends V2 {
    @Override // com.google.protobuf.V2
    public final void c(long j5, byte[] bArr, long j6) {
        this.f2878a.copyMemory((Object) null, j5, bArr, W2.f, j6);
    }

    @Override // com.google.protobuf.V2
    public final boolean d(Object obj, long j5) {
        return this.f2878a.getBoolean(obj, j5);
    }

    @Override // com.google.protobuf.V2
    public final byte e(long j5) {
        return this.f2878a.getByte(j5);
    }

    @Override // com.google.protobuf.V2
    public final byte f(Object obj, long j5) {
        return this.f2878a.getByte(obj, j5);
    }

    @Override // com.google.protobuf.V2
    public final double g(Object obj, long j5) {
        return this.f2878a.getDouble(obj, j5);
    }

    @Override // com.google.protobuf.V2
    public final float h(Object obj, long j5) {
        return this.f2878a.getFloat(obj, j5);
    }

    @Override // com.google.protobuf.V2
    public final void m(Object obj, long j5, boolean z10) {
        this.f2878a.putBoolean(obj, j5, z10);
    }

    @Override // com.google.protobuf.V2
    public final void n(Object obj, long j5, byte b) {
        this.f2878a.putByte(obj, j5, b);
    }

    @Override // com.google.protobuf.V2
    public final void o(Object obj, long j5, double d) {
        this.f2878a.putDouble(obj, j5, d);
    }

    @Override // com.google.protobuf.V2
    public final void p(Object obj, long j5, float f) {
        this.f2878a.putFloat(obj, j5, f);
    }

    @Override // com.google.protobuf.V2
    public final boolean t() {
        if (!super.t()) {
            return false;
        }
        try {
            Class<?> cls = this.f2878a.getClass();
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
            W2.a(th);
            return false;
        }
    }

    @Override // com.google.protobuf.V2
    public final boolean u() {
        Unsafe unsafe = this.f2878a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (W2.e() != null) {
                    try {
                        Class<?> cls3 = this.f2878a.getClass();
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
                        W2.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                W2.a(th2);
            }
        }
        return false;
    }
}
