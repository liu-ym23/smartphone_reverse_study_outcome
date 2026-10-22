package com.obric.aiagent.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: RequestRestrictConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f22229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f22230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f22231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<d> f22232d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
        return false;
    L8:
        e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if (this.f22229a == r10.f22229a) goto L12;
        return false;
    L12:
        if (this.f22230b == r10.f22230b) goto L15;
        return false;
    L15:
        if (o.a(this.f22231c, r10.f22231c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f22232d, r10.f22232d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f22229a) * 31) + Long.hashCode(this.f22230b)) * 31) + this.f22231c.hashCode()) * 31) + this.f22232d.hashCode();
    }

    public String toString() {
        return "RequestRestrictConfig(isDebug=" + this.f22229a + ", durationBeforeRestrict=" + this.f22230b + ", allowUsers=" + this.f22231c + ", excludeRules=" + this.f22232d + ')';
    }

    public e(boolean r3, long r4, Set<String> r6, Set<d> r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        Set<d> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        o.e(r8, "allowUsers");
        o.e(r9, "excludeRules");
        this.f22229a = r3;
        this.f22230b = r4;
        this.f22231c = r8;
        this.f22232d = r9;
    }

    public final long a() {
        return this.f22230b;
    }

    public final Set<String> b() {
        return this.f22231c;
    }

    public final Set<d> c() {
        return this.f22232d;
    }
}
