package com.bytedance.apm.agent.tracing;

/* JADX INFO: compiled from: PageTraceEntity.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4139e;
    public long f;
    public long g;

    public b(String r1, long r2) {
        this.f4135a = r1;
        this.f4136b = r2;
    }

    public boolean a() {
        if (this.f4136b > 0) goto L5;
    L11:
        return false;
    L5:
        if (this.f4137c <= 0) goto L11;
        if (this.f4138d <= 0) goto L11;
        if (this.f4139e <= 0) goto L11;
        return true;
    }
}
