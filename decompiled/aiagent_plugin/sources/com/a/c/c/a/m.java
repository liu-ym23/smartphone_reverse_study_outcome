package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;

/* JADX INFO: compiled from: OnDayOfMonthValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class m extends l {

    /* JADX INFO: renamed from: com.a.c.c.a.m$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnDayOfMonthValueGenerator.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3159a = null;

        static {
            int[] r0 = new int[com.a.c.b.d.c.values().length];
            f3159a = r0;
            r0[com.a.c.b.d.c.f3133b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f3159a[com.a.c.b.d.c.f3134c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f3159a[com.a.c.b.d.c.f3132a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public m(com.a.c.b.a r1, int r2, int r3) {
        super(r1, r2, r3);
        com.a.e.a.a(com.a.c.b.b.f3107d.equals(r1.a()), "CronField does not belong to day of month");
    }

    @Override // com.a.c.c.a.h
    public int a(int r4) {
        int r3 = a((com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.f.class, "com.obric.aiagent.plugin"), this.f3157a, this.f3158b);
        if (r3 <= r4) goto L6;
        return r3;
    L6:
        throw new j();
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r5) {
        com.a.c.b.c.f r0 = (com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.f.class, "com.obric.aiagent.plugin");
        if (r5 != a(r0, this.f3157a, this.f3158b)) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    @Override // com.a.c.c.a.h
    public boolean a(com.a.c.b.c.e r1) {
        return ZeusTransformUtils.instanceOf(r1, com.a.c.b.c.f.class);
    }

    private int a(com.a.c.b.c.f r4, int r5, int r6) {
        int r3 = r4.b().b().intValue();
        int r0 = AnonymousClass1.f3159a[r4.f().b().ordinal()];
        if (r0 != 1) goto L5;
        int r7 = r4.c().b().intValue();
        int r8 = LocalDate.of(r5, r6, 1).lengthOfMonth();
        if (r7 > 0) goto L32;
        r7 = 0;
    L32:
        return r8 - r7;
    L5:
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L14;
        LocalDate r9 = LocalDate.of(r5, r6, LocalDate.of(r5, r6, 1).lengthOfMonth());
        int r10 = r9.getDayOfWeek().getValue() - 5;
        if (r10 <= 0) goto L12;
        return r9.minusDays(r10).getDayOfMonth();
    L12:
        return r9.getDayOfMonth();
    L14:
        throw new j();
    L15:
        LocalDate r11 = LocalDate.of(r5, r6, r3);
        if (r11.getDayOfWeek() != DayOfWeek.SATURDAY) goto L22;
        if (r3 != 1) goto L20;
        return 3;
    L20:
        return r3 - 1;
    L22:
        if (r11.getDayOfWeek() != DayOfWeek.SUNDAY) goto L26;
        int r12 = r3 + 1;
        if (r12 > r11.lengthOfMonth()) goto L26;
        return r12;
    L26:
        return r3;
    }
}
