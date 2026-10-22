package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/toolbar/AttackAndDefenseLogType;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "SHOW", "CLICK", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AttackAndDefenseLogType extends Enum<AttackAndDefenseLogType> {
    public static final AttackAndDefenseLogType CLICK = null;
    public static final AttackAndDefenseLogType SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttackAndDefenseLogType[] f130148a = null;
    private final String eventName;

    static {
        AttackAndDefenseLogType r100 = new AttackAndDefenseLogType("SHOW", 0, "livesdk_gift_game_anchor_entrance_show");
        SHOW = r100;
        AttackAndDefenseLogType r101 = new AttackAndDefenseLogType("CLICK", 1, "livesdk_gift_game_anchor_entrance_click");
        CLICK = r101;
        f130148a = new AttackAndDefenseLogType[]{r100, r101};
    }

    public static AttackAndDefenseLogType valueOf(String r100) {
        return (AttackAndDefenseLogType) r27.a.a(AttackAndDefenseLogType.class, r100);
    }

    public static AttackAndDefenseLogType[] values() {
        return (AttackAndDefenseLogType[]) f130148a.clone();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public AttackAndDefenseLogType(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventName = r102;
    }
}
