package M9;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okio.ByteString;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0247a[] f979a;
    public static final Map b;

    static {
        C0247a c0247a = new C0247a(C0247a.i, "");
        ByteString byteString = C0247a.f;
        C0247a c0247a2 = new C0247a(byteString, "GET");
        C0247a c0247a3 = new C0247a(byteString, "POST");
        ByteString byteString2 = C0247a.g;
        C0247a c0247a4 = new C0247a(byteString2, "/");
        C0247a c0247a5 = new C0247a(byteString2, "/index.html");
        ByteString byteString3 = C0247a.h;
        C0247a c0247a6 = new C0247a(byteString3, "http");
        C0247a c0247a7 = new C0247a(byteString3, "https");
        ByteString byteString4 = C0247a.e;
        C0247a[] c0247aArr = {c0247a, c0247a2, c0247a3, c0247a4, c0247a5, c0247a6, c0247a7, new C0247a(byteString4, "200"), new C0247a(byteString4, "204"), new C0247a(byteString4, "206"), new C0247a(byteString4, "304"), new C0247a(byteString4, "400"), new C0247a(byteString4, "404"), new C0247a(byteString4, "500"), new C0247a("accept-charset", ""), new C0247a("accept-encoding", "gzip, deflate"), new C0247a("accept-language", ""), new C0247a("accept-ranges", ""), new C0247a("accept", ""), new C0247a("access-control-allow-origin", ""), new C0247a("age", ""), new C0247a("allow", ""), new C0247a("authorization", ""), new C0247a("cache-control", ""), new C0247a("content-disposition", ""), new C0247a("content-encoding", ""), new C0247a("content-language", ""), new C0247a("content-length", ""), new C0247a("content-location", ""), new C0247a("content-range", ""), new C0247a("content-type", ""), new C0247a("cookie", ""), new C0247a("date", ""), new C0247a("etag", ""), new C0247a("expect", ""), new C0247a("expires", ""), new C0247a(TypedValues.TransitionType.S_FROM, ""), new C0247a("host", ""), new C0247a("if-match", ""), new C0247a("if-modified-since", ""), new C0247a("if-none-match", ""), new C0247a("if-range", ""), new C0247a("if-unmodified-since", ""), new C0247a("last-modified", ""), new C0247a("link", ""), new C0247a("location", ""), new C0247a("max-forwards", ""), new C0247a("proxy-authenticate", ""), new C0247a("proxy-authorization", ""), new C0247a("range", ""), new C0247a("referer", ""), new C0247a("refresh", ""), new C0247a("retry-after", ""), new C0247a("server", ""), new C0247a("set-cookie", ""), new C0247a("strict-transport-security", ""), new C0247a("transfer-encoding", ""), new C0247a("user-agent", ""), new C0247a("vary", ""), new C0247a("via", ""), new C0247a("www-authenticate", "")};
        f979a = c0247aArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i = 0; i < 61; i++) {
            if (!linkedHashMap.containsKey(c0247aArr[i].f976a)) {
                linkedHashMap.put(c0247aArr[i].f976a, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.k.e(mapUnmodifiableMap, "unmodifiableMap(result)");
        b = mapUnmodifiableMap;
    }

    public static void a(ByteString name) throws IOException {
        kotlin.jvm.internal.k.f(name, "name");
        int iC = name.c();
        for (int i = 0; i < iC; i++) {
            byte bF = name.f(i);
            if (65 <= bF && bF < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(name.j()));
            }
        }
    }
}
