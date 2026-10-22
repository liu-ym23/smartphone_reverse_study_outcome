package com.bytedance.android.livesdk.chatroom.ui.record;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordBasePresenter$showRecordShareDialog$1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vr1.u;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f113954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f113955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f113956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f113957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f113958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f113959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Activity f113960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f113961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f113962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f113963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f113964k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VideoViewParams f113965l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View.OnClickListener f113966m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f113967n;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.b$b, reason: collision with other inner class name */
    public static final class C1679b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f113968a;

        public C1679b(b r100) {
            this.f113968a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            View r101 = this.f113968a.getContentView();
            if (r101 == null) goto L6;
            r101.setAlpha(1 - r100.getAnimatedFraction());
        L6:
            if (r100.getAnimatedFraction() != 1.0f) goto L9;
            b.a(this.f113968a);
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f113969a;

        public static final class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f113970a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.FloatRef f113971b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.FloatRef f113972c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ float f113973d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113974e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113975f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113976g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113977h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113978i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ float f113979j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113980k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113981l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113982m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113983n;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.b$c$a$a, reason: collision with other inner class name */
            public static final class C1680a<T> implements Consumer {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f113984a;

                public C1680a(a r100) {
                    this.f113984a = r100;
                }

                @Override // io.reactivex.functions.Consumer
                public final void accept(Object r100) {
                    Long r101 = (Long) r100;
                    b r102 = this.f113984a.f113970a.f113969a;
                    PopupWindowLancet.handleDismissBeforeOrigin(r102);
                    r102.dismiss();
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.b$c$a$b, reason: collision with other inner class name */
            public static final class C1681b<T> implements Consumer {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C1681b f113985a = null;

                static {
                    f113985a = new C1681b();
                }

                public C1681b() {
                }

                @Override // io.reactivex.functions.Consumer
                public final void accept(Object r100) {
                    Throwable r101 = (Throwable) r100;
                    x8.a.b("LandscapeQuickShotWindow", "autodismiss Fail", false);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                this.f113971b.element = r100.getAnimatedFraction();
                Ref.FloatRef r101 = this.f113972c;
                float r102 = 1;
                float r103 = r102 - this.f113973d;
                Ref.FloatRef r104 = this.f113971b;
                float r105 = r102 - (r103 * r104.element);
                r101.element = r105;
                this.f113974e.element = (int) (this.f113975f.element * r105);
                Ref.IntRef r106 = this.f113976g;
                r106.element = (int) (this.f113977h.element * r105);
                this.f113978i.element = (int) (this.f113979j * r105);
                Ref.IntRef r107 = this.f113980k;
                int r108 = this.f113981l.element;
                float r109 = r108;
                b r110 = this.f113970a.f113969a;
                float r111 = r110.f113961h - r108;
                float r112 = r104.element;
                r107.element = (int) (r109 + (r111 * r112));
                Ref.IntRef r113 = this.f113982m;
                int r114 = this.f113983n.element;
                r113.element = (int) ((r114 + ((r110.f113962i - r114) * r112)) - r106.element);
                View r115 = r110.f113957d;
                if (r115 == null) goto L9;
                ViewGroup.LayoutParams r116 = r115.getLayoutParams();
                if (r116 == null) goto L8;
                r116.width = this.f113974e.element;
                r116.height = this.f113976g.element;
                r115.setLayoutParams(r116);
                goto L9
            L8:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L9:
                b r117 = this.f113970a.f113969a;
                if (r117.f113967n == false) goto L18;
                View r118 = r117.f113954a;
                if (r118 == null) goto L18;
                UtilityKotlinExtentionsKt.w(r118);
                ViewGroup.LayoutParams r119 = r118.getLayoutParams();
                if (r119 == null) goto L17;
                r119.height = this.f113978i.element;
                r118.setLayoutParams(r119);
                goto L18
            L17:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L18:
                FrameLayout r120 = this.f113970a.f113969a.f113959f;
                ViewGroup.LayoutParams r121 = r120.getLayoutParams();
                if (r121 == null) goto L25;
                r121.width = -2;
                r121.height = -2;
                r120.setLayoutParams(r121);
                r120.setX(this.f113980k.element);
                r120.setY(this.f113982m.element);
                if (this.f113971b.element != 1.0f) goto L26;
                Observable.timer(3000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C1680a(this), C1681b.f113985a);
                return;
            L26:
                return;
            L25:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }

            public a(c r100, Ref.FloatRef r101, Ref.FloatRef r102, float r103, Ref.IntRef r104, Ref.IntRef r105, Ref.IntRef r106, Ref.IntRef r107, Ref.IntRef r108, float r110, Ref.IntRef r111, Ref.IntRef r112, Ref.IntRef r113, Ref.IntRef r114) {
                this.f113970a = r100;
                this.f113971b = r101;
                this.f113972c = r102;
                this.f113973d = r103;
                this.f113974e = r104;
                this.f113975f = r105;
                this.f113976g = r106;
                this.f113977h = r107;
                this.f113978i = r108;
                this.f113979j = r110;
                this.f113980k = r111;
                this.f113981l = r112;
                this.f113982m = r113;
                this.f113983n = r114;
            }
        }

        public c(b r100) {
            this.f113969a = r100;
        }

        public final void a() {
            if (this.f113969a.f113965l == null) goto L32;
            Ref.IntRef r100 = new Ref.IntRef();
            r100.element = this.f113969a.f113965l.f112569a;
            Ref.IntRef r101 = new Ref.IntRef();
            r101.element = this.f113969a.f113965l.f112570b;
            Ref.IntRef r110 = new Ref.IntRef();
            u r102 = r.u(null, null, 3);
            if (r102 == null) goto L11;
            n<Rect> r103 = r102.d();
            if (r103 == null) goto L11;
            Rect r104 = r103.getValue();
            if (r104 == null) goto L11;
            int r105 = r104.left;
        L12:
            r110.element = r105;
            Ref.IntRef r111 = new Ref.IntRef();
            VideoViewParams r106 = this.f113969a.f113965l;
            r111.element = r106.f112571c + r106.f112570b;
            if (r100.element > 0) goto L15;
        L16:
            r100.element = s1.t();
            r101.element = s1.r();
            r110.element = 0;
            r111.element = s1.r();
        L17:
            int r107 = r100.element;
            int r108 = r101.element;
            if (r107 >= r108) goto L21;
            r107 = r108;
        L21:
            ValueAnimator r112 = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
            float r109 = this.f113969a.f113963j / r107;
            Ref.IntRef r113 = new Ref.IntRef();
            r113.element = 0;
            Ref.IntRef r114 = new Ref.IntRef();
            r114.element = 0;
            Ref.FloatRef r115 = new Ref.FloatRef();
            r115.element = 0.0f;
            Ref.IntRef r116 = new Ref.IntRef();
            r116.element = 0;
            Ref.IntRef r117 = new Ref.IntRef();
            r117.element = 0;
            Ref.FloatRef r118 = new Ref.FloatRef();
            r118.element = 0.0f;
            float r119 = this.f113969a.f113964k / r109;
            Ref.IntRef r120 = new Ref.IntRef();
            r120.element = 0;
            b r121 = this.f113969a;
            if ((r121 instanceof PopupWindow) == false) goto L27;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r121) == false) goto L27;
            r121.update(0, 0, -1, -1);
        L30:
            r112.addUpdateListener(new a(this, r118, r115, r109, r116, r100, r117, r101, r120, r119, r113, r110, r114, r111));
            r112.setInterpolator(new AccelerateDecelerateInterpolator());
            r112.start();
            return;
        L27:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r121, 0, 0, -1, -1) == true) goto L30;
            r121.update(0, 0, -1, -1);
            goto L30
        L15:
            if (r101.element > 0) goto L17;
        L11:
            r105 = 0;
            goto L12
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

    static {
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        if (this.f113958e == false) goto L5;
        return;
    L5:
        this.f113958e = true;
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
        int[] r101 = new int[2];
        View r102 = getContentView();
        if (r102 == null) goto L8;
        r102.getLocationOnScreen(r101);
    L8:
        r100.addUpdateListener(new C1679b(this));
        r100.start();
    }

    public final Activity getContext() {
        return this.f113960g;
    }

    public static final void a(b r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        super.dismiss();
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r100, int r101, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r100) == true) goto L13;
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L8;
        super.showAtLocation(r100, r101, r110, r111);
        goto L13
    L8:
        OverlaySource r102 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r102, r101, r110, r111) == true) goto L13;
        super.showAtLocation(r100, r101, r110, r111);
        PopupWindowLancet.trackAfterShow(this, r102, r100);
    L13:
        if (this.f113967n == true) goto L17;
        View r103 = this.f113954a;
        if (r103 == null) goto L17;
        UtilityKotlinExtentionsKt.z(r103, false);
    L17:
        if (r100 == null) goto L20;
        r100.post(new c(this));
        return;
    }

    public b(Activity r100, Bitmap r101, int r102, int r103, float r104, float r105, VideoViewParams r110, QuickRecordBasePresenter$showRecordShareDialog$1.a.ViewOnClickListenerC1683a r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "quickScreenShot");
        this.f113960g = r100;
        this.f113961h = r102;
        this.f113962i = r103;
        this.f113963j = r104;
        this.f113964k = r105;
        this.f113965l = r110;
        this.f113966m = r111;
        this.f113967n = r112;
        LayoutInflater r106 = LayoutInflater.from(r100);
        int r107 = bs1.a.f20221a;
        setContentView(r106.inflate(R.layout.ttlive_vs_dialog_quick_screenrecord_landscape_v2, null));
        FrameLayout r108 = (FrameLayout) getContentView().findViewById(R.id.ttlive_vs_dialog_container);
        this.f113959f = r108;
        ImageView r109 = (ImageView) getContentView().findViewById(R.id.ttlive_vs_quick_screenshot_img);
        this.f113954a = getContentView().findViewById(R.id.btn_share);
        this.f113955b = getContentView().findViewById(R.id.ttlive_vs_dialog_content);
        this.f113956c = getContentView().findViewById(R.id.ttlive_vs_quick_record_icon);
        this.f113957d = getContentView().findViewById(R.id.ttlive_vs_quick_record_snapshot);
        getContentView().setOnClickListener(new com.bytedance.android.livesdk.chatroom.ui.record.c(this));
        Bitmap r113 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), Bitmap.Config.ARGB_4444);
        Rect r114 = new Rect(0, 0, r101.getWidth(), r101.getHeight());
        RectF r115 = new RectF(r114);
        Canvas r116 = new Canvas(r113);
        r116.drawARGB(0, 0, 0, 0);
        Paint r117 = new Paint();
        r117.setAntiAlias(true);
        float r118 = 20;
        r116.drawRoundRect(r115, UtilityKotlinExtentionsKt.h(r118), UtilityKotlinExtentionsKt.h(r118), r117);
        r117.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r116.drawBitmap(r101, r114, r114, r117);
        if (r109 == null) goto L5;
        r109.setImageBitmap(r113);
    L5:
        if (r109 == null) goto L7;
        r109.setScaleType(ImageView.ScaleType.FIT_XY);
    L7:
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setOutsideTouchable(false);
        r108.setOnClickListener(new com.bytedance.android.livesdk.chatroom.ui.record.a(this));
    }
}
