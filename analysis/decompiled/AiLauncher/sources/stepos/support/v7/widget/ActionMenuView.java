package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.view.menu.ActionMenuItemView;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;

/* loaded from: classes5.dex */
public class ActionMenuView extends LinearLayoutCompat implements c.b, stepos.support.v7.view.menu.h {

    /* renamed from: a, reason: collision with root package name */
    public stepos.support.v7.view.menu.c f41198a;

    /* renamed from: b, reason: collision with root package name */
    public Context f41199b;

    /* renamed from: c, reason: collision with root package name */
    public int f41200c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f41201d;

    /* renamed from: e, reason: collision with root package name */
    public ActionMenuPresenter f41202e;

    /* renamed from: f, reason: collision with root package name */
    public g.a f41203f;

    /* renamed from: g, reason: collision with root package name */
    public c.a f41204g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f41205h;

    /* renamed from: i, reason: collision with root package name */
    public int f41206i;

    /* renamed from: j, reason: collision with root package name */
    public int f41207j;

    /* renamed from: k, reason: collision with root package name */
    public int f41208k;

    /* renamed from: l, reason: collision with root package name */
    public f f41209l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41210m;

    public interface b {
        boolean a();

        boolean b();
    }

    public class c implements g.a {
        public c() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public void a(stepos.support.v7.view.menu.c cVar, boolean z10) {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public boolean b(stepos.support.v7.view.menu.c cVar) {
            return false;
        }
    }

    public static class d extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f41212a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f41213b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f41214c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f41215d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f41216e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f41217f;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public d(d dVar) {
            super((ViewGroup.LayoutParams) dVar);
            this.f41212a = dVar.f41212a;
        }

        public d(int i10, int i11) {
            super(i10, i11);
            this.f41212a = false;
        }
    }

    public class e implements c.a {
        public e() {
        }

        @Override // stepos.support.v7.view.menu.c.a
        public void a(stepos.support.v7.view.menu.c cVar) {
            if (ActionMenuView.this.f41204g != null) {
                ActionMenuView.this.f41204g.a(cVar);
            }
        }

