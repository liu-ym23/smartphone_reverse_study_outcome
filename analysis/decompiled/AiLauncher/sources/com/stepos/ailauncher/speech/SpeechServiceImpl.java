package com.stepos.ailauncher.speech;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.h;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.I;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import com.stepos.ailauncher.contract.api.speech.TtsStreamSession;
import com.stepos.ailauncher.sla.SlaRouter;
import com.stepos.ailauncher.speech.asr.AIEngineAsrEngine;
import com.stepos.ailauncher.speech.asr.MicForegroundService;
import com.stepos.ailauncher.speech.asr.c;
import com.stepos.ailauncher.speech.tts.AIEngineTtsEngine;
import com.stepos.ailauncher.speech.tts.i;
import com.stepos.core.error.AIEngineError;
import h9.InterfaceC4149a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import x5.d;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 V2\u00020\u0001:\u0002WXB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\bJ-\u0010\u001e\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001aH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u001aH\u0016¢\u0006\u0004\b&\u0010$J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u000bJ!\u0010/\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b/\u00100J\u001b\u00102\u001a\u0004\u0018\u0001012\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\bJ\u000f\u00105\u001a\u00020\tH\u0016¢\u0006\u0004\b5\u0010\u000bJ\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\bJ\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\bJ\u0017\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010=R\u001d\u0010C\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\"\u0010G\u001a\u0010\u0012\f\u0012\n F*\u0004\u0018\u00010E0E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u001a8\u0002X\u0082D¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001d\u0010U\u001a\u0004\u0018\u00010Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010@\u001a\u0004\bS\u0010T¨\u0006Y"}, d2 = {"Lcom/stepos/ailauncher/speech/SpeechServiceImpl;", "Lcom/stepos/ailauncher/contract/api/speech/ISpeechService;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", "", "e", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "isAsrAvailable", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "callback", "startListening", "(Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;)V", "startManualRecording", "prewarmManualCapture", "cancelCapturePrewarm", "startSlaOnlyRecording", "startSlaOnlyListening", "stopAndFinalize", "armStartHapticPcmSkip", "cancelAsr", "", "silenceTimeoutMs", "listenTimeoutMs", "muteTimeoutMs", "setListeningConfig", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "timeoutMs", "setLongPressTimeoutMs", "(Ljava/lang/Long;)V", "getLongPressTimeoutMs", "()J", "getLongPressRemainingMs", "getRecordingRemainingMs", d.EXTRA_ENABLED, "setVadEnabled", "(Z)V", "isTtsAvailable", "", "text", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "listener", "speak", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/speech/TtsListener;)V", "Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", "startStreamSpeak", "(Lcom/stepos/ailauncher/contract/api/speech/TtsListener;)Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", "stopSpeak", "isSpeaking", "pauseSpeak", "resumeSpeak", "", "gain", "setSpeakDuckGain", "(F)V", "destroy", "Landroid/content/Context;", "Lcom/stepos/ailauncher/speech/asr/c;", "asrEngine$delegate", "LY8/h;", "f", "()Lcom/stepos/ailauncher/speech/asr/c;", "asrEngine", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/stepos/ailauncher/speech/SpeechServiceImpl$AsrCap;", "kotlin.jvm.PlatformType", "asrCap", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicLong;", "asrCapAtMs", "Ljava/util/concurrent/atomic/AtomicLong;", "ASR_CAP_TTL_MS", "J", "LUa/M;", "asrCapScope", "LUa/M;", "Lcom/stepos/ailauncher/speech/tts/i;", "ttsEngine$delegate", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/ailauncher/speech/tts/i;", "ttsEngine", "Companion", Const.INTENT_KEY_APIKEY, "AsrCap", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpeechServiceImpl implements ISpeechService {
    public static final long DEFAULT_LONG_PRESS_TIMEOUT_MS = 180000;
    private static final String TAG = "SpeechService";
    private final long ASR_CAP_TTL_MS;
    private final AtomicReference<AsrCap> asrCap;
    private final AtomicLong asrCapAtMs;
    private final M asrCapScope;

    /* renamed from: asrEngine$delegate, reason: from kotlin metadata */
    private final h asrEngine;
    private final Context context;

    /* renamed from: ttsEngine$delegate, reason: from kotlin metadata */
    private final h ttsEngine;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/speech/SpeechServiceImpl$AsrCap;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "OK", AMapLocationStaticsEntity.FAIL_STATUS, "ONLINE_OK", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AsrCap {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ AsrCap[] $VALUES;
        public static final AsrCap UNKNOWN = new AsrCap("UNKNOWN", 0);
        public static final AsrCap OK = new AsrCap("OK", 1);
        public static final AsrCap FAIL = new AsrCap(AMapLocationStaticsEntity.FAIL_STATUS, 2);
        public static final AsrCap ONLINE_OK = new AsrCap("ONLINE_OK", 3);

        private static final /* synthetic */ AsrCap[] $values() {
            return new AsrCap[]{UNKNOWN, OK, FAIL, ONLINE_OK};
        }

        static {
            AsrCap[] asrCapArr$values = $values();
            $VALUES = asrCapArr$values;
            $ENTRIES = kotlin.enums.a.a(asrCapArr$values);
        }

        private AsrCap(String str, int i10) {
        }

        public static InterfaceC4149a<AsrCap> getEntries() {
            return $ENTRIES;
        }

        public static AsrCap valueOf(String str) {
            return (AsrCap) Enum.valueOf(AsrCap.class, str);
        }

        public static AsrCap[] values() {
            return (AsrCap[]) $VALUES.clone();
        }
    }

    public SpeechServiceImpl(Context context) {
        p.i(context, "context");
        this.context = context;
        MicForegroundService.INSTANCE.g(context);
        this.asrEngine = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.speech.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SpeechServiceImpl.d(this.f28328a);
            }
        });
        this.asrCap = new AtomicReference<>(AsrCap.UNKNOWN);
        this.asrCapAtMs = new AtomicLong(0L);
        this.ASR_CAP_TTL_MS = 10000L;
        this.asrCapScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
        this.ttsEngine = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.speech.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SpeechServiceImpl.j(this.f28329a);
            }
        });
    }

    public static final AIEngineAsrEngine d(SpeechServiceImpl speechServiceImpl) {
        AIEngineAsrEngine aIEngineAsrEngine;
        try {
            aIEngineAsrEngine = new AIEngineAsrEngine(speechServiceImpl.context);
        } catch (Exception e10) {
            Log.w(TAG, "asrEngine: lazy init threw", e10);
            aIEngineAsrEngine = null;
        }
        Log.i(TAG, "asrEngine initialized=" + (aIEngineAsrEngine != null));
        return aIEngineAsrEngine;
    }

    public static final AIEngineTtsEngine j(SpeechServiceImpl speechServiceImpl) {
        AIEngineTtsEngine aIEngineTtsEngine;
        try {
            aIEngineTtsEngine = new AIEngineTtsEngine(speechServiceImpl.context);
        } catch (Exception e10) {
            Log.w(TAG, "ttsEngine: lazy init threw", e10);
            aIEngineTtsEngine = null;
        }
        Log.i(TAG, "ttsEngine initialized=" + (aIEngineTtsEngine != null));
        return aIEngineTtsEngine;
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void armStartHapticPcmSkip() {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.armStartHapticPcmSkip();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void cancelAsr() {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.cancel();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void cancelCapturePrewarm() {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.cancelCapturePrewarm();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void destroy() {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.destroy();
        }
        i iVarG = g();
        if (iVarG != null) {
            iVarG.destroy();
        }
    }

    public final boolean e() {
        boolean zB = I.INSTANCE.b(this.context);
        c cVarF = f();
        boolean z10 = false;
        if (cVarF != null && cVarF.a(this.context)) {
            z10 = true;
        }
        this.asrCap.set(!z10 ? AsrCap.FAIL : zB ? AsrCap.ONLINE_OK : AsrCap.OK);
        this.asrCapAtMs.set(System.currentTimeMillis());
        if (!z10) {
            Log.w(TAG, "isAsrAvailable=false (computed)");
        }
        return z10;
    }

    public final c f() {
        return (c) this.asrEngine.getValue();
    }

    public final i g() {
        return (i) this.ttsEngine.getValue();
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public long getLongPressRemainingMs() {
        c cVarF = f();
        if (cVarF != null) {
            return cVarF.getLongPressRemainingMs();
        }
        return -1L;
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public long getLongPressTimeoutMs() {
        c cVarF = f();
        if (cVarF != null) {
            return cVarF.getLongPressTimeoutMs();
        }
        return 0L;
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public long getRecordingRemainingMs() {
        c cVarF = f();
        if (cVarF != null) {
            return cVarF.getRecordingRemainingMs();
        }
        return -1L;
    }

    public final void h() {
        C1060i.d(this.asrCapScope, null, null, new SpeechServiceImpl$refreshAsrCapAsync$1(this, null), 3, null);
    }

    public final void i() {
        i iVarG = g();
        if (iVarG == null || !iVarG.isSpeaking()) {
            return;
        }
        Log.i(TAG, "stopTtsBeforeAsr: TTS speaking, stopping before ASR open mic");
        i iVarG2 = g();
        if (iVarG2 != null) {
            iVarG2.stop();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public boolean isAsrAvailable() {
        if (I.INSTANCE.b(this.context)) {
            return e();
        }
        AsrCap asrCap = this.asrCap.get();
        if (asrCap == AsrCap.ONLINE_OK) {
            if (!p.d(Looper.myLooper(), Looper.getMainLooper())) {
                return e();
            }
            Log.w(TAG, "isAsrAvailable: drop online-skip cache, refresh offline");
            h();
            return false;
        }
        if (asrCap != AsrCap.UNKNOWN && System.currentTimeMillis() - this.asrCapAtMs.get() <= this.ASR_CAP_TTL_MS) {
            AsrCap asrCap2 = AsrCap.OK;
            Log.d(TAG, "isAsrAvailable(cached)=" + (asrCap == asrCap2));
            return asrCap == asrCap2;
        }
        if (!p.d(Looper.myLooper(), Looper.getMainLooper())) {
            return e();
        }
        Log.w(TAG, "isAsrAvailable on main with stale cap=" + asrCap + " → refresh in background, return last-known");
        h();
        return asrCap == AsrCap.OK;
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public boolean isSpeaking() {
        i iVarG = g();
        if (iVarG != null) {
            return iVarG.isSpeaking();
        }
        return false;
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public boolean isTtsAvailable() {
        i iVarG = g();
        boolean z10 = false;
        if (iVarG != null && iVarG.a(this.context)) {
            z10 = true;
        }
        if (!z10) {
            Log.w(TAG, "isTtsAvailable=false");
        }
        return z10;
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void pauseSpeak() {
        i iVarG = g();
        if (iVarG != null) {
            iVarG.pause();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void prewarmManualCapture() {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.c();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void resumeSpeak() {
        i iVarG = g();
        if (iVarG != null) {
            iVarG.resume();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void setListeningConfig(Long silenceTimeoutMs, Long listenTimeoutMs, Long muteTimeoutMs) {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.setListeningConfig(silenceTimeoutMs, listenTimeoutMs, muteTimeoutMs);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void setLongPressTimeoutMs(Long timeoutMs) {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.setLongPressTimeoutMs(timeoutMs);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void setSpeakDuckGain(float gain) {
        i iVarG = g();
        if (iVarG != null) {
            iVarG.c(gain);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void setVadEnabled(boolean enabled) {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.setVadEnabled(enabled);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void speak(String text, TtsListener listener) {
        p.i(text, "text");
        if (!SlaRouter.INSTANCE.n(this.context)) {
            Log.w(TAG, "speak blocked: AI engine not ready");
            if (listener != null) {
                listener.onPlayStopped();
                return;
            }
            return;
        }
        i iVarG = g();
        if (iVarG != null) {
            iVarG.speak(text, listener);
            return;
        }
        Log.w(TAG, "speak skipped: ttsEngine unavailable");
        if (listener != null) {
            listener.onPlayStopped();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void startListening(AsrCallback callback) {
        p.i(callback, "callback");
        if (!SlaRouter.INSTANCE.n(this.context)) {
            Log.w(TAG, "startListening blocked: AI engine not ready");
            callback.onError(AIEngineError.PERMISSION_DENIED, "AI engine not ready");
            return;
        }
        i();
        c cVarF = f();
        if (cVarF != null) {
            cVarF.startListening(callback);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void startManualRecording(AsrCallback callback) {
        p.i(callback, "callback");
        if (!SlaRouter.INSTANCE.n(this.context)) {
            Log.w(TAG, "startManualRecording blocked: AI engine not ready");
            callback.onError(AIEngineError.PERMISSION_DENIED, "AI engine not ready");
            return;
        }
        i();
        c cVarF = f();
        if (cVarF != null) {
            cVarF.b(callback);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void startSlaOnlyListening(AsrCallback callback) {
        p.i(callback, "callback");
        if (!SlaRouter.INSTANCE.n(this.context)) {
            Log.w(TAG, "startSlaOnlyListening blocked: AI engine not ready");
            callback.onError(AIEngineError.PERMISSION_DENIED, "AI engine not ready");
            return;
        }
        i();
        c cVarF = f();
        if (cVarF != null) {
            cVarF.startSlaOnlyListening(callback);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void startSlaOnlyRecording(AsrCallback callback) {
        p.i(callback, "callback");
        if (!SlaRouter.INSTANCE.n(this.context)) {
            Log.w(TAG, "startSlaOnlyRecording blocked: AI engine not ready");
            callback.onError(AIEngineError.PERMISSION_DENIED, "AI engine not ready");
            return;
        }
        i();
        c cVarF = f();
        if (cVarF != null) {
            cVarF.d(callback);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public TtsStreamSession startStreamSpeak(TtsListener listener) {
        if (!SlaRouter.INSTANCE.n(this.context)) {
            Log.w(TAG, "startStreamSpeak blocked: AI engine not ready");
            if (listener != null) {
                listener.onPlayStopped();
            }
            return null;
        }
        i iVarG = g();
        if (iVarG != null) {
            return iVarG.b(listener);
        }
        Log.w(TAG, "startStreamSpeak skipped: ttsEngine unavailable");
        if (listener != null) {
            listener.onPlayStopped();
        }
        return null;
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void stopAndFinalize() {
        c cVarF = f();
        if (cVarF != null) {
            cVarF.stopAndFinalize();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.speech.ISpeechService
    public void stopSpeak() {
        i iVarG = g();
        if (iVarG != null) {
            iVarG.stop();
        }
    }
}
