package m1;

import com.bytedance.apm.data.ITypeData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements ITypeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f22028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22029c;

    public b(String r10, JSONObject r11, boolean r12) {
        this.f22027a = r10;
        this.f22028b = r11;
        this.f22029c = r12;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.f22027a;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "common_log";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r10) {
        return b2.b.a(this.f22027a);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return this.f22029c;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        JSONObject r10 = this.f22028b;
        if (r10 != null) goto L10;
        return null;
    L10:
        r10.put("log_type", this.f22027a);     // Catch: JSONException -> L9
    L6:
        return this.f22028b;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }
}
