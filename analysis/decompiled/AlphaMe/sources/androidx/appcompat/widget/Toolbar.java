package androidx.appcompat.widget;

import K.C0082n;
import K.InterfaceC0078j;
import K.InterfaceC0084p;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AbstractC0175a;
import androidx.appcompat.app.ViewOnClickListenerC0177c;
import androidx.customview.view.AbsSavedState;
import com.stepos.alphame.R;
import e.EnumC0546d;
import g.AbstractC0560a;
import h.RunnableC0583a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k.C0661o;
import k.C0663q;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC0078j {

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f2967A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f2968B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f2969C;

    /* renamed from: D, reason: collision with root package name */
    public final ArrayList f2970D;

    /* renamed from: E, reason: collision with root package name */
    public final ArrayList f2971E;

    /* renamed from: F, reason: collision with root package name */
    public final int[] f2972F;

    /* renamed from: G, reason: collision with root package name */
    public final C0082n f2973G;

    /* renamed from: H, reason: collision with root package name */
    public ArrayList f2974H;

    /* renamed from: I, reason: collision with root package name */
    public final a1 f2975I;

    /* renamed from: J, reason: collision with root package name */
    public g1 f2976J;

    /* renamed from: K, reason: collision with root package name */
    public C0217o f2977K;

    /* renamed from: L, reason: collision with root package name */
    public c1 f2978L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f2979M;

    /* renamed from: N, reason: collision with root package name */
    public OnBackInvokedCallback f2980N;

    /* renamed from: O, reason: collision with root package name */
    public OnBackInvokedDispatcher f2981O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f2982P;

    /* renamed from: Q, reason: collision with root package name */
    public final RunnableC0583a f2983Q;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f2984a;

    /* renamed from: b, reason: collision with root package name */
    public C0200f0 f2985b;

    /* renamed from: c, reason: collision with root package name */
    public C0200f0 f2986c;

    /* renamed from: d, reason: collision with root package name */
    public E f2987d;

    /* renamed from: e, reason: collision with root package name */
    public G f2988e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f2989f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f2990g;

    /* renamed from: h, reason: collision with root package name */
    public E f2991h;

    /* renamed from: i, reason: collision with root package name */
    public View f2992i;

    /* renamed from: j, reason: collision with root package name */
    public Context f2993j;

    /* renamed from: k, reason: collision with root package name */
    public int f2994k;

    /* renamed from: l, reason: collision with root package name */
    public int f2995l;

    /* renamed from: m, reason: collision with root package name */
    public int f2996m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2997n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2998o;

    /* renamed from: p, reason: collision with root package name */
    public int f2999p;

    /* renamed from: q, reason: collision with root package name */
    public int f3000q;

    /* renamed from: r, reason: collision with root package name */
    public int f3001r;

    /* renamed from: s, reason: collision with root package name */
    public int f3002s;

    /* renamed from: t, reason: collision with root package name */
    public P0 f3003t;

    /* renamed from: u, reason: collision with root package name */
    public int f3004u;

    /* renamed from: v, reason: collision with root package name */
    public int f3005v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3006w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f3007x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f3008y;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f3009z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new f1();

        /* renamed from: a, reason: collision with root package name */
        public int f3010a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3011b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3010a = parcel.readInt();
            this.f3011b = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f3010a);
            parcel.writeInt(this.f3011b ? 1 : 0);
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static d1 g() {
        d1 d1Var = new d1(-2, -2);
        d1Var.f3077b = 0;
        d1Var.f2583a = 8388627;
        return d1Var;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i4 = 0; i4 < menu.size(); i4++) {
            arrayList.add(menu.getItem(i4));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new j.k(getContext());
    }

    public static d1 h(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d1) {
            d1 d1Var = (d1) layoutParams;
            d1 d1Var2 = new d1(d1Var);
            d1Var2.f3077b = 0;
            d1Var2.f3077b = d1Var.f3077b;
            return d1Var2;
        }
        if (layoutParams instanceof AbstractC0175a) {
            d1 d1Var3 = new d1((AbstractC0175a) layoutParams);
            d1Var3.f3077b = 0;
            return d1Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            d1 d1Var4 = new d1(layoutParams);
            d1Var4.f3077b = 0;
            return d1Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        d1 d1Var5 = new d1(marginLayoutParams);
        d1Var5.f3077b = 0;
        ((ViewGroup.MarginLayoutParams) d1Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) d1Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) d1Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) d1Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return d1Var5;
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i4, ArrayList arrayList) {
        boolean z4 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, getLayoutDirection());
        arrayList.clear();
        if (!z4) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                d1 d1Var = (d1) childAt.getLayoutParams();
                if (d1Var.f3077b == 0 && r(childAt)) {
                    int i6 = d1Var.f2583a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i6, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i7 = childCount - 1; i7 >= 0; i7--) {
            View childAt2 = getChildAt(i7);
            d1 d1Var2 = (d1) childAt2.getLayoutParams();
            if (d1Var2.f3077b == 0 && r(childAt2)) {
                int i8 = d1Var2.f2583a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i8, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // K.InterfaceC0078j
    public final void addMenuProvider(InterfaceC0084p interfaceC0084p) {
        C0082n c0082n = this.f2973G;
        c0082n.f991b.add(interfaceC0084p);
        c0082n.f990a.run();
    }

    public final void b(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        d1 d1VarG = layoutParams == null ? g() : !checkLayoutParams(layoutParams) ? h(layoutParams) : (d1) layoutParams;
        d1VarG.f3077b = 1;
        if (!z4 || this.f2992i == null) {
            addView(view, d1VarG);
        } else {
            view.setLayoutParams(d1VarG);
            this.f2971E.add(view);
        }
    }

    public final void c() {
        if (this.f2991h == null) {
            E e4 = new E(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f2991h = e4;
            e4.setImageDrawable(this.f2989f);
            this.f2991h.setContentDescription(this.f2990g);
            d1 d1VarG = g();
            d1VarG.f2583a = (this.f2997n & 112) | 8388611;
            d1VarG.f3077b = 2;
            this.f2991h.setLayoutParams(d1VarG);
            this.f2991h.setOnClickListener(new ViewOnClickListenerC0177c(1, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof d1);
    }

    public final void d() {
        e();
        ActionMenuView actionMenuView = this.f2984a;
        if (actionMenuView.f2787p == null) {
            C0661o c0661o = (C0661o) actionMenuView.getMenu();
            if (this.f2978L == null) {
                this.f2978L = new c1(this);
            }
            this.f2984a.setExpandedActionViewsExclusive(true);
            c0661o.b(this.f2978L, this.f2993j);
            s();
        }
    }

    public final void e() {
        if (this.f2984a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f2984a = actionMenuView;
            actionMenuView.setPopupTheme(this.f2994k);
            this.f2984a.setOnMenuItemClickListener(this.f2975I);
            ActionMenuView actionMenuView2 = this.f2984a;
            a1 a1Var = new a1(this);
            actionMenuView2.f2792u = null;
            actionMenuView2.f2793v = a1Var;
            d1 d1VarG = g();
            d1VarG.f2583a = (this.f2997n & 112) | 8388613;
            this.f2984a.setLayoutParams(d1VarG);
            b(this.f2984a, false);
        }
    }

    public final void f() {
        if (this.f2987d == null) {
            this.f2987d = new E(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            d1 d1VarG = g();
            d1VarG.f2583a = (this.f2997n & 112) | 8388611;
            this.f2987d.setLayoutParams(d1VarG);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return h(layoutParams);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        E e4 = this.f2991h;
        if (e4 != null) {
            return e4.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        E e4 = this.f2991h;
        if (e4 != null) {
            return e4.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        P0 p02 = this.f3003t;
        if (p02 == null) {
            return 0;
        }
        switch (p02.f2898a) {
            case 0:
                return p02.f2905h ? p02.f2899b : p02.f2900c;
            default:
                return p02.f2905h ? p02.f2899b : p02.f2900c;
        }
    }

    public int getContentInsetEndWithActions() {
        int i4 = this.f3005v;
        return i4 != Integer.MIN_VALUE ? i4 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        P0 p02 = this.f3003t;
        if (p02 == null) {
            return 0;
        }
        switch (p02.f2898a) {
        }
        return p02.f2899b;
    }

    public int getContentInsetRight() {
        P0 p02 = this.f3003t;
        if (p02 == null) {
            return 0;
        }
        switch (p02.f2898a) {
        }
        return p02.f2900c;
    }

    public int getContentInsetStart() {
        P0 p02 = this.f3003t;
        if (p02 == null) {
            return 0;
        }
        switch (p02.f2898a) {
            case 0:
                return p02.f2905h ? p02.f2900c : p02.f2899b;
            default:
                return p02.f2905h ? p02.f2900c : p02.f2899b;
        }
    }

    public int getContentInsetStartWithNavigation() {
        int i4 = this.f3004u;
        return i4 != Integer.MIN_VALUE ? i4 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        C0661o c0661o;
        ActionMenuView actionMenuView = this.f2984a;
        return (actionMenuView == null || (c0661o = actionMenuView.f2787p) == null || !c0661o.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f3005v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f3004u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        G g4 = this.f2988e;
        if (g4 != null) {
            return g4.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        G g4 = this.f2988e;
        if (g4 != null) {
            return g4.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        d();
        return this.f2984a.getMenu();
    }

    @Nullable
    @VisibleForTesting
    public View getNavButtonView() {
        return this.f2987d;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        E e4 = this.f2987d;
        if (e4 != null) {
            return e4.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        E e4 = this.f2987d;
        if (e4 != null) {
            return e4.getDrawable();
        }
        return null;
    }

    public C0217o getOuterActionMenuPresenter() {
        return this.f2977K;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        d();
        return this.f2984a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f2993j;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.f2994k;
    }

    public CharSequence getSubtitle() {
        return this.f3008y;
    }

    @Nullable
    @VisibleForTesting
    public final TextView getSubtitleTextView() {
        return this.f2986c;
    }

    public CharSequence getTitle() {
        return this.f3007x;
    }

    public int getTitleMarginBottom() {
        return this.f3002s;
    }

    public int getTitleMarginEnd() {
        return this.f3000q;
    }

    public int getTitleMarginStart() {
        return this.f2999p;
    }

    public int getTitleMarginTop() {
        return this.f3001r;
    }

    @Nullable
    @VisibleForTesting
    public final TextView getTitleTextView() {
        return this.f2985b;
    }

    @RestrictTo({EnumC0546d.f12494c})
    public InterfaceC0216n0 getWrapper() {
        Drawable drawable;
        if (this.f2976J == null) {
            g1 g1Var = new g1();
            g1Var.f3100n = 0;
            g1Var.f3087a = this;
            g1Var.f3094h = getTitle();
            g1Var.f3095i = getSubtitle();
            g1Var.f3093g = g1Var.f3094h != null;
            g1Var.f3092f = getNavigationIcon();
            android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(R.attr.actionBarStyle, 0, getContext(), null, AbstractC0560a.f12588a);
            g1Var.f3101o = cVarY.l(15);
            CharSequence charSequenceU = cVarY.u(27);
            if (!TextUtils.isEmpty(charSequenceU)) {
                g1Var.f3093g = true;
                g1Var.f3094h = charSequenceU;
                if ((g1Var.f3088b & 8) != 0) {
                    Toolbar toolbar = g1Var.f3087a;
                    toolbar.setTitle(charSequenceU);
                    if (g1Var.f3093g) {
                        K.S.i(toolbar.getRootView(), charSequenceU);
                    }
                }
            }
            CharSequence charSequenceU2 = cVarY.u(25);
            if (!TextUtils.isEmpty(charSequenceU2)) {
                g1Var.f3095i = charSequenceU2;
                if ((g1Var.f3088b & 8) != 0) {
                    setSubtitle(charSequenceU2);
                }
            }
            Drawable drawableL = cVarY.l(20);
            if (drawableL != null) {
                g1Var.f3091e = drawableL;
                g1Var.d();
            }
            Drawable drawableL2 = cVarY.l(17);
            if (drawableL2 != null) {
                g1Var.f3090d = drawableL2;
                g1Var.d();
            }
            if (g1Var.f3092f == null && (drawable = g1Var.f3101o) != null) {
                g1Var.f3092f = drawable;
                int i4 = g1Var.f3088b & 4;
                Toolbar toolbar2 = g1Var.f3087a;
                if (i4 != 0) {
                    toolbar2.setNavigationIcon(drawable);
                } else {
                    toolbar2.setNavigationIcon((Drawable) null);
                }
            }
            g1Var.a(cVarY.p(10, 0));
            int iR = cVarY.r(9, 0);
            if (iR != 0) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(iR, (ViewGroup) this, false);
                View view = g1Var.f3089c;
                if (view != null && (g1Var.f3088b & 16) != 0) {
                    removeView(view);
                }
                g1Var.f3089c = viewInflate;
                if (viewInflate != null && (g1Var.f3088b & 16) != 0) {
                    addView(viewInflate);
                }
                g1Var.a(g1Var.f3088b | 16);
            }
            int layoutDimension = ((TypedArray) cVarY.f2365c).getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int i5 = cVarY.i(7, -1);
            int i6 = cVarY.i(3, -1);
            if (i5 >= 0 || i6 >= 0) {
                int iMax = Math.max(i5, 0);
                int iMax2 = Math.max(i6, 0);
                if (this.f3003t == null) {
                    this.f3003t = new P0(0);
                }
                this.f3003t.c(iMax, iMax2);
            }
            int iR2 = cVarY.r(28, 0);
            if (iR2 != 0) {
                Context context = getContext();
                this.f2995l = iR2;
                C0200f0 c0200f0 = this.f2985b;
                if (c0200f0 != null) {
                    c0200f0.setTextAppearance(context, iR2);
                }
            }
            int iR3 = cVarY.r(26, 0);
            if (iR3 != 0) {
                Context context2 = getContext();
                this.f2996m = iR3;
                C0200f0 c0200f02 = this.f2986c;
                if (c0200f02 != null) {
                    c0200f02.setTextAppearance(context2, iR3);
                }
            }
            int iR4 = cVarY.r(22, 0);
            if (iR4 != 0) {
                setPopupTheme(iR4);
            }
            cVarY.A();
            if (R.string.abc_action_bar_up_description != g1Var.f3100n) {
                g1Var.f3100n = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i7 = g1Var.f3100n;
                    g1Var.f3096j = i7 != 0 ? getContext().getString(i7) : null;
                    g1Var.c();
                }
            }
            g1Var.f3096j = getNavigationContentDescription();
            setNavigationOnClickListener(new ViewOnClickListenerC0193c(g1Var));
            this.f2976J = g1Var;
        }
        return this.f2976J;
    }

    public final int i(int i4, View view) {
        d1 d1Var = (d1) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i4 > 0 ? (measuredHeight - i4) / 2 : 0;
        int i6 = d1Var.f2583a & 112;
        if (i6 != 16 && i6 != 48 && i6 != 80) {
            i6 = this.f3006w & 112;
        }
        if (i6 == 48) {
            return getPaddingTop() - i5;
        }
        if (i6 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) d1Var).bottomMargin) - i5;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i7 = ((ViewGroup.MarginLayoutParams) d1Var).topMargin;
        if (iMax < i7) {
            iMax = i7;
        } else {
            int i8 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i9 = ((ViewGroup.MarginLayoutParams) d1Var).bottomMargin;
            if (i8 < i9) {
                iMax = Math.max(0, iMax - (i9 - i8));
            }
        }
        return paddingTop + iMax;
    }

    public final void l() {
        Iterator it = this.f2974H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it2 = this.f2973G.f991b.iterator();
        while (it2.hasNext()) {
            ((androidx.fragment.app.S) ((InterfaceC0084p) it2.next())).f3641a.j(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f2974H = currentMenuItems2;
    }

    public final boolean m(View view) {
        return view.getParent() == this || this.f2971E.contains(view);
    }

    public final int n(View view, int i4, int i5, int[] iArr) {
        d1 d1Var = (d1) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) d1Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i6) + i4;
        iArr[0] = Math.max(0, -i6);
        int i7 = i(i5, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, i7, iMax + measuredWidth, view.getMeasuredHeight() + i7);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) d1Var).rightMargin + iMax;
    }

    public final int o(View view, int i4, int i5, int[] iArr) {
        d1 d1Var = (d1) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) d1Var).rightMargin - iArr[1];
        int iMax = i4 - Math.max(0, i6);
        iArr[1] = Math.max(0, -i6);
        int i7 = i(i5, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, i7, iMax, view.getMeasuredHeight() + i7);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) d1Var).leftMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2983Q);
        s();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2969C = false;
        }
        if (!this.f2969C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2969C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2969C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0293 A[LOOP:0: B:104:0x0291->B:105:0x0293, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02af A[LOOP:1: B:107:0x02ad->B:108:0x02af, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02cf A[LOOP:2: B:110:0x02cd->B:111:0x02cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x031d A[LOOP:3: B:119:0x031b->B:120:0x031d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        char c4;
        char c5;
        int iJ;
        int iMax;
        int iCombineMeasuredStates;
        int iJ2;
        int iK;
        int iCombineMeasuredStates2;
        int iMax2;
        int i6 = 0;
        if (getLayoutDirection() == 1) {
            c5 = 1;
            c4 = 0;
        } else {
            c4 = 1;
            c5 = 0;
        }
        if (r(this.f2987d)) {
            q(this.f2987d, i4, 0, i5, this.f2998o);
            iJ = j(this.f2987d) + this.f2987d.getMeasuredWidth();
            iMax = Math.max(0, k(this.f2987d) + this.f2987d.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2987d.getMeasuredState());
        } else {
            iJ = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (r(this.f2991h)) {
            q(this.f2991h, i4, 0, i5, this.f2998o);
            iJ = j(this.f2991h) + this.f2991h.getMeasuredWidth();
            iMax = Math.max(iMax, k(this.f2991h) + this.f2991h.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2991h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iJ);
        int iMax4 = Math.max(0, currentContentInsetStart - iJ);
        int[] iArr = this.f2972F;
        iArr[c5] = iMax4;
        if (r(this.f2984a)) {
            q(this.f2984a, i4, iMax3, i5, this.f2998o);
            iJ2 = j(this.f2984a) + this.f2984a.getMeasuredWidth();
            iMax = Math.max(iMax, k(this.f2984a) + this.f2984a.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2984a.getMeasuredState());
        } else {
            iJ2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iJ2);
        iArr[c4] = Math.max(0, currentContentInsetEnd - iJ2);
        if (r(this.f2992i)) {
            iMax5 += p(this.f2992i, i4, iMax5, i5, 0, iArr);
            iMax = Math.max(iMax, k(this.f2992i) + this.f2992i.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2992i.getMeasuredState());
        }
        if (r(this.f2988e)) {
            iMax5 += p(this.f2988e, i4, iMax5, i5, 0, iArr);
            iMax = Math.max(iMax, k(this.f2988e) + this.f2988e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2988e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (((d1) childAt.getLayoutParams()).f3077b == 0 && r(childAt)) {
                iMax5 += p(childAt, i4, iMax5, i5, 0, iArr);
                iMax = Math.max(iMax, k(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i8 = this.f3001r + this.f3002s;
        int i9 = this.f2999p + this.f3000q;
        if (r(this.f2985b)) {
            p(this.f2985b, i4, iMax5 + i9, i5, i8, iArr);
            int iJ3 = j(this.f2985b) + this.f2985b.getMeasuredWidth();
            iK = k(this.f2985b) + this.f2985b.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2985b.getMeasuredState());
            iMax2 = iJ3;
        } else {
            iK = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (r(this.f2986c)) {
            iMax2 = Math.max(iMax2, p(this.f2986c, i4, iMax5 + i9, i5, iK + i8, iArr));
            iK += k(this.f2986c) + this.f2986c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f2986c.getMeasuredState());
        }
        int iMax6 = Math.max(iMax, iK);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax6;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax5 + iMax2, getSuggestedMinimumWidth()), i4, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i5, iCombineMeasuredStates2 << 16);
        if (!this.f2979M) {
            i6 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            View childAt2 = getChildAt(i10);
            if (r(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i6 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i6);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f2984a;
        C0661o c0661o = actionMenuView != null ? actionMenuView.f2787p : null;
        int i4 = savedState.f3010a;
        if (i4 != 0 && this.f2978L != null && c0661o != null && (menuItemFindItem = c0661o.findItem(i4)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f3011b) {
            RunnableC0583a runnableC0583a = this.f2983Q;
            removeCallbacks(runnableC0583a);
            post(runnableC0583a);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        if (this.f3003t == null) {
            this.f3003t = new P0(0);
        }
        this.f3003t.b(i4 == 1);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C0217o c0217o;
        C0663q c0663q;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        c1 c1Var = this.f2978L;
        if (c1Var != null && (c0663q = c1Var.f3072b) != null) {
            savedState.f3010a = c0663q.f13269a;
        }
        ActionMenuView actionMenuView = this.f2984a;
        savedState.f3011b = (actionMenuView == null || (c0217o = actionMenuView.f2791t) == null || !c0217o.i()) ? false : true;
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2968B = false;
        }
        if (!this.f2968B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2968B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2968B = false;
        }
        return true;
    }

    public final int p(View view, int i4, int i5, int i6, int i7, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i8 = marginLayoutParams.leftMargin - iArr[0];
        int i9 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i9) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i8);
        iArr[1] = Math.max(0, -i9);
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + iMax + i5, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void q(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // K.InterfaceC0078j
    public final void removeMenuProvider(InterfaceC0084p interfaceC0084p) {
        this.f2973G.b(interfaceC0084p);
    }

    public final void s() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedDispatcher onBackInvokedDispatcherA = b1.a(this);
        c1 c1Var = this.f2978L;
        int i4 = 0;
        boolean z4 = (c1Var != null && c1Var.f3072b != null) && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.f2982P;
        if (z4 && this.f2981O == null) {
            if (this.f2980N == null) {
                this.f2980N = b1.b(new Z0(this, i4));
            }
            b1.c(onBackInvokedDispatcherA, this.f2980N);
            this.f2981O = onBackInvokedDispatcherA;
            return;
        }
        if (z4 || (onBackInvokedDispatcher = this.f2981O) == null) {
            return;
        }
        b1.d(onBackInvokedDispatcher, this.f2980N);
        this.f2981O = null;
    }

    public void setBackInvokedCallbackEnabled(boolean z4) {
        if (this.f2982P != z4) {
            this.f2982P = z4;
            s();
        }
    }

    public void setCollapseContentDescription(@StringRes int i4) {
        setCollapseContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setCollapseIcon(@DrawableRes int i4) {
        setCollapseIcon(Z2.I.o(getContext(), i4));
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setCollapsible(boolean z4) {
        this.f2979M = z4;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i4) {
        if (i4 < 0) {
            i4 = Integer.MIN_VALUE;
        }
        if (i4 != this.f3005v) {
            this.f3005v = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i4) {
        if (i4 < 0) {
            i4 = Integer.MIN_VALUE;
        }
        if (i4 != this.f3004u) {
            this.f3004u = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(@DrawableRes int i4) {
        setLogo(Z2.I.o(getContext(), i4));
    }

    public void setLogoDescription(@StringRes int i4) {
        setLogoDescription(getContext().getText(i4));
    }

    public void setNavigationContentDescription(@StringRes int i4) {
        setNavigationContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setNavigationIcon(@DrawableRes int i4) {
        setNavigationIcon(Z2.I.o(getContext(), i4));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        f();
        this.f2987d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(e1 e1Var) {
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        d();
        this.f2984a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i4) {
        if (this.f2994k != i4) {
            this.f2994k = i4;
            if (i4 == 0) {
                this.f2993j = getContext();
            } else {
                this.f2993j = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setSubtitle(@StringRes int i4) {
        setSubtitle(getContext().getText(i4));
    }

    public void setSubtitleTextColor(@ColorInt int i4) {
        setSubtitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setTitle(@StringRes int i4) {
        setTitle(getContext().getText(i4));
    }

    public void setTitleMarginBottom(int i4) {
        this.f3002s = i4;
        requestLayout();
    }

    public void setTitleMarginEnd(int i4) {
        this.f3000q = i4;
        requestLayout();
    }

    public void setTitleMarginStart(int i4) {
        this.f2999p = i4;
        requestLayout();
    }

    public void setTitleMarginTop(int i4) {
        this.f3001r = i4;
        requestLayout();
    }

    public void setTitleTextColor(@ColorInt int i4) {
        setTitleTextColor(ColorStateList.valueOf(i4));
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f3006w = 8388627;
        this.f2970D = new ArrayList();
        this.f2971E = new ArrayList();
        this.f2972F = new int[2];
        this.f2973G = new C0082n(new Z0(this, 1));
        this.f2974H = new ArrayList();
        this.f2975I = new a1(this);
        this.f2983Q = new RunnableC0583a(3, this);
        Context context2 = getContext();
        int[] iArr = AbstractC0560a.f12611x;
        android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(R.attr.toolbarStyle, 0, context2, attributeSet, iArr);
        TypedArray typedArray = (TypedArray) cVarY.f2365c;
        WeakHashMap weakHashMap = K.S.f939a;
        K.O.d(this, context, iArr, attributeSet, typedArray, R.attr.toolbarStyle, 0);
        this.f2995l = cVarY.r(31, 0);
        this.f2996m = cVarY.r(22, 0);
        this.f3006w = ((TypedArray) cVarY.f2365c).getInteger(0, 8388627);
        this.f2997n = ((TypedArray) cVarY.f2365c).getInteger(2, 48);
        int i5 = cVarY.i(25, 0);
        i5 = cVarY.v(30) ? cVarY.i(30, i5) : i5;
        this.f3002s = i5;
        this.f3001r = i5;
        this.f3000q = i5;
        this.f2999p = i5;
        int i6 = cVarY.i(28, -1);
        if (i6 >= 0) {
            this.f2999p = i6;
        }
        int i7 = cVarY.i(27, -1);
        if (i7 >= 0) {
            this.f3000q = i7;
        }
        int i8 = cVarY.i(29, -1);
        if (i8 >= 0) {
            this.f3001r = i8;
        }
        int i9 = cVarY.i(26, -1);
        if (i9 >= 0) {
            this.f3002s = i9;
        }
        this.f2998o = cVarY.j(13, -1);
        int i10 = cVarY.i(9, Integer.MIN_VALUE);
        int i11 = cVarY.i(5, Integer.MIN_VALUE);
        int iJ = cVarY.j(7, 0);
        int iJ2 = cVarY.j(8, 0);
        if (this.f3003t == null) {
            this.f3003t = new P0(0);
        }
        this.f3003t.a(iJ, iJ2);
        if (i10 != Integer.MIN_VALUE || i11 != Integer.MIN_VALUE) {
            this.f3003t.c(i10, i11);
        }
        this.f3004u = cVarY.i(10, Integer.MIN_VALUE);
        this.f3005v = cVarY.i(6, Integer.MIN_VALUE);
        this.f2989f = cVarY.l(4);
        this.f2990g = cVarY.u(3);
        CharSequence charSequenceU = cVarY.u(24);
        if (!TextUtils.isEmpty(charSequenceU)) {
            setTitle(charSequenceU);
        }
        CharSequence charSequenceU2 = cVarY.u(21);
        if (!TextUtils.isEmpty(charSequenceU2)) {
            setSubtitle(charSequenceU2);
        }
        this.f2993j = getContext();
        setPopupTheme(cVarY.r(17, 0));
        Drawable drawableL = cVarY.l(16);
        if (drawableL != null) {
            setNavigationIcon(drawableL);
        }
        CharSequence charSequenceU3 = cVarY.u(15);
        if (!TextUtils.isEmpty(charSequenceU3)) {
            setNavigationContentDescription(charSequenceU3);
        }
        Drawable drawableL2 = cVarY.l(11);
        if (drawableL2 != null) {
            setLogo(drawableL2);
        }
        CharSequence charSequenceU4 = cVarY.u(12);
        if (!TextUtils.isEmpty(charSequenceU4)) {
            setLogoDescription(charSequenceU4);
        }
        if (cVarY.v(32)) {
            setTitleTextColor(cVarY.h(32));
        }
        if (cVarY.v(23)) {
            setSubtitleTextColor(cVarY.h(23));
        }
        if (cVarY.v(14)) {
            getMenuInflater().inflate(cVarY.r(14, 0), getMenu());
        }
        cVarY.A();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d1 d1Var = new d1(context, attributeSet);
        d1Var.f2583a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12589b);
        d1Var.f2583a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        d1Var.f3077b = 0;
        return d1Var;
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        E e4 = this.f2991h;
        if (e4 != null) {
            e4.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            c();
            this.f2991h.setImageDrawable(drawable);
        } else {
            E e4 = this.f2991h;
            if (e4 != null) {
                e4.setImageDrawable(this.f2989f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f2988e == null) {
                this.f2988e = new G(getContext());
            }
            if (!m(this.f2988e)) {
                b(this.f2988e, true);
            }
        } else {
            G g4 = this.f2988e;
            if (g4 != null && m(g4)) {
                removeView(this.f2988e);
                this.f2971E.remove(this.f2988e);
            }
        }
        G g5 = this.f2988e;
        if (g5 != null) {
            g5.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f2988e == null) {
            this.f2988e = new G(getContext());
        }
        G g4 = this.f2988e;
        if (g4 != null) {
            g4.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        E e4 = this.f2987d;
        if (e4 != null) {
            e4.setContentDescription(charSequence);
            h1.a(this.f2987d, charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            f();
            if (!m(this.f2987d)) {
                b(this.f2987d, true);
            }
        } else {
            E e4 = this.f2987d;
            if (e4 != null && m(e4)) {
                removeView(this.f2987d);
                this.f2971E.remove(this.f2987d);
            }
        }
        E e5 = this.f2987d;
        if (e5 != null) {
            e5.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            C0200f0 c0200f0 = this.f2986c;
            if (c0200f0 != null && m(c0200f0)) {
                removeView(this.f2986c);
                this.f2971E.remove(this.f2986c);
            }
        } else {
            if (this.f2986c == null) {
                Context context = getContext();
                C0200f0 c0200f02 = new C0200f0(context, null);
                this.f2986c = c0200f02;
                c0200f02.setSingleLine();
                this.f2986c.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f2996m;
                if (i4 != 0) {
                    this.f2986c.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.f2967A;
                if (colorStateList != null) {
                    this.f2986c.setTextColor(colorStateList);
                }
            }
            if (!m(this.f2986c)) {
                b(this.f2986c, true);
            }
        }
        C0200f0 c0200f03 = this.f2986c;
        if (c0200f03 != null) {
            c0200f03.setText(charSequence);
        }
        this.f3008y = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f2967A = colorStateList;
        C0200f0 c0200f0 = this.f2986c;
        if (c0200f0 != null) {
            c0200f0.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            C0200f0 c0200f0 = this.f2985b;
            if (c0200f0 != null && m(c0200f0)) {
                removeView(this.f2985b);
                this.f2971E.remove(this.f2985b);
            }
        } else {
            if (this.f2985b == null) {
                Context context = getContext();
                C0200f0 c0200f02 = new C0200f0(context, null);
                this.f2985b = c0200f02;
                c0200f02.setSingleLine();
                this.f2985b.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f2995l;
                if (i4 != 0) {
                    this.f2985b.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.f3009z;
                if (colorStateList != null) {
                    this.f2985b.setTextColor(colorStateList);
                }
            }
            if (!m(this.f2985b)) {
                b(this.f2985b, true);
            }
        }
        C0200f0 c0200f03 = this.f2985b;
        if (c0200f03 != null) {
            c0200f03.setText(charSequence);
        }
        this.f3007x = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f3009z = colorStateList;
        C0200f0 c0200f0 = this.f2985b;
        if (c0200f0 != null) {
            c0200f0.setTextColor(colorStateList);
        }
    }
}
