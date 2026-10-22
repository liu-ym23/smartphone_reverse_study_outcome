package L8;

import A8.e;
import Zb.d;
import java.util.Collections;
import u8.AbstractC5589a;

/* loaded from: classes4.dex */
public class c extends AbstractC5589a {

    /* renamed from: a, reason: collision with root package name */
    public final d f4329a;

    public c(d dVar) {
        this.f4329a = dVar;
    }

    public static c l(e eVar) {
        return new c(d.k(eVar));
    }

    @Override // u8.AbstractC5589a, u8.i
    public void h(d.b bVar) {
        bVar.i(Collections.singleton(Rb.e.c()));
    }

    public d m() {
        return this.f4329a;
    }
}
