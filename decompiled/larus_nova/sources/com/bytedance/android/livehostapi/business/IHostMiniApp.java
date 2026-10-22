package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.depend.miniapp.AnchorLiveData;
import com.bytedance.android.livehostapi.business.depend.miniapp.MiniAppParams;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostMiniApp extends IService {
    boolean openMiniApp(Context r100, String r101, boolean r102, MiniAppParams r103, AnchorLiveData r104);

    void preloadMiniApp(String r100, Map<String, String> r101, MiniAppPreloadListener r102);
}
