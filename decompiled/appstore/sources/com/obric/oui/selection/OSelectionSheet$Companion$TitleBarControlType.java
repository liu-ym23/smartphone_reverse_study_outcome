package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "<init>", "(Ljava/lang/String;I)V", "CLOSE_ONLY", "CLOSE_AND_CONFIRM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSelectionSheet$Companion$TitleBarControlType extends Enum<OSelectionSheet$Companion$TitleBarControlType> {
    private static final /* synthetic */ OSelectionSheet$Companion$TitleBarControlType[] $VALUES = null;
    public static final OSelectionSheet$Companion$TitleBarControlType CLOSE_AND_CONFIRM = null;
    public static final OSelectionSheet$Companion$TitleBarControlType CLOSE_ONLY = null;

    private static final /* synthetic */ OSelectionSheet$Companion$TitleBarControlType[] $values() {
        return new OSelectionSheet$Companion$TitleBarControlType[]{CLOSE_ONLY, CLOSE_AND_CONFIRM};
    }

    static {
        CLOSE_ONLY = new OSelectionSheet$Companion$TitleBarControlType("CLOSE_ONLY", 0);
        CLOSE_AND_CONFIRM = new OSelectionSheet$Companion$TitleBarControlType("CLOSE_AND_CONFIRM", 1);
        $VALUES = $values();
    }

    private OSelectionSheet$Companion$TitleBarControlType(String r10, int r11) {
        super(r10, r11);
    }

    public static OSelectionSheet$Companion$TitleBarControlType valueOf(String r10) {
        return (OSelectionSheet$Companion$TitleBarControlType) Enum.valueOf(OSelectionSheet$Companion$TitleBarControlType.class, r10);
    }

    public static OSelectionSheet$Companion$TitleBarControlType[] values() {
        return (OSelectionSheet$Companion$TitleBarControlType[]) $VALUES.clone();
    }
}
