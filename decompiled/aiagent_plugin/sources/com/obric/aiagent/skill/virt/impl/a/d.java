package com.obric.aiagent.skill.virt.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VirtBackendFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f22040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22041b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22040a, r6.f22040a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22041b, r6.f22041b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f22040a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f22041b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CtrdProbeResult(apiVersion=" + this.f22040a + ", reason=" + this.f22041b + ')';
    }

    public d(Integer r1, String r2) {
        this.f22040a = r1;
        this.f22041b = r2;
    }

    public final Integer a() {
        return this.f22040a;
    }

    public final String b() {
        return this.f22041b;
    }
}
