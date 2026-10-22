package com.stepos.perf.gc;

import android.util.Log;
import com.stepos.perf.nativecode.GcPendingHelper;

/* loaded from: classes.dex */
public class GcSuppressUtil {
    private static final int MAX_ALLOWED_SECONDS = 10;
    private static final String TAG = "GcSuppressUtil";
    private static boolean sInited = false;

    private static boolean ensureInit() {
        if (sInited) {
            return true;
        }
        sInited = GcPendingHelper.init();
        if (!sInited) {
            Log.e(TAG, "GcPendingHelper init 失败");
        }
        return sInited;
    }

    public static synchronized void startGcSuppress(String reason, int maxTime) {
        if (maxTime > 10) {
            Log.w(TAG, "startGcSuppress 忽略：maxTime=" + maxTime + "s 超过上限 10s, reason=" + reason);
        } else if (ensureInit()) {
            int maxBlockMs = maxTime > 0 ? maxTime * 1000 : GcPendingHelper.DEFAULT_MAX_BLOCK_MS;
            GcPendingHelper.enable(reason, maxBlockMs);
        }
    }

    public static synchronized void endGcSuppress() {
        if (sInited) {
            GcPendingHelper.disable();
        }
    }
}
