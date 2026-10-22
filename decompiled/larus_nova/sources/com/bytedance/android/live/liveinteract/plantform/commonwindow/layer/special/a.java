package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.h;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f75742n = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f75743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PositionNameTv f75744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b f75745k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f75746l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m f75747m;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.a$a, reason: collision with other inner class name */
    public static final class C1185a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e
    public final void r() {
    }

    @Override // jg0.c
    public final int o() {
        MicSeatScene r100 = this.f498952b;
        int r101 = b.f75748a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return R.layout.ttlive_layer_multilink_audio_common_special_stub;
    L5:
        if (r101 != 2) goto L7;
        return R.layout.ttlive_layer_multilink_audio_common_special_stub_large;
    L7:
        if (r101 == 3) goto L9;
        return 0;
    L9:
        return R.layout.ttlive_layer_multilink_audio_enlarge_stage_special_stub;
    }

    public final void v() {
        boolean r100 = gh0.b.f481244a;
        StringBuilder r101 = new StringBuilder("updateEmptySeatPositionName, isShowFromFullScreenAll = ");
        MultiLinkSpecialViewBinder.a r102 = this.f75750e;
        int r103 = -1;
        if (r102 == null) goto L5;
        int r104 = r102.f545688d;
    L6:
        r101.append(h.f(r104));
        r101.append(", positionNameItem = ");
        MultiLinkSpecialViewBinder.a r105 = this.f75750e;
        LinkmicPositionItem r106 = null;
        if (r105 == null) goto L9;
        LinkmicPositionItem r107 = r105.f75987m;
    L10:
        r101.append(r107);
        r101.append(", positionNameTv = ");
        r101.append(this.f75744j);
        gh0.b.a("AudioSpecialLayer", r101.toString(), false);
        MultiLinkSpecialViewBinder.a r108 = this.f75750e;
        if (r108 == null) goto L14;
        r103 = r108.f545688d;
    L14:
        if (h.f(r103) == true) goto L16;
        return;
    L16:
        PositionNameTv r109 = this.f75744j;
        if (r109 == null) goto L38;
        MultiLinkSpecialViewBinder.a r110 = this.f75750e;
        if (r110 == null) goto L21;
        r106 = r110.f75987m;
    L21:
        LinkmicPositionItem r111 = r106;
        boolean r112 = gh0.a.d();
        MultiLinkSpecialViewBinder.a r113 = this.f75750e;
        if (r113 == null) goto L24;
        int r114 = r113.f545690f;
    L25:
        if (r113 == null) goto L28;
        List<Integer> r115 = r113.f545691g;
        if (r115 == null) goto L28;
    L29:
        List<Integer> r116 = r115;
        MultiLinkSpecialViewBinder.a r117 = this.f75750e;
        if (r117 == null) goto L32;
        int r118 = r117.f545688d;
    L33:
        if (r118 <= 0) goto L35;
        boolean r119 = true;
    L36:
        PositionNameTv.y(r109, r111, r112, r114, r116, r119);
        return;
    L35:
        r119 = false;
        goto L36
    L32:
        r118 = 0;
    L28:
        r115 = CollectionsKt.emptyList();
        goto L29
    L24:
        r114 = 0;
        goto L25
    L38:
        return;
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = -1;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e, jg0.c, jg0.f
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.a(r100);
        this.f75745k = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b((ImageView) q().findViewById(R.id.ttlive_lock), (TextView) q().findViewById(R.id.ttlive_empty_tips), null, 0, true);
    }

    public final void u(MultiLinkSpecialViewBinder.a r100) {
        if (this.f498952b != MicSeatScene.AUDIO_LINK_LARGE) goto L44;
        if (TeamFightContext.Companion.h() == false) goto L26;
        if (li0.d.g(null) == false) goto L26;
        Integer r101 = this.f75746l;
        if (r101 == null) goto L26;
        if (r100.f75988n == false) goto L15;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r102 = this.f75745k;
        if (r102 == null) goto L65;
        r102.g(s1.B(R.string.ttlive_team_fight_invite_fight));
    L65:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r103 = this.f75745k;
        if (r103 == null) goto L71;
        String r104 = r103.c();
        if (r104 == null) goto L72;
        r3.c(q(), r104, true);
        return;
    L72:
        return;
    L71:
        return;
    L15:
        Intrinsics.checkNotNull(r101);
        int r105 = li0.d.b(r101.intValue());
        if (r105 != 1) goto L21;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r106 = this.f75745k;
        if (r106 == null) goto L65;
        r106.g(s1.B(R.string.ttlive_live_video_join_red_fight));
        goto L65
    L21:
        if (r105 != 2) goto L65;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r107 = this.f75745k;
        if (r107 == null) goto L65;
        r107.g(s1.B(R.string.ttlive_live_video_join_blue_fight));
    L26:
        if (gh0.a.d() == true) goto L33;
        com.bytedance.android.live.liveinteract.api.data.a.f71432h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.a().f71435c == false) goto L33;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r108 = this.f75745k;
        if (r108 == null) goto L65;
        r108.g(s1.B(R.string.ttlive_live_radio_interact_paid_link));
    L33:
        if (r100.f75988n == false) goto L35;
    L40:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r109 = this.f75745k;
        if (r109 == null) goto L65;
        r109.g(s1.B(R.string.ttlive_live_radio_interact_invite_chat));
        goto L65
    L35:
        if (je0.d.D() == true) goto L40;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r110 = this.f75745k;
        if (r110 == null) goto L65;
        r110.g(s1.B(R.string.ttlive_live_radio_interact_waiting));
        goto L65
    L44:
        if (gh0.a.d() == true) goto L51;
        com.bytedance.android.live.liveinteract.api.data.a.f71432h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.a().f71435c == false) goto L51;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r111 = this.f75745k;
        if (r111 == null) goto L65;
        r111.g(s1.B(R.string.ttlive_live_radio_interact_paid_link));
    L51:
        if (r100.f75988n == false) goto L55;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r112 = this.f75745k;
        if (r112 == null) goto L65;
        r112.g(s1.B(R.string.ttlive_live_radio_interact_invite_link));
        goto L65
    L55:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r113 = MultiRevenueDataContext.a.a();
        if (r113 != null) goto L58;
    L62:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r114 = this.f75745k;
        if (r114 == null) goto L65;
        r114.g(s1.B(R.string.ttlive_live_radio_interact_waiting));
        goto L65
    L58:
        if (r113.isGameShowing() != true) goto L62;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r115 = this.f75745k;
        if (r115 == null) goto L65;
        r115.g(s1.B(R.string.ttlive_guest_battle_interact_join_battle));
        goto L65
    }

    @Override // jg0.f
    public final void d(Object r100, int r101) {
        MultiLinkSpecialViewBinder.a r102 = (MultiLinkSpecialViewBinder.a) r100;
        Intrinsics.checkNotNullParameter(r102, "itemData");
        super.s(r102);
        this.f75746l = Integer.valueOf(r101);
        this.f75743i = q().findViewById(R.id.ttlive_empty_content);
        PositionNameTv r103 = (PositionNameTv) q().findViewById(R.id.ttlive_position_name);
        this.f75744j = r103;
        if (r103 == null) goto L10;
        xg0.a r104 = this.f498953c;
        if (r104 == null) goto L7;
        DataCenter r105 = r104.getDataCenter();
    L8:
        r103.setDataCenter(r105);
        goto L10
    L7:
        r105 = null;
    L10:
        if (n() != 0) goto L12;
        q().setOnClickListener(x0.a(new MultiLinkAudioCommonSpecialMicSeatBasicLayer$onBind$1(this)));
    L12:
        v();
        if (je0.d.D() == false) goto L22;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r106 = this.f75745k;
        if (r106 == null) goto L17;
        r106.g(s1.B(R.string.ttlive_live_radio_interact_invite_chat));
    L17:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r107 = this.f75745k;
        if (r107 == null) goto L27;
        String r108 = r107.c();
        if (r108 == null) goto L27;
        r3.c(q(), r108, true);
    L27:
        if (((IInteractService) k.n(IInteractService.class)).isVoiceMultiEnlargeSeat(this.f75747m.getUiLayout(), r101) == false) goto L33;
        View r109 = this.f75743i;
        if (r109 == null) goto L39;
        ViewTreeObserver r110 = r109.getViewTreeObserver();
        if (r110 == null) goto L40;
        r110.addOnGlobalLayoutListener(new c(this));
        return;
    L40:
        return;
    L39:
        return;
    L33:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r111 = this.f75745k;
        if (r111 == null) goto L42;
        TextView r112 = r111.f75678k;
        if (r112 == null) goto L43;
        r112.setTranslationY(0.0f);
        return;
    L43:
        return;
    L42:
        return;
    L22:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r113 = this.f75745k;
        if (r113 == null) goto L25;
        r113.e(0);
    L25:
        u(r102);
        goto L27
    }

    public a(MicSeatScene r100, m r101, xg0.a r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "layoutConfig");
        Intrinsics.checkNotNullParameter(r102, "linkSeatAbilityProvider");
        super(r100, r102);
        this.f75747m = r101;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r100, int r101, Bundle r102) {
        t((MultiLinkSpecialViewBinder.a) r100, r101, r102);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e
    public final void t(MultiLinkSpecialViewBinder.a r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        super.t(r100, r101, r102);
        this.f75746l = Integer.valueOf(r101);
        Iterator<String> r103 = r102.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();
        if (r104 == null) goto L4;
        int r105 = r104.hashCode();
        if (r105 != 817798352) goto L11;
        if (r104.equals("payload_key_position_item_update") == false) goto L4;
        v();
        goto L4
    L11:
        if (r105 != 1074297423) goto L4;
        if (r104.equals("payload_key_interact_state_update") == false) goto L4;
        u(r100);
        goto L4
    L19:
        v();
    }
}
