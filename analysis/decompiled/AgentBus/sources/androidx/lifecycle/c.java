package androidx.lifecycle;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f978a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f979b;

    public c(int i2, Method method) throws SecurityException {
        this.f978a = i2;
        this.f979b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f978a == cVar.f978a && this.f979b.getName().equals(cVar.f979b.getName());
    }

    public final int hashCode() {
        return this.f979b.getName().hashCode() + (this.f978a * 31);
    }
}
