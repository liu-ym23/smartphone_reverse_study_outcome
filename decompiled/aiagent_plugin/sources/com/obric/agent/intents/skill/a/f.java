package com.obric.agent.intents.skill.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IntentActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14891c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14889a, r6.f14889a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14890b, r6.f14890b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f14891c, r6.f14891c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f14889a.hashCode() * 31) + this.f14890b.hashCode()) * 31) + this.f14891c.hashCode();
    }

    public String toString() {
        return "IntentActionRequest(uniqueId=" + this.f14889a + ", actionType=" + this.f14890b + ", actionArgs=" + this.f14891c + ')';
    }

    public f(String r2, String r3, String r4) {
        o.e(r2, "uniqueId");
        o.e(r3, "actionType");
        o.e(r4, "actionArgs");
        this.f14889a = r2;
        this.f14890b = r3;
        this.f14891c = r4;
    }

    public final String a() {
        return this.f14889a;
    }

    public final String b() {
        return this.f14890b;
    }

    public final String c() {
        return this.f14891c;
    }
}
