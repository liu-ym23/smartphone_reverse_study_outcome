package com.bytedance.android.livesdkapi.util;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/LiveResourceModel;", "", "resourceName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "TTLIVE_FEED_EMPTY", "TTLIVE_NO_NETWORK", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveResourceModel extends Enum<LiveResourceModel> {
    private static final /* synthetic */ LiveResourceModel[] $VALUES = null;
    public static final LiveResourceModel TTLIVE_FEED_EMPTY = null;
    public static final LiveResourceModel TTLIVE_NO_NETWORK = null;

    static {
        LiveResourceModel r100 = new LiveResourceModel("TTLIVE_FEED_EMPTY", 0, "ttlive_feed_empty");
        TTLIVE_FEED_EMPTY = r100;
        LiveResourceModel r101 = new LiveResourceModel("TTLIVE_NO_NETWORK", 1, "ttlive_feed_drawer_no_network");
        TTLIVE_NO_NETWORK = r101;
        $VALUES = new LiveResourceModel[]{r100, r101};
    }

    public static LiveResourceModel valueOf(String r100) {
        return (LiveResourceModel) a.a(LiveResourceModel.class, r100);
    }

    public static LiveResourceModel[] values() {
        return (LiveResourceModel[]) $VALUES.clone();
    }

    private LiveResourceModel(String r100, int r101, String r102) {
        super(r100, r101);
    }
}
