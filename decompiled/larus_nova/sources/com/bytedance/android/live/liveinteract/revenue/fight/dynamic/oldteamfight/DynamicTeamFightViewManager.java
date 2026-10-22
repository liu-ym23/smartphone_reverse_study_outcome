package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.api.fulllink.revenue.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.MultiLinkCommonEmptyMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightPKProgressLayout;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightTitleLayout;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh0.f;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/dynamic/oldteamfight/DynamicTeamFightViewManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicTeamFightViewManager implements Observer<KVData> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f78175s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f78176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f78177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f78178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f78179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TeamFightPKProgressLayout f78180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TeamFightTitleLayout f78181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IRoom f78182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f78183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f78184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f78185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f78186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f78187l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f78188m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f78189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.revenue.fight.c f78190o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinkMicRecyclerView f78191p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ViewGroup f78192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DataCenter f78193r;

    public static final class a {
    }

    static {
    }

    public static boolean d() {
        boolean r100 = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().isAdmin();
        IMiddlewareUserService r101 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r101 == null) goto L12;
        com.bytedance.android.livesdk.user.e r102 = r101.user();
        if (r102 == null) goto L12;
        UserAttr r103 = r102.q();
        if (r103 == null) goto L12;
        List<Integer> r104 = r103.getAdminPrivileges();
        if (r104 == null) goto L12;
        LiveRoomPermission.D.getClass();
        if (r104.contains(Integer.valueOf(LiveRoomPermission.f105071u.f105077a)) != true) goto L12;
    L22:
        if (r100 == true) goto L26;
    L24:
        return false;
    L26:
        return true;
    L12:
        IMiddlewareUserService r105 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r105 == null) goto L24;
        com.bytedance.android.livesdk.user.e r106 = r105.user();
        if (r106 == null) goto L24;
        UserAttr r107 = r106.q();
        if (r107 == null) goto L24;
        List<Integer> r108 = r107.getAdminPrivileges();
        if (r108 == null) goto L24;
        LiveRoomPermission.D.getClass();
        if (r108.contains(Integer.valueOf(LiveRoomPermission.f105068r.f105077a)) != true) goto L24;
        goto L22
    }

    public final void a() {
        Disposable r100 = this.f78187l;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f78188m;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public static void e(MultiLinkCommonEmptyMicSeatBasicLayer r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        if (gh0.a.d() == false) goto L5;
        View r101 = r100.m(R.id.ttlive_empty_position);
        View r102 = r100.m(R.id.ttlive_empty_avatar);
        UIUtils.setViewVisibility(r101, 8);
        UIUtils.setViewVisibility(r102, 0);
    L5:
        View r103 = r100.m(R.id.ttlive_position_name);
        if (r103 == null) goto L9;
        r103.setAlpha(0.0f);
        return;
    }

    public static void g(pg0.b r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        View r101 = r100.m(R.id.ttlive_position_name);
        if (r101 == null) goto L5;
        r101.setAlpha(0.0f);
    L5:
        View r102 = r100.m(R.id.ttlive_seat_pos_tag_label);
        if (r102 == null) goto L8;
        r102.setAlpha(0.0f);
    L8:
        View r103 = r100.m(R.id.ttlive_mic_room_host_tv);
        if (r103 == null) goto L12;
        r103.setAlpha(0.0f);
        return;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        ALogger.i("DynamicTeamFightViewManager", "clearTeamFightState fightShowing:" + this.f78184i + " reason:" + r100);
        if (this.f78184i == true) goto L5;
        return;
    L5:
        a();
        this.f78178c.setVisibility(8);
        ViewGroup r101 = this.f78179d;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        this.f78180e.setVisibility(8);
        this.f78180e.f();
        this.f78184i = false;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L7:
        if (Intrinsics.areEqual(r103, "data_multi_link_dynamic_layout_info_change") == true) goto L9;
        return;
    L9:
        if (this.f78177b == null) goto L32;
        f r104 = (f) r101.getData();
        if (r104 == null) goto L33;
        sf0.b r105 = r104.f519125e;
        if (r105 == null) goto L27;
        ViewGroup.LayoutParams r106 = this.f78177b.getLayoutParams();
        if ((r106 instanceof ConstraintLayout.LayoutParams) == false) goto L19;
        r102 = r106;
    L19:
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r102;
        if (r107 == null) goto L29;
        int r108 = ((ViewGroup.MarginLayoutParams) r107).topMargin;
        sf0.c r109 = r105.f541702c;
        if (r108 == r109.f541707c) goto L24;
    L25:
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(-1, r105.f541702c.f541709e);
        r110.topToTop = 0;
        r110.leftToLeft = 0;
        r110.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r110).topMargin = r105.f541702c.f541707c;
        this.f78177b.setLayoutParams(r110);
        return;
    L24:
        if (((ViewGroup.MarginLayoutParams) r107).height != r109.f541709e) goto L25;
        return;
    L29:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.linkbase.DynamicFrameInfo");
    L33:
        return;
    L32:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static void f(MultiLinkCommonGuestMicSeatBasicLayer r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        if (((r101 - 1) % 4) >= 2) goto L5;
        boolean r102 = true;
    L6:
        if (r101 == 0) goto L36;
        ViewGroup.LayoutParams r103 = null;
        if (r102 == false) goto L22;
        FrameLayout r104 = (FrameLayout) r100.m(R.id.ttlive_guest_fans_ticket_count_container);
        if (r104 == null) goto L12;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L14:
        if ((r105 instanceof ConstraintLayout.LayoutParams) == false) goto L17;
        r103 = r105;
    L17:
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r103;
        if (r106 == null) goto L37;
        r106.leftToLeft = R.id.guest_info_container;
        r106.rightToRight = -1;
        if (r104 == null) goto L38;
        r104.setLayoutParams(r106);
        return;
    L38:
        return;
    L37:
        return;
    L12:
        r105 = null;
        goto L14
    L22:
        FrameLayout r107 = (FrameLayout) r100.m(R.id.ttlive_guest_fans_ticket_count_container);
        if (r107 == null) goto L25;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
    L27:
        if ((r108 instanceof ConstraintLayout.LayoutParams) == false) goto L30;
        r103 = r108;
    L30:
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r103;
        if (r109 == null) goto L40;
        r109.rightToRight = R.id.guest_info_container;
        r109.leftToLeft = -1;
        if (r107 == null) goto L41;
        r107.setLayoutParams(r109);
        return;
    L41:
        return;
    L40:
        return;
    L25:
        r108 = null;
        goto L27
    L36:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void c(com.bytedance.android.live.liveinteract.multiscene.a r100, String r101) {
        if (this.f78184i == false) goto L6;
        return;
    L6:
        if (li0.d.g(r100) == false) goto L8;
        return;
    L8:
        ALogger.w("DynamicTeamFightViewManager", "首次创建团战:上报uiRenderStart from=".concat(r101));
        int r102 = h.f71494a;
        int r103 = 0;
        UIUtils.setViewVisibility(this.f78178c, 0);
        UIUtils.setViewVisibility(this.f78179d, 0);
        this.f78184i = true;
        h.b(this.f78180e);
        LinkMicRecyclerView r104 = this.f78191p;
        if (r104 == null) goto L30;
        int r105 = r104.getChildCount();
    L11:
        if (r103 >= r105) goto L36;
        Object r106 = r104.findViewHolderForAdapterPosition(r103);
        if ((r106 instanceof hg0.b) == false) goto L29;
        hg0.b r107 = (hg0.b) r106;
        g r108 = r107.l().h();
        if (r108 != null) goto L17;
    L19:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b r109 = r107.l().g();
        if (r109 != null) goto L22;
    L24:
        pg0.e r110 = r107.l().s();
        if (r110 == null) goto L29;
        if ((r110 instanceof pg0.b) == false) goto L29;
        g((pg0.b) r110);
        goto L29
    L22:
        if ((r109 instanceof MultiLinkCommonEmptyMicSeatBasicLayer) == false) goto L24;
        e((MultiLinkCommonEmptyMicSeatBasicLayer) r109);
        goto L24
    L17:
        if ((r108 instanceof MultiLinkCommonGuestMicSeatBasicLayer) == false) goto L19;
        f((MultiLinkCommonGuestMicSeatBasicLayer) r108, r103);
    L29:
        r103 = r103 + 1;
        goto L11
    L36:
        return;
    }

    public DynamicTeamFightViewManager(com.bytedance.android.live.liveinteract.revenue.fight.c r100, LinkMicRecyclerView r101, ViewGroup r102, DataCenter r103) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        this.f78190o = r100;
        this.f78191p = r101;
        this.f78192q = r102;
        this.f78193r = r103;
        View r104 = r102.findViewById(R.id.iv_top_bg);
        this.f78176a = r104;
        this.f78177b = (FrameLayout) r102.findViewById(R.id.fl_play_mode_view_container_align_recyclerview);
        this.f78178c = (ViewGroup) r102.findViewById(R.id.team_fight_container);
        this.f78179d = (ViewGroup) r102.findViewById(R.id.voice_team_fight_container_old);
        TeamFightPKProgressLayout r105 = (TeamFightPKProgressLayout) r102.findViewById(R.id.team_fight_progressbar);
        this.f78180e = r105;
        TeamFightTitleLayout r106 = (TeamFightTitleLayout) r102.findViewById(R.id.team_fight_title_layout);
        this.f78181f = r106;
        IRoom r107 = a0.n(r103);
        this.f78182g = r107;
        boolean r108 = a0.d(r103, false);
        this.f78183h = r108;
        this.f78186k = new CompositeDisposable();
        this.f78189n = "";
        r105.e(r108);
        if (r108 == false) goto L5;
    L8:
        boolean r109 = true;
    L9:
        r106.f78268b = r109;
        r106.setOnClickListener(x0.a(new AnonymousClass1(this)));
        r103.observe("data_multi_fight_profit_egg", new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.a(this));
        ViewGroup.LayoutParams r110 = r104.getLayoutParams();
        if (r110 == null) goto L20;
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
        if (r107.isLiveTypeAudio() == false) goto L14;
        r111.matchConstraintPercentHeight = 0.379f;
        r104.setLayoutParams(r111);
    L16:
        if (r.j(null, 0, 7) == false) goto L21;
        r103.observe("data_multi_link_dynamic_layout_info_change", this, true);
        return;
    L21:
        return;
    L14:
        r111.matchConstraintPercentHeight = 0.333f;
        r104.setLayoutParams(r111);
        goto L16
    L20:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L5:
        if (d() == true) goto L8;
        r109 = false;
        goto L9
    }
}
