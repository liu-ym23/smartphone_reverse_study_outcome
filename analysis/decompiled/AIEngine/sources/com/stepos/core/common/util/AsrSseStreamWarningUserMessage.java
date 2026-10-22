package com.stepos.core.common.util;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import gc.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.b;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrSseStreamWarningUserMessage {
    private static final String FALLBACK = "语音识别出现提示";
    private static final String TAG = "AsrSseStreamWarningUserMessage";
    public static final AsrSseStreamWarningUserMessage INSTANCE = new AsrSseStreamWarningUserMessage();
    private static final Map<String, String> MESSAGES = b.g0(new Pair(AsrSseStreamWarningCode.STREAM_MAX_DURATION_CLAMPED, "录音时间过长，已自动截断并继续识别"), new Pair(AsrSseStreamWarningCode.LEADING_SILENCE_TIMEOUT, "未检测到说话，请重新尝试"));
    private static final Map<String, String> LOG_DETAILS = b.g0(new Pair(AsrSseStreamWarningCode.STREAM_MAX_DURATION_CLAMPED, "recording reached stream max duration and was finalized; transcription still submitted; raise asr.sse.stream.max_duration_ms if longer audio expected"), new Pair(AsrSseStreamWarningCode.LEADING_SILENCE_TIMEOUT, "leading silence timeout; no speech detected before speech_start, transcription skipped"));
    private static final ConcurrentHashMap.KeySetView<String, Boolean> warnedMissing = ConcurrentHashMap.newKeySet();

    private AsrSseStreamWarningUserMessage() {
    }

    public static /* synthetic */ String logDetail$default(AsrSseStreamWarningUserMessage asrSseStreamWarningUserMessage, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return asrSseStreamWarningUserMessage.logDetail(str, str2);
    }

    public final boolean has(String code) {
        g.f(code, "code");
        return MESSAGES.containsKey(code);
    }

    public final String logDetail(String code, String context) {
        g.f(code, "code");
        g.f(context, "context");
        String strConcat = LOG_DETAILS.get(code);
        if (strConcat == null) {
            strConcat = "asr sse stream warning code=".concat(code);
        }
        return q.t0(context) ? strConcat : d.i(strConcat, "; ", context);
    }

    public final String of(String code) {
        g.f(code, "code");
        String str = MESSAGES.get(code);
        if (str != null) {
            return str;
        }
        if (warnedMissing.add(code)) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "no user-facing warning message for code=" + code + "; business will see the fallback. Register it in MESSAGES.");
        }
        return FALLBACK;
    }
}
