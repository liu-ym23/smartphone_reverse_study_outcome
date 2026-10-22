package com.bytedance.ai.core.manager;

import android.content.Context;
import android.os.Trace;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.JSWorkerRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.utils.g;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import h5.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.MutexImpl;
import m5.i;
import m5.i1;
import m5.j;
import m5.x;
import m5.y;
import m5.y0;

/* JADX INFO: loaded from: classes43.dex */
public final class WorkerRuntimeManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f36157e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, AppletRuntime> f36158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, AppletRuntime> f36159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutexImpl f36160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, CompletableDeferred<AppletRuntime>> f36161d;

    public static final class a {
    }

    static {
    }

    public WorkerRuntimeManager() {
        this.f36158a = new ConcurrentHashMap();
        this.f36159b = new ConcurrentHashMap();
        this.f36160c = kotlinx.coroutines.sync.b.a();
        this.f36161d = new ConcurrentHashMap();
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        AppletRuntime r101 = this.f36158a.remove(r100);
        if (r101 == null) goto L5;
        r101.G();
    L5:
        b3.b r102 = b3.b.f17112a;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);     // Catch: Throwable -> L12
        com.bytedance.ai.applet.base.log.b r103 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Throwable -> L12
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "terminateApp, appletId:" + r100);     // Catch: Throwable -> L12
        b3.a r104 = b3.b.f17113b.remove(r100);     // Catch: Throwable -> L12
        if (r104 == null) goto L10;
        r104.f17110c.destroy();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, kotlinx.coroutines.CompletableDeferred<T>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r5v7, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final <T> Object c(CompletableDeferred<T> r100, Function1<? super Continuation<? super T>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof WorkerRuntimeManager$safeRun$1) == false) goto L7;
        WorkerRuntimeManager$safeRun$1 r103 = (WorkerRuntimeManager$safeRun$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        boolean r108 = (CompletableDeferred<T>) ((CompletableDeferred) r103.L$0);
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L22
        r100 = r108;
    L20:
        ((CompletableDeferred) r100).complete(r105);     // Catch: Exception -> L22
    L25:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;     // Catch: Exception -> L22
        r103.label = 1;     // Catch: Exception -> L22
        r105 = r101.invoke(r103);     // Catch: Exception -> L22
        r100 = r100;
        if (r105 != r106) goto L20;
        return r106;
    L22:
        e = move-exception;
        g.f37637a.e("WorkerRuntimeManager", "Exception safeRun: " + e.getMessage(), e);
        r100.complete(null);
    L7:
        r103 = new WorkerRuntimeManager$safeRun$1(this, r102);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final Object b(String r210, Context r211, String r212, String r213, String r214, String r215, SessionType r310, Map<String, Object> r311, Continuation<? super AppletRuntime> r312) {
        if ((r312 instanceof WorkerRuntimeManager$runAppletWorker$1) == false) goto L7;
        WorkerRuntimeManager$runAppletWorker$1 r100 = (WorkerRuntimeManager$runAppletWorker$1) r312;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        WorkerRuntimeManager$runAppletWorker$1 r102 = r100;
        Object r103 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r104 = r102.label;
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L18;
        if (r104 != 3) goto L17;
        CompletableDeferred<AppletRuntime> r105 = (CompletableDeferred) r102.L$3;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r102.L$2;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$1;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L80
        Ref.ObjectRef r111 = r106;
        kotlinx.coroutines.sync.a r112 = r107;
        WorkerRuntimeManager r109 = this;
        CompletableDeferred<AppletRuntime> r113 = r105;
        Continuation r114 = null;
    L66:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new WorkerRuntimeManager$runAppletWorker$2$3(r109, r108, r113, r114), 3, null);     // Catch: Throwable -> L69
        JobKt.ensureActive(r102.getContext());     // Catch: Throwable -> L69
        AppletRuntime r115 = (AppletRuntime) r111.element;     // Catch: Throwable -> L69
        kotlinx.coroutines.sync.a r116 = r112;
    L67:
        r116.unlock(r114);
        return r115;
    L69:
        th = th;
    L70:
        ?? r117 = r112;
    L83:
        r117.unlock(r114);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        CompletableDeferred<AppletRuntime> r118 = (CompletableDeferred) r102.L$11;
        CompletableDeferred<AppletRuntime> r119 = (CompletableDeferred) r102.L$10;
        Ref.ObjectRef r120 = (Ref.ObjectRef) r102.L$9;
        kotlinx.coroutines.sync.a r121 = (kotlinx.coroutines.sync.a) r102.L$8;
        Map<String, Object> r122 = (Map) r102.L$7;
        SessionType r123 = (SessionType) r102.L$6;
        String r124 = (String) r102.L$5;
        String r125 = (String) r102.L$4;
        String r126 = (String) r102.L$3;
        String r127 = (String) r102.L$2;
        Context r128 = (Context) r102.L$1;
        String r129 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L21
        kotlinx.coroutines.sync.a r130 = r121;
        String r131 = r126;
        String r132 = r129;
        r111 = r120;
        Object r133 = r110;
        CompletableDeferred<AppletRuntime> r134 = r118;
        Context r135 = r128;
    L96:
        r115 = (AppletRuntime) r103;     // Catch: Throwable -> L50
        kotlinx.coroutines.sync.a r216 = r130;
        if (r115 == null) goto L42;
        g.f37637a.i("WorkerRuntimeManager", "runApplet " + r132 + ": await completed successfully, result=true");     // Catch: Throwable -> L48
        r116 = r216;
        r114 = null;
        goto L67
    L42:
        Object r136 = r133;
        g.f37637a.e("WorkerRuntimeManager", "runApplet " + r132 + ": await timeout, will retry by current thread");     // Catch: Throwable -> L48
        WorkerRuntimeManager r137 = this;
        Boxing.boxBoolean(r137.f36161d.remove(r132, r134));     // Catch: Throwable -> L46
        r112 = r216;
        Map<String, Object> r138 = r122;
        String r139 = r131;
        CompletableDeferred<AppletRuntime> r140 = r119;
        String r217 = r127;
        String r141 = r132;
        String r142 = r217;
        String r218 = r125;
        SessionType r143 = r123;
        String r144 = r218;
    L92:
        Object r145 = r136;
        String r146 = r139;
        String r147 = r144;
        String r148 = r124;
        SessionType r149 = r143;
        Map<String, Object> r150 = r138;
        CompletableDeferred<AppletRuntime> r151 = r140;
        String r152 = r141;
        WorkerRuntimeManager$runAppletWorker$2$2 r153 = new WorkerRuntimeManager$runAppletWorker$2$2(r141, r111, this, r135, r142, r146, r147, r148, r149, r150, null);     // Catch: Throwable -> L73
        r102.L$0 = r152;     // Catch: Throwable -> L73
        r102.L$1 = r112;     // Catch: Throwable -> L73
        r102.L$2 = r111;     // Catch: Throwable -> L73
        r113 = r151;
        r102.L$3 = r113;     // Catch: Throwable -> L73
        r114 = null;
        r102.L$4 = null;     // Catch: Throwable -> L71
        r102.L$5 = null;     // Catch: Throwable -> L71
        r102.L$6 = null;     // Catch: Throwable -> L71
        r102.L$7 = null;     // Catch: Throwable -> L71
        r102.L$8 = null;     // Catch: Throwable -> L71
        r102.L$9 = null;     // Catch: Throwable -> L71
        r102.L$10 = null;     // Catch: Throwable -> L71
        r102.L$11 = null;     // Catch: Throwable -> L71
        r102.label = 3;     // Catch: Throwable -> L71
        r109 = this;
        if (r109.c(r113, r153, r102) != r145) goto L65;
        return r145;
    L65:
        r108 = r152;
        r112 = r112;
    L71:
        th = th;
    L73:
        th = th;
    L75:
        r114 = null;
    L76:
        th = th;
    L46:
        th = th;
    L47:
        kotlinx.coroutines.sync.a r154 = r216;
    L54:
        r114 = null;
        r117 = r154;
    L48:
        th = th;
        r137 = this;
    L50:
        th = th;
        r137 = this;
        r216 = r130;
    L21:
        th = th;
        r114 = null;
        ?? r155 = r121;
    L82:
        r117 = r155;
        goto L83
    L23:
        kotlinx.coroutines.sync.a r156 = (kotlinx.coroutines.sync.a) r102.L$8;
        Map<String, Object> r157 = (Map) r102.L$7;
        SessionType r158 = (SessionType) r102.L$6;
        r124 = (String) r102.L$5;
        String r159 = (String) r102.L$4;
        String r160 = (String) r102.L$3;
        String r161 = (String) r102.L$2;
        r135 = (Context) r102.L$1;
        r132 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);
        String r162 = r161;
        Map<String, Object> r163 = r157;
        r139 = r160;
        r143 = r158;
        r144 = r159;
        kotlinx.coroutines.sync.a r164 = r156;
    L28:
        r111 = new Ref.ObjectRef();     // Catch: Throwable -> L80
        r136 = r110;
        CompletableDeferred<AppletRuntime> r165 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L78
        r134 = this.f36161d.putIfAbsent(r132, r165);     // Catch: Throwable -> L80
        if (r134 != null) goto L85;
        r137 = this;
        r112 = r164;
        r138 = r163;
        r141 = r132;
        r142 = r162;
        r140 = r165;
        goto L92
    L85:
        g.f37637a.i("WorkerRuntimeManager", "await runApplet " + r132 + ", another thread is loading");     // Catch: Throwable -> L52
        WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1 r166 = new WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1(r134, null);     // Catch: Throwable -> L52
        r102.L$0 = r132;     // Catch: Throwable -> L52
        r102.L$1 = r135;     // Catch: Throwable -> L52
        r102.L$2 = r162;     // Catch: Throwable -> L52
        r102.L$3 = r139;     // Catch: Throwable -> L52
        r102.L$4 = r144;     // Catch: Throwable -> L52
        r102.L$5 = r124;     // Catch: Throwable -> L52
        r102.L$6 = r143;     // Catch: Throwable -> L52
        r102.L$7 = r163;     // Catch: Throwable -> L52
        r102.L$8 = r164;     // Catch: Throwable -> L52
        r102.L$9 = r111;     // Catch: Throwable -> L52
        r102.L$10 = r165;     // Catch: Throwable -> L52
        r102.L$11 = r134;     // Catch: Throwable -> L52
        r102.label = 2;     // Catch: Throwable -> L52
        String r167 = r162;
        r103 = TimeoutKt.c(30000, r166, r102);     // Catch: Throwable -> L52
        r133 = r136;
        if (r103 != r133) goto L37;
        return r133;
    L37:
        r130 = r164;
        r119 = r165;
        r131 = r139;
        r122 = r163;
        r127 = r167;
        SessionType r219 = r143;
        r125 = r144;
        r123 = r219;
    L52:
        th = th;
        r137 = this;
        r154 = r164;
    L78:
        th = th;
        r114 = null;
        r117 = r164;
        goto L83
    L24:
        ResultKt.throwOnFailure(r103);
        MutexImpl r168 = this.f36160c;
        r102.L$0 = r210;
        r135 = r211;
        r102.L$1 = r135;
        r102.L$2 = r212;
        r139 = r213;
        r102.L$3 = r139;
        r144 = r214;
        r102.L$4 = r144;
        r124 = r215;
        r102.L$5 = r124;
        r143 = r310;
        r102.L$6 = r143;
        r163 = r311;
        r102.L$7 = r163;
        r102.L$8 = r168;
        r102.label = 1;
        if (r168.a(null, r102) != r110) goto L27;
        return r110;
    L27:
        r164 = r168;
        r162 = r212;
        r132 = r210;
    L80:
        th = th;
        r114 = null;
        r155 = r104;
    L7:
        r100 = new WorkerRuntimeManager$runAppletWorker$1(this, r312);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static final Object a(WorkerRuntimeManager r210, String r211, Context r212, String r213, String r214, String r310, String r311, SessionType r312, Map r313, Continuation r314) {
        String r100 = r211;
        r210.getClass();
        if ((r314 instanceof WorkerRuntimeManager$runAppletWorkerInner$1) == false) goto L7;
        WorkerRuntimeManager$runAppletWorkerInner$1 r101 = (WorkerRuntimeManager$runAppletWorkerInner$1) r314;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        long r106 = r101.J$1;
        long r107 = r101.J$0;
        String r108 = (String) r101.L$10;
        final String r109 = (String) r101.L$9;
        Ref.ObjectRef r110 = (Ref.ObjectRef) r101.L$8;
        Map r111 = (Map) r101.L$7;
        SessionType r112 = (SessionType) r101.L$6;
        String r113 = (String) r101.L$5;
        String r114 = (String) r101.L$4;
        String r115 = (String) r101.L$3;
        String r116 = (String) r101.L$2;
        Context r117 = (Context) r101.L$1;
        String r118 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Context r119 = r117;
        r100 = r118;
        Object r120 = r103;
        String r121 = r108;
        long r122 = r107;
        long r123 = r106;
    L66:
        Applet r124 = (Applet) r120;
        if (r124 != null) goto L75;
        String r125 = "Applet " + r100 + " not found, can't launch main thread";
        g r126 = g.f37637a;
        r126.e("applet_lifecycle", "<parseMessage>< runapplet: " + r125);
        r126.e("WorkerRuntimeManager", "runAppletWorkerInner: loadApplet FAILED, elapsed=" + (System.currentTimeMillis() - r122) + "ms");
        com.bytedance.ai.monitor.b.d("applet_run_applet_result", new d(r100, r114, r113, r125));
        T r127 = r110.element;
        if (((AppletRuntime) r127) == null) goto L71;
        r210.f36159b.put(r100, (AppletRuntime) r127);
        r210.d(r100);
    L71:
        if (r109 == null) goto L74;
        if (r121 == null) goto L74;
        i1 r128 = y0.f512051a;
        y0.b(r109, r125, AppletErrorCode.APPLET_NOT_FOUND.getType(), r121);
    L74:
        Trace.endSection();
    L122:
        return null;
    L75:
        String r129 = r115;
        SessionType r315 = r112;
        g r130 = g.f37637a;
        String r316 = r116;
        Map r131 = r111;
        Context r132 = r119;
        r130.i("WorkerRuntimeManager", "runAppletWorkerInner: loadApplet SUCCESS, loadTime=" + (System.currentTimeMillis() - r123) + "ms, totalElapsed=" + (System.currentTimeMillis() - r122) + "ms, versionCode=" + r124.f36896c);
        if (r109 == null) goto L90;
        if (r121 == null) goto L90;
        String r133 = r124.B;
        if (r133 != null) goto L81;
        r133 = "";
    L81:
        String r134 = r124.f36897d;
        if (r134 != null) goto L84;
        r134 = "";
    L84:
        i1 r135 = y0.f512051a;
        final Map r136 = MapsKt.mapOf(new Pair[]{TuplesKt.to("applet_res_from", r133), TuplesKt.to("scm_version", r134), TuplesKt.to("version_code", Boxing.boxLong(r124.f36896c)), TuplesKt.to("packageId", r124.f36895b)});
        Intrinsics.checkNotNullParameter(r109, "traceId");
        Intrinsics.checkNotNullParameter(r121, "eventType");
        Intrinsics.checkNotNullParameter(r136, "eventInfo");
        final long r137 = System.currentTimeMillis();
        g r138 = r130;
        r138.d("AppletEventMonitorManager", "onLoadAppletEnd: " + r109 + ", " + r121);
        if (Intrinsics.areEqual(r121, "applet_widget_timeline_full") == false) goto L88;
        y0.r(new x(r109, r137, r136));
    L91:
        T r139 = r110.element;
        if (r139 == 0) goto L97;
        long r140 = ((AppletRuntime) r139).f36719h.f36896c;
        Ref.ObjectRef r141 = r110;
        if (r140 != r124.f36896c) goto L98;
        long r142 = System.currentTimeMillis() - r122;
        com.bytedance.ai.monitor.b.d("applet_run_applet_result", new c(r100, r114, r113, r142));
        Trace.endSection();
        r138.i("WorkerRuntimeManager", "runAppletWorkerInner END: reused existing runtime, totalTime=" + r142 + "ms");
        return r141.element;
    L98:
        StringBuilder r143 = new StringBuilder("runAppletWorkerInner: need to create new runtime, reason=");
        if (r141.element != 0) goto L101;
        String r144 = "no existing runtime";
    L102:
        r143.append(r144);
        r143.append(", elapsed=");
        r143.append(System.currentTimeMillis() - r122);
        r143.append("ms");
        r138.i("WorkerRuntimeManager", r143.toString());
        T r145 = r141.element;
        if (((AppletRuntime) r145) == null) goto L106;
        r210.f36159b.put(r100, (AppletRuntime) r145);
        r210.d(r100);
    L106:
        if (e.a(r124.f36901h, EventConstant.Value.AUTH_VERSION_2) < 0) goto L116;
        String r146 = r124.P;
        if (r146 != null) goto L110;
    L113:
        boolean r147 = true;
    L114:
        if (r147 == false) goto L116;
        r138.e("WorkerRuntimeManager", "runtimeEntry is empty");
        boolean r148 = false;
    L117:
        if (r148 == true) goto L124;
        if (r109 == 0) goto L121;
        if (r121 == null) goto L121;
        String r149 = "The runtimeEntry of " + r100 + " not found";
        i1 r150 = y0.f512051a;
        y0.b(r109, r149, AppletErrorCode.RUNTIME_ENTRY_EMPTY.getType(), r121);
    L121:
        Trace.endSection();
        goto L122
    L124:
        if (c3.b.a(r124.C) == false) goto L137;
        r138.i("WorkerRuntimeManager", "runAppletWorkerInner: need to create lynx runtime, appletId=" + r100);
        b3.b r151 = b3.b.f17112a;
        monitor-enter(r151);
        Intrinsics.checkNotNullParameter(r132, "app");     // Catch: Throwable -> L134
        Intrinsics.checkNotNullParameter(r124, "applet");     // Catch: Throwable -> L134
        if (r151.a(r124.o()) != null) goto L133;
        com.bytedance.ai.applet.base.log.b r152 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Throwable -> L134
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "launchApp, appletId:" + r124.o());     // Catch: Throwable -> L134
        b3.a r153 = new b3.a(r132, r124, r131);     // Catch: Throwable -> L134
        b3.b.f17113b.put(r124.o(), r153);     // Catch: Throwable -> L134
        monitor-exit(r151);
        AppletRuntime r154 = r153.f17111d;
    L138:
        AppletRuntime r155 = r154;
        r155.x();
        long r156 = System.currentTimeMillis() - r122;
        r138.i("WorkerRuntimeManager", "runAppletWorkerInner: created new runtime type=" + r155.getClass().getSimpleName() + ", elapsed=" + r156 + "ms");
        r210.f36158a.put(r100, r155);
        AppletRuntimeManager.INSTANCE.getClass();
        r155.f36721j = AppletRuntimeManager.f36750e;
        com.bytedance.ai.monitor.b.d("applet_run_applet_result", new b(r100, r114, r113, r156, r141));
        Trace.endSection();
        if (r316 == null) goto L144;
        if (r315 != null) goto L142;
        SessionType r157 = SessionType.CHATUI;
    L143:
        r155.m(r316, r129, r157);
        goto L144
    L142:
        r157 = r315;
    L144:
        r138.i("WorkerRuntimeManager", "runAppletWorkerInner END: created new runtime, totalTime=" + (System.currentTimeMillis() - r122) + "ms");
        return r155;
    L133:
        throw new IllegalArgumentException("appletId:" + r124.o() + " is already installed");     // Catch: Throwable -> L134
    L134:
        th = move-exception;
        throw th;
    L137:
        r154 = new JSWorkerRuntime(r132, r124, r131);
        goto L138
    L110:
        if (r146.length() == 0) goto L113;
        r147 = false;
    L116:
        r148 = true;
        goto L117
    L101:
        r144 = "version changed (" + ((AppletRuntime) r141.element).f36719h.f36896c + " -> " + r124.f36896c + ')';
        goto L102
    L97:
        r141 = r110;
        goto L98
    L88:
        if (Intrinsics.areEqual(r121, "applet_page_timeline_full") == false) goto L91;
        y0.r(new y(r109, r137, r136));
    L90:
        r138 = r130;
        goto L91
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        long r158 = System.currentTimeMillis();
        g r159 = g.f37637a;
        r159.i("WorkerRuntimeManager", "runAppletWorkerInner START: appletId=" + r100 + ", msgId=" + r310 + ", thread=" + ThreadMethodProxy.currentThread().getName());
        Trace.beginSection("runApplet");
        com.bytedance.ai.monitor.b.d("applet_run_applet", new com.bytedance.ai.core.manager.a(r100, r310, r214, r311));
        Ref.ObjectRef r160 = new Ref.ObjectRef();
        r160.element = r210.f36158a.get(r100);
        StringBuilder r161 = new StringBuilder("runAppletWorkerInner: check existing runtime, found=");
        if (r160.element == 0) goto L17;
        boolean r162 = true;
    L18:
        r161.append(r162);
        r161.append(", terminated=");
        AppletRuntime r163 = (AppletRuntime) r160.element;
        if (r163 == null) goto L21;
        Boolean r164 = Boxing.boxBoolean(r163.H());
    L22:
        r161.append(r164);
        r161.append(", elapsed=");
        r161.append(System.currentTimeMillis() - r158);
        r161.append("ms");
        r159.i("WorkerRuntimeManager", r161.toString());
        AppletRuntime r165 = (AppletRuntime) r160.element;
        if (r165 != null) goto L25;
    L27:
        boolean r166 = false;
    L28:
        if (r166 == false) goto L30;
        r210.d(r211);
        String r167 = null;
        r160.element = null;
    L31:
        if (r313 == null) goto L33;
        Object r168 = r313.get(BindCardPayConfirmConstants.Key.TRACE_ID);
    L35:
        if ((r168 instanceof String) == false) goto L37;
        String r169 = (String) r168;
    L38:
        if (r169 != null) goto L40;
        r169 = r167;
    L40:
        if (r313 == null) goto L42;
        Object r170 = r313.get("eventName");
    L44:
        if ((r170 instanceof String) == false) goto L46;
        String r171 = (String) r170;
    L47:
        if (r171 != null) goto L49;
        r171 = r167;
    L49:
        if (r169 == null) goto L57;
        if (r171 == null) goto L57;
        i1 r172 = y0.f512051a;
        Intrinsics.checkNotNullParameter(r169, "traceId");
        Intrinsics.checkNotNullParameter(r171, "eventType");
        final long r173 = System.currentTimeMillis();
        StringBuilder r174 = new StringBuilder("onLoadAppletStart: ");
        final String r175 = r169;
        r174.append(r175);
        Object r176 = r104;
        r174.append(", ");
        r174.append(r171);
        r159.d("AppletEventMonitorManager", r174.toString());
        if (Intrinsics.areEqual(r171, "applet_widget_timeline_full") == false) goto L55;
        y0.r(new i(r175, r173));
    L58:
        StringBuilder r177 = new StringBuilder("runAppletWorkerInner: start loading applet, elapsed=");
        String r178 = r171;
        r177.append(System.currentTimeMillis() - r158);
        r177.append("ms");
        r159.i("WorkerRuntimeManager", r177.toString());
        long r179 = System.currentTimeMillis();
        AIManager r180 = AIManager.f37211a;
        if (r310 == null) goto L61;
        Map<String, Object> r181 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r310)});
    L62:
        r101.L$0 = r100;
        r101.L$1 = r212;
        r101.L$2 = r213;
        r101.L$3 = r214;
        r101.L$4 = r310;
        r101.L$5 = r311;
        r101.L$6 = r312;
        r101.L$7 = r313;
        r101.L$8 = r160;
        r101.L$9 = r175;
        r101.L$10 = r178;
        r101.J$0 = r158;
        r101.J$1 = r179;
        String r182 = r175;
        r101.label = 1;
        Object r183 = r180.D(r100, r181, r101);
        Object r184 = r176;
        if (r183 == r184) goto L147;
        r119 = r212;
        r120 = r183;
        r121 = r178;
        r109 = r182;
        r113 = r311;
        r115 = r214;
        r110 = r160;
        r114 = r310;
        r112 = r312;
        r123 = r179;
        r116 = r213;
        r111 = r313;
        r122 = r158;
        goto L66
    L147:
        return r184;
    L61:
        r181 = null;
        goto L62
    L55:
        if (Intrinsics.areEqual(r171, "applet_page_timeline_full") == false) goto L58;
        y0.r(new j(r175, r173));
    L57:
        r176 = r104;
        r175 = r169;
        goto L58
    L46:
        r171 = r167;
        goto L47
    L42:
        r170 = r167;
        goto L44
    L37:
        r169 = r167;
        goto L38
    L33:
        r168 = r167;
        goto L35
    L30:
        r167 = null;
        goto L31
    L25:
        if (r165.H() != true) goto L27;
        r166 = true;
        goto L28
    L21:
        r164 = null;
        goto L22
    L17:
        r162 = false;
    L7:
        r101 = new WorkerRuntimeManager$runAppletWorkerInner$1(r210, r314);
        goto L8
    }
}
