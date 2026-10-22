package C9;

import ca.AbstractC0897f;
import kotlin.NoWhenBranchMatchedException;
import z9.C2201c;

/* loaded from: classes4.dex */
public final class n implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final n f330a = new n();
    public static final z9.h b = z2.l.l("kotlinx.serialization.json.JsonElement", C2201c.d, new z9.g[0], new Ba.f(1));

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return AbstractC0897f.n(decoder).a();
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        l value = (l) obj;
        kotlin.jvm.internal.k.f(value, "value");
        AbstractC0897f.l(fVar);
        if (value instanceof B) {
            fVar.encodeSerializableValue(C.f320a, value);
        } else if (value instanceof x) {
            fVar.encodeSerializableValue(z.f337a, value);
        } else {
            if (!(value instanceof d)) {
                throw new NoWhenBranchMatchedException();
            }
            fVar.encodeSerializableValue(f.f324a, value);
        }
    }
}
