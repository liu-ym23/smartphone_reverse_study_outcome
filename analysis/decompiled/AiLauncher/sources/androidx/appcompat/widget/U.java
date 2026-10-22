package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import f.C4027a;
import s0.h;

/* loaded from: classes.dex */
public class U {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9133a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f9134b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f9135c;

    public U(Context context, TypedArray typedArray) {
        this.f9133a = context;
        this.f9134b = typedArray;
    }

    public static U t(Context context, int i10, int[] iArr) {
        return new U(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static U u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new U(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static U v(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new U(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f9134b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f9134b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f9134b.hasValue(i10) || (resourceId = this.f9134b.getResourceId(i10, 0)) == 0 || (colorStateListA = C4027a.a(this.f9133a, resourceId)) == null) ? this.f9134b.getColorStateList(i10) : colorStateListA;
    }

    public float d(int i10, float f10) {
        return this.f9134b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f9134b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f9134b.getDimensionPixelSize(i10, i11);
    }

    public Drawable g(int i10) {
        int resourceId;
        return (!this.f9134b.hasValue(i10) || (resourceId = this.f9134b.getResourceId(i10, 0)) == 0) ? this.f9134b.getDrawable(i10) : C4027a.b(this.f9133a, resourceId);
    }

    public Drawable h(int i10) {
        int resourceId;
        if (!this.f9134b.hasValue(i10) || (resourceId = this.f9134b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return C1295h.b().d(this.f9133a, resourceId, true);
    }

    public float i(int i10, float f10) {
        return this.f9134b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, h.f fVar) {
        int resourceId = this.f9134b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f9135c == null) {
            this.f9135c = new TypedValue();
        }
        return s0.h.i(this.f9133a, resourceId, this.f9135c, i11, fVar);
    }

    public int k(int i10, int i11) {
        return this.f9134b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f9134b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f9134b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f9134b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f9134b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f9134b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f9134b.getTextArray(i10);
    }

    public TypedArray r() {
        return this.f9134b;
    }

    public boolean s(int i10) {
        return this.f9134b.hasValue(i10);
    }

    public TypedValue w(int i10) {
        return this.f9134b.peekValue(i10);
    }

    public void x() {
        this.f9134b.recycle();
    }
}
