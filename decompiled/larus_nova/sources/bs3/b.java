package bs3;

import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f20234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f20235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f20237d;

    public abstract void e(boolean r100, boolean r101);

    public b(String r100) {
        this.f20236c = r100;
        this.f20237d = com.bytedance.apm.d.k();
        this.f20234a = ActivityLifeObserver.getInstance().isForeground();
        this.f20235b = ds3.a.c(com.bytedance.apm.d.getContext());
    }

    @Override // bs3.l
    public final void b(boolean r100) {
        e(this.f20234a, r100);
    }

    @Override // bs3.l
    public final void d(boolean r100) {
        e(this.f20234a, r100);
    }

    @Override // bs3.l
    public final void f(boolean r100) {
        e(this.f20234a, r100);
        this.f20234a = false;
    }

    @Override // bs3.l
    public final void h(boolean r100) {
        e(this.f20234a, r100);
        this.f20234a = true;
    }

    @Override // bs3.l
    public final void i(boolean r100) {
        e(this.f20234a, r100);
    }

    @Override // bs3.l
    public final void c(boolean r100, boolean r101) {
        e(this.f20234a, r101);
        this.f20235b = r100;
    }

    public final void g(boolean r110, long r111, String r112) {
        if (r111 < 0) goto L5;
        as3.b.a.f16095a.g(new ms3.a(r110, System.currentTimeMillis(), this.f20236c, this.f20235b, r111, r112));
        return;
    L5:
        if (com.bytedance.apm.d.j() == false) goto L8;
        ps3.b.a(new String[]{"AbsBatteryValueStats value error: " + r111 + " type:" + this.f20236c});
    }
}
