package com.bytedance.android.live.revlink.impl.multianchor.vm;

import androidx.camera.core.RetryPolicy;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revenuelink.rtc.o;
import com.bytedance.android.live.revenuelink.rtc.p;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r11.j;

/* JADX INFO: loaded from: classes47.dex */
public final class LinkingInvitePreloadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f95025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f95026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f95027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f95028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f95029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f95030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f95031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f95032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f95033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f95034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ld.a f95035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f95036l;

    public static final class a {
    }

    static {
    }

    public final f c() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f95036l;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Fb();
    }

    public final v d() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f95036l;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMultiLinkMonitor();
    }

    public final w e() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f95036l;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMultiLinkUtil();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String f() {
        f r100 = c();
        if (r100 != null) goto L5;
        return "preload disabled";
    L5:
        if (r100.a() != true) goto L137;
        w r101 = e();
        if (r101 != null) goto L10;
    L13:
        com.bytedance.android.live.revlink.impl.global.c r102 = this.f95036l;
        if (r102 == null) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r103 = r102.getLinkPlayHelper();
    L17:
        if (r103 != null) goto L19;
    L22:
        w r104 = e();
        if (r104 != null) goto L25;
    L28:
        com.bytedance.android.live.revlink.impl.global.c r105 = this.f95036l;
        if (r105 == null) goto L31;
        MultiLinkAnchorControlContext r106 = r105.ua();
    L32:
        boolean r107 = false;
        if (r106 == null) goto L52;
        m<Boolean> r108 = r106.getForbidInvite();
        if (r108 == null) goto L52;
        if (r108.getValue().booleanValue() != true) goto L52;
        w r109 = e();
        if (r109 == null) goto L51;
        i11.b r110 = r109.a();
        if (r110 == null) goto L51;
        com.bytedance.android.live.revlink.impl.global.c r111 = this.f95036l;
        if (r111 == null) goto L45;
        s r112 = r111.getRevLinkCommonUtil();
    L46:
        if (r112 == null) goto L48;
        String r113 = r112.e();
    L50:
        if (r110.N(r113) == true) goto L52;
    L48:
        r113 = null;
        goto L50
    L45:
        r112 = null;
    L51:
        boolean r114 = true;
    L53:
        if (r114 == false) goto L57;
        return "forbid invite";
    L57:
        if (c() == null) goto L59;
        b51.b r115 = b51.b.f17721c0;
        r115.getClass();
        r11.d r116 = (r11.d) b51.b.f17728j.getValue(r115, b51.b.f17716a[8]);
    L61:
        if (r116 != null) goto L63;
    L65:
        if (r116 != null) goto L67;
    L77:
        if (r116 != null) goto L79;
    L105:
        com.bytedance.android.live.revlink.impl.global.c r117 = this.f95036l;
        if (r117 == null) goto L108;
        com.bytedance.android.live.revenuelink.rtc.f r118 = r117.m0();
    L109:
        if (r118 == null) goto L127;
        i r119 = r118.getRtcManager();
        if (r119 == null) goto L127;
        p r120 = r119.L();
        if (r120 == null) goto L127;
        List<o> r121 = r120.l();
        if (r121 == null) goto L127;
        if (r116 == null) goto L127;
        if (r116.X() != true) goto L127;
        if (r121.size() != 1) goto L127;
        o r122 = (o) CollectionsKt.firstOrNull(r121);
        if (r122 == null) goto L127;
        if (r122.f91961g != true) goto L127;
        return "guest muted";
    L127:
        if (r116 != null) goto L129;
    L134:
        return "";
    L129:
        if (r116.B2() != true) goto L134;
        if ((!((Boolean) l51.a.U.getValue(null, l51.a.f507436a[49])).booleanValue()) == false) goto L134;
        return "never open invite panel";
    L108:
        r118 = null;
        goto L109
    L79:
        if (r116.J1() != true) goto L105;
        com.bytedance.android.live.revlink.impl.global.c r123 = this.f95036l;
        if (r123 == null) goto L83;
        q r124 = r123.getPkUtils();
    L84:
        if (r124 == null) goto L86;
        q11.b r125 = r124.a();
    L88:
        if ((!Intrinsics.areEqual(r125, q11.b.d.f531275b)) == true) goto L102;
        com.bytedance.android.live.revlink.impl.global.c r126 = this.f95036l;
        if (r126 == null) goto L93;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r127 = r126.Ig();
    L94:
        if (r127 == null) goto L102;
        LiveData<Long> r128 = r127.getBaseTimeLeft();
        if (r128 == null) goto L102;
        Long r129 = r128.getValue();
        if (r129 == null) goto L102;
        if (r129.longValue() >= 30) goto L102;
        r107 = true;
        goto L102
    L93:
        r127 = null;
    L102:
        if (r107 == false) goto L105;
        return "couple pk time up";
    L86:
        r125 = null;
        goto L88
    L83:
        r124 = null;
        goto L84
    L67:
        if (r116.O5() != true) goto L77;
        if (((Boolean) l51.a.O.getValue(null, l51.a.f507436a[41])).booleanValue() == false) goto L71;
    L74:
        boolean r130 = true;
    L75:
        if (r130 == false) goto L77;
        return "";
    L71:
        if (this.f95025a > 3) goto L74;
        r130 = false;
        goto L75
    L63:
        if (r116.l4() != true) goto L65;
        return "";
    L59:
        r116 = null;
    L52:
        r114 = false;
        goto L53
    L31:
        r106 = null;
        goto L32
    L25:
        if (r104.g() != true) goto L28;
        return "pk with audience";
    L19:
        if (r103.g() != true) goto L22;
        return "in multi pk";
    L16:
        r103 = null;
        goto L17
    L10:
        if (r101.h() != r41.f.f536020b) goto L13;
        return "linked user count limit";
    L137:
        return "preload disabled";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String h() {
        String r100 = f();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("error_msg", r100);
        boolean r102 = false;
        if (r100.length() != 0) goto L5;
        int r103 = 1;
    L6:
        r101.put("error_code", Integer.valueOf(r103 ^ 1));
        com.bytedance.android.live.revlink.impl.global.c r104 = this.f95036l;
        Disposable r105 = null;
        if (r104 == null) goto L9;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r106 = r104.Ig();
    L10:
        if (r106 == null) goto L14;
        LiveData<Long> r107 = r106.getBaseTimeLeft();
        if (r107 == null) goto L14;
        Long r108 = r107.getValue();
    L15:
        r101.put("couple_pk_time_left", String.valueOf(r108));
        com.bytedance.android.live.revlink.impl.global.c r109 = this.f95036l;
        if (r109 == null) goto L18;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r110 = r109.Ig();
    L19:
        String r111 = "";
        if (r110 == null) goto L25;
        PkBaseStateMachine.c r112 = r110.getCurPKBaseState();
        if (r112 == null) goto L25;
        String r113 = r112.f92862c;
        if (r113 == null) goto L25;
    L26:
        r101.put("couple_pk_stage", r113);
        w r114 = e();
        if (r114 == null) goto L29;
        int r115 = r114.h();
    L30:
        r101.put("link_anchor_cnt", Integer.valueOf(r115));
        r101.put("top_rev_linker", Boolean.valueOf(((Boolean) l51.a.O.getValue(null, l51.a.f507436a[41])).booleanValue()));
        r101.put("invite_panel_open_cnt", Integer.valueOf(this.f95025a));
        r101.put("team_pk_invite_panel_open_cnt", Integer.valueOf(this.f95026b));
        if (c() == null) goto L38;
        int r116 = f.f95049b;
        b51.b r117 = b51.b.f17721c0;
        r117.getClass();
        r11.d r118 = (r11.d) b51.b.f17728j.getValue(r117, b51.b.f17716a[8]);
        if (r118 == null) goto L38;
        Intrinsics.checkNotNullParameter(r118, "$this$formatString");
        String r119 = "InvitePreloadStrategy{aggressive=" + r118.l4() + ",pk_time=" + r118.J1() + ",mute_state=" + r118.X() + ",never_open_invite=" + r118.B2() + ",active_user=" + r118.O5() + com.alipay.sdk.m.u.i.f25855d;
        if (r119 == null) goto L38;
        r111 = r119;
    L38:
        r101.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r111);
        v r120 = d();
        if (r120 == null) goto L42;
        r120.H("preload_inviting_list", r101);
    L42:
        if (r100.length() != 0) goto L44;
        r102 = true;
    L44:
        if (r102 == false) goto L67;
        com.bytedance.android.live.revlink.impl.global.c r121 = this.f95036l;
        if (r121 == null) goto L48;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r122 = r121.getLinkPlayHelper();
    L49:
        if (r122 != null) goto L51;
    L53:
        int r123 = 6;
    L54:
        jy0.b.f("ttlive_anchor_link_preload", "preload recommendList tabType=" + r123, null, 4);
        this.f95028d = true;
        this.f95029e = r123;
        i97.a r124 = i97.a.f488802a;
        this.f95027c = System.currentTimeMillis();
        long r125 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r126 = this.f95036l;
        if (r126 == null) goto L57;
        r31.a r127 = r126.getLinkNetwork();
    L58:
        if (r127 == null) goto L66;
        Observable r128 = r127.c(3, false, r123, "", 3, IRivalRankRecommendResponse.LoadType.All.ordinal());
        if (r128 == null) goto L66;
        int r129 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Observable r130 = r128.subscribeOn(Schedulers.io());
        if (r130 == null) goto L66;
        Observable r131 = r130.observeOn(AndroidSchedulers.mainThread());
        if (r131 == null) goto L66;
        r105 = r131.subscribe(new c(this, r123, r125), new d(this, r123, r125));
    L66:
        this.f95031g = r105;
    L68:
        return r100;
    L57:
        r127 = null;
        goto L58
    L51:
        if (r122.c() != true) goto L53;
        r123 = 3;
        goto L54
    L48:
        r122 = null;
        goto L49
    L67:
        b("noPreload");
        goto L68
    L29:
        r115 = 0;
    L25:
        r113 = "";
        goto L26
    L18:
        r110 = null;
    L14:
        r108 = null;
        goto L15
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final Pair<String, IRivalRankRecommendResponse> a(int r110) {
        h r100 = this.f95030f;
        if (r100 == null) goto L52;
        if (r100.f95053b != r110) goto L7;
        i97.a r111 = i97.a.f488802a;
        long r101 = System.currentTimeMillis() - r100.f95054c;
        j r112 = b51.b.f17721c0.d();
        Intrinsics.checkNotNullParameter(r112, "$this$getValidCacheInterval");
        if (r112.z() > 0) goto L11;
        long r102 = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
    L13:
        if (r101 > r102) goto L15;
        IRivalRankRecommendResponse r113 = r100.f95052a;
        f r103 = c();
        if (r103 == null) goto L50;
        if (r103.b() != true) goto L50;
        int r104 = IGroupRivals.GroupType.GroupFeedRecommend.ordinal();
        s2 r114 = r113.getTabRivals();
        if (r114 == null) goto L26;
        Map<Long, IGroupRivals> r115 = r114.getGroupRivals();
        if (r115 == null) goto L26;
        IGroupRivals r116 = r115.get(Long.valueOf(r104));
    L27:
        if (r116 == null) goto L29;
        List<m2> r105 = r116.getRivals();
    L30:
        if (r105 == null) goto L50;
        if ((true ^ ((HashSet) this.f95034j.getValue()).isEmpty()) == false) goto L50;
        ArrayList r106 = new ArrayList();
        Iterator r107 = CollectionsKt.toList(r105).iterator();
    L35:
        if (r107.hasNext() == false) goto L46;
        m2 r108 = (m2) r107.next();
        if (r108 == null) goto L35;
        HashSet r109 = (HashSet) this.f95034j.getValue();
        IRoom r117 = r108.getRoom();
        if (r117 == null) goto L41;
        String r118 = r117.getIdStr();
    L43:
        if (r109.contains(r118) == true) goto L35;
        r106.add(r108);
        goto L35
    L41:
        r118 = null;
        goto L43
    L46:
        if (r106.size() < b51.b.f17721c0.d().t()) goto L50;
        if (r116 == null) goto L50;
        r116.setRivals(r106);
        goto L50
    L29:
        r105 = null;
    L26:
        r116 = null;
    L50:
        return TuplesKt.to("", r100.f95052a);
    L15:
        return TuplesKt.to("time expired", null);
    L11:
        r102 = r112.z();
        goto L13
    L7:
        return TuplesKt.to("tabType mismatch", null);
    L52:
        return TuplesKt.to("no cache", null);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        jy0.b.d("ttlive_anchor_link_preload", "clearCache from ".concat(r100));
        if ((!Intrinsics.areEqual(r100, "preloadFailed")) == false) goto L8;
        Disposable r101 = this.f95032h;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        this.f95033i = true;
    L8:
        Disposable r102 = this.f95031g;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        this.f95031g = null;
        f r103 = c();
        if (r103 != null) goto L14;
    L19:
        this.f95030f = null;
        this.f95027c = 0;
        ((HashSet) this.f95034j.getValue()).clear();
    L20:
        this.f95028d = false;
        this.f95029e = 0;
        return;
    L14:
        if (r103.b() != true) goto L19;
        if ((!Intrinsics.areEqual(r100, "cacheConsumed")) == false) goto L20;
        if ((!Intrinsics.areEqual(r100, "preloadFailed")) == false) goto L20;
        goto L19
    }

    public LinkingInvitePreloadUtils(ld.a r100, com.bytedance.android.live.revlink.impl.global.c r101) {
        this.f95035k = r100;
        this.f95036l = r101;
        this.f95033i = true;
        this.f95034j = LazyKt.lazy(LinkingInvitePreloadUtils$exposeSet$2.INSTANCE);
    }

    public final void g(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        jy0.b.c("ttlive_anchor_link_preload", "first refresh recommend list, status: " + r101, null, 4);
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("error_msg", r101);
        r102.put("error_code", Integer.valueOf(r100));
        w r103 = e();
        if (r103 == null) goto L5;
        int r104 = r103.h();
    L6:
        r102.put("link_anchor_cnt", Integer.valueOf(r104));
        v r105 = d();
        if (r105 == null) goto L10;
        r105.H("first_refresh_status", r102);
        return;
    L10:
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
