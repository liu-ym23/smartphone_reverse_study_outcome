package com.bytedance.android.livehostapi.business.depend.share;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class SimpleShareCallback implements IShareCallbackWithExtra {
    public SimpleShareCallback() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public boolean interceptReportAction(IShareParams r100) {
        return false;
    }

    public void onChannelShare(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public void onFail(Throwable r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public final /* synthetic */ void onShareUiDismiss() {
        IShareCallback.CC.$default$onShareUiDismiss(this);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public final /* synthetic */ void onShareUiShow() {
        IShareCallback.CC.$default$onShareUiShow(this);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public void onSuccess(String r100, String r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallbackWithExtra
    public void onSuccessWithExtra(String r100, String r101, Map<String, List<String>> r102) {
    }
}
