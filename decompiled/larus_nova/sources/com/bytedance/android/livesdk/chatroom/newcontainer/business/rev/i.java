package com.bytedance.android.livesdk.chatroom.newcontainer.business.rev;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b30.c0;
import b30.d0;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.utils.i1;
import com.bytedance.android.livesdk.chatroom.widget.d2;
import com.bytedance.android.livesdk.chatroom.widget.e2;
import com.bytedance.android.livesdk.chatroom.widget.f2;
import com.bytedance.android.livesdk.config.fi0;
import com.bytedance.android.livesdk.config.x4;
import com.bytedance.android.livesdk.gift.model.GiftPage;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.p4;
import com.bytedance.android.livesdk.performance.LivePerformanceManager;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.service.PreviewClickBundle;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kc0.t;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends com.bytedance.android.livesdk.room.c<bk1.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f107529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f107530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f107531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f107532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f107533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f107534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f107535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f107536i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f107537j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f107538k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f107539l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f107540m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f107541n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f107542o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f107543p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f107544q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ik1.c f107545r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public yj1.a f107546s;

    @Override // os2.a
    public final String b() {
        return "RoomDataConst_live_room_rev_container_context";
    }

    @Override // os2.a
    public final boolean e() {
        return true;
    }

    @Override // os2.a
    public final ls2.c d() {
        return new bk1.a();
    }

    public i() {
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void i(com.bytedance.android.livesdk.room.b r110) {
        if (r110.f510509p.longValue() <= 0) goto L13;
        long r100 = System.currentTimeMillis() - r110.f510509p.longValue();
        long r101 = this.f107532e;
        this.f107532e = 0;
        r110.f510509p = 0L;
        if (r101 <= 0) goto L13;
        HashMap r102 = new HashMap();
        r102.put("duration_room", String.valueOf(r100));
        r102.put("duration_gift_effect", String.valueOf(r101));
        double r103 = r100;
        r102.put("gift_effect_live_ratio", String.valueOf((r101 * 1.0d) / r103));
        if (((Boolean) r110.f157610s.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L11;
        String r104 = "1";
    L12:
        r102.put(IPerformanceManager.Params.is_anchor, r104);
        r102.put(IPerformanceManager.Params.room_type, LivePerformanceManager.convertRoomType(this.f107545r.f490211d.getStreamType()));
        r102.put("effect_gift_duration_sum", String.valueOf(0));
        r102.put("effect_gift_live_ratio", String.valueOf((0 * 1.0d) / r103));
        u.l().sendLog("livesdk_gift_effect_show_summary", r102, new Object[]{Room.class, x.class});
        goto L13
    L11:
        r104 = "0";
    L13:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void o(com.bytedance.android.livesdk.room.b r100) {
        this.f107545r = jk1.a.c(r100);
        yj1.a r101 = jk1.a.f(r100);
        this.f107546s = r101;
        r100.c(a.class, new RoomRevService(r100, r101));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void q(final com.bytedance.android.livesdk.room.b r100) {
        ik1.c r101 = jk1.a.c(r100);
        f2 r102 = ((bk1.a) this.f526494a).f19292c;
        RoomSession r103 = r101.f490211d;
        r102.f118801b = true;
        r102.f118803d = null;
        if (r103 == null) goto L5;
        long r104 = r103.getRoomId();
    L7:
        if (r102.f118802c == false) goto L9;
    L14:
        final RoomContext r105 = jk1.b.c(r100);
        if (r100.getContext() == null) goto L21;
        r105.getLiveRoomInstance().e(new c(this, r105, r100));
        r105.getRevenueInstance().e(new d(r105));
        if (k.f(IHostGameCP.class) == null) goto L21;
        final Object r106 = ((IHostGameCP) k.f(IHostGameCP.class)).createGameCpInstance(r105.getLiveRoomInstance().getValue());
        if ((r106 instanceof xa6.d) == false) goto L21;
        r105.getGameCpInstance().e(new e(r106));
    L21:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L9:
        if (r102.f118801b == false) goto L14;
        t r107 = r102.f118800a;
        if (r107 == null) goto L14;
        r102.f118802c = true;
        r107.c(r104);
        goto L14
    L5:
        r104 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void r(com.bytedance.android.livesdk.room.b r100) {
        d2 r101 = ((bk1.a) this.f526494a).f19293d;
        if (r101 == null) goto L5;
        r101.f118773a.clear();
    L5:
        DataCenter r102 = r100.f157610s;
        if (r102 == null) goto L8;
        r102.put("data_enter_room_pop_type", "");
        this.f107537j = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void u(com.bytedance.android.livesdk.room.b r100) {
        if (this.f107545r.f490218k == true) goto L5;
        ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r100.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class)).L7(h1.class, new f(this));
    L5:
        r100.f("data_rev_enter_room_status_view_mock", new g(this));
        r100.f("cmd_video_gift_start", new h(this));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void x(com.bytedance.android.livesdk.room.b r100) {
        d2 r101 = ((bk1.a) this.f526494a).f19293d;
        if (r101 == null) goto L5;
        r101.f118773a.clear();
    L5:
        DataCenter r102 = r100.f157610s;
        if (r102 == null) goto L8;
        r102.put("data_enter_room_pop_type", "");
        this.f107537j = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final boolean z(String r100) {
        d2 r101 = ((bk1.a) this.f526494a).f19293d;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.a(r100);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void t(com.bytedance.android.livesdk.room.b r110, ts2.f r111) {
        yj1.a r100 = this.f107546s;
        r100.f568063j = ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).enterLivePlay(r110.f157610s);
        jk1.b.c(r110).getFeedRespFrom().setValue(r110.f510497d.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_RESP_FROM, ""));
        PreviewClickBundle r101 = new PreviewClickBundle();
        r101.readFromBundle(r110.f510497d, true);
        r110.f157610s.put("feed_enter_room_launch_panel", r101);
        Bundle r102 = r110.f510498e;
        if (r102 == null) goto L5;
        this.f107533f = r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_GIFT_PANEL);
        this.f107535h = r102.getString(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_GIFT_PANEL_PAGE_TYPE);
        this.f107534g = r102.getString(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_GIFT_PANEL_PANEL_TYPE);
        this.f107536i = r102.getString(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_GIFT_PANEL_GIFT_ID);
        this.f107538k = r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_PROP_PANEL);
        this.f107539l = r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_FOLLOW_GUIDE);
        this.f107540m = r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_FANS_CLUB_GUIDE);
        this.f107541n = r102.getString(ILiveRoomPlayFragmentConstant.EXTRA_FANS_CLUB_GUIDE_MSG);
        this.f107542o = r102.getString(ILiveRoomPlayFragmentConstant.EXTRA_FANS_CLUB_GUIDE_SOURCE);
        this.f107537j = r102.getString(ILiveRoomPlayFragmentConstant.ENTER_LIVE_POP_TYPE);
        this.f107543p = r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_PICK_PROFILE_PANEL);
        this.f107544q = r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_PICK_TOP);
    L5:
        r102.remove(ILiveRoomPlayFragmentConstant.ENTER_LIVE_POP_TYPE);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_FANS_CLUB_GUIDE_SOURCE);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_FANS_CLUB_GUIDE_MSG);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_FANS_CLUB_GUIDE);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_FOLLOW_GUIDE);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_GIFT_PANEL_GIFT_ID);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_GIFT_PANEL_PANEL_TYPE);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_GIFT_PANEL_PAGE_TYPE);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_GIFT_PANEL);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_PROP_PANEL);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_PICK_PROFILE_PANEL);
        r102.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_PICK_TOP);
        r110.f157610s.put("data_enter_room_pop_type", this.f107537j);
        com.bytedance.android.livesdk.sharedpref.e<String> r103 = com.bytedance.android.livesdk.sharedpref.b.M;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, "");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(final com.bytedance.android.livesdk.room.b r110, ContainerLifecycle r111, ts2.a r112) {
        if (r111 != ContainerLifecycle.ON_VIEW_CREATE) goto L74;
        this.f107530c = (ImageView) r110.f510505l.findViewById(R.id.interact_rev_feed_frame_view);
        this.f107529b = (FrameLayout) r110.f510505l.findViewById(R.id.interact_rev_feed_frame_view_stub);
        ((bk1.a) this.f526494a).f19293d = new d2(r110.f157610s, this.f107529b, this.f107530c);
        Bundle r113 = r110.f510497d;
        d2 r100 = ((bk1.a) this.f526494a).f19293d;
        boolean r101 = true;
        if (r100 == null) goto L58;
        String r102 = r113.getString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE);
        Intrinsics.checkNotNullParameter(r113, "args");
        View r114 = (View) jc1.g.a(r113, ILiveRoomPlayFragmentConstant.FEED_LIVE_REV_VIEW_STUB);
        if ((r114 instanceof qc0.f) == true) goto L10;
    L51:
        boolean r115 = false;
    L52:
        if (r115 == false) goto L58;
        if (("handleRevFeedViewFrameView roomId" + this.f107545r.f490211d) != null) goto L56;
        String r116 = "";
    L57:
        ALogger.d("RoomRevBusiness", r116);
        goto L58
    L56:
        r116 = String.valueOf(this.f107545r.f490211d.getRoomId());
        goto L57
    L10:
        if (Intrinsics.areEqual(ILiveRoomPlayFragmentConstant.ENTER_ROOM_TYPE_WITH_NO_FEED_REQUEST, r102) == false) goto L51;
        ViewParent r103 = r114.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L51;
        r100.f118774b = r114;
        ViewGroup r104 = (ViewGroup) r103;
        r100.f118775c = r104;
        r100.f118776d = r114.getLayoutParams();
        r104.removeView(r114);
        FrameLayout r105 = r100.f118778f;
        if (r105 == null) goto L16;
        r105.addView(r114);
    L16:
        fi0 r106 = fi0.f120205a;
        if (r106.getValue() == null) goto L20;
        r100.f118773a.add(Observable.timer(r106.getValue().getRemoveViewMockTimeOut(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e2(r100)));
    L20:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L22;
    L34:
        boolean r107 = r114 instanceof qc0.f;
        Object r117 = r114;
        if (r107 == true) goto L37;
        r117 = null;
    L37:
        qc0.f r118 = (qc0.f) r117;
        if (r118 == null) goto L42;
        qc0.c r119 = r118.getIPkFeedView();
        if (r119 == null) goto L42;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r120 = r119.getViewState();
    L43:
        if (r120 == null) goto L47;
        DataCenter r108 = r100.f118777e;
        if (r108 == null) goto L47;
        r108.put("data_rev_enter_room_feed_view_data", r120);
    L47:
        ILinkServiceExternal r121 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
        if (r121 == null) goto L50;
        r121.updateEnterRoomViewMock(true);
    L50:
        r115 = true;
    L42:
        r120 = null;
        goto L43
    L22:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L34;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L34;
        FrameLayout r109 = r100.f118778f;
        if (r109 == null) goto L28;
        ViewGroup.LayoutParams r122 = r109.getLayoutParams();
    L30:
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        ((ViewGroup.MarginLayoutParams) r122).topMargin = s1.A();
        FrameLayout r123 = r100.f118778f;
        if (r123 == null) goto L34;
        r123.setLayoutParams(r122);
        goto L34
    L28:
        r122 = null;
    L58:
        yj1.a r124 = jk1.a.f(r110);
        f2 r125 = ((bk1.a) this.f526494a).f19292c;
        Context r126 = r110.getContext();
        DataCenter r127 = r110.f157610s;
        RoomSession r128 = this.f107545r.f490211d;
        i1 r129 = r124.f568060g;
        String r130 = r124.f568066m;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r129, "seiHelper");
        if (r127 == null) goto L61;
        String r131 = (String) r127.get(ILiveRoomPlayFragmentConstant.INTERACT_FEED_VIEW_SEI, "");
    L62:
        r129.getClass();
        if (i1.a(r131) == false) goto L65;
        r130 = r131;
    L65:
        if (r130 != null) goto L67;
    L70:
        if (r101 == true) goto L74;
        r125.b(r126, r127, r130, r128);
        goto L74
    L67:
        if (r130.length() == 0) goto L70;
        r101 = false;
        goto L70
    L61:
        r131 = null;
    L74:
        if (r111 != ContainerLifecycle.ON_PAUSE) goto L77;
        z("pause");
    L77:
        if (r111 != ContainerLifecycle.ROOM_DISPOSE_CONTEXT) goto L84;
        f2 r132 = ((bk1.a) this.f526494a).f19292c;
        DataCenter r133 = r110.f157610s;
        r132.f118801b = false;
        t r134 = r132.f118800a;
        if (r134 == null) goto L81;
        r132.f118802c = false;
        r134.detach();
    L81:
        if (r133 == null) goto L84;
        r133.put("DATA_MULTI_REVENUE_PRELOAD_INFO", null);
    L84:
        if (r111 != ContainerLifecycle.ON_DESTROY) goto L104;
        this.f107533f = false;
        this.f107538k = false;
        this.f107539l = false;
        this.f107540m = false;
        this.f107541n = null;
        this.f107542o = null;
        f2 r135 = ((bk1.a) this.f526494a).f19292c;
        DataCenter r136 = r110.f157610s;
        if (r135.f118801b == false) goto L88;
    L89:
        r135.f118801b = false;
        r135.f118802c = false;
        t r137 = r135.f118800a;
        if (r137 == null) goto L92;
        r137.detach();
    L92:
        if (r136 == null) goto L95;
        r136.put("DATA_MULTI_REVENUE_PRELOAD_INFO", null);
    L95:
        if (x4.f121575a.getValue().booleanValue() == false) goto L102;
        d2 r138 = ((bk1.a) this.f526494a).f19293d;
        if (r138 == null) goto L99;
        r138.f118773a.clear();
    L99:
        DataCenter r139 = r110.f157610s;
        if (r139 == null) goto L102;
        r139.put("data_enter_room_pop_type", "");
        this.f107537j = null;
    L102:
        ((IGiftServiceExternal) k.f(IGiftServiceExternal.class)).removeFastGiftFromMap(this.f107545r.f490211d.getRoomId());
        z(MapMonitorConst.EVENT_DESTROY);
        ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).leaveLivePlay(this.f107546s.f568063j);
        goto L104
    L88:
        if (r135.f118802c == false) goto L92;
    L104:
        if (r111 != ContainerLifecycle.ON_BACK_PRESSED) goto L107;
        z("leave");
    L107:
        if (r111 == ContainerLifecycle.ON_VIEW_MODULE_PREPARED) goto L109;
    L170:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L109:
        if (this.f107538k == false) goto L112;
        User r140 = new User();
        r140.setUserId(this.f107545r.f490211d.getUserId());
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(0, r140);
        this.f107538k = false;
    L145:
        if (TextUtils.equals(this.f107537j, "gift_panel") == false) goto L165;
        if (TextUtils.isEmpty(this.f107536i) == false) goto L149;
        User r141 = new User();
        r141.setUserId(this.f107545r.f490211d.getUserId());
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(0, r141);
    L163:
        this.f107537j = null;
        goto L170
    L149:
        if (TextUtils.isEmpty(this.f107535h) == true) goto L153;
        int r142 = CastIntegerProtector.parseInt(this.f107535h);
    L155:
        int r143 = r142;
    L173:
        long r144 = CastLongProtector.parseLong(this.f107536i);     // Catch: Exception -> L159
    L161:
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(r143, r144, this.f107545r.f490211d.getUserId(), null, null);
        this.f107536i = "";
        this.f107535h = "";
        this.f107534g = "";
    L159:
        e = move-exception;
        e.printStackTrace();
        r144 = 0;
        goto L161
    L153:
        if (TextUtils.isEmpty(this.f107534g) == true) goto L156;
        r142 = GiftPage.convertPageTypeFromString(this.f107534g);
        goto L155
    L156:
        r143 = 0;
        goto L173
    L165:
        if (TextUtils.equals(this.f107537j, "package_panel") == false) goto L168;
        User r145 = new User();
        r145.setUserId(this.f107545r.f490211d.getUserId());
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(5, r145);
        this.f107537j = null;
        goto L170
    L168:
        if (TextUtils.equals(this.f107537j, "screen_record") == false) goto L170;
        r110.f("cmd_widget_loaded", new b(r110));
        this.f107537j = null;
        goto L170
    L112:
        if (this.f107533f == false) goto L122;
        Bundle r146 = new Bundle();
        Bundle r147 = r110.f510497d;
        if (r147 != null) goto L116;
    L120:
        User r148 = new User();
        r148.setUserId(this.f107545r.f490211d.getUserId());
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(r148, r146);
        this.f107533f = false;
        goto L145
    L116:
        if (m0.a(r147) == null) goto L120;
        if (TextUtils.isEmpty(m0.a(r110.f510497d).getString(ILiveRoomPlayFragmentConstant.EXTRA_GIFT_SHOW_FROM)) == true) goto L120;
        r146.putString("gift_show_from", m0.a(r110.f510497d).getString(ILiveRoomPlayFragmentConstant.EXTRA_GIFT_SHOW_FROM));
        goto L120
    L122:
        if (this.f107543p == false) goto L134;
        xo2.e r149 = (xo2.e) l.d().b().a(xo2.e.class);
        if (r149 != null) goto L126;
    L132:
        this.f107544q = false;
        this.f107543p = false;
        goto L145
    L126:
        if (r110.getActivity() == null) goto L132;
        in2.b r150 = r149.a(r110.getActivity(), r110.f157611t, this.f107544q);
        if (DialogLancet.shouldBlockDialogShow(r150) == false) goto L175;
        DialogLancet.handleBlockedDialogShow(r150);
        goto L132
    L175:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L172
    L131:
        DialogLancet.beforeDialogShow(r150);
        r150.show();
        DialogLancet.afterDialogShow(r150);
        goto L132
    L134:
        if (this.f107539l == false) goto L139;
        if (r110.getActivity() == null) goto L145;
        p4 r151 = new p4();
        r151.setContent(r110.getActivity().getString(R.string.ttlive_live_follow_guide_default_text));
        xs2.b.a().post(new d0(r151));
        this.f107539l = false;
        goto L145
    L139:
        if (this.f107540m == false) goto L145;
        if (TextUtils.isEmpty(this.f107541n) == true) goto L143;
        xs2.b.a().post(new c0(this.f107541n, this.f107542o));
    L143:
        this.f107540m = false;
        this.f107541n = null;
        this.f107542o = null;
        goto L145
    }
}
