package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import cy0.j;
import i12.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import mz0.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class NewLynxGiftBannerView extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f126580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public zy0.b f126581h;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public final void c() {
        v02.b.a(0, false, new NewLynxGiftBannerView$release$1(this), 7);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void d() {
        int r100 = com.bytedance.android.livesdk.gift.util.g.f132341a;
        h1 r101 = this.f126584c;
        if (r101 == null) goto L5;
        String r102 = r101.getBannerScheme();
    L6:
        h1 r103 = this.f126584c;
        if (r103 == null) goto L9;
        Long r104 = Long.valueOf(r103.getId());
    L10:
        Map<? extends String, ? extends String> r105 = MapsKt.mapOf(new Pair[]{TuplesKt.to("uri", String.valueOf(r102)), TuplesKt.to(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r104))});
        JSONObject r106 = new JSONObject();
        if (r105 != null) goto L13;
    L26:
        Intrinsics.checkNotNullParameter("ttlive_lynx_gift_banner_click", "eventName");
        Intrinsics.checkNotNullParameter(r106, "extras");
        JSONObject r107 = new JSONObject();
        JSONObject r108 = new JSONObject();
        JSONObject r109 = new JSONObject();
        Intrinsics.checkNotNullParameter(r109, "extra");
        Intrinsics.checkNotNullParameter(r108, "metric");
        EventModule r110 = EventModule.GIFT;
        Intrinsics.checkNotNullParameter(r110, "eventModule");
        String r111 = r110.getValue();
        r108.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r109, "map");
        Iterator<String> r112 = r106.keys();
    L28:
        if (r112.hasNext() == false) goto L30;
        String r113 = r112.next();
        Object r114 = r106.get(r113);
        Intrinsics.checkNotNullParameter(r113, "key");
        Intrinsics.checkNotNullParameter(r114, "value");
        r109.put(r113, r114);
        goto L28
    L30:
        cy0.e.f465759a.getClass();
        j r115 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r116 = m.b(r115).b(n97.a.class);
        Intrinsics.checkNotNull(r116);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r116)).g("ttlive_lynx_gift_banner_click", r111, "bussiness_api_call", r107, r108, r109);
        jy0.b.a("ttlive_gift_lynx_banner", "ttlive_lynx_gift_banner_click " + r105);
        n r117 = new n();
        Map<String, String> r118 = r117.f516447a;
        Intrinsics.checkNotNullParameter(r118, "map");
        Intrinsics.checkNotNullParameter(r105, "map");
        r118.putAll(r105);
        mz0.m r119 = new mz0.m();
        r119.b(LogCommon.ROOM);
        r119.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r117.f516448b).addAll(r119.f516446a);
        Object r120 = m.b(r115).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r120);
        ((mz0.i) ((f80.a) r120)).w3("livesdk_lynx_gift_banner_click", r117.f516447a, r117.f516448b);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        return;
    L13:
        if (r105.isEmpty() == true) goto L26;
        Iterator<Map.Entry<? extends String, ? extends String>> r121 = r105.entrySet().iterator();
    L17:
        if (r121.hasNext() == false) goto L26;
        Map.Entry<? extends String, ? extends String> r122 = r121.next();
        String r123 = r122.getKey();
        String r124 = r122.getValue();
        Intrinsics.checkNotNullParameter(r106, "$this$safePut");
        Intrinsics.checkNotNullParameter(r123, "key");
        Intrinsics.checkNotNullParameter(r124, "value");
        r106.put(r123, r124);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        String r125 = e.getMessage();
        if (r125 != null) goto L25;
        r125 = "";
    L25:
        jy0.b.c("BindBoxTracing", r125, null, 4);
        goto L17
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void e(long r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L25
        i12.e r102 = o.b();     // Catch: Throwable -> L25
        Unit r103 = null;
        if (r102 == null) goto L5;
        Object r104 = m.f163449e.d(r102, GiftExtraRepo.class);     // Catch: Throwable -> L25
    L6:
        GiftExtraRepo r105 = (GiftExtraRepo) r104;     // Catch: Throwable -> L25
        if (r105 == null) goto L10;
        g0 r106 = r105.q(r100);     // Catch: Throwable -> L25
    L30:
        Object r107 = Result.m9449constructorimpl(GsonHelper.get().toJson(r106));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r107) == false) goto L18;
        r107 = SliceInitService.DEFAULT_SWITCH;
    L18:
        String r108 = (String) r107;     // Catch: Throwable -> L25
        zy0.b r109 = this.f126581h;     // Catch: Throwable -> L25
        if (r109 == null) goto L23;
        xy0.a<?> r110 = r109.g();     // Catch: Throwable -> L25
        if (r110 == null) goto L23;
        r110.sendJsEvent("H5_updateBannerView", r108);     // Catch: Throwable -> L25
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L25
        return;
    L13:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L25
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L25
        goto L16
    L10:
        r106 = null;
        goto L30
    L5:
        r104 = null;
    L25:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void f(p2 r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        List<y1> r101 = r100.getGifts();
        g0 r102 = null;
        if (r101 == null) goto L9;
        Sequence r103 = CollectionsKt.asSequence(r101);
        if (r103 == null) goto L9;
        Sequence r104 = SequencesKt.mapNotNull(r103, NewLynxGiftBannerView$onGiftSendSucceed$gift$1.INSTANCE);
        if (r104 == null) goto L9;
        y1 r105 = (y1) SequencesKt.firstOrNull(r104);
    L10:
        if (r105 == null) goto L20;
        Pair[] r106 = new Pair[3];
        r106[0] = TuplesKt.to("gift_banner", r105.getGiftBanner());
        r106[1] = TuplesKt.to(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r105.getGiftId()));
        p1 r107 = r105.getGiftExtra();
        if (r107 == null) goto L14;
        r102 = r107.getDecoded();
    L14:
        r106[2] = TuplesKt.to("gift_extra", r102);
        Map r108 = MapsKt.mutableMapOf(r106);
        zy0.b r109 = this.f126581h;
        if (r109 == null) goto L21;
        xy0.a<?> r110 = r109.g();
        if (r110 == null) goto L22;
        r110.sendJsEvent("H5_giftBannerStatusChange", GsonProtectorUtils.toJson(GsonHelper.get(), r108).toString());
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r105 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void g(e0 r110) {
        if (v.e() == false) goto L5;
        return;
    L5:
        h1 r111 = this.f126584c;
        if (r111 == null) goto L10;
        long r100 = r111.getId();
        long r101 = this.f126580g;
        if (r100 != r101) goto L10;
        e(r101);
        return;
    L10:
        h1 r112 = this.f126584c;
        if (r112 == null) goto L18;
        JsonElement r113 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), ((IGiftService) k.n(IGiftService.class)).findGiftExtraInfo(r112.getId()));
        if ((r113 instanceof JsonObject) == true) goto L15;
        r113 = null;
    L15:
        JsonObject r114 = (JsonObject) r113;
        if (r114 == null) goto L18;
        GsonMap r115 = UtilsKt.i(r114);
    L19:
        v02.b.a(0, false, new NewLynxGiftBannerView$release$1(this), 7);
        h1 r102 = this.f126584c;
        if (r102 == null) goto L123;
        String r103 = r102.getBannerScheme();
        if (r103 == null) goto L124;
        com.bytedance.android.live.revenue.core.a r104 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r104 == null) goto L28;
        yz0.k r105 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.c(r104, yz0.k.class);
        if (r105 == null) goto L28;
        IRoom r106 = r105.getRoom();
    L29:
        IBaseUser r107 = (IBaseUser) this.f126587f.get("data_user_in_room", null);
        Pair[] r108 = new Pair[11];
        String r109 = "";
        if (r106 == null) goto L33;
        String r116 = String.valueOf(r106.getId());
        if (r116 == null) goto L33;
    L34:
        r108[0] = TuplesKt.to("room_id", r116);
        if (r107 == null) goto L38;
        String r117 = r107.getIdString();
        if (r117 == null) goto L38;
    L39:
        boolean r118 = true;
        r108[1] = TuplesKt.to("user_id", r117);
        if (r107 == null) goto L44;
        Intrinsics.checkNotNullParameter(r107, "$this$secUidExt");
        String r119 = r107.getCastSecUid();
        if (r119 == null) goto L44;
    L45:
        r108[2] = TuplesKt.to("sec_user_id", r119);
        if (r106 == null) goto L49;
        String r120 = r106.getAnchorId();
        if (r120 == null) goto L49;
    L50:
        r108[3] = TuplesKt.to("anchor_id", r120);
        if (r106 == null) goto L57;
        IBaseUser r121 = r106.getOwner();
        if (r121 == null) goto L57;
        Intrinsics.checkNotNullParameter(r121, "$this$secUidExt");
        String r122 = r121.getCastSecUid();
        if (r122 == null) goto L57;
    L58:
        r108[4] = TuplesKt.to("sec_anchor_id", r122);
        h1 r123 = this.f126584c;
        if (r123 == null) goto L62;
        String r124 = String.valueOf(r123.getId());
        if (r124 == null) goto L62;
    L63:
        r108[5] = TuplesKt.to(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r124);
        h1 r125 = this.f126584c;
        if (r125 == null) goto L67;
        String r126 = String.valueOf(r125.getReqExtraType());
        if (r126 == null) goto L67;
    L68:
        r108[6] = TuplesKt.to("req_extra_type", r126);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r127 = s.c();
        if (r127 == null) goto L74;
        IBaseUser r128 = r127.f128462a;
        if (r128 == null) goto L74;
        String r129 = r128.getIdString();
        if (r129 == null) goto L74;
    L75:
        r108[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r129);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r130 = s.c();
        if (r130 == null) goto L79;
        IBaseUser r131 = r130.f128462a;
        if (r131 == null) goto L79;
    L87:
        if (r131 == null) goto L91;
        py.o r132 = r131.getOwnRoom();
        if (r132 == null) goto L91;
        List<String> r133 = r132.getRoomIdStrList();
    L92:
        if (r133 == null) goto L109;
        py.o r134 = r131.getOwnRoom();
        if (r134 == null) goto L113;
        List<String> r135 = r134.getRoomIdStrList();
        if (r135 == null) goto L113;
        if (r135.size() > 0) goto L101;
        r118 = false;
    L101:
        if (r118 == true) goto L104;
        r135 = null;
    L104:
        if (r135 == null) goto L113;
        String r136 = (String) ListProtector.get(r135, 0);
        if (r136 == null) goto L113;
        r109 = r136;
    L113:
        r108[8] = TuplesKt.to("to_room_id", r109);
        r108[9] = TuplesKt.to("enable_rev_container", String.valueOf(((Number) f.f126597b.getValue(null, f.f126596a[0])).intValue()));
        r108[10] = TuplesKt.to("source", "gift_bubble_banner");
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r137 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(getContext(), x6.a.d(d7.a.a(r103, MapsKt.mapOf(r108))), new NewLynxGiftBannerView$updateBanner$$inlined$let$lambda$1(this, r115));
        this.f126581h = r137;
        if (r137 == null) goto L125;
        h1 r138 = this.f126584c;
        if (r138 == null) goto L118;
        this.f126580g = r138.getId();
    L118:
        this.f126582a.addView((View) r137.f91463d);
        xy0.a<?> r139 = r137.g();
        if (r139 == null) goto L126;
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r139).load(null, r115);
        return;
    L126:
        return;
    L125:
        return;
    L109:
        if (r131 == null) goto L111;
        Long r140 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r131));
    L112:
        r109 = String.valueOf(r140);
        goto L113
    L111:
        r140 = null;
    L91:
        r133 = null;
    L79:
        com.bytedance.android.live.revenue.core.a r141 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r141 == null) goto L86;
        yz0.k r142 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.c(r141, yz0.k.class);
        if (r142 == null) goto L86;
        IRoom r143 = r142.getRoom();
        if (r143 == null) goto L86;
        r131 = r143.getOwner();
    L86:
        r131 = null;
    L74:
        r129 = "0";
    L67:
        r126 = "";
    L62:
        r124 = "";
    L57:
        r122 = "";
    L49:
        r120 = "";
    L44:
        r119 = "";
    L38:
        r117 = "";
    L33:
        r116 = "";
    L28:
        r106 = null;
        goto L29
    L124:
        return;
    L123:
        return;
    L18:
        r115 = null;
        goto L19
    }

    public NewLynxGiftBannerView(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100, r101, R.layout.ttlive_gift_top_lynx_banner);
    }
}
