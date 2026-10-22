package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public abstract class Overlay {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f33120id;
    public long mLayerID;
    public int mType;

    public Overlay() {
        this.f33120id = System.currentTimeMillis() + "_" + hashCode();
    }

    public static void putColorInfoIntoBundle(int r100, Bundle r101) {
        Bundle r102 = new Bundle();
        r102.putFloat("red", ((r100 >> 16) & 255) / 255.0f);
        r102.putFloat("green", ((r100 >> 8) & 255) / 255.0f);
        r102.putFloat("blue", (r100 & 255) / 255.0f);
        r102.putFloat("alpha", (r100 >>> 24) / 255.0f);
        r101.putBundle("color", r102);
    }

    public static void putPointsInfoIntoBundle(List<GeoPoint> r100, Bundle r101) {
        int r102 = r100.size();
        double[] r103 = new double[r102];
        double[] r104 = new double[r102];
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        GeoPoint r106 = l.a((GeoPoint) ListProtector.get(r100, r105));
        r103[r105] = r106.getLongitude();
        r104[r105] = r106.getLatitude();
        r105 = r105 + 1;
        goto L3
    L5:
        r101.putDoubleArray("x_array", r103);
        r101.putDoubleArray("y_array", r104);
    }
}
