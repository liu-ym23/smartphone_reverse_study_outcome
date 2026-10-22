package x6;

import com.bytedance.watson.assist.file.FileStatInfo;

/* JADX INFO: loaded from: classes.dex */
public class d implements FileStatInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f25460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f25461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f25462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f25463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f25464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f25465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f25466i;

    public d() {
        this.f25458a = null;
        this.f25459b = -1;
        this.f25460c = 0;
        this.f25461d = 0;
        this.f25462e = 0;
        this.f25463f = 0.0d;
        this.f25464g = 0.0d;
        this.f25465h = 0.0d;
        this.f25466i = 0.0d;
    }

    public double a() {
        return this.f25465h;
    }

    public long b() {
        return this.f25460c;
    }

    public double c() {
        return this.f25463f;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo r10) {
        long r11 = b();
        if (r10 != null) goto L5;
        long r12 = 0;
    L6:
        long r13 = r11 - r12;
        this.f25461d = r13;
        if (this.f25462e != 0) goto L10;
        this.f25462e = r13;
        return;
    L10:
        return;
    L5:
        r12 = ((d) r10).b();
        goto L6
    }

    public long d() {
        return this.f25461d;
    }

    public long e() {
        return this.f25462e;
    }

    public void f() {
        this.f25458a = null;
        this.f25459b = -1;
        this.f25460c = 0;
        this.f25461d = 0;
        this.f25462e = 0;
        this.f25463f = 0.0d;
        this.f25464g = 0.0d;
        this.f25465h = 0.0d;
        this.f25466i = 0.0d;
    }

    public void g(long r10) {
        if (this.f25461d >= 0) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L9;
        this.f25465h = d() / r10;
        return;
    }

    public void h(long r10) {
        this.f25460c = r10;
    }

    public void i(long r10) {
        if (this.f25461d >= 0) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L9;
        this.f25463f = d() / r10;
        return;
    }

    public void j(int r10) {
        this.f25459b = r10;
    }

    public void k(String r10) {
        this.f25458a = r10;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f25462e += ((d) r10).e();
    }

    public String toString() {
        return "proc_stat:{pid=" + this.f25459b + " process_name:" + this.f25458a + " delta cpu_time:" + d() + " cpu_usage:" + (this.f25463f * 100.0d) + "% cpu_rate:" + this.f25465h + "}";
    }
}
