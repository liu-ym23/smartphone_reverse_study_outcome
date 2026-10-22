package com.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SingleCron.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.c.a.c f3180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.a.c.b.b, com.a.c.b.a> f3181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3182c;

    public e(com.a.c.a.c r4, List<com.a.c.b.a> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f3180a = (com.a.c.a.c) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r4, "CronDefinition must not be null"), com.a.c.a.c.class, "com.obric.aiagent.plugin");
        com.a.e.a.a(r6, "CronFields cannot be null");
        this.f3181b = new EnumMap(com.a.c.b.b.class);
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        com.a.c.b.a r8 = (com.a.c.b.a) ZeusTransformUtils.preCheckCast(r7.next(), com.a.c.b.a.class, "com.obric.aiagent.plugin");
        this.f3181b.put(r8.a(), r8);
        goto L4
    }

    @Override // com.a.c.b
    public com.a.c.b.a a(com.a.c.b.b r2) {
        return (com.a.c.b.a) ZeusTransformUtils.preCheckCast(this.f3181b.get(com.a.e.a.a(r2, "CronFieldName must not be null")), com.a.c.b.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.a.c.b
    public Map<com.a.c.b.b, com.a.c.b.a> b() {
        return Collections.unmodifiableMap(this.f3181b);
    }

    public String a() {
        if (this.f3182c != null) goto L10;
        ArrayList r0 = new ArrayList(this.f3181b.values());
        r0.sort(com.a.c.b.a.d());
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.append(String.format("%s ", new Object[]{((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r2.next(), com.a.c.b.a.class, "com.obric.aiagent.plugin")).b().a()}));
        goto L6
    L8:
        this.f3182c = r1.toString().trim();
    L10:
        return this.f3182c;
    }

    @Override // com.a.c.b
    public com.a.c.a.c c() {
        return this.f3180a;
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
