package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AndDayOfWeekValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class b extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3145b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.b.b f3146d;

    @Override // com.a.c.c.a.h
    public int a(int r1) {
        return 0;
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r1) {
        return false;
    }

    public b(com.a.c.b.a r2, int r3, int r4, com.a.b.b r5) {
        super(r2);
        com.a.e.a.a(com.a.c.b.b.f.equals(r2.a()), "CronField does not belong to day of week");
        this.f3144a = r3;
        this.f3145b = r4;
        this.f3146d = r5;
    }

    @Override // com.a.c.c.a.h
    public List<Integer> a(int r8, int r9) {
        ArrayList r0 = new ArrayList();
        Iterator<com.a.c.b.c.e> r1 = ((com.a.c.b.c.b) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.b.class, "com.obric.aiagent.plugin")).b().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        com.a.c.b.c.e r2 = (com.a.c.b.c.e) ZeusTransformUtils.preCheckCast(r1.next(), com.a.c.b.c.e.class, "com.obric.aiagent.plugin");
        List<Integer> r3 = i.a(new com.a.c.b.a(com.a.c.b.b.f, r2, this.f3156c.c()), this.f3144a, this.f3145b, this.f3146d).b(r8, r9);
        if (r3 == null) goto L4;
        r0.addAll(r3);
        goto L4
    L8:
        return r0;
    }

    @Override // com.a.c.c.a.h
    public boolean a(com.a.c.b.c.e r1) {
        return ZeusTransformUtils.instanceOf(r1, com.a.c.b.c.b.class);
    }
}
