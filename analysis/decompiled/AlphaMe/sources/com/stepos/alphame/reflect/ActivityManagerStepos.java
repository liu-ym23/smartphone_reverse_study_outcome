package com.stepos.alphame.reflect;

import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.perfbinder.PerfBinderHelper;

/* loaded from: classes.dex */
public class ActivityManagerStepos {
    private static String TAG = "AlphaMe";

    public static int checkUidPermission(String str, int i4) {
        try {
            return PerfBinderHelper.checkUidPermission(str, i4);
        } catch (Exception e4) {
            AbstractC0351g.B(AwarenessDataItem.PERMISSION_SPLITTER, e4, TAG);
            return -1;
        }
    }
}
