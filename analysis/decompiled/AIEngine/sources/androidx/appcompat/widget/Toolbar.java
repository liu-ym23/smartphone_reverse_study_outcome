package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements v0.h {
    public CharSequence A;
    public CharSequence B;
    public ColorStateList C;
    public ColorStateList D;
    public boolean E;
    public boolean F;
    public final ArrayList<View> G;
    public final ArrayList<View> H;
    public final int[] I;
    public final v0.k J;
    public ArrayList<MenuItem> K;
    public final a L;
    public b1 M;
    public ActionMenuPresenter N;
    public f O;
    public boolean P;
    public OnBackInvokedCallback Q;
    public OnBackInvokedDispatcher R;
    public boolean S;
    public final b T;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f705a;

    /* renamed from: b, reason: collision with root package name */
    public AppCompatTextView f706b;

    /* renamed from: c, reason: collision with root package name */
    public AppCompatTextView f707c;

    /* renamed from: d, reason: collision with root package name */
    public n f708d;

    /* renamed from: e, reason: collision with root package name */
    public p f709e;
    public final Drawable h;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f710j;

    /* renamed from: k, reason: collision with root package name */
    public n f711k;

    /* renamed from: l, reason: collision with root package name */
    public View f712l;

    /* renamed from: m, reason: collision with root package name */
    public Context f713m;

    /* renamed from: n, reason: collision with root package name */
    public int f714n;

    /* renamed from: o, reason: collision with root package name */
    public int f715o;

    /* renamed from: p, reason: collision with root package name */
    public int f716p;

    /* renamed from: q, reason: collision with root package name */
    public final int f717q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public int f718s;

    /* renamed from: t, reason: collision with root package name */
    public int f719t;

    /* renamed from: u, reason: collision with root package name */
    public int f720u;

    /* renamed from: v, reason: collision with root package name */
    public int f721v;

    /* renamed from: w, reason: collision with root package name */
    public p0 f722w;

    /* renamed from: x, reason: collision with root package name */
    public int f723x;

    /* renamed from: y, reason: collision with root package name */
    public int f724y;
    public final int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i10) {
                return new SavedState[i10];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ActionMenuView.e {
        public a() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionMenuPresenter actionMenuPresenter;
            ActionMenuView actionMenuView = Toolbar.this.f705a;
            if (actionMenuView == null || (actionMenuPresenter = actionMenuView.f621w) == null) {
                return;
            }
            actionMenuPresenter.l();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements f.a {
        public c() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            Toolbar.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f fVar) {
            Toolbar toolbar = Toolbar.this;
            ActionMenuPresenter actionMenuPresenter = toolbar.f705a.f621w;
            if (actionMenuPresenter == null || !actionMenuPresenter.k()) {
                Iterator<v0.l> it = toolbar.J.f13295b.iterator();
                while (it.hasNext()) {
                    it.next().b(fVar);
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            f fVar = Toolbar.this.O;
            androidx.appcompat.view.menu.h hVar = fVar == null ? null : fVar.f730b;
            if (hVar != null) {
                hVar.collapseActionView();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e {
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new androidx.appcompat.app.p(runnable, 1);
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class g extends a.C0001a {

        /* renamed from: b, reason: collision with root package name */
        public int f732b;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface h {
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new k.f(getContext());
    }

    public static g h() {
        g gVar = new g(-2, -2);
        gVar.f732b = 0;
        gVar.f315a = 8388627;
        return gVar;
    }

    public static g i(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof g) {
            g gVar = (g) layoutParams;
            g gVar2 = new g(gVar);
            gVar2.f732b = 0;
            gVar2.f732b = gVar.f732b;
            return gVar2;
        }
        if (layoutParams instanceof a.C0001a) {
            g gVar3 = new g((a.C0001a) layoutParams);
            gVar3.f732b = 0;
            return gVar3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            g gVar4 = new g(layoutParams);
            gVar4.f732b = 0;
            return gVar4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        g gVar5 = new g(marginLayoutParams);
        gVar5.f732b = 0;
        ((ViewGroup.MarginLayoutParams) gVar5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) gVar5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) gVar5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) gVar5).bottomMargin = marginLayoutParams.bottomMargin;
        return gVar5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i10) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i10, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f732b == 0 && t(childAt)) {
                    int i12 = gVar.f315a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i12, layoutDirection) & 7;
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
        for (int i13 = childCount - 1; i13 >= 0; i13--) {
            View childAt2 = getChildAt(i13);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f732b == 0 && t(childAt2)) {
                int i14 = gVar2.f315a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i14, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // v0.h
    public final void addMenuProvider(v0.l lVar) {
        v0.k kVar = this.J;
        kVar.f13295b.add(lVar);
        kVar.f13294a.run();
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarH = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (g) layoutParams;
        gVarH.f732b = 1;
        if (!z || this.f712l == null) {
            addView(view, gVarH);
        } else {
            view.setLayoutParams(gVarH);
            this.H.add(view);
        }
    }

    public final void c() {
        if (this.f711k == null) {
            n nVar = new n(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f711k = nVar;
            nVar.setImageDrawable(this.h);
            this.f711k.setContentDescription(this.f710j);
            g gVarH = h();
            gVarH.f315a = (this.f717q & 112) | 8388611;
            gVarH.f732b = 2;
            this.f711k.setLayoutParams(gVarH);
            this.f711k.setOnClickListener(new d());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public final void d() {
        if (this.f722w == null) {
            p0 p0Var = new p0(0);
            p0Var.f910b = 0;
            p0Var.f911c = 0;
            p0Var.f912d = Integer.MIN_VALUE;
            p0Var.f913e = Integer.MIN_VALUE;
            p0Var.f914f = 0;
            p0Var.f915g = 0;
            p0Var.h = false;
            p0Var.f916i = false;
            this.f722w = p0Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f705a;
        if (actionMenuView.f617s == null) {
            androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) actionMenuView.getMenu();
            if (this.O == null) {
                this.O = new f();
            }
            this.f705a.setExpandedActionViewsExclusive(true);
            fVar.b(this.O, this.f713m);
            u();
        }
    }

    public final void f() {
        if (this.f705a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f705a = actionMenuView;
            actionMenuView.setPopupTheme(this.f714n);
            this.f705a.setOnMenuItemClickListener(this.L);
            ActionMenuView actionMenuView2 = this.f705a;
            c cVar = new c();
            actionMenuView2.getClass();
            actionMenuView2.f622x = cVar;
            g gVarH = h();
            gVarH.f315a = (this.f717q & 112) | 8388613;
            this.f705a.setLayoutParams(gVarH);
            b(this.f705a, false);
        }
    }

    public final void g() {
        if (this.f708d == null) {
            this.f708d = new n(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            g gVarH = h();
            gVarH.f315a = (this.f717q & 112) | 8388611;
            this.f708d.setLayoutParams(gVarH);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        n nVar = this.f711k;
        if (nVar != null) {
            return nVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        n nVar = this.f711k;
        if (nVar != null) {
            return nVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        p0 p0Var = this.f722w;
        if (p0Var != null) {
            return p0Var.h ? p0Var.f910b : p0Var.f911c;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.f724y;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        p0 p0Var = this.f722w;
        if (p0Var != null) {
            return p0Var.f910b;
        }
        return 0;
    }

    public int getContentInsetRight() {
        p0 p0Var = this.f722w;
        if (p0Var != null) {
            return p0Var.f911c;
        }
        return 0;
    }

    public int getContentInsetStart() {
        p0 p0Var = this.f722w;
        if (p0Var != null) {
            return p0Var.h ? p0Var.f911c : p0Var.f910b;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.f723x;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.f fVar;
        ActionMenuView actionMenuView = this.f705a;
        return (actionMenuView == null || (fVar = actionMenuView.f617s) == null || !fVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f724y, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f723x, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        p pVar = this.f709e;
        if (pVar != null) {
            return pVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        p pVar = this.f709e;
        if (pVar != null) {
            return pVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f705a.getMenu();
    }

    public View getNavButtonView() {
        return this.f708d;
    }

    public CharSequence getNavigationContentDescription() {
        n nVar = this.f708d;
        if (nVar != null) {
            return nVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        n nVar = this.f708d;
        if (nVar != null) {
            return nVar.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.N;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f705a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f713m;
    }

    public int getPopupTheme() {
        return this.f714n;
    }

    public CharSequence getSubtitle() {
        return this.B;
    }

    public final TextView getSubtitleTextView() {
        return this.f707c;
    }

    public CharSequence getTitle() {
        return this.A;
    }

    public int getTitleMarginBottom() {
        return this.f721v;
    }

    public int getTitleMarginEnd() {
        return this.f719t;
    }

    public int getTitleMarginStart() {
        return this.f718s;
    }

    public int getTitleMarginTop() {
        return this.f720u;
    }

    public final TextView getTitleTextView() {
        return this.f706b;
    }

    public e0 getWrapper() {
        Drawable drawable;
        if (this.M == null) {
            b1 b1Var = new b1();
            b1Var.f773n = 0;
            b1Var.f761a = this;
            b1Var.h = getTitle();
            b1Var.f768i = getSubtitle();
            b1Var.f767g = b1Var.h != null;
            b1Var.f766f = getNavigationIcon();
            x0 x0VarE = x0.e(getContext(), null, g.a.f8921a, R.attr.actionBarStyle);
            TypedArray typedArray = x0VarE.f948b;
            b1Var.f774o = x0VarE.b(15);
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                b1Var.f767g = true;
                b1Var.h = text;
                if ((b1Var.f762b & 8) != 0) {
                    setTitle(text);
                    if (b1Var.f767g) {
                        v0.e0.k(getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                b1Var.f768i = text2;
                if ((b1Var.f762b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable drawableB = x0VarE.b(20);
            if (drawableB != null) {
                b1Var.f765e = drawableB;
                b1Var.t();
            }
            Drawable drawableB2 = x0VarE.b(17);
            if (drawableB2 != null) {
                b1Var.setIcon(drawableB2);
            }
            if (b1Var.f766f == null && (drawable = b1Var.f774o) != null) {
                b1Var.f766f = drawable;
                if ((b1Var.f762b & 4) != 0) {
                    setNavigationIcon(drawable);
                } else {
                    setNavigationIcon((Drawable) null);
                }
            }
            b1Var.h(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = b1Var.f763c;
                if (view != null && (b1Var.f762b & 16) != 0) {
                    removeView(view);
                }
                b1Var.f763c = viewInflate;
                if (viewInflate != null && (b1Var.f762b & 16) != 0) {
                    addView(viewInflate);
                }
                b1Var.h(b1Var.f762b | 16);
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
                this.f722w.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f715o = resourceId2;
                AppCompatTextView appCompatTextView = this.f706b;
                if (appCompatTextView != null) {
                    appCompatTextView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.f716p = resourceId3;
                AppCompatTextView appCompatTextView2 = this.f707c;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            x0VarE.f();
            if (R.string.abc_action_bar_up_description != b1Var.f773n) {
                b1Var.f773n = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i10 = b1Var.f773n;
                    b1Var.f769j = i10 != 0 ? getContext().getString(i10) : null;
                    b1Var.s();
                }
            }
            b1Var.f769j = getNavigationContentDescription();
            setNavigationOnClickListener(new a1(b1Var));
            this.M = b1Var;
        }
        return this.M;
    }

    public final int j(int i10, View view) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int i12 = gVar.f315a & 112;
        if (i12 != 16 && i12 != 48 && i12 != 80) {
            i12 = this.z & 112;
        }
        if (i12 == 48) {
            return getPaddingTop() - i11;
        }
        if (i12 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i13) {
            iMax = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i15 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i14 < i15) {
                iMax = Math.max(0, iMax - (i15 - i14));
            }
        }
        return paddingTop + iMax;
    }

    public void m(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public final void n() {
        ArrayList<MenuItem> arrayList = this.K;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            MenuItem menuItem = arrayList.get(i10);
            i10++;
            getMenu().removeItem(menuItem.getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator<v0.l> it = this.J.f13295b.iterator();
        while (it.hasNext()) {
            it.next().d(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.K = currentMenuItems2;
    }

    public final boolean o(View view) {
        return view.getParent() == this || this.H.contains(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.T);
        u();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.F = false;
        }
        if (!this.F) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.F = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.F = false;
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
    public void onMeasure(int i10, int i11) {
        char c9;
        Object[] objArr;
        int iK;
        int iMax;
        int iCombineMeasuredStates;
        int iK2;
        int iL;
        int iCombineMeasuredStates2;
        int iMax2;
        int i12 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c9 = 0;
        } else {
            c9 = 1;
            objArr = false;
        }
        if (t(this.f708d)) {
            s(this.f708d, i10, 0, i11, this.r);
            iK = k(this.f708d) + this.f708d.getMeasuredWidth();
            iMax = Math.max(0, l(this.f708d) + this.f708d.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f708d.getMeasuredState());
        } else {
            iK = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (t(this.f711k)) {
            s(this.f711k, i10, 0, i11, this.r);
            iK = k(this.f711k) + this.f711k.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.f711k) + this.f711k.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f711k.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iK);
        int iMax4 = Math.max(0, currentContentInsetStart - iK);
        Object[] objArr2 = objArr;
        int[] iArr = this.I;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (t(this.f705a)) {
            s(this.f705a, i10, iMax3, i11, this.r);
            iK2 = k(this.f705a) + this.f705a.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.f705a) + this.f705a.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f705a.getMeasuredState());
        } else {
            iK2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iK2);
        iArr[c9] = Math.max(0, currentContentInsetEnd - iK2);
        if (t(this.f712l)) {
            iMax5 += r(this.f712l, i10, iMax5, i11, 0, iArr);
            iMax = Math.max(iMax, l(this.f712l) + this.f712l.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f712l.getMeasuredState());
        }
        if (t(this.f709e)) {
            iMax5 += r(this.f709e, i10, iMax5, i11, 0, iArr);
            iMax = Math.max(iMax, l(this.f709e) + this.f709e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f709e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((g) childAt.getLayoutParams()).f732b == 0 && t(childAt)) {
                iMax5 += r(childAt, i10, iMax5, i11, 0, iArr);
                int iMax6 = Math.max(iMax, l(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i14 = iMax5;
        int i15 = this.f720u + this.f721v;
        int i16 = this.f718s + this.f719t;
        if (t(this.f706b)) {
            r(this.f706b, i10, i14 + i16, i11, i15, iArr);
            int iK3 = k(this.f706b) + this.f706b.getMeasuredWidth();
            iL = l(this.f706b) + this.f706b.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f706b.getMeasuredState());
            iMax2 = iK3;
        } else {
            iL = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (t(this.f707c)) {
            iMax2 = Math.max(iMax2, r(this.f707c, i10, i14 + i16, i11, i15 + iL, iArr));
            iL += l(this.f707c) + this.f707c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f707c.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iL);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i14 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i10, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16);
        if (!this.P) {
            i12 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i17 = 0; i17 < childCount2; i17++) {
            View childAt2 = getChildAt(i17);
            if (t(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i12 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i12);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f705a;
        androidx.appcompat.view.menu.f fVar = actionMenuView != null ? actionMenuView.f617s : null;
        int i10 = savedState.expandedMenuItemId;
        if (i10 != 0 && this.O != null && fVar != null && (menuItemFindItem = fVar.findItem(i10)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            b bVar = this.T;
            removeCallbacks(bVar);
            post(bVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        d();
        p0 p0Var = this.f722w;
        boolean z = i10 == 1;
        if (z == p0Var.h) {
            return;
        }
        p0Var.h = z;
        if (!p0Var.f916i) {
            p0Var.f910b = p0Var.f914f;
            p0Var.f911c = p0Var.f915g;
            return;
        }
        if (z) {
            int i11 = p0Var.f913e;
            if (i11 == Integer.MIN_VALUE) {
                i11 = p0Var.f914f;
            }
            p0Var.f910b = i11;
            int i12 = p0Var.f912d;
            if (i12 == Integer.MIN_VALUE) {
                i12 = p0Var.f915g;
            }
            p0Var.f911c = i12;
            return;
        }
        int i13 = p0Var.f912d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = p0Var.f914f;
        }
        p0Var.f910b = i13;
        int i14 = p0Var.f913e;
        if (i14 == Integer.MIN_VALUE) {
            i14 = p0Var.f915g;
        }
        p0Var.f911c = i14;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ActionMenuPresenter actionMenuPresenter;
        androidx.appcompat.view.menu.h hVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.O;
        if (fVar != null && (hVar = fVar.f730b) != null) {
            savedState.expandedMenuItemId = hVar.f501a;
        }
        ActionMenuView actionMenuView = this.f705a;
        savedState.isOverflowOpen = (actionMenuView == null || (actionMenuPresenter = actionMenuView.f621w) == null || !actionMenuPresenter.k()) ? false : true;
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.E = false;
        }
        if (!this.E) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.E = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.E = false;
        return true;
    }

    public final int p(View view, int i10, int i11, int[] iArr) {
        g gVar = (g) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = Math.max(0, i12) + i10;
        iArr[0] = Math.max(0, -i12);
        int iJ = j(i11, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iJ, iMax + measuredWidth, view.getMeasuredHeight() + iJ);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin + iMax;
    }

    public final int q(View view, int i10, int i11, int[] iArr) {
        g gVar = (g) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int iJ = j(i11, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iJ, iMax, view.getMeasuredHeight() + iJ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    public final int r(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i15) + Math.max(0, i14);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + iMax + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    @Override // v0.h
    public final void removeMenuProvider(v0.l lVar) {
        this.J.a(lVar);
    }

    public final void s(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i13 >= 0) {
            if (mode != 0) {
                i13 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i13);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.S != z) {
            this.S = z;
            u();
        }
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(androidx.datastore.preferences.protobuf.b1.L(i10, getContext()));
    }

    public void setCollapsible(boolean z) {
        this.P = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f724y) {
            this.f724y = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f723x) {
            this.f723x = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(androidx.datastore.preferences.protobuf.b1.L(i10, getContext()));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(androidx.datastore.preferences.protobuf.b1.L(i10, getContext()));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f708d.setOnClickListener(onClickListener);
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f705a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f714n != i10) {
            this.f714n = i10;
            if (i10 == 0) {
                this.f713m = getContext();
            } else {
                this.f713m = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) throws Resources.NotFoundException {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) throws Resources.NotFoundException {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.f721v = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f719t = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f718s = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f720u = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public final boolean t(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final void u() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            f fVar = this.O;
            boolean z = (fVar == null || fVar.f730b == null || onBackInvokedDispatcherA == null || !isAttachedToWindow() || !this.S) ? false : true;
            if (z && this.R == null) {
                if (this.Q == null) {
                    this.Q = e.b(new y0(this, 0));
                }
                e.c(onBackInvokedDispatcherA, this.Q);
                this.R = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.R) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.Q);
            this.R = null;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.z = 8388627;
        this.G = new ArrayList<>();
        this.H = new ArrayList<>();
        this.I = new int[2];
        this.J = new v0.k(new z0(this, 0));
        this.K = new ArrayList<>();
        this.L = new a();
        this.T = new b();
        Context context2 = getContext();
        int[] iArr = g.a.f8942x;
        x0 x0VarE = x0.e(context2, attributeSet, iArr, R.attr.toolbarStyle);
        TypedArray typedArray = x0VarE.f948b;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.h.b(this, context, iArr, attributeSet, typedArray, R.attr.toolbarStyle, 0);
        TypedArray typedArray2 = x0VarE.f948b;
        this.f715o = typedArray2.getResourceId(31, 0);
        this.f716p = typedArray2.getResourceId(22, 0);
        this.z = typedArray2.getInteger(0, 8388627);
        this.f717q = typedArray2.getInteger(2, 48);
        int dimensionPixelOffset = typedArray2.getDimensionPixelOffset(25, 0);
        dimensionPixelOffset = typedArray2.hasValue(30) ? typedArray2.getDimensionPixelOffset(30, dimensionPixelOffset) : dimensionPixelOffset;
        this.f721v = dimensionPixelOffset;
        this.f720u = dimensionPixelOffset;
        this.f719t = dimensionPixelOffset;
        this.f718s = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray2.getDimensionPixelOffset(28, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f718s = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray2.getDimensionPixelOffset(27, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f719t = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray2.getDimensionPixelOffset(29, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f720u = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray2.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f721v = dimensionPixelOffset5;
        }
        this.r = typedArray2.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray2.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray2.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray2.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray2.getDimensionPixelSize(8, 0);
        d();
        p0 p0Var = this.f722w;
        p0Var.f916i = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            p0Var.f914f = dimensionPixelSize;
            p0Var.f910b = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            p0Var.f915g = dimensionPixelSize2;
            p0Var.f911c = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            p0Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f723x = typedArray2.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f724y = typedArray2.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.h = x0VarE.b(4);
        this.f710j = typedArray2.getText(3);
        CharSequence text = typedArray2.getText(24);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray2.getText(21);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f713m = getContext();
        setPopupTheme(typedArray2.getResourceId(17, 0));
        Drawable drawableB = x0VarE.b(16);
        if (drawableB != null) {
            setNavigationIcon(drawableB);
        }
        CharSequence text3 = typedArray2.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableB2 = x0VarE.b(11);
        if (drawableB2 != null) {
            setLogo(drawableB2);
        }
        CharSequence text4 = typedArray2.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray2.hasValue(32)) {
            setTitleTextColor(x0VarE.a(32));
        }
        if (typedArray2.hasValue(23)) {
            setSubtitleTextColor(x0VarE.a(23));
        }
        if (typedArray2.hasValue(14)) {
            m(typedArray2.getResourceId(14, 0));
        }
        x0VarE.f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        g gVar = new g(context, attributeSet);
        gVar.f315a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8922b);
        gVar.f315a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        gVar.f732b = 0;
        return gVar;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        n nVar = this.f711k;
        if (nVar != null) {
            nVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f711k.setImageDrawable(drawable);
        } else {
            n nVar = this.f711k;
            if (nVar != null) {
                nVar.setImageDrawable(this.h);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f709e == null) {
                this.f709e = new p(getContext(), null);
            }
            if (!o(this.f709e)) {
                b(this.f709e, true);
            }
        } else {
            p pVar = this.f709e;
            if (pVar != null && o(pVar)) {
                removeView(this.f709e);
                this.H.remove(this.f709e);
            }
        }
        p pVar2 = this.f709e;
        if (pVar2 != null) {
            pVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f709e == null) {
            this.f709e = new p(getContext(), null);
        }
        p pVar = this.f709e;
        if (pVar != null) {
            pVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        n nVar = this.f708d;
        if (nVar != null) {
            nVar.setContentDescription(charSequence);
            c1.a(this.f708d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!o(this.f708d)) {
                b(this.f708d, true);
            }
        } else {
            n nVar = this.f708d;
            if (nVar != null && o(nVar)) {
                removeView(this.f708d);
                this.H.remove(this.f708d);
            }
        }
        n nVar2 = this.f708d;
        if (nVar2 != null) {
            nVar2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f707c;
            if (appCompatTextView != null && o(appCompatTextView)) {
                removeView(this.f707c);
                this.H.remove(this.f707c);
            }
        } else {
            if (this.f707c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.f707c = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f707c.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f716p;
                if (i10 != 0) {
                    this.f707c.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.D;
                if (colorStateList != null) {
                    this.f707c.setTextColor(colorStateList);
                }
            }
            if (!o(this.f707c)) {
                b(this.f707c, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f707c;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.B = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        AppCompatTextView appCompatTextView = this.f707c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f706b;
            if (appCompatTextView != null && o(appCompatTextView)) {
                removeView(this.f706b);
                this.H.remove(this.f706b);
            }
        } else {
            if (this.f706b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.f706b = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f706b.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f715o;
                if (i10 != 0) {
                    this.f706b.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.C;
                if (colorStateList != null) {
                    this.f706b.setTextColor(colorStateList);
                }
            }
            if (!o(this.f706b)) {
                b(this.f706b, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f706b;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.A = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.C = colorStateList;
        AppCompatTextView appCompatTextView = this.f706b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setOnMenuItemClickListener(h hVar) {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f implements androidx.appcompat.view.menu.j {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.view.menu.f f729a;

        /* renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.h f730b;

        public f() {
        }

        @Override // androidx.appcompat.view.menu.j
        public final void b() {
            if (this.f730b != null) {
                androidx.appcompat.view.menu.f fVar = this.f729a;
                if (fVar != null) {
                    int size = fVar.h.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f729a.getItem(i10) == this.f730b) {
                            return;
                        }
                    }
                }
                e(this.f730b);
            }
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean e(androidx.appcompat.view.menu.h hVar) {
            Toolbar toolbar = Toolbar.this;
            KeyEvent.Callback callback = toolbar.f712l;
            if (callback instanceof k.b) {
                ((k.b) callback).onActionViewCollapsed();
            }
            toolbar.removeView(toolbar.f712l);
            toolbar.removeView(toolbar.f711k);
            toolbar.f712l = null;
            ArrayList<View> arrayList = toolbar.H;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                toolbar.addView(arrayList.get(size));
            }
            arrayList.clear();
            this.f730b = null;
            toolbar.requestLayout();
            hVar.F = false;
            hVar.f513q.p(false);
            toolbar.u();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean f(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public final boolean g(androidx.appcompat.view.menu.h hVar) {
            Toolbar toolbar = Toolbar.this;
            toolbar.c();
            ViewParent parent = toolbar.f711k.getParent();
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f711k);
                }
                toolbar.addView(toolbar.f711k);
            }
            View actionView = hVar.getActionView();
            toolbar.f712l = actionView;
            this.f730b = hVar;
            ViewParent parent2 = actionView.getParent();
            if (parent2 != toolbar) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar.f712l);
                }
                g gVarH = Toolbar.h();
                gVarH.f315a = (toolbar.f717q & 112) | 8388611;
                gVarH.f732b = 2;
                toolbar.f712l.setLayoutParams(gVarH);
                toolbar.addView(toolbar.f712l);
            }
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (((g) childAt.getLayoutParams()).f732b != 2 && childAt != toolbar.f705a) {
                    toolbar.removeViewAt(childCount);
                    toolbar.H.add(childAt);
                }
            }
            toolbar.requestLayout();
            hVar.F = true;
            hVar.f513q.p(false);
            KeyEvent.Callback callback = toolbar.f712l;
            if (callback instanceof k.b) {
                ((k.b) callback).onActionViewExpanded();
            }
            toolbar.u();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public final void h(Context context, androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.h hVar;
            androidx.appcompat.view.menu.f fVar2 = this.f729a;
            if (fVar2 != null && (hVar = this.f730b) != null) {
                fVar2.d(hVar);
            }
            this.f729a = fVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z) {
        }
    }
}
