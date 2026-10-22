package h3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* loaded from: classes2.dex */
public final class U {

    /* renamed from: a, reason: collision with root package name */
    public J f12821a;

    /* renamed from: d, reason: collision with root package name */
    public Z f12824d;

    /* renamed from: e, reason: collision with root package name */
    public Map f12825e = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public String f12822b = "GET";

    /* renamed from: c, reason: collision with root package name */
    public G f12823c = new G();

    public final void a(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f12823c.a(name, value);
    }

    public final V b() {
        J j4 = this.f12821a;
        if (j4 != null) {
            return new V(j4, this.f12822b, this.f12823c.d(), this.f12824d, Util.toImmutableMap(this.f12825e));
        }
        throw new IllegalStateException("url == null".toString());
    }

    public final void c(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        G g4 = this.f12823c;
        g4.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        C0611u.e(name);
        C0611u.f(value, name);
        g4.f(name);
        g4.c(name, value);
    }

    public final void d(String method, Z z4) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }
        if (z4 == null) {
            if (!(!HttpMethod.requiresRequestBody(method))) {
                throw new IllegalArgumentException(B0.g.n("method ", method, " must have a request body.").toString());
            }
        } else if (!HttpMethod.permitsRequestBody(method)) {
            throw new IllegalArgumentException(B0.g.n("method ", method, " must not have a request body.").toString());
        }
        Intrinsics.checkNotNullParameter(method, "<set-?>");
        this.f12822b = method;
        this.f12824d = z4;
    }

    public final void e(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f12823c.f(name);
    }

    public final void f(Class type, Object obj) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (obj == null) {
            this.f12825e.remove(type);
            return;
        }
        if (this.f12825e.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Intrinsics.checkNotNullParameter(linkedHashMap, "<set-?>");
            this.f12825e = linkedHashMap;
        }
        Map map = this.f12825e;
        Object objCast = type.cast(obj);
        Intrinsics.checkNotNull(objCast);
        map.put(type, objCast);
    }

    public final void g(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt__StringsJVMKt.startsWith(url, "ws:", true)) {
            String strSubstring = url.substring(3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            url = Intrinsics.stringPlus("http:", strSubstring);
        } else if (StringsKt__StringsJVMKt.startsWith(url, "wss:", true)) {
            String strSubstring2 = url.substring(4);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            url = Intrinsics.stringPlus("https:", strSubstring2);
        }
        char[] cArr = J.f12721k;
        J url2 = C0611u.n(url);
        Intrinsics.checkNotNullParameter(url2, "url");
        this.f12821a = url2;
    }
}
