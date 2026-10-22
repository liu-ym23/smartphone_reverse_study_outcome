package com.bytedance.android.livehostapi.business.depend.share;

/* JADX INFO: loaded from: classes7.dex */
public interface IShareCallback {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.share.IShareCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onShareUiDismiss(IShareCallback r100) {
        }

        public static void $default$onShareUiShow(IShareCallback r100) {
        }
    }

    boolean interceptReportAction(IShareParams r100);

    void onFail(Throwable r100);

    void onShareUiDismiss();

    void onShareUiShow();

    void onSuccess(String r100, String r101);
}
