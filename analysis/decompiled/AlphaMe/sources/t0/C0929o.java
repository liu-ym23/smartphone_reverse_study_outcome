package t0;

import androidx.lifecycle.U;
import f1.AbstractC0557a;
import s0.C0842A;

/* renamed from: t0.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0929o implements s0.B {

    /* renamed from: c, reason: collision with root package name */
    public final U f15394c = new U();

    /* renamed from: d, reason: collision with root package name */
    public final D0.j f15395d = new D0.j();

    public C0929o() {
        a(s0.B.f14149b);
    }

    public final void a(AbstractC0557a abstractC0557a) {
        this.f15394c.h(abstractC0557a);
        boolean z4 = abstractC0557a instanceof C0842A;
        D0.j jVar = this.f15395d;
        if (z4) {
            jVar.j((C0842A) abstractC0557a);
        } else if (abstractC0557a instanceof s0.y) {
            jVar.k(((s0.y) abstractC0557a).f14223i);
        }
    }
}
