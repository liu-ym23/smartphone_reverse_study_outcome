package com.stepos.ailauncher.chat.view;

import com.stepos.ailauncher.chat.view.ListenRewakePolicy;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import com.stepos.ailauncher.speech.view.DotWaveVoiceView;
import h8.C4148a;
import java.util.Set;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;
import x5.C5851b;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0017\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/stepos/ailauncher/chat/view/BaseInputView$createSpeechAsrCallback$1", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "", "text", "LY8/t;", "onPartialResult", "(Ljava/lang/String;)V", "onFinalResult", "", "code", "message", "onError", "(ILjava/lang/String;)V", "onRecordingStarted", "()V", "onRecordingStopped", "", "data", "onAudioFrame", "([S)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseInputView$createSpeechAsrCallback$1 implements AsrCallback {
    final /* synthetic */ int $sessionId;
    final /* synthetic */ BaseInputView this$0;

    public BaseInputView$createSpeechAsrCallback$1(BaseInputView baseInputView, int i10) {
        this.this$0 = baseInputView;
        this.$sessionId = i10;
    }

    public static final void b(BaseInputView baseInputView) {
        if (!baseInputView.getManualPressActive() || baseInputView.isDialogCancel) {
            C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "auto restart skipped: press already ended", false, 4, null);
            return;
        }
        ISpeechService speechService = baseInputView.getSpeechService();
        if (speechService != null) {
            speechService.startManualRecording(baseInputView.T5(baseInputView.fc()));
            return;
        }
        C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "auto restart skipped: speechService unavailable", false, 4, null);
        baseInputView.y4();
        baseInputView.G6();
        baseInputView.isManualAsrMode = false;
    }

    @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
    public void onAudioFrame(short[] data) {
        kotlin.jvm.internal.p.i(data, "data");
        if (this.this$0.c8(this.$sessionId) || this.this$0.getRecordingPresentationController().n(data)) {
            return;
        }
        com.stepos.ailauncher.speech.dialog.c cVar = this.this$0.aiEngineManualPopup;
        if (cVar == null || !cVar.i()) {
            DotWaveVoiceView dotWaveVoiceView = this.this$0.voiceRecordingView;
            if (dotWaveVoiceView != null) {
                dotWaveVoiceView.j(data);
                return;
            }
            return;
        }
        com.stepos.ailauncher.speech.dialog.c cVar2 = this.this$0.aiEngineManualPopup;
        if (cVar2 != null) {
            cVar2.o(data);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
    public void onError(int code, String message) {
        kotlin.jvm.internal.p.i(message, "message");
        if (this.this$0.c8(this.$sessionId)) {
            C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "onError stale: session=" + this.$sessionId + " epoch=" + this.this$0.asrSessionEpoch + " code=" + code, false, 4, null);
            return;
        }
        if (this.this$0.Wc(code, message)) {
            return;
        }
        if (this.this$0.getManualPressActive()) {
            C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "onError premature while pressing: code=" + code + " msg=" + message + " recordingActive=" + this.this$0.recordingActive, false, 4, null);
        }
        Function2.b(new BaseInputView$createSpeechAsrCallback$1$onError$1(this.this$0, code, message, code == 1003 ? this.this$0.pendingManualFinalText : null, null));
    }

    @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
    public void onFinalResult(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (this.this$0.c8(this.$sessionId)) {
            C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "onFinalResult stale: session=" + this.$sessionId + " epoch=" + this.this$0.asrSessionEpoch + " text=\"" + text + "\"", false, 4, null);
            this.this$0.h5(text);
            return;
        }
        String str = this.this$0.pendingManualFinalText;
        if (this.this$0.getManualPressActive() && !this.this$0.isDialogCancel) {
            BaseInputView baseInputView = this.this$0;
            if (str == null) {
                str = "";
            }
            baseInputView.pendingManualFinalText = str + text;
            C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "onFinalResult premature while pressing: stash segment=\"" + text + "\" total=\"" + this.this$0.pendingManualFinalText + "\" recordingActive=" + this.this$0.recordingActive, false, 4, null);
            return;
        }
        this.this$0.pendingManualFinalText = null;
        if (str == null) {
            str = "";
        }
        String command = str + text;
        if (!this.this$0.isDialogCancel && this.this$0.listenModeActive && !this.this$0.isManualAsrMode && !this.this$0.getManualPressActive()) {
            Set<String> setB = C5851b.INSTANCE.b();
            boolean zS = com.stepos.ailauncher.chat.manager.U0.INSTANCE.s();
            ListenRewakePolicy.a aVarA = (this.this$0.Z7() && ListenRewakePolicy.INSTANCE.c(command, setB, zS)) ? ListenRewakePolicy.a.C0297a.INSTANCE : ListenRewakePolicy.INSTANCE.a(command, setB, zS);
            if (kotlin.jvm.internal.p.d(aVarA, ListenRewakePolicy.a.C0297a.INSTANCE)) {
                C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "AIOSBUG-15394: wake word while listening, drop and restart", false, 4, null);
                BaseInputView baseInputView2 = this.this$0;
                baseInputView2.pa(baseInputView2.listeningSource);
                return;
            } else if (aVarA instanceof ListenRewakePolicy.a.SendRemainder) {
                C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "AIOSBUG-15394: strip leading wake word, keep command", false, 4, null);
                command = ((ListenRewakePolicy.a.SendRemainder) aVarA).getCommand();
            } else if (!kotlin.jvm.internal.p.d(aVarA, ListenRewakePolicy.a.b.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        this.this$0.t6();
        if (this.this$0.aiKeyShortPressAwaitingVadStop && !this.this$0.isDialogCancel && command.length() > 0) {
            this.this$0.fd();
        }
        this.this$0.K5();
        this.this$0.asrCallback.e(command);
    }

    @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
    public void onPartialResult(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (!this.this$0.c8(this.$sessionId)) {
            this.this$0.asrCallback.d(text);
            return;
        }
        C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "onPartialResult stale: session=" + this.$sessionId + " epoch=" + this.this$0.asrSessionEpoch, false, 4, null);
    }

    @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
    public void onRecordingStarted() {
        if (this.this$0.c8(this.$sessionId)) {
            C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "onRecordingStarted stale: session=" + this.$sessionId + " epoch=" + this.this$0.asrSessionEpoch, false, 4, null);
            return;
        }
        if (this.this$0.isManualAsrMode) {
            if (!this.this$0.getManualPressActive() || this.this$0.T7()) {
                return;
            }
            this.this$0.x4();
            return;
        }
        if (this.this$0.recordingActive && this.this$0.listenModeActive) {
            BaseInputView.D4(this.this$0, null, 1, null);
            this.this$0.setRecordingActive(true);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
    public void onRecordingStopped() {
        InterfaceC5074l<Boolean, Y8.t> onRecordingStateChanged;
        if (this.this$0.c8(this.$sessionId)) {
            C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "onRecordingStopped stale: session=" + this.$sessionId + " epoch=" + this.this$0.asrSessionEpoch, false, 4, null);
            return;
        }
        if (this.this$0.isManualAsrMode || this.this$0.aiKeyLongPressPhase || !this.this$0.E5()) {
            this.this$0.t8();
            if (this.this$0.isManualAsrMode) {
                if (this.this$0.wb()) {
                    this.this$0.asrAutoRestartCount++;
                    C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "onRecordingStopped: cloud session ended while pressing — auto restart (count=" + this.this$0.asrAutoRestartCount + ", pendingText=" + (this.this$0.pendingManualFinalText != null) + ")", false, 4, null);
                    final BaseInputView baseInputView = this.this$0;
                    baseInputView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.view.R2
                        @Override // java.lang.Runnable
                        public final void run() {
                            BaseInputView$createSpeechAsrCallback$1.b(baseInputView);
                        }
                    }, 150L);
                    return;
                }
                if (this.this$0.getManualPressActive()) {
                    boolean z10 = this.this$0.pendingManualFinalText != null;
                    C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "onRecordingStopped premature while pressing: pendingText=" + z10 + " restartCount=" + this.this$0.asrAutoRestartCount + " cancel=" + this.this$0.isDialogCancel, false, 4, null);
                }
                this.this$0.y4();
                this.this$0.G6();
                this.this$0.isManualAsrMode = false;
                return;
            }
            this.this$0.setRecordingActive(false);
            if (!this.this$0.slaOnlyVoiceActive && (onRecordingStateChanged = this.this$0.getOnRecordingStateChanged()) != null) {
                onRecordingStateChanged.invoke(Boolean.FALSE);
            }
            if (this.this$0.aiKeyShortPressAwaitingVadStop && !this.this$0.isDialogCancel) {
                this.this$0.fd();
            }
            if (!this.this$0.isDialogCancel && !this.this$0.slaOnlyVoiceActive && this.this$0.getRecordingPresentationController().k()) {
                BaseInputView.Z4(this.this$0, false, false, 3, null);
            }
            this.this$0.f6();
            this.this$0.ha();
            this.this$0.D8();
            if (!this.this$0.listenModeActive || this.this$0.isDialogCancel || this.this$0.slaOnlyVoiceActive) {
                if (this.this$0.slaOnlyVoiceActive) {
                    this.this$0.Oc(!r9.isDialogCancel);
                    return;
                }
                return;
            }
            DotWaveVoiceView dotWaveVoiceView = this.this$0.voiceRecordingView;
            if (dotWaveVoiceView != null) {
                dotWaveVoiceView.setVisibility(4);
            }
            DotWaveVoiceView dotWaveVoiceView2 = this.this$0.voiceRecordingView;
            if (dotWaveVoiceView2 != null) {
                dotWaveVoiceView2.y();
            }
            this.this$0.Lc();
            if (this.this$0.asrFinalizingAfterRelease) {
                return;
            }
            this.this$0.ac();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
    public /* bridge */ void onSpeechDetected() {
        super.onSpeechDetected();
    }
}
