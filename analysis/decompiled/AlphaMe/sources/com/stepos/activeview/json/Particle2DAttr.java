package com.stepos.activeview.json;

import android.content.Context;
import com.stepos.activeview.utils.DisplayUnitUtil;
import java.util.List;

/* loaded from: classes.dex */
public class Particle2DAttr {
    private static final int ARRAY_LENGTH_2 = 2;
    private String bitmapPath;
    private int[] colors;
    private List<String> heights;
    private String id;
    private float[] mHeightValues;
    private Float mRegionRadiusValue;
    private float[] mWidthValues;
    private String[] offset;
    private String[] position;
    private String[] randomSpeed;
    private String regionRadius;
    private Float[] scale;
    private String[] speed;
    private String[] translation;
    private Integer transmitCycle;
    private Integer transmitNum;
    private String type;
    private List<String> widths;
    private Float[] mPositionValue = new Float[2];
    private Float[] mTranslationValue = new Float[2];
    private Float[] mSpeedValue = new Float[2];
    private Float[] mRandomSpeedValue = new Float[2];
    private Float[] mOffsetValue = new Float[2];

    public String getBitmapPath() {
        return this.bitmapPath;
    }

    public int[] getColors() {
        return this.colors;
    }

    public float[] getHeightValues(Context context) {
        int size;
        List<String> list = this.heights;
        if (list != null && !list.isEmpty() && (size = this.heights.size()) > 0) {
            this.mHeightValues = new float[size];
            for (int i4 = 0; i4 < size; i4++) {
                String str = this.heights.get(i4);
                if (str != null && !str.isEmpty()) {
                    this.mHeightValues[i4] = DisplayUnitUtil.getPixelValue(context, str);
                }
            }
        }
        return this.mHeightValues;
    }

    public List<String> getHeights() {
        return this.heights;
    }

    public String getId() {
        return this.id;
    }

    public String[] getOffset() {
        return this.offset;
    }

    public Float[] getOffsetValue(Context context) {
        String[] strArr = this.offset;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.offset[i4] != null) {
                    this.mOffsetValue[i4] = Float.valueOf(DisplayUnitUtil.getPixelValue(context, r2));
                }
            }
        }
        return this.mOffsetValue;
    }

    public String[] getPosition() {
        return this.position;
    }

    public Float[] getPositionValue(Context context) {
        String[] strArr = this.position;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.position[i4] != null) {
                    this.mPositionValue[i4] = Float.valueOf(DisplayUnitUtil.getPixelValue(context, r2));
                }
            }
        }
        return this.mPositionValue;
    }

    public String[] getRandomSpeed() {
        return this.randomSpeed;
    }

    public Float[] getRandomSpeedValue(Context context) {
        String[] strArr = this.randomSpeed;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.randomSpeed[i4] != null) {
                    this.mRandomSpeedValue[i4] = Float.valueOf(DisplayUnitUtil.getPixelValue(context, r2));
                }
            }
        }
        return this.mRandomSpeedValue;
    }

    public String getRegionRadius() {
        return this.regionRadius;
    }

    public Float getRegionRadiusValue(Context context) {
        String str = this.regionRadius;
        if (str != null && !str.isEmpty()) {
            this.mRegionRadiusValue = Float.valueOf(DisplayUnitUtil.getPixelValue(context, this.regionRadius));
        }
        return this.mRegionRadiusValue;
    }

    public Float[] getScale() {
        return this.scale;
    }

    public String[] getSpeed() {
        return this.speed;
    }

    public Float[] getSpeedValue(Context context) {
        String[] strArr = this.speed;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.speed[i4] != null) {
                    this.mSpeedValue[i4] = Float.valueOf(DisplayUnitUtil.getPixelValue(context, r2));
                }
            }
        }
        return this.mSpeedValue;
    }

    public String[] getTranslation() {
        return this.translation;
    }

    public Float[] getTranslationValue() {
        String[] strArr = this.translation;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                String str = this.translation[i4];
                if (str != null) {
                    this.mTranslationValue[i4] = Float.valueOf(Float.parseFloat(str.substring(0, str.length() - 2)));
                }
            }
        }
        return this.mTranslationValue;
    }

    public Integer getTransmitCycle() {
        return this.transmitCycle;
    }

    public Integer getTransmitNum() {
        return this.transmitNum;
    }

    public String getType() {
        return this.type;
    }

    public float[] getWidthValues(Context context) {
        int size;
        List<String> list = this.widths;
        if (list != null && !list.isEmpty() && (size = this.widths.size()) > 0) {
            this.mWidthValues = new float[size];
            for (int i4 = 0; i4 < size; i4++) {
                String str = this.widths.get(i4);
                if (str != null && !str.isEmpty()) {
                    this.mWidthValues[i4] = DisplayUnitUtil.getPixelValue(context, str);
                }
            }
        }
        return this.mWidthValues;
    }

    public List<String> getWidths() {
        return this.widths;
    }

    public void setBitmapPath(String str) {
        this.bitmapPath = str;
    }

    public void setColors(int[] iArr) {
        this.colors = iArr;
    }

    public void setHeights(List<String> list) {
        this.heights = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setOffset(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.offset = strArr;
    }

    public void setPosition(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.position = strArr;
    }

    public void setRandomSpeed(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.randomSpeed = strArr;
    }

    public void setRegionRadius(String str) {
        this.regionRadius = str;
    }

    public void setScale(Float[] fArr) {
        this.scale = fArr;
    }

    public void setSpeed(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.speed = strArr;
    }

    public void setTranslation(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.translation = strArr;
    }

    public void setTransmitCycle(Integer num) {
        this.transmitCycle = num;
    }

    public void setTransmitNum(Integer num) {
        this.transmitNum = num;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setWidths(List<String> list) {
        this.widths = list;
    }
}
