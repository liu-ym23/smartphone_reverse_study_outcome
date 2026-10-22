package e6;

import b5.a0;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends h5.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2377a;

    /* renamed from: b, reason: collision with root package name */
    public int f2378b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2379c;
    public final /* synthetic */ e d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(e eVar, f5.c cVar, int i8) {
        super(2, cVar);
        this.f2377a = i8;
        this.d = eVar;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f2377a) {
            case 0:
                d dVar = new d(this.d, cVar, 0);
                dVar.f2379c = obj;
                return dVar;
            default:
                d dVar2 = new d(this.d, cVar, 1);
                dVar2.f2379c = obj;
                return dVar2;
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f2377a) {
            case 0:
                return ((d) create((c6.p) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            default:
                return ((d) create((d6.c) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
        }
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f2377a) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                int i8 = this.f2378b;
                a0 a0Var = a0.f883a;
                if (i8 == 0) {
                    a.a.c0(obj);
                    c6.p pVar = (c6.p) this.f2379c;
                    this.f2378b = 1;
                    Object objCollect = this.d.d.collect(new m(pVar), this);
                    if (objCollect != aVar) {
                        objCollect = a0Var;
                    }
                    if (objCollect != aVar) {
                        objCollect = a0Var;
                    }
                    if (objCollect == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                return a0Var;
            default:
                g5.a aVar2 = g5.a.f2984a;
                int i9 = this.f2378b;
                a0 a0Var2 = a0.f883a;
                if (i9 == 0) {
                    a.a.c0(obj);
                    d6.c cVar = (d6.c) this.f2379c;
                    this.f2378b = 1;
                    Object objCollect2 = this.d.d.collect(cVar, this);
                    if (objCollect2 != aVar2) {
                        objCollect2 = a0Var2;
                    }
                    if (objCollect2 == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                return a0Var2;
        }
    }
}
