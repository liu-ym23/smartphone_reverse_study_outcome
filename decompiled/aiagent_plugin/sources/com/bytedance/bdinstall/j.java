package com.bytedance.bdinstall;

import com.bytedance.keva.KevaImpl;

/* JADX INFO: compiled from: BDInstallConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aj f6294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6298e;
    private int f;

    public j() {
        this.f6296c = false;
        this.f6297d = false;
        this.f6298e = false;
    }

    public aj a() {
        return this.f6294a;
    }

    public boolean b() {
        return this.f6297d;
    }

    public boolean c() {
        return this.f6298e;
    }

    public int d() {
        return this.f6295b;
    }

    public int e() {
        int r0 = this.f;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    }

    public boolean f() {
        return this.f6296c;
    }
}
