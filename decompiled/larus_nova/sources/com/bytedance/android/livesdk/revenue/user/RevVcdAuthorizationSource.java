package com.bytedance.android.livesdk.revenue.user;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/user/RevVcdAuthorizationSource;", "", "RedPacketSend", "RedPacketRush", "LotteryParticipate", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevVcdAuthorizationSource extends Enum<RevVcdAuthorizationSource> {
    public static final RevVcdAuthorizationSource LotteryParticipate = null;
    public static final RevVcdAuthorizationSource RedPacketRush = null;
    public static final RevVcdAuthorizationSource RedPacketSend = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevVcdAuthorizationSource[] f157525a = null;

    static {
        RevVcdAuthorizationSource r100 = new RevVcdAuthorizationSource("RedPacketSend", 0);
        RedPacketSend = r100;
        RevVcdAuthorizationSource r101 = new RevVcdAuthorizationSource("RedPacketRush", 1);
        RedPacketRush = r101;
        RevVcdAuthorizationSource r102 = new RevVcdAuthorizationSource("LotteryParticipate", 2);
        LotteryParticipate = r102;
        f157525a = new RevVcdAuthorizationSource[]{r100, r101, r102};
    }

    public static RevVcdAuthorizationSource valueOf(String r100) {
        return (RevVcdAuthorizationSource) a.a(RevVcdAuthorizationSource.class, r100);
    }

    public static RevVcdAuthorizationSource[] values() {
        return (RevVcdAuthorizationSource[]) f157525a.clone();
    }

    public RevVcdAuthorizationSource(String r100, int r101) {
        super(r100, r101);
    }
}
