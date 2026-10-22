package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends f {
    public static final rd.b i = rd.d.b(k0.class);

    /* renamed from: g, reason: collision with root package name */
    public String f1976g;

    /* renamed from: h, reason: collision with root package name */
    public d8.c f1977h;

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        String str = this.f1976g;
        if (td.h.x(jsonNode, ((w7.o) this.f1954d.f1601d).f15349g) != 3) {
            return;
        }
        try {
            if (this.f1977h.matches(jsonNode.asText())) {
                return;
            }
            w7.j jVarJ = j();
            jVarJ.f15293d = aVar;
            jVarJ.f15291b = fVar.f15311f;
            jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
            jVarJ.f15294e = new Object[]{str};
            fVar.a(jVarJ.a());
        } catch (w7.g | w7.m e10) {
            throw e10;
        } catch (RuntimeException e11) {
            i.error("Failed to apply pattern '{}' at {}: {}", str, aVar, e11.getMessage());
            throw e11;
        }
    }
}
