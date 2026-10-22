package com.bytedance.apm6.frequency;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: FrequencyMonitorConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, Float> f5360e;
    private final HashMap<String, Float> f;
    private final int g;
    private final int h;
    private final int i;
    private final HashMap<String, Float> j;
    private final HashMap<String, Float> k;

    /* JADX INFO: compiled from: FrequencyMonitorConfig.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f5362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private HashMap<String, Float> f5365e;
        private HashMap<String, Float> f;
        private int g;
        private int h;
        private int i;
        private HashMap<String, Float> j;
        private HashMap<String, Float> k;

        public a() {
            this.f5361a = false;
            this.f5362b = false;
            this.f5363c = 120;
            this.f5364d = 600;
            this.f5365e = new HashMap();
            this.f = new HashMap();
            this.g = 5;
            this.h = 600;
            this.i = 1000;
            this.j = new HashMap();
            this.k = new HashMap();
        }

        public a a(boolean r1) {
            this.f5361a = r1;
            return this;
        }

        public a b(boolean r1) {
            this.f5362b = r1;
            return this;
        }

        public a a(int r1) {
            if (r1 <= 0) goto L4;
            this.f5363c = r1;
        L4:
            return this;
        }

        public a b(int r1) {
            if (r1 <= 0) goto L4;
            this.f5364d = r1;
        L4:
            return this;
        }

        public a a(HashMap<String, Float> r1) {
            if (r1 == null) goto L4;
            this.f5365e = r1;
        L4:
            return this;
        }

        public a b(HashMap<String, Float> r1) {
            if (r1 == null) goto L4;
            this.f = r1;
        L4:
            return this;
        }

        public a c(int r1) {
            if (r1 <= 0) goto L4;
            this.g = r1;
        L4:
            return this;
        }

        public a d(int r1) {
            if (r1 <= 0) goto L4;
            this.h = r1;
        L4:
            return this;
        }

        public a e(int r2) {
            if (r2 > 0) goto L4;
        L6:
            return this;
        L4:
            if (r2 > 10000) goto L6;
            this.i = r2;
            goto L6
        }

        public a c(HashMap<String, Float> r1) {
            if (r1 == null) goto L4;
            this.j = r1;
        L4:
            return this;
        }

        public a d(HashMap<String, Float> r1) {
            if (r1 == null) goto L4;
            this.k = r1;
        L4:
            return this;
        }

        public c a() {
            return new c(this.f5361a, this.f5362b, this.f5363c, this.f5364d, this.f5365e, this.f, this.g, this.h, this.i, this.j, this.k);
        }
    }

    c(boolean r1, boolean r2, int r3, int r4, HashMap<String, Float> r5, HashMap<String, Float> r6, int r7, int r8, int r9, HashMap<String, Float> r10, HashMap<String, Float> r11) {
        this.f5356a = r1;
        this.f5357b = r2;
        this.f5359d = r3;
        this.f5358c = r4;
        this.f5360e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }

    public boolean a() {
        return this.f5356a;
    }

    public boolean b() {
        return this.f5357b;
    }

    public int a(boolean r1) {
        if (r1 == false) goto L4;
        int r0 = this.f5359d;
    L6:
        return r0 * 1000;
    L4:
        r0 = this.f5358c;
        goto L6
    }

    public float a(String r2, boolean r3) {
        if (r3 == false) goto L9;
        Float r1 = (Float) ZeusTransformUtils.preCheckCast(this.f5360e.get(r2), Float.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        return 1000.0f;
    L8:
        return r1.floatValue();
    L9:
        Float r4 = (Float) ZeusTransformUtils.preCheckCast(this.f.get(r2), Float.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L13;
        return 100.0f;
    L13:
        return r4.floatValue();
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.h * 1000;
    }

    public int e() {
        return this.i;
    }

    public float b(String r2, boolean r3) {
        if (r3 == false) goto L9;
        Float r1 = (Float) ZeusTransformUtils.preCheckCast(this.j.get(r2), Float.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        return 20.0f;
    L8:
        return r1.floatValue();
    L9:
        Float r4 = (Float) ZeusTransformUtils.preCheckCast(this.k.get(r2), Float.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L13;
        return 2.0f;
    L13:
        return r4.floatValue();
    }

    public String toString() {
        return "FrequencyMonitorConfig{mEnableFrequencyMonitor=" + this.f5356a + ", mEnableExceptionMonitor=" + this.f5357b + ", mBackgroundExceptionCheckInterval=" + this.f5358c + ", mFrontExceptionCheckInterval=" + this.f5359d + ", mFrontExceptionThresholdPerMin=" + this.f5360e + ", mBackExceptionThresholdPerMin=" + this.f + ", mExceptionReportTopCount=" + this.g + ", mReportInterval=" + this.h + ", mEventSamplingRate=" + this.i + ", mReportFrontThreshold=" + this.j + ", mReportBackgroundThreshold=" + this.k + '}';
    }
}
