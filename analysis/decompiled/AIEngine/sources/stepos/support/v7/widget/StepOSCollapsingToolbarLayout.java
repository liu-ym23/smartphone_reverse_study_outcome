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
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.aiengine.R;
import java.util.Objects;
import java.util.WeakHashMap;
import stepos.support.v7.app.a;
import stepos.support.v7.widget.e;
import stepos.support.v7.widget.h;
import v0.h0;
import v0.m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSCollapsingToolbarLayout extends e {
    public g A;
    public m0 B;
    public b C;
    public ActionBarContextView D;
    public s E;
    public TextView F;
    public h G;
    public float H;
    public final a I;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements h.a {
        public a() {
        }

        @Override // stepos.support.v7.widget.h.a
        public final void a(CharSequence charSequence) {
            StepOSCollapsingToolbarLayout.this.f12742n.n(charSequence);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements AppBarLayout.g {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public final void a(int i10) {
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = StepOSCollapsingToolbarLayout.this;
            float fAbs = Math.abs(i10) / stepOSCollapsingToolbarLayout.getExpandRange();
            stepOSCollapsingToolbarLayout.H = fAbs;
            stepOSCollapsingToolbarLayout.h(fAbs);
            s sVar = stepOSCollapsingToolbarLayout.E;
            if (sVar != null) {
                float f8 = 1.0f - (stepOSCollapsingToolbarLayout.H * 0.27f);
                sVar.setScaleX(f8);
                stepOSCollapsingToolbarLayout.E.setScaleY(f8);
            }
        }
    }

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposCollapsingToolbarLayoutStyle);
        this.I = new a();
    }

    @Override // stepos.support.v7.widget.e
    public final int a() {
        m0 m0Var = this.B;
        if (m0Var != null) {
            return m0Var.d();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.dispatchConfigurationChanged(configuration);
        s sVar = this.E;
        if (sVar != null) {
            setTabLayout(sVar);
            if (this.F != null) {
                this.E.setVisibility(8);
            }
        }
    }

    @Override // stepos.support.v7.widget.e, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        h(this.H);
    }

    @Override // stepos.support.v7.widget.e
    public final m0 e(m0 m0Var) {
        if (!Objects.equals(this.B, m0Var)) {
            this.B = m0Var;
            requestLayout();
        }
        return super.e(m0Var);
    }

    public int getExpandRange() {
        m0 m0Var = this.B;
        int iD = m0Var != null ? m0Var.d() : 0;
        int height = getHeight();
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        return (height - getMinimumHeight()) - iD;
    }

    public final void h(float f8) {
        TextView textView = this.F;
        if (textView == null) {
            return;
        }
        textView.setAlpha(f8 < 0.5f ? 0.0f : (f8 * 2.0f) - 1.0f);
        float f9 = 1.0f - f8;
        this.f12742n.G.setAlpha((int) ((f9 > 0.5f ? (f9 * 2.0f) - 1.0f : 0.0f) * 255.0f));
    }

    @Override // stepos.support.v7.widget.e, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.C == null) {
                this.C = new b();
            }
            ((AppBarLayout) parent).c(this.C);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.D = (ActionBarContextView) findViewById(R.id.action_context_bar);
    }

    @Override // stepos.support.v7.widget.e, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int iA = a();
        if (iA > 0) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iA, 1073741824));
        }
        s sVar = this.E;
        if (sVar != null) {
            sVar.setPivotX(sVar.getContentStart());
            s sVar2 = this.E;
            sVar2.setPivotY(sVar2.getContentBottom());
        }
    }

    public void setTabLayout(s sVar) throws Resources.NotFoundException {
        s sVar2 = this.E;
        if (sVar2 != null && sVar2.getParent() == this) {
            removeView(this.E);
        }
        this.E = sVar;
        if (sVar != null) {
            sVar.a(true);
            addView(this.E);
            e.b bVar = (e.b) this.E.getLayoutParams();
            ((FrameLayout.LayoutParams) bVar).width = -2;
            ((FrameLayout.LayoutParams) bVar).height = -2;
            ((FrameLayout.LayoutParams) bVar).gravity = 8388691;
            Resources resources = getResources();
            ((FrameLayout.LayoutParams) bVar).bottomMargin = resources.getDimensionPixelSize(R.dimen.stepos_tab_bar_margin_bottom_nested_scroll);
            this.E.setPadding(resources.getDimensionPixelSize(R.dimen.stepos_tab_bar_padding_left_nested_scroll), 0, 0, 0);
        }
    }

    public void setTitleTextColor(int i10) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i10);
        d dVar = this.f12742n;
        if (dVar.f12721o != colorStateListValueOf) {
            dVar.f12721o = colorStateListValueOf;
            dVar.j();
        }
        if (dVar.f12720n != colorStateListValueOf) {
            dVar.f12720n = colorStateListValueOf;
            dVar.j();
        }
    }

    public void setOnOffsetChangedListener(a.e eVar) {
    }
}
