package com.bytedance.android.livesdk.chatroom.tetris.row3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.e3;
import com.bytedance.android.livesdk.chatroom.utils.i3;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g;
import com.bytedance.android.livesdk.config.setting.i;
import com.bytedance.android.livesdk.gameguess.widget.GameGuessPredictorWidget;
import com.bytedance.android.livesdk.message.model.mn;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.GameExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.GameKind;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.m0;
import zg1.n3;
import zg1.q3;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/row3/BannerTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerTetris extends LiveTetris<e0> implements o70.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f111815o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f111816p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WidgetElement f111817q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f111818r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d f111819s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.f f111820t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CompositeDisposable f111821u;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerTetris f111822a;

        public a(BannerTetris r100) {
            this.f111822a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            BannerTetris r100 = this.f111822a;
            r100.getClass();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
            if (r100.f111820t != null) goto L6;
        L8:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
            return;
        L6:
            if (r100.V() == null) goto L8;
            com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.f r102 = r100.f111820t;     // Catch: Throwable -> L10
            Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L10
            g r103 = r100.V();     // Catch: Throwable -> L10
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L10
            i3.d(r102, r103, d90.c.c((d90.a) r100.K()));     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
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

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerTetris f111823a;

        public b(BannerTetris r100) {
            this.f111823a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            BannerTetris r100 = this.f111823a;
            r100.getClass();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
            com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r102 = r100.f111819s;     // Catch: Throwable -> L12
            if (r102 != null) goto L6;
        L10:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
            return;
        L6:
            if (r102.f115174a == null) goto L10;
            if (r100.V() == null) goto L10;
            com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r103 = r100.f111819s;     // Catch: Throwable -> L12
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L12
            g r104 = r100.V();     // Catch: Throwable -> L12
            Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L12
            boolean r105 = d90.c.c((d90.a) r100.K());     // Catch: Throwable -> L12
            r104.Yb(8);     // Catch: Throwable -> L12
            RoomTopRightBannerEvent r106 = new RoomTopRightBannerEvent();     // Catch: Throwable -> L12
            r106.setStatus(1);     // Catch: Throwable -> L12
            r106.setAnimationTime(250);     // Catch: Throwable -> L12
            i3.e(r103, r104, r106, r105);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
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

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerTetris f111824a;

        public c(BannerTetris r100) {
            this.f111824a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            BannerTetris r100 = this.f111824a;
            r100.getClass();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
            if (r100.f111820t != null) goto L6;
        L8:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
            return;
        L6:
            if (r100.V() == null) goto L8;
            i3.c(r100.f111820t, r100.V(), d90.c.c((d90.a) r100.K()));     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r102 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
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

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerTetris f111825a;

        public d(BannerTetris r100) {
            this.f111825a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            BannerTetris r100 = this.f111825a;
            r100.getClass();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
            com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r102 = r100.f111819s;     // Catch: Throwable -> L12
            if (r102 != null) goto L6;
        L10:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
            return;
        L6:
            if (r102.f115174a == null) goto L10;
            if (r100.V() == null) goto L10;
            i3.b(r100.f111819s, r100.V(), d90.c.c((d90.a) r100.K()));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
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

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerTetris f111826a;

        public e(BannerTetris r100) {
            this.f111826a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RoomTopRightBannerEvent r101 = (RoomTopRightBannerEvent) r100;
            BannerTetris r102 = this.f111826a;
            if (d90.c.i((d90.a) r102.K()) == false) goto L10;
            com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.f r103 = r102.f111820t;
            if (r103 == null) goto L16;
            g r104 = r102.V();
            boolean r105 = d90.c.c((d90.a) r102.K());
            if (r101 == null) goto L20;
            View r106 = r103.f115179b;
            r106.post(new e3(r101, r106, r105, r104));
            return;
        L20:
            return;
        L16:
            return;
        L10:
            com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r107 = r102.f111819s;
            if (r107 != null) goto L13;
            return;
        L13:
            if (r107.f115174a == null) goto L19;
            i3.e(r107, r102.V(), r101, false);
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerTetris f111827a;

        public f(BannerTetris r100) {
            this.f111827a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            n3 r101 = (n3) r100;
            boolean r102 = false;
            if (VrUtils.t(((e0) this.f111827a.K()).f467480h, false) == false) goto L12;
            BannerTetris r103 = this.f111827a;
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
        return CollectionsKt.listOf(new Class[]{yn1.a.class, yn1.f.class, yn1.d.class, m0.class});
    }

    public final g V() {
        return (g) this.f111818r.getValue();
    }

    public BannerTetris() {
        this.f111818r = LazyKt.lazy(new BannerTetris$mTopRightBanner$2(this));
        this.f111821u = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        e0 r100 = (e0) K();
        if (d90.c.i(r100) == false) goto L5;
        Boolean r101 = i60.c.f488350a.getValue();
    L6:
        ViewGroup r102 = this.f111815o;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L9:
        this.f111817q = LiveTetris.Q(this, ActivityTopBannerWidget.class, r102, r101.booleanValue(), null, 24);
        ViewGroup r103 = this.f111815o;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L12:
        r103.post(new com.bytedance.android.livesdk.chatroom.tetris.row3.a(this, r100));
        ((ObservableSubscribeProxy) xs2.b.a().b(RoomTopRightBannerEvent.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new e(this));
        boolean r104 = true;
        if (d90.c.c((d90.a) K()) == true) goto L55;
        e0 r105 = (e0) K();
        if (d90.c.i(r105) == false) goto L49;
        DataCenter r106 = r105.f467480h;
        if (r106 == null) goto L19;
        Integer r107 = Integer.valueOf(r106.hashCode());
    L20:
        RoomContext r108 = (RoomContext) com.bytedance.live.datacontext.d.d(r107);
        if (r108 == null) goto L55;
        boolean r109 = com.bytedance.android.livesdk.chatroom.game.e.a(d90.c.q(r105), r108);
        Room r110 = r108.getRoom().getValue();
        if (r109 == false) goto L40;
        GameExtraInfo r111 = r110.gameExtraInfo;
        if (r111 == null) goto L40;
        if (r111.getGameKind() != GameKind.WGAMEX.type) goto L30;
        boolean r112 = true;
    L31:
        if (r112 == true) goto L34;
        r111 = null;
    L34:
        if (r111 == null) goto L40;
        vlc.d r113 = com.bytedance.android.livesdk.chatroom.utils.n3.d(r108);
        if (r113 == null) goto L38;
        int r114 = mn.f153670a;
        r113.j(mn.a.a(r111), true);
    L38:
        r110.gameExtraInfo = null;
        goto L40
    L30:
        r112 = false;
    L40:
        if (yx1.a.b(r110) == false) goto L55;
        ViewGroup r115 = this.f111816p;
        if (r115 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mPredictorContainer");
    L44:
        r115.setVisibility(0);
        ViewGroup r116 = this.f111816p;
        if (r116 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mPredictorContainer");
    L47:
        LiveTetris.Q(this, GameGuessPredictorWidget.class, r116, false, null, 24);
        goto L55
    L19:
        r107 = null;
        goto L20
    L49:
        if (yx1.a.b(d90.c.q(r105)) == false) goto L55;
        ViewGroup r117 = this.f111816p;
        if (r117 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mPredictorContainer");
    L53:
        LiveTetris.Q(this, GameGuessPredictorWidget.class, r117, true, null, 24);
    L55:
        if (d90.c.c((d90.a) K()) == false) goto L58;
        this.f111821u.add(xs2.b.a().b(q3.class).subscribe(new com.bytedance.android.livesdk.chatroom.tetris.row3.b(this)));
    L58:
        if (VrUtils.t(((e0) K()).f467480h, false) == false) goto L69;
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(((e0) K()).f467480h).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new f(this));
        RoomContext r118 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r118 == null) goto L67;
        m<Boolean> r119 = r118.getVrInImmersedMode();
        if (r119 == null) goto L67;
        if (r119.getValue().booleanValue() != true) goto L67;
        r104 = false;
    L67:
        W(r104);
    L69:
        if (i.f121210a.K() == true) goto L79;
        ILiveExpOptService r120 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        if (r120 == null) goto L77;
        Disposable r121 = r120.registerExpBizListener(l61.d.a.o0.f507635e, new com.bytedance.android.livesdk.chatroom.tetris.row3.c(this));
        if (r121 == null) goto L78;
        RxUtilKt.c(r121, this.f111821u);
        return;
    L78:
        return;
    L77:
        return;
    L79:
        return;
    L5:
        r101 = Boolean.TRUE;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        this.f111821u.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (d90.c.i((d90.a) K()) == false) goto L8;
        View r101 = r100.b(R.layout.ttlive_layout_portrait_banner_container);
        this.f111815o = (ViewGroup) r101.findViewById(R.id.portrait_activity_indicator_container);
        this.f111816p = (ViewGroup) r101.findViewById(R.id.portrait_predictor_entrance_container);
        ViewGroup r102 = this.f111815o;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L7:
        this.f111820t = new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.f(null, r102, null);
    L12:
        return r101;
    L8:
        r101 = r100.b(R.layout.ttlive_layout_landscape_banner_container);
        this.f111815o = (ViewGroup) r101.findViewById(R.id.landscape_top_left_activity_banner);
        this.f111816p = (ViewGroup) r101.findViewById(R.id.landscape_predictor_entrance_container);
        ViewGroup r103 = this.f111815o;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L11:
        this.f111819s = new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d(r103.findViewById(R.id.activity_top_right_banner_widget_container));
        goto L12
    }

    public final void W(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        ViewGroup r102 = this.f111815o;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L8:
        r102.setVisibility(r101);
        ViewGroup r103 = this.f111816p;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPredictorContainer");
    L11:
        r103.setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof yn1.a) == false) goto L14;
        ViewGroup r101 = this.f111815o;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        if (((yn1.a) r100).f568519a == false) goto L11;
        int r102 = 0;
    L12:
        r101.setVisibility(r102);
        return;
    L11:
        r102 = 4;
        goto L12
    L14:
        if ((r100 instanceof yn1.f) == false) goto L26;
        if (d90.c.i((d90.a) K()) == false) goto L21;
        ViewGroup r103 = this.f111815o;
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L20:
        r103.post(new a(this));
        return;
    L21:
        ViewGroup r104 = this.f111815o;
        if (r104 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L24:
        r104.post(new b(this));
        return;
    L26:
        if ((r100 instanceof yn1.d) == false) goto L38;
        if (d90.c.i((d90.a) K()) == false) goto L33;
        ViewGroup r105 = this.f111815o;
        if (r105 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L32:
        r105.post(new c(this));
        return;
    L33:
        ViewGroup r106 = this.f111815o;
        if (r106 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mActivityBannerView");
    L36:
        r106.post(new d(this));
        return;
    L38:
        if ((r100 instanceof m0) == true) goto L40;
        return;
    L40:
        if (d90.c.i((d90.a) K()) == false) goto L54;
        boolean r107 = ((m0) r100).f571878a;
        View r108 = L();
        if (r107 == false) goto L44;
        float r109 = 0.0f;
    L45:
        r108.setAlpha(r109);
        return;
    L44:
        r109 = 1.0f;
        goto L45
    }
}
