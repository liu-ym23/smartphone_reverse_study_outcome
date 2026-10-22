package com.stepos.ailauncher.chat.trace;

import Y8.j;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.y;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b6\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J]\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dJE\u0010\u001e\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001fJE\u0010\"\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010\u001fJG\u0010%\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010\u001fJ_\u0010+\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b+\u0010,J7\u00101\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00042\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010.2\b\b\u0002\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00104R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00104R\u0014\u00108\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00104R\u0014\u00109\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00104R\u0014\u0010:\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00104R\u0014\u0010;\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00104R\u0014\u0010<\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u00104R\u0014\u0010>\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u00104R\u0014\u0010?\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u00104R\u0014\u0010@\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u00104R\u0014\u0010A\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u00104R\u0014\u0010B\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u00104R\u0014\u0010C\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u00104R\u0014\u0010D\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u00104R\u0014\u0010E\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u00104R\u0014\u0010F\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u00104R\u0014\u0010G\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u00104R\u0014\u0010H\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u00104R\u0014\u0010I\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u00104R\u0014\u0010J\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u00104R\u0014\u0010K\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u00104R\u0014\u0010L\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u00104R\u0014\u0010M\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u00104R\u0014\u0010N\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u00104R\u0014\u0010O\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u00104R\u0014\u0010P\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u00104R\u0014\u0010Q\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u00104R\u0014\u0010R\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u00104R\u0014\u0010S\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u00104R\u0014\u0010T\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bT\u00104R\u0014\u0010U\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u00104R\u0014\u0010V\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u00104R\u0014\u0010W\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u00104R\u0014\u0010X\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u00104R\u0014\u0010Y\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u00104R\u0014\u0010Z\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bZ\u00104R\u0014\u0010[\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u00104R\u0014\u0010\\\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\\\u00104R\u0014\u0010]\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b]\u00104R\u0014\u0010^\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u00104R\u0014\u0010_\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u00104R\u0014\u0010`\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u00104R\u0014\u0010a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u00104R\u0014\u0010b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bb\u00104R\u0014\u0010c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bc\u00104R\u0014\u0010d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bd\u00104R\u0014\u0010f\u001a\u00020e8\u0006X\u0086T¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006h"}, d2 = {"Lcom/stepos/ailauncher/chat/trace/h;", "", "<init>", "()V", "", "source", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Ljava/lang/String;", "", "monitorSaysOff", "interactive", "", "displayState", "recentlyWokeFromOff", "l", "(ZLjava/lang/Boolean;Ljava/lang/Integer;Z)Z", "sessionId", "wakeupType", "systemState", "wakeupResult", "targetState", "failReason", DidiCardProvider.KEY_TRACE_ID, "LY8/t;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "screenOnResult", "overlayShowResult", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "occupiedSourceType", "blockStage", "e", "dispatchResult", "appForegroundState", "sceneType", "hasActiveSession", "isFallback", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "event", "", "params", "page", "f", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "PAGE_DEFAULT", "Ljava/lang/String;", "PAGE_LOCKSCREEN", "EVENT_WAKEUP_RESULT", "EVENT_VOICE_CONTENT_RESULT", "EVENT_LOCKSCREEN_WAKEUP", "EVENT_SCREENOFF_WAKEUP", "EVENT_MIC_OCCUPIED_BLOCK", "EVENT_SESSION_DISPATCH", "TYPE_LOCKSCREEN_SHORTCUT", "TYPE_VOICE_WAKEUP", "TYPE_HOME_INPUTBAR", "TYPE_AI_KEY_CLICK", "TYPE_ASK_AI_ENTRY", "TYPE_SHARE_AGENT", "TYPE_GUI_AGENT", "TYPE_HEADSET_CONTROL", "TYPE_LOCKSCREEN_ENTRY", "TYPE_NAV_KEY_LONG_PRESS", "STATE_APP_HOME", "STATE_LOCK_SCREEN", "STATE_SCREEN_OFF", "STATE_LAUNCHER", "STATE_OTHER_APP", "RESULT_SUCCESS", "RESULT_FAIL", "RESULT_CANCEL", "RESULT_IGNORED", "TARGET_LISTENING", "TARGET_KEYBOARD_INPUT", "TARGET_LOCKSCREEN_OVERLAY", "TARGET_CHATVIEW", "TARGET_FULLSCREEN_GUI", "FAIL_WAKEWORD", "FAIL_VOICEPRINT", "FAIL_MIC_OCCUPIED", "FAIL_SYSTEM_INTERRUPTED", "FAIL_TIMEOUT", "FAIL_UNKNOWN", "OCCUPIED_CALL", "OCCUPIED_RECORDER", "OCCUPIED_OTHER_APP", "OCCUPIED_UNKNOWN", "BLOCK_BEFORE_WAKEUP", "BLOCK_BEFORE_LISTENING", "BLOCK_DURING_LISTENING", "DISPATCH_REUSE", "DISPATCH_CREATE_NEW", "APP_FOREGROUND", "APP_BACKGROUND", "", "SCREEN_OFF_WAKE_WINDOW_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    public static final String APP_BACKGROUND = "background";
    public static final String APP_FOREGROUND = "foreground";
    public static final String BLOCK_BEFORE_LISTENING = "before_listening";
    public static final String BLOCK_BEFORE_WAKEUP = "before_wakeup";
    public static final String BLOCK_DURING_LISTENING = "during_listening";
    public static final String DISPATCH_CREATE_NEW = "create_new_session";
    public static final String DISPATCH_REUSE = "reuse_current_session";
    private static final String EVENT_LOCKSCREEN_WAKEUP = "lockscreen_wakeup_result";
    private static final String EVENT_MIC_OCCUPIED_BLOCK = "mic_occupied_block";
    private static final String EVENT_SCREENOFF_WAKEUP = "screenoff_wakeup_result";
    private static final String EVENT_SESSION_DISPATCH = "session_dispatch";
    private static final String EVENT_VOICE_CONTENT_RESULT = "voice_wakeup_content_result";
    private static final String EVENT_WAKEUP_RESULT = "xiaoyue_wakeup_result";
    public static final String FAIL_MIC_OCCUPIED = "mic_occupied";
    public static final String FAIL_SYSTEM_INTERRUPTED = "system_interrupted";
    public static final String FAIL_TIMEOUT = "timeout";
    public static final String FAIL_UNKNOWN = "unknown";
    public static final String FAIL_VOICEPRINT = "voiceprint_fail";
    public static final String FAIL_WAKEWORD = "wakeword_fail";
    public static final h INSTANCE = new h();
    public static final String OCCUPIED_CALL = "call";
    public static final String OCCUPIED_OTHER_APP = "other_app";
    public static final String OCCUPIED_RECORDER = "recorder";
    public static final String OCCUPIED_UNKNOWN = "unknown";
    private static final String PAGE_DEFAULT = "chatview";
    private static final String PAGE_LOCKSCREEN = "lockscreen";
    public static final String RESULT_CANCEL = "cancel";
    public static final String RESULT_FAIL = "fail";
    public static final String RESULT_IGNORED = "ignored";
    public static final String RESULT_SUCCESS = "success";
    public static final long SCREEN_OFF_WAKE_WINDOW_MS = 1500;
    public static final String STATE_APP_HOME = "app_home";
    public static final String STATE_LAUNCHER = "launcher";
    public static final String STATE_LOCK_SCREEN = "lock_screen";
    public static final String STATE_OTHER_APP = "other_app";
    public static final String STATE_SCREEN_OFF = "screen_off";
    public static final String TARGET_CHATVIEW = "chatview";
    public static final String TARGET_FULLSCREEN_GUI = "fullscreen_gui";
    public static final String TARGET_KEYBOARD_INPUT = "keyboard_input";
    public static final String TARGET_LISTENING = "listening";
    public static final String TARGET_LOCKSCREEN_OVERLAY = "lockscreen_overlay";
    public static final String TYPE_AI_KEY_CLICK = "ai_key_click";
    public static final String TYPE_ASK_AI_ENTRY = "ask_ai_entry";
    public static final String TYPE_GUI_AGENT = "gui_agent";
    public static final String TYPE_HEADSET_CONTROL = "headset_control";
    public static final String TYPE_HOME_INPUTBAR = "home_inputbar";
    public static final String TYPE_LOCKSCREEN_ENTRY = "lockscreen_entry";
    public static final String TYPE_LOCKSCREEN_SHORTCUT = "lockscreen_shortcut";
    public static final String TYPE_NAV_KEY_LONG_PRESS = "nav_key_long_press";
    public static final String TYPE_SHARE_AGENT = "share_agent";
    public static final String TYPE_VOICE_WAKEUP = "voice_wakeup";

    public static /* synthetic */ void c(h hVar, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        if ((i10 & 16) != 0) {
            str5 = null;
        }
        hVar.b(str, str2, str3, str4, str5);
    }

    public static /* synthetic */ void g(h hVar, String str, Map map, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "chatview";
        }
        hVar.f(str, map, str2);
    }

    public static /* synthetic */ void i(h hVar, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        if ((i10 & 16) != 0) {
            str5 = null;
        }
        hVar.h(str, str2, str3, str4, str5);
    }

    public final String a(Context context) {
        p.i(context, "context");
        Object systemService = context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager != null && !powerManager.isInteractive()) {
            return STATE_SCREEN_OFF;
        }
        Object systemService2 = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService2 instanceof KeyguardManager ? (KeyguardManager) systemService2 : null;
        return (keyguardManager == null || !keyguardManager.isKeyguardLocked()) ? y.INSTANCE.d() ? STATE_APP_HOME : "other_app" : STATE_LOCK_SCREEN;
    }

    public final void b(String wakeupType, String wakeupResult, String targetState, String failReason, String traceId) {
        f(EVENT_LOCKSCREEN_WAKEUP, kotlin.collections.a.m(j.a("wakeup_type", wakeupType), j.a("wakeup_result", wakeupResult), j.a("target_state", targetState), j.a("fail_reason", failReason), j.a("trace_id", traceId)), "lockscreen");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0086 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L87
            int r1 = r2.hashCode()
            java.lang.String r0 = "ai_key_click"
            switch(r1) {
                case -1418033720: goto L7d;
                case -1350521956: goto L71;
                case -951070683: goto L65;
                case -926107835: goto L5c;
                case -833467215: goto L53;
                case -548645468: goto L47;
                case 293766892: goto L3c;
                case 390025893: goto L31;
                case 643045183: goto L28;
                case 684453624: goto L1f;
                case 797870729: goto L15;
                case 1080244305: goto Ld;
                default: goto Lb;
            }
        Lb:
            goto L87
        Ld:
            boolean r1 = r2.equals(r0)
            if (r1 != 0) goto L86
            goto L87
        L15:
            java.lang.String r1 = "lock_screen_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L50
            goto L87
        L1f:
            java.lang.String r1 = "ai_key_long_click_end"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L86
            goto L87
        L28:
            java.lang.String r1 = "ai_key_long_click_start"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L86
            goto L87
        L31:
            java.lang.String r1 = "share_agent"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L3b
            goto L87
        L3b:
            return r1
        L3c:
            java.lang.String r1 = "voice_wakeup"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L46
            goto L87
        L46:
            return r1
        L47:
            java.lang.String r1 = "lock_screen_long_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L50
            goto L87
        L50:
            java.lang.String r1 = "lockscreen_shortcut"
            return r1
        L53:
            java.lang.String r1 = "ai_key_double_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L86
            goto L87
        L5c:
            java.lang.String r1 = "home_key_long_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L6e
            goto L87
        L65:
            java.lang.String r1 = "bottom_bar_key_long_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L6e
            goto L87
        L6e:
            java.lang.String r1 = "home_inputbar"
            return r1
        L71:
            java.lang.String r1 = "headset_wakeup"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L7a
            goto L87
        L7a:
            java.lang.String r1 = "headset_control"
            return r1
        L7d:
            java.lang.String r1 = "ai_key"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L86
            goto L87
        L86:
            return r0
        L87:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.trace.h.d(java.lang.String):java.lang.String");
    }

    public final void e(String wakeupType, String systemState, String occupiedSourceType, String blockStage, String traceId) {
        g(this, EVENT_MIC_OCCUPIED_BLOCK, kotlin.collections.a.m(j.a("wakeup_type", wakeupType), j.a("system_state", systemState), j.a("occupied_source_type", occupiedSourceType), j.a("block_stage", blockStage), j.a("trace_id", traceId)), null, 4, null);
    }

    public final void f(String event, Map<String, ? extends Object> params, String page) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(params.size());
        Iterator<Map.Entry<String, ? extends Object>> it = params.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                C4148a.k("Track", event + " page=" + page + " " + linkedHashMap, false, 4, null);
                N.b(event, page, linkedHashMap);
                return;
            }
            Map.Entry<String, ? extends Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            String string = value != null ? value.toString() : null;
            if (string == null) {
                string = "";
            }
            linkedHashMap.put(key, string);
        }
    }

    public final void h(String wakeupType, String screenOnResult, String overlayShowResult, String failReason, String traceId) {
        g(this, EVENT_SCREENOFF_WAKEUP, kotlin.collections.a.m(j.a("wakeup_type", wakeupType), j.a("screen_on_result", screenOnResult), j.a("overlay_show_result", overlayShowResult), j.a("fail_reason", failReason), j.a("trace_id", traceId)), null, 4, null);
    }

    public final void j(String dispatchResult, String appForegroundState, String sceneType, Boolean hasActiveSession, Boolean isFallback, String sessionId, String traceId) {
        g(this, EVENT_SESSION_DISPATCH, kotlin.collections.a.m(j.a("dispatch_result", dispatchResult), j.a("app_foreground_state", appForegroundState), j.a("scene_type", sceneType), j.a("has_active_session", hasActiveSession), j.a("is_fallback", isFallback), j.a("session_id", sessionId), j.a("trace_id", traceId)), null, 4, null);
    }

    public final void k(String sessionId, String wakeupType, String systemState, String wakeupResult, String targetState, String failReason, String traceId) {
        g(this, EVENT_WAKEUP_RESULT, kotlin.collections.a.m(j.a("session_id", sessionId), j.a("wakeup_type", wakeupType), j.a("system_state", systemState), j.a("wakeup_result", wakeupResult), j.a("target_state", targetState), j.a("fail_reason", failReason), j.a("trace_id", traceId)), null, 4, null);
        if (p.d(systemState, STATE_LOCK_SCREEN)) {
            b(wakeupType, wakeupResult, targetState, failReason, traceId);
        }
    }

    public final boolean l(boolean monitorSaysOff, Boolean interactive, Integer displayState, boolean recentlyWokeFromOff) {
        if (monitorSaysOff || p.d(interactive, Boolean.FALSE) || recentlyWokeFromOff) {
            return true;
        }
        if (displayState != null && displayState.intValue() == 1) {
            return true;
        }
        if (displayState != null && displayState.intValue() == 3) {
            return true;
        }
        return displayState != null && displayState.intValue() == 4;
    }
}
