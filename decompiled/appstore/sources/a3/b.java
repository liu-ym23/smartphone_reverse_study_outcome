package a3;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.util.ListUtils;
import java.util.List;
import m3.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends n3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f17i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18j;

    public b(int r10, List r11, boolean r12) {
        this.f16h = r10;
        this.f17i = r11;
        this.f18j = r12;
    }

    @Override // n3.a
    public JSONObject a() {
        JSONObject r10 = new JSONObject();
        r10.put("fd_count", this.f16h);     // Catch: Exception -> L7
        if (ListUtils.b(this.f17i) == true) goto L6;
        r10.put("fd_detail", ListUtils.d(this.f17i, "\n"));     // Catch: Exception -> L7
    L6:
        return r10;
    }

    @Override // n3.a
    public JSONObject b() {
        JSONObject r10 = super.b();
        if (r10 == null) goto L8;
    L5:
        r10.put(CommonKey.KEY_IS_FRONT, this.f18j);     // Catch: Exception -> L7
    L6:
        return r10;
    L8:
        r10 = new JSONObject();     // Catch: Exception -> L7
        goto L5
    }

    @Override // n3.a
    public JSONObject c() {
        return null;
    }

    @Override // n3.a
    public JSONObject d() {
        return c.a().getPerfFiltersJson();
    }

    @Override // n3.a
    public String e() {
        return SlardarSettingsConsts.PERF_KEY_FD;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }
}
