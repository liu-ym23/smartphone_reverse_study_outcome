package com.stepos.activeview.json;

import android.content.Context;
import android.graphics.Color;
import com.stepos.activeview.utils.DisplayUnitUtil;

/* loaded from: classes.dex */
public class Style {
    private String background;
    private String border;
    private int colorPrimary;
    private String height;
    private int mBackgroundColorValue;
    private float mBorderValue;
    private float mHeightValue;
    private float mRadiusValue;
    private float mWidthValue;
    private String radius;
    private String width;

    public String getBackground() {
        return this.background;
    }

    public int getBackgroundColorValue() {
        String str = this.background;
        if (str != null && !str.isEmpty()) {
            this.mBackgroundColorValue = Color.parseColor(this.background);
        }
        return this.mBackgroundColorValue;
    }

    public String getBorder() {
        return this.border;
    }

    public float getBorderValue() {
        String str = this.border;
        if (str != null && !str.isEmpty()) {
            this.mBorderValue = Float.parseFloat(this.border.substring(0, r0.length() - 2));
        }
        return this.mBorderValue;
    }

    public int getColorPrimary() {
        return this.colorPrimary;
    }

    public String getHeight() {
        return this.height;
    }

    public float getHeightValue(Context context) {
        String str = this.height;
        if (str != null && !str.isEmpty()) {
            this.mHeightValue = DisplayUnitUtil.getPixelValue(context, this.height);
        }
        return this.mHeightValue;
    }

    public String getRadius() {
        return this.radius;
    }

    public float getRadiusValue() {
        String str = this.radius;
        if (str != null && !str.isEmpty()) {
            this.mRadiusValue = Float.parseFloat(this.radius.substring(0, r0.length() - 2));
        }
        return this.mRadiusValue;
    }

    public String getWidth() {
        return this.width;
    }

    public float getWidthValue(Context context) {
        String str = this.width;
        if (str != null && !str.isEmpty()) {
            this.mWidthValue = DisplayUnitUtil.getPixelValue(context, this.width);
        }
        return this.mWidthValue;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setBorder(String str) {
        this.border = str;
    }

    public void setColorPrimary(int i4) {
        this.colorPrimary = i4;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setRadius(String str) {
        this.radius = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }
}
