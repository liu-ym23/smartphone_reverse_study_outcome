package com.stepos.core.ota.confirmui;

import com.stepos.aiengine.flow.ModelFlowError;
import com.stepos.aiengine.flow.ModelFlowStage;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/stepos/core/ota/confirmui/ModelConfirmFlow$internalCb$1", "Lcom/stepos/core/download/IDownloadCallback;", "", VoiceWakeupReceiver.EXTRA_STATE, "progress", "LY8/t;", "onUpdate", "(II)V", "", "downloaded", "total", "onProgress", "(IJJ)V", "", "localFilePath", "onComplete", "(Ljava/lang/String;)V", "code", "message", "onError", "(ILjava/lang/String;)V", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ModelConfirmFlow$internalCb$1 implements IDownloadCallback {
    final /* synthetic */ ModelConfirmFlow this$0;

    public ModelConfirmFlow$internalCb$1(ModelConfirmFlow modelConfirmFlow) {
        this.this$0 = modelConfirmFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onComplete$lambda$2(String str, IDownloadCallback it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.onComplete(str);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onError$lambda$3(int i10, String str, IDownloadCallback it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.onError(i10, str);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onProgress$lambda$1(int i10, long j10, long j11, IDownloadCallback it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.onProgress(i10, j10, j11);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onUpdate$lambda$0(int i10, int i11, IDownloadCallback it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.onUpdate(i10, i11);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.core.download.IDownloadCallback
    public void onComplete(final String localFilePath) {
        kotlin.jvm.internal.p.i(localFilePath, "localFilePath");
        this.this$0.forEachProgress(new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.P
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ModelConfirmFlow$internalCb$1.onComplete$lambda$2(localFilePath, (IDownloadCallback) obj);
            }
        });
        this.this$0.ready(false);
    }

    @Override // com.stepos.core.download.IDownloadCallback
    public void onError(final int code, final String message) {
        kotlin.jvm.internal.p.i(message, "message");
        this.this$0.forEachProgress(new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.N
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ModelConfirmFlow$internalCb$1.onError$lambda$3(code, message, (IDownloadCallback) obj);
            }
        });
        this.this$0.fail(ModelFlowError.DOWNLOAD_ERROR, message);
    }

    @Override // com.stepos.core.download.IDownloadCallback
    public void onProgress(final int progress, final long downloaded, final long total) {
        this.this$0.forEachProgress(new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.M
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ModelConfirmFlow$internalCb$1.onProgress$lambda$1(progress, downloaded, total, (IDownloadCallback) obj);
            }
        });
    }

    @Override // com.stepos.core.download.IDownloadCallback
    public void onUpdate(final int state, final int progress) {
        this.this$0.forEachProgress(new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.O
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ModelConfirmFlow$internalCb$1.onUpdate$lambda$0(state, progress, (IDownloadCallback) obj);
            }
        });
        switch (state) {
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
                this.this$0.fail(ModelFlowError.DOWNLOAD_ERROR, "download error");
                break;
            case 4:
                this.this$0.downloadingPosted.set(false);
                this.this$0.phase = ModelConfirmFlow.Phase.DETACHED;
                this.this$0.postStage(ModelFlowStage.PAUSED);
                break;
            case 6:
                this.this$0.ready(false);
                break;
            case 7:
                ModelConfirmFlow modelConfirmFlow = this.this$0;
                modelConfirmFlow.fail(modelConfirmFlow.userCanceledCode(), "task removed");
                break;
            default:
                switch (state) {
                    case 14:
                        this.this$0.fail(4001, "CTA denied");
                        break;
                    case 15:
                        ModelConfirmFlow modelConfirmFlow2 = this.this$0;
                        modelConfirmFlow2.fail(modelConfirmFlow2.canceledCodeForCurrentStep(), "user canceled");
                        break;
                    case 16:
                        this.this$0.fail(5022, "model service disabled");
                        break;
                    case 17:
                        this.this$0.fail(5001, "no network");
                        break;
                    case 18:
                        this.this$0.fail(5021, "insufficient space");
                        break;
                    case 19:
                        this.this$0.fail(5020, "low battery");
                        break;
                }
        }
    }
}
