package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import f2.C0702g;
import f2.C0711p;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AlphaMeEntities {
    public static final String TAG = "AlphaMeEntities";

    public static class AppDailyUsage {
        private int notificationNumber;
        private String packageName;
        private long usedTime;

        public void dump() {
            C0702g.M(AlphaMeEntities.TAG, "\t\tAppDailyUsage #" + hashCode() + "{");
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\tpackageName = ");
            sb.append(this.packageName);
            C0702g.M(AlphaMeEntities.TAG, sb.toString());
            C0702g.M(AlphaMeEntities.TAG, "\t\t\tusedTime = " + C0711p.t(this.usedTime));
            C0702g.M(AlphaMeEntities.TAG, "\t\t\tnotificationNumber = " + this.notificationNumber);
            C0702g.M(AlphaMeEntities.TAG, "\t\t}");
        }

        public int getNotificationNumber() {
            return this.notificationNumber;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public long getUsedTime() {
            return this.usedTime;
        }

        public void setNotificationNumber(int i5) {
            this.notificationNumber = i5;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setUsedTime(long j5) {
            this.usedTime = j5;
        }

        public String toString() {
            return "AppDailyUsage{notificationNumber=" + this.notificationNumber + ", packageName='" + this.packageName + "', usedTime=" + this.usedTime + '}';
        }
    }

    public static class AppUsage {
        private int notificationNumber;
        private String packageName;
        private long usedTime;

        public void dump() {
            C0702g.M(AlphaMeEntities.TAG, "\t\t\tAppUsage #" + hashCode() + "{");
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\tpackageName = ");
            sb.append(this.packageName);
            C0702g.M(AlphaMeEntities.TAG, sb.toString());
            C0702g.M(AlphaMeEntities.TAG, "\t\t\t\tusedTime = " + C0711p.t(this.usedTime));
            C0702g.M(AlphaMeEntities.TAG, "\t\t\t\tnotificationNumber = " + this.notificationNumber);
            C0702g.M(AlphaMeEntities.TAG, "\t\t\t}");
        }

        public int getNotificationNumber() {
            return this.notificationNumber;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public long getUsedTime() {
            return this.usedTime;
        }

        public void setNotificationNumber(int i5) {
            this.notificationNumber = i5;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setUsedTime(long j5) {
            this.usedTime = j5;
        }

        public String toString() {
            return "AppUsage{notificationNumber=" + this.notificationNumber + ", packageName='" + this.packageName + "', usedTime=" + this.usedTime + '}';
        }
    }

    public static class DU {
        DailyUsageSummary mDailyUsageSummary;
        List<TimeEvent> mTimeEvents;
    }

    public static class DailyUsageSummary {
        private List<AppDailyUsage> appDailyUsages;
        private long dailyUsedTime;
        private long date;
        private List<HourlyUsageSummary> hourlyUsageSummaries;
        private String id;
        private long maximumUsageTime;
        private int mode;
        private int notificationNumbers;
        private int screenOnTimes;
        private int useId;

        public void dump() {
            C0702g.K(AlphaMeEntities.TAG, 2);
            C0702g.M(AlphaMeEntities.TAG, "DailyUsageSummary #" + hashCode() + "{");
            StringBuilder sb = new StringBuilder();
            sb.append("\tdate = ");
            sb.append(C0711p.j(this.date));
            C0702g.M(AlphaMeEntities.TAG, sb.toString());
            C0702g.M(AlphaMeEntities.TAG, "\tmode = " + this.mode + " userId = " + this.useId);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\tdailyUsedTime = ");
            sb2.append(C0711p.t(this.dailyUsedTime));
            C0702g.M(AlphaMeEntities.TAG, sb2.toString());
            C0702g.M(AlphaMeEntities.TAG, "\tmaximumUsageTime = " + C0711p.t(this.maximumUsageTime));
            C0702g.M(AlphaMeEntities.TAG, "\tscreenOnTimes = " + this.screenOnTimes);
            C0702g.M(AlphaMeEntities.TAG, "\tnotificationNumbers = " + this.notificationNumbers);
            List<AppDailyUsage> list = this.appDailyUsages;
            if (list != null) {
                Iterator<AppDailyUsage> it = list.iterator();
                while (it.hasNext()) {
                    it.next().dump();
                }
            }
            if (this.hourlyUsageSummaries != null) {
                for (int i5 = 0; i5 < this.hourlyUsageSummaries.size(); i5++) {
                    this.hourlyUsageSummaries.get(i5).dump(i5);
                }
            }
            C0702g.M(AlphaMeEntities.TAG, "}");
        }

        public List<AppDailyUsage> getAppDailyUsages() {
            return this.appDailyUsages;
        }

        public long getDailyUsedTime() {
            return this.dailyUsedTime;
        }

        public long getDate() {
            return this.date;
        }

        public List<HourlyUsageSummary> getHourlyUsageSummaries() {
            return this.hourlyUsageSummaries;
        }

        public String getId() {
            return this.id;
        }

        public long getMaximumUsageTime() {
            return this.maximumUsageTime;
        }

        public int getMode() {
            return this.mode;
        }

        public int getNotificationNumbers() {
            return this.notificationNumbers;
        }

        public int getScreenOnTimes() {
            return this.screenOnTimes;
        }

        public int getUseId() {
            return this.useId;
        }

        public void setAppDailyUsages(List<AppDailyUsage> list) {
            this.appDailyUsages = list;
        }

        public void setDailyUsedTime(long j5) {
            this.dailyUsedTime = j5;
        }

        public void setDate(long j5) {
            this.date = j5;
        }

        public void setHourlyUsageSummaries(List<HourlyUsageSummary> list) {
            this.hourlyUsageSummaries = list;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setMaximumUsageTime(long j5) {
            this.maximumUsageTime = j5;
        }

        public void setMode(int i5) {
            this.mode = i5;
        }

        public void setNotificationNumbers(int i5) {
            this.notificationNumbers = i5;
        }

        public void setScreenOnTimes(int i5) {
            this.screenOnTimes = i5;
        }

        public void setUseId(int i5) {
            this.useId = i5;
        }

        public String toString() {
            return "DailyUsageSummary{appDailyUsages=" + this.appDailyUsages + ", dailyUsedTime=" + this.dailyUsedTime + ", date=" + this.date + ", hourlyUsageSummaries=" + this.hourlyUsageSummaries + ", id='" + this.id + "', maximumUsageTime=" + this.maximumUsageTime + ", mode=" + this.mode + ", notificationNumbers=" + this.notificationNumbers + ", screenOnTimes=" + this.screenOnTimes + ", useId=" + this.useId + '}';
        }
    }

    public static class HourlyUsageSummary {
        private List<AppUsage> appUsages;
        private long hourlyUsageTime;
        private int notificationNumber;
        private int screenOnTimes;

        public void dump(int i5) {
            C0702g.M(AlphaMeEntities.TAG, "\t\tHourlyUsageSummary #" + i5 + " {");
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\thourlyUsageTime = ");
            sb.append(C0711p.t(this.hourlyUsageTime));
            C0702g.M(AlphaMeEntities.TAG, sb.toString());
            C0702g.M(AlphaMeEntities.TAG, "\t\t\tnotificationNumber = " + this.notificationNumber);
            C0702g.M(AlphaMeEntities.TAG, "\t\t\tscreenOnTimes = " + this.screenOnTimes);
            List<AppUsage> list = this.appUsages;
            if (list != null) {
                Iterator<AppUsage> it = list.iterator();
                while (it.hasNext()) {
                    it.next().dump();
                }
            }
            C0702g.M(AlphaMeEntities.TAG, "\t\t}");
        }

        public List<AppUsage> getAppUsages() {
            return this.appUsages;
        }

        public long getHourlyUsageTime() {
            return this.hourlyUsageTime;
        }

        public int getNotificationNumber() {
            return this.notificationNumber;
        }

        public int getScreenOnTimes() {
            return this.screenOnTimes;
        }

        public void setAppUsages(List<AppUsage> list) {
            this.appUsages = list;
        }

        public void setHourlyUsageTime(long j5) {
            this.hourlyUsageTime = j5;
        }

        public void setNotificationNumber(int i5) {
            this.notificationNumber = i5;
        }

        public void setScreenOnTimes(int i5) {
            this.screenOnTimes = i5;
        }

        public String toString() {
            return "HourlyUsageSummary{appUsages=" + this.appUsages + ", hourlyUsageTime=" + this.hourlyUsageTime + ", notificationNumber=" + this.notificationNumber + ", screenOnTimes=" + this.screenOnTimes + '}';
        }
    }

    public static class Response<T> {
        private int code;
        private String message;
        private T result;

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public T getResult() {
            return this.result;
        }

        public void setCode(int i5) {
            this.code = i5;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setResult(T t5) {
            this.result = t5;
        }

        public String toString() {
            return "Response{code=" + this.code + ", message='" + this.message + "', result=" + this.result + '}';
        }
    }

    public static class Result {
        private List<DailyUsageSummary> dailyUsageSummaries;
        private long requestTime;
        private List<TimeEvent> timeEvents;

        public List<DailyUsageSummary> getDailyUsageSummaries() {
            return this.dailyUsageSummaries;
        }

        public long getRequestTime() {
            return this.requestTime;
        }

        public List<TimeEvent> getTimeEvents() {
            return this.timeEvents;
        }

        public void setDailyUsageSummaries(List<DailyUsageSummary> list) {
            this.dailyUsageSummaries = list;
        }

        public void setRequestTime(long j5) {
            this.requestTime = j5;
        }

        public void setTimeEvents(List<TimeEvent> list) {
            this.timeEvents = list;
        }

        public String toString() {
            return "Result{dailyUsageSummaries=" + this.dailyUsageSummaries + ", requestTime=" + this.requestTime + '}';
        }
    }

    public class TimeEvent {
        private long endTime;
        private String packageName;
        private long startTime;
        private int type;

        public TimeEvent() {
        }

        public long getEndTime() {
            return this.endTime;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public int getType() {
            return this.type;
        }

        public String toString() {
            return "TimeEvent{packageName='" + this.packageName + "', startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + '}';
        }
    }

    public class TimeEventData {
        private int code;
        private String message;
        private List<TimeEvent> result;

        public TimeEventData() {
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public List<TimeEvent> getResult() {
            return this.result;
        }

        public String toString() {
            return "TimeEventData{code=" + this.code + ", message='" + this.message + "', result=" + this.result + '}';
        }
    }
}
