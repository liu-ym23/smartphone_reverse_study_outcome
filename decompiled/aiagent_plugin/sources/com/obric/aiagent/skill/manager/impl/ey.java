package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
final class ey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f19854b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ey.class) == true) goto L8;
        return false;
    L8:
        ey r6 = (ey) ZeusTransformUtils.preCheckCast(r5, ey.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19853a, r6.f19853a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19854b, r6.f19854b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19853a.hashCode() * 31) + this.f19854b.hashCode();
    }

    public String toString() {
        return "SkillServerRequestIdentity(uid=" + this.f19853a + ", authHeaders=" + this.f19854b + ')';
    }

    public ey(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "uid");
        d.h.b.o.e(r5, "authHeaders");
        this.f19853a = r3;
        this.f19854b = r5;
    }

    public final String a() {
        return this.f19853a;
    }

    public final Map<String, String> b() {
        return this.f19854b;
    }
}
