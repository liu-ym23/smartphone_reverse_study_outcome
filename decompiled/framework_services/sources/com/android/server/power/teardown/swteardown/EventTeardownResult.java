package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class EventTeardownResult extends ComponentResult {
    public static final String EVENT_AOD = "aod";
    public static final String EVENT_CHARGING = "charging";
    public static final String EVENT_DEEP_DOZE = "deep_doze";
    public static final String EVENT_FIRE_WALL = "fire_wall";
    public static final String EVENT_LIGHT_DOZE = "light_doze";
    public static final String EVENT_SCREEN = "screen";
    public static final String EVENT_SLEEP_MODE = "sleep_mode";
    private static final DateTimeFormatter mFormatter = null;
    public List<EventInfo> mEventList;
    public List<FrontAppInfo> mFrontAppList;
    public List<SubSysStatsInfo> mSubSysStatsList;

    public static class EventInfo {
        public String payload;
        public String tag;
        public long time;
        public int value;

        public EventInfo(String tag, long time, int value, String payload) {
            this.tag = tag;
            this.time = time;
            this.value = value;
            this.payload = payload;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[EventInfo] ");
            sb.append("tag =");
            sb.append(this.tag);
            sb.append(", time:");
            Instant instant = Instant.ofEpochMilli(this.time);
            LocalTime localTime = instant.atZone(ZoneId.systemDefault()).toLocalTime();
            sb.append(EventTeardownResult.m7870$$Nest$sfgetmFormatter().format(localTime));
            sb.append(", value =");
            sb.append(this.value);
            sb.append(", payload =");
            sb.append(this.payload);
            return sb.toString();
        }
    }

    public static class FrontAppInfo {
        public int current;
        public long endTime;
        public String pkg;
        public long startTime;
        public int uid;

        public FrontAppInfo(String pkg, int uid, long startTime, long endTime, int current) {
            this.pkg = pkg;
            this.uid = uid;
            this.startTime = startTime;
            this.endTime = endTime;
            this.current = current;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[FrontAppInfo] ");
            sb.append("pkg =");
            sb.append(this.pkg);
            sb.append(", uid =");
            sb.append(this.uid);
            sb.append(", startTime:");
            Instant instant = Instant.ofEpochMilli(this.startTime);
            LocalTime localTime = instant.atZone(ZoneId.systemDefault()).toLocalTime();
            sb.append(EventTeardownResult.m7870$$Nest$sfgetmFormatter().format(localTime));
            sb.append(", endTime:");
            Instant instant2 = Instant.ofEpochMilli(this.endTime);
            LocalTime localTime2 = instant2.atZone(ZoneId.systemDefault()).toLocalTime();
            sb.append(EventTeardownResult.m7870$$Nest$sfgetmFormatter().format(localTime2));
            sb.append(", current =");
            sb.append(this.current);
            sb.append("mA.");
            return sb.toString();
        }
    }

    public static class SubSysStatsInfo {
        public long adsp;
        public long aosd;
        public long apss;
        public long cdsp;
        public long cxsd;
        public long ddr;
        public long elapsedRealtime;
        public long mpss;
        public long qcnWifi;
        public long slpi;
        public long time;
        public long totalDuration;
        public long uptime;
        public long wifi;

        public SubSysStatsInfo(long elapsedRealtime, long uptime, long time, long apss, long mpss, long adsp, long cdsp, long slpi, long wifi, long ddr, long aosd, long cxsd, long qcnWifi) {
            this.elapsedRealtime = elapsedRealtime;
            this.uptime = uptime;
            this.time = time;
            this.apss = apss;
            this.mpss = mpss;
            this.adsp = adsp;
            this.cdsp = cdsp;
            this.slpi = slpi;
            this.wifi = wifi;
            this.ddr = ddr;
            this.aosd = aosd;
            this.cxsd = cxsd;
            this.qcnWifi = qcnWifi;
        }

        public void setTotalDuration(long totalDuration) {
            this.totalDuration = totalDuration;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[SubSysStats] ");
            sb.append("time:");
            Instant instant = Instant.ofEpochMilli(this.time);
            LocalTime localTime = instant.atZone(ZoneId.systemDefault()).toLocalTime();
            sb.append(EventTeardownResult.m7870$$Nest$sfgetmFormatter().format(localTime));
            sb.append(", elapsedRealtime =");
            sb.append(this.elapsedRealtime);
            sb.append(", uptime =");
            sb.append(this.uptime);
            sb.append(", totalDuration =");
            sb.append(this.totalDuration);
            sb.append(", apss =");
            sb.append(this.apss);
            sb.append(", mpss =");
            sb.append(this.mpss);
            sb.append(", adsp =");
            sb.append(this.adsp);
            sb.append(", cdsp =");
            sb.append(this.cdsp);
            sb.append(", slpi =");
            sb.append(this.slpi);
            sb.append(", wifi =");
            sb.append(this.wifi);
            sb.append(", ddr =");
            sb.append(this.ddr);
            sb.append(", aosd =");
            sb.append(this.aosd);
            sb.append(", cxsd =");
            sb.append(this.cxsd);
            sb.append(", qcnWifi =");
            sb.append(this.qcnWifi);
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmFormatter, reason: not valid java name */
    static /* bridge */ /* synthetic */ DateTimeFormatter m7870$$Nest$sfgetmFormatter() {
        return mFormatter;
    }

    static {
        mFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());
    }

    public EventTeardownResult() {
        this.mEventList = new ArrayList();
        this.mFrontAppList = new ArrayList();
        this.mSubSysStatsList = new ArrayList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.mEventList.size() <= 0) goto L9;
        Iterator<EventInfo> r1 = this.mEventList.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        EventInfo info = r1.next();
        sb.append(info.toString());
        sb.append("\n");
    L9:
        if (this.mFrontAppList.size() <= 0) goto L15;
        Iterator<FrontAppInfo> r2 = this.mFrontAppList.iterator();
    L12:
        if (r2.hasNext() == false) goto L15;
        FrontAppInfo info2 = r2.next();
        sb.append(info2.toString());
        sb.append("\n");
    L15:
        if (this.mSubSysStatsList.size() <= 0) goto L21;
        Iterator<SubSysStatsInfo> r3 = this.mSubSysStatsList.iterator();
    L18:
        if (r3.hasNext() == false) goto L21;
        SubSysStatsInfo sysStatsInfo = r3.next();
        sb.append(sysStatsInfo.toString());
        sb.append("\n");
    L21:
        return sb.toString();
    }
}
