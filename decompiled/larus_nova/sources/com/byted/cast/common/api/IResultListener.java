package com.byted.cast.common.api;

/* JADX INFO: loaded from: classes39.dex */
public interface IResultListener {
    public static final int ERROR_CODE_GOOGLECAST_NOT_EXIST_ITEMID = 26500002;
    public static final int ERROR_CODE_GOOGLECAST_REMOTE_MEDIA_CLIENT_IS_NULL = 26500001;
    public static final String ERROR_MSG_GOOGLECAST_REMOTE_MEDIA_CLIENT_IS_NULL = "GoogleCast remote media client is null.";
    public static final String ERROR_MSG_GOOGLECAST__NOT_EXIST_ITEMID = "GoogleCast not exist itemId.";

    /* JADX INFO: renamed from: com.byted.cast.common.api.IResultListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onSuccess(IResultListener r100, Object r101) {
        }
    }

    void onFail(int r100, String r101);

    void onSuccess();

    void onSuccess(Object r100);
}
