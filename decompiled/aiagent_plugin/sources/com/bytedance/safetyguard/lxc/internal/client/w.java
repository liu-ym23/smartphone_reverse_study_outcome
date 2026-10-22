package com.bytedance.safetyguard.lxc.internal.client;

import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyIpcClientMappers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActionContextToken f10080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ActionEgressResult f10081b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, w.class) == true) goto L8;
        return false;
    L8:
        w r6 = (w) ZeusTransformUtils.preCheckCast(r5, w.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10080a, r6.f10080a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10081b, r6.f10081b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10080a.hashCode() * 31) + this.f10081b.hashCode();
    }

    public String toString() {
        return "TerminalActionResult(token=" + this.f10080a + ", result=" + this.f10081b + ')';
    }

    public w(ActionContextToken r2, ActionEgressResult r3) {
        d.h.b.o.e(r2, "token");
        d.h.b.o.e(r3, "result");
        this.f10080a = r2;
        this.f10081b = r3;
    }

    public final ActionContextToken a() {
        return this.f10080a;
    }

    public final ActionEgressResult b() {
        return this.f10081b;
    }
}
