package u6;

import com.stepos.stepclaw.SecurePrefs;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final d[] f5700a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f5701b;

    static {
        d dVar = new d(d.f5683i, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        c7.i iVar = d.f5680f;
        d dVar2 = new d(iVar, "GET");
        d dVar3 = new d(iVar, "POST");
        c7.i iVar2 = d.f5681g;
        d dVar4 = new d(iVar2, "/");
        d dVar5 = new d(iVar2, "/index.html");
        c7.i iVar3 = d.f5682h;
        d dVar6 = new d(iVar3, "http");
        d dVar7 = new d(iVar3, "https");
        c7.i iVar4 = d.f5679e;
        d[] dVarArr = {dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, new d(iVar4, "200"), new d(iVar4, "204"), new d(iVar4, "206"), new d(iVar4, "304"), new d(iVar4, "400"), new d(iVar4, "404"), new d(iVar4, "500"), new d("accept-charset", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("accept-encoding", "gzip, deflate"), new d("accept-language", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("accept-ranges", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("accept", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("access-control-allow-origin", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("age", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("allow", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("authorization", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("cache-control", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("content-disposition", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("content-encoding", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("content-language", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("content-length", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("content-location", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("content-range", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("content-type", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("cookie", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("date", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("etag", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("expect", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("expires", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("from", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("host", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("if-match", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("if-modified-since", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("if-none-match", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("if-range", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("if-unmodified-since", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("last-modified", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("link", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("location", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("max-forwards", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("proxy-authenticate", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("proxy-authorization", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("range", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("referer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("refresh", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("retry-after", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("server", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("set-cookie", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("strict-transport-security", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("transfer-encoding", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("user-agent", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("vary", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("via", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new d("www-authenticate", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)};
        f5700a = dVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61, 1.0f);
        for (int i8 = 0; i8 < 61; i8++) {
            if (!linkedHashMap.containsKey(dVarArr[i8].f5684a)) {
                linkedHashMap.put(dVarArr[i8].f5684a, Integer.valueOf(i8));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.p.d(mapUnmodifiableMap, "unmodifiableMap(...)");
        f5701b = mapUnmodifiableMap;
    }

    public static void a(c7.i name) throws IOException {
        kotlin.jvm.internal.p.e(name, "name");
        int iC = name.c();
        for (int i8 = 0; i8 < iC; i8++) {
            byte bF = name.f(i8);
            if (65 <= bF && bF < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(name.l()));
            }
        }
    }
}
