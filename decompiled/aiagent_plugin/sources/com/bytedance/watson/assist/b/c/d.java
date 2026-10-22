package com.bytedance.watson.assist.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProcStatInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.watson.assist.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f11840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f11841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f11842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f11843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f11844e;
    protected double f;
    protected double g;
    protected double h;
    protected double i;

    public d() {
        this.f11840a = null;
        this.f11841b = -1;
        this.f11842c = 0;
        this.f11843d = 0;
        this.f11844e = 0;
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = 0.0d;
        this.i = 0.0d;
    }

    public long a() {
        return this.f11843d;
    }

    public void a(long r5) {
        if (this.f11843d >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.f = a() / r5;
        return;
    }

    public void b(long r5) {
        if (this.f11843d >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.h = a() / r5;
        return;
    }

    public void a(com.bytedance.watson.assist.c.b r7) {
        com.bytedance.watson.assist.c.b r8 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.watson.assist.c.b.class, "com.obric.aiagent.plugin");
        long r2 = b();
        if (r8 != null) goto L5;
        long r0 = 0;
    L6:
        long r3 = r2 - r0;
        this.f11843d = r3;
        if (this.f11844e != 0) goto L10;
        this.f11844e = r3;
        return;
    L10:
        return;
    L5:
        r0 = ((d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin")).b();
        goto L6
    }

    public void a(int r1) {
        this.f11841b = r1;
    }

    public void a(String r1) {
        this.f11840a = r1;
    }

    public long b() {
        return this.f11842c;
    }

    public void c(long r1) {
        this.f11842c = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("proc_stat:{pid=").append(this.f11841b).append(" process_name:").append(this.f11840a).append(" delta cpu_time:").append(a()).append(" cpu_usage:").append(this.f * 100.0d).append("%").append(" cpu_rate:").append(this.h).append("}");
        return r0.toString();
    }
}
