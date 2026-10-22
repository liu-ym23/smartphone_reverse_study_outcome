package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.livehostapi.business.depend.miniapp.AnchorLiveData;
import com.bytedance.android.livehostapi.business.depend.miniapp.MiniAppParams;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostMiniAppDummy implements IHostMiniApp {
    public LiveHostMiniAppDummy() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostMiniApp
    public boolean openMiniApp(Context r100, String r101, boolean r102, MiniAppParams r103, AnchorLiveData r104) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostMiniApp
    public void preloadMiniApp(String r100, Map<String, String> r101, MiniAppPreloadListener r102) {
    }
}
