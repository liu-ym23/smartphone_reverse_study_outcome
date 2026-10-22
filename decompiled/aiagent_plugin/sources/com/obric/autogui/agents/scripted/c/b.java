package com.obric.autogui.agents.scripted.c;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import d.h.b.o;

/* JADX INFO: compiled from: ScriptEnvConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26918a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f26919b = null;

    /* JADX INFO: renamed from: lambda$202Ic-LO9uGP1BtsrmTky6z4ENs, reason: not valid java name */
    public static /* synthetic */ long m716lambda$202IcLO9uGP1BtsrmTky6z4ENs(String r0, long r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$5__-spxSc_8GGb9Tjja9Wi1r_Sg, reason: not valid java name */
    public static /* synthetic */ int m717lambda$5__spxSc_8GGb9Tjja9Wi1r_Sg(String r0, int r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$hZqw0pu-MXDTQX8Ua62wDiItoWk, reason: not valid java name */
    public static /* synthetic */ boolean m718lambda$hZqw0puMXDTQX8Ua62wDiItoWk() {
        return A();
    }

    private b() {
    }

    static {
        f26918a = new b();
        f26919b = new e($$Lambda$b$202IcLO9uGP1BtsrmTky6z4ENs.INSTANCE, $$Lambda$b$5__spxSc_8GGb9Tjja9Wi1r_Sg.INSTANCE, $$Lambda$b$hZqw0puMXDTQX8Ua62wDiItoWk.INSTANCE);
    }

    private static final long a(String r1, long r2) {
        o.e(r1, "key");
        return AutoActionConfigs.INSTANCE.getLongCfg(r1, r2);
    }

    private static final int a(String r1, int r2) {
        o.e(r1, "key");
        return AutoActionConfigs.INSTANCE.getIntCfg(r1, r2);
    }

    private static final boolean A() {
        return AOSystemTools.INSTANCE.isDebugVersion();
    }

    public static /* synthetic */ boolean a(b r1, String r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return r1.a(r2, r3, r4);
    }

    public final boolean a(String r3, boolean r4, boolean r5) {
        o.e(r3, "configKey");
        if (z() == false) goto L5;
        return true;
    L5:
        boolean r6 = AutoActionConfigs.INSTANCE.getBooleanCfg(r3, r4);
        if (r5 == true) goto L8;
        return r6;
    L8:
        if (r6 == true) goto L10;
    L12:
        return false;
    L10:
        if (a() == false) goto L12;
        return true;
    }

    public final boolean a() {
        return a(this, "js.script.enable", true, false, 4, null);
    }

    public final boolean b() {
        return a("js.script.foundation.ready.download.enable", true, true);
    }

    public final boolean c() {
        return a("js.script.screen.off.download.enable", true, true);
    }

    public final boolean d() {
        return a("js.script.periodic.refresh.enable", true, true);
    }

    public final boolean e() {
        return a("js.script.wifi.available.download.enable", true, true);
    }

    public final boolean f() {
        return a("js.script.start.failed.download.enable", true, true);
    }

    public final boolean g() {
        return a(this, "js.script.version.enable", false, true, 2, null);
    }

    public final d h() {
        return f26919b.a();
    }

    public final boolean i() {
        return a(this, "js.script.decrypt.enable", true, false, 4, null);
    }

    public final boolean j() {
        return a(this, "jsb.get_current_app_info.enable", false, false, 6, null);
    }

    public final boolean k() {
        return a(this, "jsb.get_vd_top_activity_info.enable", false, false, 6, null);
    }

    public final boolean l() {
        return a(this, "jsb.get_view_tree.enable", false, false, 6, null);
    }

    public final boolean m() {
        return a(this, "jsb.get_screenshot.enable", false, false, 6, null);
    }

    public final boolean n() {
        return a(this, "jsb.get_device_info.enable", false, false, 6, null);
    }

    public final boolean o() {
        return a(this, "jsb.event_sender.enable", false, false, 6, null);
    }

    public final boolean p() {
        return a(this, "jsb.log.enable", false, false, 6, null);
    }

    public final boolean q() {
        return a(this, "jsb.http_request.enable", false, false, 6, null);
    }

    public final boolean r() {
        return a(this, "http_request.log_id.enable", false, false, 6, null);
    }

    public final boolean s() {
        return a(this, "jsb.image_process.enable", false, false, 6, null);
    }

    public final int t() {
        return AutoActionConfigs.INSTANCE.getIntCfg("js.script.session_block_threshold", 5);
    }

    public final int u() {
        return AutoActionConfigs.INSTANCE.getIntCfg("js.script.same_ability_loop_warning_threshold", 5);
    }

    public final int v() {
        return AutoActionConfigs.INSTANCE.getIntCfg("js.script.same_ability_loop_block_threshold", 10);
    }

    public final int w() {
        return AutoActionConfigs.INSTANCE.getIntCfg("jsb.image_process.max_base64_length", 1073741824);
    }

    public final int x() {
        return AutoActionConfigs.INSTANCE.getIntCfg("jsb.image_process.max_stitch_count", 30);
    }

    public final int y() {
        return AutoActionConfigs.INSTANCE.getIntCfg("jsb.image_process.max_decode_pixels", 999000000);
    }

    public final boolean z() {
        return AOSystemTools.INSTANCE.isDebugVersion();
    }
}
