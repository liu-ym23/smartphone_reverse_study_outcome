package com.obric.memorydata.sdk.entity.search;

/* JADX INFO: compiled from: SearchError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SearchError {
    public static final int ERR_INTERNAL_ERROR = 1004;
    public static final int ERR_INVALID_PARAMS = 1002;
    public static final int ERR_MODEL_NOT_READY = 1005;
    public static final int ERR_NO_PERMISSION = 1001;
    public static final int ERR_PACKAGE_FAILED = 1006;
    public static final int ERR_PACKAGE_RUN_TIMEOUT = 1007;
    public static final int ERR_QUERY_UNDERSTANDING_FAILED = 1003;
    public static final int ERR_UNKNOWN = 1000;
    public static final SearchError INSTANCE = null;
    public static final int OK = 0;

    static {
        INSTANCE = new SearchError();
    }

    private SearchError() {
    }
}
