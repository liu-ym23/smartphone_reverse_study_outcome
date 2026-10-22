package androidx.cardview.widget;

import B0.m;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.stepos.alphame.utils.Property;
import o.AbstractC0784a;
import p.C0810a;
import y1.f;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f3220f = {R.attr.colorBackground};

    /* renamed from: g, reason: collision with root package name */
    public static final f f3221g = new f();

    /* renamed from: a, reason: collision with root package name */
    public boolean f3222a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3223b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f3224c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f3225d;

    /* renamed from: e, reason: collision with root package name */
    public final m f3226e;

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, com.stepos.alphame.R.attr.cardViewStyle);
        Rect rect = new Rect();
        this.f3224c = rect;
        this.f3225d = new Rect();
        m mVar = new m(this);
        this.f3226e = mVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0784a.f13672a, com.stepos.alphame.R.attr.cardViewStyle, com.stepos.alphame.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f3220f);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(com.stepos.alphame.R.color.cardview_light_background) : getResources().getColor(com.stepos.alphame.R.color.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, Property.DEFAULT_FLOAT_VALUE);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, Property.DEFAULT_FLOAT_VALUE);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, Property.DEFAULT_FLOAT_VALUE);
        this.f3222a = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f3223b = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        f fVar = f3221g;
        C0810a c0810a = new C0810a(dimension, colorStateListValueOf);
        mVar.f155b = c0810a;
        ((CardView) mVar.f156c).setBackgroundDrawable(c0810a);
        CardView cardView = (CardView) mVar.f156c;
        cardView.setClipToOutline(true);
        cardView.setElevation(dimension2);
        fVar.o(mVar, dimension3);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f.g(this.f3226e).f13835h;
    }

    public float getCardElevation() {
        return ((CardView) this.f3226e.f156c).getElevation();
    }

    @Px
    public int getContentPaddingBottom() {
        return this.f3224c.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.f3224c.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.f3224c.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.f3224c.top;
    }

    public float getMaxCardElevation() {
        return f.g(this.f3226e).f13832e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f3223b;
    }

    public float getRadius() {
        return f.g(this.f3226e).f13828a;
    }

    public boolean getUseCompatPadding() {
        return this.f3222a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        C0810a c0810aG = f.g(this.f3226e);
        if (colorStateList == null) {
            c0810aG.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        c0810aG.f13835h = colorStateList;
        c0810aG.f13829b.setColor(colorStateList.getColorForState(c0810aG.getState(), c0810aG.f13835h.getDefaultColor()));
        c0810aG.invalidateSelf();
    }

    public void setCardElevation(float f4) {
        ((CardView) this.f3226e.f156c).setElevation(f4);
    }

    public void setMaxCardElevation(float f4) {
        f3221g.o(this.f3226e, f4);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i4) {
        super.setMinimumHeight(i4);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i4) {
        super.setMinimumWidth(i4);
    }

    @Override // android.view.View
    public final void setPadding(int i4, int i5, int i6, int i7) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i4, int i5, int i6, int i7) {
    }

    public void setPreventCornerOverlap(boolean z4) {
        if (z4 != this.f3223b) {
            this.f3223b = z4;
            f fVar = f3221g;
            m mVar = this.f3226e;
            fVar.o(mVar, f.g(mVar).f13832e);
        }
    }

    public void setRadius(float f4) {
        C0810a c0810aG = f.g(this.f3226e);
        if (f4 == c0810aG.f13828a) {
            return;
        }
        c0810aG.f13828a = f4;
        c0810aG.b(null);
        c0810aG.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z4) {
        if (this.f3222a != z4) {
            this.f3222a = z4;
            f fVar = f3221g;
            m mVar = this.f3226e;
            fVar.o(mVar, f.g(mVar).f13832e);
        }
    }

    public void setCardBackgroundColor(@ColorInt int i4) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i4);
        C0810a c0810aG = f.g(this.f3226e);
        if (colorStateListValueOf == null) {
            c0810aG.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        c0810aG.f13835h = colorStateListValueOf;
        c0810aG.f13829b.setColor(colorStateListValueOf.getColorForState(c0810aG.getState(), c0810aG.f13835h.getDefaultColor()));
        c0810aG.invalidateSelf();
    }
}
