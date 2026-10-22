package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketDialogShowFrom;", "", "STI_CLICK", "RECEIVE", "REWARD", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RedPacketDialogShowFrom extends Enum<RedPacketDialogShowFrom> {
    public static final RedPacketDialogShowFrom RECEIVE = null;
    public static final RedPacketDialogShowFrom REWARD = null;
    public static final RedPacketDialogShowFrom STI_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedPacketDialogShowFrom[] f88491a = null;

    static {
        RedPacketDialogShowFrom r100 = new RedPacketDialogShowFrom("STI_CLICK", 0);
        STI_CLICK = r100;
        RedPacketDialogShowFrom r101 = new RedPacketDialogShowFrom("RECEIVE", 1);
        RECEIVE = r101;
        RedPacketDialogShowFrom r102 = new RedPacketDialogShowFrom("REWARD", 2);
        REWARD = r102;
        f88491a = new RedPacketDialogShowFrom[]{r100, r101, r102};
    }

    public static RedPacketDialogShowFrom valueOf(String r100) {
        return (RedPacketDialogShowFrom) r27.a.a(RedPacketDialogShowFrom.class, r100);
    }

    public static RedPacketDialogShowFrom[] values() {
        return (RedPacketDialogShowFrom[]) f88491a.clone();
    }

    public RedPacketDialogShowFrom(String r100, int r101) {
        super(r100, r101);
    }
}
