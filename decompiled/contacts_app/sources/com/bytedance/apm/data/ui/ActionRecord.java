package com.bytedance.apm.data.ui;

import com.bytedance.apm.structure.LimitQueue;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ActionRecord {
    private static volatile ActionRecord singleton;
    private LimitQueue<JSONObject> mActionQueue;

    private ActionRecord() {
        this.mActionQueue = new LimitQueue(20);
    }

    public static ActionRecord getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(ActionRecord.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new ActionRecord();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ActionRecord.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    public void addRecord(JSONObject r1) {
        this.mActionQueue.enqueue(r1);
    }

    public List<JSONObject> getRecords() {
        return this.mActionQueue.toList();
    }
}
