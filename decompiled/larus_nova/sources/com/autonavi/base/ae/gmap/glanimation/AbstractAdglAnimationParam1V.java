package com.autonavi.base.ae.gmap.glanimation;

/* JADX INFO: loaded from: classes39.dex */
public class AbstractAdglAnimationParam1V extends AbstractAdglAnimationParam {
    private float fromValue;
    private float toValue;

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue == true) goto L5;
    L9:
        this.hasCheckedParam = true;
        return;
    L5:
        if (this.hasToValue == false) goto L9;
        if (Math.abs(this.toValue - this.fromValue) <= 1.0E-4d) goto L9;
        this.needToCaculate = true;
        goto L9
    }

    public float getCurValue() {
        float r100 = this.fromValue;
        return r100 + ((this.toValue - r100) * this.mult);
    }

    public AbstractAdglAnimationParam1V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromValue = 0.0f;
        this.toValue = 0.0f;
    }

    public float getFromValue() {
        return this.fromValue;
    }

    public float getToValue() {
        return this.toValue;
    }

    public void setFromValue(float r100) {
        this.fromValue = r100;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(float r100) {
        this.toValue = r100;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
