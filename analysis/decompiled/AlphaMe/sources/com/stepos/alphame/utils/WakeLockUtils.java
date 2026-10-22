package com.stepos.alphame.utils;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class WakeLockUtils {
    private static final boolean DEBUG = false;
    private static final int REQUEST_TIME_OUT = 300;
    private static final String TAG = "WakeLockUtils";
    public static final String WACK_LOCK_ALL = "All";
    public static final String WACK_LOCK_AUDIO_IN = "AudioIn";
    public static final String WACK_LOCK_AUDIO_MIX = "AudioMix";
    public static final String WACK_LOCK_OTHERS = "Others";
    private static long mLastRefreshTime;
    private static HashMap<String, Set<Integer>> sCachedSets;

    private static HashMap<String, Set<Integer>> fetchWakeLockUidSets() {
        HashMap<String, Set<Integer>> map = new HashMap<>();
        try {
            Bundle wakeLockUidSets = PerfBinderHelper.getWakeLockUidSets();
            map.put("All", toSet(wakeLockUidSets.getIntArray(PerfBinderHelper.KEY_WAKELOCK_UIDS_ALL)));
            map.put(WACK_LOCK_AUDIO_MIX, toSet(wakeLockUidSets.getIntArray(PerfBinderHelper.KEY_WAKELOCK_UIDS_AUDIO_MIX)));
            map.put(WACK_LOCK_AUDIO_IN, toSet(wakeLockUidSets.getIntArray(PerfBinderHelper.KEY_WAKELOCK_UIDS_AUDIO_IN)));
            map.put(WACK_LOCK_OTHERS, toSet(wakeLockUidSets.getIntArray(PerfBinderHelper.KEY_WAKELOCK_UIDS_OTHERS)));
        } catch (Exception e4) {
            Log.e(TAG, "fetchWakeLockUidSets failed", e4);
            map.put("All", new HashSet());
            map.put(WACK_LOCK_AUDIO_MIX, new HashSet());
            map.put(WACK_LOCK_AUDIO_IN, new HashSet());
            map.put(WACK_LOCK_OTHERS, new HashSet());
        }
        return map;
    }

    public static HashMap<String, Set<Integer>> getWakeLockUidSets() {
        if (sCachedSets == null || SystemClock.elapsedRealtime() - mLastRefreshTime > 300) {
            sCachedSets = fetchWakeLockUidSets();
            mLastRefreshTime = SystemClock.elapsedRealtime();
        }
        return sCachedSets;
    }

    private static Set<Integer> toSet(int[] iArr) {
        HashSet hashSet = new HashSet();
        if (iArr != null) {
            for (int i4 : iArr) {
                hashSet.add(Integer.valueOf(i4));
            }
        }
        return hashSet;
    }
}
