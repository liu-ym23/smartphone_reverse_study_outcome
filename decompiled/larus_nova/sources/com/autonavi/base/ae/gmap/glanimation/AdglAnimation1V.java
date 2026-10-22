package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes39.dex */
public class AdglAnimation1V extends AbstractAdglAnimation {
    private float curValue;
    private AbstractAdglAnimationParam1V v1Param;

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        AbstractAdglAnimationParam1V r100 = this.v1Param;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    public float getEndValue() {
        AbstractAdglAnimationParam1V r100 = this.v1Param;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.getToValue();
    }

    public float getStartValue() {
        AbstractAdglAnimationParam1V r100 = this.v1Param;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.getFromValue();
    }

    public float getCurValue() {
        return this.curValue;
    }

    public AdglAnimation1V(int r100) {
        this.v1Param = null;
        reset();
        this.duration = r100;
        this.curValue = 0.0f;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object r100) {
        if (this.isOver == false) goto L5;
        return;
    L5:
        long r101 = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = r101;
        float r102 = r101 / this.duration;
        if (r102 <= 1.0f) goto L9;
        this.isOver = true;
        r102 = 1.0f;
    L12:
        AbstractAdglAnimationParam1V r103 = this.v1Param;
        if (r103 == null) goto L16;
        r103.setNormalizedTime(r102);
        this.curValue = this.v1Param.getCurValue();
        return;
    L16:
        return;
    L9:
        if (r102 >= 0.0f) goto L12;
        this.isOver = true;
    }

    public void setAnimationValue(float r100, float r101, int r102) {
        if (this.v1Param != null) goto L5;
        this.v1Param = new AbstractAdglAnimationParam1V();
    L5:
        this.v1Param.reset();
        this.v1Param.setInterpolatorType(r102, 1.0f);
        this.v1Param.setFromValue(r100);
        this.v1Param.setToValue(r101);
        this.startTime = SystemClock.uptimeMillis();
        this.isOver = false;
    }
}
