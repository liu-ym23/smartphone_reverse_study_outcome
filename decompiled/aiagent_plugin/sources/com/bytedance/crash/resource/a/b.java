package com.bytedance.crash.resource.a;

import com.bytedance.crash.config.h;
import com.bytedance.crash.resource.c;

/* JADX INFO: compiled from: FdTrackConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    protected boolean h;
    protected boolean i;
    protected boolean j;
    protected int k;
    protected int l;
    protected int m;
    protected long n;

    public b(boolean r5, boolean r6, int r7, int r8, long r9, int r11) {
        super(21, 35, 2);
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = 500;
        this.l = 1000;
        this.m = 10;
        this.n = 60000;
        if (h.g() == false) goto L5;
        this.h = true;
        this.i = true;
        this.k = 200;
        this.l = 400;
        this.n = 1000;
        this.m = 10;
        this.j = true;
        return;
    L5:
        this.h = r5;
        this.i = r6;
        this.k = r7;
        this.l = r8;
        this.n = Math.max(1000, r9);
        this.m = r11;
    }

    @Override // com.bytedance.crash.resource.c
    public String toString() {
        return "fdTrackEnable=" + this.h + "\nwaterLine=" + this.k + "\ndumpLine=" + this.l + "\nloopMonitorEnable=" + this.i + "\nmSleepTime=" + this.n + "\nmBacktraceLimit=" + this.m + "\ndebug=" + this.j + "\n";
    }
}
