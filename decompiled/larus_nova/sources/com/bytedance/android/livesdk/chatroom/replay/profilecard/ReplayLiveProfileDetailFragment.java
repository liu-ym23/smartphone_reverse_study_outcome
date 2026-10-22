package com.bytedance.android.livesdk.chatroom.replay.profilecard;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bm1.b;
import bm1.e;
import bm1.n;
import bm1.o;
import bm1.p;
import bm1.s;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.android.livesdk.chatroom.vs_base.util.l;
import com.bytedance.android.livesdk.chatroom.vs_base.util.y;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import fq1.t;
import ita.i;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import pq1.c;
import py.j;
import py.q;
import wr1.f;

/* JADX INFO: loaded from: classes7.dex */
public class ReplayLiveProfileDetailFragment extends BaseFragment implements View.OnClickListener, a.InterfaceC1656a {
    public static final /* synthetic */ int V = 0;
    public View A;
    public ImageView B;
    public View C;
    public HSImageView D;
    public LinearLayout E;
    public final Animator[] F;
    public final Animator[] G;
    public IBaseUser H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f109878J;
    public String K;
    public Episode L;
    public boolean M;
    public a N;
    public boolean O;
    public boolean P;
    public long Q;
    public String R;
    public s S;
    public final String T;
    public final boolean U;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f109879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f109880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f109881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f109882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f109883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f109884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f109885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f109886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f109887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f109888m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f109889n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f109890o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f109891p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Activity f109892q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataCenter f109893r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f109894s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f109895t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f109896u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f109897v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f109898w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f109899x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RecyclerView f109900y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f f109901z;

    @Override // com.bytedance.android.live.core.ui.BaseFragment, tw2.b
    public final String getSpm() {
        return "a100.a214";
    }

    public final HashMap<String, String> U90() {
        Episode r100 = this.L;
        if (r100 == null) goto L5;
        long r101 = r100.getIdExt();
    L6:
        HashMap<String, String> r102 = new HashMap();
        Episode r103 = this.L;
        if (r103 == null) goto L9;
        String r104 = r103.getOwner().getIdString();
    L10:
        r102.put("anchor_id", r104);
        r102.put("room_id", String.valueOf(r101));
        if (this.H.getPoiInfo() == null) goto L13;
        String r105 = this.H.getPoiInfo().getPoiIdStr();
    L15:
        if (this.I == true) goto L17;
    L19:
        String r106 = "live_page";
    L20:
        r102.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r106);
        r102.put("poi_id", r105);
        return r102;
    L17:
        if (this.f109878J == false) goto L19;
        r106 = "live_take_detail";
        goto L20
    L13:
        r105 = "";
        goto L15
    L9:
        r104 = "0";
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    public ReplayLiveProfileDetailFragment() {
        this.F = new Animator[]{null, null};
        this.G = new Animator[]{null, null};
        this.T = "";
        this.U = true;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.O = false;
        T90(this.F[0]);
        T90(this.F[1]);
        T90(this.G[0]);
        T90(this.G[1]);
    }

    public static void T90(Animator r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.removeAllListeners();
        if (r100.isRunning() == false) goto L8;
        r100.cancel();
        return;
    }

