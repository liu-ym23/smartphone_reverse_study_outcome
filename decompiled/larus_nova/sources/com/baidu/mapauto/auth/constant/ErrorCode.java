package com.baidu.mapauto.auth.constant;

import com.amap.api.services.core.AMapException;

/* JADX INFO: loaded from: classes39.dex */
public final class ErrorCode {
    public static final int CODE_CHECK_SIGN_ERROR = -1006;
    public static final int CODE_INNER_ERROR = -1001;
    public static final int CODE_MULTI_FUNC_ERROR = -1007;
    public static final int CODE_NET_WORK_ERROR = -1003;
    public static final int CODE_NET_WORK_TIMEOUT = -1004;
    public static final int CODE_PARAMETER_ERROR = -1002;
    public static final int CODE_SERVER_ERROR = -1005;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNKNOWN_ERROR = -1000;

    public ErrorCode() {
    }

    public static String getCodeDesc(int r100) {
        if (r100 != 0) goto L6;
        return "成功";
    L6:
        if (r100 != (-1001)) goto L10;
        return "内部错误";
    L10:
        if (r100 != (-1002)) goto L14;
        return "参数错误";
    L14:
        if (r100 != (-1003)) goto L18;
        return "网络错误";
    L18:
        if (r100 != (-1004)) goto L22;
        return "网络超时错误";
    L22:
        if (r100 != (-1005)) goto L26;
        return "服务错误";
    L26:
        if (r100 != (-1006)) goto L30;
        return "校验错误";
    L30:
        if (r100 != (-1007)) goto L34;
        return "所申请一个或多个LICENSE没有权限";
    L34:
        if (r100 != (-1000)) goto L38;
        return AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
    L38:
        throw new UnsupportedOperationException();
    }
}
