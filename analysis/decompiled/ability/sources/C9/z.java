package C9;

import B9.H;
import B9.h0;
import ca.AbstractC0897f;
import java.util.Map;

/* loaded from: classes4.dex */
public final class z implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final z f337a = new z();
    public static final y b = y.b;

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        AbstractC0897f.n(decoder);
        return new x((Map) new H(h0.f242a, n.f330a).deserialize(decoder));
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        x value = (x) obj;
        kotlin.jvm.internal.k.f(value, "value");
        AbstractC0897f.l(fVar);
        new H(h0.f242a, n.f330a).serialize(fVar, value);
    }
}
