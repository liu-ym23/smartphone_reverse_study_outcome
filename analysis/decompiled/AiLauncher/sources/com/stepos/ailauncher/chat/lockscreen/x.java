package com.stepos.ailauncher.chat.lockscreen;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.activity.ChatMainActivity;
import com.stepos.ailauncher.chat.lockscreen.LockScreenChatActivity;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2689c0;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0003J5\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b#\u0010$J+\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003R\u0014\u0010,\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0018\u00103\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010-¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/x;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;", "action", "LY8/t;", "s", "(Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;)V", "", "sessionId", "t", "(Ljava/lang/String;)V", "taskId", "u", "e", "()Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;", "f", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "Landroid/content/Context;", "context", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;Ljava/lang/String;Ljava/lang/String;)Z", "Landroid/content/Intent;", "routingIntent", "isInternal", "Lcom/stepos/ailauncher/chat/lockscreen/ChatMainLockRoute;", "q", "(Landroid/content/Context;Landroid/content/Intent;Z)Lcom/stepos/ailauncher/chat/lockscreen/ChatMainLockRoute;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)Z", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "p", "(Landroid/content/Context;)Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "o", "(Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity;", "lockActivity", "n", "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity;)Z", "r", "TAG", "Ljava/lang/String;", "unlockInProgress", "Z", "pendingAction", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;", "pendingSessionId", "pendingTaskId", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    public static final x INSTANCE = new x();
    private static final String TAG = "LockScreenChatGate";
    private static volatile LockScreenChatAction pendingAction;
    private static volatile String pendingSessionId;
    private static volatile String pendingTaskId;
    private static volatile boolean unlockInProgress;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LockScreenChatActivity.UnlockResult.values().length];
            try {
                iArr[LockScreenChatActivity.UnlockResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LockScreenChatActivity.UnlockResult.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LockScreenChatActivity.UnlockResult.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LockScreenChatActivity.UnlockResult.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ boolean j(x xVar, Context context, LockScreenChatAction lockScreenChatAction, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return xVar.i(context, lockScreenChatAction, str, str2);
    }

    public static final Y8.t k(LockScreenChatAction lockScreenChatAction, ChatActivity chatActivity, boolean z10) {
        unlockInProgress = false;
        if (z10) {
            C4148a.k(TAG, "action unlock success, ChatActivity -> normal mode action=" + lockScreenChatAction, false, 4, null);
            chatActivity.c7();
            chatActivity.n9();
        } else {
            C4148a.u(TAG, "unlock not completed, action=" + lockScreenChatAction, false, 4, null);
            INSTANCE.d();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t l(LockScreenChatAction lockScreenChatAction, LockScreenChatActivity lockScreenChatActivity, LockScreenChatActivity.UnlockResult result) {
        kotlin.jvm.internal.p.i(result, "result");
        unlockInProgress = false;
        int i10 = a.$EnumSwitchMapping$0[result.ordinal()];
        if (i10 == 1) {
            C4148a.k(TAG, "action unlock success, stay on lock screen chat action=" + lockScreenChatAction, false, 4, null);
            lockScreenChatActivity.O();
            lockScreenChatActivity.S();
        } else {
            if (i10 != 2 && i10 != 3 && i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            C4148a.u(TAG, "unlock not completed result=" + result + " action=" + lockScreenChatAction, false, 4, null);
            INSTANCE.d();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t m(LockScreenChatAction lockScreenChatAction, ChatMainActivity chatMainActivity, boolean z10) {
        unlockInProgress = false;
        if (z10) {
            C4148a.k(TAG, "action unlock success, ChatMainActivity unlocked action=" + lockScreenChatAction, false, 4, null);
            chatMainActivity.h0();
        } else {
            C4148a.u(TAG, "unlock not completed, action=" + lockScreenChatAction, false, 4, null);
            INSTANCE.d();
        }
        return Y8.t.f7040a;
    }

    public final void d() {
        pendingAction = null;
        pendingSessionId = null;
        pendingTaskId = null;
        C4148a.d(TAG, "clearPendingAction", false, 4, null);
    }

    public final LockScreenChatAction e() {
        LockScreenChatAction lockScreenChatAction = pendingAction;
        pendingAction = null;
        C4148a.d(TAG, "consumePendingAction: " + lockScreenChatAction, false, 4, null);
        return lockScreenChatAction;
    }

    public final String f() {
        String str = pendingSessionId;
        pendingSessionId = null;
        C4148a.d(TAG, "consumePendingSessionId: " + str, false, 4, null);
        return str;
    }

    public final String g() {
        String str = pendingTaskId;
        pendingTaskId = null;
        C4148a.d(TAG, "consumePendingTaskId: " + str, false, 4, null);
        return str;
    }

    public final boolean h(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        LockScreenChatActivity lockScreenChatActivityA = LockScreenChatActivity.INSTANCE.a();
        if (lockScreenChatActivityA == null) {
            return false;
        }
        lockScreenChatActivityA.E();
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        if (n(applicationContext, lockScreenChatActivityA)) {
            return true;
        }
        C4148a.h(TAG, "handoffFromLockScreenChat launch failed, rolling back", false, 4, null);
        r();
        lockScreenChatActivityA.F();
        return false;
    }

    public final boolean i(Context context, final LockScreenChatAction action, String sessionId, String taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(action, "action");
        final ChatActivity chatActivityP = p(context);
        if (chatActivityP != null && chatActivityP.getLockScreenMode()) {
            if (unlockInProgress) {
                C4148a.d(TAG, "intercept ignored: unlock in progress action=" + action, false, 4, null);
                return true;
            }
            C4148a.k(TAG, "intercept (ChatActivity lockScreen) action=" + action + " sessionId=" + sessionId + " taskId=" + taskId, false, 4, null);
            o(action, sessionId, taskId);
            unlockInProgress = true;
            I.INSTANCE.i(chatActivityP, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.lockscreen.u
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return x.k(action, chatActivityP, ((Boolean) obj).booleanValue());
                }
            });
            return true;
        }
        final LockScreenChatActivity lockScreenChatActivityA = context instanceof LockScreenChatActivity ? (LockScreenChatActivity) context : null;
        if (lockScreenChatActivityA == null) {
            lockScreenChatActivityA = LockScreenChatActivity.INSTANCE.a();
        }
        if (lockScreenChatActivityA != null) {
            if (unlockInProgress) {
                C4148a.d(TAG, "intercept ignored: unlock in progress action=" + action, false, 4, null);
                return true;
            }
            C4148a.k(TAG, "intercept (LockScreenChatActivity) action=" + action + " sessionId=" + sessionId + " taskId=" + taskId, false, 4, null);
            o(action, sessionId, taskId);
            unlockInProgress = true;
            lockScreenChatActivityA.U(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.lockscreen.v
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return x.l(action, lockScreenChatActivityA, (LockScreenChatActivity.UnlockResult) obj);
                }
            });
            return true;
        }
        final ChatMainActivity chatMainActivity = context instanceof ChatMainActivity ? (ChatMainActivity) context : null;
        if (chatMainActivity == null || !chatMainActivity.getIsLockedFullChat()) {
            return false;
        }
        if (unlockInProgress) {
            C4148a.d(TAG, "intercept ignored: unlock in progress action=" + action, false, 4, null);
            return true;
        }
        C4148a.k(TAG, "intercept (ChatMainActivity locked) action=" + action + " sessionId=" + sessionId + " taskId=" + taskId, false, 4, null);
        o(action, sessionId, taskId);
        unlockInProgress = true;
        chatMainActivity.j0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.lockscreen.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return x.m(action, chatMainActivity, ((Boolean) obj).booleanValue());
            }
        });
        return true;
    }

    public final boolean n(Context context, LockScreenChatActivity lockActivity) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            ChatMainActivity.INSTANCE.a(context);
            if (lockActivity != null) {
                B.INSTANCE.c(lockActivity);
            }
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "launchFromLockScreenUnlock failed", thE, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void o(LockScreenChatAction action, String sessionId, String taskId) {
        s(action);
        t(sessionId);
        u(taskId);
    }

    public final ChatActivity p(Context context) {
        while (true) {
            Context baseContext = null;
            if (context == null) {
                return null;
            }
            if (context instanceof ChatActivity) {
                return (ChatActivity) context;
            }
            ContextWrapper contextWrapper = context instanceof ContextWrapper ? (ContextWrapper) context : null;
            if (contextWrapper != null) {
                baseContext = contextWrapper.getBaseContext();
            }
            context = baseContext;
        }
    }

    public final ChatMainLockRoute q(Context context, Intent routingIntent, boolean isInternal) {
        kotlin.jvm.internal.p.i(context, "context");
        return C.INSTANCE.j(context, routingIntent, isInternal);
    }

    public final void r() {
        AgentConfig.INSTANCE.a().w(null);
        C2689c0.INSTANCE.c();
    }

    public final void s(LockScreenChatAction action) {
        pendingAction = action;
        C4148a.d(TAG, "setPendingAction: " + action, false, 4, null);
    }

    public final void t(String sessionId) {
        pendingSessionId = sessionId;
        C4148a.d(TAG, "setPendingSessionId: " + sessionId, false, 4, null);
    }

    public final void u(String taskId) {
        pendingTaskId = taskId;
        C4148a.d(TAG, "setPendingTaskId: " + taskId, false, 4, null);
    }
}
