package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/view/InputBarListenTapPolicy;", "", "<init>", "()V", "", "listening", com.stepos.ailauncher.chat.util.g.REASON_RECORDING, "startPending", "pushToTalk", "Lcom/stepos/ailauncher/chat/view/InputBarListenTapPolicy$Action;", Const.INTENT_KEY_APIKEY, "(ZZZZ)Lcom/stepos/ailauncher/chat/view/InputBarListenTapPolicy$Action;", "Action", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InputBarListenTapPolicy {
    public static final InputBarListenTapPolicy INSTANCE = new InputBarListenTapPolicy();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/view/InputBarListenTapPolicy$Action;", "", "<init>", "(Ljava/lang/String;I)V", "FINALIZE", "CANCEL_PENDING", "CONSUME", "PASS_THROUGH", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Action {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Action[] $VALUES;
        public static final Action FINALIZE = new Action("FINALIZE", 0);
        public static final Action CANCEL_PENDING = new Action("CANCEL_PENDING", 1);
        public static final Action CONSUME = new Action("CONSUME", 2);
        public static final Action PASS_THROUGH = new Action("PASS_THROUGH", 3);

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{FINALIZE, CANCEL_PENDING, CONSUME, PASS_THROUGH};
        }

        static {
            Action[] actionArr$values = $values();
            $VALUES = actionArr$values;
            $ENTRIES = kotlin.enums.a.a(actionArr$values);
        }

        private Action(String str, int i10) {
        }

        public static InterfaceC4149a<Action> getEntries() {
            return $ENTRIES;
        }

        public static Action valueOf(String str) {
            return (Action) Enum.valueOf(Action.class, str);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }
    }

    public final Action a(boolean listening, boolean recording, boolean startPending, boolean pushToTalk) {
        return (pushToTalk || !listening) ? Action.PASS_THROUGH : startPending ? Action.CANCEL_PENDING : recording ? Action.FINALIZE : Action.CONSUME;
    }
}
