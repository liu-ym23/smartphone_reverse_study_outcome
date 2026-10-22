package com.obric.agent.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: NlgResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14463b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f14462a == r6.f14462a) goto L12;
        return false;
    L12:
        if (o.a(this.f14463b, r6.f14463b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f14462a) * 31;
        String r1 = this.f14463b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "NlgResult(needSummary=" + this.f14462a + ", nlg=" + this.f14463b + ')';
    }

    public b(boolean r1, String r2) {
        this.f14462a = r1;
        this.f14463b = r2;
    }

    public final boolean a() {
        return this.f14462a;
    }

    public final String b() {
        return this.f14463b;
    }
}
