package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketDataSource;", "", "(Ljava/lang/String;I)V", "API", "IM", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RedPacketDataSource extends Enum<RedPacketDataSource> {
    private static final /* synthetic */ RedPacketDataSource[] $VALUES = null;
    public static final RedPacketDataSource API = null;
    public static final RedPacketDataSource IM = null;

    static {
        RedPacketDataSource r100 = new RedPacketDataSource("API", 0);
        API = r100;
        RedPacketDataSource r101 = new RedPacketDataSource("IM", 1);
        IM = r101;
        $VALUES = new RedPacketDataSource[]{r100, r101};
    }

    public static RedPacketDataSource valueOf(String r100) {
        return (RedPacketDataSource) r27.a.a(RedPacketDataSource.class, r100);
    }

    public static RedPacketDataSource[] values() {
        return (RedPacketDataSource[]) $VALUES.clone();
    }

    private RedPacketDataSource(String r100, int r101) {
        super(r100, r101);
    }
}
