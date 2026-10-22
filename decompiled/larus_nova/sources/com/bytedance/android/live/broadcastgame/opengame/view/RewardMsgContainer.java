package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class RewardMsgContainer extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f61266h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f61267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.t f61268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.panel.h f61269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f61270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f61271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f61272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RewardMsgContainer$startHideCountdown$2 f61273g;

    public static final class a {
    }

    static {
    }

    public final void c() {
        h r100 = this.f61267a;
        if (r100 == null) goto L45;
        final m0 r101 = r100.poll();
        if (r101 != null) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, onNewMsg = " + r101);
    L10:
        if (d() == false) goto L31;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L14;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, 已有老的，新的替换老的");
    L14:
        KeyEvent.Callback r102 = this.f61270d;
        if (r102 == null) goto L29;
        ((g) r102).k(new RewardMsgContainer$onNewMsg$3(this));
        KeyEvent.Callback r103 = this.f61271e;
        if (r103 == null) goto L27;
        ((g) r103).setReward(r101);
        KeyEvent.Callback r104 = this.f61271e;
        if (r104 == null) goto L25;
        ((g) r104).o(new RewardMsgContainer$onNewMsg$4(this, r101));
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L23;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, 新老 Item 互换");
    L23:
        View r105 = this.f61270d;
        this.f61270d = this.f61271e;
        this.f61271e = r105;
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    L31:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L33;
        Logger.d("RewardMsgContainer", "RewardMsgContainer,  没有老的，新的直接展示");
    L33:
        com.bytedance.android.live.broadcastgame.opengame.panel.h r106 = this.f61269c;
        if (r106 == null) goto L36;
        r106.M(0);
    L36:
        z.b(this.f61272f);
        KeyEvent.Callback r107 = this.f61270d;
        if (r107 == null) goto L44;
        ((g) r107).setReward(r101);
        KeyEvent.Callback r108 = this.f61270d;
        if (r108 == null) goto L42;
        ((g) r108).j(new RewardMsgContainer$onNewMsg$7(this, r101));
        return;
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    }

    public final boolean d() {
        if (this.f61270d.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, 老 item 正在展示: " + r100);
    L9:
        return r100;
    L5:
        r100 = false;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, cancelHideCountdown");
    L5:
        RewardMsgContainer$startHideCountdown$2 r100 = this.f61273g;
        if (r100 == null) goto L9;
        removeCallbacks(r100);
        return;
    }

    public RewardMsgContainer(final PluginContext r110) {
        Intrinsics.checkNotNullParameter(r110, "pluginContext");
        super(r110.getContext());
        this.f61270d = new RewardItemView(getContext(), new RewardMsgContainer$oldItem$1(r110));
        this.f61271e = new RewardItemView(getContext(), new RewardMsgContainer$newItem$1(r110));
        View r111 = View.inflate(getContext(), R.layout.ttlive_open_platform_audience_panel_reward_msg_view_icon_arrow, this);
        this.f61272f = r111;
        setBackground(getResources().getDrawable(R.drawable.ttlive_bg_open_reward_msg));
        ConstraintLayout r100 = (ConstraintLayout) r111.findViewById(R.id.message_placeholder);
        ConstraintSet r101 = new ConstraintSet();
        r101.clone(r100);
        this.f61270d.setId(View.generateViewId());
        ((ConstraintLayout) r111.findViewById(R.id.message_placeholder)).addView(this.f61270d);
        r101.connect(this.f61270d.getId(), 6, r100.getId(), 6);
        r101.connect(this.f61270d.getId(), 3, r100.getId(), 3);
        r101.connect(this.f61270d.getId(), 4, r100.getId(), 4);
        r101.connect(this.f61270d.getId(), 7, r100.getId(), 7);
        r101.applyTo(r100);
        this.f61271e.setId(View.generateViewId());
        ((ConstraintLayout) r111.findViewById(R.id.message_placeholder)).addView(this.f61271e);
        r101.connect(this.f61271e.getId(), 6, r100.getId(), 6);
        r101.connect(this.f61271e.getId(), 3, r100.getId(), 3);
        r101.connect(this.f61271e.getId(), 4, r100.getId(), 4);
        r101.connect(this.f61271e.getId(), 7, r100.getId(), 7);
        r101.applyTo(r100);
        r111.setVisibility(4);
        this.f61270d.setVisibility(4);
        this.f61271e.setVisibility(4);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.live.broadcastgame.opengame.view.RewardMsgContainer$startHideCountdown$2] */
    public static final void b(final RewardMsgContainer r100) {
        r100.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, startHideCountdown");
    L6:
        if (r100.f61273g != null) goto L8;
        r100.f61273g = new RewardMsgContainer$startHideCountdown$2(r100);
    L8:
        r100.postDelayed(r100.f61273g, 5000);
    }

    public static final void a(RewardMsgContainer r100, int r101) {
        r100.getClass();
        int r102 = com.bytedance.android.live.broadcastgame.api.interactgame.n.f59316a;
        com.bytedance.android.live.broadcastgame.opengame.t r103 = r100.f61268b;
        String r104 = "";
        if (r103 == null) goto L5;
        String r105 = r103.b(false);
    L6:
        com.bytedance.android.live.broadcastgame.opengame.t r106 = r100.f61268b;
        if (r106 == null) goto L12;
        String r107 = String.valueOf(r106.f61082h);
        if (r107 == null) goto L12;
        r104 = r107;
    L12:
        String r108 = ((IUserService) jc1.k.n(IUserService.class)).user().n();
        String r109 = String.valueOf(r101);
        Intrinsics.checkNotNullParameter(r105, "programName");
        Intrinsics.checkNotNullParameter(r104, "programId");
        Intrinsics.checkNotNullParameter(r108, "userId");
        Intrinsics.checkNotNullParameter(r109, "amount");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_program_prop_message_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r104), TuplesKt.to("program_name", r105), TuplesKt.to("user_id", r108), TuplesKt.to("prop_amount", r109)}), new Object[]{Room.class});
        return;
    L5:
        r105 = "";
        goto L6
    }
}
