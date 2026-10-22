package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.f2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class Toolbar extends ViewGroup {
    public final int A;
    public final f2 B;
    public final int C;
    public CharSequence D;
    public CharSequence E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public final ArrayList J;
    public final ArrayList K;
    public final int[] L;
    public s1 M;
    public final p N;
    public v1 O;
    public q P;
    public q1 Q;
    public l3.d R;
    public stepos.support.v7.app.f S;
    public boolean T;
    public final w0 U;
    public final m.s V;
    public ActionMenuView W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f12679a0;

    /* renamed from: b0, reason: collision with root package name */
    public final r9.l f12680b0;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f12681c;

    /* renamed from: c0, reason: collision with root package name */
    public ViewGroup f12682c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f12683d0;
    public View e0;

    /* renamed from: f, reason: collision with root package name */
    public HorizontalScrollView f12684f;
    public final m.a f0;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12685g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f12686h;
    public ImageButton i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f12687j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f12688k;

    /* renamed from: l, reason: collision with root package name */
    public final CharSequence f12689l;

    /* renamed from: m, reason: collision with root package name */
    public ImageButton f12690m;

    /* renamed from: n, reason: collision with root package name */
    public View f12691n;

    /* renamed from: o, reason: collision with root package name */
    public Context f12692o;

    /* renamed from: p, reason: collision with root package name */
    public int f12693p;

    /* renamed from: q, reason: collision with root package name */
    public int f12694q;

    /* renamed from: r, reason: collision with root package name */
    public final int f12695r;

    /* renamed from: s, reason: collision with root package name */
    public int f12696s;

    /* renamed from: t, reason: collision with root package name */
    public final int f12697t;

    /* renamed from: u, reason: collision with root package name */
    public final int f12698u;

    /* renamed from: v, reason: collision with root package name */
    public int f12699v;

    /* renamed from: w, reason: collision with root package name */
    public final int f12700w;

    /* renamed from: x, reason: collision with root package name */
    public final int f12701x;

    /* renamed from: y, reason: collision with root package name */
    public final int f12702y;

    /* renamed from: z, reason: collision with root package name */
    public final int f12703z;

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f2 f2Var = new f2(1);
        f2Var.f7905b = 0;
        f2Var.f7906c = 0;
        f2Var.f7907d = Integer.MIN_VALUE;
        f2Var.f7908e = Integer.MIN_VALUE;
        f2Var.f7909f = 0;
        f2Var.f7910g = 0;
        f2Var.f7911h = false;
        f2Var.i = false;
        this.B = f2Var;
        this.C = 8388627;
        this.J = new ArrayList();
        this.K = new ArrayList();
        int i3 = 2;
        this.L = new int[2];
        p pVar = new p();
        pVar.f12784c = this;
        VarHandle.storeStoreFence();
        this.N = pVar;
        w0 w0Var = new w0(i3);
        w0Var.f12894f = this;
        VarHandle.storeStoreFence();
        this.U = w0Var;
        this.f12680b0 = new r9.l();
        m.a aVar = new m.a(i3);
        aVar.f7866h = this;
        aVar.f7864f = false;
        VarHandle.storeStoreFence();
        this.f0 = aVar;
        p5.m mVarJ = p5.m.J(getContext(), attributeSet, g.a.f4120x, i);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        this.f12694q = typedArray.getResourceId(31, 0);
        this.f12695r = typedArray.getResourceId(20, 0);
        this.f12696s = typedArray.getResourceId(22, 0);
        this.C = typedArray.getInteger(0, 8388627);
        this.f12697t = typedArray.getInteger(18, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(30, 0);
        this.A = dimensionPixelOffset;
        this.f12703z = dimensionPixelOffset;
        this.f12702y = dimensionPixelOffset;
        this.f12700w = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(28, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f12700w = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(27, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f12702y = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(29, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f12703z = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.A = dimensionPixelOffset5;
        }
        this.f12698u = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
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
        this.f12688k = mVarJ.A(4);
        this.f12689l = typedArray.getText(3);
        CharSequence text = typedArray.getText(24);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(21);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f12692o = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableA = mVarJ.A(16);
        if (drawableA != null) {
            setNavigationIcon(drawableA);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableA2 = mVarJ.A(11);
        if (drawableA2 != null) {
            setLogo(drawableA2);
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
        this.f12701x = typedArray.getDimensionPixelSize(19, this.f12699v);
        this.f12699v = this.f12700w;
        mVarJ.M();
        this.V = m.s.a();
    }

    public static r1 f() {
        r1 r1Var = new r1(-2, -2);
        r1Var.f12826b = 0;
        r1Var.f12825a = 8388627;
        return r1Var;
    }

    public static r1 g(ViewGroup.LayoutParams layoutParams) {
        boolean z10 = layoutParams instanceof r1;
        if (z10) {
            r1 r1Var = (r1) layoutParams;
            r1 r1Var2 = new r1(r1Var);
            r1Var2.f12826b = 0;
            r1Var2.f12826b = r1Var.f12826b;
            return r1Var2;
        }
        if (z10) {
            r1 r1Var3 = new r1((r1) layoutParams);
            r1Var3.f12826b = 0;
            return r1Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            r1 r1Var4 = new r1(layoutParams);
            r1Var4.f12826b = 0;
            return r1Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        r1 r1Var5 = new r1(marginLayoutParams);
        r1Var5.f12826b = 0;
        ((ViewGroup.MarginLayoutParams) r1Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) r1Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) r1Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) r1Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return r1Var5;
    }

    private MenuInflater getMenuInflater() {
        return new se.j(getContext());
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
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && k((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void a(ArrayList arrayList, int i) {
        WeakHashMap weakHashMap = n3.k0.f8724a;
        boolean z10 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z10) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                r1 r1Var = (r1) childAt.getLayoutParams();
                if (r1Var.f12826b == 0 && r(childAt)) {
                    int i10 = r1Var.f12825a;
                    WeakHashMap weakHashMap2 = n3.k0.f8724a;
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
            r1 r1Var2 = (r1) childAt2.getLayoutParams();
            if (r1Var2.f12826b == 0 && r(childAt2)) {
                int i12 = r1Var2.f12825a;
                WeakHashMap weakHashMap3 = n3.k0.f8724a;
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
        r1 r1VarF = layoutParams == null ? f() : !checkLayoutParams(layoutParams) ? g(layoutParams) : (r1) layoutParams;
        r1VarF.f12826b = 1;
        if (!z10 || this.f12691n == null) {
            addView(view, r1VarF);
        } else {
            view.setLayoutParams(r1VarF);
            this.K.add(view);
        }
    }

    public final void c() {
        d();
        ActionMenuView actionMenuView = this.f12681c;
        if (actionMenuView.f12602t == null) {
            te.l lVar = (te.l) actionMenuView.getMenu();
            if (this.Q == null) {
                this.Q = new q1(this);
            }
            this.f12681c.setExpandedActionViewsExclusive(true);
            lVar.b(this.Q, this.f12692o);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof r1);
    }

    public final void d() {
        if (this.f12681c == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f12681c = actionMenuView;
            actionMenuView.setPopupTheme(this.f12693p);
            this.f12681c.setOnMenuItemClickListener(this.N);
            ActionMenuView actionMenuView2 = this.f12681c;
            l3.d dVar = this.R;
            stepos.support.v7.app.f fVar = this.S;
            actionMenuView2.f12607y = dVar;
            actionMenuView2.f12608z = fVar;
            r1 r1VarF = f();
            r1VarF.f12825a = (this.f12697t & 112) | 8388613;
            this.f12681c.setLayoutParams(r1VarF);
            this.f12681c.setId(R.id.stepos_action_menu_view);
            if (!this.f12683d0) {
                b(this.f12681c, false);
            } else {
                ((ViewGroup.MarginLayoutParams) r1VarF).width = -1;
                this.f12682c0.addView(this.f12681c, 0, r1VarF);
            }
        }
    }

    public final void e() {
        if (this.i == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.i = imageButton;
            this.f12680b0.b(5, imageButton);
            r1 r1VarF = f();
            r1VarF.f12825a = (this.f12697t & 112) | 8388611;
            this.i.setLayoutParams(r1VarF);
            ImageButton imageButton2 = this.i;
            Resources resources = getResources();
            ThreadLocal threadLocal = e3.k.f3478a;
            imageButton2.setImageDrawable(resources.getDrawable(R.drawable.stepos_titlebar_ic_back_dark, null));
            this.i.setLayoutDirection(3);
            this.i.setId(R.id.stepos_toolbar_nav_button);
            ImageButton imageButton3 = this.i;
            p1 p1Var = new p1();
            p1Var.f12800a = this;
            VarHandle.storeStoreFence();
            imageButton3.addOnLayoutChangeListener(p1Var);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        r1 r1Var = new r1(context, attributeSet);
        r1Var.f12825a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f4099b);
        r1Var.f12825a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        r1Var.f12826b = 0;
        return r1Var;
    }

    public int getContentInsetEnd() {
        f2 f2Var = this.B;
        return f2Var.f7911h ? f2Var.f7905b : f2Var.f7906c;
    }

    public int getContentInsetLeft() {
        return this.B.f7905b;
    }

    public int getContentInsetRight() {
        return this.B.f7906c;
    }

    public int getContentInsetStart() {
        f2 f2Var = this.B;
        return f2Var.f7911h ? f2Var.f7906c : f2Var.f7905b;
    }

    public Drawable getLogo() {
        ImageView imageView = this.f12687j;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f12687j;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        c();
        return this.f12681c.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public Drawable getOverflowIcon() {
        c();
        return this.f12681c.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f12693p;
    }

    public View getSplitBarCustomView() {
        return this.e0;
    }

    public CharSequence getSubtitle() {
        return this.E;
    }

    public CharSequence getTitle() {
        return this.D;
    }

    public int getTitleMarginBottom() {
        return this.A;
    }

    public int getTitleMarginEnd() {
        return this.f12702y;
    }

    public int getTitleMarginStart() {
        return this.f12699v;
    }

    public int getTitleMarginTop() {
        return this.f12703z;
    }

    public c0 getWrapper() {
        if (this.O == null) {
            this.O = new v1(this, true);
        }
        return this.O;
    }

    public final int h(int i, View view) {
        r1 r1Var = (r1) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i10 = r1Var.f12825a & 112;
        if (i10 != 16 && i10 != 48 && i10 != 80) {
            i10 = this.C & 112;
        }
        if (i10 == 48) {
            return getPaddingTop() - i3;
        }
        if (i10 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) r1Var).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i11 = ((ViewGroup.MarginLayoutParams) r1Var).topMargin;
        if (iMax < i11) {
            iMax = i11;
        } else {
            int i12 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i13 = ((ViewGroup.MarginLayoutParams) r1Var).bottomMargin;
            if (i12 < i13) {
                iMax = Math.max(0, iMax - (i13 - i12));
            }
        }
        return paddingTop + iMax;
    }

    public final boolean l(View view) {
        return view.getParent() == this || this.K.contains(view);
    }

    public final boolean m() {
        q qVar;
        ActionMenuView actionMenuView = this.f12681c;
        return (actionMenuView == null || (qVar = actionMenuView.f12606x) == null || !qVar.k()) ? false : true;
    }

    public final int n(View view, int i, int i3, int[] iArr) {
        r1 r1Var = (r1) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) r1Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i10) + i;
        iArr[0] = Math.max(0, -i10);
        int iH = h(i3, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iH, iMax + measuredWidth, view.getMeasuredHeight() + iH);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) r1Var).rightMargin + iMax;
    }

    public final int o(View view, int i, int i3, int[] iArr) {
        r1 r1Var = (r1) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) r1Var).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i10);
        iArr[1] = Math.max(0, -i10);
        int iH = h(i3, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iH, iMax, view.getMeasuredHeight() + iH);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) r1Var).leftMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.U);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.I = false;
        }
        if (!this.I) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.I = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.I = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x02d6 A[LOOP:0: B:120:0x02d4->B:121:0x02d6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ee A[LOOP:1: B:123:0x02ec->B:124:0x02ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x030d A[LOOP:2: B:126:0x030b->B:127:0x030d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x035a A[LOOP:3: B:135:0x0358->B:136:0x035a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0219  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 875
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int i10;
        int i11;
        int iMax;
        int measuredState;
        int measuredState2;
        int iMax2;
        int i12;
        int iJ;
        int measuredState3;
        int iMax3;
        boolean zB = x1.b(this);
        int i13 = !zB ? 1 : 0;
        int i14 = 0;
        if (r(this.i)) {
            q(this.i, i, 0, i3, this.f12698u);
            i11 = i(this.i) + this.i.getMeasuredWidth();
            int iMax4 = Math.max(0, j(this.i) + this.i.getMeasuredHeight());
            ImageButton imageButton = this.i;
            WeakHashMap weakHashMap = n3.k0.f8724a;
            int measuredState4 = imageButton.getMeasuredState();
            i10 = this.f12701x;
            iMax = iMax4;
            measuredState = measuredState4;
        } else {
            i10 = this.f12700w;
            i11 = 0;
            iMax = 0;
            measuredState = 0;
        }
        this.f12699v = i10;
        if (r(this.f12690m)) {
            q(this.f12690m, i, 0, i3, this.f12698u);
            i11 = i(this.f12690m) + this.f12690m.getMeasuredWidth();
            iMax = Math.max(iMax, j(this.f12690m) + this.f12690m.getMeasuredHeight());
            ImageButton imageButton2 = this.f12690m;
            WeakHashMap weakHashMap2 = n3.k0.f8724a;
            measuredState |= imageButton2.getMeasuredState();
        }
        int contentInsetStart = getContentInsetStart();
        int iMax5 = Math.max(contentInsetStart, i11);
        int iMax6 = Math.max(0, contentInsetStart - i11);
        int[] iArr = this.L;
        iArr[zB ? 1 : 0] = iMax6;
        if (r(this.f12681c)) {
            q(this.f12681c, i, iMax5, i3, this.f12698u);
            int i15 = i(this.f12681c) + this.f12681c.getMeasuredWidth();
            int iMax7 = Math.max(iMax, j(this.f12681c) + this.f12681c.getMeasuredHeight());
            ActionMenuView actionMenuView = this.f12681c;
            WeakHashMap weakHashMap3 = n3.k0.f8724a;
            measuredState2 = measuredState | actionMenuView.getMeasuredState();
            iMax2 = iMax7;
            i12 = i15;
        } else {
            measuredState2 = measuredState;
            iMax2 = iMax;
            i12 = 0;
        }
        int contentInsetEnd = getContentInsetEnd();
        int iMax8 = iMax5 + Math.max(contentInsetEnd, i12);
        iArr[i13] = Math.max(0, contentInsetEnd - i12);
        if (r(this.f12691n)) {
            iMax8 += p(this.f12691n, i, iMax8, i3, 0, iArr, false);
            iMax2 = Math.max(iMax2, j(this.f12691n) + this.f12691n.getMeasuredHeight());
            View view = this.f12691n;
            WeakHashMap weakHashMap4 = n3.k0.f8724a;
            measuredState2 |= view.getMeasuredState();
        }
        if (r(this.f12687j)) {
            iMax8 += p(this.f12687j, i, iMax8, i3, 0, iArr, false);
            iMax2 = Math.max(iMax2, j(this.f12687j) + this.f12687j.getMeasuredHeight());
            ImageView imageView = this.f12687j;
            WeakHashMap weakHashMap5 = n3.k0.f8724a;
            measuredState2 |= imageView.getMeasuredState();
        }
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (((r1) childAt.getLayoutParams()).f12826b == 0 && r(childAt)) {
                iMax8 += p(childAt, i, iMax8, i3, 0, iArr, false);
                int iMax9 = Math.max(iMax2, j(childAt) + childAt.getMeasuredHeight());
                WeakHashMap weakHashMap6 = n3.k0.f8724a;
                measuredState2 = childAt.getMeasuredState() | measuredState2;
                iMax2 = iMax9;
            } else {
                iMax8 = iMax8;
            }
        }
        int i17 = iMax8;
        int i18 = this.f12703z + this.A;
        int i19 = this.f12699v + this.f12702y;
        int i20 = (this.C & 7) != 1 ? i17 : i12 * 2;
        if (r(this.f12684f)) {
            p(this.f12684f, i, i20 + i19, i3, i18, iArr, true);
            int i21 = i(this.f12684f) + this.f12684f.getMeasuredWidth();
            int iJ2 = j(this.f12684f) + this.f12684f.getMeasuredHeight();
            HorizontalScrollView horizontalScrollView = this.f12684f;
            WeakHashMap weakHashMap7 = n3.k0.f8724a;
            iJ = iJ2;
            measuredState3 = measuredState2 | horizontalScrollView.getMeasuredState();
            iMax3 = i21;
        } else {
            iJ = 0;
            measuredState3 = measuredState2;
            iMax3 = 0;
        }
        if (r(this.f12686h)) {
            iMax3 = Math.max(iMax3, p(this.f12686h, i, i20 + i19, i3, i18 + iJ, iArr, false));
            iJ += j(this.f12686h) + this.f12686h.getMeasuredHeight();
            TextView textView = this.f12686h;
            WeakHashMap weakHashMap8 = n3.k0.f8724a;
            measuredState3 |= textView.getMeasuredState();
        }
        int iMax10 = Math.max(iMax2, iJ);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i17 + iMax3;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax10;
        WeakHashMap weakHashMap9 = n3.k0.f8724a;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & measuredState3);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, measuredState3 << 16);
        if (!this.T) {
            i14 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i22 = 0; i22 < childCount2; i22++) {
            View childAt2 = getChildAt(i22);
            if (r(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i14 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i14);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof t1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        t1 t1Var = (t1) parcelable;
        super.onRestoreInstanceState(t1Var.getSuperState());
        ActionMenuView actionMenuView = this.f12681c;
        te.l lVar = actionMenuView != null ? actionMenuView.f12602t : null;
        int i = t1Var.f12834c;
        if (i != 0 && this.Q != null && lVar != null && (menuItemFindItem = lVar.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (t1Var.f12835f) {
            w0 w0Var = this.U;
            removeCallbacks(w0Var);
            post(w0Var);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        f2 f2Var = this.B;
        if (f2Var != null) {
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
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        te.m mVar;
        t1 t1Var = new t1(super.onSaveInstanceState());
        q1 q1Var = this.Q;
        if (q1Var != null && (mVar = q1Var.f12823f) != null) {
            t1Var.f12834c = mVar.f13363a;
        }
        t1Var.f12835f = m();
        return t1Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.H = false;
        }
        if (!this.H) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.H = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.H = false;
        return true;
    }

    public final int p(View view, int i, int i3, int i10, int i11, int[] iArr, boolean z10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i12 = marginLayoutParams.leftMargin - iArr[0];
        int i13 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i13) + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        iArr[1] = Math.max(0, -i13);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height);
        if (z10 && view.getMinimumWidth() > View.MeasureSpec.getSize(childMeasureSpec)) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.getMode(childMeasureSpec));
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        return view.getMeasuredWidth() + iMax;
    }

    public final void q(View view, int i, int i3, int i10, int i11) {
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

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setCollapsible(boolean z10) {
        this.T = z10;
        requestLayout();
    }

    public void setLogo(Drawable drawable) {
        ImageView imageView = this.f12687j;
        if (drawable != null) {
            if (imageView == null) {
                this.f12687j = new ImageView(getContext());
            }
            if (!l(this.f12687j)) {
                b(this.f12687j, true);
            }
        } else if (imageView != null && l(imageView)) {
            removeView(this.f12687j);
            this.K.remove(this.f12687j);
        }
        ImageView imageView2 = this.f12687j;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f12687j == null) {
            this.f12687j = new ImageView(getContext());
        }
        ImageView imageView = this.f12687j;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setMenuVisibility(int i) {
        ActionMenuView actionMenuView = this.f12681c;
        if (actionMenuView == null || !this.f12683d0) {
            return;
        }
        actionMenuView.setVisibility(i);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        TextView textView;
        TextView textView2;
        if (drawable != null) {
            e();
            if (!l(this.i)) {
                b(this.i, true);
            }
            int i = this.f12695r;
            if (i != 0 && (textView2 = this.f12685g) != null) {
                textView2.setTextAppearance(getContext(), i);
            }
        } else {
            ImageButton imageButton = this.i;
            if (imageButton != null && l(imageButton)) {
                removeView(this.i);
                this.K.remove(this.i);
                setTouchDelegate(null);
                if (this.f12694q != 0 && (textView = this.f12685g) != null) {
                    textView.setTextAppearance(getContext(), this.f12694q);
                }
            }
        }
        ImageButton imageButton2 = this.i;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        e();
        this.i.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(s1 s1Var) {
        this.M = s1Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        c();
        this.f12681c.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f12693p != i) {
            this.f12693p = i;
            if (i == 0) {
                this.f12692o = getContext();
            } else {
                this.f12692o = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setShowBottomMenu(boolean z10) {
        if (this.f12679a0 != z10) {
            this.f12679a0 = z10;
            ActionMenuView actionMenuView = this.W;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.W);
                }
                if (this.f12679a0) {
                    ViewGroup viewGroup2 = this.f12682c0;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.W);
                    }
                    this.W.getLayoutParams().width = -1;
                }
                this.W.requestLayout();
            }
        }
    }

    public void setSplitCustomView(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.f12682c0 == null) {
            return;
        }
        View view2 = this.e0;
        if (view2 != null) {
            ((ViewGroup) view2.getParent()).removeView(this.e0);
        }
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.e0 = view;
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
            this.f12682c0.addView(view, layoutParams);
        }
    }

    public void setSplitToolbar(boolean z10) {
        if (this.f12683d0 != z10) {
            this.f12683d0 = z10;
            ActionMenuView actionMenuView = this.f12681c;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f12681c);
                }
                if (z10) {
                    ViewGroup viewGroup2 = this.f12682c0;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f12681c);
                    }
                    this.f12681c.getLayoutParams().width = -1;
                } else {
                    b(this.f12681c, false);
                    this.f12681c.getLayoutParams().width = -2;
                }
                this.f12681c.requestLayout();
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f12682c0 = viewGroup;
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f12686h;
        if (!zIsEmpty) {
            if (textView == null) {
                Context context = getContext();
                TextView textView2 = new TextView(context);
                this.f12686h = textView2;
                textView2.setSingleLine();
                this.f12686h.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f12696s;
                if (i != 0) {
                    this.f12686h.setTextAppearance(context, i);
                }
                int i3 = this.G;
                if (i3 != 0) {
                    this.f12686h.setTextColor(i3);
                }
            }
            if (!l(this.f12686h)) {
                b(this.f12686h, true);
            }
        } else if (textView != null && l(textView)) {
            removeView(this.f12686h);
            this.K.remove(this.f12686h);
        }
        TextView textView3 = this.f12686h;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
        this.E = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.G = i;
        TextView textView = this.f12686h;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i;
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        HorizontalScrollView horizontalScrollView = this.f12684f;
        if (!zIsEmpty) {
            if (horizontalScrollView == null) {
                HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(getContext());
                this.f12684f = horizontalScrollView2;
                horizontalScrollView2.setHorizontalFadingEdgeEnabled(true);
                this.f12684f.setOverScrollMode(2);
                this.f12684f.setHorizontalScrollBarEnabled(false);
                this.f12684f.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.stepos_toolbar_title_min_width));
            }
            if (this.f12685g == null) {
                TextView textView = new TextView(getContext());
                this.f12685g = textView;
                textView.setSingleLine();
            }
            if (r(this.i) && (i = this.f12695r) != 0) {
                this.f12685g.setTextAppearance(getContext(), i);
            } else if (this.f12694q != 0) {
                this.f12685g.setTextAppearance(getContext(), this.f12694q);
            }
            int i3 = this.F;
            if (i3 != 0) {
                this.f12685g.setTextColor(i3);
            }
            this.f12684f.removeAllViews();
            this.f12684f.addView(this.f12685g);
            if (!l(this.f12684f)) {
                b(this.f12684f, true);
            }
        } else if (horizontalScrollView != null && l(horizontalScrollView)) {
            removeView(this.f12684f);
            this.K.remove(this.f12684f);
        }
        TextView textView2 = this.f12685g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.D = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.F = i;
        TextView textView = this.f12685g;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return g(layoutParams);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
    }

    public void setLogo(int i) {
        setLogo(this.V.b(i, getContext()));
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.V.b(i, getContext()));
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.steposToolbarStyleFullScreen);
    }

    public Toolbar(Context context) {
        this(context, null);
    }
}
