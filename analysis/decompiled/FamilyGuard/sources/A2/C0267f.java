package A2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import f2.C0702g;

/* renamed from: A2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0267f extends C0269h {

    /* renamed from: m, reason: collision with root package name */
    private final RectF f119m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f120n;

    /* renamed from: o, reason: collision with root package name */
    private float[] f121o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f122p;

    public C0267f(Context context, int[] iArr) {
        this(context, null, iArr);
    }

    private boolean s(int[] iArr, float[] fArr) {
        if (iArr == null || iArr.length == 0) {
            C0702g.p("CategoricalColorHistogramDataDrawable", "invalid colors is empty");
            return false;
        }
        if (fArr == null || fArr.length == 0) {
            C0702g.p("CategoricalColorHistogramDataDrawable", "invalid sizes is empty");
            return false;
        }
        if (iArr.length == fArr.length) {
            return true;
        }
        C0702g.p("CategoricalColorHistogramDataDrawable", "invalid colors.length != sizes.length");
        return false;
    }

    @Override // A2.C0269h, y2.g
    public void c(Canvas canvas) {
        canvas.save();
        Path pathH = h();
        if (pathH != null) {
            canvas.clipPath(pathH);
        }
        int iQ = q();
        if (iQ != 0) {
            this.f124j.setColor(iQ);
            canvas.drawRect(getBounds(), this.f124j);
        }
        y2.k kVarK = k();
        if (!s(this.f120n, this.f121o)) {
            C0702g.p("CategoricalColorHistogramDataDrawable", "draw: invalid colors and heights");
            canvas.restore();
            return;
        }
        int length = this.f121o.length;
        Rect rectB = b();
        int i5 = 0;
        if (this.f110c) {
            float f5 = rectB.bottom;
            float f6 = rectB.top;
            while (i5 < length) {
                if (this.f121o[i5] > 0.0f && f5 > f6) {
                    this.f124j.setColor(this.f120n[i5]);
                    float fMax = Math.max(f6, f5 - this.f121o[i5]);
                    this.f119m.set(rectB.left, fMax, rectB.right, f5);
                    canvas.drawRect(this.f119m, this.f124j);
                    f5 = fMax;
                }
                i5++;
            }
            if (kVarK == y2.k.UNSELECTED || kVarK == y2.k.NOT_HOVER) {
                this.f124j.setColor(r()[kVarK.ordinal()]);
                canvas.drawRect(b(), this.f124j);
            }
        } else {
            float f7 = rectB.left;
            float f8 = rectB.right;
            while (i5 < length) {
                if (this.f121o[i5] > 0.0f && f7 < f8) {
                    this.f124j.setColor(this.f120n[i5]);
                    float fMin = Math.min(f8, this.f121o[i5] + f7);
                    this.f119m.set(f7, rectB.top, fMin, rectB.bottom);
                    canvas.drawRect(this.f119m, this.f124j);
                    f7 = fMin;
                }
                i5++;
            }
            if (kVarK == y2.k.UNSELECTED || kVarK == y2.k.NOT_HOVER) {
                this.f124j.setColor(r()[kVarK.ordinal()]);
                canvas.drawRect(b(), this.f124j);
            }
        }
        canvas.restore();
    }

    @Override // A2.AbstractC0265d, A2.m
    public void e(int i5, int i6, int i7, int i8) {
        l(new Rect(i5, i6, i7, i8));
    }

    @Override // A2.AbstractC0265d
    public void l(Rect rect) {
        super.l(rect);
        Rect rectB = b();
        float[] fArr = this.f122p;
        if (fArr == null) {
            return;
        }
        float[] fArr2 = this.f121o;
        if (fArr2 == null || fArr2.length != fArr.length) {
            this.f121o = new float[fArr.length];
        }
        float fHeight = this.f110c ? rectB.height() : rectB.width();
        int i5 = 0;
        while (true) {
            float[] fArr3 = this.f122p;
            if (i5 >= fArr3.length) {
                return;
            }
            this.f121o[i5] = fArr3[i5] * fHeight;
            i5++;
        }
    }

    public int[] t() {
        return this.f120n;
    }

    public void u(int[] iArr) {
        this.f120n = iArr;
    }

    public void v(float[] fArr) {
        this.f122p = fArr;
        if (fArr == null) {
            this.f121o = null;
            return;
        }
        int length = fArr.length;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f6 = this.f122p[i5];
            if (f6 > 0.0f) {
                f5 += f6;
            }
        }
        if (f5 > 1.0001f) {
            for (int i6 = 0; i6 < length; i6++) {
                float[] fArr2 = this.f122p;
                fArr2[i6] = fArr2[i6] / f5;
            }
        }
        float[] fArr3 = new float[length];
        float fHeight = this.f110c ? b().height() : b().width();
        for (int i7 = 0; i7 < length; i7++) {
            fArr3[i7] = this.f122p[i7] * fHeight;
        }
        this.f121o = fArr3;
    }

    public C0267f(Context context, int[] iArr, int[] iArr2) {
        this(context, iArr, iArr2, 0);
    }

    public C0267f(Context context, int[] iArr, int[] iArr2, int i5) {
        super(context, iArr, i5);
        this.f119m = new RectF();
        this.f120n = iArr2;
    }
}
