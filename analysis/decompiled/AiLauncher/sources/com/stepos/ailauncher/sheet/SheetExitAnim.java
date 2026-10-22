package com.stepos.ailauncher.sheet;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "SLIDE_DOWN", "NAV_HANDLE", "MorphToBar", "SPRING_SCALE_DOWN", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SheetExitAnim {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SheetExitAnim[] $VALUES;
    public static final SheetExitAnim NONE = new SheetExitAnim(ModelFlowMeta.PLAN_NONE, 0);
    public static final SheetExitAnim SLIDE_DOWN = new SheetExitAnim("SLIDE_DOWN", 1);
    public static final SheetExitAnim NAV_HANDLE = new SheetExitAnim("NAV_HANDLE", 2);
    public static final SheetExitAnim MorphToBar = new SheetExitAnim("MorphToBar", 3);
    public static final SheetExitAnim SPRING_SCALE_DOWN = new SheetExitAnim("SPRING_SCALE_DOWN", 4);

    private static final /* synthetic */ SheetExitAnim[] $values() {
        return new SheetExitAnim[]{NONE, SLIDE_DOWN, NAV_HANDLE, MorphToBar, SPRING_SCALE_DOWN};
    }

    static {
        SheetExitAnim[] sheetExitAnimArr$values = $values();
        $VALUES = sheetExitAnimArr$values;
        $ENTRIES = kotlin.enums.a.a(sheetExitAnimArr$values);
    }

    private SheetExitAnim(String str, int i10) {
    }

    public static InterfaceC4149a<SheetExitAnim> getEntries() {
        return $ENTRIES;
    }

    public static SheetExitAnim valueOf(String str) {
        return (SheetExitAnim) Enum.valueOf(SheetExitAnim.class, str);
    }

    public static SheetExitAnim[] values() {
        return (SheetExitAnim[]) $VALUES.clone();
    }
}
