package bi5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements NetService.c<RetentionSettingVisible> {
    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        RetentionSettingVisible r101 = new RetentionSettingVisible();
        JSONObject r102 = new JSONObject(r100).optJSONObject("data").optJSONObject("data");     // Catch: JSONException -> L5
        r101.setToken(r102.optString("token"));     // Catch: JSONException -> L5
        r101.setEntityType(r102.optString("entityType"));     // Catch: JSONException -> L5
        r101.setCanSetRetentionLabel(r102.optBoolean("canSetRetentionLabel"));     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        tt5.a.d("RetentionSettingVisibleParser", "parse()...error = " + e);
        goto L7
    }
}
