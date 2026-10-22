package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<gw> f20059a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, gx.class) == true) goto L8;
        return false;
    L8:
        gx r6 = (gx) ZeusTransformUtils.preCheckCast(r5, gx.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20059a, r6.f20059a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f20059a.hashCode();
    }

    public String toString() {
        return "SkillStoreMetadataRefreshSummary(results=" + this.f20059a + ')';
    }

    public gx(List<gw> r3) {
        List<gw> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "results");
        this.f20059a = r4;
    }

    public final List<gw> a() {
        return this.f20059a;
    }

    public final int b() {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.f20059a, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
        int r0 = 0;
    L9:
        if (r7.hasNext() == false) goto L22;
        gw r3 = (gw) ZeusTransformUtils.preCheckCast(r7.next(), gw.class, "com.obric.aiagent.plugin");
        if (r3.a() != gv.f20055d) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        d.a.p.d();
        goto L9
    L13:
        if (r3.a() == gv.f20056e) goto L16;
        r4 = false;
        goto L17
    L22:
        return r0;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return 0;
    }
}
