package com.stepos.activeview.json;

import android.content.Context;
import com.stepos.activeview.utils.DisplayUnitUtil;

/* loaded from: classes.dex */
public class Parameter {
    private static final int PARAMETER_2D_ARRAY_LENGTH = 2;
    private static final int PARAMETER_4D_ARRAY_LENGTH = 4;
    private Float[] angle;
    private int duration;
    private Interpolator interpolator;
    private String[] range;
    private int sensitivity;
    private Float[] rangeValue = new Float[2];
    private Float[] orientationRangeValue = new Float[4];

    public Float[] getAngle() {
        return this.angle;
    }

    public int getDuration() {
        return this.duration;
    }

    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    public Float[] getOrientationRangeValue(Context context) {
        String[] strArr = this.range;
        if (strArr != null && strArr.length == 4) {
            for (int i4 = 0; i4 < 4; i4++) {
                if (this.range[i4] != null) {
                    this.orientationRangeValue[i4] = Float.valueOf(DisplayUnitUtil.getPixelValue(context, r2));
                }
            }
        }
        return this.orientationRangeValue;
    }

    public String[] getRange() {
        return this.range;
    }

    public Float[] getRangeValue(Context context) {
        String[] strArr = this.range;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.range[i4] != null) {
                    this.rangeValue[i4] = Float.valueOf(DisplayUnitUtil.getPixelValue(context, r2));
                }
            }
        }
        return this.rangeValue;
    }

    public int getSensitivity() {
        return this.sensitivity;
    }

    public void setAngle(Float[] fArr) {
        this.angle = fArr;
    }

    public void setDuration(int i4) {
        this.duration = i4;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    public void setRange(String[] strArr) {
        this.range = strArr;
    }

    public void setSensitivity(int i4) {
        this.sensitivity = i4;
    }
}
