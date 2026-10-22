package com.android.server.autofill.ui;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.view.View;
import android.widget.LinearLayout;
import com.android.server.autofill.Helper;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetLayout extends LinearLayout {
    private static final String TAG = "BottomSheetLayout";

    public BottomSheetLayout(Context context) {
        super(context);
    }

    public BottomSheetLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomSheetLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthSpec, int heightSpec) {
        if (getContext() != null) goto L5;
    L19:
        super.onMeasure(widthSpec, heightSpec);
        Slog.w(TAG, "onMeasure failed due to missing context or missing resources.");
        return;
    L5:
        if (getContext().getResources() == null) goto L19;
        if (getChildCount() != 0) goto L11;
        super.onMeasure(widthSpec, heightSpec);
        Slog.wtf(TAG, "onMeasure failed due to missing children views.");
        return;
    L11:
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int pxOffset = getContext().getResources().getDimensionPixelSize(R.dimen.autofill_save_title_start_padding);
        int outerMargin = getContext().getResources().getDimensionPixelSize(R.dimen.btn_horizontal_edge_padding);
        boolean includeHorizontalSpace = getContext().getResources().getBoolean(R.bool.autofill_dialog_horizontal_space_included);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;
        int maxHeight = (screenHeight - pxOffset) - outerMargin;
        int maxWidth = screenWidth;
        if (includeHorizontalSpace == false) goto L14;
        maxWidth = maxWidth - (pxOffset * 2);
    L14:
        int maxWidth2 = Math.min(maxWidth, getContext().getResources().getDimensionPixelSize(R.dimen.autofill_save_scroll_view_top_margin));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(maxWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE));
        if (Helper.sDebug == false) goto L17;
        Slog.d(TAG, "onMeasure() values in dp: screenHeight: " + (screenHeight / displayMetrics.density) + ", screenWidth: " + (screenWidth / displayMetrics.density) + ", maxHeight: " + (maxHeight / displayMetrics.density) + ", maxWidth: " + (maxWidth2 / displayMetrics.density) + ", getMeasuredWidth(): " + (getMeasuredWidth() / displayMetrics.density) + ", getMeasuredHeight(): " + (getMeasuredHeight() / displayMetrics.density));
    L17:
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }
}
