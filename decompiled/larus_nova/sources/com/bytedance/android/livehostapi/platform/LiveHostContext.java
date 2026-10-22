package com.bytedance.android.livehostapi.platform;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.IUgSettingCallback;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.bytedance.android.livehostapi.wrap.AbsHostContext;
import com.bytedance.android.livesdk.open.DefaultLivePlayerActivity;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ss.android.ugc.effectmanager.EffectManager;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jc1.j;
import jc1.k;
import jta.g;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostContext extends AbsHostContext {
    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public Locale currentLocale() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public void formatEnterDetail(Context r100, HashMap<String, String> r101) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public String getBtmJsbVersion() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public LocationResult getCurrentLocation() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getDevicePlatform() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public EffectManager getEffectManager() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getEffectSDKVersion() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public <T> T getHostABValue(String r100, String r101, T r102, T r103) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public String getHostEffectAccessKey() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public LocationResult getNearByLocation() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public String getNearbyCityCode() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public Interceptor getSandboxInterceptor() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int getTopSpaceHeight() {
        return 0;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getXTTToken() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public boolean hasLocation() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public boolean hasSandboxRecord() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int hostAppId() {
        return 0;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public boolean isFoldDevice() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public boolean isMpInSandboxMode(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public boolean isNeedProtectUnderage() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public boolean isOpSandboxDevMode() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public boolean isOscarRun(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public boolean isPpe() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public boolean isTransparentStatusBar() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public void linkNSForLive() {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public Observable<LocationResult> locationChangedForHS() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public void refreshLocationForHS(Context r100) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContext
    public void refreshLocationForHS(Context r100, boolean r101, boolean r102) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public String getPlayActivityName() {
        return DefaultLivePlayerActivity.class.getName();
    }

    public LiveHostContext() {
        k.l(IHostContext.class, (IHostContext) j.a(this, IHostContext.class));
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getInstallId() {
        return g.e();
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String getServerDeviceId() {
        return g.d();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public Boolean isDarkMode() {
        return Boolean.TRUE;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IHostContextForSaas
    public void loadVESDKForSaas(Context r100) {
        JavaCalls.callStaticMethod("com.bytedance.android.live.effect.api.VESDKUtils", "loadVESDK", new Object[]{r100});
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public Object getUgSettingsByKey(int r100, String r101) {
        return super.getUgSettingsByKey(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public void getUgSettingsByKey(int r100, List<String> r101, IUgSettingCallback r102) {
        super.getUgSettingsByKey(r100, r101, r102);
    }
}
