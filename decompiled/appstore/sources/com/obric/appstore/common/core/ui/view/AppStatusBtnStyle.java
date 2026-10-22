package com.obric.appstore.common.core.ui.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/appstore/common/core/ui/view/AppStatusBtnStyle;", "", "(Ljava/lang/String;I)V", "DEFAULT", "ACCENT", "DETAIL", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum AppStatusBtnStyle extends Enum<AppStatusBtnStyle> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AppStatusBtnStyle[] $VALUES = null;
    public static final AppStatusBtnStyle ACCENT = null;
    public static final AppStatusBtnStyle DEFAULT = null;
    public static final AppStatusBtnStyle DETAIL = null;

    private static final /* synthetic */ AppStatusBtnStyle[] $values() {
        return new AppStatusBtnStyle[]{DEFAULT, ACCENT, DETAIL};
    }

    static {
        DEFAULT = new AppStatusBtnStyle("DEFAULT", 0);
        ACCENT = new AppStatusBtnStyle("ACCENT", 1);
        DETAIL = new AppStatusBtnStyle("DETAIL", 2);
        AppStatusBtnStyle[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = kotlin.enums.a.a(r10);
    }

    private AppStatusBtnStyle(String r10, int r11) {
        super(r10, r11);
    }

    @NotNull
    public static EnumEntries<AppStatusBtnStyle> getEntries() {
        return $ENTRIES;
    }

    public static AppStatusBtnStyle valueOf(String r10) {
        return (AppStatusBtnStyle) Enum.valueOf(AppStatusBtnStyle.class, r10);
    }

    public static AppStatusBtnStyle[] values() {
        return (AppStatusBtnStyle[]) $VALUES.clone();
    }
}
