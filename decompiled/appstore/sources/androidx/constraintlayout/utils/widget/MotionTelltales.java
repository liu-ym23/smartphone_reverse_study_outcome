package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f2158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MotionLayout f2159m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f2160n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Matrix f2161o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2162p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2163q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f2164r;

    public MotionTelltales(Context r10) {
        super(r10);
        this.f2158l = new Paint();
        this.f2160n = new float[2];
        this.f2161o = new Matrix();
        this.f2162p = 0;
        this.f2163q = -65281;
        this.f2164r = 0.25f;
        a(r10, null);
    }

    public final void a(Context r10, AttributeSet r11) {
        if (r11 == null) goto L16;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.MotionTelltales);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L15;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.MotionTelltales_telltales_tailColor) goto L9;
        this.f2163q = r12.getColor(r15, this.f2163q);
    L14:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R$styleable.MotionTelltales_telltales_velocityMode) goto L12;
        this.f2162p = r12.getInt(r15, this.f2162p);
        goto L14
    L12:
        if (r15 != R$styleable.MotionTelltales_telltales_tailScale) goto L14;
        this.f2164r = r12.getFloat(r15, this.f2164r);
        goto L14
    L15:
        r12.recycle();
    L16:
        this.f2158l.setColor(this.f2163q);
        this.f2158l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas r24) {
        super.onDraw(r24);
        getMatrix().invert(this.f2161o);
        if (this.f2159m != null) goto L8;
        ViewParent r10 = getParent();
        if ((r10 instanceof MotionLayout) == false) goto L17;
        this.f2159m = (MotionLayout) r10;
        return;
    L17:
        return;
    L8:
        int r11 = getWidth();
        int r12 = getHeight();
        float[] r13 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r14 = 0;
    L9:
        if (r14 >= 5) goto L14;
        float r15 = r13[r14];
        int r16 = 0;
    L11:
        if (r16 >= 5) goto L13;
        float r17 = r13[r16];
        this.f2159m.U(this, r17, r15, this.f2160n, this.f2162p);
        this.f2161o.mapVectors(this.f2160n);
        float r18 = r11 * r17;
        float r19 = r12 * r15;
        float[] r20 = this.f2160n;
        float r21 = r20[0];
        float r22 = this.f2164r;
        float r23 = r19 - (r20[1] * r22);
        this.f2161o.mapVectors(r20);
        r24.drawLine(r18, r19, r18 - (r21 * r22), r23, this.f2158l);
        r16 = r16 + 1;
        goto L11
    L13:
        r14 = r14 + 1;
        goto L9
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        postInvalidate();
    }

    public void setText(CharSequence r10) {
        this.f2116f = r10.toString();
        requestLayout();
    }

    public MotionTelltales(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f2158l = new Paint();
        this.f2160n = new float[2];
        this.f2161o = new Matrix();
        this.f2162p = 0;
        this.f2163q = -65281;
        this.f2164r = 0.25f;
        a(r10, r11);
    }

    public MotionTelltales(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f2158l = new Paint();
        this.f2160n = new float[2];
        this.f2161o = new Matrix();
        this.f2162p = 0;
        this.f2163q = -65281;
        this.f2164r = 0.25f;
        a(r10, r11);
    }
}
