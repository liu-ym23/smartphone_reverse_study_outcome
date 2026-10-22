package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtPath.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21564b;

    public e(String r2, String r3) {
        d.h.b.o.e(r2, "relativePath");
        d.h.b.o.e(r3, "absolutePath");
        this.f21563a = r2;
        this.f21564b = r3;
    }

    @Override // com.obric.aiagent.skill.virt.api.x
    public String a() {
        return this.f21564b;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (d.h.b.o.a(((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "HomePath(relative='" + this.f21563a + "', absolute='" + a() + "')";
    }
}
