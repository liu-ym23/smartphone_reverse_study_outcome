package com.bytedance.safetyguard.lxc.internal.e.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10679b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10678a, r6.f10678a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10679b, r6.f10679b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10678a.hashCode() * 31) + this.f10679b.hashCode();
    }

    public String toString() {
        return "DeviceFlowErrorClassification(subtype=" + this.f10678a + ", hint=" + this.f10679b + ')';
    }

    public e(String r2, String r3) {
        o.e(r2, "subtype");
        o.e(r3, "hint");
        this.f10678a = r2;
        this.f10679b = r3;
    }

    public final String a() {
        return this.f10678a;
    }

    public final String b() {
        return this.f10679b;
    }
}
