package com.bytedance.android.live.ktv.common.model.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/SingingHotResultRankType;", "", "DAILY_RANK", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SingingHotResultRankType extends Enum<SingingHotResultRankType> {
    public static final SingingHotResultRankType DAILY_RANK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingingHotResultRankType[] f69984a = null;

    static {
        SingingHotResultRankType r100 = new SingingHotResultRankType();
        DAILY_RANK = r100;
        f69984a = new SingingHotResultRankType[]{r100};
    }

    public static SingingHotResultRankType valueOf(String r100) {
        return (SingingHotResultRankType) r27.a.a(SingingHotResultRankType.class, r100);
    }

    public static SingingHotResultRankType[] values() {
        return (SingingHotResultRankType[]) f69984a.clone();
    }

    public SingingHotResultRankType() {
        super("DAILY_RANK", 0);
    }
}
