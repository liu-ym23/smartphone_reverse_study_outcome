package b8;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1966g;

    /* renamed from: h, reason: collision with root package name */
    public Object f1967h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
        super(b0.C, jsonNode, nVar, lVar, qVar);
        this.f1966g = 1;
        JsonNode jsonNode2 = lVar.f15331g;
        JsonNode jsonNode3 = jsonNode2.get("minContains");
        LinkedHashSet linkedHashSet = null;
        int iIntValue = 1;
        if (jsonNode3 != null) {
            if (jsonNode3.isNumber() && jsonNode3.canConvertToExactIntegral() && jsonNode3.intValue() >= 0) {
                iIntValue = jsonNode3.intValue();
            } else {
                linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(new h0("minContains"));
            }
        }
        JsonNode jsonNode4 = jsonNode2.get("maxContains");
        int iIntValue2 = Reader.READ_DONE;
        if (jsonNode4 != null) {
            if (jsonNode4.isNumber() && jsonNode4.canConvertToExactIntegral() && jsonNode4.intValue() >= 0) {
                iIntValue2 = jsonNode4.intValue();
            } else {
                linkedHashSet = linkedHashSet == null ? new LinkedHashSet() : linkedHashSet;
                linkedHashSet.add(new h0("maxContains"));
            }
        }
        if (iIntValue2 < iIntValue) {
            linkedHashSet = linkedHashSet == null ? new LinkedHashSet() : linkedHashSet;
            linkedHashSet.add(new h0("minContainsVsMaxContains"));
        }
        this.f1967h = linkedHashSet;
    }

    public static stepos.support.v7.app.f m(w7.l lVar, androidx.room.q qVar, String str) {
        int i = 0;
        if (!str.startsWith("#")) {
            int iIndexOf = str.indexOf("#");
            String strO = o(lVar, iIndexOf > 0 ? str.substring(0, iIndexOf) : str);
            w7.n nVarC = w7.n.c(strO);
            o0 o0Var = new o0();
            o0Var.f1997c = qVar;
            o0Var.f1998f = strO;
            o0Var.f1999g = nVarC;
            o0Var.f2000h = iIndexOf;
            o0Var.i = str;
            o0Var.f2001j = str;
            VarHandle.storeStoreFence();
            ((w7.o) qVar.f1601d).f15349g.getClass();
            g8.e eVar = new g8.e();
            eVar.f4380f = null;
            eVar.f4379c = o0Var;
            return new stepos.support.v7.app.f(eVar);
        }
        if (str.startsWith("#") && !"#".equals(str) && !str.startsWith("#/")) {
            String strO2 = o(lVar, str);
            p0 p0Var = new p0();
            p0Var.f2006c = qVar;
            p0Var.f2007f = strO2;
            p0Var.f2008g = lVar;
            p0Var.f2009h = str;
            p0Var.i = str;
            VarHandle.storeStoreFence();
            ((w7.o) qVar.f1601d).f15349g.getClass();
            g8.e eVar2 = new g8.e();
            eVar2.f4380f = null;
            eVar2.f4379c = p0Var;
            return new stepos.support.v7.app.f(eVar2);
        }
        if (str.equals("#")) {
            q0 q0Var = new q0(i);
            q0Var.f2013f = lVar;
            VarHandle.storeStoreFence();
            ((w7.o) qVar.f1601d).f15349g.getClass();
            g8.e eVar3 = new g8.e();
            eVar3.f4380f = null;
            eVar3.f4379c = q0Var;
            return new stepos.support.v7.app.f(eVar3);
        }
        o oVar = new o(1);
        oVar.f1994f = lVar;
        oVar.i = qVar;
        oVar.f1995g = str;
        oVar.f1996h = str;
        VarHandle.storeStoreFence();
        ((w7.o) qVar.f1601d).f15349g.getClass();
        g8.e eVar4 = new g8.e();
        eVar4.f4380f = null;
        eVar4.f4379c = oVar;
        return new stepos.support.v7.app.f(eVar4);
    }

    public static w7.l n(w7.l lVar, androidx.room.q qVar, String str, String str2) {
        w7.l lVarF;
        String strO = o(lVar, str2);
        w7.l lVar2 = (w7.l) ((ConcurrentMap) qVar.f1602e).get(strO);
        if (lVar2 != null) {
            return lVar2;
        }
        c8.a aVarA = w7.k.a(str);
        synchronized (((w7.o) qVar.f1601d)) {
            try {
                lVarF = (w7.l) ((ConcurrentMap) qVar.f1602e).get(strO);
                if (lVarF == null && (lVarF = lVar.f(aVarA)) != null) {
                    ((ConcurrentMap) qVar.f1602e).put(strO, lVarF);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVarF;
    }

    public static String o(w7.l lVar, String str) {
        w7.l lVar2;
        if (lVar.f15325a != null && (lVar2 = lVar.f15332h) != null && ((y7.a) lVar.f15333j.f1600c).f15933e.f15356c <= 7) {
            lVar = lVar2;
        }
        return w7.n.d(lVar.i, str);
    }

    @Override // w7.s
    public void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        switch (this.f1966g) {
            case 4:
                w7.l lVarG = ((stepos.support.v7.app.f) this.f1967h).g();
                if (lVarG != null) {
                    if (jsonNode == null) {
                        w7.n nVar = lVarG.i;
                        Iterator itDescendingIterator = fVar.f15312g.descendingIterator();
                        while (itDescendingIterator.hasNext()) {
                            if (((w7.l) itDescendingIterator.next()).i.equals(nVar)) {
                                return;
                            }
                        }
                    }
                    lVarG.a(fVar, jsonNode, jsonNode2, aVar, z10);
                    return;
                }
                w7.j jVarJ = j();
                jVarJ.f15290a = b0.Y.f1938c;
                jVarJ.i = "internal.unresolvedRef";
                jVarJ.f15296g = "Reference {0} cannot be resolved";
                jVarJ.f15293d = aVar;
                jVarJ.f15291b = fVar.f15311f;
                jVarJ.f15294e = new Object[]{this.f1908b.asText()};
                throw new w7.i(jVarJ.a());
            default:
                super.a(fVar, jsonNode, jsonNode2, aVar, z10);
                return;
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        int i = this.f1966g;
        androidx.room.q qVar = this.f1954d;
        BigDecimal bigDecimalDecimalValue = null;
        Set linkedHashSet = null;
        int i3 = 0;
        switch (i) {
            case 0:
                String str = (String) this.f1967h;
                if (td.h.x(jsonNode, ((w7.o) qVar.f1601d).f15349g) != 3) {
                    return;
                }
                c(fVar);
                String strAsText = jsonNode.asText();
                if ("base64".equals(str)) {
                    try {
                        Base64.getDecoder().decode(strAsText);
                        return;
                    } catch (IllegalArgumentException unused) {
                        w7.j jVarJ = j();
                        jVarJ.f15293d = aVar;
                        jVarJ.f15291b = fVar.f15311f;
                        jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                        jVarJ.f15294e = new Object[]{str};
                        fVar.a(jVarJ.a());
                        return;
                    }
                }
                return;
            case 1:
                LinkedHashSet linkedHashSet2 = (LinkedHashSet) this.f1967h;
                if (linkedHashSet2 != null) {
                    Stream stream = linkedHashSet2.stream();
                    f0 f0Var = new f0(i3);
                    f0Var.f1958b = this;
                    f0Var.f1959c = aVar;
                    f0Var.f1960d = fVar;
                    VarHandle.storeStoreFence();
                    Stream map = stream.map(f0Var);
                    Objects.requireNonNull(fVar);
                    g0 g0Var = new g0(i3);
                    g0Var.f1963f = fVar;
                    VarHandle.storeStoreFence();
                    map.forEach(g0Var);
                    return;
                }
                return;
            case 2:
                BigDecimal bigDecimal = (BigDecimal) this.f1967h;
                if (bigDecimal != null) {
                    if (jsonNode.isNumber()) {
                        bigDecimalDecimalValue = jsonNode.isBigDecimal() ? jsonNode.decimalValue() : BigDecimal.valueOf(jsonNode.doubleValue());
                    } else {
                        ((w7.o) qVar.f1601d).f15349g.getClass();
                    }
                    if (bigDecimalDecimalValue == null || bigDecimalDecimalValue.divideAndRemainder(bigDecimal)[1].abs().compareTo(BigDecimal.ZERO) <= 0) {
                        return;
                    }
                    w7.j jVarJ2 = j();
                    jVarJ2.f15293d = aVar;
                    jVarJ2.f15291b = fVar.f15311f;
                    jVarJ2.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ2.f15294e = new Object[]{bigDecimal};
                    fVar.a(jVarJ2.a());
                    return;
                }
                return;
            case 3:
                if (jsonNode.isObject()) {
                    Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                    if (a.h(fVar)) {
                        i3 = 1;
                    } else {
                        a.d(fVar, e());
                    }
                    while (itFields.hasNext()) {
                        Map.Entry<String, JsonNode> next = itFields.next();
                        String key = next.getKey();
                        JsonNode value = next.getValue();
                        for (Map.Entry entry : ((IdentityHashMap) this.f1967h).entrySet()) {
                            if (((d8.c) entry.getKey()).matches(key)) {
                                c8.a aVarB = aVar.b(key);
                                int size = fVar.f15309d.size();
                                w7.l lVar = (w7.l) entry.getValue();
                                fVar.c(lVar.i.f15340b.d(-1).toString());
                                try {
                                    lVar.b(fVar, value, jsonNode2, aVarB);
                                    fVar.d();
                                    if (size == fVar.f15309d.size() && i3 != 0) {
                                        if (linkedHashSet == null) {
                                            linkedHashSet = new LinkedHashSet();
                                        }
                                        linkedHashSet.add(key);
                                    }
                                } catch (Throwable th) {
                                    fVar.d();
                                    throw th;
                                }
                            }
                        }
                    }
                    if (i3 != 0) {
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
                        return;
                    }
                    return;
                }
                return;
            default:
                w7.l lVarG = ((stepos.support.v7.app.f) this.f1967h).g();
                if (lVarG != null) {
                    lVarG.b(fVar, jsonNode, jsonNode2, aVar);
                    return;
                }
                w7.j jVarJ3 = j();
                jVarJ3.f15290a = b0.Y.f1938c;
                jVarJ3.i = "internal.unresolvedRef";
                jVarJ3.f15296g = "Reference {0} cannot be resolved";
                jVarJ3.f15293d = aVar;
                jVarJ3.f15291b = fVar.f15311f;
                jVarJ3.f15294e = new Object[]{this.f1908b.asText()};
                throw new w7.i(jVarJ3.a());
        }
    }

    @Override // b8.a
    public void i() {
        switch (this.f1966g) {
            case 3:
                f.l(((IdentityHashMap) this.f1967h).values());
                return;
            case 4:
                try {
                    ((stepos.support.v7.app.f) this.f1967h).g().h();
                    return;
                } catch (w7.m e10) {
                    throw e10;
                } catch (RuntimeException e11) {
                    throw new w7.m(e11);
                }
            default:
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1966g = i;
    }
}
