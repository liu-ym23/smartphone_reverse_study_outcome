package com.bytedance.android.live.recharge.exchange.trace;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/trace/ExchangeTraceBusinessScene;", "", "", "value", "I", "getValue", "()I", "EXCHANGE_BUSINESS_SCENE_UNKNOWN", "EXCHANGE_BUSINESS_SCENE_DIAMOND", "EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeTraceBusinessScene extends Enum<ExchangeTraceBusinessScene> {
    public static final ExchangeTraceBusinessScene EXCHANGE_BUSINESS_SCENE_DIAMOND = null;
    public static final ExchangeTraceBusinessScene EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON = null;
    public static final ExchangeTraceBusinessScene EXCHANGE_BUSINESS_SCENE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExchangeTraceBusinessScene[] f89967a = null;
    private final int value;

    static {
        ExchangeTraceBusinessScene r100 = new ExchangeTraceBusinessScene("EXCHANGE_BUSINESS_SCENE_UNKNOWN", 0, -1);
        EXCHANGE_BUSINESS_SCENE_UNKNOWN = r100;
        ExchangeTraceBusinessScene r101 = new ExchangeTraceBusinessScene("EXCHANGE_BUSINESS_SCENE_DIAMOND", 1, 1);
        EXCHANGE_BUSINESS_SCENE_DIAMOND = r101;
        ExchangeTraceBusinessScene r102 = new ExchangeTraceBusinessScene("EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON", 2, 6);
        EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON = r102;
        f89967a = new ExchangeTraceBusinessScene[]{r100, r101, r102};
    }

    public static ExchangeTraceBusinessScene valueOf(String r100) {
        return (ExchangeTraceBusinessScene) r27.a.a(ExchangeTraceBusinessScene.class, r100);
    }

    public static ExchangeTraceBusinessScene[] values() {
        return (ExchangeTraceBusinessScene[]) f89967a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExchangeTraceBusinessScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
