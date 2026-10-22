package com.obric.autogui.evaluation.a;

import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.skill.ovirt.debug.api.IOVirtDebugService;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;

/* JADX INFO: compiled from: OVirtDebugSignedCallingExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements d.a {
    private static final String TAG = "OVirtDebugSC";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f29072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f29073b = null;

    private c() {
    }

    public final void a() {
        d.f29074a.a((d.a) ZeusTransformUtils.preCheckCast(this, d.a.class, "com.obric.aiagent.plugin"));
    }

    static {
        f29072a = new c();
        f29073b = "o_virt_debug_260825";
    }

    @Override // com.obric.autogui.evaluation.a.d.a
    public String b() {
        return f29073b;
    }

    @Override // com.obric.autogui.evaluation.a.d.a
    public Object a(Context r2, Intent r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        String r6 = r3.getStringExtra("o_virt_command");
        if (r6 != null) goto L5;
        r6 = r3.getStringExtra("payload");
    L5:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        IOVirtDebugService r9 = (IOVirtDebugService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOVirtDebugService.class), IOVirtDebugService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L18;
        Loog.INSTANCE.i(TAG, "OVirt debug result:\n" + r9.runDebug(r6));
        return com.obric.autogui.common.e.f29014b.a();
    L18:
        return com.obric.autogui.common.e.f29014b.b("OVirt debug service unavailable (debug-only module)");
    L14:
        return com.obric.autogui.common.e.f29014b.b("o_virt_command missing");
    L8:
        if (o.d(r7) == true) goto L11;
        r8 = false;
        goto L12
    }
}
