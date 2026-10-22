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
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ActionMenuView extends m.o1 implements te.k, te.x {
    public boolean A;
    public int B;
    public final int C;
    public final int D;
    public t E;
    public boolean F;

    /* renamed from: t, reason: collision with root package name */
    public te.l f12602t;

    /* renamed from: u, reason: collision with root package name */
    public Context f12603u;

    /* renamed from: v, reason: collision with root package name */
    public int f12604v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12605w;

    /* renamed from: x, reason: collision with root package name */
    public q f12606x;

    /* renamed from: y, reason: collision with root package name */
    public l3.d f12607y;

    /* renamed from: z, reason: collision with root package name */
    public stepos.support.v7.app.f f12608z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.C = (int) (56.0f * f5);
        this.D = (int) (f5 * 4.0f);
        this.f12603u = context;
        this.f12604v = 0;
        setMotionEventSplittingEnabled(false);
    }

    private int getExtraPadding() {
        for (int i = 0; i < getChildCount(); i++) {
            if ((getChildAt(i) instanceof ActionMenuItemView) && ((ActionMenuItemView) getChildAt(i)).getItemData().getIcon() != null) {
                return a4.n.c(getContext()).d();
            }
        }
        return 0;
    }

    public static s k() {
        s sVar = new s(-2, -2);
        sVar.f12827a = false;
        ((LinearLayout.LayoutParams) sVar).gravity = 16;
        return sVar;
    }

    public static s l(ViewGroup.LayoutParams layoutParams) {
        s sVar;
        if (layoutParams == null) {
            return k();
        }
        if (layoutParams instanceof s) {
            s sVar2 = (s) layoutParams;
            sVar = new s(sVar2);
            sVar.f12827a = sVar2.f12827a;
        } else {
            sVar = new s(layoutParams);
        }
        if (((LinearLayout.LayoutParams) sVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) sVar).gravity = 16;
        }
        return sVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int n(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            stepos.support.v7.widget.s r0 = (stepos.support.v7.widget.s) r0
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
            boolean r9 = r9.f()
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
            boolean r7 = r0.f12827a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f12830d = r1
            r0.f12828b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionMenuView.n(android.view.View, int, int, int, int):int");
    }

    @Override // te.x
    public final void b(te.l lVar) {
        this.f12602t = lVar;
    }

    @Override // m.o1, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof s);
    }

    @Override // te.k
    public final boolean d(te.m mVar) {
        return this.f12602t.p(mVar, null, 0);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // m.o1
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ m.n1 generateDefaultLayoutParams() {
        return k();
    }

    @Override // m.o1, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return k();
    }

    @Override // m.o1, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new s(getContext(), attributeSet);
    }

    public Menu getMenu() {
        if (this.f12602t == null) {
            Context context = getContext();
            te.l lVar = new te.l(context);
            this.f12602t = lVar;
            p pVar = new p();
            pVar.f12784c = this;
            VarHandle.storeStoreFence();
            lVar.f13346d = pVar;
            q qVar = new q(context);
            this.f12606x = qVar;
            qVar.f12812q = true;
            qVar.f12813r = true;
            te.u iVar = this.f12607y;
            if (iVar == null) {
                iVar = new r2.i(11);
            }
            qVar.i = iVar;
            this.f12602t.b(qVar, this.f12603u);
            q qVar2 = this.f12606x;
            qVar2.f12807l = this;
            this.f12602t = qVar2.f12803g;
        }
        return this.f12602t;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        q qVar = this.f12606x;
        o oVar = qVar.f12808m;
        if (oVar != null) {
            return oVar.getDrawable();
        }
        if (qVar.f12811p) {
            return qVar.f12810o;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f12604v;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // m.o1
    /* renamed from: h */
    public final m.n1 generateLayoutParams(AttributeSet attributeSet) {
        return new s(getContext(), attributeSet);
    }

    @Override // m.o1
    /* renamed from: i */
    public final /* bridge */ /* synthetic */ m.n1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return l(layoutParams);
    }

    public final boolean m(int i) {
        boolean zA = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof r)) {
            zA = ((r) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof r)) ? zA : ((r) childAt2).b() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        q qVar = this.f12606x;
        if (qVar != null) {
            qVar.c();
            if (this.f12606x.k()) {
                this.f12606x.j();
                this.f12606x.o();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q qVar = this.f12606x;
        if (qVar != null) {
            qVar.j();
            l lVar = qVar.F;
            if (lVar != null) {
                lVar.h();
            }
        }
    }

    @Override // m.o1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int width;
        int paddingLeft;
        int width2;
        int paddingLeft2;
        if (!this.A) {
            super.onLayout(z10, i, i3, i10, i11);
            return;
        }
        int i12 = 8;
        if (!this.f12606x.J) {
            int childCount = getChildCount();
            int i13 = (i11 - i3) / 2;
            int dividerWidth = getDividerWidth();
            int i14 = i10 - i;
            int paddingRight = (i14 - getPaddingRight()) - getPaddingLeft();
            boolean zB = x1.b(this);
            int measuredWidth = paddingRight;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() != 8) {
                    s sVar = (s) childAt.getLayoutParams();
                    if (sVar.f12827a) {
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        if (m(i17)) {
                            measuredWidth2 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (zB) {
                            paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) sVar).leftMargin;
                            width = paddingLeft + measuredWidth2;
                        } else {
                            width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) sVar).rightMargin;
                            paddingLeft = width - measuredWidth2;
                        }
                        int i18 = i13 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i18, width, measuredHeight + i18);
                        measuredWidth -= measuredWidth2;
                        i15 = 1;
                    } else {
                        measuredWidth -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) sVar).leftMargin) + ((LinearLayout.LayoutParams) sVar).rightMargin;
                        m(i17);
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
                    s sVar2 = (s) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8 && !sVar2.f12827a) {
                        int i23 = width3 - ((LinearLayout.LayoutParams) sVar2).rightMargin;
                        int measuredWidth4 = childAt3.getMeasuredWidth();
                        int measuredHeight3 = childAt3.getMeasuredHeight();
                        int i24 = i13 - (measuredHeight3 / 2);
                        childAt3.layout(i23 - measuredWidth4, i24, i23, measuredHeight3 + i24);
                        width3 = i23 - ((measuredWidth4 + ((LinearLayout.LayoutParams) sVar2).leftMargin) + iMax);
                    }
                    i22++;
                }
                return;
            }
            int paddingLeft3 = getPaddingLeft();
            while (i22 < childCount) {
                View childAt4 = getChildAt(i22);
                s sVar3 = (s) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !sVar3.f12827a) {
                    int i25 = paddingLeft3 + ((LinearLayout.LayoutParams) sVar3).leftMargin;
                    int measuredWidth5 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i26 = i13 - (measuredHeight4 / 2);
                    childAt4.layout(i25, i26, i25 + measuredWidth5, measuredHeight4 + i26);
                    paddingLeft3 = measuredWidth5 + ((LinearLayout.LayoutParams) sVar3).rightMargin + iMax + i25;
                }
                i22++;
            }
            return;
        }
        int extraPadding = getExtraPadding();
        int childCount2 = getChildCount();
        int i27 = (i11 - i3) / 2;
        int dividerWidth2 = getDividerWidth();
        int i28 = i10 - i;
        int paddingRight2 = ((i28 - getPaddingRight()) - getPaddingLeft()) - (extraPadding * 2);
        boolean zB2 = x1.b(this);
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        while (i29 < childCount2) {
            View childAt5 = getChildAt(i29);
            if (childAt5.getVisibility() != i12) {
                s sVar4 = (s) childAt5.getLayoutParams();
                if (sVar4.f12827a) {
                    int measuredWidth6 = childAt5.getMeasuredWidth();
                    if (m(i29)) {
                        measuredWidth6 += dividerWidth2;
                    }
                    int measuredHeight5 = childAt5.getMeasuredHeight();
                    if (zB2) {
                        paddingLeft2 = getPaddingLeft() + extraPadding + ((LinearLayout.LayoutParams) sVar4).leftMargin;
                        width2 = paddingLeft2 + measuredWidth6;
                    } else {
                        width2 = ((getWidth() - extraPadding) - getPaddingRight()) - ((LinearLayout.LayoutParams) sVar4).rightMargin;
                        paddingLeft2 = width2 - measuredWidth6;
                    }
                    int i32 = i27 - (measuredHeight5 / 2);
                    childAt5.layout(paddingLeft2, i32, width2, measuredHeight5 + i32);
                    paddingRight2 -= measuredWidth6;
                    i30 = 1;
                } else {
                    paddingRight2 -= (childAt5.getMeasuredWidth() + ((LinearLayout.LayoutParams) sVar4).leftMargin) + ((LinearLayout.LayoutParams) sVar4).rightMargin;
                    m(i29);
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
                s sVar5 = (s) childAt7.getLayoutParams();
                if (childAt7.getVisibility() != 8 && !sVar5.f12827a) {
                    int i37 = width4 - ((LinearLayout.LayoutParams) sVar5).rightMargin;
                    int measuredWidth8 = childAt7.getMeasuredWidth();
                    int measuredHeight7 = childAt7.getMeasuredHeight();
                    int i38 = i27 - (measuredHeight7 / 2);
                    childAt7.layout(i37 - measuredWidth8, i38, i37, measuredHeight7 + i38);
                    width4 = i37 - ((measuredWidth8 + ((LinearLayout.LayoutParams) sVar5).leftMargin) + iMax2);
                }
            }
            return;
        }
        int paddingLeft4 = getPaddingLeft() + extraPadding;
        for (int i39 = 0; i39 < childCount2; i39++) {
            View childAt8 = getChildAt(i39);
            s sVar6 = (s) childAt8.getLayoutParams();
            if (childAt8.getVisibility() != 8 && !sVar6.f12827a) {
                int i40 = paddingLeft4 + ((LinearLayout.LayoutParams) sVar6).leftMargin;
                int measuredWidth9 = childAt8.getMeasuredWidth();
                int measuredHeight8 = childAt8.getMeasuredHeight();
                int i41 = i27 - (measuredHeight8 / 2);
                childAt8.layout(i40, i41, i40 + measuredWidth9, measuredHeight8 + i41);
                paddingLeft4 = measuredWidth9 + ((LinearLayout.LayoutParams) sVar6).rightMargin + iMax2 + i40;
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
    @Override // m.o1, android.view.View
    public final void onMeasure(int i, int i3) throws Resources.NotFoundException {
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        ?? r11;
        int i12;
        int i13;
        te.l lVar;
        boolean z12 = this.A;
        ?? r42 = 0;
        boolean z13 = View.MeasureSpec.getMode(i) == 1073741824;
        this.A = z13;
        if (z12 != z13) {
            this.B = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.A && (lVar = this.f12602t) != null && size != this.B) {
            this.B = size;
            lVar.o(true);
        }
        int childCount = getChildCount();
        if (!this.A || childCount <= 0) {
            for (int i14 = 0; i14 < childCount; i14++) {
                s sVar = (s) getChildAt(i14).getLayoutParams();
                ((LinearLayout.LayoutParams) sVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) sVar).leftMargin = 0;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_action_overflow_btn_margin_right);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_last_margin_right);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_next_overflow_margin_right);
                int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.stepos_action_menu_item_margin_right);
                if (sVar.f12827a) {
                    sVar.setMarginEnd(dimensionPixelSize);
                    sVar.resolveLayoutDirection(getLayoutDirection());
                } else {
                    boolean z14 = this.F;
                    if (z14 && i14 == childCount - 2) {
                        dimensionPixelSize2 = dimensionPixelSize3;
                    } else if (z14 || i14 != childCount - 1) {
                        dimensionPixelSize2 = dimensionPixelSize4;
                    }
                    sVar.setMarginEnd(dimensionPixelSize2);
                    sVar.resolveLayoutDirection(getLayoutDirection());
                }
            }
            super.onMeasure(i, i3);
            return;
        }
        int i15 = 8;
        if (this.f12606x.J) {
            int extraPadding = getExtraPadding();
            int mode = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i);
            int size3 = View.MeasureSpec.getSize(i3);
            int paddingRight = (extraPadding * 2) + getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
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
                    s sVar2 = (s) childAt.getLayoutParams();
                    sVar2.f12832f = r42;
                    sVar2.f12829c = r42;
                    sVar2.f12828b = r42;
                    sVar2.f12830d = r42;
                    ((LinearLayout.LayoutParams) sVar2).leftMargin = r42;
                    ((LinearLayout.LayoutParams) sVar2).rightMargin = r42;
                    sVar2.f12831e = (z15 && ((ActionMenuItemView) childAt).f()) ? true : r42;
                    s sVar3 = (s) childAt.getLayoutParams();
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                    sVar3.f12828b = 1;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), iMakeMeasureSpec);
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
        int mode2 = View.MeasureSpec.getMode(i3);
        int size4 = View.MeasureSpec.getSize(i);
        int size5 = View.MeasureSpec.getSize(i3);
        int paddingRight2 = getPaddingRight() + getPaddingLeft();
        int paddingBottom2 = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingBottom2, -2);
        int i19 = size4 - paddingRight2;
        int i20 = this.C;
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
        long j10 = 0;
        while (true) {
            i10 = this.D;
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
                s sVar4 = (s) childAt2.getLayoutParams();
                sVar4.f12832f = false;
                sVar4.f12829c = 0;
                sVar4.f12828b = 0;
                sVar4.f12830d = false;
                ((LinearLayout.LayoutParams) sVar4).leftMargin = 0;
                ((LinearLayout.LayoutParams) sVar4).rightMargin = 0;
                sVar4.f12831e = z17 && ((ActionMenuItemView) childAt2).f();
                int iN = n(childAt2, i23, sVar4.f12827a ? 1 : i21, childMeasureSpec2, paddingBottom2);
                int iMax3 = Math.max(i25, iN);
                if (sVar4.f12830d) {
                    i28++;
                }
                if (sVar4.f12827a) {
                    z16 = true;
                }
                i21 -= iN;
                int iMax4 = Math.max(i26, childAt2.getMeasuredHeight());
                if (iN == 1) {
                    j10 |= 1 << i27;
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
            int i31 = Reader.READ_DONE;
            long j11 = 0;
            int i32 = 0;
            int i33 = 0;
            while (i32 < childCount3) {
                boolean z20 = z18;
                s sVar5 = (s) getChildAt(i32).getLayoutParams();
                boolean z21 = z19;
                if (sVar5.f12830d) {
                    int i34 = sVar5.f12828b;
                    if (i34 < i31) {
                        i12 = i23;
                        i13 = i32;
                        i31 = i34;
                        j11 = 1 << i32;
                        i33 = 1;
                    } else {
                        i12 = i23;
                        i13 = i32;
                        if (i34 == i31) {
                            j11 |= 1 << i13;
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
            j10 |= j11;
            if (i33 > i21) {
                break;
            }
            int i35 = i31 + 1;
            int i36 = 0;
            while (i36 < childCount3) {
                View childAt3 = getChildAt(i36);
                s sVar6 = (s) childAt3.getLayoutParams();
                int i37 = i26;
                long j12 = 1 << i36;
                if ((j11 & j12) != 0) {
                    if (z22 && sVar6.f12831e) {
                        r11 = 1;
                        r11 = 1;
                        if (i21 == 1) {
                            childAt3.setPadding(i10 + i11, 0, i10, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    sVar6.f12828b += r11;
                    sVar6.f12832f = r11;
                    i21--;
                } else if (sVar6.f12828b == i35) {
                    j10 |= j12;
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
        if (i21 <= 0 || j10 == 0 || (i21 >= i24 - 1 && !z23 && i25 <= 1)) {
            z11 = z10;
        } else {
            float fBitCount = Long.bitCount(j10);
            if (!z23) {
                if ((j10 & 1) != 0 && !((s) getChildAt(0).getLayoutParams()).f12831e) {
                    fBitCount -= 0.5f;
                }
                int i39 = childCount3 - 1;
                if ((j10 & (1 << i39)) != 0 && !((s) getChildAt(i39).getLayoutParams()).f12831e) {
                    fBitCount -= 0.5f;
                }
            }
            int i40 = fBitCount > 0.0f ? (int) ((i21 * i11) / fBitCount) : 0;
            boolean z24 = z10;
            for (int i41 = 0; i41 < childCount3; i41++) {
                if ((j10 & (1 << i41)) != 0) {
                    View childAt4 = getChildAt(i41);
                    s sVar7 = (s) childAt4.getLayoutParams();
                    if (childAt4 instanceof ActionMenuItemView) {
                        sVar7.f12829c = i40;
                        sVar7.f12832f = true;
                        if (i41 == 0 && !sVar7.f12831e) {
                            ((LinearLayout.LayoutParams) sVar7).leftMargin = (-i40) / 2;
                        }
                        z24 = true;
                    } else if (sVar7.f12827a) {
                        sVar7.f12829c = i40;
                        sVar7.f12832f = true;
                        ((LinearLayout.LayoutParams) sVar7).rightMargin = (-i40) / 2;
                        z24 = true;
                    } else {
                        if (i41 != 0) {
                            ((LinearLayout.LayoutParams) sVar7).leftMargin = i40 / 2;
                        }
                        if (i41 != childCount3 - 1) {
                            ((LinearLayout.LayoutParams) sVar7).rightMargin = i40 / 2;
                        }
                    }
                }
            }
            z11 = z24;
        }
        if (z11) {
            for (int i42 = 0; i42 < childCount3; i42++) {
                View childAt5 = getChildAt(i42);
                s sVar8 = (s) childAt5.getLayoutParams();
                if (sVar8.f12832f) {
                    childAt5.measure(View.MeasureSpec.makeMeasureSpec((sVar8.f12828b * i11) + sVar8.f12829c, 1073741824), childMeasureSpec2);
                }
            }
        }
        setMeasuredDimension(i19, mode2 != 1073741824 ? i38 : i30);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f12606x.f12820y = z10;
    }

    public void setHasOverflow(boolean z10) {
        this.F = z10;
    }

    public void setOnMenuItemClickListener(t tVar) {
        this.E = tVar;
    }

    public void setOverflowDrawable(Drawable drawable) {
        q qVar = this.f12606x;
        if (qVar != null) {
            qVar.B = drawable;
            o oVar = qVar.f12808m;
            if (oVar != null) {
                oVar.setImageDrawable(drawable);
            }
        }
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        q qVar = this.f12606x;
        o oVar = qVar.f12808m;
        if (oVar != null) {
            oVar.setImageDrawable(drawable);
        } else {
            qVar.f12811p = true;
            qVar.f12810o = drawable;
        }
    }

    public void setOverflowReserved(boolean z10) {
        this.f12605w = z10;
    }

    public void setPopupTheme(int i) {
        if (this.f12604v != i) {
            this.f12604v = i;
            if (i == 0) {
                this.f12603u = getContext();
            } else {
                this.f12603u = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(q qVar) {
        this.f12606x = qVar;
        qVar.f12807l = this;
        this.f12602t = qVar.f12803g;
    }

    @Override // m.o1, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return l(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }
}
