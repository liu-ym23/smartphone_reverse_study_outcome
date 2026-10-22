package com.baidu.mapapi.utils;

import androidx.camera.video.AudioStats;
import com.baidu.mapapi.model.LatLng;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class AreaUtil {
    public AreaUtil() {
    }

    public static double calculateArea(List<LatLng> r110) {
        double r100 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r110 != null) goto L5;
    L12:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (r110.size() < 3) goto L12;
        int r101 = r110.size();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L11;
        LatLng r103 = (LatLng) ListProtector.get(r110, r102);
        r102 = r102 + 1;
        LatLng r104 = (LatLng) ListProtector.get(r110, r102 % r101);
        r100 = r100 + ((((r103.longitude * 111319.49079327358d) * Math.cos(r103.latitude * 0.017453292519943295d)) * (r104.latitude * 111319.49079327358d)) - ((r103.latitude * 111319.49079327358d) * ((r104.longitude * 111319.49079327358d) * Math.cos(r104.latitude * 0.017453292519943295d))));
        goto L8
    L11:
        return (float) Math.abs(r100 / 2.0d);
    }

    public static double calculateArea(LatLng r100, LatLng r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        LatLng r102 = new LatLng(r100.latitude, r101.longitude);
        double r103 = DistanceUtil.getDistance(r102, r101);
        double r104 = DistanceUtil.getDistance(r100, r102);
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        if (r104 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        return r103 * r104;
    L13:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
