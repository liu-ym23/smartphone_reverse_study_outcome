package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class y0 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f3554a;

    public y0(Unsafe unsafe) {
        this.f3554a = unsafe;
    }

    public final int a(Class cls) {
        return this.f3554a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f3554a.arrayIndexScale(cls);
    }

    public abstract boolean c(long j4, Object obj);

    public abstract byte d(long j4, Object obj);

    public abstract double e(long j4, Object obj);

    public abstract float f(long j4, Object obj);

    public final int g(long j4, Object obj) {
        return this.f3554a.getInt(obj, j4);
    }

    public final long h(long j4, Object obj) {
        return this.f3554a.getLong(obj, j4);
    }

    public final Object i(long j4, Object obj) {
        return this.f3554a.getObject(obj, j4);
    }

    public final long j(Field field) {
        return this.f3554a.objectFieldOffset(field);
    }

    public abstract void k(Object obj, long j4, boolean z4);

    public abstract void l(Object obj, long j4, byte b4);

    public abstract void m(Object obj, long j4, double d4);

    public abstract void n(Object obj, long j4, float f4);

    public final void o(int i4, long j4, Object obj) {
        this.f3554a.putInt(obj, j4, i4);
    }

    public final void p(Object obj, long j4, long j5) {
        this.f3554a.putLong(obj, j4, j5);
    }

    public final void q(long j4, Object obj, Object obj2) {
        this.f3554a.putObject(obj, j4, obj2);
    }
}
