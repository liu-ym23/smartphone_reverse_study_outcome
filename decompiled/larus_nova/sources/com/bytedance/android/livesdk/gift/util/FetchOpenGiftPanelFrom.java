package com.bytedance.android.livesdk.gift.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/util/FetchOpenGiftPanelFrom;", "", "", "value", "I", "getValue", "()I", "TOUCH_DOWN", "DIALOG_CREATE_BEFORE", "GIFT_PANEL_CREATE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FetchOpenGiftPanelFrom extends Enum<FetchOpenGiftPanelFrom> {
    public static final FetchOpenGiftPanelFrom DIALOG_CREATE_BEFORE = null;
    public static final FetchOpenGiftPanelFrom GIFT_PANEL_CREATE = null;
    public static final FetchOpenGiftPanelFrom TOUCH_DOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FetchOpenGiftPanelFrom[] f132313a = null;
    private final int value;

    static {
        FetchOpenGiftPanelFrom r100 = new FetchOpenGiftPanelFrom("TOUCH_DOWN", 0, 0);
        TOUCH_DOWN = r100;
        FetchOpenGiftPanelFrom r101 = new FetchOpenGiftPanelFrom("DIALOG_CREATE_BEFORE", 1, 1);
        DIALOG_CREATE_BEFORE = r101;
        FetchOpenGiftPanelFrom r102 = new FetchOpenGiftPanelFrom("GIFT_PANEL_CREATE", 2, 2);
        GIFT_PANEL_CREATE = r102;
        f132313a = new FetchOpenGiftPanelFrom[]{r100, r101, r102};
    }

    public static FetchOpenGiftPanelFrom valueOf(String r100) {
        return (FetchOpenGiftPanelFrom) r27.a.a(FetchOpenGiftPanelFrom.class, r100);
    }

    public static FetchOpenGiftPanelFrom[] values() {
        return (FetchOpenGiftPanelFrom[]) f132313a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FetchOpenGiftPanelFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
