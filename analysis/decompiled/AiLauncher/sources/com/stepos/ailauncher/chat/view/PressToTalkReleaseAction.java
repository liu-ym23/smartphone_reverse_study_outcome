package com.stepos.ailauncher.chat.view;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/view/PressToTalkReleaseAction;", "", "<init>", "(Ljava/lang/String;I)V", "ENTER_GRACE", "FINALIZE_NOW", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PressToTalkReleaseAction {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PressToTalkReleaseAction[] $VALUES;
    public static final PressToTalkReleaseAction ENTER_GRACE = new PressToTalkReleaseAction("ENTER_GRACE", 0);
    public static final PressToTalkReleaseAction FINALIZE_NOW = new PressToTalkReleaseAction("FINALIZE_NOW", 1);

    private static final /* synthetic */ PressToTalkReleaseAction[] $values() {
        return new PressToTalkReleaseAction[]{ENTER_GRACE, FINALIZE_NOW};
    }

    static {
        PressToTalkReleaseAction[] pressToTalkReleaseActionArr$values = $values();
        $VALUES = pressToTalkReleaseActionArr$values;
        $ENTRIES = kotlin.enums.a.a(pressToTalkReleaseActionArr$values);
    }

    private PressToTalkReleaseAction(String str, int i10) {
    }

    public static InterfaceC4149a<PressToTalkReleaseAction> getEntries() {
        return $ENTRIES;
    }

    public static PressToTalkReleaseAction valueOf(String str) {
        return (PressToTalkReleaseAction) Enum.valueOf(PressToTalkReleaseAction.class, str);
    }

    public static PressToTalkReleaseAction[] values() {
        return (PressToTalkReleaseAction[]) $VALUES.clone();
    }
}
