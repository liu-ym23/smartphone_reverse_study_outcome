package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.annotation.AutoRegisterTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
@AutoRegisterTask(name = "LiveFeatureServiceTask")
public final class h implements IWTOSingleTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f132657a;

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final boolean cancelable() {
        this.f132657a.getClass();
        return true;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final boolean isEffective() {
        this.f132657a.getClass();
        return true;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final void run() {
        this.f132657a.run();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final String taskBusinessInfo() {
        return this.f132657a.taskBusinessInfo();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final int taskID() {
        return this.f132657a.taskID();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final List<Integer> taskCategoryList() {
        this.f132657a.getClass();
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.initialize.IWTOSingleTask
    public final List<Integer> taskDependencies() {
        return this.f132657a.f132665e;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final com.bytedance.android.live.initialize.a taskExecutePeriod() {
        return this.f132657a.f132662b;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final WTOPriorityType taskPriorityType() {
        return this.f132657a.f132663c;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final WTOThreadType taskThreadType() {
        return this.f132657a.f132664d;
    }

    public h() {
        FeatureServiceTask r100 = new FeatureServiceTask();
        com.bytedance.android.live.initialize.a.i r101 = com.bytedance.android.live.initialize.a.i.f69383c;
        this.f132657a = new l(r100, WTOPriorityType.SCHEDULE, WTOThreadType.WorkerThread);
    }
}
