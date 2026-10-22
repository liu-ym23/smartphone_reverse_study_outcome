package com.bytedance.android.live.core.monitor.trace;

import com.google.gson.annotations.SerializedName;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile C1069a f64991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f64992b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f64993c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f64994d;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.monitor.trace.a$a, reason: collision with other inner class name */
    public static class C1069a {

        @SerializedName("enable")
        boolean enable;

        @SerializedName("frequencyThreshold")
        int frequencyThreshold;

        @SerializedName("intervals")
        private long intervals;

        public C1069a() {
        }

        public final long a() {
            long r100 = this.intervals;
            if (r100 >= 60000) goto L5;
            return 60000;
        L5:
            return r100;
        }
    }

    static {
        f64992b = new ConcurrentHashMap();
        f64993c = new ConcurrentHashMap();
    }
}
