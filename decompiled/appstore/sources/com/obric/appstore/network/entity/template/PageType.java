package com.obric.appstore.network.entity.template;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/appstore/network/entity/template/PageType;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "HOMEPAGE", "RANK_APP_PAGE", "RANK_GAME_PAGE", "APPS_PAGE", "GAME_PAGE", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum PageType extends Enum<PageType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PageType[] $VALUES = null;
    public static final PageType APPS_PAGE = null;
    public static final PageType GAME_PAGE = null;
    public static final PageType HOMEPAGE = null;
    public static final PageType RANK_APP_PAGE = null;
    public static final PageType RANK_GAME_PAGE = null;
    public static final PageType UNKNOWN = null;

    @NotNull
    private final String value;

    private static final /* synthetic */ PageType[] $values() {
        return new PageType[]{UNKNOWN, HOMEPAGE, RANK_APP_PAGE, RANK_GAME_PAGE, APPS_PAGE, GAME_PAGE};
    }

    static {
        UNKNOWN = new PageType("UNKNOWN", 0, "");
        HOMEPAGE = new PageType("HOMEPAGE", 1, "homepage");
        RANK_APP_PAGE = new PageType("RANK_APP_PAGE", 2, "app_rank");
        RANK_GAME_PAGE = new PageType("RANK_GAME_PAGE", 3, "game_rank");
        APPS_PAGE = new PageType("APPS_PAGE", 4, "app_page");
        GAME_PAGE = new PageType("GAME_PAGE", 5, "game_page");
        PageType[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = a.a(r10);
    }

    private PageType(String r10, int r11, String r12) {
        super(r10, r11);
        this.value = r12;
    }

    @NotNull
    public static EnumEntries<PageType> getEntries() {
        return $ENTRIES;
    }

    public static PageType valueOf(String r10) {
        return (PageType) Enum.valueOf(PageType.class, r10);
    }

    public static PageType[] values() {
        return (PageType[]) $VALUES.clone();
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
