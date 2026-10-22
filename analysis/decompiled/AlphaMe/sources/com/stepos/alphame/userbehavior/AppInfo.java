package com.stepos.alphame.userbehavior;

import B0.g;
import android.util.Log;
import android.util.Pair;
import com.stepos.alphame.common.utils.TimeUtils;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class AppInfo {
    String pkgName;
    final List<Long> notiRecords = new ArrayList();
    final List<UseRecord> useRecords = new ArrayList();

    public interface AppUsageInGap {
        long sumBetween(long j4, long j5);
    }

    public class UseRecord {
        long end;
        long start;

        public UseRecord(long j4, long j5) {
            this.start = j4;
            this.end = j5;
        }

        public String toString() {
            return "from " + StringUtil.formatDateFull(this.start) + " to " + StringUtil.formatDateFull(this.end);
        }
    }

    public AppInfo(String str) {
        this.pkgName = str;
    }

    private static long capGapByAppUsage(long j4, long j5, long j6, AppUsageInGap appUsageInGap) {
        if (j4 <= 0) {
            return 0L;
        }
        return appUsageInGap == null ? j4 : Math.max(0L, Math.min(j4, appUsageInGap.sumBetween(j5, j6)));
    }

    private static long capToWallClock(long j4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return j4 > jCurrentTimeMillis ? jCurrentTimeMillis : j4;
    }

    private boolean isInRange(long j4, long j5, long j6) {
        return j4 < j6 && j6 < j5;
    }

    public void clampRecordsToWallClock(long j4) {
        for (int size = this.useRecords.size() - 1; size >= 0; size--) {
            UseRecord useRecord = this.useRecords.get(size);
            long j5 = useRecord.start;
            if (j5 > j4) {
                this.useRecords.remove(size);
                AlphaMeLogger.debugLog("UserBehavior", this.pkgName + " clamp: remove future record " + useRecord);
            } else {
                if (useRecord.end > j4) {
                    useRecord.end = j4;
                }
                if (useRecord.end < j5) {
                    useRecord.end = j5;
                }
            }
        }
        for (int size2 = this.notiRecords.size() - 1; size2 >= 0; size2--) {
            if (this.notiRecords.get(size2).longValue() > j4) {
                this.notiRecords.remove(size2);
            }
        }
    }

    public void coalesceUseRecordsAfterClamp() {
        for (int size = this.useRecords.size() - 1; size >= 0; size--) {
            UseRecord useRecord = this.useRecords.get(size);
            if (useRecord.end - useRecord.start < 1000) {
                this.useRecords.remove(size);
            }
        }
        for (int size2 = this.useRecords.size() - 1; size2 > 0; size2--) {
            UseRecord useRecord2 = this.useRecords.get(size2 - 1);
            UseRecord useRecord3 = this.useRecords.get(size2);
            if (useRecord2.end == useRecord3.start) {
                useRecord2.end = useRecord3.end;
                this.useRecords.remove(size2);
            }
        }
    }

    public void end(long j4) {
        UseRecord lastUse = getLastUse();
        UseRecord secondLastUseRecord = getSecondLastUseRecord();
        if (secondLastUseRecord != null && lastUse != null) {
            long j5 = secondLastUseRecord.end;
            long j6 = lastUse.start;
            if (j5 > j6) {
                secondLastUseRecord.end = j6;
            }
        }
        if (lastUse != null) {
            lastUse.end = j4;
            AlphaMeLogger.debugLog("lastApp " + this.pkgName + " end time is " + StringUtil.formatDateFull(j4));
            Log.d(UserBehaviorDataSource.TAG, "++++++++++++++lastApp ++++++ " + this.pkgName + " end time is " + StringUtil.formatDateFull(j4));
            StringBuilder sb = new StringBuilder("++++++++++++++lastApp ++++++ end-start: ");
            sb.append(lastUse.end - lastUse.start);
            Log.d(UserBehaviorDataSource.TAG, sb.toString());
            if (lastUse.end - lastUse.start < 1000) {
                this.useRecords.remove(lastUse);
            }
        }
    }

    public long getLastStartTime() {
        UseRecord lastUse = getLastUse();
        if (lastUse != null) {
            return lastUse.start;
        }
        return 0L;
    }

    public UseRecord getLastUse() {
        if (this.useRecords.size() > 0) {
            return (UseRecord) g.h(this.useRecords, 1);
        }
        return null;
    }

    public int getNotisIn(long j4, long j5) {
        long jCapToWallClock = capToWallClock(j5);
        int i4 = 0;
        for (Long l4 : this.notiRecords) {
            if (l4.longValue() >= j4 && l4.longValue() < jCapToWallClock) {
                i4++;
            }
        }
        return i4;
    }

    public UseRecord getSecondLastUseRecord() {
        if (this.useRecords.size() > 1) {
            return (UseRecord) g.h(this.useRecords, 2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long getTopUseTimeByScreenOff(long r27, long r29, com.stepos.alphame.userbehavior.AppInfo.AppUsageInGap r31) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.userbehavior.AppInfo.getTopUseTimeByScreenOff(long, long, com.stepos.alphame.userbehavior.AppInfo$AppUsageInGap):long");
    }

    public long getUsedTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return getUsedTimeIn(TimeUtils.getBaseTimeMill(jCurrentTimeMillis), jCurrentTimeMillis);
    }

    public long getUsedTimeIn(long j4, long j5) {
        long jCapToWallClock = capToWallClock(j5);
        long jMax = 0;
        for (UseRecord useRecord : this.useRecords) {
            if (useRecord != null) {
                long j6 = useRecord.end;
                if (j6 > j4 && useRecord.start < jCapToWallClock) {
                    jMax += Math.max(0L, Math.min(j6, Math.min(jCapToWallClock, j5)) - Math.max(useRecord.start, j4));
                }
            }
        }
        StringBuilder sbE = AbstractC0831a.e("getUsedTimeIn  result : ", jMax, "  pkgName : ");
        sbE.append(this.pkgName);
        Log.d(UserBehaviorDataSource.TAG, sbE.toString());
        return jMax;
    }

    public int getValidRecordSize(Pair<Long, Long> pair) {
        int size = this.useRecords.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = size - 1;
            if ((i5 >= i6 || this.useRecords.get(i5).end != this.useRecords.get(i5 + 1).start) && ((i5 != i6 || this.useRecords.get(i5).end != this.useRecords.get(i5).start) && (pair == null || (this.useRecords.get(i5).end >= ((Long) pair.first).longValue() && this.useRecords.get(i5).end < ((Long) pair.second).longValue())))) {
                i4++;
            }
        }
        return i4;
    }

    public boolean hasUseRecord() {
        return this.useRecords.size() > 0;
    }

    public void onNotification(long j4) {
        this.notiRecords.add(Long.valueOf(j4));
    }

    public void refresh(long j4) {
        end(j4);
        use(j4);
    }

    public String toString() {
        return this.pkgName + "=(" + this.notiRecords.size() + ", " + getUsedTime() + ")";
    }

    public void use(long j4) {
        this.useRecords.add(new UseRecord(j4, j4));
    }

    public String toString(long j4, long j5) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.pkgName);
        sb.append("=(");
        sb.append(this.notiRecords.size());
        sb.append(", ");
        return g.p(sb, getUsedTimeIn(j4, j5), ")");
    }
}
