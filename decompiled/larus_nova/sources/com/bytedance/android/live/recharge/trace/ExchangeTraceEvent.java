package com.bytedance.android.live.recharge.trace;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/trace/ExchangeTraceEvent;", "", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "DIAMOND_AUTO_EXCHANGE", "INCOME_EXCHANGE_SUCCESS", "DIAMOND_EXCHANGE", "CLIENT_RECHARGE", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeTraceEvent extends Enum<ExchangeTraceEvent> {
    public static final ExchangeTraceEvent CLIENT_RECHARGE = null;
    public static final ExchangeTraceEvent DIAMOND_AUTO_EXCHANGE = null;
    public static final ExchangeTraceEvent DIAMOND_EXCHANGE = null;
    public static final ExchangeTraceEvent INCOME_EXCHANGE_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExchangeTraceEvent[] f90382a = null;
    private final String eventType;

    static {
        ExchangeTraceEvent r100 = new ExchangeTraceEvent("DIAMOND_AUTO_EXCHANGE", 0, "diamond_automatic_exchange");
        DIAMOND_AUTO_EXCHANGE = r100;
        ExchangeTraceEvent r101 = new ExchangeTraceEvent("INCOME_EXCHANGE_SUCCESS", 1, "income_exchange_success");
        INCOME_EXCHANGE_SUCCESS = r101;
        ExchangeTraceEvent r102 = new ExchangeTraceEvent("DIAMOND_EXCHANGE", 2, "diamond_exchange");
        DIAMOND_EXCHANGE = r102;
        ExchangeTraceEvent r103 = new ExchangeTraceEvent("CLIENT_RECHARGE", 3, "client_recharge");
        CLIENT_RECHARGE = r103;
        f90382a = new ExchangeTraceEvent[]{r100, r101, r102, r103};
    }

    public static ExchangeTraceEvent valueOf(String r100) {
        return (ExchangeTraceEvent) r27.a.a(ExchangeTraceEvent.class, r100);
    }

    public static ExchangeTraceEvent[] values() {
        return (ExchangeTraceEvent[]) f90382a.clone();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public ExchangeTraceEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventType = r102;
    }
}
