package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import k5.C4814a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a1\u0010\b\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a!\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a/\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b \u0010!\"\u0014\u0010\"\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#\"\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00000$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"", "source", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Z", com.stepos.ailauncher.chat.util.g.REASON_RECORDING, "listenMode", "manualPushToTalk", "f", "(Ljava/lang/String;ZZZ)Z", "keyguardShowing", "deviceSecure", "Lcom/stepos/ailauncher/chat/wake/LockedGateAction;", "e", "(ZZ)Lcom/stepos/ailauncher/chat/wake/LockedGateAction;", "userPresentReceived", "fallbackExpired", "Lcom/stepos/ailauncher/chat/wake/UnlockUiSettleDecision;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(ZZZ)Lcom/stepos/ailauncher/chat/wake/UnlockUiSettleDecision;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;)V", "loggedIn", "agentEnabled", "Lcom/stepos/ailauncher/chat/wake/LockScreenDirectEntryRequirement;", Const.INTENT_KEY_UMID, "(ZZ)Lcom/stepos/ailauncher/chat/wake/LockScreenDirectEntryRequirement;", "requirement", "networkUsable", "c", "(Lcom/stepos/ailauncher/chat/wake/LockScreenDirectEntryRequirement;ZZZ)Lcom/stepos/ailauncher/chat/wake/LockedGateAction;", "GUARD_TAG", "Ljava/lang/String;", "", "WAKE_NOTICE_SOURCES", "Ljava/util/Set;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Q1 {
    private static final String GUARD_TAG = "WakeGuard";
    private static final Set<String> WAKE_NOTICE_SOURCES = Z8.Y.j("ai_key_click", C4814a.AI_KEY_CLICK2, C4814a.AI_KEY_DOUBLE_CLICK, C4814a.AI_KEY_LONG_CLICK_START, C4814a.HOME_KEY_LONG_CLICK, C4814a.BOTTOM_BAR_KEY_LONG_CLICK, C4814a.LOCK_SCREEN_CLICK, C4814a.LOCK_SCREEN_LONG_CLICK, C4814a.HEADSET_WAKEUP, "voice_wakeup");

    public static final void b(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        com.stepos.ailauncher.chat.manager.S0 s02 = com.stepos.ailauncher.chat.manager.S0.INSTANCE;
        if (s02.c()) {
            s02.d(context);
            s02.a("agent_prompt_agreed");
            return;
        }
        if (kotlin.jvm.internal.p.d(str, C4814a.AI_KEY_LONG_CLICK_START) || kotlin.jvm.internal.p.d(str, C4814a.AI_KEY_LONG_CLICK_END)) {
            str = "ai_key_click";
        }
        Intent intent = new Intent(context, (Class<?>) WakeService.class);
        if (str != null && !La.H.x0(str)) {
            intent.putExtra(C4814a.PARAM_SOURCE, str);
        }
        WakeService.INSTANCE.J1(context, intent);
    }

    public static final LockedGateAction c(LockScreenDirectEntryRequirement requirement, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.p.i(requirement, "requirement");
        return requirement == LockScreenDirectEntryRequirement.ALLOW ? LockedGateAction.PROMPT_DIRECTLY : e(z10, z11);
    }

    public static final LockScreenDirectEntryRequirement d(boolean z10, boolean z11) {
        return !z10 ? LockScreenDirectEntryRequirement.LOGIN : !z11 ? LockScreenDirectEntryRequirement.AGENT_SWITCH : LockScreenDirectEntryRequirement.ALLOW;
    }

    public static final LockedGateAction e(boolean z10, boolean z11) {
        return !z10 ? LockedGateAction.PROMPT_DIRECTLY : z11 ? LockedGateAction.NOTICE_ONLY : LockedGateAction.UNLOCK_THEN_PROMPT;
    }

    public static final boolean f(String str, boolean z10, boolean z11, boolean z12) {
        if (kotlin.jvm.internal.p.d(str, "voice_wakeup") && z10) {
            return z11 && !z12;
        }
        return true;
    }

    public static final boolean g(String str) {
        return Z8.F.f0(WAKE_NOTICE_SOURCES, str);
    }

    public static final UnlockUiSettleDecision h(boolean z10, boolean z11, boolean z12) {
        return (z11 || !(z10 || z12)) ? z12 ? UnlockUiSettleDecision.FAIL : UnlockUiSettleDecision.WAIT : UnlockUiSettleDecision.CONTINUE;
    }
}
