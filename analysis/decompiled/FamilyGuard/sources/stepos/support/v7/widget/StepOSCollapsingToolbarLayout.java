package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.H;
import androidx.core.view.Y;
import com.google.android.material.appbar.AppBarLayout;
import stepos.support.v7.app.a;
import stepos.support.v7.widget.g;
import stepos.support.v7.widget.i;

/* loaded from: classes.dex */
public class StepOSCollapsingToolbarLayout extends g {

    /* renamed from: A, reason: collision with root package name */
    private ActionBarContextView f21668A;

    /* renamed from: B, reason: collision with root package name */
    private float f21669B;

    /* renamed from: C, reason: collision with root package name */
    protected v f21670C;

    /* renamed from: D, reason: collision with root package name */
    private TextView f21671D;

    /* renamed from: E, reason: collision with root package name */
    private i f21672E;

    /* renamed from: F, reason: collision with root package name */
    private float f21673F;

    /* renamed from: G, reason: collision with root package name */
    private i.a f21674G;

    /* renamed from: x, reason: collision with root package name */
    private h f21675x;

    /* renamed from: y, reason: collision with root package name */
    protected Y f21676y;

    /* renamed from: z, reason: collision with root package name */
    private b f21677z;

    class a implements i.a {
        a() {
        }

        @Override // stepos.support.v7.widget.i.a
        public void a(CharSequence charSequence) {
        }

        @Override // stepos.support.v7.widget.i.a
        public void b(CharSequence charSequence) {
            StepOSCollapsingToolbarLayout.this.f22033k.O(charSequence);
        }
    }

    private class b implements AppBarLayout.h {
        b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i5) {
            StepOSCollapsingToolbarLayout.this.f21673F = Math.abs(i5) / StepOSCollapsingToolbarLayout.this.getExpandRange();
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = StepOSCollapsingToolbarLayout.this;
            stepOSCollapsingToolbarLayout.v(stepOSCollapsingToolbarLayout.f21673F);
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout2 = StepOSCollapsingToolbarLayout.this;
            if (stepOSCollapsingToolbarLayout2.f21670C != null) {
                float f5 = 1.0f - (stepOSCollapsingToolbarLayout2.f21673F * 0.27f);
                StepOSCollapsingToolbarLayout.this.f21670C.setScaleX(f5);
                StepOSCollapsingToolbarLayout.this.f21670C.setScaleY(f5);
            }
            StepOSCollapsingToolbarLayout.r(StepOSCollapsingToolbarLayout.this);
        }
    }

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X4.a.f5843s);
    }

    static /* synthetic */ a.g r(StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout) {
        stepOSCollapsingToolbarLayout.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f5) {
        TextView textView = this.f21671D;
        if (textView == null) {
            return;
        }
        textView.setAlpha(f5 < 0.5f ? 0.0f : (f5 * 2.0f) - 1.0f);
        float f6 = 1.0f - f5;
        this.f22033k.P(f6 > 0.5f ? (f6 * 2.0f) - 1.0f : 0.0f);
    }

    @Override // stepos.support.v7.widget.g
    protected int b() {
        Y y5 = this.f21676y;
        if (y5 != null) {
            return y5.k();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchConfigurationChanged(Configuration configuration) {
        super.dispatchConfigurationChanged(configuration);
        v vVar = this.f21670C;
        if (vVar != null) {
            setTabLayout(vVar);
            if (this.f21671D != null) {
                this.f21670C.setVisibility(8);
            }
        }
    }

    @Override // stepos.support.v7.widget.g, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        v(this.f21673F);
    }

    public int getExpandRange() {
        Y y5 = this.f21676y;
        return (getHeight() - H.z(this)) - (y5 != null ? y5.k() : 0);
    }

    @Override // stepos.support.v7.widget.g
    Y k(Y y5) {
        if (!D.c.a(this.f21676y, y5)) {
            this.f21676y = y5;
            requestLayout();
        }
        return super.k(y5);
    }

    @Override // stepos.support.v7.widget.g, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.f21677z == null) {
                this.f21677z = new b();
            }
            ((AppBarLayout) parent).g(this.f21677z);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f21668A = (ActionBarContextView) findViewById(X4.f.f5991g);
    }

    @Override // stepos.support.v7.widget.g, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int iB = b();
        if (iB > 0) {
            super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iB, 1073741824));
        }
        v vVar = this.f21670C;
        if (vVar != null) {
            vVar.setPivotX(vVar.getContentStart());
            v vVar2 = this.f21670C;
            vVar2.setPivotY(vVar2.getContentBottom());
        }
    }

    public void s() {
        v vVar = this.f21670C;
        if (vVar != null) {
            vVar.setVisibility(0);
        }
        this.f22033k.O(getTitle());
        this.f22033k.P(1.0f);
        i iVar = this.f21672E;
        if (iVar != null) {
            iVar.H(this.f21674G);
        }
        this.f21672E = null;
        this.f21671D = null;
    }

    public void setOnOffsetChangedListener(a.g gVar) {
    }

    public void setTabLayout(v vVar) {
        v vVar2 = this.f21670C;
        if (vVar2 != null && vVar2.getParent() == this) {
            removeView(this.f21670C);
        }
        this.f21670C = vVar;
        if (vVar != null) {
            vVar.L(true);
            addView(this.f21670C);
            g.c cVar = (g.c) this.f21670C.getLayoutParams();
            ((FrameLayout.LayoutParams) cVar).width = -2;
            ((FrameLayout.LayoutParams) cVar).height = -2;
            ((FrameLayout.LayoutParams) cVar).gravity = 8388691;
            Resources resources = getResources();
            ((FrameLayout.LayoutParams) cVar).bottomMargin = resources.getDimensionPixelSize(X4.d.f5895c0);
            this.f21670C.setPadding(resources.getDimensionPixelSize(X4.d.f5897d0), 0, 0, 0);
        }
    }

    public void setTitleTextColor(int i5) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i5);
        this.f22033k.D(colorStateListValueOf);
        this.f22033k.I(colorStateListValueOf);
    }

    public h t(m mVar) {
        if (this.f21675x == null) {
            this.f21675x = new h(this, mVar);
        }
        return this.f21675x;
    }

    public void u() {
        ActionBarContextView actionBarContextView = this.f21668A;
        if (actionBarContextView != null) {
            View customView = actionBarContextView.getCustomView();
            if (customView instanceof i) {
                i iVar = (i) customView;
                this.f21672E = iVar;
                this.f21671D = iVar.getTitleView();
                this.f21672E.B(this.f21674G);
            }
            v vVar = this.f21670C;
            if (vVar != null) {
                vVar.setVisibility(8);
            }
            v(this.f21673F);
        }
    }

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21669B = 1.0f;
        this.f21674G = new a();
    }
}
