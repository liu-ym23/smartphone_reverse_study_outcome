package m1;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.data.ITypeData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements ITypeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f22026h;

    public a(String r10, long r11, long r12, String r13, String r14, String r15, int r16, JSONObject r17) {
        this.f22019a = r10;
        this.f22020b = r11;
        this.f22021c = r12;
        this.f22022d = r13;
        this.f22023e = r14;
        this.f22024f = r15;
        this.f22025g = r16;
        if (r17 != null) goto L5;
        this.f22026h = new JSONObject();
        return;
    L5:
        this.f22026h = r17;
    }

    public void a(String r10) {
        if (this.f22026h.isNull(TrafficConsts.KEY_NET_CONSUME_TYPE) == false) goto L6;
        this.f22026h.put(TrafficConsts.KEY_NET_CONSUME_TYPE, r10);
        return;
    }

    public void b(boolean r10) {
        if (this.f22026h.isNull(CommonKey.KEY_FRONT) == false) goto L6;
        this.f22026h.put(CommonKey.KEY_FRONT, r10 ? 1 : 0);
        return;
    }

    public void c() {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
        r10.put(TraceStatsConsts.STATS_KEY_TRACE_BASE, w0.c.f());     // Catch: JSONException -> L4
        this.f22026h.put("relate_start_trace", r10);     // Catch: JSONException -> L4
        return;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r10) {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        if (TextUtils.isEmpty(this.f22019a) == false) goto L18;
        return null;
    L18:
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L17
        r10.put("log_type", this.f22019a);     // Catch: Exception -> L17
        r10.put("duration", this.f22020b);     // Catch: Exception -> L17
        r10.put("uri", Uri.parse(this.f22022d));     // Catch: Exception -> L17
        long r11 = this.f22021c;     // Catch: Exception -> L17
        if (r11 <= 0) goto L8;
        r10.put("timestamp", r11);     // Catch: Exception -> L17
    L8:
        r10.put("status", this.f22025g);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(this.f22023e) == true) goto L13;
        r10.put("ip", this.f22023e);     // Catch: Exception -> L17
    L13:
        if (TextUtils.isEmpty(this.f22024f) == true) goto L15;
        r10.put("trace_code", this.f22024f);     // Catch: Exception -> L17
    L16:
        return r10;
    L15:
        r10.put("trace_code", "");     // Catch: Exception -> L17
    L17:
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }
}
