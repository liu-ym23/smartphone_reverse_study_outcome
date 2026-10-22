package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WakelockTeardownResult extends ComponentResult {
    public List<WakelockTeardownEntry> mEnterys;

    public static class WakelockTeardownEntry {
        public double mCurrent;
        public long mDuration;
        public boolean mIsKernelWl;
        public String mPackageName;
        public long mScnOffTotalHoldDuration;
        public int mUid;
        public String mWakelockName;

        public WakelockTeardownEntry(double current, int uid, String packageName, String name, long duration, long scnOffTotalHoldDuration, boolean isKernelWakelock) {
            this.mCurrent = current;
            this.mIsKernelWl = isKernelWakelock;
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mDuration = duration;
            this.mScnOffTotalHoldDuration = scnOffTotalHoldDuration;
            this.mWakelockName = name;
        }

        public String toString() {
            return "[uid=" + this.mUid + ", packageName=" + this.mPackageName + ", wakelockName=" + this.mWakelockName + ", duration=" + (this.mDuration / 1000) + "s, scnOffDuration=" + (this.mScnOffTotalHoldDuration / 1000) + "s, current=" + String.format("%.2f", new Object[]{Double.valueOf(this.mCurrent)}) + "mA]\n";
        }
    }

    public WakelockTeardownResult(int wakelockCurrent, List<WakelockTeardownEntry> entrys) {
        this.mCurrent = wakelockCurrent;
        this.mEnterys = entrys;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Wakelock]");
        sb.append("wakelock current = ");
        sb.append(this.mCurrent);
        sb.append("mA, ");
        Iterator<WakelockTeardownEntry> r2 = this.mEnterys.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        WakelockTeardownEntry entry = r2.next();
        sb.append("[Wakelock]");
        sb.append(entry.toString());
        goto L4
    L7:
        return sb.toString();
    }
}
