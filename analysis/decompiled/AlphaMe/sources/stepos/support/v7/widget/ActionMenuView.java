package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.C0237y0;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import j.C0622a;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* loaded from: classes2.dex */
public class ActionMenuView extends LinearLayoutCompat implements L3.j, L3.y {

    /* renamed from: A, reason: collision with root package name */
    public InterfaceC0900u f14796A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f14797B;

    /* renamed from: p, reason: collision with root package name */
    public L3.k f14798p;

    /* renamed from: q, reason: collision with root package name */
    public Context f14799q;

    /* renamed from: r, reason: collision with root package name */
    public int f14800r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14801s;

    /* renamed from: t, reason: collision with root package name */
    public C0897q f14802t;

    /* renamed from: u, reason: collision with root package name */
    public L3.v f14803u;

    /* renamed from: v, reason: collision with root package name */
    public L3.i f14804v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14805w;

    /* renamed from: x, reason: collision with root package name */
    public int f14806x;

    /* renamed from: y, reason: collision with root package name */
    public final int f14807y;

    /* renamed from: z, reason: collision with root package name */
    public final int f14808z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f14807y = (int) (56.0f * f4);
        this.f14808z = (int) (f4 * 4.0f);
        this.f14799q = context;
        this.f14800r = 0;
        setMotionEventSplittingEnabled(false);
    }

    private int getExtraPadding() {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if ((getChildAt(i4) instanceof ActionMenuItemView) && ((ActionMenuItemView) getChildAt(i4)).getItemData().getIcon() != null) {
                return C0622a.c(getContext()).f();
            }
        }
        return 0;
    }

    public static C0899t n() {
        C0899t c0899t = new C0899t(-2, -2);
        c0899t.f15148a = false;
        ((LinearLayout.LayoutParams) c0899t).gravity = 16;
        return c0899t;
    }

    public static C0899t o(ViewGroup.LayoutParams layoutParams) {
        C0899t c0899t;
        if (layoutParams == null) {
            return n();
        }
        if (layoutParams instanceof C0899t) {
            C0899t c0899t2 = (C0899t) layoutParams;
            c0899t = new C0899t(c0899t2);
            c0899t.f15148a = c0899t2.f15148a;
        } else {
            c0899t = new C0899t(layoutParams);
        }
        if (((LinearLayout.LayoutParams) c0899t).gravity <= 0) {
            ((LinearLayout.LayoutParams) c0899t).gravity = 16;
        }
        return c0899t;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int q(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            stepos.support.v7.widget.t r0 = (stepos.support.v7.widget.C0899t) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof stepos.support.v7.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            stepos.support.v7.view.menu.ActionMenuItemView r9 = (stepos.support.v7.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L28
            boolean r9 = r9.s()
            if (r9 == 0) goto L28
            r9 = r1
            goto L29
        L28:
            r9 = r2
        L29:
            if (r7 <= 0) goto L4c
            r3 = 2
            if (r9 == 0) goto L30
            if (r7 < r3) goto L4c
        L30:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L45
            int r4 = r4 + 1
        L45:
            if (r9 == 0) goto L4a
            if (r4 >= r3) goto L4a
            goto L4d
        L4a:
            r3 = r4
            goto L4d
        L4c:
            r3 = r2
        L4d:
            boolean r7 = r0.f15148a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            goto L55
        L54:
            r1 = r2
        L55:
            r0.f15151d = r1
            r0.f15149b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionMenuView.q(android.view.View, int, int, int, int):int");
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0899t);
    }

    @Override // L3.j
    public final boolean d(L3.l lVar) {
        return this.f14798p.p(lVar, null, 0);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // L3.y
    public final void e(L3.k kVar) {
        this.f14798p = kVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return n();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return o(layoutParams);
    }

    public Menu getMenu() {
        if (this.f14798p == null) {
            Context context = getContext();
            L3.k kVar = new L3.k(context);
            this.f14798p = kVar;
            kVar.f1284d = new C0898s(this, 1);
            C0897q c0897q = new C0897q(context);
            this.f14802t = c0897q;
            c0897q.f15128m = true;
            c0897q.f15129n = true;
            L3.v c0898s = this.f14803u;
            if (c0898s == null) {
                c0898s = new C0898s(this, 0);
            }
            c0897q.f15120e = c0898s;
            this.f14798p.b(c0897q, this.f14799q);
            C0897q c0897q2 = this.f14802t;
            c0897q2.f15123h = this;
            this.f14798p = c0897q2.f15118c;
        }
        return this.f14798p;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        C0897q c0897q = this.f14802t;
        C0894n c0894n = c0897q.f15124i;
        if (c0894n != null) {
            return c0894n.getDrawable();
        }
        if (c0897q.f15127l) {
            return c0897q.f15126k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f14800r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ C0237y0 generateDefaultLayoutParams() {
        return n();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: k */
    public final C0237y0 generateLayoutParams(AttributeSet attributeSet) {
        return new C0899t(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: l */
    public final /* bridge */ /* synthetic */ C0237y0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return o(layoutParams);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0897q c0897q = this.f14802t;
        if (c0897q != null) {
            c0897q.a();
            if (this.f14802t.k()) {
                this.f14802t.j();
                this.f14802t.o();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0897q c0897q = this.f14802t;
        if (c0897q != null) {
            c0897q.j();
            C0891k c0891k = c0897q.f15111B;
            if (c0891k != null) {
                c0891k.b();
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int i8;
        int width;
        int paddingLeft;
        int width2;
        int paddingLeft2;
        if (!this.f14805w) {
            super.onLayout(z4, i4, i5, i6, i7);
            return;
        }
        int i9 = 8;
        if (!this.f14802t.f15115F) {
            int childCount = getChildCount();
            int i10 = (i7 - i5) / 2;
            int dividerWidth = getDividerWidth();
            int i11 = i6 - i4;
            int paddingRight = (i11 - getPaddingRight()) - getPaddingLeft();
            boolean zB = y0.b(this);
            int measuredWidth = paddingRight;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (childAt.getVisibility() != 8) {
                    C0899t c0899t = (C0899t) childAt.getLayoutParams();
                    if (c0899t.f15148a) {
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        if (p(i14)) {
                            measuredWidth2 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (zB) {
                            paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) c0899t).leftMargin;
                            width = paddingLeft + measuredWidth2;
                        } else {
                            width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c0899t).rightMargin;
                            paddingLeft = width - measuredWidth2;
                        }
                        int i15 = i10 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i15, width, measuredHeight + i15);
                        measuredWidth -= measuredWidth2;
                        i12 = 1;
                    } else {
                        measuredWidth -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c0899t).leftMargin) + ((LinearLayout.LayoutParams) c0899t).rightMargin;
                        p(i14);
                        i13++;
                    }
                }
            }
            if (childCount != 1) {
                i8 = 1;
            } else {
                if (i12 == 0) {
                    View childAt2 = getChildAt(0);
                    int measuredWidth3 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    int i16 = (i11 / 2) - (measuredWidth3 / 2);
                    int i17 = i10 - (measuredHeight2 / 2);
                    childAt2.layout(i16, i17, measuredWidth3 + i16, measuredHeight2 + i17);
                    return;
                }
                i8 = 1;
            }
            int i18 = i13 - (i8 ^ i12);
            int i19 = 0;
            int iMax = Math.max(0, i18 > 0 ? measuredWidth / i18 : 0);
            if (zB) {
                int width3 = getWidth() - getPaddingRight();
                while (i19 < childCount) {
                    View childAt3 = getChildAt(i19);
                    C0899t c0899t2 = (C0899t) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8 && !c0899t2.f15148a) {
                        int i20 = width3 - ((LinearLayout.LayoutParams) c0899t2).rightMargin;
                        int measuredWidth4 = childAt3.getMeasuredWidth();
                        int measuredHeight3 = childAt3.getMeasuredHeight();
                        int i21 = i10 - (measuredHeight3 / 2);
                        childAt3.layout(i20 - measuredWidth4, i21, i20, measuredHeight3 + i21);
                        width3 = i20 - ((measuredWidth4 + ((LinearLayout.LayoutParams) c0899t2).leftMargin) + iMax);
                    }
                    i19++;
                }
                return;
            }
            int paddingLeft3 = getPaddingLeft();
            while (i19 < childCount) {
                View childAt4 = getChildAt(i19);
                C0899t c0899t3 = (C0899t) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !c0899t3.f15148a) {
                    int i22 = paddingLeft3 + ((LinearLayout.LayoutParams) c0899t3).leftMargin;
                    int measuredWidth5 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i23 = i10 - (measuredHeight4 / 2);
                    childAt4.layout(i22, i23, i22 + measuredWidth5, measuredHeight4 + i23);
                    paddingLeft3 = measuredWidth5 + ((LinearLayout.LayoutParams) c0899t3).rightMargin + iMax + i22;
                }
                i19++;
            }
            return;
        }
        int extraPadding = getExtraPadding();
        int childCount2 = getChildCount();
        int i24 = (i7 - i5) / 2;
        int dividerWidth2 = getDividerWidth();
        int i25 = i6 - i4;
        int paddingRight2 = ((i25 - getPaddingRight()) - getPaddingLeft()) - (extraPadding * 2);
        boolean zB2 = y0.b(this);
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (i26 < childCount2) {
            View childAt5 = getChildAt(i26);
            if (childAt5.getVisibility() != i9) {
                C0899t c0899t4 = (C0899t) childAt5.getLayoutParams();
                if (c0899t4.f15148a) {
                    int measuredWidth6 = childAt5.getMeasuredWidth();
                    if (p(i26)) {
                        measuredWidth6 += dividerWidth2;
                    }
                    int measuredHeight5 = childAt5.getMeasuredHeight();
                    if (zB2) {
                        paddingLeft2 = getPaddingLeft() + extraPadding + ((LinearLayout.LayoutParams) c0899t4).leftMargin;
                        width2 = paddingLeft2 + measuredWidth6;
                    } else {
                        width2 = ((getWidth() - extraPadding) - getPaddingRight()) - ((LinearLayout.LayoutParams) c0899t4).rightMargin;
                        paddingLeft2 = width2 - measuredWidth6;
                    }
                    int i29 = i24 - (measuredHeight5 / 2);
                    childAt5.layout(paddingLeft2, i29, width2, measuredHeight5 + i29);
                    paddingRight2 -= measuredWidth6;
                    i27 = 1;
                } else {
                    paddingRight2 -= (childAt5.getMeasuredWidth() + ((LinearLayout.LayoutParams) c0899t4).leftMargin) + ((LinearLayout.LayoutParams) c0899t4).rightMargin;
                    p(i26);
                    i28++;
                }
            }
            i26++;
            i9 = 8;
        }
        int i30 = 1;
        if (childCount2 == 1) {
            if (i27 == 0) {
                View childAt6 = getChildAt(0);
                int measuredWidth7 = childAt6.getMeasuredWidth();
                int measuredHeight6 = childAt6.getMeasuredHeight();
                int i31 = (i25 / 2) - (measuredWidth7 / 2);
                int i32 = i24 - (measuredHeight6 / 2);
                childAt6.layout(i31, i32, measuredWidth7 + i31, measuredHeight6 + i32);
                return;
            }
            i30 = 1;
        }
        int i33 = i28 - (i30 ^ i27);
        int iMax2 = Math.max(0, i33 > 0 ? paddingRight2 / i33 : 0);
        if (zB2) {
            int width4 = (getWidth() - getPaddingRight()) - extraPadding;
            for (int i34 = 0; i34 < childCount2; i34++) {
                View childAt7 = getChildAt(i34);
                C0899t c0899t5 = (C0899t) childAt7.getLayoutParams();
                if (childAt7.getVisibility() != 8 && !c0899t5.f15148a) {
                    int i35 = width4 - ((LinearLayout.LayoutParams) c0899t5).rightMargin;
                    int measuredWidth8 = childAt7.getMeasuredWidth();
                    int measuredHeight7 = childAt7.getMeasuredHeight();
                    int i36 = i24 - (measuredHeight7 / 2);
                    childAt7.layout(i35 - measuredWidth8, i36, i35, measuredHeight7 + i36);
                    width4 = i35 - ((measuredWidth8 + ((LinearLayout.LayoutParams) c0899t5).leftMargin) + iMax2);
                }
            }
            return;
        }
        int paddingLeft4 = getPaddingLeft() + extraPadding;
        for (int i37 = 0; i37 < childCount2; i37++) {
            View childAt8 = getChildAt(i37);
            C0899t c0899t6 = (C0899t) childAt8.getLayoutParams();
            if (childAt8.getVisibility() != 8 && !c0899t6.f15148a) {
                int i38 = paddingLeft4 + ((LinearLayout.LayoutParams) c0899t6).leftMargin;
                int measuredWidth9 = childAt8.getMeasuredWidth();
                int measuredHeight8 = childAt8.getMeasuredHeight();
                int i39 = i24 - (measuredHeight8 / 2);
                childAt8.layout(i38, i39, i38 + measuredWidth9, measuredHeight8 + i39);
                paddingLeft4 = measuredWidth9 + ((LinearLayout.LayoutParams) c0899t6).rightMargin + iMax2 + i38;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v64, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v65 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i4, int i5) throws Resources.NotFoundException {
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        int i8;
        int i9;
        int i10;
        L3.k kVar;
        boolean z6 = this.f14805w;
        ?? r4 = 0;
        boolean z7 = View.MeasureSpec.getMode(i4) == 1073741824;
        this.f14805w = z7;
        if (z6 != z7) {
            this.f14806x = 0;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (this.f14805w && (kVar = this.f14798p) != null && size != this.f14806x) {
            this.f14806x = size;
            kVar.o(true);
        }
        int childCount = getChildCount();
        if (!this.f14805w || childCount <= 0) {
            for (int i11 = 0; i11 < childCount; i11++) {
                C0899t c0899t = (C0899t) getChildAt(i11).getLayoutParams();
                ((LinearLayout.LayoutParams) c0899t).rightMargin = 0;
                ((LinearLayout.LayoutParams) c0899t).leftMargin = 0;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_action_overflow_btn_margin_right);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_last_margin_right);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_next_overflow_margin_right);
                int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_margin_right);
                if (c0899t.f15148a) {
                    c0899t.setMarginEnd(dimensionPixelSize);
                    c0899t.resolveLayoutDirection(getLayoutDirection());
                } else {
                    boolean z8 = this.f14797B;
                    if (z8 && i11 == childCount - 2) {
                        dimensionPixelSize2 = dimensionPixelSize3;
                    } else if (z8 || i11 != childCount - 1) {
                        dimensionPixelSize2 = dimensionPixelSize4;
                    }
                    c0899t.setMarginEnd(dimensionPixelSize2);
                    c0899t.resolveLayoutDirection(getLayoutDirection());
                }
            }
            super.onMeasure(i4, i5);
            return;
        }
        int i12 = 8;
        if (this.f14802t.f15115F) {
            int extraPadding = getExtraPadding();
            int mode = View.MeasureSpec.getMode(i5);
            int size2 = View.MeasureSpec.getSize(i4);
            int size3 = View.MeasureSpec.getSize(i5);
            int paddingRight = (extraPadding * 2) + getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, paddingBottom, -2);
            int i13 = size2 - paddingRight;
            int childCount2 = getChildCount();
            if (childCount2 == 0) {
                setMeasuredDimension(i13, 0);
                return;
            }
            int i14 = i13 / childCount2;
            int i15 = 0;
            int iMax = 0;
            int iMax2 = 0;
            while (i15 < childCount2) {
                View childAt = getChildAt(i15);
                if (childAt.getVisibility() != i12) {
                    boolean z9 = childAt instanceof ActionMenuItemView;
                    C0899t c0899t2 = (C0899t) childAt.getLayoutParams();
                    c0899t2.f15153f = r4;
                    c0899t2.f15150c = r4;
                    c0899t2.f15149b = r4;
                    c0899t2.f15151d = r4;
                    ((LinearLayout.LayoutParams) c0899t2).leftMargin = r4;
                    ((LinearLayout.LayoutParams) c0899t2).rightMargin = r4;
                    c0899t2.f15152e = (z9 && ((ActionMenuItemView) childAt).s()) ? true : r4;
                    C0899t c0899t3 = (C0899t) childAt.getLayoutParams();
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                    c0899t3.f15149b = 1;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), iMakeMeasureSpec);
                    iMax2 = Math.max(iMax2, 1);
                    iMax = Math.max(iMax, childAt.getMeasuredHeight());
                }
                i15++;
                r4 = 0;
                i12 = 8;
            }
            if (mode != 1073741824) {
                size3 = iMax;
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i4), size3);
            return;
        }
        int mode2 = View.MeasureSpec.getMode(i5);
        int size4 = View.MeasureSpec.getSize(i4);
        int size5 = View.MeasureSpec.getSize(i5);
        int paddingRight2 = getPaddingRight() + getPaddingLeft();
        int paddingBottom2 = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, paddingBottom2, -2);
        int i16 = size4 - paddingRight2;
        int i17 = this.f14807y;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount3 = getChildCount();
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        boolean z10 = false;
        long j4 = 0;
        while (true) {
            i6 = this.f14808z;
            if (i25 >= childCount3) {
                break;
            }
            View childAt2 = getChildAt(i25);
            int i26 = size5;
            int i27 = i16;
            if (childAt2.getVisibility() != 8) {
                boolean z11 = childAt2 instanceof ActionMenuItemView;
                i21++;
                if (z11) {
                    childAt2.setPadding(i6, 0, i6, 0);
                }
                C0899t c0899t4 = (C0899t) childAt2.getLayoutParams();
                c0899t4.f15153f = false;
                c0899t4.f15150c = 0;
                c0899t4.f15149b = 0;
                c0899t4.f15151d = false;
                ((LinearLayout.LayoutParams) c0899t4).leftMargin = 0;
                ((LinearLayout.LayoutParams) c0899t4).rightMargin = 0;
                c0899t4.f15152e = z11 && ((ActionMenuItemView) childAt2).s();
                int iQ = q(childAt2, i20, c0899t4.f15148a ? 1 : i18, childMeasureSpec2, paddingBottom2);
                int iMax3 = Math.max(i22, iQ);
                if (c0899t4.f15151d) {
                    i23++;
                }
                if (c0899t4.f15148a) {
                    z10 = true;
                }
                i18 -= iQ;
                int iMax4 = Math.max(i24, childAt2.getMeasuredHeight());
                if (iQ == 1) {
                    i24 = iMax4;
                    j4 |= 1 << i25;
                } else {
                    i24 = iMax4;
                }
                i22 = iMax3;
            }
            i25++;
            size5 = i26;
            i16 = i27;
        }
        int i28 = i16;
        int i29 = size5;
        boolean z12 = z10 && i21 == 2;
        boolean z13 = false;
        while (i23 > 0 && i18 > 0) {
            int i30 = Integer.MAX_VALUE;
            int i31 = 0;
            int i32 = 0;
            long j5 = 0;
            while (i31 < childCount3) {
                boolean z14 = z13;
                C0899t c0899t5 = (C0899t) getChildAt(i31).getLayoutParams();
                int i33 = i23;
                if (c0899t5.f15151d) {
                    int i34 = c0899t5.f15149b;
                    if (i34 < i30) {
                        i10 = i24;
                        i30 = i34;
                        j5 = 1 << i31;
                        i32 = 1;
                    } else {
                        i10 = i24;
                        if (i34 == i30) {
                            i32++;
                            j5 |= 1 << i31;
                        }
                    }
                } else {
                    i10 = i24;
                }
                i31++;
                i23 = i33;
                z13 = z14;
                i24 = i10;
            }
            z4 = z13;
            int i35 = i23;
            i7 = i24;
            j4 |= j5;
            if (i32 > i18) {
                break;
            }
            int i36 = i30 + 1;
            for (int i37 = 0; i37 < childCount3; i37++) {
                View childAt3 = getChildAt(i37);
                C0899t c0899t6 = (C0899t) childAt3.getLayoutParams();
                long j6 = 1 << i37;
                if ((j5 & j6) != 0) {
                    if (z12 && c0899t6.f15152e && i18 == 1) {
                        childAt3.setPadding(i6 + i20, 0, i6, 0);
                    }
                    c0899t6.f15149b++;
                    c0899t6.f15153f = true;
                    i18--;
                } else if (c0899t6.f15149b == i36) {
                    j4 |= j6;
                }
            }
            i23 = i35;
            i24 = i7;
            z13 = true;
        }
        z4 = z13;
        i7 = i24;
        boolean z15 = !z10 && i21 == 1;
        if (i18 <= 0 || j4 == 0 || (i18 >= i21 - 1 && !z15 && i22 <= 1)) {
            z5 = z4;
        } else {
            float fBitCount = Long.bitCount(j4);
            if (!z15) {
                if ((j4 & 1) != 0 && !((C0899t) getChildAt(0).getLayoutParams()).f15152e) {
                    fBitCount -= 0.5f;
                }
                int i38 = childCount3 - 1;
                if ((j4 & (1 << i38)) != 0 && !((C0899t) getChildAt(i38).getLayoutParams()).f15152e) {
                    fBitCount -= 0.5f;
                }
            }
            int i39 = fBitCount > Property.DEFAULT_FLOAT_VALUE ? (int) ((i18 * i20) / fBitCount) : 0;
            z5 = z4;
            for (int i40 = 0; i40 < childCount3; i40++) {
                if ((j4 & (1 << i40)) != 0) {
                    View childAt4 = getChildAt(i40);
                    C0899t c0899t7 = (C0899t) childAt4.getLayoutParams();
                    if (childAt4 instanceof ActionMenuItemView) {
                        c0899t7.f15150c = i39;
                        c0899t7.f15153f = true;
                        if (i40 == 0 && !c0899t7.f15152e) {
                            ((LinearLayout.LayoutParams) c0899t7).leftMargin = (-i39) / 2;
                        }
                        z5 = true;
                    } else if (c0899t7.f15148a) {
                        c0899t7.f15150c = i39;
                        c0899t7.f15153f = true;
                        ((LinearLayout.LayoutParams) c0899t7).rightMargin = (-i39) / 2;
                        z5 = true;
                    } else {
                        if (i40 != 0) {
                            ((LinearLayout.LayoutParams) c0899t7).leftMargin = i39 / 2;
                        }
                        if (i40 != childCount3 - 1) {
                            ((LinearLayout.LayoutParams) c0899t7).rightMargin = i39 / 2;
                        }
                    }
                }
            }
        }
        if (z5) {
            for (int i41 = 0; i41 < childCount3; i41++) {
                View childAt5 = getChildAt(i41);
                C0899t c0899t8 = (C0899t) childAt5.getLayoutParams();
                if (c0899t8.f15153f) {
                    childAt5.measure(View.MeasureSpec.makeMeasureSpec((c0899t8.f15149b * i20) + c0899t8.f15150c, 1073741824), childMeasureSpec2);
                }
            }
        }
        if (mode2 != 1073741824) {
            i9 = i28;
            i8 = i7;
        } else {
            i8 = i29;
            i9 = i28;
        }
        setMeasuredDimension(i9, i8);
    }

    public final boolean p(int i4) {
        boolean zA = false;
        if (i4 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i4 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i4);
        if (i4 < getChildCount() && (childAt instanceof r)) {
            zA = ((r) childAt).a();
        }
        return (i4 <= 0 || !(childAt2 instanceof r)) ? zA : zA | ((r) childAt2).b();
    }

    public void setExpandedActionViewsExclusive(boolean z4) {
        this.f14802t.f15136u = z4;
    }

    public void setHasOverflow(boolean z4) {
        this.f14797B = z4;
    }

    public void setOnMenuItemClickListener(InterfaceC0900u interfaceC0900u) {
        this.f14796A = interfaceC0900u;
    }

    public void setOverflowDrawable(Drawable drawable) {
        C0897q c0897q = this.f14802t;
        if (c0897q != null) {
            c0897q.f15139x = drawable;
            C0894n c0894n = c0897q.f15124i;
            if (c0894n != null) {
                c0894n.setImageDrawable(drawable);
            }
        }
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        C0897q c0897q = this.f14802t;
        C0894n c0894n = c0897q.f15124i;
        if (c0894n != null) {
            c0894n.setImageDrawable(drawable);
        } else {
            c0897q.f15127l = true;
            c0897q.f15126k = drawable;
        }
    }

    public void setOverflowReserved(boolean z4) {
        this.f14801s = z4;
    }

    public void setPopupTheme(@StyleRes int i4) {
        if (this.f14800r != i4) {
            this.f14800r = i4;
            if (i4 == 0) {
                this.f14799q = getContext();
            } else {
                this.f14799q = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setPresenter(C0897q c0897q) {
        this.f14802t = c0897q;
        c0897q.f15123h = this;
        this.f14798p = c0897q.f15118c;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0899t(getContext(), attributeSet);
    }
}
