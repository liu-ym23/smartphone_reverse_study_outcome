package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.sla.SlaVoiceBridge;
import com.stepos.ailauncher.speech.model.ErrorModel;
import h8.C4148a;
import kotlin.Function2;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;
import w5.C5736a;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J!\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/view/BaseInputView$asrCallback$1", "", "", "finalAsr", "LY8/t;", "e", "(Ljava/lang/String;)V", "currentAsr", Const.INTENT_KEY_UMID, "", "errCode", "errMsg", "c", "(ILjava/lang/String;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseInputView$asrCallback$1 {
    final /* synthetic */ Context $context;
    final /* synthetic */ BaseInputView this$0;

    public BaseInputView$asrCallback$1(BaseInputView baseInputView, Context context) {
        this.this$0 = baseInputView;
        this.$context = context;
    }

    public static final void f(final BaseInputView baseInputView, final String str) {
        if (baseInputView.E5()) {
            return;
        }
        baseInputView.ka(true);
        baseInputView.t8();
        if (baseInputView.isDialogCancel) {
            baseInputView.Z6();
            BaseInputView.D6(baseInputView, null, 1, null);
            return;
        }
        if (str == null || str.length() == 0) {
            baseInputView.Z6();
            baseInputView.Xa();
            BaseInputView.A8(baseInputView, 0, 1, null);
        } else {
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.P2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return BaseInputView$asrCallback$1.g(baseInputView, str);
                }
            };
            if (baseInputView.circleSelectGestureAwaitingAttachment) {
                C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "onSuc: defer ASR until circle selection attachment is queued", false, 4, null);
                baseInputView.deferredCircleSelectAsrSend = interfaceC5063a;
            } else {
                interfaceC5063a.invoke();
            }
        }
        C4148a.d("InputView", "finalAsr: " + str, false, 4, null);
    }

    public static final Y8.t g(BaseInputView baseInputView, String str) {
        if (baseInputView.picAndFileReadyStatus == -1 && !baseInputView.circleSelectAttachmentQueuedForVoice) {
            SlaVoiceBridge slaVoiceBridge = SlaVoiceBridge.INSTANCE;
            String strQ = slaVoiceBridge.q();
            if (strQ.length() <= 0) {
                strQ = null;
            }
            if (strQ != null) {
                slaVoiceBridge.o(strQ);
            }
            baseInputView.traceChannel = "text";
            baseInputView.pendingVoiceDurationMs = null;
            baseInputView.t6();
            baseInputView.Z6();
            BaseInputView.h6(baseInputView, false, 1, null);
            baseInputView.C6(com.stepos.ailauncher.chat.trace.g.STOP_SWITCH_KEYBOARD);
            baseInputView.qa(str);
            baseInputView.Xa();
            return Y8.t.f7040a;
        }
        baseInputView.circleSelectAttachmentQueuedForVoice = false;
        C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "onSuc: send finalAsr=" + str, false, 4, null);
        baseInputView.traceChannel = "voice";
        Long lValueOf = Long.valueOf(baseInputView.voicePressStartTime);
        if (!(lValueOf.longValue() > 0)) {
            lValueOf = null;
        }
        baseInputView.pendingVoiceDurationMs = lValueOf != null ? Long.valueOf(SystemClock.elapsedRealtime() - lValueOf.longValue()) : null;
        baseInputView.o4(str);
        baseInputView.Z6();
        BaseInputView.h6(baseInputView, false, 1, null);
        baseInputView.Xa();
        baseInputView.C6(com.stepos.ailauncher.chat.trace.g.STOP_SEND_MESSAGE);
        return Y8.t.f7040a;
    }

    public void c(int errCode, String errMsg) {
        C4148a.h("InputView", "errMsg: " + errMsg + ", code: " + errCode, false, 4, null);
        if (this.this$0.pressToTalkAsrPending) {
            if (errCode != 1002 && errCode != 1003) {
                if (errCode != 50001) {
                    switch (errCode) {
                        case ErrorModel.Err_ASR_EMPTY /* 20002 */:
                        case ErrorModel.Err_ASR_COMMIT_FAIL /* 20003 */:
                        case ErrorModel.Err_ASR_NO_SPEECH /* 20004 */:
                            com.stepos.ailauncher.chat.trace.g.e(com.stepos.ailauncher.chat.trace.g.INSTANCE, "no_result", null, errCode == 20004 ? "no_speech" : com.stepos.ailauncher.chat.trace.g.NO_RESULT_ASR_ERROR, this.this$0.pressToTalkAsrTraceId, 2, null);
                            break;
                        default:
                            com.stepos.ailauncher.chat.trace.g.e(com.stepos.ailauncher.chat.trace.g.INSTANCE, "fail", null, null, this.this$0.pressToTalkAsrTraceId, 6, null);
                            break;
                    }
                }
            } else {
                com.stepos.ailauncher.chat.trace.g.e(com.stepos.ailauncher.chat.trace.g.INSTANCE, "timeout", null, "timeout", this.this$0.pressToTalkAsrTraceId, 2, null);
            }
            this.this$0.N5();
        }
        Function2.b(new BaseInputView$asrCallback$1$onFail$1(this.this$0, null));
        if (errCode == 1003) {
            this.this$0.fd();
            this.this$0.Qc(this.$context.getString(R$string.long_press_recording_timeout, Long.valueOf(C5685n.g(this.this$0.na() / 1000, 1L))));
        }
        if (errCode == 1002) {
            this.this$0.fd();
            this.this$0.Qc(this.$context.getString(R$string.listen_timeout_too_long));
            return;
        }
        this.this$0.currentBtnState = 0;
        if (errCode == 50001) {
            this.this$0.fd();
            this.this$0.isDialogCancel = true;
            return;
        }
        switch (errCode) {
            case ErrorModel.Err_ASR_EMPTY /* 20002 */:
            case ErrorModel.Err_ASR_COMMIT_FAIL /* 20003 */:
            case ErrorModel.Err_ASR_NO_SPEECH /* 20004 */:
                Function2.b(new BaseInputView$asrCallback$1$onFail$2(this.this$0, errCode, null));
                this.this$0.currentVoiceStr = null;
                break;
            default:
                boolean zA = C5736a.INSTANCE.a(errCode, errMsg);
                if (errCode != 100005 && ((errMsg == null || !La.D.X(errMsg, "inferSync rejected:", false, 2, null)) && !zA)) {
                    Function2.b(new BaseInputView$asrCallback$1$onFail$4(this.this$0, errMsg, this.$context, null));
                    break;
                } else {
                    Function2.b(new BaseInputView$asrCallback$1$onFail$3(this.this$0, this.$context, errMsg, null));
                    break;
                }
        }
    }

    public void d(String currentAsr) {
        C4148a.d("InputView", "onProgress: " + currentAsr, false, 4, null);
        if (this.this$0.isManualAsrMode) {
            this.this$0.currentVoiceStr = currentAsr;
        }
    }

    public void e(final String finalAsr) {
        if (this.this$0.pressToTalkAsrPending) {
            boolean z10 = finalAsr == null || finalAsr.length() == 0;
            com.stepos.ailauncher.chat.trace.g.INSTANCE.d(!z10 ? com.stepos.ailauncher.chat.trace.g.ASR_FINAL_RESULT : "no_result", finalAsr != null ? Integer.valueOf(finalAsr.length()) : null, !z10 ? null : "no_speech", this.this$0.pressToTalkAsrTraceId);
            this.this$0.N5();
        }
        final BaseInputView baseInputView = this.this$0;
        baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.O2
            @Override // java.lang.Runnable
            public final void run() {
                BaseInputView$asrCallback$1.f(baseInputView, finalAsr);
            }
        });
        this.this$0.currentVoiceStr = null;
    }
}
