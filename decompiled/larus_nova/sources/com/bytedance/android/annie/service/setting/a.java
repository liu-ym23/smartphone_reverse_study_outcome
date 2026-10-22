package com.bytedance.android.annie.service.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/annie/service/setting/a;", "", "", "enable", "Z", "b", "()Z", "", "maxReportTimes", "I", "c", "()I", "sample", "e", "", "cycleInterval", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "reportDeadLoop", "d", "f", "(I)V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40046b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f40047c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40048a;

    @SerializedName("cycle_interval")
    private final long cycleInterval;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("max_report_times")
    private final int maxReportTimes;

    @SerializedName("report_dead_loop")
    private int reportDeadLoop;

    @SerializedName("sample")
    private final int sample;

    /* JADX INFO: renamed from: com.bytedance.android.annie.service.setting.a$a, reason: collision with other inner class name */
    public static final class C0750a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.maxReportTimes == r101.maxReportTimes) goto L15;
        return false;
    L15:
        if (this.sample == r101.sample) goto L18;
        return false;
    L18:
        if (this.cycleInterval == r101.cycleInterval) goto L21;
        return false;
    L21:
        if (this.f40048a == r101.f40048a) goto L24;
        return false;
    L24:
        if (this.reportDeadLoop == r101.reportDeadLoop) goto L26;
        return false;
    L26:
        return true;
    }

    public final void f() {
        this.reportDeadLoop = 0;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.maxReportTimes) * 31) + this.sample) * 31;
        long r102 = this.cycleInterval;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f40048a;
        return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.reportDeadLoop;
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "PerformanceConfig(enable=" + this.enable + ", maxReportTimes=" + this.maxReportTimes + ", sample=" + this.sample + ", cycleInterval=" + this.cycleInterval + ", duration=" + this.f40048a + ", reportDeadLoop=" + this.reportDeadLoop + ')';
    }

    static {
        f40046b = new a(true, 3, 0, 10000, 3000, 10);
        f40047c = new a(0);
    }

    public final long a() {
        return this.cycleInterval;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.maxReportTimes;
    }

    public final int d() {
        return this.reportDeadLoop;
    }

    public final int e() {
        return this.sample;
    }

    public /* synthetic */ a(int r110) {
        this(false, 0, 0, 10000, 2000, 0);
    }

    public a(boolean r100, int r101, int r102, long r103, long r104, int r105) {
        this.enable = r100;
        this.maxReportTimes = r101;
        this.sample = r102;
        this.cycleInterval = r103;
        this.f40048a = r104;
        this.reportDeadLoop = r105;
    }
}
