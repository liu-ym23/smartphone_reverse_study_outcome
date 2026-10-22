package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/MVOperation;", "", "", "value", "I", "getValue", "()I", "MVOperation_Unknown", "MVOperation_Start", "MVOperation_Close", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MVOperation extends Enum<MVOperation> {
    public static final MVOperation MVOperation_Close = null;
    public static final MVOperation MVOperation_Start = null;
    public static final MVOperation MVOperation_Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MVOperation[] f153574a = null;
    private final int value;

    static {
        MVOperation r100 = new MVOperation("MVOperation_Unknown", 0, 0);
        MVOperation_Unknown = r100;
        MVOperation r101 = new MVOperation("MVOperation_Start", 1, 1);
        MVOperation_Start = r101;
        MVOperation r102 = new MVOperation("MVOperation_Close", 2, 2);
        MVOperation_Close = r102;
        f153574a = new MVOperation[]{r100, r101, r102};
    }

    public static MVOperation valueOf(String r100) {
        return (MVOperation) r27.a.a(MVOperation.class, r100);
    }

    public static MVOperation[] values() {
        return (MVOperation[]) f153574a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MVOperation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
