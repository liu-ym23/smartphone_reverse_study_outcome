package androidx.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"androidx/room/FtsOptions$MatchInfo", "", "Landroidx/room/FtsOptions$MatchInfo;", "<init>", "(Ljava/lang/String;I)V", "FTS3", "FTS4", "room-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum FtsOptions$MatchInfo extends Enum<FtsOptions$MatchInfo> {
    private static final /* synthetic */ FtsOptions$MatchInfo[] $VALUES = null;
    public static final FtsOptions$MatchInfo FTS3 = null;
    public static final FtsOptions$MatchInfo FTS4 = null;

    private static final /* synthetic */ FtsOptions$MatchInfo[] $values() {
        return new FtsOptions$MatchInfo[]{FTS3, FTS4};
    }

    static {
        FTS3 = new FtsOptions$MatchInfo("FTS3", 0);
        FTS4 = new FtsOptions$MatchInfo("FTS4", 1);
        $VALUES = $values();
    }

    private FtsOptions$MatchInfo(String r10, int r11) {
        super(r10, r11);
    }

    public static FtsOptions$MatchInfo valueOf(String r10) {
        return (FtsOptions$MatchInfo) Enum.valueOf(FtsOptions$MatchInfo.class, r10);
    }

    public static FtsOptions$MatchInfo[] values() {
        return (FtsOptions$MatchInfo[]) $VALUES.clone();
    }
}
