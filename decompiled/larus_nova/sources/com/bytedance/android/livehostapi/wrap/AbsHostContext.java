package com.bytedance.android.livehostapi.wrap;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.AbsLiveAppInfo;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.callback.TicketCallback;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livehostapi.foundation.depend.HostLargeFontParam;
import com.bytedance.android.livehostapi.foundation.depend.IUgSettingCallback;
import com.bytedance.android.livehostapi.hostdefault.HostContextDefault;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jc1.j;
import jc1.k;
import jta.g;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbsHostContext extends HostContextDefault {
    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String ecHostAppId() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public boolean enableLynxProfileAB() {
        return true;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public Pair<String, String> getFreeFlowModel() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public <T> T getSetting(String r100, T r101) {
        return r101;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int hostAppId() {
        return 0;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public void initDownloadableModelSupport() {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public void initDownloadableModelSupportSafely() {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public boolean isSettingEnableForTargetKey(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int liveId() {
        return 1;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public void refreshClientABTestValues() {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public boolean skipSecSdkCheck() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public HostLargeFontParam getHostLargeFontModeParams() {
        return new HostLargeFontParam();
    }

    public AbsHostContext() {
        k.l(IHostContext.class, (IHostContext) j.a(this, IHostContext.class));
        k.l(IMiddleWareHostContext.class, (IMiddleWareHostContext) j.a(this, IMiddleWareHostContext.class));
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int appIcon() {
        return BDLiveSdk.getAppInfo().appIcon();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int appId() {
        IAppInfo r100 = BDLiveSdk.getAppInfo();
        if ((r100 instanceof AbsLiveAppInfo) == false) goto L7;
        return ((AbsLiveAppInfo) r100).webcastId();
    L7:
        return r100.appId();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String appName() {
        return BDLiveSdk.getAppInfo().appName();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public String clientKey() {
        return BDLiveSdk.getAppInfo().clientKey();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public Context context() {
        return BDLiveSdk.getContext();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getChannel() {
        return BDLiveSdk.getAppInfo().channel();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public Map<String, String> getFEParamExtra() {
        return Collections.emptyMap();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public HostBoeParams getHostBoeParams() {
        IAppInfo r100 = BDLiveSdk.getAppInfo();
        return new HostBoeParams(r100.isBoe(), r100.isPPE(), r100.boeLane(), r100.ppeLane());
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getPackageName() {
        return BDLiveSdk.getContext().getPackageName();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getServerDeviceId() {
        return g.d();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int getUpdateVersionCode() {
        return BDLiveSdk.getAppInfo().updateVersionCode();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getVersionCode() {
        return String.valueOf(BDLiveSdk.getAppInfo().versionCode());
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getVersionName() {
        return BDLiveSdk.getAppInfo().versionName();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public boolean isBoe() {
        return BDLiveSdk.getAppInfo().isBoe();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public boolean isLocalTest() {
        return "local_test".equalsIgnoreCase(BDLiveSdk.getAppInfo().channel());
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public String getXTTicket(TicketCallback r100) {
        if (r100 == null) goto L5;
        r100.onGetValidTicketInfo(null, false);
    L5:
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public <T> T getClientABTestValue(ClientABTestKey<T> r100, boolean r101) {
        return r100.f58803c;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public void getUgSettingsByKey(int r100, List<String> r101, IUgSettingCallback r102) {
        if (r102 == null) goto L5;
        r102.onResult(null);
        return;
    }
}
