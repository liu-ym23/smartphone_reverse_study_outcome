package com.bytedance.android.livesdk.chorusconcert;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chorusconcert/VSChorusConcertWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSChorusConcertWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f119330l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f119331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f119332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SurfaceView f119333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f119334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f119335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Pair<Integer, Integer> f119336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IPlayerProgressService f119337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PlayerProgressServiceContext f119338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f119339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f119340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f119341k;

    public static final class a {
    }

    public static final class b implements gd2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSChorusConcertWidget f119342a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f119343a;

            public a(b r100) {
                this.f119343a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VSChorusConcertWidget r100 = this.f119343a.f119342a;     // Catch: Throwable -> L10
                Context r101 = r100.context;     // Catch: Throwable -> L10
                if (r101 == null) goto L7;
                Resources r102 = r101.getResources();     // Catch: Throwable -> L10
                if (r102 == null) goto L7;
                Configuration r103 = r102.getConfiguration();     // Catch: Throwable -> L10
            L8:
                int r104 = VSChorusConcertWidget.f119330l;     // Catch: Throwable -> L10
                r100.Aq(r103, true);     // Catch: Throwable -> L10
                return;
            L7:
                r103 = null;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L14;
                return;
            L14:
                throw th;
            }
        }

        @Override // gd2.b
        public final void c() {
            Intrinsics.checkNotNullParameter("hide", "reason");
            VSChorusConcertWidget r100 = this.f119342a;
            int r101 = VSChorusConcertWidget.f119330l;
            r100.zq("onChorusCardHide");
            es1.a r102 = this.f119342a.xq(false);
            if (r102 == null) goto L5;
            r102.f473682a = false;
        L5:
            this.f119342a.yq();
        }

        @Override // gd2.b
        public final void d() {
            VSChorusConcertWidget r100 = this.f119342a;
            int r101 = VSChorusConcertWidget.f119330l;
            r100.zq("onChorusCardShow");
            es1.a r102 = this.f119342a.xq(false);
            if (r102 == null) goto L5;
            r102.f473682a = true;
        L5:
            this.f119342a.Cq();
            VSChorusConcertWidget r103 = this.f119342a;
            FrameLayout r104 = r103.f119331a;
            if (r104 == null) goto L10;
            es1.a r105 = r103.xq(false);
            if (r105 == null) goto L10;
            WidgetManager r106 = this.f119342a.subWidgetManager;
            Intrinsics.checkNotNullParameter(r104, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r106, "subWidgetManager");
            r105.f473685d = r104.getChildAt(0);
            es1.a.c("attachChorusCard " + r105.f473685d);
        L10:
            FrameLayout r107 = this.f119342a.f119331a;
            if (r107 == null) goto L14;
            r107.post(new a(this));
            return;
        }

        public b(VSChorusConcertWidget r100) {
            this.f119342a = r100;
        }

        @Override // gd2.b
        public final void a(int r100) {
            int r101 = VSChorusConcertWidget.f119330l;
            this.f119342a.zq("onChorusStateChanged state:" + r100);
            es1.a r102 = this.f119342a.xq(true);
            if (r102 == null) goto L8;
            r102.f473683b = r100;
            if (r100 == JoinChorusConcertStatus.JOINED.getValue()) goto L8;
            JoinChorusConcertStatus.JOINING.getValue();
        L8:
            if (r100 != JoinChorusConcertStatus.JOINING.getValue()) goto L14;
            VSChorusConcertWidget r103 = this.f119342a;
            r103.zq("disableSeek");
            ViewGroup r104 = r103.containerView;
            if (r104 == null) goto L12;
            r104.post(new ds1.a(r103));
        L12:
            r103.dataCenter.put("key_chorus_disable_seek_toast", "您已在合唱中，请保持最新进度");
            VSChorusConcertWidget.wq(this.f119342a, true);
            return;
        L14:
            if (r100 != JoinChorusConcertStatus.JOINED.getValue()) goto L25;
            VSChorusConcertWidget r105 = this.f119342a;
            r105.zq("disableSeek");
            ViewGroup r106 = r105.containerView;
            if (r106 == null) goto L18;
            r106.post(new ds1.a(r105));
        L18:
            r105.dataCenter.put("key_chorus_disable_seek_toast", "您已在合唱中，请保持最新进度");
            MiddlewareRoomContext r107 = o3.b();
            if (r107 == null) goto L23;
            m<Boolean> r108 = r107.getVsInChorusConcert();
            if (r108 == null) goto L23;
            r108.setValue(Boolean.FALSE);
        L23:
            VSChorusConcertWidget.wq(this.f119342a, true);
            return;
        L25:
            if (r100 != JoinChorusConcertStatus.LEAVING.getValue()) goto L42;
            VSChorusConcertWidget r109 = this.f119342a;
            SurfaceView r110 = r109.f119333c;
            if (r110 == null) goto L42;
            r109.zq("replaceSurface remove");
            ViewGroup r111 = r109.f119334d;
            if (r111 == null) goto L31;
            r111.removeView(r110);
        L31:
            es1.a r112 = r109.xq(false);
            if (r112 == null) goto L42;
            View r113 = r112.f473686e;
            if (r113 == null) goto L41;
            ViewParent r114 = r113.getParent();
            if ((r114 instanceof ViewGroup) == true) goto L38;
            r114 = null;
        L38:
            ViewGroup r115 = (ViewGroup) r114;
            if (r115 == null) goto L41;
            r115.removeView(r113);
        L41:
            r112.f473686e = null;
        L42:
            VSChorusConcertWidget r116 = this.f119342a;
            r116.zq("enableSeek");
            PlayerProgressServiceContext r117 = r116.f119338h;
            if (r117 == null) goto L47;
            m<Boolean> r118 = r117.getDisableSeek();
            if (r118 == null) goto L47;
            r118.setValue(Boolean.FALSE);
        L47:
            r116.dataCenter.put("key_chorus_disable_seek_toast", null);
            VSChorusConcertWidget.wq(this.f119342a, false);
            es1.a r119 = this.f119342a.xq(false);
            if (r119 == null) goto L61;
            View r120 = r119.f473686e;
            if (r120 == null) goto L57;
            ViewParent r121 = r120.getParent();
            if ((r121 instanceof ViewGroup) == true) goto L54;
            r121 = null;
        L54:
            ViewGroup r122 = (ViewGroup) r121;
            if (r122 == null) goto L57;
            r122.removeView(r120);
        L57:
            r119.f473686e = null;
            return;
        }

        @Override // gd2.b
        public final void b(SurfaceView r100) {
            Intrinsics.checkNotNullParameter(r100, "surfaceView");
            int r101 = VSChorusConcertWidget.f119330l;
            this.f119342a.zq("onLinkSuccess" + r100);
            VSChorusConcertWidget r102 = this.f119342a;
            r102.f119333c = r100;
            if (r102.f119339i == false) goto L9;
            IKtvService r103 = (IKtvService) k.f(IKtvService.class);
            if (r103 == null) goto L17;
            gd2.c r104 = r103.getChorusConcertService();
            if (r104 == null) goto L17;
            r104.e(true);
        L17:
            if (this.f119342a.isScreenLandscape() == false) goto L20;
            boolean r105 = MatchRoomLandScapeAnimUtil.f82832a;
            MatchRoomLandScapeAnimUtil.c("chorus_surface", this.f119342a.f119333c, true, false, false, 24);
            return;
        L20:
            return;
        L9:
            ViewGroup r106 = r102.f119334d;
            if (r106 == null) goto L17;
            View r107 = r102.f119335e;
            if (r107 == null) goto L17;
            es1.a r108 = r102.xq(true);
            if (r108 == null) goto L17;
            r108.a(r100, r106, r107);
            goto L17
        }

        @Override // gd2.b
        public final void f(SurfaceView r100) {
            Intrinsics.checkNotNullParameter(r100, "surfaceView");
            VSChorusConcertWidget r101 = this.f119342a;
            int r102 = VSChorusConcertWidget.f119330l;
            r101.zq("onRtcSurfaceViewCreated");
            this.f119342a.f119333c = r100;
        }

        @Override // gd2.b
        public final void e(int r100, int r101) {
            int r102 = VSChorusConcertWidget.f119330l;
            this.f119342a.zq("onChorusSizeUpdate height:" + r100 + " width:" + r101);
            FrameLayout r103 = this.f119342a.f119331a;
            if (r103 == null) goto L7;
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            if (r104 == null) goto L7;
            r104.height = r100;
        L7:
            FrameLayout r105 = this.f119342a.f119331a;
            if (r105 == null) goto L12;
            ViewGroup.LayoutParams r106 = r105.getLayoutParams();
            if (r106 == null) goto L12;
            r106.width = r101;
        L12:
            FrameLayout r107 = this.f119342a.f119331a;
            if (r107 == null) goto L16;
            r107.requestLayout();
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSChorusConcertWidget f119344a;

        public c(VSChorusConcertWidget r100) {
            this.f119344a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VSChorusConcertWidget r100 = this.f119344a;     // Catch: Throwable -> L8
            View r101 = r100.f119335e;     // Catch: Throwable -> L8
            if (r101 == null) goto L11;
            es1.a r102 = r100.xq(false);     // Catch: Throwable -> L8
            if (r102 == null) goto L15;
            r102.b(r101);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSChorusConcertWidget f119345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f119346b;

        public d(VSChorusConcertWidget r100, ViewGroup r101) {
            this.f119345a = r100;
            this.f119346b = r101;
        }

        public final void a() {
            int r100 = p.f40070a.a(100.0f);
            ViewGroup r101 = this.f119346b;
            FrameLayout r102 = this.f119345a.f119331a;
            if (r102 == null) goto L5;
            float r103 = r102.getHeight();
        L6:
            r101.setTranslationY((-r103) - r100);
            this.f119346b.setTranslationZ(100.0f);
            this.f119345a.zq("resolvePadFoldCard pad landscape, transY to " + this.f119346b.getTranslationY());
            return;
        L5:
            r103 = 0.0f;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSChorusConcertWidget f119347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f119348b;

        public e(VSChorusConcertWidget r100, ViewGroup r101) {
            this.f119347a = r100;
            this.f119348b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f119348b.setTranslationY(0.0f);     // Catch: Throwable -> L4
            VSChorusConcertWidget r100 = this.f119347a;     // Catch: Throwable -> L4
            int r101 = VSChorusConcertWidget.f119330l;     // Catch: Throwable -> L4
            r100.zq("resolvePadFoldCard pad portrait, transY to 0");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSChorusConcertWidget f119349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f119350b;

        public f(VSChorusConcertWidget r100, ViewGroup r101) {
            this.f119349a = r100;
            this.f119350b = r101;
        }

        public final void a() {
            int r100 = p.f40070a.a(100.0f);
            ViewGroup r101 = this.f119350b;
            FrameLayout r102 = this.f119349a.f119331a;
            if (r102 == null) goto L5;
            float r103 = r102.getHeight();
        L6:
            r101.setTranslationY((-r103) - r100);
            this.f119350b.setTranslationZ(100.0f);
            this.f119349a.zq("resolvePadFoldCard fold expanded, transY to " + this.f119350b.getTranslationY());
            return;
        L5:
            r103 = 0.0f;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSChorusConcertWidget f119351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f119352b;

        public g(VSChorusConcertWidget r100, ViewGroup r101) {
            this.f119351a = r100;
            this.f119352b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f119352b.setTranslationY(0.0f);     // Catch: Throwable -> L4
            VSChorusConcertWidget r100 = this.f119351a;     // Catch: Throwable -> L4
            int r101 = VSChorusConcertWidget.f119330l;     // Catch: Throwable -> L4
            r100.zq("resolvePadFoldCard fold collapsed, transY to 0");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSChorusConcertWidget f119353a;

        public h(VSChorusConcertWidget r100) {
            this.f119353a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VSChorusConcertWidget r100 = this.f119353a;     // Catch: Throwable -> L9
            View r101 = r100.f119335e;     // Catch: Throwable -> L9
            if (r101 == null) goto L12;
            es1.a r102 = r100.xq(false);     // Catch: Throwable -> L9
            if (r102 == null) goto L16;
            r102.b(r101);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_vs_chorus_concert_layout;
    }

    public final void Bq() {
        zq("try restoreChorusSurfaceView");
        es1.a r100 = xq(false);
        SurfaceView r101 = null;
        View r102 = null;
        r101 = null;
        if (r100 == null) goto L11;
        View r103 = r100.f473686e;
        if (r103 == null) goto L11;
        if ((r103 instanceof SurfaceView) == false) goto L10;
        r102 = r103;
    L10:
        r101 = (SurfaceView) r102;
    L11:
        es1.a r104 = xq(false);
        if (r104 != null) goto L14;
    L15:
        es1.a r105 = xq(false);
        if (r105 != null) goto L18;
        return;
    L18:
        if (r105.f473683b != JoinChorusConcertStatus.JOINING.getValue()) goto L37;
    L19:
        if (r101 == null) goto L38;
        zq("restoreSurfaceView now");
        this.f119333c = r101;
        ViewGroup r106 = this.f119334d;
        if (r106 == null) goto L28;
        View r107 = this.f119335e;
        if (r107 == null) goto L28;
        es1.a r108 = xq(false);
        if (r108 == null) goto L28;
        r108.a(r101, r106, r107);
    L28:
        if (isScreenLandscape() == false) goto L30;
        boolean r109 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.c("chorus_surface", this.f119333c, false, false, false, 28);
    L30:
        IKtvService r110 = (IKtvService) k.f(IKtvService.class);
        if (r110 == null) goto L39;
        gd2.c r111 = r110.getChorusConcertService();
        if (r111 == null) goto L40;
        r111.f(r101.getWidth(), r101.getHeight());
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L14:
        if (r104.f473683b == JoinChorusConcertStatus.JOINED.getValue()) goto L19;
        goto L15
    }

    public final void Cq() {
        zq("showChorusCard");
        es1.a r100 = xq(false);
        if (r100 != null) goto L5;
    L8:
        es1.a r101 = xq(false);
        if (r101 != null) goto L11;
    L20:
        FrameLayout r102 = this.f119331a;
        if (r102 == null) goto L24;
        r102.setVisibility(0);
    L24:
        if (isScreenLandscape() == true) goto L32;
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r103 = InteractionWidgetsPosContext.a.a();
        if (r103 == null) goto L30;
        m<Integer> r104 = r103.getVsChorusConcertHeight();
        if (r104 == null) goto L30;
        r104.setValue(Integer.valueOf(p.f40070a.a(115.0f)));
    L30:
        zq("set vsChorusConcertHeight" + p.f40070a.a(115.0f));
        return;
    L32:
        return;
    L11:
        if (r101.f473682a != true) goto L20;
        PlayerProgressServiceContext r105 = this.f119338h;
        if (r105 == null) goto L20;
        m<Boolean> r106 = r105.getAtLatest();
        if (r106 == null) goto L20;
        if (r106.getValue().booleanValue() == true) goto L20;
        zq("showChorusCard return cause isCardShouldShow == true and atLatest == false");
        yq();
        return;
    L5:
        if (r100.f473682a == true) goto L8;
        zq("showChorusCard return cause isCardShouldShow == false");
        yq();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        zq("destroyChorusCard");
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        zq("onUnload");
        this.f119340j.clear();
        IKtvService r100 = (IKtvService) k.f(IKtvService.class);
        if (r100 == null) goto L7;
        gd2.c r101 = r100.getChorusConcertService();
        if (r101 == null) goto L7;
        r101.a(this.f119341k);
    L7:
        es1.a r102 = xq(false);
        if (r102 == null) goto L11;
        r102.f473687f = null;
        return;
    }

    public final void yq() {
        zq("hideChorusCard");
        if (isScreenLandscape() == true) goto L10;
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r100 = InteractionWidgetsPosContext.a.a();
        if (r100 == null) goto L9;
        m<Integer> r101 = r100.getVsChorusConcertHeight();
        if (r101 == null) goto L9;
        r101.setValue(0);
    L9:
        zq("set vsChorusConcertHeight 0");
    L10:
        FrameLayout r102 = this.f119331a;
        if (r102 == null) goto L14;
        r102.setVisibility(8);
        return;
    }

    public VSChorusConcertWidget() {
        this.f119336f = new Pair(0, 0);
        this.f119340j = new CompositeDisposable();
        this.f119341k = new b(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        IKtvService r100 = (IKtvService) k.f(IKtvService.class);
        if (r100 == null) goto L8;
        gd2.f r101 = r100.getConcertStageService();
        if (r101 == null) goto L9;
        r101.onPause();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        IKtvService r100 = (IKtvService) k.f(IKtvService.class);
        if (r100 == null) goto L8;
        gd2.f r101 = r100.getConcertStageService();
        if (r101 == null) goto L9;
        r101.onResume();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        zq("onConfigurationChanged " + r100);
        Aq(r100, false);
        super.onConfigurationChanged(r100);
        IKtvService r101 = (IKtvService) k.f(IKtvService.class);
        if (r101 == null) goto L7;
        gd2.f r102 = r101.getConcertStageService();
        if (r102 == null) goto L7;
        r102.onConfigurationChanged(r100);
    L7:
        FrameLayout r103 = this.f119331a;
        if (r103 == null) goto L10;
        View r104 = r103.getChildAt(0);
    L11:
        this.f119332b = r104;
        return;
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        zq("onInit");
        this.f119331a = (FrameLayout) this.containerView.findViewById(R.id.vs_chorus_widget_container);
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L14;
        IRoom r102 = lu2.c.f(r101);
        if (r102 == null) goto L14;
        long r103 = r102.getId();
        es1.a.C5810a r104 = es1.a.f473681j;
        monitor-enter(r104);
        es1.a.f473680i.remove(Long.valueOf(r103));     // Catch: Throwable -> L11
        monitor-exit(r104);
        r104.b(r103);
    L11:
        th = move-exception;
        throw th;
    L14:
        Context r105 = this.context;
        if (r105 == null) goto L24;
        Resources r106 = r105.getResources();
        if (r106 == null) goto L25;
        Configuration r107 = r106.getConfiguration();
        if (r107 == null) goto L26;
        this.f119336f = new Pair(Integer.valueOf(r107.screenWidthDp), Integer.valueOf(r107.screenHeightDp));
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        zq(WidgetCostModule.TYPE_ON_LOAD);
        View r101 = this.containerView;
    L3:
        PlayerProgressServiceContext r102 = null;
        if (r101 != null) goto L160;
        ViewParent r103 = null;
    L10:
        if ((r103 instanceof View) == false) goto L20;
        Object r104 = r101.getParent();     // Catch: Exception -> L6
        if (r104 == null) goto L18;
        View r105 = (View) r104;     // Catch: Exception -> L6
        if ((r105 instanceof LiveVerticalViewPager) == true) goto L22;
        r101 = r105;
    L22:
        if (r101 == null) goto L33;
        View r106 = r101.findViewById(R.id.ttlive_player_render_view);
        this.f119335e = r106;
        if (r106 == null) goto L28;
        ViewParent r107 = r106.getParent();
        if (r107 == null) goto L28;
        ViewParent r108 = r107.getParent();
    L30:
        if ((r108 instanceof ViewGroup) == true) goto L32;
        r108 = null;
    L32:
        this.f119334d = (ViewGroup) r108;
        zq("Successfully found playerView within the current page.");
    L51:
        if (this.f119335e != null) goto L53;
    L54:
        zq("!!! Failed to get playerView or its container.");
    L55:
        enableSubWidgetManager();
        if (this.f119335e != null) goto L58;
    L59:
        zq("!!! Failed to get playerView or its container from IVSPlayerService.");
    L60:
        zq("initChorusCard");
        es1.a r109 = xq(true);
        if (r109 == null) goto L65;
        View r110 = r109.f473685d;
        if (r110 == null) goto L65;
    L66:
        if (r110 == null) goto L88;
        zq("restoreChorusCardView success");
        zq("try restoreChorusCardView");
        es1.a r111 = xq(false);
        if (r111 == null) goto L72;
        View r112 = r111.f473685d;
        if (r112 == null) goto L72;
    L73:
        if (r112 != null) goto L162;
    L87:
        Bq();
    L94:
        if (isScreenLandscape() == false) goto L110;
        IVSPlayerService r113 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r113 == null) goto L102;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r114 = r113.provideVSPlayerViewControlService(this.dataCenter);
        if (r114 == null) goto L102;
        NextLiveData<Integer> r115 = r114.g(PlayerViewControl.KEY.PlayerShadowBottom);
        if (r115 == null) goto L102;
        Integer r116 = r115.getValue();
    L103:
        if (r116 == null) goto L110;
        if (r116.intValue() != 0) goto L110;
        FrameLayout r117 = this.f119331a;
        if (r117 == null) goto L113;
        r117.setAlpha(0.2f);
    L113:
        yq();
        IKtvService r118 = (IKtvService) k.f(IKtvService.class);
        if (r118 == null) goto L119;
        gd2.c r119 = r118.getChorusConcertService();
        if (r119 == null) goto L119;
        r119.c(this.f119341k);
    L119:
        if (isScreenLandscape() == false) goto L139;
        IVSPlayerService r120 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r120 == null) goto L127;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r121 = r120.provideVSPlayerViewControlService(this.dataCenter);
        if (r121 == null) goto L127;
        NextLiveData<Integer> r122 = r121.g(PlayerViewControl.KEY.PlayerShadowBottom);
        if (r122 == null) goto L127;
        r122.observe(this, new ds1.b(this));
    L127:
        Disposable r123 = MatchRoomLandScapeAnimUtil.f82835d.observeOn(AndroidSchedulers.mainThread()).subscribe(new ds1.c(this), ds1.d.f469838a);
        if (r123 == null) goto L130;
        RxUtilKt.c(r123, this.f119340j);
    L130:
        MiddlewareRoomContext r124 = o3.b();
        if (r124 == null) goto L139;
        m<Boolean> r125 = r124.isLandscapeLock();
        if (r125 == null) goto L139;
        Observable<Boolean> r126 = r125.a();
        if (r126 == null) goto L139;
        Disposable r127 = r126.subscribe(new ds1.e(this));
        if (r127 == null) goto L139;
        RxUtilKt.c(r127, this.f119340j);
    L139:
        IPlayerProgressService r128 = ((rk1.a) k.n(rk1.a.class)).M4(this.dataCenter);
        this.f119337g = r128;
        if (r128 == null) goto L142;
        r102 = r128.provideContext(this.dataCenter);
    L142:
        this.f119338h = r102;
        if (r102 == null) goto L151;
        com.bytedance.live.datacontext.k<Boolean> r129 = r102.getShowLatestEvent();
        if (r129 == null) goto L151;
        PublishSubject r130 = r129.onEvent();
        if (r130 == null) goto L151;
        Disposable r131 = r130.subscribe(new ds1.f(this));
        if (r131 == null) goto L151;
        RxUtilKt.c(r131, this.f119340j);
    L151:
        es1.a r132 = xq(true);
        if (r132 == null) goto L155;
        r132.f473684c = true;
    L155:
        if (isScreenLandscape() == false) goto L167;
        FrameLayout r133 = this.f119331a;
        if (r133 == null) goto L168;
        r133.post(new c(this));
        return;
    L168:
        return;
    L167:
        return;
    L102:
        r116 = null;
    L110:
        FrameLayout r134 = this.f119331a;
        if (r134 == null) goto L113;
        r134.setAlpha(1.0f);
        goto L113
    L162:
        ViewParent r135 = r112.getParent();     // Catch: Exception -> L85
        if ((r135 instanceof ViewGroup) == true) goto L77;
        r135 = null;
    L77:
        ViewGroup r136 = (ViewGroup) r135;     // Catch: Exception -> L85
        if (r136 == null) goto L80;
        r136.removeView(r112);     // Catch: Exception -> L85
    L80:
        FrameLayout r137 = this.f119331a;     // Catch: Exception -> L85
        if (r137 == null) goto L83;
        r137.addView(r112);     // Catch: Exception -> L85
    L83:
        Cq();     // Catch: Exception -> L85
        zq("restoreChorusCardView success and addview now");     // Catch: Exception -> L85
    L85:
        e = move-exception;
        zq("restoreChorusCardView exception: " + e);
    L72:
        r112 = null;
        goto L73
    L88:
        zq("no chorusCard cache & initChorusCard continue");
        FrameLayout r138 = this.f119331a;
        if (r138 == null) goto L94;
        IKtvService r139 = (IKtvService) k.f(IKtvService.class);
        if (r139 == null) goto L94;
        r139.initChorusService(this.context, r138, this.dataCenter);
    L65:
        r110 = null;
        goto L66
    L58:
        if (this.f119334d != null) goto L60;
    L53:
        if (this.f119334d != null) goto L55;
    L28:
        r108 = null;
        goto L30
    L33:
        zq("!!! CRITICAL: Could not find page root. Falling back to activity search.");
        Context r140 = this.context;
        if ((r140 instanceof Activity) == true) goto L36;
        r140 = null;
    L36:
        Activity r141 = (Activity) r140;
        if (r141 == null) goto L39;
        View r142 = r141.findViewById(R.id.ttlive_player_render_view);
    L40:
        this.f119335e = r142;
        if (r142 == null) goto L45;
        ViewParent r143 = r142.getParent();
        if (r143 == null) goto L45;
        ViewParent r144 = r143.getParent();
    L47:
        if ((r144 instanceof ViewGroup) == true) goto L49;
        r144 = null;
    L49:
        this.f119334d = (ViewGroup) r144;
    L45:
        r144 = null;
        goto L47
    L39:
        r142 = null;
        goto L40
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");     // Catch: Exception -> L6
    L6:
        e = move-exception;
        ALogger.e("VSChorusConcertWidget", "findPageRootView error", e);
    L20:
        r101 = null;
        goto L22
    L160:
        r103 = r101.getParent();     // Catch: Exception -> L6
        goto L10
    }

    public final es1.a xq(boolean r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L7;
        IRoom r102 = lu2.c.f(r101);
        if (r102 == null) goto L7;
        long r103 = r102.getId();
        return es1.a.f473681j.c(r103, this.context, r100);
    L7:
        return null;
    }

    public final void zq(String r100) {
        ALogger.i("VSChorusConcertWidget", r100);
    }

    public static final void wq(VSChorusConcertWidget r100, boolean r101) {
        r100.getClass();
        MiddlewareRoomContext r102 = o3.b();
        if (r102 == null) goto L8;
        m<Boolean> r103 = r102.getVsInChorusConcert();
        if (r103 == null) goto L9;
        r103.setValue(Boolean.valueOf(r101));
        return;
    L9:
        return;
    }

    public final void Aq(Configuration r100, boolean r101) {
        if (PadConfigUtils.c() == false) goto L5;
    L6:
        StringBuilder r102 = new StringBuilder("resolvePadFoldCard: newConfig.orientation=");
        ViewParent r103 = null;
        if (r100 == null) goto L9;
        Integer r104 = Integer.valueOf(r100.orientation);
    L10:
        r102.append(r104);
        r102.append(", newConfig.width=");
        if (r100 == null) goto L13;
        Integer r105 = Integer.valueOf(r100.screenWidthDp);
    L14:
        r102.append(r105);
        r102.append(", newConfig.height=");
        if (r100 == null) goto L17;
        Integer r106 = Integer.valueOf(r100.screenHeightDp);
    L18:
        r102.append(r106);
        r102.append(", previousSize=");
        r102.append(this.f119336f);
        zq(r102.toString());
        if (r101 == false) goto L21;
        if (r100 == null) goto L21;
    L26:
        FrameLayout r107 = this.f119331a;
        if (r107 == null) goto L31;
        ViewParent r108 = r107.getParent();
        if (r108 == null) goto L31;
        ViewParent r109 = r108.getParent();
    L33:
        if ((r109 instanceof ViewGroup) == true) goto L35;
        r109 = null;
    L35:
        ViewGroup r110 = (ViewGroup) r109;
        if (r110 != null) goto L39;
        return;
    L39:
        if (PadConfigUtils.c() == false) goto L62;
        int r111 = r100.orientation;
        if (r111 != 2) goto L51;
        ViewParent r112 = r110.getParent();
        if ((r112 instanceof ViewGroup) == true) goto L45;
        r112 = null;
    L45:
        ViewGroup r113 = (ViewGroup) r112;
        if (r113 == null) goto L48;
        r113.setClipChildren(false);
    L48:
        r110.setClipChildren(false);
        FrameLayout r114 = this.f119331a;
        if (r114 == null) goto L62;
        r114.post(new d(this, r110));
        goto L62
    L51:
        if (r111 != 1) goto L62;
        ViewParent r115 = r110.getParent();
        if ((r115 instanceof ViewGroup) == true) goto L55;
        r115 = null;
    L55:
        ViewGroup r116 = (ViewGroup) r115;
        if (r116 == null) goto L58;
        r116.setClipChildren(true);
    L58:
        r110.setClipChildren(true);
        FrameLayout r117 = this.f119331a;
        if (r117 == null) goto L62;
        r117.post(new e(this, r110));
    L62:
        if (FoldScreenUtils.f() == true) goto L64;
    L85:
        FrameLayout r118 = this.f119331a;
        if (r118 == null) goto L88;
        r118.post(new h(this));
    L88:
        this.f119336f = new Pair(Integer.valueOf(r100.screenWidthDp), Integer.valueOf(r100.screenHeightDp));
        Bq();
        return;
    L64:
        if (FoldScreenUtils.a() != 0) goto L75;
        ViewParent r119 = r110.getParent();
        if ((r119 instanceof ViewGroup) == false) goto L69;
        r103 = r119;
    L69:
        ViewGroup r120 = (ViewGroup) r103;
        if (r120 == null) goto L72;
        r120.setClipChildren(false);
    L72:
        r110.setClipChildren(false);
        FrameLayout r121 = this.f119331a;
        if (r121 == null) goto L85;
        r121.post(new f(this, r110));
        goto L85
    L75:
        ViewParent r122 = r110.getParent();
        if ((r122 instanceof ViewGroup) == false) goto L79;
        r103 = r122;
    L79:
        ViewGroup r123 = (ViewGroup) r103;
        if (r123 == null) goto L82;
        r123.setClipChildren(true);
    L82:
        r110.setClipChildren(true);
        FrameLayout r124 = this.f119331a;
        if (r124 == null) goto L85;
        r124.post(new g(this, r110));
    L31:
        r109 = null;
    L21:
        if (r100 != null) goto L23;
        return;
    L23:
        if (this.f119336f.getFirst().intValue() != r100.screenWidthDp) goto L26;
        if (this.f119336f.getSecond().intValue() != r100.screenHeightDp) goto L26;
        return;
    L17:
        r106 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        if (FoldScreenUtils.f() == true) goto L6;
    }
}
