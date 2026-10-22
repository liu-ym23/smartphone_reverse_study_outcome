package u6;

import android.content.Context;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.ArrayList;
import java.util.List;
import x6.f;

/* JADX INFO: loaded from: classes.dex */
public class a implements IAssistStat {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile a f24879g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f24880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w6.a f24881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y6.a f24882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x6.b f24883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v6.a f24884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t6.a f24885f;

    static {
    }

    public a(Context r10) {
        this(r10, t6.a.f24728i);
    }

    public static a a(Context r10) {
        if (f24879g != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f24879g != null) goto L11;
        f24879g = new a(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f24879g;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void end() {
        a7.a.a("end, obj:" + this);
        this.f24881b.a();
        this.f24882c.a();
        this.f24883d.a();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int getBatteryLevel() {
        return this.f24881b.c();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public float getBatteryTemperature() {
        return this.f24881b.d();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public t6.a getConfig() {
        return this.f24885f;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.b getCpuFactorTag() {
        IAssistStat.b r10 = new IAssistStat.b();
        r10.f8216a = getCpuHardwareFromProp();
        r10.f8217b = isCharging();
        r10.f8218c = getBatteryLevel();
        r10.f8219d = getCurrentThermalStatus();
        r10.f8220e = isPowerSaveMode();
        r10.f8221f = getBatteryTemperature();
        r10.f8222g = getProcessCpuTimeFreqPercent();
        return r10;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public String getCpuHardware() {
        return com.bytedance.watson.assist.utils.a.j();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public String getCpuHardwareFromProp() {
        return com.bytedance.watson.assist.utils.a.k();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getCurrentCpuClusterFreqInfo() {
        List r11 = com.bytedance.watson.assist.utils.a.h();
        if (r11 != null) goto L6;
        return null;
    L6:
        ArrayList r10 = new ArrayList();
        int r12 = r11.size();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L16;
        com.bytedance.watson.assist.utils.a.h r14 = (com.bytedance.watson.assist.utils.a.h) r11.get(r13);
        IAssistStat.a r15 = new IAssistStat.a();
        r15.f8206a = r14.c();
        r15.f8207b = r14.a();
        r15.f8208c = r14.b();
        r15.f8210e = com.bytedance.watson.assist.utils.a.e(r13);
        r15.f8211f = com.bytedance.watson.assist.utils.a.c(r13);
        long r16 = com.bytedance.watson.assist.utils.a.e(r13);
        r15.f8212g = r16;
        long r17 = r15.f8210e;
        if (r17 == (-1)) goto L15;
        if (r16 == (-1)) goto L15;
        if (r17 != r16) goto L15;
        r15.f8209d = true;
    L15:
        r15.f8213h = com.bytedance.watson.assist.utils.a.m(r13, r17);
        r15.f8214i = com.bytedance.watson.assist.utils.a.m(r13, r15.f8211f);
        r15.f8215j = com.bytedance.watson.assist.utils.a.m(r13, r15.f8212g);
        r10.add(r15);
        r13 = r13 + 1;
        goto L7
    L16:
        return r10;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int getCurrentThermalStatus() {
        return this.f24882c.c();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getProcCpuSpeed() {
        return this.f24883d.f();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getProcCpuTimeDetail() {
        return this.f24883d.g();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getProcCpuUsage() {
        return this.f24883d.h();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getProcessCpuTimeFreqPercent() {
        return this.f24883d.i();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.c getProcessCpuTimePercent() {
        return this.f24883d.j();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getSortedThreadStatInfoList() {
        return this.f24883d.k();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getSystemCpuTimeFreqDetail() {
        return this.f24883d.l();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getSystemCpuTimeFreqPercent() {
        return this.f24883d.m();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.c getSystemCpuTimePercent() {
        return this.f24883d.n();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getSystemCpuUsage() {
        return this.f24883d.o();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getThreadCpuSpeed(int r10) {
        return this.f24883d.p(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public f getThreadCpuStatInfo(int r10) {
        return this.f24883d.q(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getThreadCpuTimeDetail(int r10) {
        return this.f24883d.r(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getThreadCpuTimeFreqPercent(int r10) {
        return this.f24883d.s(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.c getThreadCpuTimePercent(int r10) {
        return this.f24883d.t(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getThreadCpuUsage(int r10) {
        return this.f24883d.u(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List getTopThreadCpuStatInfoList(int r10) {
        return this.f24883d.v(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCharging() {
        return this.f24881b.f();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalProcess(float r10) {
        return this.f24884e.b(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalThread(int r10) {
        return this.f24884e.c(r10);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuSampleEnvironment() {
        return this.f24884e.d();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int isPowerSaveMode() {
        return this.f24881b.h();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void refreshCpuStat() {
        this.f24883d.y();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat start() {
        a7.a.a("start, obj:" + this);
        this.f24881b.b();
        this.f24882c.b();
        this.f24883d.b();
        return this;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void test(int r10) {
        test();
        a7.a.a("get thread cpu usage :" + getThreadCpuUsage(r10));
        a7.a.a("get thread cpu time detail :" + getThreadCpuTimeDetail(r10));
        a7.a.a("get thread cpu time percent :" + getThreadCpuTimeFreqPercent(r10));
        a7.a.a("get thread stat :" + getThreadCpuStatInfo(r10));
        a7.a.a("get TopN thread stat :" + getTopThreadCpuStatInfoList(r10));
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void updateConfig(t6.a r10) {
        if (r10 == null) goto L5;
        this.f24885f = r10;
        a7.a.e("update config : " + r10 + ", obj:" + this);
        return;
    }

    public a(Context r10, t6.a r11) {
        Context r12 = r10.getApplicationContext();
        this.f24880a = r12;
        if (r11 != null) goto L5;
        t6.a r13 = t6.a.f24728i;
    L6:
        this.f24885f = r13;
        this.f24881b = new w6.a(r12, this);
        this.f24882c = new y6.a(this.f24880a, this);
        this.f24883d = new x6.b(this.f24880a, this);
        this.f24884e = new v6.a(this);
        a7.a.e("new assist obj:" + this + " config : " + r11);
        return;
    L5:
        r13 = r11;
        goto L6
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalProcess() {
        return this.f24884e.a();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void test() {
        refreshCpuStat();
        StringBuilder r10 = new StringBuilder();
        r10.append(" get cpu hardware:" + getCpuHardware());
        r10.append("\n get cpu cur freq : " + com.bytedance.watson.assist.utils.a.c(0));
        r10.append("\n get cpu max freq: " + com.bytedance.watson.assist.utils.a.e(0));
        r10.append("\n get cpu min freq: " + com.bytedance.watson.assist.utils.a.g(0));
        r10.append("\n get process cpu usage : " + getProcCpuUsage());
        r10.append("\n get process cpu speed : " + getProcCpuSpeed());
        r10.append("\n get cluster info list : " + com.bytedance.watson.assist.utils.a.h());
        r10.append("\n get cpu scaling max : " + com.bytedance.watson.assist.utils.a.e(1));
        r10.append("\n get cpu scaling max level: " + com.bytedance.watson.assist.utils.a.f(1));
        r10.append("\n get process cpu time percent : " + getProcessCpuTimePercent());
        r10.append("\n getThreadInfoList:" + getSortedThreadStatInfoList());
        r10.append("\n getSystemCpuTimeFreqDetail:" + getSystemCpuTimeFreqDetail());
        r10.append("\n getSystemCpuTimeFreqPercent:" + getSystemCpuTimeFreqPercent());
        r10.append("\n getSystemCpuTimePercent:" + getSystemCpuTimePercent());
        r10.append("\n getSystemCpuUsage:" + getSystemCpuUsage());
        r10.append("\n getCurrentCpuClusterFreqInfo:" + getCurrentCpuClusterFreqInfo());
        a7.a.e(r10.toString());
        a7.a.g(this.f24880a, r10.toString());
    }
}
