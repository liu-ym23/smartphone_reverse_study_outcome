package c;

import b0.x0;

/* loaded from: classes.dex */
public final class l extends a.a {

    /* renamed from: a, reason: collision with root package name */
    public final x0 f1708a;

    public l(x0 x0Var) {
        q7.k.e(x0Var, "callback");
        this.f1708a = x0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && q7.k.a(this.f1708a, ((l) obj).f1708a);
    }

    public final int hashCode() {
        return this.f1708a.hashCode() * 31;
    }

    public final String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.f1708a + ", owner=null)";
    }
}
