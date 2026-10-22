package com.obric.agent.entitysync;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, j> f14544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f14545d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L8;
        return false;
    L8:
        m r10 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
        if (this.f14542a == r10.f14542a) goto L12;
        return false;
    L12:
        if (o.a(this.f14543b, r10.f14543b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f14544c, r10.f14544c) == true) goto L18;
        return false;
    L18:
        if (this.f14545d == r10.f14545d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f14542a) * 31;
        String r1 = this.f14543b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.f14544c.hashCode()) * 31) + Long.hashCode(this.f14545d);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "PreparedEntityQuery(round=" + this.f14542a + ", queryKey=" + this.f14543b + ", updates=" + this.f14544c + ", eventVersion=" + this.f14545d + ')';
    }

    public m(long r3, String r5, Map<String, j> r6, long r7) {
        Map<String, j> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "updates");
        this.f14542a = r3;
        this.f14543b = r5;
        this.f14544c = r8;
        this.f14545d = r7;
    }

    public final long a() {
        return this.f14542a;
    }

    public final String b() {
        return this.f14543b;
    }

    public final Map<String, j> c() {
        return this.f14544c;
    }

    public final long d() {
        return this.f14545d;
    }
}
