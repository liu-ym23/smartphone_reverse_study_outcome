package com.stepos.net.cache;

import F9.A;
import F9.G;
import F9.M;
import F9.v;
import F9.z;
import K9.g;
import i9.C1570e;
import j9.m;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import v0.C2054a;

/* loaded from: classes3.dex */
public final class a implements A {

    /* renamed from: a, reason: collision with root package name */
    public final C2054a f3882a;

    public a(C2054a store) {
        k.f(store, "store");
        this.f3882a = store;
    }

    @Override // F9.A
    public final M intercept(z zVar) {
        g gVar = (g) zVar;
        G g = gVar.e;
        String strA = g.a("Stepos-Cache-Tags");
        if (strA == null) {
            return gVar.b(g);
        }
        K1.a aVarB = g.b();
        ((v) aVarB.c).h("Stepos-Cache-Tags");
        G gD = aVarB.d();
        M mB = gVar.b(gD);
        String str = gD.f626a.i;
        List listE0 = m.E0(strA, new char[]{','});
        C2054a c2054a = this.f3882a;
        c2054a.getClass();
        C1570e c1570e = new C1570e(kotlin.sequences.a.f0(kotlin.sequences.a.m0(D7.v.s0(listE0), CacheTagStore$bind$1.f3880a), CacheTagStore$bind$2.f3881a));
        while (c1570e.hasNext()) {
            String str2 = (String) c1570e.next();
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) c2054a.f6763a;
            Object objNewSetFromMap = concurrentHashMap.get(str2);
            if (objNewSetFromMap == null) {
                objNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
                k.e(objNewSetFromMap, "newSetFromMap(...)");
                Object objPutIfAbsent = concurrentHashMap.putIfAbsent(str2, objNewSetFromMap);
                if (objPutIfAbsent != null) {
                    objNewSetFromMap = objPutIfAbsent;
                }
            }
            ((Set) objNewSetFromMap).add(str);
        }
        return mB;
    }
}
