package com.android.server.input.debug;

import android.R;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.TextView;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class RotaryInputValueView extends TextView {
    private static final ColorFilter ACTIVE_BACKGROUND_FILTER = null;
    private static final int ACTIVE_STATUS_DURATION = 250;
    private static final int ACTIVE_TEXT_COLOR = -12447960;
    private static final int INACTIVE_TEXT_COLOR = -65281;
    private static final int SIDE_PADDING_SP = 4;
    private static final int TEXT_SIZE_SP = 8;
    private final Locale mDefaultLocale;
    private final float mScaledVerticalScrollFactor;
    private final Runnable mUpdateActivityStatusCallback;

    public static /* synthetic */ void $r8$lambda$B6RdSSuJJVeyj3e7V7l7fG73QmU(RotaryInputValueView r0) {
        r0.lambda$new$0();
    }

    static {
        ACTIVE_BACKGROUND_FILTER = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 200.0f});
    }

    private /* synthetic */ void lambda$new$0() {
        updateActivityStatus(false);
    }

    public RotaryInputValueView(Context c) {
        super(c);
        this.mUpdateActivityStatusCallback = new RotaryInputValueView$$ExternalSyntheticLambda0(this);
        this.mDefaultLocale = Locale.getDefault();
        DisplayMetrics dm = ((TextView) this).mContext.getResources().getDisplayMetrics();
        this.mScaledVerticalScrollFactor = ViewConfiguration.get(c).getScaledVerticalScrollFactor();
        setText(getFormattedValue(0.0f));
        setTextColor(INACTIVE_TEXT_COLOR);
        setTextSize(applyDimensionSp(8, dm));
        setPaddingRelative(applyDimensionSp(4, dm), 0, applyDimensionSp(4, dm), 0);
        setTypeface(null, 1);
        setBackgroundResource(R.drawable.ic_menu_invite);
    }

    public void updateValue(float value) {
        removeCallbacks(this.mUpdateActivityStatusCallback);
        setText(getFormattedValue(this.mScaledVerticalScrollFactor * value));
        updateActivityStatus(true);
        postDelayed(this.mUpdateActivityStatusCallback, 250);
    }

    public void updateActivityStatus(boolean active) {
        if (active == false) goto L4;
        setTextColor(ACTIVE_TEXT_COLOR);
        getBackground().setColorFilter(ACTIVE_BACKGROUND_FILTER);
        return;
    L4:
        setTextColor(INACTIVE_TEXT_COLOR);
        getBackground().clearColorFilter();
    }

    private String getFormattedValue(float value) {
        Locale r0 = this.mDefaultLocale;
        if (value >= 0.0f) goto L5;
        String r1 = "-";
    L7:
        return String.format(r0, "%s%.1f", new Object[]{r1, Float.valueOf(Math.abs(value))});
    L5:
        r1 = "+";
        goto L7
    }

    private static int applyDimensionSp(int dimensionSp, DisplayMetrics dm) {
        return (int) TypedValue.applyDimension(2, dimensionSp, dm);
    }
}
