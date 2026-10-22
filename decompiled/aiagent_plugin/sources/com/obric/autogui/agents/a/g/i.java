package com.obric.autogui.agents.a.g;

import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.agents.a.m.s;
import com.obric.autogui.agents.a.m.t;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.operator.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import java.util.UUID;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: ActionEffectPreparationStage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static final String TAG = "ActionEffectPrepare";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26492a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.d f26493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.a.h.e f26494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.a.i.a f26495d;

    /* JADX INFO: compiled from: ActionEffectPreparationStage.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26492a = new a(null);
    }

    public i(com.obric.autogui.agents.a.l.d r2, com.obric.autogui.agents.a.h.e r3, com.obric.autogui.agents.a.i.a r4) {
        o.e(r2, "snapshotProvider");
        o.e(r3, "policyProvider");
        o.e(r4, "resourceCleanupScheduler");
        this.f26493b = r2;
        this.f26494c = r3;
        this.f26495d = r4;
    }

    public final Object a(com.obric.autogui.session.a r4, com.obric.autogui.operator.e r5, com.obric.autogui.agents.a.a.k r6, d.c.d<? super h> r7) {
        com.obric.autogui.agents.a.a.k r8 = (com.obric.autogui.agents.a.a.k) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autogui.agents.a.a.k.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        n.a r10 = n.f38560a;     // Catch: Throwable -> L5
        i r11 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r12 = n.f(com.obric.autogui.agents.a.h.b.f26500a.a(r5));     // Catch: Throwable -> L5
    L7:
        Throwable r0 = n.c(r12);
        if (r0 != null) goto L21;
        com.obric.autogui.agents.a.h.a r13 = (com.obric.autogui.agents.a.h.a) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.a.h.a.class, "com.obric.aiagent.plugin");
        if (o.a(r13, com.obric.autogui.agents.a.h.a.c.f26499a) == false) goto L13;
        return (h) ZeusTransformUtils.preCheckCast(h.c.f26491a, h.class, "com.obric.aiagent.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autogui.agents.a.h.a.C0666a.class) == false) goto L16;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] action routed action=" + ((com.obric.autogui.agents.a.h.a.C0666a) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.agents.a.h.a.C0666a.class, "com.obric.aiagent.plugin")).a().a() + ", route=execution_result, settings_read=false, observer_installed=false, extra_check=false");
        return (h) ZeusTransformUtils.preCheckCast(new h.a(((com.obric.autogui.agents.a.h.a.C0666a) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.agents.a.h.a.C0666a.class, "com.obric.aiagent.plugin")).a()), h.class, "com.obric.aiagent.plugin");
    L16:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autogui.agents.a.h.a.b.class) == false) goto L20;
        return a(r4, r5, ((com.obric.autogui.agents.a.h.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.agents.a.h.a.b.class, "com.obric.aiagent.plugin")).a(), r8);
    L20:
        throw new d.k();
    L21:
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] action resolve failed action=unknown, error_type=" + com.obric.autogui.agents.a.b.a(r0) + ", original_action_preserved=true");
        return h.c.f26491a;
    L5:
        th = move-exception;
        n.a r1 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L7
    }

    private final h a(com.obric.autogui.session.a r29, com.obric.autogui.operator.e r30, com.obric.autogui.agents.a.f.a r31, com.obric.autogui.agents.a.a.k r32) {
        r30 = r30;
        String r11 = ", observer_installed=";
        String r12 = ", finish_reason=";
        String r13 = "[OAutoActionEffect] preparation timing ";
        String r8 = "com.obric.aiagent.plugin";
        com.obric.autogui.agents.a.a.k r16 = (com.obric.autogui.agents.a.a.k) ZeusTransformUtils.wrapperContextForParams(r32, com.obric.autogui.agents.a.a.k.class, "com.obric.aiagent.plugin");
        t r7 = new t(null, 1, null);
        com.obric.autogui.agents.a.m.d r4 = r7.a(com.obric.autogui.agents.a.m.a.f26647a);
        s r3 = s.f26710a;
        String r2 = UUID.randomUUID().toString();
        o.c(r2, "toString(...)");
        String r1 = r31.a();     // Catch: Throwable -> L97 CancellationException -> L118
    L167:
        com.obric.autogui.agents.a.h.d r5 = this.f26494c.a(r31);     // Catch: Throwable -> L83 CancellationException -> L85
    L8:
        if (r5.b() == true) goto L145;
    L157:
    L147:
        Loog.INSTANCE.i(TAG, new StringBuilder().append("[OAutoActionEffect] prepare skipped ").append(com.obric.autogui.agents.a.c.f26286a.a(r31.a(), r2)).append(", reason=observation_disabled_or_unsupported, observe_enabled=").append(r5.b()).append(", retry_wait_enabled=").append(r5.c()).toString());     // Catch: Throwable -> L18 CancellationException -> L20
        h r0 = (h) ZeusTransformUtils.preCheckCast(h.c.f26491a, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18 CancellationException -> L20
        r7.a(r4, r3);
        if (o.a(r1, SensitiveType.UNKNOWN) == true) goto L17;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] preparation timing " + com.obric.autogui.agents.a.c.f26286a.a(r1, r2) + ", finish_reason=" + r3 + ", observer_installed=false, elapsed_ms=" + r7.b().h().a());
    L17:
        return r0;
    L20:
        e = e;
        r11 = ", observer_installed=";
    L27:
        com.obric.autogui.agents.a.a.a r9 = null;
        boolean r21 = false;
        String r6 = ", elapsed_ms=";
    L34:
        String r10 = r1;
        r7 = r7;
        r13 = "[OAutoActionEffect] preparation timing ";
        com.obric.autogui.agents.a.m.d r14 = r4;
    L141:
        s r15 = s.f26712c;     // Catch: Throwable -> L126
        if (r9 != null) goto L139;
    L125:
        throw e;     // Catch: Throwable -> L123
    L123:
        th = th;
        r3 = r15;
    L127:
        r7.a(r14, r3);
        if (o.a(r10, SensitiveType.UNKNOWN) == true) goto L134;
        long r17 = r7.b().h().a();
        Loog r18 = Loog.INSTANCE;
        StringBuilder r19 = new StringBuilder().append(r13).append(com.obric.autogui.agents.a.c.f26286a.a(r10, r2)).append(r12).append(r3).append(r11);
        if (r9 == null) goto L132;
        boolean r20 = true;
    L133:
        r18.i(TAG, r19.append(r20).append(r6).append(r17).toString());
        goto L134
    L132:
        r20 = r21;
    L134:
        throw th;
    L139:
        r30.b((p) ZeusTransformUtils.preCheckCast(r9, p.class, r8));     // Catch: Throwable -> L123
    L126:
        th = th;
    L18:
        th = th;
        r11 = ", observer_installed=";
    L24:
        r9 = null;
        r21 = false;
        String r22 = ", elapsed_ms=";
    L30:
        String r23 = r1;
        r7 = r7;
        r13 = "[OAutoActionEffect] preparation timing ";
        r14 = r4;
    L137:
        r3 = s.f26713d;     // Catch: Throwable -> L116
        if (r9 == null) goto L103;
        r30.b((p) ZeusTransformUtils.preCheckCast(r9, p.class, r8));     // Catch: Throwable -> L116
    L103:
        String r110 = r22;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] preparation failed before injection " + com.obric.autogui.agents.a.c.f26286a.a(r23, r2) + ", error_type=" + com.obric.autogui.agents.a.b.a(th));     // Catch: Throwable -> L114
        h r24 = (h) ZeusTransformUtils.preCheckCast(h.c.f26491a, h.class, r8);     // Catch: Throwable -> L114
        r7.a(r14, r3);
        if (o.a(r23, SensitiveType.UNKNOWN) == true) goto L113;
        long r25 = r7.b().h().a();
        Loog r26 = Loog.INSTANCE;
        StringBuilder r27 = new StringBuilder().append(r13).append(com.obric.autogui.agents.a.c.f26286a.a(r23, r2)).append(r12).append(r3).append(r11);
        if (r9 == null) goto L111;
        boolean r28 = true;
    L112:
        r26.i(TAG, r27.append(r28).append(r110).append(r25).toString());
        goto L113
    L111:
        r28 = r21;
    L113:
        return r24;
    L114:
        th = th;
        r10 = r23;
        r6 = r110;
    L116:
        th = th;
        String r210 = r22;
        r10 = r23;
        r6 = r210;
    L25:
        e = e;
    L22:
        th = th;
    L32:
        e = e;
        r30 = r30;
        r8 = "com.obric.aiagent.plugin";
        r12 = ", finish_reason=";
        r21 = false;
        r6 = ", elapsed_ms=";
        r9 = null;
    L28:
        th = th;
        r30 = r30;
        r8 = "com.obric.aiagent.plugin";
        r12 = ", finish_reason=";
        r21 = false;
        r22 = ", elapsed_ms=";
        r9 = null;
        goto L30
    L145:
        com.obric.autogui.agents.a.f.j r111 = this.f26494c.a(r5);     // Catch: Throwable -> L79 CancellationException -> L81
    L151:
        com.obric.autogui.agents.a.l.d r33 = this.f26493b;     // Catch: Throwable -> L75 CancellationException -> L77
    L159:
    L143:
        Context r211 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r29.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L67 CancellationException -> L69
        r21 = false;
        r2 = r2;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r3 = r3;
        r13 = "[OAutoActionEffect] preparation timing ";
        r14 = r4;
        com.obric.autogui.agents.a.a.a r112 = null;
        r7 = r7;
        r8 = "com.obric.aiagent.plugin";
        r9 = new com.obric.autogui.agents.a.a.a(r111, r2, r33, r7, r211, r30, r16);     // Catch: Throwable -> L60 CancellationException -> L63
        r30 = r30;
        r30.a((p) ZeusTransformUtils.preCheckCast(r9, p.class, r8));     // Catch: Throwable -> L56 CancellationException -> L58
    L165:
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] begin " + com.obric.autogui.agents.a.c.f26286a.a(r9) + ", observe_enabled=" + r5.b() + ", retry_wait_enabled=" + r5.c() + ", detector_count=" + r111.b().size());     // Catch: Throwable -> L52 CancellationException -> L54
        h r34 = (h) ZeusTransformUtils.preCheckCast(new h.b(new com.obric.autogui.agents.a.a.g(r30, r9, r5.c(), r7, this.f26495d)), h.class, r8);     // Catch: Throwable -> L52 CancellationException -> L54
        r7.a(r14, r3);
        if (o.a(r1, SensitiveType.UNKNOWN) == true) goto L51;
        Loog.INSTANCE.i(TAG, r13 + com.obric.autogui.agents.a.c.f26286a.a(r1, r2) + r12 + r3 + r11 + "true, elapsed_ms=" + r7.b().h().a());
    L51:
        return r34;
    L54:
        e = e;
        r2 = r2;
        r10 = r1;
    L66:
        r6 = ", elapsed_ms=";
    L52:
        th = th;
        r2 = r2;
        r7 = r7;
        r23 = r1;
        r11 = r11;
        r12 = r12;
        r13 = r13;
        r22 = ", elapsed_ms=";
    L58:
        e = e;
    L65:
        r10 = r1;
        r9 = null;
    L56:
        th = th;
    L62:
        r7 = r7;
        r23 = r1;
        r11 = r11;
        r12 = r12;
        r13 = r13;
        r22 = ", elapsed_ms=";
    L99:
        r9 = r112;
        goto L137
    L63:
        e = e;
        r30 = r30;
    L60:
        th = th;
        r30 = r30;
        goto L62
    L69:
        e = e;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r14 = r4;
        String r35 = r1;
        com.obric.autogui.agents.a.a.a r113 = null;
        r21 = false;
        r3 = r3;
        String r36 = ", elapsed_ms=";
        r8 = "com.obric.aiagent.plugin";
        r2 = r2;
        r30 = r30;
    L96:
        r9 = r113;
        String r212 = r36;
        r10 = r35;
        r6 = r212;
    L67:
        th = th;
        r7 = r7;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r13 = "[OAutoActionEffect] preparation timing ";
        r14 = r4;
        r23 = r1;
        r112 = null;
        r21 = false;
        r3 = r3;
        r22 = ", elapsed_ms=";
        r8 = "com.obric.aiagent.plugin";
        r2 = r2;
        r30 = r30;
    L73:
        e = e;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r14 = r4;
        r113 = null;
        r3 = r3;
        r36 = ", elapsed_ms=";
        r8 = "com.obric.aiagent.plugin";
        r30 = r30;
        r2 = r2;
        r35 = r1;
        r21 = false;
    L71:
        th = th;
        r7 = r7;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r13 = "[OAutoActionEffect] preparation timing ";
        r14 = r4;
        r112 = null;
        r3 = r3;
        r22 = ", elapsed_ms=";
        r8 = "com.obric.aiagent.plugin";
        r30 = r30;
        r2 = r2;
        r23 = r1;
        r21 = false;
    L77:
        e = e;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r113 = null;
        r21 = false;
        r3 = r3;
        r36 = ", elapsed_ms=";
        r8 = "com.obric.aiagent.plugin";
        r30 = r30;
        r2 = r2;
        r35 = r1;
        r14 = r4;
    L75:
        th = th;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r112 = null;
        r21 = false;
        r3 = r3;
        r22 = ", elapsed_ms=";
        r8 = "com.obric.aiagent.plugin";
        r30 = r30;
        r2 = r2;
        r23 = r1;
        r7 = r7;
        r13 = "[OAutoActionEffect] preparation timing ";
        r14 = r4;
    L81:
        e = e;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r113 = null;
        r21 = false;
        r36 = ", elapsed_ms=";
        r30 = r30;
    L95:
        r2 = r2;
        r35 = r1;
        r14 = r4;
    L79:
        th = th;
        r11 = ", observer_installed=";
        r12 = ", finish_reason=";
        r112 = null;
        r21 = false;
        r22 = ", elapsed_ms=";
        r30 = r30;
    L90:
        r2 = r2;
        r23 = r1;
        r7 = r7;
        r13 = "[OAutoActionEffect] preparation timing ";
        r14 = r4;
    L85:
        e = e;
        r113 = null;
    L94:
        r21 = false;
        r36 = ", elapsed_ms=";
    L83:
        th = th;
        r112 = null;
    L89:
        r21 = false;
        r22 = ", elapsed_ms=";
    L92:
        e = e;
        r113 = null;
    L87:
        th = th;
        r112 = null;
        goto L89
    L118:
        e = e;
        r7 = r7;
        r30 = r30;
        r12 = ", finish_reason=";
        r13 = "[OAutoActionEffect] preparation timing ";
        r21 = false;
        r3 = r3;
        r14 = r4;
        r2 = r2;
        r6 = ", elapsed_ms=";
        r8 = "com.obric.aiagent.plugin";
        r10 = SensitiveType.UNKNOWN;
        r9 = null;
    L97:
        th = th;
        r112 = null;
        r7 = r7;
        r30 = r30;
        r13 = "[OAutoActionEffect] preparation timing ";
        r21 = false;
        r14 = r4;
        r12 = ", finish_reason=";
        r3 = r3;
        r22 = ", elapsed_ms=";
        r8 = "com.obric.aiagent.plugin";
        r2 = r2;
        r23 = SensitiveType.UNKNOWN;
        goto L99
    }
}
