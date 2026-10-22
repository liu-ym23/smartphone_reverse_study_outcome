package com.bytedance.android.live.broadcast.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/VerifyResultEnum;", "", "", "value", "I", "getValue", "()I", "VerifyResultUnknown", "VerifyResultSuccess", "VerifyResultFailed", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VerifyResultEnum extends Enum<VerifyResultEnum> {
    public static final VerifyResultEnum VerifyResultFailed = null;
    public static final VerifyResultEnum VerifyResultSuccess = null;
    public static final VerifyResultEnum VerifyResultUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VerifyResultEnum[] f59025a = null;
    private final int value;

    static {
        VerifyResultEnum r100 = new VerifyResultEnum("VerifyResultUnknown", 0, 0);
        VerifyResultUnknown = r100;
        VerifyResultEnum r101 = new VerifyResultEnum("VerifyResultSuccess", 1, 1);
        VerifyResultSuccess = r101;
        VerifyResultEnum r102 = new VerifyResultEnum("VerifyResultFailed", 2, 2);
        VerifyResultFailed = r102;
        f59025a = new VerifyResultEnum[]{r100, r101, r102};
    }

    public static VerifyResultEnum valueOf(String r100) {
        return (VerifyResultEnum) r27.a.a(VerifyResultEnum.class, r100);
    }

    public static VerifyResultEnum[] values() {
        return (VerifyResultEnum[]) f59025a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public VerifyResultEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
