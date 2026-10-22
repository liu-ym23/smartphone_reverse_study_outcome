package com.obric.performance.power.monitor.cpu.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ThreadWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f36987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f36988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f36989c;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, d.class) == true) goto L8;
        return false;
    L8:
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36987a, r8.f36987a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f36988b, r8.f36988b) == true) goto L15;
        return false;
    L15:
        if (this.f36989c == r8.f36989c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f36987a.hashCode() * 31) + this.f36988b.hashCode()) * 31) + Long.hashCode(this.f36989c);
    }

    public String toString() {
        return "ThreadWrapper(tName=" + this.f36987a + ", rThread=" + this.f36988b + ", startTimeStamp=" + this.f36989c + ')';
    }

    public d(String r2, Thread r3, long r4) {
        o.e(r2, "tName");
        o.e(r3, "rThread");
        this.f36987a = r2;
        this.f36988b = r3;
        this.f36989c = r4;
    }

    public /* synthetic */ d(String r1, Thread r2, long r3, int r5, h r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }

    public final String a() {
        return this.f36987a;
    }

    public final void a(long r1) {
        this.f36989c = r1;
    }

    public final Thread b() {
        return this.f36988b;
    }
}
