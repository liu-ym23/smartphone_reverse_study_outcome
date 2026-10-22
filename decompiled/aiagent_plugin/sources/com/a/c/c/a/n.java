package com.a.c.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;

/* JADX INFO: compiled from: OnDayOfWeekValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class n extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.a.c.b.c.f f3160d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.a.b.b f3161e;

    /* JADX INFO: renamed from: com.a.c.c.a.n$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnDayOfWeekValueGenerator.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3162a = null;

        static {
            int[] r0 = new int[com.a.c.b.d.c.values().length];
            f3162a = r0;
            r0[com.a.c.b.d.c.f3135d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f3162a[com.a.c.b.d.c.f3133b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f3162a[com.a.c.b.d.c.f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f3160d = new com.a.c.b.c.f(new com.a.c.b.d.b(7));
    }

    public n(com.a.c.b.a r1, int r2, int r3, com.a.b.b r4) {
        super(r1, r2, r3);
        com.a.e.a.a(com.a.c.b.b.f.equals(r1.a()), "CronField does not belong to day of week");
        this.f3161e = r4;
    }

    @Override // com.a.c.c.a.h
    public int a(int r4) {
        int r3 = a((com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.f.class, "com.obric.aiagent.plugin"), this.f3157a, this.f3158b, r4);
        if (r3 <= r4) goto L6;
        return r3;
    L6:
        throw new j();
    }

    @Override // com.a.c.c.a.h
    public boolean b(int r6) {
        if (r6 != a((com.a.c.b.c.f) ZeusTransformUtils.preCheckCast(this.f3156c.b(), com.a.c.b.c.f.class, "com.obric.aiagent.plugin"), this.f3157a, this.f3158b, r6 - 1)) goto L10;
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

    private int a(com.a.c.b.c.f r3, int r4, int r5, int r6) {
        int r0 = AnonymousClass1.f3162a[r3.f().b().ordinal()];
        if (r0 == 1) goto L18;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return b(r3, r4, r5, r6);
    L11:
        throw new j();
    L13:
        if (r3.b().b().intValue() != (-1)) goto L16;
        return b(f3160d, r4, r5, r6);
    L16:
        return b(r3, r4, r5);
    L18:
        return a(r3, r4, r5);
    }

    private int a(com.a.c.b.c.f r3, int r4, int r5) {
        DayOfWeek r6 = LocalDate.of(r4, r5, 1).getDayOfWeek();
        int r2 = com.a.b.a.a(this.f3161e, com.a.b.a.f3068b, r3.b().b().intValue());
        int r7 = r3.c().b().intValue();
        int r8 = r6.getValue() - r2;
        if (r8 >= 0) goto L5;
        int r9 = Math.abs(r8) + 1;
    L6:
        if (r8 <= 0) goto L9;
        r9 = (r9 + 7) - r8;
    L9:
        return ((r7 - 1) * 7) + r9;
    L5:
        r9 = 1;
        goto L6
    }

    private int b(com.a.c.b.c.f r3, int r4, int r5) {
        LocalDate r6 = LocalDate.of(r4, r5, LocalDate.of(r4, r5, 1).lengthOfMonth());
        int r7 = r6.getDayOfWeek().getValue();
        int r2 = com.a.b.a.a(this.f3161e, com.a.b.a.f3068b, r3.b().b().intValue());
        int r8 = r7 - r2;
        if (r8 == 0) goto L5;
        if (r8 < 0) goto L8;
        if (r8 <= 0) goto L13;
        return r6.minusDays(r8).getDayOfMonth();
    L13:
        throw new j();
    L8:
        return r6.minusDays(((long) r7) + ((long) (7 - r2))).getDayOfMonth();
    L5:
        return r6.getDayOfMonth();
    }

    private int b(com.a.c.b.c.f r2, int r3, int r4, int r5) {
        int r6 = LocalDate.of(r3, r4, 1).getDayOfWeek().getValue() - com.a.b.a.a(this.f3161e, com.a.b.a.f3068b, r2.b().b().intValue());
        if (r6 >= 0) goto L5;
        int r1 = Math.abs(r6) + 1;
    L6:
        if (r6 <= 0) goto L8;
        r1 = (r1 + 7) - r6;
    L8:
        if (r5 >= 1) goto L10;
        return r1;
    L10:
        if (r1 > r5) goto L12;
        r1 = r1 + 7;
        goto L10
    L12:
        return r1;
    L5:
        r1 = 1;
        goto L6
    }
}
