package ak5;

import com.bytedance.ee.bear.net.RawServerResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements Function<p, RawServerResult> {
    public q() {
    }

    @Override // io.reactivex.functions.Function
    public final RawServerResult apply(p r110) throws Exception {
        p r111 = r110;
        String r100 = "";
        Object[] r101 = {0, "", ""};
        JSONObject r102 = new JSONObject(r111.f4047b);     // Catch: Exception -> L7 JSONException -> L9
        int r103 = r102.optInt("code");     // Catch: Exception -> L7 JSONException -> L9
        String r104 = r102.optString("msg");     // Catch: Exception -> L7 JSONException -> L9
        r101[0] = Integer.valueOf(r103);     // Catch: Exception -> L7 JSONException -> L9
        r101[1] = r104;     // Catch: Exception -> L7 JSONException -> L9
        JSONObject r105 = r102.optJSONObject("data");     // Catch: Exception -> L7 JSONException -> L9
        if (r105 == null) goto L11;
        r101[2] = r105.toString();     // Catch: Exception -> L7 JSONException -> L9
    L11:
        RawServerResult r106 = new RawServerResult();
        r106.setCode(((Integer) r101[0]).intValue());
        r106.setMsg((String) r101[1]);
        r106.setData((String) r101[2]);
        r106.setJson(r111.f4047b);
        Map<String, List<String>> r107 = r111.f4048c;
        if (r107 == null) goto L19;
        List<String> r108 = r107.get(NetResponse.HEADER_KEY_LOG_ID);
        if (r108 == null) goto L19;
        if (r108.size() <= 0) goto L19;
        r100 = (String) ListProtector.get(r108, 0);
    L19:
        r106.setLogId(r100);
        if (r106.getCode() == 0) goto L22;
        tt5.a.d("ParseCodeFun", "request error! url = " + r111.f4046a + ", code = " + r106.getCode() + ", message = " + r106.getMsg() + ", logId = " + r106.getLogId());
    L22:
        return r106;
    L9:
        e = move-exception;
        tt5.a.e("ParseCodeFun", "parseBody JSONException", e, false);
    L7:
        e = move-exception;
        tt5.a.e("ParseCodeFun", "parseBody Exception", e, false);
        goto L11
    }
}
