package com.android.server.am;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryRecord {
    public long freeRAM;
    public long kernelCached;
    public long lostRAM;
    public long totalRAM;
    public long usedRAM;

    public MemoryRecord() {
    }

    public String toString() {
        return this.totalRAM + "|" + this.freeRAM + "|" + this.usedRAM + "|" + this.lostRAM;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total_ram", this.totalRAM);     // Catch: JSONException -> L5
        jsonObject.put("lost_ram", this.lostRAM);     // Catch: JSONException -> L5
        jsonObject.put("kernel_cached", this.kernelCached);     // Catch: JSONException -> L5
    L7:
        return jsonObject;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static MemoryRecord readMemInfo() {
        MemoryRecord memoryRecord = new MemoryRecord();
        return memoryRecord;
    }
}
