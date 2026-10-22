package f3;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedanceos.common.ad.common.AdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements IFdConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b3.a f19452a;

    public class a implements IConfigChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19453a;

        public a(d r10) {
            this.f19453a = r10;
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            d.a(this.f19453a, r10, r11);
        }
    }

    public d() {
        if (r3.a.c() == false) goto L5;
        s3.a.a("APM-FD", "FdConfigManager:");
    L5:
        g3.a.g().h();
        g3.a.g().k(new a(this));
    }

    public static /* synthetic */ void a(d r10, JSONObject r11, boolean r12) {
        r10.b(r11, r12);
    }

    public final void b(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject("performance_modules");
        if (r3.a.c() == false) goto L5;
        s3.a.a("APM-FD", "parseConfig:" + r13);
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        JSONObject r14 = r13.optJSONObject(SlardarSettingsConsts.PERF_KEY_FD);
        if (r14 != null) goto L11;
        return;
    L11:
        if (r3.a.c() == false) goto L14;
        s3.a.a("APM-FD", "parseConfig:" + r14);
    L14:
        if (r14.optInt("enable_upload", 0) != 1) goto L16;
        boolean r10 = true;
    L17:
        long r15 = r14.optInt(SlardarSettingsConsts.PERF_FD_KEY_COUNT_THRESHOLD, 800);
        long r16 = r14.optLong("collect_interval", 10) * 60000;
        if (r16 >= 10) goto L20;
        r16 = AdConstant.SPLASH_AD_INTERVAL;
    L20:
        b3.a r17 = new b3.a(r15, r16, r10);
        if (r3.a.c() == false) goto L23;
        s3.a.a("APM-FD", "parseConfig:" + r17);
    L23:
        this.f19452a = r17;
        a3.a.i().l(r17);
        return;
    L16:
        r10 = false;
        goto L17
    }

    @Override // com.bytedance.apm6.fd.config.IFdConfigService
    public b3.a getConfig() {
        return this.f19452a;
    }
}
