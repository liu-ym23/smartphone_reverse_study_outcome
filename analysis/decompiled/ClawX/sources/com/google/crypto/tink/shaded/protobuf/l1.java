package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l1 extends m1 {
    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final boolean c(Object obj, long j4) {
        return this.f1495a.getBoolean(obj, j4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final byte d(Object obj, long j4) {
        return this.f1495a.getByte(obj, j4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final double e(Object obj, long j4) {
        return this.f1495a.getDouble(obj, j4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final float f(Object obj, long j4) {
        return this.f1495a.getFloat(obj, j4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final void k(Object obj, long j4, boolean z) {
        this.f1495a.putBoolean(obj, j4, z);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final void l(Object obj, long j4, byte b9) {
        this.f1495a.putByte(obj, j4, b9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final void m(Object obj, long j4, double d) {
        this.f1495a.putDouble(obj, j4, d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final void n(Object obj, long j4, float f3) {
        this.f1495a.putFloat(obj, j4, f3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final boolean r() {
        if (!super.r()) {
            return false;
        }
        try {
            Class<?> cls = this.f1495a.getClass();
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
            n1.a(th);
            return false;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final boolean s() {
        Unsafe unsafe = this.f1495a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (n1.e() != null) {
                    try {
                        Class<?> cls3 = this.f1495a.getClass();
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
                        n1.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                n1.a(th2);
            }
        }
        return false;
    }
}
