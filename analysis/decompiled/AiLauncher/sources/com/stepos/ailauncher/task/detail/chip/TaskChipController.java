package com.stepos.ailauncher.task.detail.chip;

import Y8.t;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.exifinterface.media.ExifInterface;
import b6.InterfaceC1452a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.SessionHandler.f;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.widget.SweepTextView;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.ailauncher.foundation.task.TaskModule;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.detail.J0;
import com.stepos.ailauncher.task.detail.chip.TaskChipController;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001F\u0018\u0000 O2\u00020\u0001:\u0002PQB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\b¢\u0006\u0004\b#\u0010\nJ\u0015\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0016¢\u0006\u0004\b%\u0010\u0019J\u0015\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0016¢\u0006\u0004\b'\u0010\u0019J\r\u0010(\u001a\u00020\b¢\u0006\u0004\b(\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u0016\u0010+\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00100\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010,R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010,R\u0016\u00105\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010,R\u0016\u00106\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00108R\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u00108R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00109R\u0016\u0010:\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010,R\u0016\u0010;\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010,R0\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010,R\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u00020\u0016*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006R"}, d2 = {"Lcom/stepos/ailauncher/task/detail/chip/TaskChipController;", "", "Lcom/stepos/ailauncher/common/widget/SweepTextView;", "label", "", "doneAutoHideMs", "<init>", "(Lcom/stepos/ailauncher/common/widget/SweepTextView;J)V", "LY8/t;", "w", "()V", "Lw4/c;", "message", "u", "(Lw4/c;)V", "Lcom/stepos/ailauncher/task/detail/chip/TaskChipController$ChipState;", "D", "()Lcom/stepos/ailauncher/task/detail/chip/TaskChipController$ChipState;", "B", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "s", "", "hidden", "F", "(Z)V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "", "sessionId", "productKey", "p", "(Lcom/stepos/agentframework/chatcore/SessionHandler;Ljava/lang/String;Ljava/lang/String;)Z", "y", "(Ljava/lang/String;)V", "z", AuthSessionDto.STATUS_PENDING, "H", Z5.b.FALLBACK_STATE_WAITING, ExifInterface.LONGITUDE_EAST, "C", "Lcom/stepos/ailauncher/common/widget/SweepTextView;", "J", "awaitingReply", "Z", "replying", "stoppedByUser", "pendingCard", "awaitingAuthorization", "Landroid/animation/Animator;", "terminalPopAnim", "Landroid/animation/Animator;", "failed", "armFailWatch", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/task/detail/chip/TaskChipController$ChipState;", "Ljava/lang/String;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "immersiveHidden", "suppressInitialTerminal", "Lkotlin/Function1;", "onShownChanged", "Lp9/l;", "getOnShownChanged", "()Lp9/l;", "G", "(Lp9/l;)V", "lastShown", "Ljava/lang/Boolean;", "taskCallbackRegistered", "com/stepos/ailauncher/task/detail/chip/TaskChipController$e", "taskCallback", "Lcom/stepos/ailauncher/task/detail/chip/TaskChipController$e;", "Ljava/lang/Runnable;", "autoHideTerminal", "Ljava/lang/Runnable;", "t", "(Lcom/stepos/ailauncher/task/detail/chip/TaskChipController$ChipState;)Z", "isTerminal", "Companion", "ChipState", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskChipController {
    private static final a Companion = new a(null);

    @Deprecated
    public static final int DONE_TEXT_COLOR = -14044837;

    @Deprecated
    public static final int FAILED_TEXT_COLOR = -16886;

    @Deprecated
    public static final int STATIC_TEXT_COLOR = -1275068417;

    @Deprecated
    public static final int SWEEP_HIGHLIGHT_COLOR = -1;

    @Deprecated
    public static final String TAG = "TaskChipController";

    @Deprecated
    public static final long TERMINAL_POP_MS = 83;

    @Deprecated
    public static final float TERMINAL_POP_START_SCALE = 1.18f;
    private boolean armFailWatch;
    private final Runnable autoHideTerminal;
    private boolean awaitingAuthorization;
    private boolean awaitingReply;
    private final long doneAutoHideMs;
    private boolean failed;
    private SessionHandler handler;
    private boolean immersiveHidden;
    private final SweepTextView label;
    private Boolean lastShown;
    private InterfaceC5074l<? super Boolean, t> onShownChanged;
    private boolean pendingCard;
    private String productKey;
    private boolean replying;
    private String sessionId;
    private ChipState state;
    private boolean stoppedByUser;
    private boolean suppressInitialTerminal;
    private final e taskCallback;
    private boolean taskCallbackRegistered;
    private Animator terminalPopAnim;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/task/detail/chip/TaskChipController$ChipState;", "", "<init>", "(Ljava/lang/String;I)V", "TAKEOVER", "THINKING", "EXECUTING", "FAILED", "DONE", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ChipState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ChipState[] $VALUES;
        public static final ChipState TAKEOVER = new ChipState("TAKEOVER", 0);
        public static final ChipState THINKING = new ChipState("THINKING", 1);
        public static final ChipState EXECUTING = new ChipState("EXECUTING", 2);
        public static final ChipState FAILED = new ChipState("FAILED", 3);
        public static final ChipState DONE = new ChipState("DONE", 4);

        private static final /* synthetic */ ChipState[] $values() {
            return new ChipState[]{TAKEOVER, THINKING, EXECUTING, FAILED, DONE};
        }

        static {
            ChipState[] chipStateArr$values = $values();
            $VALUES = chipStateArr$values;
            $ENTRIES = kotlin.enums.a.a(chipStateArr$values);
        }

        private ChipState(String str, int i10) {
        }

        public static InterfaceC4149a<ChipState> getEntries() {
            return $ENTRIES;
        }

        public static ChipState valueOf(String str) {
            return (ChipState) Enum.valueOf(ChipState.class, str);
        }

        public static ChipState[] values() {
            return (ChipState[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/task/detail/chip/TaskChipController$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "SWEEP_HIGHLIGHT_COLOR", "I", "STATIC_TEXT_COLOR", "DONE_TEXT_COLOR", "FAILED_TEXT_COLOR", "", "TERMINAL_POP_START_SCALE", "F", "", "TERMINAL_POP_MS", "J", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EReplyStatus.values().length];
            try {
                iArr[EReplyStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EReplyStatus.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EReplyStatus.CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ChipState.values().length];
            try {
                iArr2[ChipState.TAKEOVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ChipState.THINKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ChipState.EXECUTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ChipState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ChipState.DONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/task/detail/chip/TaskChipController$c", "Lcom/stepos/agentframework/chatcore/session/AgentSession$g;", "Lw4/c;", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/c;)V", "", "success", "", "code", "", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/Integer;Ljava/lang/String;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements AgentSession.g {
        public c() {
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.g
        public void a(ChatMessage message) {
            p.i(message, "message");
            TaskChipController.this.u(message);
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.g
        public void b(boolean success, Integer code, String message) {
            if (success) {
                return;
            }
            TaskChipController.this.w();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/task/detail/chip/TaskChipController$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            p.i(animation, "animation");
            TaskChipController.this.label.setScaleX(1.0f);
            TaskChipController.this.label.setScaleY(1.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/task/detail/chip/TaskChipController$e", "Lb6/a;", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "taskCard", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC1452a {
        public e() {
        }

        public static final void d(TaskChipController taskChipController) {
            taskChipController.B();
        }

        @Override // b6.InterfaceC1452a
        public /* bridge */ void a(UiTask uiTask, List<UiTask> list) {
            super.a(uiTask, list);
        }

        @Override // b6.InterfaceC1452a
        public void b(UiTask taskCard) {
            p.i(taskCard, "taskCard");
            if (TaskChipController.this.armFailWatch && taskCard.getStatus() == 5) {
                String str = TaskChipController.this.sessionId;
                if (str.length() == 0 || !p.d(taskCard.getRequestedSessionKey(), str) || TaskChipController.this.failed) {
                    return;
                }
                TaskChipController.this.failed = true;
                TaskChipController.this.awaitingReply = false;
                TaskChipController.this.replying = false;
                SweepTextView sweepTextView = TaskChipController.this.label;
                final TaskChipController taskChipController = TaskChipController.this;
                sweepTextView.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.chip.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskChipController.e.d(taskChipController);
                    }
                });
            }
        }
    }

    public TaskChipController(SweepTextView label, long j10) {
        p.i(label, "label");
        this.label = label;
        this.doneAutoHideMs = j10;
        this.state = ChipState.DONE;
        this.sessionId = "";
        this.productKey = "";
        this.taskCallback = new e();
        this.autoHideTerminal = new Runnable() { // from class: com.stepos.ailauncher.task.detail.chip.b
            @Override // java.lang.Runnable
            public final void run() {
                TaskChipController.q(this.f28513a);
            }
        };
        label.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.chip.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskChipController.e(this.f28514a, view);
            }
        });
    }

    public static final void e(TaskChipController taskChipController, View view) {
        taskChipController.r();
    }

    public static final void q(TaskChipController taskChipController) {
        taskChipController.r();
    }

    public static final void v(TaskChipController taskChipController) {
        taskChipController.B();
    }

    public static final void x(TaskChipController taskChipController) {
        taskChipController.B();
    }

    public final void A() {
        Animator animator = this.terminalPopAnim;
        if (animator != null) {
            animator.cancel();
        }
        this.label.setScaleX(1.18f);
        this.label.setScaleY(1.18f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.label, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.18f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.18f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(83L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        objectAnimatorOfPropertyValuesHolder.addListener(new d());
        objectAnimatorOfPropertyValuesHolder.start();
        this.terminalPopAnim = objectAnimatorOfPropertyValuesHolder;
    }

    public final void B() {
        int i10;
        ChipState chipState;
        ChipState chipState2 = this.state;
        ChipState chipStateD = D();
        this.state = chipStateD;
        SweepTextView sweepTextView = this.label;
        int[] iArr = b.$EnumSwitchMapping$1;
        int i11 = iArr[chipStateD.ordinal()];
        boolean z10 = true;
        if (i11 == 1) {
            i10 = R$string.task_detail_chip_takeover;
        } else if (i11 == 2) {
            i10 = R$string.task_detail_chip_thinking;
        } else if (i11 == 3) {
            i10 = R$string.task_detail_chip_executing;
        } else if (i11 == 4) {
            i10 = R$string.task_detail_chip_failed;
        } else {
            if (i11 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = R$string.task_detail_chip_done;
        }
        sweepTextView.setText(i10);
        boolean zA = J0.INSTANCE.a(this.sessionId);
        boolean z11 = this.immersiveHidden || (t(this.state) && (zA || this.suppressInitialTerminal)) || this.stoppedByUser;
        boolean z12 = !z11;
        boolean zD = p.d(this.lastShown, Boolean.valueOf(z12));
        this.label.setVisibility(!z11 ? 0 : 8);
        if (!zD) {
            this.lastShown = Boolean.valueOf(z12);
            InterfaceC5074l<? super Boolean, t> interfaceC5074l = this.onShownChanged;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.valueOf(z12));
            }
        }
        if (!t(chipState2) && t(this.state) && this.label.getVisibility() == 0) {
            A();
        }
        if (!t(this.state)) {
            this.suppressInitialTerminal = false;
        }
        if (z11 || ((chipState = this.state) != ChipState.THINKING && chipState != ChipState.EXECUTING)) {
            z10 = false;
        }
        int i12 = iArr[this.state.ordinal()];
        int i13 = i12 != 4 ? i12 != 5 ? STATIC_TEXT_COLOR : DONE_TEXT_COLOR : FAILED_TEXT_COLOR;
        SweepTextView sweepTextView2 = this.label;
        if (z10) {
            i13 = -1;
        }
        sweepTextView2.setSweepActive(z10, i13);
        if (!t(this.state)) {
            this.label.removeCallbacks(this.autoHideTerminal);
            return;
        }
        if (this.doneAutoHideMs <= 0 || t(chipState2) || zA || this.suppressInitialTerminal) {
            return;
        }
        this.label.removeCallbacks(this.autoHideTerminal);
        this.label.postDelayed(this.autoHideTerminal, this.doneAutoHideMs);
        C4148a.d(TAG, "auto-hide scheduled in " + this.doneAutoHideMs + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
    }

    public final void C() {
        SessionHandler sessionHandler = this.handler;
        if (sessionHandler != null) {
            sessionHandler.L3(sessionHandler.new f());
        }
        this.handler = null;
        if (this.taskCallbackRegistered) {
            TaskModule.INSTANCE.l(this.taskCallback);
            this.taskCallbackRegistered = false;
        }
        this.label.removeCallbacks(this.autoHideTerminal);
        Animator animator = this.terminalPopAnim;
        if (animator != null) {
            animator.cancel();
        }
        this.terminalPopAnim = null;
        this.onShownChanged = null;
        this.lastShown = null;
        SweepTextView.stopSweep$default(this.label, false, 1, null);
        this.label.setOnClickListener(null);
        C4148a.d(TAG, "released", false, 4, null);
    }

    public final ChipState D() {
        return (this.pendingCard || this.awaitingAuthorization) ? ChipState.TAKEOVER : this.replying ? ChipState.EXECUTING : this.awaitingReply ? ChipState.THINKING : this.failed ? ChipState.FAILED : ChipState.DONE;
    }

    public final void E(boolean waiting) {
        if (this.awaitingAuthorization == waiting) {
            return;
        }
        this.awaitingAuthorization = waiting;
        B();
    }

    public final void F(boolean hidden) {
        if (this.immersiveHidden == hidden) {
            return;
        }
        this.immersiveHidden = hidden;
        B();
    }

    public final void G(InterfaceC5074l<? super Boolean, t> interfaceC5074l) {
        this.onShownChanged = interfaceC5074l;
    }

    public final void H(boolean pending) {
        if (this.pendingCard == pending) {
            return;
        }
        this.pendingCard = pending;
        B();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(com.stepos.agentframework.chatcore.SessionHandler r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r0 = "handler"
            kotlin.jvm.internal.p.i(r6, r0)
            java.lang.String r0 = "sessionId"
            kotlin.jvm.internal.p.i(r7, r0)
            java.lang.String r0 = "productKey"
            kotlin.jvm.internal.p.i(r8, r0)
            com.stepos.agentframework.chatcore.SessionHandler r0 = r5.handler
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L19
            r3 = r2
            goto L1a
        L19:
            r3 = r1
        L1a:
            if (r0 != r6) goto L26
            java.lang.String r0 = r5.sessionId
            boolean r0 = kotlin.jvm.internal.p.d(r0, r7)
            if (r0 == 0) goto L26
            r0 = r2
            goto L27
        L26:
            r0 = r1
        L27:
            r5.handler = r6
            r5.sessionId = r7
            r5.productKey = r8
            com.stepos.ailauncher.task.detail.chip.TaskChipController$c r4 = new com.stepos.ailauncher.task.detail.chip.TaskChipController$c
            r4.<init>()
            r6.L3(r4)
            r5.s()
            com.stepos.ailauncher.task.detail.chip.a r6 = com.stepos.ailauncher.task.detail.chip.a.INSTANCE
            boolean r6 = r6.c(r7, r8)
            if (r6 == 0) goto L60
            com.stepos.agentframework.chatcore.session.list.SessionActivityTracker r6 = com.stepos.agentframework.chatcore.session.list.SessionActivityTracker.INSTANCE
            Xa.t r6 = r6.e()
            java.lang.Object r6 = r6.getValue()
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r6.get(r7)
            com.stepos.agentframework.chatcore.session.list.a r6 = (com.stepos.agentframework.chatcore.session.list.SessionChatActivitySnapshot) r6
            if (r6 == 0) goto L59
            com.stepos.agentframework.chatcore.session.list.SessionChatPhase r6 = r6.getPhase()
            goto L5a
        L59:
            r6 = 0
        L5a:
            com.stepos.agentframework.chatcore.session.list.SessionChatPhase r7 = com.stepos.agentframework.chatcore.session.list.SessionChatPhase.REPLYING
            if (r6 != r7) goto L60
            r6 = r2
            goto L61
        L60:
            r6 = r1
        L61:
            if (r6 == 0) goto L69
            r5.suppressInitialTerminal = r1
            r5.armFailWatch = r2
            r5.replying = r2
        L69:
            if (r3 == 0) goto L77
            com.stepos.ailauncher.task.detail.chip.TaskChipController$ChipState r7 = r5.D()
            boolean r7 = r5.t(r7)
            if (r7 == 0) goto L77
            r5.suppressInitialTerminal = r2
        L77:
            if (r0 != 0) goto L7c
            r5.B()
        L7c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.chip.TaskChipController.p(com.stepos.agentframework.chatcore.SessionHandler, java.lang.String, java.lang.String):boolean");
    }

    public final void r() {
        if (t(this.state)) {
            this.label.removeCallbacks(this.autoHideTerminal);
            if (this.sessionId.length() > 0) {
                J0.INSTANCE.c(this.sessionId);
            } else {
                this.suppressInitialTerminal = true;
            }
            B();
        }
    }

    public final void s() {
        if (this.taskCallbackRegistered) {
            return;
        }
        TaskModule.INSTANCE.h(this.taskCallback);
        this.taskCallbackRegistered = true;
    }

    public final boolean t(ChipState chipState) {
        return chipState == ChipState.DONE || chipState == ChipState.FAILED;
    }

    public final void u(ChatMessage message) {
        if (message.getRole() != AgentRole.ASSISTANT) {
            return;
        }
        this.suppressInitialTerminal = false;
        this.awaitingReply = false;
        int i10 = b.$EnumSwitchMapping$0[message.getStatus().ordinal()];
        if (i10 == 1) {
            if (this.armFailWatch) {
                this.failed = true;
            }
            this.replying = false;
        } else if (i10 == 2 || i10 == 3) {
            this.failed = false;
            this.replying = false;
        } else {
            this.replying = true;
            if (this.sessionId.length() > 0) {
                J0.INSTANCE.b(this.sessionId);
            }
        }
        if (message.getStatus().isTerminal()) {
            com.stepos.ailauncher.task.detail.chip.a.INSTANCE.a();
            SessionActivityTracker.INSTANCE.c(this.sessionId);
        }
        if (D() == this.state) {
            return;
        }
        this.label.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.chip.d
            @Override // java.lang.Runnable
            public final void run() {
                TaskChipController.v(this.f28515a);
            }
        });
    }

    public final void w() {
        if (this.armFailWatch) {
            if (this.awaitingReply || this.replying) {
                this.failed = true;
                this.awaitingReply = false;
                this.replying = false;
                com.stepos.ailauncher.task.detail.chip.a.INSTANCE.a();
                SessionActivityTracker.INSTANCE.c(this.sessionId);
                this.label.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.chip.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskChipController.x(this.f28516a);
                    }
                });
            }
        }
    }

    public final void y(String productKey) {
        p.i(productKey, "productKey");
        if (productKey.length() > 0) {
            this.productKey = productKey;
        }
        this.stoppedByUser = false;
        this.suppressInitialTerminal = false;
        this.awaitingReply = true;
        this.replying = false;
        this.pendingCard = false;
        this.failed = false;
        this.armFailWatch = true;
        if (this.sessionId.length() > 0) {
            J0.INSTANCE.b(this.sessionId);
        }
        com.stepos.ailauncher.task.detail.chip.a.INSTANCE.b(this.sessionId, this.productKey);
        SessionActivityTracker.INSTANCE.j(this.sessionId);
        B();
    }

    public final void z() {
        this.stoppedByUser = true;
        this.awaitingReply = false;
        this.replying = false;
        this.pendingCard = false;
        this.awaitingAuthorization = false;
        this.failed = false;
        com.stepos.ailauncher.task.detail.chip.a.INSTANCE.a();
        SessionActivityTracker.INSTANCE.c(this.sessionId);
        B();
    }
}
