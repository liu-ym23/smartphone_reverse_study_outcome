package com.bytedance.apm.block;

import android.view.FrameMetrics;

/* JADX INFO: compiled from: AbsLooperObserver.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4350a;

    public void a(String r1, long r2, int r4) {
    }

    public void a(String r1, long r2, long r4) {
    }

    public void a(String r1, FrameMetrics r2, int r3) {
    }

    public a() {
        this.f4350a = false;
    }

    public void a(String r1) {
        this.f4350a = true;
    }

    public void a(long r1, long r3, long r5, long r7, boolean r9) {
        this.f4350a = false;
    }

    public boolean a() {
        return this.f4350a;
    }
}
