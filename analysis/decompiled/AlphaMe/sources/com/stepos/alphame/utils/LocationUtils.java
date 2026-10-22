package com.stepos.alphame.utils;

import android.content.Context;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LocationUtils {
    private static final boolean DEBUG = true;
    private static final String TAG = "LocationUtils";

    public static List<Integer> getActiveGpsUidSets() {
        try {
            ArrayList arrayList = new ArrayList();
            int[] activeGpsUids = PerfBinderHelper.getActiveGpsUids();
            if (activeGpsUids != null) {
                for (int i4 : activeGpsUids) {
                    arrayList.add(Integer.valueOf(i4));
                }
            }
            Log.d(TAG, "runningPackages = " + arrayList);
            return arrayList;
        } catch (Exception e4) {
            AbstractC0351g.B("getActiveGpsUidSets exception: ", e4, TAG);
            return null;
        }
    }

    public static int getLocationMode(Context context) {
        try {
            return PerfBinderHelper.getLocationMode(0);
        } catch (Exception e4) {
            AbstractC0351g.B("getLocationMode exception: ", e4, TAG);
            return 0;
        }
    }

    public static boolean isLocationEnable(Context context) {
        return getLocationMode(context) != 0;
    }

    public static boolean setLocationMode(Context context, int i4) {
        try {
            return PerfBinderHelper.putLocationMode(i4);
        } catch (Exception e4) {
            AbstractC0351g.B("setLocationMode exception: ", e4, TAG);
            return false;
        }
    }
}
