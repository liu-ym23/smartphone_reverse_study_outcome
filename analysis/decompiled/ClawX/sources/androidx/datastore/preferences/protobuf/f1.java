package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f1 extends g1 {
    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean c(Object obj, long j4) {
        return this.f477a.getBoolean(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final double d(Object obj, long j4) {
        return this.f477a.getDouble(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final float e(Object obj, long j4) {
        return this.f477a.getFloat(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void j(Object obj, long j4, boolean z) {
        this.f477a.putBoolean(obj, j4, z);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void k(Object obj, long j4, byte b9) {
        this.f477a.putByte(obj, j4, b9);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void l(Object obj, long j4, double d) {
        this.f477a.putDouble(obj, j4, d);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void m(Object obj, long j4, float f3) {
        this.f477a.putFloat(obj, j4, f3);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean q() {
        if (!super.q()) {
            return false;
        }
        try {
            Class<?> cls = this.f477a.getClass();
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
            h1.a(th);
            return false;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean r() {
        Unsafe unsafe = this.f477a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (h1.g() != null) {
                    try {
                        Class<?> cls3 = this.f477a.getClass();
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
                        h1.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                h1.a(th2);
            }
        }
        return false;
    }
}
