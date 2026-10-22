package com.byted.cast.common.sink;

/* JADX INFO: loaded from: classes39.dex */
public interface ISendResultListener extends com.byted.cast.common.api.ISendResultListener {
    public static final int ERROR_CODE_BDLINK_HTTP_ERROR = 23110002;
    public static final int ERROR_CODE_BDLINK_NO_RESPONSE = 23110001;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_DEVICE_NULL = 22568301;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_INFO_NULL = 22568302;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_JSON_EXCEPTION = 22568306;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_MESSAGE_NULL = 22568303;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_NULL = 22568300;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_RESPONSE_NULL = 22568308;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_SOURCE_ERROR = 22568309;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_SOURCE_NOT_SUBSCRIBER = 22568307;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_STATE_VARIABLE_NULL = 22568305;
    public static final int ERROR_CODE_DLNA_CUSTOMIZED_SERVICE_SUBSCRIBERS_EMPTY = 22568304;
    public static final String ERROR_MSG_BDLINK_HTTP_ERROR = "bdlink http error, status code is ";
    public static final String ERROR_MSG_BDLINK_NO_RESPONSE = "bdlink no response";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_DEVICE_NULL = "device is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_INFO_NULL = "service info is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_JSON_EXCEPTION = "json exception";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_MESSAGE_NULL = "message is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_NULL = "customize service is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_NULL = "source not response";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_SOURCE_ERROR = "source return error";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_SOURCE_NOT_SUBSCRIBER = "source not subscribe";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_STATE_VARIABLE_NULL = "customize service sendMessage StateVariable is null";
    public static final String ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_SUBSCRIBERS_EMPTY = "subscribers is empty";

    /* JADX INFO: renamed from: com.byted.cast.common.sink.ISendResultListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onReceive(ISendResultListener r100, String r101) {
        }
    }

    void onError(String r100, int r101, String r102);

    @Override // com.byted.cast.common.api.ISendResultListener
    void onReceive(String r100);

    @Override // com.byted.cast.common.api.ISendResultListener
    void onSuccess();
}
