package com.byted.cast.common.bean;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum BytecastBrowseType extends Enum<BytecastBrowseType> {
    private static final /* synthetic */ BytecastBrowseType[] $VALUES = null;
    public static final BytecastBrowseType ALL = null;
    public static final BytecastBrowseType SELECTED = null;
    private String value;

    static {
        BytecastBrowseType r100 = new BytecastBrowseType(AccountType.ALL, 0, "all");
        ALL = r100;
        BytecastBrowseType r101 = new BytecastBrowseType("SELECTED", 1, "selected");
        SELECTED = r101;
        $VALUES = new BytecastBrowseType[]{r100, r101};
    }

    public static BytecastBrowseType[] values() {
        return (BytecastBrowseType[]) $VALUES.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static BytecastBrowseType valueOf(String r100) {
        return (BytecastBrowseType) a.a(BytecastBrowseType.class, r100);
    }

    private BytecastBrowseType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
