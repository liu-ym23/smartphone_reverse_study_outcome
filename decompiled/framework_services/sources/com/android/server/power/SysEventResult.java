package com.android.server.power;

import android.os.SystemClock;
import com.android.server.am.HostingRecord;

/* JADX INFO: loaded from: classes3.dex */
public class SysEventResult {
    public Type entryType;
    public String eventName;
    public String pkgName;
    public Long startTime;
    public int uid;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type camera = null;
        public static final Type gps = null;
        public static final Type job = null;
        public static final Type sensor = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{gps, camera, job, sensor};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String name) {
            return (Type) Enum.valueOf(Type.class, name);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            gps = new Type("gps", 0);
            camera = new Type("camera", 1);
            job = new Type(HostingRecord.TRIGGER_TYPE_JOB, 2);
            sensor = new Type("sensor", 3);
            $VALUES = $values();
        }
    }

    SysEventResult(int uid, String pkgName, String eventName, Type entryType) {
        this.uid = uid;
        this.pkgName = pkgName;
        this.eventName = eventName;
        this.startTime = Long.valueOf(SystemClock.elapsedRealtime());
        this.entryType = entryType;
    }

    public long getActiveDuration() {
        return SystemClock.elapsedRealtime() - this.startTime.longValue();
    }

    public void resetTime() {
        this.startTime = Long.valueOf(SystemClock.elapsedRealtime());
    }
}
