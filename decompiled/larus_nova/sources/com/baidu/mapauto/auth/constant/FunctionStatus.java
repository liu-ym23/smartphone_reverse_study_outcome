package com.baidu.mapauto.auth.constant;

/* JADX INFO: loaded from: classes39.dex */
public final class FunctionStatus {
    public static final int STATUS_HAVE_AUTH = 0;
    public static final int STATUS_NOT_AUTH = 1;

    public FunctionStatus() {
    }

    public static String getStatusDesc(int r100) {
        if (r100 != 0) goto L6;
        return "有权限";
    L6:
        if (r100 != 1) goto L10;
        return "没有权限";
    L10:
        throw new UnsupportedOperationException();
    }
}
