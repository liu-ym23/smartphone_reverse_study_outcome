package com.obric.aiagent;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PluginLaunch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PluginLaunch {
    public static final PluginLaunch INSTANCE = null;
    private static final String TAG = "PluginLaunch";
    private static volatile boolean initialized;

    static {
        INSTANCE = new PluginLaunch();
    }

    private PluginLaunch() {
    }

    public static final void initAllAfterCreate(Context r8, Application r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        Application r11 = (Application) ZeusTransformUtils.wrapperContextForParams(r9, Application.class, "com.obric.aiagent.plugin");
        o.e(r10, "base");
        o.e(r11, "app");
        if (initialized == false) goto L6;
        ILogDepend.Companion.w(TAG, "PluginLaunch already initialized, skip initAllAfterCreate");
        return;
    L6:
        initialized = true;
        long r3 = System.currentTimeMillis();
        ILogDepend.Companion.i(TAG, "initAllAfterCreate start, curMills = " + r3 + ", pid = " + Process.myPid());
        IAppContext r0 = (IAppContext) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppContext.class), IAppContext.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        ILogDepend.Companion r5 = ILogDepend.Companion;     // Catch: Exception -> L15
        StringBuilder r6 = new StringBuilder().append("IAppContext service found: ");     // Catch: Exception -> L15
        if (r0 == null) goto L12;
        Class<?> r1 = r0.getClass();     // Catch: Exception -> L15
        if (r1 == null) goto L12;
        String r2 = r1.getName();     // Catch: Exception -> L15
    L13:
        r5.i(TAG, r6.append(r2).toString());     // Catch: Exception -> L15
    L18:
        if (ZeusTransformUtils.instanceOf((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Application.class) == false) goto L20;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r12, "null cannot be cast to non-null type android.app.Application");
        r11 = (Application) ZeusTransformUtils.preCheckCast(r12, Application.class, "com.obric.aiagent.plugin");
    L20:
        ILogDepend.Companion.i(TAG, "application class: " + r11.getClass().getName());
        a.f16090a.a(r10, r11);
        ILogDepend.Companion.i(TAG, "InitPeriodWrapper.init done");
        a.f16090a.a();
        ILogDepend.Companion.i(TAG, "beforeApplicationAttach done");
        a.f16090a.b();
        ILogDepend.Companion.i(TAG, "afterApplicationAttach done");
        a.f16090a.c();
        ILogDepend.Companion.i(TAG, "beforeApplicationCreate done");
        a.f16090a.d();
        ILogDepend.Companion.i(TAG, "afterApplicationCreate done");
        ILogDepend.Companion.i(TAG, "initAllAfterCreate completed, cost = " + (System.currentTimeMillis() - r3) + "ms");
        return;
    L12:
        r2 = null;
    L15:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "IAppContext service not found", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L18
    }
}
