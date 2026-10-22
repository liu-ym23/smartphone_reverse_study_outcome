package r4;

import com.stepos.agentcache.core.ServiceContract;
import d7.n;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f8981a = n.x0(new String[]{"_stepclaw_", ServiceContract.RequiredKeys.TRACE_ID, "sessionId", "sessionKey", "toolCallId", "toolId", "_meta", "metadata", "stepclaw"});

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[PHI: r0
      0x0044: PHI (r0v6 java.lang.String) = (r0v5 java.lang.String), (r0v33 java.lang.String) binds: [B:22:0x0035, B:24:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map a(java.lang.String r19, java.lang.Long r20) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.a.a(java.lang.String, java.lang.Long):java.util.Map");
    }

    public static JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        k.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!f8981a.contains(next)) {
                jSONObject2.put(next, jSONObject.opt(next));
            }
        }
        return jSONObject2;
    }
}
