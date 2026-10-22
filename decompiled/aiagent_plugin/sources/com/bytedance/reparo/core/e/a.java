package com.bytedance.reparo.core.e;

/* JADX INFO: compiled from: AsyncLoadResult.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f9182a;

    public void a() {
    }

    public void a(com.bytedance.reparo.core.b.d r1) {
    }

    static {
        f = new a();
    }

    public a() {
    }

    public a(a r1) {
        this.f9182a = r1;
    }

    public void b() {
        a();
        a r0 = this.f9182a;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public void b(com.bytedance.reparo.core.b.d r1) {
        a(r1);
        a r0 = this.f9182a;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }
}
