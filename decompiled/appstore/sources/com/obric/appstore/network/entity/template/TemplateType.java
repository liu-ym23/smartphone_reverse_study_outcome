package com.obric.appstore.network.entity.template;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/appstore/network/entity/template/TemplateType;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HOME_CARD", "COLUMN", "APP_LIST", "APP_CATEGORY_LIST", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum TemplateType extends Enum<TemplateType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TemplateType[] $VALUES = null;
    public static final TemplateType APP_CATEGORY_LIST = null;
    public static final TemplateType APP_LIST = null;
    public static final TemplateType COLUMN = null;
    public static final TemplateType HOME_CARD = null;

    @NotNull
    private final String value;

    private static final /* synthetic */ TemplateType[] $values() {
        return new TemplateType[]{HOME_CARD, COLUMN, APP_LIST, APP_CATEGORY_LIST};
    }

    static {
        HOME_CARD = new TemplateType("HOME_CARD", 0, "homepage_card");
        COLUMN = new TemplateType("COLUMN", 1, "column");
        APP_LIST = new TemplateType("APP_LIST", 2, "app_list");
        APP_CATEGORY_LIST = new TemplateType("APP_CATEGORY_LIST", 3, "app_category_list_title");
        TemplateType[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = a.a(r10);
    }

    private TemplateType(String r10, int r11, String r12) {
        super(r10, r11);
        this.value = r12;
    }

    @NotNull
    public static EnumEntries<TemplateType> getEntries() {
        return $ENTRIES;
    }

    public static TemplateType valueOf(String r10) {
        return (TemplateType) Enum.valueOf(TemplateType.class, r10);
    }

    public static TemplateType[] values() {
        return (TemplateType[]) $VALUES.clone();
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
