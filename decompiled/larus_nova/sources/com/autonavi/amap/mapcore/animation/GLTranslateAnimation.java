package com.autonavi.amap.mapcore.animation;

import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public class GLTranslateAnimation extends GLAnimation {
    public double mCurXDelta;
    public double mCurYDelta;
    public double mFromXDelta;
    public double mFromYDelta;
    public double mToXDelta;
    public double mToYDelta;

    public GLTranslateAnimation(LatLng r100) {
        this.mFromXDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mFromYDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mToXDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mToYDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mCurXDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mCurYDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mToXDelta = r100.longitude;
        this.mToYDelta = r100.latitude;
    }

    public void setFromPoint(LatLng r100) {
        this.mFromXDelta = r100.longitude;
        this.mFromYDelta = r100.latitude;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float r100, GLTransformation r110) {
        double r101 = this.mFromXDelta;
        this.mCurXDelta = r101;
        double r102 = this.mFromYDelta;
        this.mCurYDelta = r102;
        double r103 = this.mToXDelta;
        if (r101 == r103) goto L5;
        this.mCurXDelta = r101 + ((r103 - r101) * ((double) r100));
    L5:
        double r104 = this.mToYDelta;
        if (r102 == r104) goto L8;
        this.mCurYDelta = r102 + ((r104 - r102) * ((double) r100));
    L8:
        r110.f30023x = this.mCurXDelta;
        r110.f30024y = this.mCurYDelta;
    }
}
