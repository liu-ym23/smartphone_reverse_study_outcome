package com.stepos.activeview.json;

import android.content.Context;
import com.stepos.activeview.utils.DisplayUnitUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Animation {
    private static final int ANIMATION_2D_ARRAY_LENGTH = 2;
    private static final int ANIMATION_3D_ARRAY_LENGTH = 3;
    private ApertureData aperture;
    private Float blur;
    private int duration;
    private String elementId;
    private String id;
    private Interpolator interpolator;
    private List<float[]> mTrackPathValue;
    private String name;
    private Integer opacity;
    private boolean repeat;
    private int repeatCount;
    private float repeatDelay;
    private String repeatMode;
    private int startTime;
    private List<Float[]> trackPath;
    private String trackPointUnit;
    private String[] transform2d;
    private String type;
    private WaveData wave;
    private Float[] transform2dValue = new Float[2];
    private Float[] rotate3d = new Float[3];
    private String[] rotateCenter = new String[2];
    private Float[] rotateCenterValue = new Float[2];
    private Float[] scale2d = new Float[2];

    public ApertureData getAperture() {
        return this.aperture;
    }

    public Float getBlur() {
        return this.blur;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getElementId() {
        return this.elementId;
    }

    public String getId() {
        return this.id;
    }

    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    public String getName() {
        return this.name;
    }

    public Integer getOpacity() {
        return this.opacity;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public float getRepeatDelay() {
        return this.repeatDelay;
    }

    public String getRepeatMode() {
        return this.repeatMode;
    }

    public Float[] getRotate3d() {
        return this.rotate3d;
    }

    public String[] getRotateCenter() {
        return this.rotateCenter;
    }

    public Float[] getRotateCenterValue(Context context) {
        String[] strArr = this.rotateCenter;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.rotateCenter[i4] != null) {
                    this.rotateCenterValue[i4] = Float.valueOf(DisplayUnitUtil.getPixelValue(context, r2));
                }
            }
        }
        return this.rotateCenterValue;
    }

    public Float[] getScale2d() {
        return this.scale2d;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public List<Float[]> getTrackPath() {
        return this.trackPath;
    }

    public List<float[]> getTrackPathValue(Context context) {
        if (this.mTrackPathValue == null && this.trackPath != null) {
            this.mTrackPathValue = new ArrayList();
            int size = this.trackPath.size();
            for (int i4 = 0; i4 < size; i4++) {
                float[] fArr = {this.trackPath.get(i4)[0].floatValue(), this.trackPath.get(i4)[1].floatValue()};
                if (this.trackPointUnit != null) {
                    fArr[0] = DisplayUnitUtil.getPixelValue(context, r4, fArr[0]);
                    fArr[1] = DisplayUnitUtil.getPixelValue(context, this.trackPointUnit, fArr[1]);
                }
                this.mTrackPathValue.add(fArr);
            }
        }
        return this.mTrackPathValue;
    }

    public String getTrackPointUnit() {
        return this.trackPointUnit;
    }

    public String[] getTransform2d() {
        return this.transform2d;
    }

    public Float[] getTransform2dValue(Context context) {
        String[] strArr = this.transform2d;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.transform2d[i4] != null) {
                    this.transform2dValue[i4] = Float.valueOf(DisplayUnitUtil.getPixelValue(context, r2));
                }
            }
        }
        return this.transform2dValue;
    }

    public String getType() {
        return this.type;
    }

    public WaveData getWave() {
        return this.wave;
    }

    public boolean isRepeat() {
        return this.repeat;
    }

    public void setAperture(ApertureData apertureData) {
        this.aperture = apertureData;
    }

    public void setBlur(Float f4) {
        this.blur = f4;
    }

    public void setDuration(int i4) {
        this.duration = i4;
    }

    public void setElementId(String str) {
        this.elementId = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpacity(Integer num) {
        this.opacity = num;
    }

    public void setRepeat(boolean z4) {
        this.repeat = z4;
    }

    public void setRepeatCount(int i4) {
        this.repeatCount = i4;
    }

    public void setRepeatDelay(float f4) {
        this.repeatDelay = f4;
    }

    public void setRepeatMode(String str) {
        this.repeatMode = str;
    }

    public void setRotate3d(Float[] fArr) {
        this.rotate3d = fArr;
    }

    public void setRotateCenter(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.rotateCenter = strArr;
    }

    public void setScale2d(Float[] fArr) {
        this.scale2d = fArr;
    }

    public void setStartTime(int i4) {
        this.startTime = i4;
    }

    public void setTrackPath(List<Float[]> list) {
        this.trackPath = list;
    }

    public void setTrackPointUnit(String str) {
        this.trackPointUnit = str;
    }

    public void setTransform2d(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.transform2d = strArr;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setWave(WaveData waveData) {
        this.wave = waveData;
    }
}
