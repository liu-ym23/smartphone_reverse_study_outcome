package com.stepos.ailauncher.chat.wake;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/LockedGateAction;", "", "<init>", "(Ljava/lang/String;I)V", "PROMPT_DIRECTLY", "UNLOCK_THEN_PROMPT", "NOTICE_ONLY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LockedGateAction {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LockedGateAction[] $VALUES;
    public static final LockedGateAction PROMPT_DIRECTLY = new LockedGateAction("PROMPT_DIRECTLY", 0);
    public static final LockedGateAction UNLOCK_THEN_PROMPT = new LockedGateAction("UNLOCK_THEN_PROMPT", 1);
    public static final LockedGateAction NOTICE_ONLY = new LockedGateAction("NOTICE_ONLY", 2);

    private static final /* synthetic */ LockedGateAction[] $values() {
        return new LockedGateAction[]{PROMPT_DIRECTLY, UNLOCK_THEN_PROMPT, NOTICE_ONLY};
    }

    static {
        LockedGateAction[] lockedGateActionArr$values = $values();
        $VALUES = lockedGateActionArr$values;
        $ENTRIES = kotlin.enums.a.a(lockedGateActionArr$values);
    }

    private LockedGateAction(String str, int i10) {
    }

    public static InterfaceC4149a<LockedGateAction> getEntries() {
        return $ENTRIES;
    }

    public static LockedGateAction valueOf(String str) {
        return (LockedGateAction) Enum.valueOf(LockedGateAction.class, str);
    }

    public static LockedGateAction[] values() {
        return (LockedGateAction[]) $VALUES.clone();
    }
}
