package com.android.server.location.gnss;

import android.content.Context;
import android.os.Looper;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
abstract class NetworkTimeHelper {
    static final boolean USE_TIME_DETECTOR_IMPL = true;

    interface InjectTimeCallback {
        void injectTime(long r1, long r3, int r5);
    }

    abstract void demandUtcTimeInjection();

    abstract void dump(PrintWriter r1);

    abstract void onNetworkAvailable();

    abstract void setPeriodicTimeInjectionMode(boolean r1);

    NetworkTimeHelper() {
    }

    static NetworkTimeHelper create(Context context, Looper looper, InjectTimeCallback injectTimeCallback) {
        return new NtpNetworkTimeHelper(context, looper, injectTimeCallback);
    }
}
