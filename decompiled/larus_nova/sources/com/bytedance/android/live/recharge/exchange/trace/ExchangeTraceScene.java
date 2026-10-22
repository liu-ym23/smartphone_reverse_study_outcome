package com.bytedance.android.live.recharge.exchange.trace;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/trace/ExchangeTraceScene;", "", "", "value", "I", "getValue", "()I", "EXCHANGE_SCENE_UNKNOWN", "EXCHANGE_SCENE_EXCHANGE_DIALOG", "EXCHANGE_SCENE_COMBINE_PAY", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeTraceScene extends Enum<ExchangeTraceScene> {
    public static final ExchangeTraceScene EXCHANGE_SCENE_COMBINE_PAY = null;
    public static final ExchangeTraceScene EXCHANGE_SCENE_EXCHANGE_DIALOG = null;
    public static final ExchangeTraceScene EXCHANGE_SCENE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExchangeTraceScene[] f89970a = null;
    private final int value;

    static {
        ExchangeTraceScene r100 = new ExchangeTraceScene("EXCHANGE_SCENE_UNKNOWN", 0, -1);
        EXCHANGE_SCENE_UNKNOWN = r100;
        ExchangeTraceScene r101 = new ExchangeTraceScene("EXCHANGE_SCENE_EXCHANGE_DIALOG", 1, 1);
        EXCHANGE_SCENE_EXCHANGE_DIALOG = r101;
        ExchangeTraceScene r102 = new ExchangeTraceScene("EXCHANGE_SCENE_COMBINE_PAY", 2, 5);
        EXCHANGE_SCENE_COMBINE_PAY = r102;
        f89970a = new ExchangeTraceScene[]{r100, r101, r102};
    }

    public static ExchangeTraceScene valueOf(String r100) {
        return (ExchangeTraceScene) r27.a.a(ExchangeTraceScene.class, r100);
    }

    public static ExchangeTraceScene[] values() {
        return (ExchangeTraceScene[]) f89970a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExchangeTraceScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
