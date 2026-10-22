package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class StepOSAlertDialogLayout extends m.o1 {

    /* renamed from: t, reason: collision with root package name */
    public int f12634t;

    /* renamed from: u, reason: collision with root package name */
    public final Context f12635u;

    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12634t = Reader.READ_DONE;
        this.f12635u = context;
    }

    @Override // m.o1, android.view.View
    public final void onMeasure(int i, int i3) throws Resources.NotFoundException {
        int id2;
        StepOSAlertDialogLayout stepOSAlertDialogLayout = this;
        int childCount = stepOSAlertDialogLayout.getChildCount();
        View view = null;
        int i10 = 0;
        while (true) {
            int i11 = 8;
            if (i10 < childCount) {
                View childAt = stepOSAlertDialogLayout.getChildAt(i10);
                if (childAt.getVisibility() != 8 && ((id2 = childAt.getId()) == R.id.contentPanel || id2 == R.id.customPanel)) {
                    if (view != null) {
                        break;
                    } else {
                        view = childAt;
                    }
                }
                i10++;
            } else if (view != null) {
                int iMin = Math.min(stepOSAlertDialogLayout.f12634t, View.MeasureSpec.getSize(i3));
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
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, 1073741824));
                            } else if (childAt2.getLayoutParams().height == -2) {
                                Context context = stepOSAlertDialogLayout.f12635u;
                                boolean z10 = context.getResources().getConfiguration().orientation == 2;
                                if (childAt2.getId() == R.id.topPanel && z10) {
                                    dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_top_panel_max_height);
                                }
                                if (childAt2.getId() == R.id.buttonPanel && z10) {
                                    dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_bar_max_height);
                                }
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                            } else {
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(childAt2.getLayoutParams().height, 1073741824));
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
                            int i14 = i3;
                            stepOSAlertDialogLayout.setMeasuredDimension(View.resolveSizeAndState(stepOSAlertDialogLayout.getPaddingRight() + stepOSAlertDialogLayout.getPaddingLeft() + iMax, i, iCombineMeasuredStates2), View.resolveSizeAndState(measuredHeight2, i14, 0));
                            if (mode != 1073741824) {
                                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(stepOSAlertDialogLayout.getMeasuredWidth(), 1073741824);
                                int i15 = 0;
                                while (i15 < childCount) {
                                    int i16 = iMakeMeasureSpec;
                                    View childAt4 = stepOSAlertDialogLayout.getChildAt(i15);
                                    if (childAt4.getVisibility() != 8) {
                                        m.n1 n1Var = (m.n1) childAt4.getLayoutParams();
                                        if (((LinearLayout.LayoutParams) n1Var).width == -1) {
                                            int i17 = ((LinearLayout.LayoutParams) n1Var).height;
                                            ((LinearLayout.LayoutParams) n1Var).height = childAt4.getMeasuredHeight();
                                            stepOSAlertDialogLayout.measureChildWithMargins(childAt4, i16, 0, i14, 0);
                                            ((LinearLayout.LayoutParams) n1Var).height = i17;
                                        }
                                    }
                                    i15++;
                                    stepOSAlertDialogLayout = this;
                                    i14 = i3;
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
        super.onMeasure(i, i3);
    }

    public void setMaxHeight(int i) {
        this.f12634t = i;
        requestLayout();
    }

    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StepOSAlertDialogLayout(Context context) {
        this(context, null);
    }
}
