package com.bytedance.android.livehostapi.hostdefault;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livehostapi.business.depend.openplatform.IAppStatusListener;
import com.bytedance.android.livehostapi.business.depend.openplatform.ILiveMethodExecutor;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.ILiveDuxPopupNotice;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class HostLiveOpenPlatformDefault implements IHostLiveOpenPlatform {
    public HostLiveOpenPlatformDefault() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void dispatchHostEvent(String r100, String r101, JSONObject r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void dispatchMiniGameEvent(String r100, JSONObject r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void dispatchStaticCommand(String r100, String r101, Bundle r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public Typeface getDuxFontSync(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void openMiniApp(String r100, IAppStatusListener r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void openMiniGame(String r100, IAppStatusListener r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void preloadMiniApp(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void preloadMiniGame(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void registerLiveMethod(String r100, ILiveMethodExecutor r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public ILiveDuxPopupNotice showDuxPopupNotice(Activity r100, DuxPopupNoticeConfig r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform
    public void unregisterLiveMethod(String r100) {
    }
}
