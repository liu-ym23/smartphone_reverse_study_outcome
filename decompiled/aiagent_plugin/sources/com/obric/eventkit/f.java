package com.obric.eventkit;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskKnowledgeApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f33216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f33217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f33218c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f33216a == r6.f33216a) goto L12;
        return false;
    L12:
        if (o.a(this.f33217b, r6.f33217b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f33218c, r6.f33218c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f33216a) * 31;
        T r1 = this.f33217b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f33218c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TaskKnowledgeStatusData(ok=" + this.f33216a + ", payload=" + this.f33217b + ", message=" + this.f33218c + ')';
    }

    public f(boolean r1, T r2, String r3) {
        this.f33216a = r1;
        this.f33217b = r2;
        this.f33218c = r3;
    }

    public final boolean a() {
        return this.f33216a;
    }

    public final T b() {
        return this.f33217b;
    }

    public final String c() {
        return this.f33218c;
    }
}
