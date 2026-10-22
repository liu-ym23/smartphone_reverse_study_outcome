package hd;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final b[] f5491a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f5492b;

    static {
        b bVar = new b(b.i, "");
        od.l lVar = b.f5470f;
        b bVar2 = new b(lVar, "GET");
        b bVar3 = new b(lVar, "POST");
        od.l lVar2 = b.f5471g;
        b bVar4 = new b(lVar2, "/");
        b bVar5 = new b(lVar2, "/index.html");
        od.l lVar3 = b.f5472h;
        b bVar6 = new b(lVar3, "http");
        b bVar7 = new b(lVar3, "https");
        od.l lVar4 = b.f5469e;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new b(lVar4, "200"), new b(lVar4, "204"), new b(lVar4, "206"), new b(lVar4, "304"), new b(lVar4, "400"), new b(lVar4, "404"), new b(lVar4, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b("age", ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b("from", ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b("refresh", ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
        f5491a = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i = 0; i < 61; i++) {
            if (!linkedHashMap.containsKey(bVarArr[i].f5473a)) {
                linkedHashMap.put(bVarArr[i].f5473a, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        f5492b = mapUnmodifiableMap;
    }

    public static void a(od.l lVar) throws IOException {
        lVar.getClass();
        int iC = lVar.c();
        for (int i = 0; i < iC; i++) {
            byte bH = lVar.h(i);
            if (65 <= bH && bH < 91) {
                od.f.l("PROTOCOL_ERROR response malformed: mixed case name: ".concat(lVar.p()));
                return;
            }
        }
    }
}
