package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SkillCoverPickerCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.aiagent.skill.manager.impl.y f20804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<String, com.obric.aiagent.skill.manager.impl.y> f20805b;

    public o() {
        this.f20805b = new LinkedHashMap();
    }

    public final synchronized void a(com.obric.aiagent.skill.manager.impl.y r4) {
        monitor-enter(this);
        d.h.b.o.e(r4, "next");     // Catch: Throwable -> L6
        ((Map) ZeusTransformUtils.preCheckCast(this.f20805b, Map.class, "com.obric.aiagent.plugin")).put(r4.a(), r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized n a(String r3) {
        monitor-enter(this);
        d.h.b.o.e(r3, "coverUrl");     // Catch: Throwable -> L11
        com.obric.aiagent.skill.manager.impl.y r4 = (com.obric.aiagent.skill.manager.impl.y) ZeusTransformUtils.preCheckCast(this.f20805b.remove(r3), com.obric.aiagent.skill.manager.impl.y.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r4 == null) goto L6;
        com.obric.aiagent.skill.manager.impl.y r0 = this.f20804a;     // Catch: Throwable -> L11
        this.f20804a = r4;     // Catch: Throwable -> L11
        n r5 = new n(r0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r5;
    L6:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized com.obric.aiagent.skill.manager.impl.y b(String r3) {
        monitor-enter(this);
        d.h.b.o.e(r3, "coverUrl");     // Catch: Throwable -> L6
        com.obric.aiagent.skill.manager.impl.y r4 = (com.obric.aiagent.skill.manager.impl.y) ZeusTransformUtils.preCheckCast(this.f20805b.remove(r3), com.obric.aiagent.skill.manager.impl.y.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized com.obric.aiagent.skill.manager.impl.y c(String r4) {
        monitor-enter(this);
        d.h.b.o.e(r4, "coverUrl");     // Catch: Throwable -> L15
        com.obric.aiagent.skill.manager.impl.y r0 = this.f20804a;     // Catch: Throwable -> L15
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (d.h.b.o.a(r0.a(), r4) == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        this.f20804a = null;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r0;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized List<com.obric.aiagent.skill.manager.impl.y> a() {
        monitor-enter(this);
        List r0 = d.a.p.a();     // Catch: Throwable -> L9
        com.obric.aiagent.skill.manager.impl.y r1 = this.f20804a;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r0.add(r1);     // Catch: Throwable -> L9
    L6:
        Collection<com.obric.aiagent.skill.manager.impl.y> r2 = this.f20805b.values();     // Catch: Throwable -> L9
        d.h.b.o.c(r2, "<get-values>(...)");     // Catch: Throwable -> L9
        r0.addAll(r2);     // Catch: Throwable -> L9
        List<com.obric.aiagent.skill.manager.impl.y> r3 = d.a.p.a(r0);     // Catch: Throwable -> L9
        this.f20804a = null;     // Catch: Throwable -> L9
        this.f20805b.clear();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r3;
    L9:
        th = move-exception;
        throw th;
    }
}
