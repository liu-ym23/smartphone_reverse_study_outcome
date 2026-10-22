package com.byted.cast.common.api;

/* JADX INFO: loaded from: classes39.dex */
public interface ISendResultListener {

    /* JADX INFO: renamed from: com.byted.cast.common.api.ISendResultListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFailure(ISendResultListener r100, int r101, String r102) {
        }

        public static void $default$onReceive(ISendResultListener r100, String r101) {
        }
    }

    void onFailure(int r100, String r101);

    void onReceive(String r100);

    void onSuccess();
}
