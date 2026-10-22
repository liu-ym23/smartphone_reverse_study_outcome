package F9;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* loaded from: classes4.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public final y f626a;
    public final String b;
    public final w c;
    public final K d;
    public final Map e;
    public C0227e f;

    public G(y url, String method, w wVar, K k, Map map) {
        kotlin.jvm.internal.k.f(url, "url");
        kotlin.jvm.internal.k.f(method, "method");
        this.f626a = url;
        this.b = method;
        this.c = wVar;
        this.d = k;
        this.e = map;
    }

    public final String a(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        return this.c.b(name);
    }

    public final K1.a b() {
        K1.a aVar = new K1.a();
        aVar.e = new LinkedHashMap();
        aVar.f903a = this.f626a;
        aVar.b = this.b;
        aVar.d = this.d;
        Map map = this.e;
        aVar.e = map.isEmpty() ? new LinkedHashMap() : kotlin.collections.a.a0(map);
        aVar.c = this.c.g();
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.f626a);
        w wVar = this.c;
        if (wVar.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Object obj : wVar) {
                int i6 = i + 1;
                if (i < 0) {
                    H4.o.X();
                    throw null;
                }
                Pair pair = (Pair) obj;
                String str = (String) pair.f4886a;
                String str2 = (String) pair.b;
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i = i6;
            }
            sb.append(']');
        }
        Map map = this.e;
        if (!map.isEmpty()) {
            sb.append(", tags=");
            sb.append(map);
        }
        return androidx.appfunctions.metadata.a.h('}', "StringBuilder().apply(builderAction).toString()", sb);
    }
}
