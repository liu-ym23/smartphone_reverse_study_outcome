package C9;

import ca.AbstractC0897f;
import g1.AbstractC1451a;
import java.util.List;

/* loaded from: classes4.dex */
public final class f implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final f f324a = new f();
    public static final e b = e.b;

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        AbstractC0897f.n(decoder);
        return new d((List) AbstractC1451a.d(n.f330a).deserialize(decoder));
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        d value = (d) obj;
        kotlin.jvm.internal.k.f(value, "value");
        AbstractC0897f.l(fVar);
        AbstractC1451a.d(n.f330a).serialize(fVar, value);
    }
}
