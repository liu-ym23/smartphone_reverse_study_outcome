package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$SelectionType", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$SelectionType;", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "MULTI", "NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSelectionSheet$Companion$SelectionType extends Enum<OSelectionSheet$Companion$SelectionType> {
    private static final /* synthetic */ OSelectionSheet$Companion$SelectionType[] $VALUES = null;
    public static final OSelectionSheet$Companion$SelectionType MULTI = null;
    public static final OSelectionSheet$Companion$SelectionType NONE = null;
    public static final OSelectionSheet$Companion$SelectionType SINGLE = null;

    private static final /* synthetic */ OSelectionSheet$Companion$SelectionType[] $values() {
        return new OSelectionSheet$Companion$SelectionType[]{SINGLE, MULTI, NONE};
    }

    static {
        SINGLE = new OSelectionSheet$Companion$SelectionType("SINGLE", 0);
        MULTI = new OSelectionSheet$Companion$SelectionType("MULTI", 1);
        NONE = new OSelectionSheet$Companion$SelectionType("NONE", 2);
        $VALUES = $values();
    }

    private OSelectionSheet$Companion$SelectionType(String r10, int r11) {
        super(r10, r11);
    }

    public static OSelectionSheet$Companion$SelectionType valueOf(String r10) {
        return (OSelectionSheet$Companion$SelectionType) Enum.valueOf(OSelectionSheet$Companion$SelectionType.class, r10);
    }

    public static OSelectionSheet$Companion$SelectionType[] values() {
        return (OSelectionSheet$Companion$SelectionType[]) $VALUES.clone();
    }
}
