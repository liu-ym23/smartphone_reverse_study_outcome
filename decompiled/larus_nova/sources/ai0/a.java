package ai0;

import com.bytedance.android.live.liveinteract.revenue.adventure.model.AdventureUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f3718a = null;

    static {
        int[] r100 = new int[AdventureUpdateType.values().length];
        f3718a = r100;
        r100[AdventureUpdateType.UPDATE.ordinal()] = 1;
        r100[AdventureUpdateType.JOIN_RTC_ROOM.ordinal()] = 2;
        r100[AdventureUpdateType.LEAVE_RTC_ROOM.ordinal()] = 3;
        r100[AdventureUpdateType.CHECK_RTC_ROOM.ordinal()] = 4;
    }
}
