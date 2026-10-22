package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket;

import am2.n;
import am2.x;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.qk;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.AutoFallbackHybridComponentContainer;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f160497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AutoFallbackHybridComponentContainer f160498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f160499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f160500d;

    public interface a {
        void Lj(qk r100);

        void jb(qk r100);
    }

    public e(DataCenter r110, qk r111, View r112, PaidLiveTicketSaleCardWidget r113) {
        Intrinsics.checkNotNullParameter(r111, "cardInfo");
        Intrinsics.checkNotNullParameter(r112, "cardView");
        this.f160499c = r112;
        this.f160500d = r113;
        View r114 = r112.findViewById(R.id.iv_close_card);
        this.f160497a = r114;
        AutoFallbackHybridComponentContainer r115 = (AutoFallbackHybridComponentContainer) r112.findViewById(R.id.hybrid_container);
        this.f160498b = r115;
        if (r114 == null) goto L5;
        r114.setOnClickListener(new c(this, r111));
    L5:
        if (r115 == null) goto L8;
        r115.setListener(new d(this, r111));
    L8:
        if (r110 == null) goto L10;
        Room r100 = (Room) r110.get("data_room", null);
    L11:
        Pair[] r101 = new Pair[12];
        Map<String, String> r102 = u.l().c(x.class).getMap();
        String r103 = n.f().c();
        if (r103 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        String r105 = "";
        if (r104 == false) goto L21;
    L29:
        String r106 = r102.get("enter_from_merge");
        if (r106 != null) goto L32;
    L31:
        r106 = "";
    L32:
        r101[0] = TuplesKt.to("enter_from_merge", r106);
        r101[1] = TuplesKt.to("enter_method", l0.a("enter_method", u.l().c(x.class)));
        r101[2] = TuplesKt.to("action_type", l0.a("action_type", u.l().c(x.class)));
        if (r100 == null) goto L36;
        String r107 = String.valueOf(r100.getRoomId());
        if (r107 == null) goto L36;
    L37:
        r101[3] = TuplesKt.to("room_id", r107);
        if (r100 == null) goto L41;
        String r108 = r100.getOwnerUserIdString();
        if (r108 == null) goto L41;
    L42:
        r101[4] = TuplesKt.to("anchor_id", r108);
        if (r100 == null) goto L46;
        String r109 = String.valueOf(r100.getRoomId());
        if (r109 == null) goto L46;
    L47:
        r101[5] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_ID, r109);
        if (r100 == null) goto L53;
        String r116 = r100.getOwnerUserIdString();
        if (r116 == null) goto L53;
        r105 = r116;
    L53:
        r101[6] = TuplesKt.to("from_author_id", r105);
        r101[7] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, "live");
        String r117 = "1";
        r101[8] = TuplesKt.to("is_carry_paidlive", "1");
        RoomContext r118 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r118 == null) goto L60;
        m<Boolean> r119 = r118.isCleanMode();
        if (r119 == null) goto L60;
        if (r119.getValue().booleanValue() != true) goto L60;
        Object r120 = "1";
    L61:
        r101[9] = TuplesKt.to("if_clear_mode", r120);
        if (g.d(r110).isPaidLive() == true) goto L65;
        r117 = "0";
    L65:
        r101[10] = TuplesKt.to("is_paidlive", r117);
        r101[11] = TuplesKt.to("live_reason", l0.a("live_reason", u.l().c(x.class)));
        Map<String, String> r121 = MapsKt.mutableMapOf(r101);
        s.g().x(r110, r121);
        PaidSceneContext r122 = g.d(r110).u1(PaidSceneEnum.PAID_ROOM);
        if (r122 == null) goto L70;
        Map<String, String> r123 = r122.getCommonExtraMap();
        if (r123 == null) goto L70;
        r121.putAll(r123);
    L70:
        if (r115 == null) goto L72;
        r115.setParams(r121);
    L72:
        if (r115 == null) goto L75;
        r115.loadUrl(r111.getCardUrl());
        return;
    L75:
        return;
    L60:
        r120 = "0";
    L46:
        r109 = "";
    L41:
        r108 = "";
    L36:
        r107 = "";
        goto L37
    L21:
        if (r102.containsKey("enter_from_ad_type") == false) goto L29;
        if (TextUtils.isEmpty(r102.get("enter_from_ad_type")) == true) goto L29;
        r106 = r102.get("enter_from_ad_type");
        if (r106 != null) goto L27;
        r106 = r102.get("enter_from_merge");
    L27:
        if (r106 != null) goto L32;
    L14:
        if (r103.length() == 0) goto L17;
        r104 = false;
        goto L18
    L10:
        r100 = null;
        goto L11
    }
}
