package com.obric.appstore.ui.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/appstore/ui/adapter/ItemType;", "", "(Ljava/lang/String;I)V", "HOR_PAGER_HORIZONTAL_APP", "GRID_CATEGORY", "FIXED_ENTRANCE", "APP", "HOME_CARD", "SEARCH_BAR", "SUGGEST_WORD", "TITLE", "UPDATE_APP_TITLE", "IGNORE_UPDATE_TITLE", "SIGN_NOT_MATCH", "SPACE", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum ItemType extends Enum<ItemType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ItemType[] $VALUES = null;
    public static final ItemType APP = null;
    public static final ItemType FIXED_ENTRANCE = null;
    public static final ItemType GRID_CATEGORY = null;
    public static final ItemType HOME_CARD = null;
    public static final ItemType HOR_PAGER_HORIZONTAL_APP = null;
    public static final ItemType IGNORE_UPDATE_TITLE = null;
    public static final ItemType SEARCH_BAR = null;
    public static final ItemType SIGN_NOT_MATCH = null;
    public static final ItemType SPACE = null;
    public static final ItemType SUGGEST_WORD = null;
    public static final ItemType TITLE = null;
    public static final ItemType UPDATE_APP_TITLE = null;

    private static final /* synthetic */ ItemType[] $values() {
        return new ItemType[]{HOR_PAGER_HORIZONTAL_APP, GRID_CATEGORY, FIXED_ENTRANCE, APP, HOME_CARD, SEARCH_BAR, SUGGEST_WORD, TITLE, UPDATE_APP_TITLE, IGNORE_UPDATE_TITLE, SIGN_NOT_MATCH, SPACE};
    }

    static {
        HOR_PAGER_HORIZONTAL_APP = new ItemType("HOR_PAGER_HORIZONTAL_APP", 0);
        GRID_CATEGORY = new ItemType("GRID_CATEGORY", 1);
        FIXED_ENTRANCE = new ItemType("FIXED_ENTRANCE", 2);
        APP = new ItemType("APP", 3);
        HOME_CARD = new ItemType("HOME_CARD", 4);
        SEARCH_BAR = new ItemType("SEARCH_BAR", 5);
        SUGGEST_WORD = new ItemType("SUGGEST_WORD", 6);
        TITLE = new ItemType("TITLE", 7);
        UPDATE_APP_TITLE = new ItemType("UPDATE_APP_TITLE", 8);
        IGNORE_UPDATE_TITLE = new ItemType("IGNORE_UPDATE_TITLE", 9);
        SIGN_NOT_MATCH = new ItemType("SIGN_NOT_MATCH", 10);
        SPACE = new ItemType("SPACE", 11);
        ItemType[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = kotlin.enums.a.a(r10);
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
