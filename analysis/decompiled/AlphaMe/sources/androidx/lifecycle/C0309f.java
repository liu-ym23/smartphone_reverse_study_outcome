package androidx.lifecycle;

import java.lang.reflect.Method;

/* renamed from: androidx.lifecycle.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0309f {

    /* renamed from: a, reason: collision with root package name */
    public final int f3936a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f3937b;

    public C0309f(Method method, int i4) throws SecurityException {
        this.f3936a = i4;
        this.f3937b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0309f)) {
            return false;
        }
        C0309f c0309f = (C0309f) obj;
        return this.f3936a == c0309f.f3936a && this.f3937b.getName().equals(c0309f.f3937b.getName());
    }

    public final int hashCode() {
        return this.f3937b.getName().hashCode() + (this.f3936a * 31);
    }
}
