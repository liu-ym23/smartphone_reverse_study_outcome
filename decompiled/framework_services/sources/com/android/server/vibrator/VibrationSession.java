package com.android.server.vibrator;

import android.os.IBinder;
import android.os.VibrationAttributes;
import android.util.IndentingPrintWriter;
import android.util.proto.ProtoOutputStream;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
interface VibrationSession {
    public static final AtomicInteger sNextSessionId = null;

    public static final class CallerInfo {
        public final VibrationAttributes attrs;
        public final int deviceId;
        public final String opPkg;
        public final String reason;
        public final int uid;

        CallerInfo(VibrationAttributes attrs, int uid, int deviceId, String opPkg, String reason) {
            attrs.getClass();
            this.attrs = attrs;
            this.uid = uid;
            this.deviceId = deviceId;
            this.opPkg = opPkg;
            this.reason = reason;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof CallerInfo) == true) goto L8;
            return false;
        L8:
            CallerInfo that = (CallerInfo) o;
            if (Objects.equals(this.attrs, that.attrs) == false) goto L20;
            if (this.uid != that.uid) goto L20;
            if (this.deviceId != that.deviceId) goto L20;
            if (Objects.equals(this.opPkg, that.opPkg) == false) goto L20;
            if (Objects.equals(this.reason, that.reason) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.attrs, Integer.valueOf(this.uid), Integer.valueOf(this.deviceId), this.opPkg, this.reason});
        }

        public String toString() {
            return "CallerInfo{ uid=" + this.uid + ", opPkg=" + this.opPkg + ", deviceId=" + this.deviceId + ", attrs=" + this.attrs + ", reason=" + this.reason + '}';
        }
    }

    public interface DebugInfo {
        public static final DateTimeFormatter DEBUG_DATE_TIME_FORMATTER = null;
        public static final DateTimeFormatter DEBUG_TIME_FORMATTER = null;

        void dump(IndentingPrintWriter r1);

        void dump(ProtoOutputStream r1, long r2);

        void dumpCompact(IndentingPrintWriter r1);

        CallerInfo getCallerInfo();

        long getCreateUptimeMillis();

        Object getDumpAggregationKey();

        Status getStatus();

        void logMetrics(VibratorFrameworkStatsLogger r1);

        static {
            DEBUG_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
            DEBUG_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss.SSS");
        }

        static String formatTime(long timeInMillis, boolean includeDate) {
            if (includeDate == false) goto L4;
            DateTimeFormatter r0 = DEBUG_DATE_TIME_FORMATTER;
        L6:
            return r0.withZone(ZoneId.systemDefault()).format(Instant.ofEpochMilli(timeInMillis));
        L4:
            r0 = DEBUG_TIME_FORMATTER;
            goto L6
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status CANCELLED_BINDER_DIED = null;
        public static final Status CANCELLED_BY_APP_OPS = null;
        public static final Status CANCELLED_BY_FOREGROUND_USER = null;
        public static final Status CANCELLED_BY_SCREEN_OFF = null;
        public static final Status CANCELLED_BY_SETTINGS_UPDATE = null;
        public static final Status CANCELLED_BY_UNKNOWN_REASON = null;
        public static final Status CANCELLED_BY_USER = null;
        public static final Status CANCELLED_SUPERSEDED = null;
        public static final Status FINISHED = null;
        public static final Status FINISHED_UNEXPECTED = null;
        public static final Status FORWARDED_TO_INPUT_DEVICES = null;
        public static final Status IGNORED_APP_OPS = null;
        public static final Status IGNORED_BACKGROUND = null;
        public static final Status IGNORED_ERROR_APP_OPS = null;
        public static final Status IGNORED_ERROR_CANCELLING = null;
        public static final Status IGNORED_ERROR_SCHEDULING = null;
        public static final Status IGNORED_ERROR_TOKEN = null;
        public static final Status IGNORED_FOR_EXTERNAL = null;
        public static final Status IGNORED_FOR_HIGHER_IMPORTANCE = null;
        public static final Status IGNORED_FOR_ONGOING = null;
        public static final Status IGNORED_FOR_POWER = null;
        public static final Status IGNORED_FOR_RINGER_MODE = null;
        public static final Status IGNORED_FOR_SETTINGS = null;
        public static final Status IGNORED_FROM_VIRTUAL_DEVICE = null;
        public static final Status IGNORED_MISSING_PERMISSION = null;
        public static final Status IGNORED_ON_WIRELESS_CHARGER = null;
        public static final Status IGNORED_SUPERSEDED = null;
        public static final Status IGNORED_UNSUPPORTED = null;
        public static final Status RUNNING = null;
        public static final Status UNKNOWN = null;
        private final int mProtoEnumValue;

        private static /* synthetic */ Status[] $values() {
            return new Status[]{UNKNOWN, RUNNING, FINISHED, FINISHED_UNEXPECTED, FORWARDED_TO_INPUT_DEVICES, CANCELLED_BINDER_DIED, CANCELLED_BY_SCREEN_OFF, CANCELLED_BY_SETTINGS_UPDATE, CANCELLED_BY_USER, CANCELLED_BY_FOREGROUND_USER, CANCELLED_BY_UNKNOWN_REASON, CANCELLED_SUPERSEDED, CANCELLED_BY_APP_OPS, IGNORED_ERROR_APP_OPS, IGNORED_ERROR_CANCELLING, IGNORED_ERROR_SCHEDULING, IGNORED_ERROR_TOKEN, IGNORED_APP_OPS, IGNORED_BACKGROUND, IGNORED_MISSING_PERMISSION, IGNORED_UNSUPPORTED, IGNORED_FOR_EXTERNAL, IGNORED_FOR_HIGHER_IMPORTANCE, IGNORED_FOR_ONGOING, IGNORED_FOR_POWER, IGNORED_FOR_RINGER_MODE, IGNORED_FOR_SETTINGS, IGNORED_SUPERSEDED, IGNORED_FROM_VIRTUAL_DEVICE, IGNORED_ON_WIRELESS_CHARGER};
        }

        public static Status valueOf(String name) {
            return (Status) Enum.valueOf(Status.class, name);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            UNKNOWN = new Status("UNKNOWN", 0, 0);
            RUNNING = new Status("RUNNING", 1, 1);
            FINISHED = new Status("FINISHED", 2, 2);
            FINISHED_UNEXPECTED = new Status("FINISHED_UNEXPECTED", 3, 3);
            FORWARDED_TO_INPUT_DEVICES = new Status("FORWARDED_TO_INPUT_DEVICES", 4, 4);
            CANCELLED_BINDER_DIED = new Status("CANCELLED_BINDER_DIED", 5, 5);
            CANCELLED_BY_SCREEN_OFF = new Status("CANCELLED_BY_SCREEN_OFF", 6, 6);
            CANCELLED_BY_SETTINGS_UPDATE = new Status("CANCELLED_BY_SETTINGS_UPDATE", 7, 7);
            CANCELLED_BY_USER = new Status("CANCELLED_BY_USER", 8, 8);
            CANCELLED_BY_FOREGROUND_USER = new Status("CANCELLED_BY_FOREGROUND_USER", 9, 30);
            CANCELLED_BY_UNKNOWN_REASON = new Status("CANCELLED_BY_UNKNOWN_REASON", 10, 9);
            CANCELLED_SUPERSEDED = new Status("CANCELLED_SUPERSEDED", 11, 10);
            CANCELLED_BY_APP_OPS = new Status("CANCELLED_BY_APP_OPS", 12, 29);
            IGNORED_ERROR_APP_OPS = new Status("IGNORED_ERROR_APP_OPS", 13, 11);
            IGNORED_ERROR_CANCELLING = new Status("IGNORED_ERROR_CANCELLING", 14, 12);
            IGNORED_ERROR_SCHEDULING = new Status("IGNORED_ERROR_SCHEDULING", 15, 13);
            IGNORED_ERROR_TOKEN = new Status("IGNORED_ERROR_TOKEN", 16, 14);
            IGNORED_APP_OPS = new Status("IGNORED_APP_OPS", 17, 15);
            IGNORED_BACKGROUND = new Status("IGNORED_BACKGROUND", 18, 16);
            IGNORED_MISSING_PERMISSION = new Status("IGNORED_MISSING_PERMISSION", 19, 28);
            IGNORED_UNSUPPORTED = new Status("IGNORED_UNSUPPORTED", 20, 18);
            IGNORED_FOR_EXTERNAL = new Status("IGNORED_FOR_EXTERNAL", 21, 19);
            IGNORED_FOR_HIGHER_IMPORTANCE = new Status("IGNORED_FOR_HIGHER_IMPORTANCE", 22, 20);
            IGNORED_FOR_ONGOING = new Status("IGNORED_FOR_ONGOING", 23, 21);
            IGNORED_FOR_POWER = new Status("IGNORED_FOR_POWER", 24, 22);
            IGNORED_FOR_RINGER_MODE = new Status("IGNORED_FOR_RINGER_MODE", 25, 23);
            IGNORED_FOR_SETTINGS = new Status("IGNORED_FOR_SETTINGS", 26, 24);
            IGNORED_SUPERSEDED = new Status("IGNORED_SUPERSEDED", 27, 25);
            IGNORED_FROM_VIRTUAL_DEVICE = new Status("IGNORED_FROM_VIRTUAL_DEVICE", 28, 26);
            IGNORED_ON_WIRELESS_CHARGER = new Status("IGNORED_ON_WIRELESS_CHARGER", 29, 27);
            $VALUES = $values();
        }

        private Status(String r1, int r2, int value) {
            super(r1, r2);
            this.mProtoEnumValue = value;
        }

        public int getProtoEnumValue() {
            return this.mProtoEnumValue;
        }
    }

    CallerInfo getCallerInfo();

    IBinder getCallerToken();

    long getCreateUptimeMillis();

    DebugInfo getDebugInfo();

    long getSessionId();

    boolean isRepeating();

    boolean linkToDeath();

    void notifySessionCallback();

    void notifySyncedVibratorsCallback(long r1);

    void notifyVibratorCallback(int r1, long r2, long r4);

    void requestEnd(Status r1, CallerInfo r2, boolean r3);

    void unlinkToDeath();

    boolean wasEndRequested();

    static {
        sNextSessionId = new AtomicInteger(1);
    }

    static long nextSessionId() {
        return sNextSessionId.getAndIncrement();
    }

    default void requestEnd(Status status) {
        requestEnd(status, null, false);
    }
}
