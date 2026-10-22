package com.obric.memorydata.sdk.screencapture;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.service.IScreenCaptureService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ScreenCaptureManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScreenCaptureManager {
    public static final ScreenCaptureManager INSTANCE = null;
    private static final String SCREEN_CAPTURE_SERVICE = "com.obric.memorydata.action.SCREEN_CAPTURE_SERVICE";
    private static final String TAG = "ScreenCaptureManager";
    private static Context appContext;
    private static final Object bindingLock = null;
    private static final ScreenCaptureManager$connection$1 connection = null;
    private static boolean isBinding;
    private static boolean isBound;
    private static Handler mainHandler;
    private static final List<c> pendingCaptureOperations = null;
    private static final List<d> pendingOperations = null;
    private static IScreenCaptureService service;
    private static final f workHandler$delegate = null;

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.screencapture.ScreenCaptureManager$registerRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScreenCaptureManager.kt */
    public static final class BinderC11931 extends IEventReactionCallback.Stub {
        final /* synthetic */ b $callback;
        final /* synthetic */ boolean $isMainThread;

        public static /* synthetic */ void lambda$0buVX_bo7t1XJZzOXzFLfXiu1Dw(b r0, int r1, String r2) {
            onError$lambda$1(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$ykxGT57LpqQBgoG_pIlOpmGvauw(b r0, ScreenEvent r1, ScreenData r2) {
            onEvent$lambda$0(r0, r1, r2);
        }

        BinderC11931(boolean r3, b r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
            this.$isMainThread = r3;
            this.$callback = r5;
        }

        @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
        public void onEvent(final ScreenEvent r3, final ScreenData r4) {
            o.e(r3, "event");
            o.e(r4, "data");
            if (this.$isMainThread == false) goto L5;
            Handler r0 = ScreenCaptureManager.access$getMainHandler$p();
            final b r2 = this.$callback;
            r0.post(new $$Lambda$ScreenCaptureManager$registerRemote$1$ykxGT57LpqQBgoG_pIlOpmGvauw(r2, r3, r4));
        L6:
            ScreenCaptureManager.access$autoUnbindServiceIfNeed(ScreenCaptureManager.INSTANCE);
            return;
        L5:
            this.$callback.a(r3, r4);
            goto L6
        }

        private static final void onEvent$lambda$0(b r2, ScreenEvent r3, ScreenData r4) {
            ((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin")).a(r3, r4);
        }

        @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
        public void onError(final int r3, final String r4) {
            o.e(r4, "errorMessage");
            if (this.$isMainThread == false) goto L5;
            Handler r0 = ScreenCaptureManager.access$getMainHandler$p();
            final b r2 = this.$callback;
            r0.post(new $$Lambda$ScreenCaptureManager$registerRemote$1$0buVX_bo7t1XJZzOXzFLfXiu1Dw(r2, r3, r4));
        L6:
            ScreenCaptureManager.access$autoUnbindServiceIfNeed(ScreenCaptureManager.INSTANCE);
            return;
        L5:
            this.$callback.a(r3, r4);
            goto L6
        }

        private static final void onError$lambda$1(b r2, int r3, String r4) {
            ((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin")).a(r3, r4);
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public static /* synthetic */ int access$003(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Dd21Q-Is964WapL3wmKjg3_Q9YI, reason: not valid java name */
    public static /* synthetic */ x m957lambda$Dd21QIs964WapL3wmKjg3_Q9YI(d.h.a.a r0) {
        return captureCurrent$lambda$3$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$FBh8Jm9KrR3r-S8s8SxGh9kv-J0, reason: not valid java name */
    public static /* synthetic */ void m958lambda$FBh8Jm9KrR3rS8s8SxGh9kvJ0() {
        autoUnbindServiceIfNeed$lambda$12();
    }

    public static /* synthetic */ void lambda$RGUts4Cvd8hrgfo15xNeNay8DhI(List r0, List r1) {
        drainPendingOperationsAsync$lambda$18(r0, r1);
    }

    public static /* synthetic */ void lambda$_PkBcOeoQvUhma0u8zZgbmi6_f0(d.h.a.a r0) {
        captureCurrent$lambda$3$lambda$2$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$n8bpdXm1teG-VMIxPj5_oqGOSec, reason: not valid java name */
    public static /* synthetic */ Handler m959lambda$n8bpdXm1teGVMIxPj5_oqGOSec() {
        return workHandler_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$qRiNuhW6xkn7GNS0qXzW-Touj8U, reason: not valid java name */
    public static /* synthetic */ x m960lambda$qRiNuhW6xkn7GNS0qXzWTouj8U(d.h.a.a r0) {
        return captureCurrentRemote$lambda$6(r0);
    }

    public static /* synthetic */ x lambda$vG05Cm2KUDic5GrXUcv_Nh2Y3nE() {
        return captureCurrentRemote$lambda$7();
    }

    /* JADX INFO: renamed from: lambda$xCf-im9-nKECRhyi1gkCTfHHr74, reason: not valid java name */
    public static /* synthetic */ void m961lambda$xCfim9nKECRhyi1gkCTfHHr74(d.h.a.a r0) {
        captureCurrentRemote$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ void lambda$xGWxHJl9qNGf2Hk9qnXn1vSSAMM(c r0) {
        drainPendingOperationsAsync$lambda$18$lambda$17$lambda$16(r0);
    }

    public final void register(Context r10, ScreenEventReaction r11, b r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r12, b.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r11, "screenEventReaction");
        o.e(r5, "callback");
        register$default(this, r3, r11, r5, 0, 8, null);
    }

    public final void registerOneShot(Context r12, ScreenEventReaction r13, long r14, b r16) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r16, b.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r13, "reaction");
        o.e(r7, "callback");
        registerOneShot$default(this, r3, r13, r14, r7, 0, 16, null);
    }

    private ScreenCaptureManager() {
    }

    public static final /* synthetic */ void access$autoUnbindServiceIfNeed(ScreenCaptureManager r0) {
        r0.autoUnbindServiceIfNeed();
    }

    public static final /* synthetic */ void access$drainPendingOperationsAsync(ScreenCaptureManager r0) {
        r0.drainPendingOperationsAsync();
    }

    public static final /* synthetic */ Object access$getBindingLock$p() {
        return bindingLock;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ void access$setBinding$p(boolean r0) {
        isBinding = r0;
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(IScreenCaptureService r2) {
        service = (IScreenCaptureService) ZeusTransformUtils.wrapperContextForParams(r2, IScreenCaptureService.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$unbindService(ScreenCaptureManager r0) {
        r0.unbindService();
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.memorydata.sdk.screencapture.ScreenCaptureManager$connection$1] */
    static {
        INSTANCE = new ScreenCaptureManager();
        mainHandler = new Handler(Looper.getMainLooper());
        workHandler$delegate = g.a($$Lambda$ScreenCaptureManager$n8bpdXm1teGVMIxPj5_oqGOSec.INSTANCE);
        bindingLock = new Object();
        pendingOperations = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        pendingCaptureOperations = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        connection = new ScreenCaptureManager$connection$1();
    }

    private final Handler getWorkHandler() {
        return (Handler) ZeusTransformUtils.preCheckCast(workHandler$delegate.b(), Handler.class, "com.obric.aiagent.plugin");
    }

    private static final Handler workHandler_delegate$lambda$0() {
        HandlerThread r0 = new HandlerThread("screen_capture_worker");
        r0.start();
        return new Handler(r0.getLooper());
    }

    public static /* synthetic */ void register$default(ScreenCaptureManager r1, Context r2, ScreenEventReaction r3, b r4, int r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = 64;
    L5:
        r1.register(r8, r3, r9, r5);
    }

    public final void register(Context r10, ScreenEventReaction r11, b r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r12, b.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r11, "screenEventReaction");
        o.e(r7, "callback");
        registerInternal(r3, r11, 0, r7, r13);
    }

    public final void unregister(ScreenEventReaction r2) {
        o.e(r2, "screenEventReaction");
        unregister(r2.getId());
    }

    public final void unregister(String r3) {
        o.e(r3, "reactionId");
        IScreenCaptureService r0 = service;
        if (r0 == null) goto L5;
        r0.unregister(r3);
    L6:
        autoUnbindServiceIfNeed();
        return;
    L5:
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Service not available when unregistering reaction: " + r3);
        goto L6
    }

    public static /* synthetic */ void registerOneShot$default(ScreenCaptureManager r9, Context r10, ScreenEventReaction r11, long r12, b r14, int r15, int r16, Object r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r14, b.class, "com.obric.aiagent.plugin");
        if ((r16 & 16) == 0) goto L5;
        int r8 = 64;
    L6:
        r9.registerOneShot(r3, r11, r12, r7, r8);
        return;
    L5:
        r8 = r15;
        goto L6
    }

    public final void registerOneShot(Context r10, ScreenEventReaction r11, long r12, b r14, int r15) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r14, b.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r11, "reaction");
        o.e(r7, "callback");
        registerInternal(r3, r11, r12, r7, r15);
    }

    public final void captureCurrent(Context r2, TaskOptions r3, String r4, d.h.a.b<? super ScreenData, x> r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super ScreenData, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "taskOptions");
        o.e(r4, "targetPackage");
        o.e(r6, "callback");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "getApplicationContext(...)");
        appContext = r7;
        Object r8 = bindingLock;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (isBound == false) goto L7;
        INSTANCE.captureCurrentRemote(r3, r4, r6);     // Catch: Throwable -> L19
        x r9 = x.f38692a;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r8);
        return;
    L7:
        c r10 = new c(r3, r4, r6);     // Catch: Throwable -> L19
        List<c> r11 = pendingCaptureOperations;     // Catch: Throwable -> L19
        r11.add(r10);     // Catch: Throwable -> L19
        if (isBinding == true) goto L16;
        ScreenCaptureManager r12 = INSTANCE;     // Catch: Throwable -> L19
        Context r13 = appContext;     // Catch: Throwable -> L19
        if (r13 != null) goto L13;
        o.c("appContext");     // Catch: Throwable -> L19
        r13 = null;
    L13:
        if (r12.bindService(r13, 64) == true) goto L15;
        e.a(r11, r10, $$Lambda$ScreenCaptureManager$Dd21QIs964WapL3wmKjg3_Q9YI.INSTANCE);     // Catch: Throwable -> L19
    L15:
        x r14 = x.f38692a;     // Catch: Throwable -> L19
        goto L17
    L16:
        Integer.valueOf(INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "Service binding in progress, queued captureCurrent for package: " + r4));     // Catch: Throwable -> L19
        goto L17
    }

    private static final x captureCurrent$lambda$3$lambda$2(d.h.a.a r2) {
        final d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        mainHandler.post(new $$Lambda$ScreenCaptureManager$_PkBcOeoQvUhma0u8zZgbmi6_f0(r3));
        return x.f38692a;
    }

    private static final void captureCurrent$lambda$3$lambda$2$lambda$1(d.h.a.a r2) {
        ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
    }

    private final void registerInternal(Context r3, ScreenEventReaction r4, long r5, b r7, int r8) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "registerInternal: isBound=" + isBound + ", isBinding=" + isBinding);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "getApplicationContext(...)");
        appContext = r9;
        Object r10 = bindingLock;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isBound == false) goto L8;
        INSTANCE.registerRemote(r4, r5, r6);     // Catch: Throwable -> L16
        x r11 = x.f38692a;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r10);
        return;
    L8:
        if (isBinding == true) goto L13;
        pendingOperations.add(new d(r4, r5, r6));     // Catch: Throwable -> L16
        ScreenCaptureManager r12 = INSTANCE;     // Catch: Throwable -> L16
        Context r13 = appContext;     // Catch: Throwable -> L16
        if (r13 != null) goto L12;
        o.c("appContext");     // Catch: Throwable -> L16
        r13 = null;
    L12:
        Boolean.valueOf(r12.bindService(r13, r8));     // Catch: Throwable -> L16
        goto L14
    L13:
        pendingOperations.add(new d(r4, r5, r6));     // Catch: Throwable -> L16
        Integer.valueOf(INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "Service binding in progress, queued registration for reaction: " + r4.getId()));     // Catch: Throwable -> L16
        goto L14
    }

    private final void registerRemote(ScreenEventReaction r4, long r5, b r7) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        boolean r8 = o.a(Looper.myLooper(), Looper.getMainLooper());
        IScreenCaptureService r1 = service;
        if (r1 == null) goto L5;
        r1.register(r4, r5, (IEventReactionCallback) ZeusTransformUtils.preCheckCast(new BinderC11931(r8, r3), IEventReactionCallback.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Service is null when trying to register reaction: " + r4.getId());
    }

    private final void captureCurrentRemote(TaskOptions r6, String r7, d.h.a.b<? super ScreenData, x> r8) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "captureCurrent queued/bound package=" + r7);
        final a r0 = new a($$Lambda$ScreenCaptureManager$qRiNuhW6xkn7GNS0qXzWTouj8U.INSTANCE, r9, $$Lambda$ScreenCaptureManager$vG05Cm2KUDic5GrXUcv_Nh2Y3nE.INSTANCE);
        IScreenCaptureService r3 = service;     // Catch: Exception -> L8
        if (r3 == null) goto L6;
        r3.captureCurrent(r6, r7, (ICaptureCurrentCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r0), ICaptureCurrentCallback.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
    L11:
        return;
    L6:
        ScreenCaptureManager r5 = (ScreenCaptureManager) ZeusTransformUtils.preCheckCast(this, ScreenCaptureManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Service is null when trying to capture current screen: " + r7);     // Catch: Exception -> L8
        r0.a(null);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "captureCurrent remote call failed: " + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r0.a(null);
    }

    private static final x captureCurrentRemote$lambda$6(d.h.a.a r2) {
        final d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        mainHandler.post(new $$Lambda$ScreenCaptureManager$xCfim9nKECRhyi1gkCTfHHr74(r3));
        return x.f38692a;
    }

    private static final void captureCurrentRemote$lambda$6$lambda$5(d.h.a.a r2) {
        ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
    }

    private static final x captureCurrentRemote$lambda$7() {
        INSTANCE.autoUnbindServiceIfNeed();
        return x.f38692a;
    }

    private final boolean bindService(Context r7, int r8) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Object r9 = bindingLock;
        monitor-enter(r9);
    L31:
        th = move-exception;
        throw th;
    L6:
        if (isBinding == false) goto L10;
        monitor-exit(r9);
        return false;
    L10:
        isBinding = true;     // Catch: Throwable -> L31
        x r2 = x.f38692a;     // Catch: Throwable -> L31
        monitor-exit(r9);
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "bind service");
        Intent r3 = new Intent(SCREEN_CAPTURE_SERVICE);
        if (o.a("com.obric.memorydata", r6.getPackageName()) == false) goto L15;
        String r4 = "com.obric.memorydata";
    L16:
        r3.setPackage(r4);
        boolean r10 = ZeusTransformUtils.bindService(r6, r3, (ServiceConnection) ZeusTransformUtils.preCheckCast(connection, ServiceConnection.class, "com.obric.aiagent.plugin"), r8 | 1, "com.obric.aiagent.plugin");
        if (r10 == true) goto L30;
        StringBuilder r0 = new StringBuilder().append("not found service ");
        ComponentName r5 = r3.getComponent();
        if (r5 == null) goto L21;
        String r11 = r5.getShortClassName();
    L22:
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, r0.append(r11).toString());
        monitor-enter(r9);
        isBinding = false;     // Catch: Throwable -> L27
        x r12 = x.f38692a;     // Catch: Throwable -> L27
        monitor-exit(r9);
    L27:
        th = move-exception;
        throw th;
    L21:
        r11 = null;
    L30:
        return r10;
    L15:
        r4 = "com.larus.nova";
        goto L16
    }

    private final void unbindService() {
        if (isBound == false) goto L9;
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "unbind service");
        Context r3 = appContext;
        if (r3 != null) goto L7;
        o.c("appContext");
        r3 = null;
    L7:
        ZeusTransformUtils.unbindService(r3, (ServiceConnection) ZeusTransformUtils.preCheckCast(connection, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        isBound = false;
        return;
    }

    private final void autoUnbindServiceIfNeed() {
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "autoUnbindServiceIfNeed: isBound=" + isBound);
        mainHandler.post($$Lambda$ScreenCaptureManager$FBh8Jm9KrR3rS8s8SxGh9kvJ0.INSTANCE);
    }

    private static final void autoUnbindServiceIfNeed$lambda$12() {
        Object r0 = bindingLock;
        monitor-enter(r0);
        int r1 = 0;
        IScreenCaptureService r2 = service;     // Catch: Throwable -> L9 Exception -> L11
        if (r2 == null) goto L13;
        r1 = r2.getScreenEventReactionCount();     // Catch: Throwable -> L9 Exception -> L11
    L13:
        if (r1 != 0) goto L15;
        INSTANCE.unbindService();     // Catch: Throwable -> L9
    L15:
        x r3 = x.f38692a;     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L11:
        e = move-exception;
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "getScreenEventReactionCount failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private final void drainPendingOperationsAsync() {
        List<d> r0 = pendingOperations;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
    L6:
        final List r1 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));
        r0.clear();
        List<c> r2 = pendingCaptureOperations;
        final List r3 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
        r2.clear();
        getWorkHandler().post(new $$Lambda$ScreenCaptureManager$RGUts4Cvd8hrgfo15xNeNay8DhI(r1, r3));
        return;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(pendingCaptureOperations, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L6;
    }

    private static final void drainPendingOperationsAsync$lambda$18(List r7, List r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r11.next(), d.class, "com.obric.aiagent.plugin");
        INSTANCE.registerRemote(r0.a(), r0.b(), r0.c());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Failed to process pending operation", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    L10:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r12.hasNext() == false) goto L18;
        final c r13 = (c) ZeusTransformUtils.preCheckCast(r12.next(), c.class, "com.obric.aiagent.plugin");
        INSTANCE.captureCurrentRemote(r13.a(), r13.b(), r13.c());     // Catch: Exception -> L16
    L16:
        e = move-exception;
        INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Failed to process pending capture operation", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        mainHandler.post(new $$Lambda$ScreenCaptureManager$xGWxHJl9qNGf2Hk9qnXn1vSSAMM(r13));
        goto L12
    }

    private static final void drainPendingOperationsAsync$lambda$18$lambda$17$lambda$16(c r1) {
        r1.c().invoke(null);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_memorydata_sdk_screencapture_ScreenCaptureManager_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
