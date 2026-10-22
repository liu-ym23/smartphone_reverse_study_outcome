package ab;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public p f656a;

    /* renamed from: d, reason: collision with root package name */
    public x f659d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedHashMap f660e = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public String f657b = "GET";

    /* renamed from: c, reason: collision with root package name */
    public m f658c = new m();

    public final w a() {
        Map mapUnmodifiableMap;
        p pVar = this.f656a;
        if (pVar == null) {
            throw new IllegalStateException("url == null");
        }
        String str = this.f657b;
        n nVarD = this.f658c.d();
        x xVar = this.f659d;
        LinkedHashMap linkedHashMap = this.f660e;
        byte[] bArr = bb.b.f1659a;
        q7.k.e(linkedHashMap, "<this>");
        if (linkedHashMap.isEmpty()) {
            mapUnmodifiableMap = d7.a0.f2944f;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
            q7.k.d(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        }
        return new w(pVar, str, nVarD, xVar, mapUnmodifiableMap);
    }

    public final void b(String str, String str2) {
        q7.k.e(str2, "value");
        m mVar = this.f658c;
        mVar.getClass();
        s7.a.g(str);
        s7.a.i(str2, str);
        mVar.e(str);
        mVar.b(str, str2);
    }

    public final void c(String str, x xVar) {
        q7.k.e(str, "method");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true");
        }
        if (xVar == null) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
                throw new IllegalArgumentException(a1.a.j("method ", str, " must have a request body.").toString());
            }
        } else if (!w7.e0.I(str)) {
            throw new IllegalArgumentException(a1.a.j("method ", str, " must not have a request body.").toString());
        }
        this.f657b = str;
        this.f659d = xVar;
    }

    public final void d(String str) {
        q7.k.e(str, "url");
        if (ga.r.g0(str, "ws:", true)) {
            String strSubstring = str.substring(3);
            q7.k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            str = "http:".concat(strSubstring);
        } else if (ga.r.g0(str, "wss:", true)) {
            String strSubstring2 = str.substring(4);
            q7.k.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
            str = "https:".concat(strSubstring2);
        }
        q7.k.e(str, "<this>");
        o oVar = new o();
        oVar.c(null, str);
        this.f656a = oVar.a();
    }
}
