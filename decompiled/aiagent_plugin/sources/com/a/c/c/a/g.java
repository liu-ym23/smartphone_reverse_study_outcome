package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EveryFieldValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f3154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f3155b;

    public g(com.a.c.b.a r4) {
        super(r4);
        com.a.c.b.c.e r0 = ((com.a.c.b.c.d) ZeusTransformUtils.preCheckCast(r4.b(), com.a.c.b.c.d.class, "com.obric.aiagent.plugin")).c();
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.c.class) == false) goto L6;
        com.a.c.b.c.c r1 = (com.a.c.b.c.c) ZeusTransformUtils.preCheckCast(r0, com.a.c.b.c.c.class, "com.obric.aiagent.plugin");
        this.f3154a = Math.max(r4.c().a(), e.a(r1.b()));
        this.f3155b = Math.min(r4.c().b(), e.a(r1.c()));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.f.class) == false) goto L8;
        this.f3154a = ((com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(r0, com.a.c.b.c.f.class, "com.obric.aiagent.plugin")).b().b().intValue();
        this.f3155b = r4.c().b();
        return;
    L8:
        this.f3154a = r4.c().a();
        this.f3155b = r4.c().b();
    }

    @Override // com.a.c.c.a.h
    public int a(int r4) {
        if (r4 >= this.f3155b) goto L13;
        int r5 = a(r4, (com.a.c.b.c.d) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.d.class, "com.obric.aiagent.plugin"));
        int r0 = this.f3154a;
        if (r5 >= r0) goto L8;
        return r0;
    L8:
        if (r5 > this.f3155b) goto L11;
        return r5;
    L11:
        throw new j();
    L13:
        throw new j();
    }

    private int a(int r1, com.a.c.b.c.d r2) {
        int r0 = a();
        if (r1 < r0) goto L6;
        int r3 = r2.b().b().intValue();
        return r1 + (r3 - ((r1 - r0) % r3));
    L6:
        return r0;
    }

    @Override // com.a.c.c.a.h
    public List<Integer> a(int r4, int r5) {
        ArrayList r0 = new ArrayList();
        int r1 = a();     // Catch: j -> L14
        if (r4 >= r1) goto L7;
        if (r1 >= r5) goto L7;
        r0.add(Integer.valueOf(r1));     // Catch: j -> L14
    L7:
        int r6 = a(r4);     // Catch: j -> L14
    L8:
        if (r6 >= r5) goto L13;
        if (r6 == r1) goto L11;
        r0.add(Integer.valueOf(r6));     // Catch: j -> L14
    L11:
        r6 = a(r6);     // Catch: j -> L14
    L13:
        return r0;
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r4) {
        com.a.c.b.c.d r0 = (com.a.c.b.c.d) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.d.class, "com.obric.aiagent.plugin");
        int r1 = a();
        if (r4 >= r1) goto L5;
    L11:
        return false;
    L5:
        if (((r4 - r1) % r0.b().b().intValue()) != 0) goto L11;
        if (r4 < this.f3154a) goto L11;
        if (r4 > this.f3155b) goto L11;
        return true;
    }

    @Override // com.a.c.c.a.h
    public boolean a(com.a.c.b.c.e r1) {
        return ZeusTransformUtils.instanceOf(r1, com.a.c.b.c.d.class);
    }

    int a() {
        com.a.c.b.c.e r0 = ((com.a.c.b.c.d) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.d.class, "com.obric.aiagent.plugin")).c();
        if (ZeusTransformUtils.instanceOf(r0, com.a.c.b.c.f.class) == false) goto L7;
        return ((com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(r0, com.a.c.b.c.f.class, "com.obric.aiagent.plugin")).b().b().intValue();
    L7:
        return this.f3154a;
    }
}
