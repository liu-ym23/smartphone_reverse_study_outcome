package com.bytedance.frameworks.baselib.network.c;

import com.bytedance.common.utility.j;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.al;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApiTask.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f8005e;
    private final Runnable f;
    private final c.a g;
    private final String h;

    @Override // com.bytedance.frameworks.baselib.network.c.b
    public /* synthetic */ b c(int r1) {
        return a(r1);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(c r3) {
        return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"));
    }

    public a(String r3, c.a r4, int r5, Runnable r6, boolean r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.aiagent.plugin");
        this.g = r4;
        if (j.a(r3) == false) goto L5;
        r3 = getClass().getSimpleName();
    L5:
        this.f8008c = r5;
        this.h = r3;
        this.f = r8;
        this.f8005e = r7;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f != null) goto L5;
        return;
    L5:
        if (e() == true) goto L9;
        this.f.run();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.c.c
    public c.a a() {
        return this.g;
    }

    @Override // com.bytedance.frameworks.baselib.network.c.c
    public int b() {
        return this.f8009d;
    }

    public a a(int r1) {
        this.f8009d = r1;
        return this;
    }

    public void b(int r3) {
        if (ZeusTransformUtils.instanceOf(this.f, al.class) == false) goto L8;
        af r2 = ((al) ZeusTransformUtils.preCheckCast(this.f, al.class, "com.obric.aiagent.plugin")).d();
        if (r2 == null) goto L9;
        r2.a(r3);
        return;
    L9:
        return;
    }

    public int a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        c.a r0 = a();
        c.a r1 = r4.a();
        if (r0 != null) goto L5;
        r0 = c.a.f8012c;
    L5:
        if (r1 != null) goto L7;
        r1 = c.a.f8012c;
    L7:
        if (r0 != r1) goto L9;
        int r2 = b();
        int r5 = r4.b();
    L11:
        return r2 - r5;
    L9:
        r2 = r1.ordinal();
        r5 = r0.ordinal();
        goto L11
    }
}
