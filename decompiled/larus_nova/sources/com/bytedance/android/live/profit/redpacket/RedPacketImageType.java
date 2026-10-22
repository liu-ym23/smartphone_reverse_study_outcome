package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketImageType;", "", "UNKNOWN", "PNG", "WEBP", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedPacketImageType extends Enum<RedPacketImageType> {
    public static final RedPacketImageType PNG = null;
    public static final RedPacketImageType UNKNOWN = null;
    public static final RedPacketImageType WEBP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedPacketImageType[] f88562a = null;

    static {
        RedPacketImageType r100 = new RedPacketImageType("UNKNOWN", 0);
        UNKNOWN = r100;
        RedPacketImageType r101 = new RedPacketImageType("PNG", 1);
        PNG = r101;
        RedPacketImageType r102 = new RedPacketImageType("WEBP", 2);
        WEBP = r102;
        f88562a = new RedPacketImageType[]{r100, r101, r102};
    }

    public static RedPacketImageType valueOf(String r100) {
        return (RedPacketImageType) r27.a.a(RedPacketImageType.class, r100);
    }

    public static RedPacketImageType[] values() {
        return (RedPacketImageType[]) f88562a.clone();
    }

    public RedPacketImageType(String r100, int r101) {
        super(r100, r101);
    }
}
