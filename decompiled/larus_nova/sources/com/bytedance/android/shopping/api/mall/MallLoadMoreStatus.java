package com.bytedance.android.shopping.api.mall;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/MallLoadMoreStatus;", "", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "START_LOAD_MORE", "FINISH_LOAD_MORE", "NO_MORE", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MallLoadMoreStatus extends Enum<MallLoadMoreStatus> {
    public static final MallLoadMoreStatus FINISH_LOAD_MORE = null;
    public static final MallLoadMoreStatus NO_MORE = null;
    public static final MallLoadMoreStatus START_LOAD_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MallLoadMoreStatus[] f170209a = null;
    private final String status;

    static {
        MallLoadMoreStatus r100 = new MallLoadMoreStatus("START_LOAD_MORE", 0, "start_load_more");
        START_LOAD_MORE = r100;
        MallLoadMoreStatus r101 = new MallLoadMoreStatus("FINISH_LOAD_MORE", 1, "finish_load_more");
        FINISH_LOAD_MORE = r101;
        MallLoadMoreStatus r102 = new MallLoadMoreStatus("NO_MORE", 2, "no_more");
        NO_MORE = r102;
        f170209a = new MallLoadMoreStatus[]{r100, r101, r102};
    }

    public static MallLoadMoreStatus valueOf(String r100) {
        return (MallLoadMoreStatus) r27.a.a(MallLoadMoreStatus.class, r100);
    }

    public static MallLoadMoreStatus[] values() {
        return (MallLoadMoreStatus[]) f170209a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public MallLoadMoreStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
