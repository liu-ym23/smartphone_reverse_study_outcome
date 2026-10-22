package com.bytedance.android.live.saas.middleware.fresco;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/fresco/FrescoInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/fresco/FrescoConfig;", "()V", "init", "", "app", "Landroid/app/Application;", "params", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class FrescoInitTask implements ISdkInitTask<FrescoConfig> {
    public FrescoInitTask() {
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r100, FrescoConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "params");
        FrescoInit.initFresco(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r100, FrescoConfig r101) {
        init2(r100, r101);
    }
}
