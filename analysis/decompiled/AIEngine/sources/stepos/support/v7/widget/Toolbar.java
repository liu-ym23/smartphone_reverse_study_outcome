package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.p0;
import androidx.appcompat.widget.x0;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.app.a;
import stepos.support.v7.app.n0;
import stepos.support.v7.widget.ActionMenuView;
import v0.h0;
import v0.i0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public final p0 A;
    public final int B;
    public CharSequence C;
    public CharSequence D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public final ArrayList<View> I;
    public final ArrayList<View> J;
    public final int[] K;
    public f L;
    public final a M;
    public e0 N;
    public ActionMenuPresenter O;
    public d P;
    public n0.d Q;
    public n0.e R;
    public boolean S;
    public final b T;
    public final androidx.appcompat.widget.j U;
    public ActionMenuView V;
    public boolean W;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f12645a;

    /* renamed from: a0, reason: collision with root package name */
    public final com.stepos.common.animator.g f12646a0;

    /* renamed from: b, reason: collision with root package name */
    public HorizontalScrollView f12647b;
    public ViewGroup b0;

    /* renamed from: c, reason: collision with root package name */
    public TextView f12648c;
    public boolean c0;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12649d;

    /* renamed from: d0, reason: collision with root package name */
    public View f12650d0;

    /* renamed from: e, reason: collision with root package name */
    public ImageButton f12651e;

    /* renamed from: e0, reason: collision with root package name */
    public final g f12652e0;
    public ImageView h;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f12653j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f12654k;

    /* renamed from: l, reason: collision with root package name */
    public ImageButton f12655l;

    /* renamed from: m, reason: collision with root package name */
    public View f12656m;

    /* renamed from: n, reason: collision with root package name */
    public Context f12657n;

    /* renamed from: o, reason: collision with root package name */
    public int f12658o;

    /* renamed from: p, reason: collision with root package name */
    public int f12659p;

    /* renamed from: q, reason: collision with root package name */
    public final int f12660q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f12661s;

    /* renamed from: t, reason: collision with root package name */
    public final int f12662t;

    /* renamed from: u, reason: collision with root package name */
    public int f12663u;

    /* renamed from: v, reason: collision with root package name */
    public final int f12664v;

    /* renamed from: w, reason: collision with root package name */
    public final int f12665w;

    /* renamed from: x, reason: collision with root package name */
    public final int f12666x;

    /* renamed from: y, reason: collision with root package name */
    public final int f12667y;
    public final int z;

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
            ActionMenuView actionMenuView = Toolbar.this.f12645a;
            if (actionMenuView == null || (actionMenuPresenter = actionMenuView.f12527w) == null) {
                return;
            }
            actionMenuPresenter.o();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            View view2 = (View) view.getParent();
            int i18 = (int) (Toolbar.this.getResources().getDisplayMetrics().density * 56.0f);
            int i19 = i12 - i10;
            if (i19 < i18) {
                int i20 = (i18 - i19) / 2;
                view2.setTouchDelegate(new TouchDelegate(new Rect(i10 - i20, i11, i12 + i20, i13), view));
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e extends a.c {

        /* renamed from: b, reason: collision with root package name */
        public int f12674b;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface f {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g implements i0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12675a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f12676b;

        public g() {
        }

        @Override // v0.i0
        public final void c() {
            this.f12675a = true;
        }

        @Override // v0.i0
        public final void d(View view) {
            ActionMenuView actionMenuView;
            if (this.f12675a || (actionMenuView = Toolbar.this.f12645a) == null) {
                return;
            }
            actionMenuView.setVisibility(this.f12676b);
        }

        @Override // v0.i0
        public final void e(View view) {
            ActionMenuView actionMenuView = Toolbar.this.f12645a;
            if (actionMenuView != null) {
                actionMenuView.setVisibility(0);
            }
            this.f12675a = false;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposToolbarStyleFullScreen);
        p0 p0Var = new p0(1);
        p0Var.f910b = 0;
        p0Var.f911c = 0;
        p0Var.f912d = Integer.MIN_VALUE;
        p0Var.f913e = Integer.MIN_VALUE;
        p0Var.f914f = 0;
        p0Var.f915g = 0;
        p0Var.h = false;
        p0Var.f916i = false;
        this.A = p0Var;
        this.B = 8388627;
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.K = new int[2];
        this.M = new a();
        this.T = new b();
        this.f12646a0 = new com.stepos.common.animator.g();
        this.f12652e0 = new g();
        x0 x0VarE = x0.e(getContext(), attributeSet, g.a.f8942x, R.attr.steposToolbarStyleFullScreen);
        TypedArray typedArray = x0VarE.f948b;
        this.f12659p = typedArray.getResourceId(31, 0);
        this.f12660q = typedArray.getResourceId(20, 0);
        this.r = typedArray.getResourceId(22, 0);
        this.B = typedArray.getInteger(0, 8388627);
        this.f12661s = typedArray.getInteger(18, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(30, 0);
        this.z = dimensionPixelOffset;
        this.f12667y = dimensionPixelOffset;
        this.f12666x = dimensionPixelOffset;
        this.f12664v = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(28, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f12664v = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(27, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f12666x = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(29, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f12667y = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.z = dimensionPixelOffset5;
        }
        this.f12662t = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
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
        this.f12653j = x0VarE.b(4);
        this.f12654k = typedArray.getText(3);
        CharSequence text = typedArray.getText(24);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(21);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f12657n = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableB = x0VarE.b(16);
        if (drawableB != null) {
            setNavigationIcon(drawableB);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableB2 = x0VarE.b(11);
        if (drawableB2 != null) {
            setLogo(drawableB2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(32)) {
            setTitleTextColor(typedArray.getColor(32, -1));
        }
        if (typedArray.hasValue(23)) {
            setSubtitleTextColor(typedArray.getColor(23, -1));
        }
        this.f12665w = typedArray.getDimensionPixelSize(19, this.f12663u);
        this.f12663u = this.f12664v;
        x0VarE.f();
        this.U = androidx.appcompat.widget.j.a();
    }

    public static e f() {
        e eVar = new e(-2, -2);
        eVar.f12674b = 0;
        eVar.f12071a = 8388627;
        return eVar;
    }

    public static e g(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            e eVar = (e) layoutParams;
            e eVar2 = new e(eVar);
            eVar2.f12674b = 0;
            eVar2.f12674b = eVar.f12674b;
            return eVar2;
        }
        if (layoutParams instanceof a.c) {
            e eVar3 = new e((a.c) layoutParams);
            eVar3.f12674b = 0;
            return eVar3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            e eVar4 = new e(layoutParams);
            eVar4.f12674b = 0;
            return eVar4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        e eVar5 = new e(marginLayoutParams);
        eVar5.f12674b = 0;
        ((ViewGroup.MarginLayoutParams) eVar5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) eVar5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) eVar5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) eVar5).bottomMargin = marginLayoutParams.bottomMargin;
        return eVar5;
    }

    private MenuInflater getMenuInflater() {
        return new fe.i(getContext());
    }

    public static int i(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static boolean k(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof Button) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && k((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void a(ArrayList arrayList, int i10) {
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i10, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f12674b == 0 && r(childAt)) {
                    int i12 = eVar.f12071a;
                    WeakHashMap<View, h0> weakHashMap2 = v0.e0.f13274a;
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
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f12674b == 0 && r(childAt2)) {
                int i14 = eVar2.f12071a;
                WeakHashMap<View, h0> weakHashMap3 = v0.e0.f13274a;
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

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e eVarF = layoutParams == null ? f() : !checkLayoutParams(layoutParams) ? g(layoutParams) : (e) layoutParams;
        eVarF.f12674b = 1;
        if (!z || this.f12656m == null) {
            addView(view, eVarF);
        } else {
            view.setLayoutParams(eVarF);
            this.J.add(view);
        }
    }

    public final void c() {
        d();
        ActionMenuView actionMenuView = this.f12645a;
        if (actionMenuView.f12523s == null) {
            stepos.support.v7.view.menu.c cVar = (stepos.support.v7.view.menu.c) actionMenuView.getMenu();
            if (this.P == null) {
                this.P = new d();
            }
            this.f12645a.setExpandedActionViewsExclusive(true);
            cVar.b(this.P, this.f12657n);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public final void d() {
        if (this.f12645a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f12645a = actionMenuView;
            actionMenuView.setPopupTheme(this.f12658o);
            this.f12645a.setOnMenuItemClickListener(this.M);
            ActionMenuView actionMenuView2 = this.f12645a;
            n0.d dVar = this.Q;
            n0.e eVar = this.R;
            actionMenuView2.f12528x = dVar;
            actionMenuView2.f12529y = eVar;
            e eVarF = f();
            eVarF.f12071a = (this.f12661s & 112) | 8388613;
            this.f12645a.setLayoutParams(eVarF);
            this.f12645a.setId(R.id.stepos_action_menu_view);
            if (!this.c0) {
                b(this.f12645a, false);
            } else {
                ((ViewGroup.MarginLayoutParams) eVarF).width = -1;
                this.b0.addView(this.f12645a, 0, eVarF);
            }
        }
    }

    public final void e() {
        if (this.f12651e == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f12651e = imageButton;
            this.f12646a0.b(imageButton, 5, false);
            e eVarF = f();
            eVarF.f12071a = (this.f12661s & 112) | 8388611;
            this.f12651e.setLayoutParams(eVarF);
            ImageButton imageButton2 = this.f12651e;
            Resources resources = getResources();
            ThreadLocal<TypedValue> threadLocal = m0.f.f10462a;
            imageButton2.setImageDrawable(resources.getDrawable(R.drawable.stepos_titlebar_ic_back_dark, null));
            this.f12651e.setLayoutDirection(3);
            this.f12651e.setId(R.id.stepos_toolbar_nav_button);
            this.f12651e.addOnLayoutChangeListener(new c());
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
        p0 p0Var = this.A;
        return p0Var.h ? p0Var.f910b : p0Var.f911c;
    }

    public int getContentInsetLeft() {
        return this.A.f910b;
    }

    public int getContentInsetRight() {
        return this.A.f911c;
    }

    public int getContentInsetStart() {
        p0 p0Var = this.A;
        return p0Var.h ? p0Var.f911c : p0Var.f910b;
    }

    public Drawable getLogo() {
        ImageView imageView = this.h;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.h;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        c();
        return this.f12645a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f12651e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f12651e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public Drawable getOverflowIcon() {
        c();
        return this.f12645a.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f12658o;
    }

    public View getSplitBarCustomView() {
        return this.f12650d0;
    }

    public CharSequence getSubtitle() {
        return this.D;
    }

    public CharSequence getTitle() {
        return this.C;
    }

    public int getTitleMarginBottom() {
        return this.z;
    }

    public int getTitleMarginEnd() {
        return this.f12666x;
    }

    public int getTitleMarginStart() {
        return this.f12663u;
    }

    public int getTitleMarginTop() {
        return this.f12667y;
    }

    public k getWrapper() {
        if (this.N == null) {
            this.N = new e0(this, true);
        }
        return this.N;
    }

    public final int h(int i10, View view) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int i12 = eVar.f12071a & 112;
        if (i12 != 16 && i12 != 48 && i12 != 80) {
            i12 = this.B & 112;
        }
        if (i12 == 48) {
            return getPaddingTop() - i11;
        }
        if (i12 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i13) {
            iMax = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i15 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i14 < i15) {
                iMax = Math.max(0, iMax - (i15 - i14));
            }
        }
        return paddingTop + iMax;
    }

    public final boolean l(View view) {
        return view.getParent() == this || this.J.contains(view);
    }

    public final boolean m() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f12645a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.f12527w) == null || !actionMenuPresenter.k()) ? false : true;
    }

    public final int n(View view, int i10, int i11, int[] iArr) {
        e eVar = (e) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = Math.max(0, i12) + i10;
        iArr[0] = Math.max(0, -i12);
        int iH = h(i11, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iH, iMax + measuredWidth, view.getMeasuredHeight() + iH);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin + iMax;
    }

    public final int o(View view, int i10, int i11, int[] iArr) {
        e eVar = (e) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int iH = h(i11, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iH, iMax, view.getMeasuredHeight() + iH);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.T);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.H = false;
        }
        if (!this.H) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.H = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.H = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x02e0 A[LOOP:0: B:115:0x02de->B:116:0x02e0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02f8 A[LOOP:1: B:118:0x02f6->B:119:0x02f8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0317 A[LOOP:2: B:121:0x0315->B:122:0x0317, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0364 A[LOOP:3: B:130:0x0362->B:131:0x0364, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0223  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 885
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int iMax;
        int measuredState;
        int measuredState2;
        int iMax2;
        int i14;
        int iJ;
        int measuredState3;
        int iMax3;
        boolean zB = g0.b(this);
        int i15 = !zB ? 1 : 0;
        int i16 = 0;
        if (r(this.f12651e)) {
            q(this.f12651e, i10, 0, i11, this.f12662t);
            i13 = i(this.f12651e) + this.f12651e.getMeasuredWidth();
            int iMax4 = Math.max(0, j(this.f12651e) + this.f12651e.getMeasuredHeight());
            ImageButton imageButton = this.f12651e;
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            int measuredState4 = imageButton.getMeasuredState();
            i12 = this.f12665w;
            iMax = iMax4;
            measuredState = measuredState4;
        } else {
            i12 = this.f12664v;
            i13 = 0;
            iMax = 0;
            measuredState = 0;
        }
        this.f12663u = i12;
        if (r(this.f12655l)) {
            q(this.f12655l, i10, 0, i11, this.f12662t);
            i13 = i(this.f12655l) + this.f12655l.getMeasuredWidth();
            iMax = Math.max(iMax, j(this.f12655l) + this.f12655l.getMeasuredHeight());
            ImageButton imageButton2 = this.f12655l;
            WeakHashMap<View, h0> weakHashMap2 = v0.e0.f13274a;
            measuredState |= imageButton2.getMeasuredState();
        }
        int contentInsetStart = getContentInsetStart();
        int iMax5 = Math.max(contentInsetStart, i13);
        int iMax6 = Math.max(0, contentInsetStart - i13);
        int[] iArr = this.K;
        iArr[zB ? 1 : 0] = iMax6;
        if (r(this.f12645a)) {
            q(this.f12645a, i10, iMax5, i11, this.f12662t);
            int i17 = i(this.f12645a) + this.f12645a.getMeasuredWidth();
            int iMax7 = Math.max(iMax, j(this.f12645a) + this.f12645a.getMeasuredHeight());
            ActionMenuView actionMenuView = this.f12645a;
            WeakHashMap<View, h0> weakHashMap3 = v0.e0.f13274a;
            measuredState2 = measuredState | actionMenuView.getMeasuredState();
            iMax2 = iMax7;
            i14 = i17;
        } else {
            measuredState2 = measuredState;
            iMax2 = iMax;
            i14 = 0;
        }
        int contentInsetEnd = getContentInsetEnd();
        int iMax8 = iMax5 + Math.max(contentInsetEnd, i14);
        iArr[i15] = Math.max(0, contentInsetEnd - i14);
        if (r(this.f12656m)) {
            iMax8 += p(this.f12656m, i10, iMax8, i11, 0, iArr, false);
            iMax2 = Math.max(iMax2, j(this.f12656m) + this.f12656m.getMeasuredHeight());
            View view = this.f12656m;
            WeakHashMap<View, h0> weakHashMap4 = v0.e0.f13274a;
            measuredState2 |= view.getMeasuredState();
        }
        if (r(this.h)) {
            iMax8 += p(this.h, i10, iMax8, i11, 0, iArr, false);
            iMax2 = Math.max(iMax2, j(this.h) + this.h.getMeasuredHeight());
            ImageView imageView = this.h;
            WeakHashMap<View, h0> weakHashMap5 = v0.e0.f13274a;
            measuredState2 |= imageView.getMeasuredState();
        }
        int childCount = getChildCount();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (((e) childAt.getLayoutParams()).f12674b == 0 && r(childAt)) {
                iMax8 += p(childAt, i10, iMax8, i11, 0, iArr, false);
                int iMax9 = Math.max(iMax2, j(childAt) + childAt.getMeasuredHeight());
                WeakHashMap<View, h0> weakHashMap6 = v0.e0.f13274a;
                measuredState2 = childAt.getMeasuredState() | measuredState2;
                iMax2 = iMax9;
            } else {
                iMax8 = iMax8;
            }
        }
        int i19 = iMax8;
        int i20 = this.f12667y + this.z;
        int i21 = this.f12663u + this.f12666x;
        int i22 = (this.B & 7) != 1 ? i19 : i14 * 2;
        if (r(this.f12647b)) {
            p(this.f12647b, i10, i22 + i21, i11, i20, iArr, true);
            int i23 = i(this.f12647b) + this.f12647b.getMeasuredWidth();
            int iJ2 = j(this.f12647b) + this.f12647b.getMeasuredHeight();
            HorizontalScrollView horizontalScrollView = this.f12647b;
            WeakHashMap<View, h0> weakHashMap7 = v0.e0.f13274a;
            iJ = iJ2;
            measuredState3 = measuredState2 | horizontalScrollView.getMeasuredState();
            iMax3 = i23;
        } else {
            iJ = 0;
            measuredState3 = measuredState2;
            iMax3 = 0;
        }
        if (r(this.f12649d)) {
            iMax3 = Math.max(iMax3, p(this.f12649d, i10, i22 + i21, i11, i20 + iJ, iArr, false));
            iJ += j(this.f12649d) + this.f12649d.getMeasuredHeight();
            TextView textView = this.f12649d;
            WeakHashMap<View, h0> weakHashMap8 = v0.e0.f13274a;
            measuredState3 |= textView.getMeasuredState();
        }
        int iMax10 = Math.max(iMax2, iJ);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i19 + iMax3;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax10;
        WeakHashMap<View, h0> weakHashMap9 = v0.e0.f13274a;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i10, (-16777216) & measuredState3);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i11, measuredState3 << 16);
        if (!this.S) {
            i16 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i24 = 0; i24 < childCount2; i24++) {
            View childAt2 = getChildAt(i24);
            if (r(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i16 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i16);
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
        ActionMenuView actionMenuView = this.f12645a;
        stepos.support.v7.view.menu.c cVar = actionMenuView != null ? actionMenuView.f12523s : null;
        int i10 = savedState.expandedMenuItemId;
        if (i10 != 0 && this.P != null && cVar != null && (menuItemFindItem = cVar.findItem(i10)) != null) {
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
        p0 p0Var = this.A;
        if (p0Var != null) {
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
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        stepos.support.v7.view.menu.e eVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.P;
        if (dVar != null && (eVar = dVar.f12672b) != null) {
            savedState.expandedMenuItemId = eVar.f12397a;
        }
        savedState.isOverflowOpen = m();
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.G = false;
        }
        if (!this.G) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.G = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.G = false;
        return true;
    }

    public final int p(View view, int i10, int i11, int i12, int i13, int[] iArr, boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i15) + Math.max(0, i14);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + iMax + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        if (z && view.getMinimumWidth() > View.MeasureSpec.getSize(childMeasureSpec)) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.getMode(childMeasureSpec));
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        return view.getMeasuredWidth() + iMax;
    }

    public final void q(View view, int i10, int i11, int i12, int i13) {
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

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setCollapsible(boolean z) {
        this.S = z;
        requestLayout();
    }

    public void setLogo(int i10) {
        setLogo(this.U.b(i10, getContext()));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setMenuVisibility(int i10) {
        ActionMenuView actionMenuView = this.f12645a;
        if (actionMenuView == null || !this.c0) {
            return;
        }
        actionMenuView.setVisibility(i10);
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(this.U.b(i10, getContext()));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        e();
        this.f12651e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.L = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        c();
        this.f12645a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f12658o != i10) {
            this.f12658o = i10;
            if (i10 == 0) {
                this.f12657n = getContext();
            } else {
                this.f12657n = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setShowBottomMenu(boolean z) {
        if (this.W != z) {
            this.W = z;
            ActionMenuView actionMenuView = this.V;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.V);
                }
                if (this.W) {
                    ViewGroup viewGroup2 = this.b0;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.V);
                    }
                    this.V.getLayoutParams().width = -1;
                }
                this.V.requestLayout();
            }
        }
    }

    public void setSplitCustomView(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.b0 == null) {
            return;
        }
        View view2 = this.f12650d0;
        if (view2 != null) {
            ((ViewGroup) view2.getParent()).removeView(this.f12650d0);
        }
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f12650d0 = view;
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
            this.b0.addView(view, layoutParams);
        }
    }

    public void setSplitToolbar(boolean z) {
        if (this.c0 != z) {
            this.c0 = z;
            ActionMenuView actionMenuView = this.f12645a;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f12645a);
                }
                if (z) {
                    ViewGroup viewGroup2 = this.b0;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f12645a);
                    }
                    this.f12645a.getLayoutParams().width = -1;
                } else {
                    b(this.f12645a, false);
                    this.f12645a.getLayoutParams().width = -2;
                }
                this.f12645a.requestLayout();
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.b0 = viewGroup;
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        this.F = i10;
        TextView textView = this.f12649d;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleTextColor(int i10) {
        this.E = i10;
        TextView textView = this.f12648c;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        e eVar = new e(context, attributeSet);
        eVar.f12071a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8922b);
        eVar.f12071a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        eVar.f12674b = 0;
        return eVar;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.h == null) {
                this.h = new ImageView(getContext());
            }
            if (!l(this.h)) {
                b(this.h, true);
            }
        } else {
            ImageView imageView = this.h;
            if (imageView != null && l(imageView)) {
                removeView(this.h);
                this.J.remove(this.h);
            }
        }
        ImageView imageView2 = this.h;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.h == null) {
            this.h = new ImageView(getContext());
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.f12651e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        TextView textView;
        TextView textView2;
        if (drawable != null) {
            e();
            if (!l(this.f12651e)) {
                b(this.f12651e, true);
            }
            int i10 = this.f12660q;
            if (i10 != 0 && (textView2 = this.f12648c) != null) {
                textView2.setTextAppearance(getContext(), i10);
            }
        } else {
            ImageButton imageButton = this.f12651e;
            if (imageButton != null && l(imageButton)) {
                removeView(this.f12651e);
                this.J.remove(this.f12651e);
                setTouchDelegate(null);
                if (this.f12659p != 0 && (textView = this.f12648c) != null) {
                    textView.setTextAppearance(getContext(), this.f12659p);
                }
            }
        }
        ImageButton imageButton2 = this.f12651e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f12649d;
            if (textView != null && l(textView)) {
                removeView(this.f12649d);
                this.J.remove(this.f12649d);
            }
        } else {
            if (this.f12649d == null) {
                Context context = getContext();
                TextView textView2 = new TextView(context);
                this.f12649d = textView2;
                textView2.setSingleLine();
                this.f12649d.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.r;
                if (i10 != 0) {
                    this.f12649d.setTextAppearance(context, i10);
                }
                int i11 = this.F;
                if (i11 != 0) {
                    this.f12649d.setTextColor(i11);
                }
            }
            if (!l(this.f12649d)) {
                b(this.f12649d, true);
            }
        }
        TextView textView3 = this.f12649d;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
        this.D = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        int i10;
        if (TextUtils.isEmpty(charSequence)) {
            HorizontalScrollView horizontalScrollView = this.f12647b;
            if (horizontalScrollView != null && l(horizontalScrollView)) {
                removeView(this.f12647b);
                this.J.remove(this.f12647b);
            }
        } else {
            if (this.f12647b == null) {
                HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(getContext());
                this.f12647b = horizontalScrollView2;
                horizontalScrollView2.setHorizontalFadingEdgeEnabled(true);
                this.f12647b.setOverScrollMode(2);
                this.f12647b.setHorizontalScrollBarEnabled(false);
                this.f12647b.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.stepos_toolbar_title_min_width));
            }
            if (this.f12648c == null) {
                TextView textView = new TextView(getContext());
                this.f12648c = textView;
                textView.setSingleLine();
            }
            if (r(this.f12651e) && (i10 = this.f12660q) != 0) {
                this.f12648c.setTextAppearance(getContext(), i10);
            } else if (this.f12659p != 0) {
                this.f12648c.setTextAppearance(getContext(), this.f12659p);
            }
            int i11 = this.E;
            if (i11 != 0) {
                this.f12648c.setTextColor(i11);
            }
            this.f12647b.removeAllViews();
            this.f12647b.addView(this.f12648c);
            if (!l(this.f12647b)) {
                b(this.f12647b, true);
            }
        }
        TextView textView2 = this.f12648c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.C = charSequence;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements stepos.support.v7.view.menu.g {

        /* renamed from: a, reason: collision with root package name */
        public stepos.support.v7.view.menu.c f12671a;

        /* renamed from: b, reason: collision with root package name */
        public stepos.support.v7.view.menu.e f12672b;

        public d() {
        }

        @Override // stepos.support.v7.view.menu.g
        public final void b() {
            if (this.f12672b != null) {
                stepos.support.v7.view.menu.c cVar = this.f12671a;
                if (cVar != null) {
                    int size = cVar.f12378e.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f12671a.getItem(i10) == this.f12672b) {
                            return;
                        }
                    }
                }
                d(this.f12672b);
            }
        }

        @Override // stepos.support.v7.view.menu.g
        public final boolean c() {
            return false;
        }

        @Override // stepos.support.v7.view.menu.g
        public final boolean d(stepos.support.v7.view.menu.e eVar) {
            Toolbar toolbar = Toolbar.this;
            KeyEvent.Callback callback = toolbar.f12656m;
            if (callback instanceof k.b) {
                ((k.b) callback).onActionViewCollapsed();
            }
            toolbar.removeView(toolbar.f12656m);
            toolbar.removeView(toolbar.f12655l);
            toolbar.f12656m = null;
            ArrayList<View> arrayList = toolbar.J;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                toolbar.addView(arrayList.get(size));
            }
            arrayList.clear();
            this.f12672b = null;
            toolbar.requestLayout();
            eVar.F = false;
            eVar.f12409q.o(false);
            return true;
        }

        @Override // stepos.support.v7.view.menu.g
        public final boolean e(stepos.support.v7.view.menu.i iVar) {
            return false;
        }

        @Override // stepos.support.v7.view.menu.g
        public final boolean f(stepos.support.v7.view.menu.e eVar) {
            Toolbar toolbar = Toolbar.this;
            int i10 = toolbar.f12661s;
            if (toolbar.f12655l == null) {
                ImageButton imageButton = new ImageButton(toolbar.getContext(), null, R.attr.toolbarNavigationButtonStyle);
                toolbar.f12655l = imageButton;
                imageButton.setImageDrawable(toolbar.f12653j);
                toolbar.f12655l.setContentDescription(toolbar.f12654k);
                e eVarF = Toolbar.f();
                eVarF.f12071a = (i10 & 112) | 8388611;
                eVarF.f12674b = 2;
                toolbar.f12655l.setLayoutParams(eVarF);
                toolbar.f12655l.setOnClickListener(new c0(toolbar));
            }
            if (toolbar.f12655l.getParent() != toolbar) {
                toolbar.addView(toolbar.f12655l);
            }
            View actionView = eVar.getActionView();
            toolbar.f12656m = actionView;
            this.f12672b = eVar;
            if (actionView.getParent() != toolbar) {
                e eVarF2 = Toolbar.f();
                eVarF2.f12071a = (i10 & 112) | 8388611;
                eVarF2.f12674b = 2;
                toolbar.f12656m.setLayoutParams(eVarF2);
                toolbar.addView(toolbar.f12656m);
            }
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (((e) childAt.getLayoutParams()).f12674b != 2 && childAt != toolbar.f12645a) {
                    toolbar.removeViewAt(childCount);
                    toolbar.J.add(childAt);
                }
            }
            toolbar.requestLayout();
            eVar.F = true;
            eVar.f12409q.o(false);
            KeyEvent.Callback callback = toolbar.f12656m;
            if (callback instanceof k.b) {
                ((k.b) callback).onActionViewExpanded();
            }
            return true;
        }

        @Override // stepos.support.v7.view.menu.g
        public final void g(Context context, stepos.support.v7.view.menu.c cVar) {
            stepos.support.v7.view.menu.e eVar;
            stepos.support.v7.view.menu.c cVar2 = this.f12671a;
            if (cVar2 != null && (eVar = this.f12672b) != null) {
                cVar2.d(eVar);
            }
            this.f12671a = cVar;
        }

        @Override // stepos.support.v7.view.menu.g
        public final void a(stepos.support.v7.view.menu.c cVar, boolean z) {
        }
    }
}
