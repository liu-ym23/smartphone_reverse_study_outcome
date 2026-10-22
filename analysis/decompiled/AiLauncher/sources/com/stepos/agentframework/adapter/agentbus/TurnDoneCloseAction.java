package com.stepos.agentframework.adapter.agentbus;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/TurnDoneCloseAction;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE_NOW", "ARM_GRACE", "AWAIT_REPLY", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TurnDoneCloseAction {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TurnDoneCloseAction[] $VALUES;
    public static final TurnDoneCloseAction CLOSE_NOW = new TurnDoneCloseAction("CLOSE_NOW", 0);
    public static final TurnDoneCloseAction ARM_GRACE = new TurnDoneCloseAction("ARM_GRACE", 1);
    public static final TurnDoneCloseAction AWAIT_REPLY = new TurnDoneCloseAction("AWAIT_REPLY", 2);

    private static final /* synthetic */ TurnDoneCloseAction[] $values() {
        return new TurnDoneCloseAction[]{CLOSE_NOW, ARM_GRACE, AWAIT_REPLY};
    }

    static {
        TurnDoneCloseAction[] turnDoneCloseActionArr$values = $values();
        $VALUES = turnDoneCloseActionArr$values;
        $ENTRIES = kotlin.enums.a.a(turnDoneCloseActionArr$values);
    }

    private TurnDoneCloseAction(String str, int i10) {
    }

    public static InterfaceC4149a<TurnDoneCloseAction> getEntries() {
        return $ENTRIES;
    }

    public static TurnDoneCloseAction valueOf(String str) {
        return (TurnDoneCloseAction) Enum.valueOf(TurnDoneCloseAction.class, str);
    }

    public static TurnDoneCloseAction[] values() {
        return (TurnDoneCloseAction[]) $VALUES.clone();
    }
}
