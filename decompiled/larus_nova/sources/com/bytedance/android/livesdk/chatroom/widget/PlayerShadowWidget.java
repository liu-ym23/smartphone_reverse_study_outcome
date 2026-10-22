package com.bytedance.android.livesdk.chatroom.widget;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PlayerShadowWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerShadowWidget extends LiveRecyclableWidget implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a, Observer<KVData> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f118618f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f118619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f118620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IVSPlayerService f118621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CompositeDisposable f118622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vr1.u f118623e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerShadowWidget f118624a;

        public b(PlayerShadowWidget r100) {
            this.f118624a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            PlayerShadowWidget r102 = this.f118624a;
            int r103 = PlayerShadowWidget.f118618f;
            UtilityKotlinExtentionsKt.z(r102.zq(), this.f118624a.Bq());
            UtilityKotlinExtentionsKt.z(this.f118624a.yq(), this.f118624a.Aq());
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerShadowWidget f118625a;

        public c(PlayerShadowWidget r100) {
            this.f118625a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            ViewGroup r102 = this.f118625a.containerView;
            if (r102 == null) goto L6;
            UtilityKotlinExtentionsKt.w(r102);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_player_shadow_widget_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final View yq() {
        return (View) this.f118620b.getValue();
    }

    public final View zq() {
        return (View) this.f118619a.getValue();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.dataCenter.removeObserver(this);
        IVSPlayerService r100 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = r100.provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L7;
        r101.c(PlayerViewControl.KEY.PlayerShadowTop);
        r101.c(PlayerViewControl.KEY.PlayerShadowBottom);
    L7:
        this.f118623e = null;
        this.f118622d.dispose();
    }

    public final boolean xq() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L16;
        IVSPlayerService r101 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r101 == null) goto L17;
        IPlayerProgressService r102 = r101.provideVSProgressService(r100);
        if (r102 == null) goto L18;
        PlayerProgressServiceContext r103 = r102.provideContext(r100);
        if (r103 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r104 = r103.getVsRoomEnableSeek();
        if (r104 != null) goto L13;
        return false;
    L13:
        if (r104.getValue().booleanValue() != true) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    }

    public PlayerShadowWidget() {
        this.f118619a = LazyKt.lazy(new PlayerShadowWidget$shadowTop$2(this));
        this.f118620b = LazyKt.lazy(new PlayerShadowWidget$shadowBottom$2(this));
        this.f118622d = new CompositeDisposable();
    }

    public final boolean Aq() {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().d(this.dataCenter) == true) goto L5;
    L9:
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L20;
        IRoom r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r100);
        if (r101 == null) goto L20;
        if (ju2.e.a(r101) != true) goto L20;
        if (PadConfigUtils.c() == false) goto L20;
        if (CollectionsKt.listOf(new Integer[]{0, 8}).contains(Integer.valueOf(e5.a())) == false) goto L20;
        return false;
    L20:
        vr1.u r102 = this.f118623e;
        if (r102 == null) goto L28;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.A();
        if (r103 == null) goto L28;
        if (r103.getValue().booleanValue() != true) goto L28;
        return xq();
    L28:
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L35;
        IRoom r105 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r104);
        if (r105 == null) goto L35;
        if (r105.isMergeFirstShow() != true) goto L35;
    L44:
        return true;
    L35:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().d(this.dataCenter) == false) goto L46;
        vr1.u r106 = this.f118623e;
        if (r106 == null) goto L43;
        com.bytedance.live.datacontext.m<Boolean> r107 = r106.A();
        if (r107 == null) goto L43;
        if (r107.getValue().booleanValue() != true) goto L43;
        return false;
    L43:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter), PaidSceneEnum.PAID_ROOM, 2) == true) goto L44;
        return false;
    L46:
        return false;
    L5:
        if (PadConfigUtils.c() == false) goto L9;
        if (e5.n() == false) goto L9;
        return false;
    }

    public final boolean Bq() {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().d(this.dataCenter) == true) goto L5;
    L9:
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L20;
        IRoom r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r100);
        if (r101 == null) goto L20;
        if (ju2.e.a(r101) != true) goto L20;
        if (PadConfigUtils.c() == false) goto L20;
        if (CollectionsKt.listOf(new Integer[]{0, 8}).contains(Integer.valueOf(e5.a())) == false) goto L20;
        return false;
    L20:
        vr1.u r102 = this.f118623e;
        if (r102 == null) goto L29;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.A();
        if (r103 == null) goto L29;
        if (r103.getValue().booleanValue() != true) goto L29;
        return xq();
    L29:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter), PaidSceneEnum.PAID_ROOM, 2) == false) goto L59;
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L59;
        IRoom r105 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r104);
        if (r105 == null) goto L59;
        IRoomAuthStatus r106 = r105.getRoomAuthStatus();
        if (r106 == null) goto L59;
        if (r106.getCastScreen() != 1) goto L59;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().isSaas() == false) goto L48;
        yr1.o r107 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.v();
        if (r107 != null) goto L45;
    L47:
        boolean r108 = false;
    L49:
        if (r108 == false) goto L59;
        yr1.b r109 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b();
        if (r109 == null) goto L58;
        com.bytedance.live.datacontext.m<Boolean> r110 = r109.castScreenMode(this.dataCenter);
        if (r110 == null) goto L58;
        if (r110.getValue().booleanValue() == true) goto L59;
    L58:
        boolean r111 = true;
    L60:
        if (r111 == false) goto L62;
    L63:
        vr1.u r112 = this.f118623e;
        if (r112 == null) goto L69;
        com.bytedance.live.datacontext.m<Boolean> r113 = r112.A();
        if (r113 == null) goto L69;
        if (r113.getValue().booleanValue() != true) goto L69;
        return false;
    L69:
        return true;
    L62:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(this.dataCenter, true) == false) goto L63;
        return false;
    L45:
        if (r107.c() != true) goto L47;
        r108 = true;
        goto L49
    L48:
        r108 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().q();
    L59:
        r111 = false;
        goto L60
    L5:
        if (PadConfigUtils.c() == false) goto L9;
        if (e5.n() == false) goto L9;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        PlayerViewControl.KEY r101 = PlayerViewControl.KEY.PlayerShadowBottom;
        if (r100 != r101) goto L55;
        IVSPlayerService r102 = this.f118621c;
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r103 = r102.provideVSPlayerTipService(this.dataCenter);
        if (r103 == null) goto L11;
        PlayerTipsContext r104 = r103.provideVSPlayTipsContext();
        if (r104 == null) goto L11;
        boolean r105 = r104.getPlayerTipShowing();
    L13:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(this.dataCenter, true) == false) goto L21;
        View r106 = yq();
        if (Aq() == true) goto L19;
        if (r105 == true) goto L19;
        boolean r107 = false;
    L20:
        UtilityKotlinExtentionsKt.z(r106, r107);
    L19:
        r107 = true;
    L21:
        IVSPlayerService r108 = this.f118621c;
        Integer r109 = null;
        if (r108 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r110 = r108.provideVSPlayerViewControlService(this.dataCenter);
        if (r110 == null) goto L26;
        Boolean r111 = Boolean.valueOf(r110.getVisibilityStatus());
    L27:
        IVSPlayerService r112 = this.f118621c;
        if (r112 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r113 = r112.provideVSPlayerViewControlService(this.dataCenter);
        if (r113 == null) goto L32;
        NextLiveData<Integer> r114 = r113.g(r101);
    L34:
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == false) goto L45;
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(this.dataCenter, true) == false) goto L43;
        com.bytedance.live.datacontext.m<Boolean> r115 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().castScreenMode(this.dataCenter);
        if (r115 == null) goto L43;
        if (r115.getValue().booleanValue() != true) goto L43;
        if (r105 == true) goto L43;
        return false;
    L43:
        return true;
    L45:
        if (Intrinsics.areEqual(r111, Boolean.FALSE) == false) goto L59;
        if (r114 == null) goto L48;
        r109 = r114.getValue();
    L48:
        if (r109 == null) goto L59;
        if (r109.intValue() != 0) goto L59;
        return !r105;
    L59:
        return true;
    L32:
        r114 = null;
    L26:
        r111 = null;
    L11:
        r105 = false;
        goto L13
    L55:
        if (r100 != PlayerViewControl.KEY.PlayerShadowTop) goto L59;
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(this.dataCenter, true) == false) goto L59;
        UtilityKotlinExtentionsKt.z(zq(), Bq());
        goto L59
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L18;
        String r102 = r101.getKey();
        if (r102.hashCode() == (-1836833765)) goto L8;
        return;
    L8:
        if (r102.equals("cmd_widget_loaded") == false) goto L19;
        IVSPlayerService r103 = this.f118621c;
        if (r103 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r104 = r103.provideVSPlayerTipService(this.dataCenter);
        if (r104 == null) goto L14;
        PlayerTipsContext r105 = r104.provideVSPlayTipsContext();
    L15:
        if (r105 == null) goto L20;
        RxUtilKt.c(r105.getMShowPlayerTipEvent().onEvent().subscribe(new q1(this)), this.f118622d);
        RxUtilKt.c(r105.getMHidePlayerTipEvent().onEvent().subscribe(new r1(this)), this.f118622d);
        return;
    L20:
        return;
    L14:
        r105 = null;
        goto L15
    L19:
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L14;
        IRoom r102 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r101);
        if (r102 != null) goto L7;
        return;
    L7:
        if (ju2.e.a(r102) == true) goto L9;
        return;
    L9:
        if (PadConfigUtils.c() == true) goto L11;
        return;
    L11:
        if (r100.orientation != 2) goto L18;
        UtilityKotlinExtentionsKt.z(zq(), false);
        UtilityKotlinExtentionsKt.z(yq(), false);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        this.f118622d = new CompositeDisposable();
        this.f118623e = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.dataCenter, null, 2);
        DataCenter r100 = this.dataCenter;
        IRoom r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.f118195a;
        Intrinsics.checkNotNullParameter(r100, "$this$common");
        IRoom r102 = (IRoom) r100.get("data_room");
        Object r103 = r100.get("data_is_portrait");
        if (r103 != null) goto L5;
        r103 = Boolean.TRUE;
    L5:
        boolean r104 = ((Boolean) r103).booleanValue();
        Object r105 = r100.get("data_is_anchor");
        if (r105 != null) goto L8;
        r105 = Boolean.FALSE;
    L8:
        ((Boolean) r105).booleanValue();
        if (r104 == false) goto L11;
        int r106 = 80;
    L12:
        int r107 = UtilityKotlinExtentionsKt.i(r106);
        com.bytedance.android.live.core.utils.a1.k(yq(), r107);
        com.bytedance.android.live.core.utils.a1.k(zq(), r107);
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().d(this.dataCenter) == false) goto L25;
        zq().setBackgroundResource(R.drawable.ttlive_vs_player_background_shadow_up_opt);
        yq().setBackgroundResource(R.drawable.ttlive_vs_player_background_shadow_up_opt);
        if (PadConfigUtils.c() == false) goto L25;
        vr1.u r108 = this.f118623e;
        if (r108 == null) goto L25;
        com.bytedance.live.datacontext.n<PadOrientation> r109 = r108.w();
        if (r109 == null) goto L25;
        Observable<sh6.b<PadOrientation>> r111 = r109.a();
        if (r111 == null) goto L25;
        Disposable r112 = r111.subscribe(new b(this));
        if (r112 == null) goto L25;
        RxUtilKt.c(r112, this.f118622d);
    L25:
        IVSPlayerService r113 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        this.f118621c = r113;
        if (r113 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r114 = r113.provideVSPlayerViewControlService(this.dataCenter);
        if (r114 == null) goto L31;
        PlayerViewControl.KEY r115 = PlayerViewControl.KEY.PlayerShadowTop;
        PlayerViewControl.Type r116 = PlayerViewControl.Type.TOP;
        PlayerViewControl.Style r117 = PlayerViewControl.Style.HIDE;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r114, r115, r116, r117, zq(), 0.0f, true, false, this, 336);
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r114, PlayerViewControl.KEY.PlayerShadowBottom, PlayerViewControl.Type.BOTTOM, r117, yq(), 0.0f, true, false, this, 336);
    L31:
        if (Bq() == true) goto L33;
        UtilityKotlinExtentionsKt.t(zq());
    L35:
        if (Aq() == true) goto L37;
        UtilityKotlinExtentionsKt.t(yq());
    L39:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.A().a(this.dataCenter, false) == false) goto L47;
        DataCenter r118 = this.dataCenter;
        if (r118 == null) goto L47;
        IRoom r119 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r118);
        if (r119 == null) goto L47;
        if (r119.isMediaRoom() != true) goto L47;
        UtilityKotlinExtentionsKt.t(zq());
        UtilityKotlinExtentionsKt.t(yq());
    L47:
        this.dataCenter.observe("cmd_widget_loaded", this);
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(this.dataCenter, true) == false) goto L71;
        vr1.u r120 = this.f118623e;
        if (r120 == null) goto L59;
        com.bytedance.live.datacontext.j<Unit> r121 = r120.k();
        if (r121 == null) goto L59;
        if (r121.hasValue() != true) goto L59;
        ViewGroup r122 = this.containerView;
        if (r122 == null) goto L75;
        UtilityKotlinExtentionsKt.w(r122);
        return;
    L75:
        return;
    L59:
        ViewGroup r123 = this.containerView;
        if (r123 == null) goto L62;
        UtilityKotlinExtentionsKt.t(r123);
    L62:
        vr1.u r124 = this.f118623e;
        if (r124 == null) goto L77;
        com.bytedance.live.datacontext.j<Unit> r125 = r124.k();
        if (r125 == null) goto L78;
        Maybe<sh6.b<Unit>> r126 = r125.b();
        if (r126 == null) goto L79;
        Disposable r127 = r126.subscribe(new c(this));
        if (r127 == null) goto L80;
        RxUtilKt.c(r127, this.f118622d);
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L71:
        ViewGroup r128 = this.containerView;
        if (r128 == null) goto L82;
        UtilityKotlinExtentionsKt.w(r128);
        return;
    L82:
        return;
    L37:
        UtilityKotlinExtentionsKt.w(yq());
        goto L39
    L33:
        UtilityKotlinExtentionsKt.w(zq());
        goto L35
    L11:
        r106 = 140;
        goto L12
    }

    public static final void wq(PlayerShadowWidget r100, boolean r101) {
        IVSPlayerService r102 = r100.f118621c;
        Integer r103 = null;
        if (r102 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r104 = r102.provideVSPlayerViewControlService(r100.dataCenter);
        if (r104 == null) goto L7;
        Boolean r105 = Boolean.valueOf(r104.getVisibilityStatus());
    L8:
        IVSPlayerService r106 = r100.f118621c;
        if (r106 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r107 = r106.provideVSPlayerViewControlService(r100.dataCenter);
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
        IVSPlayerService r109 = r100.f118621c;
        if (r109 == null) goto L50;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r110 = r109.provideVSPlayerViewControlService(r100.dataCenter);
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
        IVSPlayerService r112 = r100.f118621c;
        if (r112 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r113 = r112.provideVSPlayerViewControlService(r100.dataCenter);
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
