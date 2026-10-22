package com.baidu.mapapi.map;

import android.graphics.Point;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: loaded from: classes39.dex */
public class WeightedLatLng extends e.a {
    public static final double DEFAULT_INTENSITY = 1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Point f31558a;
    public final double intensity;
    public final LatLng mLatLng;

    public double getIntensity() {
        return this.intensity;
    }

    @Override // com.baidu.mapapi.map.e.a
    public Point getPoint() {
        return this.f31558a;
    }

    public WeightedLatLng(LatLng r100) {
        this(r100, 1.0d);
    }

    public WeightedLatLng(LatLng r100, double r101) {
        if (r100 == null) goto L10;
        this.mLatLng = r100;
        GeoPoint r102 = CoordUtil.ll2mc(r100);
        this.f31558a = new Point((int) r102.getLongitudeE6(), (int) r102.getLatitudeE6());
        if (r101 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        this.intensity = r101;
        return;
    L7:
        this.intensity = 1.0d;
        return;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: latLng can not be null");
    }
}
