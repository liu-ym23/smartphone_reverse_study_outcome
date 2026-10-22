package com.stepos.core.ota.confirmui;

import com.stepos.aiengine.flow.ModelFlowStage;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelConfirmFlow$internalCb$1 implements IDownloadCallback {
    final /* synthetic */ ModelConfirmFlow this$0;

    public ModelConfirmFlow$internalCb$1(ModelConfirmFlow modelConfirmFlow) {
        this.this$0 = modelConfirmFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n onComplete$lambda$2(String str, IDownloadCallback it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onComplete(str);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n onError$lambda$3(int i10, String str, IDownloadCallback it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onError(i10, str);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n onProgress$lambda$1(int i10, long j10, long j11, IDownloadCallback it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onProgress(i10, j10, j11);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n onUpdate$lambda$0(int i10, int i11, IDownloadCallback it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onUpdate(i10, i11);
        return lb.n.f10413a;
    }

    @Override // com.stepos.core.download.IDownloadCallback
    public void onComplete(String localFilePath) {
        kotlin.jvm.internal.g.f(localFilePath, "localFilePath");
        this.this$0.forEachProgress(new l(localFilePath, 2));
        this.this$0.ready(false);
    }

    @Override // com.stepos.core.download.IDownloadCallback
    public void onError(int i10, String message) {
        kotlin.jvm.internal.g.f(message, "message");
        this.this$0.forEachProgress(new n(i10, 0, message));
        this.this$0.fail(5102, message);
    }

    @Override // com.stepos.core.download.IDownloadCallback
    public void onProgress(final int i10, final long j10, final long j11) {
        this.this$0.forEachProgress(new zb.l() { // from class: com.stepos.core.ota.confirmui.m
            @Override // zb.l
            public final Object invoke(Object obj) {
                return ModelConfirmFlow$internalCb$1.onProgress$lambda$1(i10, j10, j11, (IDownloadCallback) obj);
            }
        });
    }

    @Override // com.stepos.core.download.IDownloadCallback
    public void onUpdate(final int i10, final int i11) {
        this.this$0.forEachProgress(new zb.l() { // from class: com.stepos.core.ota.confirmui.o
            @Override // zb.l
            public final Object invoke(Object obj) {
                return ModelConfirmFlow$internalCb$1.onUpdate$lambda$0(i10, i11, (IDownloadCallback) obj);
            }
        });
        switch (i10) {
            case 0:
                this.this$0.downloadingPosted.set(false);
                this.this$0.phase = ModelConfirmFlow.Phase.DETACHED;
                break;
            case 1:
            case 2:
            case 5:
                this.this$0.postDownloadingOnce();
                break;
            case 3:
                this.this$0.fail(5102, "download error");
                break;
            case 4:
                this.this$0.downloadingPosted.set(false);
                this.this$0.phase = ModelConfirmFlow.Phase.DETACHED;
                this.this$0.postStage(ModelFlowStage.f5778d);
                break;
            case 6:
                this.this$0.ready(false);
                break;
            case 7:
                ModelConfirmFlow modelConfirmFlow = this.this$0;
                modelConfirmFlow.fail(modelConfirmFlow.userCanceledCode(), "task removed");
                break;
            default:
                switch (i10) {
                    case 14:
                        this.this$0.fail(4001, "CTA denied");
                        break;
                    case 15:
                        ModelConfirmFlow modelConfirmFlow2 = this.this$0;
                        modelConfirmFlow2.fail(modelConfirmFlow2.canceledCodeForCurrentStep(), "user canceled");
                        break;
                    case 16:
                        this.this$0.fail(ModelFlowMeta.GATE_ERROR_SERVICE_DISABLED, "model service disabled");
                        break;
                    case 17:
                        this.this$0.fail(ModelFlowMeta.ENV_ERROR_NO_NETWORK, "no network");
                        break;
                    case 18:
                        this.this$0.fail(ModelFlowMeta.GATE_ERROR_INSUFFICIENT_SPACE, "insufficient space");
                        break;
                    case 19:
                        this.this$0.fail(ModelFlowMeta.GATE_ERROR_LOW_BATTERY, "low battery");
                        break;
                }
        }
    }
}
