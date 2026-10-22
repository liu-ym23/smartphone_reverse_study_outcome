package M8;

import O8.h;
import u8.AbstractC5589a;
import u8.g;
import v8.C5671a;

/* loaded from: classes4.dex */
public class f extends AbstractC5589a {

    /* renamed from: a, reason: collision with root package name */
    public final h f4658a;

    /* renamed from: b, reason: collision with root package name */
    public final c f4659b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4660c;

    public f(h hVar, c cVar, String str) {
        this.f4658a = hVar;
        this.f4659b = cVar;
        this.f4660c = str;
    }

    public static f l(h hVar, c cVar, String str) {
        return new f(hVar, cVar, str);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void f(g.b bVar) {
        bVar.m(a.b(this.f4658a, this.f4659b, this.f4660c));
    }

    @Override // u8.AbstractC5589a, u8.i
    public void k(C5671a.C0540a c0540a) {
        c0540a.I(this.f4659b.c()).C(this.f4659b.a());
    }
}
