package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: HostResolveJob.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable, Comparable<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f8505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8508d;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(c r3) {
        return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"));
    }

    public int a(c r4) {
        long r0 = r4.f8508d;
        long r3 = this.f8508d;
        if (r0 != r3) goto L7;
        return 0;
    L7:
        if (r0 >= r3) goto L9;
        return -1;
    L9:
        return 1;
    }

    public String a() {
        return this.f8506b;
    }

    public boolean b() {
        return this.f8507c;
    }
}
