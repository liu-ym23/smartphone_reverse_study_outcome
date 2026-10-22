package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes10.dex */
public class BubbleLayout extends LinearLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f149082s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f149083t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f149084u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static float f149085v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static float f149086w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static float f149087x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f149088y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f149089z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f149090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f149091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f149092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f149093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f149094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f149095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f149096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f149097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f149098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Matrix f149099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f149100k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f149101l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f149102m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f149103n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f149104o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f149105p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f149106q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f149107r;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BubbleOrientation {
    }

    public float getBubbleOffset() {
        float r100 = Math.max(this.f149104o, f149087x);
        int r101 = this.f149105p;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r100, this.f149094e - f149087x);
    L18:
        return Math.min(r100, this.f149095f - f149087x);
    L19:
        return Math.min(r100, this.f149095f - f149087x);
    L15:
        return Math.min(r100, this.f149094e - f149087x);
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
        if (this.f149100k != null) goto L8;
        Bitmap r100 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f149100k = r100;
        if (r100.getDensity() == r110.getDensity()) goto L7;
        this.f149100k.setDensity(r110.getDensity());
    L7:
        this.f149101l = new Canvas(this.f149100k);
    L8:
        float r101 = this.f149094e;
        float r102 = this.f149095f;
        float r103 = Math.max(this.f149104o, f149087x);
        float r104 = Math.min(r103, r102 - f149087x);
        Matrix r105 = new Matrix();
        this.f149099j = new Matrix();
        int r106 = this.f149105p;
        if (r106 != 0) goto L11;
        r101 = Math.min(r103, r101 - f149087x);
        r105.postRotate(90.0f);
        this.f149099j.postRotate(90.0f);
        Matrix r107 = this.f149099j;
        int r108 = this.f149098i;
        r107.postTranslate(((r108 * 3) / 2) + r101, r108 + 0.0f);
        setPadding(0, f149082s, 0, 0);
        setGravity(17);
        this.f149093d = new RectF(0.0f, f149082s, this.f149094e, this.f149095f);
        r102 = 0.0f;
    L20:
        RectF r109 = this.f149093d;
        float r111 = r109.left;
        float r112 = (this.f149098i * 3) / 2;
        r109.left = r111 + r112;
        r109.top += r112;
        r109.right += r112;
        r109.bottom += r112;
        RectF r113 = new RectF();
        this.f149097h = r113;
        RectF r114 = this.f149093d;
        float r115 = r114.left;
        int r116 = this.f149098i;
        float r117 = r116 / 2;
        r113.left = r115 - r117;
        r113.top = r114.top - r117;
        r113.right = r114.right + r117;
        r113.bottom = r114.bottom + r117;
        float r118 = (r116 * 3) / 2;
        r105.postTranslate(r101 + r118, r102 + r118);
        this.f149090a.setColor(this.f149103n);
        this.f149090a.setStyle(Paint.Style.STROKE);
        this.f149090a.setStrokeWidth(this.f149098i);
        if (this.f149106q == false) goto L23;
        this.f149091b.reset();
        Path r119 = this.f149091b;
        RectF r120 = this.f149097h;
        float r121 = f149086w;
        int r122 = this.f149098i;
        r119.addRoundRect(r120, (r122 / 2) + r121, r121 + (r122 / 2), Path.Direction.CW);
        this.f149091b.addPath(this.f149096g, this.f149099j);
        this.f149101l.drawPath(this.f149091b, this.f149090a);
    L23:
        this.f149090a.setColor(this.f149102m);
        this.f149090a.setStyle(Paint.Style.FILL);
        this.f149091b.reset();
        Path r123 = this.f149091b;
        RectF r124 = this.f149093d;
        float r125 = f149086w;
        r123.addRoundRect(r124, r125, r125, Path.Direction.CW);
        this.f149091b.addPath(this.f149092c, r105);
        this.f149101l.drawPath(this.f149091b, this.f149090a);
        r110.drawBitmap(this.f149100k, 0.0f, 0.0f, null);
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
        r101 = Math.min(r103, r101 - f149087x);
        r105.postRotate(270.0f);
        this.f149099j.postRotate(270.0f);
        Matrix r126 = this.f149099j;
        int r127 = this.f149098i;
        r126.postTranslate(((r127 * 3) / 2) + r101, (r127 * 2) + r102);
        setPadding(0, 0, 0, f149082s);
        setGravity(17);
        this.f149093d = new RectF(0.0f, 0.0f, this.f149094e, this.f149095f - f149082s);
        goto L20
    L16:
        r102 = Math.min(r103, r102 - f149087x);
        r105.postRotate(180.0f);
        this.f149099j.postRotate(180.0f);
        Matrix r128 = this.f149099j;
        int r129 = this.f149098i;
        r128.postTranslate((r129 * 2) + r101, ((r129 * 3) / 2) + r102);
        setPadding(0, 0, f149082s, 0);
        setGravity(17);
        this.f149093d = new RectF(0.0f, 0.0f, this.f149094e - f149082s, this.f149095f);
        goto L20
    L17:
        float r130 = Math.min(r103, r102 - f149087x);
        setPadding(f149082s, 0, 0, 0);
        setGravity(17);
        Matrix r131 = this.f149099j;
        int r132 = this.f149098i;
        r131.postTranslate(r132 + 0.0f, ((r132 * 3) / 2) + r130);
        this.f149093d = new RectF(f149082s, 0.0f, this.f149094e, this.f149095f);
        r102 = r130;
        goto L18
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L16;
        if (r101 == 1) goto L13;
        if (r101 != 3) goto L19;
        if (this.f149107r == false) goto L19;
        a();
    L19:
        return super.onTouchEvent(r100);
    L13:
        if (this.f149107r == false) goto L19;
        a();
        goto L19
    L16:
        if (this.f149107r == false) goto L19;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.5f});
        r102.setDuration(100);
        r102.start();
        r102.addUpdateListener(new a());
        goto L19
    }

    public void setBgColor(int r100) {
        this.f149102m = r100;
    }

    public void setBorderColor(int r100) {
        this.f149103n = r100;
    }

    public void setBubbleOrientation(int r100) {
        this.f149105p = r100;
    }

    public void setNeedPath(boolean r100) {
        this.f149106q = r100;
    }

    public void setNeedPressFade(boolean r100) {
        this.f149107r = r100;
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
        int r108 = this.f149105p;
        if (r108 != 2) goto L13;
    L19:
        int r109 = f149088y;
        if (r107 <= r109) goto L22;
        r109 = (f149083t * 2) + r107;
    L22:
        int r110 = r109 + f149082s;
        int r111 = f149089z;
    L23:
        int r112 = this.f149098i;
        int r113 = r110 + (r112 * 3);
        int r114 = r111 + (r112 * 3);
        if (r103 != Integer.MIN_VALUE) goto L27;
        if (r105 != Integer.MIN_VALUE) goto L27;
        setMeasuredDimension(r113, r114);
    L31:
        this.f149094e = getMeasuredWidth() - (this.f149098i * 3);
        this.f149095f = getMeasuredHeight() - (this.f149098i * 3);
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
        r110 = f149088y;
        if (r107 <= r110) goto L18;
        r110 = (f149083t * 2) + r107;
    L18:
        r111 = f149089z;
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
        this.f149090a = null;
        this.f149091b = new Path();
        Path r112 = new Path();
        this.f149092c = r112;
        Path r113 = new Path();
        this.f149096g = r113;
        this.f149104o = 0.75f;
        this.f149105p = 1;
        this.f149106q = true;
        int r101 = (int) b(r100, 0.5f);
        this.f149098i = r101;
        if (r101 >= 2) goto L5;
        this.f149098i = 2;
    L5:
        f149082s = (int) b(r100, 7.0f);
        f149083t = (int) b(r100, 10.0f);
        f149084u = (int) b(r100, 6.0f);
        f149085v = 2.0f;
        f149086w = b(r100, 8.0f);
        f149087x = f149082s + f149084u;
        f149088y = (int) b(r100, 50.0f);
        f149089z = (int) b(r100, 46.0f);
        Paint r102 = new Paint();
        this.f149090a = r102;
        r102.setStyle(Paint.Style.FILL);
        this.f149090a.setStrokeCap(Paint.Cap.BUTT);
        this.f149090a.setAntiAlias(true);
        this.f149090a.setStrokeWidth(f149085v);
        this.f149090a.setStrokeJoin(Paint.Join.MITER);
        this.f149102m = th.a.a(r100, R.color.shopping_color_CC000000);
        this.f149103n = th.a.a(r100, R.color.shopping_color_1DFFFFFF);
        this.f149090a.setColor(this.f149102m);
        setLayerType(1, this.f149090a);
        r112.moveTo(0.0f, 0.0f);
        int r103 = f149082s;
        r112.lineTo(r103, -r103);
        float r104 = f149082s;
        r112.lineTo(r104, r104);
        r112.close();
        r113.moveTo(0.0f, 0.0f);
        r113.lineTo((float) (((double) f149082s) + (((double) this.f149098i) * Math.sqrt(2.0d))), (float) (((double) (-f149082s)) - (((double) this.f149098i) * Math.sqrt(2.0d))));
        r113.lineTo((float) (((double) f149082s) + (((double) this.f149098i) * Math.sqrt(2.0d))), (float) (((double) f149082s) + (((double) this.f149098i) * Math.sqrt(2.0d))));
        r113.close();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
