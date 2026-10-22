package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtPath.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21549a;

    public a(String r2) {
        d.h.b.o.e(r2, "absolutePath");
        this.f21549a = r2;
    }

    @Override // com.obric.aiagent.skill.virt.api.x
    public String a() {
        return this.f21549a;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (d.h.b.o.a(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "AbsoluteVirtPath('" + a() + "')";
    }
}
