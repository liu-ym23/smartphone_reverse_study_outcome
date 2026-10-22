package com.bytedance.android.live.profit.privilege.model.touch;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001b\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/android/live/profit/privilege/model/touch/GrowthTouchData$RefreshMechanism", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/GrowthTouchData$RefreshMechanism;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "value", "J", "getValue", "()J", "MechanismUnknown", "MechanismIM", "MechanismPolling", "MechanismSendGiftJSBCallback", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GrowthTouchData$RefreshMechanism extends Enum<GrowthTouchData$RefreshMechanism> {
    public static final GrowthTouchData$RefreshMechanism MechanismIM = null;
    public static final GrowthTouchData$RefreshMechanism MechanismPolling = null;
    public static final GrowthTouchData$RefreshMechanism MechanismSendGiftJSBCallback = null;
    public static final GrowthTouchData$RefreshMechanism MechanismUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrowthTouchData$RefreshMechanism[] f88423a = null;
    private final long value;

    static {
        GrowthTouchData$RefreshMechanism r100 = new GrowthTouchData$RefreshMechanism("MechanismUnknown", 0, 0);
        MechanismUnknown = r100;
        GrowthTouchData$RefreshMechanism r101 = new GrowthTouchData$RefreshMechanism("MechanismIM", 1, 1);
        MechanismIM = r101;
        GrowthTouchData$RefreshMechanism r102 = new GrowthTouchData$RefreshMechanism("MechanismPolling", 2, 2);
        MechanismPolling = r102;
        GrowthTouchData$RefreshMechanism r103 = new GrowthTouchData$RefreshMechanism("MechanismSendGiftJSBCallback", 3, 3);
        MechanismSendGiftJSBCallback = r103;
        f88423a = new GrowthTouchData$RefreshMechanism[]{r100, r101, r102, r103};
    }

    public static GrowthTouchData$RefreshMechanism valueOf(String r100) {
        return (GrowthTouchData$RefreshMechanism) r27.a.a(GrowthTouchData$RefreshMechanism.class, r100);
    }

    public static GrowthTouchData$RefreshMechanism[] values() {
        return (GrowthTouchData$RefreshMechanism[]) f88423a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public GrowthTouchData$RefreshMechanism(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
