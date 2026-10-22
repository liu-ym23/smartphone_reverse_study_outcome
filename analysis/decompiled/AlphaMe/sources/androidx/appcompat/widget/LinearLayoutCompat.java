package androidx.appcompat.widget;

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
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import g.AbstractC0560a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2864a;

    /* renamed from: b, reason: collision with root package name */
    public int f2865b;

    /* renamed from: c, reason: collision with root package name */
    public int f2866c;

    /* renamed from: d, reason: collision with root package name */
    public int f2867d;

    /* renamed from: e, reason: collision with root package name */
    public int f2868e;

    /* renamed from: f, reason: collision with root package name */
    public int f2869f;

    /* renamed from: g, reason: collision with root package name */
    public float f2870g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2871h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f2872i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f2873j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f2874k;

    /* renamed from: l, reason: collision with root package name */
    public int f2875l;

    /* renamed from: m, reason: collision with root package name */
    public int f2876m;

    /* renamed from: n, reason: collision with root package name */
    public int f2877n;

    /* renamed from: o, reason: collision with root package name */
    public int f2878o;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12494c})
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12494c})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0237y0;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i4;
        if (this.f2865b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i5 = this.f2865b;
        if (childCount <= i5) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i5);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f2865b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f2866c;
        if (this.f2867d == 1 && (i4 = this.f2868e & 112) != 48) {
            if (i4 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2869f) / 2;
            } else if (i4 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2869f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((C0237y0) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2865b;
    }

    public Drawable getDividerDrawable() {
        return this.f2874k;
    }

    public int getDividerPadding() {
        return this.f2878o;
    }

    @RestrictTo({EnumC0546d.f12494c})
    public int getDividerWidth() {
        return this.f2875l;
    }

    @GravityInt
    public int getGravity() {
        return this.f2868e;
    }

    public int getOrientation() {
        return this.f2867d;
    }

    public int getShowDividers() {
        return this.f2877n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2870g;
    }

    public final void h(Canvas canvas, int i4) {
        this.f2874k.setBounds(getPaddingLeft() + this.f2878o, i4, (getWidth() - getPaddingRight()) - this.f2878o, this.f2876m + i4);
        this.f2874k.draw(canvas);
    }

    public final void i(Canvas canvas, int i4) {
        this.f2874k.setBounds(i4, getPaddingTop() + this.f2878o, this.f2875l + i4, (getHeight() - getPaddingBottom()) - this.f2878o);
        this.f2874k.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0237y0 generateDefaultLayoutParams() {
        int i4 = this.f2867d;
        if (i4 == 0) {
            return new C0237y0(-2, -2);
        }
        if (i4 == 1) {
            return new C0237y0(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0237y0 generateLayoutParams(AttributeSet attributeSet) {
        return new C0237y0(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0237y0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0237y0 ? new C0237y0((C0237y0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0237y0((ViewGroup.MarginLayoutParams) layoutParams) : new C0237y0(layoutParams);
    }

    public final boolean m(int i4) {
        if (i4 == 0) {
            return (this.f2877n & 1) != 0;
        }
        if (i4 == getChildCount()) {
            return (this.f2877n & 4) != 0;
        }
        if ((this.f2877n & 2) == 0) {
            return false;
        }
        for (int i5 = i4 - 1; i5 >= 0; i5--) {
            if (getChildAt(i5).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i4;
        if (this.f2874k == null) {
            return;
        }
        int i5 = 0;
        if (this.f2867d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i5 < virtualChildCount) {
                View childAt = getChildAt(i5);
                if (childAt != null && childAt.getVisibility() != 8 && m(i5)) {
                    h(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((C0237y0) childAt.getLayoutParams())).topMargin) - this.f2876m);
                }
                i5++;
            }
            if (m(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                h(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f2876m : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((C0237y0) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z4 = getLayoutDirection() == 1;
        while (i5 < virtualChildCount2) {
            View childAt3 = getChildAt(i5);
            if (childAt3 != null && childAt3.getVisibility() != 8 && m(i5)) {
                C0237y0 c0237y0 = (C0237y0) childAt3.getLayoutParams();
                i(canvas, z4 ? childAt3.getRight() + ((LinearLayout.LayoutParams) c0237y0).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) c0237y0).leftMargin) - this.f2875l);
            }
            i5++;
        }
        if (m(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                C0237y0 c0237y02 = (C0237y0) childAt4.getLayoutParams();
                if (z4) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) c0237y02).leftMargin;
                    i4 = this.f2875l;
                    right = left - i4;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) c0237y02).rightMargin;
                }
            } else if (z4) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i4 = this.f2875l;
                right = left - i4;
            }
            i(canvas, right);
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a5  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0806  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:442:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r38, int r39) {
        /*
            Method dump skipped, instructions count: 2208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z4) {
        this.f2864a = z4;
    }

    public void setBaselineAlignedChildIndex(int i4) {
        if (i4 >= 0 && i4 < getChildCount()) {
            this.f2865b = i4;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f2874k) {
            return;
        }
        this.f2874k = drawable;
        if (drawable != null) {
            this.f2875l = drawable.getIntrinsicWidth();
            this.f2876m = drawable.getIntrinsicHeight();
        } else {
            this.f2875l = 0;
            this.f2876m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i4) {
        this.f2878o = i4;
    }

    public void setGravity(@GravityInt int i4) {
        if (this.f2868e != i4) {
            if ((8388615 & i4) == 0) {
                i4 |= 8388611;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            this.f2868e = i4;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i4) {
        int i5 = i4 & 8388615;
        int i6 = this.f2868e;
        if ((8388615 & i6) != i5) {
            this.f2868e = i5 | ((-8388616) & i6);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z4) {
        this.f2871h = z4;
    }

    public void setOrientation(int i4) {
        if (this.f2867d != i4) {
            this.f2867d = i4;
            requestLayout();
        }
    }

    public void setShowDividers(int i4) {
        if (i4 != this.f2877n) {
            requestLayout();
        }
        this.f2877n = i4;
    }

    public void setVerticalGravity(int i4) {
        int i5 = i4 & 112;
        int i6 = this.f2868e;
        if ((i6 & 112) != i5) {
            this.f2868e = i5 | (i6 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f4) {
        this.f2870g = Math.max(Property.DEFAULT_FLOAT_VALUE, f4);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f2864a = true;
        this.f2865b = -1;
        this.f2866c = 0;
        this.f2868e = 8388659;
        int[] iArr = AbstractC0560a.f12601n;
        android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(i4, 0, context, attributeSet, iArr);
        TypedArray typedArray = (TypedArray) cVarY.f2365c;
        WeakHashMap weakHashMap = K.S.f939a;
        K.O.d(this, context, iArr, attributeSet, typedArray, i4, 0);
        int iP = cVarY.p(1, -1);
        if (iP >= 0) {
            setOrientation(iP);
        }
        int iP2 = cVarY.p(0, -1);
        if (iP2 >= 0) {
            setGravity(iP2);
        }
        boolean zG = cVarY.g(2, true);
        if (!zG) {
            setBaselineAligned(zG);
        }
        this.f2870g = cVarY.n(-1.0f, 4);
        this.f2865b = cVarY.p(3, -1);
        this.f2871h = cVarY.g(7, false);
        setDividerDrawable(cVarY.l(5));
        this.f2877n = cVarY.p(8, 0);
        this.f2878o = cVarY.j(6, 0);
        cVarY.A();
    }
}
