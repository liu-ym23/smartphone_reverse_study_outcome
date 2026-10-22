package com.bytedance.applog.monitor.v3;

import android.os.SystemClock;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: MonitorV3Utils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicLong f5798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f5799b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f5800c = null;

    static {
        f5800c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        long r0 = (((SystemClock.elapsedRealtime() / 1000) * 100) + ((long) new SecureRandom().nextInt(99))) * 100000;
        f5798a = new AtomicLong(r0);
        f5799b = new AtomicLong(r0);
    }

    public static long a() {
        return f5798a.incrementAndGet();
    }

    public static long b() {
        return f5799b.incrementAndGet();
    }

    public static String c() {
        return String.valueOf(a());
    }

    public static String d() {
        return f5800c.format(new Date());
    }
}
