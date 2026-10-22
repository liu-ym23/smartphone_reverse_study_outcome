package com.bytedance.android.marketing.sdk.impl.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/utils/ECMarketingErrorType;", "", "", "code", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "ACTIVITY_DESTROYED_NO_DISPLAY", "PROTOCOL_PARSE_ERROR", "NOT_ROOT_VIEW_NO_DISPLAY", "GET_HOST_CONTAINER_FAILED", "CREATE_LYNX_VIEW_FAILED", "LYNX_VIEW_INNER_ERROR", "ROUTER_SCHEMA_FORMAT_ERROR", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMarketingErrorType extends Enum<ECMarketingErrorType> {
    public static final ECMarketingErrorType ACTIVITY_DESTROYED_NO_DISPLAY = null;
    public static final ECMarketingErrorType CREATE_LYNX_VIEW_FAILED = null;
    public static final ECMarketingErrorType GET_HOST_CONTAINER_FAILED = null;
    public static final ECMarketingErrorType LYNX_VIEW_INNER_ERROR = null;
    public static final ECMarketingErrorType NOT_ROOT_VIEW_NO_DISPLAY = null;
    public static final ECMarketingErrorType PROTOCOL_PARSE_ERROR = null;
    public static final ECMarketingErrorType ROUTER_SCHEMA_FORMAT_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECMarketingErrorType[] f162813a = null;
    private final String code;

    static {
        ECMarketingErrorType r100 = new ECMarketingErrorType("ACTIVITY_DESTROYED_NO_DISPLAY", 0, "activity_destroyed_no_display");
        ACTIVITY_DESTROYED_NO_DISPLAY = r100;
        ECMarketingErrorType r101 = new ECMarketingErrorType("PROTOCOL_PARSE_ERROR", 1, "protocol_parse_error");
        PROTOCOL_PARSE_ERROR = r101;
        ECMarketingErrorType r102 = new ECMarketingErrorType("NOT_ROOT_VIEW_NO_DISPLAY", 2, "not_root_view_no_display");
        NOT_ROOT_VIEW_NO_DISPLAY = r102;
        ECMarketingErrorType r103 = new ECMarketingErrorType("GET_HOST_CONTAINER_FAILED", 3, "get_host_container_failed");
        GET_HOST_CONTAINER_FAILED = r103;
        ECMarketingErrorType r104 = new ECMarketingErrorType("CREATE_LYNX_VIEW_FAILED", 4, "create_lynx_view_failed");
        CREATE_LYNX_VIEW_FAILED = r104;
        ECMarketingErrorType r105 = new ECMarketingErrorType("LYNX_VIEW_INNER_ERROR", 5, "lynx_view_inner_error");
        LYNX_VIEW_INNER_ERROR = r105;
        ECMarketingErrorType r106 = new ECMarketingErrorType("ROUTER_SCHEMA_FORMAT_ERROR", 6, "router_schema_format_error");
        ROUTER_SCHEMA_FORMAT_ERROR = r106;
        f162813a = new ECMarketingErrorType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ECMarketingErrorType valueOf(String r100) {
        return (ECMarketingErrorType) r27.a.a(ECMarketingErrorType.class, r100);
    }

    public static ECMarketingErrorType[] values() {
        return (ECMarketingErrorType[]) f162813a.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public ECMarketingErrorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.code = r102;
    }
}
