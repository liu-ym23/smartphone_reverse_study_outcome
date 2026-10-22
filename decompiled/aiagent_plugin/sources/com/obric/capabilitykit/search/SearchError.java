package com.obric.capabilitykit.search;

/* JADX INFO: loaded from: classes4.dex */
public final class SearchError {
    public static final int ERROR_QU = 5;
    public static final int ERR_API_DISABLED = 4;
    public static final int ERR_MEMORY_SERVICE_DISABLED = 6;
    public static final int ERR_MODEL_NOT_READY = 3;
    public static final SearchError INSTANCE = null;
    public static final int INTERNAL_ERROR = 1;
    public static final int OK = 0;
    public static final int SEARCH_ALL_ENTITY = 101;
    public static final int SERVICE_NOT_READY = 2;

    static {
        INSTANCE = new SearchError();
    }

    private SearchError() {
    }
}
