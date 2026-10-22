package a4;

import a6.c0;
import a6.f0;
import a6.h1;
import a6.j1;
import a6.t;
import a6.v;
import a6.x1;
import b5.a0;
import java.util.List;
import kotlin.jvm.internal.z;
import p5.p;
import p5.q;
import p5.s;
import z3.j0;
import z3.k0;
import z3.x;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m extends h5.i implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f117a;

    /* renamed from: b, reason: collision with root package name */
    public int f118b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f119c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f120e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, int i8, f5.c cVar) {
        super(3, cVar);
        this.f117a = i8;
        this.f120e = obj;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f117a) {
            case 0:
                m mVar = new m((s) this.f120e, 0, (f5.c) obj3);
                mVar.f119c = (v4.f) obj;
                return mVar.invokeSuspend(a0.f883a);
            case 1:
                m mVar2 = new m((t3.c) this.f120e, 1, (f5.c) obj3);
                mVar2.f119c = (v4.f) obj;
                mVar2.d = obj2;
                return mVar2.invokeSuspend(a0.f883a);
            case 2:
                m mVar3 = new m((p) this.f120e, 2, (f5.c) obj3);
                mVar3.f119c = (v4.f) obj;
                mVar3.d = (h4.c) obj2;
                return mVar3.invokeSuspend(a0.f883a);
            case 3:
                m mVar4 = new m((List) this.f120e, 3, (f5.c) obj3);
                mVar4.d = (g) obj;
                mVar4.f119c = (f4.c) obj2;
                return mVar4.invokeSuspend(a0.f883a);
            case 4:
                m mVar5 = new m((c) this.f120e, 4, (f5.c) obj3);
                mVar5.d = (g) obj;
                mVar5.f119c = (f4.c) obj2;
                return mVar5.invokeSuspend(a0.f883a);
            default:
                m mVar6 = new m((c) this.f120e, 5, (f5.c) obj3);
                mVar6.d = (f4.c) obj;
                mVar6.f119c = (p5.l) obj2;
                return mVar6.invokeSuspend(a0.f883a);
        }
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        v4.f fVar;
        m mVar;
        w4.a aVar;
        v4.f fVar2;
        Object obj2;
        v4.f fVar3;
        g gVar;
        f4.c cVar;
        Throwable th;
        t tVar;
        int i8 = this.f117a;
        a0 a0Var = a0.f883a;
        Object obj3 = this.f120e;
        switch (i8) {
            case 0:
                g5.a aVar2 = g5.a.f2984a;
                int i9 = this.f118b;
                if (i9 == 0) {
                    a.a.c0(obj);
                    fVar = (v4.f) this.f119c;
                    h4.d dVar = (h4.d) fVar.c();
                    w4.a aVar3 = dVar.f3020a;
                    Object obj4 = dVar.f3021b;
                    if (!(obj4 instanceof io.ktor.utils.io.p)) {
                        return a0Var;
                    }
                    l lVar = new l();
                    h4.c cVarE = ((u3.c) fVar.f5973a).e();
                    this.f119c = fVar;
                    this.d = aVar3;
                    this.f118b = 1;
                    mVar = this;
                    obj = ((s) obj3).b(lVar, cVarE, obj4, aVar3, mVar);
                    if (obj != aVar2) {
                        aVar = aVar3;
                    }
                    return aVar2;
                }
                if (i9 != 1) {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                aVar = (w4.a) this.d;
                fVar = (v4.f) this.f119c;
                a.a.c0(obj);
                mVar = this;
                if (obj == null) {
                    return a0Var;
                }
                if (!(obj instanceof n4.b) && !((kotlin.jvm.internal.h) aVar.f6200a).c(obj)) {
                    throw new IllegalStateException("transformResponseBody returned " + obj + " but expected value of type " + aVar);
                }
                h4.d dVar2 = new h4.d(aVar, obj);
                mVar.f119c = null;
                mVar.d = null;
                mVar.f118b = 2;
                if (fVar.e(mVar, dVar2) != aVar2) {
                    return a0Var;
                }
                return aVar2;
            case 1:
                g5.a aVar4 = g5.a.f2984a;
                int i10 = this.f118b;
                if (i10 == 0) {
                    a.a.c0(obj);
                    fVar2 = (v4.f) this.f119c;
                    Object obj5 = this.d;
                    if (!(obj5 instanceof u3.c)) {
                        throw new IllegalStateException(("Error: HttpClientCall expected, but found " + obj5 + '(' + z.a(obj5.getClass()) + ").").toString());
                    }
                    h4.b bVar = ((t3.c) obj3).f5573h;
                    h4.c cVarE2 = ((u3.c) obj5).e();
                    this.f119c = fVar2;
                    this.d = obj5;
                    this.f118b = 1;
                    Object objA = bVar.a(a0Var, cVarE2, this);
                    if (objA != aVar4) {
                        obj2 = obj5;
                        obj = objA;
                    }
                    return aVar4;
                }
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                obj2 = this.d;
                fVar2 = (v4.f) this.f119c;
                a.a.c0(obj);
                h4.c response = (h4.c) obj;
                u3.c cVar2 = (u3.c) obj2;
                cVar2.getClass();
                kotlin.jvm.internal.p.e(response, "response");
                cVar2.f5633c = response;
                this.f119c = null;
                this.d = null;
                this.f118b = 2;
                if (fVar2.e(this, obj2) != aVar4) {
                    return a0Var;
                }
                return aVar4;
            case 2:
                g5.a aVar5 = g5.a.f2984a;
                int i11 = this.f118b;
                if (i11 == 0) {
                    a.a.c0(obj);
                    v4.f fVar4 = (v4.f) this.f119c;
                    h4.c cVar3 = (h4.c) this.d;
                    this.f119c = fVar4;
                    this.f118b = 1;
                    Object objInvoke = ((p) obj3).invoke(cVar3, this);
                    if (objInvoke != aVar5) {
                        fVar3 = fVar4;
                        obj = objInvoke;
                    }
                    return aVar5;
                }
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                fVar3 = (v4.f) this.f119c;
                a.a.c0(obj);
                h4.c cVar4 = (h4.c) obj;
                if (cVar4 == null) {
                    return a0Var;
                }
                this.f119c = null;
                this.f118b = 2;
                if (fVar3.e(this, cVar4) != aVar5) {
                    return a0Var;
                }
                return aVar5;
            case 3:
                g5.a aVar6 = g5.a.f2984a;
                int i12 = this.f118b;
                if (i12 == 0) {
                    a.a.c0(obj);
                    g gVar2 = (g) ((f0) this.d);
                    f4.c cVar5 = (f4.c) this.f119c;
                    this.d = null;
                    this.f118b = 1;
                    obj = gVar2.f103a.a(cVar5, this);
                    if (obj == aVar6) {
                        return aVar6;
                    }
                } else {
                    if (i12 != 1) {
                        if (i12 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u3.c cVar6 = (u3.c) ((f0) this.d);
                        a.a.c0(obj);
                        return cVar6;
                    }
                    a.a.c0(obj);
                }
                u3.c cVar7 = (u3.c) obj;
                h4.c cVarE3 = cVar7.e();
                this.d = cVar7;
                this.f118b = 2;
                return x.b((List) obj3, cVarE3, this) == aVar6 ? aVar6 : cVar7;
            case 4:
                g5.a aVar7 = g5.a.f2984a;
                int i13 = this.f118b;
                if (i13 == 0) {
                    a.a.c0(obj);
                    gVar = (g) this.d;
                    cVar = (f4.c) this.f119c;
                    this.d = gVar;
                    this.f119c = cVar;
                    this.f118b = 1;
                    obj = gVar.f103a.a(cVar, this);
                    if (obj != aVar7) {
                    }
                    return aVar7;
                }
                if (i13 != 1) {
                    if (i13 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return obj;
                }
                cVar = (f4.c) this.f119c;
                gVar = (g) this.d;
                a.a.c0(obj);
                u3.c cVar8 = (u3.c) obj;
                if (!j0.f6466a.contains(cVar8.d().C())) {
                    return cVar8;
                }
                t3.c cVar9 = ((c) obj3).f92a;
                this.d = null;
                this.f119c = null;
                this.f118b = 2;
                Object objA2 = j0.a(gVar, cVar, cVar8, cVar9, this);
                if (objA2 != aVar7) {
                    return objA2;
                }
                return aVar7;
            default:
                g5.a aVar8 = g5.a.f2984a;
                int i14 = this.f118b;
                if (i14 != 0) {
                    if (i14 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    tVar = (t) this.d;
                    try {
                        a.a.c0(obj);
                        return a0Var;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            j1 j1Var = (j1) tVar;
                            j1Var.getClass();
                            j1Var.S(new v(th, false));
                            throw th;
                        } finally {
                            ((j1) tVar).f0();
                        }
                    }
                }
                a.a.c0(obj);
                f4.c cVar10 = (f4.c) this.d;
                p5.l lVar2 = (p5.l) this.f119c;
                x1 x1Var = new x1(cVar10.f2594e);
                f5.f fVarO = ((c) obj3).f92a.d.o(c0.f143b);
                kotlin.jvm.internal.p.b(fVarO);
                z7.b bVar2 = k0.f6470a;
                x1Var.A(new c5.a(18, ((h1) fVarO).A(new c5.a(17, x1Var))));
                try {
                    cVar10.f2594e = x1Var;
                    this.d = x1Var;
                    this.f118b = 1;
                    if (lVar2.invoke(this) == aVar8) {
                        return aVar8;
                    }
                    tVar = x1Var;
                    return a0Var;
                } catch (Throwable th3) {
                    th = th3;
                    tVar = x1Var;
                    j1 j1Var2 = (j1) tVar;
                    j1Var2.getClass();
                    j1Var2.S(new v(th, false));
                    throw th;
                }
        }
    }
}
