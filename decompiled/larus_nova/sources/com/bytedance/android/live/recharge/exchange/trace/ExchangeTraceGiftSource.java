package com.bytedance.android.live.recharge.exchange.trace;

import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/trace/ExchangeTraceGiftSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "EXCHANGE_SOURCE_FANS_CLUB", "EXCHANGE_SOURCE_RED_PACKET", "EXCHANGE_SOURCE_LOTTERY", "EXCHANGE_SOURCE_FANS_CLUB_SEND_GIFT", "EXCHANGE_SOURCE_LOTTERY_FANS_CLUB", "EXCHANGE_SOURCE_OTHER", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeTraceGiftSource extends Enum<ExchangeTraceGiftSource> {
    public static final ExchangeTraceGiftSource EXCHANGE_SOURCE_FANS_CLUB = null;
    public static final ExchangeTraceGiftSource EXCHANGE_SOURCE_FANS_CLUB_SEND_GIFT = null;
    public static final ExchangeTraceGiftSource EXCHANGE_SOURCE_LOTTERY = null;
    public static final ExchangeTraceGiftSource EXCHANGE_SOURCE_LOTTERY_FANS_CLUB = null;
    public static final ExchangeTraceGiftSource EXCHANGE_SOURCE_OTHER = null;
    public static final ExchangeTraceGiftSource EXCHANGE_SOURCE_RED_PACKET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExchangeTraceGiftSource[] f89968a = null;
    private final String value;

    static {
        ExchangeTraceGiftSource r100 = new ExchangeTraceGiftSource("EXCHANGE_SOURCE_FANS_CLUB", 0, PbRequest.SwitchType.FANS_CLUB);
        EXCHANGE_SOURCE_FANS_CLUB = r100;
        ExchangeTraceGiftSource r101 = new ExchangeTraceGiftSource("EXCHANGE_SOURCE_RED_PACKET", 1, "red_packet");
        EXCHANGE_SOURCE_RED_PACKET = r101;
        ExchangeTraceGiftSource r102 = new ExchangeTraceGiftSource("EXCHANGE_SOURCE_LOTTERY", 2, "lottery");
        EXCHANGE_SOURCE_LOTTERY = r102;
        ExchangeTraceGiftSource r103 = new ExchangeTraceGiftSource("EXCHANGE_SOURCE_FANS_CLUB_SEND_GIFT", 3, "fans_club_send_gift");
        EXCHANGE_SOURCE_FANS_CLUB_SEND_GIFT = r103;
        ExchangeTraceGiftSource r104 = new ExchangeTraceGiftSource("EXCHANGE_SOURCE_LOTTERY_FANS_CLUB", 4, "lottery_fans_club");
        EXCHANGE_SOURCE_LOTTERY_FANS_CLUB = r104;
        ExchangeTraceGiftSource r105 = new ExchangeTraceGiftSource("EXCHANGE_SOURCE_OTHER", 5, "other");
        EXCHANGE_SOURCE_OTHER = r105;
        f89968a = new ExchangeTraceGiftSource[]{r100, r101, r102, r103, r104, r105};
    }

    public static ExchangeTraceGiftSource valueOf(String r100) {
        return (ExchangeTraceGiftSource) r27.a.a(ExchangeTraceGiftSource.class, r100);
    }

    public static ExchangeTraceGiftSource[] values() {
        return (ExchangeTraceGiftSource[]) f89968a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ExchangeTraceGiftSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
