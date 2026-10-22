package com.obric.aiagent.skill.ovirt.impl.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BashOutputKeeping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21365b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21364a, r6.f21364a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21365b, r6.f21365b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f21364a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f21365b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BashOutputPaths(stdoutPath=" + this.f21364a + ", stderrPath=" + this.f21365b + ')';
    }

    public c(String r1, String r2) {
        this.f21364a = r1;
        this.f21365b = r2;
    }

    public final String a() {
        return this.f21364a;
    }

    public final String b() {
        return this.f21365b;
    }
}
