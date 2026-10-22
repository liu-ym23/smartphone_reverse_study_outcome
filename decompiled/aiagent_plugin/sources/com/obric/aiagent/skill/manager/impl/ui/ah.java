package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f20504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Object> f20505b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ah.class) == true) goto L8;
        return false;
    L8:
        ah r6 = (ah) ZeusTransformUtils.preCheckCast(r5, ah.class, "com.obric.aiagent.plugin");
        if (this.f20504a == r6.f20504a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20505b, r6.f20505b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f20504a) * 31) + this.f20505b.hashCode();
    }

    public String toString() {
        return "SkillFileFailureSubtitle(resId=" + this.f20504a + ", formatArgs=" + this.f20505b + ')';
    }

    public ah(int r3, List<? extends Object> r4) {
        List<Object> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "formatArgs");
        this.f20504a = r3;
        this.f20505b = r5;
    }

    public final int a() {
        return this.f20504a;
    }

    public /* synthetic */ ah(int r2, List r3, int r4, d.h.b.h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = d.a.p.b();
    L5:
        this(r2, r6);
    }

    public final List<Object> b() {
        return this.f20505b;
    }
}
