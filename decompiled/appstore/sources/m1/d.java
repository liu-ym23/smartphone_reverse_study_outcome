package m1;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionConsts;
import com.bytedance.apm.data.ITypeData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements ITypeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f22038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f22040d;

    public d(String r10, JSONObject r11) {
        this(r10, r11, System.currentTimeMillis());
    }

    public long a() {
        return this.f22040d;
    }

    public void b() {
        this.f22039c = true;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.f22037a;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return this.f22037a;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r10) {
        if (this.f22039c == false) goto L5;
    L8:
        return true;
    L5:
        if (b2.b.e(this.f22037a) == true) goto L8;
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
        JSONObject r10 = this.f22038b;
        if (r10 != null) goto L17;
        return null;
    L17:
        r10.put("timestamp", this.f22040d);     // Catch: JSONException -> L15
        this.f22038b.put(CommonKey.KEY_CRASH_TIME, this.f22040d);     // Catch: JSONException -> L15
        this.f22038b.put("is_main_process", w0.c.F());     // Catch: JSONException -> L15
        this.f22038b.put("process_name", w0.c.h());     // Catch: JSONException -> L15
        this.f22038b.put("log_type", this.f22037a);     // Catch: JSONException -> L15
        if (w0.c.f() <= w0.c.z()) goto L8;
    L10:
        this.f22038b.put(ExceptionConsts.KEY_APP_START_TIME, w0.c.z());     // Catch: JSONException -> L15
    L16:
        goto L12
    L8:
        if (w0.c.f() == 0) goto L10;
        this.f22038b.put(ExceptionConsts.KEY_APP_START_TIME, w0.c.f());     // Catch: JSONException -> L15
    L12:
        return this.f22038b;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public String toString() {
        return "ExceptionLogData{eventType='" + this.f22037a + "', logJson=" + this.f22038b + ", forceSampled=" + this.f22039c + ", time=" + this.f22040d + '}';
    }

    public d(String r10, JSONObject r11, long r12) {
        this.f22037a = r10;
        this.f22038b = r11;
        this.f22040d = r12;
    }
}
