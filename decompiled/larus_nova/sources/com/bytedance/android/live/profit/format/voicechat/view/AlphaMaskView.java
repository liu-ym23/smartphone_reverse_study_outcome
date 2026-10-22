package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/AlphaMaskView;", "Landroid/view/View;", "", "resId", "", "setResource", "Landroid/graphics/Bitmap;", ce.f26391f, "Lkotlin/Lazy;", "getGradientBitmap", "()Landroid/graphics/Bitmap;", "gradientBitmap", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaMaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f87689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f87690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f87691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f87692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f87693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f87694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f87695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f87696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f87697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f87698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f87699k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaMaskView f87700a;

        public a(AlphaMaskView r100) {
            this.f87700a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            AlphaMaskView r101 = this.f87700a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.f87690b = ((Float) r102).floatValue();
            this.f87700a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public AlphaMaskView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AlphaMaskView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Bitmap getGradientBitmap() {
        return (Bitmap) this.f87695g.getValue();
    }

    public final void b() {
        Bitmap r100 = this.f87691c;
        if (r100 != null) goto L5;
        return;
    L5:
        float r101 = getWidth();
        float r102 = getHeight();
        float r103 = r100.getWidth();
        float r104 = r100.getHeight();
        float r105 = Math.max(r101 / r103, r102 / r104);
        this.f87697i.reset();
        this.f87697i.postScale(r105, r105);
        float r106 = r101 - (r103 * r105);
        float r107 = 2;
        this.f87697i.postTranslate(r106 / r107, (r102 - (r104 * r105)) / r107);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Bitmap r100 = this.f87691c;
        if (r100 != null) goto L5;
    L8:
        float r101 = getHeight() * this.f87689a;
        float r102 = getHeight() - ((getHeight() + r101) * this.f87690b);
        this.f87698j.set(0.0f, r102, getWidth(), r102 + r101);
        this.f87696h.reset();
        this.f87696h.setScale(getWidth(), (getHeight() * this.f87689a) / getGradientBitmap().getHeight());
        this.f87696h.postTranslate(0.0f, getHeight() - ((getHeight() + r101) * this.f87690b));
        r110.drawBitmap(getGradientBitmap(), this.f87696h, this.f87693e);
        r110.drawRect(0.0f, this.f87698j.bottom - 1.0f, getWidth(), getHeight(), this.f87694f);
        return;
    L5:
        if (this.f87699k == true) goto L7;
        this.f87692d.setAlpha(255 - ((int) (this.f87690b * 255)));
    L7:
        r110.drawBitmap(r100, this.f87697i, this.f87692d);
        goto L8
    }

    public final void setResource(int r100) {
        this.f87691c = BitmapFactory.decodeResource(getResources(), r100);
        if (getWidth() > 0) goto L5;
    L7:
        invalidate();
        return;
    L5:
        if (getHeight() <= 0) goto L7;
        b();
        goto L7
    }

    public final Animator a(boolean r100, long r101) {
        this.f87699k = r100;
        if (r100 == false) goto L5;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    L6:
        r102.setDuration(r101);
        r102.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.25f, 1.0f));
        r102.addUpdateListener(new a(this));
        return r102;
    L5:
        r102 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        goto L6
    }

    public AlphaMaskView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f87689a = 0.4f;
        this.f87692d = new Paint(1);
        Paint r103 = new Paint(1);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Unit r104 = Unit.INSTANCE;
        this.f87693e = r103;
        Paint r105 = new Paint(1);
        r105.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f87694f = r105;
        this.f87695g = LazyKt.lazy(AlphaMaskView$gradientBitmap$2.INSTANCE);
        this.f87696h = new Matrix();
        this.f87697i = new Matrix();
        this.f87698j = new RectF();
        this.f87699k = true;
        Bitmap r106 = null;
        setLayerType(2, null);
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maskSrc}, 0, 0);
        Drawable r108 = r107.getDrawable(0);
        if ((r108 instanceof BitmapDrawable) == true) goto L5;
        r108 = null;
    L5:
        BitmapDrawable r109 = (BitmapDrawable) r108;
        if (r109 == null) goto L8;
        r106 = r109.getBitmap();
    L8:
        this.f87691c = r106;
        r107.recycle();
    }

    public /* synthetic */ AlphaMaskView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L8;
        if (r101 <= 0) goto L8;
        if (this.f87691c == null) goto L8;
        b();
    L8:
        this.f87696h.reset();
        this.f87696h.postScale(getWidth(), (getHeight() * this.f87689a) / getGradientBitmap().getHeight());
    }
}
