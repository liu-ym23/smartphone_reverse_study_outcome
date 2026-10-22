package y7;

import ad.z;
import b8.a0;
import b8.b0;
import b8.s;
import b8.x;
import g5.f;
import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w7.h;
import w7.q;
import z7.d;
import z7.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15935a;

    static {
        a aVar;
        z zVarA = a.a("https://json-schema.org/draft/2020-12/schema");
        q qVar = q.DRAFT_2020_12;
        zVarA.f639d = qVar;
        zVarA.f637b = "$id";
        List<d> list = e.f16474a;
        zVarA.getClass();
        for (d dVar : list) {
            ((HashMap) zVarA.f641f).put(dVar.getName(), dVar);
        }
        zVarA.o(b0.b(qVar));
        zVarA.o(Collections.singletonList(new b8.e("definitions", 1)));
        ((HashMap) zVarA.f642g).putAll(c.f15936a);
        HashMap map = (HashMap) zVarA.f642g;
        HashMap map2 = (HashMap) zVarA.f640e;
        q qVar2 = (q) zVarA.f639d;
        if (qVar2 != null && qVar2.f15356c >= 8) {
            HashMap map3 = new HashMap(map2);
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                h8.b bVar = (h8.b) h8.a.f5400a.get(str);
                if (bVar != null) {
                    for (x xVar : bVar.f5416b) {
                        map3.putIfAbsent(xVar.getValue(), xVar);
                    }
                } else if (Boolean.TRUE.equals(entry.getValue())) {
                    w7.b bVar2 = new w7.b();
                    bVar2.f15296g = "Meta-schema ''{0}'' has unknown required vocabulary ''{1}''";
                    bVar2.f15294e = new Object[]{(String) zVarA.f638c, str};
                    throw new h(bVar2.a());
                }
            }
            map2 = map3;
        }
        HashMap map4 = (HashMap) zVarA.f641f;
        HashMap map5 = new HashMap();
        Iterator it = map2.entrySet().iterator();
        boolean z10 = false;
        while (true) {
            aVar = null;
            if (it.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it.next();
                String str2 = (String) entry2.getKey();
                x xVar2 = (x) entry2.getValue();
                a0 a0Var = b0.f1935x;
                if (!a0Var.f1938c.equals(str2)) {
                    map5.put(xVar2.getValue(), xVar2);
                } else {
                    if (!(xVar2 instanceof s) && !a0Var.equals(xVar2)) {
                        f.s("Overriding the keyword 'format' is not supported. Use the formatKeywordFactory and extend the FormatKeyword.");
                        break;
                    }
                    z10 = true;
                }
            } else {
                if (z10) {
                    String str3 = b0.f1935x.f1938c;
                    s sVar = new s();
                    sVar.f2016c = str3;
                    sVar.f2017f = map4;
                    VarHandle.storeStoreFence();
                    map5.put(str3, sVar);
                }
                String str4 = (String) zVarA.f638c;
                String str5 = (String) zVarA.f637b;
                q qVar3 = (q) zVarA.f639d;
                a aVar2 = new a();
                if (str4 == null || str4.trim().isEmpty()) {
                    f.s("dialect id must not be null or blank");
                } else if (str5 == null || str5.trim().isEmpty()) {
                    f.s("idKeyword must not be null or blank");
                } else {
                    aVar2.f15929a = str4;
                    aVar2.f15930b = str5;
                    aVar2.f15931c = map5;
                    aVar2.f15933e = qVar3;
                    aVar2.f15932d = map;
                    aVar2.f15934f = zVarA;
                    VarHandle.storeStoreFence();
                    aVar = aVar2;
                }
            }
        }
        f15935a = aVar;
    }
}
