package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocationMonitorModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f17134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f17135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Float f17136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Float f17137e;
    private final Boolean f;
    private final String g;

    public static /* synthetic */ i a(i r9, long r10, float r12, float r13, Float r14, Float r15, Boolean r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.f17133a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        float r3 = r9.f17134b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        float r4 = r9.f17135c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Float r5 = r9.f17136d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Float r6 = r9.f17137e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Boolean r7 = r9.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.g;
    L31:
        return r9.a(r1, r3, r4, r5, r6, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final i a(long r11, float r13, float r14, Float r15, Float r16, Boolean r17, String r18) {
        d.h.b.o.e(r18, "provider");
        return new i(r11, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
        return false;
    L8:
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if (this.f17133a == r10.f17133a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f17134b, r10.f17134b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f17135c, r10.f17135c) == 0) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f17136d, r10.f17136d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f17137e, r10.f17137e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.f17133a) * 31) + Float.hashCode(this.f17134b)) * 31) + Float.hashCode(this.f17135c)) * 31;
        Float r1 = this.f17136d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Float r5 = this.f17137e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Boolean r8 = this.f;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.g.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "LocationMonitorFeatureFrame(timeDelta=" + this.f17133a + ", speed=" + this.f17134b + ", accuracy=" + this.f17135c + ", distanceDelta=" + this.f17136d + ", distanceBoundary=" + this.f17137e + ", shouldTrigger=" + this.f + ", provider=" + this.g + ')';
    }

    public i(long r2, float r4, float r5, Float r6, Float r7, Boolean r8, String r9) {
        d.h.b.o.e(r9, "provider");
        this.f17133a = r2;
        this.f17134b = r4;
        this.f17135c = r5;
        this.f17136d = r6;
        this.f17137e = r7;
        this.f = r8;
        this.g = r9;
    }

    public final long a() {
        return this.f17133a;
    }

    public final float b() {
        return this.f17134b;
    }

    public final float c() {
        return this.f17135c;
    }

    public final Float d() {
        return this.f17136d;
    }

    public final Float e() {
        return this.f17137e;
    }

    public final Boolean f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }
}
