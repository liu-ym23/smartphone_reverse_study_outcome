package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$ItemStyle", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$ItemStyle;", "<init>", "(Ljava/lang/String;I)V", "TEXT_ONLY", "ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSelectionSheet$Companion$ItemStyle extends Enum<OSelectionSheet$Companion$ItemStyle> {
    private static final /* synthetic */ OSelectionSheet$Companion$ItemStyle[] $VALUES = null;
    public static final OSelectionSheet$Companion$ItemStyle ICON_AND_TEXT = null;
    public static final OSelectionSheet$Companion$ItemStyle TEXT_ONLY = null;

    private static final /* synthetic */ OSelectionSheet$Companion$ItemStyle[] $values() {
        return new OSelectionSheet$Companion$ItemStyle[]{TEXT_ONLY, ICON_AND_TEXT};
    }

    static {
        TEXT_ONLY = new OSelectionSheet$Companion$ItemStyle("TEXT_ONLY", 0);
        ICON_AND_TEXT = new OSelectionSheet$Companion$ItemStyle("ICON_AND_TEXT", 1);
        $VALUES = $values();
    }

    private OSelectionSheet$Companion$ItemStyle(String r10, int r11) {
        super(r10, r11);
    }

    public static OSelectionSheet$Companion$ItemStyle valueOf(String r10) {
        return (OSelectionSheet$Companion$ItemStyle) Enum.valueOf(OSelectionSheet$Companion$ItemStyle.class, r10);
    }

    public static OSelectionSheet$Companion$ItemStyle[] values() {
        return (OSelectionSheet$Companion$ItemStyle[]) $VALUES.clone();
    }
}
