package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.utils.JsonType;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class w extends AbstractC2161f {
    public final /* synthetic */ int f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(t tVar, JsonNode jsonNode, u3.j jVar, u3.i iVar, G6.c cVar, int i) {
        super(tVar, jsonNode, jVar, iVar, cVar);
        this.f = i;
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        switch (this.f) {
            case 0:
                int i = this.g;
                if (!jsonNode.isArray()) {
                    ((u3.k) this.d.d).g.getClass();
                    break;
                } else if (jsonNode.size() > i) {
                    u3.g gVarJ = j();
                    gVarJ.getClass();
                    gVarJ.d = aVar;
                    gVarJ.b = fVar.f;
                    gVarJ.k = (Locale) fVar.f6698a.f177a;
                    gVarJ.e = new Object[]{Integer.valueOf(i), Integer.valueOf(jsonNode.size())};
                    fVar.a(gVarJ.a());
                    break;
                }
                break;
            case 1:
                int i6 = this.g;
                if (com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) this.d.d).g) == JsonType.STRING && jsonNode.textValue().codePointCount(0, jsonNode.textValue().length()) > i6) {
                    u3.g gVarJ2 = j();
                    gVarJ2.getClass();
                    gVarJ2.d = aVar;
                    gVarJ2.b = fVar.f;
                    gVarJ2.k = (Locale) fVar.f6698a.f177a;
                    gVarJ2.e = new Object[]{Integer.valueOf(i6)};
                    fVar.a(gVarJ2.a());
                    break;
                }
                break;
            case 2:
                int i10 = this.g;
                if (jsonNode.isObject() && jsonNode.size() > i10) {
                    u3.g gVarJ3 = j();
                    gVarJ3.getClass();
                    gVarJ3.d = aVar;
                    gVarJ3.b = fVar.f;
                    gVarJ3.k = (Locale) fVar.f6698a.f177a;
                    gVarJ3.e = new Object[]{Integer.valueOf(i10)};
                    fVar.a(gVarJ3.a());
                    break;
                }
                break;
            case 3:
                int i11 = this.g;
                if (!jsonNode.isArray()) {
                    ((u3.k) this.d.d).g.getClass();
                    break;
                } else if (jsonNode.size() < i11) {
                    u3.g gVarJ4 = j();
                    gVarJ4.getClass();
                    gVarJ4.d = aVar;
                    gVarJ4.b = fVar.f;
                    gVarJ4.k = (Locale) fVar.f6698a.f177a;
                    gVarJ4.e = new Object[]{Integer.valueOf(i11), Integer.valueOf(jsonNode.size())};
                    fVar.a(gVarJ4.a());
                    break;
                }
                break;
            case 4:
                int i12 = this.g;
                if (com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) this.d.d).g) == JsonType.STRING && jsonNode.textValue().codePointCount(0, jsonNode.textValue().length()) < i12) {
                    u3.g gVarJ5 = j();
                    gVarJ5.getClass();
                    gVarJ5.d = aVar;
                    gVarJ5.b = fVar.f;
                    gVarJ5.k = (Locale) fVar.f6698a.f177a;
                    gVarJ5.e = new Object[]{Integer.valueOf(i12)};
                    fVar.a(gVarJ5.a());
                    break;
                }
                break;
            default:
                int i13 = this.g;
                if (jsonNode.isObject() && jsonNode.size() < i13) {
                    u3.g gVarJ6 = j();
                    gVarJ6.getClass();
                    gVarJ6.d = aVar;
                    gVarJ6.b = fVar.f;
                    gVarJ6.k = (Locale) fVar.f6698a.f177a;
                    gVarJ6.e = new Object[]{Integer.valueOf(i13)};
                    fVar.a(gVarJ6.a());
                    break;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        super(KeywordType.f3053z, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.f3017A, jsonNode, jVar, iVar, cVar);
                if (jsonNode != null && jsonNode.canConvertToExactIntegral()) {
                    this.g = jsonNode.intValue();
                    break;
                } else {
                    this.g = Integer.MAX_VALUE;
                    break;
                }
                break;
            case 2:
                super(KeywordType.f3018B, jsonNode, jVar, iVar, cVar);
                if (!jsonNode.canConvertToExactIntegral()) {
                    this.g = Integer.MAX_VALUE;
                    break;
                } else {
                    this.g = jsonNode.intValue();
                    break;
                }
            case 3:
            case 4:
            default:
                if (!jsonNode.canConvertToExactIntegral()) {
                    this.g = 0;
                    break;
                } else {
                    this.g = jsonNode.intValue();
                    break;
                }
            case 5:
                super(KeywordType.f3022G, jsonNode, jVar, iVar, cVar);
                if (!jsonNode.canConvertToExactIntegral()) {
                    this.g = 0;
                    break;
                } else {
                    this.g = jsonNode.intValue();
                    break;
                }
        }
    }
}
