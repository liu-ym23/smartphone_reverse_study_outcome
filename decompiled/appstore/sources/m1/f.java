package m1;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.ITypeData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements ITypeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f22051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f22052d;

    public f(String r10, String r11, JSONObject r12, JSONObject r13) {
        this.f22049a = r10;
        this.f22050b = r11;
        this.f22051c = r12;
        this.f22052d = r13;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "ui_action";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "ui_action";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r10) {
        return b2.b.c(SlardarSettingsConsts.PERF_KEY_UI);
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
    L7:
        return null;
    L3:
        if (this.f22052d != null) goto L5;
        this.f22052d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.f22052d.put("log_type", "ui_action");     // Catch: JSONException -> L7
        this.f22052d.put("action", this.f22049a);     // Catch: JSONException -> L7
        this.f22052d.put("page", this.f22050b);     // Catch: JSONException -> L7
        this.f22052d.put("context", this.f22051c);     // Catch: JSONException -> L7
        return this.f22052d;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }
}
