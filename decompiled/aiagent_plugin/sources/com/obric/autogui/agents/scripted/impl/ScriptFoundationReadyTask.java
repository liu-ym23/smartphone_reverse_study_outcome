package com.obric.autogui.agents.scripted.impl;

import android.content.Context;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: ScriptFoundationReadyTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ScriptFoundationReadyTask implements IAutoActionFoundationReadyTask {
    public static final a Companion = null;
    private static final String TAG = "ScriptFoundationReadyTask";

    /* JADX INFO: compiled from: ScriptFoundationReadyTask.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScriptFoundationReadyTask.kt */
    @d.c.b.a.f(b = "ScriptFoundationReadyTask.kt", c = {31}, d = "run", e = "com.obric.autogui.agents.scripted.impl.ScriptFoundationReadyTask")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f26965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScriptFoundationReadyTask f26966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f26967c;

        b(ScriptFoundationReadyTask r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26966b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26965a = r3;
            this.f26967c |= Integer.MIN_VALUE;
            return this.f26966b.run((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public ScriptFoundationReadyTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f26967c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f26967c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f26965a;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f26967c;
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L16;
        d.o.a(r6);     // Catch: Exception -> L13
    L26:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L31;
        Loog.INSTANCE.i(TAG, "Script foundation ready task completed");     // Catch: Exception -> L13
    L31:
        return x.f38692a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r6);
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
        Loog.INSTANCE.i(TAG, "Script foundation ready task started");
    L20:
        IJSScriptService r3 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        if (r3 == null) goto L26;
        r0.f26967c = 1;     // Catch: Exception -> L13
        if (r3.onFoundationReady(r10, r0) != r9) goto L26;
        return r9;
    L13:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to initialize script service on foundation ready", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new b(this, r8);
        goto L8
    }
}
