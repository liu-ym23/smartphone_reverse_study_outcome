package com.bytedance.android.live.revenuelink.usercenter;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revenuelink/usercenter/ListUpdateType;", "", "", "isVersionMsg", "isVersionMsgV2", UserProfileEvent.POSITION_NONE, "WAITING_MSG", "ENTER_MSG", "LINKED_CHANGE_MSG", "LEAVE_MSG", "LIST_API", "REFRESH_WITH_VERSION", "CLEAR", "revenue-link-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ListUpdateType extends Enum<ListUpdateType> {
    public static final ListUpdateType CLEAR = null;
    public static final ListUpdateType ENTER_MSG = null;
    public static final ListUpdateType LEAVE_MSG = null;
    public static final ListUpdateType LINKED_CHANGE_MSG = null;
    public static final ListUpdateType LIST_API = null;
    public static final ListUpdateType NONE = null;
    public static final ListUpdateType REFRESH_WITH_VERSION = null;
    public static final ListUpdateType WAITING_MSG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListUpdateType[] f91975a = null;

    static {
        ListUpdateType r100 = new ListUpdateType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ListUpdateType r101 = new ListUpdateType("WAITING_MSG", 1);
        WAITING_MSG = r101;
        ListUpdateType r102 = new ListUpdateType("ENTER_MSG", 2);
        ENTER_MSG = r102;
        ListUpdateType r103 = new ListUpdateType("LINKED_CHANGE_MSG", 3);
        LINKED_CHANGE_MSG = r103;
        ListUpdateType r104 = new ListUpdateType("LEAVE_MSG", 4);
        LEAVE_MSG = r104;
        ListUpdateType r105 = new ListUpdateType("LIST_API", 5);
        LIST_API = r105;
        ListUpdateType r106 = new ListUpdateType("REFRESH_WITH_VERSION", 6);
        REFRESH_WITH_VERSION = r106;
        ListUpdateType r107 = new ListUpdateType("CLEAR", 7);
        CLEAR = r107;
        f91975a = new ListUpdateType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static ListUpdateType valueOf(String r100) {
        return (ListUpdateType) a.a(ListUpdateType.class, r100);
    }

    public static ListUpdateType[] values() {
        return (ListUpdateType[]) f91975a.clone();
    }

    public final boolean isVersionMsg() {
        if (this != ENTER_MSG) goto L5;
    L8:
        return true;
    L5:
        if (this == LINKED_CHANGE_MSG) goto L8;
        return false;
    }

    public final boolean isVersionMsgV2() {
        if (this != ENTER_MSG) goto L5;
    L16:
        return true;
    L5:
        if (this == LINKED_CHANGE_MSG) goto L16;
        if (this == LEAVE_MSG) goto L16;
        if (this == LIST_API) goto L16;
        if (this == WAITING_MSG) goto L16;
        if (this == REFRESH_WITH_VERSION) goto L16;
        return false;
    }

    public ListUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