    public final void S90(IBaseUser r100) {
        if (this.O == false) goto L106;
        if (r100 == null) goto L106;
        if (TextUtils.isEmpty(r100.getIdString()) == true) goto L106;
        if (this.f109891p.getVisibility() != 8) goto L11;
        this.f109891p.setVisibility(0);
    L11:
        this.H = r100;
        this.K = r100.getIdString();
        String r101 = t.a().getCurrentUserId();
        this.I = TextUtils.equals(r101, this.K);
        this.f109878J = TextUtils.equals(r101, this.L.getOwner().getIdString());
        this.f109901z.setData(this.H.getBadgeImageListV2Ext());
        this.f109901z.a(new e(this));
        this.f109879d.setText(this.H.getRemarkNameOrRealNickName());
        if (this.H.getGender() != 1) goto L17;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == false) goto L23;
        this.B.setImageResource(R.drawable.ttlive_replay_gender_male);
        UIUtils.setViewVisibility(this.B, 0);
    L23:
        if (TextUtils.isEmpty(this.H.getLocationCity()) == false) goto L32;
        if (this.L.getRoomAuthStatus().getEnablePoi() == true) goto L27;
    L30:
        UIUtils.setViewVisibility(this.f109880e, 8);
        UIUtils.setViewVisibility(this.f109891p.findViewById(R.id.location_divider), 8);
        UIUtils.setViewVisibility(this.f109891p.findViewById(R.id.location_iv), 8);
    L43:
        if (TextUtils.isEmpty(this.H.getSpecialId()) == true) goto L45;
        this.f109882g.setVisibility(8);
        this.f109883h.setVisibility(0);
        this.f109883h.setText(s1.C(R.string.ttlive_replay_core_special_id, new Object[]{this.H.getSpecialId()}));
        this.f109883h.postDelayed(new bm1.a(this), 1000);
    L47:
        if (this.H.isVerified() == true) goto L49;
    L51:
        this.f109885j.setVisibility(8);
    L53:
        if (TextUtils.isEmpty(this.H.getSignature()) == false) goto L56;
        this.f109886k.setText(R.string.ttlive_replay_default_user_word2);
    L66:
        this.f109894s.setVisibility(8);
        this.f109895t.setVisibility(0);
        this.f109896u.setVisibility(0);
        this.f109897v.setVisibility(0);
        if (TextUtils.isEmpty(this.H.getSpecialId()) == true) goto L69;
        this.f109898w.setVisibility(0);
    L71:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == false) goto L73;
        this.f109886k.setMaxLines(1);
    L74:
        j r102 = this.H.getFollowInfo();
        if (r102 == null) goto L77;
        this.f109896u.setText("关注 " + l.a(r102.getFollowingCount()));
    L79:
        if (r102 == null) goto L81;
        this.f109895t.setText("粉丝 " + l.a(r102.getFollowerCount()));
    L83:
        if (this.I == false) goto L88;
        this.f109888m.setVisibility(8);
        this.f109889n.setVisibility(8);
        if (this.U == false) goto L87;
        UIUtils.setViewVisibility(this.f109890o, 0);
        this.f109890o.setTag(this.H);
    L87:
        this.f109887l.setVisibility(8);
    L100:
        IBaseUser r103 = this.H;
        if (r103 != null) goto L103;
        return;
    L103:
        if (r103.getMAuthenticationInfo() == null) goto L111;
        ImageLoader.bindImage(this.D, this.H.getMAuthenticationInfo().getAuthenticationBadge());
        UIUtils.setViewVisibility(this.D, 0);
        return;
    L111:
        return;
    L88:
        W90(this.H);
        this.f109888m.setOnClickListener(this);
        this.f109889n.setOnClickListener(this);
        boolean r104 = t.a().c();
        if (this.f109878J == false) goto L91;
        UIUtils.setViewVisibility(this.f109890o, 8);
        UIUtils.setViewVisibility(null, 8);
    L99:
        this.f109887l.setVisibility(0);
        goto L100
    L91:
        if (r104 == true) goto L93;
        UIUtils.setViewVisibility(null, 8);
        if (this.U == false) goto L99;
        UIUtils.setViewVisibility(this.f109890o, 0);
        this.f109890o.setTag(this.H);
        goto L99
    L93:
        if (this.U == false) goto L95;
        UIUtils.setViewVisibility(this.f109890o, 0);
    L95:
        UIUtils.setViewVisibility(null, 8);
        goto L99
    L81:
        this.f109895t.setText("粉丝 " + String.valueOf(0));
        goto L83
    L77:
        this.f109896u.setText("关注 " + String.valueOf(0));
        goto L79
    L73:
        this.f109886k.setMaxLines(2);
        goto L74
    L69:
        this.f109898w.setVisibility(8);
        goto L71
    L56:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == true) goto L58;
        this.f109886k.setText(this.H.getSignature());
        goto L66
    L58:
        if (TextUtils.isEmpty(this.H.getSignature()) == true) goto L66;
        String r105 = this.H.getSignature().replace("\n", " ");
        if (TextUtils.isEmpty(r105) == false) goto L62;
    L64:
        this.f109886k.setText(r105);
        goto L66
    L62:
        if (r105.length() <= 20) goto L64;
        r105 = r105.substring(0, 20) + "...";
        goto L64
    L49:
        if (TextUtils.isEmpty(this.H.getVerifiedReason()) == true) goto L51;
        this.f109885j.setText(this.H.getVerifiedReason());
        this.f109885j.setVisibility(0);
        goto L53
    L45:
        this.f109882g.setVisibility(8);
        this.f109883h.setVisibility(8);
        this.f109884i.setVisibility(8);
        goto L47
    L27:
        if (this.H.getPoiInfo() == null) goto L30;
        if (TextUtils.isEmpty(this.H.getPoiInfo().getPoiName()) == true) goto L30;
    L32:
        if (this.L.getRoomAuthStatus().getEnablePoi() == true) goto L34;
    L41:
        this.f109880e.setText(this.H.getLocationCity());
        goto L43
    L34:
        if (this.H.getPoiInfo() == null) goto L41;
        if (TextUtils.isEmpty(this.H.getPoiInfo().getPoiName()) == true) goto L41;
        String r106 = this.H.getPoiInfo().getPoiName();
        if (r106.length() <= 8) goto L40;
        r106 = r106.substring(0, 8) + "...";
    L40:
        this.f109880e.setText(r106);
        this.f109881f.setVisibility(0);
        d.a(this.f109893r).d("poi_icon_show_vs", U90(), new Object[0]);
        goto L43
    L17:
        if (this.H.getGender() == 2) goto L19;
        UIUtils.setViewVisibility(this.f109899x, 8);
        UIUtils.setViewVisibility(this.B, 8);
        goto L23
    L19:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == false) goto L23;
        this.B.setImageResource(R.drawable.ttlive_replay_gender_female);
        UIUtils.setViewVisibility(this.B, 0);
    L106:
        View r107 = this.f109891p;
        if (r107 == null) goto L112;
        r107.setVisibility(8);
        return;
    }

    public final void V90(IFollowPair r100) {
        if (this.O == false) goto L13;
        IBaseUser r101 = this.H;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.getFollowInfo() != null) goto L9;
        return;
    L9:
        if (((int) this.H.getFollowInfo().getFollowStatus()) == r100.getFollowStatus()) goto L16;
        this.H.setFollowStatus(r100.getFollowStatus());
        W90(this.H);
        return;
    L16:
        return;
    }

    public final void W90(IBaseUser r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFollowing() == true) goto L8;
        UIUtils.setViewVisibility(this.f109888m, 0);
        UIUtils.setViewVisibility(this.f109889n, 8);
        return;
    L8:
        UIUtils.setViewVisibility(this.f109888m, 8);
        UIUtils.setViewVisibility(this.f109889n, 0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        int r111 = r110.getId();
        if (r111 != R.id.home_page) goto L12;
        if (this.f109878J == true) goto L10;
        IBaseUser r112 = this.H;
        if (r112 == null) goto L93;
        ((Integer) this.f109893r.get("data_link_state", 0)).intValue();
        HashMap r100 = new HashMap();
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(this.K));
        r100.put("vs_click_relation_type", this.T);
        r100.put("vs_enter_user_profile_page_positioin", "homepage_button");
        this.S.a(r100);
        HashMap r101 = new HashMap(1);
        r101.put("log_enter_live_source", (String) this.f109893r.get("log_enter_live_source"));
        r101.put("sec_user_id", r112.getCastSecUid());
        r101.put(VSConstants.EXTRA_ENTER_FROM_V3, "vs_player_detail");
        fq1.d.a().a(r112.getIdString(), r101, getContext());
        return;
    L93:
        return;
    L10:
        return;
    L12:
        if (r111 == R.id.follow) goto L43;
        if (r111 == R.id.followed) goto L43;
        if (r111 == R.id.location) goto L19;
        return;
    L19:
        if (this.L.getRoomAuthStatus().getEnablePoi() == true) goto L21;
        return;
    L21:
        q r113 = this.H.getPoiInfo();
        if (r113 != null) goto L25;
        return;
    L25:
        if (TextUtils.isEmpty(r113.getPoiIdStr()) == false) goto L27;
        return;
    L27:
        if (TextUtils.isEmpty(r113.getPoiName()) == false) goto L30;
        return;
    L30:
        if (this.I == true) goto L32;
    L34:
        r.q().showPoiInfoDialogForAudience(getActivity(), r113.getPoiIdStr(), this.H.getIdString(), String.valueOf(this.H.getLiveRoomId()));
    L35:
        a r114 = this.N;
        if (r114 == null) goto L40;
        T r115 = r114.f531633a;
        if (r115 == 0) goto L40;
        ((a.b) r115).hide();
    L40:
        d.a(this.f109893r).d("poi_icon_click_vs", U90(), new Object[0]);
        return;
    L32:
        if (this.f109878J == false) goto L34;
        r.q().showManagePoiDialog(getActivity(), true, this.H.getLiveRoomId(), null);
    L43:
        if (r.q().f(Integer.valueOf(r111), this.R) == true) goto L98;
        HashMap r116 = new HashMap();
        if (this.H.isFollowing() == false) goto L47;
        String r102 = "unfollow";
    L48:
        r116.put("follow_type", r102);
        d.a(this.f109893r).d("pre_follow_vs", r116, new Object[0]);
        HashMap r117 = new HashMap();
        if (this.H.isFollowing() == false) goto L51;
        String r103 = "unfollow";
    L52:
        r117.put("follow_type", r103);
        r117.put("type", "native");
        LiveSlardarMonitor.monitorStatus("ttlive_vs_monitor_pre_profile_follow_vs", 0, r117);
        if (t.a().isLogin() == true) goto L55;
        Bundle r118 = new Bundle();
        r118.putString("enter_from", "live_detail");
        r118.putString("action_type", "follow");
        r118.putString("source", "live");
        r118.putString(VSConstants.KEY_V1_SOURCE, "follow");
        t.a().y(this.f109892q, t.a().k(), "live", "live_detail", t.a().s(), -1, "follow").subscribe(new h());
        return;
    L55:
        Context r119 = getContext();
        int r104 = i.f495747a;
        if (NetworkUtils.isNetworkAvailable(r119) == true) goto L59;
        y.a(R.string.ttlive_replay_core_network_unavailable);
        return;
    L59:
        if (this.H.isFollowing() == true) goto L64;
        final a r120 = this.N;
        Activity r105 = this.f109892q;
        String r106 = String.valueOf(this.K);
        DataCenter r107 = this.f109893r;
        s r108 = this.S;
        String r109 = r108.f19560a;
        String r121 = r108.f19561b;
        if (r120.f109927c == true) goto L104;
        r120.f109927c = true;
        vl1.d.a.f555623a.a(r105, r106, r107, r109, r121, r108.f19562c, null, LiveFollowScene.REPLAY_USER_INFO).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(r120), new o(r120), new p(r120));
        return;
    L104:
        return;
    L64:
        c r122 = c.f530278a;
        if (c.f530278a == null) goto L67;
    L77:
        c r123 = c.f530278a;
        Context r124 = getContext();
        r123.getClass();
        pq1.a.C7226a r125 = new pq1.a.C7226a(r124, 0);
        r125.b(R.string.ttlive_replay_profile_un_follow_title);
        r125.a(0, R.string.ttlive_ok, new bm1.c(this));
        r125.a(1, R.string.ttlive_cancel, new bm1.d());
        Context r126 = r125.f530265a.f530269b;
        if (r126 == null) goto L80;
        pq1.a r127 = new pq1.a(r126, r125.f530265a);
    L81:
        if (r127 != null) goto L83;
        return;
    L83:
        if (DialogLancet.shouldBlockDialogShow(r127) == false) goto L91;
        DialogLancet.handleBlockedDialogShow(r127);
        return;
    L91:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L88
    L86:
        DialogLancet.beforeDialogShow(r127);
        r127.show();
        DialogLancet.afterDialogShow(r127);
        return;
    L80:
        r127 = null;
        goto L81
    L67:
        monitor-enter(c.class);
    L74:
        th = move-exception;
        throw th;
    L69:
        if (c.f530278a != null) goto L71;
        c.f530278a = new c();     // Catch: Throwable -> L74
    L71:
        Unit r128 = Unit.INSTANCE;     // Catch: Throwable -> L74
        monitor-exit(c.class);
        goto L77
    L51:
        r103 = "follow";
        goto L52
    L47:
        r102 = "follow";
        goto L48
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [bm1.b] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.O = true;
        t.a().n(this, new b(this));
        boolean r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a;
        this.f109891p = r100.inflate(R.layout.ttlive_replay_fragment_live_profile_detail, r101, false);
        int r104 = com.bytedance.android.livesdk.chatroom.replay.ui.i.f110252c;
        com.bytedance.android.livesdk.chatroom.replay.ui.i r105 = com.bytedance.android.livesdk.chatroom.replay.ui.i.a.a();
        View r106 = this.f109891p;
        if (r105.g() == false) goto L6;
        if (r106 == null) goto L8;
        r106.setBackground(s1.m(R.drawable.ttlive_bg_live_profile_detail));
    L8:
        this.f109879d = (TextView) this.f109891p.findViewById(R.id.name);
        this.f109900y = (RecyclerView) this.f109891p.findViewById(R.id.user_feature_label_list_view);
        this.f109880e = (TextView) this.f109891p.findViewById(R.id.location);
        this.f109881f = this.f109891p.findViewById(R.id.location_arrow);
        this.f109882g = (TextView) this.f109891p.findViewById(R.id.hotsoon_id);
        this.f109883h = (TextView) this.f109891p.findViewById(R.id.special_id);
        this.f109884i = this.f109891p.findViewById(R.id.slide_view);
        this.f109885j = (TextView) this.f109891p.findViewById(R.id.weibo_nickname);
        this.f109886k = (TextView) this.f109891p.findViewById(R.id.signature);
        this.f109894s = this.f109891p.findViewById(R.id.ttlive_profile_total_info);
        this.f109887l = this.f109891p.findViewById(R.id.action_container);
        com.bytedance.android.livesdk.chatroom.replay.ui.i r107 = com.bytedance.android.livesdk.chatroom.replay.ui.i.a.a();
        View r108 = this.f109887l;
        boolean r109 = this.M;
        if (r107.g() == true) goto L11;
        if (r109 == false) goto L11;
    L13:
        this.f109888m = (TextView) this.f109891p.findViewById(R.id.follow);
        this.f109889n = (TextView) this.f109891p.findViewById(R.id.followed);
        this.f109890o = this.f109891p.findViewById(R.id.home_page);
        this.f109899x = (TextView) this.f109891p.findViewById(R.id.gender_text);
        this.A = this.f109891p.findViewById(R.id.location_divider);
        this.f109895t = (TextView) this.f109891p.findViewById(R.id.follower_v1);
        this.f109897v = this.f109891p.findViewById(R.id.follower_divider);
        this.f109896u = (TextView) this.f109891p.findViewById(R.id.following_v1);
        this.f109898w = this.f109891p.findViewById(R.id.following_divider);
        this.B = (ImageView) this.f109891p.findViewById(R.id.gender_iv);
        this.C = this.f109891p.findViewById(R.id.info_layout);
        this.D = (HSImageView) this.f109891p.findViewById(R.id.verify_icon);
        this.E = (LinearLayout) this.f109891p.findViewById(R.id.certification_layout);
        ImageView r110 = (ImageView) this.f109891p.findViewById(R.id.ttlive_profile_certification_icon);
        TextView r111 = (TextView) this.f109891p.findViewById(R.id.ttlive_profile_certification_text);
        if (this.M == true) goto L18;
        LinearLayout r112 = this.E;
        if (r112 == null) goto L18;
        r112.setVisibility(8);
    L18:
        this.f109880e.setOnClickListener(this);
        this.f109901z = r.q().d();
        this.f109900y.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f109900y.setAdapter(this.f109901z.getAdapter());
        this.f109890o.setOnClickListener(this);
        S90(this.H);
        LinearLayout r113 = this.E;
        if (r113 == null) goto L22;
        r113.setVisibility(8);
    L22:
        if (this.Q == 0) goto L30;
        long r114 = SystemClock.uptimeMillis();
        JSONObject r115 = new JSONObject();
        r115.put("type", "native");     // Catch: JSONException -> L26
    L28:
        LiveSlardarMonitor.monitorStatusAndDuration("vs_video_user_profile_card_first_screen_vs", 0, r114 - this.Q, r115);
        s r116 = this.S;
        String r117 = this.K;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "mUserId");
        HashMap r118 = new HashMap();
        r118.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r117);
        r118.put("vs_click_relation_type", r116.f19561b);
        r118.put("vs_profile_card_position", r116.f19560a);
        r118.putAll(MapsKt.toMap(r116.f19562c));
        d.a(r116.f19564e).d("user_profile_card_show", r118, new Object[0]);
    L26:
        e = move-exception;
        e.printStackTrace();
    L30:
        return this.f109891p;
    L11:
        if (r108 == null) goto L13;
        r108.setBackground(s1.m(R.drawable.ttlive_replay_profile_footer_bg));
        goto L13
    L6:
        if (r106 == null) goto L8;
        r106.setBackground(new ColorDrawable(s1.h(R.color.ttlive_white)));
        goto L8
    }
}
