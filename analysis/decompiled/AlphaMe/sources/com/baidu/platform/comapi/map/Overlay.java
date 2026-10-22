package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Overlay {
    public String id = System.currentTimeMillis() + "_" + hashCode();
    public long mLayerID;
    public int mType;

    public static void putColorInfoIntoBundle(int i4, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i4 >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i4 >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i4 & 255) / 255.0f);
        bundle2.putFloat(ViewTweenItem.ALPHA, (i4 >>> 24) / 255.0f);
        bundle.putBundle("color", bundle2);
    }

    public static void putPointsInfoIntoBundle(List<GeoPoint> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i4 = 0; i4 < size; i4++) {
            GeoPoint geoPointA = l.a(list.get(i4));
            dArr[i4] = geoPointA.getLongitude();
            dArr2[i4] = geoPointA.getLatitude();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }
}
