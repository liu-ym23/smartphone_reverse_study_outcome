package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes9.dex */
@WorkThreadTask
@Task(businessInfo = "WTO_LightenInitTask", value = 8)
public class LightenInitTask extends AbsTask {
    @Override // com.bytedance.android.live.core.launch.AbsTask
    public void run() {
        df6.q.b(new df6.r.a(s1.getContext()).a());
    }

    public LightenInitTask() {
    }
}
