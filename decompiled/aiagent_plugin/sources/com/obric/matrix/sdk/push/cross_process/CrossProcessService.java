package com.obric.matrix.sdk.push.cross_process;

import android.content.Intent;
import android.os.IBinder;
import com.obric.matrix.push.common.cross_process.ICrossProcessInterface;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CrossProcessService.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CrossProcessService extends PluginService {
    private ICrossProcessInterface.Stub mBinder;

    public abstract void registerCrossProcessMethod();

    public CrossProcessService() {
    }

    public IBinder onBind(Intent r3) {
        if (this.mBinder != null) goto L6;
        registerCrossProcessMethod();
        this.mBinder = (ICrossProcessInterface.Stub) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), ICrossProcessInterface.Stub.class, "com.obric.aiagent.plugin");
    L6:
        return (IBinder) ZeusTransformUtils.preCheckCast(this.mBinder, IBinder.class, "com.obric.aiagent.plugin");
    }
}
