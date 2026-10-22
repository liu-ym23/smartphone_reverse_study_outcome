package com.bytedance.android.livesdk.revenue.service.datacenter;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/datacenter/UserProfileClickPos;", "", "POSITION_LINKED_ANCHOR_MANAGE_SETTING", "POSITION_LINKED_ANCHOR", "POSITION_PK_HISTORY_RECORD", "POSITION_PK_LINKED_ANCHOR", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UserProfileClickPos extends Enum<UserProfileClickPos> {
    public static final UserProfileClickPos POSITION_LINKED_ANCHOR = null;
    public static final UserProfileClickPos POSITION_LINKED_ANCHOR_MANAGE_SETTING = null;
    public static final UserProfileClickPos POSITION_PK_HISTORY_RECORD = null;
    public static final UserProfileClickPos POSITION_PK_LINKED_ANCHOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserProfileClickPos[] f157299a = null;

    static {
        UserProfileClickPos r100 = new UserProfileClickPos("POSITION_LINKED_ANCHOR_MANAGE_SETTING", 0);
        POSITION_LINKED_ANCHOR_MANAGE_SETTING = r100;
        UserProfileClickPos r101 = new UserProfileClickPos("POSITION_LINKED_ANCHOR", 1);
        POSITION_LINKED_ANCHOR = r101;
        UserProfileClickPos r102 = new UserProfileClickPos("POSITION_PK_HISTORY_RECORD", 2);
        POSITION_PK_HISTORY_RECORD = r102;
        UserProfileClickPos r103 = new UserProfileClickPos("POSITION_PK_LINKED_ANCHOR", 3);
        POSITION_PK_LINKED_ANCHOR = r103;
        f157299a = new UserProfileClickPos[]{r100, r101, r102, r103};
    }

    public static UserProfileClickPos valueOf(String r100) {
        return (UserProfileClickPos) a.a(UserProfileClickPos.class, r100);
    }

    public static UserProfileClickPos[] values() {
        return (UserProfileClickPos[]) f157299a.clone();
    }

    public UserProfileClickPos(String r100, int r101) {
        super(r100, r101);
    }
}
