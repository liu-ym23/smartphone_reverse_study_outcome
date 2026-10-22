package u3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.FailFastAssertionException;
import com.networknt.schema.InvalidSchemaException;
import com.networknt.schema.InvalidSchemaRefException;
import com.networknt.schema.SchemaException;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.path.PathType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import v3.C2057a;
import w3.C2097b;
import z3.AbstractC2156a;

/* loaded from: classes3.dex */
public final class i implements m {
    public static final long l = 8;
    public static final androidx.appsearch.app.a m = new androidx.appsearch.app.a(4);

    /* renamed from: a, reason: collision with root package name */
    public final String f6702a;
    public List b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final JsonNode g;
    public final i h;
    public final j i;

    /* renamed from: j, reason: collision with root package name */
    public final G6.c f6703j;
    public final boolean k;

    public i(G6.c cVar, j jVar, JsonNode jsonNode, i iVar, boolean z10) {
        j jVarE;
        JsonNode jsonNode2;
        JsonNode jsonNode3;
        ConcurrentMap concurrentMap = (ConcurrentMap) cVar.f;
        String strTextValue = null;
        this.b = null;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.f6703j = cVar;
        C2097b c2097b = (C2097b) cVar.c;
        JsonNode jsonNode4 = jsonNode.get(c2097b.b);
        String strTextValue2 = jsonNode4 == null ? null : jsonNode4.textValue();
        if (strTextValue2 != null) {
            int iIndexOf = strTextValue2.indexOf(35);
            String strSubstring = (iIndexOf == -1 || iIndexOf + 1 >= strTextValue2.length()) ? strTextValue2 : strTextValue2.substring(0, iIndexOf);
            jVarE = !"".equals(strSubstring) ? jVar.e(strSubstring) : jVar;
            ((k) cVar.d).g.getClass();
            if ((jVar.f6704a != null && !jVar.toString().startsWith("#")) || (!strTextValue2.startsWith("#") && !strTextValue2.startsWith("/"))) {
                C2035a c2035a = jVarE.f6704a;
                if (c2035a != null) {
                    String str = c2035a.f6694a;
                    if (str.contains(":")) {
                        try {
                            new URI(str);
                        } catch (URISyntaxException unused) {
                        }
                    }
                }
                j jVarB = jVar.b(c2097b.b);
                C2036b c2036b = new C2036b();
                String str2 = KeywordType.u.f3054a;
                c2036b.i = str2;
                c2036b.f6696a = str2;
                c2036b.d = jVarB.b;
                c2036b.e = new Object[]{strTextValue2, c2097b.b, jVarB};
                c2036b.c = jVarB;
                c2036b.h = new B5.a(cVar, 22);
                throw new InvalidSchemaException(c2036b.a());
            }
        } else {
            jVarE = jVar;
        }
        this.i = jVarE;
        this.g = jsonNode;
        this.h = iVar;
        this.k = z10;
        JsonNode jsonNode5 = jsonNode.get(c2097b.b);
        String strTextValue3 = jsonNode5 == null ? null : jsonNode5.textValue();
        if (strTextValue3 != null) {
            j jVarE2 = strTextValue3.indexOf(35) != -1 ? jVar.e(strTextValue3) : jVarE;
            A3.a aVar = jVarE.b;
            if (aVar == null || (aVar.b == null && aVar.getNameCount() == 0)) {
                this.f6702a = strTextValue3;
            } else {
                this.f6702a = null;
            }
            concurrentMap.putIfAbsent(jVarE2 != null ? jVarE2.toString() : strTextValue3, this);
        } else {
            A3.a aVar2 = jVarE.b;
            if (aVar2 == null || (aVar2.b == null && aVar2.getNameCount() == 0)) {
                C2035a c2035a2 = jVar.f6704a;
                this.f6702a = c2035a2 != null ? c2035a2.f6694a : "";
                concurrentMap.putIfAbsent(jVar.toString(), this);
            } else {
                this.f6702a = null;
            }
        }
        String strTextValue4 = (!c2097b.c.containsKey("$anchor") || (jsonNode3 = jsonNode.get("$anchor")) == null) ? null : jsonNode3.textValue();
        if (strTextValue4 != null) {
            C2035a c2035a3 = jVarE.f6704a;
            concurrentMap.putIfAbsent((c2035a3 != null ? c2035a3.f6694a : "") + "#" + strTextValue4, this);
        }
        if (c2097b.c.containsKey("$dynamicAnchor") && (jsonNode2 = jsonNode.get("$dynamicAnchor")) != null) {
            strTextValue = jsonNode2.textValue();
        }
        if (strTextValue != null) {
            C2035a c2035a4 = jVarE.f6704a;
            String str3 = c2035a4 != null ? c2035a4.f6694a : "";
            ((ConcurrentMap) cVar.g).putIfAbsent(str3 + "#" + strTextValue, this);
        }
        g();
    }

