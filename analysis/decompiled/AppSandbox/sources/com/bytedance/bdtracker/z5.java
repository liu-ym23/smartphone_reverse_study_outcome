package com.bytedance.bdtracker;

import android.util.Log;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;

/* loaded from: classes.dex */
public class z5 implements Runnable {
    public final Runnable a;
    public final String b;
    public final String c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

    public z5(Runnable runnable, String str) {
        this.a = runnable;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
            StringBuilder sbA = a.a("Oaid#Thread:");
            sbA.append(this.b);
            sbA.append(" exception\n");
            sbA.append(this.c);
            iAppLogLoggerGlobal.error(1, sbA.toString(), th, new Object[0]);
        }
    }
}
