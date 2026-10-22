package com.obric.agent.intents.skill.c;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.k;
import d.l.n;
import d.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ShellActionDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.obric.agent.intents.skill.a.a<com.obric.agent.intents.skill.c.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14902b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.c.a, ?>> f14903c = null;

    /* JADX INFO: compiled from: ShellActionDispatcher.kt */
    @d.c.b.a.f(b = "ShellActionDispatcher.kt", c = {55}, d = "prepareActionContext", e = "com.obric.agent.intents.skill.systemshell.ShellActionDispatcher")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f14907d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f14908e;
        final /* synthetic */ b f;
        int g;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14908e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f14901a = new b();
        f14902b = "ShellActionDispatcher";
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(p.b(new com.obric.agent.intents.skill.a.c[]{c.f14909a, h.f15034a, i.f15037a, e.f14936a, g.f14982a}), Iterable.class, "com.obric.aiagent.plugin");
        Map<String, com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.c.a, ?>> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(p.a(r0, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r3 = r2.next();
        r1.put(((com.obric.agent.intents.skill.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.a.c.class, "com.obric.aiagent.plugin")).a(), r3);
        goto L4
    L6:
        f14903c = r1;
    }

    @Override // com.obric.agent.intents.skill.a.a
    public String a() {
        return f14902b;
    }

    @Override // com.obric.agent.intents.skill.a.a
    public Map<String, com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.c.a, ?>> b() {
        return f14903c;
    }

    @Override // com.obric.agent.intents.skill.a.a
    public Object a(com.obric.agent.intents.skill.a.f r26, DispatchContext r27, d.c.d<? super com.obric.agent.intents.skill.a.a.AbstractC0296a<? extends com.obric.agent.intents.skill.c.a>> r28) {
        b r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        a r7 = r3;
        Object r2 = r7.f14908e;
        Object r4 = d.c.a.b.a();
        int r5 = r7.g;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r7.f14907d;
        IOVirtService r8 = (IOVirtService) ZeusTransformUtils.preCheckCast(r7.f14906c, IOVirtService.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.a.f r9 = (com.obric.agent.intents.skill.a.f) ZeusTransformUtils.preCheckCast(r7.f14905b, com.obric.agent.intents.skill.a.f.class, "com.obric.aiagent.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r7.f14904a, b.class, "com.obric.aiagent.plugin");
        o.a(r2);
        long r11 = r6;
        com.obric.agent.intents.skill.a.f r13 = r9;
        Object r12 = r2;
        IOVirtService r14 = r8;
        r0 = r10;
    L21:
        com.obric.aiagent.skill.ovirt.api.h r15 = (com.obric.aiagent.skill.ovirt.api.h) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.ovirt.api.h.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L25;
    L26:
        com.obric.agent.intents.skill.e.a.f15181a.a(r13.a(), r13.b(), r15);
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.ovirt.api.h.b.class) == false) goto L33;
        if (r14 != null) goto L42;
        return new com.obric.agent.intents.skill.a.a.AbstractC0296a.C0297a(j.a(j.f15039a, j.a(j.f15039a, "START_FAILED", "shell start failed", null, 4, null), -2002, false, 4, null));
    L42:
        return (com.obric.agent.intents.skill.a.a.AbstractC0296a) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.a.AbstractC0296a.b(new com.obric.agent.intents.skill.c.a(r14, r13.a())), com.obric.agent.intents.skill.a.a.AbstractC0296a.class, "com.obric.aiagent.plugin");
    L33:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.ovirt.api.h.a.class) == false) goto L41;
        if (IAppContext.Companion.isDebug() == false) goto L37;
        ILogDepend.Companion.e(r0.a(), "prepare runtime failed uniqueId=" + r13.a() + " msg=" + ((com.obric.aiagent.skill.ovirt.api.h.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.ovirt.api.h.a.class, "com.obric.aiagent.plugin")).b());
    L38:
        com.obric.agent.intents.skill.e.a.f15181a.a(r13.a(), r13.b(), SystemClock.elapsedRealtime() - r11, -2002, c.f14909a.a(r13.b(), r13.c()));
        return (com.obric.agent.intents.skill.a.a.AbstractC0296a) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.a.AbstractC0296a.C0297a(j.a(j.f15039a, j.a(j.f15039a, "START_FAILED", "shell start failed", null, 4, null), -2002, false, 4, null)), com.obric.agent.intents.skill.a.a.AbstractC0296a.class, "com.obric.aiagent.plugin");
    L37:
        ILogDepend.Companion.e(r0.a(), "prepare runtime failed");
        goto L38
    L41:
        throw new k();
    L25:
        r15 = (com.obric.aiagent.skill.ovirt.api.h) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.h.a(com.obric.aiagent.skill.ovirt.api.f.f20995c, "OVirt unavailable", new com.obric.aiagent.skill.ovirt.api.g(0, 0, 0, 0, 15, null)), com.obric.aiagent.skill.ovirt.api.h.class, "com.obric.aiagent.plugin");
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        r11 = SystemClock.elapsedRealtime();
        r14 = IOVirtService.Companion.a();
        if (r14 == null) goto L24;
        IOVirtService.e r16 = r14.getTask();
        if (r16 == null) goto L24;
        String r17 = r26.a();
        r7.f14904a = r0;
        r13 = r26;
        r7.f14905b = r13;
        r7.f14906c = r14;
        r7.f14907d = r11;
        r7.g = 1;
        r12 = IOVirtService.e.a.a(r16, r17, null, r7, 2, null);
        if (r12 != r4) goto L21;
        return r4;
    L24:
        r13 = r26;
    L7:
        r3 = new a(r0, r1);
        goto L8
    }

    @Override // com.obric.agent.intents.skill.a.a
    public void a(com.obric.agent.intents.skill.a.f r10, IntentResult<Empty> r11) {
        d.h.b.o.e(r10, Ext.KEY_REQUEST);
        d.h.b.o.e(r11, "result");
        com.obric.agent.intents.skill.e.a.a(com.obric.agent.intents.skill.e.a.f15181a, r10.a(), r10.b(), null, Integer.valueOf(r11.getRet()), null, c.f14909a.a(r10.b(), r10.c()), 20, null);
    }

    @Override // com.obric.agent.intents.skill.a.a
    public void a(com.obric.agent.intents.skill.a.f r10) {
        d.h.b.o.e(r10, Ext.KEY_REQUEST);
        com.obric.agent.intents.skill.e.a.a(com.obric.agent.intents.skill.e.a.f15181a, r10.a(), r10.b(), null, 999, null, c.f14909a.a(r10.b(), r10.c()), 20, null);
    }

    @Override // com.obric.agent.intents.skill.a.a
    public void a(com.obric.agent.intents.skill.a.f r10, Throwable r11) {
        d.h.b.o.e(r10, Ext.KEY_REQUEST);
        d.h.b.o.e(r11, WsConstants.KEY_CONNECTION_ERROR);
        com.obric.agent.intents.skill.e.a.a(com.obric.agent.intents.skill.e.a.f15181a, r10.a(), r10.b(), null, -2002, null, c.f14909a.a(r10.b(), r10.c()), 20, null);
    }

    @Override // com.obric.agent.intents.skill.a.a
    public IntentResult<Empty> a(String r8, Throwable r9) {
        d.h.b.o.e(r8, "actionType");
        d.h.b.o.e(r9, WsConstants.KEY_CONNECTION_ERROR);
        return j.a(j.f15039a, j.a(j.f15039a, "START_FAILED", "operation failed", null, 4, null), -2002, false, 4, null);
    }

    @Override // com.obric.agent.intents.skill.a.a
    public IntentResult<Empty> a(String r14) {
        d.h.b.o.e(r14, "actionType");
        return new IntentResult(999, null, null, "unsupported action", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }
}
