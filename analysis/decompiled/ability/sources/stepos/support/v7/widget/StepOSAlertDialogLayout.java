package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class StepOSAlertDialogLayout extends LinearLayoutCompat {

    /* renamed from: a, reason: collision with root package name */
    public int f6501a;
    public final Context b;

    public StepOSAlertDialogLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6501a = Integer.MAX_VALUE;
        this.b = context;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i, int i6) throws Resources.NotFoundException {
        int id;
        StepOSAlertDialogLayout stepOSAlertDialogLayout = this;
        int childCount = stepOSAlertDialogLayout.getChildCount();
        View view = null;
        int i10 = 0;
        while (true) {
            int i11 = 8;
            if (i10 < childCount) {
                View childAt = stepOSAlertDialogLayout.getChildAt(i10);
                if (childAt.getVisibility() != 8 && ((id = childAt.getId()) == R.id.contentPanel || id == R.id.customPanel)) {
                    if (view != null) {
                        break;
                    } else {
                        view = childAt;
                    }
                }
                i10++;
            } else if (view != null) {
                int iMin = Math.min(stepOSAlertDialogLayout.f6501a, View.MeasureSpec.getSize(i6));
                int mode = View.MeasureSpec.getMode(i);
                int paddingBottom = stepOSAlertDialogLayout.getPaddingBottom() + stepOSAlertDialogLayout.getPaddingTop();
                int dimensionPixelOffset = iMin - paddingBottom;
                int childCount2 = stepOSAlertDialogLayout.getChildCount();
                int i12 = 0;
                int iCombineMeasuredStates = 0;
                while (true) {
                    if (i12 < childCount2) {
                        View childAt2 = stepOSAlertDialogLayout.getChildAt(i12);
                        if (childAt2.getVisibility() != i11 && childAt2 != view) {
                            if (childAt2.getLayoutParams().height == -1) {
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, BasicMeasure.EXACTLY));
                            } else if (childAt2.getLayoutParams().height == -2) {
                                Context context = stepOSAlertDialogLayout.b;
                                boolean z10 = context.getResources().getConfiguration().orientation == 2;
                                if (childAt2.getId() == R.id.topPanel && z10) {
                                    dimensionPixelOffset = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_top_panel_max_height);
                                }
                                if (childAt2.getId() == R.id.buttonPanel && z10) {
                                    dimensionPixelOffset = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_button_bar_max_height);
                                }
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                            } else {
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(childAt2.getLayoutParams().height, BasicMeasure.EXACTLY));
                            }
                            int measuredHeight = childAt2.getMeasuredHeight() + paddingBottom;
                            dimensionPixelOffset = iMin - measuredHeight;
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt2.getMeasuredState());
                            if (dimensionPixelOffset <= 0) {
                                break;
                            } else {
                                paddingBottom = measuredHeight;
                            }
                        }
                        i12++;
                        i11 = 8;
                    } else {
                        view.measure(i, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                        if (view.getMeasuredHeight() <= dimensionPixelOffset) {
                            int measuredHeight2 = view.getMeasuredHeight() + paddingBottom;
                            int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                            int iMax = 0;
                            for (int i13 = 0; i13 < childCount; i13++) {
                                View childAt3 = stepOSAlertDialogLayout.getChildAt(i13);
                                if (childAt3.getVisibility() != 8) {
                                    iMax = Math.max(iMax, childAt3.getMeasuredWidth());
                                }
                            }
                            int i14 = i6;
                            stepOSAlertDialogLayout.setMeasuredDimension(View.resolveSizeAndState(stepOSAlertDialogLayout.getPaddingRight() + stepOSAlertDialogLayout.getPaddingLeft() + iMax, i, iCombineMeasuredStates2), View.resolveSizeAndState(measuredHeight2, i14, 0));
                            if (mode != 1073741824) {
                                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(stepOSAlertDialogLayout.getMeasuredWidth(), BasicMeasure.EXACTLY);
                                int i15 = 0;
                                while (i15 < childCount) {
                                    int i16 = iMakeMeasureSpec;
                                    View childAt4 = stepOSAlertDialogLayout.getChildAt(i15);
                                    if (childAt4.getVisibility() != 8) {
                                        LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt4.getLayoutParams();
                                        if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                                            int i17 = ((LinearLayout.LayoutParams) layoutParams).height;
                                            ((LinearLayout.LayoutParams) layoutParams).height = childAt4.getMeasuredHeight();
                                            stepOSAlertDialogLayout.measureChildWithMargins(childAt4, i16, 0, i14, 0);
                                            ((LinearLayout.LayoutParams) layoutParams).height = i17;
                                        }
                                    }
                                    i15++;
                                    stepOSAlertDialogLayout = this;
                                    i14 = i6;
                                    iMakeMeasureSpec = i16;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        super.onMeasure(i, i6);
    }

    public void setMaxHeight(int i) {
        this.f6501a = i;
        requestLayout();
    }
}
