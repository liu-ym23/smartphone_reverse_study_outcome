package com.baidu.mapapi.util;

import android.text.TextUtils;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.util.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class EncryptSpatialRelationUtil {
    private static boolean a(LatLng latLng, String str, EncodePointType encodePointType) {
        ArrayList<LatLng> arrayList;
        if (encodePointType == null) {
            return false;
        }
        ArrayList<LatLng> arrayListA = g.a().a(str, encodePointType.ordinal());
        if (arrayListA == null || arrayListA.size() == 0 || latLng == null) {
            return false;
        }
        for (int i4 = 0; i4 < arrayListA.size(); i4++) {
            if (latLng.longitude == arrayListA.get(i4).longitude && latLng.latitude == arrayListA.get(i4).latitude) {
                return true;
            }
        }
        int size = arrayListA.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            LatLng latLng2 = arrayListA.get(i5);
            i5++;
            LatLng latLng3 = arrayListA.get(i5 % size);
            double d4 = latLng2.latitude;
            double d5 = latLng3.latitude;
            if (d4 != d5 && latLng.latitude >= Math.min(d4, d5) && latLng.latitude < Math.max(latLng2.latitude, latLng3.latitude)) {
                double d6 = latLng.latitude;
                double d7 = latLng2.latitude;
                double d8 = latLng3.longitude;
                arrayList = arrayListA;
                double d9 = latLng2.longitude;
                double d10 = (((d8 - d9) * (d6 - d7)) / (latLng3.latitude - d7)) + d9;
                double d11 = latLng.longitude;
                if (d10 == d11) {
                    return true;
                }
                if (d10 < d11) {
                    i6++;
                }
            } else {
                arrayList = arrayListA;
            }
            arrayListA = arrayList;
        }
        return i6 % 2 == 1;
    }

    public static boolean isEncodedGeoPointsContainsPoint(LatLng latLng, String str, EncodePointType encodePointType) {
        if (latLng == null || TextUtils.isEmpty(str) || encodePointType == null) {
            return false;
        }
        return a(latLng, str, encodePointType);
    }
}
