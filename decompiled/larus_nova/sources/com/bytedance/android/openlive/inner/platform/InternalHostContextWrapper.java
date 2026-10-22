package com.bytedance.android.openlive.inner.platform;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.livehostapi.foundation.callback.TicketCallback;
import com.bytedance.android.livehostapi.platform.LiveHostContext;
import com.bytedance.android.openlive.inner.IHostParams;
import com.bytedance.android.openlive.inner.host.IOpenHostParams;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/openlive/inner/platform/InternalHostContextWrapper;", "Lcom/bytedance/android/livehostapi/platform/LiveHostContext;", "hostParams", "Lcom/bytedance/android/openlive/inner/IHostParams;", "(Lcom/bytedance/android/openlive/inner/IHostParams;)V", "getHostParams", "()Lcom/bytedance/android/openlive/inner/IHostParams;", "setHostParams", "ecHostAppId", "", "enableLynxProfileAB", "", "getHostEffectAccessKey", "getPlayActivityName", "getServerDeviceId", "getXTTicket", "callback", "Lcom/bytedance/android/livehostapi/foundation/callback/TicketCallback;", "hostAppId", "", "isSettingEnableForTargetKey", "targetKey", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class InternalHostContextWrapper extends LiveHostContext {
    private IHostParams hostParams;

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public boolean enableLynxProfileAB() {
        return this.hostParams.getOpenHostParams().enableLynxProfileAB();
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public String getHostEffectAccessKey() {
        return this.hostParams.getOpenHostParams().getHostEffectAccessKey();
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public String getPlayActivityName() {
        return this.hostParams.getOpenHostParams().getPlayActivityName();
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostContext, com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int hostAppId() {
        return this.hostParams.getOpenHostParams().hostAppId();
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String ecHostAppId() {
        if (hostAppId() != 7060) goto L6;
        return "1371";
    L6:
        String r100 = super.ecHostAppId();
        if (r100 != null) goto L10;
        return "";
    L10:
        return r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostContext, com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getServerDeviceId() {
        IAppLog r100 = BDLiveSdk.appLog();
        if (r100 == null) goto L6;
        String r101 = r100.getDid();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final IHostParams getHostParams() {
        return this.hostParams;
    }

    public InternalHostContextWrapper(IHostParams r100) {
        Intrinsics.checkNotNullParameter(r100, "hostParams");
        this.hostParams = r100;
        k.l(IOpenHostParams.class, r100.getOpenHostParams());
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public String getXTTicket(TicketCallback r100) {
        return this.hostParams.getOpenHostParams().getXTTicket(r100);
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public boolean isSettingEnableForTargetKey(String r100) {
        return this.hostParams.getOpenHostParams().isSettingEnableForTargetKey(r100);
    }

    public final void setHostParams(IHostParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostParams = r100;
    }
}
