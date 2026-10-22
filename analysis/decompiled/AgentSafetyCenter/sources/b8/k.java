package b8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1974g;

    /* renamed from: h, reason: collision with root package name */
    public Object f1975h;
    public Serializable i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
        String str;
        super(b0.f1915b0, jsonNode, nVar, lVar, qVar);
        this.f1974g = 2;
        StringBuilder sb2 = new StringBuilder("[");
        if (!jsonNode.isArray()) {
            throw new w7.m("Expected array for type property on Union Type Definition.");
        }
        this.f1975h = new ArrayList(jsonNode.size());
        Iterator<JsonNode> it = jsonNode.iterator();
        String str2 = "";
        int i = 0;
        while (it.hasNext()) {
            JsonNode next = it.next();
            int iV = td.h.v(next);
            sb2.append(str2);
            switch (iV) {
                case 1:
                    str = "OBJECT";
                    break;
                case 2:
                    str = "ARRAY";
                    break;
                case 3:
                    str = "STRING";
                    break;
                case 4:
                    str = "NUMBER";
                    break;
                case 5:
                    str = "INTEGER";
                    break;
                case 6:
                    str = "BOOLEAN";
                    break;
                case 7:
                    str = "NULL";
                    break;
                case 8:
                    str = "ANY";
                    break;
                case 9:
                    str = "UNKNOWN";
                    break;
                case 10:
                    str = "UNION";
                    break;
                default:
                    str = "null";
                    break;
            }
            sb2.append(str);
            boolean zIsObject = next.isObject();
            ArrayList arrayList = (ArrayList) this.f1975h;
            if (zIsObject) {
                arrayList.add(qVar.d(nVar.a(i), next, lVar));
            } else {
                arrayList.add(new s0(nVar.a(i), next, lVar, qVar));
            }
            i++;
            str2 = ", ";
        }
        sb2.append(']');
        this.i = sb2.toString();
    }

    public static ArrayNode m(ArrayNode arrayNode) {
        for (int i = 0; i < arrayNode.size(); i++) {
            if (arrayNode.get(i).isNumber()) {
                ArrayNode arrayNodeDeepCopy = arrayNode.deepCopy();
                for (int i3 = 0; i3 < arrayNodeDeepCopy.size(); i3++) {
                    JsonNode jsonNode = arrayNodeDeepCopy.get(i3);
                    if (jsonNode.isNumber()) {
                        arrayNodeDeepCopy.set(i3, DecimalNode.valueOf(new BigDecimal(jsonNode.decimalValue().toPlainString())));
                    }
                }
                return arrayNodeDeepCopy;
            }
        }
        return arrayNode;
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        switch (this.f1974g) {
            case 0:
                HashMap map = (HashMap) this.f1975h;
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    List list = (List) map.get(next);
                    if (list != null && !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (jsonNode.get((String) it.next()) == null) {
                                w7.j jVar = (w7.j) j().b(next);
                                jVar.f15293d = aVar;
                                jVar.f15291b = fVar.f15311f;
                                jVar.f15319l = (Locale) fVar.f15306a.f7721f;
                                jVar.f15294e = new Object[]{map.toString()};
                                fVar.a(jVar.a());
                            }
                        }
                    }
                    w7.l lVar = (w7.l) ((HashMap) this.i).get(next);
                    if (lVar != null) {
                        fVar.c(next);
                        try {
                            lVar.b(fVar, jsonNode, jsonNode2, aVar);
                        } finally {
                            fVar.d();
                        }
                    }
                }
                return;
            case 1:
                Set set = (Set) this.f1975h;
                if (jsonNode.isNumber()) {
                    jsonNode = DecimalNode.valueOf(new BigDecimal(jsonNode.decimalValue().toPlainString()));
                } else if (jsonNode.isArray()) {
                    jsonNode = m((ArrayNode) jsonNode);
                }
                if (set.contains(jsonNode)) {
                    return;
                }
                ((w7.o) this.f1954d.f1601d).f15349g.getClass();
                w7.j jVarJ = j();
                jVarJ.f15293d = aVar;
                jVarJ.f15291b = fVar.f15311f;
                jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                jVarJ.f15294e = new Object[]{(String) this.i};
                fVar.a(jVarJ.a());
                return;
            default:
                int iX = td.h.x(jsonNode, ((w7.o) this.f1954d.f1601d).f15349g);
                boolean zG = fVar.g();
                List list2 = fVar.f15309d;
                try {
                    ArrayList arrayList = new ArrayList();
                    boolean z10 = false;
                    fVar.h(false);
                    fVar.f15309d = arrayList;
                    ArrayList arrayList2 = (ArrayList) this.f1975h;
                    int size = arrayList2.size();
                    int i = 0;
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            Object obj = arrayList2.get(i3);
                            i3++;
                            w7.s sVar = (w7.s) obj;
                            fVar.b(i);
                            try {
                                sVar.b(fVar, jsonNode, jsonNode2, aVar);
                                fVar.d();
                                i++;
                                if (arrayList.isEmpty()) {
                                    z10 = true;
                                } else {
                                    arrayList.clear();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (z10) {
                        return;
                    }
                    w7.j jVarJ2 = j();
                    jVarJ2.f15293d = aVar;
                    jVarJ2.f15290a = "type";
                    jVarJ2.f15291b = fVar.f15311f;
                    jVarJ2.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ2.f15294e = new Object[]{androidx.activity.b.b(iX), (String) this.i};
                    fVar.a(jVarJ2.a());
                    return;
                } finally {
                    fVar.h(zG);
                    fVar.f15309d = list2;
                }
        }
    }

    @Override // b8.a
    public String e() {
        switch (this.f1974g) {
            case 2:
                return "type";
            default:
                return super.e();
        }
    }

    @Override // b8.a
    public void i() {
        switch (this.f1974g) {
            case 0:
                f.l(((HashMap) this.i).values());
                break;
            case 2:
                ArrayList arrayList = (ArrayList) this.f1975h;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    w7.s sVar = (w7.s) obj;
                    if (sVar instanceof a) {
                        ((a) sVar).i();
                    } else if (sVar instanceof w7.l) {
                        ((w7.l) sVar).h();
                    }
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1974g = i;
    }
}
