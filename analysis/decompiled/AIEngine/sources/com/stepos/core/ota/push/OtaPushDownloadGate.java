package com.stepos.core.ota.push;

import android.content.Context;
import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.d;
import com.stepos.core.ota.process.OtaProcess;
import com.stepos.core.ota.push.PendingAutoUpdateStore;
import com.stepos.core.ota.storage.ModelsVersionStore;
import h0.e;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaPushDownloadGate {
    private static final long DEDUP_TTL_MS = 30000;
    private static final String TAG = "OtaPushDownloadGate";
    public static final OtaPushDownloadGate INSTANCE = new OtaPushDownloadGate();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    private static final ConcurrentHashMap<String, Long> inFlight = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.push.OtaPushDownloadGate$schedule$1", f = "OtaPushDownloadGate.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.push.OtaPushDownloadGate$schedule$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ OtaPushModelUpdate $model;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, OtaPushModelUpdate otaPushModelUpdate, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$appContext = context;
            this.$model = otaPushModelUpdate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$appContext, this.$model, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Context context = this.$appContext;
            OtaPushModelUpdate otaPushModelUpdate = this.$model;
            try {
                OtaPushDownloadGate otaPushDownloadGate = OtaPushDownloadGate.INSTANCE;
                g.c(context);
                otaPushDownloadGate.recordPending(context, otaPushModelUpdate);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            OtaPushModelUpdate otaPushModelUpdate2 = this.$model;
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.OTA, OtaPushDownloadGate.TAG, "recordPending failed modelId=" + otaPushModelUpdate2.getModelId(), thB);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private OtaPushDownloadGate() {
    }

    private final void diag(String str) {
        e.k("[DIAG] ", str, LogModule.OTA, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordPending(Context context, OtaPushModelUpdate otaPushModelUpdate) {
        String taskId = otaPushModelUpdate.getTaskId();
        if (taskId == null) {
            taskId = otaPushModelUpdate.getModelId();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long lPut = inFlight.put(taskId, Long.valueOf(jElapsedRealtime));
        if (lPut != null && jElapsedRealtime - lPut.longValue() < 30000) {
            AIEngineLogger.i(LogModule.OTA, TAG, "duplicate push within TTL, skip: key=" + taskId);
            diag(ai.onnxruntime.a.l("drop duplicate push key=", taskId, " ", otaPushModelUpdate.summary()));
            return;
        }
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(otaPushModelUpdate.getModelId());
        String versionCode = otaPushModelUpdate.getVersionCode();
        Integer numC0 = versionCode != null ? gc.n.c0(versionCode) : null;
        int versionCode2 = ModelsVersionStore.INSTANCE.getVersionCode(strResolveAnyToOta);
        StringBuilder sbS = ai.onnxruntime.a.s("resolved push modelId=", otaPushModelUpdate.getModelId(), " otaId=", strResolveAnyToOta, " localVer=");
        sbS.append(versionCode2);
        sbS.append(" pushVer=");
        sbS.append(numC0);
        diag(sbS.toString());
        if (versionCode2 <= 0) {
            AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.l("skip: model not installed, push serves update-only otaId=", strResolveAnyToOta, " modelId=", otaPushModelUpdate.getModelId()));
            diag("drop push: local model not installed otaId=" + strResolveAnyToOta + " localVer=" + versionCode2);
            return;
        }
        if (numC0 != null && numC0.intValue() <= versionCode2) {
            AIEngineLogger.i(LogModule.OTA, TAG, "skip: push not newer otaId=" + strResolveAnyToOta + " pushVer=" + numC0 + " local=v" + versionCode2);
            StringBuilder sb2 = new StringBuilder("drop push: not newer otaId=");
            d.o(versionCode2, strResolveAnyToOta, " localVer=", " pushVer=", sb2);
            sb2.append(numC0);
            diag(sb2.toString());
            return;
        }
        PendingAutoUpdateStore pendingAutoUpdateStore = PendingAutoUpdateStore.INSTANCE;
        int iIntValue = numC0 != null ? numC0.intValue() : 0;
        boolean forceUpdate = otaPushModelUpdate.getForceUpdate();
        Long size = otaPushModelUpdate.getSize();
        pendingAutoUpdateStore.put(new PendingAutoUpdateStore.Record(strResolveAnyToOta, iIntValue, forceUpdate, size != null ? size.longValue() : 0L, otaPushModelUpdate.getTaskId(), System.currentTimeMillis(), false, 64, null));
        AIEngineLogger.i(LogModule.OTA, TAG, "recorded pending (record-only): otaId=" + strResolveAnyToOta + " pushVer=" + numC0 + " force=" + otaPushModelUpdate.getForceUpdate() + " (await device conditions → fetch & silent update)");
        boolean forceUpdate2 = otaPushModelUpdate.getForceUpdate();
        Long size2 = otaPushModelUpdate.getSize();
        String taskId2 = otaPushModelUpdate.getTaskId();
        StringBuilder sbF = e.f("pending recorded otaId=", strResolveAnyToOta, " localVer=", versionCode2, " pushVer=");
        sbF.append(numC0);
        sbF.append(" force=");
        sbF.append(forceUpdate2);
        sbF.append(" size=");
        sbF.append(size2);
        sbF.append(" taskId=");
        sbF.append(taskId2);
        diag(sbF.toString());
        diag(ai.onnxruntime.a.k("trigger auto-update evaluation reason=", otaPushModelUpdate.getForceUpdate() ? ai.onnxruntime.a.k("push_force:", strResolveAnyToOta) : ai.onnxruntime.a.k("push_silent:", strResolveAnyToOta)));
        ModelAutoUpdateManager.tryRun$default(ModelAutoUpdateManager.INSTANCE, otaPushModelUpdate.getForceUpdate() ? ai.onnxruntime.a.k("push_force:", strResolveAnyToOta) : ai.onnxruntime.a.k("push_silent:", strResolveAnyToOta), false, 2, null);
    }

    public final void schedule(Context context, OtaPushModelUpdate model) {
        g.f(context, "context");
        g.f(model, "model");
        if (OtaProcess.INSTANCE.isOtaProcess(context)) {
            AIEngineLogger.w(LogModule.OTA, TAG, "schedule ignored: :ota process");
            diag(ai.onnxruntime.a.k("schedule ignored in :ota ", model.summary()));
            return;
        }
        if (!CTAPermissionManager.INSTANCE.isModelOtaAllowed()) {
            AIEngineLogger.w(LogModule.OTA, TAG, "schedule ignored: CTA not granted modelId=" + model.getModelId());
            diag(ai.onnxruntime.a.k("schedule ignored: CTA not granted ", model.summary()));
            return;
        }
        LogModule logModule = LogModule.OTA;
        String modelId = model.getModelId();
        String versionCode = model.getVersionCode();
        boolean forceUpdate = model.getForceUpdate();
        String taskId = model.getTaskId();
        StringBuilder sbS = ai.onnxruntime.a.s("push accepted: modelId=", modelId, " pushVer=", versionCode, " force=");
        sbS.append(forceUpdate);
        sbS.append(" taskId=");
        sbS.append(taskId);
        AIEngineLogger.i(logModule, TAG, sbS.toString());
        diag(ai.onnxruntime.a.k("schedule accepted ", model.summary()));
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(context.getApplicationContext(), model, null), 3, null);
    }
}
