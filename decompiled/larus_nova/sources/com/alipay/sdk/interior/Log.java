package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.m.k.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.e;

/* JADX INFO: loaded from: classes28.dex */
public class Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f25210a;

    public interface ISdkLogCallback {
        void onLogLine(String r100);
    }

    public Log() {
    }

    public static boolean forcedLogReport(Context r100) {
        b.d().a(r100);     // Catch: Exception -> L9
        long r101 = SystemClock.elapsedRealtime() / 1000;     // Catch: Exception -> L9
        if ((r101 - f25210a) >= 600) goto L6;
        return false;
    L6:
        f25210a = r101;     // Catch: Exception -> L9
        a.a(r100);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        e.a(e);
        return false;
    }

    public static void setupLogCallback(ISdkLogCallback r100) {
        e.a(r100);
    }
}
