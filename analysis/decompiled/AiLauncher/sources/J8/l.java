package J8;

import J8.j;
import Zb.d;
import u8.AbstractC5589a;

/* loaded from: classes4.dex */
public class l extends AbstractC5589a {

    /* renamed from: a, reason: collision with root package name */
    public final j.b f3782a;

    public l(j.b bVar) {
        this.f3782a = bVar;
    }

    public static l l() {
        return m(j.t());
    }

    public static l m(j.b bVar) {
        return new l(bVar);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void h(d.b bVar) {
        bVar.k(this.f3782a.build());
    }

    public j.b n() {
        return this.f3782a;
    }
}
