package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillManager.kt */
/* JADX INFO: loaded from: classes3.dex */
final class bk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<bj> f19567a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bk.class) == true) goto L8;
        return false;
    L8:
        bk r6 = (bk) ZeusTransformUtils.preCheckCast(r5, bk.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19567a, r6.f19567a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f19567a.hashCode();
    }

    public String toString() {
        return "SkillExistenceCleanupSummary(results=" + this.f19567a + ')';
    }

    public bk(List<bj> r3) {
        List<bj> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "results");
        this.f19567a = r4;
    }

    public final List<bj> a() {
        return this.f19567a;
    }

    public final int b() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19567a, Iterable.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        if (((bj) ZeusTransformUtils.preCheckCast(r5.next(), bj.class, "com.obric.aiagent.plugin")).a() == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        d.a.p.d();
    L15:
        return r2;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final int c() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19567a, Iterable.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        if ((!((bj) ZeusTransformUtils.preCheckCast(r5.next(), bj.class, "com.obric.aiagent.plugin")).b()) == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        d.a.p.d();
    L15:
        return r2;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }
}
