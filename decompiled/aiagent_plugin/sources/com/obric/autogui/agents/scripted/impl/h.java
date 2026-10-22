package com.obric.autogui.agents.scripted.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ScriptResourceIdentity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26999b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26998a, r6.f26998a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f26999b, r6.f26999b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f26998a.hashCode() * 31) + this.f26999b.hashCode();
    }

    public String toString() {
        return "ResourceRequestDeviceIds(requestDeviceId=" + this.f26998a + ", osDeviceId=" + this.f26999b + ')';
    }

    public h(String r2, String r3) {
        d.h.b.o.e(r2, "requestDeviceId");
        d.h.b.o.e(r3, "osDeviceId");
        this.f26998a = r2;
        this.f26999b = r3;
    }

    public final String a() {
        return this.f26998a;
    }

    public final String b() {
        return this.f26999b;
    }
}
