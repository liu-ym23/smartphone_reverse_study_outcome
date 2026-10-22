package com.bytedance.apm.block.trace;

import android.os.SystemClock;

/* JADX INFO: compiled from: MainThreadInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f4426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4427b;

    public e() {
        this.f4426a = new long[4];
        this.f4427b = false;
    }

    public void a() {
        long[] r0 = this.f4426a;
        r0[0] = 0;
        r0[1] = 0;
        r0[2] = Long.MAX_VALUE;
        r0[3] = 0;
        this.f4427b = false;
    }

    public boolean b() {
        long[] r5 = this.f4426a;
        if ((r5[0] - r5[2]) <= 100) goto L6;
        return true;
    L6:
        return false;
    }

    public void a(long r7) {
        long[] r0 = this.f4426a;
        if (r0[0] != 0) goto L5;
        r0[0] = SystemClock.uptimeMillis();
    L5:
        long[] r1 = this.f4426a;
        r1[1] = r1[1] + 1;
        if (r7 >= r1[2]) goto L9;
        r1[2] = r7;
    L9:
        if (r7 <= r1[3]) goto L11;
        r1[3] = r7;
    L11:
        this.f4427b = true;
    }
}
