package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.a;
import com.stepos.stepclaw.R;
import e0.a0;
import e0.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f321a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f322b;

    /* renamed from: c, reason: collision with root package name */
    public int f323c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f323c = -1;
        int[] iArr = a.f1021i;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        int[] iArr2 = a0.f2285a;
        y.b(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f321a = typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f321a);
        }
    }

    private void setStacked(boolean z) {
        if (this.f322b != z) {
            if (!z || this.f321a) {
                this.f322b = z;
                setOrientation(z ? 1 : 0);
                setGravity(z ? 8388613 : 80);
                View viewFindViewById = findViewById(R.id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        int iMakeMeasureSpec;
        boolean z;
        int i10;
        int size = View.MeasureSpec.getSize(i8);
        int paddingBottom = 0;
        if (this.f321a) {
            if (size > this.f323c && this.f322b) {
                setStacked(false);
            }
            this.f323c = size;
        }
        if (this.f322b || View.MeasureSpec.getMode(i8) != 1073741824) {
            iMakeMeasureSpec = i8;
            z = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i9);
        if (this.f321a && !this.f322b && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z = true;
        }
        if (z) {
            super.onMeasure(i8, i9);
        }
        int childCount = getChildCount();
        int i11 = 0;
        while (true) {
            i10 = -1;
            if (i11 >= childCount) {
                i11 = -1;
                break;
            } else if (getChildAt(i11).getVisibility() == 0) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            View childAt = getChildAt(i11);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f322b) {
                int i12 = i11 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i12 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i12).getVisibility() == 0) {
                        i10 = i12;
                        break;
                    }
                    i12++;
                }
                paddingBottom = i10 >= 0 ? getChildAt(i10).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                paddingBottom = getPaddingBottom() + measuredHeight;
            }
        }
        int[] iArr = a0.f2285a;
        if (getMinimumHeight() != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i9 == 0) {
                super.onMeasure(i8, i9);
            }
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f321a != z) {
            this.f321a = z;
            if (!z && this.f322b) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
