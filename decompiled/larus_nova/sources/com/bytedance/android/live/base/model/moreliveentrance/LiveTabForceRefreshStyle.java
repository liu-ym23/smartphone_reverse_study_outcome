package com.bytedance.android.live.base.model.moreliveentrance;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/moreliveentrance/LiveTabForceRefreshStyle;", "", "", "styleType", "I", "getStyleType", "()I", "NO_OP", "REFRESH_FULL", "REFRESH_REVISIT_ONLY", "REFRESH_FEED_ONLY", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveTabForceRefreshStyle extends Enum<LiveTabForceRefreshStyle> {
    public static final LiveTabForceRefreshStyle NO_OP = null;
    public static final LiveTabForceRefreshStyle REFRESH_FEED_ONLY = null;
    public static final LiveTabForceRefreshStyle REFRESH_FULL = null;
    public static final LiveTabForceRefreshStyle REFRESH_REVISIT_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveTabForceRefreshStyle[] f58902a = null;
    private final int styleType;

    static {
        LiveTabForceRefreshStyle r100 = new LiveTabForceRefreshStyle("NO_OP", 0, -1);
        NO_OP = r100;
        LiveTabForceRefreshStyle r101 = new LiveTabForceRefreshStyle("REFRESH_FULL", 1, 0);
        REFRESH_FULL = r101;
        LiveTabForceRefreshStyle r102 = new LiveTabForceRefreshStyle("REFRESH_REVISIT_ONLY", 2, 1);
        REFRESH_REVISIT_ONLY = r102;
        LiveTabForceRefreshStyle r103 = new LiveTabForceRefreshStyle("REFRESH_FEED_ONLY", 3, 2);
        REFRESH_FEED_ONLY = r103;
        f58902a = new LiveTabForceRefreshStyle[]{r100, r101, r102, r103};
    }

    public static LiveTabForceRefreshStyle valueOf(String r100) {
        return (LiveTabForceRefreshStyle) r27.a.a(LiveTabForceRefreshStyle.class, r100);
    }

    public static LiveTabForceRefreshStyle[] values() {
        return (LiveTabForceRefreshStyle[]) f58902a.clone();
    }

    public final int getStyleType() {
        return this.styleType;
    }

    public LiveTabForceRefreshStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.styleType = r102;
    }
}
