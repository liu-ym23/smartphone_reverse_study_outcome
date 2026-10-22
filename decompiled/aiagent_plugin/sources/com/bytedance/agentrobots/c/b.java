package com.bytedance.agentrobots.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: AgentOperationStateMachine.java */
/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, C0102b> f4021a;

    /* JADX INFO: compiled from: AgentOperationStateMachine.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f4023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f4024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f4025c;

        a(String r1, String r2, String r3) {
            this.f4023a = r1;
            this.f4024b = r2;
            this.f4025c = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.agentrobots.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentOperationStateMachine.java */
    private static final class C0102b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f4026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f4027b;

        C0102b(String r1, String r2) {
            this.f4026a = r1;
            this.f4027b = r2;
        }
    }

    b() {
        final int r1 = 65;
        final float r2 = 0.75f;
        final boolean r3 = true;
        this.f4021a = new AnonymousClass1(this, r1, r2, r3);
    }

    synchronized List<a> a(String r5, String r6, String r7) {
        monitor-enter(this);
        String r0 = r5.toUpperCase(Locale.ROOT);     // Catch: Throwable -> L43
        C0102b r1 = (C0102b) ZeusTransformUtils.preCheckCast(this.f4021a.get(r0), C0102b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if ("start".equals(r7) == false) goto L24;
        if (r1 != null) goto L7;
    L13:
        ArrayList r8 = new ArrayList(2);     // Catch: Throwable -> L43
        if (r1 != null) goto L16;
    L20:
        r8.add(new a(r5, r6, "start"));     // Catch: Throwable -> L43
        this.f4021a.put(r0, new C0102b(r6, "start"));     // Catch: Throwable -> L43
        monitor-exit(this);
        return r8;
    L16:
        if ("start".equals(r1.f4027b) == false) goto L20;
        if (Objects.equals(r1.f4026a, r6) == true) goto L20;
        r8.add(new a(r5, r1.f4026a, "stop"));     // Catch: Throwable -> L43
        goto L20
    L7:
        if ("start".equals(r1.f4027b) == false) goto L13;
        if (Objects.equals(r1.f4026a, r6) == false) goto L13;
        List<a> r9 = Collections.emptyList();     // Catch: Throwable -> L43
        monitor-exit(this);
        return r9;
    L24:
        if ("stop".equals(r7) == false) goto L40;
        if (r1 != null) goto L27;
    L29:
        if (r1 != null) goto L31;
    L37:
        this.f4021a.put(r0, new C0102b(r6, "stop"));     // Catch: Throwable -> L43
        List<a> r10 = Collections.singletonList(new a(r5, r6, "stop"));     // Catch: Throwable -> L43
        monitor-exit(this);
        return r10;
    L31:
        if ("stop".equals(r1.f4027b) == false) goto L37;
        if (Objects.equals(r1.f4026a, r6) == false) goto L37;
        List<a> r11 = Collections.emptyList();     // Catch: Throwable -> L43
        monitor-exit(this);
        return r11;
    L27:
        if ("start".equals(r1.f4027b) == false) goto L29;
        r6 = r1.f4026a;     // Catch: Throwable -> L43
        goto L37
    L40:
        List<a> r12 = Collections.singletonList(new a(r5, r6, r7));     // Catch: Throwable -> L43
        monitor-exit(this);
        return r12;
    L43:
        th = move-exception;
        throw th;
    }

    synchronized void a() {
        monitor-enter(this);
        this.f4021a.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
