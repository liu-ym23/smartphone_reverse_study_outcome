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
import com.stepos.aiengine.R;
import stepos.support.v7.app.n0;
import stepos.support.v7.view.menu.ActionMenuItemView;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.widget.ActionMenuPresenter;
import stepos.support.v7.widget.Toolbar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements c.b, stepos.support.v7.view.menu.h {
    public int A;
    public final int B;
    public final int C;
    public e D;
    public boolean E;

    /* renamed from: s, reason: collision with root package name */
    public stepos.support.v7.view.menu.c f12523s;

    /* renamed from: t, reason: collision with root package name */
    public Context f12524t;

    /* renamed from: u, reason: collision with root package name */
    public int f12525u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12526v;

    /* renamed from: w, reason: collision with root package name */
    public ActionMenuPresenter f12527w;

    /* renamed from: x, reason: collision with root package name */
    public n0.d f12528x;

    /* renamed from: y, reason: collision with root package name */
    public n0.e f12529y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        boolean a();

        boolean b();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f12530a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f12531b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f12532c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f12533d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f12534e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f12535f;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements c.a {
        public d() {
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final void a(stepos.support.v7.view.menu.c cVar) {
            n0.e eVar = ActionMenuView.this.f12529y;
            if (eVar != null) {
                eVar.a(cVar);
            }
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.D;
            if (eVar != null) {
                Toolbar.f fVar = Toolbar.this.L;
                if (fVar != null ? n0.this.f12160c.f8920a.onMenuItemSelected(0, menuItem) : false) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.B = (int) (56.0f * f8);
        this.C = (int) (f8 * 4.0f);
        this.f12524t = context;
        this.f12525u = 0;
        setMotionEventSplittingEnabled(false);
    }

    private int getExtraPadding() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof ActionMenuItemView) && ((ActionMenuItemView) getChildAt(i10)).getItemData().getIcon() != null) {
                return fe.a.a(getContext()).b();
            }
        }
        return 0;
    }

    public static c l() {
        c cVar = new c(-2, -2);
        cVar.f12530a = false;
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    public static c m(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams == null) {
            return l();
        }
        if (layoutParams instanceof c) {
            c cVar2 = (c) layoutParams;
            cVar = new c(cVar2);
            cVar.f12530a = cVar2.f12530a;
        } else {
            cVar = new c(layoutParams);
        }
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int o(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            stepos.support.v7.widget.ActionMenuView$c r0 = (stepos.support.v7.widget.ActionMenuView.c) r0
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
            boolean r9 = r9.h()
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
            boolean r7 = r0.f12530a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f12533d = r1
            r0.f12531b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionMenuView.o(android.view.View, int, int, int, int):int");
    }

    @Override // stepos.support.v7.view.menu.h
    public final void a(stepos.support.v7.view.menu.c cVar) {
        this.f12523s = cVar;
    }

    @Override // stepos.support.v7.view.menu.c.b
    public final boolean b(stepos.support.v7.view.menu.e eVar) {
        return this.f12523s.p(eVar, null, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public Menu getMenu() {
        if (this.f12523s == null) {
            Context context = getContext();
            stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(context);
            this.f12523s = cVar;
            cVar.f12377d = new d();
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f12527w = actionMenuPresenter;
            actionMenuPresenter.f12503p = true;
            actionMenuPresenter.f12504q = true;
            g.a bVar = this.f12528x;
            if (bVar == null) {
                bVar = new b();
            }
            actionMenuPresenter.f12364e = bVar;
            this.f12523s.b(actionMenuPresenter, this.f12524t);
            ActionMenuPresenter actionMenuPresenter2 = this.f12527w;
            actionMenuPresenter2.f12366k = this;
            this.f12523s = actionMenuPresenter2.f12362c;
        }
        return this.f12523s;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f12527w;
        ActionMenuPresenter.g gVar = actionMenuPresenter.f12499l;
        if (gVar != null) {
            return gVar.getDrawable();
        }
        if (actionMenuPresenter.f12502o) {
            return actionMenuPresenter.f12501n;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f12525u;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.a generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: i */
    public final LinearLayoutCompat.a generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public final boolean n(int i10) {
        boolean zA = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i10 <= 0 || !(childAt2 instanceof a)) ? zA : ((a) childAt2).b() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f12527w;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
            if (this.f12527w.k()) {
                this.f12527w.j();
                this.f12527w.o();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f12527w;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.j();
            ActionMenuPresenter.c cVar = actionMenuPresenter.E;
            if (cVar != null) {
                cVar.h();
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int width;
        int paddingLeft;
        int width2;
        int paddingLeft2;
        if (!this.z) {
            super.onLayout(z, i10, i11, i12, i13);
            return;
        }
        int i14 = 8;
        if (!this.f12527w.I) {
            int childCount = getChildCount();
            int i15 = (i13 - i11) / 2;
            int dividerWidth = getDividerWidth();
            int i16 = i12 - i10;
            int paddingRight = (i16 - getPaddingRight()) - getPaddingLeft();
            boolean zB = g0.b(this);
            int measuredWidth = paddingRight;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt = getChildAt(i19);
                if (childAt.getVisibility() != 8) {
                    c cVar = (c) childAt.getLayoutParams();
                    if (cVar.f12530a) {
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        if (n(i19)) {
                            measuredWidth2 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (zB) {
                            paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                            width = paddingLeft + measuredWidth2;
                        } else {
                            width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                            paddingLeft = width - measuredWidth2;
                        }
                        int i20 = i15 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i20, width, measuredHeight + i20);
                        measuredWidth -= measuredWidth2;
                        i17 = 1;
                    } else {
                        measuredWidth -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                        n(i19);
                        i18++;
                    }
                }
            }
            if (childCount == 1 && i17 == 0) {
                View childAt2 = getChildAt(0);
                int measuredWidth3 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                int i21 = (i16 / 2) - (measuredWidth3 / 2);
                int i22 = i15 - (measuredHeight2 / 2);
                childAt2.layout(i21, i22, measuredWidth3 + i21, measuredHeight2 + i22);
                return;
            }
            int i23 = i18 - (i17 ^ 1);
            int i24 = 0;
            int iMax = Math.max(0, i23 > 0 ? measuredWidth / i23 : 0);
            if (zB) {
                int width3 = getWidth() - getPaddingRight();
                while (i24 < childCount) {
                    View childAt3 = getChildAt(i24);
                    c cVar2 = (c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8 && !cVar2.f12530a) {
                        int i25 = width3 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                        int measuredWidth4 = childAt3.getMeasuredWidth();
                        int measuredHeight3 = childAt3.getMeasuredHeight();
                        int i26 = i15 - (measuredHeight3 / 2);
                        childAt3.layout(i25 - measuredWidth4, i26, i25, measuredHeight3 + i26);
                        width3 = i25 - ((measuredWidth4 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                    }
                    i24++;
                }
                return;
            }
            int paddingLeft3 = getPaddingLeft();
            while (i24 < childCount) {
                View childAt4 = getChildAt(i24);
                c cVar3 = (c) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !cVar3.f12530a) {
                    int i27 = paddingLeft3 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                    int measuredWidth5 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i28 = i15 - (measuredHeight4 / 2);
                    childAt4.layout(i27, i28, i27 + measuredWidth5, measuredHeight4 + i28);
                    paddingLeft3 = measuredWidth5 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax + i27;
                }
                i24++;
            }
            return;
        }
        int extraPadding = getExtraPadding();
        int childCount2 = getChildCount();
        int i29 = (i13 - i11) / 2;
        int dividerWidth2 = getDividerWidth();
        int i30 = i12 - i10;
        int paddingRight2 = ((i30 - getPaddingRight()) - getPaddingLeft()) - (extraPadding * 2);
        boolean zB2 = g0.b(this);
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        while (i31 < childCount2) {
            View childAt5 = getChildAt(i31);
            if (childAt5.getVisibility() != i14) {
                c cVar4 = (c) childAt5.getLayoutParams();
                if (cVar4.f12530a) {
                    int measuredWidth6 = childAt5.getMeasuredWidth();
                    if (n(i31)) {
                        measuredWidth6 += dividerWidth2;
                    }
                    int measuredHeight5 = childAt5.getMeasuredHeight();
                    if (zB2) {
                        paddingLeft2 = getPaddingLeft() + extraPadding + ((LinearLayout.LayoutParams) cVar4).leftMargin;
                        width2 = paddingLeft2 + measuredWidth6;
                    } else {
                        width2 = ((getWidth() - extraPadding) - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar4).rightMargin;
                        paddingLeft2 = width2 - measuredWidth6;
                    }
                    int i34 = i29 - (measuredHeight5 / 2);
                    childAt5.layout(paddingLeft2, i34, width2, measuredHeight5 + i34);
                    paddingRight2 -= measuredWidth6;
                    i32 = 1;
                } else {
                    paddingRight2 -= (childAt5.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar4).leftMargin) + ((LinearLayout.LayoutParams) cVar4).rightMargin;
                    n(i31);
                    i33++;
                }
            }
            i31++;
            i14 = 8;
        }
        if (childCount2 == 1 && i32 == 0) {
            View childAt6 = getChildAt(0);
            int measuredWidth7 = childAt6.getMeasuredWidth();
            int measuredHeight6 = childAt6.getMeasuredHeight();
            int i35 = (i30 / 2) - (measuredWidth7 / 2);
            int i36 = i29 - (measuredHeight6 / 2);
            childAt6.layout(i35, i36, measuredWidth7 + i35, measuredHeight6 + i36);
            return;
        }
        int i37 = i33 - (i32 ^ 1);
        int iMax2 = Math.max(0, i37 > 0 ? paddingRight2 / i37 : 0);
        if (zB2) {
            int width4 = (getWidth() - getPaddingRight()) - extraPadding;
            for (int i38 = 0; i38 < childCount2; i38++) {
                View childAt7 = getChildAt(i38);
                c cVar5 = (c) childAt7.getLayoutParams();
                if (childAt7.getVisibility() != 8 && !cVar5.f12530a) {
                    int i39 = width4 - ((LinearLayout.LayoutParams) cVar5).rightMargin;
                    int measuredWidth8 = childAt7.getMeasuredWidth();
                    int measuredHeight7 = childAt7.getMeasuredHeight();
                    int i40 = i29 - (measuredHeight7 / 2);
                    childAt7.layout(i39 - measuredWidth8, i40, i39, measuredHeight7 + i40);
                    width4 = i39 - ((measuredWidth8 + ((LinearLayout.LayoutParams) cVar5).leftMargin) + iMax2);
                }
            }
            return;
        }
        int paddingLeft4 = getPaddingLeft() + extraPadding;
        for (int i41 = 0; i41 < childCount2; i41++) {
            View childAt8 = getChildAt(i41);
            c cVar6 = (c) childAt8.getLayoutParams();
            if (childAt8.getVisibility() != 8 && !cVar6.f12530a) {
                int i42 = paddingLeft4 + ((LinearLayout.LayoutParams) cVar6).leftMargin;
                int measuredWidth9 = childAt8.getMeasuredWidth();
                int measuredHeight8 = childAt8.getMeasuredHeight();
                int i43 = i29 - (measuredHeight8 / 2);
                childAt8.layout(i42, i43, i42 + measuredWidth9, measuredHeight8 + i43);
                paddingLeft4 = measuredWidth9 + ((LinearLayout.LayoutParams) cVar6).rightMargin + iMax2 + i42;
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
    public final void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        int i12;
        boolean z;
        int i13;
        boolean z3;
        ?? r11;
        int i14;
        int i15;
        stepos.support.v7.view.menu.c cVar;
        boolean z10 = this.z;
        ?? r42 = 0;
        boolean z11 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.z = z11;
        if (z10 != z11) {
            this.A = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.z && (cVar = this.f12523s) != null && size != this.A) {
            this.A = size;
            cVar.o(true);
        }
        int childCount = getChildCount();
        if (!this.z || childCount <= 0) {
            for (int i16 = 0; i16 < childCount; i16++) {
                c cVar2 = (c) getChildAt(i16).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar2).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar2).leftMargin = 0;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_action_overflow_btn_margin_right);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_last_margin_right);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_next_overflow_margin_right);
                int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_margin_right);
                if (cVar2.f12530a) {
                    cVar2.setMarginEnd(dimensionPixelSize);
                    cVar2.resolveLayoutDirection(getLayoutDirection());
                } else {
                    boolean z12 = this.E;
                    if (z12 && i16 == childCount - 2) {
                        dimensionPixelSize2 = dimensionPixelSize3;
                    } else if (z12 || i16 != childCount - 1) {
                        dimensionPixelSize2 = dimensionPixelSize4;
                    }
                    cVar2.setMarginEnd(dimensionPixelSize2);
                    cVar2.resolveLayoutDirection(getLayoutDirection());
                }
            }
            super.onMeasure(i10, i11);
            return;
        }
        int i17 = 8;
        if (this.f12527w.I) {
            int extraPadding = getExtraPadding();
            int mode = View.MeasureSpec.getMode(i11);
            int size2 = View.MeasureSpec.getSize(i10);
            int size3 = View.MeasureSpec.getSize(i11);
            int paddingRight = (extraPadding * 2) + getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingBottom, -2);
            int i18 = size2 - paddingRight;
            int childCount2 = getChildCount();
            if (childCount2 == 0) {
                setMeasuredDimension(i18, 0);
                return;
            }
            int i19 = i18 / childCount2;
            int i20 = 0;
            int iMax = 0;
            int iMax2 = 0;
            while (i20 < childCount2) {
                View childAt = getChildAt(i20);
                if (childAt.getVisibility() != i17) {
                    boolean z13 = childAt instanceof ActionMenuItemView;
                    c cVar3 = (c) childAt.getLayoutParams();
                    cVar3.f12535f = r42;
                    cVar3.f12532c = r42;
                    cVar3.f12531b = r42;
                    cVar3.f12533d = r42;
                    ((LinearLayout.LayoutParams) cVar3).leftMargin = r42;
                    ((LinearLayout.LayoutParams) cVar3).rightMargin = r42;
                    cVar3.f12534e = (z13 && ((ActionMenuItemView) childAt).h()) ? true : r42;
                    c cVar4 = (c) childAt.getLayoutParams();
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                    cVar4.f12531b = 1;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), iMakeMeasureSpec);
                    iMax2 = Math.max(iMax2, 1);
                    iMax = Math.max(iMax, childAt.getMeasuredHeight());
                }
                i20++;
                r42 = 0;
                i17 = 8;
            }
            if (mode != 1073741824) {
                size3 = iMax;
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i10), size3);
            return;
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size4 = View.MeasureSpec.getSize(i10);
        int size5 = View.MeasureSpec.getSize(i11);
        int paddingRight2 = getPaddingRight() + getPaddingLeft();
        int paddingBottom2 = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, paddingBottom2, -2);
        int i21 = size4 - paddingRight2;
        int i22 = this.B;
        int i23 = i21 / i22;
        int i24 = i21 % i22;
        if (i23 == 0) {
            setMeasuredDimension(i21, 0);
            return;
        }
        int i25 = (i24 / i23) + i22;
        int childCount3 = getChildCount();
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        boolean z14 = false;
        int i30 = 0;
        long j10 = 0;
        while (true) {
            i12 = this.C;
            if (i29 >= childCount3) {
                break;
            }
            View childAt2 = getChildAt(i29);
            int i31 = size5;
            if (childAt2.getVisibility() != 8) {
                boolean z15 = childAt2 instanceof ActionMenuItemView;
                i26++;
                if (z15) {
                    childAt2.setPadding(i12, 0, i12, 0);
                }
                c cVar5 = (c) childAt2.getLayoutParams();
                cVar5.f12535f = false;
                cVar5.f12532c = 0;
                cVar5.f12531b = 0;
                cVar5.f12533d = false;
                ((LinearLayout.LayoutParams) cVar5).leftMargin = 0;
                ((LinearLayout.LayoutParams) cVar5).rightMargin = 0;
                cVar5.f12534e = z15 && ((ActionMenuItemView) childAt2).h();
                int iO = o(childAt2, i25, cVar5.f12530a ? 1 : i23, childMeasureSpec2, paddingBottom2);
                int iMax3 = Math.max(i27, iO);
                if (cVar5.f12533d) {
                    i30++;
                }
                if (cVar5.f12530a) {
                    z14 = true;
                }
                i23 -= iO;
                int iMax4 = Math.max(i28, childAt2.getMeasuredHeight());
                if (iO == 1) {
                    j10 |= 1 << i29;
                }
                i28 = iMax4;
                i27 = iMax3;
            }
            i29++;
            size5 = i31;
        }
        int i32 = size5;
        boolean z16 = z14 && i26 == 2;
        boolean z17 = false;
        while (i30 > 0 && i23 > 0) {
            int i33 = Integer.MAX_VALUE;
            long j11 = 0;
            int i34 = 0;
            int i35 = 0;
            while (i34 < childCount3) {
                boolean z18 = z16;
                c cVar6 = (c) getChildAt(i34).getLayoutParams();
                boolean z19 = z17;
                if (cVar6.f12533d) {
                    int i36 = cVar6.f12531b;
                    if (i36 < i33) {
                        i14 = i25;
                        i15 = i34;
                        i33 = i36;
                        j11 = 1 << i34;
                        i35 = 1;
                    } else {
                        i14 = i25;
                        i15 = i34;
                        if (i36 == i33) {
                            j11 |= 1 << i15;
                            i35++;
                        }
                    }
                } else {
                    i14 = i25;
                    i15 = i34;
                }
                i34 = i15 + 1;
                z17 = z19;
                z16 = z18;
                i25 = i14;
            }
            boolean z20 = z16;
            z = z17;
            i13 = i25;
            j10 |= j11;
            if (i35 > i23) {
                break;
            }
            int i37 = i33 + 1;
            int i38 = 0;
            while (i38 < childCount3) {
                View childAt3 = getChildAt(i38);
                c cVar7 = (c) childAt3.getLayoutParams();
                int i39 = i28;
                long j12 = 1 << i38;
                if ((j11 & j12) != 0) {
                    if (z20 && cVar7.f12534e) {
                        r11 = 1;
                        r11 = 1;
                        if (i23 == 1) {
                            childAt3.setPadding(i12 + i13, 0, i12, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    cVar7.f12531b += r11;
                    cVar7.f12535f = r11;
                    i23--;
                } else if (cVar7.f12531b == i37) {
                    j10 |= j12;
                }
                i38++;
                i28 = i39;
            }
            z16 = z20;
            i25 = i13;
            z17 = true;
        }
        z = z17;
        i13 = i25;
        int i40 = i28;
        boolean z21 = !z14 && i26 == 1;
        if (i23 <= 0 || j10 == 0 || (i23 >= i26 - 1 && !z21 && i27 <= 1)) {
            z3 = z;
        } else {
            float fBitCount = Long.bitCount(j10);
            if (!z21) {
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f12534e) {
                    fBitCount -= 0.5f;
                }
                int i41 = childCount3 - 1;
                if ((j10 & (1 << i41)) != 0 && !((c) getChildAt(i41).getLayoutParams()).f12534e) {
                    fBitCount -= 0.5f;
                }
            }
            int i42 = fBitCount > 0.0f ? (int) ((i23 * i13) / fBitCount) : 0;
            boolean z22 = z;
            for (int i43 = 0; i43 < childCount3; i43++) {
                if ((j10 & (1 << i43)) != 0) {
                    View childAt4 = getChildAt(i43);
                    c cVar8 = (c) childAt4.getLayoutParams();
                    if (childAt4 instanceof ActionMenuItemView) {
                        cVar8.f12532c = i42;
                        cVar8.f12535f = true;
                        if (i43 == 0 && !cVar8.f12534e) {
                            ((LinearLayout.LayoutParams) cVar8).leftMargin = (-i42) / 2;
                        }
                        z22 = true;
                    } else if (cVar8.f12530a) {
                        cVar8.f12532c = i42;
                        cVar8.f12535f = true;
                        ((LinearLayout.LayoutParams) cVar8).rightMargin = (-i42) / 2;
                        z22 = true;
                    } else {
                        if (i43 != 0) {
                            ((LinearLayout.LayoutParams) cVar8).leftMargin = i42 / 2;
                        }
                        if (i43 != childCount3 - 1) {
                            ((LinearLayout.LayoutParams) cVar8).rightMargin = i42 / 2;
                        }
                    }
                }
            }
            z3 = z22;
        }
        if (z3) {
            for (int i44 = 0; i44 < childCount3; i44++) {
                View childAt5 = getChildAt(i44);
                c cVar9 = (c) childAt5.getLayoutParams();
                if (cVar9.f12535f) {
                    childAt5.measure(View.MeasureSpec.makeMeasureSpec((cVar9.f12531b * i13) + cVar9.f12532c, 1073741824), childMeasureSpec2);
                }
            }
        }
        setMeasuredDimension(i21, mode2 != 1073741824 ? i40 : i32);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f12527w.f12510x = z;
    }

    public void setHasOverflow(boolean z) {
        this.E = z;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.D = eVar;
    }

    public void setOverflowDrawable(Drawable drawable) {
        ActionMenuPresenter actionMenuPresenter = this.f12527w;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A = drawable;
            ActionMenuPresenter.g gVar = actionMenuPresenter.f12499l;
            if (gVar != null) {
                gVar.setImageDrawable(drawable);
            }
        }
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f12527w;
        ActionMenuPresenter.g gVar = actionMenuPresenter.f12499l;
        if (gVar != null) {
            gVar.setImageDrawable(drawable);
        } else {
            actionMenuPresenter.f12502o = true;
            actionMenuPresenter.f12501n = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.f12526v = z;
    }

    public void setPopupTheme(int i10) {
        if (this.f12525u != i10) {
            this.f12525u = i10;
            if (i10 == 0) {
                this.f12524t = getContext();
            } else {
                this.f12524t = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f12527w = actionMenuPresenter;
        actionMenuPresenter.f12366k = this;
        this.f12523s = actionMenuPresenter.f12362c;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements g.a {
        @Override // stepos.support.v7.view.menu.g.a
        public final boolean b(stepos.support.v7.view.menu.c cVar) {
            return false;
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final void a(stepos.support.v7.view.menu.c cVar, boolean z) {
        }
    }
}
