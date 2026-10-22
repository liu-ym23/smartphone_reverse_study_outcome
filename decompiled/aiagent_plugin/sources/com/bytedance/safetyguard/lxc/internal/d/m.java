package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ActionEgressStatus;
import com.bytedance.safetyguard.lxc.api.SensitiveCategoryInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ActionSecurityPayloadParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActionEgressStatus f10245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<SensitiveCategoryInfo> f10246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<SensitiveCategoryInfo> f10247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<SensitiveCategoryInfo> f10248d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (this.f10245a == r6.f10245a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10246b, r6.f10246b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10247c, r6.f10247c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f10248d, r6.f10248d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f10245a.hashCode() * 31) + this.f10246b.hashCode()) * 31) + this.f10247c.hashCode()) * 31) + this.f10248d.hashCode();
    }

    public String toString() {
        return "ParsedActionSecurityContext(status=" + this.f10245a + ", unapprovedCategories=" + this.f10246b + ", deniedCategories=" + this.f10247c + ", approvedCategories=" + this.f10248d + ')';
    }

    public m(ActionEgressStatus r3, List<SensitiveCategoryInfo> r4, List<SensitiveCategoryInfo> r5, List<SensitiveCategoryInfo> r6) {
        List<SensitiveCategoryInfo> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfo> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<SensitiveCategoryInfo> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "status");
        d.h.b.o.e(r7, "unapprovedCategories");
        d.h.b.o.e(r8, "deniedCategories");
        d.h.b.o.e(r9, "approvedCategories");
        this.f10245a = r3;
        this.f10246b = r7;
        this.f10247c = r8;
        this.f10248d = r9;
    }

    public final ActionEgressStatus a() {
        return this.f10245a;
    }

    public final List<SensitiveCategoryInfo> b() {
        return this.f10246b;
    }

    public final List<SensitiveCategoryInfo> c() {
        return this.f10247c;
    }

    public final List<SensitiveCategoryInfo> d() {
        return this.f10248d;
    }
}
