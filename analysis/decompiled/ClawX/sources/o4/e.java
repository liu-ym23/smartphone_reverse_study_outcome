package o4;

import b5.a0;
import h5.i;
import j0.v0;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4320a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4321b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4322c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, int i8, f5.c cVar) {
        super(2, cVar);
        this.f4320a = i8;
        this.f4322c = obj;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f4320a) {
            case 0:
                e eVar = new e((io.ktor.utils.io.p) this.f4322c, 0, cVar);
                eVar.f4321b = obj;
                return eVar;
            case 1:
                e eVar2 = new e((io.ktor.utils.io.p) this.f4322c, 1, cVar);
                eVar2.f4321b = obj;
                return eVar2;
            default:
                e eVar3 = new e((v0) this.f4322c, 2, cVar);
                eVar3.f4321b = obj;
                return eVar3;
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4320a) {
            case 0:
                return ((e) create(obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            case 1:
                return ((e) create(obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
            default:
                return ((e) create((v0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
        }
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        int i8 = this.f4320a;
        Object obj2 = this.f4322c;
        switch (i8) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                a.a.c0(obj);
                return Boolean.valueOf(this.f4321b != null || ((io.ktor.utils.io.p) obj2).e());
            case 1:
                g5.a aVar2 = g5.a.f2984a;
                a.a.c0(obj);
                return Boolean.valueOf(this.f4321b != null || ((io.ktor.utils.io.p) obj2).e());
            default:
                g5.a aVar3 = g5.a.f2984a;
                a.a.c0(obj);
                v0 v0Var = (v0) this.f4321b;
                if ((v0Var instanceof j0.c) && v0Var.f3448a <= ((v0) obj2).f3448a) {
                    z = true;
                }
                return Boolean.valueOf(z);
        }
    }
}
