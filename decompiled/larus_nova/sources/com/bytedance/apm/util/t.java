package com.bytedance.apm.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f190684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f190685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f190686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f190687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f190688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f190689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f190690g;

    public t(int r100, String r101, long r102) {
        this.f190684a = r100;
        this.f190685b = r101;
        this.f190686c = r102;
        this.f190687d = 0.0f;
    }

    public t(int r100, String r101, long r102, long r103, long r104) {
        this.f190684a = r100;
        this.f190685b = r101;
        this.f190688e = r102;
        this.f190689f = r103;
        this.f190686c = r102 + r103;
        long r105 = ((SystemClock.elapsedRealtime() * b.f()) / 1000) - r104;
        this.f190690g = r105;
        this.f190687d = (this.f190686c * 1.0f) / r105;
    }
}
