package com.obric.aiagent.executionengine.capabilitymanager.api.matcher;

import com.obric.capabilitykit.common.AppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: MatchResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppAction f16421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.executionengine.capabilitymanager.api.a.a f16422b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16421a, r6.f16421a) == true) goto L12;
        return false;
    L12:
        if (this.f16422b == r6.f16422b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f16421a.hashCode() * 31) + this.f16422b.hashCode();
    }

    public String toString() {
        return "MatchResult(appAction=" + this.f16421a + ", type=" + this.f16422b + ')';
    }

    public a(AppAction r2, com.obric.aiagent.executionengine.capabilitymanager.api.a.a r3) {
        o.e(r2, "appAction");
        o.e(r3, "type");
        this.f16421a = r2;
        this.f16422b = r3;
    }

    public final AppAction a() {
        return this.f16421a;
    }

    public final com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType() {
        return this.f16422b;
    }
}
