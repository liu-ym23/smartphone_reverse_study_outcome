package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/ErrorMonitorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", SuggestPromptErrorType.ERROR_TYPE_CRASH, "NETWORK_ERROR", "RUNTIME_ERROR", "SELF_EVENT_ERROR", "ERROR_PAGE_SHOW", "LOADING_MASK_CLICK", "CLOSE_WITH_LOADING", "YATA_REQUEST_ERROR", "TRANSFORM_TO_JSON_ERROR", "LOAD_AGAIN_ERROR", "YATA_ERROR", "BLANK_PARAMS", "RECEIVE_PARAMS_FROM_JSB", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorMonitorType extends Enum<ErrorMonitorType> {
    public static final ErrorMonitorType BLANK_PARAMS = null;
    public static final ErrorMonitorType CLOSE_WITH_LOADING = null;
    public static final ErrorMonitorType CRASH = null;
    public static final ErrorMonitorType ERROR_PAGE_SHOW = null;
    public static final ErrorMonitorType LOADING_MASK_CLICK = null;
    public static final ErrorMonitorType LOAD_AGAIN_ERROR = null;
    public static final ErrorMonitorType NETWORK_ERROR = null;
    public static final ErrorMonitorType RECEIVE_PARAMS_FROM_JSB = null;
    public static final ErrorMonitorType RUNTIME_ERROR = null;
    public static final ErrorMonitorType SELF_EVENT_ERROR = null;
    public static final ErrorMonitorType TRANSFORM_TO_JSON_ERROR = null;
    public static final ErrorMonitorType YATA_ERROR = null;
    public static final ErrorMonitorType YATA_REQUEST_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorMonitorType[] f164219a = null;
    private final String value;

    public static ErrorMonitorType valueOf(String r100) {
        return (ErrorMonitorType) a.a(ErrorMonitorType.class, r100);
    }

    public static ErrorMonitorType[] values() {
        return (ErrorMonitorType[]) f164219a.clone();
    }

    static {
        ErrorMonitorType r100 = new ErrorMonitorType(SuggestPromptErrorType.ERROR_TYPE_CRASH, 0, SuggestPromptErrorType.ERROR_TYPE_CRASH);
        CRASH = r100;
        ErrorMonitorType r101 = new ErrorMonitorType("NETWORK_ERROR", 1, BuyNowCloseMethod.NETWORK_ERROR);
        NETWORK_ERROR = r101;
        ErrorMonitorType r102 = new ErrorMonitorType("RUNTIME_ERROR", 2, "runtime_error");
        RUNTIME_ERROR = r102;
        ErrorMonitorType r103 = new ErrorMonitorType("SELF_EVENT_ERROR", 3, "self_event_error");
        SELF_EVENT_ERROR = r103;
        ErrorMonitorType r104 = new ErrorMonitorType("ERROR_PAGE_SHOW", 4, CheckPointType.ERROR_PAGE_SHOW);
        ERROR_PAGE_SHOW = r104;
        ErrorMonitorType r105 = new ErrorMonitorType("LOADING_MASK_CLICK", 5, "loading_mask_click");
        LOADING_MASK_CLICK = r105;
        ErrorMonitorType r106 = new ErrorMonitorType("CLOSE_WITH_LOADING", 6, "close_with_loading");
        CLOSE_WITH_LOADING = r106;
        ErrorMonitorType r107 = new ErrorMonitorType("YATA_REQUEST_ERROR", 7, "yata_request_error");
        YATA_REQUEST_ERROR = r107;
        ErrorMonitorType r108 = new ErrorMonitorType("TRANSFORM_TO_JSON_ERROR", 8, "error when transform yata fields to JSON");
        TRANSFORM_TO_JSON_ERROR = r108;
        ErrorMonitorType r109 = new ErrorMonitorType("LOAD_AGAIN_ERROR", 9, "LOAD_AGAIN_ERROR");
        LOAD_AGAIN_ERROR = r109;
        ErrorMonitorType r110 = new ErrorMonitorType("YATA_ERROR", 10, "yata_error");
        YATA_ERROR = r110;
        ErrorMonitorType r111 = new ErrorMonitorType("BLANK_PARAMS", 11, "blank_params");
        BLANK_PARAMS = r111;
        ErrorMonitorType r112 = new ErrorMonitorType("RECEIVE_PARAMS_FROM_JSB", 12, "receive_params_from_jsb");
        RECEIVE_PARAMS_FROM_JSB = r112;
        f164219a = new ErrorMonitorType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final String getValue() {
        return this.value;
    }

    public ErrorMonitorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
