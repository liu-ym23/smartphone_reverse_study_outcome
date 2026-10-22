package com.obric.ui.dialog.selection;

import kotlin.Metadata;

/* JADX INFO: compiled from: SelectionType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/ui/dialog/selection/SelectionType;", "", "(Ljava/lang/String;I)V", "SINGLE", "MULTI", "NONE", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum SelectionType extends Enum<SelectionType> {
    private static final /* synthetic */ SelectionType[] $VALUES = null;
    public static final SelectionType MULTI = null;
    public static final SelectionType NONE = null;
    public static final SelectionType SINGLE = null;

    private static final /* synthetic */ SelectionType[] $values() {
        return new SelectionType[]{SINGLE, MULTI, NONE};
    }

    public static SelectionType valueOf(String r1) {
        return (SelectionType) Enum.valueOf(SelectionType.class, r1);
    }

    public static SelectionType[] values() {
        return (SelectionType[]) $VALUES.clone();
    }

    private SelectionType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        SINGLE = new SelectionType("SINGLE", 0);
        MULTI = new SelectionType("MULTI", 1);
        NONE = new SelectionType("NONE", 2);
        $VALUES = $values();
    }
}
