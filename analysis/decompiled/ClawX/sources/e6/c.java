package e6;

import a6.f0;
import a6.h1;
import b5.a0;
import io.ktor.utils.io.n0;
import io.ktor.utils.io.r0;
import j0.c0;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends h5.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2373a;

    /* renamed from: b, reason: collision with root package name */
    public int f2374b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2375c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2376e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c0 c0Var, f5.c cVar) {
        super(2, cVar);
        this.f2373a = 1;
        this.f2376e = c0Var;
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [h5.i, p5.p] */
    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f2373a) {
            case 0:
                c cVar2 = new c((d6.c) this.d, (e) this.f2376e, cVar, 0);
                cVar2.f2375c = obj;
                return cVar2;
            case 1:
                c cVar3 = new c((c0) this.f2376e, cVar);
                cVar3.f2375c = obj;
                return cVar3;
            case 2:
                c cVar4 = new c((c0) this.d, (h5.i) this.f2376e, cVar);
                cVar4.f2375c = obj;
                return cVar4;
            case 3:
                c cVar5 = new c((k6.a) this.d, (n0) this.f2376e, cVar, 3);
                cVar5.f2375c = obj;
                return cVar5;
            case 4:
                c cVar6 = new c(this.d, (h4.c) this.f2376e, cVar, 4);
                cVar6.f2375c = obj;
                return cVar6;
            default:
                return new c((Long) this.f2375c, (f4.c) this.d, (h1) this.f2376e, cVar);
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f2373a) {
            case 0:
                return ((c) create((f0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 1:
                return ((c) create((d6.c) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 2:
                return ((c) create((f0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 3:
                return ((c) create((r0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 4:
                return ((c) create((r0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            default:
                return ((c) create((f0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x028d  */
    /* JADX WARN: Type inference failed for: r3v5, types: [h5.i, p5.p] */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(c0 c0Var, p pVar, f5.c cVar) {
        super(2, cVar);
        this.f2373a = 2;
        this.d = c0Var;
        this.f2376e = (h5.i) pVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Long l3, f4.c cVar, h1 h1Var, f5.c cVar2) {
        super(2, cVar2);
        this.f2373a = 5;
        this.f2375c = l3;
        this.d = cVar;
        this.f2376e = h1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, Object obj2, f5.c cVar, int i8) {
        super(2, cVar);
        this.f2373a = i8;
        this.d = obj;
        this.f2376e = obj2;
    }
}
