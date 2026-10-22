package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSAlertDialogLayout extends LinearLayoutCompat {

    /* renamed from: s, reason: collision with root package name */
    public int f12568s;

    /* renamed from: t, reason: collision with root package name */
    public final Context f12569t;

    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f12568s = Integer.MAX_VALUE;
        this.f12569t = context;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        int id2;
        StepOSAlertDialogLayout stepOSAlertDialogLayout = this;
        int childCount = stepOSAlertDialogLayout.getChildCount();
        View view = null;
        int i12 = 0;
        while (true) {
            int i13 = 8;
            if (i12 < childCount) {
                View childAt = stepOSAlertDialogLayout.getChildAt(i12);
                if (childAt.getVisibility() != 8 && ((id2 = childAt.getId()) == R.id.contentPanel || id2 == R.id.customPanel)) {
                    if (view != null) {
                        break;
                    } else {
                        view = childAt;
                    }
                }
                i12++;
            } else if (view != null) {
                int iMin = Math.min(stepOSAlertDialogLayout.f12568s, View.MeasureSpec.getSize(i11));
                int mode = View.MeasureSpec.getMode(i10);
                int paddingBottom = stepOSAlertDialogLayout.getPaddingBottom() + stepOSAlertDialogLayout.getPaddingTop();
                int dimensionPixelOffset = iMin - paddingBottom;
                int childCount2 = stepOSAlertDialogLayout.getChildCount();
                int i14 = 0;
                int iCombineMeasuredStates = 0;
                while (true) {
                    if (i14 < childCount2) {
                        View childAt2 = stepOSAlertDialogLayout.getChildAt(i14);
                        if (childAt2.getVisibility() != i13 && childAt2 != view) {
                            if (childAt2.getLayoutParams().height == -1) {
                                childAt2.measure(i10, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, 1073741824));
                            } else if (childAt2.getLayoutParams().height == -2) {
                                Context context = stepOSAlertDialogLayout.f12569t;
                                boolean z = context.getResources().getConfiguration().orientation == 2;
                                if (childAt2.getId() == R.id.topPanel && z) {
                                    dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_top_panel_max_height);
                                }
                                if (childAt2.getId() == R.id.buttonPanel && z) {
                                    dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_bar_max_height);
                                }
                                childAt2.measure(i10, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                            } else {
                                childAt2.measure(i10, View.MeasureSpec.makeMeasureSpec(childAt2.getLayoutParams().height, 1073741824));
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
                        i14++;
                        i13 = 8;
                    } else {
                        view.measure(i10, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                        if (view.getMeasuredHeight() <= dimensionPixelOffset) {
                            int measuredHeight2 = view.getMeasuredHeight() + paddingBottom;
                            int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                            int iMax = 0;
                            for (int i15 = 0; i15 < childCount; i15++) {
                                View childAt3 = stepOSAlertDialogLayout.getChildAt(i15);
                                if (childAt3.getVisibility() != 8) {
                                    iMax = Math.max(iMax, childAt3.getMeasuredWidth());
                                }
                            }
                            int i16 = i11;
                            stepOSAlertDialogLayout.setMeasuredDimension(View.resolveSizeAndState(stepOSAlertDialogLayout.getPaddingRight() + stepOSAlertDialogLayout.getPaddingLeft() + iMax, i10, iCombineMeasuredStates2), View.resolveSizeAndState(measuredHeight2, i16, 0));
                            if (mode != 1073741824) {
                                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(stepOSAlertDialogLayout.getMeasuredWidth(), 1073741824);
                                int i17 = 0;
                                while (i17 < childCount) {
                                    int i18 = iMakeMeasureSpec;
                                    View childAt4 = stepOSAlertDialogLayout.getChildAt(i17);
                                    if (childAt4.getVisibility() != 8) {
                                        LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt4.getLayoutParams();
                                        if (((LinearLayout.LayoutParams) aVar).width == -1) {
                                            int i19 = ((LinearLayout.LayoutParams) aVar).height;
                                            ((LinearLayout.LayoutParams) aVar).height = childAt4.getMeasuredHeight();
                                            stepOSAlertDialogLayout.measureChildWithMargins(childAt4, i18, 0, i16, 0);
                                            ((LinearLayout.LayoutParams) aVar).height = i19;
                                        }
                                    }
                                    i17++;
                                    stepOSAlertDialogLayout = this;
                                    i16 = i11;
                                    iMakeMeasureSpec = i18;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxHeight(int i10) {
        this.f12568s = i10;
        requestLayout();
    }
}
