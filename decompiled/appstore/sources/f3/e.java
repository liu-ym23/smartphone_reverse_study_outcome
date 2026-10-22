package f3;

import com.bytedance.apm.config.FluencyConfigService;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements FluencyConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h1.e f19454a;

    public class a implements IConfigChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f19455a;

        public a(e r10) {
            this.f19455a = r10;
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            e.a(this.f19455a, r10, r11);
        }
    }

    public e() {
        g3.a.g().h();
        g3.a.g().k(new a(this));
    }

    public static /* synthetic */ void a(e r10, JSONObject r11, boolean r12) {
        r10.b(r11, r12);
    }

    public final void b(JSONObject r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r12 = m3.a.a(r10, SlardarSettingsConsts.PERF_KEY_SMOOTH);
        if (r12 != null) goto L7;
        return;
    L7:
        this.f19454a = new h1.e();
        boolean r13 = false;
        if (r12.optInt(SlardarSettingsConsts.PERF_SMOOTH_STACK_SAMPLING, 0) != 1) goto L10;
        boolean r14 = true;
    L11:
        this.f19454a.s(r14);
        if (r12.optInt(SlardarSettingsConsts.PERF_TRACE_ENABLE, 0) != 1) goto L14;
        boolean r15 = true;
    L15:
        this.f19454a.t(r15);
        this.f19454a.k(r12.optLong(SlardarSettingsConsts.PERF_ATRACE_TAG, 0));
        if (r12.optInt(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_DUMP_STACK, 1) != 1) goto L18;
        boolean r16 = true;
    L19:
        this.f19454a.l(r16);
        if (r12.optInt(SlardarSettingsConsts.PERF_SMOOTH_ENABLE_GFX_MONITOR, 0) != 1) goto L22;
        boolean r17 = true;
    L23:
        this.f19454a.r(r17);
        this.f19454a.n(r12.optInt(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_MONITOR_MODE, 1001));
        if (r12.optInt(SlardarSettingsConsts.PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD, 1) != 1) goto L26;
        boolean r18 = true;
    L27:
        this.f19454a.v(r18);
        this.f19454a.w(r12.optLong(SlardarSettingsConsts.PERF_SMOOTH_SERIOUS_BLOCK_THRESHOLD, 4000));
        if (r12.optInt(SlardarSettingsConsts.PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD, 1) != 1) goto L30;
        boolean r19 = true;
    L31:
        this.f19454a.y(r19);
        if (r12.optInt(SlardarSettingsConsts.PERF_SMOOTH_DROP_ENABLE_UPLOAD, 1) != 1) goto L34;
        boolean r20 = true;
    L35:
        this.f19454a.p(r20);
        if (r12.optInt("enable_upload", 0) != 1) goto L38;
        boolean r21 = true;
    L39:
        this.f19454a.u(r21);
        this.f19454a.o(r12.optLong(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_THRESHOLD, PerfConsts.DEFAULT_BLOCK_INTERVAL_MS));
        this.f19454a.x(r12.optLong(SlardarSettingsConsts.PERF_SMOOTH_DROP_THRESHOLD_MS, 1000));
        if (r12.optInt(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, 0) != 1) goto L42;
        r13 = true;
    L42:
        this.f19454a.m(r13);
        this.f19454a.q(r12.optBoolean(SlardarSettingsConsts.PERF_SMOOTH_DROP_SLOW_METHOD_SWITCH, true));
        this.f19454a.j(r12.optJSONObject(SlardarSettingsConsts.PERF_SMOOTH_SCENE_ENABLE_UPLOAD));
        w0.g.a().c(getConfig());
        return;
    L38:
        r21 = false;
        goto L39
    L34:
        r20 = false;
        goto L35
    L30:
        r19 = false;
        goto L31
    L26:
        r18 = false;
        goto L27
    L22:
        r17 = false;
        goto L23
    L18:
        r16 = false;
        goto L19
    L14:
        r15 = false;
        goto L15
    L10:
        r14 = false;
        goto L11
    }

    @Override // com.bytedance.apm.config.FluencyConfigService
    public h1.e getConfig() {
        return this.f19454a;
    }
}
