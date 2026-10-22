package com.bytedanceos.appstore.buss.entity.item;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/item/ItemType;", "", "(Ljava/lang/String;I)V", "EMPTY", "VIDEO", "BANNER", "BANNER_SMALL", "HORIZONTAL", "HORIZONTAL_LARGE", "VERTICAL", "PAGER_BANNER", "PAGER_BANNER_SMALL", "PAGER_HORIZONTAL", "PAGER_HORIZONTAL_LARGE", "PAGER_VERTICAL", "PAGER_VIDEO", "ENTITY_VIDEO", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum ItemType extends Enum<ItemType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ItemType[] $VALUES = null;
    public static final ItemType BANNER = null;
    public static final ItemType BANNER_SMALL = null;
    public static final ItemType EMPTY = null;
    public static final ItemType ENTITY_VIDEO = null;
    public static final ItemType HORIZONTAL = null;
    public static final ItemType HORIZONTAL_LARGE = null;
    public static final ItemType PAGER_BANNER = null;
    public static final ItemType PAGER_BANNER_SMALL = null;
    public static final ItemType PAGER_HORIZONTAL = null;
    public static final ItemType PAGER_HORIZONTAL_LARGE = null;
    public static final ItemType PAGER_VERTICAL = null;
    public static final ItemType PAGER_VIDEO = null;
    public static final ItemType VERTICAL = null;
    public static final ItemType VIDEO = null;

    private static final /* synthetic */ ItemType[] $values() {
        return new ItemType[]{EMPTY, VIDEO, BANNER, BANNER_SMALL, HORIZONTAL, HORIZONTAL_LARGE, VERTICAL, PAGER_BANNER, PAGER_BANNER_SMALL, PAGER_HORIZONTAL, PAGER_HORIZONTAL_LARGE, PAGER_VERTICAL, PAGER_VIDEO, ENTITY_VIDEO};
    }

    static {
        EMPTY = new ItemType("EMPTY", 0);
        VIDEO = new ItemType("VIDEO", 1);
        BANNER = new ItemType("BANNER", 2);
        BANNER_SMALL = new ItemType("BANNER_SMALL", 3);
        HORIZONTAL = new ItemType("HORIZONTAL", 4);
        HORIZONTAL_LARGE = new ItemType("HORIZONTAL_LARGE", 5);
        VERTICAL = new ItemType("VERTICAL", 6);
        PAGER_BANNER = new ItemType("PAGER_BANNER", 7);
        PAGER_BANNER_SMALL = new ItemType("PAGER_BANNER_SMALL", 8);
        PAGER_HORIZONTAL = new ItemType("PAGER_HORIZONTAL", 9);
        PAGER_HORIZONTAL_LARGE = new ItemType("PAGER_HORIZONTAL_LARGE", 10);
        PAGER_VERTICAL = new ItemType("PAGER_VERTICAL", 11);
        PAGER_VIDEO = new ItemType("PAGER_VIDEO", 12);
        ENTITY_VIDEO = new ItemType("ENTITY_VIDEO", 13);
        ItemType[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = a.a(r10);
    }

    private ItemType(String r10, int r11) {
        super(r10, r11);
    }

    @NotNull
    public static EnumEntries<ItemType> getEntries() {
        return $ENTRIES;
    }

    public static ItemType valueOf(String r10) {
        return (ItemType) Enum.valueOf(ItemType.class, r10);
    }

    public static ItemType[] values() {
        return (ItemType[]) $VALUES.clone();
    }
}
