package com.android.ttcjpaysdk.kmp.common.view.navigation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/navigation/LeftIconStyleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE", "BACK", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LeftIconStyleEnum extends Enum<LeftIconStyleEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LeftIconStyleEnum[] $VALUES = null;
    public static final LeftIconStyleEnum BACK = null;
    public static final LeftIconStyleEnum CLOSE = null;

    private static final /* synthetic */ LeftIconStyleEnum[] $values() {
        return new LeftIconStyleEnum[]{CLOSE, BACK};
    }

    public static EnumEntries<LeftIconStyleEnum> getEntries() {
        return $ENTRIES;
    }

    static {
        CLOSE = new LeftIconStyleEnum("CLOSE", 0);
        BACK = new LeftIconStyleEnum("BACK", 1);
        LeftIconStyleEnum[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LeftIconStyleEnum[] values() {
        return (LeftIconStyleEnum[]) $VALUES.clone();
    }

    public static LeftIconStyleEnum valueOf(String r100) {
        return (LeftIconStyleEnum) r27.a.a(LeftIconStyleEnum.class, r100);
    }

    private LeftIconStyleEnum(String r100, int r101) {
        super(r100, r101);
    }
}
