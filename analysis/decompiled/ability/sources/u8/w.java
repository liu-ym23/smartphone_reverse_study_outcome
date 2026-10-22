package u8;

import h8.InterfaceC1501I;
import kotlin.jvm.internal.Ref$ObjectRef;
import t8.C2024a;

/* loaded from: classes4.dex */
public final class w implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6736a;
    public final z b;
    public final n8.n c;
    public final Ref$ObjectRef d;

    public /* synthetic */ w(z zVar, n8.n nVar, Ref$ObjectRef ref$ObjectRef, int i) {
        this.f6736a = i;
        this.b = zVar;
        this.c = nVar;
        this.d = ref$ObjectRef;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f6736a) {
            case 0:
                z zVar = this.b;
                W8.l lVar = ((C2024a) zVar.b.f903a).f6670a;
                w wVar = new w(zVar, this.c, this.d, 1);
                W8.i iVar = (W8.i) lVar;
                iVar.getClass();
                return new kotlin.reflect.jvm.internal.impl.storage.a(iVar, wVar);
            default:
                r8.h hVar = ((C2024a) this.b.b.f903a).h;
                InterfaceC1501I descriptor = (InterfaceC1501I) this.d.f4920a;
                hVar.getClass();
                n8.n field = this.c;
                kotlin.jvm.internal.k.f(field, "field");
                kotlin.jvm.internal.k.f(descriptor, "descriptor");
                return null;
        }
    }
}
