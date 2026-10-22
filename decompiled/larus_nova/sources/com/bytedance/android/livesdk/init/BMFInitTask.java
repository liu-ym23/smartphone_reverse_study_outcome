package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;

/* JADX INFO: loaded from: classes9.dex */
@GenProtoDecoders
@WorkThreadTask
@Task(businessInfo = "WTO_BMFInitTask", value = 18)
public class BMFInitTask extends AbsTask {
    @Override // com.bytedance.android.live.core.launch.AbsTask
    public void run() {
        IPullStreamService r100 = (IPullStreamService) jc1.k.f(IPullStreamService.class);
        if (r100 == null) goto L6;
        r100.tryInstallBMFPlugin();
        return;
    }

    public BMFInitTask() {
    }
}
