package com.bytedance.android.livesdkapi.init;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/ILiveInitTaskListener;", "", "onAllTaskExecuteFinish", "", "onTaskEnd", "endTask", "Lcom/bytedance/android/livesdkapi/init/LiveInitTaskInfo;", "onTaskScheduleEnd", "period", "Lcom/bytedance/android/livesdkapi/init/LiveInitCostInfo;", "onTaskScheduleStart", "onTaskStart", "startTask", "onWaitTask", "taskName", "", "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveInitTaskListener {
    void onAllTaskExecuteFinish();

    void onTaskEnd(LiveInitTaskInfo r100);

    void onTaskScheduleEnd(LiveInitCostInfo r100);

    void onTaskScheduleStart(LiveInitCostInfo r100);

    void onTaskStart(LiveInitTaskInfo r100);

    void onWaitTask(String r100);
}
