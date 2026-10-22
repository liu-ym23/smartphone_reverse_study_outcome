package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LogcatLogger implements LottieLogger {
    private static final Set<String> loggedMessages = null;

    public LogcatLogger() {
    }

    static {
        loggedMessages = new HashSet();
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String r2) {
        debug(r2, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String r1, Throwable r2) {
        if (L.DBG == false) goto L6;
        Log.d(L.TAG, r1, r2);
        return;
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(String r2) {
        warning(r2, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(String r2, Throwable r3) {
        Set<String> r1 = loggedMessages;
        if (r1.contains(r2) == false) goto L5;
        return;
    L5:
        Log.w(L.TAG, r2, r3);
        r1.add(r2);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void error(String r1, Throwable r2) {
        if (L.DBG == false) goto L6;
        Log.d(L.TAG, r1, r2);
        return;
    }
}
