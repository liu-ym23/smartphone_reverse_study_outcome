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
import stepos.support.v7.view.menu.ActionMenuItemView;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.h;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements d.b, stepos.support.v7.view.menu.i {

    /* renamed from: A, reason: collision with root package name */
    private f f21535A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f21536B;

    /* renamed from: p, reason: collision with root package name */
    private stepos.support.v7.view.menu.d f21537p;

    /* renamed from: q, reason: collision with root package name */
    private Context f21538q;

    /* renamed from: r, reason: collision with root package name */
    private int f21539r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f21540s;

    /* renamed from: t, reason: collision with root package name */
    private stepos.support.v7.widget.d f21541t;

    /* renamed from: u, reason: collision with root package name */
    private h.a f21542u;

    /* renamed from: v, reason: collision with root package name */
    private d.a f21543v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f21544w;

    /* renamed from: x, reason: collision with root package name */
    private int f21545x;

    /* renamed from: y, reason: collision with root package name */
    private int f21546y;

    /* renamed from: z, reason: collision with root package name */
    private int f21547z;

    public interface b {
        boolean a();

        boolean b();
    }

    private class c implements h.a {
        private c() {
        }

        @Override // stepos.support.v7.view.menu.h.a
        public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
        }

        @Override // stepos.support.v7.view.menu.h.a
        public boolean b(stepos.support.v7.view.menu.d dVar) {
            return false;
        }
    }

    public static class d extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f21549a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f21550b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f21551c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f21552d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f21553e;

        /* renamed from: f, reason: collision with root package name */
        boolean f21554f;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public d(d dVar) {
            super((ViewGroup.LayoutParams) dVar);
            this.f21549a = dVar.f21549a;
        }

        public d(int i5, int i6) {
            super(i5, i6);
            this.f21549a = false;
        }
    }

    private class e implements d.a {
        private e() {
        }

        @Override // stepos.support.v7.view.menu.d.a
        public boolean c(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
            return ActionMenuView.this.f21535A != null && ActionMenuView.this.f21535A.onMenuItemClick(menuItem);
        }

        @Override // stepos.support.v7.view.menu.d.a
        public void d(stepos.support.v7.view.menu.d dVar) {
            if (ActionMenuView.this.f21543v != null) {
                ActionMenuView.this.f21543v.d(dVar);
            }
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    private void D(d dVar, int i5, int i6) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(X4.d.f5926z);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(X4.d.f5922v);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(X4.d.f5924x);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(X4.d.f5923w);
        if (dVar.f21549a) {
            dVar.setMarginEnd(dimensionPixelSize);
            dVar.resolveLayoutDirection(getLayoutDirection());
            return;
        }
        boolean z5 = this.f21536B;
        if (z5 && i5 == i6 - 2) {
            dimensionPixelSize2 = dimensionPixelSize3;
        } else if (z5 || i5 != i6 - 1) {
            dimensionPixelSize2 = dimensionPixelSize4;
        }
        dVar.setMarginEnd(dimensionPixelSize2);
        dVar.resolveLayoutDirection(getLayoutDirection());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int O(android.view.View r5, int r6, int r7, int r8, int r9) {
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
            boolean r9 = r9.w()
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
            boolean r7 = r0.f21549a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f21552d = r1
            r0.f21550b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionMenuView.O(android.view.View, int, int, int, int):int");
    }

    static int P(View view, int i5, int i6, int i7) {
        d dVar = (d) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6) - i7, View.MeasureSpec.getMode(i6));
        dVar.f21550b = 1;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), iMakeMeasureSpec);
        return 1;
    }

    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    private void R(int i5, int i6) {
        boolean z5;
        int i7;
        int i8;
        boolean z6;
        boolean z7;
        boolean z8;
        ?? r32;
        int i9;
        if (this.f21541t.Q()) {
            S(i5, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingTop, -2);
        int i10 = size - paddingLeft;
        int i11 = this.f21546y;
        int i12 = i10 / i11;
        int i13 = i10 % i11;
        if (i12 == 0) {
            setMeasuredDimension(i10, 0);
            return;
        }
        int i14 = i11 + (i13 / i12);
        int childCount = getChildCount();
        int iMax = 0;
        int i15 = 0;
        boolean z9 = false;
        int i16 = 0;
        int iMax2 = 0;
        int i17 = 0;
        long j5 = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            int i18 = size2;
            if (childAt.getVisibility() == 8) {
                i9 = i14;
            } else {
                boolean z10 = childAt instanceof ActionMenuItemView;
                i16++;
                if (z10) {
                    int i19 = this.f21547z;
                    z8 = z10;
                    r32 = 0;
                    childAt.setPadding(i19, 0, i19, 0);
                } else {
                    z8 = z10;
                    r32 = 0;
                }
                d dVar = (d) childAt.getLayoutParams();
                dVar.f21554f = r32;
                dVar.f21551c = r32;
                dVar.f21550b = r32;
                dVar.f21552d = r32;
                ((LinearLayout.LayoutParams) dVar).leftMargin = r32;
                ((LinearLayout.LayoutParams) dVar).rightMargin = r32;
                dVar.f21553e = z8 && ((ActionMenuItemView) childAt).w();
                int iO = O(childAt, i14, dVar.f21549a ? 1 : i12, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iO);
                i9 = i14;
                if (dVar.f21552d) {
                    i17++;
                }
                if (dVar.f21549a) {
                    z9 = true;
                }
                i12 -= iO;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iO == 1) {
                    j5 |= 1 << i15;
                }
            }
            i15++;
            size2 = i18;
            i14 = i9;
        }
        int i20 = size2;
        int i21 = i14;
        char c6 = 2;
        boolean z11 = z9 && i16 == 2;
        boolean z12 = false;
        while (i17 > 0 && i12 > 0) {
            int i22 = Integer.MAX_VALUE;
            long j6 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i24 < childCount) {
                char c7 = c6;
                d dVar2 = (d) getChildAt(i24).getLayoutParams();
                boolean z13 = z11;
                if (dVar2.f21552d) {
                    int i25 = dVar2.f21550b;
                    if (i25 < i22) {
                        z7 = z12;
                        i22 = i25;
                        j6 = 1 << i24;
                        i23 = 1;
                    } else {
                        z7 = z12;
                        if (i25 == i22) {
                            j6 |= 1 << i24;
                            i23++;
                        }
                    }
                } else {
                    z7 = z12;
                }
                i24++;
                z11 = z13;
                c6 = c7;
                z12 = z7;
            }
            char c8 = c6;
            boolean z14 = z11;
            z5 = z12;
            j5 |= j6;
            if (i23 > i12) {
                break;
            }
            int i26 = i22 + 1;
            int i27 = 0;
            while (i27 < childCount) {
                View childAt2 = getChildAt(i27);
                d dVar3 = (d) childAt2.getLayoutParams();
                long j7 = 1 << i27;
                if ((j6 & j7) == 0) {
                    if (dVar3.f21550b == i26) {
                        j5 |= j7;
                    }
                    i8 = i27;
                } else {
                    if (!z14 || !dVar3.f21553e) {
                        i8 = i27;
                        z6 = true;
                    } else if (i12 == 1) {
                        int i28 = this.f21547z;
                        z6 = true;
                        i8 = i27;
                        childAt2.setPadding(i28 + i21, 0, i28, 0);
                    } else {
                        i8 = i27;
                        z6 = true;
                    }
                    dVar3.f21550b++;
                    dVar3.f21554f = z6;
                    i12--;
                }
                i27 = i8 + 1;
            }
            z11 = z14;
            c6 = c8;
            z12 = true;
        }
        z5 = z12;
        boolean z15 = !z9 && i16 == 1;
        if (i12 <= 0 || j5 == 0 || (i12 >= i16 - 1 && !z15 && iMax2 <= 1)) {
            i7 = 0;
        } else {
            float fBitCount = Long.bitCount(j5);
            if (z15) {
                i7 = 0;
            } else {
                if ((j5 & 1) != 0) {
                    i7 = 0;
                    if (!((d) getChildAt(0).getLayoutParams()).f21553e) {
                        fBitCount -= 0.5f;
                    }
                } else {
                    i7 = 0;
                }
                int i29 = childCount - 1;
                if ((j5 & (1 << i29)) != 0 && !((d) getChildAt(i29).getLayoutParams()).f21553e) {
                    fBitCount -= 0.5f;
                }
            }
            int i30 = fBitCount > 0.0f ? (int) ((i12 * i21) / fBitCount) : i7;
            for (int i31 = i7; i31 < childCount; i31++) {
                if ((j5 & (1 << i31)) != 0) {
                    View childAt3 = getChildAt(i31);
                    d dVar4 = (d) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        dVar4.f21551c = i30;
                        dVar4.f21554f = true;
                        if (i31 == 0 && !dVar4.f21553e) {
                            ((LinearLayout.LayoutParams) dVar4).leftMargin = (-i30) / 2;
                        }
                        z5 = true;
                    } else if (dVar4.f21549a) {
                        dVar4.f21551c = i30;
                        dVar4.f21554f = true;
                        ((LinearLayout.LayoutParams) dVar4).rightMargin = (-i30) / 2;
                        z5 = true;
                    } else {
                        if (i31 != 0) {
                            ((LinearLayout.LayoutParams) dVar4).leftMargin = i30 / 2;
                        }
                        if (i31 != childCount - 1) {
                            ((LinearLayout.LayoutParams) dVar4).rightMargin = i30 / 2;
                        }
                    }
                }
            }
        }
        if (z5) {
            for (int i32 = i7; i32 < childCount; i32++) {
                View childAt4 = getChildAt(i32);
                d dVar5 = (d) childAt4.getLayoutParams();
                if (dVar5.f21554f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((dVar5.f21550b * i21) + dVar5.f21551c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i10, mode != 1073741824 ? iMax : i20);
    }

    private void S(int i5, int i6) {
        int extraPadding = getExtraPadding();
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingLeft = getPaddingLeft() + getPaddingRight() + (extraPadding * 2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingTop, -2);
        int i7 = size - paddingLeft;
        int childCount = getChildCount();
        if (childCount == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i8 = i7 / childCount;
        int iMax = 0;
        int iMax2 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                d dVar = (d) childAt.getLayoutParams();
                dVar.f21554f = false;
                dVar.f21551c = 0;
                dVar.f21550b = 0;
                dVar.f21552d = false;
                ((LinearLayout.LayoutParams) dVar).leftMargin = 0;
                ((LinearLayout.LayoutParams) dVar).rightMargin = 0;
                dVar.f21553e = z5 && ((ActionMenuItemView) childAt).w();
                iMax2 = Math.max(iMax2, P(childAt, i8, childMeasureSpec, paddingTop));
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
            }
        }
        if (mode != 1073741824) {
            size2 = iMax;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i5), size2);
    }

    private int getExtraPadding() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if ((getChildAt(i5) instanceof ActionMenuItemView) && ((ActionMenuItemView) getChildAt(i5)).getItemData().getIcon() != null) {
                return b5.a.b(getContext()).f();
            }
        }
        return 0;
    }

    public void E() {
        stepos.support.v7.widget.d dVar = this.f21541t;
        if (dVar != null) {
            dVar.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public d generateDefaultLayoutParams() {
        d dVar = new d(-2, -2);
        ((LinearLayout.LayoutParams) dVar).gravity = 16;
        return dVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
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

    public d I() {
        d dVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        dVarGenerateDefaultLayoutParams.f21549a = true;
        return dVarGenerateDefaultLayoutParams;
    }

    protected boolean J(int i5) {
        boolean zA = false;
        if (i5 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i5 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i5);
        if (i5 < getChildCount() && (childAt instanceof b)) {
            zA = ((b) childAt).a();
        }
        return (i5 <= 0 || !(childAt2 instanceof b)) ? zA : ((b) childAt2).b() | zA;
    }

    public boolean K() {
        stepos.support.v7.widget.d dVar = this.f21541t;
        return dVar != null && dVar.M();
    }

    public boolean L() {
        stepos.support.v7.widget.d dVar = this.f21541t;
        return dVar != null && dVar.O();
    }

    public boolean M() {
        stepos.support.v7.widget.d dVar = this.f21541t;
        return dVar != null && dVar.P();
    }

    public boolean N() {
        return this.f21540s;
    }

    protected void Q(int i5, int i6, int i7, int i8) {
        int width;
        int paddingLeft;
        int extraPadding = getExtraPadding();
        int childCount = getChildCount();
        int i9 = (i8 - i6) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i7 - i5;
        int paddingRight = ((i10 - getPaddingRight()) - getPaddingLeft()) - (extraPadding * 2);
        boolean zM = C.m(this);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.f21549a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (J(i13)) {
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
                    int i14 = i9 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i14, width, measuredHeight + i14);
                    paddingRight -= measuredWidth;
                    i11 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) dVar).leftMargin) + ((LinearLayout.LayoutParams) dVar).rightMargin;
                    J(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i10 / 2) - (measuredWidth2 / 2);
            int i16 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        int iMax = Math.max(0, i17 > 0 ? paddingRight / i17 : 0);
        if (zM) {
            int width2 = (getWidth() - getPaddingRight()) - extraPadding;
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt3 = getChildAt(i18);
                d dVar2 = (d) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !dVar2.f21549a) {
                    int i19 = width2 - ((LinearLayout.LayoutParams) dVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width2 = i19 - ((measuredWidth3 + ((LinearLayout.LayoutParams) dVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft() + extraPadding;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt4 = getChildAt(i21);
            d dVar3 = (d) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !dVar3.f21549a) {
                int i22 = paddingLeft2 + ((LinearLayout.LayoutParams) dVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft2 = i22 + measuredWidth4 + ((LinearLayout.LayoutParams) dVar3).rightMargin + iMax;
            }
        }
    }

    public stepos.support.v7.view.menu.d T() {
        return this.f21537p;
    }

    public void U(h.a aVar, d.a aVar2) {
        this.f21542u = aVar;
        this.f21543v = aVar2;
    }

    public boolean V() {
        stepos.support.v7.widget.d dVar = this.f21541t;
        return dVar != null && dVar.a0();
    }

    @Override // stepos.support.v7.view.menu.i
    public void b(stepos.support.v7.view.menu.d dVar) {
        this.f21537p = dVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof d);
    }

    @Override // stepos.support.v7.view.menu.d.b
    public boolean d(stepos.support.v7.view.menu.f fVar) {
        return this.f21537p.K(fVar, 0);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f21537p == null) {
            Context context = getContext();
            stepos.support.v7.view.menu.d dVar = new stepos.support.v7.view.menu.d(context);
            this.f21537p = dVar;
            dVar.Q(new e());
            stepos.support.v7.widget.d dVar2 = new stepos.support.v7.widget.d(context);
            this.f21541t = dVar2;
            dVar2.Y(true);
            stepos.support.v7.widget.d dVar3 = this.f21541t;
            h.a cVar = this.f21542u;
            if (cVar == null) {
                cVar = new c();
            }
            dVar3.o(cVar);
            this.f21537p.c(this.f21541t, this.f21538q);
            this.f21541t.V(this);
        }
        return this.f21537p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f21541t.L();
    }

    public int getPopupTheme() {
        return this.f21539r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        stepos.support.v7.widget.d dVar = this.f21541t;
        if (dVar != null) {
            dVar.b(false);
            if (this.f21541t.P()) {
                this.f21541t.M();
                this.f21541t.a0();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        E();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int width;
        int paddingLeft;
        if (!this.f21544w) {
            super.onLayout(z5, i5, i6, i7, i8);
            return;
        }
        if (this.f21541t.Q()) {
            Q(i5, i6, i7, i8);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i8 - i6) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i7 - i5;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean zM = C.m(this);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.f21549a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (J(i13)) {
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
                    int i14 = i9 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i14, width, measuredHeight + i14);
                    paddingRight -= measuredWidth;
                    i11 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) dVar).leftMargin) + ((LinearLayout.LayoutParams) dVar).rightMargin;
                    J(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i10 / 2) - (measuredWidth2 / 2);
            int i16 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        int iMax = Math.max(0, i17 > 0 ? paddingRight / i17 : 0);
        if (zM) {
            int width2 = getWidth() - getPaddingRight();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt3 = getChildAt(i18);
                d dVar2 = (d) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !dVar2.f21549a) {
                    int i19 = width2 - ((LinearLayout.LayoutParams) dVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width2 = i19 - ((measuredWidth3 + ((LinearLayout.LayoutParams) dVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt4 = getChildAt(i21);
            d dVar3 = (d) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !dVar3.f21549a) {
                int i22 = paddingLeft2 + ((LinearLayout.LayoutParams) dVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft2 = i22 + measuredWidth4 + ((LinearLayout.LayoutParams) dVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i5, int i6) throws Resources.NotFoundException {
        stepos.support.v7.view.menu.d dVar;
        boolean z5 = this.f21544w;
        boolean z6 = View.MeasureSpec.getMode(i5) == 1073741824;
        this.f21544w = z6;
        if (z5 != z6) {
            this.f21545x = 0;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (this.f21544w && (dVar = this.f21537p) != null && size != this.f21545x) {
            this.f21545x = size;
            dVar.J(true);
        }
        int childCount = getChildCount();
        if (this.f21544w && childCount > 0) {
            R(i5, i6);
            return;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            d dVar2 = (d) getChildAt(i7).getLayoutParams();
            ((LinearLayout.LayoutParams) dVar2).rightMargin = 0;
            ((LinearLayout.LayoutParams) dVar2).leftMargin = 0;
            D(dVar2, i7, childCount);
        }
        super.onMeasure(i5, i6);
    }

    public void setExpandedActionViewsExclusive(boolean z5) {
        this.f21541t.S(z5);
    }

    public void setHasOverflow(boolean z5) {
        this.f21536B = z5;
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.f21535A = fVar;
    }

    public void setOverflowDrawable(Drawable drawable) {
        stepos.support.v7.widget.d dVar = this.f21541t;
        if (dVar != null) {
            dVar.W(drawable);
        }
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f21541t.X(drawable);
    }

    public void setOverflowReserved(boolean z5) {
        this.f21540s = z5;
    }

    public void setPopupTheme(int i5) {
        if (this.f21539r != i5) {
            this.f21539r = i5;
            if (i5 == 0) {
                this.f21538q = getContext();
            } else {
                this.f21538q = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setPresenter(stepos.support.v7.widget.d dVar) {
        this.f21541t = dVar;
        dVar.V(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.f21546y = (int) (56.0f * f5);
        this.f21547z = (int) (f5 * 4.0f);
        this.f21538q = context;
        this.f21539r = 0;
        setMotionEventSplittingEnabled(false);
    }
}
