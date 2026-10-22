package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.U;
import androidx.core.view.V;
import stepos.support.v7.app.a;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$color;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$drawable;
import stepos.support.v7.appcompat.R$style;
import stepos.support.v7.appcompat.R$styleable;
import stepos.support.v7.widget.u;

/* loaded from: classes5.dex */
public class s extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f41713a;

    /* renamed from: b, reason: collision with root package name */
    public r f41714b;

    /* renamed from: c, reason: collision with root package name */
    public u f41715c;

    /* renamed from: d, reason: collision with root package name */
    public Context f41716d;

    /* renamed from: e, reason: collision with root package name */
    public int f41717e;

    /* renamed from: f, reason: collision with root package name */
    public int f41718f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f41719g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f41720h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f41721i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f41722j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f41723k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f41724l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f41725m;

    /* renamed from: n, reason: collision with root package name */
    public int f41726n;

    /* renamed from: o, reason: collision with root package name */
    public int f41727o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f41728p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f41729q;

    /* renamed from: r, reason: collision with root package name */
    public V f41730r;

    public class a implements V {
        public a() {
        }

        @Override // androidx.core.view.V
        public void c(View view) {
        }

        @Override // androidx.core.view.V
        public void d(View view) {
            s.a(s.this);
        }

        @Override // androidx.core.view.V
        public void e(View view) {
            s.a(s.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public s(Context context) throws Resources.NotFoundException {
        int i10 = R$attr.steposActionBarTabContainerStyle;
        super(context, null, i10);
        this.f41721i = false;
        this.f41722j = false;
        this.f41723k = true;
        this.f41730r = new a();
        U uV = U.v(context, null, R$styleable.StepOSActionBarTabContainer, i10, 0);
        this.f41713a = uV.a(R$styleable.StepOSActionBarTabContainer_steposAllowCollapse, false);
        uV.x();
        U uV2 = U.v(context, null, R$styleable.StepOSActionBarTabScrollView, R$attr.steposActionBarTabScrollViewStyle, 0);
        this.f41718f = uV2.b(R$styleable.StepOSActionBarTabScrollView_steposTopDividerColor, getResources().getColor(R$color.stepos_action_bar_scrollview_divider_default_color));
        this.f41717e = uV2.f(R$styleable.StepOSActionBarTabScrollView_steposTopDividerHeight, getResources().getDimensionPixelSize(R$dimen.stepos_action_bar_tab_scroll_top_divider_height));
        this.f41727o = uV2.b(R$styleable.StepOSActionBarTabScrollView_steposTabScrollViewExpendTitleColor, getResources().getColor(com.stepos.common.R$color.stepos_white_action_bar_textcolor));
        this.f41726n = uV2.n(R$styleable.StepOSActionBarTabScrollView_steposTabScrollViewExpendTitleTextAppearance, R$style.TextAppearance_StepOS_AppCompat_Widget_ActionBar_TabScrollView_ExpendTitle);
        uV2.x();
        this.f41716d = context;
        Paint paint = new Paint();
        this.f41719g = paint;
        paint.setColor(this.f41718f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.stepos_action_tab_bar_margin_left);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    public static /* synthetic */ a.g a(s sVar) {
        sVar.getClass();
        return null;
    }

    public final void b() {
        if (this.f41715c == null) {
            this.f41715c = new u(this.f41716d);
        }
        if (this.f41715c.getParent() != this) {
            addView(this.f41715c);
            ViewGroup.LayoutParams layoutParams = this.f41715c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        this.f41715c.setOnTabCollapseButtonClickListener(null);
        Drawable drawable = this.f41724l;
        if (drawable != null) {
            this.f41715c.setImageDrawable(drawable);
        }
        this.f41715c.setVisibility(0);
        if (this.f41722j) {
            this.f41715c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            setPadding(getResources().getDimensionPixelSize(R$dimen.stepos_action_tab_bar_margin_left), 0, 0, 0);
            this.f41715c.setScaleType(ImageView.ScaleType.MATRIX);
        }
        if (this.f41729q) {
            this.f41715c.setImageDrawable(getContext().getDrawable(R$drawable.stepos_titlebar_ic_tab_unfold_capstyle));
            this.f41715c.setPadding((int) O6.s.a(16.0f, getContext()), 0, (int) O6.s.a(16.0f, getContext()), 0);
            this.f41715c.setScaleType(ImageView.ScaleType.CENTER);
        }
    }

    public final void c() throws Resources.NotFoundException {
        u uVar = this.f41715c;
        if (uVar != null) {
            uVar.setVisibility(8);
        }
        TextView textView = this.f41725m;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (this.f41722j) {
            setPadding(0, 0, 0, 0);
        } else {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.stepos_action_tab_bar_margin_left);
            setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    public final void d(View view, int i10, boolean z10, boolean z11) {
        b bVar = (b) view.getLayoutParams();
        int i11 = z10 ? ((ViewGroup.MarginLayoutParams) bVar).rightMargin : ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
        int i12 = z10 ? ((ViewGroup.MarginLayoutParams) bVar).leftMargin : ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int paddingTop = getPaddingTop();
        int measuredHeight = getMeasuredHeight() - getPaddingBottom();
        int measuredWidth = z10 ? (i10 - i12) - view.getMeasuredWidth() : i10 + i11;
        int i13 = bVar.f41732a;
        if (i13 == -1) {
            i13 = 8388659;
        }
        int i14 = i13 & 112;
        int measuredHeight2 = view.getMeasuredHeight();
        int measuredHeight3 = i14 != 48 ? i14 != 80 ? ((paddingTop + (((measuredHeight - paddingTop) - measuredHeight2) / 2)) + ((ViewGroup.MarginLayoutParams) bVar).topMargin) - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin : (measuredHeight - measuredHeight2) - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin : paddingTop + ((ViewGroup.MarginLayoutParams) bVar).topMargin;
        if (z11) {
            measuredHeight3 = (getMeasuredHeight() - view.getMeasuredHeight()) / 2;
        }
        view.layout(measuredWidth, measuredHeight3, view.getMeasuredWidth() + measuredWidth, measuredHeight2 + measuredHeight3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) throws Resources.NotFoundException {
        super.draw(canvas);
        if (this.f41722j || this.f41717e <= 0) {
            return;
        }
        canvas.drawRect(getResources().getDimensionPixelSize(R$dimen.stepos_action_tab_bar_divider_padding), 0.0f, getMeasuredWidth() - r0, this.f41717e, this.f41719g);
    }

    public final boolean e(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void f(boolean z10) {
        this.f41714b.i(z10);
        if (this.f41722j != z10) {
            this.f41722j = z10;
            if (!z10) {
                TextView textView = this.f41725m;
                if (textView == null || textView.getLayoutParams() == null) {
                    return;
                }
                ((b) this.f41725m.getLayoutParams()).f41732a = 48;
                return;
            }
            setPadding(0, 0, 0, 0);
            TextView textView2 = this.f41725m;
            if (textView2 == null || textView2.getLayoutParams() == null) {
                return;
            }
            ((b) this.f41725m.getLayoutParams()).f41732a = 16;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public int getContentStart() {
        return getPaddingStart() + this.f41714b.getContentStart();
    }

    public r getTabView() {
        return this.f41714b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean zM = y.m(this);
        int paddingRight = zM ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        if (e(this.f41714b)) {
            d(this.f41714b, paddingRight, zM, false);
        }
        if (e(this.f41725m)) {
            d(this.f41725m, paddingRight, zM, true);
        }
        if (e(this.f41715c)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f41715c.getLayoutParams();
            int paddingLeft = zM ? getPaddingLeft() + (zM ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin) : ((getMeasuredWidth() - getPaddingRight()) - (zM ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin)) - this.f41715c.getMeasuredWidth();
            u uVar = this.f41715c;
            uVar.layout(paddingLeft, 0, uVar.getMeasuredWidth() + paddingLeft, this.f41715c.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        int measuredHeight;
        int measuredWidth;
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i10);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        boolean z10 = false;
        int dimensionPixelSize = !this.f41722j ? getResources().getDimensionPixelSize(R$dimen.stepos_action_tab_bar_margin_left) : 0;
        boolean z11 = true;
        if (this.f41721i) {
            this.f41714b.setEqualTabWidth(false);
        } else if (!this.f41723k) {
            this.f41714b.setEqualTabWidth(true);
        }
        if (e(this.f41714b)) {
            this.f41714b.setNeedCollapse(false);
            int i12 = dimensionPixelSize * 2;
            this.f41714b.measure(View.MeasureSpec.makeMeasureSpec(size - i12, View.MeasureSpec.getMode(i10)), i11);
            if (!this.f41713a || (size >= this.f41714b.getTabStripWidth() + i12 && !this.f41721i)) {
                z11 = false;
            } else {
                z10 = true;
            }
            measuredHeight = this.f41714b.getMeasuredHeight();
        } else {
            measuredHeight = 0;
            z11 = false;
        }
        if (z10 != this.f41720h) {
            if (z10) {
                b();
            } else {
                c();
            }
            this.f41720h = z10;
        }
        if (!this.f41728p) {
            if (z10) {
                this.f41714b.setTabsGravity(3);
            } else {
                this.f41714b.setTabsGravity(17);
            }
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE);
        if (e(this.f41715c)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f41715c.getLayoutParams();
            this.f41715c.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824), getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
            measuredWidth = size - ((this.f41715c.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
        } else {
            measuredWidth = size;
        }
        if (e(this.f41725m)) {
            this.f41725m.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), iMakeMeasureSpec);
        }
        if (z11 && e(this.f41714b)) {
            this.f41714b.setNeedCollapse(z10);
            this.f41714b.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), iMakeMeasureSpec);
        }
        setMeasuredDimension(size, measuredHeight + paddingTop);
    }

    public void setAdaptTabWidth(boolean z10) {
        r rVar = this.f41714b;
        if (rVar != null) {
            rVar.setAdaptTabWidthNoScroll(z10);
        }
    }

    public void setAllowCollapse(boolean z10) {
        if (this.f41713a != z10) {
            this.f41713a = z10;
            requestLayout();
        }
    }

    public void setCapsuleStyleEnable(boolean z10) {
        this.f41729q = z10;
    }

    public void setCollapseButtonClickListener(u.b bVar) {
        u uVar = this.f41715c;
        if (uVar != null) {
            uVar.setOnTabCollapseButtonClickListener(bVar);
        }
    }

    public void setCollapseButtonDrawable(Drawable drawable) {
        this.f41724l = drawable;
        u uVar = this.f41715c;
        if (uVar == null || drawable == null) {
            return;
        }
        uVar.setImageDrawable(drawable);
    }

    public void setIsForceCollapse(boolean z10) {
        if (this.f41721i != z10) {
            this.f41721i = z10;
            requestLayout();
        }
    }

    public void setPreventEqualWidth(boolean z10) {
        this.f41723k = z10;
    }

    public void setScrollTabsExpendTitle(CharSequence charSequence) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f41725m;
            if (textView != null) {
                removeView(textView);
                this.f41725m = null;
            }
        } else if (this.f41725m == null) {
            Context context = getContext();
            TextView textView2 = new TextView(context);
            this.f41725m = textView2;
            textView2.setSingleLine();
            this.f41725m.setEllipsize(TextUtils.TruncateAt.END);
            this.f41725m.setMaxWidth(context.getResources().getDimensionPixelSize(R$dimen.stepos_toolbar_title_max_width));
            int i10 = this.f41726n;
            if (i10 != 0) {
                this.f41725m.setTextAppearance(context, i10);
            }
            int i11 = this.f41727o;
            if (i11 != 0) {
                this.f41725m.setTextColor(i11);
            }
            this.f41725m.setVisibility(8);
            addView(this.f41725m);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.stepos_scroll_tabs_expend_title_padding_vertical);
            this.f41725m.setPadding(getResources().getDimensionPixelSize(R$dimen.stepos_scroll_tabs_expend_title_margin_left), dimensionPixelSize, 0, dimensionPixelSize);
            b bVar = (b) this.f41725m.getLayoutParams();
            if (this.f41722j) {
                bVar.f41732a = 16;
            } else {
                bVar.f41732a = 48;
            }
        }
        TextView textView3 = this.f41725m;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
    }

    public void setScrollTabsExpendTitleTextAppearance(int i10) {
        this.f41726n = i10;
        if (this.f41725m != null) {
            this.f41725m.setTextAppearance(getContext(), i10);
        }
    }

    public void setScrollTabsExpendTitleTextColor(int i10) {
        this.f41727o = i10;
        TextView textView = this.f41725m;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public void setTabView(r rVar) {
        r rVar2 = this.f41714b;
        if (rVar2 == rVar && rVar2.getParent() == this) {
            return;
        }
        r rVar3 = this.f41714b;
        if (rVar3 != null) {
            removeView(rVar3);
        }
        this.f41714b = rVar;
        if (rVar != null) {
            addView(rVar);
            rVar.setAllowCollapse(false);
        }
    }

    public void setTabsContentHeight(int i10) {
        r rVar = this.f41714b;
        if (rVar != null) {
            rVar.setContentHeight(i10);
        }
    }

    public void setTabsGravity(int i10) {
        this.f41728p = true;
        r rVar = this.f41714b;
        if (rVar != null) {
            rVar.setTabsGravity(i10);
        }
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f41732a;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f41732a = 16;
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f41732a = 16;
        }
    }
}
