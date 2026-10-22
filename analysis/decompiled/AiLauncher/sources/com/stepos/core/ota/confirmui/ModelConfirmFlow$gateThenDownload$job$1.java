package com.stepos.core.ota.confirmui;

import android.os.Bundle;
import android.util.Log;
import com.stepos.aiengine.flow.ModelFlowError;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.download.ModelFlowMeta;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.core.ota.confirmui.ModelConfirmFlow$gateThenDownload$job$1", f = "ModelConfirmFlow.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ModelConfirmFlow$gateThenDownload$job$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $cellularAllowed;
    final /* synthetic */ boolean $enableWifiAuto;
    final /* synthetic */ long $requiredBytes;
    final /* synthetic */ IOtaDeepBinderService $service;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModelConfirmFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow$gateThenDownload$job$1(ModelConfirmFlow modelConfirmFlow, long j10, IOtaDeepBinderService iOtaDeepBinderService, boolean z10, boolean z11, InterfaceC4014c<? super ModelConfirmFlow$gateThenDownload$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = modelConfirmFlow;
        this.$requiredBytes = j10;
        this.$service = iOtaDeepBinderService;
        this.$cellularAllowed = z10;
        this.$enableWifiAuto = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ModelConfirmFlow$gateThenDownload$job$1 modelConfirmFlow$gateThenDownload$job$1 = new ModelConfirmFlow$gateThenDownload$job$1(this.this$0, this.$requiredBytes, this.$service, this.$cellularAllowed, this.$enableWifiAuto, interfaceC4014c);
        modelConfirmFlow$gateThenDownload$job$1.L$0 = obj;
        return modelConfirmFlow$gateThenDownload$job$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ModelConfirmFlow$gateThenDownload$job$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Object objB2;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        IOtaDeepBinderService iOtaDeepBinderService = this.$service;
        long j10 = this.$requiredBytes;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(iOtaDeepBinderService.queryDownloadResourceGate(j10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Bundle bundle = (Bundle) objB;
        if (bundle == null) {
            try {
                objB2 = Result.b(this.$service.queryDownloadResourceGate(this.$requiredBytes));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            bundle = (Bundle) (Result.g(objB2) ? null : objB2);
        }
        if (bundle == null) {
            Log.w("ModelConfirmFlow", "[DIAG] resourceGate query FAILED (fail-closed, block) " + this.this$0.algorithmId + " size=" + this.$requiredBytes);
            this.this$0.fail(ModelFlowError.SERVICE_UNAVAILABLE, "resource gate query failed");
            return Y8.t.f7040a;
        }
        boolean z10 = bundle.getBoolean(ModelFlowMeta.KEY_GATE_OK, false);
        int i10 = bundle.getInt(ModelFlowMeta.KEY_GATE_ERROR, 0);
        Log.i("ModelConfirmFlow", "[DIAG] resourceGate result " + this.this$0.algorithmId + " ok=" + z10 + " code=" + i10 + " size=" + this.$requiredBytes);
        if (z10) {
            this.this$0.proceedWithNetworkCheck(this.$service, this.$cellularAllowed, this.$enableWifiAuto);
            return Y8.t.f7040a;
        }
        this.this$0.showResourceGateBlocked(i10);
        return Y8.t.f7040a;
    }
}
