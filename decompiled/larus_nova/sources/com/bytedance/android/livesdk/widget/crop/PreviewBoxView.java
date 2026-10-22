package com.bytedance.android.livesdk.widget.crop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes11.dex */
public class PreviewBoxView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f161643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f161644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f161645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f161646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ShapeType f161647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f161648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f161649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f161650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap f161651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f161652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f161653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f161654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f161655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f161656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RectF f161657o;

    public static final enum ShapeType extends Enum<ShapeType> {
        public static final ShapeType OVAL = null;
        public static final ShapeType RECTANGLE = null;
        public static final ShapeType ROUND_RECTANGLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShapeType[] f161658a = null;

        static {
            ShapeType r100 = new ShapeType("RECTANGLE", 0);
            RECTANGLE = r100;
            ShapeType r101 = new ShapeType("OVAL", 1);
            OVAL = r101;
            ShapeType r102 = new ShapeType("ROUND_RECTANGLE", 2);
            ROUND_RECTANGLE = r102;
            f161658a = new ShapeType[]{r100, r101, r102};
        }

        public static ShapeType[] values() {
            return (ShapeType[]) f161658a.clone();
        }

        public static ShapeType valueOf(String r100) {
            return (ShapeType) r27.a.a(ShapeType.class, r100);
        }

        public ShapeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewBoxView f161659a;

        public a(PreviewBoxView r100) {
            this.f161659a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            PreviewBoxView r101 = this.f161659a;
            r101.f161652j = ((Float) r100.getAnimatedValue()).floatValue();
            PreviewBoxView r102 = this.f161659a;
            r102.setAlpha(r102.f161652j);
            this.f161659a.getClass();
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewBoxView f161660a;

        public b(PreviewBoxView r100) {
            this.f161660a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            PreviewBoxView r101 = this.f161660a;
            r101.f161652j = r101.f161653k;
            r101.f161644b = false;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f161661a = null;

        static {
            int[] r100 = new int[ShapeType.values().length];
            f161661a = r100;
            r100[ShapeType.RECTANGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f161661a[ShapeType.OVAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f161661a[ShapeType.ROUND_RECTANGLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public final void c() {
        if (Math.abs(this.f161652j - this.f161653k) >= Float.MIN_NORMAL) goto L5;
        return;
    L5:
        if (this.f161644b == true) goto L10;
        this.f161644b = true;
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{0.7f, this.f161653k});
        this.f161645c = r100;
        r100.setEvaluator(new FloatEvaluator());
        this.f161645c.setDuration(300);
        this.f161645c.addUpdateListener(new a(this));
        this.f161645c.addListener(new b(this));
        this.f161645c.setStartDelay(300);
        this.f161645c.start();
        return;
    }

    public Rect getVisibleRect() {
        Rect r100 = new Rect();
        RectF r101 = this.f161649g;
        r100.set((int) r101.left, (int) r101.top, (int) r101.right, (int) r101.bottom);
        return r100;
    }

    public final void a() {
        int r100 = getWidth() - (this.f161646d * 2);
        int r101 = (int) (r100 * this.f161648f);
        int r102 = this.f161655m;
        if (r102 >= 0) goto L5;
        r102 = Math.max(0, (getHeight() - r101) / 2);
    L5:
        int r103 = this.f161646d;
        this.f161649g = new RectF(r103, r102, r103 + r100, r102 + r101);
    }

    public PreviewBoxView(Context r100) {
        super(r100);
        this.f161644b = false;
        this.f161647e = ShapeType.RECTANGLE;
        this.f161648f = 0.5625f;
        this.f161650h = false;
        this.f161653k = 0.85f;
        this.f161654l = 0.0f;
        this.f161655m = -1;
        b(r100);
    }

    public final void b(Context r100) {
        Paint r101 = new Paint();
        this.f161643a = r101;
        r101.setAntiAlias(true);
        this.f161646d = (int) UIUtils.dip2Px(r100, 16.0f);
        this.f161652j = 0.7f;
        setAlpha(0.7f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        if (this.f161649g != null) goto L6;
        return;
    L6:
        if (this.f161651i != null) goto L31;
        int r100 = getWidth();
        int r101 = getHeight();
        RectF r102 = this.f161649g;
        int r103 = ColorProtector.parseColor("#0f0f0f");
        ShapeType r104 = this.f161647e;
        Bitmap r105 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_4444);
        Canvas r106 = new Canvas(r105);
        r106.drawColor(r103);
        Paint r107 = new Paint();
        r107.setAntiAlias(true);
        r107.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        int[] r108 = c.f161661a;
        int r109 = r108[r104.ordinal()];
        if (r109 == 1) goto L14;
        if (r109 == 2) goto L13;
        if (r109 != 3) goto L16;
        float r111 = this.f161654l;
        r106.drawRoundRect(r102, r111, r111, r107);
    L16:
        if (this.f161650h == false) goto L26;
        r107.setXfermode(null);
        r107.setStrokeWidth(s1.f(1.5f));
        r107.setColor(-1);
        r107.setStyle(Paint.Style.STROKE);
        int r112 = r108[r104.ordinal()];
        if (r112 == 1) goto L24;
        if (r112 == 2) goto L23;
        if (r112 != 3) goto L26;
        float r113 = this.f161654l;
        r106.drawRoundRect(r102, r113, r113, r107);
        goto L26
    L23:
        r106.drawOval(r102, r107);
        goto L26
    L24:
        r106.drawRect(r102, r107);
    L26:
        if (this.f161656n != null) goto L28;
    L30:
        this.f161651i = r105;
        goto L31
    L28:
        if (this.f161657o == null) goto L30;
        float r114 = this.f161649g.width() / 343.0f;
        RectF r115 = this.f161657o;
        float r116 = r115.left * r114;
        float r117 = this.f161646d;
        float r118 = r115.top * r114;
        float r119 = this.f161655m;
        r106.drawBitmap(this.f161656n, null, new RectF(r116 + r117, r118 + r119, (r115.right * r114) + r117, (r115.bottom * r114) + r119), this.f161643a);
        goto L30
    L13:
        r106.drawOval(r102, r107);
        goto L16
    L14:
        r106.drawRect(r102, r107);
    L31:
        r110.drawBitmap(this.f161651i, 0.0f, 0.0f, this.f161643a);
    }

    public void setTopOffset(int r100) {
        this.f161655m = r100;
    }

    public PreviewBoxView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f161644b = false;
        this.f161647e = ShapeType.RECTANGLE;
        this.f161648f = 0.5625f;
        this.f161650h = false;
        this.f161653k = 0.85f;
        this.f161654l = 0.0f;
        this.f161655m = -1;
        b(r100);
    }

    public PreviewBoxView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f161644b = false;
        this.f161647e = ShapeType.RECTANGLE;
        this.f161648f = 0.5625f;
        this.f161650h = false;
        this.f161653k = 0.85f;
        this.f161654l = 0.0f;
        this.f161655m = -1;
        b(r100);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a();
    }
}
