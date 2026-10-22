package com.bytedance.android.live.revlink.impl.precisefind;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/precisefind/FindPeopleStatus;", "", "UNKNOWN", "SELECT", "INVITE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FindPeopleStatus extends Enum<FindPeopleStatus> {
    public static final FindPeopleStatus INVITE = null;
    public static final FindPeopleStatus SELECT = null;
    public static final FindPeopleStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FindPeopleStatus[] f97469a = null;

    static {
        FindPeopleStatus r100 = new FindPeopleStatus("UNKNOWN", 0);
        UNKNOWN = r100;
        FindPeopleStatus r101 = new FindPeopleStatus("SELECT", 1);
        SELECT = r101;
        FindPeopleStatus r102 = new FindPeopleStatus("INVITE", 2);
        INVITE = r102;
        f97469a = new FindPeopleStatus[]{r100, r101, r102};
    }

    public static FindPeopleStatus valueOf(String r100) {
        return (FindPeopleStatus) r27.a.a(FindPeopleStatus.class, r100);
    }

    public static FindPeopleStatus[] values() {
        return (FindPeopleStatus[]) f97469a.clone();
    }

    public FindPeopleStatus(String r100, int r101) {
        super(r100, r101);
    }
}
