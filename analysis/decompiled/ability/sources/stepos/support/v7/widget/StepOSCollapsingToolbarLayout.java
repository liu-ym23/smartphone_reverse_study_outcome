package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.ability.R;
import stepos.support.v7.app.InterfaceC1954c;

/* loaded from: classes4.dex */
public class StepOSCollapsingToolbarLayout extends D {

    /* renamed from: A, reason: collision with root package name */
    public ActionBarContextView f6505A;

    /* renamed from: B, reason: collision with root package name */
    public TextView f6506B;

    /* renamed from: C, reason: collision with root package name */
    public F f6507C;

    /* renamed from: D, reason: collision with root package name */
    public float f6508D;
    public final C1980b0 E;

    /* renamed from: x, reason: collision with root package name */
    public E f6509x;
    public WindowInsetsCompat y;

    /* renamed from: z, reason: collision with root package name */
    public C1987f f6510z;

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = new C1980b0(this);
    }

    @Override // stepos.support.v7.widget.D
    public final int a() {
        WindowInsetsCompat windowInsetsCompat = this.y;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    @Override // stepos.support.v7.widget.D, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        g(this.f6508D);
    }

    public final void g(float f) {
        TextView textView = this.f6506B;
        if (textView == null) {
            return;
        }
        textView.setAlpha(f < 0.5f ? 0.0f : (f * 2.0f) - 1.0f);
        float f7 = 1.0f - f;
        this.k.f6383D.setAlpha((int) ((f7 > 0.5f ? (f7 * 2.0f) - 1.0f : 0.0f) * 255.0f));
    }

    public int getExpandRange() {
        WindowInsetsCompat windowInsetsCompat = this.y;
        return (getHeight() - ViewCompat.getMinimumHeight(this)) - (windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0);
    }

    @Override // stepos.support.v7.widget.D, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.f6510z == null) {
                this.f6510z = new C1987f(this, 2);
            }
            ((AppBarLayout) parent).c(this.f6510z);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f6505A = (ActionBarContextView) findViewById(R.id.action_context_bar);
    }

    @Override // stepos.support.v7.widget.D, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        int iA = a();
        if (iA > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iA, BasicMeasure.EXACTLY));
        }
    }

    public void setOnOffsetChangedListener(InterfaceC1954c interfaceC1954c) {
    }

    public void setTabLayout(Y y) {
    }

    public void setTitleTextColor(@ColorInt int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        A a3 = this.k;
        if (a3.l != colorStateListValueOf) {
            a3.l = colorStateListValueOf;
            a3.j();
        }
        if (a3.k != colorStateListValueOf) {
            a3.k = colorStateListValueOf;
            a3.j();
        }
    }
}
