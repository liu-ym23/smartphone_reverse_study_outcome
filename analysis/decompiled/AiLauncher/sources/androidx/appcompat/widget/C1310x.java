package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.appcompat.widget.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1310x {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f9262l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> f9263m = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f9271h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f9272i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f9273j;

    /* renamed from: a, reason: collision with root package name */
    public int f9264a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9265b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f9266c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f9267d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f9268e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f9269f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f9270g = false;

    /* renamed from: k, reason: collision with root package name */
    public final d f9274k = new c();

    /* renamed from: androidx.appcompat.widget.x$a */
    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                dVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* renamed from: androidx.appcompat.widget.x$b */
    public static class b extends d {
    }

    /* renamed from: androidx.appcompat.widget.x$c */
    public static class c extends b {
        @Override // androidx.appcompat.widget.C1310x.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.C1310x.d
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* renamed from: androidx.appcompat.widget.x$d */
    public static class d {
        public void a(StaticLayout.Builder builder, TextView textView) {
            throw null;
        }

        public boolean b(TextView textView) {
            throw null;
        }
    }

    public C1310x(TextView textView) {
        this.f9272i = textView;
        this.f9273j = textView.getContext();
    }

    public static Method k(String str) throws SecurityException {
        try {
            Method declaredMethod = f9263m.get(str);
            if (declaredMethod != null || (declaredMethod = TextView.class.getDeclaredMethod(str, null)) == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            f9263m.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static <T> T m(Object obj, String str, T t10) {
        try {
            return (T) k(str).invoke(obj, null);
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e10);
            return t10;
        }
    }

    public void a() {
        if (n()) {
            if (this.f9265b) {
                if (this.f9272i.getMeasuredHeight() <= 0 || this.f9272i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f9274k.b(this.f9272i) ? 1048576 : (this.f9272i.getMeasuredWidth() - this.f9272i.getTotalPaddingLeft()) - this.f9272i.getTotalPaddingRight();
                int height = (this.f9272i.getHeight() - this.f9272i.getCompoundPaddingBottom()) - this.f9272i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f9262l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f9272i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f9265b = true;
        }
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i10 : iArr) {
                if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i11 = 0; i11 < size; i11++) {
                    iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public final void c() {
        this.f9264a = 0;
        this.f9267d = -1.0f;
        this.f9268e = -1.0f;
        this.f9266c = -1.0f;
        this.f9269f = new int[0];
        this.f9265b = false;
    }

    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        return a.a(charSequence, alignment, i10, i11, this.f9272i, this.f9271h, this.f9274k);
    }

    public final int e(RectF rectF) {
        int length = this.f9269f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i10 = 1;
        int i11 = length - 1;
        int i12 = 0;
        while (i10 <= i11) {
            int i13 = (i10 + i11) / 2;
            if (x(this.f9269f[i13], rectF)) {
                int i14 = i13 + 1;
                i12 = i10;
                i10 = i14;
            } else {
                i12 = i13 - 1;
                i11 = i12;
            }
        }
        return this.f9269f[i12];
    }

    public int f() {
        return Math.round(this.f9268e);
    }

    public int g() {
        return Math.round(this.f9267d);
    }

    public int h() {
        return Math.round(this.f9266c);
    }

    public int[] i() {
        return this.f9269f;
    }

    public int j() {
        return this.f9264a;
    }

    public void l(int i10) {
        TextPaint textPaint = this.f9271h;
        if (textPaint == null) {
            this.f9271h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f9271h.set(this.f9272i.getPaint());
        this.f9271h.setTextSize(i10);
    }

    public boolean n() {
        return y() && this.f9264a != 0;
    }

    public void o(AttributeSet attributeSet, int i10) {
        int resourceId;
        Context context = this.f9273j;
        int[] iArr = R$styleable.AppCompatTextView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.f9272i;
        androidx.core.view.N.g0(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        int i11 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f9264a = typedArrayObtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i12) ? typedArrayObtainStyledAttributes.getDimension(i12, -1.0f) : -1.0f;
        int i13 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i13) ? typedArrayObtainStyledAttributes.getDimension(i13, -1.0f) : -1.0f;
        int i14 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i14) ? typedArrayObtainStyledAttributes.getDimension(i14, -1.0f) : -1.0f;
        int i15 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (typedArrayObtainStyledAttributes.hasValue(i15) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f9264a = 0;
            return;
        }
        if (this.f9264a == 1) {
            if (!this.f9270g) {
                DisplayMetrics displayMetrics = this.f9273j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    public void p(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (y()) {
            DisplayMetrics displayMetrics = this.f9273j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    public void q(int[] iArr, int i10) throws IllegalArgumentException {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i10 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f9273j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArrCopyOf[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.f9269f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f9270g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    public void r(int i10) {
        if (y()) {
            if (i10 == 0) {
                c();
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            DisplayMetrics displayMetrics = this.f9273j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public final void s(float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f10 != this.f9272i.getPaint().getTextSize()) {
            this.f9272i.getPaint().setTextSize(f10);
            boolean zIsInLayout = this.f9272i.isInLayout();
            if (this.f9272i.getLayout() != null) {
                this.f9265b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f9272i, null);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (zIsInLayout) {
                    this.f9272i.forceLayout();
                } else {
                    this.f9272i.requestLayout();
                }
                this.f9272i.invalidate();
            }
        }
    }

    public void t(int i10, float f10) {
        Context context = this.f9273j;
        s(TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean u() {
        if (y() && this.f9264a == 1) {
            if (!this.f9270g || this.f9269f.length == 0) {
                int iFloor = ((int) Math.floor((this.f9268e - this.f9267d) / this.f9266c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i10 = 0; i10 < iFloor; i10++) {
                    iArr[i10] = Math.round(this.f9267d + (i10 * this.f9266c));
                }
                this.f9269f = b(iArr);
            }
            this.f9265b = true;
        } else {
            this.f9265b = false;
        }
        return this.f9265b;
    }

    public final void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f9269f = b(iArr);
            w();
        }
    }

    public final boolean w() {
        boolean z10 = this.f9269f.length > 0;
        this.f9270g = z10;
        if (z10) {
            this.f9264a = 1;
            this.f9267d = r0[0];
            this.f9268e = r0[r1 - 1];
            this.f9266c = -1.0f;
        }
        return z10;
    }

    public final boolean x(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f9272i.getText();
        TransformationMethod transformationMethod = this.f9272i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f9272i)) != null) {
            text = transformation;
        }
        int maxLines = this.f9272i.getMaxLines();
        l(i10);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f9272i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutD.getLineCount() <= maxLines && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    public final boolean y() {
        return !(this.f9272i instanceof AppCompatEditText);
    }

    public final void z(float f10, float f11, float f12) throws IllegalArgumentException {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.f9264a = 1;
        this.f9267d = f10;
        this.f9268e = f11;
        this.f9266c = f12;
        this.f9270g = false;
    }
}
