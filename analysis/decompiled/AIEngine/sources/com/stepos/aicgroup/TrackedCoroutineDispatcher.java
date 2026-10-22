package com.stepos.aicgroup;

import android.os.SystemClock;
import android.util.Log;
import com.stepos.aicgroup.TrackedCoroutineDispatcher;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.CoroutineDispatcher;
import lb.n;
import mb.v;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TrackedCoroutineDispatcher extends CoroutineDispatcher {

    /* renamed from: d, reason: collision with root package name */
    public static l<? super TaskEvent, n> f5664d;

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f5666a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5667b;
    public static final Companion Companion = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicLong f5663c = new AtomicLong(0);

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, l<TaskEvent, n>> f5665e = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<Long, TaskInfo> h = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final List<TaskInfo> getActiveTasks() {
            Collection collectionValues = TrackedCoroutineDispatcher.h.values();
            kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
            return kotlin.collections.a.O0(collectionValues);
        }

        public final List<TaskInfo> getActiveTasksForDispatcher(String dispatcherName) {
            kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
            Collection collectionValues = TrackedCoroutineDispatcher.h.values();
            kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                if (kotlin.jvm.internal.g.b(((TaskInfo) obj).getDispatcherName(), dispatcherName)) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        public final TaskStatistics getTaskStatistics() {
            Collection collectionValues = TrackedCoroutineDispatcher.h.values();
            kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
            List listO0 = kotlin.collections.a.O0(collectionValues);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listO0) {
                String dispatcherName = ((TaskInfo) obj).getDispatcherName();
                Object arrayList = linkedHashMap.get(dispatcherName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(dispatcherName, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(v.a0(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry.getKey(), Integer.valueOf(((List) entry.getValue()).size()));
            }
            return new TaskStatistics(listO0.size(), linkedHashMap2, TrackedCoroutineDispatcher.f5663c.get());
        }

        public final void setDispatcherListener(String dispatcherName, l<? super TaskEvent, n> lVar) {
            kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
            if (lVar != null) {
                TrackedCoroutineDispatcher.f5665e.put(dispatcherName, lVar);
                Log.i("TrackedDispatcher", "调度器 " + dispatcherName + " 监听器已设置");
                return;
            }
            TrackedCoroutineDispatcher.f5665e.remove(dispatcherName);
            Log.i("TrackedDispatcher", "调度器 " + dispatcherName + " 监听器已清除");
        }

        public final void setGlobalListener(l<? super TaskEvent, n> lVar) {
            TrackedCoroutineDispatcher.f5664d = lVar;
            Log.i("TrackedDispatcher", "全局监听器已".concat(lVar != null ? "设置" : "清除"));
        }

        public Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskEndStatus {
        public static final TaskEndStatus CANCELLED;
        public static final TaskEndStatus COMPLETED;
        public static final TaskEndStatus FAILED;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TaskEndStatus[] f5668a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ sb.a f5669b;

        static {
            TaskEndStatus taskEndStatus = new TaskEndStatus("COMPLETED", 0);
            COMPLETED = taskEndStatus;
            TaskEndStatus taskEndStatus2 = new TaskEndStatus("CANCELLED", 1);
            CANCELLED = taskEndStatus2;
            TaskEndStatus taskEndStatus3 = new TaskEndStatus("FAILED", 2);
            FAILED = taskEndStatus3;
            TaskEndStatus[] taskEndStatusArr = {taskEndStatus, taskEndStatus2, taskEndStatus3};
            f5668a = taskEndStatusArr;
            f5669b = kotlin.enums.a.a(taskEndStatusArr);
        }

        public TaskEndStatus() {
            throw null;
        }

        public static sb.a<TaskEndStatus> getEntries() {
            return f5669b;
        }

        public static TaskEndStatus valueOf(String str) {
            return (TaskEndStatus) Enum.valueOf(TaskEndStatus.class, str);
        }

        public static TaskEndStatus[] values() {
            return (TaskEndStatus[]) f5668a.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskInfo {

        /* renamed from: a, reason: collision with root package name */
        public final long f5678a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5679b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5680c;

        /* renamed from: d, reason: collision with root package name */
        public final long f5681d;

        /* renamed from: e, reason: collision with root package name */
        public final String f5682e;

        public TaskInfo(long j10, String dispatcherName, long j11, long j12, String startThreadName) {
            kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
            kotlin.jvm.internal.g.f(startThreadName, "startThreadName");
            this.f5678a = j10;
            this.f5679b = dispatcherName;
            this.f5680c = j11;
            this.f5681d = j12;
            this.f5682e = startThreadName;
        }

        public static /* synthetic */ TaskInfo copy$default(TaskInfo taskInfo, long j10, String str, long j11, long j12, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = taskInfo.f5678a;
            }
            long j13 = j10;
            if ((i10 & 2) != 0) {
                str = taskInfo.f5679b;
            }
            String str3 = str;
            if ((i10 & 4) != 0) {
                j11 = taskInfo.f5680c;
            }
            return taskInfo.copy(j13, str3, j11, (i10 & 8) != 0 ? taskInfo.f5681d : j12, (i10 & 16) != 0 ? taskInfo.f5682e : str2);
        }

        public final long component1() {
            return this.f5678a;
        }

        public final String component2() {
            return this.f5679b;
        }

        public final long component3() {
            return this.f5680c;
        }

        public final long component4() {
            return this.f5681d;
        }

        public final String component5() {
            return this.f5682e;
        }

        public final TaskInfo copy(long j10, String dispatcherName, long j11, long j12, String startThreadName) {
            kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
            kotlin.jvm.internal.g.f(startThreadName, "startThreadName");
            return new TaskInfo(j10, dispatcherName, j11, j12, startThreadName);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskInfo)) {
                return false;
            }
            TaskInfo taskInfo = (TaskInfo) obj;
            return this.f5678a == taskInfo.f5678a && kotlin.jvm.internal.g.b(this.f5679b, taskInfo.f5679b) && this.f5680c == taskInfo.f5680c && this.f5681d == taskInfo.f5681d && kotlin.jvm.internal.g.b(this.f5682e, taskInfo.f5682e);
        }

        public final String getDispatcherName() {
            return this.f5679b;
        }

        public final long getDuration() {
            return SystemClock.elapsedRealtime() - this.f5680c;
        }

        public final long getStartThreadId() {
            return this.f5681d;
        }

        public final String getStartThreadName() {
            return this.f5682e;
        }

        public final long getStartTime() {
            return this.f5680c;
        }

        public final long getTaskId() {
            return this.f5678a;
        }

        public int hashCode() {
            return this.f5682e.hashCode() + a0.a.c(a0.a.c(v1.d.a(Long.hashCode(this.f5678a) * 31, 31, this.f5679b), this.f5680c, 31), this.f5681d, 31);
        }

        public String toString() {
            StringBuilder sbO = a0.a.o("TaskInfo(taskId=", this.f5678a, ", dispatcherName=", this.f5679b);
            a0.a.s(this.f5680c, ", startTime=", ", startThreadId=", sbO);
            ai.onnxruntime.a.u(this.f5681d, ", startThreadName=", this.f5682e, sbO);
            sbO.append(")");
            return sbO.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskStatistics {

        /* renamed from: a, reason: collision with root package name */
        public final int f5683a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, Integer> f5684b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5685c;

        public TaskStatistics(int i10, Map<String, Integer> tasksByDispatcher, long j10) {
            kotlin.jvm.internal.g.f(tasksByDispatcher, "tasksByDispatcher");
            this.f5683a = i10;
            this.f5684b = tasksByDispatcher;
            this.f5685c = j10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TaskStatistics copy$default(TaskStatistics taskStatistics, int i10, Map map, long j10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = taskStatistics.f5683a;
            }
            if ((i11 & 2) != 0) {
                map = taskStatistics.f5684b;
            }
            if ((i11 & 4) != 0) {
                j10 = taskStatistics.f5685c;
            }
            return taskStatistics.copy(i10, map, j10);
        }

        public final int component1() {
            return this.f5683a;
        }

        public final Map<String, Integer> component2() {
            return this.f5684b;
        }

        public final long component3() {
            return this.f5685c;
        }

        public final TaskStatistics copy(int i10, Map<String, Integer> tasksByDispatcher, long j10) {
            kotlin.jvm.internal.g.f(tasksByDispatcher, "tasksByDispatcher");
            return new TaskStatistics(i10, tasksByDispatcher, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskStatistics)) {
                return false;
            }
            TaskStatistics taskStatistics = (TaskStatistics) obj;
            return this.f5683a == taskStatistics.f5683a && kotlin.jvm.internal.g.b(this.f5684b, taskStatistics.f5684b) && this.f5685c == taskStatistics.f5685c;
        }

        public final Map<String, Integer> getTasksByDispatcher() {
            return this.f5684b;
        }

        public final int getTotalActiveTasks() {
            return this.f5683a;
        }

        public final long getTotalTasksCreated() {
            return this.f5685c;
        }

        public int hashCode() {
            return Long.hashCode(this.f5685c) + ((this.f5684b.hashCode() + (Integer.hashCode(this.f5683a) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("TaskStatistics(totalActiveTasks=");
            sb2.append(this.f5683a);
            sb2.append(", tasksByDispatcher=");
            sb2.append(this.f5684b);
            sb2.append(", totalTasksCreated=");
            return ai.onnxruntime.a.m(sb2, this.f5685c, ")");
        }
    }

    public TrackedCoroutineDispatcher(CoroutineDispatcher delegate, String dispatcherName) {
        kotlin.jvm.internal.g.f(delegate, "delegate");
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        this.f5666a = delegate;
        this.f5667b = dispatcherName;
    }

    public final void K(TaskEvent taskEvent) {
        try {
            l<? super TaskEvent, n> lVar = f5664d;
            if (lVar != null) {
                lVar.invoke(taskEvent);
            }
            l<TaskEvent, n> lVar2 = f5665e.get(this.f5667b);
            if (lVar2 != null) {
                lVar2.invoke(taskEvent);
            }
        } catch (Exception e10) {
            Log.e("TrackedDispatcher", "监听器回调异常", e10);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(kotlin.coroutines.d context, final Runnable block) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(block, "block");
        final long jIncrementAndGet = f5663c.incrementAndGet();
        this.f5666a.dispatch(context, new Runnable() { // from class: com.stepos.aicgroup.g
            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable = block;
                TrackedCoroutineDispatcher.Companion companion = TrackedCoroutineDispatcher.Companion;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long id2 = Thread.currentThread().getId();
                String name = Thread.currentThread().getName();
                TrackedCoroutineDispatcher trackedCoroutineDispatcher = this;
                String str = trackedCoroutineDispatcher.f5667b;
                kotlin.jvm.internal.g.c(name);
                long j10 = jIncrementAndGet;
                TrackedCoroutineDispatcher.TaskInfo taskInfo = new TrackedCoroutineDispatcher.TaskInfo(j10, str, jElapsedRealtime, id2, name);
                Long lValueOf = Long.valueOf(j10);
                ConcurrentHashMap<Long, TrackedCoroutineDispatcher.TaskInfo> concurrentHashMap = TrackedCoroutineDispatcher.h;
                concurrentHashMap.put(lValueOf, taskInfo);
                trackedCoroutineDispatcher.K(new TrackedCoroutineDispatcher.TaskEvent(j10, trackedCoroutineDispatcher.f5667b, true, id2, name, jElapsedRealtime, null, null, null, 448, null));
                TrackedCoroutineDispatcher.TaskEndStatus taskEndStatus = TrackedCoroutineDispatcher.TaskEndStatus.COMPLETED;
                try {
                    try {
                        try {
                            runnable.run();
                            concurrentHashMap.remove(Long.valueOf(j10));
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                            trackedCoroutineDispatcher.K(new TrackedCoroutineDispatcher.TaskEvent(j10, trackedCoroutineDispatcher.f5667b, false, id2, name, jElapsedRealtime2, Long.valueOf(jElapsedRealtime2 - jElapsedRealtime), taskEndStatus, null));
                        } catch (CancellationException e10) {
                            TrackedCoroutineDispatcher.TaskEndStatus taskEndStatus2 = TrackedCoroutineDispatcher.TaskEndStatus.CANCELLED;
                            String message = e10.getMessage();
                            if (message == null) {
                                message = "Coroutine cancelled";
                            }
                            throw e10;
                        }
                    } catch (Throwable th) {
                        TrackedCoroutineDispatcher.TaskEndStatus taskEndStatus3 = TrackedCoroutineDispatcher.TaskEndStatus.FAILED;
                        String message2 = th.getMessage();
                        if (message2 == null) {
                            message2 = th.getClass().getSimpleName();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    concurrentHashMap.remove(Long.valueOf(j10));
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                    trackedCoroutineDispatcher.K(new TrackedCoroutineDispatcher.TaskEvent(j10, trackedCoroutineDispatcher.f5667b, false, id2, name, jElapsedRealtime3, Long.valueOf(jElapsedRealtime3 - jElapsedRealtime), taskEndStatus, null));
                    throw th2;
                }
            }
        });
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskEvent {

        /* renamed from: a, reason: collision with root package name */
        public final long f5670a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5671b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5672c;

        /* renamed from: d, reason: collision with root package name */
        public final long f5673d;

        /* renamed from: e, reason: collision with root package name */
        public final String f5674e;

        /* renamed from: f, reason: collision with root package name */
        public final long f5675f;

        /* renamed from: g, reason: collision with root package name */
        public final Long f5676g;
        public final TaskEndStatus h;

        /* renamed from: i, reason: collision with root package name */
        public final String f5677i;

        public TaskEvent(long j10, String dispatcherName, boolean z, long j11, String threadName, long j12, Long l10, TaskEndStatus taskEndStatus, String str) {
            kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
            kotlin.jvm.internal.g.f(threadName, "threadName");
            this.f5670a = j10;
            this.f5671b = dispatcherName;
            this.f5672c = z;
            this.f5673d = j11;
            this.f5674e = threadName;
            this.f5675f = j12;
            this.f5676g = l10;
            this.h = taskEndStatus;
            this.f5677i = str;
        }

        public static /* synthetic */ TaskEvent copy$default(TaskEvent taskEvent, long j10, String str, boolean z, long j11, String str2, long j12, Long l10, TaskEndStatus taskEndStatus, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = taskEvent.f5670a;
            }
            return taskEvent.copy(j10, (i10 & 2) != 0 ? taskEvent.f5671b : str, (i10 & 4) != 0 ? taskEvent.f5672c : z, (i10 & 8) != 0 ? taskEvent.f5673d : j11, (i10 & 16) != 0 ? taskEvent.f5674e : str2, (i10 & 32) != 0 ? taskEvent.f5675f : j12, (i10 & 64) != 0 ? taskEvent.f5676g : l10, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? taskEvent.h : taskEndStatus, (i10 & 256) != 0 ? taskEvent.f5677i : str3);
        }

        public final long component1() {
            return this.f5670a;
        }

        public final String component2() {
            return this.f5671b;
        }

        public final boolean component3() {
            return this.f5672c;
        }

        public final long component4() {
            return this.f5673d;
        }

        public final String component5() {
            return this.f5674e;
        }

        public final long component6() {
            return this.f5675f;
        }

        public final Long component7() {
            return this.f5676g;
        }

        public final TaskEndStatus component8() {
            return this.h;
        }

        public final String component9() {
            return this.f5677i;
        }

        public final TaskEvent copy(long j10, String dispatcherName, boolean z, long j11, String threadName, long j12, Long l10, TaskEndStatus taskEndStatus, String str) {
            kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
            kotlin.jvm.internal.g.f(threadName, "threadName");
            return new TaskEvent(j10, dispatcherName, z, j11, threadName, j12, l10, taskEndStatus, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskEvent)) {
                return false;
            }
            TaskEvent taskEvent = (TaskEvent) obj;
            return this.f5670a == taskEvent.f5670a && kotlin.jvm.internal.g.b(this.f5671b, taskEvent.f5671b) && this.f5672c == taskEvent.f5672c && this.f5673d == taskEvent.f5673d && kotlin.jvm.internal.g.b(this.f5674e, taskEvent.f5674e) && this.f5675f == taskEvent.f5675f && kotlin.jvm.internal.g.b(this.f5676g, taskEvent.f5676g) && this.h == taskEvent.h && kotlin.jvm.internal.g.b(this.f5677i, taskEvent.f5677i);
        }

        public final String getDispatcherName() {
            return this.f5671b;
        }

        public final Long getDuration() {
            return this.f5676g;
        }

        public final TaskEndStatus getEndStatus() {
            return this.h;
        }

        public final String getErrorMessage() {
            return this.f5677i;
        }

        public final long getTaskId() {
            return this.f5670a;
        }

        public final long getThreadId() {
            return this.f5673d;
        }

        public final String getThreadName() {
            return this.f5674e;
        }

        public final long getTimestamp() {
            return this.f5675f;
        }

        public int hashCode() {
            int iC = a0.a.c(v1.d.a(a0.a.c(ai.onnxruntime.a.f(v1.d.a(Long.hashCode(this.f5670a) * 31, 31, this.f5671b), 31, this.f5672c), this.f5673d, 31), 31, this.f5674e), this.f5675f, 31);
            Long l10 = this.f5676g;
            int iHashCode = (iC + (l10 == null ? 0 : l10.hashCode())) * 31;
            TaskEndStatus taskEndStatus = this.h;
            int iHashCode2 = (iHashCode + (taskEndStatus == null ? 0 : taskEndStatus.hashCode())) * 31;
            String str = this.f5677i;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public final boolean isStart() {
            return this.f5672c;
        }

        public String toString() {
            StringBuilder sbO = a0.a.o("TaskEvent(taskId=", this.f5670a, ", dispatcherName=", this.f5671b);
            sbO.append(", isStart=");
            sbO.append(this.f5672c);
            sbO.append(", threadId=");
            ai.onnxruntime.a.u(this.f5673d, ", threadName=", this.f5674e, sbO);
            a0.a.s(this.f5675f, ", timestamp=", ", duration=", sbO);
            sbO.append(this.f5676g);
            sbO.append(", endStatus=");
            sbO.append(this.h);
            sbO.append(", errorMessage=");
            return ai.onnxruntime.a.o(sbO, this.f5677i, ")");
        }

        public /* synthetic */ TaskEvent(long j10, String str, boolean z, long j11, String str2, long j12, Long l10, TaskEndStatus taskEndStatus, String str3, int i10, kotlin.jvm.internal.e eVar) {
            this(j10, str, z, j11, str2, j12, (i10 & 64) != 0 ? null : l10, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? null : taskEndStatus, (i10 & 256) != 0 ? null : str3);
        }
    }
}
