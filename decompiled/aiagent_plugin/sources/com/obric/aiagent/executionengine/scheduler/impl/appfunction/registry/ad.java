package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionSkillSourceReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<m> f18210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ac f18212d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ad.class) == true) goto L8;
        return false;
    L8:
        ad r6 = (ad) ZeusTransformUtils.preCheckCast(r5, ad.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18209a, r6.f18209a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18210b, r6.f18210b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f18211c, r6.f18211c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18212d, r6.f18212d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f18209a.hashCode() * 31) + this.f18210b.hashCode()) * 31) + this.f18211c.hashCode()) * 31) + this.f18212d.hashCode();
    }

    public String toString() {
        return "AppFunctionSkillSource(packageName=" + this.f18209a + ", entries=" + this.f18210b + ", skillName=" + this.f18211c + ", original=" + this.f18212d + ')';
    }

    public ad(String r3, List<m> r4, String r5, ac r6) {
        List<m> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        ac r8 = (ac) ZeusTransformUtils.wrapperContextForParams(r6, ac.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "packageName");
        d.h.b.o.e(r7, "entries");
        d.h.b.o.e(r5, "skillName");
        d.h.b.o.e(r8, "original");
        this.f18209a = r3;
        this.f18210b = r7;
        this.f18211c = r5;
        this.f18212d = r8;
    }

    public final String a() {
        return this.f18209a;
    }

    public final List<m> b() {
        return this.f18210b;
    }

    public final String c() {
        return this.f18211c;
    }

    public final ac d() {
        return this.f18212d;
    }
}
