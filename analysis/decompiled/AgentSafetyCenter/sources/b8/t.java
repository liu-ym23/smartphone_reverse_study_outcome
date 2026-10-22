package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends f {
    public static final rd.b i = rd.d.b(t.class);

    /* renamed from: g, reason: collision with root package name */
    public boolean f2020g;

    /* renamed from: h, reason: collision with root package name */
    public z7.d f2021h;

    public static boolean n(w7.q qVar, HashMap map) {
        if (w7.q.DRAFT_2020_12.equals(qVar)) {
            return map.containsKey("https://json-schema.org/draft/2020-12/vocab/format-assertion");
        }
        if (w7.q.DRAFT_2019_09.equals(qVar)) {
            return ((Boolean) map.getOrDefault("https://json-schema.org/draft/2019-09/vocab/format", Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        z7.d dVar = this.f2021h;
        c(fVar);
        boolean zM = m(fVar);
        androidx.room.q qVar = this.f1954d;
        if (dVar != null) {
            if (zM) {
                try {
                    if (td.h.x(jsonNode, ((w7.o) qVar.f1601d).f15349g) != 3 ? true : dVar.b(fVar, qVar, jsonNode.textValue())) {
                        return;
                    }
                    w7.j jVarJ = j();
                    jVarJ.f15293d = aVar;
                    jVarJ.f15291b = fVar.f15311f;
                    jVarJ.i = dVar.a();
                    jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ.f15294e = new Object[]{dVar.getName(), jsonNode.asText()};
                    fVar.a(jVarJ.a());
                    return;
                } catch (PatternSyntaxException e10) {
                    i.error("Failed to apply pattern on {}: Invalid RE syntax [{}]", aVar, dVar.getName(), e10);
                    return;
                }
            }
            return;
        }
        if (!m(fVar) || !((w7.o) qVar.f1601d).f15349g.b(this.f1907a, Boolean.FALSE)) {
            y7.a aVar2 = (y7.a) qVar.f1600c;
            if (!n(aVar2.f15933e, aVar2.f15932d)) {
                return;
            }
        }
        JsonNode jsonNode3 = this.f1908b;
        if (jsonNode3.isTextual()) {
            w7.j jVarJ2 = j();
            jVarJ2.f15293d = aVar;
            jVarJ2.f15291b = fVar.f15311f;
            jVarJ2.i = "format.unknown";
            jVarJ2.f15294e = new Object[]{jsonNode3.textValue()};
            fVar.a(jVarJ2.a());
        }
    }

    public final boolean m(w7.f fVar) {
        Boolean bool = Boolean.TRUE;
        fVar.f15306a.getClass();
        if (bool.equals(null)) {
            return true;
        }
        Boolean bool2 = Boolean.FALSE;
        fVar.f15306a.getClass();
        if (bool2.equals(null)) {
            return false;
        }
        return this.f2020g;
    }
}
