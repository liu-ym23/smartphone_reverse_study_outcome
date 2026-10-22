package U2;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public int f6170a;

    /* renamed from: b, reason: collision with root package name */
    public int f6171b;

    /* renamed from: c, reason: collision with root package name */
    public float f6172c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6173d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f6174e = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public int f6175f;

    /* renamed from: g, reason: collision with root package name */
    public int f6176g;

    /* renamed from: h, reason: collision with root package name */
    public int f6177h;

    /* renamed from: i, reason: collision with root package name */
    public int f6178i;

    /* renamed from: j, reason: collision with root package name */
    public int f6179j;

    /* renamed from: k, reason: collision with root package name */
    public int f6180k;

    /* renamed from: l, reason: collision with root package name */
    public int f6181l;

    /* renamed from: m, reason: collision with root package name */
    public int f6182m;

    /* renamed from: n, reason: collision with root package name */
    public float f6183n;

    public b(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        TypedArray typedArrayI = r.i(context, attributeSet, R$styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.f6170a = W2.c.c(context, typedArrayI, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        TypedValue typedValuePeekValue = typedArrayI.peekValue(R$styleable.BaseProgressIndicator_trackCornerRadius);
        if (typedValuePeekValue != null) {
            int i12 = typedValuePeekValue.type;
            if (i12 == 5) {
                this.f6171b = Math.min(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArrayI.getResources().getDisplayMetrics()), this.f6170a / 2);
                this.f6173d = false;
            } else if (i12 == 6) {
                this.f6172c = Math.min(typedValuePeekValue.getFraction(1.0f, 1.0f), 0.5f);
                this.f6173d = true;
            }
        }
        this.f6176g = typedArrayI.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f6177h = typedArrayI.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.f6178i = typedArrayI.getDimensionPixelSize(R$styleable.BaseProgressIndicator_indicatorTrackGapSize, 0);
        int iAbs = Math.abs(typedArrayI.getDimensionPixelSize(R$styleable.BaseProgressIndicator_wavelength, 0));
        this.f6179j = Math.abs(typedArrayI.getDimensionPixelSize(R$styleable.BaseProgressIndicator_wavelengthDeterminate, iAbs));
        this.f6180k = Math.abs(typedArrayI.getDimensionPixelSize(R$styleable.BaseProgressIndicator_wavelengthIndeterminate, iAbs));
        this.f6181l = Math.abs(typedArrayI.getDimensionPixelSize(R$styleable.BaseProgressIndicator_waveAmplitude, 0));
        this.f6182m = typedArrayI.getDimensionPixelSize(R$styleable.BaseProgressIndicator_waveSpeed, 0);
        this.f6183n = typedArrayI.getFloat(R$styleable.BaseProgressIndicator_indeterminateAnimatorDurationScale, 1.0f);
        e(context, typedArrayI);
        f(context, typedArrayI);
        typedArrayI.recycle();
    }

    public int a() {
        return this.f6173d ? (int) (this.f6170a * this.f6172c) : this.f6171b;
    }

    public boolean b(boolean z10) {
        if (this.f6181l <= 0) {
            return false;
        }
        if (z10 || this.f6180k <= 0) {
            return z10 && this.f6179j > 0;
        }
        return true;
    }

    public boolean c() {
        return this.f6177h != 0;
    }

    public boolean d() {
        return this.f6176g != 0;
    }

    public final void e(Context context, TypedArray typedArray) throws Resources.NotFoundException {
        int i10 = R$styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i10)) {
            this.f6174e = new int[]{M2.a.b(context, R$attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(i10).type != 1) {
            this.f6174e = new int[]{typedArray.getColor(i10, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
        this.f6174e = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    public final void f(Context context, TypedArray typedArray) {
        int i10 = R$styleable.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i10)) {
            this.f6175f = typedArray.getColor(i10, -1);
            return;
        }
        this.f6175f = this.f6174e[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f10 = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.f6175f = M2.a.a(this.f6175f, (int) (f10 * 255.0f));
    }

    public boolean g() {
        return this.f6173d && this.f6172c == 0.5f;
    }

    public void h() {
        if (this.f6178i < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
