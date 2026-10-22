package com.bytedance.android.live.incentive.balance;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/RequestFrom;", "", "Unknown", "ExchangePanel", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RequestFrom extends Enum<RequestFrom> {
    public static final RequestFrom ExchangePanel = null;
    public static final RequestFrom Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestFrom[] f69326a = null;

    static {
        RequestFrom r100 = new RequestFrom("Unknown", 0);
        Unknown = r100;
        RequestFrom r101 = new RequestFrom("ExchangePanel", 1);
        ExchangePanel = r101;
        f69326a = new RequestFrom[]{r100, r101};
    }

    public static RequestFrom valueOf(String r100) {
        return (RequestFrom) r27.a.a(RequestFrom.class, r100);
    }

    public static RequestFrom[] values() {
        return (RequestFrom[]) f69326a.clone();
    }

    public RequestFrom(String r100, int r101) {
        super(r100, r101);
    }
}
