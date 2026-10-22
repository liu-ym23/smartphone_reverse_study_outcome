package com.byted.cast.common.config;

/* JADX INFO: loaded from: classes39.dex */
public interface IInitListener {
    public static final int ERROR_CODE_BAN_LICENSE = 17010016;
    public static final int ERROR_CODE_EMPTY_CONFIG = 17010011;
    public static final int ERROR_CODE_IMPORT_LICENSE_INVALID = 17010014;
    public static final int ERROR_CODE_INVALID_PARAMS = 17010019;
    public static final String ERROR_MSG_BAN_LICENSE = "The license has been banned";
    public static final String ERROR_MSG_EMPTY_CONFIG = "Init with null config";
    public static final String ERROR_MSG_IMPORT_LICENSE_INVALID = "Init with invalid license";
    public static final String ERROR_MSG_INVALID_PARAMS = "Init with empty projectId";

    /* JADX INFO: renamed from: com.byted.cast.common.config.IInitListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onError(IInitListener r100, int r101, String r102) {
        }

        public static void $default$onFail(IInitListener r100, int r101, String r102, Exception r103) {
        }
    }

    void onError(int r100, String r101);

    void onFail(int r100, String r101, Exception r102);

    void onSuccess();
}
