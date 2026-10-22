package com.bytedance.android.openlive.inner.platform;

import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livehostapi.wrap.AbsHostWebView;
import com.bytedance.android.openlive.inner.host.IOpenHostParams;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/openlive/inner/platform/InternalHostWebViewWrapper;", "Lcom/bytedance/android/livehostapi/wrap/AbsHostWebView;", "openHostParams", "Lcom/bytedance/android/openlive/inner/host/IOpenHostParams;", "(Lcom/bytedance/android/openlive/inner/host/IOpenHostParams;)V", "getOpenHostParams", "()Lcom/bytedance/android/openlive/inner/host/IOpenHostParams;", "setOpenHostParams", "getHostGeckoCacheDir", "", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class InternalHostWebViewWrapper extends AbsHostWebView {
    private IOpenHostParams openHostParams;

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public String getHostGeckoCacheDir() {
        IOpenHostParams r100 = this.openHostParams;
        if (r100 == null) goto L7;
        String r101 = r100.getHostGeckoCacheDir();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return super.getHostGeckoCacheDir();
    }

    public final IOpenHostParams getOpenHostParams() {
        return this.openHostParams;
    }

    public InternalHostWebViewWrapper(IOpenHostParams r100) {
        this.openHostParams = r100;
        k.l(IHostWebView.class, this);
    }

    public final void setOpenHostParams(IOpenHostParams r100) {
        this.openHostParams = r100;
    }
}
