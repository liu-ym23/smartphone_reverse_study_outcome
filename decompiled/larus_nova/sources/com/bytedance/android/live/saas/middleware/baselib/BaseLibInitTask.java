package com.bytedance.android.live.saas.middleware.baselib;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibConfig;", "()V", "init", "", "app", "Landroid/app/Application;", "params", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BaseLibInitTask implements ISdkInitTask<BaseLibConfig> {
    public BaseLibInitTask() {
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r100, BaseLibConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "params");
        ITTExecutors r102 = r101.getTtExecutors();
        if (r102 == null) goto L23;
        ExecutorService r103 = r102.getNormalThreadPool();
        if (r103 == null) goto L7;
        TTExecutors.setNormalThreadPool(r103);
        r103.toString();
    L7:
        ScheduledExecutorService r104 = r102.getScheduledThreadPool();
        if (r104 == null) goto L10;
        TTExecutors.setScheduledThreadPool(r104);
        r104.toString();
    L10:
        ExecutorService r105 = r102.getCpuThreadPool();
        if (r105 == null) goto L13;
        TTExecutors.setCPUThreadPool(r105);
        r105.toString();
    L13:
        ExecutorService r106 = r102.getIoThreadPool();
        if (r106 == null) goto L16;
        TTExecutors.setIOThreadPool(r106);
        r106.toString();
    L16:
        ExecutorService r107 = r102.getSerialThreadPool();
        if (r107 == null) goto L19;
        TTExecutors.setSerialThreadPool(r107);
        r107.toString();
    L19:
        ExecutorService r108 = r102.getBackgroundThreadPool();
        if (r108 == null) goto L24;
        TTExecutors.setBackgroundThreadPool(r108);
        r108.toString();
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r100, BaseLibConfig r101) {
        init2(r100, r101);
    }
}
