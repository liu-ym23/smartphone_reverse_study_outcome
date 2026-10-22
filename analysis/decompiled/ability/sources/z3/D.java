package z3;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class D extends AbstractC2161f {
    public static final InterfaceC0315b f = AbstractC0317d.b(D.class);

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        Boolean bool = Boolean.TRUE;
        fVar.f6698a.getClass();
        if (bool.equals(null)) {
            u3.g gVarJ = j();
            gVarJ.getClass();
            gVarJ.d = aVar;
            gVarJ.b = fVar.f;
            gVarJ.k = (Locale) fVar.f6698a.f177a;
            fVar.a(gVarJ.a());
        }
    }
}
