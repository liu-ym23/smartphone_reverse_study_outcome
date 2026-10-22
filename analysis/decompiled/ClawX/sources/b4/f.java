package b4;

import b5.a0;
import c5.m;
import io.ktor.utils.io.p;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k4.h0;
import k4.o;
import k4.t;
import p5.s;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends h5.i implements s {

    /* renamed from: a, reason: collision with root package name */
    public int f861a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ h4.c f862b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ p f863c;
    public /* synthetic */ w4.a d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Set f864e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f865f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a4.c f866g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(a4.c cVar, f5.c cVar2, List list, Set set) {
        super(5, cVar2);
        this.f864e = set;
        this.f865f = list;
        this.f866g = cVar;
    }

    @Override // p5.s
    public final Object b(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        List list = this.f865f;
        f fVar = new f(this.f866g, (f5.c) obj5, list, this.f864e);
        fVar.f862b = (h4.c) obj2;
        fVar.f863c = (p) obj3;
        fVar.d = (w4.a) obj4;
        return fVar.invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) throws a {
        k4.g gVarF;
        Charset charsetForName;
        g5.a aVar = g5.a.f2984a;
        int i8 = this.f861a;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return obj;
        }
        a.a.c0(obj);
        h4.c cVar = this.f862b;
        p pVar = this.f863c;
        w4.a aVar2 = this.d;
        kotlin.jvm.internal.p.e(cVar, "<this>");
        o oVarA = cVar.a();
        List list = t.f3636a;
        String strD = oVarA.d("Content-Type");
        if (strD != null) {
            k4.g gVar = k4.g.f3611f;
            gVarF = b8.h.F(strD);
        } else {
            gVarF = null;
        }
        if (gVarF == null) {
            return null;
        }
        o oVarA2 = b8.h.q(cVar).a();
        Charset defaultCharset = x5.a.f6276a;
        kotlin.jvm.internal.p.e(oVarA2, "<this>");
        kotlin.jvm.internal.p.e(defaultCharset, "defaultCharset");
        Iterator it = m.J0(b8.h.G(oVarA2.d("Accept-Charset")), new k4.s()).iterator();
        while (true) {
            if (!it.hasNext()) {
                charsetForName = null;
                break;
            }
            String name = ((k4.k) it.next()).f3625a;
            if (kotlin.jvm.internal.p.a(name, "*")) {
                charsetForName = defaultCharset;
                break;
            }
            Charset charset = x5.a.f6276a;
            kotlin.jvm.internal.p.e(name, "name");
            if (Charset.isSupported(name)) {
                charsetForName = Charset.forName(name);
                kotlin.jvm.internal.p.d(charsetForName, "forName(...)");
                break;
            }
        }
        Charset charset2 = charsetForName == null ? defaultCharset : charsetForName;
        h0 h0VarU = b8.h.q(cVar).u();
        this.f862b = null;
        this.f863c = null;
        this.f861a = 1;
        Object objB = i.b(this.f864e, this.f865f, h0VarU, aVar2, pVar, gVarF, charset2, this);
        return objB == aVar ? aVar : objB;
    }
}
