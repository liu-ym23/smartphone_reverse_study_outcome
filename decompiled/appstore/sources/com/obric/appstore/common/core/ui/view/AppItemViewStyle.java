package com.obric.appstore.common.core.ui.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/appstore/common/core/ui/view/AppItemViewStyle;", "", "(Ljava/lang/String;I)V", "DEFAULT", "LARGE_IMAGE", "PAGER_HOR", "SHOW_INDEX", "APP_INFO", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum AppItemViewStyle extends Enum<AppItemViewStyle> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AppItemViewStyle[] $VALUES = null;
    public static final AppItemViewStyle APP_INFO = null;
    public static final AppItemViewStyle DEFAULT = null;
    public static final AppItemViewStyle LARGE_IMAGE = null;
    public static final AppItemViewStyle PAGER_HOR = null;
    public static final AppItemViewStyle SHOW_INDEX = null;

    private static final /* synthetic */ AppItemViewStyle[] $values() {
        return new AppItemViewStyle[]{DEFAULT, LARGE_IMAGE, PAGER_HOR, SHOW_INDEX, APP_INFO};
    }

    static {
        DEFAULT = new AppItemViewStyle("DEFAULT", 0);
        LARGE_IMAGE = new AppItemViewStyle("LARGE_IMAGE", 1);
        PAGER_HOR = new AppItemViewStyle("PAGER_HOR", 2);
        SHOW_INDEX = new AppItemViewStyle("SHOW_INDEX", 3);
        APP_INFO = new AppItemViewStyle("APP_INFO", 4);
        AppItemViewStyle[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = kotlin.enums.a.a(r10);
    }

    private AppItemViewStyle(String r10, int r11) {
        super(r10, r11);
    }

    @NotNull
    public static EnumEntries<AppItemViewStyle> getEntries() {
        return $ENTRIES;
    }

    public static AppItemViewStyle valueOf(String r10) {
        return (AppItemViewStyle) Enum.valueOf(AppItemViewStyle.class, r10);
    }

    public static AppItemViewStyle[] values() {
        return (AppItemViewStyle[]) $VALUES.clone();
    }
}
