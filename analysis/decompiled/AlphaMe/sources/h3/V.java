package h3;

import ch.qos.logback.core.CoreConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public final J f12826a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12827b;

    /* renamed from: c, reason: collision with root package name */
    public final H f12828c;

    /* renamed from: d, reason: collision with root package name */
    public final Z f12829d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f12830e;

    /* renamed from: f, reason: collision with root package name */
    public C0600i f12831f;

    public V(J url, String method, H headers, Z z4, Map tags) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f12826a = url;
        this.f12827b = method;
        this.f12828c = headers;
        this.f12829d = z4;
        this.f12830e = tags;
    }

    public final C0600i a() {
        C0600i c0600i = this.f12831f;
        if (c0600i != null) {
            return c0600i;
        }
        int i4 = C0600i.f12920n;
        C0600i c0600iD = y0.e.d(this.f12828c);
        this.f12831f = c0600iD;
        return c0600iD;
    }

    public final String b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f12828c.a(name);
    }

    public final U c() {
        Intrinsics.checkNotNullParameter(this, "request");
        U u4 = new U();
        u4.f12825e = new LinkedHashMap();
        u4.f12821a = this.f12826a;
        u4.f12822b = this.f12827b;
        u4.f12824d = this.f12829d;
        Map map = this.f12830e;
        u4.f12825e = map.isEmpty() ? new LinkedHashMap() : MapsKt.toMutableMap(map);
        u4.f12823c = this.f12828c.d();
        return u4;
    }

    public final Object d(Class type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type.cast(this.f12830e.get(type));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.f12827b);
        sb.append(", url=");
        sb.append(this.f12826a);
        H h4 = this.f12828c;
        if (h4.size() != 0) {
            sb.append(", headers=[");
            int i4 = 0;
            for (Object obj : h4) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj;
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (i4 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(CoreConstants.COLON_CHAR);
                sb.append(str2);
                i4 = i5;
            }
            sb.append(']');
        }
        Map map = this.f12830e;
        if (!map.isEmpty()) {
            sb.append(", tags=");
            sb.append(map);
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
