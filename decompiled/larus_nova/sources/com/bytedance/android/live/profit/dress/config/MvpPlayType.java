package com.bytedance.android.live.profit.dress.config;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/MvpPlayType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", "GroupBattle", "RoomBattle", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MvpPlayType extends Enum<MvpPlayType> {
    public static final a Companion = null;
    public static final MvpPlayType GroupBattle = null;
    public static final MvpPlayType RoomBattle = null;
    public static final MvpPlayType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MvpPlayType[] f87091a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.dress.config.MvpPlayType$a] */
    static {
        MvpPlayType r100 = new MvpPlayType("Unknown", 0, -1);
        Unknown = r100;
        MvpPlayType r101 = new MvpPlayType("GroupBattle", 1, 0);
        GroupBattle = r101;
        MvpPlayType r102 = new MvpPlayType("RoomBattle", 2, 1);
        RoomBattle = r102;
        f87091a = new MvpPlayType[]{r100, r101, r102};
        Companion = new a();
    }

    public static MvpPlayType valueOf(String r100) {
        return (MvpPlayType) r27.a.a(MvpPlayType.class, r100);
    }

    public static MvpPlayType[] values() {
        return (MvpPlayType[]) f87091a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MvpPlayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
