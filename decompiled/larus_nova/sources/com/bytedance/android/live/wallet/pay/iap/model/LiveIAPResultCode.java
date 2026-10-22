package com.bytedance.android.live.wallet.pay.iap.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/wallet/pay/iap/model/LiveIAPResultCode;", "", "", "value", "I", "getValue", "()I", "UN_KNOWN", "SUCCESS", "INIT_FAIL", "UN_INIT", "PARAM_ILLEGAL", "NET_FAIL", "PAY_SUCCESS", "PAY_FAIL", "PAY_CANCEL", "PAY_PROCESSING", "PAY_UN_ACK", "PAY_PENDING", "PAY_QUERY_PURCHASE_SUCCESS", "PAY_QUERY_PURCHASE_FAIL", "QUERY_PRODUCT_SUCCESS", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveIAPResultCode extends Enum<LiveIAPResultCode> {
    public static final LiveIAPResultCode INIT_FAIL = null;
    public static final LiveIAPResultCode NET_FAIL = null;
    public static final LiveIAPResultCode PARAM_ILLEGAL = null;
    public static final LiveIAPResultCode PAY_CANCEL = null;
    public static final LiveIAPResultCode PAY_FAIL = null;
    public static final LiveIAPResultCode PAY_PENDING = null;
    public static final LiveIAPResultCode PAY_PROCESSING = null;
    public static final LiveIAPResultCode PAY_QUERY_PURCHASE_FAIL = null;
    public static final LiveIAPResultCode PAY_QUERY_PURCHASE_SUCCESS = null;
    public static final LiveIAPResultCode PAY_SUCCESS = null;
    public static final LiveIAPResultCode PAY_UN_ACK = null;
    public static final LiveIAPResultCode QUERY_PRODUCT_SUCCESS = null;
    public static final LiveIAPResultCode SUCCESS = null;
    public static final LiveIAPResultCode UN_INIT = null;
    public static final LiveIAPResultCode UN_KNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveIAPResultCode[] f102697a = null;
    private final int value;

    public static LiveIAPResultCode valueOf(String r100) {
        return (LiveIAPResultCode) a.a(LiveIAPResultCode.class, r100);
    }

    public static LiveIAPResultCode[] values() {
        return (LiveIAPResultCode[]) f102697a.clone();
    }

    static {
        LiveIAPResultCode r100 = new LiveIAPResultCode("UN_KNOWN", 0, -1);
        UN_KNOWN = r100;
        LiveIAPResultCode r101 = new LiveIAPResultCode("SUCCESS", 1, 0);
        SUCCESS = r101;
        LiveIAPResultCode r102 = new LiveIAPResultCode("INIT_FAIL", 2, 101);
        INIT_FAIL = r102;
        LiveIAPResultCode r103 = new LiveIAPResultCode("UN_INIT", 3, 102);
        UN_INIT = r103;
        LiveIAPResultCode r104 = new LiveIAPResultCode("PARAM_ILLEGAL", 4, 103);
        PARAM_ILLEGAL = r104;
        LiveIAPResultCode r105 = new LiveIAPResultCode("NET_FAIL", 5, 201);
        NET_FAIL = r105;
        LiveIAPResultCode r106 = new LiveIAPResultCode("PAY_SUCCESS", 6, 1000);
        PAY_SUCCESS = r106;
        LiveIAPResultCode r107 = new LiveIAPResultCode("PAY_FAIL", 7, 1001);
        PAY_FAIL = r107;
        LiveIAPResultCode r108 = new LiveIAPResultCode("PAY_CANCEL", 8, 1002);
        PAY_CANCEL = r108;
        LiveIAPResultCode r109 = new LiveIAPResultCode("PAY_PROCESSING", 9, 1003);
        PAY_PROCESSING = r109;
        LiveIAPResultCode r110 = new LiveIAPResultCode("PAY_UN_ACK", 10, 1004);
        PAY_UN_ACK = r110;
        LiveIAPResultCode r111 = new LiveIAPResultCode("PAY_PENDING", 11, 1005);
        PAY_PENDING = r111;
        LiveIAPResultCode r112 = new LiveIAPResultCode("PAY_QUERY_PURCHASE_SUCCESS", 12, 2000);
        PAY_QUERY_PURCHASE_SUCCESS = r112;
        LiveIAPResultCode r113 = new LiveIAPResultCode("PAY_QUERY_PURCHASE_FAIL", 13, 2001);
        PAY_QUERY_PURCHASE_FAIL = r113;
        LiveIAPResultCode r114 = new LiveIAPResultCode("QUERY_PRODUCT_SUCCESS", 14, 3000);
        QUERY_PRODUCT_SUCCESS = r114;
        f102697a = new LiveIAPResultCode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public LiveIAPResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
