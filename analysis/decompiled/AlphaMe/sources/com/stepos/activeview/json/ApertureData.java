package com.stepos.activeview.json;

import android.content.Context;
import com.stepos.activeview.utils.DisplayUnitUtil;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class ApertureData {
    private static final int DOM_2D_ARRAY_LENGTH = 2;
    private String[] location;
    private float[] locationValue = null;

    /* renamed from: r, reason: collision with root package name */
    private Float f11175r;

    public float[] getCenterLocation(Context context, float f4) {
        if (f4 == Property.DEFAULT_FLOAT_VALUE) {
            f4 = 1.0f;
        }
        if (this.locationValue == null) {
            this.locationValue = new float[2];
            String[] strArr = this.location;
            if (strArr != null && strArr.length == 2) {
                for (int i4 = 0; i4 < 2; i4++) {
                    if (this.location[i4] != null) {
                        this.locationValue[i4] = DisplayUnitUtil.getPixelValue(context, r2) / f4;
                    }
                }
            }
        }
        return this.locationValue;
    }

    public String[] getLocation() {
        return this.location;
    }

    public Float getR() {
        return this.f11175r;
    }

    public void setLocation(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.location = strArr;
    }

    public void setR(Float f4) {
        this.f11175r = f4;
    }
}
