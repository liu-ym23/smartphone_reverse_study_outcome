package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.watchcard.replay;

import am2.a0;
import am2.b0;
import android.net.Uri;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.k;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.o;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import j40.p4;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nm1.h;
import pm1.f;

/* JADX INFO: loaded from: classes11.dex */
public class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f160536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f160537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f160538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f160539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f160540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f160541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f160542g;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.k
    public final void reset() {
        this.f160539d = false;
        Disposable r100 = this.f160540e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f160541f;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public final pu2.e d() {
        return (pu2.e) g.b(this.f160542g).w1(pu2.e.class);
    }

    public Map<String, String> g() {
        HashMap r100 = new HashMap();
        h r101 = f.f();
        if (r101 == null) goto L7;
        Map<String, String> r102 = r101.d(getDataCenter(), a0.class);
        if (r102 == null) goto L7;
        r100.putAll(r102);
    L7:
        h r103 = f.f();
        if (r103 == null) goto L12;
        Map<String, String> r104 = r103.d(getDataCenter(), b0.class);
        if (r104 == null) goto L12;
        r100.putAll(r104);
    L12:
        Episode r105 = this.f160542g.D().getEpisode().invoke();
        if (r105 == null) goto L15;
        r100.put("room_id", String.valueOf(r105.roomId));
        r100.put("anchor_id", EpisodeExtKt.getOwnerIdString(r105));
        r100.put(PaidReplayConstants.KEY_FROM_CONTENT_ID, String.valueOf(r105.getId()));
        r100.put("from_author_id", EpisodeExtKt.getOwnerIdString(r105));
    L15:
        r100.put(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, PaidReplayConstants.VALUE_FROM_CONTENT_TYPE);
        ReplayPaidInfo r106 = f();
        String r107 = "0";
        if (r106 == null) goto L19;
        String r108 = String.valueOf(r106.getPaidType());
        if (r108 == null) goto L19;
    L20:
        r100.put("paid_replay_type", r108);
        ReplayPaidInfo r109 = f();
        if (r109 == null) goto L24;
        String r110 = String.valueOf(r109.getViewRight());
        if (r110 == null) goto L24;
    L25:
        r100.put("view_right", r110);
        int r111 = a.f160533a[this.f160542g.i0().ordinal()];
        if (r111 != 1) goto L28;
        r100.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, "paidlive_try_buyticket_card");
    L102:
        r100.putAll(g.d(getDataCenter()).z1(this.f160542g.i0()));
        l r112 = this.f160542g.l().getCurrentState().getValue();
        r112.getClass();
        if ((r112 instanceof l.f) == true) goto L105;
        r107 = "1";
    L105:
        r100.put("is_finished", r107);
        return r100;
    L28:
        if (r111 == 2) goto L67;
        String r113 = "";
        if (r111 != 3) goto L32;
        r100.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, "live_machine_go_buy_card");
        r100.put("ticket_buy_state", "2");
        IMainEpisode r114 = c();
        if (r114 == null) goto L66;
        Map<Integer, PrivilegeInfo> r115 = r114.getPrivilegeInfo();
        if (r115 == null) goto L66;
        PrivilegeInfo r116 = r115.get(6);
        if (r116 == null) goto L66;
        String r117 = r116.getItemIdsForTeaLog();
        if (r117 == null) goto L66;
        r113 = r117;
    L66:
        r100.put("vs_privilege_id", r113);
        r100.put(PaidReplayConstants.KEY_PRIVILEGE_TYPE, String.valueOf(6));
        goto L102
    L32:
        if (r111 != 4) goto L102;
        r100.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, "clarity_try_go_buy_card");
        if (p4.f497283a.getValue().a() == false) goto L37;
        Object r118 = "1";
    L38:
        r100.put(PaidReplayConstants.KEY_RESOLUTION_FREE_TRIAL, r118);
        com.bytedance.android.livesdk.vscore_api.paidlive.e r119 = g.d(this.f160542g.D().getDataCenter()).E1(this.f160542g.i0());
        if (r119 == null) goto L44;
        o r120 = (o) r119.getAbility(o.class);
        if (r120 == null) goto L44;
        String r121 = r120.y1();
        if (r121 == null) goto L44;
    L45:
        r100.put(PaidReplayConstants.KEY_RESOLUTION_INFO, r121);
        r100.put("ticket_buy_state", "2");
        IMainEpisode r122 = c();
        if (r122 == null) goto L55;
        Map<Integer, PrivilegeInfo> r123 = r122.getPrivilegeInfo();
        if (r123 == null) goto L55;
        PrivilegeInfo r124 = r123.get(6);
        if (r124 == null) goto L55;
        String r125 = r124.getItemIdsForTeaLog();
        if (r125 == null) goto L55;
        r113 = r125;
    L55:
        r100.put("vs_privilege_id", r113);
        r100.put(PaidReplayConstants.KEY_PRIVILEGE_TYPE, String.valueOf(4));
    L44:
        r121 = "";
        goto L45
    L37:
        r118 = "0";
        goto L38
    L67:
        r100.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, "live_machine_go_buy_card");
        Episode r126 = getEpisode();
        Long r127 = null;
        if (r126 == null) goto L72;
        EpisodeBasicInfo r128 = r126.episodeBasicInfo;
        if (r128 == null) goto L72;
        Long r129 = Long.valueOf(r128.getReplayCameraId());
    L73:
        r100.put("vs_machine_id", String.valueOf(r129));
        Episode r130 = getEpisode();
        if (r130 == null) goto L78;
        EpisodeBasicInfo r131 = r130.episodeBasicInfo;
        if (r131 == null) goto L78;
        Long r132 = Long.valueOf(r131.getReplayCameraId());
    L79:
        Episode r133 = getEpisode();
        if (r133 == null) goto L84;
        EpisodeBasicInfo r134 = r133.episodeBasicInfo;
        if (r134 == null) goto L84;
        Long r135 = Long.valueOf(r134.getOriginEpisodeId());
    L86:
        if (Intrinsics.areEqual(r132, r135) == false) goto L88;
        String r136 = "major";
    L89:
        r100.put(PaidReplayConstants.KEY_VS_MACHINE_TYPE, r136);
        Episode r137 = getEpisode();
        if (r137 == null) goto L92;
        String r138 = r137.title;
    L93:
        r100.put("vs_machine_title", String.valueOf(r138));
        ReplayPaidInfo r139 = f();
        if (r139 == null) goto L100;
        TicketData r140 = r139.getTicketData();
        if (r140 == null) goto L100;
        String r141 = r140.getPrice();
        if (r141 == null) goto L100;
        r127 = Long.valueOf((long) (CastFloatProtector.parseFloat(r141) * 100));
    L100:
        r100.put("pay_num", String.valueOf(r127));
        goto L102
    L92:
        r138 = null;
        goto L93
    L88:
        r136 = "others";
    L84:
        r135 = null;
    L78:
        r132 = null;
    L72:
        r129 = null;
    L24:
        r110 = "0";
    L19:
        r108 = "0";
        goto L20
    }

    public final DataCenter getDataCenter() {
        return this.f160542g.D().getDataCenter();
    }

    public final Episode getEpisode() {
        return this.f160542g.D().getEpisode().invoke();
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.k
    public final String x3() {
        String r100 = this.f160537b;
        boolean r101 = false;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L13;
        ReplayPaidInfo r103 = f();
        if (r103 == null) goto L12;
        TicketData r104 = r103.getTicketData();
        if (r104 == null) goto L12;
        r100 = r104.getPaidConversionJumpUrl();
    L12:
        r100 = null;
    L13:
        if (r100 == null) goto L28;
        h("load paid conversion card paidRoomConversionJumpUrl = ".concat(r100));
        Map<String, String> r105 = g();
        Uri r106 = UriProtector.parse(r100);
        String r107 = UriProtector.getQueryParameter(r106, "url");
        if (r107 != null) goto L17;
    L18:
        r101 = true;
    L19:
        if (r101 == false) goto L23;
        String r108 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.a(r100, r105);
        if (r108 == null) goto L27;
        r106 = UriProtector.parse(r108);
    L27:
        return r106.toString();
    L23:
        String r109 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.a(UriProtector.getQueryParameter(r106, "url"), r105);
        if (r109 == null) goto L27;
        r106 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.f(r106, r109);
        goto L27
    L17:
        if (r107.length() != 0) goto L19;
    L28:
        h("paid conversion card url is empty");
        return "";
    L5:
        r102 = false;
        goto L6
    }

    public final IMainEpisode c() {
        Episode r100 = getEpisode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (IMainEpisode) r100.castToOrNull(IMainEpisode.class);
    }

    public final ReplayPaidInfo f() {
        IMainEpisode r100 = c();
        if (r100 == null) goto L7;
        ReplayPaidInfo r101 = r100.getReplayPaidInfo();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.f160542g.D().getReplayPaidInfo();
    }

    public String a() {
        return this.f160536a;
    }

    public d(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "attachScene");
        this.f160542g = r100;
        this.f160536a = "PaidReplayRoomTempWatchCard[" + hashCode() + ']';
        this.f160537b = "";
        this.f160538c = "ticket_open_panel_portrait";
        nm1.e r101 = f.c();
        if (r101 == null) goto L14;
        ReplayDataContext r102 = r101.h(getDataCenter());
        if (r102 == null) goto L15;
        m<Boolean> r103 = r102.isPortrait();
        if (r103 == null) goto L16;
        Observable<Boolean> r104 = r103.a();
        if (r104 == null) goto L17;
        ObservableSubscribeProxy r105 = (ObservableSubscribeProxy) r104.as(AutoDispose.bind(r100.D().g()));
        if (r105 == null) goto L18;
        r105.subscribe(new c(this));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.k
    public final void C0(long r100) {
        if (this.f160539d == false) goto L8;
        pu2.e r101 = d();
        if (r101 == null) goto L9;
        r101.ak(this.f160542g.i0(), r100);
        return;
    L9:
        return;
    }

    public final void h(String r100) {
        ALogger.d(a(), " " + r100);
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.k
    public final void jb(boolean r100) {
        if (r100 == false) goto L18;
        long r101 = this.f160542g.l().getPaidTempWatchRemainTime().getValue().getThird().longValue();
        l r102 = this.f160542g.l().getCurrentState().getValue();
        r102.getClass();
        if ((r102 instanceof l.f) == true) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L13;
        return;
    L13:
        if (d() == null) goto L18;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r104 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.m) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.m.class)).o(getDataCenter()) == true) goto L18;
        h("updateCardVisiblity: canShowTicketCard != true, return");
        return;
    L7:
        if (r101 <= 2) goto L9;
        r103 = true;
    L18:
        pu2.e r105 = d();
        if (r105 != null) goto L21;
    L26:
        if (r100 == true) goto L28;
    L38:
        pu2.e r106 = d();
        if (r106 == null) goto L42;
        r106.Fe(this.f160542g.i0(), r100);
        return;
    L42:
        return;
    L28:
        if (this.f160539d == true) goto L38;
        pu2.e r107 = d();
        if (r107 == null) goto L38;
        r107.ba(this.f160542g.i0(), this);
        Disposable r108 = this.f160541f;
        if (r108 == null) goto L34;
        r108.dispose();
    L34:
        this.f160541f = ((ObservableSubscribeProxy) ((IBrowserService) jc1.k.n(IBrowserService.class)).registerJsEventSubscriber(this.f160538c).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.f160542g.D().g()))).subscribe(new b(this));
        Disposable r109 = this.f160540e;
        if (r109 == null) goto L37;
        r109.dispose();
    L37:
        this.f160540e = RxUtilKt.n(MatchRoomLandScapeAnimUtil.f82835d.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()), new PaidReplayRoomTempWatchCard$registerMatchLandAnimChange$1(this));
        this.f160539d = true;
        goto L38
    L21:
        if (r100 != r105.Mp(this.f160542g.i0())) goto L26;
        if (this.f160539d == false) goto L26;
        h("updateCardVisiblity same visiblity:" + r100 + ", skip");
    }
}
