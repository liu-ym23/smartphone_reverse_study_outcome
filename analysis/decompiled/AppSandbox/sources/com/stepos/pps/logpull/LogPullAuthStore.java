package com.stepos.pps.logpull;

import android.content.Context;
import android.util.Log;
import com.stepos.pps.logpull.LogPullTaskList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class LogPullAuthStore {
    private static final String TAG = "LogPull.AuthStore";
    private final LogPullTaskList list;

    public LogPullAuthStore(Context context) {
        this.list = new LogPullTaskList(context);
    }

    public synchronized void enqueue(LogPullConfig logPullConfig) {
        if (logPullConfig != null) {
            if (logPullConfig.configId > 0) {
                if (this.list.get(logPullConfig.configId) != null) {
                    return;
                }
                LogPullTaskList.Entry entry = new LogPullTaskList.Entry();
                entry.configId = logPullConfig.configId;
                entry.oaid = logPullConfig.oaid;
                entry.phase = LogPullTaskList.PHASE_PENDING_AUTH;
                entry.logTypes = logPullConfig.logTypes != null ? logPullConfig.logTypes : new String[0];
                entry.logStartTime = logPullConfig.logStartTime;
                entry.logEndTime = logPullConfig.logEndTime;
                entry.deadlineTime = logPullConfig.deadlineTime;
                entry.maxLimit = logPullConfig.maxLimit;
                entry.fileType = logPullConfig.fileType != null ? logPullConfig.fileType : "zip";
                this.list.put(entry);
                Log.i(TAG, "入队待授权: configId=" + logPullConfig.configId);
            }
        }
    }

    public synchronized void remove(long j) {
        LogPullTaskList.Entry entry = this.list.get(j);
        if (entry != null && LogPullTaskList.PHASE_PENDING_AUTH.equals(entry.phase)) {
            this.list.remove(j);
            Log.i(TAG, "移除待授权: configId=" + j);
        }
    }

    public synchronized List<LogPullConfig> loadAll() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<LogPullTaskList.Entry> it = this.list.byPhase(LogPullTaskList.PHASE_PENDING_AUTH).iterator();
        while (it.hasNext()) {
            arrayList.add(toConfig(it.next()));
        }
        return arrayList;
    }

    public synchronized LogPullConfig find(long j) {
        LogPullTaskList.Entry entry = this.list.get(j);
        if (entry == null || !LogPullTaskList.PHASE_PENDING_AUTH.equals(entry.phase)) {
            return null;
        }
        return toConfig(entry);
    }

    public synchronized void setShowing(long j) {
        this.list.setShowing(j);
    }

    public synchronized long getShowing() {
        return this.list.getShowing();
    }

    public synchronized void clearShowing() {
        this.list.clearShowing();
    }

    private static LogPullConfig toConfig(LogPullTaskList.Entry entry) {
        LogPullConfig logPullConfig = new LogPullConfig();
        logPullConfig.configId = entry.configId;
        logPullConfig.oaid = entry.oaid;
        logPullConfig.logTypes = entry.logTypes != null ? entry.logTypes : new String[0];
        logPullConfig.logStartTime = entry.logStartTime;
        logPullConfig.logEndTime = entry.logEndTime;
        logPullConfig.deadlineTime = entry.deadlineTime;
        logPullConfig.maxLimit = entry.maxLimit;
        logPullConfig.fileType = entry.fileType != null ? entry.fileType : "zip";
        return logPullConfig;
    }
}
