package f4;

import a6.i0;
import a6.t;
import androidx.emoji2.text.m;
import java.util.List;
import k4.c0;
import k4.p;
import k4.w;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f2591a = new c0();

    /* renamed from: b, reason: collision with root package name */
    public w f2592b = w.f3637b;

    /* renamed from: c, reason: collision with root package name */
    public final p f2593c = new p(0);
    public Object d = i4.b.f3150a;

    /* renamed from: e, reason: collision with root package name */
    public t f2594e = i0.c();

    /* renamed from: f, reason: collision with root package name */
    public final r4.d f2595f = new r4.d();

    public final void a(Object obj) {
        this.d = obj;
    }

    public final void b(w4.a aVar) {
        r4.d dVar = this.f2595f;
        if (aVar != null) {
            dVar.e(h.f2621a, aVar);
            return;
        }
        r4.a key = h.f2621a;
        dVar.getClass();
        kotlin.jvm.internal.p.e(key, "key");
        dVar.c().remove(key);
    }

    public final void c(w wVar) {
        kotlin.jvm.internal.p.e(wVar, "<set-?>");
        this.f2592b = wVar;
    }

    public final void d(c builder) {
        kotlin.jvm.internal.p.e(builder, "builder");
        this.f2594e = builder.f2594e;
        this.f2592b = builder.f2592b;
        this.d = builder.d;
        r4.d other = builder.f2595f;
        b((w4.a) other.d(h.f2621a));
        c0 url = builder.f2591a;
        c0 c0Var = this.f2591a;
        kotlin.jvm.internal.p.e(c0Var, "<this>");
        kotlin.jvm.internal.p.e(url, "url");
        c0Var.d = url.d;
        String str = url.f3592a;
        kotlin.jvm.internal.p.e(str, "<set-?>");
        c0Var.f3592a = str;
        c0Var.d(url.f3594c);
        List list = url.f3598h;
        kotlin.jvm.internal.p.e(list, "<set-?>");
        c0Var.f3598h = list;
        c0Var.f3595e = url.f3595e;
        c0Var.f3596f = url.f3596f;
        p pVar = new p(1);
        z.c(pVar, url.f3599i);
        c0Var.f3599i = pVar;
        c0Var.f3600j = new m(pVar);
        String str2 = url.f3597g;
        kotlin.jvm.internal.p.e(str2, "<set-?>");
        c0Var.f3597g = str2;
        c0Var.f3593b = url.f3593b;
        List list2 = c0Var.f3598h;
        kotlin.jvm.internal.p.e(list2, "<set-?>");
        c0Var.f3598h = list2;
        z.c(this.f2593c, builder.f2593c);
        r4.d dVar = this.f2595f;
        kotlin.jvm.internal.p.e(dVar, "<this>");
        kotlin.jvm.internal.p.e(other, "other");
        for (r4.a aVar : c5.m.N0(other.c().keySet())) {
            kotlin.jvm.internal.p.c(aVar, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            dVar.e(aVar, other.b(aVar));
        }
    }
}
