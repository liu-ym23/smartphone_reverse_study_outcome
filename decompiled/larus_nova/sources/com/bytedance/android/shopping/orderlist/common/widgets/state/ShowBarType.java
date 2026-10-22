package com.bytedance.android.shopping.orderlist.common.widgets.state;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/ShowBarType;", "", AccountType.ALL, "ONLY_BACK", "ONLY_SEARCH_BAR", UserProfileEvent.POSITION_NONE, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowBarType extends Enum<ShowBarType> {
    public static final ShowBarType ALL = null;
    public static final ShowBarType NONE = null;
    public static final ShowBarType ONLY_BACK = null;
    public static final ShowBarType ONLY_SEARCH_BAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowBarType[] f180067a = null;

    static {
        ShowBarType r100 = new ShowBarType(AccountType.ALL, 0);
        ALL = r100;
        ShowBarType r101 = new ShowBarType("ONLY_BACK", 1);
        ONLY_BACK = r101;
        ShowBarType r102 = new ShowBarType("ONLY_SEARCH_BAR", 2);
        ONLY_SEARCH_BAR = r102;
        ShowBarType r103 = new ShowBarType(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        f180067a = new ShowBarType[]{r100, r101, r102, r103};
    }

    public static ShowBarType valueOf(String r100) {
        return (ShowBarType) r27.a.a(ShowBarType.class, r100);
    }

    public static ShowBarType[] values() {
        return (ShowBarType[]) f180067a.clone();
    }

    public ShowBarType(String r100, int r101) {
        super(r100, r101);
    }
}
