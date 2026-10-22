package ma;

import E9.InterfaceC0819y;
import java.util.List;
import p9.InterfaceC5074l;
import ya.S;

/* renamed from: ma.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4922b extends AbstractC4927g<List<? extends AbstractC4927g<?>>> {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5074l<InterfaceC0819y, S> f37190b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C4922b(List<? extends AbstractC4927g<?>> value, InterfaceC5074l<? super InterfaceC0819y, ? extends S> computeType) {
        super(value);
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(computeType, "computeType");
        this.f37190b = computeType;
    }

    @Override // ma.AbstractC4927g
    public S a(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        S sInvoke = this.f37190b.invoke(module);
        if (!C9.j.d0(sInvoke) && !C9.j.r0(sInvoke)) {
            C9.j.E0(sInvoke);
        }
        return sInvoke;
    }
}
