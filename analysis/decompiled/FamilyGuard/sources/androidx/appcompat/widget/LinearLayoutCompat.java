package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8174a;

    /* renamed from: b, reason: collision with root package name */
    private int f8175b;

    /* renamed from: c, reason: collision with root package name */
    private int f8176c;

    /* renamed from: d, reason: collision with root package name */
    private int f8177d;

    /* renamed from: e, reason: collision with root package name */
    private int f8178e;

    /* renamed from: f, reason: collision with root package name */
    private int f8179f;

    /* renamed from: g, reason: collision with root package name */
    private float f8180g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8181h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f8182i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f8183j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f8184k;

    /* renamed from: l, reason: collision with root package name */
    private int f8185l;

    /* renamed from: m, reason: collision with root package name */
    private int f8186m;

    /* renamed from: n, reason: collision with root package name */
    private int f8187n;

    /* renamed from: o, reason: collision with root package name */
    private int f8188o;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i5, int i6) {
            super(i5, i6);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(View view, int i5, int i6, int i7, int i8) {
        view.layout(i5, i6, i7 + i5, i8 + i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredHeight()
            r1 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3d
            android.view.View r3 = r9.s(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L36
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r1 = (androidx.appcompat.widget.LinearLayoutCompat.a) r1
            int r2 = r1.height
            r4 = -1
            if (r2 != r4) goto L36
            int r8 = r1.width
            int r2 = r3.getMeasuredWidth()
            r1.width = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r4 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.width = r8
            goto L38
        L36:
            r2 = r9
            r4 = r11
        L38:
            int r0 = r0 + 1
            r9 = r2
            r11 = r4
            goto Lb
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.k(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3d
            android.view.View r3 = r9.s(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L36
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$a r1 = (androidx.appcompat.widget.LinearLayoutCompat.a) r1
            int r2 = r1.width
            r5 = -1
            if (r2 != r5) goto L36
            int r8 = r1.height
            int r2 = r3.getMeasuredHeight()
            r1.height = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r6 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.height = r8
            goto L38
        L36:
            r2 = r9
            r6 = r11
        L38:
            int r0 = r0 + 1
            r9 = r2
            r11 = r6
            goto Lb
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.l(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i5;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = h0.b(this);
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            View viewS = s(i6);
            if (viewS != null && viewS.getVisibility() != 8 && t(i6)) {
                a aVar = (a) viewS.getLayoutParams();
                j(canvas, zB ? viewS.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewS.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f8185l);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            if (viewS2 != null) {
                a aVar2 = (a) viewS2.getLayoutParams();
                if (zB) {
                    left = viewS2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i5 = this.f8185l;
                    right = left - i5;
                } else {
                    right = viewS2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i5 = this.f8185l;
                right = left - i5;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i5;
        if (this.f8175b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i6 = this.f8175b;
        if (childCount <= i6) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i6);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f8175b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f8176c;
        if (this.f8177d == 1 && (i5 = this.f8178e & 112) != 48) {
            if (i5 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f8179f) / 2;
            } else if (i5 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f8179f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f8175b;
    }

    public Drawable getDividerDrawable() {
        return this.f8184k;
    }

    public int getDividerPadding() {
        return this.f8188o;
    }

    public int getDividerWidth() {
        return this.f8185l;
    }

    public int getGravity() {
        return this.f8178e;
    }

    public int getOrientation() {
        return this.f8177d;
    }

    public int getShowDividers() {
        return this.f8187n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f8180g;
    }

    void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View viewS = s(i5);
            if (viewS != null && viewS.getVisibility() != 8 && t(i5)) {
                i(canvas, (viewS.getTop() - ((LinearLayout.LayoutParams) ((a) viewS.getLayoutParams())).topMargin) - this.f8186m);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            i(canvas, viewS2 == null ? (getHeight() - getPaddingBottom()) - this.f8186m : viewS2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewS2.getLayoutParams())).bottomMargin);
        }
    }

    void i(Canvas canvas, int i5) {
        this.f8184k.setBounds(getPaddingLeft() + this.f8188o, i5, (getWidth() - getPaddingRight()) - this.f8188o, this.f8186m + i5);
        this.f8184k.draw(canvas);
    }

    void j(Canvas canvas, int i5) {
        this.f8184k.setBounds(i5, getPaddingTop() + this.f8188o, this.f8185l + i5, (getHeight() - getPaddingBottom()) - this.f8188o);
        this.f8184k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i5 = this.f8177d;
        if (i5 == 0) {
            return new a(-2, -2);
        }
        if (i5 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a ? new a((ViewGroup.MarginLayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f8184k == null) {
            return;
        }
        if (this.f8177d == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        if (this.f8177d == 1) {
            v(i5, i6, i7, i8);
        } else {
            u(i5, i6, i7, i8);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        if (this.f8177d == 1) {
            z(i5, i6);
        } else {
            x(i5, i6);
        }
    }

    int p(View view, int i5) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i5) {
        return getChildAt(i5);
    }

    public void setBaselineAligned(boolean z5) {
        this.f8174a = z5;
    }

    public void setBaselineAlignedChildIndex(int i5) {
        if (i5 >= 0 && i5 < getChildCount()) {
            this.f8175b = i5;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f8184k) {
            return;
        }
        this.f8184k = drawable;
        if (drawable != null) {
            this.f8185l = drawable.getIntrinsicWidth();
            this.f8186m = drawable.getIntrinsicHeight();
        } else {
            this.f8185l = 0;
            this.f8186m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i5) {
        this.f8188o = i5;
    }

    public void setGravity(int i5) {
        if (this.f8178e != i5) {
            if ((8388615 & i5) == 0) {
                i5 |= 8388611;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            this.f8178e = i5;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i5) {
        int i6 = i5 & 8388615;
        int i7 = this.f8178e;
        if ((8388615 & i7) != i6) {
            this.f8178e = i6 | ((-8388616) & i7);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z5) {
        this.f8181h = z5;
    }

    public void setOrientation(int i5) {
        if (this.f8177d != i5) {
            this.f8177d = i5;
            requestLayout();
        }
    }

    public void setShowDividers(int i5) {
        if (i5 != this.f8187n) {
            requestLayout();
        }
        this.f8187n = i5;
    }

    public void setVerticalGravity(int i5) {
        int i6 = i5 & 112;
        int i7 = this.f8178e;
        if ((i7 & 112) != i6) {
            this.f8178e = i6 | (i7 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f5) {
        this.f8180g = Math.max(0.0f, f5);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected boolean t(int i5) {
        if (i5 == 0) {
            return (this.f8187n & 1) != 0;
        }
        if (i5 == getChildCount()) {
            return (this.f8187n & 4) != 0;
        }
        if ((this.f8187n & 2) != 0) {
            for (int i6 = i5 - 1; i6 >= 0; i6--) {
                if (getChildAt(i6).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void u(int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.u(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void v(int r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            int r0 = r11.getPaddingLeft()
            int r14 = r14 - r12
            int r12 = r11.getPaddingRight()
            int r12 = r14 - r12
            int r14 = r14 - r0
            int r1 = r11.getPaddingRight()
            int r14 = r14 - r1
            int r1 = r11.getVirtualChildCount()
            int r2 = r11.f8178e
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L35
            r4 = 80
            if (r3 == r4) goto L2a
            int r13 = r11.getPaddingTop()
            goto L41
        L2a:
            int r3 = r11.getPaddingTop()
            int r3 = r3 + r15
            int r3 = r3 - r13
            int r13 = r11.f8179f
            int r13 = r3 - r13
            goto L41
        L35:
            int r3 = r11.getPaddingTop()
            int r15 = r15 - r13
            int r13 = r11.f8179f
            int r15 = r15 - r13
            int r15 = r15 / 2
            int r13 = r3 + r15
        L41:
            r15 = 0
        L42:
            if (r15 >= r1) goto Lba
            android.view.View r4 = r11.s(r15)
            r9 = 1
            if (r4 != 0) goto L52
            int r3 = r11.y(r15)
            int r13 = r13 + r3
        L50:
            r3 = r11
            goto Lb7
        L52:
            int r3 = r4.getVisibility()
            r5 = 8
            if (r3 == r5) goto L50
            int r7 = r4.getMeasuredWidth()
            int r8 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r4.getLayoutParams()
            r10 = r3
            androidx.appcompat.widget.LinearLayoutCompat$a r10 = (androidx.appcompat.widget.LinearLayoutCompat.a) r10
            int r3 = r10.gravity
            if (r3 >= 0) goto L6e
            r3 = r2
        L6e:
            int r5 = r11.getLayoutDirection()
            int r3 = androidx.core.view.C0464i.b(r3, r5)
            r3 = r3 & 7
            if (r3 == r9) goto L88
            r5 = 5
            if (r3 == r5) goto L82
            int r3 = r10.leftMargin
            int r3 = r3 + r0
        L80:
            r5 = r3
            goto L93
        L82:
            int r3 = r12 - r7
            int r5 = r10.rightMargin
        L86:
            int r3 = r3 - r5
            goto L80
        L88:
            int r3 = r14 - r7
            int r3 = r3 / 2
            int r3 = r3 + r0
            int r5 = r10.leftMargin
            int r3 = r3 + r5
            int r5 = r10.rightMargin
            goto L86
        L93:
            boolean r3 = r11.t(r15)
            if (r3 == 0) goto L9c
            int r3 = r11.f8186m
            int r13 = r13 + r3
        L9c:
            int r3 = r10.topMargin
            int r13 = r13 + r3
            int r3 = r11.q(r4)
            int r6 = r13 + r3
            r3 = r11
            r3.A(r4, r5, r6, r7, r8)
            int r11 = r10.bottomMargin
            int r8 = r8 + r11
            int r11 = r3.r(r4)
            int r8 = r8 + r11
            int r13 = r13 + r8
            int r11 = r3.p(r4, r15)
            int r15 = r15 + r11
        Lb7:
            int r15 = r15 + r9
            r11 = r3
            goto L42
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.v(int, int, int, int):void");
    }

    void w(View view, int i5, int i6, int i7, int i8, int i9) {
        measureChildWithMargins(view, i6, i7, i8, i9);
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x0461  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void x(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.x(int, int):void");
    }

    int y(int i5) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void z(int r28, int r29) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.z(int, int):void");
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f8174a = true;
        this.f8175b = -1;
        this.f8176c = 0;
        this.f8178e = 8388659;
        int[] iArr = g.j.f17096a1;
        a0 a0VarV = a0.v(context, attributeSet, iArr, i5, 0);
        androidx.core.view.H.i0(this, context, iArr, attributeSet, a0VarV.r(), i5, 0);
        int iK = a0VarV.k(g.j.f17106c1, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = a0VarV.k(g.j.f17101b1, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = a0VarV.a(g.j.f17111d1, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f8180g = a0VarV.i(g.j.f17121f1, -1.0f);
        this.f8175b = a0VarV.k(g.j.f17116e1, -1);
        this.f8181h = a0VarV.a(g.j.f17136i1, false);
        setDividerDrawable(a0VarV.g(g.j.f17126g1));
        this.f8187n = a0VarV.k(g.j.f17141j1, 0);
        this.f8188o = a0VarV.f(g.j.f17131h1, 0);
        a0VarV.x();
    }
}
