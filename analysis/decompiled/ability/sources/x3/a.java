package x3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.SpecificationVersion;
import java.util.Map;
import w3.C2097b;
import z3.AbstractC2161f;
import z3.o;

/* loaded from: classes3.dex */
public abstract class a extends AbstractC2161f {
    public final boolean f;

    public a(u3.j jVar, JsonNode jsonNode, u3.i iVar, o oVar, G6.c cVar) {
        super(oVar, jsonNode, jVar, iVar, cVar);
        C2097b c2097b = (C2097b) this.d.c;
        SpecificationVersion specificationVersion = c2097b.e;
        if (specificationVersion == null || specificationVersion.f3013a < 8) {
            this.f = true;
        } else {
            this.f = n(specificationVersion, c2097b.d);
        }
    }

    public static boolean n(SpecificationVersion specificationVersion, Map map) {
        if (SpecificationVersion.DRAFT_2020_12.equals(specificationVersion)) {
            return map.containsKey("https://json-schema.org/draft/2020-12/vocab/format-assertion");
        }
        if (SpecificationVersion.DRAFT_2019_09.equals(specificationVersion)) {
            return ((Boolean) map.getOrDefault("https://json-schema.org/draft/2019-09/vocab/format", Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public final boolean m(u3.f fVar) {
        Boolean bool = Boolean.TRUE;
        fVar.f6698a.getClass();
        if (bool.equals(null)) {
            return true;
        }
        Boolean bool2 = Boolean.FALSE;
        fVar.f6698a.getClass();
        if (bool2.equals(null)) {
            return false;
        }
        return this.f;
    }
}
