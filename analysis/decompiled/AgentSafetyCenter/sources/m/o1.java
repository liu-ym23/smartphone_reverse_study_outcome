package m;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o1 extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public boolean f8027c;

    /* renamed from: f, reason: collision with root package name */
    public int f8028f;

    /* renamed from: g, reason: collision with root package name */
    public int f8029g;

    /* renamed from: h, reason: collision with root package name */
    public int f8030h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f8031j;

    /* renamed from: k, reason: collision with root package name */
    public float f8032k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8033l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f8034m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f8035n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f8036o;

    /* renamed from: p, reason: collision with root package name */
    public int f8037p;

    /* renamed from: q, reason: collision with root package name */
    public int f8038q;

    /* renamed from: r, reason: collision with root package name */
    public int f8039r;

    /* renamed from: s, reason: collision with root package name */
    public int f8040s;

    public o1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8027c = true;
        this.f8028f = -1;
        this.f8029g = 0;
        this.i = 8388659;
        int[] iArr = g.a.f4110n;
        p5.m mVarJ = p5.m.J(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.i0.b(this, context, iArr, attributeSet, typedArray, i, 0);
        TypedArray typedArray2 = (TypedArray) mVarJ.f9742g;
        int i3 = typedArray2.getInt(1, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i10 = typedArray2.getInt(0, -1);
        if (i10 >= 0) {
            setGravity(i10);
        }
        boolean z10 = typedArray2.getBoolean(2, true);
        if (!z10) {
            setBaselineAligned(z10);
        }
        this.f8032k = typedArray2.getFloat(4, -1.0f);
        this.f8028f = typedArray2.getInt(3, -1);
        this.f8033l = typedArray2.getBoolean(7, false);
        setDividerDrawable(mVarJ.A(5));
        this.f8039r = typedArray2.getInt(8, 0);
        this.f8040s = typedArray2.getDimensionPixelSize(6, 0);
        mVarJ.M();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof n1;
    }

    public final void e(Canvas canvas, int i) {
        this.f8036o.setBounds(getPaddingLeft() + this.f8040s, i, (getWidth() - getPaddingRight()) - this.f8040s, this.f8038q + i);
        this.f8036o.draw(canvas);
    }

    public final void f(Canvas canvas, int i) {
        this.f8036o.setBounds(i, getPaddingTop() + this.f8040s, this.f8037p + i, (getHeight() - getPaddingBottom()) - this.f8040s);
        this.f8036o.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public n1 generateDefaultLayoutParams() {
        int i = this.f8030h;
        if (i == 0) {
            return new n1(-2, -2);
        }
        if (i == 1) {
            return new n1(-1, -2);
        }
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f8028f < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f8028f;
        if (childCount <= i3) {
            od.f.o("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
            return 0;
        }
        View childAt = getChildAt(i3);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f8028f == 0) {
                return -1;
            }
            od.f.o("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            return 0;
        }
        int bottom = this.f8029g;
        if (this.f8030h == 1 && (i = this.i & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f8031j) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f8031j;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((n1) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f8028f;
    }

    public Drawable getDividerDrawable() {
        return this.f8036o;
    }

    public int getDividerPadding() {
        return this.f8040s;
    }

    public int getDividerWidth() {
        return this.f8037p;
    }

    public int getGravity() {
        return this.i;
    }

    public int getOrientation() {
        return this.f8030h;
    }

    public int getShowDividers() {
        return this.f8039r;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f8032k;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public n1 generateLayoutParams(AttributeSet attributeSet) {
        return new n1(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public n1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof n1 ? new n1((n1) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new n1((ViewGroup.MarginLayoutParams) layoutParams) : new n1(layoutParams);
    }

    public final boolean j(int i) {
        if (i == 0) {
            return (this.f8039r & 1) != 0;
        }
        int childCount = getChildCount();
        int i3 = this.f8039r;
        if (i == childCount) {
            return (i3 & 4) != 0;
        }
        if ((i3 & 2) != 0) {
            for (int i10 = i - 1; i10 >= 0; i10--) {
                if (getChildAt(i10).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        if (this.f8036o == null) {
            return;
        }
        int i3 = 0;
        if (this.f8030h == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i3 < virtualChildCount) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8 && j(i3)) {
                    e(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((n1) childAt.getLayoutParams())).topMargin) - this.f8038q);
                }
                i3++;
            }
            if (j(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                e(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f8038q : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((n1) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z10 = getLayoutDirection() == 1;
        while (i3 < virtualChildCount2) {
            View childAt3 = getChildAt(i3);
            if (childAt3 != null && childAt3.getVisibility() != 8 && j(i3)) {
                n1 n1Var = (n1) childAt3.getLayoutParams();
                f(canvas, z10 ? childAt3.getRight() + ((LinearLayout.LayoutParams) n1Var).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) n1Var).leftMargin) - this.f8037p);
            }
            i3++;
        }
        if (j(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                n1 n1Var2 = (n1) childAt4.getLayoutParams();
                if (z10) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) n1Var2).leftMargin;
                    i = this.f8037p;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) n1Var2).rightMargin;
                }
            } else if (z10) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.f8037p;
                right = left - i;
            }
            f(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a7  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.o1.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:229:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0146  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2139
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.o1.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z10) {
        this.f8027c = z10;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f8028f = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f8036o) {
            return;
        }
        this.f8036o = drawable;
        if (drawable != null) {
            this.f8037p = drawable.getIntrinsicWidth();
            this.f8038q = drawable.getIntrinsicHeight();
        } else {
            this.f8037p = 0;
            this.f8038q = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f8040s = i;
    }

    public void setGravity(int i) {
        if (this.i != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.i = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i3 = i & 8388615;
        int i10 = this.i;
        if ((8388615 & i10) != i3) {
            this.i = i3 | ((-8388616) & i10);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f8033l = z10;
    }

    public void setOrientation(int i) {
        if (this.f8030h != i) {
            this.f8030h = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f8039r) {
            requestLayout();
        }
        this.f8039r = i;
    }

    public void setVerticalGravity(int i) {
        int i3 = i & 112;
        int i10 = this.i;
        if ((i10 & 112) != i3) {
            this.i = i3 | (i10 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f5) {
        this.f8032k = Math.max(0.0f, f5);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
