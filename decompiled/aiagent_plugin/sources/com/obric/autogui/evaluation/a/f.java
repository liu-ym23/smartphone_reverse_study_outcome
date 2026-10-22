package com.obric.autogui.evaluation.a;

import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.skill.virt.debug.api.IVirtDebugService;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VirtDebugSignedCallingExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements d.a {
    private static final String TAG = "VirtDebugSC";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f29088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f29089b = null;

    private f() {
    }

    public final void a() {
        d.f29074a.a((d.a) ZeusTransformUtils.preCheckCast(this, d.a.class, "com.obric.aiagent.plugin"));
    }

    static {
        f29088a = new f();
        f29089b = "virt_debug_260630";
    }

    @Override // com.obric.autogui.evaluation.a.d.a
    public String b() {
        return f29089b;
    }

    @Override // com.obric.autogui.evaluation.a.d.a
    public Object a(Context r2, Intent r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        String r6 = r3.getStringExtra("virt_command");
        if (r6 != null) goto L5;
        r6 = r3.getStringExtra("payload");
    L5:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        IVirtDebugService r9 = (IVirtDebugService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IVirtDebugService.class), IVirtDebugService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L18;
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r10, "getApplicationContext(...)");
        Loog.INSTANCE.i(TAG, "Virt debug result:\n" + r9.runDebug(r10, r6));
        return com.obric.autogui.common.e.f29014b.a();
    L18:
        return com.obric.autogui.common.e.f29014b.b("Virt debug service unavailable (debug-only module)");
    L14:
        return com.obric.autogui.common.e.f29014b.b("virt_command missing");
    L8:
        if (d.o.o.d(r7) == true) goto L11;
        r8 = false;
        goto L12
    }
}
