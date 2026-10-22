package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketFromIMStatus;", "", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "RED_PACKET_RECEIVED", "RED_PACKET_EMPTY", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedPacketFromIMStatus extends Enum<RedPacketFromIMStatus> {
    public static final RedPacketFromIMStatus RED_PACKET_EMPTY = null;
    public static final RedPacketFromIMStatus RED_PACKET_RECEIVED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedPacketFromIMStatus[] f88494a = null;
    private final String statusMsg;

    static {
        RedPacketFromIMStatus r100 = new RedPacketFromIMStatus("RED_PACKET_RECEIVED", 0, "receive");
        RED_PACKET_RECEIVED = r100;
        RedPacketFromIMStatus r101 = new RedPacketFromIMStatus("RED_PACKET_EMPTY", 1, "empty");
        RED_PACKET_EMPTY = r101;
        f88494a = new RedPacketFromIMStatus[]{r100, r101};
    }

    public static RedPacketFromIMStatus valueOf(String r100) {
        return (RedPacketFromIMStatus) r27.a.a(RedPacketFromIMStatus.class, r100);
    }

    public static RedPacketFromIMStatus[] values() {
        return (RedPacketFromIMStatus[]) f88494a.clone();
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public RedPacketFromIMStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.statusMsg = r102;
    }
}
