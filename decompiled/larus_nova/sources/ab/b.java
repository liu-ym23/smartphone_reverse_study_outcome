package ab;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.sdk.param.NavBtnType;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import kotlin.jvm.internal.Intrinsics;
import t36.f;
import y36.d;
import y36.g;
import y36.n;
import y36.p;
import y36.r;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y36.a f2427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f2428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y36.a f2429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y36.a f2430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f2431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y36.a f2432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y36.a f2433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f2434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r f2435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f2436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.ies.bullet.service.sdk.param.a f2437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p f2438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public r f2439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public y36.a f2440n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public y36.a f2441o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public y36.a f2442p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public y36.a f2443q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f2444r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y36.a f2445s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public y36.a f2446t;

    public b() {
    }

    public final y36.a b() {
        y36.a r100 = this.f2432f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("showCloseall");
        return null;
    }

    public final y36.a c() {
        y36.a r100 = this.f2440n;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("transStatusBar");
        return null;
    }

    public final p getType() {
        p r100 = this.f2428b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    @Override // t36.f
    public final void a(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Boolean r101 = Boolean.FALSE;
        y36.a r102 = new y36.a(r100, "is_host_status_bar_light", r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f2446t = r102;
        y36.a r103 = new y36.a(r100, "disable_input_scroll", r101);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f2427a = r103;
        p r104 = new p(r100, "type", "");
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f2428b = r104;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "hide_back", r101), "<set-?>");
        Intrinsics.checkNotNullParameter(new y36.a(r100, "show_more_button", r101), "<set-?>");
        Intrinsics.checkNotNullParameter(new d(r100, "title_bar_style", 0), "<set-?>");
        y36.a r105 = new y36.a(r100, "hide_status_bar", r101);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f2430d = r105;
        r r106 = new r(r100, "nav_bar_color");
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f2431e = r106;
        Intrinsics.checkNotNullParameter(new g(r100, NavBtnType.NONE), "<set-?>");
        y36.a r107 = new y36.a(r100, "show_closeall", r101);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f2432f = r107;
        y36.a r108 = new y36.a(r100, "show_close_always", r101);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f2433g = r108;
        n r109 = new n(r100);
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        this.f2434h = r109;
        r r110 = new r(r100, AppConstants.BUNDLE_STATUS_BAR_BG_COLOR);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f2435i = r110;
        r r111 = new r(r100, AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        this.f2436j = r111;
        com.bytedance.ies.bullet.service.sdk.param.a r112 = new com.bytedance.ies.bullet.service.sdk.param.a(r100, "status_font_mode", StatusFontMode.DEFAULT);
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        this.f2437k = r112;
        p r113 = new p(r100, "title", null);
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        this.f2438l = r113;
        r r114 = new r(r100, "title_color");
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        this.f2439m = r114;
        Intrinsics.checkNotNullParameter(new y36.a(r100, AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME, r101), "<set-?>");
        Boolean r115 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "is_adjust_pan", r115), "<set-?>");
        if (h.u() == false) goto L6;
        y36.a r116 = new y36.a(r100, "hide_nav_bar", r101);
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f2429c = r116;
        y36.a r117 = new y36.a(r100, AppConstants.TRANS_STATUS_BAR, r101);
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        this.f2440n = r117;
    L9:
        y36.a r118 = new y36.a(r100, "should_full_screen", r101);
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        this.f2441o = r118;
        y36.a r119 = new y36.a(r100, AppConstants.BUNDLE_SHOW_BACK, r101);
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        this.f2442p = r119;
        y36.a r120 = new y36.a(r100, AppConstants.BUNDLE_ENABLE_SHARE, r101);
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        this.f2443q = r120;
        d r121 = new d(r100, "icon_theme", 0);
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        this.f2444r = r121;
        y36.a r122 = new y36.a(r100, "close_position_right", r115);
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        this.f2445s = r122;
        return;
    L6:
        if (Intrinsics.areEqual(getType().f565862b, "fullscreen") == false) goto L8;
        y36.a r123 = new y36.a(r100, "hide_nav_bar", r101);
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        this.f2429c = r123;
        y36.a r124 = new y36.a(r100, AppConstants.TRANS_STATUS_BAR, r101);
        Intrinsics.checkNotNullParameter(r124, "<set-?>");
        this.f2440n = r124;
        goto L9
    L8:
        y36.a r125 = new y36.a(r100, "hide_nav_bar", r115);
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        this.f2429c = r125;
        y36.a r126 = new y36.a(r100, AppConstants.TRANS_STATUS_BAR, r101);
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        this.f2440n = r126;
        goto L9
    }
}
