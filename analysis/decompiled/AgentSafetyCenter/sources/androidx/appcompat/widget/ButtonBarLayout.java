package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.stepos.agentsafetycenter.R;
import g.a;
import java.util.WeakHashMap;
import n3.i0;
import n3.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    public boolean f799c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f800f;

    /* renamed from: g, reason: collision with root package name */
    public int f801g;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f801g = -1;
        int[] iArr = a.f4107k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        WeakHashMap weakHashMap = k0.f8724a;
        i0.b(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f799c = typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f799c);
        }
    }

    private void setStacked(boolean z10) {
        if (this.f800f != z10) {
            if (!z10 || this.f799c) {
                this.f800f = z10;
                setOrientation(z10 ? 1 : 0);
                setGravity(z10 ? 8388613 : 80);
                View viewFindViewById = findViewById(R.id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z10 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        int iMakeMeasureSpec;
        boolean z10;
        int i10;
        int size = View.MeasureSpec.getSize(i);
        int paddingBottom = 0;
        if (this.f799c) {
            if (size > this.f801g && this.f800f) {
                setStacked(false);
            }
            this.f801g = size;
        }
        if (this.f800f || View.MeasureSpec.getMode(i) != 1073741824) {
            iMakeMeasureSpec = i;
            z10 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z10 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i3);
        if (this.f799c && !this.f800f && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z10 = true;
        }
        if (z10) {
            super.onMeasure(i, i3);
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
            if (this.f800f) {
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
        WeakHashMap weakHashMap = k0.f8724a;
        if (getMinimumHeight() != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i3 == 0) {
                super.onMeasure(i, i3);
            }
        }
    }

    public void setAllowStacking(boolean z10) {
        if (this.f799c != z10) {
            this.f799c = z10;
            if (!z10 && this.f800f) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
