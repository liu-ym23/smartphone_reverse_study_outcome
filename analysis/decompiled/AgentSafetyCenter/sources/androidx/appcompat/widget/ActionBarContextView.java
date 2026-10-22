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
import com.stepos.agentsafetycenter.R;
import h.b;
import java.lang.invoke.VarHandle;
import l.l;
import l.z;
import m.a;
import m.g;
import m.k;
import n3.k0;
import n3.o0;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public final a f752c;

    /* renamed from: f, reason: collision with root package name */
    public final Context f753f;

    /* renamed from: g, reason: collision with root package name */
    public ActionMenuView f754g;

    /* renamed from: h, reason: collision with root package name */
    public k f755h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public o0 f756j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f757k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f758l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f759m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f760n;

    /* renamed from: o, reason: collision with root package name */
    public View f761o;

    /* renamed from: p, reason: collision with root package name */
    public View f762p;

    /* renamed from: q, reason: collision with root package name */
    public View f763q;

    /* renamed from: r, reason: collision with root package name */
    public LinearLayout f764r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f765s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f766t;

    /* renamed from: u, reason: collision with root package name */
    public final int f767u;

    /* renamed from: v, reason: collision with root package name */
    public final int f768v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f769w;

    /* renamed from: x, reason: collision with root package name */
    public final int f770x;

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        super(context, attributeSet, i);
        a aVar = new a(0);
        aVar.f7866h = this;
        aVar.f7864f = false;
        VarHandle.storeStoreFence();
        this.f752c = aVar;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f753f = context;
        } else {
            this.f753f = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f4101d, i, 0);
        setBackground((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : id.k.v(resourceId, context));
        this.f767u = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f768v = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.i = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f770x = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i3);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int g(View view, int i, int i3, int i10, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = ((i10 - measuredHeight) / 2) + i3;
        if (z10) {
            view.layout(i - measuredWidth, i11, i, measuredHeight + i11);
        } else {
            view.layout(i, i11, i + measuredWidth, measuredHeight + i11);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public final void c(k.a aVar) {
        View view = this.f761o;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f770x, (ViewGroup) this, false);
            this.f761o = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f761o);
        }
        View viewFindViewById = this.f761o.findViewById(R.id.action_mode_close_button);
        this.f762p = viewFindViewById;
        b bVar = new b(1);
        bVar.f4749f = aVar;
        VarHandle.storeStoreFence();
        viewFindViewById.setOnClickListener(bVar);
        l lVarC = aVar.c();
        k kVar = this.f755h;
        if (kVar != null) {
            kVar.f();
            g gVar = kVar.f7962x;
            if (gVar != null && gVar.b()) {
                gVar.i.dismiss();
            }
        }
        k kVar2 = new k(getContext());
        this.f755h = kVar2;
        kVar2.f7954p = true;
        kVar2.f7955q = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        lVarC.b(this.f755h, this.f753f);
        k kVar3 = this.f755h;
        z zVar = kVar3.f7950l;
        if (zVar == null) {
            z zVar2 = (z) kVar3.f7947h.inflate(kVar3.f7948j, (ViewGroup) this, false);
            kVar3.f7950l = zVar2;
            zVar2.c(kVar3.f7946g);
            kVar3.c();
        }
        z zVar3 = kVar3.f7950l;
        if (zVar != zVar3) {
            ((ActionMenuView) zVar3).setPresenter(kVar3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) zVar3;
        this.f754g = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f754g, layoutParams);
    }

    public final void d() {
        if (this.f764r == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f764r = linearLayout;
            this.f765s = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f766t = (TextView) this.f764r.findViewById(R.id.action_bar_subtitle);
            int i = this.f767u;
            if (i != 0) {
                this.f765s.setTextAppearance(getContext(), i);
            }
            int i3 = this.f768v;
            if (i3 != 0) {
                this.f766t.setTextAppearance(getContext(), i3);
            }
        }
        this.f765s.setText(this.f759m);
        this.f766t.setText(this.f760n);
        boolean zIsEmpty = TextUtils.isEmpty(this.f759m);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f760n);
        this.f766t.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f764r.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f764r.getParent() == null) {
            addView(this.f764r);
        }
    }

    public final void e() {
        removeAllViews();
        this.f763q = null;
        this.f754g = null;
        this.f755h = null;
        View view = this.f762p;
        if (view != null) {
            view.setOnClickListener(null);
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
        return this.f756j != null ? this.f752c.f7865g : getVisibility();
    }

    public int getContentHeight() {
        return this.i;
    }

    public CharSequence getSubtitle() {
        return this.f760n;
    }

    public CharSequence getTitle() {
        return this.f759m;
    }

    @Override // android.view.View
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            o0 o0Var = this.f756j;
            if (o0Var != null) {
                o0Var.b();
            }
            super.setVisibility(i);
        }
    }

    public final o0 i(int i, long j10) {
        o0 o0Var = this.f756j;
        if (o0Var != null) {
            o0Var.b();
        }
        a aVar = this.f752c;
        if (i != 0) {
            o0 o0VarA = k0.a(this);
            o0VarA.a(0.0f);
            o0VarA.c(j10);
            ((ActionBarContextView) aVar.f7866h).f756j = o0VarA;
            aVar.f7865g = i;
            o0VarA.e(aVar);
            return o0VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        o0 o0VarA2 = k0.a(this);
        o0VarA2.a(1.0f);
        o0VarA2.c(j10);
        ((ActionBarContextView) aVar.f7866h).f756j = o0VarA2;
        aVar.f7865g = i;
        o0VarA2.e(aVar);
        return o0VarA2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, g.a.f4098a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        k kVar = this.f755h;
        if (kVar != null) {
            Configuration configuration2 = kVar.f7945f.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i3 = configuration2.screenHeightDp;
            kVar.f7958t = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i3 > 720) || (i > 720 && i3 > 960)) ? 5 : (i >= 500 || (i > 640 && i3 > 480) || (i > 480 && i3 > 640)) ? 4 : i >= 360 ? 3 : 2;
            l lVar = kVar.f7946g;
            if (lVar != null) {
                lVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k kVar = this.f755h;
        if (kVar != null) {
            kVar.f();
            g gVar = this.f755h.f7962x;
            if (gVar == null || !gVar.b()) {
                return;
            }
            gVar.i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f758l = false;
        }
        if (!this.f758l) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f758l = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f758l = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        boolean z11 = getLayoutDirection() == 1;
        int paddingRight = z11 ? (i10 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i11 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f761o;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f761o.getLayoutParams();
            int i12 = z11 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i13 = z11 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i14 = z11 ? paddingRight - i12 : paddingRight + i12;
            int iG = g(this.f761o, i14, paddingTop, paddingTop2, z11) + i14;
            paddingRight = z11 ? iG - i13 : iG + i13;
        }
        LinearLayout linearLayout = this.f764r;
        if (linearLayout != null && this.f763q == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(this.f764r, paddingRight, paddingTop, paddingTop2, z11);
        }
        View view2 = this.f763q;
        if (view2 != null) {
            g(view2, paddingRight, paddingTop, paddingTop2, z11);
        }
        int paddingLeft = z11 ? getPaddingLeft() : (i10 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f754g;
        if (actionMenuView != null) {
            g(actionMenuView, paddingLeft, paddingTop, paddingTop2, !z11);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            f.e(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
            return;
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            f.e(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.i;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f761o;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f761o.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f754g;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f754g, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f764r;
        if (linearLayout != null && this.f763q == null) {
            if (this.f769w) {
                this.f764r.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f764r.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f764r.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f763q;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i10 = layoutParams.width;
            int i11 = i10 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i10 >= 0) {
                paddingLeft = Math.min(i10, paddingLeft);
            }
            int i12 = layoutParams.height;
            int i13 = i12 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i12 >= 0) {
                iMin = Math.min(i12, iMin);
            }
            this.f763q.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i11), View.MeasureSpec.makeMeasureSpec(iMin, i13));
        }
        if (this.i > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            int measuredHeight = getChildAt(i15).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i14) {
                i14 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i14);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f757k = false;
        }
        if (!this.f757k) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f757k = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f757k = false;
        return true;
    }

    public void setContentHeight(int i) {
        this.i = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f763q;
        if (view2 != null) {
            removeView(view2);
        }
        this.f763q = view;
        if (view != null && (linearLayout = this.f764r) != null) {
            removeView(linearLayout);
            this.f764r = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f760n = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f759m = charSequence;
        d();
        k0.h(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f769w) {
            requestLayout();
        }
        this.f769w = z10;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }
}
