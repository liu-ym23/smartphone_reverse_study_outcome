package com.obric.autogui.agents.scripted.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: PreCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f26874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f26877d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26874a, r6.f26874a) == true) goto L12;
        return false;
    L12:
        if (this.f26875b == r6.f26875b) goto L15;
        return false;
    L15:
        if (o.a(this.f26876c, r6.f26876c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26877d, r6.f26877d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f26874a.hashCode() * 31) + Boolean.hashCode(this.f26875b)) * 31) + this.f26876c.hashCode()) * 31;
        g r2 = this.f26877d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "PreCheckResult(abilityList=" + this.f26874a + ", isWorkerCacheHit=" + this.f26875b + ", initStatus=" + this.f26876c + ", implementationData=" + this.f26877d + ')';
    }

    public i(List<String> r3, boolean r4, String r5, g r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "abilityList");
        o.e(r5, "initStatus");
        this.f26874a = r7;
        this.f26875b = r4;
        this.f26876c = r5;
        this.f26877d = r6;
    }

    public /* synthetic */ i(List r2, boolean r3, String r4, g r5, int r6, d.h.b.h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "success";
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r8, r3, r4, r5);
    }

    public final List<String> a() {
        return this.f26874a;
    }

    public final boolean b() {
        return this.f26875b;
    }

    public final String c() {
        return this.f26876c;
    }

    public final g d() {
        return this.f26877d;
    }
}
