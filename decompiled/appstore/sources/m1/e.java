package m1;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.util.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements ITypeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f22045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f22046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f22047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f22048h;

    public e() {
    }

    public e a(JSONObject r10) {
        this.f22047g = r10;
        return this;
    }

    public e b(JSONObject r10) {
        this.f22048h = r10;
        return this;
    }

    public e c(JSONObject r10) {
        this.f22046f = r10;
        return this;
    }

    public e d(JSONObject r10) {
        this.f22045e = r10;
        return this;
    }

    public boolean e() {
        return TextUtils.equals(this.f22042b, "memory");
    }

    public e f(String r10) {
        this.f22042b = r10;
        return this;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.f22042b;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "performance_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r10) {
        if ("fps".equals(this.f22042b) == false) goto L5;
    L34:
        boolean r11 = b2.b.d(this.f22042b, this.f22043c);
    L36:
        if (this.f22044d == true) goto L39;
        if (r11 == true) goto L39;
        return false;
    L39:
        return true;
    L5:
        if ("fps_drop".equals(this.f22042b) == true) goto L34;
        if (CommonServiceName.MONITOR_TYPE_TEMPERATURE.equals(this.f22042b) == false) goto L11;
        r11 = b2.b.e(this.f22042b);
        goto L36
    L11:
        if ("battery".equals(this.f22042b) == false) goto L14;
    L12:
        r11 = true;
        goto L36
    L14:
        if ("start".equals(this.f22042b) == false) goto L22;
        if (b2.b.c(this.f22042b) == true) goto L12;
        if (b2.b.b(this.f22043c) == true) goto L12;
        r11 = false;
        goto L36
    L22:
        if ("start_trace".equals(this.f22042b) == false) goto L33;
        if (r10 != null) goto L25;
    L32:
        r11 = b2.b.c(this.f22042b);
        goto L36
    L25:
        if (b2.b.e(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT) == true) goto L28;
        r10.remove(LaunchCommon.LAUNCH_DATA_PERF_DATA);
    L28:
        if (b2.b.c(this.f22042b) == true) goto L32;
        JSONObject r12 = r10.optJSONObject(TraceStatsConsts.STATS_KEY_TRACE);
        if (r12 == null) goto L32;
        r12.remove(TraceStatsConsts.STATS_KEY_SPANS);
        goto L32
    L33:
        r11 = b2.b.c(this.f22042b);
        goto L36
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return this.f22041a;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
    L24:
        return null;
    L3:
        if (this.f22048h != null) goto L5;
        this.f22048h = new JSONObject();     // Catch: JSONException -> L24
    L5:
        this.f22048h.put("log_type", "performance_monitor");     // Catch: JSONException -> L24
        this.f22048h.put("service", this.f22042b);     // Catch: JSONException -> L24
        if (i.d(this.f22045e) == true) goto L9;
        this.f22048h.put(CommonKey.KEY_EXTRA_VALUES, this.f22045e);     // Catch: JSONException -> L24
    L9:
        if (TextUtils.equals("start", this.f22042b) == false) goto L17;
        if (TextUtils.equals("from", this.f22048h.optString("monitor-plugin")) == false) goto L17;
        if (this.f22046f != null) goto L15;
        this.f22046f = new JSONObject();     // Catch: JSONException -> L24
    L15:
        this.f22046f.put("start_mode", w0.c.t());     // Catch: JSONException -> L24
    L17:
        if (i.d(this.f22046f) == true) goto L20;
        this.f22048h.put(CommonKey.KEY_EXTRA_STATUS, this.f22046f);     // Catch: JSONException -> L24
    L20:
        if (i.d(this.f22047g) == true) goto L22;
        this.f22048h.put("filters", this.f22047g);     // Catch: JSONException -> L24
    L22:
        return this.f22048h;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public e(String r10, String r11, boolean r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        this.f22042b = r10;
        this.f22043c = r11;
        this.f22044d = r12;
        this.f22045e = r13;
        this.f22046f = r14;
        this.f22048h = r15;
    }

    public e(String r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        this(r10, r11, false, r12, r13, r14);
    }

    public e(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        this(r10, "", false, r11, r12, r13);
    }
}
