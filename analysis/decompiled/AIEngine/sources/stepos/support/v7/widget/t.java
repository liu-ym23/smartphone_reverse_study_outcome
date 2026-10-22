package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.x0;
import com.stepos.aiengine.R;
import stepos.support.v7.widget.a0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12848a;

    /* renamed from: b, reason: collision with root package name */
    public s f12849b;

    /* renamed from: c, reason: collision with root package name */
    public a0 f12850c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f12851d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12852e;
    public final Paint h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12853j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12854k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12855l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12856m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f12857n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f12858o;

    /* renamed from: p, reason: collision with root package name */
    public int f12859p;

    /* renamed from: q, reason: collision with root package name */
    public int f12860q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12861s;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f12862a;
    }

    public t(Context context) throws Resources.NotFoundException {
        super(context, null, R.attr.steposActionBarTabContainerStyle);
        this.f12854k = false;
        this.f12855l = false;
        this.f12856m = true;
        x0 x0VarE = x0.e(context, null, ce.a.f3416e, R.attr.steposActionBarTabContainerStyle);
        this.f12848a = x0VarE.f948b.getBoolean(0, false);
        x0VarE.f();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, ce.a.f3417f, R.attr.steposActionBarTabScrollViewStyle, 0);
        int color = typedArrayObtainStyledAttributes.getColor(7, getResources().getColor(R.color.stepos_action_bar_scrollview_divider_default_color));
        this.f12852e = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_tab_scroll_top_divider_height));
        this.f12860q = typedArrayObtainStyledAttributes.getColor(3, getResources().getColor(R.color.stepos_white_action_bar_textcolor));
        this.f12859p = typedArrayObtainStyledAttributes.getResourceId(4, R.style.TextAppearance_StepOS_AppCompat_Widget_ActionBar_TabScrollView_ExpendTitle);
        typedArrayObtainStyledAttributes.recycle();
        this.f12851d = context;
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(color);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_action_tab_bar_margin_left);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    public final void a(View view, int i10, boolean z, boolean z3) {
        int measuredHeight;
        int i11;
        int i12;
        a aVar = (a) view.getLayoutParams();
        int i13 = z ? ((ViewGroup.MarginLayoutParams) aVar).rightMargin : ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
        int i14 = z ? ((ViewGroup.MarginLayoutParams) aVar).leftMargin : ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
        int paddingTop = getPaddingTop();
        int measuredHeight2 = getMeasuredHeight() - getPaddingBottom();
        int measuredWidth = z ? (i10 - i14) - view.getMeasuredWidth() : i10 + i13;
        int i15 = aVar.f12862a;
        if (i15 == -1) {
            i15 = 8388659;
        }
        int i16 = i15 & 112;
        int measuredHeight3 = view.getMeasuredHeight();
        if (i16 != 48) {
            if (i16 != 80) {
                i11 = (((measuredHeight2 - paddingTop) - measuredHeight3) / 2) + paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                i12 = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            } else {
                i11 = measuredHeight2 - measuredHeight3;
                i12 = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            }
            measuredHeight = i11 - i12;
        } else {
            measuredHeight = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
        }
        if (z3) {
            measuredHeight = (getMeasuredHeight() - view.getMeasuredHeight()) / 2;
        }
        view.layout(measuredWidth, measuredHeight, view.getMeasuredWidth() + measuredWidth, measuredHeight3 + measuredHeight);
    }

    public final boolean b(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) throws Resources.NotFoundException {
        int i10;
        super.draw(canvas);
        if (this.f12855l || (i10 = this.f12852e) <= 0) {
            return;
        }
        canvas.drawRect(getResources().getDimensionPixelSize(R.dimen.stepos_action_tab_bar_divider_padding), 0.0f, getMeasuredWidth() - r1, i10, this.h);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        a aVar = new a(-1, -2);
        aVar.f12862a = 16;
        return aVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        a aVar = new a(getContext(), attributeSet);
        aVar.f12862a = 16;
        return aVar;
    }

    public int getContentStart() {
        return this.f12849b.getContentStart() + getPaddingStart();
    }

    public s getTabView() {
        return this.f12849b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        boolean zB = g0.b(this);
        int paddingRight = zB ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        if (b(this.f12849b)) {
            a(this.f12849b, paddingRight, zB, false);
        }
        if (b(this.f12858o)) {
            a(this.f12858o, paddingRight, zB, true);
        }
        if (b(this.f12850c)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12850c.getLayoutParams();
            int paddingLeft = zB ? getPaddingLeft() + (zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin) : ((getMeasuredWidth() - getPaddingRight()) - (zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin)) - this.f12850c.getMeasuredWidth();
            a0 a0Var = this.f12850c;
            a0Var.layout(paddingLeft, 0, a0Var.getMeasuredWidth() + paddingLeft, this.f12850c.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        boolean z;
        int measuredHeight;
        int paddingRight;
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(t.class.getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i10);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int dimensionPixelSize = !this.f12855l ? getResources().getDimensionPixelSize(R.dimen.stepos_action_tab_bar_margin_left) : 0;
        boolean z3 = true;
        if (this.f12854k) {
            this.f12849b.setEqualTabWidth(false);
        } else if (!this.f12856m) {
            this.f12849b.setEqualTabWidth(true);
        }
        if (b(this.f12849b)) {
            this.f12849b.setNeedCollapse(false);
            int i12 = dimensionPixelSize * 2;
            this.f12849b.measure(View.MeasureSpec.makeMeasureSpec(size - i12, View.MeasureSpec.getMode(i10)), i11);
            if (!this.f12848a || (size >= this.f12849b.getTabStripWidth() + i12 && !this.f12854k)) {
                z = false;
                z3 = false;
            } else {
                z = true;
            }
            measuredHeight = this.f12849b.getMeasuredHeight();
        } else {
            z = false;
            measuredHeight = 0;
            z3 = false;
        }
        if (z3 != this.f12853j) {
            if (z3) {
                if (this.f12850c == null) {
                    this.f12850c = new a0(this.f12851d, null);
                }
                if (this.f12850c.getParent() != this) {
                    addView(this.f12850c);
                    ViewGroup.LayoutParams layoutParams = this.f12850c.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -1;
                }
                this.f12850c.setOnTabCollapseButtonClickListener(null);
                Drawable drawable = this.f12857n;
                if (drawable != null) {
                    this.f12850c.setImageDrawable(drawable);
                }
                this.f12850c.setVisibility(0);
                if (this.f12855l) {
                    this.f12850c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                } else {
                    setPadding(getResources().getDimensionPixelSize(R.dimen.stepos_action_tab_bar_margin_left), 0, 0, 0);
                    this.f12850c.setScaleType(ImageView.ScaleType.MATRIX);
                }
                if (this.f12861s) {
                    this.f12850c.setImageDrawable(getContext().getDrawable(R.drawable.stepos_titlebar_ic_tab_unfold_capstyle));
                    this.f12850c.setPadding((int) l8.f.a(16.0f, getContext()), 0, (int) l8.f.a(16.0f, getContext()), 0);
                    this.f12850c.setScaleType(ImageView.ScaleType.CENTER);
                }
            } else {
                a0 a0Var = this.f12850c;
                if (a0Var != null) {
                    a0Var.setVisibility(8);
                }
                TextView textView = this.f12858o;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (this.f12855l) {
                    setPadding(0, 0, 0, 0);
                } else {
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_action_tab_bar_margin_left);
                    setPadding(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                }
            }
            this.f12853j = z3;
        }
        if (!this.r) {
            if (z3) {
                this.f12849b.setTabsGravity(3);
            } else {
                this.f12849b.setTabsGravity(17);
            }
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE);
        if (b(this.f12850c)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12850c.getLayoutParams();
            this.f12850c.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824), getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
            paddingRight = size - (getPaddingRight() + (getPaddingLeft() + this.f12850c.getMeasuredWidth()));
        } else {
            paddingRight = size;
        }
        if (b(this.f12858o)) {
            this.f12858o.measure(View.MeasureSpec.makeMeasureSpec(paddingRight, 1073741824), iMakeMeasureSpec);
        }
        if (z && b(this.f12849b)) {
            this.f12849b.setNeedCollapse(z3);
            this.f12849b.measure(View.MeasureSpec.makeMeasureSpec(paddingRight, 1073741824), iMakeMeasureSpec);
        }
        setMeasuredDimension(size, measuredHeight + paddingBottom);
    }

    public void setAdaptTabWidth(boolean z) {
        s sVar = this.f12849b;
        if (sVar != null) {
            sVar.setAdaptTabWidthNoScroll(z);
        }
    }

    public void setAllowCollapse(boolean z) {
        if (this.f12848a != z) {
            this.f12848a = z;
            requestLayout();
        }
    }

    public void setCapsuleStyleEnable(boolean z) {
        this.f12861s = z;
    }

    public void setCollapseButtonClickListener(a0.b bVar) {
        a0 a0Var = this.f12850c;
        if (a0Var != null) {
            a0Var.setOnTabCollapseButtonClickListener(bVar);
        }
    }

    public void setCollapseButtonDrawable(Drawable drawable) {
        this.f12857n = drawable;
        a0 a0Var = this.f12850c;
        if (a0Var == null || drawable == null) {
            return;
        }
        a0Var.setImageDrawable(drawable);
    }

    public void setIsForceCollapse(boolean z) {
        if (this.f12854k != z) {
            this.f12854k = z;
            requestLayout();
        }
    }

    public void setPreventEqualWidth(boolean z) {
        this.f12856m = z;
    }

    public void setScrollTabsExpendTitle(CharSequence charSequence) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f12858o;
            if (textView != null) {
                removeView(textView);
                this.f12858o = null;
            }
        } else if (this.f12858o == null) {
            Context context = getContext();
            TextView textView2 = new TextView(context);
            this.f12858o = textView2;
            textView2.setSingleLine();
            this.f12858o.setEllipsize(TextUtils.TruncateAt.END);
            this.f12858o.setMaxWidth(context.getResources().getDimensionPixelSize(R.dimen.stepos_toolbar_title_max_width));
            int i10 = this.f12859p;
            if (i10 != 0) {
                this.f12858o.setTextAppearance(context, i10);
            }
            int i11 = this.f12860q;
            if (i11 != 0) {
                this.f12858o.setTextColor(i11);
            }
            this.f12858o.setVisibility(8);
            addView(this.f12858o);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_scroll_tabs_expend_title_padding_vertical);
            this.f12858o.setPadding(getResources().getDimensionPixelSize(R.dimen.stepos_scroll_tabs_expend_title_margin_left), dimensionPixelSize, 0, dimensionPixelSize);
            a aVar = (a) this.f12858o.getLayoutParams();
            if (this.f12855l) {
                aVar.f12862a = 16;
            } else {
                aVar.f12862a = 48;
            }
        }
        TextView textView3 = this.f12858o;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
    }

    public void setScrollTabsExpendTitleTextAppearance(int i10) {
        this.f12859p = i10;
        if (this.f12858o != null) {
            this.f12858o.setTextAppearance(getContext(), i10);
        }
    }

    public void setScrollTabsExpendTitleTextColor(int i10) {
        this.f12860q = i10;
        TextView textView = this.f12858o;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public void setTabView(s sVar) {
        s sVar2 = this.f12849b;
        if (sVar2 == sVar && sVar2.getParent() == this) {
            return;
        }
        s sVar3 = this.f12849b;
        if (sVar3 != null) {
            removeView(sVar3);
        }
        this.f12849b = sVar;
        if (sVar != null) {
            addView(sVar);
            sVar.setAllowCollapse(false);
        }
    }

    public void setTabsContentHeight(int i10) {
        s sVar = this.f12849b;
        if (sVar != null) {
            sVar.setContentHeight(i10);
        }
    }

    public void setTabsGravity(int i10) {
        this.r = true;
        s sVar = this.f12849b;
        if (sVar != null) {
            sVar.setTabsGravity(i10);
        }
    }
}
