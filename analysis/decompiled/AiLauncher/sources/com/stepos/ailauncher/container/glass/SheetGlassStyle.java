package com.stepos.ailauncher.container.glass;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "", "<init>", "(Ljava/lang/String;I)V", "HALF", "FULL", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SheetGlassStyle {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SheetGlassStyle[] $VALUES;
    public static final SheetGlassStyle HALF = new SheetGlassStyle("HALF", 0);
    public static final SheetGlassStyle FULL = new SheetGlassStyle("FULL", 1);

    private static final /* synthetic */ SheetGlassStyle[] $values() {
        return new SheetGlassStyle[]{HALF, FULL};
    }

    static {
        SheetGlassStyle[] sheetGlassStyleArr$values = $values();
        $VALUES = sheetGlassStyleArr$values;
        $ENTRIES = kotlin.enums.a.a(sheetGlassStyleArr$values);
    }

    private SheetGlassStyle(String str, int i10) {
    }

    public static InterfaceC4149a<SheetGlassStyle> getEntries() {
        return $ENTRIES;
    }

    public static SheetGlassStyle valueOf(String str) {
        return (SheetGlassStyle) Enum.valueOf(SheetGlassStyle.class, str);
    }

    public static SheetGlassStyle[] values() {
        return (SheetGlassStyle[]) $VALUES.clone();
    }
}
