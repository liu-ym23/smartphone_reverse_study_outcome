package com.obric.ui.popover;

import kotlin.Metadata;

/* JADX INFO: compiled from: ItemType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/ui/popover/ItemType;", "", "(Ljava/lang/String;I)V", "TEXT", "FILTERS", "TEXT_WITH_BADGE", "TEXT_WITH_ARROW", "DIVIDER", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum ItemType extends Enum<ItemType> {
    private static final /* synthetic */ ItemType[] $VALUES = null;
    public static final ItemType DIVIDER = null;
    public static final ItemType FILTERS = null;
    public static final ItemType TEXT = null;
    public static final ItemType TEXT_WITH_ARROW = null;
    public static final ItemType TEXT_WITH_BADGE = null;

    private static final /* synthetic */ ItemType[] $values() {
        return new ItemType[]{TEXT, FILTERS, TEXT_WITH_BADGE, TEXT_WITH_ARROW, DIVIDER};
    }

    public static ItemType valueOf(String r1) {
        return (ItemType) Enum.valueOf(ItemType.class, r1);
    }

    public static ItemType[] values() {
        return (ItemType[]) $VALUES.clone();
    }

    private ItemType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        TEXT = new ItemType("TEXT", 0);
        FILTERS = new ItemType("FILTERS", 1);
        TEXT_WITH_BADGE = new ItemType("TEXT_WITH_BADGE", 2);
        TEXT_WITH_ARROW = new ItemType("TEXT_WITH_ARROW", 3);
        DIVIDER = new ItemType("DIVIDER", 4);
        $VALUES = $values();
    }
}
