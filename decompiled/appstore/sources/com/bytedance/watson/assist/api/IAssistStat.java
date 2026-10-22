package com.bytedance.watson.assist.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import x6.f;

/* JADX INFO: loaded from: classes.dex */
public interface IAssistStat {
    public static final int CPU_FREQ_LEVEL_HIGH = 3;
    public static final int CPU_FREQ_LEVEL_LOW = 0;
    public static final int CPU_FREQ_LEVEL_LOW_MID = 1;
    public static final int CPU_FREQ_LEVEL_MAX = 4;
    public static final int CPU_FREQ_LEVEL_MID_HIGH = 2;
    public static final int POWERSAVE_CLOSE = 0;
    public static final int POWERSAVE_OPEN = 1;
    public static final int POWERSAVE_UNKNOW = -1;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f8207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f8208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8209d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8210e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8211f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f8212g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8213h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8214i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f8215j;

        public a() {
            this.f8207b = new ArrayList();
            this.f8208c = new ArrayList();
            this.f8209d = false;
        }

        public String toString() {
            return "CpuClusterFreqInfo{name='" + this.f8206a + "', affectedCpuList=" + this.f8207b + ", freqList=" + this.f8208c + ", isLockFreq=" + this.f8209d + ", scalingMinFreq=" + this.f8210e + ", scalingCurFreq=" + this.f8211f + ", scalingMaxFreq=" + this.f8212g + ", scalingMinFreqLevel=" + this.f8213h + ", scalingCurFreqLevel=" + this.f8214i + ", scalingMaxFreqLevel=" + this.f8215j + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8219d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8220e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f8221f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f8222g;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f8224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f8225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f8226d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f8227e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f8228f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f8229g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f8230h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f8231i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f8232j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f8233k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f8234l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f8235m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f8236n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f8237o;

        public c() {
        }

        public String toString() {
            return "CpuTimePercent{smallCoreLow=" + this.f8223a + ", smallCoreMidLow=" + this.f8224b + ", smallCoreMidHigh=" + this.f8225c + ", smallCoreHigh=" + this.f8226d + ", smallCoreSum=" + this.f8227e + ", middleCoreLow=" + this.f8228f + ", middleCoreMidLow=" + this.f8229g + ", middleCoreMidHigh=" + this.f8230h + ", middleCoreHigh=" + this.f8231i + ", middleCoreSum=" + this.f8232j + ", bigCoreLow=" + this.f8233k + ", bigCoreMidLow=" + this.f8234l + ", bigCoreMidHigh=" + this.f8235m + ", bigCoreHigh=" + this.f8236n + ", bigCoreSum=" + this.f8237o + '}';
        }
    }

    void end();

    int getBatteryLevel();

    float getBatteryTemperature();

    t6.a getConfig();

    b getCpuFactorTag();

    String getCpuHardware();

    String getCpuHardwareFromProp();

    List<a> getCurrentCpuClusterFreqInfo();

    int getCurrentThermalStatus();

    double getProcCpuSpeed();

    List<LinkedHashMap<Long, Long>> getProcCpuTimeDetail();

    double getProcCpuUsage();

    List<List<Integer>> getProcessCpuTimeFreqPercent();

    c getProcessCpuTimePercent();

    List<f> getSortedThreadStatInfoList();

    List<LinkedHashMap<Long, Long>> getSystemCpuTimeFreqDetail();

    List<List<Integer>> getSystemCpuTimeFreqPercent();

    c getSystemCpuTimePercent();

    double getSystemCpuUsage();

    double getThreadCpuSpeed(int r10);

    f getThreadCpuStatInfo(int r10);

    List<LinkedHashMap<Long, Long>> getThreadCpuTimeDetail(int r10);

    List<List<Integer>> getThreadCpuTimeFreqPercent(int r10);

    c getThreadCpuTimePercent(int r10);

    double getThreadCpuUsage(int r10);

    List<f> getTopThreadCpuStatInfoList(int r10);

    boolean isCharging();

    boolean isCpuAbnormalProcess();

    boolean isCpuAbnormalProcess(float r10);

    boolean isCpuAbnormalThread(int r10);

    boolean isCpuSampleEnvironment();

    int isPowerSaveMode();

    void refreshCpuStat();

    IAssistStat start();

    void test();

    void test(int r10);

    void updateConfig(t6.a r10);
}
