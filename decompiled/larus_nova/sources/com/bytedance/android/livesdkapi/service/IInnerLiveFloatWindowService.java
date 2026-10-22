package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IInnerLiveFloatWindowService;", "Lcom/bytedance/android/livesdkapi/service/IMiddlewareInnerLiveFloatWindowService;", "addVideoFloatManagerListener", "", "listener", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "dismissFloatWindow", "reason", "", "getFloatWindowTag", "isContinueShowingWhenBackground", "", "removeVideoFloatManagerListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInnerLiveFloatWindowService extends IMiddlewareInnerLiveFloatWindowService {
    void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100);

    void dismissFloatWindow(String r100);

    String getFloatWindowTag();

    boolean isContinueShowingWhenBackground();

    void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100);
}
