package com.bytedance.server.security.behaviorrecord.record;

import android.app.AppOpsManager;
import com.bytedance.server.security.behaviorrecord.AppBehaviorConst;

/* JADX INFO: loaded from: classes3.dex */
public class AppBehaviorInfo {
    int count;
    long duration;
    private final String mUniqueAppKey;
    private final String mUniqueKey;
    private final int opId;
    String opName;
    int operation;
    String packageName;
    long recordTime;
    int uid;
    int uidState;
    int userId;

    String getUniqueKey() {
        return this.mUniqueKey;
    }

    String getUniqueAppKey() {
        return this.mUniqueAppKey;
    }

    AppBehaviorInfo(long duration, int opId, int operation, String packageName, long recordTime, int uid, int uidState, int userId, int count) {
        this.duration = duration;
        this.opId = opId;
        this.opName = coverOpToOpName(opId);
        this.operation = operation;
        this.packageName = packageName;
        this.recordTime = recordTime;
        this.uid = uid;
        this.uidState = uidState;
        this.userId = userId;
        this.count = count;
        this.mUniqueAppKey = uid + packageName + userId + this.opName;
        this.mUniqueKey = recordTime + packageName + uid + this.opName + userId;
    }

    static String coverOpToOpName(int op) {
        if (AppBehaviorConst.VALID_OP_NAME_MAP.containsKey(Integer.valueOf(op)) == false) goto L7;
        return AppBehaviorConst.VALID_OP_NAME_MAP.get(Integer.valueOf(op));
    L7:
        return AppOpsManager.opToName(op);
    }

    public boolean isValid() {
        return AppBehaviorConst.VALID_OPS.contains(Integer.valueOf(this.opId));
    }

    public String toString() {
        return this.recordTime + "|" + this.userId + "|" + this.duration + "|" + this.packageName + "|" + this.uid + "|" + this.opName + "|" + this.uidState + "|" + this.operation + "|" + this.count;
    }
}
