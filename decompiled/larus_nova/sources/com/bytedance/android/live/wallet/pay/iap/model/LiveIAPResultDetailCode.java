package com.bytedance.android.live.wallet.pay.iap.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/wallet/pay/iap/model/LiveIAPResultDetailCode;", "", "", "isGoogleErrorCode", "", "value", "I", "getValue", "()I", "CODE_UNKNOWN", "CODE_PAY_CHANNEL_START_FAIL", "CODE_GOOGLE_OK", "CODE_GOOGLE_ERROR", "CODE_GOOGLE_USER_CANCEL", "CODE_GOOGLE_NETWORK_ERROR", "CODE_GOOGLE_FEATURE_NOT_SUPPORT", "CODE_GOOGLE_DEVELOPER_ERROR", "CODE_GOOGLE_SERVICE_TIMEOUT", "CODE_GOOGLE_SERVICE_DISCONNECTED", "CODE_GOOGLE_SERVICE_UNAVAILABLE", "CODE_GOOGLE_GOOGLE_BILLING_UNAVAILABLE", "CODE_GOOGLE_GOOGLE_ITEM_UNAVAILABLE", "CODE_GOOGLE_GOOGLE_ITEM_ALREADY_OWNED", "CODE_GOOGLE_GOOGLE_ITEM_NOT_OWNED", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveIAPResultDetailCode extends Enum<LiveIAPResultDetailCode> {
    public static final LiveIAPResultDetailCode CODE_GOOGLE_DEVELOPER_ERROR = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_ERROR = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_FEATURE_NOT_SUPPORT = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_GOOGLE_BILLING_UNAVAILABLE = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_GOOGLE_ITEM_ALREADY_OWNED = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_GOOGLE_ITEM_NOT_OWNED = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_GOOGLE_ITEM_UNAVAILABLE = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_NETWORK_ERROR = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_OK = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_SERVICE_DISCONNECTED = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_SERVICE_TIMEOUT = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_SERVICE_UNAVAILABLE = null;
    public static final LiveIAPResultDetailCode CODE_GOOGLE_USER_CANCEL = null;
    public static final LiveIAPResultDetailCode CODE_PAY_CHANNEL_START_FAIL = null;
    public static final LiveIAPResultDetailCode CODE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveIAPResultDetailCode[] f102698a = null;
    private final int value;

    public static LiveIAPResultDetailCode valueOf(String r100) {
        return (LiveIAPResultDetailCode) a.a(LiveIAPResultDetailCode.class, r100);
    }

    public static LiveIAPResultDetailCode[] values() {
        return (LiveIAPResultDetailCode[]) f102698a.clone();
    }

    static {
        LiveIAPResultDetailCode r100 = new LiveIAPResultDetailCode("CODE_UNKNOWN", 0, -1);
        CODE_UNKNOWN = r100;
        LiveIAPResultDetailCode r101 = new LiveIAPResultDetailCode("CODE_PAY_CHANNEL_START_FAIL", 1, 101);
        CODE_PAY_CHANNEL_START_FAIL = r101;
        LiveIAPResultDetailCode r102 = new LiveIAPResultDetailCode("CODE_GOOGLE_OK", 2, 200);
        CODE_GOOGLE_OK = r102;
        LiveIAPResultDetailCode r103 = new LiveIAPResultDetailCode("CODE_GOOGLE_ERROR", 3, 201);
        CODE_GOOGLE_ERROR = r103;
        LiveIAPResultDetailCode r104 = new LiveIAPResultDetailCode("CODE_GOOGLE_USER_CANCEL", 4, 202);
        CODE_GOOGLE_USER_CANCEL = r104;
        LiveIAPResultDetailCode r105 = new LiveIAPResultDetailCode("CODE_GOOGLE_NETWORK_ERROR", 5, 203);
        CODE_GOOGLE_NETWORK_ERROR = r105;
        LiveIAPResultDetailCode r106 = new LiveIAPResultDetailCode("CODE_GOOGLE_FEATURE_NOT_SUPPORT", 6, 204);
        CODE_GOOGLE_FEATURE_NOT_SUPPORT = r106;
        LiveIAPResultDetailCode r107 = new LiveIAPResultDetailCode("CODE_GOOGLE_DEVELOPER_ERROR", 7, 205);
        CODE_GOOGLE_DEVELOPER_ERROR = r107;
        LiveIAPResultDetailCode r108 = new LiveIAPResultDetailCode("CODE_GOOGLE_SERVICE_TIMEOUT", 8, 206);
        CODE_GOOGLE_SERVICE_TIMEOUT = r108;
        LiveIAPResultDetailCode r109 = new LiveIAPResultDetailCode("CODE_GOOGLE_SERVICE_DISCONNECTED", 9, 207);
        CODE_GOOGLE_SERVICE_DISCONNECTED = r109;
        LiveIAPResultDetailCode r110 = new LiveIAPResultDetailCode("CODE_GOOGLE_SERVICE_UNAVAILABLE", 10, 208);
        CODE_GOOGLE_SERVICE_UNAVAILABLE = r110;
        LiveIAPResultDetailCode r111 = new LiveIAPResultDetailCode("CODE_GOOGLE_GOOGLE_BILLING_UNAVAILABLE", 11, 209);
        CODE_GOOGLE_GOOGLE_BILLING_UNAVAILABLE = r111;
        LiveIAPResultDetailCode r112 = new LiveIAPResultDetailCode("CODE_GOOGLE_GOOGLE_ITEM_UNAVAILABLE", 12, 210);
        CODE_GOOGLE_GOOGLE_ITEM_UNAVAILABLE = r112;
        LiveIAPResultDetailCode r113 = new LiveIAPResultDetailCode("CODE_GOOGLE_GOOGLE_ITEM_ALREADY_OWNED", 13, 211);
        CODE_GOOGLE_GOOGLE_ITEM_ALREADY_OWNED = r113;
        LiveIAPResultDetailCode r114 = new LiveIAPResultDetailCode("CODE_GOOGLE_GOOGLE_ITEM_NOT_OWNED", 14, 212);
        CODE_GOOGLE_GOOGLE_ITEM_NOT_OWNED = r114;
        f102698a = new LiveIAPResultDetailCode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public final boolean isGoogleErrorCode() {
        if (this == CODE_GOOGLE_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveIAPResultDetailCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
