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
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.stepos.ability.R;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* loaded from: classes4.dex */
public class ActionMenuView extends LinearLayoutCompat implements Va.m, Va.D {

    /* renamed from: a, reason: collision with root package name */
    public Va.n f6443a;
    public Context b;
    public int c;
    public boolean d;
    public C2005u e;
    public C4.a f;
    public h2.d g;
    public boolean h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6444j;
    public final int k;
    public InterfaceC2009y l;
    public boolean m;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f6444j = (int) (56.0f * f);
        this.k = (int) (f * 4.0f);
        this.b = context;
        this.c = 0;
        setMotionEventSplittingEnabled(false);
    }

    public static C2008x c(ViewGroup.LayoutParams layoutParams) {
        C2008x c2008x;
        if (layoutParams == null) {
            C2008x c2008x2 = new C2008x(-2, -2);
            c2008x2.f6645a = false;
            ((LinearLayout.LayoutParams) c2008x2).gravity = 16;
            return c2008x2;
        }
        if (layoutParams instanceof C2008x) {
            C2008x c2008x3 = (C2008x) layoutParams;
            c2008x = new C2008x(c2008x3);
            c2008x.f6645a = c2008x3.f6645a;
        } else {
            c2008x = new C2008x(layoutParams);
        }
        if (((LinearLayout.LayoutParams) c2008x).gravity <= 0) {
            ((LinearLayout.LayoutParams) c2008x).gravity = 16;
        }
        return c2008x;
    }

    private int getExtraPadding() {
        for (int i = 0; i < getChildCount(); i++) {
            if ((getChildAt(i) instanceof ActionMenuItemView) && ((ActionMenuItemView) getChildAt(i)).getItemData().getIcon() != null) {
                return Ua.a.a(getContext()).b();
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int measureChildForCells(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            stepos.support.v7.widget.x r0 = (stepos.support.v7.widget.C2008x) r0
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
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.hasText()
            if (r9 == 0) goto L28
            r9 = r2
            goto L29
        L28:
            r9 = r1
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
            r3 = r1
        L4d:
            boolean r7 = r0.f6645a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.d = r1
            r0.b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionMenuView.measureChildForCells(android.view.View, int, int, int, int):int");
    }

    @Override // Va.D
    public final void a(Va.n nVar) {
        this.f6443a = nVar;
    }

    @Override // Va.m
    public final boolean b(Va.q qVar) {
        return this.f6443a.p(qVar, null, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C2008x);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C2008x c2008x = new C2008x(-2, -2);
        c2008x.f6645a = false;
        ((LinearLayout.LayoutParams) c2008x).gravity = 16;
        return c2008x;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return c(layoutParams);
    }

    public Menu getMenu() {
        if (this.f6443a == null) {
            Context context = getContext();
            Va.n nVar = new Va.n(context);
            this.f6443a = nVar;
            nVar.d = new C2003s(this);
            C2005u c2005u = new C2005u(context);
            this.e = c2005u;
            c2005u.m = true;
            c2005u.n = true;
            Va.A c2007w = this.f;
            if (c2007w == null) {
                c2007w = new C2007w();
            }
            c2005u.e = c2007w;
            this.f6443a.b(c2005u, this.b);
            C2005u c2005u2 = this.e;
            c2005u2.h = this;
            this.f6443a = c2005u2.c;
        }
        return this.f6443a;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        C2005u c2005u = this.e;
        C2002q c2002q = c2005u.i;
        if (c2002q != null) {
            return c2002q.getDrawable();
        }
        if (c2005u.l) {
            return c2005u.k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final boolean hasSupportDividerBeforeChildAt(int i) {
        boolean zNeedsDividerAfter = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof InterfaceC2006v)) {
            zNeedsDividerAfter = ((InterfaceC2006v) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof InterfaceC2006v)) ? zNeedsDividerAfter : ((InterfaceC2006v) childAt2).needsDividerBefore() | zNeedsDividerAfter;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C2005u c2005u = this.e;
        if (c2005u != null) {
            c2005u.updateMenuView(false);
            if (this.e.i()) {
                this.e.h();
                this.e.m();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C2005u c2005u = this.e;
        if (c2005u != null) {
            c2005u.h();
            C1999n c1999n = c2005u.f6632B;
            if (c1999n != null) {
                c1999n.e();
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        int width;
        int paddingLeft;
        int width2;
        int paddingLeft2;
        if (!this.h) {
            super.onLayout(z10, i, i6, i10, i11);
            return;
        }
        int i12 = 8;
        if (!this.e.f6635F) {
            int childCount = getChildCount();
            int i13 = (i11 - i6) / 2;
            int dividerWidth = getDividerWidth();
            int i14 = i10 - i;
            int paddingRight = (i14 - getPaddingRight()) - getPaddingLeft();
            boolean zB = I0.b(this);
            int measuredWidth = paddingRight;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() != 8) {
                    C2008x c2008x = (C2008x) childAt.getLayoutParams();
                    if (c2008x.f6645a) {
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        if (hasSupportDividerBeforeChildAt(i17)) {
                            measuredWidth2 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (zB) {
                            paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) c2008x).leftMargin;
                            width = paddingLeft + measuredWidth2;
                        } else {
                            width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c2008x).rightMargin;
                            paddingLeft = width - measuredWidth2;
                        }
                        int i18 = i13 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i18, width, measuredHeight + i18);
                        measuredWidth -= measuredWidth2;
                        i15 = 1;
                    } else {
                        measuredWidth -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c2008x).leftMargin) + ((LinearLayout.LayoutParams) c2008x).rightMargin;
                        hasSupportDividerBeforeChildAt(i17);
                        i16++;
                    }
                }
            }
            if (childCount == 1 && i15 == 0) {
                View childAt2 = getChildAt(0);
                int measuredWidth3 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                int i19 = (i14 / 2) - (measuredWidth3 / 2);
                int i20 = i13 - (measuredHeight2 / 2);
                childAt2.layout(i19, i20, measuredWidth3 + i19, measuredHeight2 + i20);
                return;
            }
            int i21 = i16 - (i15 ^ 1);
            int i22 = 0;
            int iMax = Math.max(0, i21 > 0 ? measuredWidth / i21 : 0);
            if (zB) {
                int width3 = getWidth() - getPaddingRight();
                while (i22 < childCount) {
                    View childAt3 = getChildAt(i22);
                    C2008x c2008x2 = (C2008x) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8 && !c2008x2.f6645a) {
                        int i23 = width3 - ((LinearLayout.LayoutParams) c2008x2).rightMargin;
                        int measuredWidth4 = childAt3.getMeasuredWidth();
                        int measuredHeight3 = childAt3.getMeasuredHeight();
                        int i24 = i13 - (measuredHeight3 / 2);
                        childAt3.layout(i23 - measuredWidth4, i24, i23, measuredHeight3 + i24);
                        width3 = i23 - ((measuredWidth4 + ((LinearLayout.LayoutParams) c2008x2).leftMargin) + iMax);
                    }
                    i22++;
                }
                return;
            }
            int paddingLeft3 = getPaddingLeft();
            while (i22 < childCount) {
                View childAt4 = getChildAt(i22);
                C2008x c2008x3 = (C2008x) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !c2008x3.f6645a) {
                    int i25 = paddingLeft3 + ((LinearLayout.LayoutParams) c2008x3).leftMargin;
                    int measuredWidth5 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i26 = i13 - (measuredHeight4 / 2);
                    childAt4.layout(i25, i26, i25 + measuredWidth5, measuredHeight4 + i26);
                    paddingLeft3 = measuredWidth5 + ((LinearLayout.LayoutParams) c2008x3).rightMargin + iMax + i25;
                }
                i22++;
            }
            return;
        }
        int extraPadding = getExtraPadding();
        int childCount2 = getChildCount();
        int i27 = (i11 - i6) / 2;
        int dividerWidth2 = getDividerWidth();
        int i28 = i10 - i;
        int paddingRight2 = ((i28 - getPaddingRight()) - getPaddingLeft()) - (extraPadding * 2);
        boolean zB2 = I0.b(this);
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        while (i29 < childCount2) {
            View childAt5 = getChildAt(i29);
            if (childAt5.getVisibility() != i12) {
                C2008x c2008x4 = (C2008x) childAt5.getLayoutParams();
                if (c2008x4.f6645a) {
                    int measuredWidth6 = childAt5.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i29)) {
                        measuredWidth6 += dividerWidth2;
                    }
                    int measuredHeight5 = childAt5.getMeasuredHeight();
                    if (zB2) {
                        paddingLeft2 = getPaddingLeft() + extraPadding + ((LinearLayout.LayoutParams) c2008x4).leftMargin;
                        width2 = paddingLeft2 + measuredWidth6;
                    } else {
                        width2 = ((getWidth() - extraPadding) - getPaddingRight()) - ((LinearLayout.LayoutParams) c2008x4).rightMargin;
                        paddingLeft2 = width2 - measuredWidth6;
                    }
                    int i32 = i27 - (measuredHeight5 / 2);
                    childAt5.layout(paddingLeft2, i32, width2, measuredHeight5 + i32);
                    paddingRight2 -= measuredWidth6;
                    i30 = 1;
                } else {
                    paddingRight2 -= (childAt5.getMeasuredWidth() + ((LinearLayout.LayoutParams) c2008x4).leftMargin) + ((LinearLayout.LayoutParams) c2008x4).rightMargin;
                    hasSupportDividerBeforeChildAt(i29);
                    i31++;
                }
            }
            i29++;
            i12 = 8;
        }
        if (childCount2 == 1 && i30 == 0) {
            View childAt6 = getChildAt(0);
            int measuredWidth7 = childAt6.getMeasuredWidth();
            int measuredHeight6 = childAt6.getMeasuredHeight();
            int i33 = (i28 / 2) - (measuredWidth7 / 2);
            int i34 = i27 - (measuredHeight6 / 2);
            childAt6.layout(i33, i34, measuredWidth7 + i33, measuredHeight6 + i34);
            return;
        }
        int i35 = i31 - (i30 ^ 1);
        int iMax2 = Math.max(0, i35 > 0 ? paddingRight2 / i35 : 0);
        if (zB2) {
            int width4 = (getWidth() - getPaddingRight()) - extraPadding;
            for (int i36 = 0; i36 < childCount2; i36++) {
                View childAt7 = getChildAt(i36);
                C2008x c2008x5 = (C2008x) childAt7.getLayoutParams();
                if (childAt7.getVisibility() != 8 && !c2008x5.f6645a) {
                    int i37 = width4 - ((LinearLayout.LayoutParams) c2008x5).rightMargin;
                    int measuredWidth8 = childAt7.getMeasuredWidth();
                    int measuredHeight7 = childAt7.getMeasuredHeight();
                    int i38 = i27 - (measuredHeight7 / 2);
                    childAt7.layout(i37 - measuredWidth8, i38, i37, measuredHeight7 + i38);
                    width4 = i37 - ((measuredWidth8 + ((LinearLayout.LayoutParams) c2008x5).leftMargin) + iMax2);
                }
            }
            return;
        }
        int paddingLeft4 = getPaddingLeft() + extraPadding;
        for (int i39 = 0; i39 < childCount2; i39++) {
            View childAt8 = getChildAt(i39);
            C2008x c2008x6 = (C2008x) childAt8.getLayoutParams();
            if (childAt8.getVisibility() != 8 && !c2008x6.f6645a) {
                int i40 = paddingLeft4 + ((LinearLayout.LayoutParams) c2008x6).leftMargin;
                int measuredWidth9 = childAt8.getMeasuredWidth();
                int measuredHeight8 = childAt8.getMeasuredHeight();
                int i41 = i27 - (measuredHeight8 / 2);
                childAt8.layout(i40, i41, i40 + measuredWidth9, measuredHeight8 + i41);
                paddingLeft4 = measuredWidth9 + ((LinearLayout.LayoutParams) c2008x6).rightMargin + iMax2 + i40;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v9, types: [boolean, int] */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i, int i6) throws Resources.NotFoundException {
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        ?? r11;
        int i12;
        int i13;
        Va.n nVar;
        boolean z12 = this.h;
        ?? r42 = 0;
        boolean z13 = View.MeasureSpec.getMode(i) == 1073741824;
        this.h = z13;
        if (z12 != z13) {
            this.i = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.h && (nVar = this.f6443a) != null && size != this.i) {
            this.i = size;
            nVar.o(true);
        }
        int childCount = getChildCount();
        if (!this.h || childCount <= 0) {
            for (int i14 = 0; i14 < childCount; i14++) {
                C2008x c2008x = (C2008x) getChildAt(i14).getLayoutParams();
                ((LinearLayout.LayoutParams) c2008x).rightMargin = 0;
                ((LinearLayout.LayoutParams) c2008x).leftMargin = 0;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_action_overflow_btn_margin_right);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_last_margin_right);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_next_overflow_margin_right);
                int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_margin_right);
                if (c2008x.f6645a) {
                    c2008x.setMarginEnd(dimensionPixelSize);
                    c2008x.resolveLayoutDirection(getLayoutDirection());
                } else {
                    boolean z14 = this.m;
                    if (z14 && i14 == childCount - 2) {
                        dimensionPixelSize2 = dimensionPixelSize3;
                    } else if (z14 || i14 != childCount - 1) {
                        dimensionPixelSize2 = dimensionPixelSize4;
                    }
                    c2008x.setMarginEnd(dimensionPixelSize2);
                    c2008x.resolveLayoutDirection(getLayoutDirection());
                }
            }
            super.onMeasure(i, i6);
            return;
        }
        int i15 = 8;
        if (this.e.f6635F) {
            int extraPadding = getExtraPadding();
            int mode = View.MeasureSpec.getMode(i6);
            int size2 = View.MeasureSpec.getSize(i);
            int size3 = View.MeasureSpec.getSize(i6);
            int paddingRight = (extraPadding * 2) + getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingBottom, -2);
            int i16 = size2 - paddingRight;
            int childCount2 = getChildCount();
            if (childCount2 == 0) {
                setMeasuredDimension(i16, 0);
                return;
            }
            int i17 = i16 / childCount2;
            int i18 = 0;
            int iMax = 0;
            int iMax2 = 0;
            while (i18 < childCount2) {
                View childAt = getChildAt(i18);
                if (childAt.getVisibility() != i15) {
                    boolean z15 = childAt instanceof ActionMenuItemView;
                    C2008x c2008x2 = (C2008x) childAt.getLayoutParams();
                    c2008x2.f = r42;
                    c2008x2.c = r42;
                    c2008x2.b = r42;
                    c2008x2.d = r42;
                    ((LinearLayout.LayoutParams) c2008x2).leftMargin = r42;
                    ((LinearLayout.LayoutParams) c2008x2).rightMargin = r42;
                    c2008x2.e = (z15 && ((ActionMenuItemView) childAt).hasText()) ? true : r42;
                    C2008x c2008x3 = (C2008x) childAt.getLayoutParams();
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                    c2008x3.b = 1;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i17, BasicMeasure.EXACTLY), iMakeMeasureSpec);
                    iMax2 = Math.max(iMax2, 1);
                    iMax = Math.max(iMax, childAt.getMeasuredHeight());
                }
                i18++;
                r42 = 0;
                i15 = 8;
            }
            if (mode != 1073741824) {
                size3 = iMax;
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i), size3);
            return;
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        int size4 = View.MeasureSpec.getSize(i);
        int size5 = View.MeasureSpec.getSize(i6);
        int paddingRight2 = getPaddingRight() + getPaddingLeft();
        int paddingBottom2 = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, paddingBottom2, -2);
        int i19 = size4 - paddingRight2;
        int i20 = this.f6444j;
        int i21 = i19 / i20;
        int i22 = i19 % i20;
        if (i21 == 0) {
            setMeasuredDimension(i19, 0);
            return;
        }
        int i23 = (i22 / i21) + i20;
        int childCount3 = getChildCount();
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        boolean z16 = false;
        int i28 = 0;
        long j5 = 0;
        while (true) {
            i10 = this.k;
            if (i27 >= childCount3) {
                break;
            }
            View childAt2 = getChildAt(i27);
            int i29 = size5;
            if (childAt2.getVisibility() != 8) {
                boolean z17 = childAt2 instanceof ActionMenuItemView;
                i24++;
                if (z17) {
                    childAt2.setPadding(i10, 0, i10, 0);
                }
                C2008x c2008x4 = (C2008x) childAt2.getLayoutParams();
                c2008x4.f = false;
                c2008x4.c = 0;
                c2008x4.b = 0;
                c2008x4.d = false;
                ((LinearLayout.LayoutParams) c2008x4).leftMargin = 0;
                ((LinearLayout.LayoutParams) c2008x4).rightMargin = 0;
                c2008x4.e = z17 && ((ActionMenuItemView) childAt2).hasText();
                int iMeasureChildForCells = measureChildForCells(childAt2, i23, c2008x4.f6645a ? 1 : i21, childMeasureSpec2, paddingBottom2);
                int iMax3 = Math.max(i25, iMeasureChildForCells);
                if (c2008x4.d) {
                    i28++;
                }
                if (c2008x4.f6645a) {
                    z16 = true;
                }
                i21 -= iMeasureChildForCells;
                int iMax4 = Math.max(i26, childAt2.getMeasuredHeight());
                if (iMeasureChildForCells == 1) {
                    j5 |= 1 << i27;
                }
                i26 = iMax4;
                i25 = iMax3;
            }
            i27++;
            size5 = i29;
        }
        int i30 = size5;
        boolean z18 = z16 && i24 == 2;
        boolean z19 = false;
        while (i28 > 0 && i21 > 0) {
            int i31 = Integer.MAX_VALUE;
            long j6 = 0;
            int i32 = 0;
            int i33 = 0;
            while (i32 < childCount3) {
                boolean z20 = z18;
                C2008x c2008x5 = (C2008x) getChildAt(i32).getLayoutParams();
                boolean z21 = z19;
                if (c2008x5.d) {
                    int i34 = c2008x5.b;
                    if (i34 < i31) {
                        i12 = i23;
                        i13 = i32;
                        i31 = i34;
                        j6 = 1 << i32;
                        i33 = 1;
                    } else {
                        i12 = i23;
                        i13 = i32;
                        if (i34 == i31) {
                            j6 |= 1 << i13;
                            i33++;
                        }
                    }
                } else {
                    i12 = i23;
                    i13 = i32;
                }
                i32 = i13 + 1;
                z19 = z21;
                z18 = z20;
                i23 = i12;
            }
            boolean z22 = z18;
            z10 = z19;
            i11 = i23;
            j5 |= j6;
            if (i33 > i21) {
                break;
            }
            int i35 = i31 + 1;
            int i36 = 0;
            while (i36 < childCount3) {
                View childAt3 = getChildAt(i36);
                C2008x c2008x6 = (C2008x) childAt3.getLayoutParams();
                int i37 = i26;
                long j10 = 1 << i36;
                if ((j6 & j10) != 0) {
                    if (z22 && c2008x6.e) {
                        r11 = 1;
                        r11 = 1;
                        if (i21 == 1) {
                            childAt3.setPadding(i10 + i11, 0, i10, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    c2008x6.b += r11;
                    c2008x6.f = r11;
                    i21--;
                } else if (c2008x6.b == i35) {
                    j5 |= j10;
                }
                i36++;
                i26 = i37;
            }
            z18 = z22;
            i23 = i11;
            z19 = true;
        }
        z10 = z19;
        i11 = i23;
        int i38 = i26;
        boolean z23 = !z16 && i24 == 1;
        if (i21 <= 0 || j5 == 0 || (i21 >= i24 - 1 && !z23 && i25 <= 1)) {
            z11 = z10;
        } else {
            float fBitCount = Long.bitCount(j5);
            if (!z23) {
                if ((j5 & 1) != 0 && !((C2008x) getChildAt(0).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
                int i39 = childCount3 - 1;
                if ((j5 & (1 << i39)) != 0 && !((C2008x) getChildAt(i39).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
            }
            int i40 = fBitCount > 0.0f ? (int) ((i21 * i11) / fBitCount) : 0;
            boolean z24 = z10;
            for (int i41 = 0; i41 < childCount3; i41++) {
                if ((j5 & (1 << i41)) != 0) {
                    View childAt4 = getChildAt(i41);
                    C2008x c2008x7 = (C2008x) childAt4.getLayoutParams();
                    if (childAt4 instanceof ActionMenuItemView) {
                        c2008x7.c = i40;
                        c2008x7.f = true;
                        if (i41 == 0 && !c2008x7.e) {
                            ((LinearLayout.LayoutParams) c2008x7).leftMargin = (-i40) / 2;
                        }
                        z24 = true;
                    } else if (c2008x7.f6645a) {
                        c2008x7.c = i40;
                        c2008x7.f = true;
                        ((LinearLayout.LayoutParams) c2008x7).rightMargin = (-i40) / 2;
                        z24 = true;
                    } else {
                        if (i41 != 0) {
                            ((LinearLayout.LayoutParams) c2008x7).leftMargin = i40 / 2;
                        }
                        if (i41 != childCount3 - 1) {
                            ((LinearLayout.LayoutParams) c2008x7).rightMargin = i40 / 2;
                        }
                    }
                }
            }
            z11 = z24;
        }
        if (z11) {
            for (int i42 = 0; i42 < childCount3; i42++) {
                View childAt5 = getChildAt(i42);
                C2008x c2008x8 = (C2008x) childAt5.getLayoutParams();
                if (c2008x8.f) {
                    childAt5.measure(View.MeasureSpec.makeMeasureSpec((c2008x8.b * i11) + c2008x8.c, BasicMeasure.EXACTLY), childMeasureSpec2);
                }
            }
        }
        setMeasuredDimension(i19, mode2 != 1073741824 ? i38 : i30);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.e.u = z10;
    }

    public void setHasOverflow(boolean z10) {
        this.m = z10;
    }

    public void setOnMenuItemClickListener(InterfaceC2009y interfaceC2009y) {
        this.l = interfaceC2009y;
    }

    public void setOverflowDrawable(Drawable drawable) {
        C2005u c2005u = this.e;
        if (c2005u != null) {
            c2005u.f6643x = drawable;
            C2002q c2002q = c2005u.i;
            if (c2002q != null) {
                c2002q.setImageDrawable(drawable);
            }
        }
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        C2005u c2005u = this.e;
        C2002q c2002q = c2005u.i;
        if (c2002q != null) {
            c2002q.setImageDrawable(drawable);
        } else {
            c2005u.l = true;
            c2005u.k = drawable;
        }
    }

    public void setOverflowReserved(boolean z10) {
        this.d = z10;
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.c != i) {
            this.c = i;
            if (i == 0) {
                this.b = getContext();
            } else {
                this.b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C2005u c2005u) {
        this.e = c2005u;
        c2005u.h = this;
        this.f6443a = c2005u.c;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return c(layoutParams);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C2008x(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        C2008x c2008x = new C2008x(-2, -2);
        c2008x.f6645a = false;
        ((LinearLayout.LayoutParams) c2008x).gravity = 16;
        return c2008x;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C2008x(getContext(), attributeSet);
    }
}
