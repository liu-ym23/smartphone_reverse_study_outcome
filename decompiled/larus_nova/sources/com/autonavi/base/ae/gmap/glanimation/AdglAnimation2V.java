package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes39.dex */
public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param;

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.curValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        AbstractAdglAnimationParam2V r100 = this.v2Param;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    public AdglAnimation2V(int r100) {
        this.v2Param = null;
        reset();
        this.duration = r100;
        this.curValue1 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.curValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
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
        AbstractAdglAnimationParam2V r103 = this.v2Param;
        if (r103 == null) goto L16;
        r103.setNormalizedTime(r102);
        this.curValue1 = this.v2Param.getCurXValue();
        this.curValue2 = this.v2Param.getCurYValue();
        return;
    L16:
        return;
    L9:
        if (r102 >= 0.0f) goto L12;
        this.isOver = true;
    }

    public double getCurValue(int r100) {
        if (r100 != 0) goto L6;
        return this.curValue1;
    L6:
        return this.curValue2;
    }

    public double getEndValue(int r100) {
        if (r100 != 0) goto L8;
        AbstractAdglAnimationParam2V r101 = this.v2Param;
        if (r101 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r101.getToXValue();
    L8:
        AbstractAdglAnimationParam2V r102 = this.v2Param;
        if (r102 != null) goto L11;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L11:
        return r102.getToYValue();
    }

    public double getStartValue(int r100) {
        if (r100 != 0) goto L8;
        AbstractAdglAnimationParam2V r101 = this.v2Param;
        if (r101 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r101.getFromXValue();
    L8:
        AbstractAdglAnimationParam2V r102 = this.v2Param;
        if (r102 != null) goto L11;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L11:
        return r102.getFromYValue();
    }
}
