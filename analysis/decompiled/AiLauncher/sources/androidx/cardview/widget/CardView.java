package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;
import b0.C1437a;
import b0.InterfaceC1438b;
import b0.InterfaceC1439c;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f11686h = {R.attr.colorBackground};

    /* renamed from: i, reason: collision with root package name */
    public static final InterfaceC1439c f11687i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11688a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11689b;

    /* renamed from: c, reason: collision with root package name */
    public int f11690c;

    /* renamed from: d, reason: collision with root package name */
    public int f11691d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f11692e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f11693f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC1438b f11694g;

    public class a implements InterfaceC1438b {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f11695a;

        public a() {
        }

        @Override // b0.InterfaceC1438b
        public void a(int i10, int i11, int i12, int i13) {
            CardView.this.f11693f.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.f11692e;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }

        @Override // b0.InterfaceC1438b
        public void b(Drawable drawable) {
            this.f11695a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // b0.InterfaceC1438b
        public boolean c() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // b0.InterfaceC1438b
        public Drawable d() {
            return this.f11695a;
        }

        @Override // b0.InterfaceC1438b
        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // b0.InterfaceC1438b
        public View f() {
            return CardView.this;
        }
    }

    static {
        C1437a c1437a = new C1437a();
        f11687i = c1437a;
        c1437a.l();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public ColorStateList getCardBackgroundColor() {
        return f11687i.h(this.f11694g);
    }

    public float getCardElevation() {
        return f11687i.j(this.f11694g);
    }

    public int getContentPaddingBottom() {
        return this.f11692e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f11692e.left;
    }

    public int getContentPaddingRight() {
        return this.f11692e.right;
    }

    public int getContentPaddingTop() {
        return this.f11692e.top;
    }

    public float getMaxCardElevation() {
        return f11687i.g(this.f11694g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f11689b;
    }

    public float getRadius() {
        return f11687i.i(this.f11694g);
    }

    public boolean getUseCompatPadding() {
        return this.f11688a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (f11687i instanceof C1437a) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.e(this.f11694g)), View.MeasureSpec.getSize(i10)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.m(this.f11694g)), View.MeasureSpec.getSize(i11)), mode2);
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f11687i.a(this.f11694g, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        f11687i.f(this.f11694g, f10);
    }

    public void setMaxCardElevation(float f10) {
        f11687i.n(this.f11694g, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.f11691d = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.f11690c = i10;
        super.setMinimumWidth(i10);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f11689b) {
            this.f11689b = z10;
            f11687i.k(this.f11694g);
        }
    }

    public void setRadius(float f10) {
        f11687i.d(this.f11694g, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f11688a != z10) {
            this.f11688a = z10;
            f11687i.c(this.f11694g);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i10) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i10);
        Rect rect = new Rect();
        this.f11692e = rect;
        this.f11693f = new Rect();
        a aVar = new a();
        this.f11694g = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i10, R$style.CardView);
        int i11 = R$styleable.CardView_cardBackgroundColor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i11);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f11686h);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(R$color.cardview_light_background) : getResources().getColor(R$color.cardview_dark_background));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f11688a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.f11689b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f11690c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f11691d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f11687i.b(aVar, context, colorStateList, dimension, dimension2, f10);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f11687i.a(this.f11694g, colorStateList);
    }
}
