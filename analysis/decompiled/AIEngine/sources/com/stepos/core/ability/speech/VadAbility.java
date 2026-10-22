package com.stepos.core.ability.speech;

import android.content.Context;
import android.os.Bundle;
import com.stepos.base.ability.AbilityBase;
import com.stepos.base.model.ModelReleaseReason;
import com.stepos.core.ability.speech.VadRuntimeConfig;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.VadParamKeys;
import com.stepos.core.model.task.AITaskRecord;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.Flow;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadAbility extends AbilityBase<c.a, d.q> {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "VadAbility";

    @Deprecated
    public static final int TARGET_CHANNEL_COUNT = 1;
    private final VadSessionManager sessions;
    private final boolean supportsFeedInput;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VadAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        kotlin.jvm.internal.g.f(abilityConfig, "abilityConfig");
        this.sessions = new VadSessionManager(TAG, null, 2, 0 == true ? 1 : 0);
        this.supportsFeedInput = true;
    }

    private final String callerPkgOf(Object obj) {
        String callerPackage;
        AITaskRecord aITaskRecord = obj instanceof AITaskRecord ? (AITaskRecord) obj : null;
        if (aITaskRecord == null || (callerPackage = aITaskRecord.getCallerPackage()) == null || gc.q.t0(callerPackage)) {
            return null;
        }
        return callerPackage;
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public Object acquire(qb.b<? super Boolean> bVar) {
        return Boolean.TRUE;
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public boolean cancel() {
        this.sessions.cancelAll();
        return super.cancel();
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public void completeInput(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.sessions.completeInput(inferId);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.a) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m62doInfergIAlus((c.a) cVar, (qb.b<? super Result<d.q>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public boolean getSupportsFeedInput() {
        return this.supportsFeedInput;
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public void onFeedInput(String inferId, Object input) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        this.sessions.onFeedInput(inferId, input);
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public Object release(ModelReleaseReason modelReleaseReason, qb.b<? super lb.n> bVar) {
        AIEngineLogger.i(LogModule.ABILITY, TAG, "release: reason=" + modelReleaseReason + ", cancelling all VAD sessions");
        this.sessions.cancelAll();
        Object objRelease = super.release(modelReleaseReason, bVar);
        return objRelease == CoroutineSingletons.f10059a ? objRelease : lb.n.f10413a;
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("", null, null, 6);
    }

    public Object doFlowInfer(c.a aVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        String str = aVar.f13393j;
        Bundle bundle = aVar.f13392i;
        if (str.length() == 0) {
            str = "?";
        }
        String str2 = str;
        VadRuntimeConfig.Companion companion = VadRuntimeConfig.Companion;
        p6.j jVar = getAbilityConfig().f11431q;
        VadRuntimeConfig vadRuntimeConfigResolve = companion.resolve(jVar != null ? jVar.a(callerPkgOf(obj)) : null, bundle);
        boolean z = bundle != null ? bundle.getBoolean(VadParamKeys.FEED_ORDERED, false) : false;
        VadSessionManager vadSessionManager = this.sessions;
        Context context = l7.a.f10344a;
        if (context != null) {
            return vadSessionManager.openSession(context, str2, vadRuntimeConfigResolve, aVar.f13387c, 1, z);
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
    }

    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    public Object m62doInfergIAlus(c.a aVar, qb.b<? super Result<d.q>> bVar) {
        return a0.a.r("stepos-vad is streaming-only; use open/write/close, not infer()");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public long localExecutionTimeoutMs(c.a input, long j10) {
        kotlin.jvm.internal.g.f(input, "input");
        return VadRuntimeConfig.Companion.executionBudgetMs(getAbilityConfig().f11431q, input.f13392i, j10);
    }
}
