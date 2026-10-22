package stepos.support.v7.widget;

import K.z0;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;
import stepos.support.v7.app.InterfaceC0859d;

/* loaded from: classes2.dex */
public class StepOSCollapsingToolbarLayout extends AbstractC0904y {

    /* renamed from: A, reason: collision with root package name */
    public ActionBarContextView f14902A;

    /* renamed from: B, reason: collision with root package name */
    public TextView f14903B;

    /* renamed from: C, reason: collision with root package name */
    public A f14904C;

    /* renamed from: D, reason: collision with root package name */
    public float f14905D;

    /* renamed from: E, reason: collision with root package name */
    public final U f14906E;

    /* renamed from: x, reason: collision with root package name */
    public C0905z f14907x;

    /* renamed from: y, reason: collision with root package name */
    public z0 f14908y;

    /* renamed from: z, reason: collision with root package name */
    public C0884d f14909z;

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14906E = new U(this);
    }

    @Override // stepos.support.v7.widget.AbstractC0904y
    public final int a() {
        z0 z0Var = this.f14908y;
        if (z0Var != null) {
            return z0Var.d();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchConfigurationChanged(Configuration configuration) {
        super.dispatchConfigurationChanged(configuration);
    }

    @Override // stepos.support.v7.widget.AbstractC0904y, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        g(this.f14905D);
    }

    public final void g(float f4) {
        TextView textView = this.f14903B;
        if (textView == null) {
            return;
        }
        float f5 = Property.DEFAULT_FLOAT_VALUE;
        textView.setAlpha(f4 < 0.5f ? 0.0f : (f4 * 2.0f) - 1.0f);
        float f6 = 1.0f - f4;
        if (f6 > 0.5f) {
            f5 = (f6 * 2.0f) - 1.0f;
        }
        this.f15238k.f15164D.setAlpha((int) (f5 * 255.0f));
    }

    public int getExpandRange() {
        z0 z0Var = this.f14908y;
        int iD = z0Var != null ? z0Var.d() : 0;
        int height = getHeight();
        WeakHashMap weakHashMap = K.S.f939a;
        return (height - getMinimumHeight()) - iD;
    }

    @Override // stepos.support.v7.widget.AbstractC0904y, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof com.google.android.material.appbar.h) {
            if (this.f14909z == null) {
                this.f14909z = new C0884d(this, 2);
            }
            ((com.google.android.material.appbar.h) parent).c(this.f14909z);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f14902A = (ActionBarContextView) findViewById(R.id.action_context_bar);
    }

    @Override // stepos.support.v7.widget.AbstractC0904y, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int iA = a();
        if (iA > 0) {
            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iA, 1073741824));
        }
    }

    public void setOnOffsetChangedListener(InterfaceC0859d interfaceC0859d) {
    }

    public void setTabLayout(Q q4) {
    }

    public void setTitleTextColor(@ColorInt int i4) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i4);
        C0902w c0902w = this.f15238k;
        if (c0902w.f15186l != colorStateListValueOf) {
            c0902w.f15186l = colorStateListValueOf;
            c0902w.j();
        }
        if (c0902w.f15185k != colorStateListValueOf) {
            c0902w.f15185k = colorStateListValueOf;
            c0902w.j();
        }
    }
}
