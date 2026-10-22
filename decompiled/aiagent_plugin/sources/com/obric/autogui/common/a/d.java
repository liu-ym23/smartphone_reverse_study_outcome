package com.obric.autogui.common.a;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.autoaction.view.DraggableFloatingLayout;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: FeatureUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "FeatureUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f28974a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f28975b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f28976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f28977d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d.f f28978e = null;
    private static final d.f f = null;
    private static final List<String> g = null;
    private static final List<String> h = null;
    private static final List<String> i = null;

    /* JADX INFO: compiled from: FeatureUtils.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f28979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f28980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<String> f28981c;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (this.f28979a == r10.f28979a) goto L12;
            return false;
        L12:
            if (this.f28980b == r10.f28980b) goto L15;
            return false;
        L15:
            if (o.a(this.f28981c, r10.f28981c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f28979a) * 31) + Boolean.hashCode(this.f28980b)) * 31) + this.f28981c.hashCode();
        }

        public String toString() {
            return "SwipeV3Config(version=" + this.f28979a + ", enabled=" + this.f28980b + ", appWhitelist=" + this.f28981c + ')';
        }

        public a(long r3, boolean r5, Set<String> r6) {
            Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
            o.e(r7, "appWhitelist");
            this.f28979a = r3;
            this.f28980b = r5;
            this.f28981c = r7;
        }

        public final long a() {
            return this.f28979a;
        }

        public final boolean b() {
            return this.f28980b;
        }

        public final Set<String> c() {
            return this.f28981c;
        }
    }

    /* JADX INFO: compiled from: FeatureUtils.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f28983b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28982a, r6.f28982a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f28983b, r6.f28983b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f28982a.hashCode() * 31) + this.f28983b.hashCode();
        }

        public String toString() {
            return "ThermalPowerManagerShortOSVersionConfig(key=" + this.f28982a + ", defaultValue=" + this.f28983b + ')';
        }

        public b(String r2, String r3) {
            o.e(r2, "key");
            o.e(r3, "defaultValue");
            this.f28982a = r2;
            this.f28983b = r3;
        }

        public final String a() {
            return this.f28982a;
        }

        public final String b() {
            return this.f28983b;
        }
    }

    public static /* synthetic */ boolean lambda$BGIfk81Hpd1IcDoaA7HWyBjGk04() {
        return ak();
    }

    /* JADX INFO: renamed from: lambda$hVnNHtywLk_nVBSUmouLc-D0_lc, reason: not valid java name */
    public static /* synthetic */ boolean m801lambda$hVnNHtywLk_nVBSUmouLcD0_lc() {
        return al();
    }

    public final boolean a() {
        return false;
    }

    public final boolean b() {
        return true;
    }

    private d() {
    }

    static {
        f28974a = new d();
        f28975b = new a(0, false, ax.b());
        if (Build.VERSION.SDK_INT < 37) goto L5;
        String r0 = "android.window.ScreenCaptureInternal";
    L6:
        f28977d = r0;
        f28978e = d.g.a($$Lambda$d$BGIfk81Hpd1IcDoaA7HWyBjGk04.INSTANCE);
        f = d.g.a($$Lambda$d$hVnNHtywLk_nVBSUmouLcD0_lc.INSTANCE);
        g = p.b(new String[]{"com.luna.music", "com.netease.cloudmusic", "com.tencent.qqmusic", "com.kugou.android", "cn.kuwo.player", "com.ss.android.lark", "app.podcast.cosmos"});
        h = p.b(new String[]{"open_app", "click", "double_click", "long_press", "type", "press", "swipe", "wait", "set_scroll_value"});
        i = p.b();
        return;
    L5:
        r0 = "android.window.ScreenCapture";
        goto L6
    }

    private final a af() {
        long r0 = AutoActionConfigs.INSTANCE.getVersion();
        a r2 = f28976c;
        a r3 = null;
        boolean r4 = true;
        if (r2 != null) goto L5;
    L13:
        monitor-enter(this);
        long r1 = AutoActionConfigs.INSTANCE.getVersion();     // Catch: Throwable -> L31
        a r5 = f28976c;     // Catch: Throwable -> L31
        if (r5 != null) goto L17;
    L24:
        r3 = f28974a.ag();     // Catch: Throwable -> L31
        if (r3 == null) goto L28;
        f28976c = r3;     // Catch: Throwable -> L31
        if (r3 == null) goto L28;
    L29:
        monitor-exit(this);
        return r3;
    L28:
        r3 = f28975b;     // Catch: Throwable -> L31
        goto L29
    L17:
        if (r5.a() == r1) goto L20;
        r4 = false;
    L20:
        if (r4 == false) goto L22;
        r3 = r5;
    L22:
        if (r3 == null) goto L24;
    L31:
        th = move-exception;
        throw th;
    L5:
        if (r2.a() != r0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        return r2;
    L7:
        r6 = false;
        goto L8
    }

    private final a ag() {
        long r0 = AutoActionConfigs.INSTANCE.getVersion();
        List<?> r8 = AutoActionConfigs.INSTANCE.getListCfg("opt_config.swipe_v3_app_whitelist");
        if (r8 == null) goto L26;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L23;
        Object r6 = r10.next();
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L11:
        if (r7 == null) goto L20;
        String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r11 == null) goto L20;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
    L21:
        if (r11 == null) goto L6;
        r4.add(r11);
        goto L6
    L17:
        r12 = false;
    L20:
        r11 = null;
        goto L21
    L10:
        r7 = null;
        goto L11
    L23:
        Set r13 = p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        if (r13 == null) goto L26;
    L27:
        boolean r2 = AutoActionConfigs.INSTANCE.getBooleanCfg("opt_config.swipe_v3_enable", true);
        long r5 = AutoActionConfigs.INSTANCE.getVersion();
        if (r0 > 0) goto L30;
    L34:
        Loog.INSTANCE.w(TAG, "swipe v3 config unavailable or changed while reading, versionBefore=" + r0 + ", versionAfter=" + r5);
        return null;
    L30:
        if (r0 != r5) goto L34;
        return new a(r5, r2, r13);
    L26:
        r13 = ax.b();
        goto L27
    }

    private final boolean ah() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f28978e.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean ak() {
        ZeusTransformUtils.forName(f28977d + "$CaptureArgs$Builder", "com.obric.aiagent.plugin").getDeclaredMethod("setHeifOutput", new Class[]{ParcelFileDescriptor.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L5 NoSuchMethodException -> L7
    L13:
        return true;
    L7:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "setHeifOutput is not supported", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L10:
        return false;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to resolve setHeifOutput", th);
        goto L10
    }

    private final boolean ai() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean al() {
        Class<?> r4 = ZeusTransformUtils.forName("android.window.ScreenCapture$ScreenCaptureListener", "com.obric.aiagent.plugin");     // Catch: Throwable -> L5 NoSuchMethodException -> L7
        ZeusTransformUtils.forName("android.window.ScreenCapture$CaptureArgs$Builder", "com.obric.aiagent.plugin").getDeclaredMethod("setHeifEarlyBufferListener", new Class[]{r4});     // Catch: Throwable -> L5 NoSuchMethodException -> L7
    L13:
        return true;
    L7:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "setHeifEarlyBufferListener is not supported", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L10:
        return false;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to resolve setHeifEarlyBufferListener", th);
        goto L10
    }

    public final boolean c() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("notify_opt", true);
    }

    public final boolean d() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("computer_control.enable", true);
    }

    public final boolean e() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("computer_control.gui_action.enable", true);
    }

    public final boolean f() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("computer_control.mirror_view.enable", true);
    }

    public final boolean g() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_player_v2_226", true);
    }

    public final boolean h() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_vd_player_new_ui", true);
    }

    public final boolean i() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_toast_system_hint", true);
    }

    private final List<String> aj() {
        List<?> r4 = AutoActionConfigs.INSTANCE.getListCfg("vlm.common.toast_system_hint_action_whitelist");
        if (r4 == null) goto L15;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L21;
        Object r2 = r6.next();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L11:
        if (r3 == null) goto L6;
        r0.add(r3);
        goto L6
    L10:
        r3 = null;
        goto L11
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L15:
        return h;
    }

    public final boolean a(String r6) {
        if (r6 == null) goto L31;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r7 == null) goto L32;
        String r8 = r7.toLowerCase(Locale.ROOT);
        o.c(r8, "toLowerCase(...)");
        if (r8 != null) goto L9;
        return false;
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L34;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(aj(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L19;
    L21:
        Iterator r9 = r5.iterator();
    L23:
        if (r9.hasNext() == false) goto L36;
        if (d.o.o.a(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString(), r8, true) == false) goto L23;
        return true;
    L36:
        return false;
    L19:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L21;
        return false;
    L34:
        return false;
    L11:
        r1 = false;
        goto L12
    L32:
        return false;
    L31:
        return false;
    }

    public final int j() {
        return AutoActionConfigs.INSTANCE.getIntCfg("vlm.common.toast_system_hint_max_count", 5);
    }

    public final int k() {
        return AutoActionConfigs.INSTANCE.getIntCfg("vlm.common.toast_system_hint_max_text_length", 512);
    }

    public final boolean l() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_thermal_judge", true);
    }

    public final String b(String r4) {
        o.e(r4, "productName");
        if (o.a(r4, "pacific") == false) goto L6;
        b r3 = new b("vlm.common.thermal_power_manager_min_p_short_os_version", "2.2.0.2");
    L10:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        String r6 = AutoActionConfigs.INSTANCE.getStringCfg(r3.a());
        if (r6 == null) goto L24;
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L22;
        r6 = null;
    L22:
        if (r6 == null) goto L24;
        return r6;
    L24:
        return r3.b();
    L15:
        return r3.b();
    L12:
        r5 = false;
        goto L13
    L6:
        if (o.a(r4, IFeatureServiceKt.PRODUCT_NERIDA) == false) goto L8;
        r3 = new b("vlm.common.thermal_power_manager_min_n_short_os_version", "2.2.0.0");
        goto L10
    L8:
        r3 = new b("", "");
        goto L10
    }

    public final boolean m() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.opti_wait.time_opti", true);
    }

    public final boolean n() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.loading.detect_open_app_enable", true);
    }

    public final boolean o() {
        if (m() == true) goto L5;
    L7:
        return false;
    L5:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.rule_stability.enable", true) == false) goto L7;
        return true;
    }

    public final long p() {
        return n.a(AutoActionConfigs.INSTANCE.getLongCfg("vlm.rule_stability.initial_wait_millis", 500), 0);
    }

    public final long c(String r11) {
        if (r11 == null) goto L47;
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r10 == null) goto L48;
        String r12 = r10.toLowerCase(Locale.ROOT);
        o.c(r12, "toLowerCase(...)");
        if (r12 == null) goto L49;
        boolean r3 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r13 = true;
    L12:
        Long r5 = null;
        if (r13 == true) goto L16;
        r12 = null;
    L16:
        if (r12 == null) goto L50;
        String r14 = AutoActionConfigs.INSTANCE.getStringCfg("vlm.rule_stability.callback_timeout_by_action");
        if (r14 != null) goto L20;
    L25:
        r14 = "{\"open_app\":2000}";
    L45:
        Object r15 = new JSONObject(r14).opt(r12);     // Catch: Exception -> L42
        if (ZeusTransformUtils.instanceOf(r15, Number.class) == false) goto L30;
        Long r16 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Exception -> L42
    L33:
        if (r16 != null) goto L35;
        return 750;
    L35:
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L37;
        r3 = true;
    L37:
        if (r3 == false) goto L39;
        r5 = r16;
    L39:
        if (r5 == null) goto L52;
        return r5.longValue();
    L52:
        return 750;
    L30:
        if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L32;
        r16 = d.o.o.e((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L42
        goto L33
    L32:
        r16 = null;
    L42:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "解析规则稳定性回调超时配置失败，使用默认值", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return 750;
    L20:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r14 = null;
    L23:
        if (r14 == null) goto L25;
    L50:
        return 750;
    L11:
        r13 = false;
        goto L12
    L49:
        return 750;
    L48:
        return 750;
    L47:
        return 750;
    }

    public final boolean q() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("session.preload.enable", true);
    }

    public final long r() {
        return AutoActionConfigs.INSTANCE.getLongCfg("session.pending.precreate_ttl_millis", 10000);
    }

    public final boolean s() {
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.screenshot.heif.enable", true) == true) goto L5;
    L7:
        return false;
    L5:
        if (ah() == false) goto L7;
        return true;
    }

    public final int t() {
        return n.a(AutoActionConfigs.INSTANCE.getIntCfg("vlm.screenshot.heif.qp", 35), 1, 51);
    }

    public final int u() {
        return n.a(AutoActionConfigs.INSTANCE.getIntCfg("vlm.screenshot.heif.downscale_preference", 0), 0, 1);
    }

    public final boolean v() {
        if (s() == true) goto L6;
        return false;
    L6:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.screenshot.heif.early_buffer.enable", true) == true) goto L8;
        return false;
    L8:
        if (ai() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final long w() {
        return AutoActionConfigs.INSTANCE.getLongCfg("vlm.opti_wait.timeout", DraggableFloatingLayout.DEFAULT_RIGHT_REVEAL_AUTO_RETRACT_DELAY_MS);
    }

    public final long a(String r3, long r4) {
        if (r3 == null) goto L17;
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r2 == null) goto L17;
        String r5 = r2.toLowerCase(Locale.ROOT);
        o.c(r5, "toLowerCase(...)");
        if (r5 == null) goto L17;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L17;
        return AutoActionConfigs.INSTANCE.getLongCfg("vlm.loading.timeout_by_action." + r5, r4);
    L10:
        r6 = false;
    L17:
        return r4;
    }

    public final boolean x() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.opti_wait.update_model", true);
    }

    public final boolean y() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.viewtree.enable", false);
    }

    public final boolean z() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.step.prepare.parallel.enable", true);
    }

    public final boolean A() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.viewtree.hyper_params.enable", false);
    }

    public final boolean B() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.saep_packages.hyper_params.enable", true);
    }

    public final boolean C() {
        return i.f28986a.a();
    }

    public final boolean D() {
        return i.f28986a.b();
    }

    public final boolean E() {
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.spec.viewtree.prefetch.enable", true) == true) goto L5;
    L7:
        return false;
    L5:
        if (y() == false) goto L7;
        return true;
    }

    public final long F() {
        return n.a(AutoActionConfigs.INSTANCE.getLongCfg("vlm.spec.viewtree.initial_delay_ms", 2000), 0, 10000);
    }

    public final long G() {
        return n.a(AutoActionConfigs.INSTANCE.getLongCfg("vlm.spec.viewtree.interval_ms", 400), 100, 2000);
    }

    public final long H() {
        return n.a(AutoActionConfigs.INSTANCE.getLongCfg("vlm.spec.viewtree.expire_ms", 450), 100, 1500);
    }

    public final long I() {
        return n.a(AutoActionConfigs.INSTANCE.getLongCfg("vlm.spec.viewtree.cheap_abort_threshold_ms", 3), 0, 100);
    }

    public final int J() {
        return n.a(AutoActionConfigs.INSTANCE.getIntCfg("vlm.spec.viewtree.max_dumps", 20), 1, 30);
    }

    public final long K() {
        return AutoActionConfigs.INSTANCE.getLongCfg("vlm.hangup.ui_countdown_task_millis", 5000);
    }

    public final List<String> L() {
        List<?> r5 = AutoActionConfigs.INSTANCE.getListCfg("vlm.common.unmute_whitelist");
        List<String> r0 = null;
        if (r5 == null) goto L27;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L13;
        Object r3 = r7.next();
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L11:
        if (r4 == null) goto L6;
        r1.add(r4);
        goto L6
    L10:
        r4 = null;
        goto L11
    L13:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        r2.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        goto L15
    L17:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L19:
        if (r12.hasNext() == false) goto L26;
        Object r13 = r12.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L23;
        boolean r14 = true;
    L24:
        if (r14 == false) goto L19;
        r11.add(r13);
        goto L19
    L23:
        r14 = false;
        goto L24
    L26:
        r0 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
    L27:
        if (r0 == null) goto L29;
        return r0;
    L29:
        return g;
    }

    public final long M() {
        return AutoActionConfigs.INSTANCE.getLongCfg("operator.openapp.restart_timeout_interval_limit", 10000);
    }

    public final int N() {
        return AutoActionConfigs.INSTANCE.getIntCfg("operator.openapp.white_screen_similarity_threshold", 6);
    }

    public final float O() {
        return AutoActionConfigs.INSTANCE.getIntCfg("operator.openapp.white_screen_edge_ratio_threshold", 20) / 100.0f;
    }

    public final float P() {
        return AutoActionConfigs.INSTANCE.getIntCfg("operator.openapp.white_screen_corner_color_ratio_threshold", 85) / 100.0f;
    }

    public final int Q() {
        return AutoActionConfigs.INSTANCE.getIntCfg("operator.openapp.restart_retry_max_times", 3);
    }

    public final long R() {
        return AutoActionConfigs.INSTANCE.getLongCfg("operator.openapp.kill_app_delay_time", WsConstants.EXIT_DELAY_TIME);
    }

    public final boolean S() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("operator.openapp.restart_enable", false);
    }

    public final List<String> T() {
        List<?> r4 = AutoActionConfigs.INSTANCE.getListCfg("vlm.loading.skip_wait");
        if (r4 == null) goto L15;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L21;
        Object r2 = r6.next();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L11:
        if (r3 == null) goto L6;
        r0.add(r3);
        goto L6
    L10:
        r3 = null;
        goto L11
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L15:
        return p.b();
    }

    public final List<String> U() {
        List<?> r4 = AutoActionConfigs.INSTANCE.getListCfg("vlm.loading.skip_client_check");
        if (r4 == null) goto L15;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L21;
        Object r2 = r6.next();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L11:
        if (r3 == null) goto L6;
        r0.add(r3);
        goto L6
    L10:
        r3 = null;
        goto L11
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L15:
        return p.b();
    }

    public final boolean V() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("operator.precheck.scrollwheel.optimize.enable", true);
    }

    public final boolean W() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("operator.precheck.scrollwheel.semantic_parse.enable", false);
    }

    public final boolean X() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("operator.precheck.swipe.isDelay.enable", true);
    }

    public final boolean Y() {
        if (af().b() == true) goto L5;
    L7:
        return false;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(af().c(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L7;
        return true;
    }

    public final boolean d(String r1) {
        return e.a(r1, af().c());
    }

    public final boolean Z() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("cursor.fix.swipe_ui", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<String> aa() {
        List r1 = AutoActionConfigs.INSTANCE.getListCfg("operator.vd.openapp.white_list");
        boolean r0 = ZeusTransformUtils.instanceOf(r1, List.class);
        List r2 = r1;
        if (r0 == true) goto L6;
        r2 = null;
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        return i;
    }

    public final boolean ab() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("network.enable_ttnet_monitor_hook_log", false);
    }

    public final boolean ac() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("network.enable_ttnet_monitor_hook_event", false);
    }

    public final float ad() {
        String r1 = AutoActionConfigs.INSTANCE.getStringCfg("obric_ttnet_monitor_hook_event_rate");
        if (r1 == null) goto L7;
        Float r2 = d.o.o.b(r1);
        if (r2 == null) goto L7;
        return r2.floatValue();
    L7:
        return 0.0f;
    }

    public final boolean ae() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("client_tool.client_info_collect.enable", true);
    }
}
