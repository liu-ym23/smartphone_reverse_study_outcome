package m1;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.ITypeData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements ITypeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f22032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f22033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f22034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f22035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22036g;

    public c(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        this.f22030a = r10;
        this.f22031b = r11;
        this.f22032c = r12;
        this.f22033d = r13;
        this.f22034e = r14;
        this.f22035f = r15;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r10) {
        return b2.b.f(this.f22030a);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return this.f22036g;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        if (this.f22035f != null) goto L18;
        this.f22035f = new JSONObject();
    L18:
        this.f22035f.put("log_type", "service_monitor");     // Catch: JSONException -> L16
        this.f22035f.put("service", this.f22030a);     // Catch: JSONException -> L16
        this.f22035f.put("status", this.f22031b);     // Catch: JSONException -> L16
        JSONObject r10 = this.f22032c;     // Catch: JSONException -> L16
        if (r10 == null) goto L8;
        this.f22035f.put(CommonKey.KEY_VALUE, r10);     // Catch: JSONException -> L16
    L8:
        JSONObject r11 = this.f22033d;     // Catch: JSONException -> L16
        if (r11 == null) goto L11;
        this.f22035f.put("category", r11);     // Catch: JSONException -> L16
    L11:
        JSONObject r12 = this.f22034e;     // Catch: JSONException -> L16
        if (r12 == null) goto L14;
        this.f22035f.put(CommonKey.KEY_METRIC, r12);     // Catch: JSONException -> L16
    L14:
        return this.f22035f;
    L16:
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public c(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15, boolean r16) {
        this.f22030a = r10;
        this.f22031b = r11;
        this.f22032c = r12;
        this.f22033d = r13;
        this.f22034e = r14;
        this.f22035f = r15;
        this.f22036g = r16;
    }
}
