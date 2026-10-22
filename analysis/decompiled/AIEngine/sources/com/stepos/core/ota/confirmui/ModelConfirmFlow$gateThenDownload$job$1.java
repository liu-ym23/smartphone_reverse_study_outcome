package com.stepos.core.ota.confirmui;

import android.os.Bundle;
import android.util.Log;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.download.ModelFlowMeta;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ota.confirmui.ModelConfirmFlow$gateThenDownload$job$1", f = "ModelConfirmFlow.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelConfirmFlow$gateThenDownload$job$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ boolean $cellularAllowed;
    final /* synthetic */ boolean $enableWifiAuto;
    final /* synthetic */ long $requiredBytes;
    final /* synthetic */ IOtaDeepBinderService $service;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModelConfirmFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow$gateThenDownload$job$1(ModelConfirmFlow modelConfirmFlow, long j10, IOtaDeepBinderService iOtaDeepBinderService, boolean z, boolean z3, qb.b<? super ModelConfirmFlow$gateThenDownload$job$1> bVar) {
        super(2, bVar);
        this.this$0 = modelConfirmFlow;
        this.$requiredBytes = j10;
        this.$service = iOtaDeepBinderService;
        this.$cellularAllowed = z;
        this.$enableWifiAuto = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        ModelConfirmFlow$gateThenDownload$job$1 modelConfirmFlow$gateThenDownload$job$1 = new ModelConfirmFlow$gateThenDownload$job$1(this.this$0, this.$requiredBytes, this.$service, this.$cellularAllowed, this.$enableWifiAuto, bVar);
        modelConfirmFlow$gateThenDownload$job$1.L$0 = obj;
        return modelConfirmFlow$gateThenDownload$job$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        Object objA2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        try {
            objA = this.$service.queryDownloadResourceGate(this.$requiredBytes);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Bundle bundle = (Bundle) objA;
        if (bundle == null) {
            try {
                objA2 = this.$service.queryDownloadResourceGate(this.$requiredBytes);
            } catch (Throwable th2) {
                objA2 = kotlin.c.a(th2);
            }
            bundle = (Bundle) (objA2 instanceof Result.Failure ? null : objA2);
        }
        if (bundle == null) {
            Log.w("ModelConfirmFlow", "[DIAG] resourceGate query FAILED (fail-closed, block) " + this.this$0.algorithmId + " size=" + this.$requiredBytes);
            this.this$0.fail(5901, "resource gate query failed");
            return lb.n.f10413a;
        }
        boolean z = bundle.getBoolean(ModelFlowMeta.KEY_GATE_OK, false);
        int i10 = bundle.getInt(ModelFlowMeta.KEY_GATE_ERROR, 0);
        String str = this.this$0.algorithmId;
        long j10 = this.$requiredBytes;
        StringBuilder sbM = com.stepos.core.ota.d.m("[DIAG] resourceGate result ", str, " ok=", " code=", z);
        sbM.append(i10);
        sbM.append(" size=");
        sbM.append(j10);
        Log.i("ModelConfirmFlow", sbM.toString());
        if (z) {
            this.this$0.proceedWithNetworkCheck(this.$service, this.$cellularAllowed, this.$enableWifiAuto);
            return lb.n.f10413a;
        }
        this.this$0.showResourceGateBlocked(i10);
        return lb.n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((ModelConfirmFlow$gateThenDownload$job$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
