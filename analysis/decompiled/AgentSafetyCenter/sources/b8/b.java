package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1910g;

    /* renamed from: h, reason: collision with root package name */
    public w7.l f1911h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public Object f1912j;

    /* renamed from: k, reason: collision with root package name */
    public Object f1913k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1910g = i;
    }

    @Override // w7.s
    public void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        w7.l lVar;
        switch (this.f1910g) {
            case 0:
                if (z10 && jsonNode != null) {
                    n(fVar, jsonNode, jsonNode2, aVar, true);
                    break;
                } else if (jsonNode != null && jsonNode.isObject()) {
                    Iterator<String> itFieldNames = jsonNode.fieldNames();
                    while (itFieldNames.hasNext()) {
                        String next = itFieldNames.next();
                        if (!next.startsWith("#") && !((Set) this.f1912j).contains(next)) {
                            Iterator it = ((List) this.f1913k).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((d8.c) it.next()).matches(next)) {
                                        break;
                                    }
                                } else if (this.i && (lVar = this.f1911h) != null) {
                                    lVar.a(fVar, jsonNode.get(next), jsonNode2, aVar.b(next), z10);
                                }
                            }
                        }
                    }
                    break;
                }
                break;
            default:
                super.a(fVar, jsonNode, jsonNode2, aVar, z10);
                break;
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        c8.a aVar2;
        w7.f fVar2;
        b bVar;
        int i;
        switch (this.f1910g) {
            case 0:
                n(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            default:
                boolean z10 = this.i;
                Integer num = (Integer) this.f1912j;
                Integer num2 = (Integer) this.f1913k;
                ArrayList arrayList = new ArrayList();
                w7.l lVar = this.f1911h;
                int i3 = 0;
                if (lVar == null || !jsonNode.isArray()) {
                    aVar2 = aVar;
                    fVar2 = fVar;
                    bVar = this;
                    i = 0;
                } else {
                    boolean zG = fVar.g();
                    List list = fVar.f15309d;
                    try {
                        fVar.h(false);
                        ArrayList arrayList2 = new ArrayList();
                        fVar.f15309d = arrayList2;
                        Iterator<JsonNode> it = jsonNode.iterator();
                        int i10 = 0;
                        i = 0;
                        while (it.hasNext()) {
                            lVar.b(fVar, it.next(), jsonNode2, aVar.a(i));
                            if (arrayList2.isEmpty()) {
                                i10++;
                                arrayList.add(Integer.valueOf(i));
                            } else {
                                arrayList2.clear();
                            }
                            i++;
                        }
                        fVar.h(zG);
                        fVar.f15309d = list;
                        int iIntValue = num != null ? num.intValue() : 1;
                        if (i10 < iIntValue) {
                            m(fVar, z10 ? b0.H : b0.f1923l, (Locale) fVar.f15306a.f7721f, jsonNode, aVar, iIntValue);
                        }
                        if (num2 == null || i10 <= num2.intValue()) {
                            aVar2 = aVar;
                            fVar2 = fVar;
                            bVar = this;
                        } else {
                            m(fVar, z10 ? b0.C : b0.f1923l, (Locale) fVar.f15306a.f7721f, jsonNode, aVar, num2.intValue());
                            aVar2 = aVar;
                            fVar2 = fVar;
                            bVar = this;
                        }
                        i3 = i10;
                    } catch (Throwable th) {
                        fVar.h(zG);
                        fVar.f15309d = list;
                        throw th;
                    }
                }
                boolean zG2 = a.g(fVar2);
                if (lVar != null) {
                    w7.n nVar = bVar.f1909c;
                    if (!zG2) {
                        fVar2.f15306a.getClass();
                    } else if (i3 == i) {
                        androidx.room.t tVarE = fVar2.e();
                        c8.a aVar3 = fVar2.f15311f;
                        Boolean bool = Boolean.TRUE;
                        x7.a aVar4 = new x7.a();
                        aVar4.f15589f = true;
                        aVar4.f15584a = "contains";
                        aVar4.f15585b = aVar2;
                        aVar4.f15586c = nVar;
                        aVar4.f15587d = aVar3;
                        aVar4.f15588e = bool;
                        VarHandle.storeStoreFence();
                        tVarE.b(aVar4);
                    } else {
                        androidx.room.t tVarE2 = fVar2.e();
                        c8.a aVar5 = fVar2.f15311f;
                        x7.a aVar6 = new x7.a();
                        aVar6.f15589f = true;
                        aVar6.f15584a = "contains";
                        aVar6.f15585b = aVar2;
                        aVar6.f15586c = nVar;
                        aVar6.f15587d = aVar5;
                        aVar6.f15588e = arrayList;
                        VarHandle.storeStoreFence();
                        tVarE2.b(aVar6);
                    }
                    if (num != null) {
                        if (zG2) {
                            fVar2.c("minContains");
                            androidx.room.t tVarE3 = fVar2.e();
                            c8.a aVar7 = fVar2.f15311f;
                            w7.n nVarB = nVar.b("minContains");
                            x7.a aVar8 = new x7.a();
                            aVar8.f15589f = true;
                            aVar8.f15584a = "minContains";
                            aVar8.f15585b = aVar2;
                            aVar8.f15586c = nVarB;
                            aVar8.f15587d = aVar7;
                            aVar8.f15588e = num;
                            VarHandle.storeStoreFence();
                            tVarE3.b(aVar8);
                            fVar2.d();
                        } else {
                            fVar2.f15306a.getClass();
                        }
                    }
                    if (num2 != null) {
                        if (!zG2) {
                            fVar2.f15306a.getClass();
                            return;
                        }
                        fVar2.c("maxContains");
                        androidx.room.t tVarE4 = fVar2.e();
                        c8.a aVar9 = fVar2.f15311f;
                        w7.n nVarB2 = nVar.b("maxContains");
                        x7.a aVar10 = new x7.a();
                        aVar10.f15589f = true;
                        aVar10.f15584a = "maxContains";
                        aVar10.f15585b = aVar2;
                        aVar10.f15586c = nVarB2;
                        aVar10.f15587d = aVar9;
                        aVar10.f15588e = num2;
                        VarHandle.storeStoreFence();
                        tVarE4.b(aVar10);
                        fVar2.d();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // b8.a
    public final void i() {
        switch (this.f1910g) {
            case 0:
                w7.l lVar = this.f1911h;
                if (lVar != null) {
                    lVar.h();
                    break;
                }
                break;
            default:
                Optional.ofNullable(this.f1911h).ifPresent(new h(0));
                break;
        }
    }

    public void m(w7.f fVar, b0 b0Var, Locale locale, JsonNode jsonNode, c8.a aVar, int i) {
        String str = b0.H.equals(b0Var) ? "contains.min" : b0.C.equals(b0Var) ? "contains.max" : "contains";
        w7.j jVarJ = j();
        jVarJ.f15293d = aVar;
        jVarJ.f15291b = fVar.f15311f;
        jVarJ.i = str;
        jVarJ.f15319l = locale;
        jVarJ.f15294e = new Object[]{String.valueOf(i), this.f1911h.f15331g.toString()};
        jVarJ.f15290a = b0Var.f1938c;
        fVar.a(jVarJ.a());
    }

    public void n(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        boolean z11;
        boolean z12 = this.i;
        if (jsonNode.isObject()) {
            if (a.h(fVar)) {
                z11 = true;
            } else {
                a.d(fVar, e());
                z11 = false;
            }
            Set linkedHashSet = null;
            if (z12 && z11) {
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    linkedHashSet.add(itFieldNames.next());
                }
            }
            Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
            while (itFields.hasNext()) {
                Map.Entry<String, JsonNode> next = itFields.next();
                String key = next.getKey();
                if (!key.startsWith("#") && !((Set) this.f1912j).contains(key)) {
                    Iterator it = ((List) this.f1913k).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((d8.c) it.next()).matches(key)) {
                                break;
                            }
                        } else if (z12) {
                            w7.l lVar = this.f1911h;
                            if (lVar != null) {
                                if (z10) {
                                    lVar.a(fVar, next.getValue(), jsonNode2, aVar.b(key), true);
                                } else {
                                    lVar.b(fVar, next.getValue(), jsonNode2, aVar.b(key));
                                }
                            }
                        } else {
                            w7.j jVar = (w7.j) j().b(key);
                            jVar.f15293d = aVar;
                            jVar.f15291b = fVar.f15311f;
                            jVar.f15319l = (Locale) fVar.f15306a.f7721f;
                            jVar.f15294e = new Object[]{key};
                            fVar.a(jVar.a());
                        }
                    }
                }
            }
            if (z11) {
                androidx.room.t tVarE = fVar.e();
                c8.a aVar2 = fVar.f15311f;
                if (linkedHashSet == null) {
                    linkedHashSet = Collections.EMPTY_SET;
                }
                x7.a aVar3 = new x7.a();
                aVar3.f15589f = true;
                aVar3.f15584a = this.f1907a;
                aVar3.f15585b = aVar;
                aVar3.f15586c = this.f1909c;
                aVar3.f15587d = aVar2;
                aVar3.f15588e = linkedHashSet;
                VarHandle.storeStoreFence();
                tVarE.b(aVar3);
            }
        }
    }
}
