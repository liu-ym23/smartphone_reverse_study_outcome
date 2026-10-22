package ab;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final p f661a;

    /* renamed from: b, reason: collision with root package name */
    public final String f662b;

    /* renamed from: c, reason: collision with root package name */
    public final n f663c;

    /* renamed from: d, reason: collision with root package name */
    public final x f664d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f665e;

    /* renamed from: f, reason: collision with root package name */
    public c f666f;

    public w(p pVar, String str, n nVar, x xVar, Map map) {
        q7.k.e(pVar, "url");
        q7.k.e(str, "method");
        this.f661a = pVar;
        this.f662b = str;
        this.f663c = nVar;
        this.f664d = xVar;
        this.f665e = map;
    }

    public final v a() {
        v vVar = new v();
        vVar.f660e = new LinkedHashMap();
        vVar.f656a = this.f661a;
        vVar.f657b = this.f662b;
        vVar.f659d = this.f664d;
        Map map = this.f665e;
        vVar.f660e = map.isEmpty() ? new LinkedHashMap() : d7.e0.b0(map);
        vVar.f658c = this.f663c.h();
        return vVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Request{method=");
        sb2.append(this.f662b);
        sb2.append(", url=");
        sb2.append(this.f661a);
        n nVar = this.f663c;
        if (nVar.size() != 0) {
            sb2.append(", headers=[");
            int i2 = 0;
            for (Object obj : nVar) {
                int i10 = i2 + 1;
                if (i2 < 0) {
                    d7.s.z0();
                    throw null;
                }
                c7.j jVar = (c7.j) obj;
                String str = (String) jVar.f1973f;
                String str2 = (String) jVar.f1974g;
                if (i2 > 0) {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append(':');
                sb2.append(str2);
                i2 = i10;
            }
            sb2.append(']');
        }
        Map map = this.f665e;
        if (!map.isEmpty()) {
            sb2.append(", tags=");
            sb2.append(map);
        }
        sb2.append('}');
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
