package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkmicAdjustPositionPingType;", "", "AdjustPositionPingType_UnKnown", "AdjustPositinoPingType_Continue", "AdjustPositionPingType_Cancel", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicAdjustPositionPingType extends Enum<LinkmicAdjustPositionPingType> {
    public static final LinkmicAdjustPositionPingType AdjustPositinoPingType_Continue = null;
    public static final LinkmicAdjustPositionPingType AdjustPositionPingType_Cancel = null;
    public static final LinkmicAdjustPositionPingType AdjustPositionPingType_UnKnown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicAdjustPositionPingType[] f71955a = null;

    static {
        LinkmicAdjustPositionPingType r100 = new LinkmicAdjustPositionPingType("AdjustPositionPingType_UnKnown", 0);
        AdjustPositionPingType_UnKnown = r100;
        LinkmicAdjustPositionPingType r101 = new LinkmicAdjustPositionPingType("AdjustPositinoPingType_Continue", 1);
        AdjustPositinoPingType_Continue = r101;
        LinkmicAdjustPositionPingType r102 = new LinkmicAdjustPositionPingType("AdjustPositionPingType_Cancel", 2);
        AdjustPositionPingType_Cancel = r102;
        f71955a = new LinkmicAdjustPositionPingType[]{r100, r101, r102};
    }

    public static LinkmicAdjustPositionPingType valueOf(String r100) {
        return (LinkmicAdjustPositionPingType) r27.a.a(LinkmicAdjustPositionPingType.class, r100);
    }

    public static LinkmicAdjustPositionPingType[] values() {
        return (LinkmicAdjustPositionPingType[]) f71955a.clone();
    }

    public LinkmicAdjustPositionPingType(String r100, int r101) {
        super(r100, r101);
    }
}
