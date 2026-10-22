package com.obric.capabilitykit;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f32152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f32154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f32156e;

    public k(long r2, String r4, String r5, int r6, j r7) {
        d.h.b.o.e(r4, DbHelper.COL_ID);
        d.h.b.o.e(r5, "data");
        d.h.b.o.e(r7, "action");
        this.f32152a = r2;
        this.f32153b = r4;
        this.f32154c = r5;
        this.f32155d = r6;
        this.f32156e = r7;
    }

    public /* synthetic */ k(long r8, String r10, String r11, int r12, j r13, int r14, d.h.b.h r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = -1;
    L5:
        this(r8, r10, r11, r12, r13);
    }

    public final long a() {
        return this.f32152a;
    }

    public final String b() {
        return this.f32153b;
    }

    public final String c() {
        return this.f32154c;
    }

    public final int d() {
        return this.f32155d;
    }

    public final j e() {
        return this.f32156e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, k.class) == true) goto L8;
        return false;
    L8:
        k r10 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.aiagent.plugin");
        if (this.f32152a == r10.f32152a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32153b, r10.f32153b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f32154c, r10.f32154c) == true) goto L18;
        return false;
    L18:
        if (this.f32155d == r10.f32155d) goto L21;
        return false;
    L21:
        if (this.f32156e == r10.f32156e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f32152a) * 31) + this.f32153b.hashCode()) * 31) + this.f32154c.hashCode()) * 31) + Integer.hashCode(this.f32155d)) * 31) + this.f32156e.hashCode();
    }

    public String toString() {
        return "EntityHistoryDao(indexId=" + this.f32152a + ", id=" + this.f32153b + ", data=" + this.f32154c + ", type=" + this.f32155d + ", action=" + this.f32156e + ')';
    }
}
