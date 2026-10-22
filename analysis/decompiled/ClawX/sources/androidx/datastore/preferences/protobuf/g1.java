package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g1 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f477a;

    public g1(Unsafe unsafe) {
        this.f477a = unsafe;
    }

    public final int a(Class cls) {
        return this.f477a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f477a.arrayIndexScale(cls);
    }

    public abstract boolean c(Object obj, long j4);

    public abstract double d(Object obj, long j4);

    public abstract float e(Object obj, long j4);

    public final int f(Object obj, long j4) {
        return this.f477a.getInt(obj, j4);
    }

    public final long g(Object obj, long j4) {
        return this.f477a.getLong(obj, j4);
    }

    public final Object h(Object obj, long j4) {
        return this.f477a.getObject(obj, j4);
    }

    public final long i(Field field) {
        return this.f477a.objectFieldOffset(field);
    }

    public abstract void j(Object obj, long j4, boolean z);

    public abstract void k(Object obj, long j4, byte b9);

    public abstract void l(Object obj, long j4, double d);

    public abstract void m(Object obj, long j4, float f3);

    public final void n(int i8, long j4, Object obj) {
        this.f477a.putInt(obj, j4, i8);
    }

    public final void o(Object obj, long j4, long j8) {
        this.f477a.putLong(obj, j4, j8);
    }

    public final void p(long j4, Object obj, Object obj2) {
        this.f477a.putObject(obj, j4, obj2);
    }

    public boolean q() {
        Unsafe unsafe = this.f477a;
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
            h1.a(th);
            return false;
        }
    }

    public abstract boolean r();
}
