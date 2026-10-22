package com.stepos.alphame.reflect;

import android.content.Context;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.perfbinder.PerfBinderHelper;

/* loaded from: classes.dex */
public class TelephonyManagerStepos {
    public static int getCallState(Context context) {
        try {
            return PerfBinderHelper.getCallState();
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static boolean getDataEnabled(Context context) {
        try {
            return PerfBinderHelper.getDataEnabled();
        } catch (Exception e4) {
            AbstractC0351g.B("getDataEnabled exception: ", e4, "TelephonyManagerStepos");
            return false;
        }
    }

    public static void setDataEnabled(Context context, boolean z4) {
        try {
            PerfBinderHelper.setDataEnabled(z4);
        } catch (Exception e4) {
            AbstractC0351g.B("setDataEnabled exception: ", e4, "TelephonyManagerStepos");
        }
    }
}
