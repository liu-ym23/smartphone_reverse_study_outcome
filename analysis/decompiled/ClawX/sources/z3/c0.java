package z3;

import java.nio.charset.Charset;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c0 extends h5.i implements p5.q {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ f4.c f6425a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6426b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6427c;
    public final /* synthetic */ Charset d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(String str, Charset charset, f5.c cVar) {
        super(3, cVar);
        this.f6427c = str;
        this.d = charset;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        c0 c0Var = new c0(this.f6427c, this.d, (f5.c) obj3);
        c0Var.f6425a = (f4.c) obj;
        c0Var.f6426b = obj2;
        return c0Var.invokeSuspend(b5.a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        Charset charset;
        g5.a aVar = g5.a.f2984a;
        a.a.c0(obj);
        f4.c cVar = this.f6425a;
        Object obj2 = this.f6426b;
        z7.b bVar = f0.f6440a;
        k4.p pVar = cVar.f2593c;
        k4.c0 c0Var = cVar.f2591a;
        List list = k4.t.f3636a;
        if (pVar.f("Accept-Charset") == null) {
            z7.b bVar2 = f0.f6440a;
            StringBuilder sb = new StringBuilder("Adding Accept-Charset=");
            String value = this.f6427c;
            sb.append(value);
            sb.append(" to ");
            sb.append(c0Var);
            bVar2.h(sb.toString());
            k4.p pVar2 = cVar.f2593c;
            pVar2.getClass();
            kotlin.jvm.internal.p.e(value, "value");
            pVar2.m(value);
            List listE = pVar2.e("Accept-Charset");
            listE.clear();
            listE.add(value);
        }
        if (!(obj2 instanceof String)) {
            return null;
        }
        k4.g gVarR = k4.v.r(cVar);
        if (gVarR != null && !kotlin.jvm.internal.p.a(gVarR.d, k4.f.f3608a.d)) {
            return null;
        }
        String str = (String) obj2;
        k4.g gVar = gVarR == null ? k4.f.f3608a : gVarR;
        if (gVarR == null || (charset = a.a.f(gVarR)) == null) {
            charset = this.d;
        }
        f0.f6440a.h("Sending request body to " + c0Var + " as text/plain with charset " + charset);
        kotlin.jvm.internal.p.e(gVar, "<this>");
        kotlin.jvm.internal.p.e(charset, "charset");
        return new n4.j(str, gVar.v("charset", x.f.V(charset)));
    }
}
