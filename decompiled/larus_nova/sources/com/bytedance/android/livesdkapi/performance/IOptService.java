package com.bytedance.android.livesdkapi.performance;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/performance/IOptService;", "", "cleanCache", "", SlcCommonAction.KEY_ACTIONS, "", "cleanCacheWhenExit", "switchFWatchDog", "open", "", "triggerLiveInnerPerformanceLevel", "level", "lastDuration", "", "triggerLivePreviewPerformanceLevel", "isDegrade", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOptService {
    void cleanCache(int r100);

    void cleanCacheWhenExit();

    void switchFWatchDog(boolean r100);

    void triggerLiveInnerPerformanceLevel(int r100, long r101);

    void triggerLivePreviewPerformanceLevel(boolean r100, int r101);
}
