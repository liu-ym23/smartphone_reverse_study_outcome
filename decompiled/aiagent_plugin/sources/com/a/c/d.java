package com.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: RebootCron.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.c.a.c f3179a;

    public String a() {
        return "@reboot";
    }

    public d(com.a.c.a.c r3) {
        this.f3179a = (com.a.c.a.c) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r3, "CronDefinition must not be null"), com.a.c.a.c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.a.c.b
    public com.a.c.b.a a(com.a.c.b.b r1) {
        com.a.e.a.a(r1, "CronFieldName must not be null");
        return null;
    }

    @Override // com.a.c.b
    public Map<com.a.c.b.b, com.a.c.b.a> b() {
        return Collections.unmodifiableMap(new HashMap());
    }

    @Override // com.a.c.b
    public com.a.c.a.c c() {
        return this.f3179a;
    }

    @Override // com.a.c.b
    public b d() {
        Iterator<Map.Entry<com.a.c.b.b, com.a.c.b.a>> r0 = b().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        ((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.a.c.b.a.class, "com.obric.aiagent.plugin")).b().a(new com.a.c.b.c.a.b(c().a((com.a.c.b.b) ZeusTransformUtils.preCheckCast(r1.getKey(), com.a.c.b.b.class, "com.obric.aiagent.plugin")).c()));
        goto L4
    L6:
        Iterator<com.a.c.a.a> r2 = c().c().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        com.a.c.a.a r3 = (com.a.c.a.a) ZeusTransformUtils.preCheckCast(r2.next(), com.a.c.a.a.class, "com.obric.aiagent.plugin");
        if (r3.a(this) == true) goto L8;
        throw new IllegalArgumentException(String.format("Invalid cron expression: %s. %s", new Object[]{a(), r3.a()}));
    L14:
        return this;
    }
}
