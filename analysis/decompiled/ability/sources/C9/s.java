package C9;

import B9.Z;
import B9.q0;
import ca.AbstractC0897f;
import g1.AbstractC1451a;
import z9.C2203e;

/* loaded from: classes4.dex */
public final class s implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final s f333a = new s();
    public static final Z b = z2.l.a("kotlinx.serialization.json.JsonLiteral", C2203e.k);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        l lVarA = AbstractC0897f.n(decoder).a();
        if (lVarA instanceof r) {
            return (r) lVarA;
        }
        StringBuilder sb = new StringBuilder("Unexpected JSON element, expected JsonLiteral, had ");
        throw D9.j.d(B7.a.t(kotlin.jvm.internal.m.f4928a, lVarA.getClass(), sb), lVarA.toString(), -1);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        r value = (r) obj;
        kotlin.jvm.internal.k.f(value, "value");
        String str = value.c;
        AbstractC0897f.l(fVar);
        if (value.f332a) {
            fVar.encodeString(str);
            return;
        }
        z9.g gVar = value.b;
        if (gVar != null) {
            fVar.encodeInline(gVar).encodeString(str);
            return;
        }
        Long lG0 = j9.t.g0(str);
        if (lG0 != null) {
            fVar.encodeLong(lG0.longValue());
            return;
        }
        C7.m mVarW = AbstractC1451a.W(str);
        if (mVarW != null) {
            fVar.encodeInline(q0.b).encodeLong(mVarW.f312a);
            return;
        }
        Double dU = j9.s.U(str);
        if (dU != null) {
            fVar.encodeDouble(dU.doubleValue());
            return;
        }
        Boolean boolP0 = j9.m.P0(str);
        if (boolP0 != null) {
            fVar.encodeBoolean(boolP0.booleanValue());
        } else {
            fVar.encodeString(str);
        }
    }
}
