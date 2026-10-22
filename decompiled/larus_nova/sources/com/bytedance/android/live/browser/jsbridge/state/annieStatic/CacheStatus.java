package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/state/annieStatic/CacheStatus;", "", "", "code", "I", "getCode", "()I", "HIT_CACHE", "MISS_CACHE", "ILLEGAL_KEY", "READ_ERROR", "INVALID_CACHE", "NOT_IN_ALLOW_LIST", "OTHER_ERROR", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CacheStatus extends Enum<CacheStatus> {
    public static final CacheStatus HIT_CACHE = null;
    public static final CacheStatus ILLEGAL_KEY = null;
    public static final CacheStatus INVALID_CACHE = null;
    public static final CacheStatus MISS_CACHE = null;
    public static final CacheStatus NOT_IN_ALLOW_LIST = null;
    public static final CacheStatus OTHER_ERROR = null;
    public static final CacheStatus READ_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheStatus[] f63942a = null;
    private final int code;

    static {
        CacheStatus r100 = new CacheStatus("HIT_CACHE", 0, 1);
        HIT_CACHE = r100;
        CacheStatus r101 = new CacheStatus("MISS_CACHE", 1, -1);
        MISS_CACHE = r101;
        CacheStatus r102 = new CacheStatus("ILLEGAL_KEY", 2, -2);
        ILLEGAL_KEY = r102;
        CacheStatus r103 = new CacheStatus("READ_ERROR", 3, -3);
        READ_ERROR = r103;
        CacheStatus r104 = new CacheStatus("INVALID_CACHE", 4, -4);
        INVALID_CACHE = r104;
        CacheStatus r105 = new CacheStatus("NOT_IN_ALLOW_LIST", 5, -5);
        NOT_IN_ALLOW_LIST = r105;
        CacheStatus r106 = new CacheStatus("OTHER_ERROR", 6, -1000);
        OTHER_ERROR = r106;
        f63942a = new CacheStatus[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static CacheStatus valueOf(String r100) {
        return (CacheStatus) r27.a.a(CacheStatus.class, r100);
    }

    public static CacheStatus[] values() {
        return (CacheStatus[]) f63942a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public CacheStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
