package j6;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.launch.LaunchCommon;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements ITypeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f20911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f20913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20914d;

    public c(JSONObject r10, String r11, boolean r12, String r13) {
        this.f20911a = r10;
        this.f20912b = r11;
        this.f20913c = r12;
        this.f20914d = r13;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.f20914d;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "tracing";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r10) {
        if (LaunchCommon.LAUNCH_TASK_TRACING_SERVICE_NAME.equals(this.f20912b) == false) goto L7;
        return b2.b.c("start_trace");
    L7:
        if (b.a().b(this.f20913c, this.f20912b) == 0) goto L9;
        return true;
    L9:
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
        return this.f20911a;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return false;
    }
}
