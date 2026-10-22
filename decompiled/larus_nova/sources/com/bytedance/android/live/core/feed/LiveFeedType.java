package com.bytedance.android.live.core.feed;

import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/feed/LiveFeedType;", "", "", "lowerName", "OUT_FLOW", "INNER_FLOW", "DRAWER", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveFeedType extends Enum<LiveFeedType> {
    public static final LiveFeedType DRAWER = null;
    public static final LiveFeedType INNER_FLOW = null;
    public static final LiveFeedType OUT_FLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveFeedType[] f64793a = null;

    static {
        LiveFeedType r100 = new LiveFeedType("OUT_FLOW", 0);
        OUT_FLOW = r100;
        LiveFeedType r101 = new LiveFeedType("INNER_FLOW", 1);
        INNER_FLOW = r101;
        LiveFeedType r102 = new LiveFeedType("DRAWER", 2);
        DRAWER = r102;
        f64793a = new LiveFeedType[]{r100, r101, r102};
    }

    public static LiveFeedType valueOf(String r100) {
        return (LiveFeedType) r27.a.a(LiveFeedType.class, r100);
    }

    public static LiveFeedType[] values() {
        return (LiveFeedType[]) f64793a.clone();
    }

    public final String lowerName() {
        String r100 = name();
        Locale r101 = Locale.ENGLISH;
        if (r100 == null) goto L7;
        return r100.toLowerCase(r101);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public LiveFeedType(String r100, int r101) {
        super(r100, r101);
    }
}
