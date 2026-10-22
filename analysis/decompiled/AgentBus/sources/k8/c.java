package k8;

import ga.r;
import gb.h;
import q7.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Class f5652a;

    /* renamed from: b, reason: collision with root package name */
    public final h f5653b;

    public c(Class cls, h hVar) {
        this.f5652a = cls;
        this.f5653b = hVar;
    }

    public final String a() {
        return r.d0(this.f5652a.getName(), '.', '/').concat(".class");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return k.a(this.f5652a, ((c) obj).f5652a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5652a.hashCode();
    }

    public final String toString() {
        return c.class.getName() + ": " + this.f5652a;
    }
}
