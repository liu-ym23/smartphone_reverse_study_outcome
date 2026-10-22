package com.stepos.ailauncher.chat.trace;

import Y8.j;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b7\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007JG\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0014\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J_\u0010\u001c\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\"\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010#JA\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`'2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010$H\u0000¢\u0006\u0004\b(\u0010)J7\u0010,\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00042\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010$2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010/R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010/R\u0014\u00104\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010/R\u0014\u00105\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010/R\u0014\u00106\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010/R\u0014\u00107\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010/R\u0014\u00108\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010/R\u0014\u00109\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010/R\u0014\u0010:\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010/R\u0014\u0010;\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010/R\u0014\u0010<\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010/R\u0014\u0010=\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010/R\u0014\u0010>\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010/R\u0014\u0010?\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010/R\u0014\u0010@\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010/R\u0014\u0010A\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010/R\u0014\u0010B\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010/R\u0014\u0010C\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010/R\u0014\u0010D\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010/R\u0014\u0010E\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010/R\u0014\u0010F\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u0010/R\u0014\u0010G\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010/R\u0014\u0010H\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010/R\u0014\u0010I\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010/R\u0014\u0010J\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010/R\u0014\u0010K\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010/R\u0014\u0010L\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u0010/R\u0014\u0010M\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010/R\u0014\u0010N\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u0010/R\u0014\u0010O\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010/R\u0014\u0010P\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u0010/R\u0014\u0010Q\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u0010/R\u0014\u0010R\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u0010/R\u0014\u0010S\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010/R\u0014\u0010T\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bT\u0010/R\u0014\u0010U\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u0010/R\u0014\u0010V\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u0010/R\u0014\u0010W\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u0010/R\u0014\u0010X\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u0010/R\u0014\u0010Y\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010/R\u0014\u0010Z\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bZ\u0010/R\u0014\u0010[\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u0010/R\u0014\u0010\\\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\\\u0010/R\u0014\u0010]\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b]\u0010/¨\u0006^"}, d2 = {"Lcom/stepos/ailauncher/chat/trace/g;", "", "<init>", "()V", "", "source", "c", "(Ljava/lang/String;)Ljava/lang/String;", "action", "stopReason", "", "listeningDurationMs", DidiCardProvider.KEY_TRACE_ID, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "triggerSource", "thresholdMs", "systemState", "assistantStateBefore", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "endType", "pressDurationMs", "", "hasVoiceInput", "hasRequestSent", "cancelReason", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "asrResult", "", "asrTextLength", "noResultReason", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "", "params", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map;)Ljava/util/LinkedHashMap;", "event", "page", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "PAGE_DEFAULT", "Ljava/lang/String;", "EVENT_LISTENING_STATE_CHANGE", "EVENT_PRESS_TO_TALK_START", "EVENT_PRESS_TO_TALK_END", "EVENT_PRESS_TO_TALK_ASR_RESULT", "ACTION_START", "ACTION_REFRESH", "ACTION_STOP", "SOURCE_VOICE_WAKEUP", "SOURCE_AI_KEY_CLICK", "SOURCE_HEADSET_CONTROL", "STOP_TIMEOUT", "STOP_SEND_MESSAGE", "STOP_NO_SPEECH", "STOP_SWITCH_KEYBOARD", "STOP_SCREEN_LOCK", "STOP_CALL_INCOMING", "STOP_NAV_KEY_CLICK", "STOP_CIRCLE_SELECT", "STOP_UNKNOWN", "TRIGGER_AI_KEY_LONG_PRESS", "TRIGGER_INPUT_BAR_LONG_PRESS", "ASSISTANT_IDLE", "ASSISTANT_LISTENING", "ASSISTANT_KEYBOARD", "ASSISTANT_CHATVIEW", "ASSISTANT_LOCKSCREEN", "END_RELEASE_SEND", "END_CANCEL", "END_INTERRUPTED", "END_AUTO_SEND_TIMEOUT", "CANCEL_SCREEN_LOCK", "CANCEL_CALL_INCOMING", "CANCEL_NAV_KEY_CLICK", "CANCEL_USER_CANCEL", "CANCEL_CIRCLE_SELECT", "CANCEL_NO_VOICE", "CANCEL_UNKNOWN", "ASR_FINAL_RESULT", "ASR_NO_RESULT", "ASR_FAIL", "ASR_TIMEOUT", "NO_RESULT_NO_SPEECH", "NO_RESULT_TOO_SHORT", "NO_RESULT_NOISE", "NO_RESULT_ASR_ERROR", "NO_RESULT_TIMEOUT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    public static final String ACTION_REFRESH = "refresh";
    public static final String ACTION_START = "start";
    public static final String ACTION_STOP = "stop";
    public static final String ASR_FAIL = "fail";
    public static final String ASR_FINAL_RESULT = "final_result";
    public static final String ASR_NO_RESULT = "no_result";
    public static final String ASR_TIMEOUT = "timeout";
    public static final String ASSISTANT_CHATVIEW = "chatview";
    public static final String ASSISTANT_IDLE = "idle";
    public static final String ASSISTANT_KEYBOARD = "keyboard_input";
    public static final String ASSISTANT_LISTENING = "listening";
    public static final String ASSISTANT_LOCKSCREEN = "lockscreen_overlay";
    public static final String CANCEL_CALL_INCOMING = "call_incoming";
    public static final String CANCEL_CIRCLE_SELECT = "circle_select";
    public static final String CANCEL_NAV_KEY_CLICK = "nav_key_click";
    public static final String CANCEL_NO_VOICE = "no_voice";
    public static final String CANCEL_SCREEN_LOCK = "screen_lock";
    public static final String CANCEL_UNKNOWN = "unknown";
    public static final String CANCEL_USER_CANCEL = "user_cancel";
    public static final String END_AUTO_SEND_TIMEOUT = "auto_send_timeout";
    public static final String END_CANCEL = "cancel";
    public static final String END_INTERRUPTED = "interrupted";
    public static final String END_RELEASE_SEND = "release_send";
    private static final String EVENT_LISTENING_STATE_CHANGE = "listening_state_change";
    private static final String EVENT_PRESS_TO_TALK_ASR_RESULT = "press_to_talk_asr_result";
    private static final String EVENT_PRESS_TO_TALK_END = "press_to_talk_end";
    private static final String EVENT_PRESS_TO_TALK_START = "press_to_talk_start";
    public static final g INSTANCE = new g();
    public static final String NO_RESULT_ASR_ERROR = "asr_error";
    public static final String NO_RESULT_NOISE = "noise";
    public static final String NO_RESULT_NO_SPEECH = "no_speech";
    public static final String NO_RESULT_TIMEOUT = "timeout";
    public static final String NO_RESULT_TOO_SHORT = "too_short";
    private static final String PAGE_DEFAULT = "chatview";
    public static final String SOURCE_AI_KEY_CLICK = "ai_key_click";
    public static final String SOURCE_HEADSET_CONTROL = "headset_control";
    public static final String SOURCE_VOICE_WAKEUP = "voice_wakeup";
    public static final String STOP_CALL_INCOMING = "call_incoming";
    public static final String STOP_CIRCLE_SELECT = "circle_select";
    public static final String STOP_NAV_KEY_CLICK = "nav_key_click";
    public static final String STOP_NO_SPEECH = "no_speech";
    public static final String STOP_SCREEN_LOCK = "screen_lock";
    public static final String STOP_SEND_MESSAGE = "send_message";
    public static final String STOP_SWITCH_KEYBOARD = "switch_keyboard";
    public static final String STOP_TIMEOUT = "timeout";
    public static final String STOP_UNKNOWN = "unknown";
    public static final String TRIGGER_AI_KEY_LONG_PRESS = "ai_key_long_press";
    public static final String TRIGGER_INPUT_BAR_LONG_PRESS = "input_bar_long_press";

    public static /* synthetic */ void b(g gVar, String str, String str2, String str3, Long l10, String str4, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            l10 = null;
        }
        if ((i10 & 16) != 0) {
            str4 = null;
        }
        gVar.a(str, str2, str3, l10, str4);
    }

    public static /* synthetic */ void e(g gVar, String str, Integer num, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        gVar.d(str, num, str2, str3);
    }

    public static /* synthetic */ void i(g gVar, String str, Map map, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "chatview";
        }
        gVar.h(str, map, str2);
    }

    public final void a(String action, String source, String stopReason, Long listeningDurationMs, String traceId) {
        i(this, EVENT_LISTENING_STATE_CHANGE, kotlin.collections.a.m(j.a("action", action), j.a("source", source), j.a("stop_reason", stopReason), j.a("listening_duration_ms", listeningDurationMs), j.a("trace_id", traceId)), null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L33
            int r1 = r2.hashCode()
            java.lang.String r0 = "ai_key_click"
            switch(r1) {
                case -1418033720: goto L29;
                case -1350521956: goto L1d;
                case 293766892: goto L13;
                case 1080244305: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L33
        Lc:
            boolean r1 = r2.equals(r0)
            if (r1 != 0) goto L32
            goto L33
        L13:
            java.lang.String r1 = "voice_wakeup"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L33
            return r1
        L1d:
            java.lang.String r1 = "headset_wakeup"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L26
            goto L33
        L26:
            java.lang.String r1 = "headset_control"
            return r1
        L29:
            java.lang.String r1 = "ai_key"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L32
            goto L33
        L32:
            return r0
        L33:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.trace.g.c(java.lang.String):java.lang.String");
    }

    public final void d(String asrResult, Integer asrTextLength, String noResultReason, String traceId) {
        i(this, EVENT_PRESS_TO_TALK_ASR_RESULT, kotlin.collections.a.m(j.a("asr_result", asrResult), j.a("asr_text_length", asrTextLength), j.a("no_result_reason", noResultReason), j.a("trace_id", traceId)), null, 4, null);
    }

    public final void f(String endType, String triggerSource, Long pressDurationMs, Boolean hasVoiceInput, Boolean hasRequestSent, String cancelReason, String traceId) {
        i(this, EVENT_PRESS_TO_TALK_END, kotlin.collections.a.m(j.a("end_type", endType), j.a("trigger_source", triggerSource), j.a("press_duration_ms", pressDurationMs), j.a("has_voice_input", hasVoiceInput), j.a("has_request_sent", hasRequestSent), j.a("cancel_reason", cancelReason), j.a("trace_id", traceId)), null, 4, null);
    }

    public final void g(String triggerSource, Long thresholdMs, String systemState, String assistantStateBefore, String traceId) {
        i(this, EVENT_PRESS_TO_TALK_START, kotlin.collections.a.m(j.a("trigger_source", triggerSource), j.a("threshold_ms", thresholdMs), j.a("system_state", systemState), j.a("assistant_state_before", assistantStateBefore), j.a("trace_id", traceId)), null, 4, null);
    }

    public final void h(String event, Map<String, ? extends Object> params, String page) {
        LinkedHashMap<String, String> linkedHashMapJ = j(params);
        C4148a.k("Track", event + " page=" + page + " " + linkedHashMapJ, false, 4, null);
        N.a(event, page, linkedHashMapJ);
    }

    public final LinkedHashMap<String, String> j(Map<String, ? extends Object> params) {
        p.i(params, "params");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(params.size());
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String string = value != null ? value.toString() : null;
            if (string == null) {
                string = "";
            }
            linkedHashMap.put(key, string);
        }
        return linkedHashMap;
    }
}
