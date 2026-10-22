package com.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: WeekDay.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3071b;

    /* JADX INFO: renamed from: lambda$YANj68DJ5GKSPZ-RlHRBaLPUuCU, reason: not valid java name */
    public static /* synthetic */ Integer m16lambda$YANj68DJ5GKSPZRlHRBaLPUuCU(b r0, b r1, int r2, int r3, Integer r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public b(int r3, boolean r4) {
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        com.a.e.a.a(r0, "Monday Day of Week value must be greater or equal to zero");
        this.f3070a = r3;
        this.f3071b = r4;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int a() {
        return this.f3070a;
    }

    public boolean b() {
        return this.f3071b;
    }

    public int a(int r6, b r7) {
        if (this.f3071b == false) goto L9;
        if (r7.b() == false) goto L9;
        return ((Integer) ZeusTransformUtils.preCheckCast(a(0, 6, this, r7).apply(Integer.valueOf(r6)), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L9:
        if (this.f3071b == true) goto L15;
        if (r7.b() == true) goto L15;
        return ((Integer) ZeusTransformUtils.preCheckCast(a(1, 7, this, r7).apply(Integer.valueOf(r6)), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L15:
        if (r7.b() == false) goto L19;
        return a(r6, new b(r7.a() + 1, false)) - 1;
    L19:
        return (a(r6, new b(r7.a() - 1, true)) % 7) + 1;
    }

    private com.a.a<Integer, Integer> a(final int r1, final int r2, final b r3, final b r4) {
        return new $$Lambda$b$YANj68DJ5GKSPZRlHRBaLPUuCU(r4, r3, r1, r2);
    }

    private static /* synthetic */ Integer a(b r1, b r2, int r3, int r4, Integer r5) {
        int r6 = r1.a() - r2.a();
        int r7 = r5.intValue();
        if (r6 != 0) goto L5;
        return r5;
    L5:
        if (r6 >= 0) goto L9;
        r7 = r5.intValue() + r6;
        int r0 = r3 - r7;
        if (r7 >= r3) goto L9;
        r7 = (r4 + 1) - r0;
    L9:
        if (r6 <= 0) goto L14;
        r7 = r5.intValue() + r6;
        if (r7 <= r4) goto L14;
        r7 = r7 - r4;
    L14:
        return Integer.valueOf(r7);
    }
}