    @Override // u3.m
    public final void a(f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        List<C2057a> list;
        List<AbstractC2156a> listG = g();
        ArrayDeque arrayDeque = fVar.g;
        ArrayDeque arrayDeque2 = fVar.h;
        arrayDeque.addLast(this);
        boolean z10 = fVar.f6699j;
        boolean z11 = fVar.k;
        boolean z12 = this.c;
        if (z12) {
            fVar.f6699j = z12;
        }
        boolean z13 = this.d;
        if (z13) {
            fVar.k = z13;
        }
        try {
            int size = fVar.d.size();
            for (AbstractC2156a abstractC2156a : listG) {
                fVar.c(abstractC2156a.e());
                arrayDeque2.addLast(abstractC2156a.e());
                try {
                    abstractC2156a.a(fVar, jsonNode, jsonNode2, aVar);
                    fVar.d();
                    arrayDeque2.removeLast();
                } catch (Throwable th) {
                    fVar.d();
                    arrayDeque2.removeLast();
                    throw th;
                }
            }
            if (fVar.d.size() > size && (list = (List) fVar.e().b.get(aVar)) != null) {
                for (C2057a c2057a : list) {
                    if (c2057a.d.c(fVar.f)) {
                        c2057a.f = false;
                    }
                }
            }
            arrayDeque.removeLast();
            fVar.f6699j = z10;
            fVar.k = z11;
        } catch (Throwable th2) {
            arrayDeque.removeLast();
            fVar.f6699j = z10;
            fVar.k = z11;
            throw th2;
        }
    }

    @Override // u3.m
    public final void b(f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        List<AbstractC2156a> listG = g();
        ArrayDeque arrayDeque = fVar.g;
        ArrayDeque arrayDeque2 = fVar.h;
        arrayDeque.addLast(this);
        boolean z11 = fVar.f6699j;
        boolean z12 = fVar.k;
        boolean z13 = this.c;
        if (z13) {
            fVar.f6699j = z13;
        }
        boolean z14 = this.d;
        if (z14) {
            fVar.k = z14;
        }
        try {
            int size = fVar.d.size();
            for (AbstractC2156a abstractC2156a : listG) {
                try {
                    fVar.f().getClass();
                    abstractC2156a.getClass();
                    fVar.c(abstractC2156a.e());
                    arrayDeque2.addLast(abstractC2156a.e());
                    try {
                        abstractC2156a.b(fVar, jsonNode, jsonNode2, aVar, z10);
                        fVar.d();
                        arrayDeque2.removeLast();
                        fVar.f().getClass();
                        List list = fVar.d;
                        list.subList(size, list.size());
                    } finally {
                    }
                } catch (Throwable th) {
                    fVar.f().getClass();
                    abstractC2156a.getClass();
                    List list2 = fVar.d;
                    list2.subList(size, list2.size());
                    throw th;
                }
            }
        } finally {
            arrayDeque.removeLast();
            fVar.f6699j = z11;
            fVar.k = z12;
        }
    }

