package com.obric.aiagent.skill.manager.impl;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillScanDecisionStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f20929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f20930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.f f20931c;

    public static /* synthetic */ Keva lambda$L56f36vHWz1unzRUIJkDd9KUNpo() {
        return b();
    }

    public w() {
        this.f20929a = new Gson();
        this.f20930b = new Object();
        this.f20931c = d.g.a($$Lambda$w$L56f36vHWz1unzRUIJkDd9KUNpo.INSTANCE);
    }

    private final Keva a() {
        return (Keva) ZeusTransformUtils.preCheckCast(this.f20931c.b(), Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva b() {
        return cx.f19710a.a();
    }

    @Override // com.obric.aiagent.skill.manager.impl.eh
    public eg a(String r4, int r5, String r6) {
        d.h.b.o.e(r4, "slug");
        d.h.b.o.e(r6, DBDefinition.TASK_ID);
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        eg r1 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L28:
        return null;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L28;
        Object r0 = this.f20930b;
        monitor-enter(r0);
        eg r3 = b(r4);     // Catch: Throwable -> L25
        if (r3 != null) goto L12;
    L23:
        monitor-exit(r0);
        return r1;
    L12:
        if (d.h.b.o.a(r3.a(), r4) == true) goto L14;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L23;
        r1 = r3;
        goto L23
    L14:
        if (r3.b() != r5) goto L20;
        if (d.h.b.o.a(r3.c(), r7) == false) goto L20;
        if (r3.g() == null) goto L20;
        r8 = true;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aiagent.skill.manager.impl.eh
    public boolean a(eg r5) {
        d.h.b.o.e(r5, "snapshot");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L24:
        return false;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L24;
        if (r5.g() == null) goto L24;
        Object r0 = this.f20930b;
        monitor-enter(r0);
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L13
        w r4 = (w) ZeusTransformUtils.preCheckCast(this, w.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r4.a().storeString(r4.c(r5.a()), r4.f20929a.toJson(r5));     // Catch: Throwable -> L13
        Object r6 = d.n.f(true);     // Catch: Throwable -> L13
    L16:
        if (d.n.b(r6) == false) goto L18;
        r6 = false;
    L18:
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L21
        monitor-exit(r0);
        return r7;
    L13:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L21
        r6 = d.n.f(d.o.a(th));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aiagent.skill.manager.impl.eh
    public void a(String r4) {
        d.h.b.o.e(r4, "slug");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        Object r0 = this.f20930b;
        monitor-enter(r0);
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L9
        w r3 = (w) ZeusTransformUtils.preCheckCast(this, w.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        r3.a().erase(r3.c(r4));     // Catch: Throwable -> L9
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L13
        d.n.f(d.o.a(th));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private final eg b(String r5) {
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L14
        w r4 = (w) ZeusTransformUtils.preCheckCast(this, w.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        String r6 = r4.a().getString(r4.c(r5), "");     // Catch: Throwable -> L14
        if (r6 != null) goto L6;
    L11:
        eg r7 = null;
    L12:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L14
    L17:
        if (d.n.b(r8) == true) goto L21;
        r1 = r8;
    L21:
        return (eg) ZeusTransformUtils.preCheckCast(r1, eg.class, "com.obric.aiagent.plugin");
    L6:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L11;
        r7 = (eg) ZeusTransformUtils.preCheckCast(r4.f20929a.fromJson(r6, eg.class), eg.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L17
    }

    private final String c(String r2) {
        return "scan_decision_v1_" + r2;
    }
}
