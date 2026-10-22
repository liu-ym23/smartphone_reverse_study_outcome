package com.bytedance.android.live.initialize;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/initialize/IWTORepeatableTask;", "Lcom/bytedance/android/live/initialize/IWTOTask;", "taskSceneType", "Lcom/bytedance/android/live/initialize/WTOSceneType;", "taskThreadWorkType", "Lcom/bytedance/android/live/initialize/WTOThreadWorkType;", "live-initialize-annotation_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IWTORepeatableTask extends IWTOTask {
    WTOSceneType taskSceneType();

    WTOThreadWorkType taskThreadWorkType();
}
