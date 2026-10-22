package com.stepos.familyguard.db.entity;

import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;

/* loaded from: classes.dex */
public class RawPeriodCache implements Cloneable {
    private static final String TAG = "RawPeriodCache";
    private long end;
    private long id;
    private long limitCacheId;
    private long rawPeriodId;
    private long relationId;
    private long remoteVersion;
    private long start;
    private int weekDayType;

    public RawPeriodCache() {
    }

    public long getEnd() {
        return this.end;
    }

    public long getId() {
        return this.id;
    }

    public long getLimitCacheId() {
        return this.limitCacheId;
    }

    public long getRawPeriodId() {
        return this.rawPeriodId;
    }

    public long getRelationId() {
        return this.relationId;
    }

    public long getRemoteVersion() {
        return this.remoteVersion;
    }

    public long getStart() {
        return this.start;
    }

    public int getWeekDayType() {
        return this.weekDayType;
    }

    public void setEnd(long j5) {
        this.end = j5;
    }

    public void setId(long j5) {
        this.id = j5;
    }

    public void setLimitCacheId(long j5) {
        this.limitCacheId = j5;
    }

    public void setRawPeriodId(long j5) {
        this.rawPeriodId = j5;
    }

    public void setRelationId(long j5) {
        this.relationId = j5;
    }

    public void setRemoteVersion(long j5) {
        this.remoteVersion = j5;
    }

    public void setStart(long j5) {
        this.start = j5;
    }

    public void setWeekDayType(int i5) {
        this.weekDayType = i5;
    }

    public String toString() {
        return "RawPeriodCache{ id=" + this.id + ", rawPeriodId=" + this.rawPeriodId + ", weekDayType=" + this.weekDayType + ", start=" + this.start + ", end=" + this.end + ", limitCacheId=" + this.limitCacheId + ", remoteVersion=" + this.remoteVersion + ", relationId=" + this.relationId + '}';
    }

    public RawPeriodCache(long j5, long j6, int i5, long j7, long j8, long j9, long j10, long j11) {
        this.id = j5;
        this.rawPeriodId = j6;
        this.weekDayType = i5;
        this.start = j7;
        this.end = j8;
        this.limitCacheId = j9;
        this.remoteVersion = j10;
        this.relationId = j11;
    }

    public RawPeriodCache(long j5, int i5, long j6, long j7, long j8, long j9, long j10) {
        this.rawPeriodId = j5;
        this.weekDayType = i5;
        this.start = j6;
        this.end = j7;
        this.limitCacheId = j8;
        this.remoteVersion = j9;
        this.relationId = j10;
    }

    public RawPeriodCache(int i5, long j5, long j6, long j7, long j8, long j9) {
        this.weekDayType = i5;
        this.start = j5;
        this.end = j6;
        this.limitCacheId = j7;
        this.remoteVersion = j8;
        this.relationId = j9;
    }

    public RawPeriodCache(RawPeriodInfo rawPeriodInfo, long j5) {
        this(rawPeriodInfo.getId(), -1L, rawPeriodInfo.getWeekDayType(), rawPeriodInfo.getStart(), rawPeriodInfo.getEnd(), rawPeriodInfo.getLimitId(), 1L, j5);
    }
}
