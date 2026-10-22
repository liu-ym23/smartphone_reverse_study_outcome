package com.obric.aiagent.plugin_impl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL;
import com.obric.aiagent.assistant.idl.IFlowNightModeChangeListenerIDL;
import com.obric.aiagent.assistant.idl.u;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: FlowNightModeCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "FlowNightModeCache";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f18757b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f18758c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f18759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final FlowNightModeCache$listener$1 f18760e = null;

    public static /* synthetic */ void lambda$1RCYgex31ezemvz7ygrxndn3yEY(int r0, String r1) {
        c(r0, r1);
    }

    public static /* synthetic */ void lambda$iU6YYLfnV3ZBRiDBjzMl0YGynh8(IFlowAssistantStateIDL r0) {
        a(r0);
    }

    private b() {
    }

    public static final /* synthetic */ String a(b r0, int r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ void a(b r0, int r1, String r2) {
        r0.a(r1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.aiagent.plugin_impl.FlowNightModeCache$listener$1] */
    static {
        f18756a = new b();
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        f18757b = r0;
        f18758c = new Handler(Looper.getMainLooper());
        f18760e = new FlowNightModeCache$listener$1();
        return;
    L5:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L8;
        r0 = false;
        goto L9
    }

    public final void a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        if (f18759d == true) goto L5;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L10:
        if (f18759d == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        f18759d = true;     // Catch: Throwable -> L18
        x r0 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(this);
        a(b(r8), "coldStart");
        ILogDepend.Companion.i(TAG, "ensureInit: waiting for IFlowAssistantStateIDL IPC to register");
        u.a(aa.b(IFlowAssistantStateIDL.class), false, false, $$Lambda$b$iU6YYLfnV3ZBRiDBjzMl0YGynh8.INSTANCE, 3, null);
        return;
    L5:
        if (f18757b == false) goto L23;
        ILogDepend.Companion.i(TAG, "ensureInit skipped: already initialized");
        return;
    }

    private static final void a(IFlowAssistantStateIDL r7) {
        IFlowAssistantStateIDL r8 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r7, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        o.e(r8, "ipc");
        ILogDepend.Companion.i(TAG, "IPC connected, start seed & register night mode listener");
        b r0 = f18756a;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L5
        int r4 = r8.getCurrentNightMode();     // Catch: Throwable -> L5
        ILogDepend.Companion.i(TAG, "seed currentNightMode from host = " + r0.a(r4));     // Catch: Throwable -> L5
        r0.a(r4, "seed");     // Catch: Throwable -> L5
        r8.registerNightModeListener((IFlowNightModeChangeListenerIDL) ZeusTransformUtils.preCheckCast(f18760e, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        ILogDepend.Companion.i(TAG, "registered night mode listener success");     // Catch: Throwable -> L5
        Object r9 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L14;
        ILogDepend.Companion.w(TAG, "register night mode listener failed: " + r10.getMessage());
        return;
    L14:
        return;
    L5:
        th = move-exception;
        n.a r1 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L7
    }

    private final void a(final int r3, final String r4) {
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        b(r3, r4);
        return;
    L5:
        f18758c.post(new $$Lambda$b$1RCYgex31ezemvz7ygrxndn3yEY(r3, r4));
    }

    private static final void c(int r1, String r2) {
        f18756a.b(r1, r2);
    }

    private final void b(int r7, String r8) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L14
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r7 != (-1)) goto L6;
        r6.a();     // Catch: Throwable -> L14
    L6:
        int r3 = androidx.appcompat.app.c.getDefaultNightMode();     // Catch: Throwable -> L14
        if (r3 == r7) goto L9;
        androidx.appcompat.app.c.setDefaultNightMode(r7);     // Catch: Throwable -> L14
        ILogDepend.Companion.i(TAG, "applyNightMode(" + r8 + ") setDefaultNightMode " + r6.a(r3) + " -> " + r6.a(r7));     // Catch: Throwable -> L14
        Object r9 = n.f(x.f38692a);     // Catch: Throwable -> L14
    L16:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L22;
        ILogDepend.Companion.w(TAG, "applyNightMode(" + r8 + ") failed: " + r10.getMessage());
        return;
    L22:
        return;
    L9:
        if (f18757b == false) goto L21;
        ILogDepend.Companion.i(TAG, "applyNightMode(" + r8 + ") skip: already " + r6.a(r7));     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L16
    }

    private final String a(int r3) {
        if (r3 == (-1)) goto L12;
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L14;
        return "UNKNOWN(" + r3 + ')';
    L14:
        return "YES(" + r3 + ')';
    L15:
        return "NO(" + r3 + ')';
    L12:
        return "FOLLOW_SYSTEM(" + r3 + ')';
    }

    private final int b(Context r3) {
        int r2 = c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        if (r2 == 1) goto L7;
        if (r2 == 2) goto L8;
        return -1;
    L8:
        return 2;
    L7:
        return 1;
    }

    private final int c(Context r9) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Object r10 = null;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L9
        Bundle r11 = ZeusProviderTransform.call(r8.getContentResolver(), Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider"), "query_night_mode_setting", null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        Integer r12 = Integer.valueOf(r11.getInt("night_mode"));     // Catch: Throwable -> L9
    L7:
        Object r13 = n.f(r12);     // Catch: Throwable -> L9
    L11:
        Throwable r2 = n.c(r13);
        if (r2 == null) goto L15;
        ILogDepend.Companion.w(TAG, "Failed to get night mode setting: " + r2.getMessage());
    L15:
        if (n.b(r13) == true) goto L18;
        r10 = r13;
    L18:
        Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L25;
        return -1;
    L25:
        return r14.intValue();
    L6:
        r12 = null;
    L9:
        th = move-exception;
        n.a r3 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L11
    }

    private final void a() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        b r7 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        Configuration r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getConfiguration();     // Catch: Throwable -> L8
        int r5 = r4.uiMode & 48;     // Catch: Throwable -> L8
        int r6 = Resources.getSystem().getConfiguration().uiMode & 48;     // Catch: Throwable -> L8
        if (r5 != r6) goto L6;
        return;
    L6:
        Configuration r8 = new Configuration(r4);     // Catch: Throwable -> L8
        r8.uiMode = (r8.uiMode & (-49)) | r6;     // Catch: Throwable -> L8
        ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").updateConfiguration(r8, ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDisplayMetrics());     // Catch: Throwable -> L8
        ILogDepend.Companion.i(TAG, "syncAppConfigNightToSystem: appConfigNight " + r7.b(r5) + " -> " + r7.b(r6));     // Catch: Throwable -> L8
        Object r9 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L16;
        ILogDepend.Companion.w(TAG, "syncAppConfigNightToSystem failed: " + r10.getMessage());
        return;
    L16:
        return;
    L8:
        th = move-exception;
        n.a r1 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L10
    }

    private final String b(int r2) {
        if (r2 != 32) goto L6;
        return "NIGHT_YES";
    L6:
        return "NIGHT_NO/UNDEF(" + r2 + ')';
    }
}
