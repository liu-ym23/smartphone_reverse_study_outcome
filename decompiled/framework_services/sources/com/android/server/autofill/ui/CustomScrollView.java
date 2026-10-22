package com.android.server.autofill.ui;

import android.R;
import android.content.Context;
import android.graphics.Point;
import android.provider.DeviceConfig;
import android.util.AttributeSet;
import android.util.Slog;
import android.util.TypedValue;
import android.view.View;
import android.widget.ScrollView;
import com.android.server.autofill.Helper;

/* JADX INFO: loaded from: classes.dex */
public class CustomScrollView extends ScrollView {
    public static final String DEVICE_CONFIG_SAVE_DIALOG_LANDSCAPE_BODY_HEIGHT_MAX_PERCENT = "autofill_save_dialog_landscape_body_height_max_percent";
    public static final String DEVICE_CONFIG_SAVE_DIALOG_PORTRAIT_BODY_HEIGHT_MAX_PERCENT = "autofill_save_dialog_portrait_body_height_max_percent";
    private static final String TAG = "CustomScrollView";
    private int mAttrBasedMaxHeightPercent;
    private int mHeight;
    private int mMaxLandscapeBodyHeightPercent;
    private int mMaxPortraitBodyHeightPercent;
    private int mWidth;

    public CustomScrollView(Context context) {
        super(context);
        this.mWidth = -1;
        this.mHeight = -1;
        setMaxBodyHeightPercent(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mWidth = -1;
        this.mHeight = -1;
        setMaxBodyHeightPercent(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mWidth = -1;
        this.mHeight = -1;
        setMaxBodyHeightPercent(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mWidth = -1;
        this.mHeight = -1;
        setMaxBodyHeightPercent(context);
    }

    private void setMaxBodyHeightPercent(Context context) {
        this.mAttrBasedMaxHeightPercent = getAttrBasedMaxHeightPercent(context);
        this.mMaxPortraitBodyHeightPercent = DeviceConfig.getInt("autofill", DEVICE_CONFIG_SAVE_DIALOG_PORTRAIT_BODY_HEIGHT_MAX_PERCENT, this.mAttrBasedMaxHeightPercent);
        this.mMaxLandscapeBodyHeightPercent = DeviceConfig.getInt("autofill", DEVICE_CONFIG_SAVE_DIALOG_LANDSCAPE_BODY_HEIGHT_MAX_PERCENT, this.mAttrBasedMaxHeightPercent);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() != 0) goto L6;
        Slog.e(TAG, "no children");
        return;
    L6:
        this.mWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        calculateDimensions();
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    private void calculateDimensions() {
        if (this.mHeight == (-1)) goto L5;
        return;
    L5:
        Point point = new Point();
        Context context = getContext();
        context.getDisplayNoVerify().getSize(point);
        View content = getChildAt(0);
        int contentHeight = content.getMeasuredHeight();
        int displayHeight = point.y;
        if (getResources().getConfiguration().orientation != 2) goto L8;
        int maxHeight = (this.mMaxLandscapeBodyHeightPercent * displayHeight) / 100;
    L9:
        this.mHeight = Math.min(contentHeight, maxHeight);
        if (Helper.sDebug == false) goto L13;
        Slog.d(TAG, "calculateDimensions(): mMaxPortraitBodyHeightPercent=" + this.mMaxPortraitBodyHeightPercent + ", mMaxLandscapeBodyHeightPercent=" + this.mMaxLandscapeBodyHeightPercent + ", mAttrBasedMaxHeightPercent=" + this.mAttrBasedMaxHeightPercent + ", maxHeight=" + maxHeight + ", contentHeight=" + contentHeight + ", w=" + this.mWidth + ", h=" + this.mHeight);
        return;
    L13:
        return;
    L8:
        maxHeight = (this.mMaxPortraitBodyHeightPercent * displayHeight) / 100;
        goto L9
    }

    private int getAttrBasedMaxHeightPercent(Context context) {
        TypedValue maxHeightAttrTypedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.^attr-private.autofillSaveCustomSubtitleMaxHeight, maxHeightAttrTypedValue, true);
        return (int) maxHeightAttrTypedValue.getFraction(100.0f, 100.0f);
    }
}
