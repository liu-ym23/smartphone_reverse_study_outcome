package z3;

import java.nio.charset.Charset;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d0 extends h5.i implements p5.s {

    /* renamed from: a, reason: collision with root package name */
    public int f6431a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ h4.c f6432b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ io.ktor.utils.io.p f6433c;
    public /* synthetic */ w4.a d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Charset f6434e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(Charset charset, f5.c cVar) {
        super(5, cVar);
        this.f6434e = charset;
    }

    @Override // p5.s
    public final Object b(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        d0 d0Var = new d0(this.f6434e, (f5.c) obj5);
        d0Var.f6432b = (h4.c) obj2;
        d0Var.f6433c = (io.ktor.utils.io.p) obj3;
        d0Var.d = (w4.a) obj4;
        return d0Var.invokeSuspend(b5.a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) throws b4.a {
        h4.c cVar;
        k4.g gVarF;
        g5.a aVar = g5.a.f2984a;
        int i8 = this.f6431a;
        if (i8 == 0) {
            a.a.c0(obj);
            h4.c cVar2 = this.f6432b;
            io.ktor.utils.io.p pVar = this.f6433c;
            if (!this.d.f6200a.equals(kotlin.jvm.internal.z.a(String.class))) {
                return null;
            }
            this.f6432b = cVar2;
            this.f6433c = null;
            this.f6431a = 1;
            Object objM = io.ktor.utils.io.h0.m(pVar, this);
            if (objM == aVar) {
                return aVar;
            }
            cVar = cVar2;
            obj = objM;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = this.f6432b;
            a.a.c0(obj);
        }
        j6.j jVar = (j6.j) obj;
        u3.c cVarC = cVar.c();
        z7.b bVar = f0.f6440a;
        k4.o oVarA = cVarC.e().a();
        List list = k4.t.f3636a;
        String strD = oVarA.d("Content-Type");
        if (strD != null) {
            k4.g gVar = k4.g.f3611f;
            gVarF = b8.h.F(strD);
        } else {
            gVarF = null;
        }
        Charset charsetF = gVarF != null ? a.a.f(gVarF) : null;
        if (charsetF == null) {
            charsetF = this.f6434e;
        }
        f0.f6440a.h("Reading response body for " + cVarC.d().u() + " as String with charset " + charsetF);
        return x.e.g0(jVar, charsetF);
    }
}
