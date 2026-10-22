package com.bytedanceos.appstore.buss.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedanceos/appstore/buss/constant/NavItemType;", "", "(Ljava/lang/String;I)V", "NAV_UNKNOWN_TYPE", "NAV_HEAD_TYPE", "NAV_TITLE_TYPE", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum NavItemType extends Enum<NavItemType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NavItemType[] $VALUES = null;
    public static final NavItemType NAV_HEAD_TYPE = null;
    public static final NavItemType NAV_TITLE_TYPE = null;
    public static final NavItemType NAV_UNKNOWN_TYPE = null;

    private static final /* synthetic */ NavItemType[] $values() {
        return new NavItemType[]{NAV_UNKNOWN_TYPE, NAV_HEAD_TYPE, NAV_TITLE_TYPE};
    }

    static {
        NAV_UNKNOWN_TYPE = new NavItemType("NAV_UNKNOWN_TYPE", 0);
        NAV_HEAD_TYPE = new NavItemType("NAV_HEAD_TYPE", 1);
        NAV_TITLE_TYPE = new NavItemType("NAV_TITLE_TYPE", 2);
        NavItemType[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = a.a(r10);
    }

    private NavItemType(String r10, int r11) {
        super(r10, r11);
    }

    @NotNull
    public static EnumEntries<NavItemType> getEntries() {
        return $ENTRIES;
    }

    public static NavItemType valueOf(String r10) {
        return (NavItemType) Enum.valueOf(NavItemType.class, r10);
    }

    public static NavItemType[] values() {
        return (NavItemType[]) $VALUES.clone();
    }
}
