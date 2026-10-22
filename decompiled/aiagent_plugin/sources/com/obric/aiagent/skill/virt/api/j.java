package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtPath.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21576b;

    public j(String r2, String r3) {
        d.h.b.o.e(r2, "relativePath");
        d.h.b.o.e(r3, "absolutePath");
        this.f21575a = r2;
        this.f21576b = r3;
    }

    @Override // com.obric.aiagent.skill.virt.api.x
    public String a() {
        return this.f21576b;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, j.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (d.h.b.o.a(((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "SharePath(relative='" + this.f21575a + "', absolute='" + a() + "')";
    }
}
