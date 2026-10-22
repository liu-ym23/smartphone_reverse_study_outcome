package com.stepos.ailauncher.speech.asr;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/h;", "", "", "sessionId", "", "listenVad", "<init>", "(JZ)V", "currentSessionId", com.stepos.ailauncher.chat.util.g.REASON_RECORDING, Const.INTENT_KEY_PKGNAME, "(JZ)Z", "stillCurrent", "noSpeechTimedOut", "heardSpeech", "c", "(ZZZ)Z", "J", "getSessionId", "()J", UxipConstants.f30680s, "useVad", "Z", Const.INTENT_KEY_APIKEY, "()Z", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    private final long sessionId;
    private volatile boolean useVad;

    public h(long j10, boolean z10) {
        this.sessionId = j10;
        this.useVad = z10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getUseVad() {
        return this.useVad;
    }

    public final boolean b(long currentSessionId, boolean recording) {
        if (this.sessionId != currentSessionId || !recording) {
            return false;
        }
        this.useVad = false;
        return true;
    }

    public final boolean c(boolean stillCurrent, boolean noSpeechTimedOut, boolean heardSpeech) {
        if (!stillCurrent || noSpeechTimedOut) {
            return false;
        }
        return !this.useVad || heardSpeech;
    }
}
