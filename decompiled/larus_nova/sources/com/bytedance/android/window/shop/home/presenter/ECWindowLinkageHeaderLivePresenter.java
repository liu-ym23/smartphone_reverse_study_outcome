package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.model.ECLiveMode;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.shopping.floatlive.FloatScene;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.window.shop.home.WindowMonitor;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowMuteCtrlPlugin;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowLinkageHeaderLivePresenter;", "Lcom/bytedance/android/window/shop/home/presenter/j;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowLinkageHeaderLivePresenter extends j implements View.OnClickListener, LifecycleObserver {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f188417t = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f188418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SimpleDraweeView f188419n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Float f188420o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f188421p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f188422q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f188423r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function0<Integer> f188424s;

    public static final class a {
    }

    public static final class b implements yn.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f188425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECWindowLinkageHeaderLivePresenter f188426b;

        @Override // yn.t
        public final void a() {
            ECWindowLinkageHeaderLivePresenter.a0(this.f188426b).setVisibility(0);
        }

        @Override // yn.t
        public final void c() {
            ECWindowLinkageHeaderLivePresenter.a0(this.f188426b).setVisibility(0);
            Map<String, com.bytedance.android.ec.core.monitor.a> r100 = com.bytedance.android.ec.core.monitor.c.f45142a;
            MonitorScenes r101 = MonitorScenes.EC_STORE_LIVE_FAIL_MONITOR;
            LinkedHashMap r102 = new LinkedHashMap();
            r102.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW);
            Unit r103 = Unit.INSTANCE;
            com.bytedance.android.ec.core.monitor.c.b(r101, null, r102);
        }

        @Override // yn.t
        public final void onFirstFrame() {
            ECWindowLinkageHeaderLivePresenter.a0(this.f188426b).setVisibility(8);
            if (this.f188426b.O().getShopParam().isFirstFrameReported() == true) goto L11;
            this.f188426b.O().getShopParam().setFirstFrameReported(true);
            WindowMonitor r100 = this.f188426b.O().getShopParam().getMonitor();
            if (r100 == null) goto L7;
            r100.stopFirstFrameTimeMonitor();
        L7:
            ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r101 = com.bytedance.android.window.shop.lifecycle.c.f189233a;
            com.bytedance.android.window.shop.lifecycle.f r102 = com.bytedance.android.window.shop.lifecycle.c.a(this.f188426b.O().getShopParam().getLifecycleMonitorId());
            if (r102 == null) goto L12;
            r102.g(this.f188426b.O().getShopParam());
            return;
        L12:
            return;
        }

        @Override // yn.t
        public final void onPlayComplete() {
            ECWindowLinkageHeaderLivePresenter.a0(this.f188426b).setVisibility(0);
        }

        @Override // yn.t
        public final void onStopped() {
            ECWindowLinkageHeaderLivePresenter.a0(this.f188426b).setVisibility(0);
        }

        public b(ECWindowLinkageHeaderLivePresenter r100) {
            this.f188426b = r100;
        }

        @Override // yn.t
        public final void b(boolean r100) {
            if (this.f188425a == false) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual(this.f188426b.O().isLiveOn().getValue(), Boolean.valueOf(r100))) == false) goto L7;
            this.f188426b.O().isLiveOn().setValue(Boolean.valueOf(r100));
        L7:
            this.f188425a = true;
        }

        @Override // yn.t
        public final void d(boolean r100) {
            if (r100 == false) goto L5;
            ECWindowLinkageHeaderLivePresenter r101 = this.f188426b;
            int r102 = ECWindowLinkageHeaderLivePresenter.f188417t;
            r101.f0();
            ECWindowLinkageHeaderLivePresenter.a0(this.f188426b).setVisibility(0);
        L5:
            if (Intrinsics.areEqual(this.f188426b.O().isLiveOn().getValue(), Boolean.valueOf(r100)) == false) goto L8;
            this.f188426b.O().isLiveOn().setValue(Boolean.valueOf(!r100));
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowLinkageHeaderLivePresenter f188427a;

        public c(ECWindowLinkageHeaderLivePresenter r100) {
            this.f188427a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            final WindowV3LiveRoomVO r110 = (WindowV3LiveRoomVO) r210;
            if (this.f188427a.O().couldLive() == false) goto L29;
            if (r110 == null) goto L30;
            final ECWindowLinkageHeaderLivePresenter r111 = this.f188427a;
            uq3.a r100 = r111.O().getHeaderResponse().getValue();
            if (r100 == null) goto L16;
            uq3.o r101 = r100.f551204c;
            if (r101 == null) goto L16;
            if (r101.a() != true) goto L16;
            boolean r102 = ECServiceManager.f42805a;
            Boolean r103 = ((s83.g) ECServiceManager.c(s83.g.class)).hasLivePlayingMute();
            if (r103 == null) goto L16;
            boolean r112 = r103.booleanValue();
        L17:
            yn.d r113 = r111.O().getLiveManager();
            FloatScene r114 = FloatScene.WINDOW;
            Context r104 = r111.u().c();
            Fragment r105 = r111.u().f450890a;
            View r106 = null;
            if ((r105 instanceof DialogFragment) == true) goto L20;
            r105 = null;
        L20:
            DialogFragment r107 = (DialogFragment) r105;
            View r108 = r111.X();
            if ((r108 instanceof FrameLayout) == false) goto L24;
            r106 = r108;
        L24:
            yn.d.d(r113, r114, false, r110, r112, new yn.m(r104, r107, (FrameLayout) r106, r110, r111.O().getPassThroughLogData(), "1003", r111.O().getShopParam().getSearchParams(), th.a.e(r111.u().c(), true).getResources().getDimensionPixelSize(R.dimen.ec_shop_float_window_bottom_margin), r111.O().getShopParam().getAuthorId()), true, new ECWindowLinkageHeaderLivePresenter$initHeaderLive$1(r111, r110), 64);
            ECWindowLinkageHeaderLivePresenter r109 = this.f188427a;
            r109.getClass();
            String r115 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7635.c4706.d3124", Boolean.FALSE).withView(r109.y()).build());
            ECWindowViewModel r116 = r109.O();
            Pair<String, String>[] r117 = new Pair[5];
            r117[0] = TuplesKt.to("enter_from_merge", "store_page");
            r117[1] = TuplesKt.to("enter_method", "live_cell");
            String r118 = r110.getRoomId();
            if (r118 != null) goto L27;
            r118 = "";
        L27:
            r117[2] = TuplesKt.to("room_id", r118);
            r117[3] = TuplesKt.to("pass_through_log_data", r109.O().getPassThroughLogData());
            r117[4] = TuplesKt.to("btm_id", r115);
            r116.doEventAction("livesdk_live_show", r117);
            this.f188427a.c0(r110);
            ECWindowLinkageHeaderLivePresenter r119 = this.f188427a;
            r119.O().getOffsetState().a(r119.U(), new q1(r119), false);
            return;
        L16:
            r112 = true;
            goto L17
        L30:
            return;
        }
    }

    static {
    }

    public ECWindowLinkageHeaderLivePresenter() {
        this(null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        ((ECWindowMuteCtrlPlugin) this.f188422q.getValue()).b();
        yn.d r100 = O().getLiveManager();
        int r101 = yn.d.f568443q;
        r100.b(false);
        U().getLifecycle().removeObserver(this);
    }

    public final boolean d0() {
        if ((!Intrinsics.areEqual(O().isLiveOn().getValue(), Boolean.FALSE)) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.ec.core.utils.y0.a() == false) goto L7;
        return true;
    }

    public final void f0() {
        yn.d r100 = O().getLiveManager();
        IECLivePlayerClient r101 = r100.f568446c;
        if (r101 == null) goto L5;
        r101.release();
    L5:
        Integer r102 = null;
        r100.f568446c = null;
        int r103 = yn.n.f568491a;
        JSONObject r104 = new JSONObject();
        r104.put("author_id", O().getShopParam().getAuthorId());
        WindowV3LiveRoomVO r105 = O().getLiveInfo().getValue();
        if (r105 == null) goto L8;
        String r106 = r105.getRoomId();
    L9:
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r104.put("room_id", r106);
        IECLivePlayerClient r107 = O().getLiveManager().f568446c;
        if (r107 == null) goto L14;
        r102 = Integer.valueOf(r107.hashCode());
    L14:
        r104.put("client_code", r102);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW);
        Unit r108 = Unit.INSTANCE;
        JSONObject r109 = new JSONObject();
        JSONObject r110 = new JSONObject();
        Intrinsics.checkNotNullParameter("store_header_live_stop", "name");
        int r111 = ECMonitorService.f45110b;
        ECMonitorService.a.a("store_header_live_stop", r104, r109, r110);
        return;
    L8:
        r106 = null;
        goto L9
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        O().getLiveManager().f568455l.clear();
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 == null) goto L7;
        com.bytedance.android.ec.adapter.api.j r102 = r101.getLiveWindowService();
        if (r102 == null) goto L7;
        r102.stopShowFloat();
    L7:
        U().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        f0();
        this.f188421p = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        WindowV3LiveRoomVO r100 = O().getLiveInfo().getValue();
        if (r100 == null) goto L5;
        c0(r100);
    L5:
        this.f188421p = false;
    }

    public ECWindowLinkageHeaderLivePresenter(Function0<Integer> r100) {
        this.f188424s = r100;
        this.f188422q = LazyKt.lazy(new ECWindowLinkageHeaderLivePresenter$muteCtrlPlugin$2(this));
        this.f188423r = new b(this);
    }

    public static final /* synthetic */ SimpleDraweeView a0(ECWindowLinkageHeaderLivePresenter r100) {
        SimpleDraweeView r101 = r100.f188419n;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L5:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if (d0() == true) goto L5;
        return;
    L5:
        this.f188418m = (ViewGroup) w().b(R.id.fl_live_container).f();
        this.f188419n = (SimpleDraweeView) w().b(R.id.iv_live_cover).f();
        ((ECWindowMuteCtrlPlugin) this.f188422q.getValue()).a();
        O().getLiveInfo().e(ECQuickUtilKt.a(u()), new c(this));
        U().getLifecycle().addObserver(this);
    }

    public final le.b b0(WindowV3LiveRoomVO r110) {
        int r100 = yn.a.f568440a;
        int r101 = ECSdk.f48106a;
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r102 == null) goto L9;
        com.bytedance.android.ec.adapter.api.j r103 = r102.getLiveWindowService();
        if (r103 == null) goto L9;
        if (r103.isFloatWindowShowing() != true) goto L9;
        boolean r104 = true;
    L10:
        IECLivePlayerClient r105 = null;
        if (r104 == false) goto L17;
        SimpleDraweeView r106 = this.f188419n;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L15:
        r106.setVisibility(8);
        return null;
    L17:
        yn.d r107 = O().getLiveManager();
        String r108 = r110.getRoomId();
        if (r108 == null) goto L91;
        long r109 = CastLongProtector.parseLong(r108);
        IAdapterService r111 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r111 == null) goto L24;
        IECPlayerViewService r112 = r111.getPlayerViewService();
        if (r112 == null) goto L24;
        le.b r113 = IECPlayerViewService.a.a(r112, u().c(), null, 0, String.valueOf(r109), "ec_feed_window", true, true, 384);
    L25:
        if (r113 == null) goto L91;
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r114 = (com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r113;
        r114.setScaleType(2);
        r114.f42759b.setVisibility(0);
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-1, -1);
        r115.gravity = 17;
        r115.setMargins(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(80));
        Object r116 = u().c().getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r116 instanceof WindowManager) == true) goto L30;
        r116 = null;
    L30:
        WindowManager r117 = (WindowManager) r116;
        if (r117 == null) goto L39;
        Display r118 = r117.getDefaultDisplay();
        if (r118 == null) goto L39;
        Point r119 = new Point();
        r118.getRealSize(r119);
        if (r119.x <= 0) goto L39;
        if (r119.y <= 0) goto L39;
    L40:
        if (r119 == null) goto L45;
        int r120 = r119.x;
        if (r120 <= 0) goto L45;
        r115.width = r120;
        r115.height = (int) ((r120 * 16.0f) / 9.0f);
    L45:
        if (r114.a().isPlaying() == true) goto L94;
        r105 = r114.a();     // Catch: Exception -> L61
    L63:
        String r121 = ECSettingKeys.C().get("ec_feed_window");
        if (r121 != null) goto L66;
        r121 = ECSettingKeys.B().get("ec_feed_window");
    L66:
        Function1<LifecycleOwner, Unit> r122 = new ECWindowLinkageHeaderLivePresenter$createPlayView$2(this);
        r107.f568446c = r105;
        le.a.C6680a r123 = new le.a.C6680a();
        WindowV3LiveRoomVO r124 = r107.f568447d;
        if (r124 == null) goto L70;
        String r125 = r124.getStreamData();
        if (r125 == null) goto L70;
    L71:
        Intrinsics.checkNotNullParameter(r125, "data");
        r123.f508895a = r125;
        if (r121 == null) goto L74;
        Intrinsics.checkNotNullParameter(r121, "resolution");
        r123.f508896b = r121;
    L74:
        ECLiveMode r126 = ECLiveMode.MEDIA;
        Intrinsics.checkNotNullParameter(r126, "streamType");
        r123.f508897c = r126;
        r123.f508902h = r107.f();
        r123.f508900f = true;
        le.a r127 = r123.a();
        if (r105 == null) goto L77;
        r105.stream(r127, r122);
    L77:
        ViewGroup r128 = this.f188418m;
        if (r128 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L81:
        if (r128.getChildCount() <= 1) goto L86;
        ViewGroup r129 = this.f188418m;
        if (r129 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L85:
        r129.removeAllViews();
    L86:
        ViewGroup r130 = this.f188418m;
        if (r130 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L89:
        r130.addView(r114.f42759b, r115);
        return r113;
    L70:
        r125 = "";
    L61:
        e = move-exception;
        e.toString();
        goto L63
    L94:
        r105 = r114.a();     // Catch: Exception -> L48
    L51:
        if (r107.e() == true) goto L77;
        r107.f568446c = r105;
        if (r105 == null) goto L57;
        r105.resumePlay();
    L57:
        if (r107.f() == false) goto L77;
        r107.h(true);
    L48:
        e = move-exception;
        e.toString();
    L39:
        r119 = null;
    L24:
        r113 = null;
    L91:
        return null;
    L9:
        r104 = false;
        goto L10
    }

    public final void c0(WindowV3LiveRoomVO r100) {
        if (d0() == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.ec.core.utils.y0.a() == false) goto L34;
        SimpleDraweeView r101 = this.f188419n;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L11:
        r101.setVisibility(0);
        le.b r102 = b0(r100);
        if (r102 == null) goto L34;
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r103 = (com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r102;
        if (r103.a().isPlaying() == false) goto L23;
        e0(r103.a().getLifecycleOwner());
        this.f188423r.f188425a = true;
        Boolean r104 = O().isLiveOn().getValue();
        Boolean r105 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r104, r105)) == false) goto L19;
        O().isLiveOn().setValue(r105);
    L19:
        SimpleDraweeView r106 = this.f188419n;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L22:
        r106.setVisibility(8);
    L23:
        int r107 = yn.n.f568491a;
        JSONObject r108 = new JSONObject();
        r108.put("author_id", O().getShopParam().getAuthorId());
        WindowV3LiveRoomVO r109 = O().getLiveInfo().getValue();
        if (r109 == null) goto L26;
        String r110 = r109.getRoomId();
    L27:
        if (r110 != null) goto L29;
        r110 = "";
    L29:
        r108.put("room_id", r110);
        IECLivePlayerClient r111 = O().getLiveManager().f568446c;
        if (r111 == null) goto L32;
        Integer r112 = Integer.valueOf(r111.hashCode());
    L33:
        r108.put("client_code", r112);
        r108.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW);
        Unit r113 = Unit.INSTANCE;
        JSONObject r114 = new JSONObject();
        Intrinsics.checkNotNullParameter("store_header_live_start", "name");
        int r115 = ECMonitorService.f45110b;
        ECMonitorService.a.a("store_header_live_start", r108, r114, null);
        goto L34
    L32:
        r112 = null;
        goto L33
    L26:
        r110 = null;
    L34:
        ECUrlModel r116 = r100.getCover();
        if (r116 == null) goto L40;
        SimpleDraweeView r117 = this.f188419n;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L39:
        com.bytedance.android.ec.core.utils.y.a(r117, r116);
    L40:
        O().setJump2Live(new ECWindowLinkageHeaderLivePresenter$initLiveAbout$2(this));
        ViewGroup r118 = this.f188418m;
        if (r118 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L43:
        r118.setOnClickListener(this);
    }

    public final void e0(LifecycleOwner r100) {
        yn.d r101 = O().getLiveManager();
        Context r102 = u().c();
        b r103 = this.f188423r;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "listener");
        IECLivePlayerClient r104 = r101.f568446c;
        if (r104 == null) goto L6;
        td.e r105 = r104.getEventHub();
        r105.getPlayPrepared().observe(r100, new yn.f(r100, r103));
        r105.getFirstFrame().observe(r100, new yn.g(r100, r103));
        r105.getStopped().observe(r100, new yn.h(r100, r103));
        r105.getReleased().observe(r100, new yn.i(r100, r103));
        r105.getPlayComplete().observe(r100, new yn.j(r100, r103));
        r105.getLiveEnd().observe(r100, new yn.k(r101, r100, r103));
        r105.getPlayerMediaError().observe(r100, new yn.l(r100, r103));
        return;
    }
}
