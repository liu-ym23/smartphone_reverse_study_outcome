package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSkillSpellManager.kt */
/* JADX INFO: loaded from: classes2.dex */
final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18238c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, am.class) == true) goto L8;
        return false;
    L8:
        am r6 = (am) ZeusTransformUtils.preCheckCast(r5, am.class, "com.obric.aiagent.plugin");
        if (this.f18236a == r6.f18236a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18237b, r6.f18237b) == true) goto L15;
        return false;
    L15:
        if (this.f18238c == r6.f18238c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f18236a) * 31) + this.f18237b.hashCode()) * 31) + Integer.hashCode(this.f18238c);
    }

    public String toString() {
        return "SpellSyncTransportFailure(providerCode=" + this.f18236a + ", providerMessage=" + this.f18237b + ", attempt=" + this.f18238c + ')';
    }

    public am(int r2, String r3, int r4) {
        d.h.b.o.e(r3, "providerMessage");
        this.f18236a = r2;
        this.f18237b = r3;
        this.f18238c = r4;
    }

    public final int a() {
        return this.f18236a;
    }

    public final String b() {
        return this.f18237b;
    }

    public final int c() {
        return this.f18238c;
    }
}
