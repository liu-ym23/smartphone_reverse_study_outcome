package com.bytedance.android.livesdk.revenue.service.livecore;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/RtcBusinessType;", "", "UNKNOWN", "PK_CLOUD_GAME", "REAL_TIME_CHORUS", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RtcBusinessType extends Enum<RtcBusinessType> {
    public static final RtcBusinessType PK_CLOUD_GAME = null;
    public static final RtcBusinessType REAL_TIME_CHORUS = null;
    public static final RtcBusinessType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RtcBusinessType[] f157405a = null;

    static {
        RtcBusinessType r100 = new RtcBusinessType("UNKNOWN", 0);
        UNKNOWN = r100;
        RtcBusinessType r101 = new RtcBusinessType("PK_CLOUD_GAME", 1);
        PK_CLOUD_GAME = r101;
        RtcBusinessType r102 = new RtcBusinessType("REAL_TIME_CHORUS", 2);
        REAL_TIME_CHORUS = r102;
        f157405a = new RtcBusinessType[]{r100, r101, r102};
    }

    public static RtcBusinessType valueOf(String r100) {
        return (RtcBusinessType) a.a(RtcBusinessType.class, r100);
    }

    public static RtcBusinessType[] values() {
        return (RtcBusinessType[]) f157405a.clone();
    }

    public RtcBusinessType(String r100, int r101) {
        super(r100, r101);
    }
}