        @Override // stepos.support.v7.view.menu.c.a
        public boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            return ActionMenuView.this.f41209l != null && ActionMenuView.this.f41209l.onMenuItemClick(menuItem);
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    private int getExtraPadding() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof ActionMenuItemView) && ((ActionMenuItemView) getChildAt(i10)).getItemData().getIcon() != null) {
                return Ic.a.b(getContext()).f();
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int t(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            stepos.support.v7.widget.ActionMenuView$d r0 = (stepos.support.v7.widget.ActionMenuView.d) r0
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
            boolean r9 = r9.i()
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
            boolean r7 = r0.f41212a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f41215d = r1
            r0.f41213b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionMenuView.t(android.view.View, int, int, int, int):int");
    }

    public static int u(View view, int i10, int i11, int i12) {
        d dVar = (d) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11) - i12, View.MeasureSpec.getMode(i11));
        dVar.f41213b = 1;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), iMakeMeasureSpec);
        return 1;
    }

    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    private void w(int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        boolean z11;
        boolean z12;
        boolean z13;
        ?? r32;
        int i14;
        if (this.f41202e.Q()) {
            x(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i15 = size - paddingLeft;
        int i16 = this.f41207j;
        int i17 = i15 / i16;
        int i18 = i15 % i16;
        if (i17 == 0) {
            setMeasuredDimension(i15, 0);
            return;
        }
        int i19 = i16 + (i18 / i17);
        int childCount = getChildCount();
        int iMax = 0;
        int i20 = 0;
        boolean z14 = false;
        int i21 = 0;
        int iMax2 = 0;
        int i22 = 0;
        long j10 = 0;
        while (i20 < childCount) {
            View childAt = getChildAt(i20);
            int i23 = size2;
            if (childAt.getVisibility() == 8) {
                i14 = i19;
            } else {
                boolean z15 = childAt instanceof ActionMenuItemView;
                i21++;
                if (z15) {
                    int i24 = this.f41208k;
                    z13 = z15;
                    r32 = 0;
                    childAt.setPadding(i24, 0, i24, 0);
                } else {
                    z13 = z15;
                    r32 = 0;
                }
                d dVar = (d) childAt.getLayoutParams();
                dVar.f41217f = r32;
                dVar.f41214c = r32;
                dVar.f41213b = r32;
                dVar.f41215d = r32;
                ((LinearLayout.LayoutParams) dVar).leftMargin = r32;
                ((LinearLayout.LayoutParams) dVar).rightMargin = r32;
                dVar.f41216e = z13 && ((ActionMenuItemView) childAt).i();
                int iT = t(childAt, i19, dVar.f41212a ? 1 : i17, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iT);
                i14 = i19;
                if (dVar.f41215d) {
                    i22++;
                }
                if (dVar.f41212a) {
                    z14 = true;
                }
                i17 -= iT;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iT == 1) {
                    j10 |= 1 << i20;
                }
            }
            i20++;
            size2 = i23;
            i19 = i14;
        }
        int i25 = size2;
        int i26 = i19;
        char c10 = 2;
        boolean z16 = z14 && i21 == 2;
        boolean z17 = false;
        while (i22 > 0 && i17 > 0) {
            int i27 = Integer.MAX_VALUE;
            long j11 = 0;
            int i28 = 0;
            int i29 = 0;
            while (i29 < childCount) {
                char c11 = c10;
                d dVar2 = (d) getChildAt(i29).getLayoutParams();
                boolean z18 = z16;
                if (dVar2.f41215d) {
                    int i30 = dVar2.f41213b;
                    if (i30 < i27) {
                        z12 = z17;
                        i27 = i30;
                        j11 = 1 << i29;
                        i28 = 1;
                    } else {
                        z12 = z17;
                        if (i30 == i27) {
                            j11 |= 1 << i29;
                            i28++;
                        }
                    }
                } else {
                    z12 = z17;
                }
                i29++;
                z16 = z18;
                c10 = c11;
                z17 = z12;
            }
            char c12 = c10;
            boolean z19 = z16;
            z10 = z17;
            j10 |= j11;
            if (i28 > i17) {
                break;
            }
            int i31 = i27 + 1;
            int i32 = 0;
            while (i32 < childCount) {
                View childAt2 = getChildAt(i32);
                d dVar3 = (d) childAt2.getLayoutParams();
                long j12 = 1 << i32;
                if ((j11 & j12) == 0) {
                    if (dVar3.f41213b == i31) {
                        j10 |= j12;
                    }
                    i13 = i32;
                } else {
                    if (!z19 || !dVar3.f41216e) {
                        i13 = i32;
                        z11 = true;
                    } else if (i17 == 1) {
                        int i33 = this.f41208k;
                        z11 = true;
                        i13 = i32;
                        childAt2.setPadding(i33 + i26, 0, i33, 0);
                    } else {
                        i13 = i32;
                        z11 = true;
                    }
                    dVar3.f41213b++;
                    dVar3.f41217f = z11;
                    i17--;
                }
                i32 = i13 + 1;
            }
            z16 = z19;
            c10 = c12;
            z17 = true;
        }
        z10 = z17;
        boolean z20 = !z14 && i21 == 1;
        if (i17 <= 0 || j10 == 0 || (i17 >= i21 - 1 && !z20 && iMax2 <= 1)) {
            i12 = 0;
        } else {
            float fBitCount = Long.bitCount(j10);
            if (z20) {
                i12 = 0;
            } else {
                if ((j10 & 1) != 0) {
                    i12 = 0;
                    if (!((d) getChildAt(0).getLayoutParams()).f41216e) {
                        fBitCount -= 0.5f;
                    }
                } else {
                    i12 = 0;
                }
                int i34 = childCount - 1;
                if ((j10 & (1 << i34)) != 0 && !((d) getChildAt(i34).getLayoutParams()).f41216e) {
                    fBitCount -= 0.5f;
                }
            }
            int i35 = fBitCount > 0.0f ? (int) ((i17 * i26) / fBitCount) : i12;
            for (int i36 = i12; i36 < childCount; i36++) {
                if ((j10 & (1 << i36)) != 0) {
                    View childAt3 = getChildAt(i36);
                    d dVar4 = (d) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        dVar4.f41214c = i35;
                        dVar4.f41217f = true;
                        if (i36 == 0 && !dVar4.f41216e) {
                            ((LinearLayout.LayoutParams) dVar4).leftMargin = (-i35) / 2;
                        }
                        z10 = true;
                    } else if (dVar4.f41212a) {
                        dVar4.f41214c = i35;
                        dVar4.f41217f = true;
                        ((LinearLayout.LayoutParams) dVar4).rightMargin = (-i35) / 2;
                        z10 = true;
                    } else {
                        if (i36 != 0) {
                            ((LinearLayout.LayoutParams) dVar4).leftMargin = i35 / 2;
                        }
                        if (i36 != childCount - 1) {
                            ((LinearLayout.LayoutParams) dVar4).rightMargin = i35 / 2;
                        }
                    }
                }
            }
        }
        if (z10) {
            for (int i37 = i12; i37 < childCount; i37++) {
                View childAt4 = getChildAt(i37);
                d dVar5 = (d) childAt4.getLayoutParams();
                if (dVar5.f41217f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((dVar5.f41213b * i26) + dVar5.f41214c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i15, mode != 1073741824 ? iMax : i25);
    }

    public boolean A() {
        ActionMenuPresenter actionMenuPresenter = this.f41202e;
        return actionMenuPresenter != null && actionMenuPresenter.a0();
    }

    @Override // stepos.support.v7.view.menu.h
    public void a(stepos.support.v7.view.menu.c cVar) {
        this.f41198a = cVar;
    }

    @Override // stepos.support.v7.view.menu.c.b
    public boolean b(stepos.support.v7.view.menu.e eVar) {
        return this.f41198a.K(eVar, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof d);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f41198a == null) {
            Context context = getContext();
            stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(context);
            this.f41198a = cVar;
            cVar.Q(new e());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f41202e = actionMenuPresenter;
            actionMenuPresenter.Y(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f41202e;
            g.a cVar2 = this.f41203f;
            if (cVar2 == null) {
                cVar2 = new c();
            }
            actionMenuPresenter2.o(cVar2);
            this.f41198a.c(this.f41202e, this.f41199b);
            this.f41202e.V(this);
        }
        return this.f41198a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f41202e.L();
    }

    public int getPopupTheme() {
        return this.f41200c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void i(d dVar, int i10, int i11) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.stepos_action_overflow_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.stepos_action_menu_item_last_margin_right);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.stepos_action_menu_item_next_overflow_margin_right);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R$dimen.stepos_action_menu_item_margin_right);
        if (dVar.f41212a) {
            dVar.setMarginEnd(dimensionPixelSize);
            dVar.resolveLayoutDirection(getLayoutDirection());
            return;
        }
        boolean z10 = this.f41210m;
        if (z10 && i10 == i11 - 2) {
            dimensionPixelSize2 = dimensionPixelSize3;
        } else if (z10 || i10 != i11 - 1) {
            dimensionPixelSize2 = dimensionPixelSize4;
        }
        dVar.setMarginEnd(dimensionPixelSize2);
        dVar.resolveLayoutDirection(getLayoutDirection());
    }

    public void j() {
        ActionMenuPresenter actionMenuPresenter = this.f41202e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.I();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public d generateDefaultLayoutParams() {
        d dVar = new d(-2, -2);
        ((LinearLayout.LayoutParams) dVar).gravity = 16;
        return dVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        d dVar = layoutParams instanceof d ? new d((d) layoutParams) : new d(layoutParams);
        if (((LinearLayout.LayoutParams) dVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) dVar).gravity = 16;
        }
        return dVar;
    }

    public d n() {
        d dVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        dVarGenerateDefaultLayoutParams.f41212a = true;
        return dVarGenerateDefaultLayoutParams;
    }

    public boolean o(int i10) {
        boolean zA = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof b)) {
            zA = ((b) childAt).a();
        }
        return (i10 <= 0 || !(childAt2 instanceof b)) ? zA : ((b) childAt2).b() | zA;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f41202e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b(false);
            if (this.f41202e.P()) {
                this.f41202e.M();
                this.f41202e.a0();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int width;
        int paddingLeft;
        if (!this.f41205h) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        if (this.f41202e.Q()) {
            v(i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i14 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i12 - i10;
        int paddingRight = (i15 - getPaddingRight()) - getPaddingLeft();
        boolean zM = y.m(this);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.f41212a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (o(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) dVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) dVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) dVar).leftMargin) + ((LinearLayout.LayoutParams) dVar).rightMargin;
                    o(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        int iMax = Math.max(0, i22 > 0 ? paddingRight / i22 : 0);
        if (zM) {
            int width2 = getWidth() - getPaddingRight();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                d dVar2 = (d) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !dVar2.f41212a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) dVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) dVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            d dVar3 = (d) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !dVar3.f41212a) {
                int i27 = paddingLeft2 + ((LinearLayout.LayoutParams) dVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft2 = i27 + measuredWidth4 + ((LinearLayout.LayoutParams) dVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        stepos.support.v7.view.menu.c cVar;
        boolean z10 = this.f41205h;
        boolean z11 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.f41205h = z11;
        if (z10 != z11) {
            this.f41206i = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.f41205h && (cVar = this.f41198a) != null && size != this.f41206i) {
            this.f41206i = size;
            cVar.J(true);
        }
        int childCount = getChildCount();
        if (this.f41205h && childCount > 0) {
            w(i10, i11);
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            d dVar = (d) getChildAt(i12).getLayoutParams();
            ((LinearLayout.LayoutParams) dVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) dVar).leftMargin = 0;
            i(dVar, i12, childCount);
        }
        super.onMeasure(i10, i11);
    }

    public boolean p() {
        ActionMenuPresenter actionMenuPresenter = this.f41202e;
        return actionMenuPresenter != null && actionMenuPresenter.M();
    }

    public boolean q() {
        ActionMenuPresenter actionMenuPresenter = this.f41202e;
        return actionMenuPresenter != null && actionMenuPresenter.O();
    }

    public boolean r() {
        ActionMenuPresenter actionMenuPresenter = this.f41202e;
        return actionMenuPresenter != null && actionMenuPresenter.P();
    }

    public boolean s() {
        return this.f41201d;
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f41202e.S(z10);
    }

    public void setHasOverflow(boolean z10) {
        this.f41210m = z10;
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.f41209l = fVar;
    }

    public void setOverflowDrawable(Drawable drawable) {
        ActionMenuPresenter actionMenuPresenter = this.f41202e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.W(drawable);
        }
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f41202e.X(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.f41201d = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f41200c != i10) {
            this.f41200c = i10;
            if (i10 == 0) {
                this.f41199b = getContext();
            } else {
                this.f41199b = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f41202e = actionMenuPresenter;
        actionMenuPresenter.V(this);
    }

    public void v(int i10, int i11, int i12, int i13) {
        int width;
        int paddingLeft;
        int extraPadding = getExtraPadding();
        int childCount = getChildCount();
        int i14 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i12 - i10;
        int paddingRight = ((i15 - getPaddingRight()) - getPaddingLeft()) - (extraPadding * 2);
        boolean zM = y.m(this);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.f41212a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (o(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM) {
                        paddingLeft = extraPadding + getPaddingLeft() + ((LinearLayout.LayoutParams) dVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = ((getWidth() - extraPadding) - getPaddingRight()) - ((LinearLayout.LayoutParams) dVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) dVar).leftMargin) + ((LinearLayout.LayoutParams) dVar).rightMargin;
                    o(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        int iMax = Math.max(0, i22 > 0 ? paddingRight / i22 : 0);
        if (zM) {
            int width2 = (getWidth() - getPaddingRight()) - extraPadding;
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                d dVar2 = (d) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !dVar2.f41212a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) dVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) dVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft() + extraPadding;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            d dVar3 = (d) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !dVar3.f41212a) {
                int i27 = paddingLeft2 + ((LinearLayout.LayoutParams) dVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft2 = i27 + measuredWidth4 + ((LinearLayout.LayoutParams) dVar3).rightMargin + iMax;
            }
        }
    }

    public final void x(int i10, int i11) {
        int extraPadding = getExtraPadding();
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight() + (extraPadding * 2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i12 = size - paddingLeft;
        int childCount = getChildCount();
        if (childCount == 0) {
            setMeasuredDimension(i12, 0);
            return;
        }
        int i13 = i12 / childCount;
        int iMax = 0;
        int iMax2 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                boolean z10 = childAt instanceof ActionMenuItemView;
                d dVar = (d) childAt.getLayoutParams();
                dVar.f41217f = false;
                dVar.f41214c = 0;
                dVar.f41213b = 0;
                dVar.f41215d = false;
                ((LinearLayout.LayoutParams) dVar).leftMargin = 0;
                ((LinearLayout.LayoutParams) dVar).rightMargin = 0;
                dVar.f41216e = z10 && ((ActionMenuItemView) childAt).i();
                iMax2 = Math.max(iMax2, u(childAt, i13, childMeasureSpec, paddingTop));
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
            }
        }
        if (mode != 1073741824) {
            size2 = iMax;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), size2);
    }

    public stepos.support.v7.view.menu.c y() {
        return this.f41198a;
    }

    public void z(g.a aVar, c.a aVar2) {
        this.f41203f = aVar;
        this.f41204g = aVar2;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f41207j = (int) (56.0f * f10);
        this.f41208k = (int) (f10 * 4.0f);
        this.f41199b = context;
        this.f41200c = 0;
        setMotionEventSplittingEnabled(false);
    }
}
