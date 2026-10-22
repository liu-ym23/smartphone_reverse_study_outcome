package com.android.server.content;

import android.mifavor.MFVUtils;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public interface IZswContentService {
    public static final String TAG = "ZswContentService";

    public static final class ObserverNode {
        private static final int MAX_CHECK_TIMES_BEFORE_REPORT = 200;
        private static final int MAX_OBSERVERS_COUNT = 5000;
        private static int mCheckObserversTimes;

        public ObserverNode() {
        }

        static {
            mCheckObserversTimes = -1;
        }
    }

    static boolean handleIncomingUser_DoubleApp(Uri uri, int uid, int userId) {
    L14:
        e = move-exception;
        Log.d(TAG, "debug_999_fallback handleIncomingUser e:" + e + ",uri:" + uri + ",userId:" + userId);
        return false;
    L4:
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L6;
        return false;
    L6:
        if (userId != 999) goto L23;
        String auth = uri.getAuthority();     // Catch: Exception -> L14
        if (auth != null) goto L10;
        return false;
    L10:
        if (auth.contains("com.android.contacts") == false) goto L25;
        Log.d(TAG, "debug_999_fallback handleIncomingUser Contact 999 fall back to 0 !,uri:" + uri + ",uid:" + uid + ",userId:" + userId);     // Catch: Exception -> L14
        return true;
    L25:
        return false;
    L23:
        return false;
    }
}
