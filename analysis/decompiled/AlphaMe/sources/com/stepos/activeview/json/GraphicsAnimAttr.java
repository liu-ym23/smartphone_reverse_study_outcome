package com.stepos.activeview.json;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GraphicsAnimAttr {
    private String bitmapPath;
    private String className;
    private int[] colorList;
    private String id;
    private List<Float> mParticleHeightValues;
    private List<Float> mParticleWidthValues;
    private Float mRandomSpeedXValue;
    private Float mRandomSpeedYValue;
    private Float mRandomXValue;
    private Float mRandomYValue;
    private Float mRegionRadiusValue;
    private Float mSpeedXValue;
    private Float mSpeedYValue;
    private Float mTranslationXValue;
    private Float mTranslationYValue;
    private Float mXValue;
    private Float mYValue;
    private List<String> particleHeight;
    private List<String> particleWidth;
    private String randomSpeedX;
    private String randomSpeedY;
    private String randomX;
    private String randomY;
    private String regionRadius;
    private Float scaleX;
    private Float scaleY;
    private String speedX;
    private String speedY;
    private String translationX;
    private String translationY;
    private Integer transmitCycle;
    private Integer transmitNum;
    private String type;

    /* renamed from: x, reason: collision with root package name */
    private String f11176x;

    /* renamed from: y, reason: collision with root package name */
    private String f11177y;

    public String getBitmapPath() {
        return this.bitmapPath;
    }

    public String getClassName() {
        return this.className;
    }

    public int[] getColorList() {
        return this.colorList;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getParticleHeight() {
        return this.particleHeight;
    }

    public List getParticleHeightValue() {
        int size;
        List<String> list = this.particleHeight;
        if (list != null && !list.isEmpty() && (size = this.particleHeight.size()) > 0) {
            this.mParticleHeightValues = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                String str = this.particleHeight.get(i4);
                if (str != null && !str.isEmpty()) {
                    this.mParticleHeightValues.add(Float.valueOf(Float.parseFloat(str.substring(0, str.length() - 2))));
                }
            }
        }
        return this.mParticleHeightValues;
    }

    public List<String> getParticleWidth() {
        return this.particleWidth;
    }

    public List getParticleWidthValue() {
        int size;
        List<String> list = this.particleWidth;
        if (list != null && !list.isEmpty() && (size = this.particleWidth.size()) > 0) {
            this.mParticleWidthValues = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                String str = this.particleWidth.get(i4);
                if (str != null && !str.isEmpty()) {
                    this.mParticleWidthValues.add(Float.valueOf(Float.parseFloat(str.substring(0, str.length() - 2))));
                }
            }
        }
        return this.mParticleWidthValues;
    }

    public String getRandomSpeedX() {
        return this.randomSpeedX;
    }

    public Float getRandomSpeedXValue() {
        String str = this.randomSpeedX;
        if (str != null && !str.isEmpty()) {
            this.mRandomSpeedXValue = Float.valueOf(Float.parseFloat(this.randomSpeedX.substring(0, r0.length() - 2)));
        }
        return this.mRandomSpeedXValue;
    }

    public String getRandomSpeedY() {
        return this.randomSpeedY;
    }

    public Float getRandomSpeedYValue() {
        String str = this.randomSpeedY;
        if (str != null && !str.isEmpty()) {
            this.mRandomSpeedYValue = Float.valueOf(Float.parseFloat(this.randomSpeedY.substring(0, r0.length() - 2)));
        }
        return this.mRandomSpeedYValue;
    }

    public String getRandomX() {
        return this.randomX;
    }

    public Float getRandomXValue() {
        String str = this.randomX;
        if (str != null && !str.isEmpty()) {
            this.mRandomXValue = Float.valueOf(Float.parseFloat(this.randomX.substring(0, r0.length() - 2)));
        }
        return this.mRandomXValue;
    }

    public String getRandomY() {
        return this.randomY;
    }

    public Float getRandomYValue() {
        String str = this.randomY;
        if (str != null && !str.isEmpty()) {
            this.mRandomYValue = Float.valueOf(Float.parseFloat(this.randomY.substring(0, r0.length() - 2)));
        }
        return this.mRandomYValue;
    }

    public String getRegionRadius() {
        return this.regionRadius;
    }

    public Float getScaleX() {
        return this.scaleX;
    }

    public Float getScaleY() {
        return this.scaleY;
    }

    public String getSpeedX() {
        return this.speedX;
    }

    public Float getSpeedXValue() {
        String str = this.speedX;
        if (str != null && !str.isEmpty()) {
            this.mSpeedXValue = Float.valueOf(Float.parseFloat(this.speedX.substring(0, r0.length() - 2)));
        }
        return this.mSpeedXValue;
    }

    public String getSpeedY() {
        return this.speedY;
    }

    public Float getSpeedYValue() {
        String str = this.speedY;
        if (str != null && !str.isEmpty()) {
            this.mSpeedYValue = Float.valueOf(Float.parseFloat(this.speedY.substring(0, r0.length() - 2)));
        }
        return this.mSpeedYValue;
    }

    public String getTranslationX() {
        return this.translationX;
    }

    public Float getTranslationXValue() {
        String str = this.translationX;
        if (str != null && !str.isEmpty()) {
            this.mTranslationXValue = Float.valueOf(Float.parseFloat(this.translationX.substring(0, r0.length() - 2)));
        }
        return this.mTranslationXValue;
    }

    public String getTranslationY() {
        return this.translationY;
    }

    public Float getTranslationYValue() {
        String str = this.translationY;
        if (str != null && !str.isEmpty()) {
            this.mTranslationYValue = Float.valueOf(Float.parseFloat(this.translationY.substring(0, r0.length() - 2)));
        }
        return this.mTranslationYValue;
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

    public String getX() {
        return this.f11176x;
    }

    public Float getXValue() {
        String str = this.f11176x;
        if (str != null && !str.isEmpty()) {
            this.mXValue = Float.valueOf(Float.parseFloat(this.f11176x.substring(0, r0.length() - 2)));
        }
        return this.mXValue;
    }

    public String getY() {
        return this.f11177y;
    }

    public Float getYValue() {
        String str = this.f11177y;
        if (str != null && !str.isEmpty()) {
            this.mYValue = Float.valueOf(Float.parseFloat(this.f11177y.substring(0, r0.length() - 2)));
        }
        return this.mYValue;
    }

    public Float getmRandomSpeedYValue() {
        String str = this.randomSpeedY;
        if (str != null && !str.isEmpty()) {
            this.mRandomSpeedYValue = Float.valueOf(Float.parseFloat(this.randomSpeedY.substring(0, r0.length() - 2)));
        }
        return this.mRandomSpeedYValue;
    }

    public void setBitmapPath(String str) {
        this.bitmapPath = str;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setColorList(int[] iArr) {
        this.colorList = iArr;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setParticleHeight(List<String> list) {
        this.particleHeight = list;
    }

    public void setParticleWidth(List<String> list) {
        this.particleWidth = list;
    }

    public void setRandomSpeedX(String str) {
        this.randomSpeedX = str;
    }

    public void setRandomSpeedY(String str) {
        this.randomSpeedY = str;
    }

    public void setRandomX(String str) {
        this.randomX = str;
    }

    public void setRandomY(String str) {
        this.randomY = str;
    }

    public void setRegionRadius(String str) {
        this.regionRadius = str;
    }

    public void setScaleX(Float f4) {
        this.scaleX = f4;
    }

    public void setScaleY(Float f4) {
        this.scaleY = f4;
    }

    public void setSpeedX(String str) {
        this.speedX = str;
    }

    public void setSpeedY(String str) {
        this.speedY = str;
    }

    public void setTranslationX(String str) {
        this.translationX = str;
    }

    public void setTranslationY(String str) {
        this.translationY = str;
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

    public void setX(String str) {
        this.f11176x = str;
    }

    public void setY(String str) {
        this.f11177y = str;
    }
}
