package com.bytedance.reparo.core.e;

import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PatchLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.reparo.core.e f9194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f9195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f9196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f9197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.reparo.core.h.d f9198e;
    private com.bytedance.reparo.core.g.a f;

    public d(com.bytedance.reparo.core.h.d r3, com.bytedance.reparo.core.e r4, g r5, com.bytedance.reparo.core.g.a r6) {
        com.bytedance.reparo.core.g.a r7 = (com.bytedance.reparo.core.g.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.reparo.core.g.a.class, "com.obric.aiagent.plugin");
        this.f9198e = r3;
        this.f9194a = r4;
        this.f9195b = r5;
        this.f = r7;
        this.f9196c = new c(this.f9195b);
        this.f9197d = new e(this.f9195b);
    }

    public void a(final a r7, com.bytedance.reparo.core.h.b r8) {
        com.bytedance.reparo.core.h.c r0 = this.f9198e.f9262c;
        com.bytedance.reparo.core.h.e r1 = this.f9198e.f9263d;
        if (r1 != null) goto L5;
    L9:
        int r3 = 0;
        final AtomicInteger r2 = new AtomicInteger(0);
        a r4 = new AnonymousClass1(this, r7, r2);
        if (this.f9194a.f9180a == false) goto L16;
        if (r0 == null) goto L16;
        if (r0.e() == false) goto L16;
        this.f9196c.a(r0, r4, r8);
        r3 = 1;
    L16:
        if (this.f9194a.f9181b == false) goto L22;
        if (r1 == null) goto L22;
        if (r1.e() == false) goto L22;
        this.f9197d.a(r1, r4, r8);
        r3 = r3 + 1;
    L22:
        if (r2.get() != r3) goto L25;
        r7.b();
        return;
    L25:
        return;
    L5:
        if (r1.i() == false) goto L9;
        if (WandTrick.f9137c != null) goto L9;
        WandTrick.f9137c = r1.g();
        goto L9
    }

    public void a() {
        this.f9196c.a();
        this.f9197d.a();
    }
}
