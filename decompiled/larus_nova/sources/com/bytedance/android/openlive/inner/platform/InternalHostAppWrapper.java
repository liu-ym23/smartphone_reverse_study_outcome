package com.bytedance.android.openlive.inner.platform;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.LiveHostApp;
import com.bytedance.android.openlive.inner.host.IOpenHostParams;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/bytedance/android/openlive/inner/platform/InternalHostAppWrapper;", "Lcom/bytedance/android/livehostapi/platform/LiveHostApp;", "openHostParams", "Lcom/bytedance/android/openlive/inner/host/IOpenHostParams;", "(Lcom/bytedance/android/openlive/inner/host/IOpenHostParams;)V", "getOpenHostParams", "()Lcom/bytedance/android/openlive/inner/host/IOpenHostParams;", "setOpenHostParams", "getCurrentActivity", "Landroid/app/Activity;", "getSessionId", "", "getTopActivity", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class InternalHostAppWrapper extends LiveHostApp {
    private IOpenHostParams openHostParams;

    @Override // com.bytedance.android.livehostapi.platform.LiveHostApp, com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Activity getCurrentActivity() {
        IOpenHostParams r100 = this.openHostParams;
        if (r100 == null) goto L7;
        Activity r101 = r100.getCurrentActivity();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return super.getCurrentActivity();
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostApp, com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public String getSessionId() {
        IOpenHostParams r100 = this.openHostParams;
        if (r100 == null) goto L7;
        String r101 = r100.getSessionId();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return super.getSessionId();
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostApp, com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Activity getTopActivity() {
        IOpenHostParams r100 = this.openHostParams;
        if (r100 == null) goto L7;
        Activity r101 = r100.getTopActivity();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return super.getTopActivity();
    }

    public final IOpenHostParams getOpenHostParams() {
        return this.openHostParams;
    }

    public InternalHostAppWrapper(IOpenHostParams r100) {
        this.openHostParams = r100;
    }

    public final void setOpenHostParams(IOpenHostParams r100) {
        this.openHostParams = r100;
    }
}
