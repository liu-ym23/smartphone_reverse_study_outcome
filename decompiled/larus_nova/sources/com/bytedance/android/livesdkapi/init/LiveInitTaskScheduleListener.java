package com.bytedance.android.livesdkapi.init;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitTaskScheduleListener;", "Lcom/bytedance/android/livesdkapi/init/ILiveInitTaskListener;", "()V", "allTaskFinished", "", "getAllTaskFinished", "()Z", "setAllTaskFinished", "(Z)V", "scheduleInfoList", "Ljava/util/HashSet;", "Lcom/bytedance/android/livesdkapi/init/LiveInitPeriodScheduleInfo;", "Lkotlin/collections/HashSet;", "assembleCostInfo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "dispose", "", "formatName", "name", "getScheduleInfo", "periodName", "onAllTaskExecuteFinish", "onTaskEnd", "endTask", "Lcom/bytedance/android/livesdkapi/init/LiveInitTaskInfo;", "onTaskScheduleEnd", "period", "Lcom/bytedance/android/livesdkapi/init/LiveInitCostInfo;", "onTaskScheduleStart", "onTaskStart", "startTask", "onWaitTask", "taskName", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitTaskScheduleListener implements ILiveInitTaskListener {
    private volatile boolean allTaskFinished;
    private final HashSet<LiveInitPeriodScheduleInfo> scheduleInfoList;

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitTaskListener
    public void onAllTaskExecuteFinish() {
        this.allTaskFinished = true;
        LiveInitAssistant.INSTANCE.report();
    }

    public final HashMap<String, String> assembleCostInfo() {
        HashMap<String, String> r100 = new HashMap();
        Iterator<T> r101 = this.scheduleInfoList.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        LiveInitPeriodScheduleInfo r102 = (LiveInitPeriodScheduleInfo) r101.next();
        String r103 = formatName(r102.getName());
        r100.put(r103 + "_schedule_duration", String.valueOf(r102.getDuration()));
        r100.put(r103 + "_schedule_thread_count", String.valueOf(r102.getThreadIdSet().size()));
        r100.put(r103 + "_schedule_task_count", String.valueOf(r102.getTaskList().size()));
        Iterator<T> r104 = r102.getTaskList().iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        LiveInitTaskInfo r105 = (LiveInitTaskInfo) r104.next();
        r100.put(r103 + '_' + formatName(r105.getName()) + "_duration", String.valueOf(r105.getDuration()));
        goto L7
    L9:
        return r100;
    }

    public final void dispose() {
        this.scheduleInfoList.clear();
    }

    public LiveInitTaskScheduleListener() {
        this.scheduleInfoList = new HashSet();
    }

    public final boolean getAllTaskFinished() {
        return this.allTaskFinished;
    }

    private final String formatName(String r100) {
        Locale r101 = Locale.ROOT;
        if (r100 == null) goto L7;
        return r100.toLowerCase(r101);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final LiveInitPeriodScheduleInfo getScheduleInfo(String r100) {
        Iterator<T> r101 = this.scheduleInfoList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((LiveInitPeriodScheduleInfo) r102).getName(), r100) == false) goto L4;
    L10:
        return (LiveInitPeriodScheduleInfo) r102;
    L8:
        r102 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitTaskListener
    public void onTaskEnd(LiveInitTaskInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "endTask");
        if (r100.getName().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        LiveInitPeriodScheduleInfo r102 = getScheduleInfo(r100.getPeriodName());
        if (r102 != null) goto L11;
    L13:
        LiveInitPeriodScheduleInfo r103 = getScheduleInfo(r100.getPeriodName());
        if (r103 == null) goto L34;
        HashSet<LiveInitTaskInfo> r104 = r103.getTaskList();
        if (r104 == null) goto L35;
        Iterator<T> r105 = r104.iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((LiveInitTaskInfo) r106).getName(), r100.getName()) == false) goto L19;
    L24:
        LiveInitTaskInfo r107 = (LiveInitTaskInfo) r106;
        if (r107 != null) goto L27;
        return;
    L27:
        if (r100.getDuration() == 0) goto L29;
        r107.setDuration(r100.getDuration());
        return;
    L29:
        r107.setDuration(System.currentTimeMillis() - r107.getStart());
        return;
    L23:
        r106 = null;
        goto L24
    L35:
        return;
    L34:
        return;
    L11:
        if (r102.isFinish() != true) goto L13;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitTaskListener
    public void onTaskScheduleEnd(LiveInitCostInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "period");
        LiveInitPeriodScheduleInfo r101 = getScheduleInfo(r100.getName());
        if (r101 == null) goto L9;
        r101.setFinish(true);
        if (r100.getDuration() == 0) goto L7;
        r101.setDuration(r100.getDuration());
        return;
    L7:
        r101.setDuration(System.currentTimeMillis() - r101.getStart());
        return;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitTaskListener
    public void onTaskScheduleStart(LiveInitCostInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "period");
        HashSet<LiveInitPeriodScheduleInfo> r101 = this.scheduleInfoList;
        LiveInitPeriodScheduleInfo r102 = new LiveInitPeriodScheduleInfo();
        r102.setName(r100.getName());
        r102.setStart(System.currentTimeMillis());
        Unit r103 = Unit.INSTANCE;
        r101.add(r102);
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitTaskListener
    public void onTaskStart(LiveInitTaskInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "startTask");
        if (r100.getName().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        LiveInitPeriodScheduleInfo r102 = getScheduleInfo(r100.getPeriodName());
        if (r102 != null) goto L11;
    L13:
        r100.setStart(System.currentTimeMillis());
        if (r102 == null) goto L17;
        r102.getTaskList().add(r100);
        r102.getThreadIdSet().add(Long.valueOf(r100.getThreadId()));
        return;
    L17:
        return;
    L11:
        if (r102.isFinish() != true) goto L13;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitTaskListener
    public void onWaitTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        LiveInitAssistant.INSTANCE.markWaitTask(r100);
    }

    public final void setAllTaskFinished(boolean r100) {
        this.allTaskFinished = r100;
    }
}
