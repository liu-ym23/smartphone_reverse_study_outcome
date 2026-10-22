package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f20160b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20159a, r6.f20159a) == true) goto L12;
        return false;
    L12:
        if (this.f20160b == r6.f20160b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f20159a.hashCode() * 31) + this.f20160b.hashCode();
    }

    public String toString() {
        return "CliUpdateResult(name=" + this.f20159a + ", outcome=" + this.f20160b + ')';
    }

    public q(String r2, n r3) {
        d.h.b.o.e(r2, "name");
        d.h.b.o.e(r3, "outcome");
        this.f20159a = r2;
        this.f20160b = r3;
    }

    public final n a() {
        return this.f20160b;
    }
}
