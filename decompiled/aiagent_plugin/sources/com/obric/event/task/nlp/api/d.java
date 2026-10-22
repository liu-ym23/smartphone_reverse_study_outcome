package com.obric.event.task.nlp.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DataCheckResult.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f32898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f32901d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f32898a, r6.f32898a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32899b, r6.f32899b) == true) goto L15;
        return false;
    L15:
        if (this.f32900c == r6.f32900c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f32901d, r6.f32901d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        T r0 = this.f32898a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f32899b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.f32900c)) * 31;
        String r7 = this.f32901d;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DataCheckResult(result=" + this.f32898a + ", errMsg=" + this.f32899b + ", errCode=" + this.f32900c + ", successMsg=" + this.f32901d + ')';
    }

    public d(T r1, String r2, int r3, String r4) {
        this.f32898a = r1;
        this.f32899b = r2;
        this.f32900c = r3;
        this.f32901d = r4;
    }

    public /* synthetic */ d(Object r2, String r3, int r4, String r5, int r6, d.h.b.h r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }

    public final T a() {
        return this.f32898a;
    }

    public final String b() {
        return this.f32899b;
    }

    public final int c() {
        return this.f32900c;
    }

    public final String d() {
        return this.f32901d;
    }
}
