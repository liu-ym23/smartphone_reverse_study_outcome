package z3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.SchemaException;
import com.networknt.schema.keyword.KeywordType;
import java.util.Locale;
import k2.C1621a;
import l2.C1655a;

/* loaded from: classes3.dex */
public final class n extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final G g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        super(KeywordType.f3046q, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.f3047r, jsonNode, jVar, iVar, cVar);
                if (!jsonNode.isNumber()) {
                    throw new SchemaException("exclusiveMinimum value is not a number");
                }
                String strAsText = jsonNode.asText();
                if ((!jsonNode.isLong() && !jsonNode.isInt()) || !TypedValues.Custom.S_INT.equals(k())) {
                    this.g = new F.g(11, jsonNode, strAsText);
                    return;
                }
                long jAsLong = jsonNode.asLong();
                C1655a c1655a = new C1655a();
                c1655a.f5272a = strAsText;
                c1655a.b = jAsLong;
                this.g = c1655a;
                return;
            default:
                if (!jsonNode.isNumber()) {
                    throw new SchemaException("exclusiveMaximum value is not a number");
                }
                String strAsText2 = jsonNode.asText();
                if ((jsonNode.isLong() || jsonNode.isInt()) && TypedValues.Custom.S_INT.equals(k())) {
                    this.g = new C5.b(jsonNode, strAsText2, jsonNode.asLong(), 3);
                    return;
                } else {
                    this.g = new C1621a(jsonNode, strAsText2);
                    return;
                }
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        switch (this.f) {
            case 0:
                if (E3.b.a(jsonNode, ((u3.k) this.d.d).g)) {
                    G g = this.g;
                    if (g.x(jsonNode)) {
                        u3.g gVarJ = j();
                        gVarJ.getClass();
                        gVarJ.d = aVar;
                        gVarJ.b = fVar.f;
                        gVarJ.k = (Locale) fVar.f6698a.f177a;
                        gVarJ.e = new Object[]{g.w()};
                        fVar.a(gVarJ.a());
                        break;
                    }
                }
                break;
            default:
                if (E3.b.a(jsonNode, ((u3.k) this.d.d).g)) {
                    G g10 = this.g;
                    if (g10.x(jsonNode)) {
                        u3.g gVarJ2 = j();
                        gVarJ2.getClass();
                        gVarJ2.d = aVar;
                        gVarJ2.b = fVar.f;
                        gVarJ2.k = (Locale) fVar.f6698a.f177a;
                        gVarJ2.e = new Object[]{g10.w()};
                        fVar.a(gVarJ2.a());
                        break;
                    }
                }
                break;
        }
    }
}
