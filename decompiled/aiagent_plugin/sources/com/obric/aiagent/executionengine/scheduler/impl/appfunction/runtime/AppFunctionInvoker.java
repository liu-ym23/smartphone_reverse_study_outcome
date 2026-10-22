package com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime;

import android.app.Application;
import android.app.appfunctions.AppFunctionException;
import android.app.appfunctions.AppFunctionManager;
import android.app.appfunctions.ExecuteAppFunctionRequest;
import android.app.appfunctions.ExecuteAppFunctionResponse;
import android.app.appsearch.GenericDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.AppFunctionCallResult;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.i;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.l;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.d;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AppFunctionInvoker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionInvoker implements IAppFunctionInvoker {
    public static final a Companion = null;
    private static final int REQUIRED_SDK = 36;
    private static final String TAG = "AppFunctionInvoker";
    private final f executor$delegate;

    /* JADX INFO: compiled from: AppFunctionInvoker.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AppFunctionInvoker.kt */
    @d.c.b.a.f(b = "AppFunctionInvoker.kt", c = {ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId, 189}, d = "executeInternal", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.AppFunctionInvoker")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18336d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f18337e;
        /* synthetic */ Object f;
        final /* synthetic */ AppFunctionInvoker g;
        int h;

        b(AppFunctionInvoker r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return AppFunctionInvoker.access$executeInternal(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionInvoker.kt */
    static final class c implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellationSignal f18338a;

        c(CancellationSignal r1) {
            this.f18338a = r1;
        }

        public final void a(Throwable r1) {
            this.f18338a.cancel();
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ ExecutorService lambda$iQZKfusifymmXZSj0kOqIydzJTU() {
        return executor_delegate$lambda$0();
    }

    public AppFunctionInvoker() {
        this.executor$delegate = g.a($$Lambda$AppFunctionInvoker$iQZKfusifymmXZSj0kOqIydzJTU.INSTANCE);
    }

    public static final /* synthetic */ Object access$executeInternal(AppFunctionInvoker r2, String r3, String r4, String r5, d.c.d r6) {
        return r2.executeInternal(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Executor access$getExecutor(AppFunctionInvoker r0) {
        return r0.getExecutor();
    }

    public static final /* synthetic */ AppFunctionCallResult access$mapError(AppFunctionInvoker r2, AppFunctionException r3) {
        return r2.mapError((AppFunctionException) ZeusTransformUtils.wrapperContextForParams(r3, AppFunctionException.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AppFunctionCallResult access$mapSuccess(AppFunctionInvoker r2, ExecuteAppFunctionResponse r3, String r4, String r5) {
        return r2.mapSuccess((ExecuteAppFunctionResponse) ZeusTransformUtils.wrapperContextForParams(r3, ExecuteAppFunctionResponse.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    private static final ExecutorService executor_delegate$lambda$0() {
        return Executors.newCachedThreadPool();
    }

    private final Executor getExecutor() {
        Object r2 = this.executor$delegate.b();
        o.c(r2, "getValue(...)");
        return (Executor) ZeusTransformUtils.preCheckCast(r2, Executor.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker
    public Object execute(String r16, String r17, String r18, d.c.d<? super AppFunctionCallResult> r19) {
        d.c.d<? super AppFunctionCallResult> r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 36) goto L7;
        return new AppFunctionCallResult(-1, "AppFunction requires SDK >= 36, current=" + Build.VERSION.SDK_INT, null, null, null, false, null, null, null, 508, null);
    L7:
        return executeInternal(r16, r17, r18, r0);
    }

    private final Object executeInternal(String r28, String r29, String r30, d.c.d<? super AppFunctionCallResult> r31) {
        final AppFunctionInvoker r0 = this;
        final String r1 = r28;
        final String r2 = r29;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L7;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        if ((r6.h & Integer.MIN_VALUE) == 0) goto L7;
        r6.h -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.f;
        Object r7 = d.c.a.b.a();
        int r8 = r6.h;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        ExecuteAppFunctionRequest r3 = (ExecuteAppFunctionRequest) ZeusTransformUtils.preCheckCast(r6.f18337e, ExecuteAppFunctionRequest.class, "com.obric.aiagent.plugin");
        AppFunctionManager r9 = (AppFunctionManager) ZeusTransformUtils.preCheckCast(r6.f18336d, AppFunctionManager.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.f18335c, String.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.f18334b, String.class, "com.obric.aiagent.plugin");
        AppFunctionInvoker r12 = (AppFunctionInvoker) ZeusTransformUtils.preCheckCast(r6.f18333a, AppFunctionInvoker.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L39:
        return r5;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AppFunctionManager r13 = (AppFunctionManager) ZeusTransformUtils.preCheckCast(r6.f18337e, AppFunctionManager.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r6.f18336d, String.class, "com.obric.aiagent.plugin");
        r2 = (String) ZeusTransformUtils.preCheckCast(r6.f18335c, String.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r6.f18334b, String.class, "com.obric.aiagent.plugin");
        AppFunctionInvoker r16 = (AppFunctionInvoker) ZeusTransformUtils.preCheckCast(r6.f18333a, AppFunctionInvoker.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        AppFunctionManager r17 = r13;
        r0 = r16;
        String r18 = r14;
        r1 = r15;
    L24:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L43;
        ILogDepend.Companion.w(TAG, "executeAppFunction skipped, disabled pkg=" + r1 + ", functionId=" + r2);
        return new AppFunctionCallResult(-1, "AppFunction disabled: " + r1 + '/' + r2, null, null, null, false, null, null, null, 508, null);
    L43:
        m r19 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x.f18310a.a(r1, r2);     // Catch: Throwable -> L40
        if (r19 == null) goto L30;
        Map<String, String> r20 = r19.h();     // Catch: Throwable -> L40
    L31:
        if (r20 != null) goto L33;
        r20 = ao.b();     // Catch: Throwable -> L40
    L33:
        ExecuteAppFunctionRequest r21 = new ExecuteAppFunctionRequest.Builder(r1, r2).setParameters(com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a.f18339a.a(r18, r20)).build();
        ILogDepend.Companion.i(TAG, "executeAppFunction pkg=" + r1 + ", functionId=" + r2);
        r6.f18333a = r0;
        r6.f18334b = r1;
        r6.f18335c = r2;
        r6.f18336d = r17;
        r6.f18337e = r21;
        r6.h = 2;
        kotlinx.coroutines.o r22 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r22.e();
        final n r23 = (n) ZeusTransformUtils.preCheckCast(r22, n.class, "com.obric.aiagent.plugin");
        CancellationSignal r110 = new CancellationSignal();
        r23.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r110), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r17.executeAppFunction(r21, access$getExecutor(r0), r110, (OutcomeReceiver) ZeusTransformUtils.preCheckCast(new AppFunctionInvoker$executeInternal$2$2(r23, r0, r1, r2), OutcomeReceiver.class, "com.obric.aiagent.plugin"));
        r5 = r22.h();
        if (r5 != d.c.a.b.a()) goto L37;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    L37:
        if (r5 != r7) goto L39;
        return r7;
    L30:
        r20 = null;
    L40:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "paramsJsonToDocument failed: " + r18, th);
        return new AppFunctionCallResult(-2, "invalid params json: " + th.getMessage(), null, null, null, false, null, null, null, 508, null);
    L16:
        d.o.a(r5);
        r17 = (AppFunctionManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(AppFunctionManager.class), AppFunctionManager.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L19;
        l r24 = l.f18264a;
        r6.f18333a = r0;
        r6.f18334b = r1;
        r6.f18335c = r2;
        r18 = r30;
        r6.f18336d = r18;
        r6.f18337e = r17;
        r6.h = 1;
        r5 = r24.a(r1, r2, r6);
        if (r5 != r7) goto L24;
        return r7;
    L19:
        return new AppFunctionCallResult(-1, "AppFunctionManager unavailable on this device", null, null, null, false, null, null, null, 508, null);
    L7:
        r6 = new b(r0, r4);
        goto L8
    }

    private final AppFunctionCallResult mapSuccess(ExecuteAppFunctionResponse r23, String r24, String r25) {
        ExecuteAppFunctionResponse r2 = (ExecuteAppFunctionResponse) ZeusTransformUtils.wrapperContextForParams(r23, ExecuteAppFunctionResponse.class, "com.obric.aiagent.plugin");
        GenericDocument r3 = r2.getResultDocument();     // Catch: Throwable -> L28
        GenericDocument r4 = r3.getPropertyDocument("androidAppfunctionsReturnValue");     // Catch: Throwable -> L28
        if (r4 != null) goto L6;
        r4 = r3;
    L6:
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a r5 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a.f18339a;     // Catch: Throwable -> L28
        o.a(r4);     // Catch: Throwable -> L28
        if (r5.a(r4) == false) goto L9;
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a.C0380a r0 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a.f18339a.a(r4, com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a.f18339a.a(r2.getExtras(), "androidAppfunctionsReturnValue"));     // Catch: Throwable -> L28
        return new AppFunctionCallResult(0, null, null, null, r0.d(), true, Integer.valueOf(r0.a()), r0.b(), r0.c(), 14, null);
    L9:
        m r6 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x.f18310a.a(r24, r25);     // Catch: Throwable -> L28
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a r7 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a.f18339a;     // Catch: Throwable -> L28
        o.a(r3);     // Catch: Throwable -> L28
        if (r6 == null) goto L12;
        i r8 = r6.j();     // Catch: Throwable -> L28
    L14:
        if (r6 == null) goto L17;
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.h r9 = r6.i();     // Catch: Throwable -> L28
        if (r9 == null) goto L17;
    L18:
        String r13 = r7.a(r3, "androidAppfunctionsReturnValue", r8, r9);     // Catch: Throwable -> L28
        ILogDepend.Companion.d(TAG, "response=" + r13);     // Catch: Throwable -> L28
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a r10 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a.f18339a;     // Catch: Throwable -> L28
        Bundle r11 = r2.getExtras();     // Catch: Throwable -> L28
        if (r6 == null) goto L21;
        i r12 = r6.j();     // Catch: Throwable -> L28
    L22:
        if (r6 == null) goto L25;
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.h r14 = r6.i();     // Catch: Throwable -> L28
        if (r14 == null) goto L25;
    L33:
        return new AppFunctionCallResult(0, null, r13, null, r10.a(r11, "androidAppfunctionsReturnValue", r12, r14), false, null, null, null, 490, null);
    L25:
        r14 = new com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.h(null, 1, null);     // Catch: Throwable -> L28
        goto L33
    L21:
        r12 = null;
    L17:
        r9 = new com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.h(null, 1, null);     // Catch: Throwable -> L28
        goto L18
    L12:
        r8 = null;
    L28:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "mapSuccess failed", th);
        return new AppFunctionCallResult(-3, "parse result failed: " + th.getMessage(), null, null, null, false, null, null, null, 508, null);
    }

    private final AppFunctionCallResult mapError(AppFunctionException r15) {
        AppFunctionException r14 = (AppFunctionException) ZeusTransformUtils.wrapperContextForParams(r15, AppFunctionException.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "executeAppFunction error code=" + r14.getErrorCode() + ", msg=" + r14.getErrorMessage());
        return new AppFunctionCallResult(r14.getErrorCode(), r14.getErrorMessage(), null, null, null, false, null, null, null, 508, null);
    }
}
