package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import g.AbstractC0560a;
import j.AbstractC0624c;
import j.C0622a;
import k.C0661o;
import k.InterfaceC0642C;

@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C0189a f2734a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2735b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f2736c;

    /* renamed from: d, reason: collision with root package name */
    public C0217o f2737d;

    /* renamed from: e, reason: collision with root package name */
    public int f2738e;

    /* renamed from: f, reason: collision with root package name */
    public K.e0 f2739f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2740g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2741h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f2742i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f2743j;

    /* renamed from: k, reason: collision with root package name */
    public View f2744k;

    /* renamed from: l, reason: collision with root package name */
    public View f2745l;

    /* renamed from: m, reason: collision with root package name */
    public View f2746m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f2747n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f2748o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f2749p;

    /* renamed from: q, reason: collision with root package name */
    public final int f2750q;

    /* renamed from: r, reason: collision with root package name */
    public final int f2751r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2752s;

    /* renamed from: t, reason: collision with root package name */
    public final int f2753t;

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.actionModeStyle);
        this.f2734a = new C0189a(this, 0);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f2735b = context;
        } else {
            this.f2735b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12591d, R.attr.actionModeStyle, 0);
        setBackground((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : Z2.I.o(context, resourceId));
        this.f2750q = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f2751r = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f2738e = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f2753t = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), i5);
        return Math.max(0, i4 - view.getMeasuredWidth());
    }

    public static int j(int i4, int i5, int i6, View view, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = ((i6 - measuredHeight) / 2) + i5;
        if (z4) {
            view.layout(i4 - measuredWidth, i7, i4, measuredHeight + i7);
        } else {
            view.layout(i4, i7, i4 + measuredWidth, measuredHeight + i7);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    public final void c(AbstractC0624c abstractC0624c) {
        View view = this.f2744k;
        int i4 = 0;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f2753t, (ViewGroup) this, false);
            this.f2744k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f2744k);
        }
        View viewFindViewById = this.f2744k.findViewById(R.id.action_mode_close_button);
        this.f2745l = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0193c(i4, this, abstractC0624c));
        C0661o c0661o = (C0661o) abstractC0624c.c();
        C0217o c0217o = this.f2737d;
        if (c0217o != null) {
            c0217o.g();
            C0205i c0205i = c0217o.f3145t;
            if (c0205i != null && c0205i.b()) {
                c0205i.f13316j.dismiss();
            }
        }
        C0217o c0217o2 = new C0217o(getContext());
        this.f2737d = c0217o2;
        c0217o2.f3137l = true;
        c0217o2.f3138m = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c0661o.b(this.f2737d, this.f2735b);
        C0217o c0217o3 = this.f2737d;
        InterfaceC0642C interfaceC0642C = c0217o3.f3133h;
        if (interfaceC0642C == null) {
            InterfaceC0642C interfaceC0642C2 = (InterfaceC0642C) c0217o3.f3129d.inflate(c0217o3.f3131f, (ViewGroup) this, false);
            c0217o3.f3133h = interfaceC0642C2;
            interfaceC0642C2.f(c0217o3.f3128c);
            c0217o3.a();
        }
        InterfaceC0642C interfaceC0642C3 = c0217o3.f3133h;
        if (interfaceC0642C != interfaceC0642C3) {
            ((ActionMenuView) interfaceC0642C3).setPresenter(c0217o3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) interfaceC0642C3;
        this.f2736c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f2736c, layoutParams);
    }

    public final void d() {
        if (this.f2747n == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2747n = linearLayout;
            this.f2748o = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f2749p = (TextView) this.f2747n.findViewById(R.id.action_bar_subtitle);
            int i4 = this.f2750q;
            if (i4 != 0) {
                this.f2748o.setTextAppearance(getContext(), i4);
            }
            int i5 = this.f2751r;
            if (i5 != 0) {
                this.f2749p.setTextAppearance(getContext(), i5);
            }
        }
        this.f2748o.setText(this.f2742i);
        this.f2749p.setText(this.f2743j);
        boolean z4 = !TextUtils.isEmpty(this.f2742i);
        boolean z5 = !TextUtils.isEmpty(this.f2743j);
        this.f2749p.setVisibility(z5 ? 0 : 8);
        this.f2747n.setVisibility((z4 || z5) ? 0 : 8);
        if (this.f2747n.getParent() == null) {
            addView(this.f2747n);
        }
    }

    public final void e() {
        removeAllViews();
        this.f2746m = null;
        this.f2736c = null;
        this.f2737d = null;
        View view = this.f2745l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.View
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC0560a.f12588a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0217o c0217o = this.f2737d;
        if (c0217o != null) {
            c0217o.f3141p = new C0622a(c0217o.f3127b, 0).e();
            C0661o c0661o = c0217o.f3128c;
            if (c0661o != null) {
                c0661o.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f2739f != null ? this.f2734a.f3050c : getVisibility();
    }

    public int getContentHeight() {
        return this.f2738e;
    }

    public CharSequence getSubtitle() {
        return this.f2743j;
    }

    public CharSequence getTitle() {
        return this.f2742i;
    }

    public final boolean h(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2741h = false;
        }
        if (!this.f2741h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2741h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2741h = false;
        }
        return true;
    }

    public final boolean i(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2740g = false;
        }
        if (!this.f2740g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2740g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2740g = false;
        }
        return true;
    }

    @Override // android.view.View
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i4) {
        if (i4 != getVisibility()) {
            K.e0 e0Var = this.f2739f;
            if (e0Var != null) {
                e0Var.b();
            }
            super.setVisibility(i4);
        }
    }

    public final K.e0 l(int i4, long j4) {
        K.e0 e0Var = this.f2739f;
        if (e0Var != null) {
            e0Var.b();
        }
        C0189a c0189a = this.f2734a;
        if (i4 != 0) {
            K.e0 e0VarA = K.S.a(this);
            e0VarA.a(Property.DEFAULT_FLOAT_VALUE);
            e0VarA.c(j4);
            ((ActionBarContextView) c0189a.f3051d).f2739f = e0VarA;
            c0189a.f3050c = i4;
            e0VarA.e(c0189a);
            return e0VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(Property.DEFAULT_FLOAT_VALUE);
        }
        K.e0 e0VarA2 = K.S.a(this);
        e0VarA2.a(1.0f);
        e0VarA2.c(j4);
        ((ActionBarContextView) c0189a.f3051d).f2739f = e0VarA2;
        c0189a.f3050c = i4;
        e0VarA2.e(c0189a);
        return e0VarA2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0217o c0217o = this.f2737d;
        if (c0217o != null) {
            c0217o.g();
            C0205i c0205i = this.f2737d.f3145t;
            if (c0205i == null || !c0205i.b()) {
                return;
            }
            c0205i.f13316j.dismiss();
        }
    }

    @Override // android.view.View
    public final /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        h(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        boolean z5 = getLayoutDirection() == 1;
        int paddingRight = z5 ? (i6 - i4) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2744k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2744k.getLayoutParams();
            int i8 = z5 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i9 = z5 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i10 = z5 ? paddingRight - i8 : paddingRight + i8;
            int iJ = j(i10, paddingTop, paddingTop2, this.f2744k, z5) + i10;
            paddingRight = z5 ? iJ - i9 : iJ + i9;
        }
        LinearLayout linearLayout = this.f2747n;
        if (linearLayout != null && this.f2746m == null && linearLayout.getVisibility() != 8) {
            paddingRight += j(paddingRight, paddingTop, paddingTop2, this.f2747n, z5);
        }
        View view2 = this.f2746m;
        if (view2 != null) {
            j(paddingRight, paddingTop, paddingTop2, view2, z5);
        }
        int paddingLeft = z5 ? getPaddingLeft() : (i6 - i4) - getPaddingRight();
        ActionMenuView actionMenuView = this.f2736c;
        if (actionMenuView != null) {
            j(paddingLeft, paddingTop, paddingTop2, actionMenuView, !z5);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        if (View.MeasureSpec.getMode(i4) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i5) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i4);
        int size2 = this.f2738e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i5);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f2744k;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2744k.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f2736c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f2736c, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f2747n;
        if (linearLayout != null && this.f2746m == null) {
            if (this.f2752s) {
                this.f2747n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f2747n.getMeasuredWidth();
                boolean z4 = measuredWidth <= paddingLeft;
                if (z4) {
                    paddingLeft -= measuredWidth;
                }
                this.f2747n.setVisibility(z4 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f2746m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i6 = layoutParams.width;
            int i7 = i6 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i6 >= 0) {
                paddingLeft = Math.min(i6, paddingLeft);
            }
            int i8 = layoutParams.height;
            int i9 = i8 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i8 >= 0) {
                iMin = Math.min(i8, iMin);
            }
            this.f2746m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i7), View.MeasureSpec.makeMeasureSpec(iMin, i9));
        }
        if (this.f2738e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i10) {
                i10 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i10);
    }

    @Override // android.view.View
    public final /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        i(motionEvent);
        return true;
    }

    public void setContentHeight(int i4) {
        this.f2738e = i4;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f2746m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2746m = view;
        if (view != null && (linearLayout = this.f2747n) != null) {
            removeView(linearLayout);
            this.f2747n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2743j = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2742i = charSequence;
        d();
        K.S.i(this, charSequence);
    }

    public void setTitleOptional(boolean z4) {
        if (z4 != this.f2752s) {
            requestLayout();
        }
        this.f2752s = z4;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
