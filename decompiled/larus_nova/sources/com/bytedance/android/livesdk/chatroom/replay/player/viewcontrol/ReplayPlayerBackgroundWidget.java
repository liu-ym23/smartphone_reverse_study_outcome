package com.bytedance.android.livesdk.chatroom.replay.player.viewcontrol;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.replay.ui.o;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayStatusBarUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.chatroom.vs_base.util.k;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.e0;
import mq1.p;
import mq1.t;
import mq1.u;
import mq1.v;
import tq1.g;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/player/viewcontrol/ReplayPlayerBackgroundWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lmq1/e0;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPlayerBackgroundWidget extends LiveRecyclableWidget implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a, Observer<KVData>, e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f109850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f109851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f109852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f109853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f109854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompositeDisposable f109855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ReplayDataContext f109856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VideoViewParams f109857h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_player_background;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // mq1.e0
    public final void qj() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.dataCenter.removeObserver(this);
        t r100 = this.f109854e;
        if (r100 == null) goto L7;
        v r101 = r100.provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L7;
        r101.c(PlayerViewControl.KEY.PlayerShadow);
        r101.c(PlayerViewControl.KEY.PlayerShadowTop);
        r101.c(PlayerViewControl.KEY.PlayerShadowBottom);
    L7:
        t r102 = this.f109854e;
        if (r102 == null) goto L12;
        p r103 = r102.a(this.dataCenter);
        if (r103 == null) goto L12;
        r103.unregisterReplaySwitchListener(this);
    L12:
        this.f109854e = null;
        this.f109856g = null;
        this.f109855f.dispose();
    }

    public final void xq() {
        UtilityKotlinExtentionsKt.h((View) this.f109852c.getValue());
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        o r101 = (o) ReplayRoomFragmentScopeUtil.a(o.class);
        DataCenter r102 = this.dataCenter;
        boolean r103 = false;
        ViewGroup.LayoutParams r104 = null;
        if (r101.l() == false) goto L24;
        if (r101.g() == true) goto L24;
        int r105 = lr1.a.f510387b;
        lr1.a r106 = lr1.a.C6730a.a(r102);
        r106.getClass();
        int r107 = r106.a();
        float r108 = 74.0f;
        if (r107 != 3) goto L9;
    L22:
        Integer r109 = Integer.valueOf(s1.f(r108));
    L27:
        if (r109 == null) goto L29;
        k.c((View) this.f109851b.getValue(), r109.intValue());
    L29:
        ReplayStatusBarUIState r110 = (ReplayStatusBarUIState) ReplayRoomFragmentScopeUtil.a(ReplayStatusBarUIState.class);
        int r111 = r110.r(this.context, this.dataCenter, r110.d());
        o r112 = (o) ReplayRoomFragmentScopeUtil.a(o.class);
        View r113 = this.contentView;
        View r114 = (View) this.f109850a.getValue();
        View r115 = (View) this.f109851b.getValue();
        View r116 = (View) this.f109853d.getValue();
        VideoViewParams r117 = this.f109857h;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "contentView");
        Intrinsics.checkNotNullParameter(r114, "shadowTop");
        Intrinsics.checkNotNullParameter(r115, "shadowBottom");
        Intrinsics.checkNotNullParameter(r116, GXViewKey.VIEW_TYPE_SHADOW_LAYOUT);
        if (r112.l() == false) goto L37;
        k.b(r114, UtilityKotlinExtentionsKt.c(200));
        k.b(r115, UtilityKotlinExtentionsKt.c(260));
        r114.setBackgroundResource(R.drawable.ttlive_vs_vertical_shadow_top_bg);
        r115.setBackgroundResource(R.drawable.ttlive_vs_vertical_shadow_bottom_bg);
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == true) goto L34;
    L41:
        if (r117 == null) goto L59;
        ViewGroup.LayoutParams r118 = r113.getLayoutParams();
        if ((r118 instanceof FrameLayout.LayoutParams) == false) goto L47;
        r104 = r118;
    L47:
        FrameLayout.LayoutParams r119 = (FrameLayout.LayoutParams) r104;
        if (r119 == null) goto L59;
        if (r112.l() == false) goto L55;
        if (r112.g() == true) goto L55;
        r119.topMargin = r117.f112571c;
        r119.height = r117.f112570b + r111;
    L58:
        r113.setLayoutParams(r119);
    L55:
        if (r112.d() == true) goto L57;
        r119.topMargin = r117.f112571c + r111;
        r119.height = r117.f112570b;
        goto L58
    L57:
        r119.topMargin = r117.f112571c;
        r119.height = r117.f112570b;
    L59:
        o r120 = (o) ReplayRoomFragmentScopeUtil.a(o.class);
        if (r120.l() == false) goto L64;
        if (r120.g() == true) goto L64;
    L65:
        r103 = true;
    L66:
        if (r103 == true) goto L68;
        UtilityKotlinExtentionsKt.h((View) this.f109850a.getValue());
    L69:
        t r121 = this.f109854e;
        if (r121 == null) goto L75;
        v r122 = r121.provideVSPlayerViewControlService(this.dataCenter);
        if (r122 == null) goto L76;
        PlayerViewControl.KEY r123 = PlayerViewControl.KEY.PlayerShadow;
        PlayerViewControl.Type r124 = PlayerViewControl.Type.ALPHA;
        PlayerViewControl.Style r125 = PlayerViewControl.Style.HIDE;
        v.a.a(r122, r123, r124, r125, (View) this.f109853d.getValue(), 0.0f, true, this, 336);
        v.a.a(r122, PlayerViewControl.KEY.PlayerShadowTop, PlayerViewControl.Type.TOP, r125, (View) this.f109850a.getValue(), 0.0f, true, this, 336);
        v.a.a(r122, PlayerViewControl.KEY.PlayerShadowBottom, PlayerViewControl.Type.BOTTOM, r125, (View) this.f109851b.getValue(), 0.0f, true, this, 336);
        return;
    L76:
        return;
    L75:
        return;
    L68:
        UtilityKotlinExtentionsKt.j((View) this.f109850a.getValue());
    L64:
        if (r120.d() == false) goto L66;
    L34:
        if (r112.a() == false) goto L41;
        r115.setVisibility(8);
        goto L41
    L37:
        if (r112.c() == false) goto L39;
        int r126 = UtilityKotlinExtentionsKt.c(80);
    L40:
        k.b(r115, r126);
        k.b(r114, r126);
        goto L41
    L39:
        r114.setBackgroundResource(R.drawable.ttlive_vs_player_background_shadow_up_opt);
        r115.setBackgroundResource(R.drawable.ttlive_vs_player_background_shadow_up_opt);
        r126 = UtilityKotlinExtentionsKt.c(150);
        goto L40
    L9:
        if (r107 != 5) goto L11;
        ReplayDataContext.a r127 = ReplayDataContext.Companion;
        DataCenter r128 = r106.f510388a;
        r127.getClass();
        ReplayDataContext r129 = ReplayDataContext.a.b(r128);
        if (r129 == null) goto L21;
        j<Float> r130 = r129.getPlayerControllerBottomMargin();
        if (r130 == null) goto L21;
        Float r131 = r130.getValue();
        if (r131 == null) goto L21;
        r108 = r131.floatValue();
    L21:
        r108 = (r108 + 20.0f) - 8.0f;
        goto L22
    L11:
        if (r107 == 7) goto L13;
        r108 = 0.0f;
        goto L22
    L13:
        r108 = 86.0f;
    L24:
        if (r101.g() == false) goto L26;
        r109 = 0;
        goto L27
    L26:
        r109 = null;
        goto L27
    }

    public ReplayPlayerBackgroundWidget() {
        this.f109850a = LazyKt.lazy(new ReplayPlayerBackgroundWidget$shadowTop$2(this));
        this.f109851b = LazyKt.lazy(new ReplayPlayerBackgroundWidget$shadowBottom$2(this));
        this.f109852c = LazyKt.lazy(new ReplayPlayerBackgroundWidget$verticalShadow$2(this));
        this.f109853d = LazyKt.lazy(new ReplayPlayerBackgroundWidget$shadow$2(this));
        this.f109855f = new CompositeDisposable();
    }

    @Override // mq1.e0
    public final void FY(g r100) {
        t r101 = this.f109854e;
        if (r101 == null) goto L7;
        v r102 = r101.provideVSPlayerViewControlService(this.dataCenter);
        if (r102 == null) goto L7;
        r102.c(PlayerViewControl.KEY.PlayerShadow);
        r102.c(PlayerViewControl.KEY.PlayerShadowTop);
        r102.c(PlayerViewControl.KEY.PlayerShadowBottom);
    L7:
        xq();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        PlayerViewControl.KEY r101 = PlayerViewControl.KEY.PlayerShadowBottom;
        if (r100 != r101) goto L48;
        t r102 = this.f109854e;
        if (r102 == null) goto L11;
        u r103 = r102.provideVSPlayerTipService(this.dataCenter);
        if (r103 == null) goto L11;
        PlayerTipsContext r104 = r103.provideVSPlayTipsContext();
        if (r104 == null) goto L11;
        boolean r105 = r104.getPlayerTipShowing();
    L12:
        t r106 = this.f109854e;
        Integer r107 = null;
        if (r106 == null) goto L17;
        v r108 = r106.provideVSPlayerViewControlService(this.dataCenter);
        if (r108 == null) goto L17;
        Boolean r109 = Boolean.valueOf(r108.getVisibilityStatus());
    L18:
        t r110 = this.f109854e;
        if (r110 == null) goto L23;
        v r111 = r110.provideVSPlayerViewControlService(this.dataCenter);
        if (r111 == null) goto L23;
        NextLiveData<Integer> r112 = r111.g(r101);
    L25:
        if (Intrinsics.areEqual(r109, Boolean.TRUE) == false) goto L38;
        if (h.d(this.dataCenter, true) == true) goto L29;
    L36:
        return true;
    L29:
        if (this.f109856g == null) goto L36;
        m<Boolean> r113 = r.b().castScreenMode(this.dataCenter);
        if (r113 == null) goto L36;
        if (r113.getValue().booleanValue() != true) goto L36;
        if (r105 == true) goto L36;
        return false;
    L38:
        if (Intrinsics.areEqual(r109, Boolean.FALSE) == false) goto L59;
        if (r112 == null) goto L41;
        r107 = r112.getValue();
    L41:
        if (r107 == null) goto L59;
        if (r107.intValue() != 0) goto L59;
        return !r105;
    L59:
        return true;
    L23:
        r112 = null;
    L17:
        r109 = null;
    L11:
        r105 = false;
        goto L12
    L48:
        if (r100 != PlayerViewControl.KEY.PlayerShadowTop) goto L59;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r114 = ReplayRoomFragmentScopeUtil.f117917a;
        o r115 = (o) ReplayRoomFragmentScopeUtil.a(o.class);
        if (r115.l() == false) goto L54;
        if (r115.g() == true) goto L54;
    L55:
        boolean r116 = true;
    L57:
        if (r116 == true) goto L59;
        UtilityKotlinExtentionsKt.k((View) this.f109850a.getValue(), false);
    L54:
        if (r115.d() == true) goto L55;
        r116 = false;
        goto L57
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L26;
        String r102 = r101.getKey();
        int r103 = r102.hashCode();
        if (r103 == (-1882223254)) goto L20;
        if (r103 == (-1836833765)) goto L10;
        return;
    L10:
        if (r102.equals("cmd_widget_loaded") == false) goto L27;
        t r104 = this.f109854e;
        if (r104 == null) goto L16;
        u r105 = r104.provideVSPlayerTipService(this.dataCenter);
        if (r105 == null) goto L16;
        PlayerTipsContext r106 = r105.provideVSPlayTipsContext();
    L17:
        if (r106 == null) goto L28;
        RxUtilKt.c(r106.getMShowPlayerTipEvent().onEvent().subscribe(new com.bytedance.android.livesdk.chatroom.replay.player.viewcontrol.a(r106, this)), this.f109855f);
        RxUtilKt.c(r106.getMHidePlayerTipEvent().onEvent().subscribe(new b(r106, this)), this.f109855f);
        return;
    L28:
        return;
    L16:
        r106 = null;
        goto L17
    L27:
        return;
    L20:
        if (r102.equals("live_render_view_params") == false) goto L30;
        VideoViewParams r107 = (VideoViewParams) r101.getData();
        if (r107 == null) goto L32;
        this.f109857h = r107;
        xq();
        return;
    L32:
        return;
    L30:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f109855f = new CompositeDisposable();
        ReplayDataContext.a r101 = ReplayDataContext.Companion;
        DataCenter r102 = this.dataCenter;
        r101.getClass();
        this.f109856g = ReplayDataContext.a.b(r102);
        t r103 = s.e();
        this.f109854e = r103;
        if (r103 == null) goto L7;
        p r104 = r103.a(this.dataCenter);
        if (r104 == null) goto L7;
        r104.registerReplaySwitchListener(this, false);
    L7:
        xq();
        this.dataCenter.observe("cmd_widget_loaded", this);
        this.dataCenter.observe("vs_link_room_data", this, true);
        this.dataCenter.observe("vs_data_update_link_room_info", this, true);
        this.dataCenter.observe("live_render_view_params", this, true);
    }

    public static final void wq(ReplayPlayerBackgroundWidget r100, boolean r101) {
        t r102 = r100.f109854e;
        Integer r103 = null;
        if (r102 == null) goto L7;
        v r104 = r102.provideVSPlayerViewControlService(r100.dataCenter);
        if (r104 == null) goto L7;
        Boolean r105 = Boolean.valueOf(r104.getVisibilityStatus());
    L8:
        t r106 = r100.f109854e;
        if (r106 == null) goto L13;
        v r107 = r106.provideVSPlayerViewControlService(r100.dataCenter);
        if (r107 == null) goto L13;
        NextLiveData<Integer> r108 = r107.g(PlayerViewControl.KEY.PlayerShadowBottom);
    L14:
        if (r101 == false) goto L16;
    L29:
        if (r101 == true) goto L31;
        return;
    L31:
        if (Intrinsics.areEqual(r105, Boolean.FALSE) == false) goto L48;
        if (r108 == null) goto L34;
        r103 = r108.getValue();
    L34:
        if (r103 != null) goto L37;
        return;
    L37:
        if (r103.intValue() != 1) goto L49;
        t r109 = r100.f109854e;
        if (r109 == null) goto L50;
        v r110 = r109.provideVSPlayerViewControlService(r100.dataCenter);
        if (r110 == null) goto L51;
        r110.d(PlayerViewControl.KEY.PlayerShadowBottom, true);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L16:
        if (Intrinsics.areEqual(r105, Boolean.FALSE) == false) goto L29;
        if (r108 == null) goto L19;
        Integer r111 = r108.getValue();
    L20:
        if (r111 == null) goto L29;
        if (r111.intValue() != 0) goto L29;
        t r112 = r100.f109854e;
        if (r112 == null) goto L44;
        v r113 = r112.provideVSPlayerViewControlService(r100.dataCenter);
        if (r113 == null) goto L45;
        r113.d(PlayerViewControl.KEY.PlayerShadowBottom, false);
        return;
    L45:
        return;
    L44:
        return;
    L19:
        r111 = null;
    L13:
        r108 = null;
    L7:
        r105 = null;
        goto L8
    }
}
