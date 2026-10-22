package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.app.appfunctions.AppFunctionManager;
import android.os.OutcomeReceiver;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: AppFunctionEnabledChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private static final String TAG = "AppFuncEnabledChecker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f18264a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f18265b = null;

    /* JADX INFO: renamed from: lambda$zDI-nbXhbFk6gu1N4mXJY43aCmc, reason: not valid java name */
    public static /* synthetic */ ExecutorService m182lambda$zDInbXhbFk6gu1N4mXJY43aCmc() {
        return b();
    }

    private l() {
    }

    public static final /* synthetic */ Executor a(l r0) {
        return r0.a();
    }

    static {
        f18264a = new l();
        f18265b = d.g.a($$Lambda$l$zDInbXhbFk6gu1N4mXJY43aCmc.INSTANCE);
    }

    private final Executor a() {
        Object r2 = f18265b.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (Executor) ZeusTransformUtils.preCheckCast(r2, Executor.class, "com.obric.aiagent.plugin");
    }

    private static final ExecutorService b() {
        return Executors.newCachedThreadPool();
    }

    public final Object a(final String r6, final String r7, d.c.d<? super Boolean> r8) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        AppFunctionManager r9 = (AppFunctionManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(AppFunctionManager.class), AppFunctionManager.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L5;
        kotlinx.coroutines.o r2 = new kotlinx.coroutines.o(d.c.a.b.a(r5), 1);
        r2.e();
        final kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r9.isAppFunctionEnabled(r7, r6, a(f18264a), (OutcomeReceiver) ZeusTransformUtils.preCheckCast(new AppFunctionEnabledChecker$isEnabled$2$1(r1, r6, r7), OutcomeReceiver.class, "com.obric.aiagent.plugin"));
        Object r10 = r2.h();
        if (r10 != d.c.a.b.a()) goto L9;
        d.c.b.a.h.c(r5);
    L9:
        return r10;
    L5:
        return d.c.b.a.b.a(true);
    }
}
