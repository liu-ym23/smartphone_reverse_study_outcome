package com.stepos.core.model.task;

import android.content.Context;
import android.util.Log;
import com.tencent.mmkv.MMKV;
import gc.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import lb.n;
import mb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskHistory {
    private static final int MAX_RECORDS = 1000;
    private static final String MMKV_ID = "task_history";
    private static final String TAG = "TaskHistory";
    private static volatile MMKV mmkv;
    public static final TaskHistory INSTANCE = new TaskHistory();
    private static final k<TaskInvokeRecord> records = new k<>(1000);
    private static final ConcurrentHashMap<String, Long> avgCache = new ConcurrentHashMap<>();

    private TaskHistory() {
    }

    public static /* synthetic */ List dump$default(TaskHistory taskHistory, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1000;
        }
        return taskHistory.dump(i10);
    }

    public static /* synthetic */ void dumpToLog$default(TaskHistory taskHistory, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 10;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        taskHistory.dumpToLog(i10, str);
    }

    private final String initTimeKey(String str) {
        return a0.a.j(str, ".init.time");
    }

    private final String invokeTimeKey(String str) {
        return a0.a.j(str, ".invoke.time");
    }

    private final void persistAverage(TaskInvokeRecord taskInvokeRecord) {
        updateAvg(invokeTimeKey(taskInvokeRecord.getModelId()), taskInvokeRecord.getInferenceTimeMs());
        long firstTokenAt = taskInvokeRecord.getFirstTokenAt() > 0 ? taskInvokeRecord.getFirstTokenAt() - taskInvokeRecord.getStartedAt() : -1L;
        if (firstTokenAt > 0) {
            updateAvg(ttftKey(taskInvokeRecord.getModelId()), firstTokenAt);
        }
        long tokenCount = taskInvokeRecord.getInferenceTimeMs() > 0 ? (long) ((taskInvokeRecord.getTokenCount() / (taskInvokeRecord.getInferenceTimeMs() / 1000.0f)) * 100) : -1L;
        if (tokenCount > 0) {
            updateAvg(tpsKey(taskInvokeRecord.getModelId()), tokenCount);
        }
    }

    private final String tpsKey(String str) {
        return a0.a.j(str, ".invoke.tps_x100");
    }

    private final String ttftKey(String str) {
        return a0.a.j(str, ".invoke.ttft");
    }

    private final void updateAvg(String str, long j10) {
        ConcurrentHashMap<String, Long> concurrentHashMap = avgCache;
        Long l10 = concurrentHashMap.get(str);
        long jLongValue = l10 != null ? l10.longValue() : 0L;
        if (jLongValue != 0) {
            j10 = (j10 + jLongValue) / 2;
        }
        concurrentHashMap.put(str, Long.valueOf(j10));
        try {
            MMKV mmkv2 = mmkv;
            if (mmkv2 != null) {
                mmkv2.j(j10, str);
            }
        } catch (Exception e10) {
            a0.a.w("MMKV write failed for ", str, ": ", e10.getMessage(), TAG);
        }
    }

    public final List<TaskInvokeRecord> dump(int i10) {
        List<TaskInvokeRecord> listF0;
        k<TaskInvokeRecord> kVar = records;
        synchronized (kVar) {
            listF0 = kotlin.collections.a.F0(kotlin.collections.a.K0(i10, kVar));
        }
        return listF0;
    }

    public final void dumpToLog(int i10, String str) {
        List listDump$default = dump$default(this, 0, 1, null);
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listDump$default) {
                if (o.k0(((TaskInvokeRecord) obj).getModelId(), str, false)) {
                    arrayList.add(obj);
                }
            }
            listDump$default = arrayList;
        }
        List listJ0 = kotlin.collections.a.J0(i10, listDump$default);
        Log.i(TAG, "=== TaskHistory dump (" + listJ0.size() + " records) ===");
        Iterator it = listJ0.iterator();
        while (it.hasNext()) {
            Log.i(TAG, ((TaskInvokeRecord) it.next()).toLogString());
        }
        Log.i(TAG, "=== end dump ===");
    }

    public final long getAverageInitTimeMs(String modelId) {
        g.f(modelId, "modelId");
        Long l10 = avgCache.get(initTimeKey(modelId));
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    public final long getAverageInvokeTimeMs(String modelId) {
        g.f(modelId, "modelId");
        Long l10 = avgCache.get(invokeTimeKey(modelId));
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    public final long getAverageTpsX100(String modelId) {
        g.f(modelId, "modelId");
        Long l10 = avgCache.get(tpsKey(modelId));
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    public final long getAverageTtftMs(String modelId) {
        g.f(modelId, "modelId");
        Long l10 = avgCache.get(ttftKey(modelId));
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    public final void init(Context context) {
        g.f(context, "context");
        try {
            MMKV.m(context);
            MMKV mmkvO = MMKV.o(MMKV_ID);
            mmkv = mmkvO;
            String[] strArrA = mmkvO.a();
            if (strArrA != null) {
                for (String str : strArrA) {
                    long jF = mmkvO.f(0L, str);
                    if (jF > 0) {
                        avgCache.put(str, Long.valueOf(jF));
                    }
                }
            }
            Log.i(TAG, "MMKV initialized, loaded " + avgCache.size() + " history entries");
        } catch (Exception e10) {
            a0.a.A("MMKV init failed, using in-memory only: ", e10.getMessage(), TAG);
        }
    }

    public final void record(TaskInvokeRecord r) {
        g.f(r, "r");
        k<TaskInvokeRecord> kVar = records;
        synchronized (kVar) {
            try {
                if (kVar.a() >= 1000) {
                    kVar.removeFirst();
                }
                kVar.addLast(r);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (r.getCanceledAt() == null && r.getInferenceTimeMs() > 0) {
            persistAverage(r);
        }
        a0.a.v("Recorded: ", r.toLogString(), TAG);
    }

    public final void recordInitTime(String modelId, long j10) {
        g.f(modelId, "modelId");
        updateAvg(initTimeKey(modelId), j10);
    }
}
