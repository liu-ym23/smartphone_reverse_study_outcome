package com.bytedance.android.livesdk.revenue.perf.wto;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/perf/wto/IRevWTOSingleTask;", "Lcom/bytedance/android/livesdk/revenue/perf/wto/IRevWTOTask;", "taskDependencies", "", "", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRevWTOSingleTask extends IRevWTOTask {
    List<Integer> taskDependencies();
}
