package com.bytedance.android.shopping.inflow.common.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/inflow/common/base/LoadStatus;", "", "IDLE", "LOADING", "SUCCESS", "PACK_SUCCESS", "PACK_ERROR", "FINISH_ERROR", "FINISH_EMPTY", "FINISH_NO_MORE", "FINISH_HAS_MORE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadStatus extends Enum<LoadStatus> {
    public static final LoadStatus FINISH_EMPTY = null;
    public static final LoadStatus FINISH_ERROR = null;
    public static final LoadStatus FINISH_HAS_MORE = null;
    public static final LoadStatus FINISH_NO_MORE = null;
    public static final LoadStatus IDLE = null;
    public static final LoadStatus LOADING = null;
    public static final LoadStatus PACK_ERROR = null;
    public static final LoadStatus PACK_SUCCESS = null;
    public static final LoadStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadStatus[] f176256a = null;

    static {
        LoadStatus r100 = new LoadStatus("IDLE", 0);
        IDLE = r100;
        LoadStatus r101 = new LoadStatus("LOADING", 1);
        LOADING = r101;
        LoadStatus r102 = new LoadStatus("SUCCESS", 2);
        SUCCESS = r102;
        LoadStatus r103 = new LoadStatus("PACK_SUCCESS", 3);
        PACK_SUCCESS = r103;
        LoadStatus r104 = new LoadStatus("PACK_ERROR", 4);
        PACK_ERROR = r104;
        LoadStatus r105 = new LoadStatus("FINISH_ERROR", 5);
        FINISH_ERROR = r105;
        LoadStatus r106 = new LoadStatus("FINISH_EMPTY", 6);
        FINISH_EMPTY = r106;
        LoadStatus r107 = new LoadStatus("FINISH_NO_MORE", 7);
        FINISH_NO_MORE = r107;
        LoadStatus r108 = new LoadStatus("FINISH_HAS_MORE", 8);
        FINISH_HAS_MORE = r108;
        f176256a = new LoadStatus[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static LoadStatus valueOf(String r100) {
        return (LoadStatus) a.a(LoadStatus.class, r100);
    }

    public static LoadStatus[] values() {
        return (LoadStatus[]) f176256a.clone();
    }

    public LoadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
