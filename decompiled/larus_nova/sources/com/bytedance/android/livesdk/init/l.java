package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadType;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements IWTOSingleTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsTask f132661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.initialize.a f132662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WTOPriorityType f132663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WTOThreadType f132664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f132665e;

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final boolean cancelable() {
        return true;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final boolean isEffective() {
        return true;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final void run() {
        this.f132661a.start();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final String taskBusinessInfo() {
        return this.f132661a.getTaskBusinessInfo();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final List<Integer> taskCategoryList() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final int taskID() {
        return this.f132661a.getTaskId();
    }

    @Override // com.bytedance.android.live.initialize.IWTOSingleTask
    public final List<Integer> taskDependencies() {
        return this.f132665e;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final com.bytedance.android.live.initialize.a taskExecutePeriod() {
        return this.f132662b;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final WTOPriorityType taskPriorityType() {
        return this.f132663c;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final WTOThreadType taskThreadType() {
        return this.f132664d;
    }

    public l(AbsTask r100, WTOPriorityType r101, WTOThreadType r102) {
        com.bytedance.android.live.initialize.a.i r103 = com.bytedance.android.live.initialize.a.i.f69383c;
        List<Integer> r104 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r103, "period");
        Intrinsics.checkNotNullParameter(r101, "priorityType");
        Intrinsics.checkNotNullParameter(r102, "threadType");
        Intrinsics.checkNotNullParameter(r104, "dependencies");
        this.f132661a = r100;
        this.f132662b = r103;
        this.f132663c = r101;
        this.f132664d = r102;
        this.f132665e = r104;
    }
}
