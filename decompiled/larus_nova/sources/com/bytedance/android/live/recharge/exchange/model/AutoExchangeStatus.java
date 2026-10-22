package com.bytedance.android.live.recharge.exchange.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/model/AutoExchangeStatus;", "", "", "value", "I", "getValue", "()I", "UnKnown", "UnSync", "Closed", "Open", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AutoExchangeStatus extends Enum<AutoExchangeStatus> {
    public static final AutoExchangeStatus Closed = null;
    public static final AutoExchangeStatus Open = null;
    public static final AutoExchangeStatus UnKnown = null;
    public static final AutoExchangeStatus UnSync = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoExchangeStatus[] f89857a = null;
    private final int value;

    static {
        AutoExchangeStatus r100 = new AutoExchangeStatus("UnKnown", 0, -1);
        UnKnown = r100;
        AutoExchangeStatus r101 = new AutoExchangeStatus("UnSync", 1, 0);
        UnSync = r101;
        AutoExchangeStatus r102 = new AutoExchangeStatus("Closed", 2, 1);
        Closed = r102;
        AutoExchangeStatus r103 = new AutoExchangeStatus("Open", 3, 2);
        Open = r103;
        f89857a = new AutoExchangeStatus[]{r100, r101, r102, r103};
    }

    public static AutoExchangeStatus valueOf(String r100) {
        return (AutoExchangeStatus) r27.a.a(AutoExchangeStatus.class, r100);
    }

    public static AutoExchangeStatus[] values() {
        return (AutoExchangeStatus[]) f89857a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AutoExchangeStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
