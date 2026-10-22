package com.android.server.power;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PowerHighMonitor {
    public long currentTime;
    private Map<HighType, Record> highList;
    public boolean isCollectAppLog;
    private Set<LogType> logTypes;
    public final String pkgName;
    public final int uid;

    public static final enum HighType extends Enum<HighType> {
        private static final /* synthetic */ HighType[] $VALUES = null;
        public static final HighType ADSP = null;
        public static final HighType ALARM = null;
        public static final HighType ANIMATION_LEAK = null;
        public static final HighType CDSP = null;
        public static final HighType CPU_HIGH_FREQ = null;
        public static final HighType CPU_LOAD = null;
        public static final HighType GPS = null;
        public static final HighType HANDLER_LEAK = null;
        public static final HighType NETWORK = null;
        public static final HighType PARTIAL_WAKELOCK = null;
        public static final HighType WIFI_SCAN = null;

        private static /* synthetic */ HighType[] $values() {
            return new HighType[]{CPU_LOAD, NETWORK, GPS, PARTIAL_WAKELOCK, ALARM, WIFI_SCAN, ANIMATION_LEAK, HANDLER_LEAK, ADSP, CDSP, CPU_HIGH_FREQ};
        }

        private HighType(String r1, int r2) {
            super(r1, r2);
        }

        public static HighType valueOf(String name) {
            return (HighType) Enum.valueOf(HighType.class, name);
        }

        public static HighType[] values() {
            return (HighType[]) $VALUES.clone();
        }

        static {
            CPU_LOAD = new HighType("CPU_LOAD", 0);
            NETWORK = new HighType("NETWORK", 1);
            GPS = new HighType("GPS", 2);
            PARTIAL_WAKELOCK = new HighType("PARTIAL_WAKELOCK", 3);
            ALARM = new HighType("ALARM", 4);
            WIFI_SCAN = new HighType("WIFI_SCAN", 5);
            ANIMATION_LEAK = new HighType("ANIMATION_LEAK", 6);
            HANDLER_LEAK = new HighType("HANDLER_LEAK", 7);
            ADSP = new HighType("ADSP", 8);
            CDSP = new HighType("CDSP", 9);
            CPU_HIGH_FREQ = new HighType("CPU_HIGH_FREQ", 10);
            $VALUES = $values();
        }
    }

    public static final enum LogType extends Enum<LogType> {
        private static final /* synthetic */ LogType[] $VALUES = null;
        public static final LogType ADSP_RAM_DUMP = null;
        public static final LogType APP_LOG = null;
        public static final LogType AP_LOG = null;
        public static final LogType BUGREPORT = null;
        public static final LogType DATABASE = null;
        public static final LogType HD_AP_LOG = null;
        public static final LogType PERFETTO = null;
        public static final LogType POWER_MONITOR = null;

        private static /* synthetic */ LogType[] $values() {
            return new LogType[]{AP_LOG, HD_AP_LOG, DATABASE, POWER_MONITOR, BUGREPORT, PERFETTO, APP_LOG, ADSP_RAM_DUMP};
        }

        private LogType(String r1, int r2) {
            super(r1, r2);
        }

        public static LogType valueOf(String name) {
            return (LogType) Enum.valueOf(LogType.class, name);
        }

        public static LogType[] values() {
            return (LogType[]) $VALUES.clone();
        }

        static {
            AP_LOG = new LogType("AP_LOG", 0);
            HD_AP_LOG = new LogType("HD_AP_LOG", 1);
            DATABASE = new LogType("DATABASE", 2);
            POWER_MONITOR = new LogType("POWER_MONITOR", 3);
            BUGREPORT = new LogType("BUGREPORT", 4);
            PERFETTO = new LogType("PERFETTO", 5);
            APP_LOG = new LogType("APP_LOG", 6);
            ADSP_RAM_DUMP = new LogType("ADSP_RAM_DUMP", 7);
            $VALUES = $values();
        }
    }

    public static class Record {
        public String actionName;
        public HighType highType;
        public long latestApss;
        public long latestConsume;
        public long latestStatTime;
        public long scnOffApss;
        public long statTime;
        public long threshold;

        public Record(HighType highType, long threshold, long statTime, String actionName) {
            this.scnOffApss = -1;
            this.latestApss = -1;
            this.latestConsume = -1;
            this.latestStatTime = -1;
            this.highType = highType;
            this.threshold = threshold;
            this.statTime = statTime;
            this.actionName = actionName;
        }

        public void setSubSystem(long scnOffApss, long latestApss, long latestConsume, long latestStatTime) {
            this.scnOffApss = scnOffApss;
            this.latestApss = latestApss;
            this.latestConsume = latestConsume;
            this.latestStatTime = latestStatTime;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("{highType=");
            r0.append(this.highType);
            r0.append(" threshold=");
            r0.append(this.threshold);
            r0.append(" statTime=");
            r0.append(this.statTime);
            String r2 = "";
            if (this.actionName != null) goto L5;
            String r1 = "";
        L6:
            r0.append(r1);
            if (this.scnOffApss < 0) goto L9;
            String r3 = " scnOffApss=" + this.scnOffApss;
        L10:
            r0.append(r3);
            if (this.latestApss < 0) goto L13;
            String r4 = " latestApss=" + this.latestApss;
        L14:
            r0.append(r4);
            if (this.latestConsume < 0) goto L17;
            String r5 = " latestConsume=" + this.latestConsume;
        L18:
            r0.append(r5);
            if (this.latestStatTime < 0) goto L21;
            r2 = " latestStatTime=" + this.latestStatTime;
        L21:
            r0.append(r2);
            r0.append('}');
            return r0.toString();
        L17:
            r5 = "";
            goto L18
        L13:
            r4 = "";
            goto L14
        L9:
            r3 = "";
            goto L10
        L5:
            r1 = " actionName=" + this.actionName;
            goto L6
        }
    }

    public PowerHighMonitor(String pkgName, int uid, long currentTime) {
        this.isCollectAppLog = false;
        this.pkgName = pkgName;
        this.uid = uid;
        this.currentTime = currentTime;
    }

    public synchronized void setHighList(Map<HighType, Record> highList) {
        monitor-enter(this);
        this.highList = new ConcurrentHashMap();     // Catch: Throwable -> L6
        this.highList.putAll(highList);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Map<HighType, Record> getHighList() {
        monitor-enter(this);
        Map<HighType, Record> r0 = this.highList;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setLogTypes(Set<LogType> logTypes) {
        monitor-enter(this);
        this.logTypes = new HashSet();     // Catch: Throwable -> L6
        this.logTypes.addAll(logTypes);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Set<LogType> getLogTypes() {
        monitor-enter(this);
        Set<LogType> r0 = this.logTypes;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Record{");
        if (this.pkgName == null) goto L6;
        sb.append("pkg=");
        sb.append(this.pkgName);
    L6:
        if (this.uid < 0) goto L8;
        sb.append(" uid=");
        sb.append(this.uid);
    L8:
        sb.append(" logTypes=");
        sb.append(getLogTypes());
        if (this.highList == null) goto L14;
        Iterator<Map.Entry<HighType, Record>> r1 = this.highList.entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<HighType, Record> entry = r1.next();
        sb.append(entry.getValue());
    L14:
        sb.append('}');
        return sb.toString();
    }
}
