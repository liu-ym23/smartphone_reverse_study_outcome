package com.bytedance.android.livesdkapi.init;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\tj\b\u0012\u0004\u0012\u00020\u0011`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitPeriodScheduleInfo;", "Lcom/bytedance/android/livesdkapi/init/LiveInitCostInfo;", "()V", "isFinish", "", "()Z", "setFinish", "(Z)V", "taskList", "Ljava/util/HashSet;", "Lcom/bytedance/android/livesdkapi/init/LiveInitTaskInfo;", "Lkotlin/collections/HashSet;", "getTaskList", "()Ljava/util/HashSet;", "setTaskList", "(Ljava/util/HashSet;)V", "threadIdSet", "", "getThreadIdSet", "setThreadIdSet", "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitPeriodScheduleInfo extends LiveInitCostInfo {
    private boolean isFinish;
    private HashSet<LiveInitTaskInfo> taskList;
    private HashSet<Long> threadIdSet;

    public LiveInitPeriodScheduleInfo() {
        this.threadIdSet = new HashSet();
        this.taskList = new HashSet();
    }

    public final HashSet<LiveInitTaskInfo> getTaskList() {
        return this.taskList;
    }

    public final HashSet<Long> getThreadIdSet() {
        return this.threadIdSet;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public final void setFinish(boolean r100) {
        this.isFinish = r100;
    }

    public final void setTaskList(HashSet<LiveInitTaskInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskList = r100;
    }

    public final void setThreadIdSet(HashSet<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.threadIdSet = r100;
    }
}
