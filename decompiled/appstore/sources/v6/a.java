package v6;

import android.os.SystemClock;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.watson.assist.api.IAssistStat;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IAssistStat f25087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f25089c;

    public a(IAssistStat r10) {
        this.f25088b = false;
        this.f25087a = r10;
    }

    public boolean a() {
        if (d() == true) goto L6;
        return false;
    L6:
        return true;
    }

    public boolean b(float r10) {
        if (d() == true) goto L6;
        a7.a.e("isAbnormalProcess false, cpuSpeed " + r10 + ", not sample environment");
        return false;
    L6:
        t6.a.C0381a r11 = this.f25087a.getConfig().a();
        if (r11 != null) goto L10;
        a7.a.e("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:null");
        return true;
    L10:
        float r12 = r11.b();
        float r13 = r11.a();
        if (r10 >= r12) goto L13;
        return false;
    L13:
        if (r13 <= 0.0d) goto L20;
        IAssistStat.c r14 = this.f25087a.getProcessCpuTimePercent();
        if (r14 == null) goto L20;
        a7.a.e("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r12 + ", bigCorePercent:" + r14.f8237o + ", config bigCorePercent:" + r13);
        if (r14.f8237o > r13) goto L19;
        return false;
    L19:
        return true;
    L20:
        a7.a.e("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r12);
        return true;
    }

    public boolean c(int r10) {
        return false;
    }

    public boolean d() {
        e();
        return this.f25088b;
    }

    public final void e() {
        long r10 = SystemClock.elapsedRealtime();
        long r11 = this.f25089c;
        if (r11 != 0) goto L5;
    L6:
        this.f25089c = r10;
        float r12 = this.f25087a.getBatteryTemperature();
        int r13 = this.f25087a.getBatteryLevel();
        int r14 = this.f25087a.isPowerSaveMode();
        boolean r15 = false;
        if (r12 <= this.f25087a.getConfig().c()) goto L9;
        boolean r16 = false;
    L11:
        if (r13 >= this.f25087a.getConfig().b()) goto L13;
        r16 = false;
    L13:
        if (r14 == 1) goto L16;
        r15 = r16;
    L16:
        a7.a.e("updateCpuSampleEnvironment:" + r15 + ", temp:" + r12 + ", level:" + r13 + ", powerSave:" + r14);
        this.f25088b = r15;
        return;
    L9:
        r16 = true;
        goto L11
    L5:
        if ((r10 - r11) >= PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L6;
    }
}
