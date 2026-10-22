package com.stepos.guidepager;

import E2.c;
import E2.d;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.L;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class CirclePageIndicator extends View implements ViewPager.j {

    /* renamed from: a, reason: collision with root package name */
    private int f15341a;

    /* renamed from: b, reason: collision with root package name */
    private int f15342b;

    /* renamed from: c, reason: collision with root package name */
    private int f15343c;

    /* renamed from: d, reason: collision with root package name */
    private int f15344d;

    /* renamed from: e, reason: collision with root package name */
    private int f15345e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f15346f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f15347g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f15348h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager f15349i;

    /* renamed from: j, reason: collision with root package name */
    private ViewPager.j f15350j;

    /* renamed from: k, reason: collision with root package name */
    private int f15351k;

    /* renamed from: l, reason: collision with root package name */
    private int f15352l;

    /* renamed from: m, reason: collision with root package name */
    private float f15353m;

    /* renamed from: n, reason: collision with root package name */
    private int f15354n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f15355o;

    /* renamed from: p, reason: collision with root package name */
    private int f15356p;

    /* renamed from: q, reason: collision with root package name */
    private float f15357q;

    /* renamed from: r, reason: collision with root package name */
    private int f15358r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f15359s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f15360t;

    static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f15361a;

        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i5) {
                return new b[i5];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f15361a);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private b(Parcel parcel) {
            super(parcel);
            this.f15361a = parcel.readInt();
        }
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, E2.a.f1313a);
    }

    private int d(int i5, int i6, float f5, int i7) {
        int iRound;
        int iRound2;
        int iRound3;
        int iRound4;
        int iRed = Color.red(i5);
        int iGreen = Color.green(i5);
        int iBlue = Color.blue(i5);
        int iAlpha = Color.alpha(i5);
        int iRed2 = Color.red(i6);
        int iGreen2 = Color.green(i6);
        int iBlue2 = Color.blue(i6);
        int iAlpha2 = Color.alpha(i6);
        if (i7 < 0) {
            iRound = Math.round(iRed2 - ((iRed2 - iRed) * f5));
            iRound2 = Math.round(iGreen2 - ((iGreen2 - iGreen) * f5));
            iRound3 = Math.round(iBlue2 - ((iBlue2 - iBlue) * f5));
            iRound4 = Math.round(iAlpha2 - ((iAlpha2 - iAlpha) * f5));
        } else {
            iRound = Math.round(iRed + ((iRed2 - iRed) * f5));
            iRound2 = Math.round(iGreen + ((iGreen2 - iGreen) * f5));
            iRound3 = Math.round(iBlue + ((iBlue2 - iBlue) * f5));
            iRound4 = Math.round(iAlpha + ((iAlpha2 - iAlpha) * f5));
        }
        return Color.argb(iRound4, iRound, iRound2, iRound3);
    }

    private float e(float f5, float f6, float f7, int i5) {
        return i5 < 0 ? f6 - ((f6 - f5) * f7) : f5 + ((f6 - f5) * f7);
    }

    private void g(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        i();
        h(context, attributeSet);
    }

    private int getCount() {
        ViewPager viewPager = this.f15349i;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return 0;
        }
        return (!this.f15360t || this.f15349i.getAdapter().c() <= 1) ? this.f15349i.getAdapter().c() : this.f15349i.getAdapter().c() / 2;
    }

    private void h(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        TypedArray typedArrayF = f(context, attributeSet, d.f1386N);
        if (typedArrayF == null) {
            return;
        }
        Resources resources = getResources();
        int color = resources.getColor(E2.b.f1315b);
        int color2 = resources.getColor(E2.b.f1314a);
        int color3 = resources.getColor(E2.b.f1316c);
        float dimension = resources.getDimension(c.f1320d);
        float dimension2 = resources.getDimension(c.f1318b);
        float dimension3 = resources.getDimension(c.f1317a);
        float dimension4 = (int) resources.getDimension(c.f1319c);
        int i5 = d.f1396P;
        this.f15344d = typedArrayF.getColor(i5, color2);
        int i6 = d.f1406R;
        this.f15345e = typedArrayF.getColor(i6, color);
        this.f15346f.setColor(typedArrayF.getColor(i6, color));
        this.f15347g.setColor(typedArrayF.getColor(d.f1426V, color3));
        this.f15347g.setStrokeWidth(typedArrayF.getDimension(d.f1431W, dimension));
        this.f15348h.setColor(typedArrayF.getColor(i5, color2));
        this.f15341a = (int) typedArrayF.getDimension(d.f1411S, dimension2);
        this.f15342b = (int) typedArrayF.getDimension(d.f1401Q, dimension3);
        this.f15355o = typedArrayF.getBoolean(d.f1416T, true);
        this.f15343c = (int) typedArrayF.getDimension(d.f1421U, dimension4);
        Drawable drawable = typedArrayF.getDrawable(d.f1391O);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        typedArrayF.recycle();
    }

    private void i() {
        Paint paint = new Paint(1);
        this.f15346f = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.f15347g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        this.f15348h = paint3;
        paint3.setStyle(style);
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void a(int i5, float f5, int i6) {
        ViewPager viewPager = this.f15349i;
        if (viewPager == null) {
            return;
        }
        if (!this.f15360t || viewPager.getAdapter().c() <= 1) {
            this.f15351k = i5;
        } else {
            this.f15351k = i5 % (this.f15349i.getAdapter().c() / 2);
        }
        this.f15352l = this.f15351k;
        this.f15353m = f5;
        invalidate();
        ViewPager.j jVar = this.f15350j;
        if (jVar != null) {
            jVar.a(i5, f5, i6);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void b(int i5) {
        this.f15354n = i5;
        ViewPager.j jVar = this.f15350j;
        if (jVar != null) {
            jVar.b(i5);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void c(int i5) {
        if (getCount() <= 1) {
            return;
        }
        if (this.f15355o || this.f15354n == 0) {
            if (!this.f15360t || this.f15349i.getAdapter().c() <= 1) {
                this.f15351k = i5;
            } else {
                this.f15351k = i5 % (this.f15349i.getAdapter().c() / 2);
            }
            this.f15352l = this.f15351k;
            invalidate();
        }
        ViewPager.j jVar = this.f15350j;
        if (jVar != null) {
            jVar.c(i5);
        }
    }

    protected TypedArray f(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public int getFillColor() {
        return this.f15348h.getColor();
    }

    public int getPageColor() {
        return this.f15346f.getColor();
    }

    public float getRadius() {
        return this.f15341a;
    }

    public float getSpacing() {
        return this.f15343c;
    }

    public int getStrokeColor() {
        return this.f15347g.getColor();
    }

    public float getStrokeWidth() {
        return this.f15347g.getStrokeWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws Resources.NotFoundException {
        int count;
        super.onDraw(canvas);
        if (this.f15349i == null || (count = getCount()) == 0) {
            return;
        }
        if (this.f15351k >= count) {
            setCurrentItem(count - 1);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = this.f15341a;
        float f5 = (i5 * 2) + this.f15343c;
        float f6 = paddingTop + i5;
        float f7 = paddingLeft + i5;
        float strokeWidth = i5;
        if (this.f15347g.getStrokeWidth() > 0.0f) {
            strokeWidth -= this.f15347g.getStrokeWidth() / 2.0f;
        }
        this.f15346f.setColor(this.f15345e);
        int i6 = this.f15355o ? this.f15352l : this.f15351k;
        for (int i7 = 0; i7 < count; i7++) {
            if (i6 != i7 && ((i6 != count - 1 || i7 != 0) && i7 != i6 + 1)) {
                float f8 = (i7 * f5) + f7;
                if (this.f15346f.getAlpha() > 0) {
                    canvas.drawCircle(f8, f6, strokeWidth, this.f15346f);
                }
                int i8 = this.f15341a;
                if (strokeWidth != i8) {
                    canvas.drawCircle(f8, f6, i8, this.f15347g);
                }
            }
        }
        boolean z5 = this.f15355o;
        float f9 = (z5 ? this.f15352l : this.f15351k) * f5;
        if (!z5) {
            f9 += this.f15353m * f5;
        }
        float f10 = f9 + f7;
        int iD = d(this.f15345e, this.f15344d, this.f15353m, -1);
        float fE = e(this.f15341a, this.f15342b, this.f15353m, -1);
        this.f15348h.setColor(iD);
        canvas.drawCircle(f10, f6, fE, this.f15348h);
        if (this.f15351k != count - 1) {
            f7 = f10 + f5;
        }
        int iD2 = d(this.f15345e, this.f15344d, this.f15353m, 1);
        float fE2 = e(this.f15341a, this.f15342b, this.f15353m, 1);
        this.f15348h.setColor(iD2);
        canvas.drawCircle(f7, f6, fE2, this.f15348h);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int count = getCount();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i7 = this.f15341a;
        setMeasuredDimension(View.resolveSizeAndState(paddingLeft + (count * 2 * i7) + ((count - 1) * this.f15343c) + 1, i5, 0), View.resolveSizeAndState((Math.max(i7, this.f15342b) * 2) + getPaddingTop() + getPaddingBottom() + 1, i6, 0));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        int i5 = bVar.f15361a;
        this.f15351k = i5;
        this.f15352l = i5;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f15361a = this.f15351k;
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r12) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.guidepager.CirclePageIndicator.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCurrentItem(int i5) throws Resources.NotFoundException {
        ViewPager viewPager = this.f15349i;
        if (viewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        viewPager.setCurrentItem(i5);
        this.f15351k = i5;
        invalidate();
    }

    public void setDoubleCount(boolean z5) {
        this.f15360t = z5;
    }

    public void setFillColor(int i5) {
        this.f15348h.setColor(i5);
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.j jVar) {
        this.f15350j = jVar;
    }

    public void setPageColor(int i5) {
        this.f15346f.setColor(i5);
        invalidate();
    }

    public void setRadius(int i5) {
        this.f15341a = i5;
        invalidate();
    }

    public void setSpacing(int i5) {
        this.f15343c = i5;
        invalidate();
    }

    public void setStrokeColor(int i5) {
        this.f15347g.setColor(i5);
        invalidate();
    }

    public void setStrokeWidth(float f5) {
        this.f15347g.setStrokeWidth(f5);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f15349i;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.f15349i = viewPager;
        viewPager.setOnPageChangeListener(this);
        invalidate();
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        super(context, attributeSet, i5);
        this.f15357q = -1.0f;
        this.f15358r = -1;
        this.f15360t = false;
        if (isInEditMode()) {
            return;
        }
        g(context, attributeSet);
        this.f15356p = L.h(ViewConfiguration.get(context));
    }
}
