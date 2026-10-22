package com.zyql.intenttaskmanager.bean;

import com.stepos.ailauncher.chat.api.SafetyDecision;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/zyql/intenttaskmanager/bean/Action;", "", "<init>", "(Ljava/lang/String;I)V", "DISPLAY_SWITCH", "TAKE_OVER", "PAUSE_RESUME", "CANCEL", SafetyDecision.REVIEW, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Action {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ Action[] $VALUES;
    public static final Action DISPLAY_SWITCH = new Action("DISPLAY_SWITCH", 0);
    public static final Action TAKE_OVER = new Action("TAKE_OVER", 1);
    public static final Action PAUSE_RESUME = new Action("PAUSE_RESUME", 2);
    public static final Action CANCEL = new Action("CANCEL", 3);
    public static final Action REVIEW = new Action(SafetyDecision.REVIEW, 4);

    private static final /* synthetic */ Action[] $values() {
        return new Action[]{DISPLAY_SWITCH, TAKE_OVER, PAUSE_RESUME, CANCEL, REVIEW};
    }

    static {
        Action[] actionArr$values = $values();
        $VALUES = actionArr$values;
        $ENTRIES = a.a(actionArr$values);
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
