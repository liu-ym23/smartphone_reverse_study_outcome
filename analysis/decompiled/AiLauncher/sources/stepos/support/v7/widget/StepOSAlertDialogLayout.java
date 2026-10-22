package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.LinearLayoutCompat;
import stepos.support.v7.appcompat.R$dimen;

/* loaded from: classes5.dex */
public class StepOSAlertDialogLayout extends LinearLayoutCompat {

    /* renamed from: a, reason: collision with root package name */
    public int f41277a;

    /* renamed from: b, reason: collision with root package name */
    public Context f41278b;

    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void forceUniformWidth(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3d
            android.view.View r3 = r9.getChildAt(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.StepOSAlertDialogLayout.forceUniformWidth(int, int):void");
    }

    private boolean tryOnMeasure(int i10, int i11) throws Resources.NotFoundException {
        int id;
        int childCount = getChildCount();
        View view = null;
        boolean z10 = false;
        int i12 = 0;
        while (true) {
            int i13 = 8;
            if (i12 < childCount) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() != 8 && ((id = childAt.getId()) == R$id.contentPanel || id == R$id.customPanel)) {
                    if (view != null) {
                        return false;
                    }
                    view = childAt;
                }
                i12++;
            } else {
                if (view == null) {
                    return false;
                }
                int iMin = Math.min(this.f41277a, View.MeasureSpec.getSize(i11));
                int mode = View.MeasureSpec.getMode(i10);
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int dimensionPixelOffset = iMin - paddingTop;
                int childCount2 = getChildCount();
                int i14 = 0;
                int iCombineMeasuredStates = 0;
                while (true) {
                    if (i14 >= childCount2) {
                        boolean z11 = z10;
                        view.measure(i10, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                        if (view.getMeasuredHeight() > dimensionPixelOffset) {
                            return z11;
                        }
                        int measuredHeight = paddingTop + view.getMeasuredHeight();
                        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        int i15 = z11 ? 1 : 0;
                        int iMax = i15;
                        while (i15 < childCount) {
                            View childAt2 = getChildAt(i15);
                            if (childAt2.getVisibility() != 8) {
                                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
                            }
                            i15++;
                        }
                        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i10, iCombineMeasuredStates2), View.resolveSizeAndState(measuredHeight, i11, z11 ? 1 : 0));
                        if (mode != 1073741824) {
                            forceUniformWidth(childCount, i11);
                        }
                        return true;
                    }
                    boolean z12 = z10;
                    View childAt3 = getChildAt(i14);
                    if (childAt3.getVisibility() != i13 && childAt3 != view) {
                        if (childAt3.getLayoutParams().height == -1) {
                            childAt3.measure(i10, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, 1073741824));
                        } else if (childAt3.getLayoutParams().height == -2) {
                            boolean z13 = this.f41278b.getResources().getConfiguration().orientation != 2 ? z12 : true;
                            if (childAt3.getId() == R$id.topPanel && z13) {
                                dimensionPixelOffset = this.f41278b.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_top_panel_max_height);
                            }
                            if (childAt3.getId() == R$id.buttonPanel && z13) {
                                dimensionPixelOffset = this.f41278b.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_button_bar_max_height);
                            }
                            childAt3.measure(i10, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                        } else {
                            childAt3.measure(i10, View.MeasureSpec.makeMeasureSpec(childAt3.getLayoutParams().height, 1073741824));
                        }
                        paddingTop += childAt3.getMeasuredHeight();
                        int i16 = iMin - paddingTop;
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt3.getMeasuredState());
                        if (i16 <= 0) {
                            return z12;
                        }
                        dimensionPixelOffset = i16;
                    }
                    i14++;
                    z10 = z12;
                    i13 = 8;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        if (tryOnMeasure(i10, i11)) {
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxHeight(int i10) {
        this.f41277a = i10;
        requestLayout();
    }

    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41277a = Integer.MAX_VALUE;
        this.f41278b = context;
    }
}
