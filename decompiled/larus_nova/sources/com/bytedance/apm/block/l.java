package com.bytedance.apm.block;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f190379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f190380b;

    public final void a() {
        c r100 = this.f190379a;
        if ((r100.f190327h - r100.f190326g) > this.f190380b.f190362e) goto L5;
    L7:
        this.f190379a.getClass();
        c r101 = this.f190379a;
        if (r101.f190336q == null) goto L12;
        if (r101.f190331l == true) goto L12;
    L15:
        c r102 = this.f190379a;
        long r103 = r102.f190327h - r102.f190326g;
        k r104 = this.f190380b;
        if (r103 > r104.f190362e) goto L18;
    L22:
        boolean r105 = false;
    L33:
        String r106 = b27.j.a(this.f190379a.f190321b);     // Catch: Exception -> L32
        k r107 = this.f190380b;     // Catch: Exception -> L32
        c r108 = this.f190379a;     // Catch: Exception -> L32
        k.a(r107, r108.f190323d, r108, r106);     // Catch: Exception -> L32
        if (this.f190379a.f190329j == true) goto L26;
    L30:
        k.c(this.f190380b, this.f190379a, r106);     // Catch: Exception -> L32
        return;
    L26:
        if (this.f190380b.f190359b == false) goto L30;
        k r109 = this.f190380b;     // Catch: Exception -> L32
        if (r109.f190363f == false) goto L30;
        k.b(r109, this.f190379a, r106, r105);     // Catch: Exception -> L32
    L35:
        return;
    L18:
        if (r102.f190329j == true) goto L22;
        if (r104.f190363f == false) goto L22;
        r102.f190341v = k.d(r104);
        c r110 = this.f190379a;
        ss3.e.b().getClass();
        r110.f190340u = ss3.e.a();
        r105 = true;
        this.f190379a.f190329j = true;
    L12:
        if (this.f190380b.f190360c == false) goto L14;
        return;
    L14:
        this.f190379a.f190336q = "Invalid Stack\n";
        goto L15
    L5:
        if (zs3.c.b(UploadTypeInf.SERIOUS_BLOCK_MONITOR) == false) goto L7;
        c r111 = this.f190380b.f190368k;
        com.bytedance.monitor.collector.c r112 = com.bytedance.monitor.collector.c.e();
        c r113 = this.f190379a;
        r111.f190342w = r112.c(r113.f190326g, r113.f190327h);
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public l(k r100, c r101) {
        this.f190380b = r100;
        this.f190379a = r101;
    }
}
