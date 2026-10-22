package T8;

import h8.InterfaceC1503K;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;

/* loaded from: classes4.dex */
public final class D implements S7.k {
    public static final D b = new D();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1214a = 0;

    public /* synthetic */ D() {
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1214a) {
            case 0:
                ProtoBuf$Type it = (ProtoBuf$Type) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return Integer.valueOf(it.d.size());
            default:
                kotlin.jvm.internal.k.f((G8.b) obj, "it");
                return InterfaceC1503K.f4577I;
        }
    }

    public D(U8.b bVar) {
    }
}
