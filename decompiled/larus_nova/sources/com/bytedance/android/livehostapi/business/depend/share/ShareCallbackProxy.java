package com.bytedance.android.livehostapi.business.depend.share;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/ShareCallbackProxy;", "Lcom/bytedance/android/livehostapi/business/depend/share/IShareCallback;", "impl", "(Lcom/bytedance/android/livehostapi/business/depend/share/IShareCallback;)V", "interceptReportAction", "", "shareParams", "Lcom/bytedance/android/livehostapi/business/depend/share/IShareParams;", "onFail", "", LynxError.LYNX_THROWABLE, "", "onShareUiDismiss", "onShareUiShow", "onSuccess", "platform", "", "shareType", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ShareCallbackProxy implements IShareCallback {
    private final IShareCallback impl;

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public void onShareUiDismiss() {
        IShareCallback r100 = this.impl;
        if (r100 == null) goto L6;
        r100.onShareUiDismiss();
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public void onShareUiShow() {
        IShareCallback r100 = this.impl;
        if (r100 == null) goto L6;
        r100.onShareUiShow();
        return;
    }

    public ShareCallbackProxy(IShareCallback r100) {
        this.impl = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public boolean interceptReportAction(IShareParams r100) {
        IShareCallback r101 = this.impl;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.interceptReportAction(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public void onFail(Throwable r100) {
        IShareCallback r101 = this.impl;
        if (r101 == null) goto L6;
        r101.onFail(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public void onSuccess(String r100, String r101) {
        IShareCallback r102 = this.impl;
        if (r102 == null) goto L6;
        r102.onSuccess(r100, r101);
        return;
    }
}
