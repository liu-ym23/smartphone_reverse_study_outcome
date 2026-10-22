package com.bytedance.android.livehostapi.platform;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/UserSelection;", "", "(Ljava/lang/String;I)V", "CONFIRM", "CANCEL", "USE_DOUYIN", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UserSelection extends Enum<UserSelection> {
    private static final /* synthetic */ UserSelection[] $VALUES = null;
    public static final UserSelection CANCEL = null;
    public static final UserSelection CONFIRM = null;
    public static final UserSelection USE_DOUYIN = null;

    static {
        UserSelection r100 = new UserSelection("CONFIRM", 0);
        CONFIRM = r100;
        UserSelection r101 = new UserSelection("CANCEL", 1);
        CANCEL = r101;
        UserSelection r102 = new UserSelection("USE_DOUYIN", 2);
        USE_DOUYIN = r102;
        $VALUES = new UserSelection[]{r100, r101, r102};
    }

    public static UserSelection valueOf(String r100) {
        return (UserSelection) r27.a.a(UserSelection.class, r100);
    }

    public static UserSelection[] values() {
        return (UserSelection[]) $VALUES.clone();
    }

    private UserSelection(String r100, int r101) {
        super(r100, r101);
    }
}
