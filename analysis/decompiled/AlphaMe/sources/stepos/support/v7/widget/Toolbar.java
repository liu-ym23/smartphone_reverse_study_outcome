package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.C0189a;
import androidx.appcompat.widget.P0;
import com.stepos.alphame.R;
import g.AbstractC0560a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.app.AbstractC0858c;
import stepos.support.v7.app.C0872q;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f14991A;

    /* renamed from: B, reason: collision with root package name */
    public int f14992B;

    /* renamed from: C, reason: collision with root package name */
    public int f14993C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f14994D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f14995E;

    /* renamed from: F, reason: collision with root package name */
    public final ArrayList f14996F;

    /* renamed from: G, reason: collision with root package name */
    public final ArrayList f14997G;

    /* renamed from: H, reason: collision with root package name */
    public final int[] f14998H;

    /* renamed from: I, reason: collision with root package name */
    public t0 f14999I;

    /* renamed from: J, reason: collision with root package name */
    public final C0872q f15000J;

    /* renamed from: K, reason: collision with root package name */
    public w0 f15001K;

    /* renamed from: L, reason: collision with root package name */
    public C0897q f15002L;

    /* renamed from: M, reason: collision with root package name */
    public r0 f15003M;

    /* renamed from: N, reason: collision with root package name */
    public L3.v f15004N;

    /* renamed from: O, reason: collision with root package name */
    public L3.i f15005O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f15006P;

    /* renamed from: Q, reason: collision with root package name */
    public final J3.a f15007Q;

    /* renamed from: R, reason: collision with root package name */
    public final androidx.appcompat.widget.A f15008R;

    /* renamed from: S, reason: collision with root package name */
    public ActionMenuView f15009S;
    public boolean T;

    /* renamed from: U, reason: collision with root package name */
    public final com.stepos.common.animator.m f15010U;

    /* renamed from: V, reason: collision with root package name */
    public ViewGroup f15011V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f15012W;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f15013a;

    /* renamed from: b, reason: collision with root package name */
    public HorizontalScrollView f15014b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f15015c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f15016d;

    /* renamed from: e, reason: collision with root package name */
    public ImageButton f15017e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f15018f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f15019g;

    /* renamed from: h, reason: collision with root package name */
    public final CharSequence f15020h;

    /* renamed from: i, reason: collision with root package name */
    public ImageButton f15021i;

    /* renamed from: j, reason: collision with root package name */
    public View f15022j;

    /* renamed from: k, reason: collision with root package name */
    public Context f15023k;

    /* renamed from: k0, reason: collision with root package name */
    public View f15024k0;

    /* renamed from: l, reason: collision with root package name */
    public int f15025l;

    /* renamed from: l0, reason: collision with root package name */
    public final C0189a f15026l0;

    /* renamed from: m, reason: collision with root package name */
    public int f15027m;

    /* renamed from: n, reason: collision with root package name */
    public final int f15028n;

    /* renamed from: o, reason: collision with root package name */
    public int f15029o;

    /* renamed from: p, reason: collision with root package name */
    public final int f15030p;

    /* renamed from: q, reason: collision with root package name */
    public final int f15031q;

    /* renamed from: r, reason: collision with root package name */
    public int f15032r;

    /* renamed from: s, reason: collision with root package name */
    public final int f15033s;

    /* renamed from: t, reason: collision with root package name */
    public final int f15034t;

    /* renamed from: u, reason: collision with root package name */
    public final int f15035u;

    /* renamed from: v, reason: collision with root package name */
    public final int f15036v;

    /* renamed from: w, reason: collision with root package name */
    public final int f15037w;

    /* renamed from: x, reason: collision with root package name */
    public final P0 f15038x;

    /* renamed from: y, reason: collision with root package name */
    public final int f15039y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f15040z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new u0();

        /* renamed from: a, reason: collision with root package name */
        public int f15041a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f15042b;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f15041a);
            parcel.writeInt(this.f15042b ? 1 : 0);
        }
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposToolbarStyleFullScreen);
        P0 p02 = new P0(1);
        this.f15038x = p02;
        this.f15039y = 8388627;
        this.f14996F = new ArrayList();
        this.f14997G = new ArrayList();
        this.f14998H = new int[2];
        this.f15000J = new C0872q(10, this);
        this.f15007Q = new J3.a(4, this);
        this.f15010U = new com.stepos.common.animator.m();
        this.f15026l0 = new C0189a(this, 5);
        android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(R.attr.steposToolbarStyleFullScreen, 0, getContext(), attributeSet, AbstractC0560a.f12611x);
        this.f15027m = cVarY.r(31, 0);
        this.f15028n = cVarY.r(20, 0);
        this.f15029o = cVarY.r(22, 0);
        this.f15039y = ((TypedArray) cVarY.f2365c).getInteger(0, 8388627);
        this.f15030p = ((TypedArray) cVarY.f2365c).getInteger(18, 48);
        int i4 = cVarY.i(30, 0);
        this.f15037w = i4;
        this.f15036v = i4;
        this.f15035u = i4;
        this.f15033s = i4;
        int i5 = cVarY.i(28, -1);
        if (i5 >= 0) {
            this.f15033s = i5;
        }
        int i6 = cVarY.i(27, -1);
        if (i6 >= 0) {
            this.f15035u = i6;
        }
        int i7 = cVarY.i(29, -1);
        if (i7 >= 0) {
            this.f15036v = i7;
        }
        int i8 = cVarY.i(26, -1);
        if (i8 >= 0) {
            this.f15037w = i8;
        }
        this.f15031q = cVarY.j(13, -1);
        int i9 = cVarY.i(9, Integer.MIN_VALUE);
        int i10 = cVarY.i(5, Integer.MIN_VALUE);
        p02.a(cVarY.j(7, 0), cVarY.j(8, 0));
        if (i9 != Integer.MIN_VALUE || i10 != Integer.MIN_VALUE) {
            p02.c(i9, i10);
        }
        this.f15019g = cVarY.l(4);
        this.f15020h = cVarY.u(3);
        CharSequence charSequenceU = cVarY.u(24);
        if (!TextUtils.isEmpty(charSequenceU)) {
            setTitle(charSequenceU);
        }
        CharSequence charSequenceU2 = cVarY.u(21);
        if (!TextUtils.isEmpty(charSequenceU2)) {
            setSubtitle(charSequenceU2);
        }
        this.f15023k = getContext();
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
            setTitleTextColor(((TypedArray) cVarY.f2365c).getColor(32, -1));
        }
        if (cVarY.v(23)) {
            setSubtitleTextColor(((TypedArray) cVarY.f2365c).getColor(23, -1));
        }
        this.f15034t = cVarY.j(19, this.f15032r);
        this.f15032r = this.f15033s;
        cVarY.A();
        this.f15008R = androidx.appcompat.widget.A.a();
    }

    public static s0 f() {
        s0 s0Var = new s0(-2, -2);
        s0Var.f15147b = 0;
        s0Var.f14437a = 8388627;
        return s0Var;
    }

    public static s0 g(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof s0) {
            s0 s0Var = (s0) layoutParams;
            s0 s0Var2 = new s0(s0Var);
            s0Var2.f15147b = 0;
            s0Var2.f15147b = s0Var.f15147b;
            return s0Var2;
        }
        if (layoutParams instanceof AbstractC0858c) {
            s0 s0Var3 = new s0((AbstractC0858c) layoutParams);
            s0Var3.f15147b = 0;
            return s0Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            s0 s0Var4 = new s0(layoutParams);
            s0Var4.f15147b = 0;
            return s0Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        s0 s0Var5 = new s0(marginLayoutParams);
        s0Var5.f15147b = 0;
        ((ViewGroup.MarginLayoutParams) s0Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) s0Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) s0Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) s0Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return s0Var5;
    }

    private MenuInflater getMenuInflater() {
        return new K3.k(getContext());
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static boolean l(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof Button) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && l((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i4, ArrayList arrayList) {
        WeakHashMap weakHashMap = K.S.f939a;
        boolean z4 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, getLayoutDirection());
        arrayList.clear();
        if (!z4) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                s0 s0Var = (s0) childAt.getLayoutParams();
                if (s0Var.f15147b == 0 && s(childAt) && h(s0Var.f14437a) == absoluteGravity) {
                    arrayList.add(childAt);
                }
            }
            return;
        }
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            s0 s0Var2 = (s0) childAt2.getLayoutParams();
            if (s0Var2.f15147b == 0 && s(childAt2) && h(s0Var2.f14437a) == absoluteGravity) {
                arrayList.add(childAt2);
            }
        }
    }

    public final void b(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        s0 s0VarF = layoutParams == null ? f() : !checkLayoutParams(layoutParams) ? g(layoutParams) : (s0) layoutParams;
        s0VarF.f15147b = 1;
        if (!z4 || this.f15022j == null) {
            addView(view, s0VarF);
        } else {
            view.setLayoutParams(s0VarF);
            this.f14997G.add(view);
        }
    }

    public final void c() {
        d();
        ActionMenuView actionMenuView = this.f15013a;
        if (actionMenuView.f14798p == null) {
            L3.k kVar = (L3.k) actionMenuView.getMenu();
            if (this.f15003M == null) {
                this.f15003M = new r0(this);
            }
            this.f15013a.setExpandedActionViewsExclusive(true);
            kVar.b(this.f15003M, this.f15023k);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof s0);
    }

    public final void d() {
        if (this.f15013a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f15013a = actionMenuView;
            actionMenuView.setPopupTheme(this.f15025l);
            this.f15013a.setOnMenuItemClickListener(this.f15000J);
            ActionMenuView actionMenuView2 = this.f15013a;
            L3.v vVar = this.f15004N;
            L3.i iVar = this.f15005O;
            actionMenuView2.f14803u = vVar;
            actionMenuView2.f14804v = iVar;
            s0 s0VarF = f();
            s0VarF.f14437a = (this.f15030p & 112) | 8388613;
            this.f15013a.setLayoutParams(s0VarF);
            this.f15013a.setId(R.id.stepos_action_menu_view);
            if (!this.f15012W) {
                b(this.f15013a, false);
            } else {
                ((ViewGroup.MarginLayoutParams) s0VarF).width = -1;
                this.f15011V.addView(this.f15013a, 0, s0VarF);
            }
        }
    }

    public final void e() {
        if (this.f15017e == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f15017e = imageButton;
            this.f15010U.b(imageButton, 5, false);
            s0 s0VarF = f();
            s0VarF.f14437a = (this.f15030p & 112) | 8388611;
            this.f15017e.setLayoutParams(s0VarF);
            ImageButton imageButton2 = this.f15017e;
            Resources resources = getResources();
            ThreadLocal threadLocal = C.o.f272a;
            imageButton2.setImageDrawable(C.j.a(resources, R.drawable.stepos_titlebar_ic_back_dark, null));
            this.f15017e.setLayoutDirection(3);
            this.f15017e.setId(R.id.stepos_toolbar_nav_button);
            this.f15017e.addOnLayoutChangeListener(new com.google.android.material.bottomappbar.a(2, this));
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return f();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return g(layoutParams);
    }

    public int getContentInsetEnd() {
        P0 p02 = this.f15038x;
        switch (p02.f2898a) {
            case 0:
                return p02.f2905h ? p02.f2899b : p02.f2900c;
            default:
                return p02.f2905h ? p02.f2899b : p02.f2900c;
        }
    }

    public int getContentInsetLeft() {
        P0 p02 = this.f15038x;
        switch (p02.f2898a) {
        }
        return p02.f2899b;
    }

    public int getContentInsetRight() {
        P0 p02 = this.f15038x;
        switch (p02.f2898a) {
        }
        return p02.f2900c;
    }

    public int getContentInsetStart() {
        P0 p02 = this.f15038x;
        switch (p02.f2898a) {
            case 0:
                return p02.f2905h ? p02.f2900c : p02.f2899b;
            default:
                return p02.f2905h ? p02.f2900c : p02.f2899b;
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.f15018f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f15018f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        c();
        return this.f15013a.getMenu();
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f15017e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f15017e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        c();
        return this.f15013a.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f15025l;
    }

    public View getSplitBarCustomView() {
        return this.f15024k0;
    }

    public CharSequence getSubtitle() {
        return this.f14991A;
    }

    public CharSequence getTitle() {
        return this.f15040z;
    }

    public int getTitleMarginBottom() {
        return this.f15037w;
    }

    public int getTitleMarginEnd() {
        return this.f15035u;
    }

    public int getTitleMarginStart() {
        return this.f15032r;
    }

    public int getTitleMarginTop() {
        return this.f15036v;
    }

    public D getWrapper() {
        if (this.f15001K == null) {
            this.f15001K = new w0(this, true);
        }
        return this.f15001K;
    }

    public final int h(int i4) {
        WeakHashMap weakHashMap = K.S.f939a;
        int layoutDirection = getLayoutDirection();
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, layoutDirection) & 7;
        return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : layoutDirection == 1 ? 5 : 3;
    }

    public final int i(int i4, View view) {
        s0 s0Var = (s0) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i4 > 0 ? (measuredHeight - i4) / 2 : 0;
        int i6 = s0Var.f14437a & 112;
        if (i6 != 16 && i6 != 48 && i6 != 80) {
            i6 = this.f15039y & 112;
        }
        if (i6 == 48) {
            return getPaddingTop() - i5;
        }
        if (i6 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) s0Var).bottomMargin) - i5;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i7 = ((ViewGroup.MarginLayoutParams) s0Var).topMargin;
        if (iMax < i7) {
            iMax = i7;
        } else {
            int i8 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i9 = ((ViewGroup.MarginLayoutParams) s0Var).bottomMargin;
            if (i8 < i9) {
                iMax = Math.max(0, iMax - (i9 - i8));
            }
        }
        return paddingTop + iMax;
    }

    public final boolean m(View view) {
        return view.getParent() == this || this.f14997G.contains(view);
    }

    public final boolean n() {
        C0897q c0897q;
        ActionMenuView actionMenuView = this.f15013a;
        return (actionMenuView == null || (c0897q = actionMenuView.f14802t) == null || !c0897q.k()) ? false : true;
    }

    public final int o(View view, int i4, int i5, int[] iArr) {
        s0 s0Var = (s0) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) s0Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i6) + i4;
        iArr[0] = Math.max(0, -i6);
        int i7 = i(i5, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, i7, iMax + measuredWidth, view.getMeasuredHeight() + i7);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) s0Var).rightMargin + iMax;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f15007Q);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f14995E = false;
        }
        if (!this.f14995E) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f14995E = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f14995E = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02d6 A[LOOP:0: B:116:0x02d4->B:117:0x02d6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02f2 A[LOOP:1: B:119:0x02f0->B:120:0x02f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0312 A[LOOP:2: B:122:0x0310->B:123:0x0312, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0361 A[LOOP:3: B:131:0x035f->B:132:0x0361, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r22, int r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int iJ;
        int iMax;
        int measuredState;
        int measuredState2;
        int iMax2;
        int i7;
        int iK;
        int measuredState3;
        int iMax3;
        int i8;
        boolean zB = y0.b(this);
        int i9 = !zB ? 1 : 0;
        int i10 = 0;
        if (s(this.f15017e)) {
            r(this.f15017e, i4, 0, i5, this.f15031q);
            iJ = j(this.f15017e) + this.f15017e.getMeasuredWidth();
            int iMax4 = Math.max(0, k(this.f15017e) + this.f15017e.getMeasuredHeight());
            ImageButton imageButton = this.f15017e;
            WeakHashMap weakHashMap = K.S.f939a;
            int measuredState4 = imageButton.getMeasuredState();
            i6 = this.f15034t;
            iMax = iMax4;
            measuredState = measuredState4;
        } else {
            i6 = this.f15033s;
            iJ = 0;
            iMax = 0;
            measuredState = 0;
        }
        this.f15032r = i6;
        if (s(this.f15021i)) {
            r(this.f15021i, i4, 0, i5, this.f15031q);
            iJ = j(this.f15021i) + this.f15021i.getMeasuredWidth();
            iMax = Math.max(iMax, k(this.f15021i) + this.f15021i.getMeasuredHeight());
            ImageButton imageButton2 = this.f15021i;
            WeakHashMap weakHashMap2 = K.S.f939a;
            measuredState |= imageButton2.getMeasuredState();
        }
        int contentInsetStart = getContentInsetStart();
        int iMax5 = Math.max(contentInsetStart, iJ);
        int iMax6 = Math.max(0, contentInsetStart - iJ);
        int[] iArr = this.f14998H;
        iArr[zB ? 1 : 0] = iMax6;
        if (s(this.f15013a)) {
            r(this.f15013a, i4, iMax5, i5, this.f15031q);
            int iJ2 = j(this.f15013a) + this.f15013a.getMeasuredWidth();
            int iMax7 = Math.max(iMax, k(this.f15013a) + this.f15013a.getMeasuredHeight());
            ActionMenuView actionMenuView = this.f15013a;
            WeakHashMap weakHashMap3 = K.S.f939a;
            measuredState2 = measuredState | actionMenuView.getMeasuredState();
            iMax2 = iMax7;
            i7 = iJ2;
        } else {
            measuredState2 = measuredState;
            iMax2 = iMax;
            i7 = 0;
        }
        int contentInsetEnd = getContentInsetEnd();
        int iMax8 = iMax5 + Math.max(contentInsetEnd, i7);
        iArr[i9] = Math.max(0, contentInsetEnd - i7);
        if (s(this.f15022j)) {
            iMax8 += q(this.f15022j, i4, iMax8, i5, 0, iArr, false);
            iMax2 = Math.max(iMax2, k(this.f15022j) + this.f15022j.getMeasuredHeight());
            View view = this.f15022j;
            WeakHashMap weakHashMap4 = K.S.f939a;
            measuredState2 |= view.getMeasuredState();
        }
        if (s(this.f15018f)) {
            iMax8 += q(this.f15018f, i4, iMax8, i5, 0, iArr, false);
            iMax2 = Math.max(iMax2, k(this.f15018f) + this.f15018f.getMeasuredHeight());
            ImageView imageView = this.f15018f;
            WeakHashMap weakHashMap5 = K.S.f939a;
            measuredState2 |= imageView.getMeasuredState();
        }
        int childCount = getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            if (((s0) childAt.getLayoutParams()).f15147b == 0 && s(childAt)) {
                i8 = i11;
                iMax8 += q(childAt, i4, iMax8, i5, 0, iArr, false);
                int iMax9 = Math.max(iMax2, k(childAt) + childAt.getMeasuredHeight());
                WeakHashMap weakHashMap6 = K.S.f939a;
                iMax2 = iMax9;
                measuredState2 = childAt.getMeasuredState() | measuredState2;
            } else {
                i8 = i11;
            }
            i11 = i8 + 1;
        }
        int i12 = this.f15036v + this.f15037w;
        int i13 = this.f15032r + this.f15035u;
        int i14 = (this.f15039y & 7) != 1 ? iMax8 : i7 * 2;
        if (s(this.f15014b)) {
            q(this.f15014b, i4, i14 + i13, i5, i12, iArr, true);
            int iJ3 = j(this.f15014b) + this.f15014b.getMeasuredWidth();
            int iK2 = k(this.f15014b) + this.f15014b.getMeasuredHeight();
            HorizontalScrollView horizontalScrollView = this.f15014b;
            WeakHashMap weakHashMap7 = K.S.f939a;
            iK = iK2;
            measuredState3 = measuredState2 | horizontalScrollView.getMeasuredState();
            iMax3 = iJ3;
        } else {
            iK = 0;
            measuredState3 = measuredState2;
            iMax3 = 0;
        }
        if (s(this.f15016d)) {
            iMax3 = Math.max(iMax3, q(this.f15016d, i4, i14 + i13, i5, iK + i12, iArr, false));
            iK = k(this.f15016d) + this.f15016d.getMeasuredHeight() + iK;
            TextView textView = this.f15016d;
            WeakHashMap weakHashMap8 = K.S.f939a;
            measuredState3 |= textView.getMeasuredState();
        }
        int iMax10 = Math.max(iMax2, iK);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax10;
        WeakHashMap weakHashMap9 = K.S.f939a;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax8 + iMax3, getSuggestedMinimumWidth()), i4, measuredState3 & (-16777216));
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i5, measuredState3 << 16);
        if (!this.f15006P) {
            i10 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            View childAt2 = getChildAt(i15);
            if (s(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i10 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i10);
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
        ActionMenuView actionMenuView = this.f15013a;
        L3.k kVar = actionMenuView != null ? actionMenuView.f14798p : null;
        int i4 = savedState.f15041a;
        if (i4 != 0 && this.f15003M != null && kVar != null && (menuItemFindItem = kVar.findItem(i4)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f15042b) {
            J3.a aVar = this.f15007Q;
            removeCallbacks(aVar);
            post(aVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        P0 p02 = this.f15038x;
        if (p02 != null) {
            p02.b(i4 == 1);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        L3.l lVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        r0 r0Var = this.f15003M;
        if (r0Var != null && (lVar = r0Var.f15144b) != null) {
            savedState.f15041a = lVar.f1305a;
        }
        savedState.f15042b = n();
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f14994D = false;
        }
        if (!this.f14994D) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f14994D = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f14994D = false;
        }
        return true;
    }

    public final int p(View view, int i4, int i5, int[] iArr) {
        s0 s0Var = (s0) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) s0Var).rightMargin - iArr[1];
        int iMax = i4 - Math.max(0, i6);
        iArr[1] = Math.max(0, -i6);
        int i7 = i(i5, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, i7, iMax, view.getMeasuredHeight() + i7);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) s0Var).leftMargin);
    }

    public final int q(View view, int i4, int i5, int i6, int i7, int[] iArr, boolean z4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i8 = marginLayoutParams.leftMargin - iArr[0];
        int i9 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i9) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i8);
        iArr[1] = Math.max(0, -i9);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + iMax + i5, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height);
        if (z4 && view.getMinimumWidth() > View.MeasureSpec.getSize(childMeasureSpec)) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.getMode(childMeasureSpec));
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        return view.getMeasuredWidth() + iMax;
    }

    public final void r(View view, int i4, int i5, int i6, int i7) {
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

    public final boolean s(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setCollapsible(boolean z4) {
        this.f15006P = z4;
        requestLayout();
    }

    public void setLogo(@DrawableRes int i4) {
        setLogo(this.f15008R.b(getContext(), i4));
    }

    public void setLogoDescription(@StringRes int i4) {
        setLogoDescription(getContext().getText(i4));
    }

    public void setMenuVisibility(int i4) {
        ActionMenuView actionMenuView = this.f15013a;
        if (actionMenuView == null || !this.f15012W) {
            return;
        }
        actionMenuView.setVisibility(i4);
    }

    public void setNavigationContentDescription(@StringRes int i4) {
        setNavigationContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setNavigationIcon(@DrawableRes int i4) {
        setNavigationIcon(this.f15008R.b(getContext(), i4));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        e();
        this.f15017e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(t0 t0Var) {
        this.f14999I = t0Var;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        c();
        this.f15013a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i4) {
        if (this.f15025l != i4) {
            this.f15025l = i4;
            if (i4 == 0) {
                this.f15023k = getContext();
            } else {
                this.f15023k = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setShowBottomMenu(boolean z4) {
        if (this.T != z4) {
            this.T = z4;
            ActionMenuView actionMenuView = this.f15009S;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f15009S);
                }
                if (this.T) {
                    ViewGroup viewGroup2 = this.f15011V;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f15009S);
                    }
                    this.f15009S.getLayoutParams().width = -1;
                }
                this.f15009S.requestLayout();
            }
        }
    }

    public void setSplitCustomView(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.f15011V == null) {
            return;
        }
        View view2 = this.f15024k0;
        if (view2 != null) {
            ((ViewGroup) view2.getParent()).removeView(this.f15024k0);
        }
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f15024k0 = view;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams = new FrameLayout.LayoutParams(layoutParams2);
                if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                    layoutParams.gravity = 17;
                }
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
            }
            this.f15011V.addView(view, layoutParams);
        }
    }

    public void setSplitToolbar(boolean z4) {
        if (this.f15012W != z4) {
            this.f15012W = z4;
            ActionMenuView actionMenuView = this.f15013a;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f15013a);
                }
                if (z4) {
                    ViewGroup viewGroup2 = this.f15011V;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f15013a);
                    }
                    this.f15013a.getLayoutParams().width = -1;
                } else {
                    b(this.f15013a, false);
                    this.f15013a.getLayoutParams().width = -2;
                }
                this.f15013a.requestLayout();
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f15011V = viewGroup;
    }

    public void setSubtitle(@StringRes int i4) {
        setSubtitle(getContext().getText(i4));
    }

    public void setSubtitleTextColor(@ColorInt int i4) {
        this.f14993C = i4;
        TextView textView = this.f15016d;
        if (textView != null) {
            textView.setTextColor(i4);
        }
    }

    public void setTitle(@StringRes int i4) {
        setTitle(getContext().getText(i4));
    }

    public void setTitleTextColor(@ColorInt int i4) {
        this.f14992B = i4;
        TextView textView = this.f15015c;
        if (textView != null) {
            textView.setTextColor(i4);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        s0 s0Var = new s0(context, attributeSet);
        s0Var.f14437a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12589b);
        s0Var.f14437a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        s0Var.f15147b = 0;
        return s0Var;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f15018f == null) {
                this.f15018f = new ImageView(getContext());
            }
            if (!m(this.f15018f)) {
                b(this.f15018f, true);
            }
        } else {
            ImageView imageView = this.f15018f;
            if (imageView != null && m(imageView)) {
                removeView(this.f15018f);
                this.f14997G.remove(this.f15018f);
            }
        }
        ImageView imageView2 = this.f15018f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f15018f == null) {
            this.f15018f = new ImageView(getContext());
        }
        ImageView imageView = this.f15018f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.f15017e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        TextView textView;
        TextView textView2;
        if (drawable != null) {
            e();
            if (!m(this.f15017e)) {
                b(this.f15017e, true);
            }
            int i4 = this.f15028n;
            if (i4 != 0 && (textView2 = this.f15015c) != null) {
                textView2.setTextAppearance(getContext(), i4);
            }
        } else {
            ImageButton imageButton = this.f15017e;
            if (imageButton != null && m(imageButton)) {
                removeView(this.f15017e);
                this.f14997G.remove(this.f15017e);
                setTouchDelegate(null);
                if (this.f15027m != 0 && (textView = this.f15015c) != null) {
                    textView.setTextAppearance(getContext(), this.f15027m);
                }
            }
        }
        ImageButton imageButton2 = this.f15017e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f15016d;
            if (textView != null && m(textView)) {
                removeView(this.f15016d);
                this.f14997G.remove(this.f15016d);
            }
        } else {
            if (this.f15016d == null) {
                Context context = getContext();
                TextView textView2 = new TextView(context);
                this.f15016d = textView2;
                textView2.setSingleLine();
                this.f15016d.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f15029o;
                if (i4 != 0) {
                    this.f15016d.setTextAppearance(context, i4);
                }
                int i5 = this.f14993C;
                if (i5 != 0) {
                    this.f15016d.setTextColor(i5);
                }
            }
            if (!m(this.f15016d)) {
                b(this.f15016d, true);
            }
        }
        TextView textView3 = this.f15016d;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
        this.f14991A = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        int i4;
        if (TextUtils.isEmpty(charSequence)) {
            HorizontalScrollView horizontalScrollView = this.f15014b;
            if (horizontalScrollView != null && m(horizontalScrollView)) {
                removeView(this.f15014b);
                this.f14997G.remove(this.f15014b);
            }
        } else {
            if (this.f15014b == null) {
                HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(getContext());
                this.f15014b = horizontalScrollView2;
                horizontalScrollView2.setHorizontalFadingEdgeEnabled(true);
                this.f15014b.setOverScrollMode(2);
                this.f15014b.setHorizontalScrollBarEnabled(false);
                this.f15014b.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.stepos_toolbar_title_min_width));
            }
            if (this.f15015c == null) {
                TextView textView = new TextView(getContext());
                this.f15015c = textView;
                textView.setSingleLine();
            }
            if (s(this.f15017e) && (i4 = this.f15028n) != 0) {
                this.f15015c.setTextAppearance(getContext(), i4);
            } else if (this.f15027m != 0) {
                this.f15015c.setTextAppearance(getContext(), this.f15027m);
            }
            int i5 = this.f14992B;
            if (i5 != 0) {
                this.f15015c.setTextColor(i5);
            }
            this.f15014b.removeAllViews();
            this.f15014b.addView(this.f15015c);
            if (!m(this.f15014b)) {
                b(this.f15014b, true);
            }
        }
        TextView textView2 = this.f15015c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f15040z = charSequence;
    }
}
