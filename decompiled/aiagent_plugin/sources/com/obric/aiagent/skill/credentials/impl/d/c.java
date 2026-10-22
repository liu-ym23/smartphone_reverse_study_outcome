package com.obric.aiagent.skill.credentials.impl.d;

import com.obric.aiagent.skill.credentials.api.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskSessionCapability.kt */
/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f19079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19080b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f19079a, r6.f19079a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f19080b, r6.f19080b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19079a.hashCode() * 31) + this.f19080b.hashCode();
    }

    public String toString() {
        return "TaskSessionRecord(env=" + this.f19079a + ", cliName=" + this.f19080b + ')';
    }

    public c(g r2, String r3) {
        o.e(r2, "env");
        o.e(r3, "cliName");
        this.f19079a = r2;
        this.f19080b = r3;
    }

    public final g a() {
        return this.f19079a;
    }

    public final String b() {
        return this.f19080b;
    }
}
