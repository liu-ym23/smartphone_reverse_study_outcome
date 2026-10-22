package P9;

import kotlin.jvm.internal.p;
import o9.C5013a;
import w9.InterfaceC5745d;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5745d<? extends e> f5381a;

    public f(InterfaceC5745d<? extends e> klass) {
        p.i(klass, "klass");
        this.f5381a = klass;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && p.d(this.f5381a, ((f) obj).f5381a);
    }

    public int hashCode() {
        return this.f5381a.hashCode();
    }

    public String toString() {
        String name = C5013a.b(this.f5381a).getName();
        p.h(name, "getName(...)");
        return name;
    }
}
