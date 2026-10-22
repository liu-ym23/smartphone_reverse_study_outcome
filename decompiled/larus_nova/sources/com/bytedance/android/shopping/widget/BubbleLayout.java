package com.bytedance.android.shopping.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes14.dex */
public class BubbleLayout extends LinearLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f187193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f187194t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f187195u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static float f187196v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static float f187197w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static float f187198x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f187199y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f187200z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f187201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f187202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f187203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f187204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f187205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f187206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f187207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f187208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f187209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Matrix f187210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f187211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f187212l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f187213m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f187214n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f187215o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f187216p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f187217q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f187218r;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BubbleOrientation {
    }

    public float getBubbleOffset() {
        float r100 = Math.max(this.f187215o, f187198x);
        int r101 = this.f187216p;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r100, this.f187205e - f187198x);
    L18:
        return Math.min(r100, this.f187206f - f187198x);
    L19:
        return Math.min(r100, this.f187206f - f187198x);
    L15:
        return Math.min(r100, this.f187205e - f187198x);
    }

    public final void a() {
        clearAnimation();
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 1.0f});
        r100.setDuration(100);
        r100.start();
        r100.addUpdateListener(new a());
    }

    public BubbleLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r110) {
        if (this.f187211k != null) goto L8;
        Bitmap r100 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f187211k = r100;
        if (r100.getDensity() == r110.getDensity()) goto L7;
        this.f187211k.setDensity(r110.getDensity());
    L7:
        this.f187212l = new Canvas(this.f187211k);
    L8:
        float r101 = this.f187205e;
        float r102 = this.f187206f;
        float r103 = Math.max(this.f187215o, f187198x);
        float r104 = Math.min(r103, r102 - f187198x);
        Matrix r105 = new Matrix();
        this.f187210j = new Matrix();
        int r106 = this.f187216p;
        if (r106 != 0) goto L11;
        r101 = Math.min(r103, r101 - f187198x);
        r105.postRotate(90.0f);
        this.f187210j.postRotate(90.0f);
        Matrix r107 = this.f187210j;
        int r108 = this.f187209i;
        r107.postTranslate(((r108 * 3) / 2) + r101, r108 + 0.0f);
        setPadding(0, f187193s, 0, 0);
        setGravity(17);
        this.f187204d = new RectF(0.0f, f187193s, this.f187205e, this.f187206f);
        r102 = 0.0f;
    L20:
        RectF r109 = this.f187204d;
        float r111 = r109.left;
        float r112 = (this.f187209i * 3) / 2;
        r109.left = r111 + r112;
        r109.top += r112;
        r109.right += r112;
        r109.bottom += r112;
        RectF r113 = new RectF();
        this.f187208h = r113;
        RectF r114 = this.f187204d;
        float r115 = r114.left;
        int r116 = this.f187209i;
        float r117 = r116 / 2;
        r113.left = r115 - r117;
        r113.top = r114.top - r117;
        r113.right = r114.right + r117;
        r113.bottom = r114.bottom + r117;
        float r118 = (r116 * 3) / 2;
        r105.postTranslate(r101 + r118, r102 + r118);
        this.f187201a.setColor(this.f187214n);
        this.f187201a.setStyle(Paint.Style.STROKE);
        this.f187201a.setStrokeWidth(this.f187209i);
        if (this.f187217q == false) goto L23;
        this.f187202b.reset();
        Path r119 = this.f187202b;
        RectF r120 = this.f187208h;
        float r121 = f187197w;
        int r122 = this.f187209i;
        r119.addRoundRect(r120, (r122 / 2) + r121, r121 + (r122 / 2), Path.Direction.CW);
        this.f187202b.addPath(this.f187207g, this.f187210j);
        this.f187212l.drawPath(this.f187202b, this.f187201a);
    L23:
        this.f187201a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f187201a.setColor(this.f187213m);
        this.f187201a.setStyle(Paint.Style.FILL);
        this.f187202b.reset();
        Path r123 = this.f187202b;
        RectF r124 = this.f187204d;
        float r125 = f187197w;
        r123.addRoundRect(r124, r125, r125, Path.Direction.CW);
        this.f187202b.addPath(this.f187203c, r105);
        this.f187212l.drawPath(this.f187202b, this.f187201a);
        this.f187201a.setXfermode(null);
        r110.drawBitmap(this.f187211k, 0.0f, 0.0f, null);
        return;
    L11:
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 == 3) goto L15;
        r102 = r104;
    L18:
        r101 = 0.0f;
        goto L20
    L15:
        r101 = Math.min(r103, r101 - f187198x);
        r105.postRotate(270.0f);
        this.f187210j.postRotate(270.0f);
        Matrix r126 = this.f187210j;
        int r127 = this.f187209i;
        r126.postTranslate(((r127 * 3) / 2) + r101, (r127 * 2) + r102);
        setPadding(0, 0, 0, f187193s);
        setGravity(17);
        this.f187204d = new RectF(0.0f, 0.0f, this.f187205e, this.f187206f - f187193s);
        goto L20
    L16:
        r102 = Math.min(r103, r102 - f187198x);
        r105.postRotate(180.0f);
        this.f187210j.postRotate(180.0f);
        Matrix r128 = this.f187210j;
        int r129 = this.f187209i;
        r128.postTranslate((r129 * 2) + r101, ((r129 * 3) / 2) + r102);
        setPadding(0, 0, f187193s, 0);
        setGravity(17);
        this.f187204d = new RectF(0.0f, 0.0f, this.f187205e - f187193s, this.f187206f);
        goto L20
    L17:
        float r130 = Math.min(r103, r102 - f187198x);
        setPadding(f187193s, 0, 0, 0);
        setGravity(17);
        Matrix r131 = this.f187210j;
        int r132 = this.f187209i;
        r131.postTranslate(r132 + 0.0f, ((r132 * 3) / 2) + r130);
        this.f187204d = new RectF(f187193s, 0.0f, this.f187205e, this.f187206f);
        r102 = r130;
        goto L18
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L16;
        if (r101 == 1) goto L13;
        if (r101 != 3) goto L19;
        if (this.f187218r == false) goto L19;
        a();
    L19:
        return super.onTouchEvent(r100);
    L13:
        if (this.f187218r == false) goto L19;
        a();
        goto L19
    L16:
        if (this.f187218r == false) goto L19;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.5f});
        r102.setDuration(100);
        r102.start();
        r102.addUpdateListener(new a());
        goto L19
    }

    public void setBgColor(int r100) {
        this.f187213m = r100;
    }

    public void setBorderColor(int r100) {
        this.f187214n = r100;
    }

    public void setBubbleOrientation(int r100) {
        this.f187216p = r100;
    }

    public void setNeedPath(boolean r100) {
        this.f187217q = r100;
    }

    public void setNeedPressFade(boolean r100) {
        this.f187218r = r100;
    }

    public BubbleLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static float b(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if ((getChildAt(0) instanceof TextView) == false) goto L5;
        TextView r102 = (TextView) getChildAt(0);
    L6:
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.MeasureSpec.getSize(r101);
        if (r102 == null) goto L9;
        int r107 = (((int) r102.getPaint().measureText(r102.getText().toString())) + r102.getPaddingLeft()) + r102.getPaddingRight();
    L10:
        int r108 = this.f187216p;
        if (r108 != 2) goto L13;
    L19:
        int r109 = f187199y;
        if (r107 <= r109) goto L22;
        r109 = (f187194t * 2) + r107;
    L22:
        int r110 = r109 + f187193s;
        int r111 = f187200z;
    L23:
        int r112 = this.f187209i;
        int r113 = r110 + (r112 * 3);
        int r114 = r111 + (r112 * 3);
        if (r103 != Integer.MIN_VALUE) goto L27;
        if (r105 != Integer.MIN_VALUE) goto L27;
        setMeasuredDimension(r113, r114);
    L31:
        this.f187205e = getMeasuredWidth() - (this.f187209i * 3);
        this.f187206f = getMeasuredHeight() - (this.f187209i * 3);
        return;
    L27:
        if (r103 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r113, r106);
        goto L31
    L29:
        if (r105 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r104, r114);
        goto L31
    L13:
        if (r108 == 1) goto L19;
        r110 = f187199y;
        if (r107 <= r110) goto L18;
        r110 = (f187194t * 2) + r107;
    L18:
        r111 = f187200z;
        goto L23
    L9:
        r107 = getMeasuredWidth();
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public BubbleLayout(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.f187201a = null;
        this.f187202b = new Path();
        Path r112 = new Path();
        this.f187203c = r112;
        Path r113 = new Path();
        this.f187207g = r113;
        this.f187215o = 0.75f;
        this.f187216p = 1;
        this.f187217q = true;
        int r101 = (int) b(r100, 0.5f);
        this.f187209i = r101;
        if (r101 >= 2) goto L5;
        this.f187209i = 2;
    L5:
        f187193s = (int) b(r100, 7.0f);
        f187194t = (int) b(r100, 10.0f);
        f187195u = (int) b(r100, 6.0f);
        f187196v = 2.0f;
        f187197w = b(r100, 6.0f);
        f187198x = f187193s + f187195u;
        f187199y = (int) b(r100, 50.0f);
        f187200z = (int) b(r100, 46.0f);
        Paint r102 = new Paint();
        this.f187201a = r102;
        r102.setStyle(Paint.Style.FILL);
        this.f187201a.setStrokeCap(Paint.Cap.BUTT);
        this.f187201a.setAntiAlias(true);
        this.f187201a.setStrokeWidth(f187196v);
        this.f187201a.setStrokeJoin(Paint.Join.MITER);
        this.f187213m = r100.getResources().getColor(R.color.s6_80);
        this.f187214n = ColorProtector.parseColor("#1DFFFFFF");
        this.f187201a.setColor(this.f187213m);
        setLayerType(1, this.f187201a);
        r112.moveTo(0.0f, 0.0f);
        int r103 = f187193s;
        r112.lineTo(r103, -r103);
        float r104 = f187193s;
        r112.lineTo(r104, r104);
        r112.close();
        r113.moveTo(0.0f, 0.0f);
        r113.lineTo((float) (((double) f187193s) + (((double) this.f187209i) * Math.sqrt(2.0d))), (float) (((double) (-f187193s)) - (((double) this.f187209i) * Math.sqrt(2.0d))));
        r113.lineTo((float) (((double) f187193s) + (((double) this.f187209i) * Math.sqrt(2.0d))), (float) (((double) f187193s) + (((double) this.f187209i) * Math.sqrt(2.0d))));
        r113.close();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
