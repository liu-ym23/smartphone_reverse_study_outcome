package z3;

import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t extends h5.i implements p5.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6504a;

    /* renamed from: b, reason: collision with root package name */
    public int f6505b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6506c;
    public /* synthetic */ Throwable d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f6507e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(List list, f5.c cVar, int i8) {
        super(3, cVar);
        this.f6504a = i8;
        this.f6507e = list;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        f4.b bVar = (f4.b) obj;
        Throwable th = (Throwable) obj2;
        f5.c cVar = (f5.c) obj3;
        switch (this.f6504a) {
            case 0:
                t tVar = new t(this.f6507e, cVar, 0);
                tVar.f6506c = bVar;
                tVar.d = th;
                return tVar.invokeSuspend(b5.a0.f883a);
            default:
                t tVar2 = new t(this.f6507e, cVar, 1);
                tVar2.f6506c = bVar;
                tVar2.d = th;
                return tVar2.invokeSuspend(b5.a0.f883a);
        }
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6504a) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                int i8 = this.f6505b;
                if (i8 != 0) {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) this.f6506c;
                    a.a.c0(obj);
                    return th;
                }
                a.a.c0(obj);
                f4.b bVar = (f4.b) this.f6506c;
                Throwable thA = i4.a.a(this.d);
                this.f6506c = thA;
                this.f6505b = 1;
                x.a(this.f6507e, thA, bVar, this);
                return b5.a0.f883a == aVar ? aVar : thA;
            default:
                g5.a aVar2 = g5.a.f2984a;
                int i9 = this.f6505b;
                if (i9 != 0) {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) this.f6506c;
                    a.a.c0(obj);
                    return th2;
                }
                a.a.c0(obj);
                f4.b bVar2 = (f4.b) this.f6506c;
                Throwable thA2 = i4.a.a(this.d);
                this.f6506c = thA2;
                this.f6505b = 1;
                x.a(this.f6507e, thA2, bVar2, this);
                return b5.a0.f883a == aVar2 ? aVar2 : thA2;
        }
    }
}
