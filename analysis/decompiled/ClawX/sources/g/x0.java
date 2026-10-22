package g;

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

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class x0 extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2854a;

    /* renamed from: b, reason: collision with root package name */
    public int f2855b;

    /* renamed from: c, reason: collision with root package name */
    public int f2856c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f2857e;

    /* renamed from: f, reason: collision with root package name */
    public int f2858f;

    /* renamed from: g, reason: collision with root package name */
    public float f2859g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2860h;

    /* renamed from: j, reason: collision with root package name */
    public int[] f2861j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f2862k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f2863l;

    /* renamed from: m, reason: collision with root package name */
    public int f2864m;

    /* renamed from: n, reason: collision with root package name */
    public int f2865n;

    /* renamed from: o, reason: collision with root package name */
    public int f2866o;

    /* renamed from: p, reason: collision with root package name */
    public int f2867p;

    public x0(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, 0);
        this.f2854a = true;
        this.f2855b = -1;
        this.f2856c = 0;
        this.f2857e = 8388659;
        int[] iArr = c.a.f1023k;
        a4.d dVarE = a4.d.E(context, attributeSet, iArr, 0);
        TypedArray typedArray = (TypedArray) dVarE.f97c;
        int[] iArr2 = e0.a0.f2285a;
        e0.y.b(this, context, iArr, attributeSet, typedArray, 0, 0);
        TypedArray typedArray2 = (TypedArray) dVarE.f97c;
        int i9 = typedArray2.getInt(1, -1);
        if (i9 >= 0) {
            setOrientation(i9);
        }
        int i10 = typedArray2.getInt(0, -1);
        if (i10 >= 0) {
            setGravity(i10);
        }
        boolean z = typedArray2.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f2859g = typedArray2.getFloat(4, -1.0f);
        this.f2855b = typedArray2.getInt(3, -1);
        this.f2860h = typedArray2.getBoolean(7, false);
        setDividerDrawable(dVarE.t(5));
        this.f2866o = typedArray2.getInt(8, 0);
        this.f2867p = typedArray2.getDimensionPixelSize(6, 0);
        dVarE.H();
    }

    public final void c(Canvas canvas, int i8) {
        this.f2863l.setBounds(getPaddingLeft() + this.f2867p, i8, (getWidth() - getPaddingRight()) - this.f2867p, this.f2865n + i8);
        this.f2863l.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof w0;
    }

    public final void d(Canvas canvas, int i8) {
        this.f2863l.setBounds(i8, getPaddingTop() + this.f2867p, this.f2864m + i8, (getHeight() - getPaddingBottom()) - this.f2867p);
        this.f2863l.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public w0 generateDefaultLayoutParams() {
        int i8 = this.d;
        if (i8 == 0) {
            return new w0(-2, -2);
        }
        if (i8 == 1) {
            return new w0(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public w0 generateLayoutParams(AttributeSet attributeSet) {
        return new w0(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public w0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof w0 ? new w0((w0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new w0((ViewGroup.MarginLayoutParams) layoutParams) : new w0(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i8;
        if (this.f2855b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i9 = this.f2855b;
        if (childCount <= i9) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i9);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f2855b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f2856c;
        if (this.d == 1 && (i8 = this.f2857e & 112) != 48) {
            if (i8 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2858f) / 2;
            } else if (i8 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2858f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((w0) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2855b;
    }

    public Drawable getDividerDrawable() {
        return this.f2863l;
    }

    public int getDividerPadding() {
        return this.f2867p;
    }

    public int getDividerWidth() {
        return this.f2864m;
    }

    public int getGravity() {
        return this.f2857e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.f2866o;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2859g;
    }

    public final boolean h(int i8) {
        if (i8 == 0) {
            return (this.f2866o & 1) != 0;
        }
        if (i8 == getChildCount()) {
            return (this.f2866o & 4) != 0;
        }
        if ((this.f2866o & 2) != 0) {
            for (int i9 = i8 - 1; i9 >= 0; i9--) {
                if (getChildAt(i9).getVisibility() != 8) {
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
        int i8;
        if (this.f2863l == null) {
            return;
        }
        int i9 = 0;
        if (this.d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i9 < virtualChildCount) {
                View childAt = getChildAt(i9);
                if (childAt != null && childAt.getVisibility() != 8 && h(i9)) {
                    c(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((w0) childAt.getLayoutParams())).topMargin) - this.f2865n);
                }
                i9++;
            }
            if (h(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                c(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f2865n : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((w0) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z = getLayoutDirection() == 1;
        while (i9 < virtualChildCount2) {
            View childAt3 = getChildAt(i9);
            if (childAt3 != null && childAt3.getVisibility() != 8 && h(i9)) {
                w0 w0Var = (w0) childAt3.getLayoutParams();
                d(canvas, z ? childAt3.getRight() + ((LinearLayout.LayoutParams) w0Var).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) w0Var).leftMargin) - this.f2864m);
            }
            i9++;
        }
        if (h(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                w0 w0Var2 = (w0) childAt4.getLayoutParams();
                if (z) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) w0Var2).leftMargin;
                    i8 = this.f2864m;
                    right = left - i8;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) w0Var2).rightMargin;
                }
            } else if (z) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i8 = this.f2864m;
                right = left - i8;
            }
            d(canvas, right);
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
        throw new UnsupportedOperationException("Method not decompiled: g.x0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:228:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.x0.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.f2854a = z;
    }

    public void setBaselineAlignedChildIndex(int i8) {
        if (i8 >= 0 && i8 < getChildCount()) {
            this.f2855b = i8;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f2863l) {
            return;
        }
        this.f2863l = drawable;
        if (drawable != null) {
            this.f2864m = drawable.getIntrinsicWidth();
            this.f2865n = drawable.getIntrinsicHeight();
        } else {
            this.f2864m = 0;
            this.f2865n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i8) {
        this.f2867p = i8;
    }

    public void setGravity(int i8) {
        if (this.f2857e != i8) {
            if ((8388615 & i8) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            this.f2857e = i8;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i8) {
        int i9 = i8 & 8388615;
        int i10 = this.f2857e;
        if ((8388615 & i10) != i9) {
            this.f2857e = i9 | ((-8388616) & i10);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f2860h = z;
    }

    public void setOrientation(int i8) {
        if (this.d != i8) {
            this.d = i8;
            requestLayout();
        }
    }

    public void setShowDividers(int i8) {
        if (i8 != this.f2866o) {
            requestLayout();
        }
        this.f2866o = i8;
    }

    public void setVerticalGravity(int i8) {
        int i9 = i8 & 112;
        int i10 = this.f2857e;
        if ((i10 & 112) != i9) {
            this.f2857e = i9 | (i10 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f3) {
        this.f2859g = Math.max(0.0f, f3);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
