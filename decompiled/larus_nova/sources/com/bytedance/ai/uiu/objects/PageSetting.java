package com.bytedance.ai.uiu.objects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/uiu/objects/PageSetting;", "", "<init>", "(Ljava/lang/String;I)V", "ALL_PAGE", "LAST_PAGE", "TARGET_PAGE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageSetting extends Enum<PageSetting> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PageSetting[] $VALUES = null;
    public static final PageSetting ALL_PAGE = null;
    public static final PageSetting LAST_PAGE = null;
    public static final PageSetting TARGET_PAGE = null;

    private static final /* synthetic */ PageSetting[] $values() {
        return new PageSetting[]{ALL_PAGE, LAST_PAGE, TARGET_PAGE};
    }

    public static EnumEntries<PageSetting> getEntries() {
        return $ENTRIES;
    }

    static {
        ALL_PAGE = new PageSetting("ALL_PAGE", 0);
        LAST_PAGE = new PageSetting("LAST_PAGE", 1);
        TARGET_PAGE = new PageSetting("TARGET_PAGE", 2);
        PageSetting[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static PageSetting[] values() {
        return (PageSetting[]) $VALUES.clone();
    }

    public static PageSetting valueOf(String r100) {
        return (PageSetting) a.a(PageSetting.class, r100);
    }

    private PageSetting(String r100, int r101) {
        super(r100, r101);
    }
}
