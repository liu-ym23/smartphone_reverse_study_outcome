package com.amap.api.maps;

import com.amap.api.mapcore.util.p0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class AMapException extends Exception {
    public static final String AMAP_NOT_SUPPORT = null;
    public static final String ERROR_CONNECTION = null;
    public static final String ERROR_FAILURE_AUTH = null;
    public static final String ERROR_FAILURE_OVERSEA_AUTH = null;
    public static final String ERROR_ILLEGAL_VALUE = null;
    public static final String ERROR_INVALID_PARAMETER = null;
    public static final String ERROR_IO = null;
    public static final String ERROR_LANGUAGE_AUTH = "多语言鉴权失败";
    public static final String ERROR_LIB_NOT_FIND = null;
    public static final String ERROR_LIB_NOT_MATCH = null;
    public static final String ERROR_NOT_AVAILABLE = null;
    public static final String ERROR_NOT_ENOUGH_SPACE = null;
    public static final String ERROR_NULL_PARAMETER = null;
    public static final String ERROR_PROTOCOL = null;
    public static final String ERROR_SOCKET = null;
    public static final String ERROR_SOCKE_TIME_OUT = null;
    public static final String ERROR_UNKNOWN = null;
    public static final String ERROR_UNKNOW_HOST = null;
    public static final String ERROR_UNKNOW_SERVICE = null;
    public static final String ERROR_URL = null;
    public static final String FEATURE_GLTF_NOT_SUPPORT = null;
    public static final String FEATURE_MVT_NOT_SUPPORT = null;
    public static final String FEATURE_TERRAIN_NOT_SUPPORT = null;
    public static final String ILLEGAL_AMAP_ARGUMENT = null;
    private static final long serialVersionUID = 5204097757158979179L;
    private String errorMessage;

    static {
        ERROR_IO = p0.a(2131034200);
        ERROR_SOCKET = p0.a(2131034201);
        ERROR_SOCKE_TIME_OUT = p0.a(2131034202);
        ERROR_INVALID_PARAMETER = p0.a(2131034203);
        ERROR_NULL_PARAMETER = p0.a(2131034204);
        ERROR_URL = p0.a(2131034205);
        ERROR_UNKNOW_HOST = p0.a(2131034206);
        ERROR_UNKNOW_SERVICE = p0.a(2131034207);
        ERROR_PROTOCOL = p0.a(2131034208);
        ERROR_CONNECTION = p0.a(2131034209);
        ERROR_UNKNOWN = p0.a(2131034210);
        ERROR_FAILURE_AUTH = p0.a(2131034211);
        ERROR_NOT_ENOUGH_SPACE = p0.a(2131034212);
        ERROR_NOT_AVAILABLE = p0.a(2131034213);
        ERROR_ILLEGAL_VALUE = p0.a(2131034214);
        AMAP_NOT_SUPPORT = p0.a(2131034215);
        ILLEGAL_AMAP_ARGUMENT = p0.a(2131034216);
        ERROR_FAILURE_OVERSEA_AUTH = p0.a(2131034217);
        FEATURE_MVT_NOT_SUPPORT = p0.a(R.bool.enable_system_foreground_service_default);
        FEATURE_GLTF_NOT_SUPPORT = p0.a(2131034218);
        FEATURE_TERRAIN_NOT_SUPPORT = p0.a(2131034219);
        ERROR_LIB_NOT_MATCH = p0.a(2131034220);
        ERROR_LIB_NOT_FIND = p0.a(2131034221);
    }

    public AMapException() {
        this.errorMessage = ERROR_UNKNOWN;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public AMapException(String r100) {
        super(r100);
        this.errorMessage = r100;
    }
}
