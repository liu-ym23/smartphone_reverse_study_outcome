package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.taskstore.R$string;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/w;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/taskstore/livenotification/r;", VoiceWakeupReceiver.EXTRA_STATE, "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Lcom/stepos/ailauncher/taskstore/livenotification/r;)Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "phase", "dynamic", "c", "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    public static final w INSTANCE = new w();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SessionLiveCategory.values().length];
            try {
                iArr[SessionLiveCategory.TASK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionLiveCategory.CHAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SessionActivityState.values().length];
            try {
                iArr2[SessionActivityState.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[SessionActivityState.COMPLETED_UNREAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SessionActivityState.WAITING_FOR_USER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SessionActivityState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final String a(Context context, SessionActivityState phase, String dynamic) {
        int i10 = a.$EnumSwitchMapping$1[phase.ordinal()];
        if (i10 == 1) {
            String string = context.getString(R$string.taskstore_live_session_chat_thinking);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        if (i10 == 2) {
            String string2 = context.getString(R$string.taskstore_live_session_chat_replied);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return string2;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            String string3 = context.getString(R$string.taskstore_live_session_chat_failed);
            kotlin.jvm.internal.p.h(string3, "getString(...)");
            return string3;
        }
        if (dynamic.length() == 0) {
            String string4 = context.getString(R$string.taskstore_live_session_task_waiting);
            kotlin.jvm.internal.p.f(string4);
            return string4;
        }
        String string5 = context.getString(R$string.taskstore_live_session_task_waiting_with_reason, dynamic);
        kotlin.jvm.internal.p.f(string5);
        return string5;
    }

    public final String b(Context context, SessionLiveState state) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(state, "state");
        SessionActivityState phase = state.getPhase();
        if (phase == null) {
            return "";
        }
        String string = La.H.D1(state.getDynamicText()).toString();
        if (state.getRiskRequestId() != null) {
            String string2 = context.getString(R$string.taskstore_live_session_risk_waiting);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return string2;
        }
        int i10 = a.$EnumSwitchMapping$0[state.getCategory().ordinal()];
        if (i10 == 1) {
            return c(context, phase, string);
        }
        if (i10 == 2) {
            return a(context, phase, string);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String c(Context context, SessionActivityState phase, String dynamic) {
        int i10 = a.$EnumSwitchMapping$1[phase.ordinal()];
        if (i10 == 1) {
            String string = context.getString(R$string.taskstore_live_session_task_running);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        if (i10 == 2) {
            String string2 = context.getString(R$string.taskstore_live_session_task_completed);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return string2;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            String string3 = context.getString(R$string.taskstore_live_session_task_failed);
            kotlin.jvm.internal.p.h(string3, "getString(...)");
            return string3;
        }
        if (dynamic.length() == 0) {
            String string4 = context.getString(R$string.taskstore_live_session_task_waiting);
            kotlin.jvm.internal.p.f(string4);
            return string4;
        }
        String string5 = context.getString(R$string.taskstore_live_session_task_waiting_with_reason, dynamic);
        kotlin.jvm.internal.p.f(string5);
        return string5;
    }
}
