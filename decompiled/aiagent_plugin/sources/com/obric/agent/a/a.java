package com.obric.agent.a;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AlarmCardSyncContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f14215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, AlarmEntity> f14216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f14217d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14214a, r6.f14214a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14215b, r6.f14215b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f14216c, r6.f14216c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f14217d, r6.f14217d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f14214a.hashCode() * 31) + this.f14215b.hashCode()) * 31) + this.f14216c.hashCode()) * 31) + this.f14217d.hashCode();
    }

    public String toString() {
        return "AlarmCardSyncContext(localMessageId=" + this.f14214a + ", alarmIds=" + this.f14215b + ", alarmEntities=" + this.f14216c + ", payload=" + this.f14217d + ')';
    }

    public a(String r3, Set<String> r4, Map<String, AlarmEntity> r5, c r6) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Map<String, AlarmEntity> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
        o.e(r3, "localMessageId");
        o.e(r7, "alarmIds");
        o.e(r8, "alarmEntities");
        o.e(r9, "payload");
        this.f14214a = r3;
        this.f14215b = r7;
        this.f14216c = r8;
        this.f14217d = r9;
    }

    public final String a() {
        return this.f14214a;
    }

    public final Set<String> b() {
        return this.f14215b;
    }

    public final Map<String, AlarmEntity> c() {
        return this.f14216c;
    }

    public final void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f14217d = r4;
    }

    public final c d() {
        return this.f14217d;
    }
}
