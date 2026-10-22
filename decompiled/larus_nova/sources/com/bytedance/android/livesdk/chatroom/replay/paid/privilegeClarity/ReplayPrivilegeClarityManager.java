package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import am2.a0;
import am2.b0;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdk.chatroom.replay.play.ReplayPlayFragment;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayPaidApi;
import com.bytedance.android.livesdk.chatroom.vs_base.base.paid.PrivilegeClarityEventHub;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.element.AbsReplayPlayerWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayOrientationControlUIState;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeBaseInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeClarityExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeUrl;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fq1.t;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import j40.p4;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mq1.e0;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayPrivilegeClarityManager implements kq1.c, e0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f109391v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f109392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f109393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f109394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f109395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Episode f109396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f109397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f109398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f109399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f109400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f109401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f109402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f109403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f109404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f109405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f109406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.a f109407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e f109408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PrivilegeClarityEventHub f109409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.session.video.h f109410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Context f109411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public h80.d<AbsReplayPlayerWidget> f109412u;

    public static final class a {
    }

    static {
    }

    public final PrivilegeClarityExtraInfo f() {
        return (PrivilegeClarityExtraInfo) this.f109401j.getValue();
    }

    @Override // mq1.e0
    public final void qj() {
    }

    @Override // kq1.c
    public final void b() {
        this.f109409r.f117901b.setValue("");
        this.f109409r.f117902c.setValue("");
        this.f109409r.f117900a.setValue(PrivilegeClarityEventHub.State.NONE);
        mq1.p r100 = s.e().a(this.f109410s.f118151y);
        if (r100 == null) goto L5;
        r100.unregisterReplaySwitchListener(this);
    L5:
        Disposable r101 = this.f109394c;
        if (r101 != null) goto L8;
    L9:
        Disposable r102 = this.f109394c;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        Disposable r103 = this.f109395d;
        if (r103 != null) goto L15;
    L16:
        Disposable r104 = this.f109395d;
        if (r104 == null) goto L19;
        r104.dispose();
    L19:
        this.f109412u = null;
        return;
    L15:
        if (r103.isDisposed() == true) goto L19;
    L8:
        if (r101.isDisposed() == true) goto L12;
        goto L9
    }

    public final PrivilegeInfo g() {
        Episode r100 = this.f109396e;
        if (r100 == null) goto L9;
        IMainEpisode r101 = (IMainEpisode) r100.castToOrNull(IMainEpisode.class);
        if (r101 == null) goto L9;
        Map<Integer, PrivilegeInfo> r102 = r101.getPrivilegeInfo();
        if (r102 == null) goto L9;
        return r102.get(4);
    L9:
        return null;
    }

    public final Map<String, String> h() {
        Episode r100 = this.f109396e;
        if (r100 == null) goto L5;
        Pair[] r101 = new Pair[8];
        r101[0] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, PaidReplayConstants.VALUE_FROM_CONTENT_TYPE);
        String r102 = String.valueOf(Long.valueOf(r100.getId()).longValue());
        String r103 = "";
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r101[1] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_ID, r102);
        String r104 = EpisodeExtKt.getOwnerIdString(r100);
        if (r104 == null) goto L13;
        r103 = r104;
    L13:
        r101[2] = TuplesKt.to("from_author_id", r103);
        r101[3] = TuplesKt.to(PaidReplayConstants.KEY_PRIVILEGE_TYPE, String.valueOf(4));
        String r105 = "1";
        r101[4] = TuplesKt.to("is_creator_anchor", "1");
        r101[5] = TuplesKt.to("action_type", "click");
        if (p4.f497283a.getValue().a() == true) goto L17;
        r105 = "0";
    L17:
        r101[6] = TuplesKt.to(PaidReplayConstants.KEY_RESOLUTION_FREE_TRIAL, r105);
        r101[7] = TuplesKt.to(PaidReplayConstants.KEY_RESOLUTION_INFO, y1());
        return MapsKt.mutableMapOf(r101);
    L5:
        return new LinkedHashMap();
    }

    public final void k() {
        com.bytedance.android.livesdk.chatroom.vs_base.log.d r100 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f109410s.f118151y);
        Map<String, String> r101 = h();
        r101.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, PaidReplayConstants.VALUE_BUY_TICKET_CAMERA_PLAYER_TIP);
        r101.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, this.f109406o);
        Unit r102 = Unit.INSTANCE;
        r100.e("livesdk_clarity_buyticket_module_show", r101, new Object[0]);
    }

    public final void l() {
        this.f109407p.a();
        this.f109409r.f117900a.setValue(PrivilegeClarityEventHub.State.NONE);
        this.f109402k = false;
        this.f109410s.f118151y.removeObserver((Observer) this.f109400i.getValue());
    }

    public final void m() {
        ReplayPrivilegeClarityManager$tryDelivery$1 r100 = ReplayPrivilegeClarityManager$tryDelivery$1.INSTANCE;
        ReplayPrivilegeClarityManager$tryDelivery$2 r101 = ReplayPrivilegeClarityManager$tryDelivery$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "successAction");
        Intrinsics.checkNotNullParameter(r101, "errorCallback");
        PrivilegeInfo r102 = g();
        if (r102 == null) goto L5;
        long r103 = r102.entityid;
    L6:
        long r110 = r103;
        p.a("request ping , id = " + r110 + " type : 6");
        this.f109397f = ReplayPaidApi.a.a((ReplayPaidApi) this.f109398g.getValue(), String.valueOf(r110), 6, System.currentTimeMillis() / ((long) 1000), 4, r110, 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r100, r101), new i(r101));
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void n() {
        if (this.f109404m == true) goto L5;
        return;
    L5:
        if (this.f109403l == true) goto L7;
        return;
    L7:
        if (this.f109405n == true) goto L57;
        boolean r100 = true;
        this.f109405n = true;
        Episode r101 = this.f109396e;
        if (r101 == null) goto L14;
        IMainEpisode r102 = (IMainEpisode) r101.castToOrNull(IMainEpisode.class);
        if (r102 == null) goto L14;
        if (r102.isPaidReplay() == true) goto L14;
    L22:
        boolean r103 = true;
    L24:
        if (r103 == true) goto L28;
        p.a("cur video not available");
        return;
    L28:
        if (i() == false) goto L31;
        p.a("already has clarity view right");
        return;
    L31:
        Episode r104 = this.f109396e;
        if (r104 == null) goto L42;
        String r105 = String.valueOf(r104.getId());
        PrivilegeInfo r106 = g();
        if (r106 == null) goto L42;
        String r107 = String.valueOf(r106.entityid);
        if (r107 == null) goto L42;
        if (((Map) ((com.bytedance.android.livesdk.sharedpref.e) this.f109393b.getValue()).getValue()).get(r105 + r107) != null) goto L42;
    L43:
        if (r100 == true) goto L47;
        p.a("frequency check failed already showed before");
        return;
    L47:
        if (this.f109408q.c() == true) goto L49;
        return;
    L49:
        com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.a r108 = this.f109407p;
        Integer r109 = f().getPriorTime();
        if (r109 == null) goto L52;
        int r110 = r109.intValue();
    L53:
        r108.c(r110, this.f109410s, new ReplayPrivilegeClarityManager$tryStart$1(this));
        return;
    L52:
        r110 = 10;
    L42:
        r100 = false;
    L14:
        Episode r111 = this.f109396e;
        if (r111 == null) goto L23;
        IMainEpisode r112 = (IMainEpisode) r111.castToOrNull(IMainEpisode.class);
        if (r112 == null) goto L23;
        ReplayPaidInfo r113 = r112.getReplayPaidInfo();
        if (r113 == null) goto L23;
        if (r113.isDelivery() == true) goto L22;
    L23:
        r103 = false;
        goto L24
    }

    @Override // kq1.c
    public final String y1() {
        return this.f109408q.d();
    }

    @Override // kq1.c
    public final Map<String, String> d() {
        PrivilegeInfo r100 = g();
        if (r100 != null) goto L5;
        return null;
    L5:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("vs_privilege_id", r100.getItemIdsForTeaLog()), TuplesKt.to(PaidReplayConstants.KEY_TICKET_ENTRANCE, "clarity_panel")});
    }

    public final boolean i() {
        PrivilegeInfo r100 = g();
        if (r100 == null) goto L10;
        PrivilegeBaseInfo r101 = r100.paidLiveInfo;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.viewRight == 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // kq1.c
    public final PrivilegeClarityEventHub getEventHub() {
        return this.f109409r;
    }

    @Override // mq1.e0
    public final void FY(tq1.g r100) {
        this.f109407p.a();
        l();
        Episode r101 = r100.f547123a;
        if (r101 == null) goto L6;
        e(r101);
        return;
    }

    public final void e(Episode r100) {
        p.a("bind episode");
        this.f109396e = r100;
        if (g() == null) goto L11;
        PrivilegeClarityExtraInfo r101 = f();
        if (r101 == null) goto L7;
        String r102 = r101.getSdkKey();
    L8:
        if (r102 == null) goto L11;
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        return;
    L14:
        PrivilegeClarityExtraInfo r104 = f();
        p.a("init extra info definition = " + r104.getDefinition());
        if (r104.getSdkKey() == null) goto L20;
        e r105 = this.f109408q;
        String r106 = f().getDefinition();
        if (r106 != null) goto L19;
        r106 = "4k";
    L19:
        r105.b(r106, r100);
    L20:
        this.f109403l = true;
        n();
        this.f109394c = fq1.f.a().registerJsEventSubscriber("ticket_has_paid").observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), new k(this));
        this.f109395d = fq1.f.a().registerJsEventSubscriber("ticket_buy_success").observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this), m.f109453a);
        return;
    L7:
        r102 = null;
    L11:
        r103 = true;
        goto L12
    }

    public final void j(String r100) {
        p.a(r100);
    }

    @Override // kq1.c
    public final void a(final String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        Intrinsics.checkNotNullParameter(r101, "onViewRight");
        boolean r102 = true;
        if (i() == false) goto L15;
        PrivilegeInfo r103 = g();
        if (r103 == null) goto L12;
        PrivilegeBaseInfo r104 = r103.paidLiveInfo;
        if (r104 == null) goto L12;
        if (r104.delivery != 0) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L14;
        r101.invoke();
        return;
    L14:
        m();
        return;
    L15:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r105 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.m) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.m.class)).p() == true) goto L20;
        Context r106 = this.f109411t;
        if (r106 == null) goto L24;
        ReplayOrientationControlUIState r107 = (ReplayOrientationControlUIState) ReplayRoomFragmentScopeUtil.a(ReplayOrientationControlUIState.class);
        Boolean r108 = Boolean.FALSE;
        DataCenter r109 = this.f109410s.f118151y;
        Function1<Boolean, Unit> r110 = new ReplayPrivilegeClarityManager$checkPrivilegeClarity$$inlined$let$lambda$1(this, r100);
        r107.getClass();
        ReplayOrientationControlUIState.p(r106, r108, r109, r110);
        return;
    L24:
        return;
    L20:
        c(MapsKt.mapOf(new Pair[]{TuplesKt.to(PaidReplayConstants.KEY_TICKET_ENTRANCE, r100), TuplesKt.to(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, r100)}), false);
    }

    @Override // kq1.c
    public final void c(Map<String, String> r110, boolean r111) {
        if (t.a().isLogin() == true) goto L6;
        p.a("user not login, open login page");
        com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m.a.a(t.a(), this.f109411t, null, null, null, null, 0, null, 124).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L6:
        PrivilegeInfo r100 = g();
        if (r100 == null) goto L91;
        PrivilegeUrl r101 = r100.privilegeUrl;
        if (r101 == null) goto L92;
        String r102 = r101.privilegePanelSchema;
        if (r102 == null) goto L93;
        Uri r103 = UriProtector.parse(r102);
        if (r103 == null) goto L16;
        String r104 = UriProtector.getQueryParameter(r103, "url");
    L18:
        if (r104 != null) goto L20;
    L23:
        boolean r105 = true;
    L24:
        if (r105 == false) goto L26;
        r104 = r102;
    L26:
        boolean r106 = true ^ r105;
        Uri r107 = UriProtector.parse(r104);
        Map<String, String> r108 = h();
        com.bytedance.android.livesdk.chatroom.vs_base.log.d r109 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f109410s.f118151y);
        com.bytedance.android.livesdk.log.filter.o r112 = r109.c(a0.class);
        if (r112 == null) goto L32;
        Map<String, String> r113 = r112.getMap();
        if (r113 == null) goto L32;
        Map<? extends String, ? extends String> r114 = MapsKt.toMutableMap(r113);
        if (r114 == null) goto L32;
    L33:
        r108.putAll(r114);
        com.bytedance.android.livesdk.log.filter.o r115 = r109.c(b0.class);
        if (r115 == null) goto L39;
        Map<String, String> r116 = r115.getMap();
        if (r116 == null) goto L39;
        Map<? extends String, ? extends String> r117 = MapsKt.toMutableMap(r116);
        if (r117 == null) goto L39;
    L40:
        r108.putAll(r117);
        if (r110 == null) goto L43;
        r108.putAll(r110);
    L43:
        if (r111 == false) goto L45;
        r108.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, this.f109406o);
        r108.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, this.f109406o);
    L45:
        Iterator<String> r118 = r108.keySet().iterator();
    L47:
        if (r118.hasNext() == false) goto L56;
        String r119 = r118.next();
        if (r107 == null) goto L55;
        Uri.Builder r120 = r107.buildUpon();
        if (r120 == null) goto L55;
        Uri.Builder r121 = r120.appendQueryParameter(r119, r108.get(r119));
        if (r121 == null) goto L55;
        r107 = r121.build();
    L55:
        r107 = null;
        goto L47
    L56:
        Uri r122 = UriProtector.parse(r102);
        if (r106 == false) goto L59;
        r107 = new Uri.Builder().scheme(r122.getScheme()).authority(r122.getAuthority()).path(r122.getPath()).appendQueryParameter("url", r107.toString()).build();
    L59:
        Iterator<String> r123 = UriProtector.getQueryParameterNames(r122).iterator();
    L61:
        if (r123.hasNext() == false) goto L71;
        String r124 = r123.next();
        if (r124.equals("url") == true) goto L61;
        if (r107 == null) goto L70;
        Uri.Builder r125 = r107.buildUpon();
        if (r125 == null) goto L70;
        Uri.Builder r126 = r125.appendQueryParameter(r124, UriProtector.getQueryParameter(r122, r124));
        if (r126 == null) goto L70;
        r107 = r126.build();
    L70:
        r107 = null;
        goto L61
    L71:
        fq1.d.a().handleSchema(this.f109411t, r107.toString());
        return;
    L39:
        r117 = new LinkedHashMap();
    L32:
        r114 = new LinkedHashMap();
        goto L33
    L20:
        if (r104.length() == 0) goto L23;
        r105 = false;
        goto L24
    L16:
        r104 = null;
        goto L18
    L93:
        return;
    L92:
        return;
    }

    public ReplayPrivilegeClarityManager(com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r100, Context r101, ReplayPlayFragment.n r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f109410s = r100;
        this.f109411t = r101;
        this.f109412u = r102;
        this.f109392a = LazyKt.lazy(ReplayPrivilegeClarityManager$enablePrivilegeTrial$2.INSTANCE);
        this.f109393b = LazyKt.lazy(ReplayPrivilegeClarityManager$frequencyRecord$2.INSTANCE);
        this.f109398g = LazyKt.lazy(ReplayPrivilegeClarityManager$paidLiveAPI$2.INSTANCE);
        f r103 = new f(this);
        g r104 = new g(this);
        this.f109399h = new n(this);
        this.f109400i = LazyKt.lazy(new ReplayPrivilegeClarityManager$tempWatchResObserver$2(this));
        this.f109401j = LazyKt.lazy(new ReplayPrivilegeClarityManager$extraInfo$2(this));
        this.f109406o = "";
        this.f109407p = new com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.a();
        this.f109408q = new e(r100.f118151y, r101);
        Episode r105 = r100.f118130d.f118064r.getValue();
        if (r105 == null) goto L5;
        e(r105);
    L7:
        if (Intrinsics.areEqual(r100.f118130d.f118048b.getValue(), Boolean.TRUE) == false) goto L9;
        this.f109404m = true;
        n();
    L10:
        mq1.p r106 = s.e().a(r100.f118151y);
        if (r106 == null) goto L13;
        r106.registerReplaySwitchListener(this, false);
    L13:
        this.f109409r = new PrivilegeClarityEventHub();
        return;
    L9:
        r100.f118130d.f118048b.observeForever(r104);
        goto L10
    L5:
        r100.f118130d.f118064r.observeForever(r103);
        goto L7
    }
}
