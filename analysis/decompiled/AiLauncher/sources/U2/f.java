package U2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* loaded from: classes2.dex */
public final class f extends b {

    /* renamed from: o, reason: collision with root package name */
    public int f6226o;

    /* renamed from: p, reason: collision with root package name */
    public int f6227p;

    /* renamed from: q, reason: collision with root package name */
    public int f6228q;

    /* renamed from: r, reason: collision with root package name */
    public int f6229r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6230s;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, CircularProgressIndicator.f21188q);
    }

    public f(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayI = r.i(context, attributeSet, R$styleable.CircularProgressIndicator, i10, i11, new int[0]);
        this.f6226o = typedArrayI.getInt(R$styleable.CircularProgressIndicator_indeterminateAnimationTypeCircular, 0);
        this.f6227p = Math.max(W2.c.c(context, typedArrayI, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f6170a * 2);
        this.f6228q = W2.c.c(context, typedArrayI, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f6229r = typedArrayI.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        this.f6230s = typedArrayI.getBoolean(R$styleable.CircularProgressIndicator_indeterminateTrackVisible, true);
        typedArrayI.recycle();
        h();
    }
}
