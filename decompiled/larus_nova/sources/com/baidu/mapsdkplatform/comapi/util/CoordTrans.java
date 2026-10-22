package com.baidu.mapsdkplatform.comapi.util;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;

/* JADX INFO: loaded from: classes39.dex */
public class CoordTrans {
    public CoordTrans() {
    }

    public static LatLng baiduToGcj(LatLng r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        double[] r101 = JNITools.baiduToGcj(r100.latitude, r100.longitude);
        if (r101 != null) goto L9;
        return null;
    L9:
        return new LatLng(r101[0], r101[1]);
    }

    public static LatLng gcjToBaidu(LatLng r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        double[] r101 = JNITools.gcjToBaidu(r100.latitude, r100.longitude);
        if (r101 != null) goto L9;
        return null;
    L9:
        return new LatLng(r101[0], r101[1]);
    }

    public static LatLng wgsToBaidu(LatLng r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        double[] r101 = JNITools.wgsToBaidu(r100.latitude, r100.longitude);
        if (r101 != null) goto L9;
        return null;
    L9:
        return new LatLng(r101[0], r101[1]);
    }
}
