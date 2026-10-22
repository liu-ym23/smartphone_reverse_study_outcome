package q5;

import com.stepos.account.oauth.OAuthConstants;
import d7.e0;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class r {
    public static c5.b a(String str, String str2, String str3, Map map, Long l6, int i2) {
        if ((i2 & 64) != 0) {
            l6 = null;
        }
        q7.k.e(str, "invocationId");
        q7.k.e(str2, "nodeId");
        q7.k.e(map, "params");
        LinkedHashMap linkedHashMapV = e0.V(new c7.j("id", str), new c7.j("nodeId", str2), new c7.j("command", str3), new c7.j("params", map));
        if (l6 != null) {
            linkedHashMapV.put("timeoutMs", l6);
        }
        return new c5.b("event", e0.U(new c7.j("type", "event"), new c7.j("event", "node.invoke.request"), new c7.j("payload", linkedHashMapV)));
    }

    public static c5.b b(String str, String str2, String str3, String str4, boolean z4) {
        q7.k.e(str, "invocationId");
        q7.k.e(str2, "nodeId");
        q7.k.e(str3, "code");
        q7.k.e(str4, OAuthConstants.FACTOR_RESULT_MESSAGE);
        LinkedHashMap linkedHashMapV = e0.V(new c7.j("code", str3), new c7.j(OAuthConstants.FACTOR_RESULT_MESSAGE, str4), new c7.j("retryable", Boolean.valueOf(z4)));
        String strH = a1.a.h("iv-res-", System.nanoTime());
        Map mapU = e0.U(new c7.j("id", str), new c7.j("nodeId", str2), new c7.j("ok", Boolean.FALSE), new c7.j("error", linkedHashMapV));
        q7.k.e(strH, "id");
        return new c5.b("req", e0.U(new c7.j("type", "req"), new c7.j("id", strH), new c7.j("method", "node.invoke.result"), new c7.j("params", mapU)));
    }
}
