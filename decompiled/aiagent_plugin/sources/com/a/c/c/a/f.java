package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: EveryDayOfWeekValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class f extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3153e;
    private int f;
    private final Set<DayOfWeek> g;

    f(com.a.c.b.a r3, int r4, int r5, com.a.b.b r6) {
        super(r3);
        com.a.e.a.a(com.a.c.b.b.f.equals(r3.a()), "CronField does not belong to day of week");
        this.f3153e = r4;
        this.f = r5;
        boolean r0 = true;
        this.f3152d = LocalDate.of(r4, r5, 1).lengthOfMonth();
        int r7 = ((com.a.c.b.c.d) ZeusTransformUtils.preCheckCast(r3.b(), com.a.c.b.c.d.class, "com.obric.aiagent.plugin")).b().b().intValue();
        if (r7 > 0) goto L5;
    L7:
        r0 = false;
    L8:
        com.a.e.a.a(r0, "Cron Expression for day of week has an invalid period.");
        this.g = a(r6, r7, this.f3154a, this.f3155b);
        return;
    L5:
        if (r7 >= 8) goto L7;
        goto L7
    }

    private static Set<DayOfWeek> a(com.a.b.b r2, int r3, int r4, int r5) {
        ArrayList r0 = new ArrayList(7);
    L3:
        if (r4 > r5) goto L6;
        r0.add(DayOfWeek.of(com.a.b.a.a(r2, com.a.b.a.f3068b, r4)));
        r4 = r4 + r3;
        goto L3
    L6:
        return EnumSet.copyOf(r0);
    }

    @Override // com.a.c.c.a.g, com.a.c.c.a.h
    public int a(int r2) {
    L2:
        r2 = r2 + 1;
        if (b(r2) == true) goto L7;
        if (r2 <= this.f3152d) goto L2;
    L7:
        if (r2 > this.f3152d) goto L10;
        return r2;
    L10:
        throw new j();
    }

    @Override // com.a.c.c.a.g, com.a.c.c.a.h
    public List<Integer> a(int r3, int r4) {
        ArrayList r0 = new ArrayList();
    L3:
        if (r3 >= r4) goto L8;
        r3 = a(r3);     // Catch: j -> L9
        if (r3 >= r4) goto L3;
        r0.add(Integer.valueOf(r3));     // Catch: j -> L9
    L8:
        return r0;
    }

    @Override // com.a.c.c.a.g, com.a.c.c.a.h
    public boolean b(int r3) {
        if (r3 <= this.f3152d) goto L5;
        return false;
    L5:
        if (r3 < 1) goto L11;
        DayOfWeek r4 = LocalDate.of(this.f3153e, this.f, r3).getDayOfWeek();
        return this.g.contains(r4);
    L11:
        return false;
    }
}
