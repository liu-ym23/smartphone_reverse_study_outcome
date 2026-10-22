package com.stepos.digitalwellbeing.server.limit.data.room;

import f2.C0711p;
import java.util.Objects;

/* loaded from: classes.dex */
public class RipePeriod implements Cloneable {
    private static final String TAG = "RipePeriod";
    public static final int TYPE_LOCK = 0;
    public static final int TYPE_NOTIFY = 2;
    public static final int TYPE_NOTIFY_ONLY = 3;
    public static final int TYPE_UNLOCK = 1;
    private long adminId;
    private long id;
    private long limitCategoryId;
    private long limitId;
    private String limitPackageName;
    private int limitType;
    private int mergedWeekDayType;
    private long time;
    private int type;
    private long version;

    public RipePeriod() {
        this.time = -1L;
        this.limitId = -1L;
        this.limitType = -1;
        this.adminId = -1L;
        this.limitPackageName = null;
        this.limitCategoryId = -1L;
        this.version = -1L;
    }

    protected Object clone() {
        try {
            RipePeriod ripePeriod = (RipePeriod) super.clone();
            ripePeriod.setTime(this.time);
            ripePeriod.setLimitId(this.limitId);
            ripePeriod.setLimitType(this.limitType);
            ripePeriod.setAdminId(this.adminId);
            ripePeriod.setLimitPackageName(this.limitPackageName);
            ripePeriod.setLimitCategoryId(this.limitCategoryId);
            ripePeriod.setVersion(this.version);
            ripePeriod.setType(this.type);
            ripePeriod.setMergedWeekDayType(this.mergedWeekDayType);
            return ripePeriod;
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RipePeriod)) {
            return false;
        }
        RipePeriod ripePeriod = (RipePeriod) obj;
        return this.id == ripePeriod.id && this.time == ripePeriod.time && this.type == ripePeriod.type && this.limitId == ripePeriod.limitId && this.limitType == ripePeriod.limitType && this.adminId == ripePeriod.adminId && this.limitCategoryId == ripePeriod.limitCategoryId && this.version == ripePeriod.version && this.mergedWeekDayType == ripePeriod.mergedWeekDayType && Objects.equals(this.limitPackageName, ripePeriod.limitPackageName);
    }

    public long getAdminId() {
        return this.adminId;
    }

    public long getId() {
        return this.id;
    }

    public long getLimitCategoryId() {
        return this.limitCategoryId;
    }

    public long getLimitId() {
        return this.limitId;
    }

    public String getLimitPackageName() {
        return this.limitPackageName;
    }

    public int getLimitType() {
        return this.limitType;
    }

    public int getMergedWeekDayType() {
        return this.mergedWeekDayType;
    }

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public long getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id), Long.valueOf(this.time), Integer.valueOf(this.type), Long.valueOf(this.limitId), Integer.valueOf(this.limitType), Long.valueOf(this.adminId), this.limitPackageName, Long.valueOf(this.limitCategoryId), Long.valueOf(this.version), Integer.valueOf(this.mergedWeekDayType));
    }

    public void setAdminId(long j5) {
        this.adminId = j5;
    }

    public void setId(long j5) {
        this.id = j5;
    }

    public void setLimitCategoryId(long j5) {
        this.limitCategoryId = j5;
    }

    public void setLimitId(long j5) {
        this.limitId = j5;
    }

    public void setLimitPackageName(String str) {
        this.limitPackageName = str;
    }

    public void setLimitType(int i5) {
        this.limitType = i5;
    }

    public void setMergedWeekDayType(int i5) {
        this.mergedWeekDayType = i5;
    }

    public void setTime(long j5) {
        this.time = j5;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    public void setVersion(long j5) {
        this.version = j5;
    }

    public String toString() {
        return "RipePeriod{id=" + this.id + ", time=" + C0711p.F(this.time) + ", limitId=" + this.limitId + ", limitType=" + this.limitType + ", adminId=" + this.adminId + ", limitPackageName='" + this.limitPackageName + "', limitCategoryId=" + this.limitCategoryId + ", version=" + this.version + ", type=" + this.type + ", weekDayType=" + Z1.a.e(this.mergedWeekDayType) + '}';
    }

    public RipePeriod(long j5, long j6, int i5, long j7, String str, long j8, long j9, int i6, int i7) {
        this.time = j5;
        this.limitId = j6;
        this.limitType = i5;
        this.adminId = j7;
        this.limitPackageName = str;
        this.limitCategoryId = j8;
        this.version = j9;
        this.type = i6;
        this.mergedWeekDayType = i7;
    }
}
