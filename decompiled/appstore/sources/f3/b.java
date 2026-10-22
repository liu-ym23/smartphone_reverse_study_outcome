package f3;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements CpuConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u2.a f19447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u2.b f19448b;

    public class a implements IConfigChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f19449a;

        public a(b r10) {
            this.f19449a = r10;
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            b.a(this.f19449a, r10, r11);
        }
    }

    public b() {
        g3.a.g().h();
        g3.a.g().k(new a(this));
    }

    public static /* synthetic */ void a(b r10, JSONObject r11, boolean r12) {
        r10.b(r11, r12);
    }

    public final void b(JSONObject r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r12 = m3.a.a(r10, "cpu");
        if (r12 == null) goto L79;
        this.f19447a = new u2.a();
        boolean r13 = true;
        if (r12.optInt("enable_upload", 0) != 1) goto L9;
        boolean r14 = true;
    L10:
        this.f19447a.k(r14);
        if (r12.optInt("enable_collect_all_process", 0) != 1) goto L13;
        boolean r15 = true;
    L14:
        this.f19447a.j(r15);
        long r16 = r12.optLong("front_collect_interval", 0);
        if (r16 <= 0) goto L17;
        this.f19447a.l(r16);
    L17:
        long r17 = r12.optLong("back_collect_interval", 0);
        if (r17 <= 0) goto L20;
        this.f19447a.h(r17);
    L20:
        long r18 = r12.optLong("monitor_interval", 0);
        if (r18 <= 0) goto L23;
        this.f19447a.n(r18);
    L23:
        long r19 = r12.optLong("front_thread_collect_interval", 0);
        if (r19 <= 0) goto L26;
        this.f19447a.m(r19);
    L26:
        long r20 = r12.optLong("back_thread_collect_interval", 0);
        if (r20 <= 0) goto L29;
        this.f19447a.i(r20);
    L29:
        this.f19448b = new u2.b();
        if (r12.optInt("exception_switch", 0) != 1) goto L32;
        boolean r110 = true;
    L33:
        this.f19448b.x(r110);
        double r21 = r12.optDouble("exception_process_back_max_speed", 0.0d);
        if (r21 <= 0.0d) goto L36;
        this.f19448b.t(r21);
    L36:
        double r22 = r12.optDouble("exception_process_fore_max_speed", 0.0d);
        if (r22 <= 0.0d) goto L40;
        this.f19448b.u(r22);
    L40:
        if (r12.optInt(SlardarSettingsConsts.MAIN_THREAD_COLLECT_ENABLED, 0) != 1) goto L42;
        boolean r111 = true;
    L43:
        this.f19448b.p(r111);
        if (r12.optInt("exception_collect_all_process", 0) != 1) goto L46;
        boolean r112 = true;
    L47:
        this.f19448b.o(r112);
        if (r12.optInt("exception_thread_stack_enabled", 1) == 1) goto L51;
        r13 = false;
    L51:
        this.f19448b.r(r13);
        double r23 = r12.optDouble("exception_thread_max_usage", 0.0d);
        if (r23 <= 0.0d) goto L54;
        this.f19448b.v(r23);
    L54:
        JSONObject r113 = r12.optJSONObject("exception_thread_max_usage_map");
        HashMap r24 = new HashMap();
        if (r113 == null) goto L62;
        Iterator<String> r25 = r113.keys();
    L58:
        if (r25.hasNext() == false) goto L62;
        String r26 = r25.next();
        double r27 = r113.optDouble(r26, 0.0d);
        if (r27 <= 0.0d) goto L58;
        r24.put(r26, Double.valueOf(r27));
    L62:
        this.f19448b.w(r24);
        this.f19448b.y(r12.optInt("process_detect_interval", 30));
        this.f19448b.z(r12.optInt("thread_detect_interval", 30));
        JSONObject r114 = r12.optJSONObject("exception_fore_max_speed_scene");
        HashMap r28 = new HashMap();
        if (r114 == null) goto L70;
        Iterator<String> r29 = r114.keys();
    L66:
        if (r29.hasNext() == false) goto L70;
        String r30 = r29.next();
        double r31 = r114.optDouble(r30, 0.0d);
        if (r31 <= 0.0d) goto L66;
        r28.put(r30, Double.valueOf(r31));
    L70:
        this.f19448b.s(r28);
        JSONObject r115 = r12.optJSONObject("exception_back_max_speed_scene");
        HashMap r32 = new HashMap();
        if (r115 == null) goto L78;
        Iterator<String> r33 = r115.keys();
    L74:
        if (r33.hasNext() == false) goto L78;
        String r34 = r33.next();
        double r35 = r115.optDouble(r34, 0.0d);
        if (r35 <= 0.0d) goto L74;
        r32.put(r34, Double.valueOf(r35));
    L78:
        this.f19448b.n(r32);
        this.f19448b.q(r12.optBoolean("exception_native_thread_enabled", false));
        goto L79
    L46:
        r112 = false;
        goto L47
    L42:
        r111 = false;
        goto L43
    L32:
        r110 = false;
        goto L33
    L13:
        r15 = false;
        goto L14
    L9:
        r14 = false;
    L79:
        s3.a.a("APM-CPU", getConfig() + " " + getExceptionConfig());
        t2.a.e().j(getConfig());
        v2.c.c().f(getExceptionConfig());
    }

    @Override // com.bytedance.apm6.cpu.config.CpuConfigService
    public u2.a getConfig() {
        return this.f19447a;
    }

    @Override // com.bytedance.apm6.cpu.config.CpuConfigService
    public u2.b getExceptionConfig() {
        return this.f19448b;
    }
}
