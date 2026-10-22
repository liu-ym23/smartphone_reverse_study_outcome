package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sg2.v;
import xi2.f0;
import xi2.m0;
import xi2.w;

/* JADX INFO: loaded from: classes10.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f149037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TitleSwitchHelper$switchAction$1 f149038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f149039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f149040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f149041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View.OnClickListener f149042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f149043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f149044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final gi2.a f149045i;

    public final void b() {
        Handler r100 = UtilityKotlinExtentionsKt.f153057b;
        r100.removeCallbacks(this.f149038b);
        if (ViewCompat.isAttachedToWindow(this.f149039c) == false) goto L6;
        r100.postDelayed(this.f149038b, this.f149040d.a() * ((long) 1000));
        return;
    }

    public final int getType() {
        return this.f149043g;
    }

    public final void a(f0 r100) {
        TextView r101 = this.f149039c;
        r101.setText(r100.c());
        int r102 = s.f45717a;
        Integer r103 = s.b(r100.a());
        if (r103 == null) goto L6;
        r101.setTextColor(r103.intValue());
    L6:
        if (r100.b() <= 0) goto L8;
        float r104 = r100.b();
    L9:
        r101.setTextSize(1, r104);
        r101.setVisibility(0);
        this.f149039c.setTag(r100);
        Object r105 = this.f149039c.getParent();
        if (r105 == null) goto L61;
        View r106 = (View) r105;
        if (cg4.a.a(r100.d()) == false) goto L14;
        View.OnClickListener r107 = this.f149042f;
    L15:
        r106.setOnClickListener(r107);
        String r108 = "";
        if (this.f149043g != 2) goto L43;
        gi2.a r109 = this.f149045i;
        if (r109 == null) goto L20;
        LiveRoomParams r110 = (LiveRoomParams) r109.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
    L21:
        com.bytedance.android.ec.common.api.jump.model.a r111 = this.f149045i;
        if (r111 != null) goto L24;
        r111 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
    L24:
        v r112 = new v("livesdk_show_store_entrance", r111);
        r112.c(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
        if (r110 == null) goto L27;
        String r113 = r110.getEnterFromMerge();
    L28:
        r112.c(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r113);
        if (r110 == null) goto L31;
        String r114 = r110.getEnterMethod();
    L32:
        r112.c(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r114);
        r112.c(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, "live");
        w r115 = this.f149040d;
        if (r115 == null) goto L42;
        m0 r116 = r115.b();
        if (r116 == null) goto L42;
        Map<String, String> r117 = r116.c();
        if (r117 == null) goto L42;
        String r118 = r117.get("author_id");
        if (r118 == null) goto L42;
        r108 = r118;
    L42:
        r112.c("author_id", r108);
        r112.c("live_anchor_id", this.f149044h);
        r112.c(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "live_brand_speical");
        r112.i(null);
        return;
    L31:
        r114 = null;
        goto L32
    L27:
        r113 = null;
        goto L28
    L20:
        r110 = null;
        goto L21
    L43:
        m0 r119 = this.f149040d.b();
        if (r119 == null) goto L63;
        String r120 = r119.b();
        if (r120 == null) goto L64;
        String r121 = r120.concat("show");
        com.bytedance.android.ec.common.api.jump.model.a r122 = this.f149045i;
        if (r122 != null) goto L50;
        r122 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
    L50:
        v r123 = new v(r121, r122);
        m0 r124 = this.f149040d.b();
        if (r124 == null) goto L53;
        Map<String, String> r125 = r124.c();
    L54:
        r123.d(r125);
        r123.d(this.f149041e);
        String r126 = r100.c();
        if (r126 == null) goto L58;
        r108 = r126;
    L58:
        r123.c("button_text", r108);
        r123.i(null);
        return;
    L53:
        r125 = null;
        goto L54
    L64:
        return;
    L63:
        return;
    L14:
        r107 = null;
        goto L15
    L61:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L8:
        r104 = 13.0f;
        goto L9
    }

    public m(TextView r100, w r101, Map r102, IronPromotionListBackgroundView.b r103, int r104, String r105, gi2.a r106) {
        Intrinsics.checkNotNullParameter(r100, "tvTitle");
        Intrinsics.checkNotNullParameter(r101, "marketComponent");
        Intrinsics.checkNotNullParameter(r103, "clickListener");
        Intrinsics.checkNotNullParameter(r105, "roomId");
        this.f149039c = r100;
        this.f149040d = r101;
        this.f149041e = r102;
        this.f149042f = r103;
        this.f149043g = r104;
        this.f149044h = r105;
        this.f149045i = r106;
        this.f149038b = new TitleSwitchHelper$switchAction$1(this);
    }
}
