package com.amap.api.maps.model;

import androidx.camera.video.AudioStats;
import com.amap.api.mapcore.util.w3;
import com.autonavi.amap.mapcore.DPoint;

/* JADX INFO: loaded from: classes28.dex */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public DPoint getPoint() {
        return this.mPoint;
    }

    public WeightedLatLng(LatLng r100) {
        this(r100, 1.0d);
    }

    public WeightedLatLng(LatLng r100, double r101) {
        if (r100 == null) goto L10;
        this.latLng = r100;
        this.mPoint = w3.a(r100);
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        this.intensity = r101;
        return;
    L7:
        this.intensity = 1.0d;
        return;
    L10:
        throw new IllegalArgumentException("latLng can not null");
    }
}
