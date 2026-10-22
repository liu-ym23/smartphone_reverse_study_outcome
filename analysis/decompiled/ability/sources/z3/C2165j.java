package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.networknt.schema.SchemaException;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.utils.JsonType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import w3.C2097b;

/* renamed from: z3.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2165j extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final Object g;
    public final Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2165j(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        JsonNode jsonNode2;
        super(KeywordType.k, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.p, jsonNode, jVar, iVar, cVar);
                if (jsonNode == null || !jsonNode.isArray()) {
                    this.g = Collections.EMPTY_SET;
                    this.h = "[none]";
                    return;
                }
                this.g = new HashSet();
                StringBuilder sb = new StringBuilder("[");
                Iterator<JsonNode> it = jsonNode.iterator();
                String str = "";
                while (it.hasNext()) {
                    JsonNode next = it.next();
                    if (next.isNumber()) {
                        ((Set) this.g).add(DecimalNode.valueOf(new BigDecimal(next.decimalValue().toPlainString())));
                    } else if (next.isArray()) {
                        ((Set) this.g).add(m((ArrayNode) next));
                    } else {
                        ((Set) this.g).add(next);
                    }
                    sb.append(str);
                    sb.append((next.isObject() || next.isArray() || next.isTextual()) ? next.toString() : next.asText());
                    str = ", ";
                }
                if (cVar.b && (jsonNode2 = iVar.g.get("nullable")) != null && jsonNode2.asBoolean()) {
                    ((Set) this.g).add(NullNode.getInstance());
                    sb.append(", null");
                }
                sb.append(']');
                this.h = sb.toString();
                return;
            case 2:
                super(KeywordType.b0, jsonNode, jVar, iVar, cVar);
                JsonType jsonTypeC = com.stepos.ability.task.executor.e.C(jsonNode);
                this.g = jsonTypeC;
                if (jsonTypeC == JsonType.UNION) {
                    this.h = new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    return;
                } else {
                    this.h = null;
                    return;
                }
            case 3:
                super(KeywordType.b0, jsonNode, jVar, iVar, cVar);
                StringBuilder sb2 = new StringBuilder("[");
                if (!jsonNode.isArray()) {
                    throw new SchemaException("Expected array for type property on Union Type Definition.");
                }
                this.g = new ArrayList(jsonNode.size());
                Iterator<JsonNode> it2 = jsonNode.iterator();
                String str2 = "";
                int i6 = 0;
                while (it2.hasNext()) {
                    JsonNode next2 = it2.next();
                    JsonType jsonTypeC2 = com.stepos.ability.task.executor.e.C(next2);
                    sb2.append(str2);
                    sb2.append(jsonTypeC2);
                    if (next2.isObject()) {
                        ((ArrayList) this.g).add(cVar.c(jVar.a(i6), next2, iVar));
                    } else {
                        ((ArrayList) this.g).add(new C2165j(jVar.a(i6), next2, iVar, cVar, 2));
                    }
                    i6++;
                    str2 = ", ";
                }
                sb2.append(']');
                this.h = sb2.toString();
                return;
            default:
                this.g = new HashMap();
                this.h = new HashMap();
                Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                while (itFields.hasNext()) {
                    Map.Entry<String, JsonNode> next3 = itFields.next();
                    String key = next3.getKey();
                    JsonNode value = next3.getValue();
                    if (value.isArray()) {
                        List arrayList = (List) ((HashMap) this.g).get(key);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            ((HashMap) this.g).put(key, arrayList);
                        }
                        for (int i10 = 0; i10 < value.size(); i10++) {
                            arrayList.add(value.get(i10).asText());
                        }
                    } else if (value.isObject() || value.isBoolean()) {
                        ((HashMap) this.h).put(key, cVar.c(jVar.b(key), value, iVar));
                    }
                }
                return;
        }
    }

    public static ArrayNode m(ArrayNode arrayNode) {
        for (int i = 0; i < arrayNode.size(); i++) {
            if (arrayNode.get(i).isNumber()) {
                ArrayNode arrayNodeDeepCopy = arrayNode.deepCopy();
                for (int i6 = 0; i6 < arrayNodeDeepCopy.size(); i6++) {
                    JsonNode jsonNode = arrayNodeDeepCopy.get(i6);
                    if (jsonNode.isNumber()) {
                        arrayNodeDeepCopy.set(i6, DecimalNode.valueOf(new BigDecimal(jsonNode.decimalValue().toPlainString())));
                    }
                }
                return arrayNodeDeepCopy;
            }
        }
        return arrayNode;
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        int i = this.f;
        boolean zEquals = false;
        G6.c cVar = this.d;
        Object obj = this.h;
        Object obj2 = this.g;
        switch (i) {
            case 0:
                HashMap map = (HashMap) obj2;
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    List list = (List) map.get(next);
                    if (list != null && !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (jsonNode.get((String) it.next()) == null) {
                                u3.g gVarJ = j();
                                gVarJ.getClass();
                                u3.g gVar = (u3.g) gVarJ.b(next);
                                gVar.d = aVar;
                                gVar.b = fVar.f;
                                gVar.k = (Locale) fVar.f6698a.f177a;
                                gVar.e = new Object[]{map.toString()};
                                fVar.a(gVar.a());
                            }
                        }
                    }
                    u3.i iVar = (u3.i) ((HashMap) obj).get(next);
                    if (iVar != null) {
                        fVar.c(next);
                        try {
                            iVar.a(fVar, jsonNode, jsonNode2, aVar);
                        } finally {
                            fVar.d();
                        }
                    }
                }
                return;
            case 1:
                if (jsonNode.isNumber()) {
                    jsonNode = DecimalNode.valueOf(new BigDecimal(jsonNode.decimalValue().toPlainString()));
                } else if (jsonNode.isArray()) {
                    jsonNode = m((ArrayNode) jsonNode);
                }
                if (((Set) obj2).contains(jsonNode)) {
                    return;
                }
                ((u3.k) cVar.d).g.getClass();
                u3.g gVarJ2 = j();
                gVarJ2.getClass();
                gVarJ2.d = aVar;
                gVarJ2.b = fVar.f;
                gVarJ2.k = (Locale) fVar.f6698a.f177a;
                gVarJ2.e = new Object[]{(String) obj};
                fVar.a(gVarJ2.a());
                return;
            case 2:
                JsonType jsonType = (JsonType) obj2;
                if (jsonType == JsonType.UNION) {
                    ((C2165j) obj).a(fVar, jsonNode, jsonNode2, aVar);
                    return;
                }
                int i6 = E3.b.b;
                T6.a aVar2 = ((u3.k) cVar.d).g;
                JsonType jsonTypeD = com.stepos.ability.task.executor.e.D(jsonNode, aVar2);
                if (jsonTypeD != jsonType) {
                    JsonType jsonType2 = JsonType.INTEGER;
                    JsonType jsonType3 = JsonType.NUMBER;
                    if (jsonType == jsonType3 && jsonTypeD == jsonType2) {
                        return;
                    }
                    if (jsonType == jsonType2 && jsonTypeD == jsonType3 && jsonNode.canConvertToExactIntegral() && E3.b.f462a <= ((C2097b) cVar.c).e.f3013a) {
                        return;
                    }
                    JsonType jsonType4 = JsonType.NULL;
                    u3.i iVar2 = this.e;
                    if (jsonTypeD == jsonType4 && iVar2 != null && cVar.b) {
                        u3.i iVar3 = iVar2.h;
                        if (iVar3 != null && (jsonNode4 = iVar3.g.get("nullable")) != null && jsonNode4.asBoolean()) {
                            return;
                        }
                        JsonNode jsonNode5 = iVar2.g.get("nullable");
                        if (jsonNode5 != null && jsonNode5.asBoolean()) {
                            return;
                        }
                    }
                    if (!aVar2.c("type", Boolean.TRUE)) {
                        JsonNode jsonNode6 = null;
                        if (iVar2 != null) {
                            JsonNode jsonNode7 = iVar2.g;
                            if (jsonNode7 != null) {
                                jsonNode6 = jsonNode7.get("type");
                                jsonNode3 = jsonNode7.get("enum");
                            } else {
                                jsonNode3 = null;
                            }
                            zEquals = "$ref".equals(fVar.f.b.b(-1));
                        } else {
                            jsonNode3 = null;
                        }
                        if (jsonNode6 != null && jsonNode3 != null && zEquals && com.stepos.ability.task.executor.e.C(jsonNode6) == JsonType.OBJECT && jsonNode3.isArray()) {
                            return;
                        }
                    }
                    if (jsonType == JsonType.ANY) {
                        return;
                    }
                    JsonType jsonTypeD2 = com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) cVar.d).g);
                    u3.g gVarJ3 = j();
                    gVarJ3.getClass();
                    gVarJ3.d = aVar;
                    gVarJ3.b = fVar.f;
                    gVarJ3.k = (Locale) fVar.f6698a.f177a;
                    gVarJ3.e = new Object[]{jsonTypeD2.f3057a, jsonType.f3057a};
                    fVar.a(gVarJ3.a());
                    return;
                }
                return;
            default:
                JsonType jsonTypeD3 = com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) cVar.d).g);
                boolean zG = fVar.g();
                List list2 = fVar.d;
                try {
                    ArrayList arrayList = new ArrayList();
                    fVar.h(false);
                    fVar.d = arrayList;
                    Iterator it2 = ((ArrayList) obj2).iterator();
                    int i10 = 0;
                    while (true) {
                        if (it2.hasNext()) {
                            u3.m mVar = (u3.m) it2.next();
                            fVar.b(i10);
                            try {
                                mVar.a(fVar, jsonNode, jsonNode2, aVar);
                                fVar.d();
                                i10++;
                                if (arrayList.isEmpty()) {
                                    zEquals = true;
                                } else {
                                    arrayList.clear();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (zEquals) {
                        return;
                    }
                    u3.g gVarJ4 = j();
                    gVarJ4.getClass();
                    gVarJ4.d = aVar;
                    gVarJ4.f6696a = "type";
                    gVarJ4.b = fVar.f;
                    gVarJ4.k = (Locale) fVar.f6698a.f177a;
                    gVarJ4.e = new Object[]{jsonTypeD3.f3057a, (String) obj};
                    fVar.a(gVarJ4.a());
                    return;
                } finally {
                    fVar.h(zG);
                    fVar.d = list2;
                }
        }
    }

    @Override // z3.AbstractC2156a
    public String e() {
        switch (this.f) {
            case 3:
                return "type";
            default:
                return super.e();
        }
    }

    @Override // z3.AbstractC2156a
    public void i() {
        switch (this.f) {
            case 0:
                AbstractC2161f.l(((HashMap) this.h).values());
                break;
            case 3:
                Iterator it = ((ArrayList) this.g).iterator();
                while (it.hasNext()) {
                    u3.m mVar = (u3.m) it.next();
                    if (mVar instanceof AbstractC2156a) {
                        ((AbstractC2156a) mVar).i();
                    } else if (mVar instanceof u3.i) {
                        ((u3.i) mVar).h();
                    }
                }
                break;
        }
    }
}
