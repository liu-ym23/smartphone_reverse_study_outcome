package com.bytedance.android.livesdk.gift.platform.core.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/SendGiftStrategy;", "", "ONE_SEND_ONE_REQUEST", "REQUEST_AFTER_RESPONSE", "ONLY_SEND_ONCE", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SendGiftStrategy extends Enum<SendGiftStrategy> {
    public static final SendGiftStrategy ONE_SEND_ONE_REQUEST = null;
    public static final SendGiftStrategy ONLY_SEND_ONCE = null;
    public static final SendGiftStrategy REQUEST_AFTER_RESPONSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendGiftStrategy[] f130829a = null;

    static {
        SendGiftStrategy r100 = new SendGiftStrategy("ONE_SEND_ONE_REQUEST", 0);
        ONE_SEND_ONE_REQUEST = r100;
        SendGiftStrategy r101 = new SendGiftStrategy("REQUEST_AFTER_RESPONSE", 1);
        REQUEST_AFTER_RESPONSE = r101;
        SendGiftStrategy r102 = new SendGiftStrategy("ONLY_SEND_ONCE", 2);
        ONLY_SEND_ONCE = r102;
        f130829a = new SendGiftStrategy[]{r100, r101, r102};
    }

    public static SendGiftStrategy valueOf(String r100) {
        return (SendGiftStrategy) r27.a.a(SendGiftStrategy.class, r100);
    }

    public static SendGiftStrategy[] values() {
        return (SendGiftStrategy[]) f130829a.clone();
    }

    public SendGiftStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
