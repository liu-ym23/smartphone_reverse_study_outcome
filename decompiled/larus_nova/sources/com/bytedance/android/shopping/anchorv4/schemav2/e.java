package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home.BaseStandardHomeFragment;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.shopping.api.anchorv3.ECSceneTransitionData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends PdpSchemaParam {
    public String A;
    public Boolean B;
    public boolean C;
    public Long D;
    public final boolean E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f167392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f167393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f167394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f167395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f167396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f167397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f167398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f167399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f167400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f167401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f167402n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f167403o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f167404p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public JSONObject f167405q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f167406r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ECSceneTransitionData f167407s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f167408t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f167409u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f167410v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f167411w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f167412x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Float f167413y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f167414z;

    public final void e() {
        boolean r100 = true;
        if (c().optInt("full_mode", this.C ? 1 : 0) != 1) goto L5;
        boolean r101 = true;
    L6:
        Boolean r102 = Boolean.valueOf(r101);
        this.f167392d = r102;
        a("full_mode", Integer.valueOf(Intrinsics.areEqual(r102, Boolean.TRUE) ? 1 : 0));
        this.f167399k = c().optString("live_window_room_id", null);
        this.f167393e = Boolean.valueOf(com.bytedance.android.shopping.extensions.k.n(c().optString("small_window_mute", null), false));
        this.f167402n = Boolean.valueOf(com.bytedance.android.shopping.extensions.k.n(c().optString("small_window_priority", null), true));
        this.f167401m = Boolean.valueOf(com.bytedance.android.shopping.extensions.k.n(c().optString("disable_live_window", null), false));
        this.f167396h = Integer.valueOf(com.bytedance.android.shopping.extensions.k.r(c().optString("show_sku_panel"), 0));
        this.f167397i = c().optString("mask_color", null);
        this.f167398j = c().optString("clear_screen_upon", null);
        this.f167395g = com.bytedance.android.shopping.extensions.k.n(c().optString("open_with_activity", null), false);
        this.f167403o = c().optString("share_scene", null);
        this.f167404p = c().optString("sec_activity_info", null);
        String r103 = c().optString("img_proportion", null);
        if (r103 == null) goto L9;
        StringsKt.toFloatOrNull(r103);
    L9:
        this.f167405q = com.bytedance.android.shopping.extensions.k.w(c().optString("ecom_share_track_params"));
        Float r104 = StringsKt.toFloatOrNull(c().optString(ECFindSimilarConfig.HEIGHT_PERCENT));
        if (r104 == null) goto L12;
        Integer r105 = Integer.valueOf((int) r104.floatValue());
    L13:
        this.f167406r = r105;
        this.f167394f = Integer.valueOf(com.bytedance.android.shopping.extensions.k.r(c().optString(BaseStandardHomeFragment.KEY_PANEL_HEIGHT), 0));
        String r106 = c().optString("scene_transition_data");
        if (r106.length() <= 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == true) goto L20;
        r106 = null;
    L20:
        this.f167407s = (ECSceneTransitionData) p83.a.a(r106, ECSceneTransitionData.class);
        this.f167409u = c().optString("page_state_listener_id");
        c().optString("page_state_listener_extra");
        this.f167410v = c().optString("first_cid");
        this.f167400l = c().optString("live_hot_sale_component");
        this.f167412x = c().optString("preload_extra");
        this.f167413y = Float.valueOf(com.bytedance.android.shopping.extensions.k.p(c().optString("half_head_scale"), 0.0f));
        this.f167414z = c().optString("half_head_space");
        Long r108 = Long.valueOf(c().optLong("pre_page_click_start"));
        if (r108.longValue() > 0) goto L24;
        r100 = false;
    L24:
        if (r100 == true) goto L27;
        r108 = null;
    L27:
        this.D = r108;
        if (this.E == false) goto L30;
        this.A = c().optString("top_label_text", null);
        this.f167411w = c().optString("pdp_event_transparent_id", null);
        this.f167408t = c().optString("fraction_listener_id", null);
        this.B = Boolean.valueOf(c().optBoolean("need_split_for_pad"));
        return;
    L30:
        this.f167411w = c().optString("pdp_event_transparent_id");
        this.f167408t = c().optString("fraction_listener_id");
        return;
    L16:
        r107 = false;
        goto L17
    L12:
        r105 = null;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaParam
    public final String d() {
        return this.f167391c;
    }

    public e(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        super(r100);
        this.f167391c = "client_params";
        Boolean r101 = Boolean.FALSE;
        this.f167392d = r101;
        this.f167393e = r101;
        boolean r102 = false;
        this.f167396h = 0;
        this.f167401m = r101;
        this.f167402n = Boolean.TRUE;
        this.f167413y = Float.valueOf(0.0f);
        this.B = r101;
        if (com.bytedance.android.ec.core.abtest.d.h() == false) goto L5;
    L6:
        r102 = true;
    L7:
        this.E = r102;
        return;
    L5:
        if (com.bytedance.android.ec.core.anchorv3.o.a(null) == false) goto L7;
        goto L6
    }
}
