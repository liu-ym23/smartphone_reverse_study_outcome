package c8;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import v9.z;

/* loaded from: classes.dex */
public final class f implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1995f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f1996g;

    public /* synthetic */ f(h hVar, int i2) {
        this.f1995f = i2;
        this.f1996g = hVar;
    }

    @Override // p7.a
    public final Object c() {
        int i2 = this.f1995f;
        h hVar = this.f1996g;
        switch (i2) {
            case 0:
                return Arrays.asList(hVar.k().z(n.f2066k), hVar.k().z(n.f2068m), hVar.k().z(n.f2069n), hVar.k().z(n.f2067l));
            default:
                EnumMap enumMap = new EnumMap(j.class);
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                for (j jVar : j.values()) {
                    String strB = jVar.f2016f.b();
                    if (strB == null) {
                        h.a(46);
                        throw null;
                    }
                    z zVarK = hVar.j(strB).k();
                    if (zVarK == null) {
                        h.a(47);
                        throw null;
                    }
                    String strB2 = jVar.f2017g.b();
                    if (strB2 == null) {
                        h.a(46);
                        throw null;
                    }
                    z zVarK2 = hVar.j(strB2).k();
                    if (zVarK2 == null) {
                        h.a(47);
                        throw null;
                    }
                    enumMap.put((EnumMap) jVar, (j) zVarK2);
                    map.put(zVarK, zVarK2);
                    map2.put(zVarK2, zVarK);
                }
                return new g(enumMap, map, map2);
        }
    }
}
