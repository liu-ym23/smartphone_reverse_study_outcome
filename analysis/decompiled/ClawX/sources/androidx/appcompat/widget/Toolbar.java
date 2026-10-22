package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import androidx.emoji2.text.m;
import androidx.fragment.app.b;
import b8.h;
import c.a;
import com.stepos.stepclaw.R;
import e.d;
import e0.a0;
import e0.y;
import f.j;
import f.k;
import g.a2;
import g.b2;
import g.d2;
import g.e2;
import g.f;
import g.f2;
import g.g0;
import g.i;
import g.m0;
import g.n1;
import g.u1;
import g.v;
import g.v1;
import g.w;
import g.w1;
import g.y1;
import g.z1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public final ArrayList E;
    public final ArrayList F;
    public final int[] G;
    public final m H;
    public ArrayList I;
    public final v1 J;
    public e2 K;
    public z1 L;
    public boolean M;
    public OnBackInvokedCallback N;
    public OnBackInvokedDispatcher O;
    public boolean P;
    public final b Q;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f333a;

    /* renamed from: b, reason: collision with root package name */
    public g0 f334b;

    /* renamed from: c, reason: collision with root package name */
    public g0 f335c;
    public v d;

    /* renamed from: e, reason: collision with root package name */
    public w f336e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f337f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f338g;

    /* renamed from: h, reason: collision with root package name */
    public v f339h;

    /* renamed from: j, reason: collision with root package name */
    public View f340j;

    /* renamed from: k, reason: collision with root package name */
    public Context f341k;

    /* renamed from: l, reason: collision with root package name */
    public int f342l;

    /* renamed from: m, reason: collision with root package name */
    public int f343m;

    /* renamed from: n, reason: collision with root package name */
    public int f344n;

    /* renamed from: o, reason: collision with root package name */
    public final int f345o;

    /* renamed from: p, reason: collision with root package name */
    public final int f346p;

    /* renamed from: q, reason: collision with root package name */
    public int f347q;

    /* renamed from: r, reason: collision with root package name */
    public int f348r;

    /* renamed from: s, reason: collision with root package name */
    public int f349s;

    /* renamed from: t, reason: collision with root package name */
    public int f350t;

    /* renamed from: u, reason: collision with root package name */
    public n1 f351u;

    /* renamed from: v, reason: collision with root package name */
    public int f352v;

    /* renamed from: w, reason: collision with root package name */
    public int f353w;

    /* renamed from: x, reason: collision with root package name */
    public final int f354x;
    public CharSequence y;
    public CharSequence z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static a2 g() {
        a2 a2Var = new a2(-2, -2);
        a2Var.f2669b = 0;
        a2Var.f2668a = 8388627;
        return a2Var;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i8 = 0; i8 < menu.size(); i8++) {
            arrayList.add(menu.getItem(i8));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new d(getContext());
    }

    public static a2 h(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof a2;
        if (z) {
            a2 a2Var = (a2) layoutParams;
            a2 a2Var2 = new a2(a2Var);
            a2Var2.f2669b = 0;
            a2Var2.f2669b = a2Var.f2669b;
            return a2Var2;
        }
        if (z) {
            a2 a2Var3 = new a2((a2) layoutParams);
            a2Var3.f2669b = 0;
            return a2Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            a2 a2Var4 = new a2(layoutParams);
            a2Var4.f2669b = 0;
            return a2Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        a2 a2Var5 = new a2(marginLayoutParams);
        a2Var5.f2669b = 0;
        ((ViewGroup.MarginLayoutParams) a2Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) a2Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) a2Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) a2Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return a2Var5;
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i8) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i8, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                a2 a2Var = (a2) childAt.getLayoutParams();
                if (a2Var.f2669b == 0 && r(childAt)) {
                    int i10 = a2Var.f2668a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i10, layoutDirection) & 7;
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
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            View childAt2 = getChildAt(i11);
            a2 a2Var2 = (a2) childAt2.getLayoutParams();
            if (a2Var2.f2669b == 0 && r(childAt2)) {
                int i12 = a2Var2.f2668a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i12, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        a2 a2VarG = layoutParams == null ? g() : !checkLayoutParams(layoutParams) ? h(layoutParams) : (a2) layoutParams;
        a2VarG.f2669b = 1;
        if (!z || this.f340j == null) {
            addView(view, a2VarG);
        } else {
            view.setLayoutParams(a2VarG);
            this.F.add(view);
        }
    }

    public final void c() {
        if (this.f339h == null) {
            v vVar = new v(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f339h = vVar;
            vVar.setImageDrawable(this.f337f);
            this.f339h.setContentDescription(this.f338g);
            a2 a2VarG = g();
            a2VarG.f2668a = (this.f345o & 112) | 8388611;
            a2VarG.f2669b = 2;
            this.f339h.setLayoutParams(a2VarG);
            this.f339h.setOnClickListener(new w1(this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof a2);
    }

    public final void d() {
        if (this.f351u == null) {
            n1 n1Var = new n1();
            n1Var.f2787a = 0;
            n1Var.f2788b = 0;
            n1Var.f2789c = Integer.MIN_VALUE;
            n1Var.d = Integer.MIN_VALUE;
            n1Var.f2790e = 0;
            n1Var.f2791f = 0;
            n1Var.f2792g = false;
            n1Var.f2793h = false;
            this.f351u = n1Var;
        }
    }

    public final void e() {
        if (this.f333a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f333a = actionMenuView;
            actionMenuView.setPopupTheme(this.f342l);
            this.f333a.setOnMenuItemClickListener(this.J);
            ActionMenuView actionMenuView2 = this.f333a;
            v1 v1Var = new v1(this);
            actionMenuView2.getClass();
            actionMenuView2.f316u = v1Var;
            a2 a2VarG = g();
            a2VarG.f2668a = (this.f345o & 112) | 8388613;
            this.f333a.setLayoutParams(a2VarG);
            b(this.f333a, false);
        }
        ActionMenuView actionMenuView3 = this.f333a;
        if (actionMenuView3.f312q == null) {
            j jVar = (j) actionMenuView3.getMenu();
            if (this.L == null) {
                this.L = new z1(this);
            }
            this.f333a.setExpandedActionViewsExclusive(true);
            jVar.b(this.L, this.f341k);
            s();
        }
    }

    public final void f() {
        if (this.d == null) {
            this.d = new v(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            a2 a2VarG = g();
            a2VarG.f2668a = (this.f345o & 112) | 8388611;
            this.d.setLayoutParams(a2VarG);
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

    public CharSequence getCollapseContentDescription() {
        v vVar = this.f339h;
        if (vVar != null) {
            return vVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        v vVar = this.f339h;
        if (vVar != null) {
            return vVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        n1 n1Var = this.f351u;
        if (n1Var != null) {
            return n1Var.f2792g ? n1Var.f2787a : n1Var.f2788b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i8 = this.f353w;
        return i8 != Integer.MIN_VALUE ? i8 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        n1 n1Var = this.f351u;
        if (n1Var != null) {
            return n1Var.f2787a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        n1 n1Var = this.f351u;
        if (n1Var != null) {
            return n1Var.f2788b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        n1 n1Var = this.f351u;
        if (n1Var != null) {
            return n1Var.f2792g ? n1Var.f2788b : n1Var.f2787a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i8 = this.f352v;
        return i8 != Integer.MIN_VALUE ? i8 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        j jVar;
        ActionMenuView actionMenuView = this.f333a;
        return (actionMenuView == null || (jVar = actionMenuView.f312q) == null || !jVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f353w, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f352v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        w wVar = this.f336e;
        if (wVar != null) {
            return wVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        w wVar = this.f336e;
        if (wVar != null) {
            return wVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f333a.getMenu();
    }

    public View getNavButtonView() {
        return this.d;
    }

    public CharSequence getNavigationContentDescription() {
        v vVar = this.d;
        if (vVar != null) {
            return vVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        v vVar = this.d;
        if (vVar != null) {
            return vVar.getDrawable();
        }
        return null;
    }

    public i getOuterActionMenuPresenter() {
        return null;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f333a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f341k;
    }

    public int getPopupTheme() {
        return this.f342l;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public final TextView getSubtitleTextView() {
        return this.f335c;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.f350t;
    }

    public int getTitleMarginEnd() {
        return this.f348r;
    }

    public int getTitleMarginStart() {
        return this.f347q;
    }

    public int getTitleMarginTop() {
        return this.f349s;
    }

    public final TextView getTitleTextView() {
        return this.f334b;
    }

    public m0 getWrapper() {
        Drawable drawable;
        if (this.K == null) {
            e2 e2Var = new e2();
            e2Var.f2701l = 0;
            e2Var.f2691a = this;
            e2Var.f2697h = getTitle();
            e2Var.f2698i = getSubtitle();
            e2Var.f2696g = e2Var.f2697h != null;
            e2Var.f2695f = getNavigationIcon();
            a4.d dVarE = a4.d.E(getContext(), null, a.f1014a, R.attr.actionBarStyle);
            TypedArray typedArray = (TypedArray) dVarE.f97c;
            e2Var.f2702m = dVarE.t(15);
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                e2Var.f2696g = true;
                e2Var.f2697h = text;
                if ((e2Var.f2692b & 8) != 0) {
                    setTitle(text);
                    if (e2Var.f2696g) {
                        a0.f(getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                e2Var.f2698i = text2;
                if ((e2Var.f2692b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable drawableT = dVarE.t(20);
            if (drawableT != null) {
                e2Var.f2694e = drawableT;
                e2Var.c();
            }
            Drawable drawableT2 = dVarE.t(17);
            if (drawableT2 != null) {
                e2Var.d = drawableT2;
                e2Var.c();
            }
            if (e2Var.f2695f == null && (drawable = e2Var.f2702m) != null) {
                e2Var.f2695f = drawable;
                if ((e2Var.f2692b & 4) != 0) {
                    setNavigationIcon(drawable);
                } else {
                    setNavigationIcon((Drawable) null);
                }
            }
            e2Var.a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = e2Var.f2693c;
                if (view != null && (e2Var.f2692b & 16) != 0) {
                    removeView(view);
                }
                e2Var.f2693c = viewInflate;
                if (viewInflate != null && (e2Var.f2692b & 16) != 0) {
                    addView(viewInflate);
                }
                e2Var.a(e2Var.f2692b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                d();
                this.f351u.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f343m = resourceId2;
                g0 g0Var = this.f334b;
                if (g0Var != null) {
                    g0Var.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.f344n = resourceId3;
                g0 g0Var2 = this.f335c;
                if (g0Var2 != null) {
                    g0Var2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            dVarE.H();
            if (R.string.abc_action_bar_up_description != e2Var.f2701l) {
                e2Var.f2701l = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i8 = e2Var.f2701l;
                    e2Var.f2699j = i8 != 0 ? getContext().getString(i8) : null;
                    e2Var.b();
                }
            }
            e2Var.f2699j = getNavigationContentDescription();
            setNavigationOnClickListener(new w1(e2Var));
            this.K = e2Var;
        }
        return this.K;
    }

    public final int i(View view, int i8) {
        a2 a2Var = (a2) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i9 = i8 > 0 ? (measuredHeight - i8) / 2 : 0;
        int i10 = a2Var.f2668a & 112;
        if (i10 != 16 && i10 != 48 && i10 != 80) {
            i10 = this.f354x & 112;
        }
        if (i10 == 48) {
            return getPaddingTop() - i9;
        }
        if (i10 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) a2Var).bottomMargin) - i9;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i11 = ((ViewGroup.MarginLayoutParams) a2Var).topMargin;
        if (iMax < i11) {
            iMax = i11;
        } else {
            int i12 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i13 = ((ViewGroup.MarginLayoutParams) a2Var).bottomMargin;
            if (i12 < i13) {
                iMax = Math.max(0, iMax - (i13 - i12));
            }
        }
        return paddingTop + iMax;
    }

    public final void l() {
        ArrayList arrayList = this.I;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.H.f621a).iterator();
        if (it.hasNext()) {
            ((androidx.fragment.app.i) it.next()).getClass();
            throw null;
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.I = currentMenuItems2;
    }

    public final boolean m(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public final int n(View view, int i8, int i9, int[] iArr) {
        a2 a2Var = (a2) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) a2Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i10) + i8;
        iArr[0] = Math.max(0, -i10);
        int i11 = i(view, i9);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, i11, iMax + measuredWidth, view.getMeasuredHeight() + i11);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) a2Var).rightMargin + iMax;
    }

    public final int o(View view, int i8, int i9, int[] iArr) {
        a2 a2Var = (a2) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) a2Var).rightMargin - iArr[1];
        int iMax = i8 - Math.max(0, i10);
        iArr[1] = Math.max(0, -i10);
        int i11 = i(view, i9);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, i11, iMax, view.getMeasuredHeight() + i11);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) a2Var).leftMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Q);
        s();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.D = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x028f A[LOOP:0: B:102:0x028d->B:103:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02a7 A[LOOP:1: B:105:0x02a5->B:106:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c7 A[LOOP:2: B:108:0x02c5->B:109:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031a A[LOOP:3: B:117:0x0318->B:118:0x031a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        char c3;
        Object[] objArr;
        int iJ;
        int iMax;
        int iCombineMeasuredStates;
        int iJ2;
        int iK;
        int iCombineMeasuredStates2;
        int iMax2;
        int i10 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c3 = 0;
        } else {
            c3 = 1;
            objArr = false;
        }
        if (r(this.d)) {
            q(this.d, i8, 0, i9, this.f346p);
            iJ = j(this.d) + this.d.getMeasuredWidth();
            iMax = Math.max(0, k(this.d) + this.d.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        } else {
            iJ = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (r(this.f339h)) {
            q(this.f339h, i8, 0, i9, this.f346p);
            iJ = j(this.f339h) + this.f339h.getMeasuredWidth();
            iMax = Math.max(iMax, k(this.f339h) + this.f339h.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f339h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iJ);
        int iMax4 = Math.max(0, currentContentInsetStart - iJ);
        Object[] objArr2 = objArr;
        int[] iArr = this.G;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (r(this.f333a)) {
            q(this.f333a, i8, iMax3, i9, this.f346p);
            iJ2 = j(this.f333a) + this.f333a.getMeasuredWidth();
            iMax = Math.max(iMax, k(this.f333a) + this.f333a.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f333a.getMeasuredState());
        } else {
            iJ2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iJ2);
        iArr[c3] = Math.max(0, currentContentInsetEnd - iJ2);
        if (r(this.f340j)) {
            iMax5 += p(this.f340j, i8, iMax5, i9, 0, iArr);
            iMax = Math.max(iMax, k(this.f340j) + this.f340j.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f340j.getMeasuredState());
        }
        if (r(this.f336e)) {
            iMax5 += p(this.f336e, i8, iMax5, i9, 0, iArr);
            iMax = Math.max(iMax, k(this.f336e) + this.f336e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f336e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((a2) childAt.getLayoutParams()).f2669b == 0 && r(childAt)) {
                iMax5 += p(childAt, i8, iMax5, i9, 0, iArr);
                int iMax6 = Math.max(iMax, k(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i12 = iMax5;
        int i13 = this.f349s + this.f350t;
        int i14 = this.f347q + this.f348r;
        if (r(this.f334b)) {
            p(this.f334b, i8, i12 + i14, i9, i13, iArr);
            int iJ3 = j(this.f334b) + this.f334b.getMeasuredWidth();
            iK = k(this.f334b) + this.f334b.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f334b.getMeasuredState());
            iMax2 = iJ3;
        } else {
            iK = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (r(this.f335c)) {
            iMax2 = Math.max(iMax2, p(this.f335c, i8, i12 + i14, i9, i13 + iK, iArr));
            iK += k(this.f335c) + this.f335c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f335c.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iK);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i12 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i8, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i9, iCombineMeasuredStates2 << 16);
        if (!this.M) {
            i10 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            View childAt2 = getChildAt(i15);
            if (r(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i10 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof d2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d2 d2Var = (d2) parcelable;
        super.onRestoreInstanceState(d2Var.f3000a);
        ActionMenuView actionMenuView = this.f333a;
        j jVar = actionMenuView != null ? actionMenuView.f312q : null;
        int i8 = d2Var.f2689c;
        if (i8 != 0 && this.L != null && jVar != null && (menuItemFindItem = jVar.findItem(i8)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (d2Var.d) {
            b bVar = this.Q;
            removeCallbacks(bVar);
            post(bVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i8) {
        super.onRtlPropertiesChanged(i8);
        d();
        n1 n1Var = this.f351u;
        boolean z = i8 == 1;
        if (z == n1Var.f2792g) {
            return;
        }
        n1Var.f2792g = z;
        if (!n1Var.f2793h) {
            n1Var.f2787a = n1Var.f2790e;
            n1Var.f2788b = n1Var.f2791f;
            return;
        }
        if (z) {
            int i9 = n1Var.d;
            if (i9 == Integer.MIN_VALUE) {
                i9 = n1Var.f2790e;
            }
            n1Var.f2787a = i9;
            int i10 = n1Var.f2789c;
            if (i10 == Integer.MIN_VALUE) {
                i10 = n1Var.f2791f;
            }
            n1Var.f2788b = i10;
            return;
        }
        int i11 = n1Var.f2789c;
        if (i11 == Integer.MIN_VALUE) {
            i11 = n1Var.f2790e;
        }
        n1Var.f2787a = i11;
        int i12 = n1Var.d;
        if (i12 == Integer.MIN_VALUE) {
            i12 = n1Var.f2791f;
        }
        n1Var.f2788b = i12;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        i iVar;
        f fVar;
        k kVar;
        d2 d2Var = new d2(super.onSaveInstanceState());
        z1 z1Var = this.L;
        if (z1Var != null && (kVar = z1Var.f2878b) != null) {
            d2Var.f2689c = kVar.f2473a;
        }
        ActionMenuView actionMenuView = this.f333a;
        d2Var.d = (actionMenuView == null || (iVar = actionMenuView.f315t) == null || (fVar = iVar.f2728s) == null || !fVar.b()) ? false : true;
        return d2Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.C = false;
        return true;
    }

    public final int p(View view, int i8, int i9, int i10, int i11, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i12 = marginLayoutParams.leftMargin - iArr[0];
        int i13 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i13) + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        iArr[1] = Math.max(0, -i13);
        view.measure(ViewGroup.getChildMeasureSpec(i8, getPaddingRight() + getPaddingLeft() + iMax + i9, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void q(View view, int i8, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i9, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i11 >= 0) {
            if (mode != 0) {
                i11 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i11);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final void s() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = y1.a(this);
            z1 z1Var = this.L;
            boolean z = (z1Var == null || z1Var.f2878b == null || onBackInvokedDispatcherA == null || !isAttachedToWindow() || !this.P) ? false : true;
            if (z && this.O == null) {
                if (this.N == null) {
                    this.N = y1.b(new u1(this, 0));
                }
                y1.c(onBackInvokedDispatcherA, this.N);
                this.O = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.O) == null) {
                return;
            }
            y1.d(onBackInvokedDispatcher, this.N);
            this.O = null;
        }
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.P != z) {
            this.P = z;
            s();
        }
    }

    public void setCollapseContentDescription(int i8) {
        setCollapseContentDescription(i8 != 0 ? getContext().getText(i8) : null);
    }

    public void setCollapseIcon(int i8) {
        setCollapseIcon(h.p(getContext(), i8));
    }

    public void setCollapsible(boolean z) {
        this.M = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i8) {
        if (i8 < 0) {
            i8 = Integer.MIN_VALUE;
        }
        if (i8 != this.f353w) {
            this.f353w = i8;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i8) {
        if (i8 < 0) {
            i8 = Integer.MIN_VALUE;
        }
        if (i8 != this.f352v) {
            this.f352v = i8;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i8) {
        setLogo(h.p(getContext(), i8));
    }

    public void setLogoDescription(int i8) {
        setLogoDescription(getContext().getText(i8));
    }

    public void setNavigationContentDescription(int i8) {
        setNavigationContentDescription(i8 != 0 ? getContext().getText(i8) : null);
    }

    public void setNavigationIcon(int i8) {
        setNavigationIcon(h.p(getContext(), i8));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        f();
        this.d.setOnClickListener(onClickListener);
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f333a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i8) {
        if (this.f342l != i8) {
            this.f342l = i8;
            if (i8 == 0) {
                this.f341k = getContext();
            } else {
                this.f341k = new ContextThemeWrapper(getContext(), i8);
            }
        }
    }

    public void setSubtitle(int i8) {
        setSubtitle(getContext().getText(i8));
    }

    public void setSubtitleTextColor(int i8) {
        setSubtitleTextColor(ColorStateList.valueOf(i8));
    }

    public void setTitle(int i8) {
        setTitle(getContext().getText(i8));
    }

    public void setTitleMarginBottom(int i8) {
        this.f350t = i8;
        requestLayout();
    }

    public void setTitleMarginEnd(int i8) {
        this.f348r = i8;
        requestLayout();
    }

    public void setTitleMarginStart(int i8) {
        this.f347q = i8;
        requestLayout();
    }

    public void setTitleMarginTop(int i8) {
        this.f349s = i8;
        requestLayout();
    }

    public void setTitleTextColor(int i8) {
        setTitleTextColor(ColorStateList.valueOf(i8));
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f354x = 8388627;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        new u1(this, 1);
        m mVar = new m();
        mVar.f621a = new CopyOnWriteArrayList();
        new HashMap();
        this.H = mVar;
        this.I = new ArrayList();
        this.J = new v1(this);
        this.Q = new b(4, this);
        Context context2 = getContext();
        int[] iArr = a.f1031s;
        a4.d dVarE = a4.d.E(context2, attributeSet, iArr, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) dVarE.f97c;
        int[] iArr2 = a0.f2285a;
        y.b(this, context, iArr, attributeSet, typedArray, R.attr.toolbarStyle, 0);
        TypedArray typedArray2 = (TypedArray) dVarE.f97c;
        this.f343m = typedArray2.getResourceId(28, 0);
        this.f344n = typedArray2.getResourceId(19, 0);
        this.f354x = typedArray2.getInteger(0, 8388627);
        this.f345o = typedArray2.getInteger(2, 48);
        int dimensionPixelOffset = typedArray2.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray2.hasValue(27) ? typedArray2.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f350t = dimensionPixelOffset;
        this.f349s = dimensionPixelOffset;
        this.f348r = dimensionPixelOffset;
        this.f347q = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray2.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f347q = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray2.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f348r = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray2.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f349s = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray2.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f350t = dimensionPixelOffset5;
        }
        this.f346p = typedArray2.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray2.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray2.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray2.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray2.getDimensionPixelSize(8, 0);
        d();
        n1 n1Var = this.f351u;
        n1Var.f2793h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            n1Var.f2790e = dimensionPixelSize;
            n1Var.f2787a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            n1Var.f2791f = dimensionPixelSize2;
            n1Var.f2788b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            n1Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f352v = typedArray2.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f353w = typedArray2.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f337f = dVarE.t(4);
        this.f338g = typedArray2.getText(3);
        CharSequence text = typedArray2.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray2.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f341k = getContext();
        setPopupTheme(typedArray2.getResourceId(17, 0));
        Drawable drawableT = dVarE.t(16);
        if (drawableT != null) {
            setNavigationIcon(drawableT);
        }
        CharSequence text3 = typedArray2.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableT2 = dVarE.t(11);
        if (drawableT2 != null) {
            setLogo(drawableT2);
        }
        CharSequence text4 = typedArray2.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray2.hasValue(29)) {
            setTitleTextColor(dVarE.s(29));
        }
        if (typedArray2.hasValue(20)) {
            setSubtitleTextColor(dVarE.s(20));
        }
        if (typedArray2.hasValue(14)) {
            getMenuInflater().inflate(typedArray2.getResourceId(14, 0), getMenu());
        }
        dVarE.H();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        a2 a2Var = new a2(context, attributeSet);
        a2Var.f2668a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f1015b);
        a2Var.f2668a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        a2Var.f2669b = 0;
        return a2Var;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        v vVar = this.f339h;
        if (vVar != null) {
            vVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f339h.setImageDrawable(drawable);
        } else {
            v vVar = this.f339h;
            if (vVar != null) {
                vVar.setImageDrawable(this.f337f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f336e == null) {
                this.f336e = new w(getContext(), 0);
            }
            if (!m(this.f336e)) {
                b(this.f336e, true);
            }
        } else {
            w wVar = this.f336e;
            if (wVar != null && m(wVar)) {
                removeView(this.f336e);
                this.F.remove(this.f336e);
            }
        }
        w wVar2 = this.f336e;
        if (wVar2 != null) {
            wVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f336e == null) {
            this.f336e = new w(getContext(), 0);
        }
        w wVar = this.f336e;
        if (wVar != null) {
            wVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        v vVar = this.d;
        if (vVar != null) {
            vVar.setContentDescription(charSequence);
            f2.a(this.d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!m(this.d)) {
                b(this.d, true);
            }
        } else {
            v vVar = this.d;
            if (vVar != null && m(vVar)) {
                removeView(this.d);
                this.F.remove(this.d);
            }
        }
        v vVar2 = this.d;
        if (vVar2 != null) {
            vVar2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            g0 g0Var = this.f335c;
            if (g0Var != null && m(g0Var)) {
                removeView(this.f335c);
                this.F.remove(this.f335c);
            }
        } else {
            if (this.f335c == null) {
                Context context = getContext();
                g0 g0Var2 = new g0(context, null);
                this.f335c = g0Var2;
                g0Var2.setSingleLine();
                this.f335c.setEllipsize(TextUtils.TruncateAt.END);
                int i8 = this.f344n;
                if (i8 != 0) {
                    this.f335c.setTextAppearance(context, i8);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f335c.setTextColor(colorStateList);
                }
            }
            if (!m(this.f335c)) {
                b(this.f335c, true);
            }
        }
        g0 g0Var3 = this.f335c;
        if (g0Var3 != null) {
            g0Var3.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        g0 g0Var = this.f335c;
        if (g0Var != null) {
            g0Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            g0 g0Var = this.f334b;
            if (g0Var != null && m(g0Var)) {
                removeView(this.f334b);
                this.F.remove(this.f334b);
            }
        } else {
            if (this.f334b == null) {
                Context context = getContext();
                g0 g0Var2 = new g0(context, null);
                this.f334b = g0Var2;
                g0Var2.setSingleLine();
                this.f334b.setEllipsize(TextUtils.TruncateAt.END);
                int i8 = this.f343m;
                if (i8 != 0) {
                    this.f334b.setTextAppearance(context, i8);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f334b.setTextColor(colorStateList);
                }
            }
            if (!m(this.f334b)) {
                b(this.f334b, true);
            }
        }
        g0 g0Var3 = this.f334b;
        if (g0Var3 != null) {
            g0Var3.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        g0 g0Var = this.f334b;
        if (g0Var != null) {
            g0Var.setTextColor(colorStateList);
        }
    }

    public void setOnMenuItemClickListener(b2 b2Var) {
    }
}
