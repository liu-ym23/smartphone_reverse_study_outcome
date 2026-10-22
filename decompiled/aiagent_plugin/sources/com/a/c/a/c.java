package com.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: CronDefinition.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<com.a.c.b.b, com.a.c.b.b.c> f3076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<a> f3077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<e> f3078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f3079d;

    public c(List<com.a.c.b.b.c> r5, Set<a> r6, Set<e> r7, boolean r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        com.a.e.a.a(r11, "Cron nicknames must not be null");
        if (r11.contains(e.h) == true) goto L5;
        com.a.e.a.a(r9, "Field definitions must not be null");
        com.a.e.a.a(r10, "Cron validations must not be null");
        com.a.e.a.a(r9, "Field definitions must not be empty");
        com.a.e.a.a(!((com.a.c.b.b.c) ZeusTransformUtils.preCheckCast(r9.get(0), com.a.c.b.b.c.class, "com.obric.aiagent.plugin")).d(), "The first field must not be optional");
    L5:
        this.f3076a = new EnumMap(com.a.c.b.b.class);
        Iterator r12 = r9.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        com.a.c.b.b.c r0 = (com.a.c.b.b.c) ZeusTransformUtils.preCheckCast(r12.next(), com.a.c.b.b.c.class, "com.obric.aiagent.plugin");
        this.f3076a.put(r0.b(), r0);
        goto L7
    L9:
        this.f3077b = Collections.unmodifiableSet(r10);
        this.f3078c = Collections.unmodifiableSet(r11);
        this.f3079d = r8;
    }

    public boolean a() {
        return this.f3079d;
    }

    public Set<com.a.c.b.b.c> b() {
        return new HashSet(this.f3076a.values());
    }

    public com.a.c.b.b.c a(com.a.c.b.b r2) {
        return (com.a.c.b.b.c) ZeusTransformUtils.preCheckCast(this.f3076a.get(r2), com.a.c.b.b.c.class, "com.obric.aiagent.plugin");
    }

    public boolean b(com.a.c.b.b r1) {
        return this.f3076a.containsKey(r1);
    }

    public Set<a> c() {
        return this.f3077b;
    }

    public Set<e> d() {
        return this.f3078c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L21;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f3079d != r6.f3079d) goto L20;
        if (this.f3076a.equals(r6.f3076a) == false) goto L20;
        if (this.f3077b.equals(r6.f3077b) == false) goto L20;
        if (this.f3078c.equals(r6.f3078c) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f3076a, this.f3077b, this.f3078c, Boolean.valueOf(this.f3079d)});
    }
}
