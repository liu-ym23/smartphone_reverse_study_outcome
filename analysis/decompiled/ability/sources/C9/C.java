package C9;

import ca.AbstractC0897f;
import z9.C2203e;

/* loaded from: classes4.dex */
public final class C implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final C f320a = new C();
    public static final z9.h b = z2.l.m("kotlinx.serialization.json.JsonPrimitive", C2203e.k, new z9.g[0]);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        l lVarA = AbstractC0897f.n(decoder).a();
        if (lVarA instanceof B) {
            return (B) lVarA;
        }
        StringBuilder sb = new StringBuilder("Unexpected JSON element, expected JsonPrimitive, had ");
        throw D9.j.d(B7.a.t(kotlin.jvm.internal.m.f4928a, lVarA.getClass(), sb), lVarA.toString(), -1);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        B value = (B) obj;
        kotlin.jvm.internal.k.f(value, "value");
        AbstractC0897f.l(fVar);
        if (value instanceof u) {
            fVar.encodeSerializableValue(v.f334a, u.INSTANCE);
        } else {
            fVar.encodeSerializableValue(s.f333a, (r) value);
        }
    }
}
