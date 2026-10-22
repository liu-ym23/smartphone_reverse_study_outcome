package com.android.server.power;

import android.os.WorkSource;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes3.dex */
public class FrameworkStatsLogger {

    public static final enum WakelockEventType extends Enum<WakelockEventType> {
        private static final /* synthetic */ WakelockEventType[] $VALUES = null;
        public static final WakelockEventType ACQUIRE = null;
        public static final WakelockEventType RELEASE = null;

        private static /* synthetic */ WakelockEventType[] $values() {
            return new WakelockEventType[]{ACQUIRE, RELEASE};
        }

        private WakelockEventType(String r1, int r2) {
            super(r1, r2);
        }

        public static WakelockEventType valueOf(String name) {
            return (WakelockEventType) Enum.valueOf(WakelockEventType.class, name);
        }

        public static WakelockEventType[] values() {
            return (WakelockEventType[]) $VALUES.clone();
        }

        static {
            ACQUIRE = new WakelockEventType("ACQUIRE", 0);
            RELEASE = new WakelockEventType("RELEASE", 1);
            $VALUES = $values();
        }
    }

    public FrameworkStatsLogger() {
    }

    public void wakelockStateChanged(int ownerUid, String tag, int powerManagerWakeLockLevel, WakelockEventType eventType) {
        if (eventType != WakelockEventType.ACQUIRE) goto L5;
        int r0 = 1;
    L6:
        int event = r0;
        FrameworkStatsLog.write_non_chained(10, ownerUid, null, powerManagerWakeLockLevel, tag, event, 999);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public void wakelockStateChanged(String tag, WorkSource.WorkChain wc, int powerManagerWakeLockLevel, WakelockEventType eventType) {
        if (eventType != WakelockEventType.ACQUIRE) goto L5;
        int r0 = 1;
    L6:
        int event = r0;
        FrameworkStatsLog.write(10, wc.getUids(), wc.getTags(), powerManagerWakeLockLevel, tag, event, 999);
        return;
    L5:
        r0 = 0;
        goto L6
    }
}
