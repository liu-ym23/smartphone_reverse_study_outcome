package androidx.appcompat.widget;

import a1.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import androidx.fragment.app.r;
import com.stepos.agentsafetycenter.R;
import g.a;
import h.b;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k.i;
import l.l;
import l.n;
import m.c1;
import m.f2;
import m.k;
import m.o2;
import m.p2;
import m.q2;
import m.r2;
import m.s2;
import m.t2;
import m.u2;
import m.v0;
import m.v2;
import m.w;
import m.w2;
import m.x;
import n3.i0;
import n3.k0;
import n3.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public final int A;
    public CharSequence B;
    public CharSequence C;
    public ColorStateList D;
    public ColorStateList E;
    public boolean F;
    public boolean G;
    public final ArrayList H;
    public final ArrayList I;
    public final int[] J;
    public final m K;
    public ArrayList L;
    public final g M;
    public v2 N;
    public k O;
    public q2 P;
    public boolean Q;
    public OnBackInvokedCallback R;
    public OnBackInvokedDispatcher S;
    public boolean T;
    public final r U;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f804c;

    /* renamed from: f, reason: collision with root package name */
    public v0 f805f;

    /* renamed from: g, reason: collision with root package name */
    public v0 f806g;

    /* renamed from: h, reason: collision with root package name */
    public w f807h;
    public x i;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f808j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f809k;

    /* renamed from: l, reason: collision with root package name */
    public w f810l;

    /* renamed from: m, reason: collision with root package name */
    public View f811m;

    /* renamed from: n, reason: collision with root package name */
    public Context f812n;

    /* renamed from: o, reason: collision with root package name */
    public int f813o;

    /* renamed from: p, reason: collision with root package name */
    public int f814p;

    /* renamed from: q, reason: collision with root package name */
    public int f815q;

    /* renamed from: r, reason: collision with root package name */
    public final int f816r;

    /* renamed from: s, reason: collision with root package name */
    public final int f817s;

    /* renamed from: t, reason: collision with root package name */
    public int f818t;

    /* renamed from: u, reason: collision with root package name */
    public int f819u;

    /* renamed from: v, reason: collision with root package name */
    public int f820v;

    /* renamed from: w, reason: collision with root package name */
    public int f821w;

    /* renamed from: x, reason: collision with root package name */
    public f2 f822x;

    /* renamed from: y, reason: collision with root package name */
    public int f823y;

    /* renamed from: z, reason: collision with root package name */
    public int f824z;

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.A = 8388627;
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.J = new int[2];
        o2 o2Var = new o2(1);
        o2Var.f8042f = this;
        VarHandle.storeStoreFence();
        this.K = new m(o2Var);
        this.L = new ArrayList();
        g gVar = new g(20, false);
        gVar.f19f = this;
        VarHandle.storeStoreFence();
        this.M = gVar;
        r rVar = new r(8);
        rVar.f1301f = this;
        VarHandle.storeStoreFence();
        this.U = rVar;
        Context context2 = getContext();
        int[] iArr = a.f4120x;
        p5.m mVarJ = p5.m.J(context2, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        WeakHashMap weakHashMap = k0.f8724a;
        i0.b(this, context, iArr, attributeSet, typedArray, i, 0);
        TypedArray typedArray2 = (TypedArray) mVarJ.f9742g;
        this.f814p = typedArray2.getResourceId(31, 0);
        this.f815q = typedArray2.getResourceId(22, 0);
        this.A = typedArray2.getInteger(0, 8388627);
        this.f816r = typedArray2.getInteger(2, 48);
        int dimensionPixelOffset = typedArray2.getDimensionPixelOffset(25, 0);
        dimensionPixelOffset = typedArray2.hasValue(30) ? typedArray2.getDimensionPixelOffset(30, dimensionPixelOffset) : dimensionPixelOffset;
        this.f821w = dimensionPixelOffset;
        this.f820v = dimensionPixelOffset;
        this.f819u = dimensionPixelOffset;
        this.f818t = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray2.getDimensionPixelOffset(28, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f818t = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray2.getDimensionPixelOffset(27, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f819u = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray2.getDimensionPixelOffset(29, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f820v = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray2.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f821w = dimensionPixelOffset5;
        }
        this.f817s = typedArray2.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray2.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray2.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray2.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray2.getDimensionPixelSize(8, 0);
        d();
        f2 f2Var = this.f822x;
        f2Var.i = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            f2Var.f7909f = dimensionPixelSize;
            f2Var.f7905b = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            f2Var.f7910g = dimensionPixelSize2;
            f2Var.f7906c = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            f2Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f823y = typedArray2.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f824z = typedArray2.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f808j = mVarJ.A(4);
        this.f809k = typedArray2.getText(3);
        CharSequence text = typedArray2.getText(24);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray2.getText(21);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f812n = getContext();
        setPopupTheme(typedArray2.getResourceId(17, 0));
        Drawable drawableA = mVarJ.A(16);
        if (drawableA != null) {
            setNavigationIcon(drawableA);
        }
        CharSequence text3 = typedArray2.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableA2 = mVarJ.A(11);
        if (drawableA2 != null) {
            setLogo(drawableA2);
        }
        CharSequence text4 = typedArray2.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray2.hasValue(32)) {
            setTitleTextColor(mVarJ.z(32));
        }
        if (typedArray2.hasValue(23)) {
            setSubtitleTextColor(mVarJ.z(23));
        }
        if (typedArray2.hasValue(14)) {
            getMenuInflater().inflate(typedArray2.getResourceId(14, 0), getMenu());
        }
        mVarJ.M();
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new i(getContext());
    }

    public static r2 h() {
        r2 r2Var = new r2(-2, -2);
        r2Var.f8059b = 0;
        r2Var.f8058a = 8388627;
        return r2Var;
    }

    public static r2 i(ViewGroup.LayoutParams layoutParams) {
        boolean z10 = layoutParams instanceof r2;
        if (z10) {
            r2 r2Var = (r2) layoutParams;
            r2 r2Var2 = new r2(r2Var);
            r2Var2.f8059b = 0;
            r2Var2.f8059b = r2Var.f8059b;
            return r2Var2;
        }
        if (z10) {
            r2 r2Var3 = new r2((r2) layoutParams);
            r2Var3.f8059b = 0;
            return r2Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            r2 r2Var4 = new r2(layoutParams);
            r2Var4.f8059b = 0;
            return r2Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        r2 r2Var5 = new r2(marginLayoutParams);
        r2Var5.f8059b = 0;
        ((ViewGroup.MarginLayoutParams) r2Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) r2Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) r2Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) r2Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return r2Var5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i) {
        boolean z10 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z10) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                r2 r2Var = (r2) childAt.getLayoutParams();
                if (r2Var.f8059b == 0 && s(childAt)) {
                    int i10 = r2Var.f8058a;
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
            r2 r2Var2 = (r2) childAt2.getLayoutParams();
            if (r2Var2.f8059b == 0 && s(childAt2)) {
                int i12 = r2Var2.f8058a;
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

    public final void b(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        r2 r2VarH = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (r2) layoutParams;
        r2VarH.f8059b = 1;
        if (!z10 || this.f811m == null) {
            addView(view, r2VarH);
        } else {
            view.setLayoutParams(r2VarH);
            this.I.add(view);
        }
    }

    public final void c() {
        if (this.f810l == null) {
            w wVar = new w(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f810l = wVar;
            wVar.setImageDrawable(this.f808j);
            this.f810l.setContentDescription(this.f809k);
            r2 r2VarH = h();
            r2VarH.f8058a = (this.f816r & 112) | 8388611;
            r2VarH.f8059b = 2;
            this.f810l.setLayoutParams(r2VarH);
            w wVar2 = this.f810l;
            b bVar = new b(2);
            bVar.f4749f = this;
            VarHandle.storeStoreFence();
            wVar2.setOnClickListener(bVar);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof r2);
    }

    public final void d() {
        if (this.f822x == null) {
            f2 f2Var = new f2(0);
            f2Var.f7905b = 0;
            f2Var.f7906c = 0;
            f2Var.f7907d = Integer.MIN_VALUE;
            f2Var.f7908e = Integer.MIN_VALUE;
            f2Var.f7909f = 0;
            f2Var.f7910g = 0;
            f2Var.f7911h = false;
            f2Var.i = false;
            this.f822x = f2Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f804c;
        if (actionMenuView.f792t == null) {
            l lVar = (l) actionMenuView.getMenu();
            if (this.P == null) {
                this.P = new q2(this);
            }
            this.f804c.setExpandedActionViewsExclusive(true);
            lVar.b(this.P, this.f812n);
            t();
        }
    }

    public final void f() {
        if (this.f804c == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f804c = actionMenuView;
            actionMenuView.setPopupTheme(this.f813o);
            this.f804c.setOnMenuItemClickListener(this.M);
            ActionMenuView actionMenuView2 = this.f804c;
            a2.i iVar = new a2.i(18);
            iVar.f49f = this;
            VarHandle.storeStoreFence();
            actionMenuView2.getClass();
            actionMenuView2.f797y = iVar;
            r2 r2VarH = h();
            r2VarH.f8058a = (this.f816r & 112) | 8388613;
            this.f804c.setLayoutParams(r2VarH);
            b(this.f804c, false);
        }
    }

    public final void g() {
        if (this.f807h == null) {
            this.f807h = new w(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            r2 r2VarH = h();
            r2VarH.f8058a = (this.f816r & 112) | 8388611;
            this.f807h.setLayoutParams(r2VarH);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        r2 r2Var = new r2(context, attributeSet);
        r2Var.f8058a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f4099b);
        r2Var.f8058a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        r2Var.f8059b = 0;
        return r2Var;
    }

    public CharSequence getCollapseContentDescription() {
        w wVar = this.f810l;
        if (wVar != null) {
            return wVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        w wVar = this.f810l;
        if (wVar != null) {
            return wVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        f2 f2Var = this.f822x;
        if (f2Var != null) {
            return f2Var.f7911h ? f2Var.f7905b : f2Var.f7906c;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.f824z;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        f2 f2Var = this.f822x;
        if (f2Var != null) {
            return f2Var.f7905b;
        }
        return 0;
    }

    public int getContentInsetRight() {
        f2 f2Var = this.f822x;
        if (f2Var != null) {
            return f2Var.f7906c;
        }
        return 0;
    }

    public int getContentInsetStart() {
        f2 f2Var = this.f822x;
        if (f2Var != null) {
            return f2Var.f7911h ? f2Var.f7906c : f2Var.f7905b;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.f823y;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        l lVar;
        ActionMenuView actionMenuView = this.f804c;
        return (actionMenuView == null || (lVar = actionMenuView.f792t) == null || !lVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f824z, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f823y, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        x xVar = this.i;
        if (xVar != null) {
            return xVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        x xVar = this.i;
        if (xVar != null) {
            return xVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f804c.getMenu();
    }

    public View getNavButtonView() {
        return this.f807h;
    }

    public CharSequence getNavigationContentDescription() {
        w wVar = this.f807h;
        if (wVar != null) {
            return wVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        w wVar = this.f807h;
        if (wVar != null) {
            return wVar.getDrawable();
        }
        return null;
    }

    public k getOuterActionMenuPresenter() {
        return this.O;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f804c.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f812n;
    }

    public int getPopupTheme() {
        return this.f813o;
    }

    public CharSequence getSubtitle() {
        return this.C;
    }

    public final TextView getSubtitleTextView() {
        return this.f806g;
    }

    public CharSequence getTitle() {
        return this.B;
    }

    public int getTitleMarginBottom() {
        return this.f821w;
    }

    public int getTitleMarginEnd() {
        return this.f819u;
    }

    public int getTitleMarginStart() {
        return this.f818t;
    }

    public int getTitleMarginTop() {
        return this.f820v;
    }

    public final TextView getTitleTextView() {
        return this.f805f;
    }

    public c1 getWrapper() {
        Drawable drawable;
        if (this.N == null) {
            v2 v2Var = new v2();
            v2Var.f8109n = 0;
            v2Var.f8097a = this;
            v2Var.f8104h = getTitle();
            v2Var.i = getSubtitle();
            v2Var.f8103g = v2Var.f8104h != null;
            v2Var.f8102f = getNavigationIcon();
            p5.m mVarJ = p5.m.J(getContext(), null, a.f4098a, R.attr.actionBarStyle);
            TypedArray typedArray = (TypedArray) mVarJ.f9742g;
            v2Var.f8110o = mVarJ.A(15);
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                v2Var.f8103g = true;
                v2Var.f8104h = text;
                if ((v2Var.f8098b & 8) != 0) {
                    setTitle(text);
                    if (v2Var.f8103g) {
                        k0.h(getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                v2Var.i = text2;
                if ((v2Var.f8098b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable drawableA = mVarJ.A(20);
            if (drawableA != null) {
                v2Var.f8101e = drawableA;
                v2Var.d();
            }
            Drawable drawableA2 = mVarJ.A(17);
            if (drawableA2 != null) {
                v2Var.f8100d = drawableA2;
                v2Var.d();
            }
            if (v2Var.f8102f == null && (drawable = v2Var.f8110o) != null) {
                v2Var.f8102f = drawable;
                if ((v2Var.f8098b & 4) != 0) {
                    setNavigationIcon(drawable);
                } else {
                    setNavigationIcon((Drawable) null);
                }
            }
            v2Var.a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = v2Var.f8099c;
                if (view != null && (v2Var.f8098b & 16) != 0) {
                    removeView(view);
                }
                v2Var.f8099c = viewInflate;
                if (viewInflate != null && (v2Var.f8098b & 16) != 0) {
                    addView(viewInflate);
                }
                v2Var.a(v2Var.f8098b | 16);
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
                this.f822x.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f814p = resourceId2;
                v0 v0Var = this.f805f;
                if (v0Var != null) {
                    v0Var.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.f815q = resourceId3;
                v0 v0Var2 = this.f806g;
                if (v0Var2 != null) {
                    v0Var2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            mVarJ.M();
            if (R.string.abc_action_bar_up_description != v2Var.f8109n) {
                v2Var.f8109n = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i = v2Var.f8109n;
                    v2Var.f8105j = i == 0 ? null : getContext().getString(i);
                    v2Var.c();
                }
            }
            v2Var.f8105j = getNavigationContentDescription();
            u2 u2Var = new u2();
            u2Var.f8088f = v2Var;
            Context context3 = getContext();
            CharSequence charSequence = v2Var.f8104h;
            l.a aVar = new l.a();
            aVar.f7510e = 4096;
            aVar.f7512g = 4096;
            aVar.f7516l = null;
            aVar.f7517m = null;
            aVar.f7518n = false;
            aVar.f7519o = false;
            aVar.f7520p = 16;
            aVar.i = context3;
            aVar.f7506a = charSequence;
            VarHandle.storeStoreFence();
            u2Var.f8087c = aVar;
            VarHandle.storeStoreFence();
            setNavigationOnClickListener(u2Var);
            this.N = v2Var;
        }
        return this.N;
    }

    public final int j(int i, View view) {
        r2 r2Var = (r2) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i10 = r2Var.f8058a & 112;
        if (i10 != 16 && i10 != 48 && i10 != 80) {
            i10 = this.A & 112;
        }
        if (i10 == 48) {
            return getPaddingTop() - i3;
        }
        if (i10 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) r2Var).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i11 = ((ViewGroup.MarginLayoutParams) r2Var).topMargin;
        if (iMax < i11) {
            iMax = i11;
        } else {
            int i12 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i13 = ((ViewGroup.MarginLayoutParams) r2Var).bottomMargin;
            if (i12 < i13) {
                iMax = Math.max(0, iMax - (i13 - i12));
            }
        }
        return paddingTop + iMax;
    }

    public final void m() {
        ArrayList arrayList = this.L;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        this.K.a();
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.L = currentMenuItems2;
    }

    public final boolean n(View view) {
        return view.getParent() == this || this.I.contains(view);
    }

    public final int o(View view, int i, int i3, int[] iArr) {
        r2 r2Var = (r2) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) r2Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i10) + i;
        iArr[0] = Math.max(0, -i10);
        int iJ = j(i3, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iJ, iMax + measuredWidth, view.getMeasuredHeight() + iJ);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) r2Var).rightMargin + iMax;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.U);
        t();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.G = false;
        }
        if (!this.G) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.G = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.G = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0285 A[LOOP:0: B:107:0x0283->B:108:0x0285, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x029d A[LOOP:1: B:110:0x029b->B:111:0x029d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02bd A[LOOP:2: B:113:0x02bb->B:114:0x02bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0310 A[LOOP:3: B:122:0x030e->B:123:0x0310, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x020e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 801
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        char c9;
        Object[] objArr;
        int iK;
        int iMax;
        int iCombineMeasuredStates;
        int iK2;
        int iL;
        int iCombineMeasuredStates2;
        int iMax2;
        int i10 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c9 = 0;
        } else {
            c9 = 1;
            objArr = false;
        }
        if (s(this.f807h)) {
            r(this.f807h, i, 0, i3, this.f817s);
            iK = k(this.f807h) + this.f807h.getMeasuredWidth();
            iMax = Math.max(0, l(this.f807h) + this.f807h.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f807h.getMeasuredState());
        } else {
            iK = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (s(this.f810l)) {
            r(this.f810l, i, 0, i3, this.f817s);
            iK = k(this.f810l) + this.f810l.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.f810l) + this.f810l.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f810l.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iK);
        int iMax4 = Math.max(0, currentContentInsetStart - iK);
        Object[] objArr2 = objArr;
        int[] iArr = this.J;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (s(this.f804c)) {
            r(this.f804c, i, iMax3, i3, this.f817s);
            iK2 = k(this.f804c) + this.f804c.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.f804c) + this.f804c.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f804c.getMeasuredState());
        } else {
            iK2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iK2);
        iArr[c9] = Math.max(0, currentContentInsetEnd - iK2);
        if (s(this.f811m)) {
            iMax5 += q(this.f811m, i, iMax5, i3, 0, iArr);
            iMax = Math.max(iMax, l(this.f811m) + this.f811m.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f811m.getMeasuredState());
        }
        if (s(this.i)) {
            iMax5 += q(this.i, i, iMax5, i3, 0, iArr);
            iMax = Math.max(iMax, l(this.i) + this.i.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.i.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((r2) childAt.getLayoutParams()).f8059b == 0 && s(childAt)) {
                iMax5 += q(childAt, i, iMax5, i3, 0, iArr);
                int iMax6 = Math.max(iMax, l(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i12 = iMax5;
        int i13 = this.f820v + this.f821w;
        int i14 = this.f818t + this.f819u;
        if (s(this.f805f)) {
            q(this.f805f, i, i12 + i14, i3, i13, iArr);
            int iK3 = k(this.f805f) + this.f805f.getMeasuredWidth();
            iL = l(this.f805f) + this.f805f.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f805f.getMeasuredState());
            iMax2 = iK3;
        } else {
            iL = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (s(this.f806g)) {
            iMax2 = Math.max(iMax2, q(this.f806g, i, i12 + i14, i3, i13 + iL, iArr));
            iL += l(this.f806g) + this.f806g.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f806g.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iL);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i12 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16);
        if (!this.Q) {
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
        if (!(parcelable instanceof t2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        t2 t2Var = (t2) parcelable;
        super.onRestoreInstanceState(t2Var.getSuperState());
        ActionMenuView actionMenuView = this.f804c;
        l lVar = actionMenuView != null ? actionMenuView.f792t : null;
        int i = t2Var.f8079c;
        if (i != 0 && this.P != null && lVar != null && (menuItemFindItem = lVar.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (t2Var.f8080f) {
            r rVar = this.U;
            removeCallbacks(rVar);
            post(rVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        d();
        f2 f2Var = this.f822x;
        boolean z10 = i == 1;
        if (z10 == f2Var.f7911h) {
            return;
        }
        f2Var.f7911h = z10;
        if (!f2Var.i) {
            f2Var.f7905b = f2Var.f7909f;
            f2Var.f7906c = f2Var.f7910g;
            return;
        }
        if (z10) {
            int i3 = f2Var.f7908e;
            if (i3 == Integer.MIN_VALUE) {
                i3 = f2Var.f7909f;
            }
            f2Var.f7905b = i3;
            int i10 = f2Var.f7907d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = f2Var.f7910g;
            }
            f2Var.f7906c = i10;
            return;
        }
        int i11 = f2Var.f7907d;
        if (i11 == Integer.MIN_VALUE) {
            i11 = f2Var.f7909f;
        }
        f2Var.f7905b = i11;
        int i12 = f2Var.f7908e;
        if (i12 == Integer.MIN_VALUE) {
            i12 = f2Var.f7910g;
        }
        f2Var.f7906c = i12;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        k kVar;
        n nVar;
        t2 t2Var = new t2(super.onSaveInstanceState());
        q2 q2Var = this.P;
        if (q2Var != null && (nVar = q2Var.f8052f) != null) {
            t2Var.f8079c = nVar.f7610a;
        }
        ActionMenuView actionMenuView = this.f804c;
        t2Var.f8080f = (actionMenuView == null || (kVar = actionMenuView.f796x) == null || !kVar.h()) ? false : true;
        return t2Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.F = false;
        }
        if (!this.F) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.F = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.F = false;
        return true;
    }

    public final int p(View view, int i, int i3, int[] iArr) {
        r2 r2Var = (r2) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) r2Var).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i10);
        iArr[1] = Math.max(0, -i10);
        int iJ = j(i3, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iJ, iMax, view.getMeasuredHeight() + iJ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) r2Var).leftMargin);
    }

    public final int q(View view, int i, int i3, int i10, int i11, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i12 = marginLayoutParams.leftMargin - iArr[0];
        int i13 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i13) + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        iArr[1] = Math.max(0, -i13);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void r(View view, int i, int i3, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
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

    public final boolean s(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.T != z10) {
            this.T = z10;
            t();
        }
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        w wVar = this.f810l;
        if (wVar != null) {
            wVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f810l.setImageDrawable(drawable);
        } else {
            w wVar = this.f810l;
            if (wVar != null) {
                wVar.setImageDrawable(this.f808j);
            }
        }
    }

    public void setCollapsible(boolean z10) {
        this.Q = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f824z) {
            this.f824z = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f823y) {
            this.f823y = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(Drawable drawable) {
        x xVar = this.i;
        if (drawable != null) {
            if (xVar == null) {
                this.i = new x(getContext(), null, 0);
            }
            if (!n(this.i)) {
                b(this.i, true);
            }
        } else if (xVar != null && n(xVar)) {
            removeView(this.i);
            this.I.remove(this.i);
        }
        x xVar2 = this.i;
        if (xVar2 != null) {
            xVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.i == null) {
            this.i = new x(getContext(), null, 0);
        }
        x xVar = this.i;
        if (xVar != null) {
            xVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        w wVar = this.f807h;
        if (wVar != null) {
            wVar.setContentDescription(charSequence);
            w2.a(this.f807h, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!n(this.f807h)) {
                b(this.f807h, true);
            }
        } else {
            w wVar = this.f807h;
            if (wVar != null && n(wVar)) {
                removeView(this.f807h);
                this.I.remove(this.f807h);
            }
        }
        w wVar2 = this.f807h;
        if (wVar2 != null) {
            wVar2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f807h.setOnClickListener(onClickListener);
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f804c.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f813o != i) {
            this.f813o = i;
            if (i == 0) {
                this.f812n = getContext();
            } else {
                this.f812n = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        v0 v0Var = this.f806g;
        if (!zIsEmpty) {
            if (v0Var == null) {
                Context context = getContext();
                v0 v0Var2 = new v0(context, null);
                this.f806g = v0Var2;
                v0Var2.setSingleLine();
                this.f806g.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f815q;
                if (i != 0) {
                    this.f806g.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.f806g.setTextColor(colorStateList);
                }
            }
            if (!n(this.f806g)) {
                b(this.f806g, true);
            }
        } else if (v0Var != null && n(v0Var)) {
            removeView(this.f806g);
            this.I.remove(this.f806g);
        }
        v0 v0Var3 = this.f806g;
        if (v0Var3 != null) {
            v0Var3.setText(charSequence);
        }
        this.C = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        v0 v0Var = this.f806g;
        if (v0Var != null) {
            v0Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        v0 v0Var = this.f805f;
        if (!zIsEmpty) {
            if (v0Var == null) {
                Context context = getContext();
                v0 v0Var2 = new v0(context, null);
                this.f805f = v0Var2;
                v0Var2.setSingleLine();
                this.f805f.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f814p;
                if (i != 0) {
                    this.f805f.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.D;
                if (colorStateList != null) {
                    this.f805f.setTextColor(colorStateList);
                }
            }
            if (!n(this.f805f)) {
                b(this.f805f, true);
            }
        } else if (v0Var != null && n(v0Var)) {
            removeView(this.f805f);
            this.I.remove(this.f805f);
        }
        v0 v0Var3 = this.f805f;
        if (v0Var3 != null) {
            v0Var3.setText(charSequence);
        }
        this.B = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.f821w = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f819u = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f818t = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f820v = i;
        requestLayout();
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        v0 v0Var = this.f805f;
        if (v0Var != null) {
            v0Var.setTextColor(colorStateList);
        }
    }

    public final void t() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedDispatcher onBackInvokedDispatcherA = p2.a(this);
        q2 q2Var = this.P;
        int i = 0;
        boolean z10 = (q2Var == null || q2Var.f8052f == null || onBackInvokedDispatcherA == null || !isAttachedToWindow() || !this.T) ? false : true;
        if (!z10 || this.S != null) {
            if (z10 || (onBackInvokedDispatcher = this.S) == null) {
                return;
            }
            p2.d(onBackInvokedDispatcher, this.R);
            this.S = null;
            return;
        }
        if (this.R == null) {
            o2 o2Var = new o2(i);
            o2Var.f8042f = this;
            VarHandle.storeStoreFence();
            this.R = p2.b(o2Var);
        }
        p2.c(onBackInvokedDispatcherA, this.R);
        this.S = onBackInvokedDispatcherA;
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(id.k.v(i, getContext()));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setOnMenuItemClickListener(s2 s2Var) {
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(id.k.v(i, getContext()));
    }

    public void setLogo(int i) {
        setLogo(id.k.v(i, getContext()));
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context) {
        this(context, null);
    }
}
