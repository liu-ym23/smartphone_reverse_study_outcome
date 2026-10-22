package hb;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final b[] f4283a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f4284b;

    static {
        b bVar = new b(b.f4261i, "");
        ob.k kVar = b.f4258f;
        b bVar2 = new b(kVar, "GET");
        b bVar3 = new b(kVar, "POST");
        ob.k kVar2 = b.f4259g;
        b bVar4 = new b(kVar2, "/");
        b bVar5 = new b(kVar2, "/index.html");
        ob.k kVar3 = b.f4260h;
        b bVar6 = new b(kVar3, "http");
        b bVar7 = new b(kVar3, "https");
        ob.k kVar4 = b.f4257e;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new b(kVar4, "200"), new b(kVar4, "204"), new b(kVar4, "206"), new b(kVar4, "304"), new b(kVar4, "400"), new b(kVar4, "404"), new b(kVar4, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b("age", ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b("from", ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b("refresh", ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
        f4283a = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i2 = 0; i2 < 61; i2++) {
            if (!linkedHashMap.containsKey(bVarArr[i2].f4262a)) {
                linkedHashMap.put(bVarArr[i2].f4262a, Integer.valueOf(i2));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        q7.k.d(mapUnmodifiableMap, "unmodifiableMap(result)");
        f4284b = mapUnmodifiableMap;
    }

    public static void a(ob.k kVar) throws IOException {
        q7.k.e(kVar, "name");
        int iD = kVar.d();
        for (int i2 = 0; i2 < iD; i2++) {
            byte bI = kVar.i(i2);
            if (65 <= bI && bI < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(kVar.r()));
            }
        }
    }
}
