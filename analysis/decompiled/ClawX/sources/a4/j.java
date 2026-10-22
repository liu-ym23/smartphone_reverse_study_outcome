package a4;

import b5.a0;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import k4.o;
import k4.t;
import k4.v;
import kotlin.jvm.internal.z;
import p5.p;
import p5.q;
import p5.s;
import z3.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends h5.i implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f114a;

    /* renamed from: b, reason: collision with root package name */
    public int f115b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ v4.f f116c;
    public /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(int i8, f5.c cVar, int i9) {
        super(i8, cVar);
        this.f114a = i9;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        v4.f fVar = (v4.f) obj;
        switch (this.f114a) {
            case 0:
                j jVar = new j((p) this.d, 0, (f5.c) obj3);
                jVar.f116c = fVar;
                return jVar.invokeSuspend(a0.f883a);
            case 1:
                j jVar2 = new j((s) this.d, 1, (f5.c) obj3);
                jVar2.f116c = fVar;
                return jVar2.invokeSuspend(a0.f883a);
            case 2:
                j jVar3 = new j((t3.c) this.d, 2, (f5.c) obj3);
                jVar3.f116c = fVar;
                return jVar3.invokeSuspend(a0.f883a);
            case 3:
                j jVar4 = new j(3, (f5.c) obj3, 3);
                jVar4.f116c = fVar;
                jVar4.d = obj2;
                return jVar4.invokeSuspend(a0.f883a);
            case 4:
                j jVar5 = new j(3, (f5.c) obj3, 4);
                jVar5.f116c = fVar;
                jVar5.d = (h4.d) obj2;
                return jVar5.invokeSuspend(a0.f883a);
            default:
                j jVar6 = new j(3, (f5.c) obj3, 5);
                jVar6.f116c = fVar;
                jVar6.d = (h4.c) obj2;
                return jVar6.invokeSuspend(a0.f883a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [v4.f] */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        v4.f fVar;
        j jVar;
        n4.e iVar;
        int i8 = this.f114a;
        int i9 = 0;
        a0 a0Var = a0.f883a;
        int i10 = 1;
        switch (i8) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                int i11 = this.f115b;
                if (i11 != 0) {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                a.a.c0(obj);
                v4.f fVar2 = this.f116c;
                p pVar = (p) this.d;
                Object obj2 = fVar2.f5973a;
                this.f115b = 1;
                return pVar.invoke(obj2, this) == aVar ? aVar : a0Var;
            case 1:
                g5.a aVar2 = g5.a.f2984a;
                int i12 = this.f115b;
                if (i12 == 0) {
                    a.a.c0(obj);
                    fVar = this.f116c;
                    s sVar = (s) this.d;
                    k kVar = new k();
                    Object obj3 = fVar.f5973a;
                    Object objC = fVar.c();
                    w4.a aVar3 = (w4.a) ((f4.c) fVar.f5973a).f2595f.d(f4.h.f2621a);
                    this.f116c = fVar;
                    this.f115b = 1;
                    jVar = this;
                    obj = sVar.b(kVar, obj3, objC, aVar3, jVar);
                    if (obj != aVar2) {
                    }
                    return aVar2;
                }
                if (i12 != 1) {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                fVar = this.f116c;
                a.a.c0(obj);
                jVar = this;
                n4.e eVar = (n4.e) obj;
                if (eVar == null) {
                    return a0Var;
                }
                jVar.f116c = null;
                jVar.f115b = 2;
                if (fVar.e(jVar, eVar) != aVar2) {
                    return a0Var;
                }
                return aVar2;
            case 2:
                g5.a aVar4 = g5.a.f2984a;
                ?? r12 = this.f115b;
                try {
                    if (r12 == 0) {
                        a.a.c0(obj);
                        v4.f fVar3 = this.f116c;
                        this.f116c = fVar3;
                        this.f115b = 1;
                        obj = fVar3.d(this);
                        r12 = fVar3;
                        if (obj == aVar4) {
                            return aVar4;
                        }
                    } else {
                        if (r12 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v4.f fVar4 = this.f116c;
                        a.a.c0(obj);
                        r12 = fVar4;
                    }
                    return a0Var;
                } catch (Throwable th) {
                    androidx.emoji2.text.m mVar = ((t3.c) this.d).f5575k;
                    ((u3.c) r12.f5973a).e();
                    mVar.getClass();
                    a8.b.x(((t4.a) mVar.f621a).a(i4.a.d));
                    throw th;
                }
            case 3:
                g5.a aVar5 = g5.a.f2984a;
                int i13 = this.f115b;
                if (i13 != 0) {
                    if (i13 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                a.a.c0(obj);
                v4.f fVar5 = this.f116c;
                Object body = this.d;
                Object obj4 = fVar5.f5973a;
                k4.p pVar2 = ((f4.c) obj4).f2593c;
                List list = t.f3636a;
                if (pVar2.f("Accept") == null) {
                    ((f4.c) obj4).f2593c.b("Accept", "*/*");
                }
                k4.g gVarR = v.r((f4.c) obj4);
                if (body instanceof String) {
                    String str = (String) body;
                    if (gVarR == null) {
                        gVarR = k4.f.f3608a;
                    }
                    iVar = new n4.j(str, gVarR);
                } else if (body instanceof byte[]) {
                    iVar = new z3.h(gVarR, body);
                } else if (body instanceof io.ktor.utils.io.p) {
                    iVar = new z3.i(fVar5, gVarR, body);
                } else if (body instanceof n4.e) {
                    iVar = (n4.e) body;
                } else {
                    f4.c context = (f4.c) obj4;
                    kotlin.jvm.internal.p.e(context, "context");
                    kotlin.jvm.internal.p.e(body, "body");
                    iVar = body instanceof InputStream ? new z3.i(context, gVarR, body) : null;
                }
                if ((iVar != null ? iVar.b() : null) == null) {
                    return a0Var;
                }
                f4.c cVar = (f4.c) obj4;
                ((Map) cVar.f2593c.f2554a).remove("Content-Type");
                z3.k.f6469a.h("Transformed with default transformers request body for " + cVar.f2591a + " from " + z.a(body.getClass()));
                this.f116c = null;
                this.f115b = 1;
                return fVar5.e(this, iVar) == aVar5 ? aVar5 : a0Var;
            case 4:
                g5.a aVar6 = g5.a.f2984a;
                int i14 = this.f115b;
                if (i14 != 0) {
                    if (i14 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                a.a.c0(obj);
                v4.f fVar6 = this.f116c;
                h4.d dVar = (h4.d) this.d;
                w4.a aVar7 = dVar.f3020a;
                Object obj5 = dVar.f3021b;
                if (!(obj5 instanceof io.ktor.utils.io.p) || !aVar7.f6200a.equals(z.a(InputStream.class))) {
                    return a0Var;
                }
                h4.d dVar2 = new h4.d(aVar7, new z3.l(i9, new z3.l(i10, (io.ktor.utils.io.p) obj5)));
                this.f116c = null;
                this.f115b = 1;
                return fVar6.e(this, dVar2) == aVar6 ? aVar6 : a0Var;
            default:
                g5.a aVar8 = g5.a.f2984a;
                int i15 = this.f115b;
                if (i15 != 0) {
                    if (i15 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                a.a.c0(obj);
                v4.f fVar7 = this.f116c;
                h4.c cVar2 = (h4.c) this.d;
                r4.d attributes = cVar2.c().getAttributes();
                r4.a key = n.f6480a;
                attributes.getClass();
                kotlin.jvm.internal.p.e(key, "key");
                if (attributes.c().containsKey(key)) {
                    return a0Var;
                }
                c4.d dVar3 = new c4.d(cVar2.d());
                u3.c cVarC = cVar2.c();
                b7.c cVar3 = new b7.c(23, dVar3);
                kotlin.jvm.internal.p.e(cVarC, "<this>");
                t3.c cVar4 = cVarC.f5631a;
                o responseHeaders = cVarC.e().a();
                kotlin.jvm.internal.p.e(responseHeaders, "responseHeaders");
                d4.a aVar9 = new d4.a(cVar4);
                aVar9.f5632b = new d4.b(aVar9, cVarC.d(), i9);
                aVar9.f5633c = new d4.c(aVar9, cVar3, cVarC.e(), responseHeaders);
                aVar9.getAttributes().e(n.f6481b, a0Var);
                h4.c cVarE = aVar9.e();
                this.f116c = null;
                this.f115b = 1;
                return fVar7.e(this, cVarE) == aVar8 ? aVar8 : a0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, int i8, f5.c cVar) {
        super(3, cVar);
        this.f114a = i8;
        this.d = obj;
    }
}
