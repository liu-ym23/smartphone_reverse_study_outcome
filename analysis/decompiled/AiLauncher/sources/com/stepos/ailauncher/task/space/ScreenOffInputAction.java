package com.stepos.ailauncher.task.space;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/task/space/ScreenOffInputAction;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "DISMISS_IME_PRESERVING_DRAFT_LAYOUT", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOffInputAction {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ScreenOffInputAction[] $VALUES;
    public static final ScreenOffInputAction NONE = new ScreenOffInputAction(ModelFlowMeta.PLAN_NONE, 0);
    public static final ScreenOffInputAction DISMISS_IME_PRESERVING_DRAFT_LAYOUT = new ScreenOffInputAction("DISMISS_IME_PRESERVING_DRAFT_LAYOUT", 1);

    private static final /* synthetic */ ScreenOffInputAction[] $values() {
        return new ScreenOffInputAction[]{NONE, DISMISS_IME_PRESERVING_DRAFT_LAYOUT};
    }

    static {
        ScreenOffInputAction[] screenOffInputActionArr$values = $values();
        $VALUES = screenOffInputActionArr$values;
        $ENTRIES = kotlin.enums.a.a(screenOffInputActionArr$values);
    }

    private ScreenOffInputAction(String str, int i10) {
    }

    public static InterfaceC4149a<ScreenOffInputAction> getEntries() {
        return $ENTRIES;
    }

    public static ScreenOffInputAction valueOf(String str) {
        return (ScreenOffInputAction) Enum.valueOf(ScreenOffInputAction.class, str);
    }

    public static ScreenOffInputAction[] values() {
        return (ScreenOffInputAction[]) $VALUES.clone();
    }
}
