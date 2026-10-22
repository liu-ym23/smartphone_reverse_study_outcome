package com.bytedance.reparo.core.h;

import com.bytedance.reparo.core.g;
import com.bytedance.reparo.core.g.h;
import com.bytedance.reparo.core.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: Patch.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f9261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f9262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f9263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f9264e;
    private com.bytedance.reparo.core.e.d f;
    private boolean g;

    private d(h r3, com.bytedance.reparo.core.e r4, g r5, com.bytedance.reparo.core.g.a r6) {
        com.bytedance.reparo.core.g.a r7 = (com.bytedance.reparo.core.g.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.reparo.core.g.a.class, "com.obric.aiagent.plugin");
        this.g = false;
        this.f9264e = r3;
        this.f9261b = r3.b();
        this.f = new com.bytedance.reparo.core.e.d(this, r4, r5, r7);
    }

    public static d a(n r2, com.bytedance.reparo.core.d.a.C0212a r3, com.bytedance.reparo.core.e r4, g r5, com.bytedance.reparo.core.g.a r6) {
        com.bytedance.reparo.core.g.a r7 = (com.bytedance.reparo.core.g.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.reparo.core.g.a.class, "com.obric.aiagent.plugin");
        h r8 = r2.i();
        r8.a(r3.f9175a);
        if (r3.f9176b == false) goto L8;
        if (com.bytedance.reparo.core.a.b.b.d(r3.f9177c) == true) goto L8;
        r8.a(true);
        r8.b(r3.f9177c);
    L8:
        if (r3.f9178d == false) goto L13;
        if (com.bytedance.reparo.core.a.b.b.b(r3.f) == false) goto L13;
        r8.b(true);
        r8.c(r3.f9179e);
        r8.c(r3.f);
    L13:
        return a(r8, r4, r5, r7);
    }

    public static d a(h r2, com.bytedance.reparo.core.e r3, g r4, com.bytedance.reparo.core.g.a r5) {
        com.bytedance.reparo.core.g.a r6 = (com.bytedance.reparo.core.g.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.reparo.core.g.a.class, "com.obric.aiagent.plugin");
        d r0 = new d(r2, r3, r4, r6);
        if (r2.d() == false) goto L8;
        if (com.bytedance.reparo.core.a.b.b.d(r2.f()) == true) goto L8;
        r0.f9262c = new c(r2.f(), r0);
    L8:
        if (r2.g() == true) goto L10;
    L12:
        return r0;
    L10:
        if (com.bytedance.reparo.core.a.b.b.b(r2.i()) == false) goto L12;
        r0.f9263d = new e(r2.b(), r2.i(), r4, r6);
        goto L12
    }

    public void a(com.bytedance.reparo.core.e.a r1, b r2) {
        this.f.a(r1, r2);     // Catch: com.bytedance.reparo.core.b.d -> L4
        return;
    L4:
        e = move-exception;
        r1.a(e);
    }

    public void f() {
        this.f.a();
    }

    public h g() {
        return this.f9264e;
    }

    public void h() {
        this.g = true;
    }

    public boolean i() {
        return this.g;
    }
}
