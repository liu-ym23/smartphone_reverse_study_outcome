package com.bytedance.android.livesdk.chatroom.ui;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
public final class j8 extends PopupWindow implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f113605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f113606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f113607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f113608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f113609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f113610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Activity f113611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f113612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f113613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f113614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f113615k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VideoViewParams f113616l;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8 f113617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f113618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f113619c;

        public b(j8 r100, int r101, int r102) {
            this.f113617a = r100;
            this.f113618b = r101;
            this.f113619c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            View r101 = this.f113617a.getContentView();
            if (r101 == null) goto L6;
            int r102 = this.f113618b;
            r101.setX(r102 + ((this.f113619c - r102) * r100.getAnimatedFraction()));
        L6:
            if (r100.getAnimatedFraction() != 1.0f) goto L9;
            j8.a(this.f113617a);
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8 f113620a;

        public static final class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f113621a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.FloatRef f113622b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.FloatRef f113623c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ float f113624d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113625e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113626f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113627g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113628h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113629i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113630j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113631k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f113632l;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.j8$c$a$a, reason: collision with other inner class name */
            public static final class C1678a<T> implements Consumer {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f113633a;

                public C1678a(a r100) {
                    this.f113633a = r100;
                }

                @Override // io.reactivex.functions.Consumer
                public final void accept(Object r100) {
                    Long r101 = (Long) r100;
                    j8 r102 = this.f113633a.f113621a.f113620a;
                    PopupWindowLancet.handleDismissBeforeOrigin(r102);
                    r102.dismiss();
                }
            }

            public static final class b<T> implements Consumer {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final b f113634a = null;

                static {
                    f113634a = new b();
                }

                public b() {
                }

                @Override // io.reactivex.functions.Consumer
                public final void accept(Object r100) {
                    Throwable r101 = (Throwable) r100;
                    x8.a.b("QuickShotPopupWindow", "autodismiss Fail", false);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                this.f113622b.element = r100.getAnimatedFraction();
                Ref.FloatRef r101 = this.f113623c;
                float r102 = 1;
                float r103 = r102 - this.f113624d;
                Ref.FloatRef r104 = this.f113622b;
                float r105 = r102 - (r103 * r104.element);
                r101.element = r105;
                this.f113625e.element = (int) (this.f113626f.element * r105);
                Ref.IntRef r106 = this.f113627g;
                r106.element = (int) (this.f113628h.element * r105);
                Ref.IntRef r107 = this.f113629i;
                int r108 = this.f113630j.element;
                float r109 = r108;
                j8 r110 = this.f113621a.f113620a;
                float r111 = r110.f113612h - r108;
                float r112 = r104.element;
                r107.element = (int) (r109 + (r111 * r112));
                Ref.IntRef r113 = this.f113631k;
                int r114 = this.f113632l.element;
                r113.element = (int) ((r114 + ((r110.f113613i - r114) * r112)) - r106.element);
                View r115 = r110.f113606b;
                if (r115 == null) goto L9;
                r115.setAlpha(r102 - r112);
                ViewGroup.LayoutParams r116 = r115.getLayoutParams();
                if (r116 == null) goto L8;
                r116.width = this.f113625e.element;
                r116.height = this.f113627g.element;
                r115.setLayoutParams(r116);
                r115.setX(this.f113629i.element);
                r115.setY(this.f113631k.element);
                goto L9
            L8:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L9:
                HSImageView r117 = this.f113621a.f113620a.f113605a;
                if (r117 == null) goto L17;
                ViewGroup.LayoutParams r118 = r117.getLayoutParams();
                if (r118 == null) goto L15;
                r118.width = this.f113625e.element;
                r118.height = this.f113627g.element;
                r117.setLayoutParams(r118);
                r117.setX(this.f113629i.element);
                r117.setY(this.f113631k.element);
                goto L17
            L15:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L17:
                if (this.f113622b.element != 1.0f) goto L20;
                long r119 = this.f113621a.f113620a.f113614j;
                int r120 = r9.f113944a;
                Intrinsics.checkNotNullParameter("", "errorCode");
                Intrinsics.checkNotNullParameter("", "errorMsg");
                vr1.o r121 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
                Map<String, String> r122 = MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "1"), TuplesKt.to("sessionId", String.valueOf(r119))});
                am2.x r123 = new am2.x();
                r123.f4349a = "live";
                r123.f4353e = "show";
                r123.f4350b = "live_detail";
                r121.sendLog("livesdk_quick_shot_anim", r122, new Object[]{r123, IRoom.class});
                Observable.timer(2000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C1678a(this), b.f113634a);
                return;
            }

            public a(c r100, Ref.FloatRef r101, Ref.FloatRef r102, float r103, Ref.IntRef r104, Ref.IntRef r105, Ref.IntRef r106, Ref.IntRef r107, Ref.IntRef r108, Ref.IntRef r110, Ref.IntRef r111, Ref.IntRef r112) {
                this.f113621a = r100;
                this.f113622b = r101;
                this.f113623c = r102;
                this.f113624d = r103;
                this.f113625e = r104;
                this.f113626f = r105;
                this.f113627g = r106;
                this.f113628h = r107;
                this.f113629i = r108;
                this.f113630j = r110;
                this.f113631k = r111;
                this.f113632l = r112;
            }
        }

        public c(j8 r100) {
            this.f113620a = r100;
        }

        public final void a() {
            if (this.f113620a.f113616l == null) goto L32;
            Ref.IntRef r100 = new Ref.IntRef();
            r100.element = this.f113620a.f113616l.f112569a;
            Ref.IntRef r101 = new Ref.IntRef();
            r101.element = this.f113620a.f113616l.f112570b;
            Ref.IntRef r110 = new Ref.IntRef();
            vr1.u r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, null, 3);
            if (r102 == null) goto L11;
            com.bytedance.live.datacontext.n<Rect> r103 = r102.d();
            if (r103 == null) goto L11;
            Rect r104 = r103.getValue();
            if (r104 == null) goto L11;
            int r105 = r104.left;
        L12:
            r110.element = r105;
            Ref.IntRef r111 = new Ref.IntRef();
            VideoViewParams r106 = this.f113620a.f113616l;
            r111.element = r106.f112571c + r106.f112570b;
            if (r100.element > 0) goto L15;
        L16:
            r100.element = com.bytedance.android.live.core.utils.s1.t();
            r101.element = com.bytedance.android.live.core.utils.s1.r();
            r110.element = 0;
            r111.element = com.bytedance.android.live.core.utils.s1.r();
        L17:
            int r107 = r100.element;
            int r108 = r101.element;
            if (r107 >= r108) goto L21;
            r107 = r108;
        L21:
            ValueAnimator r112 = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(600);
            float r109 = this.f113620a.f113615k / r107;
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
            j8 r119 = this.f113620a;
            if ((r119 instanceof PopupWindow) == false) goto L27;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r119) == false) goto L27;
            r119.update(0, 0, -1, -1);
        L30:
            r112.addUpdateListener(new a(this, r118, r115, r109, r116, r100, r117, r101, r113, r110, r114, r111));
            r112.setInterpolator(new AccelerateDecelerateInterpolator());
            r112.start();
            return;
        L27:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r119, 0, 0, -1, -1) == true) goto L30;
            r119.update(0, 0, -1, -1);
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
        if (this.f113607c == false) goto L5;
        return;
    L5:
        this.f113607c = true;
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
        int[] r101 = new int[2];
        View r102 = getContentView();
        if (r102 == null) goto L8;
        r102.getLocationOnScreen(r101);
    L8:
        int r103 = 0;
        int r104 = r101[0];
        View r105 = getContentView();
        if (r105 == null) goto L11;
        r103 = r105.getWidth();
    L11:
        r100.addUpdateListener(new b(this, r104, -r103));
        r100.start();
    }

    public final Activity getContext() {
        return this.f113611g;
    }

    public static final void a(j8 r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        super.dismiss();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 == null) goto L4;
        Integer r102 = Integer.valueOf(r101.getAction());
    L6:
        if (r102 == null) goto L12;
        if (r102.intValue() != 0) goto L12;
        this.f113608d = r101.getX();
    L53:
        return true;
    L12:
        if (r102 != null) goto L15;
    L30:
        if (r102 != null) goto L33;
    L35:
        if (r102 == null) goto L53;
        if (r102.intValue() != 3) goto L53;
    L39:
        View r103 = getContentView();
        if (r103 == null) goto L42;
        int r104 = r103.getScrollX();
    L44:
        if (r104 <= com.bytedance.android.live.core.utils.s1.f(10.0f)) goto L46;
        boolean r105 = true;
    L47:
        if (r105 != true) goto L49;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        dismiss();
        goto L53
    L49:
        View r106 = getContentView();
        if (r106 == null) goto L52;
        r106.scrollTo(0, 0);
    L52:
        this.f113608d = 0.0f;
        goto L53
    L46:
        r105 = false;
        goto L47
    L42:
        r104 = 0;
        goto L44
    L33:
        if (r102.intValue() != 1) goto L35;
    L15:
        if (r102.intValue() != 2) goto L30;
        this.f113609e = r101.getX() - this.f113608d;
        View r107 = getContentView();
        if (r107 == null) goto L19;
        r107.scrollBy(-((int) this.f113609e), 0);
    L19:
        this.f113608d = r101.getX();
        View r108 = getContentView();
        if (r108 == null) goto L22;
        int r109 = r108.getScrollX();
    L23:
        if (r109 <= 0) goto L25;
        boolean r110 = true;
    L26:
        if (r110 == true) goto L53;
        View r111 = getContentView();
        if (r111 == null) goto L53;
        r111.scrollTo(0, 0);
        goto L53
    L25:
        r110 = false;
        goto L26
    L22:
        r109 = 0;
        goto L23
    L4:
        r102 = null;
        goto L6
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r100, int r101, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L6;
    L12:
        if (r100 == null) goto L15;
        r100.post(new c(this));
        return;
    L15:
        return;
    L6:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L8;
        super.showAtLocation(r100, r101, r110, r111);
        goto L12
    L8:
        OverlaySource r102 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r102, r101, r110, r111) == true) goto L12;
        super.showAtLocation(r100, r101, r110, r111);
        PopupWindowLancet.trackAfterShow(this, r102, r100);
        goto L12
    }

    public j8(Activity r100, Bitmap r101, int r102, int r103, long r110, float r111, VideoViewParams r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "quickScreenShot");
        this.f113611g = r100;
        this.f113612h = r102;
        this.f113613i = r103;
        this.f113614j = r110;
        this.f113615k = r111;
        this.f113616l = r112;
        setContentView(LayoutInflater.from(r100).inflate(R.layout.ttlive_vs_dialog_quick_screenshot, null));
        FrameLayout r104 = (FrameLayout) getContentView().findViewById(R.id.ttlive_vs_dialog_container);
        this.f113610f = r104;
        HSImageView r105 = (HSImageView) getContentView().findViewById(R.id.ttlive_vs_quick_screenshot_img);
        this.f113605a = r105;
        this.f113606b = getContentView().findViewById(R.id.ttlive_vs_quick_screenshot_layer);
        r104.setOnClickListener(new k8(this));
        int r106 = ColorProtector.parseColor("#66FFFFFF");
        int r107 = (int) UtilityKotlinExtentionsKt.h(2.0f);
        Bitmap r113 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), Bitmap.Config.ARGB_4444);
        Rect r114 = new Rect(0, 0, r101.getWidth(), r101.getHeight());
        RectF r115 = new RectF(r114);
        int r108 = r107 * 2;
        RectF r109 = new RectF(new Rect(r107, r107, r101.getWidth() - r108, r101.getHeight() - r108));
        Canvas r116 = new Canvas(r113);
        r116.drawARGB(0, 0, 0, 0);
        Paint r117 = new Paint();
        r117.setAntiAlias(true);
        float r118 = 20;
        r116.drawRoundRect(r115, UtilityKotlinExtentionsKt.h(r118), UtilityKotlinExtentionsKt.h(r118), r117);
        r117.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r116.drawBitmap(r101, r114, r114, r117);
        Paint r119 = new Paint();
        r119.setAntiAlias(true);
        r119.setStyle(Paint.Style.STROKE);
        r119.setColor(r106);
        r119.setStrokeWidth(UtilityKotlinExtentionsKt.h(5));
        r116.drawRoundRect(r109, UtilityKotlinExtentionsKt.h(r118), UtilityKotlinExtentionsKt.h(r118), r119);
        if (r105 == null) goto L5;
        r105.setImageBitmap(r113);
    L5:
        if (r105 == null) goto L7;
        r105.setScaleType(ImageView.ScaleType.FIT_XY);
    L7:
        if (r105 == null) goto L9;
        r105.setOnTouchListener(this);
    L9:
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setOutsideTouchable(true);
    }
}
