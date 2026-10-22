package com.bytedance.android.livesdk.gift.platform.business.sendGift.sendStrategy;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/sendGift/sendStrategy/ExchangeDiamondPluginCustomResultCode;", "", "", "value", "I", "getValue", "()I", "SendGiftSuccess", "ExchangeCancel", "ExchangeFailed", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExchangeDiamondPluginCustomResultCode extends Enum<ExchangeDiamondPluginCustomResultCode> {
    public static final ExchangeDiamondPluginCustomResultCode ExchangeCancel = null;
    public static final ExchangeDiamondPluginCustomResultCode ExchangeFailed = null;
    public static final ExchangeDiamondPluginCustomResultCode SendGiftSuccess = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExchangeDiamondPluginCustomResultCode[] f130147a = null;
    private final int value;

    static {
        ExchangeDiamondPluginCustomResultCode r100 = new ExchangeDiamondPluginCustomResultCode("SendGiftSuccess", 0, 1);
        SendGiftSuccess = r100;
        ExchangeDiamondPluginCustomResultCode r101 = new ExchangeDiamondPluginCustomResultCode("ExchangeCancel", 1, 2);
        ExchangeCancel = r101;
        ExchangeDiamondPluginCustomResultCode r102 = new ExchangeDiamondPluginCustomResultCode("ExchangeFailed", 2, 3);
        ExchangeFailed = r102;
        f130147a = new ExchangeDiamondPluginCustomResultCode[]{r100, r101, r102};
    }

    public static ExchangeDiamondPluginCustomResultCode valueOf(String r100) {
        return (ExchangeDiamondPluginCustomResultCode) a.a(ExchangeDiamondPluginCustomResultCode.class, r100);
    }

    public static ExchangeDiamondPluginCustomResultCode[] values() {
        return (ExchangeDiamondPluginCustomResultCode[]) f130147a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExchangeDiamondPluginCustomResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
