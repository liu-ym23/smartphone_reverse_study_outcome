package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.State;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends LinearLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f169477x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f169478y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f169479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f169480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f169481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f169482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f169483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f169484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f169485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f169486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f169487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f169488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ValueAnimator f169489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ValueAnimator f169490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ValueAnimator f169491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f169492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f169493o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f169494p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Interpolator f169495q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f169496r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f169497s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f169498t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Float f169499u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f169500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f169501w;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f169502c;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final boolean a(int r100) {
            f r101 = this.f169502c.f169501w;
            int r102 = d.f169477x;
            return r101.wW(d.f169478y, Integer.valueOf(r100));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final void b(RectF r100) {
            boolean r101 = false;
            if (r100 == null) goto L8;
            d r102 = this.f169502c;
            r102.f169481c = true;
            int r103 = r102.getChildCount();
            int r104 = 0;
        L5:
            if (r104 >= r103) goto L7;
            r102.getChildAt(r104).setAlpha(1.0f);
            r104 = r104 + 1;
            goto L5
        L7:
            this.f169502c.invalidate();
        L8:
            if (r100 != null) goto L10;
            return;
        L10:
            if (r100.height() <= 0) goto L12;
            r101 = true;
        L12:
            if (r101 == true) goto L15;
            r100 = null;
        L15:
            if (r100 == null) goto L23;
            float r105 = r100.bottom;
            float r106 = d.f169477x;
            float r107 = Float.valueOf((r105 - r106) - com.bytedance.android.shopping.extensions.b.a(12)).floatValue();
            d r108 = this.f169502c;
            if (r108.f169493o == false) goto L19;
            r108.setTranslationY((r107 + r106) - r108.f169488j);
            return;
        L19:
            r108.setTranslationY(r107);
            this.f169502c.f169499u = Float.valueOf(r107);
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final void d(boolean r100) {
            dm.a.a("-----xias").b("isShow: " + r100, null);
            if (r100 == false) goto L14;
            d r101 = this.f169502c;
            if (r101.f169492n == true) goto L12;
            if (r101.f169494p == true) goto L28;
            r101.f169494p = true;
            if (r101.f169501w.ey(m.f169522o) == true) goto L29;
            d r102 = this.f169502c;
            e r103 = r102.f169500v;
            int r104 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.f169316a;
            r102.postDelayed(r103, 2000);
            return;
        L29:
            return;
        L28:
            return;
        L12:
            if (r101.f169493o == true) goto L31;
            r101.b();
            return;
        L31:
            return;
        L14:
            ValueAnimator r105 = this.f169502c.f169489k;
            if (r105 == null) goto L17;
            r105.cancel();
        L17:
            ValueAnimator r106 = this.f169502c.f169490l;
            if (r106 == null) goto L20;
            r106.cancel();
        L20:
            ValueAnimator r107 = this.f169502c.f169491m;
            if (r107 == null) goto L23;
            r107.cancel();
        L23:
            d r108 = this.f169502c;
            if (r108 == null) goto L26;
            r108.removeCallbacks(r108.f169500v);
        L26:
            this.f169502c.b();
        }

        public b(d r100, View r101, m0 r102) {
            this.f169502c = r100;
            super(r101, r102);
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f169503a;

        public c(Function1 r100) {
            this.f169503a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Function1 r101 = this.f169503a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.invoke((Float) r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d$d, reason: collision with other inner class name */
    public static final class C2552d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f169504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f169505b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f169504a.b();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f169505b.invoke();
        }

        public C2552d(d r100, Function0 r101) {
            this.f169504a = r100;
            this.f169505b = r101;
        }
    }

    static {
        f169477x = com.bytedance.android.shopping.extensions.b.a(34);
        f169478y = "bottom_left_find_same";
    }

    public final void b() {
        int r100 = com.bytedance.android.shopping.extensions.b.a(12);
        ImageView r101 = this.f169483e;
        if (r101 == null) goto L15;
        if (r101 == null) goto L6;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L7:
        if (r102 == null) goto L9;
        r102.width = r100;
    L9:
        if (r102 == null) goto L11;
        r102.height = r100;
    L11:
        if (r102 == null) goto L15;
        ImageView r103 = this.f169483e;
        if (r103 == null) goto L15;
        r103.setLayoutParams(r102);
        goto L15
    L6:
        r102 = null;
    L15:
        TextView r104 = this.f169484f;
        if (r104 == null) goto L18;
        r104.setText("找同款");
    L18:
        TextView r105 = this.f169484f;
        if (r105 == null) goto L21;
        r105.setTextSize(1, 10.0f);
    L21:
        ViewGroup.LayoutParams r106 = getLayoutParams();
        if (r106 == null) goto L24;
        r106.width = this.f169486h;
    L24:
        if (r106 == null) goto L26;
        r106.height = this.f169488j;
    L26:
        if (r106 == null) goto L28;
        setLayoutParams(r106);
    L28:
        int r107 = this.f169497s;
        setPadding(r107, 0, r107, 0);
        Float r108 = this.f169499u;
        if (r108 == null) goto L31;
        setTranslationY((r108.floatValue() + f169477x) - this.f169488j);
    L31:
        this.f169493o = true;
        this.f169501w.gD(State.SHOW);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b getLayerItem() {
        return new b(this, this, new m0(true, true, true, 1, false, 48));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f169500v);
        ValueAnimator r100 = this.f169489k;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f169490l;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        ValueAnimator r102 = this.f169491m;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        super.onDetachedFromWindow();
    }

    public final boolean getBubbleIsShown() {
        return this.f169482d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f169481c == false) goto L5;
        this.f169479a.setColor(CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR);
        float r101 = getHeight() / 2.0f;
        float r102 = q.a(Double.valueOf(0.5d));
        this.f169479a.setStyle(Paint.Style.FILL);
        this.f169480b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f169480b.inset(r102, r102);
        r100.drawRoundRect(this.f169480b, r101, r101, this.f169479a);
        this.f169480b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f169479a.setStrokeWidth(r102);
        this.f169479a.setStyle(Paint.Style.STROKE);
        this.f169479a.setColor(536870911);
        r100.drawRoundRect(this.f169480b, r101, r101, this.f169479a);
    L5:
        super.dispatchDraw(r100);
    }

    public final void setBubbleIsShown(boolean r100) {
        this.f169482d = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        if (r100 != 0) goto L6;
        f r101 = this.f169501w;
        int r102 = m.f169521n;
        if (r101.ey(m.f169522o) == false) goto L6;
        b();
    L6:
        super.setVisibility(r100);
    }

    public d(FragmentActivity r110, f r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "callback");
        super(r110);
        this.f169501w = r111;
        Paint r112 = new Paint(1);
        r112.setColor(CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR);
        r112.setStyle(Paint.Style.FILL);
        Unit r100 = Unit.INSTANCE;
        this.f169479a = r112;
        this.f169480b = new RectF();
        int r113 = com.bytedance.android.shopping.extensions.b.a(153);
        int r101 = com.bytedance.android.shopping.extensions.b.a(46);
        this.f169485g = r101;
        int r102 = com.bytedance.android.shopping.extensions.b.a(32);
        int r103 = com.bytedance.android.shopping.extensions.b.a(64);
        this.f169486h = r103;
        this.f169487i = com.bytedance.android.shopping.extensions.b.a(34);
        this.f169488j = com.bytedance.android.shopping.extensions.b.a(20);
        int r104 = 0;
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{r113, r101});
        this.f169489k = r114;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f169490l = r105;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r103});
        this.f169491m = r106;
        float r107 = 0.0f;
        this.f169495q = new PathInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        int r108 = com.bytedance.android.shopping.extensions.b.a(14);
        this.f169496r = r108;
        this.f169497s = com.bytedance.android.shopping.extensions.b.a(10);
        int r109 = com.bytedance.android.shopping.extensions.b.a(18);
        this.f169498t = r109;
        setOrientation(0);
        setGravity(17);
        setPadding(r108, 0, r108, 0);
        ImageView r115 = new ImageView(r110);
        this.f169483e = r115;
        r115.setImageResource(R.drawable.anchor_v4_gallery_find_similar);
        addView(r115, new LinearLayout.LayoutParams(r109, r109));
        TextView r116 = new TextView(r110);
        this.f169484f = r116;
        r116.setText("找图片同款商品");
        r116.setTextColor(-1);
        r116.setSingleLine();
        r116.setTextSize(1, 15.0f);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-2, -2);
        r117.leftMargin = com.bytedance.android.shopping.extensions.b.a(2);
        addView(r116, r117);
        a(r114, new FindSimilarLayoutV2$4(this), new FindSimilarLayoutV2$5(this));
        a(r105, new FindSimilarLayoutV2$6(this), new FindSimilarLayoutV2$7(this));
        a(r106, new FindSimilarLayoutV2$8(this), new FindSimilarLayoutV2$9(this));
        if (this.f169481c == false) goto L5;
        r107 = 1.0f;
    L5:
        int r118 = getChildCount();
    L6:
        if (r104 >= r118) goto L8;
        getChildAt(r104).setAlpha(r107);
        r104 = r104 + 1;
        goto L6
    L8:
        this.f169500v = new e(this);
    }

    public final void a(ValueAnimator r100, Function1<? super Float, Unit> r101, Function0<Unit> r102) {
        if (r100 == null) goto L4;
        r100.setDuration(260);
    L4:
        if (r100 == null) goto L6;
        r100.setInterpolator(this.f169495q);
    L6:
        if (r100 == null) goto L8;
        r100.addUpdateListener(new c(r101));
    L8:
        if (r100 == null) goto L11;
        r100.addListener(new C2552d(this, r102));
        return;
    }
}
