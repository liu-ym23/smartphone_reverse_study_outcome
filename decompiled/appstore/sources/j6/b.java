package j6;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.util.i;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IConfigListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f20906e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f20909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f20910d;

    public b() {
        this.f20908b = true;
    }

    public static b a() {
        if (f20906e != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20906e != null) goto L11;
        f20906e = new b();     // Catch: Throwable -> L9
        ((IConfigManager) n5.b.a(IConfigManager.class)).registerConfigListener(f20906e);     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f20906e;
    }

    public int b(boolean r10, String r11) {
        int r12 = 0;
        if (this.f20908b == true) goto L6;
        return 0;
    L6:
        if (r10 == false) goto L12;
        JSONObject r13 = this.f20910d;
        if (r13 != null) goto L10;
    L11:
        r12 = 16;
        goto L12
    L10:
        if (r13.optDouble(r11, -1.0d) > 0.0d) goto L11;
    L12:
        JSONObject r14 = this.f20909c;
        if (r14 != null) goto L15;
        return r12;
    L15:
        if (r14.optDouble(r11, -1.0d) > 0.0d) goto L17;
        return r12;
    L17:
        return r12 | 1;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r10, boolean r11) {
        this.f20908b = i.e(r10, "tracing", SlardarSettingsConsts.SETTING_TRACING_ENABLE, true);
        if (this.f20907a == true) goto L6;
        this.f20909c = i.g(r10, "tracing", SlardarSettingsConsts.SETTING_TRACING_ALLOW_LIST);
        this.f20910d = i.g(r10, "tracing", SlardarSettingsConsts.SETTING_TRACING_ERROR_LIST);
        this.f20907a = true;
        return;
    }
}
