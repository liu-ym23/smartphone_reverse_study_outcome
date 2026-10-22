package com.obric.autoaction.app.launcherpage.detail.shortcut.data;

import android.content.Context;
import android.util.Log;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.n;
import d.o.o;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: TaskNetRepo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static final String TAG = "TaskNetRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f23539a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f23540b = null;

    /* JADX INFO: compiled from: TaskNetRepo.kt */
    @d.c.b.a.f(b = "TaskNetRepo.kt", c = {34}, d = "createServerCheck", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.data.TaskNetRepo")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f23542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f23543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23544d;

        a(g r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23543c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23542b = r3;
            this.f23544d |= Integer.MIN_VALUE;
            return this.f23543c.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private g() {
    }

    static {
        f23539a = new g();
        f23540b = o.b(com.obric.aiagent.product.a.a.f18769a.c(), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final Object a(String r12, String r13, d.c.d<? super com.obric.autogui.common.d<b>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, a.class) == false) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.aiagent.plugin");
        if ((r2.f23544d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f23544d -= Integer.MIN_VALUE;
    L8:
        a r9 = r2;
        Object r16 = r9.f23542b;
        Object r3 = d.c.a.b.a();
        int r4 = r9.f23544d;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        g this = (g) ZeusTransformUtils.preCheckCast(r9.f23541a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L14
    L26:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r17 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r17.a() == false) goto L53;
        JsonObject r11 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.d.f24472a.a().fromJson((String) ZeusTransformUtils.preCheckCast(r17.c(), String.class, "com.obric.aiagent.plugin"), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        int r18 = r11.get(MonitorConstants.CODE).getAsInt();     // Catch: Throwable -> L14
        String r19 = r11.get("msg").getAsString();     // Catch: Throwable -> L14
        String r110 = r11.get("log_id").getAsString();     // Catch: Throwable -> L14
        if (r18 == 0) goto L55;
        Loog.INSTANCE.e(TAG, "createServerCheck failed, code: " + r18);     // Catch: Throwable -> L14
        return com.obric.autogui.common.d.f29012a.a("createServerCheck failed, code: " + r18 + ", message: " + r19 + ", logId: " + r110);
    L55:
        return com.obric.autogui.common.d.f29012a.a((b) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.d.f24472a.a().fromJson(r11.get("data"), b.class), b.class, "com.obric.aiagent.plugin"));
    L53:
        n.a r111 = n.f38560a;     // Catch: Throwable -> L30
        g r112 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Object r113 = n.f(r17.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L30
    L32:
        String r114 = null;
        if (n.b(r113) == false) goto L35;
        r113 = null;
    L35:
        com.obric.autogui.tools.api.net.b r115 = (com.obric.autogui.tools.api.net.b) ZeusTransformUtils.preCheckCast(r113, com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        StringBuilder r116 = new StringBuilder().append("createServerCheck failed: response not ok, errorType: ");     // Catch: Throwable -> L14
        if (r115 == null) goto L38;
        com.obric.autogui.tools.api.net.c r117 = r115.getType();     // Catch: Throwable -> L14
    L39:
        StringBuilder r118 = r116.append(r117).append(", errorCode: ");     // Catch: Throwable -> L14
        if (r115 == null) goto L42;
        r114 = r115.a();     // Catch: Throwable -> L14
    L42:
        String r119 = r118.append(r114).toString();     // Catch: Throwable -> L14
        Loog.INSTANCE.e(TAG, r119);     // Catch: Throwable -> L14
        return com.obric.autogui.common.d.f29012a.a(r119);
    L38:
        r117 = null;
        goto L39
    L30:
        th = move-exception;
        n.a r120 = n.f38560a;     // Catch: Throwable -> L14
        r113 = n.f(d.o.a(th));     // Catch: Throwable -> L14
        goto L32
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r16);
        com.obric.autogui.tools.api.net.a r5 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r5 == null) goto L21;
        Loog.INSTANCE.i(TAG, "createServerCheck, instructionType: " + r13);
        String r7 = com.obric.autoaction.app.launcherpage.utils.d.f24472a.a().toJson(new com.obric.autoaction.app.launcherpage.detail.shortcut.data.a(r12, "uitars", r13, AODeviceInfo.INSTANCE.getRpDid()));
        String r121 = f23540b + "/auto_action/api/instruction/check";     // Catch: Throwable -> L14
        Map<String, String> r6 = ao.a(s.a("Content-type", "application/json"));     // Catch: Throwable -> L14
        d.h.b.o.a(r7);     // Catch: Throwable -> L14
        r9.f23541a = this;     // Catch: Throwable -> L14
        r9.f23544d = 1;     // Catch: Throwable -> L14
        r16 = r5.a(r121, r6, r7, 60000, r9);     // Catch: Throwable -> L14
        if (r16 != r3) goto L26;
        return r3;
    L21:
        return com.obric.autogui.common.d.f29012a.a("network client is null");
    L14:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "createServerCheck, request exception: " + Log.getStackTraceString(th));
        return com.obric.autogui.common.d.f29012a.a("createServerCheck failed: request exception: " + th.getClass().getSimpleName() + ": " + th.getMessage());
    L7:
        r2 = new a(this, r15);
        goto L8
    }
}