    public final A3.a c() {
        k kVar = (k) this.f6703j.d;
        kVar.g.getClass();
        PathType pathType = PathType.JSON_POINTER;
        if (pathType.equals(pathType)) {
            return h.b;
        }
        kVar.g.getClass();
        if (pathType.equals(PathType.LEGACY)) {
            return h.c;
        }
        kVar.g.getClass();
        if (pathType.equals(PathType.JSON_PATH)) {
            return h.f6701a;
        }
        kVar.g.getClass();
        return new A3.a(pathType);
    }

    public final i d() {
        while (true) {
            String str = this.f6702a;
            i iVar = this.h;
            boolean zEquals = true;
            if (str == null && iVar != null) {
                zEquals = true ^ Objects.equals(this.i.f6704a, iVar.i.f6704a);
            }
            if (zEquals) {
                return this;
            }
            this = iVar;
        }
    }

    public final i e(A3.a aVar) {
        if (PathType.JSON_POINTER.equals(aVar.f92a)) {
            return f(aVar);
        }
        C2035a c2035a = this.i.f6704a;
        String str = (c2035a != null ? c2035a.f6694a : "") + "#" + aVar;
        G6.c cVar = this.f6703j;
        i iVar = (i) ((ConcurrentMap) cVar.f).get(str);
        if (iVar == null) {
            iVar = (i) ((ConcurrentMap) cVar.g).get(str);
        }
        if (iVar != null) {
            return iVar;
        }
        throw new SchemaException(B7.a.k("Unable to find anchor ", str));
    }

    public final i f(A3.a aVar) {
        i iVarF;
        JsonNode jsonNode;
        JsonNode jsonNode2;
        i iVarD = d();
        JsonNode jsonNode3 = iVarD.g;
        j jVar = iVarD.i;
        int nameCount = aVar.getNameCount();
        int i = 0;
        i iVar = iVarD;
        i iVarC = null;
        while (true) {
            G6.c cVar = iVar.f6703j;
            if (i >= nameCount) {
                return iVarC;
            }
            Object objB = aVar.b(i);
            boolean z10 = objB instanceof Number;
            JsonNode jsonNode4 = (z10 && jsonNode3.isArray()) ? jsonNode3.get(((Number) objB).intValue()) : jsonNode3.get(objB.toString());
            if (jsonNode4 == null) {
                i iVarD2 = iVarD.d();
                if (iVarD2.k || (jsonNode2 = (jsonNode = iVarD2.g).get("id")) == null || jsonNode2.equals(jsonNode.get("$schema")) || jsonNode2.textValue() == null) {
                    iVarF = null;
                } else {
                    j jVarC = j.c(jsonNode2.textValue());
                    k kVar = (k) this.f6703j.d;
                    i iVarE = kVar.e(jVarC);
                    kVar.g.getClass();
                    try {
                        iVarE.h();
                    } catch (Exception unused) {
                    }
                    iVarF = iVarE;
                }
                if (iVarF != null) {
                    iVarF = iVarF.f(aVar);
                }
                if (iVarF != null) {
                    return iVarF;
                }
                C2036b c2036b = new C2036b();
                c2036b.f6696a = KeywordType.f3036Y.f3054a;
                c2036b.i = "internal.unresolvedRef";
                c2036b.g = "Reference {0} cannot be resolved";
                c2036b.d = jVar.b;
                c2036b.c = jVar;
                c2036b.b = null;
                c2036b.e = new Object[]{aVar};
                throw new InvalidSchemaRefException(c2036b.a());
            }
            j jVarA = (z10 && jsonNode3.isArray()) ? jVar.a(((Number) objB).intValue()) : jVar.b(objB.toString());
            JsonNode jsonNode5 = jsonNode4.get(((C2097b) cVar.c).b);
            if ((jsonNode5 == null ? null : jsonNode5.textValue()) != null || i == nameCount - 1) {
                iVarC = cVar.c(jVarA, jsonNode4, iVar);
                jVarA = iVarC.i;
                iVar = iVarC;
            }
            jVar = jVarA;
            i++;
            jsonNode3 = jsonNode4;
        }
    }

