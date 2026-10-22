package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
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
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements e.b, androidx.appcompat.view.menu.k {

    /* renamed from: A, reason: collision with root package name */
    e f8068A;

    /* renamed from: p, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f8069p;

    /* renamed from: q, reason: collision with root package name */
    private Context f8070q;

    /* renamed from: r, reason: collision with root package name */
    private int f8071r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8072s;

    /* renamed from: t, reason: collision with root package name */
    private C0433c f8073t;

    /* renamed from: u, reason: collision with root package name */
    private j.a f8074u;

    /* renamed from: v, reason: collision with root package name */
    e.a f8075v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f8076w;

    /* renamed from: x, reason: collision with root package name */
    private int f8077x;

    /* renamed from: y, reason: collision with root package name */
    private int f8078y;

    /* renamed from: z, reason: collision with root package name */
    private int f8079z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements j.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void d(androidx.appcompat.view.menu.e eVar, boolean z5) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean e(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    public static class c extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f8080a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f8081b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f8082c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f8083d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f8084e;

        /* renamed from: f, reason: collision with root package name */
        boolean f8085f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f8080a = cVar.f8080a;
        }

        public c(int i5, int i6) {
            super(i5, i6);
            this.f8080a = false;
        }
    }

    private class d implements e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.f8068A;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.f8075v;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int L(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r0 = (androidx.appcompat.widget.ActionMenuView.c) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.t()
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
            boolean r7 = r0.f8080a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f8083d = r1
            r0.f8081b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.L(android.view.View, int, int, int, int):int");
    }

    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v48 */
    private void M(int i5, int i6) {
        long j5;
        int i7;
        int i8;
        boolean z5;
        boolean z6;
        ?? r32;
        int i9;
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingTop, -2);
        int i10 = size - paddingLeft;
        int i11 = this.f8078y;
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
        boolean z7 = false;
        int i16 = 0;
        int iMax2 = 0;
        int i17 = 0;
        long j6 = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            int i18 = size2;
            if (childAt.getVisibility() == 8) {
                i9 = i14;
            } else {
                boolean z8 = childAt instanceof ActionMenuItemView;
                i16++;
                if (z8) {
                    int i19 = this.f8079z;
                    z6 = z8;
                    r32 = 0;
                    childAt.setPadding(i19, 0, i19, 0);
                } else {
                    z6 = z8;
                    r32 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f8085f = r32;
                cVar.f8082c = r32;
                cVar.f8081b = r32;
                cVar.f8083d = r32;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r32;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r32;
                cVar.f8084e = z6 && ((ActionMenuItemView) childAt).t();
                int iL = L(childAt, i14, cVar.f8080a ? 1 : i12, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iL);
                i9 = i14;
                if (cVar.f8083d) {
                    i17++;
                }
                if (cVar.f8080a) {
                    z7 = true;
                }
                i12 -= iL;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iL == 1) {
                    j6 |= 1 << i15;
                }
            }
            i15++;
            size2 = i18;
            i14 = i9;
        }
        int i20 = size2;
        int i21 = i14;
        char c6 = 2;
        boolean z9 = z7 && i16 == 2;
        boolean z10 = false;
        while (i17 > 0 && i12 > 0) {
            int i22 = Integer.MAX_VALUE;
            long j7 = 0;
            char c7 = c6;
            int i23 = 0;
            int i24 = 0;
            j5 = 1;
            while (i24 < childCount) {
                c cVar2 = (c) getChildAt(i24).getLayoutParams();
                boolean z11 = z9;
                if (cVar2.f8083d) {
                    int i25 = cVar2.f8081b;
                    if (i25 < i22) {
                        j7 = 1 << i24;
                        i22 = i25;
                        i23 = 1;
                    } else if (i25 == i22) {
                        j7 |= 1 << i24;
                        i23++;
                    }
                }
                i24++;
                z9 = z11;
            }
            boolean z12 = z9;
            j6 |= j7;
            if (i23 > i12) {
                break;
            }
            int i26 = i22 + 1;
            int i27 = 0;
            while (i27 < childCount) {
                View childAt2 = getChildAt(i27);
                c cVar3 = (c) childAt2.getLayoutParams();
                long j8 = 1 << i27;
                if ((j7 & j8) == 0) {
                    if (cVar3.f8081b == i26) {
                        j6 |= j8;
                    }
                    i8 = i27;
                } else {
                    if (!z12 || !cVar3.f8084e) {
                        i8 = i27;
                        z5 = true;
                    } else if (i12 == 1) {
                        int i28 = this.f8079z;
                        z5 = true;
                        i8 = i27;
                        childAt2.setPadding(i28 + i21, 0, i28, 0);
                    } else {
                        i8 = i27;
                        z5 = true;
                    }
                    cVar3.f8081b++;
                    cVar3.f8085f = z5;
                    i12--;
                }
                i27 = i8 + 1;
            }
            c6 = c7;
            z9 = z12;
            z10 = true;
        }
        j5 = 1;
        boolean z13 = !z7 && i16 == 1;
        if (i12 <= 0 || j6 == 0 || (i12 >= i16 - 1 && !z13 && iMax2 <= 1)) {
            i7 = 0;
        } else {
            float fBitCount = Long.bitCount(j6);
            if (z13) {
                i7 = 0;
            } else {
                if ((j6 & j5) != 0) {
                    i7 = 0;
                    if (!((c) getChildAt(0).getLayoutParams()).f8084e) {
                        fBitCount -= 0.5f;
                    }
                } else {
                    i7 = 0;
                }
                int i29 = childCount - 1;
                if ((j6 & (1 << i29)) != 0 && !((c) getChildAt(i29).getLayoutParams()).f8084e) {
                    fBitCount -= 0.5f;
                }
            }
            int i30 = fBitCount > 0.0f ? (int) ((i12 * i21) / fBitCount) : i7;
            boolean z14 = z10;
            for (int i31 = i7; i31 < childCount; i31++) {
                if ((j6 & (1 << i31)) != 0) {
                    View childAt3 = getChildAt(i31);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f8082c = i30;
                        cVar4.f8085f = true;
                        if (i31 == 0 && !cVar4.f8084e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i30) / 2;
                        }
                        z14 = true;
                    } else if (cVar4.f8080a) {
                        cVar4.f8082c = i30;
                        cVar4.f8085f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i30) / 2;
                        z14 = true;
                    } else {
                        if (i31 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i30 / 2;
                        }
                        if (i31 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i30 / 2;
                        }
                    }
                }
            }
            z10 = z14;
        }
        if (z10) {
            for (int i32 = i7; i32 < childCount; i32++) {
                View childAt4 = getChildAt(i32);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f8085f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f8081b * i21) + cVar5.f8082c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i10, mode != 1073741824 ? iMax : i20);
    }

    public void B() {
        C0433c c0433c = this.f8073t;
        if (c0433c != null) {
            c0433c.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public c F() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f8080a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    protected boolean G(int i5) {
        boolean zA = false;
        if (i5 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i5 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i5);
        if (i5 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i5 <= 0 || !(childAt2 instanceof a)) ? zA : ((a) childAt2).b() | zA;
    }

    public boolean H() {
        C0433c c0433c = this.f8073t;
        return c0433c != null && c0433c.B();
    }

    public boolean I() {
        C0433c c0433c = this.f8073t;
        return c0433c != null && c0433c.D();
    }

    public boolean J() {
        C0433c c0433c = this.f8073t;
        return c0433c != null && c0433c.E();
    }

    public boolean K() {
        return this.f8072s;
    }

    public androidx.appcompat.view.menu.e N() {
        return this.f8069p;
    }

    public void O(j.a aVar, e.a aVar2) {
        this.f8074u = aVar;
        this.f8075v = aVar2;
    }

    public boolean P() {
        C0433c c0433c = this.f8073t;
        return c0433c != null && c0433c.K();
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(androidx.appcompat.view.menu.g gVar) {
        return this.f8069p.M(gVar, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void e(androidx.appcompat.view.menu.e eVar) {
        this.f8069p = eVar;
    }

    public Menu getMenu() {
        if (this.f8069p == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.f8069p = eVar;
            eVar.S(new d());
            C0433c c0433c = new C0433c(context);
            this.f8073t = c0433c;
            c0433c.J(true);
            C0433c c0433c2 = this.f8073t;
            j.a bVar = this.f8074u;
            if (bVar == null) {
                bVar = new b();
            }
            c0433c2.g(bVar);
            this.f8069p.c(this.f8073t, this.f8070q);
            this.f8073t.H(this);
        }
        return this.f8069p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f8073t.A();
    }

    public int getPopupTheme() {
        return this.f8071r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0433c c0433c = this.f8073t;
        if (c0433c != null) {
            c0433c.b(false);
            if (this.f8073t.E()) {
                this.f8073t.B();
                this.f8073t.K();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int width;
        int paddingLeft;
        if (!this.f8076w) {
            super.onLayout(z5, i5, i6, i7, i8);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i8 - i6) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i7 - i5;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean zB = h0.b(this);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f8080a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i14 = i9 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i14, width, measuredHeight + i14);
                    paddingRight -= measuredWidth;
                    i11 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    G(i13);
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
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt3 = getChildAt(i18);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f8080a) {
                    int i19 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width2 = i19 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt4 = getChildAt(i21);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f8080a) {
                int i22 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft2 = i22 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i5, int i6) {
        androidx.appcompat.view.menu.e eVar;
        boolean z5 = this.f8076w;
        boolean z6 = View.MeasureSpec.getMode(i5) == 1073741824;
        this.f8076w = z6;
        if (z5 != z6) {
            this.f8077x = 0;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (this.f8076w && (eVar = this.f8069p) != null && size != this.f8077x) {
            this.f8077x = size;
            eVar.L(true);
        }
        int childCount = getChildCount();
        if (this.f8076w && childCount > 0) {
            M(i5, i6);
            return;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            c cVar = (c) getChildAt(i7).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i5, i6);
    }

    public void setExpandedActionViewsExclusive(boolean z5) {
        this.f8073t.G(z5);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f8068A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f8073t.I(drawable);
    }

    public void setOverflowReserved(boolean z5) {
        this.f8072s = z5;
    }

    public void setPopupTheme(int i5) {
        if (this.f8071r != i5) {
            this.f8071r = i5;
            if (i5 == 0) {
                this.f8070q = getContext();
            } else {
                this.f8070q = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setPresenter(C0433c c0433c) {
        this.f8073t = c0433c;
        c0433c.H(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.f8078y = (int) (56.0f * f5);
        this.f8079z = (int) (f5 * 4.0f);
        this.f8070q = context;
        this.f8071r = 0;
    }
}
