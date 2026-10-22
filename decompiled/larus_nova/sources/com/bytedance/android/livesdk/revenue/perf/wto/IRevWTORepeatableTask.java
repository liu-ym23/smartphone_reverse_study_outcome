package com.bytedance.android.livesdk.revenue.perf.wto;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/perf/wto/IRevWTORepeatableTask;", "Lcom/bytedance/android/livesdk/revenue/perf/wto/IRevWTOTask;", "taskSceneType", "Lcom/bytedance/android/livesdk/revenue/perf/wto/WTOSceneType;", "taskThreadWorkType", "Lcom/bytedance/android/livesdk/revenue/perf/wto/WTOThreadWorkType;", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRevWTORepeatableTask extends IRevWTOTask {
    WTOSceneType taskSceneType();

    WTOThreadWorkType taskThreadWorkType();
}
