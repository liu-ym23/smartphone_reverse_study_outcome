package com.stepos.ailauncher.chat.view.input;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002PQB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010!\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#J5\u0010)\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J'\u0010-\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\t¢\u0006\u0004\b-\u0010.J5\u00104\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0018¢\u0006\u0004\b4\u00105J5\u0010;\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0018¢\u0006\u0004\b;\u00105J\u001d\u0010>\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t¢\u0006\u0004\b>\u0010?J3\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180A¢\u0006\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00188\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020G8\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010IR\u0014\u0010K\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020G8\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010IR\u0014\u0010N\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010FR\u0014\u0010O\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010F¨\u0006R"}, d2 = {"Lcom/stepos/ailauncher/chat/view/input/InputBarMotionSpec;", "", "<init>", "()V", "", "t", "c", "(F)F", Const.INTENT_KEY_PKGNAME, "", "targetExpanded", "visualProgress", "f", "(ZF)Z", "wasVisible", "nowVisible", "Lcom/stepos/ailauncher/chat/view/input/InputBarMotionSpec$SendTransition;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(ZZ)Lcom/stepos/ailauncher/chat/view/input/InputBarMotionSpec$SendTransition;", "sameState", "animated", "Lcom/stepos/ailauncher/chat/view/input/InputBarMotionSpec$FormTransitionDriver;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ZZ)Lcom/stepos/ailauncher/chat/view/input/InputBarMotionSpec$FormTransitionDriver;", "", "lineCount", "maxVisibleLines", "e", "(II)Z", "scrollY", "m", "(III)Z", "runningTarget", "requestedTarget", "l", "(Ljava/lang/Integer;I)Z", "hasText", "hasExplicitNewline", "textWidthPx", "unfocusedTextWidthPx", "wasExpanded", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(ZZFIZ)Z", "logicalUnfocused", "snappedToUnfocused", "k", "(ZFZ)Z", "inputBackgroundHeightPx", "inputBackgroundTopMarginPx", "actionRowTopMarginPx", "actionRowHeightPx", "actionRowBottomMarginPx", Const.INTENT_KEY_UMID, "(IIIII)I", "lastVisibleLineBottomPx", "compoundPaddingTopPx", "compoundPaddingBottomPx", "containerPaddingTopPx", "containerPaddingBottomPx", Const.INTENT_KEY_APIKEY, "hasRealOverflowNow", "wasRealOverflowing", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ZZ)Z", "viewportHeightPx", "Lkotlin/Function1;", "lineBottomPx", "n", "(IILp9/l;)Ljava/lang/Integer;", "PLUS_SHIFT_DP", "I", "", "PLUS_SHIFT_DURATION_MS", "J", "SEND_REVEAL_DURATION_MS", "SEND_SCALE_FROM", "F", "BAR_GROW_DURATION_MS", "SINGLE_ROW_BAR_HEIGHT_DP", "MULTI_ROW_BASE_HEIGHT_DP", "SendTransition", "FormTransitionDriver", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InputBarMotionSpec {
    public static final long BAR_GROW_DURATION_MS = 100;
    public static final InputBarMotionSpec INSTANCE = new InputBarMotionSpec();
    private static final int MULTI_ROW_BASE_HEIGHT_DP = 74;
    public static final int PLUS_SHIFT_DP = 44;
    public static final long PLUS_SHIFT_DURATION_MS = 150;
    public static final long SEND_REVEAL_DURATION_MS = 150;
    public static final float SEND_SCALE_FROM = 0.6f;
    private static final int SINGLE_ROW_BAR_HEIGHT_DP = 56;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/view/input/InputBarMotionSpec$FormTransitionDriver;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "SNAP", "MANUAL_PROGRESS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FormTransitionDriver {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ FormTransitionDriver[] $VALUES;
        public static final FormTransitionDriver NONE = new FormTransitionDriver(ModelFlowMeta.PLAN_NONE, 0);
        public static final FormTransitionDriver SNAP = new FormTransitionDriver("SNAP", 1);
        public static final FormTransitionDriver MANUAL_PROGRESS = new FormTransitionDriver("MANUAL_PROGRESS", 2);

        private static final /* synthetic */ FormTransitionDriver[] $values() {
            return new FormTransitionDriver[]{NONE, SNAP, MANUAL_PROGRESS};
        }

        static {
            FormTransitionDriver[] formTransitionDriverArr$values = $values();
            $VALUES = formTransitionDriverArr$values;
            $ENTRIES = kotlin.enums.a.a(formTransitionDriverArr$values);
        }

        private FormTransitionDriver(String str, int i10) {
        }

        public static InterfaceC4149a<FormTransitionDriver> getEntries() {
            return $ENTRIES;
        }

        public static FormTransitionDriver valueOf(String str) {
            return (FormTransitionDriver) Enum.valueOf(FormTransitionDriver.class, str);
        }

        public static FormTransitionDriver[] values() {
            return (FormTransitionDriver[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/view/input/InputBarMotionSpec$SendTransition;", "", "<init>", "(Ljava/lang/String;I)V", "PLAY_IN", "PLAY_OUT", ModelFlowMeta.PLAN_NONE, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SendTransition {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ SendTransition[] $VALUES;
        public static final SendTransition PLAY_IN = new SendTransition("PLAY_IN", 0);
        public static final SendTransition PLAY_OUT = new SendTransition("PLAY_OUT", 1);
        public static final SendTransition NONE = new SendTransition(ModelFlowMeta.PLAN_NONE, 2);

        private static final /* synthetic */ SendTransition[] $values() {
            return new SendTransition[]{PLAY_IN, PLAY_OUT, NONE};
        }

        static {
            SendTransition[] sendTransitionArr$values = $values();
            $VALUES = sendTransitionArr$values;
            $ENTRIES = kotlin.enums.a.a(sendTransitionArr$values);
        }

        private SendTransition(String str, int i10) {
        }

        public static InterfaceC4149a<SendTransition> getEntries() {
            return $ENTRIES;
        }

        public static SendTransition valueOf(String str) {
            return (SendTransition) Enum.valueOf(SendTransition.class, str);
        }

        public static SendTransition[] values() {
            return (SendTransition[]) $VALUES.clone();
        }
    }

    public final int a(int lastVisibleLineBottomPx, int compoundPaddingTopPx, int compoundPaddingBottomPx, int containerPaddingTopPx, int containerPaddingBottomPx) {
        return lastVisibleLineBottomPx + compoundPaddingTopPx + compoundPaddingBottomPx + containerPaddingTopPx + containerPaddingBottomPx;
    }

    public final float b(float t10) {
        float fM = C5685n.m(t10, 0.0f, 1.0f);
        return fM * fM * (3.0f - (fM * 2.0f));
    }

    public final float c(float t10) {
        float fM = 1.0f - C5685n.m(t10, 0.0f, 1.0f);
        return 1.0f - ((fM * fM) * fM);
    }

    public final int d(int inputBackgroundHeightPx, int inputBackgroundTopMarginPx, int actionRowTopMarginPx, int actionRowHeightPx, int actionRowBottomMarginPx) {
        return inputBackgroundTopMarginPx + inputBackgroundHeightPx + actionRowTopMarginPx + actionRowHeightPx + actionRowBottomMarginPx;
    }

    public final boolean e(int lineCount, int maxVisibleLines) {
        return maxVisibleLines > 0 && lineCount > maxVisibleLines;
    }

    public final boolean f(boolean targetExpanded, float visualProgress) {
        return targetExpanded ? visualProgress >= 1.0f : visualProgress <= 0.0f;
    }

    public final FormTransitionDriver g(boolean sameState, boolean animated) {
        return (sameState && animated) ? FormTransitionDriver.NONE : !animated ? FormTransitionDriver.SNAP : FormTransitionDriver.MANUAL_PROGRESS;
    }

    public final SendTransition h(boolean wasVisible, boolean nowVisible) {
        return wasVisible == nowVisible ? SendTransition.NONE : nowVisible ? SendTransition.PLAY_IN : SendTransition.PLAY_OUT;
    }

    public final boolean i(boolean hasRealOverflowNow, boolean wasRealOverflowing) {
        return (hasRealOverflowNow || wasRealOverflowing) ? false : true;
    }

    public final boolean j(boolean hasText, boolean hasExplicitNewline, float textWidthPx, int unfocusedTextWidthPx, boolean wasExpanded) {
        if (!hasText) {
            return false;
        }
        if (hasExplicitNewline) {
            return true;
        }
        return unfocusedTextWidthPx > 0 ? textWidthPx > ((float) unfocusedTextWidthPx) : wasExpanded;
    }

    public final boolean k(boolean logicalUnfocused, float visualProgress, boolean snappedToUnfocused) {
        if (logicalUnfocused) {
            return visualProgress <= 0.0f || snappedToUnfocused;
        }
        return false;
    }

    public final boolean l(Integer runningTarget, int requestedTarget) {
        return runningTarget != null && runningTarget.intValue() == requestedTarget;
    }

    public final boolean m(int lineCount, int maxVisibleLines, int scrollY) {
        return e(lineCount, maxVisibleLines) && scrollY > 0;
    }

    public final Integer n(int viewportHeightPx, int lineCount, InterfaceC5074l<? super Integer, Integer> lineBottomPx) {
        p.i(lineBottomPx, "lineBottomPx");
        if (viewportHeightPx <= 0 || lineCount <= 0 || lineBottomPx.invoke(Integer.valueOf(lineCount - 1)).intValue() <= viewportHeightPx) {
            return null;
        }
        for (int i10 = lineCount - 2; -1 < i10; i10--) {
            int iIntValue = lineBottomPx.invoke(Integer.valueOf(i10)).intValue();
            if (iIntValue <= viewportHeightPx) {
                return Integer.valueOf(iIntValue);
            }
        }
        return null;
    }
}
