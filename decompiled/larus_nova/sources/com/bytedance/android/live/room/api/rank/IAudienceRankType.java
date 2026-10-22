package com.bytedance.android.live.room.api.rank;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/rank/IAudienceRankType;", "", "LIVE_PORTRAIT_RANK_WIDGET", "LIVE_LANDSCAPE_RANK_WIDGET", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IAudienceRankType extends Enum<IAudienceRankType> {
    public static final IAudienceRankType LIVE_LANDSCAPE_RANK_WIDGET = null;
    public static final IAudienceRankType LIVE_PORTRAIT_RANK_WIDGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IAudienceRankType[] f99081a = null;

    static {
        IAudienceRankType r100 = new IAudienceRankType("LIVE_PORTRAIT_RANK_WIDGET", 0);
        LIVE_PORTRAIT_RANK_WIDGET = r100;
        IAudienceRankType r101 = new IAudienceRankType("LIVE_LANDSCAPE_RANK_WIDGET", 1);
        LIVE_LANDSCAPE_RANK_WIDGET = r101;
        f99081a = new IAudienceRankType[]{r100, r101};
    }

    public static IAudienceRankType valueOf(String r100) {
        return (IAudienceRankType) a.a(IAudienceRankType.class, r100);
    }

    public static IAudienceRankType[] values() {
        return (IAudienceRankType[]) f99081a.clone();
    }

    public IAudienceRankType(String r100, int r101) {
        super(r100, r101);
    }
}
