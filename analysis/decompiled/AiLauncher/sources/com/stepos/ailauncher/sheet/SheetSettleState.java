package com.stepos.ailauncher.sheet;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sheet/SheetSettleState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "MINIFY", "HALF", "FULL", "IMMERSIVE", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SheetSettleState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SheetSettleState[] $VALUES;
    public static final SheetSettleState HIDDEN = new SheetSettleState("HIDDEN", 0);
    public static final SheetSettleState MINIFY = new SheetSettleState("MINIFY", 1);
    public static final SheetSettleState HALF = new SheetSettleState("HALF", 2);
    public static final SheetSettleState FULL = new SheetSettleState("FULL", 3);
    public static final SheetSettleState IMMERSIVE = new SheetSettleState("IMMERSIVE", 4);

    private static final /* synthetic */ SheetSettleState[] $values() {
        return new SheetSettleState[]{HIDDEN, MINIFY, HALF, FULL, IMMERSIVE};
    }

    static {
        SheetSettleState[] sheetSettleStateArr$values = $values();
        $VALUES = sheetSettleStateArr$values;
        $ENTRIES = kotlin.enums.a.a(sheetSettleStateArr$values);
    }

    private SheetSettleState(String str, int i10) {
    }

    public static InterfaceC4149a<SheetSettleState> getEntries() {
        return $ENTRIES;
    }

    public static SheetSettleState valueOf(String str) {
        return (SheetSettleState) Enum.valueOf(SheetSettleState.class, str);
    }

    public static SheetSettleState[] values() {
        return (SheetSettleState[]) $VALUES.clone();
    }
}
