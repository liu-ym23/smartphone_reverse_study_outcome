package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import com.stepos.ailauncher.taskstore.R$color;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJm\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ5\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0!2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010 \u001a\u00020\u0015H\u0000¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\r¢\u0006\u0004\b%\u0010\u001dJ\u001d\u0010&\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b&\u0010\u001dJ-\u0010'\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b)\u0010\u001dJ\u0015\u0010*\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J\u001d\u0010-\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u00101J\u0013\u00103\u001a\u00020\u0011*\u000202H\u0002¢\u0006\u0004\b3\u00104J#\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000206052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b7\u00108R\u0014\u00109\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/A;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/taskstore/livenotification/r;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "networkPhase", "LY8/t;", "k", "(Landroid/content/Context;Lcom/stepos/ailauncher/taskstore/livenotification/r;Lcom/stepos/ailauncher/common/utils/NetworkPhase;)V", "", "taskId", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "sessionId", "", "floatOverlay", "medium", "", "timeoutAfterMs", "l", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;Ljava/lang/String;Ljava/lang/String;ZZJ)V", "f", "(Landroid/content/Context;Ljava/lang/String;)V", "", "sessionIds", "forceIfSingleLive", "", "c", "(Landroid/content/Context;Ljava/util/Collection;Z)Ljava/util/Set;", "liveId", "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "label", "n", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/taskstore/livenotification/r;)Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "m", "(Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "Lkotlin/Pair;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Lkotlin/Pair;", "TAG", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A {
    public static final A INSTANCE = new A();
    private static final String TAG = "TaskLiveNotification";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[LiveCardLevel.values().length];
            try {
                iArr[LiveCardLevel.PERMISSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LiveCardLevel.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveCardLevel.SMALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LiveCardLevel.MEDIUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SessionActivityState.values().length];
            try {
                iArr2[SessionActivityState.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SessionActivityState.WAITING_FOR_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SessionActivityState.COMPLETED_UNREAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SessionActivityState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[TaskInfoStatus.values().length];
            try {
                iArr3[TaskInfoStatus.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[TaskInfoStatus.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[TaskInfoStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[TaskInfoStatus.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static /* synthetic */ Set d(A a10, Context context, Collection collection, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return a10.c(context, collection, z10);
    }

    public final void a(Context context, String taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Log.d(TAG, "cancel by taskId=" + taskId + " → refresh owning session");
        TaskLiveNotificationDispatcher.INSTANCE.D0(context, taskId);
    }

    public final void b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Log.d(TAG, "cancelAll on channel");
        T.INSTANCE.p(context);
        TaskLiveNotificationDispatcher.INSTANCE.S0();
    }

    public final Set<String> c(Context context, Collection<String> sessionIds, boolean forceIfSingleLive) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        Log.d(TAG, "cancelMatching sessionIds=" + sessionIds + " forceIfSingle=" + forceIfSingleLive);
        return T.INSTANCE.q(context, sessionIds, forceIfSingleLive);
    }

    public final void e(Context context, String liveId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(liveId, "liveId");
        String string = La.H.D1(liveId).toString();
        if (string.length() == 0) {
            return;
        }
        Log.d(TAG, "cancelPosted liveId=" + string);
        T.INSTANCE.n(context, string);
    }

    public final void f(Context context, String sessionId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        Log.d(TAG, "cancelSession sessionId=" + sessionId);
        T.INSTANCE.n(context, sessionId);
    }

    public final void g(Context context, String taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Log.d(TAG, "dismissByServer taskId=" + taskId);
        TaskLiveNotificationDispatcher.INSTANCE.E0(context, taskId);
    }

    public final void h(Context context, String sessionId, String taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        Log.d(TAG, "dismissFailedAfterView sessionId=" + sessionId + " taskId=" + taskId);
        TaskLiveNotificationDispatcher.INSTANCE.x0(context, sessionId, taskId);
    }

    public final Pair<Integer, Integer> i(TaskInfoStatus status) {
        int i10 = a.$EnumSwitchMapping$2[status.ordinal()];
        return (i10 == 1 || i10 == 2) ? new Pair<>(Integer.valueOf(R$color.taskstore_live_capsule_pending_bg), Integer.valueOf(R$color.taskstore_live_capsule_pending_content)) : i10 != 3 ? i10 != 4 ? new Pair<>(Integer.valueOf(R$color.taskstore_live_capsule_processing_bg), Integer.valueOf(R$color.taskstore_live_capsule_processing_content)) : new Pair<>(Integer.valueOf(R$color.taskstore_live_capsule_failed_bg), Integer.valueOf(R$color.taskstore_live_capsule_failed_content)) : new Pair<>(Integer.valueOf(R$color.taskstore_live_capsule_done_bg), Integer.valueOf(R$color.taskstore_live_capsule_done_content));
    }

    public final LiveCardLevel j(SessionLiveState state) {
        String riskRequestId = state.getRiskRequestId();
        boolean z10 = false;
        boolean z11 = (riskRequestId == null || state.j().isEmpty()) ? false : true;
        if (riskRequestId != null && state.j().isEmpty()) {
            z10 = true;
        }
        return (!z11 || state.j().size() < 3 || x.INSTANCE.e(riskRequestId)) ? z10 ? LiveCardLevel.SMALL : (state.getPhase() != SessionActivityState.RUNNING || z11) ? LiveCardLevel.MEDIUM : LiveCardLevel.SMALL : LiveCardLevel.PERMISSION;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.content.Context r38, com.stepos.ailauncher.taskstore.livenotification.SessionLiveState r39, com.stepos.ailauncher.common.utils.NetworkPhase r40) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.A.k(android.content.Context, com.stepos.ailauncher.taskstore.livenotification.r, com.stepos.ailauncher.common.utils.NetworkPhase):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.content.Context r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r33, java.lang.String r34, java.lang.String r35, boolean r36, boolean r37, long r38) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.A.l(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.stepos.ailauncher.taskstore.entity.TaskInfoStatus, java.lang.String, java.lang.String, boolean, boolean, long):void");
    }

    public final TaskInfoStatus m(SessionActivityState sessionActivityState) {
        int i10 = a.$EnumSwitchMapping$1[sessionActivityState.ordinal()];
        if (i10 == 1) {
            return TaskInfoStatus.RUNNING;
        }
        if (i10 == 2) {
            return TaskInfoStatus.WAITING;
        }
        if (i10 == 3) {
            return TaskInfoStatus.COMPLETED;
        }
        if (i10 == 4) {
            return TaskInfoStatus.FAILED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void n(String sessionId, String label) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(label, "label");
        String string = La.H.D1(sessionId).toString();
        String string2 = La.H.D1(label).toString();
        if (string.length() == 0 || string2.length() == 0) {
            Log.d(TAG, "updateSessionSummary skipped: blank sessionId or label");
            return;
        }
        Log.d(TAG, "updateSessionSummary sessionId=" + string + " label='" + string2 + "'");
        y.INSTANCE.b(string, string2);
        TaskLiveNotificationDispatcher.INSTANCE.B0();
    }
}
