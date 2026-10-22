package androidx.appcompat.widget;

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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class E {

    /* renamed from: l, reason: collision with root package name */
    private static final RectF f8123l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f8124m = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f8132h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f8133i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f8134j;

    /* renamed from: a, reason: collision with root package name */
    private int f8125a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8126b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f8127c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f8128d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f8129e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f8130f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f8131g = false;

    /* renamed from: k, reason: collision with root package name */
    private final d f8135k = new c();

    private static final class a {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i5, int i6, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i5);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i6 == -1) {
                i6 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i6);
            try {
                dVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    private static class b extends d {
        b() {
        }
    }

    private static class c extends b {
        c() {
        }

        @Override // androidx.appcompat.widget.E.d
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.E.d
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class d {
        d() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
            throw null;
        }

        boolean b(TextView textView) {
            throw null;
        }
    }

    E(TextView textView) {
        this.f8133i = textView;
        this.f8134j = textView.getContext();
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i5 : iArr) {
                if (i5 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i5)) < 0) {
                    arrayList.add(Integer.valueOf(i5));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i6 = 0; i6 < size; i6++) {
                    iArr2[i6] = ((Integer) arrayList.get(i6)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    private void c() {
        this.f8125a = 0;
        this.f8128d = -1.0f;
        this.f8129e = -1.0f;
        this.f8127c = -1.0f;
        this.f8130f = new int[0];
        this.f8126b = false;
    }

    private int e(RectF rectF) {
        int length = this.f8130f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i5 = 1;
        int i6 = length - 1;
        int i7 = 0;
        while (i5 <= i6) {
            int i8 = (i5 + i6) / 2;
            if (x(this.f8130f[i8], rectF)) {
                int i9 = i8 + 1;
                i7 = i5;
                i5 = i9;
            } else {
                i7 = i8 - 1;
                i6 = i7;
            }
        }
        return this.f8130f[i7];
    }

    private static Method k(String str) throws SecurityException {
        try {
            Method declaredMethod = f8124m.get(str);
            if (declaredMethod != null || (declaredMethod = TextView.class.getDeclaredMethod(str, null)) == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            f8124m.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e6) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e6);
            return null;
        }
    }

    static <T> T m(Object obj, String str, T t5) {
        try {
            return (T) k(str).invoke(obj, null);
        } catch (Exception e6) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e6);
            return t5;
        }
    }

    private void s(float f5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f5 != this.f8133i.getPaint().getTextSize()) {
            this.f8133i.getPaint().setTextSize(f5);
            boolean zIsInLayout = this.f8133i.isInLayout();
            if (this.f8133i.getLayout() != null) {
                this.f8126b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f8133i, null);
                    }
                } catch (Exception e6) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e6);
                }
                if (zIsInLayout) {
                    this.f8133i.forceLayout();
                } else {
                    this.f8133i.requestLayout();
                }
                this.f8133i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f8125a == 1) {
            if (!this.f8131g || this.f8130f.length == 0) {
                int iFloor = ((int) Math.floor((this.f8129e - this.f8128d) / this.f8127c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i5 = 0; i5 < iFloor; i5++) {
                    iArr[i5] = Math.round(this.f8128d + (i5 * this.f8127c));
                }
                this.f8130f = b(iArr);
            }
            this.f8126b = true;
        } else {
            this.f8126b = false;
        }
        return this.f8126b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = typedArray.getDimensionPixelSize(i5, -1);
            }
            this.f8130f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z5 = this.f8130f.length > 0;
        this.f8131g = z5;
        if (z5) {
            this.f8125a = 1;
            this.f8128d = r0[0];
            this.f8129e = r0[r1 - 1];
            this.f8127c = -1.0f;
        }
        return z5;
    }

    private boolean x(int i5, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f8133i.getText();
        TransformationMethod transformationMethod = this.f8133i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f8133i)) != null) {
            text = transformation;
        }
        int maxLines = this.f8133i.getMaxLines();
        l(i5);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f8133i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutD.getLineCount() <= maxLines && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f8133i instanceof C0442l);
    }

    private void z(float f5, float f6, float f7) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f5 + "px) is less or equal to (0px)");
        }
        if (f6 <= f5) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f6 + "px) is less or equal to minimum auto-size text size (" + f5 + "px)");
        }
        if (f7 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f7 + "px) is less or equal to (0px)");
        }
        this.f8125a = 1;
        this.f8128d = f5;
        this.f8129e = f6;
        this.f8127c = f7;
        this.f8131g = false;
    }

    void a() {
        if (n()) {
            if (this.f8126b) {
                if (this.f8133i.getMeasuredHeight() <= 0 || this.f8133i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f8135k.b(this.f8133i) ? 1048576 : (this.f8133i.getMeasuredWidth() - this.f8133i.getTotalPaddingLeft()) - this.f8133i.getTotalPaddingRight();
                int height = (this.f8133i.getHeight() - this.f8133i.getCompoundPaddingBottom()) - this.f8133i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f8123l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f8133i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f8126b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i5, int i6) {
        return a.a(charSequence, alignment, i5, i6, this.f8133i, this.f8132h, this.f8135k);
    }

    int f() {
        return Math.round(this.f8129e);
    }

    int g() {
        return Math.round(this.f8128d);
    }

    int h() {
        return Math.round(this.f8127c);
    }

    int[] i() {
        return this.f8130f;
    }

    int j() {
        return this.f8125a;
    }

    void l(int i5) {
        TextPaint textPaint = this.f8132h;
        if (textPaint == null) {
            this.f8132h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f8132h.set(this.f8133i.getPaint());
        this.f8132h.setTextSize(i5);
    }

    boolean n() {
        return y() && this.f8125a != 0;
    }

    void o(AttributeSet attributeSet, int i5) {
        int resourceId;
        Context context = this.f8134j;
        int[] iArr = g.j.f17125g0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        TextView textView = this.f8133i;
        androidx.core.view.H.i0(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i5, 0);
        int i6 = g.j.f17150l0;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            this.f8125a = typedArrayObtainStyledAttributes.getInt(i6, 0);
        }
        int i7 = g.j.f17145k0;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i7) ? typedArrayObtainStyledAttributes.getDimension(i7, -1.0f) : -1.0f;
        int i8 = g.j.f17135i0;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i8) ? typedArrayObtainStyledAttributes.getDimension(i8, -1.0f) : -1.0f;
        int i9 = g.j.f17130h0;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i9) ? typedArrayObtainStyledAttributes.getDimension(i9, -1.0f) : -1.0f;
        int i10 = g.j.f17140j0;
        if (typedArrayObtainStyledAttributes.hasValue(i10) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i10, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f8125a = 0;
            return;
        }
        if (this.f8125a == 1) {
            if (!this.f8131g) {
                DisplayMetrics displayMetrics = this.f8134j.getResources().getDisplayMetrics();
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

    void p(int i5, int i6, int i7, int i8) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f8134j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i8, i5, displayMetrics), TypedValue.applyDimension(i8, i6, displayMetrics), TypedValue.applyDimension(i8, i7, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    void q(int[] iArr, int i5) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i5 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f8134j.getResources().getDisplayMetrics();
                    for (int i6 = 0; i6 < length; i6++) {
                        iArrCopyOf[i6] = Math.round(TypedValue.applyDimension(i5, iArr[i6], displayMetrics));
                    }
                }
                this.f8130f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f8131g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    void r(int i5) {
        if (y()) {
            if (i5 == 0) {
                c();
                return;
            }
            if (i5 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i5);
            }
            DisplayMetrics displayMetrics = this.f8134j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    void t(int i5, float f5) {
        Context context = this.f8134j;
        s(TypedValue.applyDimension(i5, f5, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
