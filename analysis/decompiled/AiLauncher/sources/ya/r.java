package ya;

import w9.InterfaceC5745d;

/* loaded from: classes5.dex */
public final class r extends q0<r> {

    /* renamed from: a, reason: collision with root package name */
    public final F9.g f44121a;

    public r(F9.g annotations) {
        kotlin.jvm.internal.p.i(annotations, "annotations");
        this.f44121a = annotations;
    }

    @Override // ya.q0
    public InterfaceC5745d<? extends r> b() {
        return kotlin.jvm.internal.t.b(r.class);
    }

    @Override // ya.q0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public r a(r rVar) {
        return rVar == null ? this : new r(F9.i.a(this.f44121a, rVar.f44121a));
    }

    public final F9.g e() {
        return this.f44121a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return kotlin.jvm.internal.p.d(((r) obj).f44121a, this.f44121a);
        }
        return false;
    }

    @Override // ya.q0
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public r c(r rVar) {
        if (kotlin.jvm.internal.p.d(rVar, this)) {
            return this;
        }
        return null;
    }

    public int hashCode() {
        return this.f44121a.hashCode();
    }
}
