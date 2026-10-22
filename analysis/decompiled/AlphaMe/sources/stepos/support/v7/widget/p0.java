package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.appcompat.app.ViewOnClickListenerC0177c;
import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public abstract class p0 extends androidx.appcompat.widget.G implements K.f0 {

    /* renamed from: d, reason: collision with root package name */
    public static final Interpolator f15106d = M.a.b(0.18f, 0.367f, Property.DEFAULT_FLOAT_VALUE, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public boolean f15107a;

    /* renamed from: b, reason: collision with root package name */
    public j.m f15108b;

    /* renamed from: c, reason: collision with root package name */
    public Matrix f15109c;

    public p0(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15107a = true;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnClickListener(new ViewOnClickListenerC0177c(7, this));
        setBackgroundDrawable(null);
    }

    @Override // K.f0
    public final void c(View view) {
        if (this.f15107a) {
            WeakHashMap weakHashMap = K.S.f939a;
            setRotation(Property.DEFAULT_FLOAT_VALUE);
        }
    }

    @Override // K.f0
    public final void d(View view) {
    }

    public j.m e(boolean z4) {
        K.e0 e0VarA;
        j.m mVar = new j.m();
        if (z4) {
            WeakHashMap weakHashMap = K.S.f939a;
            setRotation(180.0f);
            e0VarA = K.S.a(this);
            View view = (View) e0VarA.f959a.get();
            if (view != null) {
                view.animate().rotation(360.0f);
            }
        } else {
            WeakHashMap weakHashMap2 = K.S.f939a;
            setRotation(Property.DEFAULT_FLOAT_VALUE);
            e0VarA = K.S.a(this);
            View view2 = (View) e0VarA.f959a.get();
            if (view2 != null) {
                view2.animate().rotation(180.0f);
            }
        }
        e0VarA.d(f15106d);
        e0VarA.c(350L);
        mVar.b(e0VarA);
        mVar.e(this);
        return mVar;
    }

    @Override // K.f0
    public final void onAnimationCancel() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        setPivotX(getMeasuredWidth() / 2);
        setPivotY(getMeasuredHeight() / 2);
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        return true;
    }

    public void setCollapsed(boolean z4) {
        if (this.f15107a != z4) {
            this.f15107a = z4;
            j.m mVar = this.f15108b;
            if (mVar != null) {
                mVar.a();
            }
            j.m mVarE = e(z4);
            this.f15108b = mVarE;
            mVarE.f();
        }
    }

    public void setOnTabCollapseButtonClickListener(o0 o0Var) {
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (getScaleType() == ImageView.ScaleType.MATRIX && this.f15109c == null) {
            this.f15109c = new Matrix();
        }
    }
}
