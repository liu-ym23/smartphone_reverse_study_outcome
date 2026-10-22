package com.bytedance.android.livesdkapi.imagerecognition;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/imagerecognition/ScaleConfig;", "", "resultImageScale", "", "identifyAreaScaleThreshold", "identifyAreaScale", "identifyAreaSizeThreshold", "", "(FFFI)V", "getIdentifyAreaScale", "()F", "getIdentifyAreaScaleThreshold", "getIdentifyAreaSizeThreshold", "()I", "getResultImageScale", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScaleConfig {
    private final float identifyAreaScale;
    private final float identifyAreaScaleThreshold;
    private final int identifyAreaSizeThreshold;
    private final float resultImageScale;

    public static /* synthetic */ ScaleConfig copy$default(ScaleConfig r100, float r101, float r102, float r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.resultImageScale;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.identifyAreaScaleThreshold;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.identifyAreaScale;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.identifyAreaSizeThreshold;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final float component1() {
        return this.resultImageScale;
    }

    public final float component2() {
        return this.identifyAreaScaleThreshold;
    }

    public final float component3() {
        return this.identifyAreaScale;
    }

    public final int component4() {
        return this.identifyAreaSizeThreshold;
    }

    public final ScaleConfig copy(float r100, float r101, float r102, int r103) {
        return new ScaleConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ScaleConfig) == false) goto L14;
        ScaleConfig r101 = (ScaleConfig) r100;
        if (Float.compare(this.resultImageScale, r101.resultImageScale) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.identifyAreaScaleThreshold, r101.identifyAreaScaleThreshold) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.identifyAreaScale, r101.identifyAreaScale) == 0) goto L12;
        return false;
    L12:
        if (this.identifyAreaSizeThreshold == r101.identifyAreaSizeThreshold) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.resultImageScale) * 31) + Float.floatToIntBits(this.identifyAreaScaleThreshold)) * 31) + Float.floatToIntBits(this.identifyAreaScale)) * 31) + this.identifyAreaSizeThreshold;
    }

    public String toString() {
        return "ScaleConfig(resultImageScale=" + this.resultImageScale + ", identifyAreaScaleThreshold=" + this.identifyAreaScaleThreshold + ", identifyAreaScale=" + this.identifyAreaScale + ", identifyAreaSizeThreshold=" + this.identifyAreaSizeThreshold + ")";
    }

    public final float getIdentifyAreaScale() {
        return this.identifyAreaScale;
    }

    public final float getIdentifyAreaScaleThreshold() {
        return this.identifyAreaScaleThreshold;
    }

    public final int getIdentifyAreaSizeThreshold() {
        return this.identifyAreaSizeThreshold;
    }

    public final float getResultImageScale() {
        return this.resultImageScale;
    }

    public ScaleConfig(float r100, float r101, float r102, int r103) {
        this.resultImageScale = r100;
        this.identifyAreaScaleThreshold = r101;
        this.identifyAreaScale = r102;
        this.identifyAreaSizeThreshold = r103;
    }
}
