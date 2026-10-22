package com.bytedance.android;

import com.bytedance.android.live.annotation.AutoRegisterTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadType;
import com.bytedance.android.live.initialize.a;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.heytap.mcssdk.constant.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
@AutoRegisterTask(lockPeriod = false, name = "LiveFeedProtoInjectTask")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/LiveFeedProtoInjectTask;", "Lcom/bytedance/android/live/initialize/IWTOSingleTask;", "", b.f276354d, "", "taskBusinessInfo", "", "taskCategoryList", "Lcom/bytedance/android/live/initialize/a;", "taskExecutePeriod", "Lcom/bytedance/android/live/initialize/WTOPriorityType;", "taskPriorityType", "Lcom/bytedance/android/live/initialize/WTOThreadType;", "taskThreadType", "taskDependencies", "", "run", "<init>", "()V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedProtoInjectTask implements IWTOSingleTask {
    public LiveFeedProtoInjectTask() {
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public boolean cancelable() {
        return true;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public boolean isEffective() {
        return true;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public String taskBusinessInfo() {
        return "WTO_LiveFeedProtoInjectTask";
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public int taskID() {
        return 29;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public List<Integer> taskCategoryList() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.initialize.IWTOSingleTask
    public List<Integer> taskDependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public void run() {
        LiveFeedContext.feedProtoInit();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public a taskExecutePeriod() {
        return a.i.f69383c;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public WTOPriorityType taskPriorityType() {
        return WTOPriorityType.SCHEDULE;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public WTOThreadType taskThreadType() {
        return WTOThreadType.WorkerThread;
    }
}
