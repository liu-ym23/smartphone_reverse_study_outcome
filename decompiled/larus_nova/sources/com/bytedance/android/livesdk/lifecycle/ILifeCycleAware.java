package com.bytedance.android.livesdk.lifecycle;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
@ServiceLookup("com.bytedance.android.livesdk.lifecycle.LifeCycleService")
public interface ILifeCycleAware extends IService {
    void onEndSession(String r100);

    void onEndSession(String r100, HashMap<String, String> r101);

    void onEnterLiveRoomSuccess(String r100, String r101);

    void onInteractionFragmentDestroy(String r100);

    void onShowLiveEnd(String r100);
}
