package com.bytedance.safetyguard.lxc.internal.e.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f10730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10731b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10730a, r6.f10730a) == true) goto L12;
        return false;
    L12:
        if (this.f10731b == r6.f10731b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f10730a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Boolean.hashCode(this.f10731b);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ParsedCode(value=" + this.f10730a + ", malformed=" + this.f10731b + ')';
    }

    public e(Integer r1, boolean r2) {
        this.f10730a = r1;
        this.f10731b = r2;
    }

    public final Integer a() {
        return this.f10730a;
    }

    public final boolean b() {
        return this.f10731b;
    }
}
