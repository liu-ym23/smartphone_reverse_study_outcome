package a35;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class c0 {
    public static void a(com.bytedance.ee.bear.contract.d r100, OfflineDoc r101, int r102, int r103) {
        if (r101 != null) goto L9;
        return;
    L9:
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L6
        r104.put("file_id", du5.b.g(r101.getObj_token()));     // Catch: JSONException -> L6
        r104.put("file_type", r101.getType());     // Catch: JSONException -> L6
        r104.put("status", r103);     // Catch: JSONException -> L6
        r104.put("retry_times", r102);     // Catch: JSONException -> L6
        r100.a("dev_performance_sync_status", r104);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        tt5.a.f("SyncReport", e, false);
    }
}
