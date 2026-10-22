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
import androidx.core.view.N;
import androidx.core.view.a0;
import com.google.android.material.appbar.AppBarLayout;
import stepos.support.v7.app.a;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.widget.f;
import stepos.support.v7.widget.h;

/* loaded from: classes5.dex */
public class StepOSCollapsingToolbarLayout extends f {

    /* renamed from: A, reason: collision with root package name */
    public ActionBarContextView f41288A;

    /* renamed from: B, reason: collision with root package name */
    public float f41289B;

    /* renamed from: C, reason: collision with root package name */
    public r f41290C;

    /* renamed from: D, reason: collision with root package name */
    public TextView f41291D;

    /* renamed from: E, reason: collision with root package name */
    public h f41292E;

    /* renamed from: F, reason: collision with root package name */
    public float f41293F;

    /* renamed from: G, reason: collision with root package name */
    public h.a f41294G;

    /* renamed from: x, reason: collision with root package name */
    public g f41295x;

    /* renamed from: y, reason: collision with root package name */
    public a0 f41296y;

    /* renamed from: z, reason: collision with root package name */
    public b f41297z;

    public class a implements h.a {
        public a() {
        }

        @Override // stepos.support.v7.widget.h.a
        public void a(CharSequence charSequence) {
        }

        @Override // stepos.support.v7.widget.h.a
        public void b(CharSequence charSequence) {
            StepOSCollapsingToolbarLayout.this.f41602k.O(charSequence);
        }
    }

    public class b implements AppBarLayout.h {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i10) {
            StepOSCollapsingToolbarLayout.this.f41293F = Math.abs(i10) / StepOSCollapsingToolbarLayout.this.getExpandRange();
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = StepOSCollapsingToolbarLayout.this;
            stepOSCollapsingToolbarLayout.v(stepOSCollapsingToolbarLayout.f41293F);
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout2 = StepOSCollapsingToolbarLayout.this;
            if (stepOSCollapsingToolbarLayout2.f41290C != null) {
                float f10 = 1.0f - (stepOSCollapsingToolbarLayout2.f41293F * 0.27f);
                StepOSCollapsingToolbarLayout.this.f41290C.setScaleX(f10);
                StepOSCollapsingToolbarLayout.this.f41290C.setScaleY(f10);
            }
            StepOSCollapsingToolbarLayout.r(StepOSCollapsingToolbarLayout.this);
        }
    }

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.steposCollapsingToolbarLayoutStyle);
    }

    public static /* synthetic */ a.f r(StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout) {
        stepOSCollapsingToolbarLayout.getClass();
        return null;
    }

    @Override // stepos.support.v7.widget.f
    public int b() {
        a0 a0Var = this.f41296y;
        if (a0Var != null) {
            return a0Var.m();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchConfigurationChanged(Configuration configuration) {
        super.dispatchConfigurationChanged(configuration);
        r rVar = this.f41290C;
        if (rVar != null) {
            setTabLayout(rVar);
            if (this.f41291D != null) {
                this.f41290C.setVisibility(8);
            }
        }
    }

    @Override // stepos.support.v7.widget.f, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v(this.f41293F);
    }

    public int getExpandRange() {
        a0 a0Var = this.f41296y;
        return (getHeight() - N.w(this)) - (a0Var != null ? a0Var.m() : 0);
    }

    @Override // stepos.support.v7.widget.f
    public a0 k(a0 a0Var) {
        if (!B0.c.a(this.f41296y, a0Var)) {
            this.f41296y = a0Var;
            requestLayout();
        }
        return super.k(a0Var);
    }

    @Override // stepos.support.v7.widget.f, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.f41297z == null) {
                this.f41297z = new b();
            }
            ((AppBarLayout) parent).g(this.f41297z);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f41288A = (ActionBarContextView) findViewById(R$id.action_context_bar);
    }

    @Override // stepos.support.v7.widget.f, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int iB = b();
        if (iB > 0) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iB, 1073741824));
        }
        r rVar = this.f41290C;
        if (rVar != null) {
            rVar.setPivotX(rVar.getContentStart());
            r rVar2 = this.f41290C;
            rVar2.setPivotY(rVar2.getContentBottom());
        }
    }

    public void s() {
        r rVar = this.f41290C;
        if (rVar != null) {
            rVar.setVisibility(0);
        }
        this.f41602k.O(getTitle());
        this.f41602k.P(1.0f);
        h hVar = this.f41292E;
        if (hVar != null) {
            hVar.m(this.f41294G);
        }
        this.f41292E = null;
        this.f41291D = null;
    }

    public void setOnOffsetChangedListener(a.f fVar) {
    }

    public void setTabLayout(r rVar) {
        r rVar2 = this.f41290C;
        if (rVar2 != null && rVar2.getParent() == this) {
            removeView(this.f41290C);
        }
        this.f41290C = rVar;
        if (rVar != null) {
            rVar.i(true);
            addView(this.f41290C);
            f.c cVar = (f.c) this.f41290C.getLayoutParams();
            ((FrameLayout.LayoutParams) cVar).width = -2;
            ((FrameLayout.LayoutParams) cVar).height = -2;
            ((FrameLayout.LayoutParams) cVar).gravity = 8388691;
            Resources resources = getResources();
            ((FrameLayout.LayoutParams) cVar).bottomMargin = resources.getDimensionPixelSize(R$dimen.stepos_tab_bar_margin_bottom_nested_scroll);
            this.f41290C.setPadding(resources.getDimensionPixelSize(R$dimen.stepos_tab_bar_padding_left_nested_scroll), 0, 0, 0);
        }
    }

    public void setTitleTextColor(int i10) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i10);
        this.f41602k.D(colorStateListValueOf);
        this.f41602k.I(colorStateListValueOf);
    }

    public g t(k kVar) {
        if (this.f41295x == null) {
            this.f41295x = new g(this, kVar);
        }
        return this.f41295x;
    }

    public void u() {
        ActionBarContextView actionBarContextView = this.f41288A;
        if (actionBarContextView != null) {
            View customView = actionBarContextView.getCustomView();
            if (customView instanceof h) {
                h hVar = (h) customView;
                this.f41292E = hVar;
                this.f41291D = hVar.getTitleView();
                this.f41292E.g(this.f41294G);
            }
            r rVar = this.f41290C;
            if (rVar != null) {
                rVar.setVisibility(8);
            }
            v(this.f41293F);
        }
    }

    public final void v(float f10) {
        TextView textView = this.f41291D;
        if (textView == null) {
            return;
        }
        textView.setAlpha(f10 < 0.5f ? 0.0f : (f10 * 2.0f) - 1.0f);
        float f11 = 1.0f - f10;
        this.f41602k.P(f11 > 0.5f ? (f11 * 2.0f) - 1.0f : 0.0f);
    }

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41289B = 1.0f;
        this.f41294G = new a();
    }
}
