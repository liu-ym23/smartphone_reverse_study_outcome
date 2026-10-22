package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.utils.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/item/video/VideoProgressBar;", "Landroid/view/View;", "", "getDragProgress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressBar extends View {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f169757q = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f169758r = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f169759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f169760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f169761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f169762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f169763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f169764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f169765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f169766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f169767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b f169768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f169769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f169770l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f169771m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f169772n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f169773o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f169774p;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoProgressBar f169775a;

        public b(VideoProgressBar r100) {
            this.f169775a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            VideoProgressBar r101 = this.f169775a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            float r103 = ((Float) r102).floatValue();
            float r104 = VideoProgressBar.f169757q;
            r101.d(r103);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoProgressBar f169776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f169777b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f169777b == true) goto L8;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r101 = this.f169776a.f169768j;
            if (r101 == null) goto L9;
            r101.onDragEnd();
            return;
        L9:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f169777b == false) goto L8;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r101 = this.f169776a.f169768j;
            if (r101 == null) goto L9;
            r101.onDragStart();
            return;
        L9:
            return;
        }

        public c(VideoProgressBar r100, boolean r101) {
            this.f169776a = r100;
            this.f169777b = r101;
        }
    }

    static {
        f169757q = q.a(8);
        f169758r = q.a(16);
    }

    public final float getDragProgress() {
        return this.f169762d;
    }

    public final boolean b(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L6:
        if (r101 != null) goto L9;
    L18:
        if (r101 != null) goto L21;
    L23:
        if (r101 != null) goto L26;
    L32:
        if (r101 != null) goto L35;
    L45:
        return true;
    L35:
        if (r101.intValue() != 2) goto L45;
        if (this.f169767i == false) goto L45;
        if (this.f169766h == true) goto L41;
        this.f169766h = true;
        c(true);
    L41:
        float r102 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.f169762d + ((r100.getX() - this.f169765g) / getWidth()), 1.0f), 0.0f);
        this.f169762d = r102;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r103 = this.f169768j;
        if (r103 == null) goto L44;
        r103.b(r102);
    L44:
        invalidate();
        this.f169765g = r100.getX();
        goto L45
    L26:
        if (r101.intValue() != 3) goto L32;
    L28:
        if (this.f169766h == false) goto L45;
        this.f169766h = false;
        c(false);
        float r104 = this.f169762d;
        this.f169761c = r104;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r105 = this.f169768j;
        if (r105 == null) goto L45;
        r105.a(r104);
        goto L45
    L21:
        if (r101.intValue() != 1) goto L23;
    L9:
        if (r101.intValue() != 0) goto L18;
        if (r100.getY() >= (getBottom() - this.f169774p)) goto L14;
        this.f169767i = false;
        return false;
    L14:
        this.f169767i = true;
        this.f169765g = r100.getX();
        this.f169766h = false;
        ViewParent r106 = getParent();
        if (r106 == null) goto L17;
        r106.requestDisallowInterceptTouchEvent(true);
    L17:
        this.f169762d = this.f169761c;
        goto L45
    L4:
        r101 = null;
        goto L6
    }

    public final void c(boolean r100) {
        ValueAnimator r101 = this.f169764f;
        if (r101 == null) goto L6;
        r101.cancel();
    L6:
        if (r100 == false) goto L8;
        float r102 = 0.0f;
    L9:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{r102, 1.0f - r102});
        r103.setDuration(200);
        r103.addUpdateListener(new b(this));
        r103.addListener(new c(this, r100));
        r103.start();
        Unit r104 = Unit.INSTANCE;
        this.f169764f = r103;
        return;
    L8:
        r102 = 1.0f;
        goto L9
    }

    public final void d(float r100) {
        this.f169760b = r100;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r101 = this.f169768j;
        if (r101 == null) goto L5;
        r101.c(r100);
    L5:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = this.f169760b;
        float r101 = this.f169773o;
        float r102 = this.f169772n;
        float r103 = (r100 * (r101 - r102)) + r102;
        float r104 = r103 / 2.0f;
        float r105 = getWidth();
        float r106 = 0;
        if (this.f169760b <= r106) goto L5;
        float r107 = this.f169762d;
    L6:
        float r108 = r105 * r107;
        float r109 = 0.0f;
        if (this.f169771m == false) goto L9;
        this.f169763e.set(0.0f, (getHeight() - r103) / 2.0f, getWidth(), (getHeight() + r103) / 2.0f);
    L10:
        this.f169759a.setColor(this.f169769k);
        r110.drawRoundRect(this.f169763e, r104, r104, this.f169759a);
        this.f169759a.setColor(this.f169770l);
        RectF r111 = this.f169763e;
        r111.right = r108;
        r110.drawRoundRect(r111, r104, r104, this.f169759a);
        if (this.f169760b <= r106) goto L22;
        this.f169759a.setColor(-1);
        RectF r112 = this.f169763e;
        float r113 = f169757q;
        float r114 = this.f169760b;
        float r115 = f169758r;
        r112.set(((-r113) / 2.0f) * r114, ((-r115) / 2.0f) * r114, (r113 / 2.0f) * r114, (r115 / 2.0f) * r114);
        float r116 = 2;
        float r117 = r108 - (r104 - (this.f169763e.width() / r116));
        if (r117 < r106) goto L17;
        r109 = r117;
    L17:
        if (this.f169771m == false) goto L19;
        this.f169763e.offset(r109, getHeight() / 2.0f);
    L20:
        float r118 = this.f169763e.width() / r116;
        r110.drawRoundRect(this.f169763e, r118, r118, this.f169759a);
        return;
    L19:
        this.f169763e.offset(r109, getHeight() - r104);
        goto L20
    L22:
        return;
    L9:
        this.f169763e.set(0.0f, getHeight() - r103, getWidth(), getHeight());
        goto L10
    L5:
        r107 = this.f169761c;
        goto L6
    }

    public VideoProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f169759a = new Paint(1);
        this.f169763e = new RectF();
        this.f169769k = 1476395007;
        this.f169770l = -1056964609;
        this.f169772n = q.a(2);
        this.f169773o = q.a(12);
        this.f169774p = com.bytedance.android.shopping.extensions.b.a(44);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(View.MeasureSpec.getSize(r100), (int) this.f169773o);
    }

    public static void a(VideoProgressBar r100, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r101, boolean r102, Float r103, Integer r104, int r105, int r106, int r107) {
        if ((r107 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r107 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r107 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r107 & 32) == 0) goto L15;
        r105 = 1476395007;
    L15:
        if ((r107 & 64) == 0) goto L17;
        r106 = -1056964609;
    L17:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        r100.f169768j = r101;
        r100.f169771m = r102;
        r100.f169769k = r105;
        r100.f169770l = r106;
        if (r103 == null) goto L20;
        r100.f169772n = r103.floatValue();
    L20:
        if (r104 == null) goto L23;
        r100.f169774p = r104.intValue();
        return;
    }
}
