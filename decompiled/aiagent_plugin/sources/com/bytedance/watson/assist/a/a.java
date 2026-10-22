package com.bytedance.watson.assist.a;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* JADX INFO: compiled from: AssistConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f11794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11798e;
    public boolean f;
    private int g;
    private int h;
    private C0262a i;

    /* JADX INFO: renamed from: com.bytedance.watson.assist.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistConfig.java */
    public static class C0262a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f11800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f11801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f11802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f11803e;
        private float f;

        public C0262a() {
            this.f11799a = SensitiveType.UNKNOWN;
            this.f11800b = DownloadSettingKeys.BugFix.DEFAULT;
            this.f11801c = 0.0f;
            this.f11802d = 0.0f;
            this.f11803e = 0.0f;
            this.f = 0.0f;
        }

        public float a() {
            return this.f11801c;
        }

        public float b() {
            return this.f;
        }

        public String toString() {
            return "CpuAbnormalConfig{cpuHardWare='" + this.f11799a + "', scene='" + this.f11800b + "', cpuSpeed=" + this.f11801c + ", smallCpuCoreTimePercent=" + this.f11802d + ", middleCpuCoreTimePercent=" + this.f11803e + ", BigCpuCoreTimePercent=" + this.f + '}';
        }
    }

    static {
        f11794a = new a();
    }

    public a() {
        this.f11795b = false;
        this.f11796c = false;
        this.f11797d = false;
        this.f11798e = false;
        this.f = false;
        this.g = 37;
        this.h = 30;
        this.i = new C0262a();
    }

    public C0262a a() {
        return this.i;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.h;
    }

    public boolean d() {
        return this.f11795b;
    }

    public boolean e() {
        return this.f11796c;
    }

    public boolean f() {
        return this.f11797d;
    }

    public boolean g() {
        return this.f11798e;
    }

    public boolean h() {
        return this.f;
    }

    public String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=" + this.f11795b + ", enableThreadCpuUsageStat=" + this.f11796c + ", enableSystemCpuUsageStat=" + this.f11797d + ", enableProcessTimeFreqPercent=" + this.f11798e + ", enableSystemCpuTimeFreqPercent=" + this.f + ", cpuSampleBatteryTemp=" + this.g + ", cpuSampleBatteryLevel=" + this.h + ", cpuAbnormalConfig=" + this.i + '}';
    }
}
