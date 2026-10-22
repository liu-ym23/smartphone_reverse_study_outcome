package com.android.internal.widget;

import android.content.Context;
import android.content.IntentExt;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class StepOSAlertDialogLayout extends LinearLayout {
    private Context mContext;
    private int mMaxHeight;

    public StepOSAlertDialogLayout(Context context) {
        this(context, null);
    }

    public StepOSAlertDialogLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StepOSAlertDialogLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mContext = context;
    }

    public void setMaxHeight(int maxHeight) {
        this.mMaxHeight = maxHeight;
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!tryOnMeasure(widthMeasureSpec, heightMeasureSpec)) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private boolean tryOnMeasure(int i, int i2) throws Resources.NotFoundException {
        int i3;
        int id;
        int childCount = getChildCount();
        View view = null;
        int i4 = 0;
        while (true) {
            int i5 = 8;
            boolean z = false;
            if (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8 && ((id = childAt.getId()) == 16908979 || id == 16909029)) {
                    if (view != null) {
                        return false;
                    }
                    view = childAt;
                }
                i4++;
            } else {
                if (view == null) {
                    return false;
                }
                int size = View.MeasureSpec.getSize(i2);
                int iMin = Math.min(this.mMaxHeight, size);
                int mode = View.MeasureSpec.getMode(i);
                int i6 = 0;
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int i7 = iMin - paddingTop;
                int childCount2 = getChildCount();
                int i8 = 0;
                while (true) {
                    boolean z2 = z;
                    if (i8 < childCount2) {
                        View childAt2 = getChildAt(i8);
                        if (childAt2.getVisibility() == i5) {
                            i3 = size;
                        } else if (childAt2 == view) {
                            i3 = size;
                        } else {
                            if (childAt2.getLayoutParams().height == -1) {
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
                                i3 = size;
                            } else if (childAt2.getLayoutParams().height == -2) {
                                int dimensionPixelOffset = i7;
                                i3 = size;
                                if (childAt2.getId() == 16908900 && this.mContext.getResources().getConfiguration().orientation == 2) {
                                    dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(17106019);
                                }
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(dimensionPixelOffset, IntentExt.STEPOS_FLAG_DISABLE_SNAPSHOT));
                            } else {
                                i3 = size;
                                childAt2.measure(i, View.MeasureSpec.makeMeasureSpec(childAt2.getLayoutParams().height, 1073741824));
                            }
                            paddingTop += childAt2.getMeasuredHeight();
                            int i9 = iMin - paddingTop;
                            int iCombineMeasuredStates = View.combineMeasuredStates(i6, childAt2.getMeasuredState());
                            if (i9 > 0) {
                                i7 = i9;
                                i6 = iCombineMeasuredStates;
                            } else {
                                return z2;
                            }
                        }
                        i8++;
                        z = z2 ? 1 : 0;
                        size = i3;
                        i5 = 8;
                    } else {
                        view.measure(i, View.MeasureSpec.makeMeasureSpec(i7, IntentExt.STEPOS_FLAG_DISABLE_SNAPSHOT));
                        if (view.getMeasuredHeight() > i7) {
                            return z2;
                        }
                        int measuredHeight = paddingTop + view.getMeasuredHeight();
                        int iCombineMeasuredStates2 = View.combineMeasuredStates(i6, view.getMeasuredState());
                        int iMax = 0;
                        for (int i10 = 0; i10 < childCount; i10++) {
                            View childAt3 = getChildAt(i10);
                            if (childAt3.getVisibility() != 8) {
                                iMax = Math.max(iMax, childAt3.getMeasuredWidth());
                            }
                        }
                        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i, iCombineMeasuredStates2), View.resolveSizeAndState(measuredHeight, i2, z2 ? 1 : 0));
                        if (mode != 1073741824) {
                            forceUniformWidth(childCount, i2);
                            return true;
                        }
                        return true;
                    }
                }
            }
        }
    }

    private static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    private void forceUniformWidth(int count, int heightMeasureSpec) {
        int heightMeasureSpec2;
        int uniformMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i = 0;
        while (i < count) {
            View child = getChildAt(i);
            if (child.getVisibility() == 8) {
                heightMeasureSpec2 = heightMeasureSpec;
            } else {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                if (lp.width != -1) {
                    heightMeasureSpec2 = heightMeasureSpec;
                } else {
                    int oldHeight = lp.height;
                    lp.height = child.getMeasuredHeight();
                    heightMeasureSpec2 = heightMeasureSpec;
                    measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec2, 0);
                    lp.height = oldHeight;
                }
            }
            i++;
            heightMeasureSpec = heightMeasureSpec2;
        }
    }
}
