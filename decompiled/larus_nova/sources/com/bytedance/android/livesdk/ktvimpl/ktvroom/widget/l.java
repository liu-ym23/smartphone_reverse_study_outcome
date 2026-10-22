package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeProgressView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeViewWrapper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvOpusSingerInfoView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l extends LinearLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f145814x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KtvOpusSingerInfoView f145815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KtvRoomChallengeProgressView f145816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f145817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f145818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f145819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<? extends View> f145820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f145821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f145822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f145823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f145824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f145825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<View> f145826l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<View> f145827m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<View> f145828n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<View> f145829o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<KtvRoomChallengeProgressView> f145830p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<View> f145831q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<View> f145832r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList<View> f145833s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final KtvContext f145834t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final KtvRoomViewModel f145835u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LifecycleOwner f145836v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a f145837w;

    public static boolean c() {
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().c() == false) goto L5;
        return true;
    L5:
        IMiddlewareUserService r100 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r100 == null) goto L18;
        com.bytedance.android.livesdk.user.e r101 = r100.user();
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.isAdmin() == false) goto L21;
        UserAttr r102 = r101.q();
        if (r102 == null) goto L22;
        List<Integer> r103 = r102.getAdminPrivileges();
        if (r103 == null) goto L23;
        LiveRoomPermission.D.getClass();
        if (r103.contains(Integer.valueOf(LiveRoomPermission.f105062l.f105077a)) != true) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L18:
        return false;
    }

    public final KtvContext getKtvContext() {
        return this.f145834t;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.f145836v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r100 = (KtvRoomLyricsStateMachineConfig.d) r110.f66101c;
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L7;
    L75:
        setVisibility(8);
    L76:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r101 = this.f145837w;
        if (r101 == null) goto L80;
        r101.c(r110);
        return;
    L80:
        return;
    L7:
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L75;
        this.f145825k.setSelected(r100 instanceof KtvRoomLyricsStateMachineConfig.d.f);
        boolean r102 = false;
        setVisibility(0);
        com.bytedance.android.livesdk.ktvimpl.base.util.j r103 = com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l;
        MusicPanel r104 = r100.b();
        KtvMusic r105 = null;
        if (r104 == null) goto L12;
        KtvMusic r106 = r104.f153577a;
    L13:
        r103.getClass();
        boolean r107 = com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r106);
        KtvOpusSingerInfoView r108 = this.f145815a;
        r108.getClass();
        KtvRoomLyricsStateMachineConfig.d r109 = (KtvRoomLyricsStateMachineConfig.d) r110.f66101c;
        KtvRoomLyricsStateMachineConfig.d r111 = (KtvRoomLyricsStateMachineConfig.d) r110.f66099a;
        if ((r109 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L35;
        r108.T5(0);
        if ((r111 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L31;
        OrderInfo r112 = ((KtvRoomLyricsStateMachineConfig.d.e) r111).f145409b.f153577a.getOrderInfo();
        if (r112 == null) goto L22;
        InteractiveSongUserInfo r113 = r112.getTopUser();
        if (r113 == null) goto L22;
        String r114 = r113.getIdString();
    L23:
        OrderInfo r115 = ((KtvRoomLyricsStateMachineConfig.d.e) r109).f145409b.f153577a.getOrderInfo();
        if (r115 == null) goto L28;
        InteractiveSongUserInfo r116 = r115.getTopUser();
        if (r116 == null) goto L28;
        String r117 = r116.getIdString();
    L30:
        if ((!Intrinsics.areEqual(r114, r117)) == true) goto L31;
    L61:
        if (this.f145834t.isCurrentUserIsSinger() != true) goto L63;
        boolean r118 = true;
    L64:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r119 = this.f145837w;
        if (r119 != null) goto L67;
    L74:
        a(r118, r102, r107);
        d(r102);
        goto L76
    L67:
        if (r119.d() != true) goto L74;
        MusicPanel r120 = r100.b();
        if (r120 == null) goto L72;
        r105 = r120.f153577a;
    L72:
        if (ne2.a.f(r105) == false) goto L74;
        r102 = true;
        goto L74
    L63:
        r118 = false;
    L28:
        r117 = null;
    L22:
        r114 = null;
    L31:
        String r121 = ((KtvRoomLyricsStateMachineConfig.d.e) r109).f145409b.g();
        if (r121 == null) goto L61;
        r108.U5(r121);
        goto L61
    L35:
        if ((r109 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L56;
        if ((r111 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L52;
        OrderInfo r122 = ((KtvRoomLyricsStateMachineConfig.d.f) r111).f145409b.f153577a.getOrderInfo();
        if (r122 == null) goto L43;
        InteractiveSongUserInfo r123 = r122.getTopUser();
        if (r123 == null) goto L43;
        String r124 = r123.getIdString();
    L44:
        OrderInfo r125 = ((KtvRoomLyricsStateMachineConfig.d.f) r109).f145409b.f153577a.getOrderInfo();
        if (r125 == null) goto L49;
        InteractiveSongUserInfo r126 = r125.getTopUser();
        if (r126 == null) goto L49;
        String r127 = r126.getIdString();
    L51:
        if ((!Intrinsics.areEqual(r124, r127)) == false) goto L61;
    L49:
        r127 = null;
    L43:
        r124 = null;
    L52:
        String r128 = ((KtvRoomLyricsStateMachineConfig.d.f) r109).f145409b.g();
        if (r128 == null) goto L61;
        r108.U5(r128);
        goto L61
    L56:
        if ((r109 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L58;
    L59:
        r108.T5(0);
        goto L61
    L58:
        if ((r109 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L61;
    L12:
        r106 = null;
        goto L13
    }

    public final void d(boolean r100) {
        KtvContext.Companion.getClass();
        boolean r101 = KtvContext.a.g().isCurrentUserIsSinger();
        if (r100 == false) goto L5;
        this.f145815a.setSingingInfoVisibility(false);
    L6:
        com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l.getClass();
        a(r101, r100, true ^ com.bytedance.android.livesdk.ktvimpl.base.util.j.a());
        return;
    L5:
        this.f145815a.setSingingInfoVisibility(true);
        goto L6
    }

    public final void a(boolean r100, boolean r101, boolean r102) {
        if (r101 == false) goto L16;
        if (this.f145818d == true) goto L12;
        if (r102 == true) goto L7;
    L9:
        if (r100 == false) goto L11;
        ArrayList<? extends View> r103 = this.f145831q;
    L28:
        if ((!Intrinsics.areEqual(this.f145820f, r103)) == false) goto L33;
        this.f145820f = r103;
        removeAllViews();
        addView(this.f145815a);
        Iterator<T> r104 = r103.iterator();
    L31:
        if (r104.hasNext() == false) goto L35;
        addView((View) r104.next());
        goto L31
    L35:
        return;
    L33:
        return;
    L11:
        r103 = this.f145830p;
        goto L28
    L7:
        if (c() == false) goto L9;
    L12:
        if (r100 == false) goto L14;
        r103 = this.f145832r;
        goto L28
    L14:
        r103 = this.f145833s;
        goto L28
    L16:
        if (this.f145818d == true) goto L24;
        if (r102 == true) goto L19;
    L21:
        if (r100 == false) goto L23;
        r103 = this.f145828n;
        goto L28
    L23:
        r103 = this.f145829o;
        goto L28
    L19:
        if (c() == false) goto L21;
    L24:
        if (r100 == false) goto L26;
        r103 = this.f145826l;
        goto L28
    L26:
        r103 = this.f145827m;
        goto L28
    }

    public l(Context r110, KtvContext r111, KtvRoomInteractViewModel r112, LifecycleOwner r210, KtvRoomChallengeViewWrapper r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER);
        Intrinsics.checkNotNullParameter(r210, "lifecycleOwner");
        super(r110);
        this.f145834t = r111;
        this.f145835u = r112;
        this.f145836v = r210;
        this.f145837w = r211;
        KtvOpusSingerInfoView r100 = new KtvOpusSingerInfoView(r110);
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, com.bytedance.android.live.core.utils.s1.f(30.0f));
        r101.gravity = 16;
        Unit r102 = Unit.INSTANCE;
        r100.setLayoutParams(r101);
        r100.setKtvContext(r111);
        this.f145815a = r100;
        KtvRoomChallengeProgressView r103 = new KtvRoomChallengeProgressView(r110, null, 6, 0);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(com.bytedance.android.live.core.utils.s1.f(200.0f), com.bytedance.android.live.core.utils.s1.f(26.0f));
        r104.gravity = 16;
        r103.setLayoutParams(r104);
        TextView r105 = r103.f144608f;
        if (r105 == null) goto L5;
        r105.setVisibility(8);
    L5:
        r103.f144611i = true;
        this.f145816b = r103;
        CompositeDisposable r106 = new CompositeDisposable();
        this.f145817c = r106;
        sb0.b r107 = r111.getDataEntity().getValue();
        if (r107 != null) goto L8;
    L10:
        boolean r108 = false;
    L11:
        this.f145818d = r108;
        int r109 = com.bytedance.android.live.core.utils.s1.f(20.0f);
        int r113 = com.bytedance.android.live.core.utils.s1.f(5.0f);
        View r114 = new View(r110);
        r114.setBackgroundColor(-1);
        r114.setAlpha(0.5f);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(com.bytedance.android.live.core.utils.s1.f(0.3f), com.bytedance.android.live.core.utils.s1.f(15.0f));
        r115.leftMargin = com.bytedance.android.live.core.utils.s1.f(5.0f);
        r115.rightMargin = com.bytedance.android.live.core.utils.s1.f(5.0f);
        r114.setLayoutParams(r115);
        this.f145819e = r114;
        c r116 = new c(this);
        Intrinsics.checkNotNullParameter(r116, "clickListener");
        View r117 = new View(getContext());
        r117.setBackgroundResource(R.drawable.ttlive_ktv_mv_tone_btn);
        r117.setOnClickListener(r116);
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(r109, r109);
        r118.gravity = 16;
        r118.leftMargin = r113;
        r118.rightMargin = r113;
        r118.topMargin = r113;
        r118.bottomMargin = r113;
        r117.setLayoutParams(r118);
        r3.a(r117, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_live_ktv_tune_title));
        this.f145821g = r117;
        d r119 = new d(this, r110);
        Intrinsics.checkNotNullParameter(r119, "clickListener");
        View r120 = new View(getContext());
        r120.setBackgroundResource(R.drawable.ttlive_ktv_challenge_btn_selector);
        r120.setOnClickListener(r119);
        LinearLayout.LayoutParams r121 = new LinearLayout.LayoutParams(r109, r109);
        r121.gravity = 16;
        r121.leftMargin = r113;
        r121.rightMargin = r113;
        r121.topMargin = r113;
        r121.bottomMargin = r113;
        r120.setLayoutParams(r121);
        this.f145822h = r120;
        j r122 = new j(this);
        Intrinsics.checkNotNullParameter(r122, "clickListener");
        View r123 = new View(getContext());
        r123.setBackgroundResource(R.drawable.ttlive_ktv_component_origin_btn_selector);
        r123.setOnClickListener(r122);
        LinearLayout.LayoutParams r124 = new LinearLayout.LayoutParams(r109, r109);
        r124.gravity = 16;
        r124.leftMargin = r113;
        r124.rightMargin = r113;
        r124.topMargin = r113;
        r124.bottomMargin = r113;
        r123.setLayoutParams(r124);
        this.f145823i = r123;
        e r125 = new e(this);
        Intrinsics.checkNotNullParameter(r125, "clickListener");
        View r126 = new View(getContext());
        r126.setBackgroundResource(R.drawable.ttlive_ktv_mv_switch_next_btn);
        r126.setOnClickListener(r125);
        LinearLayout.LayoutParams r127 = new LinearLayout.LayoutParams(r109, r109);
        r127.gravity = 16;
        r127.leftMargin = r113;
        r127.rightMargin = r113;
        r127.topMargin = r113;
        r127.bottomMargin = r113;
        r126.setLayoutParams(r127);
        r3.a(r126, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_ktv_sing_next_song));
        this.f145824j = r126;
        k r128 = new k(this);
        Intrinsics.checkNotNullParameter(r128, "clickListener");
        View r129 = new View(getContext());
        r129.setBackgroundResource(R.drawable.ttlive_ktv_pause_play_btn_selector);
        r129.setOnClickListener(r128);
        LinearLayout.LayoutParams r130 = new LinearLayout.LayoutParams(r109, r109);
        r130.gravity = 16;
        r130.leftMargin = r113;
        r130.rightMargin = r113;
        r130.topMargin = r113;
        r130.bottomMargin = r113;
        r129.setLayoutParams(r130);
        r3.a(r129, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_interactive_conflict_ktv_confirm));
        this.f145825k = r129;
        TextView r131 = new TextView(r110);
        r131.setTextSize(1, 14.0f);
        r131.setTextColor(-1);
        r131.setTypeface(Typeface.DEFAULT_BOLD);
        r131.setText(R.string.ttlive_ktv_MV);
        LinearLayout.LayoutParams r132 = new LinearLayout.LayoutParams(-2, -2);
        r132.gravity = 16;
        r132.leftMargin = r113;
        r132.rightMargin = r113;
        r132.topMargin = r113;
        r132.bottomMargin = r113;
        r131.setLayoutParams(r132);
        r131.setOnClickListener(new a(this));
        this.f145826l = CollectionsKt.arrayListOf(new View[]{r114, r131, r117, r120});
        this.f145827m = CollectionsKt.arrayListOf(new View[]{r114, r129, r126, r120});
        this.f145828n = CollectionsKt.arrayListOf(new View[]{r114, r123, r126, r131, r117});
        this.f145829o = new ArrayList();
        this.f145830p = CollectionsKt.arrayListOf(new KtvRoomChallengeProgressView[]{r103});
        this.f145831q = CollectionsKt.arrayListOf(new View[]{r103, r117});
        this.f145832r = CollectionsKt.arrayListOf(new View[]{r103, r117, r120});
        this.f145833s = CollectionsKt.arrayListOf(new View[]{r103, r126, r120});
        r100.R5(r210, r112, r106);
        setBackgroundResource(R.drawable.ttlive_bg_ktv_control_area);
        ViewGroup.MarginLayoutParams r133 = new ViewGroup.MarginLayoutParams(-2, com.bytedance.android.live.core.utils.s1.f(30.0f));
        setGravity(16);
        r133.bottomMargin = com.bytedance.android.live.core.utils.s1.f(0.5f);
        setPadding(0, 0, com.bytedance.android.live.core.utils.s1.f(15.0f), 0);
        setLayoutParams(r133);
        setOrientation(0);
        if (r112 == null) goto L16;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r134 = r112.getStateChangeEvent();
        if (r134 == null) goto L16;
        r134.observe(r210, new b(this));
    L16:
        if (r112 == null) goto L20;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r135 = r112.getStateChangeEvent();
        if (r135 == null) goto L20;
        StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r136 = r135.getValue();
    L21:
        b(r136);
        Lazy r137 = KtvCommonSettingHelper.f142336a;
        return;
    L20:
        r136 = null;
        goto L21
    L8:
        if (r107.isAnchor() != true) goto L10;
        r108 = true;
        goto L11
    }
}
