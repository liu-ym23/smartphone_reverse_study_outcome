package com.obric.aiagent.skill.manager.impl;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillExistencePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bl f19568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f19569b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f19570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Set<String> f19571d;

    /* JADX INFO: compiled from: SkillExistencePolicy.kt */
    /* synthetic */ class a extends d.h.b.l implements d.h.a.b<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19572a = null;

        static {
            f19572a = new a();
        }

        a() {
            super(1, d.o.o.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
        }

        public final String a(String r2) {
            d.h.b.o.e(r2, "p0");
            return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillExistencePolicy.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19573a = null;

        static {
            f19573a = new b();
        }

        b() {
            super(1, d.o.o.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            d.h.b.o.e(r2, "p0");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r1 = true;
        L7:
            return Boolean.valueOf(r1);
        L5:
            r1 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    private bl() {
    }

    static {
        f19568a = new bl();
        f19569b = new Object();
        f19571d = d.a.ax.b();
    }

    public final Set<String> a(bn r7) {
        bn r6 = (bn) ZeusTransformUtils.wrapperContextForParams(r7, bn.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, DBHelper.BATTERY_COL_SOURCE);
        if (f19570c == true) goto L5;
        Object r8 = f19569b;
        monitor-enter(r8);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (f19570c == false) goto L25;
        Set<String> r9 = f19571d;     // Catch: Throwable -> L21
    L17:
        monitor-exit(r8);
        return r9;
    L25:
        Collection<String> r10 = r6.a();     // Catch: Exception -> L14 CancellationException -> L19 Throwable -> L21
    L16:
        f19571d = d.n.m.i(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f19572a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f19573a, d.h.a.b.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L21
        f19570c = true;     // Catch: Throwable -> L21
        ee.f19808a.b("SkillManager", "Skill existence policy initialized count=" + f19571d.size(), "Skill existence policy initialized: blocked=" + d.a.p.m((Iterable) ZeusTransformUtils.preCheckCast(f19571d, Iterable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L21
        r9 = f19571d;     // Catch: Throwable -> L21
        goto L17
    L19:
        e = move-exception;
        throw e;     // Catch: Throwable -> L21
    L14:
        e = move-exception;
        ee.f19808a.a("SkillManager", "Skill existence policy fetch failed; using empty policy for this process", "Skill existence policy fetch failed; using empty policy for this process: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        r10 = (Collection) ZeusTransformUtils.preCheckCast(d.a.ax.b(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        goto L16
    L5:
        return f19571d;
    }

    public final boolean a(String r1) {
        d.h.b.o.e(r1, "slug");
        return !f19571d.contains(r1);
    }

    public final void b(String r2) {
        d.h.b.o.e(r2, "slug");
        if (a(r2) == false) goto L6;
        return;
    L6:
        throw new bo(r2);
    }
}
