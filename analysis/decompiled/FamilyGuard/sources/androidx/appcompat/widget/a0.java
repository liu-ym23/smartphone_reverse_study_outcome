package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h;
import h.C0744a;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8478a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f8479b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f8480c;

    private a0(Context context, TypedArray typedArray) {
        this.f8478a = context;
        this.f8479b = typedArray;
    }

    public static a0 t(Context context, int i5, int[] iArr) {
        return new a0(context, context.obtainStyledAttributes(i5, iArr));
    }

    public static a0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new a0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static a0 v(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6) {
        return new a0(context, context.obtainStyledAttributes(attributeSet, iArr, i5, i6));
    }

    public boolean a(int i5, boolean z5) {
        return this.f8479b.getBoolean(i5, z5);
    }

    public int b(int i5, int i6) {
        return this.f8479b.getColor(i5, i6);
    }

    public ColorStateList c(int i5) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f8479b.hasValue(i5) || (resourceId = this.f8479b.getResourceId(i5, 0)) == 0 || (colorStateListA = C0744a.a(this.f8478a, resourceId)) == null) ? this.f8479b.getColorStateList(i5) : colorStateListA;
    }

    public float d(int i5, float f5) {
        return this.f8479b.getDimension(i5, f5);
    }

    public int e(int i5, int i6) {
        return this.f8479b.getDimensionPixelOffset(i5, i6);
    }

    public int f(int i5, int i6) {
        return this.f8479b.getDimensionPixelSize(i5, i6);
    }

    public Drawable g(int i5) {
        int resourceId;
        return (!this.f8479b.hasValue(i5) || (resourceId = this.f8479b.getResourceId(i5, 0)) == 0) ? this.f8479b.getDrawable(i5) : C0744a.b(this.f8478a, resourceId);
    }

    public Drawable h(int i5) {
        int resourceId;
        if (!this.f8479b.hasValue(i5) || (resourceId = this.f8479b.getResourceId(i5, 0)) == 0) {
            return null;
        }
        return C0441k.b().d(this.f8478a, resourceId, true);
    }

    public float i(int i5, float f5) {
        return this.f8479b.getFloat(i5, f5);
    }

    public Typeface j(int i5, int i6, h.e eVar) {
        int resourceId = this.f8479b.getResourceId(i5, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f8480c == null) {
            this.f8480c = new TypedValue();
        }
        return androidx.core.content.res.h.i(this.f8478a, resourceId, this.f8480c, i6, eVar);
    }

    public int k(int i5, int i6) {
        return this.f8479b.getInt(i5, i6);
    }

    public int l(int i5, int i6) {
        return this.f8479b.getInteger(i5, i6);
    }

    public int m(int i5, int i6) {
        return this.f8479b.getLayoutDimension(i5, i6);
    }

    public int n(int i5, int i6) {
        return this.f8479b.getResourceId(i5, i6);
    }

    public String o(int i5) {
        return this.f8479b.getString(i5);
    }

    public CharSequence p(int i5) {
        return this.f8479b.getText(i5);
    }

    public CharSequence[] q(int i5) {
        return this.f8479b.getTextArray(i5);
    }

    public TypedArray r() {
        return this.f8479b;
    }

    public boolean s(int i5) {
        return this.f8479b.hasValue(i5);
    }

    public TypedValue w(int i5) {
        return this.f8479b.peekValue(i5);
    }

    public void x() {
        this.f8479b.recycle();
    }
}
