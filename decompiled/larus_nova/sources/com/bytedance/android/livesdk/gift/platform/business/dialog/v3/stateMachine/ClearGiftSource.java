package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ClearGiftSource;", "", "(Ljava/lang/String;I)V", "ChangeTab", "SelectGift", "ChangeReceiver", "ChangeTopicPage", "GroupCancel", "SearchUpdate", "RemoveMostlyUsed", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClearGiftSource extends Enum<ClearGiftSource> {
    private static final /* synthetic */ ClearGiftSource[] $VALUES = null;
    public static final ClearGiftSource ChangeReceiver = null;
    public static final ClearGiftSource ChangeTab = null;
    public static final ClearGiftSource ChangeTopicPage = null;
    public static final ClearGiftSource GroupCancel = null;
    public static final ClearGiftSource RemoveMostlyUsed = null;
    public static final ClearGiftSource SearchUpdate = null;
    public static final ClearGiftSource SelectGift = null;

    static {
        ClearGiftSource r100 = new ClearGiftSource("ChangeTab", 0);
        ChangeTab = r100;
        ClearGiftSource r101 = new ClearGiftSource("SelectGift", 1);
        SelectGift = r101;
        ClearGiftSource r102 = new ClearGiftSource("ChangeReceiver", 2);
        ChangeReceiver = r102;
        ClearGiftSource r103 = new ClearGiftSource("ChangeTopicPage", 3);
        ChangeTopicPage = r103;
        ClearGiftSource r104 = new ClearGiftSource("GroupCancel", 4);
        GroupCancel = r104;
        ClearGiftSource r105 = new ClearGiftSource("SearchUpdate", 5);
        SearchUpdate = r105;
        ClearGiftSource r106 = new ClearGiftSource("RemoveMostlyUsed", 6);
        RemoveMostlyUsed = r106;
        $VALUES = new ClearGiftSource[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ClearGiftSource valueOf(String r100) {
        return (ClearGiftSource) a.a(ClearGiftSource.class, r100);
    }

    public static ClearGiftSource[] values() {
        return (ClearGiftSource[]) $VALUES.clone();
    }

    private ClearGiftSource(String r100, int r101) {
        super(r100, r101);
    }
}
