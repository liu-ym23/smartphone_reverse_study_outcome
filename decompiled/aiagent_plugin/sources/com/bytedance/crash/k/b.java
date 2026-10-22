package com.bytedance.crash.k;

import org.json.JSONArray;

/* JADX INFO: compiled from: RepairConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.crash.npth_repair.a.b f7561d;

    public b(int r2, int r3, boolean r4, JSONArray r5) {
        this.f7558a = 60000;
        this.f7559b = r2;
        if (r3 <= 0) goto L5;
        this.f7558a = r3;
    L5:
        this.f7560c = r4;
        this.f7561d = com.bytedance.crash.npth_repair.a.b.a(r5);
    }

    public int a() {
        return this.f7558a;
    }

    public int b() {
        return this.f7559b;
    }

    public boolean c() {
        return this.f7560c;
    }

    public com.bytedance.crash.npth_repair.a.b d() {
        return this.f7561d;
    }
}
