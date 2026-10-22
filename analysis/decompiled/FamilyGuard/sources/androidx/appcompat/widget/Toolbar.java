package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.C0464i;
import androidx.core.view.C0471p;
import androidx.core.view.InterfaceC0468m;
import g.C0728a;
import h.C0744a;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC0468m {

    /* renamed from: A, reason: collision with root package name */
    private ColorStateList f8370A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f8371B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f8372C;

    /* renamed from: D, reason: collision with root package name */
    private final ArrayList<View> f8373D;

    /* renamed from: E, reason: collision with root package name */
    private final ArrayList<View> f8374E;

    /* renamed from: F, reason: collision with root package name */
    private final int[] f8375F;

    /* renamed from: G, reason: collision with root package name */
    final C0471p f8376G;

    /* renamed from: H, reason: collision with root package name */
    private ArrayList<MenuItem> f8377H;

    /* renamed from: I, reason: collision with root package name */
    private final ActionMenuView.e f8378I;

    /* renamed from: J, reason: collision with root package name */
    private e0 f8379J;

    /* renamed from: K, reason: collision with root package name */
    private C0433c f8380K;

    /* renamed from: L, reason: collision with root package name */
    private f f8381L;

    /* renamed from: M, reason: collision with root package name */
    private j.a f8382M;

    /* renamed from: Q, reason: collision with root package name */
    e.a f8383Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f8384R;

    /* renamed from: S, reason: collision with root package name */
    private OnBackInvokedCallback f8385S;

    /* renamed from: T, reason: collision with root package name */
    private OnBackInvokedDispatcher f8386T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f8387U;

    /* renamed from: V, reason: collision with root package name */
    private final Runnable f8388V;

    /* renamed from: a, reason: collision with root package name */
    ActionMenuView f8389a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f8390b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f8391c;

    /* renamed from: d, reason: collision with root package name */
    private ImageButton f8392d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f8393e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f8394f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f8395g;

    /* renamed from: h, reason: collision with root package name */
    ImageButton f8396h;

    /* renamed from: i, reason: collision with root package name */
    View f8397i;

    /* renamed from: j, reason: collision with root package name */
    private Context f8398j;

    /* renamed from: k, reason: collision with root package name */
    private int f8399k;

    /* renamed from: l, reason: collision with root package name */
    private int f8400l;

    /* renamed from: m, reason: collision with root package name */
    private int f8401m;

    /* renamed from: n, reason: collision with root package name */
    int f8402n;

    /* renamed from: o, reason: collision with root package name */
    private int f8403o;

    /* renamed from: p, reason: collision with root package name */
    private int f8404p;

    /* renamed from: q, reason: collision with root package name */
    private int f8405q;

    /* renamed from: r, reason: collision with root package name */
    private int f8406r;

    /* renamed from: s, reason: collision with root package name */
    private int f8407s;

    /* renamed from: t, reason: collision with root package name */
    private S f8408t;

    /* renamed from: u, reason: collision with root package name */
    private int f8409u;

    /* renamed from: v, reason: collision with root package name */
    private int f8410v;

    /* renamed from: w, reason: collision with root package name */
    private int f8411w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f8412x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f8413y;

    /* renamed from: z, reason: collision with root package name */
    private ColorStateList f8414z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f8376G.h(menuItem)) {
                return true;
            }
            Toolbar.this.getClass();
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.P();
        }
    }

    class c implements e.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.f8383Q;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.f8389a.J()) {
                Toolbar.this.f8376G.i(eVar);
            }
            e.a aVar = Toolbar.this.f8383Q;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    static class e {
        static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: androidx.appcompat.widget.d0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class f implements androidx.appcompat.view.menu.j {

        /* renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.e f8419a;

        /* renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.g f8420b;

        f() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void b(boolean z5) {
            if (this.f8420b != null) {
                androidx.appcompat.view.menu.e eVar = this.f8419a;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        if (this.f8419a.getItem(i5) == this.f8420b) {
                            return;
                        }
                    }
                }
                e(this.f8419a, this.f8420b);
            }
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void d(androidx.appcompat.view.menu.e eVar, boolean z5) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean e(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.f8397i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f8397i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f8396h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f8397i = null;
            toolbar3.a();
            this.f8420b = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.Q();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean f(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f8396h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f8396h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f8396h);
            }
            Toolbar.this.f8397i = gVar.getActionView();
            this.f8420b = gVar;
            ViewParent parent2 = Toolbar.this.f8397i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f8397i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f7517a = (toolbar4.f8402n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f8422b = 2;
                toolbar4.f8397i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f8397i);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f8397i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).onActionViewExpanded();
            }
            Toolbar.this.Q();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public void i(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f8419a;
            if (eVar2 != null && (gVar = this.f8420b) != null) {
                eVar2.f(gVar);
            }
            this.f8419a = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean j(androidx.appcompat.view.menu.m mVar) {
            return false;
        }
    }

    public interface h {
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16823T);
    }

    private int C(View view, int i5, int[] iArr, int i6) {
        g gVar = (g) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i5 + Math.max(0, i7);
        iArr[0] = Math.max(0, -i7);
        int iQ = q(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    private int D(View view, int i5, int[] iArr, int i6) {
        g gVar = (g) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i5 - Math.max(0, i7);
        iArr[1] = Math.max(0, -i7);
        int iQ = q(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    private int E(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i9 = marginLayoutParams.leftMargin - iArr[0];
        int i10 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i9) + Math.max(0, i10);
        iArr[0] = Math.max(0, -i9);
        iArr[1] = Math.max(0, -i10);
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + iMax + i6, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void F(View view, int i5, int i6, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i9 >= 0) {
            if (mode != 0) {
                i9 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i9);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f8376G.f(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f8377H = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.f8388V);
        post(this.f8388V);
    }

    private boolean N() {
        if (!this.f8384R) {
            return false;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (O(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean O(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i5) {
        boolean z5 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iB = C0464i.b(i5, getLayoutDirection());
        list.clear();
        if (!z5) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f8422b == 0 && O(childAt) && p(gVar.f7517a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i7 = childCount - 1; i7 >= 0; i7--) {
            View childAt2 = getChildAt(i7);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f8422b == 0 && O(childAt2) && p(gVar2.f7517a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f8422b = 1;
        if (!z5 || this.f8397i == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f8374E.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i5 = 0; i5 < menu.size(); i5++) {
            arrayList.add(menu.getItem(i5));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void h() {
        if (this.f8408t == null) {
            this.f8408t = new S();
        }
    }

    private void i() {
        if (this.f8393e == null) {
            this.f8393e = new r(getContext());
        }
    }

    private void j() {
        k();
        if (this.f8389a.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f8389a.getMenu();
            if (this.f8381L == null) {
                this.f8381L = new f();
            }
            this.f8389a.setExpandedActionViewsExclusive(true);
            eVar.c(this.f8381L, this.f8398j);
            Q();
        }
    }

    private void k() {
        if (this.f8389a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f8389a = actionMenuView;
            actionMenuView.setPopupTheme(this.f8399k);
            this.f8389a.setOnMenuItemClickListener(this.f8378I);
            this.f8389a.O(this.f8382M, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f7517a = (this.f8402n & 112) | 8388613;
            this.f8389a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f8389a, false);
        }
    }

    private void l() {
        if (this.f8392d == null) {
            this.f8392d = new C0446p(getContext(), null, C0728a.f16822S);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f7517a = (this.f8402n & 112) | 8388611;
            this.f8392d.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    private int p(int i5) {
        int layoutDirection = getLayoutDirection();
        int iB = C0464i.b(i5, layoutDirection) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : layoutDirection == 1 ? 5 : 3;
    }

    private int q(View view, int i5) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i5 > 0 ? (measuredHeight - i5) / 2 : 0;
        int iR = r(gVar.f7517a);
        if (iR == 48) {
            return getPaddingTop() - i6;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i6;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i7 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i7) {
            iMax = i7;
        } else {
            int i8 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i9 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i8 < i9) {
                iMax = Math.max(0, iMax - (i9 - i8));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i5) {
        int i6 = i5 & 112;
        return (i6 == 16 || i6 == 48 || i6 == 80) ? i6 : this.f8411w & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i5 = iArr[0];
        int i6 = iArr[1];
        int size = list.size();
        int i7 = 0;
        int measuredWidth = 0;
        while (i7 < size) {
            View view = list.get(i7);
            g gVar = (g) view.getLayoutParams();
            int i8 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i5;
            int i9 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i6;
            int iMax = Math.max(0, i8);
            int iMax2 = Math.max(0, i9);
            int iMax3 = Math.max(0, -i8);
            int iMax4 = Math.max(0, -i9);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i7++;
            i6 = iMax4;
            i5 = iMax3;
        }
        return measuredWidth;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.f8374E.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f8389a;
        return actionMenuView != null && actionMenuView.I();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f8389a;
        return actionMenuView != null && actionMenuView.J();
    }

    void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f8422b != 2 && childAt != this.f8389a) {
                removeViewAt(childCount);
                this.f8374E.add(childAt);
            }
        }
    }

    public void J(int i5, int i6) {
        h();
        this.f8408t.g(i5, i6);
    }

    public void K(androidx.appcompat.view.menu.e eVar, C0433c c0433c) {
        if (eVar == null && this.f8389a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e eVarN = this.f8389a.N();
        if (eVarN == eVar) {
            return;
        }
        if (eVarN != null) {
            eVarN.P(this.f8380K);
            eVarN.P(this.f8381L);
        }
        if (this.f8381L == null) {
            this.f8381L = new f();
        }
        c0433c.G(true);
        if (eVar != null) {
            eVar.c(c0433c, this.f8398j);
            eVar.c(this.f8381L, this.f8398j);
        } else {
            c0433c.i(this.f8398j, null);
            this.f8381L.i(this.f8398j, null);
            c0433c.b(true);
            this.f8381L.b(true);
        }
        this.f8389a.setPopupTheme(this.f8399k);
        this.f8389a.setPresenter(c0433c);
        this.f8380K = c0433c;
        Q();
    }

    public void L(Context context, int i5) {
        this.f8401m = i5;
        TextView textView = this.f8391c;
        if (textView != null) {
            textView.setTextAppearance(context, i5);
        }
    }

    public void M(Context context, int i5) {
        this.f8400l = i5;
        TextView textView = this.f8390b;
        if (textView != null) {
            textView.setTextAppearance(context, i5);
        }
    }

    public boolean P() {
        ActionMenuView actionMenuView = this.f8389a;
        return actionMenuView != null && actionMenuView.P();
    }

    void Q() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
        boolean z5 = v() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.f8387U;
        if (z5 && this.f8386T == null) {
            if (this.f8385S == null) {
                this.f8385S = e.b(new Runnable() { // from class: androidx.appcompat.widget.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f8482a.e();
                    }
                });
            }
            e.c(onBackInvokedDispatcherA, this.f8385S);
            this.f8386T = onBackInvokedDispatcherA;
            return;
        }
        if (z5 || (onBackInvokedDispatcher = this.f8386T) == null) {
            return;
        }
        e.d(onBackInvokedDispatcher, this.f8385S);
        this.f8386T = null;
    }

    void a() {
        for (int size = this.f8374E.size() - 1; size >= 0; size--) {
            addView(this.f8374E.get(size));
        }
        this.f8374E.clear();
    }

    @Override // androidx.core.view.InterfaceC0468m
    public void addMenuProvider(androidx.core.view.r rVar) {
        this.f8376G.c(rVar);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f8389a) != null && actionMenuView.K();
    }

    public void e() {
        f fVar = this.f8381L;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.f8420b;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f8389a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f8396h == null) {
            C0446p c0446p = new C0446p(getContext(), null, C0728a.f16822S);
            this.f8396h = c0446p;
            c0446p.setImageDrawable(this.f8394f);
            this.f8396h.setContentDescription(this.f8395g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f7517a = (this.f8402n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f8422b = 2;
            this.f8396h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f8396h.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f8396h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f8396h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        S s5 = this.f8408t;
        if (s5 != null) {
            return s5.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i5 = this.f8410v;
        return i5 != Integer.MIN_VALUE ? i5 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        S s5 = this.f8408t;
        if (s5 != null) {
            return s5.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        S s5 = this.f8408t;
        if (s5 != null) {
            return s5.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        S s5 = this.f8408t;
        if (s5 != null) {
            return s5.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i5 = this.f8409u;
        return i5 != Integer.MIN_VALUE ? i5 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarN;
        ActionMenuView actionMenuView = this.f8389a;
        return (actionMenuView == null || (eVarN = actionMenuView.N()) == null || !eVarN.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f8410v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f8409u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f8393e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f8393e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f8389a.getMenu();
    }

    View getNavButtonView() {
        return this.f8392d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f8392d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f8392d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    C0433c getOuterActionMenuPresenter() {
        return this.f8380K;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f8389a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f8398j;
    }

    public int getPopupTheme() {
        return this.f8399k;
    }

    public CharSequence getSubtitle() {
        return this.f8413y;
    }

    final TextView getSubtitleTextView() {
        return this.f8391c;
    }

    public CharSequence getTitle() {
        return this.f8412x;
    }

    public int getTitleMarginBottom() {
        return this.f8407s;
    }

    public int getTitleMarginEnd() {
        return this.f8405q;
    }

    public int getTitleMarginStart() {
        return this.f8404p;
    }

    public int getTitleMarginTop() {
        return this.f8406r;
    }

    final TextView getTitleTextView() {
        return this.f8390b;
    }

    public H getWrapper() {
        if (this.f8379J == null) {
            this.f8379J = new e0(this, true);
        }
        return this.f8379J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof a.C0104a ? new g((a.C0104a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f8388V);
        Q();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f8372C = false;
        }
        if (!this.f8372C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f8372C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f8372C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0297 A[LOOP:0: B:104:0x0295->B:105:0x0297, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b5 A[LOOP:1: B:107:0x02b3->B:108:0x02b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ec A[LOOP:2: B:116:0x02ea->B:117:0x02ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int[] iArr;
        int iMax2;
        int iCombineMeasuredStates2;
        int measuredHeight;
        int[] iArr2 = this.f8375F;
        boolean zB = h0.b(this);
        int i7 = !zB ? 1 : 0;
        if (O(this.f8392d)) {
            F(this.f8392d, i5, 0, i6, 0, this.f8403o);
            measuredWidth = this.f8392d.getMeasuredWidth() + s(this.f8392d);
            iMax = Math.max(0, this.f8392d.getMeasuredHeight() + t(this.f8392d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f8392d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (O(this.f8396h)) {
            F(this.f8396h, i5, 0, i6, 0, this.f8403o);
            measuredWidth = this.f8396h.getMeasuredWidth() + s(this.f8396h);
            iMax = Math.max(iMax, this.f8396h.getMeasuredHeight() + t(this.f8396h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f8396h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr2[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (O(this.f8389a)) {
            F(this.f8389a, i5, iMax3, i6, 0, this.f8403o);
            measuredWidth2 = this.f8389a.getMeasuredWidth() + s(this.f8389a);
            iMax = Math.max(iMax, this.f8389a.getMeasuredHeight() + t(this.f8389a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f8389a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr2[i7] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (O(this.f8397i)) {
            iArr = iArr2;
            iMax4 += E(this.f8397i, i5, iMax4, i6, 0, iArr);
            iMax = Math.max(iMax, this.f8397i.getMeasuredHeight() + t(this.f8397i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f8397i.getMeasuredState());
        } else {
            iArr = iArr2;
        }
        if (O(this.f8393e)) {
            iMax4 += E(this.f8393e, i5, iMax4, i6, 0, iArr);
            iMax = Math.max(iMax, this.f8393e.getMeasuredHeight() + t(this.f8393e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f8393e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (((g) childAt.getLayoutParams()).f8422b == 0 && O(childAt)) {
                iMax4 += E(childAt, i5, iMax4, i6, 0, iArr);
                int iMax5 = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax5;
            } else {
                iMax4 = iMax4;
            }
        }
        int i9 = iMax4;
        int i10 = this.f8406r + this.f8407s;
        int i11 = this.f8404p + this.f8405q;
        if (O(this.f8390b)) {
            E(this.f8390b, i5, i9 + i11, i6, i10, iArr);
            int measuredWidth3 = this.f8390b.getMeasuredWidth() + s(this.f8390b);
            int measuredHeight2 = this.f8390b.getMeasuredHeight() + t(this.f8390b);
            iMax2 = measuredWidth3;
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f8390b.getMeasuredState());
            measuredHeight = measuredHeight2;
        } else {
            iMax2 = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            measuredHeight = 0;
        }
        if (O(this.f8391c)) {
            iMax2 = Math.max(iMax2, E(this.f8391c, i5, i9 + i11, i6, i10 + measuredHeight, iArr));
            measuredHeight += this.f8391c.getMeasuredHeight() + t(this.f8391c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f8391c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i9 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, (-16777216) & iCombineMeasuredStates2), N() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i6, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        ActionMenuView actionMenuView = this.f8389a;
        androidx.appcompat.view.menu.e eVarN = actionMenuView != null ? actionMenuView.N() : null;
        int i5 = iVar.f8423a;
        if (i5 != 0 && this.f8381L != null && eVarN != null && (menuItemFindItem = eVarN.findItem(i5)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.f8424b) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        h();
        this.f8408t.f(i5 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.f8381L;
        if (fVar != null && (gVar = fVar.f8420b) != null) {
            iVar.f8423a = gVar.getItemId();
        }
        iVar.f8424b = B();
        return iVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8371B = false;
        }
        if (!this.f8371B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f8371B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f8371B = false;
        }
        return true;
    }

    @Override // androidx.core.view.InterfaceC0468m
    public void removeMenuProvider(androidx.core.view.r rVar) {
        this.f8376G.j(rVar);
    }

    public void setBackInvokedCallbackEnabled(boolean z5) {
        if (this.f8387U != z5) {
            this.f8387U = z5;
            Q();
        }
    }

    public void setCollapseContentDescription(int i5) {
        setCollapseContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setCollapseIcon(int i5) {
        setCollapseIcon(C0744a.b(getContext(), i5));
    }

    public void setCollapsible(boolean z5) {
        this.f8384R = z5;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.f8410v) {
            this.f8410v = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.f8409u) {
            this.f8409u = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i5) {
        setLogo(C0744a.b(getContext(), i5));
    }

    public void setLogoDescription(int i5) {
        setLogoDescription(getContext().getText(i5));
    }

    public void setNavigationContentDescription(int i5) {
        setNavigationContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setNavigationIcon(int i5) {
        setNavigationIcon(C0744a.b(getContext(), i5));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f8392d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f8389a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i5) {
        if (this.f8399k != i5) {
            this.f8399k = i5;
            if (i5 == 0) {
                this.f8398j = getContext();
            } else {
                this.f8398j = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setSubtitle(int i5) {
        setSubtitle(getContext().getText(i5));
    }

    public void setSubtitleTextColor(int i5) {
        setSubtitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setTitle(int i5) {
        setTitle(getContext().getText(i5));
    }

    public void setTitleMarginBottom(int i5) {
        this.f8407s = i5;
        requestLayout();
    }

    public void setTitleMarginEnd(int i5) {
        this.f8405q = i5;
        requestLayout();
    }

    public void setTitleMarginStart(int i5) {
        this.f8404p = i5;
        requestLayout();
    }

    public void setTitleMarginTop(int i5) {
        this.f8406r = i5;
        requestLayout();
    }

    public void setTitleTextColor(int i5) {
        setTitleTextColor(ColorStateList.valueOf(i5));
    }

    public boolean v() {
        f fVar = this.f8381L;
        return (fVar == null || fVar.f8420b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f8389a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i5) {
        getMenuInflater().inflate(i5, getMenu());
    }

    public void y() {
        ArrayList<MenuItem> arrayList = this.f8377H;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            MenuItem menuItem = arrayList.get(i5);
            i5++;
            getMenu().removeItem(menuItem.getItemId());
        }
        G();
    }

    public static class g extends a.C0104a {

        /* renamed from: b, reason: collision with root package name */
        int f8422b;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8422b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i5, int i6) {
            super(i5, i6);
            this.f8422b = 0;
            this.f7517a = 8388627;
        }

        public g(g gVar) {
            super((a.C0104a) gVar);
            this.f8422b = 0;
            this.f8422b = gVar.f8422b;
        }

        public g(a.C0104a c0104a) {
            super(c0104a);
            this.f8422b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8422b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8422b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f8411w = 8388627;
        this.f8373D = new ArrayList<>();
        this.f8374E = new ArrayList<>();
        this.f8375F = new int[2];
        this.f8376G = new C0471p(new Runnable() { // from class: androidx.appcompat.widget.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f8512a.y();
            }
        });
        this.f8377H = new ArrayList<>();
        this.f8378I = new a();
        this.f8388V = new b();
        Context context2 = getContext();
        int[] iArr = g.j.f17069T2;
        a0 a0VarV = a0.v(context2, attributeSet, iArr, i5, 0);
        androidx.core.view.H.i0(this, context, iArr, attributeSet, a0VarV.r(), i5, 0);
        this.f8400l = a0VarV.n(g.j.f17203v3, 0);
        this.f8401m = a0VarV.n(g.j.f17158m3, 0);
        this.f8411w = a0VarV.l(g.j.f17073U2, this.f8411w);
        this.f8402n = a0VarV.l(g.j.f17077V2, 48);
        int iE = a0VarV.e(g.j.f17173p3, 0);
        int i6 = g.j.f17198u3;
        iE = a0VarV.s(i6) ? a0VarV.e(i6, iE) : iE;
        this.f8407s = iE;
        this.f8406r = iE;
        this.f8405q = iE;
        this.f8404p = iE;
        int iE2 = a0VarV.e(g.j.f17188s3, -1);
        if (iE2 >= 0) {
            this.f8404p = iE2;
        }
        int iE3 = a0VarV.e(g.j.f17183r3, -1);
        if (iE3 >= 0) {
            this.f8405q = iE3;
        }
        int iE4 = a0VarV.e(g.j.f17193t3, -1);
        if (iE4 >= 0) {
            this.f8406r = iE4;
        }
        int iE5 = a0VarV.e(g.j.f17178q3, -1);
        if (iE5 >= 0) {
            this.f8407s = iE5;
        }
        this.f8403o = a0VarV.f(g.j.f17128g3, -1);
        int iE6 = a0VarV.e(g.j.f17108c3, Integer.MIN_VALUE);
        int iE7 = a0VarV.e(g.j.f17089Y2, Integer.MIN_VALUE);
        int iF = a0VarV.f(g.j.f17098a3, 0);
        int iF2 = a0VarV.f(g.j.f17103b3, 0);
        h();
        this.f8408t.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.f8408t.g(iE6, iE7);
        }
        this.f8409u = a0VarV.e(g.j.f17113d3, Integer.MIN_VALUE);
        this.f8410v = a0VarV.e(g.j.f17093Z2, Integer.MIN_VALUE);
        this.f8394f = a0VarV.g(g.j.f17085X2);
        this.f8395g = a0VarV.p(g.j.f17081W2);
        CharSequence charSequenceP = a0VarV.p(g.j.f17168o3);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = a0VarV.p(g.j.f17153l3);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f8398j = getContext();
        setPopupTheme(a0VarV.n(g.j.f17148k3, 0));
        Drawable drawableG = a0VarV.g(g.j.f17143j3);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = a0VarV.p(g.j.f17138i3);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = a0VarV.g(g.j.f17118e3);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = a0VarV.p(g.j.f17123f3);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i7 = g.j.f17208w3;
        if (a0VarV.s(i7)) {
            setTitleTextColor(a0VarV.c(i7));
        }
        int i8 = g.j.f17163n3;
        if (a0VarV.s(i8)) {
            setSubtitleTextColor(a0VarV.c(i8));
        }
        int i9 = g.j.f17133h3;
        if (a0VarV.s(i9)) {
            x(a0VarV.n(i9, 0));
        }
        a0VarV.x();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f8396h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f8396h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f8396h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f8394f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f8393e)) {
                c(this.f8393e, true);
            }
        } else {
            ImageView imageView = this.f8393e;
            if (imageView != null && z(imageView)) {
                removeView(this.f8393e);
                this.f8374E.remove(this.f8393e);
            }
        }
        ImageView imageView2 = this.f8393e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f8393e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f8392d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            f0.a(this.f8392d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f8392d)) {
                c(this.f8392d, true);
            }
        } else {
            ImageButton imageButton = this.f8392d;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f8392d);
                this.f8374E.remove(this.f8392d);
            }
        }
        ImageButton imageButton2 = this.f8392d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f8391c;
            if (textView != null && z(textView)) {
                removeView(this.f8391c);
                this.f8374E.remove(this.f8391c);
            }
        } else {
            if (this.f8391c == null) {
                Context context = getContext();
                D d6 = new D(context);
                this.f8391c = d6;
                d6.setSingleLine();
                this.f8391c.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.f8401m;
                if (i5 != 0) {
                    this.f8391c.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.f8370A;
                if (colorStateList != null) {
                    this.f8391c.setTextColor(colorStateList);
                }
            }
            if (!z(this.f8391c)) {
                c(this.f8391c, true);
            }
        }
        TextView textView2 = this.f8391c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f8413y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f8370A = colorStateList;
        TextView textView = this.f8391c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f8390b;
            if (textView != null && z(textView)) {
                removeView(this.f8390b);
                this.f8374E.remove(this.f8390b);
            }
        } else {
            if (this.f8390b == null) {
                Context context = getContext();
                D d6 = new D(context);
                this.f8390b = d6;
                d6.setSingleLine();
                this.f8390b.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.f8400l;
                if (i5 != 0) {
                    this.f8390b.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.f8414z;
                if (colorStateList != null) {
                    this.f8390b.setTextColor(colorStateList);
                }
            }
            if (!z(this.f8390b)) {
                c(this.f8390b, true);
            }
        }
        TextView textView2 = this.f8390b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f8412x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f8414z = colorStateList;
        TextView textView = this.f8390b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class i extends androidx.customview.view.a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f8423a;

        /* renamed from: b, reason: collision with root package name */
        boolean f8424b;

        class a implements Parcelable.ClassLoaderCreator<i> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i5) {
                return new i[i5];
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8423a = parcel.readInt();
            this.f8424b = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f8423a);
            parcel.writeInt(this.f8424b ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
