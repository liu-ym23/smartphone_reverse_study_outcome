package com.bytedance.android.livesdk.chatroom.replay.element;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.player.seekbar.ReplayLandscapeProcessBarWidget;
import com.bytedance.android.livesdk.chatroom.replay.player.seekbar.ReplaySeekBar;
import com.bytedance.android.livesdk.chatroom.replay.player.seekbar.ReplayVerticalProgressBarWidget;
import com.bytedance.android.livesdk.chatroom.replay.player.tips.ReplayPlayTipsWidget;
import com.bytedance.android.livesdk.chatroom.replay.player.viewcontrol.ReplayPlayerViewLockWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.replay.PaidReplayCallback;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/element/ReplayLandscapePlayerTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Luq1/b;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayLandscapePlayerTetris extends LiveTetris<uq1.b> {
    public boolean A;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f108368o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f108369p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f108370q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup f108371r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup f108372s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewGroup f108373t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ReplaySeekBar f108374u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f108375v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewGroup f108376w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public kq1.d f108377x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f108378y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a f108379z;

    public static final class a implements PaidReplayCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLandscapePlayerTetris f108380a;

        public a(ReplayLandscapePlayerTetris r100) {
            this.f108380a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.replay.PaidReplayCallback
        public final void onFreePlayCountDown(long r100) {
            PaidReplayCallback.DefaultImpls.onFreePlayCountDown(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.replay.PaidReplayCallback
        public final void onStateUpdate(int r100) {
            this.f108380a.W();
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLandscapePlayerTetris f108381a;

        public b(ReplayLandscapePlayerTetris r100) {
            this.f108381a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f108381a.V();
        }
    }

    public static final class c implements PaidReplayCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLandscapePlayerTetris f108382a;

        public c(ReplayLandscapePlayerTetris r100) {
            this.f108382a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.replay.PaidReplayCallback
        public final void onFreePlayCountDown(long r100) {
            PaidReplayCallback.DefaultImpls.onFreePlayCountDown(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.replay.PaidReplayCallback
        public final void onStateUpdate(int r100) {
            if (r100 != 2) goto L6;
            this.f108382a.V();
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLandscapePlayerTetris f108383a;

        public d(ReplayLandscapePlayerTetris r100) {
            this.f108383a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f108383a.W();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        com.bytedance.android.livesdk.chatroom.replay.ui.p r101 = (com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class);
        boolean r102 = false;
        if (r101.g() == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        kq1.d r104 = null;
        if (r103 == false) goto L19;
        ReplaySeekBar r105 = this.f108374u;
        if (r105 == null) goto L19;
        ViewGroup r106 = this.f108372s;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L15:
        r106.setTranslationY(0.0f);
        ViewGroup r107 = this.f108372s;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L18:
        LiveTetris.Q(this, ReplayVerticalProgressBarWidget.class, r107, false, new Object[]{r105}, 16);
    L47:
        V();
        ReplayDataContext.a r108 = ReplayDataContext.Companion;
        DataCenter r109 = ((uq1.b) K()).f551201e;
        r108.getClass();
        ReplayDataContext r110 = ReplayDataContext.a.b(r109);
        if (r110 == null) goto L58;
        com.bytedance.live.datacontext.j<kq1.a> r111 = r110.getPaidManager();
        if (r111 == null) goto L58;
        kq1.a r112 = r111.getValue();
        if (r112 == null) goto L58;
        kq1.d r113 = r112.d();
        if (r113 == null) goto L58;
        MutableLiveData<Boolean> r114 = r113.f505584e;
        if (r114 == null) goto L58;
        r114.observe(this, new b(this));
    L58:
        yq1.a r115 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r115 == null) goto L61;
        r115.h(((uq1.b) K()).f551201e, this, new c(this));
    L61:
        ViewGroup r116 = this.f108371r;
        if (r116 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("playerTipContainer");
    L64:
        LiveTetris.Q(this, ReplayPlayTipsWidget.class, r116, false, null, 28);
        com.bytedance.android.livesdk.chatroom.replay.ui.p r117 = (com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class);
        if (r117.g() == true) goto L67;
    L70:
        r102 = true;
    L71:
        if (r102 == false) goto L76;
        ViewGroup r118 = this.f108373t;
        if (r118 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("lockScreenContainer");
    L75:
        LiveTetris.Q(this, ReplayPlayerViewLockWidget.class, r118, false, null, 28);
    L76:
        yq1.a r119 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r119 != null) goto L79;
    L83:
        ReplayDataContext r120 = ReplayDataContext.a.b(((uq1.b) K()).f551201e);
        if (r120 == null) goto L90;
        com.bytedance.live.datacontext.j<kq1.a> r121 = r120.getPaidManager();
        if (r121 == null) goto L90;
        kq1.a r122 = r121.getValue();
        if (r122 == null) goto L90;
        r104 = r122.d();
    L90:
        this.f108377x = r104;
        W();
        kq1.d r123 = this.f108377x;
        if (r123 == null) goto L95;
        NextLiveData<Boolean> r124 = r123.f505581b;
        if (r124 == null) goto L95;
        r124.observe(this, this.f108378y);
    L95:
        kq1.d r125 = this.f108377x;
        if (r125 == null) goto L103;
        MutableLiveData<Boolean> r126 = r125.f505582c;
        if (r126 == null) goto L104;
        r126.observe(this, this.f108378y);
        return;
    L104:
        return;
    L103:
        return;
    L79:
        if (yq1.a.C8372a.a(r119, ((uq1.b) K()).f551201e, null, 2) != true) goto L83;
        W();
        yq1.a r127 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r127 == null) goto L101;
        r127.h(((uq1.b) K()).f551201e, this, this.f108379z);
        return;
    L101:
        return;
    L67:
        if (r117.g() == false) goto L71;
        if (r117.d() == false) goto L71;
    L19:
        ViewGroup r128 = this.f108372s;
        if (r128 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L22:
        ViewGroup.LayoutParams r129 = r128.getLayoutParams();
        if ((r129 instanceof ViewGroup.MarginLayoutParams) == true) goto L25;
        r129 = null;
    L25:
        ViewGroup.MarginLayoutParams r130 = (ViewGroup.MarginLayoutParams) r129;
        if (r130 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.replay.ui.p r131 = (com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class);
        if (r131.g() == true) goto L30;
    L32:
        int r132 = s1.f(12.0f);
    L33:
        r130.setMarginStart(r132);
        com.bytedance.android.livesdk.chatroom.replay.ui.p r133 = (com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class);
        if (r133.g() == true) goto L36;
    L38:
        int r134 = s1.f(12.0f);
    L39:
        r130.setMarginEnd(r134);
        goto L40
    L36:
        if (r133.f() == false) goto L38;
        r134 = s1.f(6.0f);
        goto L39
    L30:
        if (r131.f() == false) goto L32;
        r132 = s1.f(6.0f);
    L40:
        ViewGroup r135 = this.f108372s;
        if (r135 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L43:
        r135.setTranslationY(s1.f(105.0f));
        ViewGroup r136 = this.f108372s;
        if (r136 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L46:
        LiveTetris.Q(this, ReplayLandscapeProcessBarWidget.class, r136, false, null, 28);
        goto L47
    L5:
        if (r101.l() == false) goto L7;
        r103 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V() {
        if (this.A == false) goto L5;
        return;
    L5:
        yq1.a r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        boolean r101 = false;
        Class<? extends Widget> r102 = null;
        if (r100 != null) goto L8;
    L16:
        ReplayDataContext.a r103 = ReplayDataContext.Companion;
        DataCenter r104 = ((uq1.b) K()).f551201e;
        r103.getClass();
        ReplayDataContext r105 = ReplayDataContext.a.b(r104);
        if (r105 == null) goto L27;
        com.bytedance.live.datacontext.j<kq1.a> r106 = r105.getPaidManager();
        if (r106 == null) goto L27;
        kq1.a r107 = r106.getValue();
        if (r107 == null) goto L27;
        kq1.d r108 = r107.d();
        if (r108 == null) goto L27;
        MutableLiveData<Boolean> r109 = r108.f505584e;
        if (r109 == null) goto L27;
        Boolean r110 = r109.getValue();
    L28:
        boolean r111 = !Intrinsics.areEqual(r110, Boolean.FALSE);
    L29:
        if (r111 == true) goto L31;
        return;
    L31:
        this.A = true;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r112 = ReplayRoomFragmentScopeUtil.f117917a;
        com.bytedance.android.livesdk.chatroom.replay.ui.p r113 = (com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class);
        if (r113.g() == false) goto L34;
    L40:
        if (r101 == false) goto L49;
        ViewGroup r114 = this.f108376w;
        mq1.e r115 = mq1.f.a();
        if (r115 == null) goto L44;
        r102 = r115.c();
    L44:
        Class<? extends Widget> r116 = r102;
        if (r114 == null) goto L50;
        if (r116 == null) goto L51;
        LiveTetris.Q(this, r116, r114, false, null, 28);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L34:
        if (r113.l() == false) goto L40;
        mq1.e r117 = mq1.f.a();
        if (r117 == null) goto L40;
        if (r117.a() != true) goto L40;
        r101 = true;
    L27:
        r110 = null;
        goto L28
    L8:
        if (yq1.a.C8372a.a(r100, ((uq1.b) K()).f551201e, null, 2) != true) goto L16;
        yq1.a r118 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r118 != null) goto L12;
    L15:
        r111 = true;
        goto L29
    L12:
        if (r118.E(((uq1.b) K()).f551201e, PaidSceneEnum.ALL, CollectionsKt.listOf(PaidSceneEnum.PAID_REPLAY_PRIVILEGE_CLARITY)) == true) goto L15;
        r111 = false;
        goto L29
    }

    public ReplayLandscapePlayerTetris() {
        this.f108378y = new d(this);
        this.f108379z = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W() {
        yq1.a r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        Boolean r101 = null;
        if (r100 != null) goto L5;
    L19:
        kq1.d r102 = this.f108377x;
        if (r102 == null) goto L24;
        NextLiveData<Boolean> r103 = r102.f505581b;
        if (r103 == null) goto L24;
        Boolean r104 = r103.getValue();
    L25:
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == true) goto L39;
        kq1.d r106 = this.f108377x;
        if (r106 == null) goto L33;
        MutableLiveData<Boolean> r107 = r106.f505582c;
        if (r107 == null) goto L33;
        r101 = r107.getValue();
    L33:
        if (Intrinsics.areEqual(r101, r105) == true) goto L39;
        ViewGroup r108 = this.f108372s;
        if (r108 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L38:
        UtilityKotlinExtentionsKt.j(r108);
        return;
    L39:
        ViewGroup r109 = this.f108372s;
        if (r109 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L42:
        UtilityKotlinExtentionsKt.h(r109);
        return;
    L24:
        r104 = null;
        goto L25
    L5:
        if (yq1.a.C8372a.a(r100, ((uq1.b) K()).f551201e, null, 2) != true) goto L19;
        yq1.a r110 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r110 != null) goto L9;
    L14:
        ViewGroup r111 = this.f108372s;
        if (r111 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L17:
        UtilityKotlinExtentionsKt.j(r111);
        return;
    L9:
        if (r110.s(((uq1.b) K()).f551201e) != true) goto L14;
        ViewGroup r112 = this.f108372s;
        if (r112 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("progressAreaContainer");
    L13:
        UtilityKotlinExtentionsKt.h(r112);
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r101 = ReplayRoomFragmentScopeUtil.f117917a;
        View r102 = r100.b(((com.bytedance.android.livesdk.chatroom.replay.ui.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.p.class)).p());
        this.f108368o = (ViewGroup) r102.findViewById(R.id.play_control_container);
        this.f108369p = (ViewGroup) r102.findViewById(R.id.orientation_control_container);
        this.f108370q = (ViewGroup) r102.findViewById(R.id.error_container);
        this.f108371r = (ViewGroup) r102.findViewById(R.id.play_tip_container);
        this.f108372s = (ViewGroup) r102.findViewById(R.id.progress_area_container);
        this.f108373t = (ViewGroup) r102.findViewById(R.id.player_lock_screen_container);
        this.f108374u = (ReplaySeekBar) r102.findViewById(R.id.pad_vertical_simple_progress_seekbar);
        this.f108375v = (ViewGroup) r102.findViewById(R.id.progress_high_light_container);
        this.f108376w = (ViewGroup) r102.findViewById(R.id.progress_ec_product_container);
        return r102;
    }
}
