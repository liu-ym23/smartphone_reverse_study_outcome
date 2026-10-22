package com.bytedance.apm.block;

import android.view.FrameMetrics;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6365a;

    public a() {
        this.f6365a = false;
    }

    public void a(String r10) {
        this.f6365a = true;
    }

    public void b(long r10, long r11, long r12, long r13, boolean r14) {
        this.f6365a = false;
    }

    public boolean c() {
        return this.f6365a;
    }

    public void d(String r10, long r11, int r12) {
    }

    public void e(String r10, FrameMetrics r11, int r12) {
    }
}
