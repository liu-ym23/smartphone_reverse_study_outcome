package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f1133a;

    public i1(Unsafe unsafe) {
        this.f1133a = unsafe;
    }

    public final int a(Class cls) {
        return this.f1133a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f1133a.arrayIndexScale(cls);
    }

    public abstract boolean c(Object obj, long j10);

    public abstract double d(Object obj, long j10);

    public abstract float e(Object obj, long j10);

    public final int f(Object obj, long j10) {
        return this.f1133a.getInt(obj, j10);
    }

    public final long g(Object obj, long j10) {
        return this.f1133a.getLong(obj, j10);
    }

    public final Object h(Object obj, long j10) {
        return this.f1133a.getObject(obj, j10);
    }

    public final long i(Field field) {
        return this.f1133a.objectFieldOffset(field);
    }

    public abstract void j(Object obj, long j10, boolean z10);

    public abstract void k(Object obj, long j10, byte b10);

    public abstract void l(Object obj, long j10, double d7);

    public abstract void m(Object obj, long j10, float f5);

    public final void n(Object obj, long j10, int i) {
        this.f1133a.putInt(obj, j10, i);
    }

    public final void o(Object obj, long j10, long j11) {
        this.f1133a.putLong(obj, j10, j11);
    }

    public final void p(Object obj, long j10, Object obj2) {
        this.f1133a.putObject(obj, j10, obj2);
    }

    public boolean q() {
        Unsafe unsafe = this.f1133a;
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
            j1.a(th);
            return false;
        }
    }

    public abstract boolean r();
}
