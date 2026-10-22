package com.bytedance.android.openlive.inner.platform;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostMiniApp;
import com.bytedance.android.livehostapi.business.MiniAppPreloadListener;
import com.bytedance.android.livehostapi.business.depend.miniapp.AnchorLiveData;
import com.bytedance.android.livehostapi.business.depend.miniapp.MiniAppParams;
import com.bytedance.android.openlive.inner.host.IOpenHostBusiness;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J8\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J2\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/openlive/inner/platform/InternalHostMiniAppWrapper;", "Lcom/bytedance/android/livehostapi/business/IHostMiniApp;", "openHostBusiness", "Lcom/bytedance/android/openlive/inner/host/IOpenHostBusiness;", "(Lcom/bytedance/android/openlive/inner/host/IOpenHostBusiness;)V", "getOpenHostBusiness", "()Lcom/bytedance/android/openlive/inner/host/IOpenHostBusiness;", "setOpenHostBusiness", "openMiniApp", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "schema", "", "isHalfScreen", "params", "Lcom/bytedance/android/livehostapi/business/depend/miniapp/MiniAppParams;", "broadcastCurrentSelectedStamp", "Lcom/bytedance/android/livehostapi/business/depend/miniapp/AnchorLiveData;", "preloadMiniApp", "", "", "preloadListener", "Lcom/bytedance/android/livehostapi/business/MiniAppPreloadListener;", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class InternalHostMiniAppWrapper implements IHostMiniApp {
    private IOpenHostBusiness openHostBusiness;

    public final IOpenHostBusiness getOpenHostBusiness() {
        return this.openHostBusiness;
    }

    public InternalHostMiniAppWrapper(IOpenHostBusiness r100) {
        this.openHostBusiness = r100;
        k.l(IHostMiniApp.class, this);
    }

    public final void setOpenHostBusiness(IOpenHostBusiness r100) {
        this.openHostBusiness = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostMiniApp
    public void preloadMiniApp(String r100, Map<String, String> r101, MiniAppPreloadListener r102) {
        IOpenHostBusiness r103 = this.openHostBusiness;
        if (r103 == null) goto L6;
        r103.preloadMiniApp(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostMiniApp
    public boolean openMiniApp(Context r100, String r101, boolean r102, MiniAppParams r110, AnchorLiveData r111) {
        IOpenHostBusiness r103 = this.openHostBusiness;
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.openMiniApp(r100, r101, r102, r110, r111);
    }
}
