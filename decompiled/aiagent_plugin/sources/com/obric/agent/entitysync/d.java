package com.obric.agent.entitysync;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f14498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f14499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f14500c;

    public static /* synthetic */ d a(d r0, i r1, e r2, i r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f14498a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f14499b;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.f14500c;
    L12:
        return r0.a(r1, r2, r3);
    }

    public final d a(i r1, e r2, i r3) {
        o.e(r1, "latest");
        o.e(r2, "state");
        return new d(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14498a, r6.f14498a) == true) goto L12;
        return false;
    L12:
        if (this.f14499b == r6.f14499b) goto L15;
        return false;
    L15:
        if (o.a(this.f14500c, r6.f14500c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f14498a.hashCode() * 31) + this.f14499b.hashCode()) * 31;
        i r2 = this.f14500c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AppEntityItemMutation(latest=" + this.f14498a + ", state=" + this.f14499b + ", previous=" + this.f14500c + ')';
    }

    public d(i r2, e r3, i r4) {
        o.e(r2, "latest");
        o.e(r3, "state");
        this.f14498a = r2;
        this.f14499b = r3;
        this.f14500c = r4;
    }

    public final i a() {
        return this.f14498a;
    }

    public final e b() {
        return this.f14499b;
    }
}