    public final List g() {
        ArrayList arrayList;
        if (this.b == null) {
            JsonNode jsonNode = this.g;
            boolean zIsBoolean = jsonNode.isBoolean();
            j jVar = this.i;
            G6.c cVar = this.f6703j;
            if (zIsBoolean) {
                arrayList = new ArrayList(1);
                if (jsonNode.booleanValue()) {
                    arrayList.add(cVar.d(jVar.b("true"), "true", jsonNode, this));
                } else {
                    arrayList.add(cVar.d(jVar.b("false"), "false", jsonNode, this));
                }
            } else {
                Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                ArrayList arrayList2 = new ArrayList(jsonNode.size());
                AbstractC2156a abstractC2156a = null;
                while (itFields.hasNext()) {
                    Map.Entry<String, JsonNode> next = itFields.next();
                    String key = next.getKey();
                    JsonNode value = next.getValue();
                    j jVarB = jVar.b(key);
                    if ("$recursiveAnchor".equals(key)) {
                        if (!value.isBoolean()) {
                            C2036b c2036b = new C2036b();
                            c2036b.f6696a = "$recursiveAnchor";
                            c2036b.i = "internal.invalidRecursiveAnchor";
                            c2036b.g = "The value of a $recursiveAnchor must be a Boolean literal but is {0}";
                            c2036b.d = null;
                            c2036b.b = null;
                            c2036b.c = jVarB;
                            c2036b.e = new Object[]{value.getNodeType().toString()};
                            throw new SchemaException(c2036b.a());
                        }
                        this.f = value.booleanValue();
                    }
                    AbstractC2156a abstractC2156aD = cVar.d(jVarB, key, value, this);
                    if (abstractC2156aD != null) {
                        arrayList2.add(abstractC2156aD);
                        if ("unevaluatedProperties".equals(key)) {
                            this.c = true;
                        } else if ("unevaluatedItems".equals(key)) {
                            this.d = true;
                        }
                        if ("$ref".equals(key)) {
                            abstractC2156a = abstractC2156aD;
                        }
                    }
                }
                if (abstractC2156a != null && ((C2097b) cVar.c).e.f3013a < l) {
                    arrayList2.clear();
                    arrayList2.add(abstractC2156a);
                }
                arrayList = arrayList2;
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, m);
            }
            this.b = Collections.unmodifiableList(arrayList);
        }
        return this.b;
    }

    public final void h() {
        if (this.e) {
            return;
        }
        this.e = true;
        try {
            Iterator it = g().iterator();
            while (it.hasNext()) {
                ((AbstractC2156a) it.next()).i();
            }
        } catch (RuntimeException e) {
            this.e = false;
            throw e;
        }
    }

    public final List i(JsonNode jsonNode) {
        T6.a aVar = ((k) this.f6703j.d).g;
        Locale locale = Locale.ROOT;
        S6.c cVar = new S6.c(12);
        aVar.getClass();
        Locale locale2 = Locale.getDefault();
        if (locale2 == null) {
            locale2 = Locale.getDefault();
        }
        f fVar = new f(new B0.f(locale2, cVar, false));
        B0.f fVar2 = fVar.f6698a;
        Locale locale3 = (Locale) fVar2.f177a;
        Predicate predicate = (Predicate) fVar2.c;
        boolean z10 = fVar2.b;
        if (locale3 == null) {
            locale3 = Locale.getDefault();
        }
        Objects.requireNonNull(predicate, "annotationCollectionFilter must not be null");
        fVar.f6698a = new B0.f(locale3, predicate, z10);
        try {
            fVar.f = c();
            a(fVar, jsonNode, jsonNode, c());
        } catch (FailFastAssertionException e) {
            fVar.d = Collections.singletonList(e.f3010a);
        }
        return fVar.d;
    }

    public final String toString() {
        return this.g.toString();
    }
}
