package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/TabType;", "", "IS_WIDGET_TAB", "IS_WEB_TAB", UserProfileEvent.POSITION_NONE, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabType extends Enum<TabType> {
    public static final TabType IS_WEB_TAB = null;
    public static final TabType IS_WIDGET_TAB = null;
    public static final TabType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabType[] f159921a = null;

    static {
        TabType r100 = new TabType("IS_WIDGET_TAB", 0);
        IS_WIDGET_TAB = r100;
        TabType r101 = new TabType("IS_WEB_TAB", 1);
        IS_WEB_TAB = r101;
        TabType r102 = new TabType(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        f159921a = new TabType[]{r100, r101, r102};
    }

    public static TabType valueOf(String r100) {
        return (TabType) r27.a.a(TabType.class, r100);
    }

    public static TabType[] values() {
        return (TabType[]) f159921a.clone();
    }

    public TabType(String r100, int r101) {
        super(r100, r101);
    }
}
