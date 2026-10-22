package com.bytedance.android.livesdk.revenue.service.datacenter;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/datacenter/UserProfileReportType;", "", "DATA_TYPE_CARD_LINKED_ANCHOR", "DATA_TYPE_CARD_PK_ANCHOR", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UserProfileReportType extends Enum<UserProfileReportType> {
    public static final UserProfileReportType DATA_TYPE_CARD_LINKED_ANCHOR = null;
    public static final UserProfileReportType DATA_TYPE_CARD_PK_ANCHOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserProfileReportType[] f157300a = null;

    static {
        UserProfileReportType r100 = new UserProfileReportType("DATA_TYPE_CARD_LINKED_ANCHOR", 0);
        DATA_TYPE_CARD_LINKED_ANCHOR = r100;
        UserProfileReportType r101 = new UserProfileReportType("DATA_TYPE_CARD_PK_ANCHOR", 1);
        DATA_TYPE_CARD_PK_ANCHOR = r101;
        f157300a = new UserProfileReportType[]{r100, r101};
    }

    public static UserProfileReportType valueOf(String r100) {
        return (UserProfileReportType) a.a(UserProfileReportType.class, r100);
    }

    public static UserProfileReportType[] values() {
        return (UserProfileReportType[]) f157300a.clone();
    }

    public UserProfileReportType(String r100, int r101) {
        super(r100, r101);
    }
}
