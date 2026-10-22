package com.stepos.digitalwellbeing.server.limit.data.room;

import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import f2.C0711p;
import java.util.Objects;

/* loaded from: classes.dex */
public class RawPeriod implements Cloneable {
    public static final int EVERY_DAY = 0;
    public static final int OFF_DAY = 2;
    private static final String TAG = "RawPeriod";
    public static final int WORK_DAY = 1;
    private long end;
    private long id;
    private long limitId;
    private long start;
    private int weekDayType;

    public RawPeriod() {
        this.id = 0L;
        this.weekDayType = 1;
        this.start = 0L;
        this.end = 60000L;
        this.limitId = -1L;
    }

    public Object clone() {
        try {
            RawPeriod rawPeriod = (RawPeriod) super.clone();
            rawPeriod.setWeekDayType(this.weekDayType);
            rawPeriod.setStart(this.start);
            rawPeriod.setEnd(this.end);
            rawPeriod.setLimitId(this.limitId);
            return rawPeriod;
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RawPeriod)) {
            return false;
        }
        RawPeriod rawPeriod = (RawPeriod) obj;
        return this.weekDayType == rawPeriod.weekDayType && this.start == rawPeriod.start && this.end == rawPeriod.end && this.limitId == rawPeriod.limitId;
    }

    public long getEnd() {
        return this.end;
    }

    public long getId() {
        return this.id;
    }

    public long getLimitId() {
        return this.limitId;
    }

    public long getStart() {
        return this.start;
    }

    public int getWeekDayType() {
        return this.weekDayType;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.weekDayType), Long.valueOf(this.start), Long.valueOf(this.end), Long.valueOf(this.limitId));
    }

    public boolean overDay() {
        return this.end < this.start;
    }

    public void setEnd(long j5) {
        this.end = j5;
    }

    public void setId(long j5) {
        this.id = j5;
    }

    public void setLimitId(long j5) {
        this.limitId = j5;
    }

    public void setStart(long j5) {
        this.start = j5;
    }

    public void setWeekDayType(int i5) {
        this.weekDayType = i5;
    }

    public Z1.a toPeriod(int i5) {
        return new Z1.a(getStart(), getStart() > getEnd() ? getEnd() + 86400000 : getEnd(), i5);
    }

    public String toString() {
        return "RawPeriod{id=" + this.id + ", weekDayType=" + this.weekDayType + ", start=" + C0711p.F(this.start) + ", end=" + C0711p.F(this.end) + ", limitId=" + this.limitId + '}';
    }

    public RawPeriod(int i5, long j5, long j6, long j7) {
        this.id = 0L;
        this.weekDayType = i5;
        this.start = j5;
        this.end = j6;
        this.limitId = j7;
    }

    public RawPeriod(RawPeriodInfo rawPeriodInfo) {
        this.id = rawPeriodInfo.getId();
        this.weekDayType = rawPeriodInfo.getWeekDayType();
        this.start = rawPeriodInfo.getStart();
        this.end = rawPeriodInfo.getEnd();
        this.limitId = rawPeriodInfo.getLimitId();
    }
}
