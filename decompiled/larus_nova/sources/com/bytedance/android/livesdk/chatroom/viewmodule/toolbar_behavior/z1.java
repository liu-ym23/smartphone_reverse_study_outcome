package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ToolBarCouponExtraData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class z1 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ToolBarCouponExtraData f117520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s f117521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f117522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f117523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f117524e;

    public static final class a {
    }

    static {
    }

    public z1() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        String r101 = null;
        if (r100 != null) goto L25;
        ToolBarCouponExtraData r102 = null;
    L13:
        this.f117520a = r102;
        this.f117521b = r100;
        HSImageView r103 = this.f117523d;
        if (r103 == null) goto L23;
        PipelineDraweeControllerBuilder r104 = Fresco.newDraweeControllerBuilder();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r105 = this.f117521b;
        if (r105 == null) goto L22;
        py.k r106 = r105.f116193c;
        if (r106 == null) goto L22;
        List<String> r107 = r106.getUrls();
        if (r107 == null) goto L22;
        r101 = (String) CollectionsKt.firstOrNull(r107);
    L22:
        r103.setController(r104.setUri(r101).setControllerListener(new a2(this)).build());
    L23:
        b("coupon_bottom_icon_show");
        a("live_coupon_bottom_icon_show");
        return;
    L25:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L6
        Object r109 = Result.m9449constructorimpl(GsonHelper.get().fromJson(r100.f116194d, ToolBarCouponExtraData.class));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r109) == false) goto L11;
        r109 = null;
    L11:
        r102 = (ToolBarCouponExtraData) r109;
    L6:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final void a(String r110) {
        DataCenter r100 = this.f117522c;
        Unit r101 = null;
        if (r100 == null) goto L5;
        String r102 = (String) r100.get("log_enter_params", SliceInitService.DEFAULT_SWITCH);
    L6:
        DataCenter r103 = this.f117522c;
        if (r103 == null) goto L9;
        Room r104 = com.bytedance.android.live.core.utils.z.o(r103);
    L11:
        if (r102 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L35;
        if (r104 == null) goto L36;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L30
        JSONObject r107 = new JSONObject(r102);     // Catch: Throwable -> L30
        String r108 = r107.optString("creative_id");     // Catch: Throwable -> L30
        if (r108.length() != 0) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == false) goto L25;
        return;
    L25:
        String r111 = r107.optString("log_extra", SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L30
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L30
        r112.put("anchor_id", r104.getOwnerUserIdString());     // Catch: Throwable -> L30
        r112.put("room_id", String.valueOf(r104.getRoomId()));     // Catch: Throwable -> L30
        String r113 = r112.toString();     // Catch: Throwable -> L30
        ILiveDouPlusService r114 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);     // Catch: Throwable -> L30
        if (r114 == null) goto L28;
        r114.logEvent(false, r110, "", MapsKt.mapOf(new Pair[]{TuplesKt.to("tag", "live_ad"), TuplesKt.to("is_ad_event", "1"), TuplesKt.to("category", "umeng"), TuplesKt.to("log_extra", r111), TuplesKt.to("value", r108), TuplesKt.to("ad_extra_data", r113)}));     // Catch: Throwable -> L30
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        Result.m9449constructorimpl(r101);     // Catch: Throwable -> L30
        return;
    L22:
        r109 = false;
    L30:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L36:
        return;
    L35:
        return;
    L13:
        if (r102.length() == 0) goto L16;
        r105 = false;
        goto L17
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public final void b(String r100) {
        com.bytedance.android.livesdk.log.filter.o r101 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        LinkedHashMap r102 = new LinkedHashMap();
        DataCenter r103 = this.f117522c;
        if (r103 == null) goto L8;
        Room r104 = com.bytedance.android.live.core.utils.z.o(r103);
        if (r104 == null) goto L8;
        String r105 = String.valueOf(r104.getRoomId());
        if (r105 == null) goto L8;
    L9:
        r102.put("anchor_id", r105);
        DataCenter r106 = this.f117522c;
        if (r106 == null) goto L15;
        Room r107 = com.bytedance.android.live.core.utils.z.o(r106);
        if (r107 == null) goto L15;
        String r108 = r107.getOwnerUserIdString();
        if (r108 == null) goto L15;
    L16:
        r102.put("room_id", r108);
        if (r101 == null) goto L22;
        Map<String, String> r109 = r101.getMap();
        if (r109 == null) goto L22;
        String r110 = r109.get("enter_from_merge");
        if (r110 == null) goto L22;
    L23:
        r102.put("enter_from_merge", r110);
        if (r101 == null) goto L29;
        Map<String, String> r111 = r101.getMap();
        if (r111 == null) goto L29;
        String r112 = r111.get("enter_method");
        if (r112 == null) goto L29;
    L30:
        r102.put("enter_method", r112);
        if (r101 == null) goto L36;
        Map<String, String> r113 = r101.getMap();
        if (r113 == null) goto L36;
        String r114 = r113.get("action_type");
        if (r114 == null) goto L36;
    L37:
        r102.put("action_type", r114);
        ToolBarCouponExtraData r115 = this.f117520a;
        if (r115 == null) goto L40;
        Integer r116 = Integer.valueOf(r115.getCouponPrice());
    L41:
        r102.put("bubble_text", String.valueOf(r116));
        DataCenter r117 = this.f117522c;
        if (r117 == null) goto L55;
        String r118 = (String) r117.get("qcpx_coupon_point_info", "");
        if (r118 == null) goto L55;
        if (r118.length() <= 0) goto L48;
        boolean r119 = true;
    L49:
        if (r119 == false) goto L55;
        JSONObject r120 = new JSONObject(r118);
        Iterator<String> r121 = r120.keys();
    L52:
        if (r121.hasNext() == false) goto L54;
        String r122 = r121.next();
        r102.put(r122, r120.get(r122).toString());
        goto L52
    L54:
        r102.put("scene_id", "live_bar_exchange_coupon");
        goto L55
    L48:
        r119 = false;
    L55:
        com.bytedance.android.livesdk.log.u.l().sendLog(r100, r102, new Object[0]);
        return;
    L40:
        r116 = null;
    L36:
        r114 = "";
    L29:
        r112 = "";
    L22:
        r110 = "";
    L15:
        r108 = "";
    L8:
        r105 = "";
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L47;
        Context r101 = r100.getContext();
        if (r101 == null) goto L47;
        ILiveActionHandler r102 = ((IRoomService) jc1.k.n(IRoomService.class)).actionHandler();
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r104 = this.f117521b;
        String r105 = "";
        if (r104 == null) goto L9;
        String r106 = r104.f116195e;
        if (r106 == null) goto L9;
    L10:
        Uri.Builder r107 = UriProtector.parse(r106).buildUpon();
        DataCenter r108 = this.f117522c;
        if (r108 == null) goto L16;
        Room r109 = com.bytedance.android.live.core.utils.z.o(r108);
        if (r109 == null) goto L16;
        String r110 = String.valueOf(r109.getRoomId());
        if (r110 == null) goto L16;
    L17:
        Uri.Builder r111 = r107.appendQueryParameter("anchor_id", r110);
        DataCenter r112 = this.f117522c;
        if (r112 == null) goto L23;
        Room r113 = com.bytedance.android.live.core.utils.z.o(r112);
        if (r113 == null) goto L23;
        String r114 = r113.getOwnerUserIdString();
        if (r114 == null) goto L23;
    L24:
        Uri.Builder r115 = r111.appendQueryParameter("room_id", r114);
        if (r103 == null) goto L30;
        Map<String, String> r116 = r103.getMap();
        if (r116 == null) goto L30;
        String r117 = r116.get("enter_from_merge");
        if (r117 == null) goto L30;
    L31:
        Uri.Builder r118 = r115.appendQueryParameter("enter_from_merge", r117);
        if (r103 == null) goto L37;
        Map<String, String> r119 = r103.getMap();
        if (r119 == null) goto L37;
        String r120 = r119.get("enter_method");
        if (r120 == null) goto L37;
    L38:
        Uri.Builder r121 = r118.appendQueryParameter("enter_method", r120);
        if (r103 == null) goto L46;
        Map<String, String> r122 = r103.getMap();
        if (r122 == null) goto L46;
        String r123 = r122.get("action_type");
        if (r123 == null) goto L46;
        r105 = r123;
    L46:
        r102.handle(r101, r121.appendQueryParameter("action_type", r105).build().toString());
    L37:
        r120 = "";
    L30:
        r117 = "";
    L23:
        r114 = "";
    L16:
        r110 = "";
    L9:
        r106 = "";
    L47:
        b("coupon_bottom_icon_click");
        a("live_coupon_bottom_icon_click");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f117522c = r101;
        this.f117523d = (HSImageView) r100.findViewById(R.id.coupon_exchange_icon);
        this.f117524e = (TextView) r100.findViewById(R.id.coupon_exchange_text);
    }
}
