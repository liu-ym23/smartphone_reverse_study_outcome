package com.bytedance.crash.upload;

/* JADX INFO: compiled from: UploadLimitConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7829e;
    private boolean f;

    public m(int r2, int r3, int r4, int r5, int r6) {
        this.f7825a = 50;
        this.f7826b = 100;
        this.f7827c = 100;
        this.f7828d = 5;
        this.f7829e = 2;
        if (r2 <= 0) goto L5;
        this.f7825a = r2;
    L5:
        if (r3 <= 0) goto L7;
        this.f7826b = r3;
    L7:
        if (r4 <= 0) goto L9;
        this.f7827c = r4;
    L9:
        if (r5 <= 0) goto L11;
        this.f7828d = r5;
    L11:
        if (r6 <= 0) goto L14;
        this.f7829e = r6;
        return;
    }

    public boolean a() {
        return this.f;
    }

    public int b() {
        return this.f7825a;
    }

    public int c() {
        return this.f7826b;
    }

    public int d() {
        return this.f7827c;
    }

    public int e() {
        return this.f7828d;
    }

    public int f() {
        return this.f7829e;
    }

    public String toString() {
        return "UploadLimitConfig{crashLimitIssue=" + this.f7825a + ", crashLimitAll=" + this.f7826b + ", exceptionAllLimit=" + this.f7827c + ", exceptionMsgLimit=" + this.f7828d + ", exceptionStackLimit=" + this.f7829e + ", isNoLimit=" + this.f + '}';
    }
}
