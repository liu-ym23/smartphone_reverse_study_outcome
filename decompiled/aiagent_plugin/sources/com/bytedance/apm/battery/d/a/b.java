package com.bytedance.apm.battery.d.a;

/* JADX INFO: compiled from: BaseHookInfo.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4296e;
    public String f;
    public StackTraceElement[] g;

    public b() {
    }

    String d() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 9;
    L4:
        if (r1 >= this.g.length) goto L7;
        r0.append("\tat ").append(this.g[r1].toString()).append("\n");
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString();
    }
}
