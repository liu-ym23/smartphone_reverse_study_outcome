package com.obric.eventkit;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskKnowledgeApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f33206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f33207b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f33206a == r6.f33206a) goto L12;
        return false;
    L12:
        if (o.a(this.f33207b, r6.f33207b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f33206a) * 31) + this.f33207b.hashCode();
    }

    public String toString() {
        return "TaskKnowledgeNetworkResponse(ok=" + this.f33206a + ", data=" + this.f33207b + ')';
    }

    public c(boolean r2, String r3) {
        o.e(r3, "data");
        this.f33206a = r2;
        this.f33207b = r3;
    }

    public final boolean a() {
        return this.f33206a;
    }

    public final String b() {
        return this.f33207b;
    }
}
