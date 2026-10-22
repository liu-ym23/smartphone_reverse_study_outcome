package com.bytedance.android.livesdk.chatroom.tetris.landscape;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.NewLandscapeShortTermWidget;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.i3;
import com.bytedance.android.livesdk.chatroom.viewmodule.TopRightBannerWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.dynamic.IDynamicExternalService;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MatchDrawer;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.n3;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/landscape/LandscapeTopRightActivityBannerTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopRightActivityBannerTetris extends LiveTetris<d90.d> implements o70.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f111700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f111701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f111702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup f111703r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WidgetElement f111704s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f111705t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f111706u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f111707v;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeTopRightActivityBannerTetris f111708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f111709b;

        public a(LandscapeTopRightActivityBannerTetris r100, Room r101) {
            this.f111708a = r100;
            this.f111709b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup r100 = this.f111708a.f111700o;     // Catch: Throwable -> L18
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");     // Catch: Throwable -> L18
        L5:
            LandscapeTopRightActivityBannerTetris r101 = this.f111708a;     // Catch: Throwable -> L18
            Room r102 = this.f111709b;     // Catch: Throwable -> L18
            r101.getClass();     // Catch: Throwable -> L18
            int r103 = 0;
            if (r102 == null) goto L12;
            RoomAuthStatus r104 = r102.getMRoomAuthStatus();     // Catch: Throwable -> L18
            if (r104 == null) goto L12;
            boolean r105 = true;
            if (r104.enableBanner() != true) goto L12;
        L13:
            if (r105 == true) goto L16;
            r103 = 8;
        L16:
            r100.setVisibility(r103);     // Catch: Throwable -> L18
            return;
        L12:
            r105 = false;
        L18:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L22;
            return;
        L22:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeTopRightActivityBannerTetris f111710a;

        public b(LandscapeTopRightActivityBannerTetris r100) {
            this.f111710a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r100 = (com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d) this.f111710a.f111706u.getValue();     // Catch: Throwable -> L4
            g r101 = (g) this.f111710a.f111705t.getValue();     // Catch: Throwable -> L4
            boolean r102 = this.f111710a.f111707v;     // Catch: Throwable -> L4
            r101.Yb(8);     // Catch: Throwable -> L4
            RoomTopRightBannerEvent r103 = new RoomTopRightBannerEvent();     // Catch: Throwable -> L4
            r103.setStatus(1);     // Catch: Throwable -> L4
            r103.setAnimationTime(250);     // Catch: Throwable -> L4
            i3.e(r100, r101, r103, r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeTopRightActivityBannerTetris f111711a;

        public c(LandscapeTopRightActivityBannerTetris r100) {
            this.f111711a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LandscapeTopRightActivityBannerTetris r100 = this.f111711a;     // Catch: Throwable -> L4
            i3.b((com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d) r100.f111706u.getValue(), (g) r100.f111705t.getValue(), r100.f111707v);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeTopRightActivityBannerTetris f111712a;

        public d(LandscapeTopRightActivityBannerTetris r100) {
            this.f111712a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            LandscapeTopRightActivityBannerTetris r100 = this.f111712a;     // Catch: Throwable -> L4
            r100.V((d90.d) r100.K(), true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeTopRightActivityBannerTetris f111713a;

        public e(LandscapeTopRightActivityBannerTetris r100) {
            this.f111713a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RoomTopRightBannerEvent r101 = (RoomTopRightBannerEvent) r100;
            LandscapeTopRightActivityBannerTetris r102 = this.f111713a;
            ViewGroup r103 = r102.f111700o;
            if (r103 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
        L6:
            if (r103.findViewById(R.id.activity_top_right_banner_widget_container) == null) goto L13;
            ViewGroup r104 = r102.f111700o;
            if (r104 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
        L11:
            r104.post(new com.bytedance.android.livesdk.chatroom.tetris.landscape.a(r102, r101));
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeTopRightActivityBannerTetris f111714a;

        public f(LandscapeTopRightActivityBannerTetris r100) {
            this.f111714a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            n3 r101 = (n3) r100;
            boolean r102 = false;
            if (VrUtils.t(((d90.d) this.f111714a.K()).f467480h, false) == false) goto L12;
            LandscapeTopRightActivityBannerTetris r103 = this.f111714a;
            if (r101 != null) goto L8;
        L9:
            r102 = true;
        L10:
            r103.W(r102);
            return;
        L8:
            if (r101.f571889a == true) goto L10;
        }
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{yn1.a.class, yn1.f.class, yn1.d.class, yn1.b.class});
    }

    public LandscapeTopRightActivityBannerTetris() {
        this.f111705t = LazyKt.lazy(new LandscapeTopRightActivityBannerTetris$mTopRightBanner$2(this));
        this.f111706u = LazyKt.lazy(new LandscapeTopRightActivityBannerTetris$bannerViewHolder$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        this.f111707v = d90.e.c((d90.d) K());
        Room r100 = d90.e.j((d90.d) K());
        if (r100 == null) goto L5;
        r100.getStreamType();
    L5:
        d90.d r101 = (d90.d) K();
        Intrinsics.checkNotNullParameter(r101, "$this$middlewareEnableLandscapeDrawerEntrance");
        Intrinsics.checkNotNullParameter(r101, "$this$isVSSpecialDrawer");
        MiddlewareRoomContext.a r102 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r103 = MiddlewareRoomContext.a.c(r102, r101.f467480h, 0, 2);
        boolean r104 = false;
        if (r103 != null) goto L8;
    L10:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L33;
        Intrinsics.checkNotNullParameter(r101, "$this$isVSSpecialDrawerSupportLandscape");
        Integer[] r106 = {3, 2};
        Room r107 = d90.e.j(r101);
        if (r107 == null) goto L24;
        EpisodeExtraInfo r108 = r107.getEpisodeExtra2();
        if (r108 == null) goto L24;
        VSConfigDrawer r109 = r108.getVsConfigDrawer();
        if (r109 == null) goto L24;
        MatchDrawer r110 = r109.drawer;
        if (r110 == null) goto L24;
        Integer r111 = r110.getDisplayMode();
        if (r111 == null) goto L24;
        int r112 = r111.intValue();
    L26:
        if (ArraysKt.contains(r106, Integer.valueOf(r112)) == true) goto L28;
    L30:
        boolean r113 = false;
    L31:
        if (r113 == false) goto L33;
        boolean r114 = true;
    L34:
        if (r114 == true) goto L37;
        V((d90.d) K(), false);
    L37:
        if (d90.e.d((d90.d) K()) == false) goto L41;
        if (VSMediaUIConfigHelper.c((d90.d) K()) == true) goto L41;
    L56:
        if (yx1.a.b(d90.e.j((d90.d) K())) == false) goto L62;
        IDynamicExternalService r115 = (IDynamicExternalService) k.f(IDynamicExternalService.class);
        if (r115 == null) goto L62;
        Class<? extends Widget> r116 = r115.getGameGuessPredictorWidget();
        if (r116 == null) goto L62;
        LiveTetris.Q(this, r116, (ViewGroup) L().findViewById(R.id.landscape_predictor_entrance_container), true, null, 24);
    L62:
        ((ObservableSubscribeProxy) xs2.b.a().b(RoomTopRightBannerEvent.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new e(this));
        if (VrUtils.t(((d90.d) K()).f467480h, false) == false) goto L73;
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(((d90.d) K()).f467480h).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new f(this));
        MiddlewareRoomContext r117 = MiddlewareRoomContext.a.c(r102, null, 0, 3);
        if (r117 == null) goto L70;
        m<Boolean> r118 = r117.getVrInImmersedMode();
        if (r118 == null) goto L70;
        if (r118.getValue().booleanValue() != true) goto L70;
    L71:
        W(r104);
    L70:
        r104 = true;
    L73:
        if (LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue().e() == false) goto L87;
        ViewGroup r119 = this.f111702q;
        if (r119 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("shortTermContainer");
    L78:
        if ((r119 instanceof MeasureOptFrameLayout) == false) goto L87;
        ViewGroup r120 = this.f111702q;
        if (r120 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("shortTermContainer");
    L82:
        if (r120 == null) goto L85;
        ((MeasureOptFrameLayout) r120).setHasFixSize(true);
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_short_touch", "shortterm measure opt enabled");
        goto L87
    L85:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout");
    L87:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((d90.d) K()).f467480h) == false) goto L96;
        ViewGroup r121 = this.f111703r;
        if (r121 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("bannerContainer");
    L91:
        a1.m(r121, s1.f(8.0f));
        ViewGroup r122 = this.f111702q;
        if (r122 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("shortTermContainer");
    L94:
        LiveTetris.Q(this, NewLandscapeShortTermWidget.class, r122, false, null, 24);
        return;
    L96:
        return;
    L41:
        if (VSMediaUIConfigHelper.c((d90.d) K()) == false) goto L51;
        Room r123 = d90.e.j((d90.d) K());
        if (r123 == null) goto L49;
        RoomAuthStatus r124 = r123.getMRoomAuthStatus();
        if (r124 == null) goto L49;
        if (r124.enableLongTouch() != true) goto L49;
        boolean r125 = true;
    L50:
        if (r125 == false) goto L56;
    L49:
        r125 = false;
    L51:
        ViewGroup r126 = this.f111701p;
        if (r126 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("topLeftTaskBanner");
    L54:
        LiveTetris.Q(this, TopRightBannerWidget.class, r126, true, null, 24);
        goto L56
    L28:
        if (oj1.f120911a.getValue().c() == false) goto L30;
        r113 = true;
    L24:
        r112 = 0;
    L33:
        r114 = false;
        goto L34
    L8:
        if (r103.isVSSpecialDrawer() != true) goto L10;
        r105 = true;
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_layout_landscape_right_top_banner_container);
        View r102 = r101.findViewById(R.id.landscape_top_left_activity_banner);
        Intrinsics.checkNotNull(r102);
        this.f111700o = (ViewGroup) r102;
        View r103 = r101.findViewById(R.id.landscape_top_left_task_banner);
        Intrinsics.checkNotNull(r103);
        this.f111701p = (ViewGroup) r103;
        this.f111702q = (ViewGroup) r101.findViewById(R.id.short_term_indicator_container_new);
        this.f111703r = (ViewGroup) r101.findViewById(R.id.banner_container);
        return r101;
    }

    public final void W(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        ViewGroup r102 = this.f111702q;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("shortTermContainer");
    L8:
        r102.setVisibility(r101);
        ViewGroup r103 = this.f111703r;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bannerContainer");
    L11:
        r103.setVisibility(r101);
        ViewGroup r104 = this.f111701p;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("topLeftTaskBanner");
    L14:
        r104.setVisibility(r101);
        ViewGroup r105 = this.f111700o;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L17:
        r105.setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L5
    }

    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof yn1.a) == false) goto L13;
        ViewGroup r101 = this.f111700o;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L8:
        if (((yn1.a) r100).f568519a == false) goto L10;
        int r102 = 0;
    L11:
        r101.setVisibility(r102);
        return;
    L10:
        r102 = 4;
        goto L11
    L13:
        if ((r100 instanceof yn1.f) == false) goto L25;
        ViewGroup r103 = this.f111700o;
        if (r103 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L18:
        if (r103.findViewById(R.id.activity_top_right_banner_widget_container) != null) goto L20;
        return;
    L20:
        ViewGroup r104 = this.f111700o;
        if (r104 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L23:
        r104.post(new b(this));
        return;
    L25:
        if ((r100 instanceof yn1.d) == false) goto L37;
        ViewGroup r105 = this.f111700o;
        if (r105 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L30:
        if (r105.findViewById(R.id.activity_top_right_banner_widget_container) != null) goto L32;
        return;
    L32:
        ViewGroup r106 = this.f111700o;
        if (r106 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L35:
        r106.post(new c(this));
        return;
    L37:
        if ((r100 instanceof yn1.b) == false) goto L46;
        ViewGroup r107 = this.f111700o;
        if (r107 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L41:
        r107.post(new d(this));
        return;
    }

    public final void V(d90.d r100, boolean r101) {
        Room r102 = d90.e.j(r100);
        ViewGroup r103 = this.f111700o;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L5:
        this.f111704s = LiveTetris.Q(this, ActivityTopBannerWidget.class, r103, true, new Object[]{Boolean.valueOf(r101)}, 16);
        ViewGroup r104 = this.f111700o;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("activityIndicator");
    L8:
        r104.post(new a(this, r102));
    }
}
