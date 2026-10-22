package a4;

import a6.i0;
import a6.t;
import b5.a0;
import d8.x0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import k4.h0;
import k4.v;
import k4.w;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import p5.q;
import x5.o;
import z3.n0;
import z3.o0;
import z3.p0;
import z3.y0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends h5.i implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f105a;

    /* renamed from: b, reason: collision with root package name */
    public int f106b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t3.c f107c;
    public /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f108e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f109f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(Object obj, t3.c cVar, f5.c cVar2, int i8) {
        super(3, cVar2);
        this.f105a = i8;
        this.f109f = obj;
        this.f107c = cVar;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f105a) {
            case 0:
                h hVar = new h((q) this.f109f, this.f107c, (f5.c) obj3, 0);
                hVar.d = (y0) obj;
                hVar.f108e = (f4.c) obj2;
                return hVar.invokeSuspend(a0.f883a);
            case 1:
                x3.d dVar = (x3.d) this.f109f;
                h hVar2 = new h(this.f107c, dVar, (f5.c) obj3);
                hVar2.d = (v4.f) obj;
                hVar2.f108e = obj2;
                return hVar2.invokeSuspend(a0.f883a);
            default:
                h hVar3 = new h((p0) this.f109f, this.f107c, (f5.c) obj3, 2);
                hVar3.d = (v4.f) obj;
                hVar3.f108e = obj2;
                return hVar3.invokeSuspend(a0.f883a);
        }
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        v4.f fVar;
        f0 f0VarC;
        f4.d requestData;
        Object objB;
        f0 f0VarC2;
        v4.f fVar2;
        Object objA;
        switch (this.f105a) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                int i8 = this.f106b;
                if (i8 != 0) {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return obj;
                }
                a.a.c0(obj);
                y0 y0Var = (y0) this.d;
                f4.c cVar = (f4.c) this.f108e;
                q qVar = (q) this.f109f;
                g gVar = new g(y0Var, this.f107c.d);
                this.d = null;
                this.f106b = 1;
                Object objInvoke = qVar.invoke(gVar, cVar, this);
                return objInvoke == aVar ? aVar : objInvoke;
            case 1:
                x3.d dVar = (x3.d) this.f109f;
                t3.c cVar2 = this.f107c;
                androidx.emoji2.text.m mVar = cVar2.f5575k;
                g5.a aVar2 = g5.a.f2984a;
                int i9 = this.f106b;
                if (i9 == 0) {
                    a.a.c0(obj);
                    fVar = (v4.f) this.d;
                    Object obj2 = this.f108e;
                    f4.c cVar3 = new f4.c();
                    cVar3.d((f4.c) fVar.f5973a);
                    if (obj2 == null) {
                        cVar3.d = n4.b.f3977a;
                        kotlin.jvm.internal.h hVarA = z.a(Object.class);
                        try {
                            f0VarC2 = z.c(Object.class);
                        } catch (Throwable unused) {
                            f0VarC2 = null;
                        }
                        cVar3.b(new w4.a(hVarA, f0VarC2));
                    } else if (obj2 instanceof n4.e) {
                        cVar3.d = obj2;
                        cVar3.b(null);
                    } else {
                        cVar3.d = obj2;
                        kotlin.jvm.internal.h hVarA2 = z.a(Object.class);
                        try {
                            f0VarC = z.c(Object.class);
                        } catch (Throwable unused2) {
                            f0VarC = null;
                        }
                        cVar3.b(new w4.a(hVarA2, f0VarC));
                    }
                    mVar.p(i4.a.f3147b);
                    h0 h0VarB = cVar3.f2591a.b();
                    w wVar = cVar3.f2592b;
                    k4.q qVarN = cVar3.f2593c.n();
                    Object obj3 = cVar3.d;
                    n4.e eVar = obj3 instanceof n4.e ? (n4.e) obj3 : null;
                    if (eVar == null) {
                        throw new IllegalStateException(("No request transformation found: " + cVar3.d).toString());
                    }
                    t tVar = cVar3.f2594e;
                    r4.d dVar2 = cVar3.f2595f;
                    requestData = new f4.d(h0VarB, wVar, qVarN, eVar, tVar, dVar2);
                    dVar2.e(w3.g.f6194b, cVar2.f5576l);
                    Set setKeySet = qVarN.f5104c.keySet();
                    p.e(setKeySet, "<this>");
                    Set setUnmodifiableSet = Collections.unmodifiableSet(setKeySet);
                    p.d(setUnmodifiableSet, "unmodifiableSet(...)");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj4 : setUnmodifiableSet) {
                        if (k4.t.f3636a.contains((String) obj4)) {
                            arrayList.add(obj4);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        String header = arrayList.toString();
                        p.e(header, "header");
                        throw new x0("Header(s) " + header + " are controlled by the engine and cannot be set explicitly");
                    }
                    for (w3.e eVar2 : requestData.f2601g) {
                        if (!dVar.f6264e.contains(eVar2)) {
                            throw new IllegalArgumentException(("Engine doesn't support " + eVar2).toString());
                        }
                    }
                    this.d = fVar;
                    this.f108e = requestData;
                    this.f106b = 1;
                    objB = k4.z.b(dVar, requestData, this);
                    if (objB == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i9 != 1) {
                        if (i9 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        a.a.c0(obj);
                        return a0.f883a;
                    }
                    f4.d dVar3 = (f4.d) this.f108e;
                    fVar = (v4.f) this.d;
                    a.a.c0(obj);
                    requestData = dVar3;
                    objB = obj;
                }
                f4.g responseData = (f4.g) objB;
                p.e(requestData, "requestData");
                p.e(responseData, "responseData");
                u3.c cVar4 = new u3.c(cVar2);
                cVar4.f5632b = new f4.a(cVar4, requestData);
                cVar4.f5633c = new h4.a(cVar4, responseData);
                r4.d attributes = cVar4.getAttributes();
                r4.a key = u3.c.f5630e;
                attributes.getClass();
                p.e(key, "key");
                attributes.c().remove(key);
                Object obj5 = responseData.f2618e;
                if (!(obj5 instanceof io.ktor.utils.io.p)) {
                    cVar4.getAttributes().e(key, obj5);
                }
                h4.c cVarE = cVar4.e();
                mVar.p(i4.a.f3148c);
                i0.l(cVarE.b()).A(new t3.a(cVar2, cVarE));
                this.d = null;
                this.f108e = null;
                this.f106b = 2;
                if (fVar.e(this, cVar4) == aVar2) {
                    return aVar2;
                }
                return a0.f883a;
            default:
                p0 p0Var = (p0) this.f109f;
                g5.a aVar3 = g5.a.f2984a;
                int i10 = this.f106b;
                if (i10 == 0) {
                    a.a.c0(obj);
                    fVar2 = (v4.f) this.d;
                    Object obj6 = this.f108e;
                    if (!(obj6 instanceof n4.e)) {
                        throw new IllegalStateException(o.R0("\n|Fail to prepare request body for sending. \n|The body type is: " + z.a(obj6.getClass()) + ", with Content-Type: " + v.r((f4.c) fVar2.f5973a) + ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header.").toString());
                    }
                    f4.c cVar5 = (f4.c) fVar2.f5973a;
                    cVar5.getClass();
                    cVar5.d = obj6;
                    cVar5.b(null);
                    p0Var.getClass();
                    y0 n0Var = new n0(this.f107c);
                    Iterator it = c5.m.H0(p0Var.f6494a).iterator();
                    while (it.hasNext()) {
                        n0Var = new o0((q) it.next(), n0Var);
                    }
                    f4.c cVar6 = (f4.c) fVar2.f5973a;
                    this.d = fVar2;
                    this.f106b = 1;
                    objA = n0Var.a(cVar6, this);
                    if (objA == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        a.a.c0(obj);
                        return a0.f883a;
                    }
                    v4.f fVar3 = (v4.f) this.d;
                    a.a.c0(obj);
                    fVar2 = fVar3;
                    objA = obj;
                }
                this.d = null;
                this.f106b = 2;
                if (fVar2.e(this, (u3.c) objA) == aVar3) {
                    return aVar3;
                }
                return a0.f883a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(t3.c cVar, x3.d dVar, f5.c cVar2) {
        super(3, cVar2);
        this.f105a = 1;
        this.f107c = cVar;
        this.f109f = dVar;
    }
}
