package com.bytedance.android.live.room.api.experience.perf;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/experience/perf/LivePerfBizType;", "", "Degrade", "Normal", "Enhance", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePerfBizType extends Enum<LivePerfBizType> {
    public static final LivePerfBizType Degrade = null;
    public static final LivePerfBizType Enhance = null;
    public static final LivePerfBizType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePerfBizType[] f98906a = null;

    static {
        LivePerfBizType r100 = new LivePerfBizType("Degrade", 0);
        Degrade = r100;
        LivePerfBizType r101 = new LivePerfBizType("Normal", 1);
        Normal = r101;
        LivePerfBizType r102 = new LivePerfBizType("Enhance", 2);
        Enhance = r102;
        f98906a = new LivePerfBizType[]{r100, r101, r102};
    }

    public static LivePerfBizType valueOf(String r100) {
        return (LivePerfBizType) a.a(LivePerfBizType.class, r100);
    }

    public static LivePerfBizType[] values() {
        return (LivePerfBizType[]) f98906a.clone();
    }

    public LivePerfBizType(String r100, int r101) {
        super(r100, r101);
    }
}
