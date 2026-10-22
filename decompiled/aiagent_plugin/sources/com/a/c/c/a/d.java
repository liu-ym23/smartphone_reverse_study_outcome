package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: BetweenDayOfWeekValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class d extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3149b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.b.b f3150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<Integer> f3151e;

    @Override // com.a.c.c.a.h
    public int a(int r1) {
        return 0;
    }

    public d(com.a.c.b.a r3, int r4, int r5, com.a.b.b r6) {
        super(r3);
        com.a.e.a.a(com.a.c.b.b.f.equals(r3.a()), "CronField does not belong to day of week");
        this.f3148a = r4;
        this.f3149b = r5;
        this.f3150d = r6;
        final HashSet r7 = new HashSet();
        this.f3151e = r7;
        com.a.c.b.c.c r2 = (com.a.c.b.c.c) ZeusTransformUtils.preCheckCast(r3.b(), com.a.c.b.c.c.class, "com.obric.aiagent.plugin");
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(r2.b().a(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(r2.c().a(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (r9 < r8) goto L5;
        IntStream.rangeClosed(r8, r9).forEach(new $$Lambda$ChCjQ6dFsPPTYRm9u_QXTnRx9B8(r7));
        return;
    L5:
        IntStream.rangeClosed(r8, r3.c().b()).forEach(new $$Lambda$ChCjQ6dFsPPTYRm9u_QXTnRx9B8(r7));
        IntStream.rangeClosed(r3.c().a(), r9).forEach(new $$Lambda$ChCjQ6dFsPPTYRm9u_QXTnRx9B8(r7));
    }

    @Override // com.a.c.c.a.h
    public List<Integer> a(int r8, int r9) {
        ArrayList r0 = new ArrayList();
        Iterator<Integer> r1 = this.f3151e.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.aiagent.plugin");
        com.a.c.b.a.b r3 = com.a.c.b.a.b.h().a(com.a.c.b.b.f);
        List<Integer> r4 = new n(new com.a.d.b(com.a.c.b.b.f, r3.g()).a(r2.toString()), this.f3148a, this.f3149b, this.f3150d).b(r8, r9);
        if (r4 == null) goto L4;
        r0.addAll(r4);
        goto L4
    L8:
        Collections.sort(r0);
        return r0;
    }

    @Override // com.a.c.c.a.h
    public boolean a(com.a.c.b.c.e r1) {
        return ZeusTransformUtils.instanceOf(r1, com.a.c.b.c.c.class);
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r3) {
        return this.f3151e.contains(Integer.valueOf((LocalDate.of(this.f3148a, this.f3149b, r3).getDayOfWeek().getValue() % 7) + (this.f3150d.a() - 1)));
    }
}
