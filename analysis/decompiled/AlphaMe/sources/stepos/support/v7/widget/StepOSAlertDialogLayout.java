package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.C0237y0;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.stepos.alphame.R;
import e.EnumC0546d;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes2.dex */
public class StepOSAlertDialogLayout extends LinearLayoutCompat {

    /* renamed from: p, reason: collision with root package name */
    public int f14896p;

    /* renamed from: q, reason: collision with root package name */
    public final Context f14897q;

    public StepOSAlertDialogLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f14896p = Integer.MAX_VALUE;
        this.f14897q = context;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i4, int i5) throws Resources.NotFoundException {
        int id;
        int childCount = getChildCount();
        View view = null;
        int i6 = 0;
        while (true) {
            int i7 = 8;
            if (i6 < childCount) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8 && ((id = childAt.getId()) == R.id.contentPanel || id == R.id.customPanel)) {
                    if (view != null) {
                        break;
                    } else {
                        view = childAt;
                    }
                }
                i6++;
            } else if (view != null) {
                int iMin = Math.min(this.f14896p, View.MeasureSpec.getSize(i5));
                int mode = View.MeasureSpec.getMode(i4);
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                int dimensionPixelOffset = iMin - paddingBottom;
                int childCount2 = getChildCount();
                int i8 = 0;
                int iCombineMeasuredStates = 0;
                while (true) {
                    if (i8 < childCount2) {
                        View childAt2 = getChildAt(i8);
                        if (childAt2.getVisibility() != i7 && childAt2 != view) {
                            if (childAt2.getLayoutParams().height == -1) {
                                childAt2.measure(i4, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, 1073741824));
                            } else if (childAt2.getLayoutParams().height == -2) {
                                Context context = this.f14897q;
                                boolean z4 = context.getResources().getConfiguration().orientation == 2;
                                if (childAt2.getId() == R.id.topPanel && z4) {
                                    dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_top_panel_max_height);
                                }
                                if (childAt2.getId() == R.id.buttonPanel && z4) {
                                    dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_bar_max_height);
                                }
                                childAt2.measure(i4, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                            } else {
                                childAt2.measure(i4, View.MeasureSpec.makeMeasureSpec(childAt2.getLayoutParams().height, 1073741824));
                            }
                            int measuredHeight = childAt2.getMeasuredHeight() + paddingBottom;
                            int i9 = iMin - measuredHeight;
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt2.getMeasuredState());
                            if (i9 <= 0) {
                                break;
                            }
                            paddingBottom = measuredHeight;
                            dimensionPixelOffset = i9;
                        }
                        i8++;
                        i7 = 8;
                    } else {
                        view.measure(i4, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, Integer.MIN_VALUE));
                        if (view.getMeasuredHeight() <= dimensionPixelOffset) {
                            int measuredHeight2 = view.getMeasuredHeight() + paddingBottom;
                            int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                            int iMax = 0;
                            for (int i10 = 0; i10 < childCount; i10++) {
                                View childAt3 = getChildAt(i10);
                                if (childAt3.getVisibility() != 8) {
                                    iMax = Math.max(iMax, childAt3.getMeasuredWidth());
                                }
                            }
                            setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + iMax, i4, iCombineMeasuredStates2), View.resolveSizeAndState(measuredHeight2, i5, 0));
                            if (mode != 1073741824) {
                                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                                for (int i11 = 0; i11 < childCount; i11++) {
                                    View childAt4 = getChildAt(i11);
                                    if (childAt4.getVisibility() != 8) {
                                        C0237y0 c0237y0 = (C0237y0) childAt4.getLayoutParams();
                                        if (((LinearLayout.LayoutParams) c0237y0).width == -1) {
                                            int i12 = ((LinearLayout.LayoutParams) c0237y0).height;
                                            ((LinearLayout.LayoutParams) c0237y0).height = childAt4.getMeasuredHeight();
                                            measureChildWithMargins(childAt4, iMakeMeasureSpec, 0, i5, 0);
                                            ((LinearLayout.LayoutParams) c0237y0).height = i12;
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        super.onMeasure(i4, i5);
    }

    public void setMaxHeight(int i4) {
        this.f14896p = i4;
        requestLayout();
    }
}
