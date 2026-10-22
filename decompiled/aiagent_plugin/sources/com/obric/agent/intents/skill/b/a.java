package com.obric.agent.intents.skill.b;

import com.obric.agent.intents.skill.a.h;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.ovirt.api.i;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.k;
import d.o;
import d.x;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: OVirtTaskCloseBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "OVirtTaskCloseBridge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14896a = null;

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OVirtTaskCloseBridge.kt */
    @f(b = "OVirtTaskCloseBridge.kt", c = {24}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.lifecycle.OVirtTaskCloseBridge$onComplexTaskEnd$1")
    static final class C0298a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14898b;

        C0298a(String r3, d<? super C0298a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f14898b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0298a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0298a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0298a(this.f14898b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = b.a();
            int r1 = this.f14897a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L15:
            i r7 = (i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L19;
        L17:
            r7 = (i) ZeusTransformUtils.preCheckCast(new i.b("OVirt unavailable"), i.class, "com.obric.aiagent.plugin");
        L19:
            if (IAppContext.Companion.isDebug() == false) goto L22;
            ILogDepend.Companion.i(a.TAG, "onComplexTaskEnd uniqueId=" + this.f14898b + " result=" + r7);
        L32:
            return x.f38692a;
        L22:
            if (ZeusTransformUtils.instanceOf(r7, i.a.class) == false) goto L28;
            if (((i.a) ZeusTransformUtils.preCheckCast(r7, i.a.class, "com.obric.aiagent.plugin")).a() == false) goto L26;
            String r5 = "closed";
        L30:
            ILogDepend.Companion.i(a.TAG, "onComplexTaskEnd result=" + r5);
            goto L32
        L26:
            r5 = "failed";
            goto L30
        L28:
            if (ZeusTransformUtils.instanceOf(r7, i.b.class) == false) goto L34;
            r5 = "skipped";
            goto L30
        L34:
            throw new k();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            IOVirtService r8 = IOVirtService.Companion.a();
            if (r8 == null) goto L17;
            IOVirtService.e r9 = r8.getTask();
            if (r9 == null) goto L17;
            String r2 = this.f14898b;
            d<? super i> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f14897a = 1;
            r6 = r9.cleanupIfOwned(r2, r4);
            if (r6 != r0) goto L15;
            return r0;
        }
    }

    static {
        f14896a = new a();
    }

    private a() {
    }

    public final void a(TaskInfo r9) {
        d.h.b.o.e(r9, "taskInfo");
        Map<String, String> r8 = r9.getExt();
        if (r8 == null) goto L5;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L6:
        kotlinx.coroutines.i.a(h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new C0298a(r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        r10 = null;
        goto L6
    }
}
