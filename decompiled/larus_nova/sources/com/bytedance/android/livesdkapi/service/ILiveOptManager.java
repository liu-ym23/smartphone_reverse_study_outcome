package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.performance.ILiveReleasable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdkapi.service.ILiveOptManager")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveOptManager;", "Lcom/bytedance/android/live/base/IService;", "bindReleasable", "", "parent", "", "releasable", "Lcom/bytedance/android/livesdkapi/performance/ILiveReleasable;", "checkMemStatusAvailable", "", "sceneFlag", "", "cleanCache", SlcCommonAction.KEY_ACTIONS, "cleanCacheWhenExit", "onEnterRoom", "onExitRoom", "switchFWatchDog", "open", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveOptManager extends IService {
    void bindReleasable(Object r100, ILiveReleasable r101);

    boolean checkMemStatusAvailable(int r100);

    void cleanCache(int r100);

    void cleanCacheWhenExit();

    void onEnterRoom();

    void onExitRoom();

    void switchFWatchDog(boolean r100);
}
