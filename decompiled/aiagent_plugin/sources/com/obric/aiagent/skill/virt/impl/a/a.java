package com.obric.aiagent.skill.virt.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VirtBackend.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21637b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21636a, r6.f21636a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21637b, r6.f21637b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f21636a.hashCode() * 31;
        String r1 = this.f21637b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "BackendPathRoots(homeDir=" + this.f21636a + ", shareDir=" + this.f21637b + ')';
    }

    public a(String r2, String r3) {
        o.e(r2, "homeDir");
        this.f21636a = r2;
        this.f21637b = r3;
    }

    public final String a() {
        return this.f21636a;
    }

    public final String b() {
        return this.f21637b;
    }
}
