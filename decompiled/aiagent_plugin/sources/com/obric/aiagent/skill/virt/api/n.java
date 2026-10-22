package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f21583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f21584b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21583a, r6.f21583a) == true) goto L12;
        return false;
    L12:
        if (this.f21584b == r6.f21584b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f21583a.hashCode() * 31) + this.f21584b.hashCode();
    }

    public String toString() {
        return "ShellExecutionResult(snapshot=" + this.f21583a + ", returnReason=" + this.f21584b + ')';
    }

    public n(p r2, o r3) {
        d.h.b.o.e(r2, "snapshot");
        d.h.b.o.e(r3, "returnReason");
        this.f21583a = r2;
        this.f21584b = r3;
    }

    public final p a() {
        return this.f21583a;
    }

    public final o b() {
        return this.f21584b;
    }
}
