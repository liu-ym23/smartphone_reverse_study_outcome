package com.bytedance.apm.perf.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TrafficUsageModel.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4789e;

    public h(String r1, long r2, String r4) {
        this.f4785a = r1;
        this.f4787c = r2;
        this.f4789e = System.currentTimeMillis();
        this.f4788d = 1;
        this.f4786b = r4;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r4) {
        h r5 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin");
        long r0 = this.f4787c;
        long r3 = r5.f4787c;
        if (r0 != r3) goto L7;
        return 0;
    L7:
        if (r0 <= r3) goto L10;
        return 1;
    L10:
        return -1;
    }
}
