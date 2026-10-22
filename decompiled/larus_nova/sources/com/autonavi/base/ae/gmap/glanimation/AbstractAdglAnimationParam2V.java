package com.autonavi.base.ae.gmap.glanimation;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes39.dex */
public class AbstractAdglAnimationParam2V extends AbstractAdglAnimationParam {
    public double fromXValue;
    public double fromYValue;
    public double toXValue;
    public double toYValue;

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue == true) goto L5;
    L11:
        this.hasCheckedParam = true;
        return;
    L5:
        if (this.hasToValue == false) goto L11;
        double r100 = this.toXValue - this.fromXValue;
        double r101 = this.toYValue - this.fromYValue;
        if (Math.abs(r100) <= 1.0E-4d) goto L9;
    L10:
        this.needToCaculate = true;
        goto L11
    L9:
        if (Math.abs(r101) <= 1.0E-4d) goto L11;
        goto L10
    }

    public double getCurXValue() {
        double r100 = this.fromXValue;
        return r100 + ((this.toXValue - r100) * ((double) this.mult));
    }

    public double getCurYValue() {
        double r100 = this.fromYValue;
        return r100 + ((this.toYValue - r100) * ((double) this.mult));
    }

    public AbstractAdglAnimationParam2V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromXValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.toXValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.fromYValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.toYValue = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public double getFromXValue() {
        return this.fromXValue;
    }

    public double getFromYValue() {
        return this.fromYValue;
    }

    public double getToXValue() {
        return this.toXValue;
    }

    public double getToYValue() {
        return this.toYValue;
    }

    public void setFromValue(double r100, double r101) {
        this.fromXValue = r100;
        this.fromYValue = r101;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(double r100, double r101) {
        this.toXValue = r100;
        this.toYValue = r101;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
