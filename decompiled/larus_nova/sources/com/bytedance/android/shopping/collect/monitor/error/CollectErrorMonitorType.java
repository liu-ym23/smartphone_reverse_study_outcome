package com.bytedance.android.shopping.collect.monitor.error;

import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/collect/monitor/error/CollectErrorMonitorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", SuggestPromptErrorType.ERROR_TYPE_CRASH, "SERIOUS_BUSINESS_ERROR", "MINOR_BUSINESS_ERROR", "SERVER_BUSINESS_ERROR", "SELF_FUN_ERROR", "COLLECT_QUERY_API_ERROR", "COLLECT_UPDATE_API_ERROR", "AUTO_COUPON_API_ERROR", "ADD_CART_API_ERROR", "TRIGGER_INTERCEPTED", "CACHE_TRIGGER_INTERCEPTED", "UPLINK_ROLLBACK", "YATA_REQUEST_ERROR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectErrorMonitorType extends Enum<CollectErrorMonitorType> {
    public static final CollectErrorMonitorType ADD_CART_API_ERROR = null;
    public static final CollectErrorMonitorType AUTO_COUPON_API_ERROR = null;
    public static final CollectErrorMonitorType CACHE_TRIGGER_INTERCEPTED = null;
    public static final CollectErrorMonitorType COLLECT_QUERY_API_ERROR = null;
    public static final CollectErrorMonitorType COLLECT_UPDATE_API_ERROR = null;
    public static final CollectErrorMonitorType CRASH = null;
    public static final CollectErrorMonitorType MINOR_BUSINESS_ERROR = null;
    public static final CollectErrorMonitorType SELF_FUN_ERROR = null;
    public static final CollectErrorMonitorType SERIOUS_BUSINESS_ERROR = null;
    public static final CollectErrorMonitorType SERVER_BUSINESS_ERROR = null;
    public static final CollectErrorMonitorType TRIGGER_INTERCEPTED = null;
    public static final CollectErrorMonitorType UPLINK_ROLLBACK = null;
    public static final CollectErrorMonitorType YATA_REQUEST_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollectErrorMonitorType[] f172237a = null;
    private final String value;

    public static CollectErrorMonitorType valueOf(String r100) {
        return (CollectErrorMonitorType) r27.a.a(CollectErrorMonitorType.class, r100);
    }

    public static CollectErrorMonitorType[] values() {
        return (CollectErrorMonitorType[]) f172237a.clone();
    }

    static {
        CollectErrorMonitorType r100 = new CollectErrorMonitorType(SuggestPromptErrorType.ERROR_TYPE_CRASH, 0, SuggestPromptErrorType.ERROR_TYPE_CRASH);
        CRASH = r100;
        CollectErrorMonitorType r101 = new CollectErrorMonitorType("SERIOUS_BUSINESS_ERROR", 1, "SERIOUS_BUSINESS_ERROR");
        SERIOUS_BUSINESS_ERROR = r101;
        CollectErrorMonitorType r102 = new CollectErrorMonitorType("MINOR_BUSINESS_ERROR", 2, "MINOR_BUSINESS_ERROR");
        MINOR_BUSINESS_ERROR = r102;
        CollectErrorMonitorType r103 = new CollectErrorMonitorType("SERVER_BUSINESS_ERROR", 3, "SERVER_BUSINESS_ERROR");
        SERVER_BUSINESS_ERROR = r103;
        CollectErrorMonitorType r104 = new CollectErrorMonitorType("SELF_FUN_ERROR", 4, "SELF_FUN_ERROR");
        SELF_FUN_ERROR = r104;
        CollectErrorMonitorType r105 = new CollectErrorMonitorType("COLLECT_QUERY_API_ERROR", 5, "COLLECT_QUERY_API_ERROR");
        COLLECT_QUERY_API_ERROR = r105;
        CollectErrorMonitorType r106 = new CollectErrorMonitorType("COLLECT_UPDATE_API_ERROR", 6, "COLLECT_UPDATE_API_ERROR");
        COLLECT_UPDATE_API_ERROR = r106;
        CollectErrorMonitorType r107 = new CollectErrorMonitorType("AUTO_COUPON_API_ERROR", 7, "AUTO_COUPON_API_ERROR");
        AUTO_COUPON_API_ERROR = r107;
        CollectErrorMonitorType r108 = new CollectErrorMonitorType("ADD_CART_API_ERROR", 8, "ADD_CART_API_ERROR");
        ADD_CART_API_ERROR = r108;
        CollectErrorMonitorType r109 = new CollectErrorMonitorType("TRIGGER_INTERCEPTED", 9, "TRIGGER_INTERCEPTED");
        TRIGGER_INTERCEPTED = r109;
        CollectErrorMonitorType r110 = new CollectErrorMonitorType("CACHE_TRIGGER_INTERCEPTED", 10, "CACHE_TRIGGER_INTERCEPTED");
        CACHE_TRIGGER_INTERCEPTED = r110;
        CollectErrorMonitorType r111 = new CollectErrorMonitorType("UPLINK_ROLLBACK", 11, "UPLINK_ROLLBACK");
        UPLINK_ROLLBACK = r111;
        CollectErrorMonitorType r112 = new CollectErrorMonitorType("YATA_REQUEST_ERROR", 12, "yata_request_error");
        YATA_REQUEST_ERROR = r112;
        f172237a = new CollectErrorMonitorType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final String getValue() {
        return this.value;
    }

    public CollectErrorMonitorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
