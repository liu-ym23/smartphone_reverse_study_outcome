package com.stepos.agentframework.floatcard.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentframework/floatcard/api/SelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "Single", "Multiple", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SelectionMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SelectionMode[] $VALUES;
    public static final SelectionMode Single = new SelectionMode("Single", 0);
    public static final SelectionMode Multiple = new SelectionMode("Multiple", 1);

    private static final /* synthetic */ SelectionMode[] $values() {
        return new SelectionMode[]{Single, Multiple};
    }

    static {
        SelectionMode[] selectionModeArr$values = $values();
        $VALUES = selectionModeArr$values;
        $ENTRIES = a.a(selectionModeArr$values);
    }

    private SelectionMode(String str, int i10) {
    }

    public static InterfaceC4149a<SelectionMode> getEntries() {
        return $ENTRIES;
    }

    public static SelectionMode valueOf(String str) {
        return (SelectionMode) Enum.valueOf(SelectionMode.class, str);
    }

    public static SelectionMode[] values() {
        return (SelectionMode[]) $VALUES.clone();
    }
}
