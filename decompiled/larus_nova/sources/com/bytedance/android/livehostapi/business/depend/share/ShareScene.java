package com.bytedance.android.livehostapi.business.depend.share;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public final enum ShareScene extends Enum<ShareScene> {
    private static final /* synthetic */ ShareScene[] $VALUES = null;
    public static final ShareScene DETAIL = null;
    public static final ShareScene H5 = null;
    public static final ShareScene LIVE = null;
    public static final ShareScene MOMENT = null;
    public static final ShareScene OTHERS = null;
    public static final ShareScene PRE_LIVE = null;
    public static final ShareScene PROFILE = null;
    public static final ShareScene REPLAY = null;

    static {
        ShareScene r100 = new ShareScene("DETAIL", 0);
        DETAIL = r100;
        ShareScene r101 = new ShareScene("PROFILE", 1);
        PROFILE = r101;
        ShareScene r102 = new ShareScene("LIVE", 2);
        LIVE = r102;
        ShareScene r103 = new ShareScene("MOMENT", 3);
        MOMENT = r103;
        ShareScene r104 = new ShareScene(AccountType.OTHERS, 4);
        OTHERS = r104;
        ShareScene r105 = new ShareScene("H5", 5);
        H5 = r105;
        ShareScene r110 = new ShareScene("PRE_LIVE", 6);
        PRE_LIVE = r110;
        ShareScene r111 = new ShareScene("REPLAY", 7);
        REPLAY = r111;
        $VALUES = new ShareScene[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static ShareScene[] values() {
        return (ShareScene[]) $VALUES.clone();
    }

    public static ShareScene valueOf(String r100) {
        return (ShareScene) a.a(ShareScene.class, r100);
    }

    private ShareScene(String r100, int r101) {
        super(r100, r101);
    }
}
