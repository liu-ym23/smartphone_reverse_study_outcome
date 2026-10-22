package com.bytedance.android.livesdk.init;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes9.dex */
@WorkThreadTask
@Task(businessInfo = "WTO_TaskManagerInitTask", value = 4)
public class TaskManagerInitTask extends AbsTask {
    @Override // com.bytedance.android.live.core.launch.AbsTask
    public List<Integer> preTasks() {
        return Arrays.asList(new Integer[]{0});
    }

    @Override // com.bytedance.android.live.core.launch.AbsTask
    public void run() {
        Executor r100 = PThreadExecutorsUtils.newCachedThreadPool(new SimpleThreadFactory("live-work-threads", true));
        if (r100 != null) goto L5;
        r100 = l56.b.f507527c;
    L5:
        l56.b r101 = l56.b.a();
        r101.getClass();
        r101.f507530b = r100;
        new Handler(Looper.getMainLooper());
        r101.f507529a = true;
    }

    public TaskManagerInitTask() {
    }
}
