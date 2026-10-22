package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f973c;

    public b0(Context r10, TypedArray r11) {
        this.f971a = r10;
        this.f972b = r11;
    }

    public static b0 t(Context r10, int r11, int[] r12) {
        return new b0(r10, r10.obtainStyledAttributes(r11, r12));
    }

    public static b0 u(Context r10, AttributeSet r11, int[] r12) {
        return new b0(r10, r10.obtainStyledAttributes(r11, r12));
    }

    public static b0 v(Context r10, AttributeSet r11, int[] r12, int r13, int r14) {
        return new b0(r10, r10.obtainStyledAttributes(r11, r12, r13, r14));
    }

    public boolean a(int r10, boolean r11) {
        return this.f972b.getBoolean(r10, r11);
    }

    public int b(int r10, int r11) {
        return this.f972b.getColor(r10, r11);
    }

    public ColorStateList c(int r10) {
        if (this.f972b.hasValue(r10) == false) goto L10;
        int r11 = this.f972b.getResourceId(r10, 0);
        if (r11 == 0) goto L10;
        ColorStateList r12 = c.a.a(this.f971a, r11);
        if (r12 == null) goto L10;
        return r12;
    L10:
        return this.f972b.getColorStateList(r10);
    }

    public float d(int r10, float r11) {
        return this.f972b.getDimension(r10, r11);
    }

    public int e(int r10, int r11) {
        return this.f972b.getDimensionPixelOffset(r10, r11);
    }

    public int f(int r10, int r11) {
        return this.f972b.getDimensionPixelSize(r10, r11);
    }

    public Drawable g(int r10) {
        if (this.f972b.hasValue(r10) == false) goto L9;
        int r11 = this.f972b.getResourceId(r10, 0);
        if (r11 == 0) goto L9;
        return c.a.b(this.f971a, r11);
    L9:
        return this.f972b.getDrawable(r10);
    }

    public Drawable h(int r10) {
        if (this.f972b.hasValue(r10) == false) goto L8;
        int r11 = this.f972b.getResourceId(r10, 0);
        if (r11 != 0) goto L7;
        return null;
    L7:
        return f.b().d(this.f971a, r11, true);
    L8:
        return null;
    }

    public float i(int r10, float r11) {
        return this.f972b.getFloat(r10, r11);
    }

    public Typeface j(int r10, int r11, androidx.core.content.res.a.e r12) {
        int r13 = this.f972b.getResourceId(r10, 0);
        if (r13 != 0) goto L7;
        return null;
    L7:
        if (this.f973c != null) goto L10;
        this.f973c = new TypedValue();
    L10:
        return androidx.core.content.res.a.i(this.f971a, r13, this.f973c, r11, r12);
    }

    public int k(int r10, int r11) {
        return this.f972b.getInt(r10, r11);
    }

    public int l(int r10, int r11) {
        return this.f972b.getInteger(r10, r11);
    }

    public int m(int r10, int r11) {
        return this.f972b.getLayoutDimension(r10, r11);
    }

    public int n(int r10, int r11) {
        return this.f972b.getResourceId(r10, r11);
    }

    public String o(int r10) {
        return this.f972b.getString(r10);
    }

    public CharSequence p(int r10) {
        return this.f972b.getText(r10);
    }

    public CharSequence[] q(int r10) {
        return this.f972b.getTextArray(r10);
    }

    public TypedArray r() {
        return this.f972b;
    }

    public boolean s(int r10) {
        return this.f972b.hasValue(r10);
    }

    public void w() {
        this.f972b.recycle();
    }
}
