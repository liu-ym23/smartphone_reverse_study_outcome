package com.byted.cast.common.source;

/* JADX INFO: loaded from: classes39.dex */
public interface ISendResultListener extends com.byted.cast.common.api.ISendResultListener {
    public static final int ERROR_CODE_BDLINK_HTTP_ERROR = 23111002;
    public static final int ERROR_CODE_BDLINK_NO_RESPONSE = 23111001;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_BODY_IS_NULL = 22568605;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_DEVICE_NULL = 22568601;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_JSON_EXCEPTION = 22568603;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_NOT_SUPPORT_CUSTOMIZE = 22568602;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_NULL = 22568600;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL = 22568604;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_SINK_ERROR = 22568606;
    public static final String ERROR_MSG_BDLINK_HTTP_ERROR = "bdlink http error, status code is ";
    public static final String ERROR_MSG_BDLINK_NO_RESPONSE = "bdlink no response";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_BODY_IS_NULL = "body is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_DEVICE_NULL = "device is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_JSON_EXCEPTION = "json exception";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_NOT_SUPPORT_CUSTOMIZE = "device is not support customized service";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_NULL = "customize service is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL = "response is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_SINK_ERROR = "sink error";

    /* JADX INFO: renamed from: com.byted.cast.common.source.ISendResultListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onReceive(ISendResultListener r100, String r101) {
        }
    }

    void onError(ServiceInfo r100, int r101, String r102);

    @Override // com.byted.cast.common.api.ISendResultListener
    void onReceive(String r100);

    @Override // com.byted.cast.common.api.ISendResultListener
    void onSuccess();
}
