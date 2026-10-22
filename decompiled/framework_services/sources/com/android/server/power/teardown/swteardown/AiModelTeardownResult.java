package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class AiModelTeardownResult extends ComponentResult {
    public ConcurrentHashMap<String, AiModelInfo> mAiModelEntrys;
    public long mDuration;

    public static class AiModelInfo {
        public String mBizs;
        public double mCurrent;
        public long mDuration;
        public String mKey;
        public String mModelName;
        public String mPerfMode;
        public String mPkgName;
        public int mRunCurrent;
        public long mStartTime;
        public int mThermalLevel;
        public int mUid;

        public AiModelInfo(String key, String bizs, int uid, String pkgName, int thermalLevel, String modelName, String perfMode, long duration, long startTime) {
            this.mKey = key;
            this.mBizs = bizs;
            this.mUid = uid;
            this.mPkgName = pkgName;
            this.mThermalLevel = thermalLevel;
            this.mModelName = modelName;
            this.mPerfMode = perfMode;
            this.mDuration = duration;
            this.mStartTime = startTime;
        }

        public String toString() {
            return "[Ai model Uid] key = " + this.mKey + ", bizs = " + this.mBizs + ", uid=" + this.mUid + ", pkgName=" + this.mPkgName + ", thermalLevel=" + this.mThermalLevel + ", modelName=" + this.mModelName + ", perfMode=" + this.mPerfMode + ", current=" + this.mCurrent + "mA, runCurrent=" + this.mRunCurrent + "mA, duration=" + this.mDuration + "ms, startTime=" + this.mStartTime + "ms.\n";
        }
    }

    public AiModelTeardownResult() {
        this.mAiModelEntrys = new ConcurrentHashMap();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Ai Model All] ");
        sb.append("Ai Model cdsp current=");
        sb.append(this.mCurrent);
        sb.append("mA, activeTime=");
        sb.append(this.mDuration);
        sb.append("ms.\n");
        Iterator<Map.Entry<String, AiModelInfo>> r1 = this.mAiModelEntrys.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, AiModelInfo> entry = r1.next();
        AiModelInfo aiModelInfo = entry.getValue();
        sb.append(aiModelInfo.toString());
        goto L4
    L7:
        return sb.toString();
    }
}
