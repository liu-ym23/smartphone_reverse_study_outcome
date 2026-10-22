package b27;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.monitor.collector.b f17033d;

    @Override // b27.a
    public final void a() {
        this.f17030a = false;
        com.bytedance.monitor.collector.b r100 = this.f17033d;
        r100.f265588f++;
        com.bytedance.monitor.collector.b.e(r100, false, a.f17028b);
        com.bytedance.monitor.collector.b r101 = this.f17033d;
        r101.f265597o = r101.f265598p;
        r101.f265598p = "no message running";
        r101.f265602t = false;
    }

    public d(com.bytedance.monitor.collector.b r100) {
        this.f17033d = r100;
    }

    @Override // b27.a
    public final void b(String r100) {
        this.f17033d.f265602t = true;
        this.f17033d.f265598p = r100;
        this.f17030a = true;
        com.bytedance.monitor.collector.b.e(this.f17033d, true, a.f17028b);
    }
}
