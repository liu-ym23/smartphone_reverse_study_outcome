package com.stepos.familyguard.db.entity;

import android.content.Context;
import com.stepos.digitalwellbeing.server.limit.data.room.PackageLimit;
import f2.C0718w;

/* loaded from: classes.dex */
public class PackageLimitCache {
    private static final int MASK = 3;
    private static final int MASK_INSTALLED = 2;
    private static final int MASK_SUSPENDED = 1;
    private boolean enable;
    private int interval;
    private long lastHandleTime;
    private boolean notifyOnly;
    private long offDayLimit;
    private long packageLimitId;
    private String packageName;
    private long relationId;
    private int state;
    private long version;
    private long workdayLimit;

    public PackageLimitCache() {
    }

    private boolean hasFlag(int i5) {
        return (this.state & i5) == i5;
    }

    private void setFlag(int i5, boolean z5) {
        if (z5) {
            this.state = i5 | this.state;
        } else {
            this.state = (~i5) & this.state;
        }
    }

    public long getCurrentLimit(Context context) {
        return C0718w.g().i() ? getWorkdayLimit() : getOffDayLimit();
    }

    public int getInterval() {
        return this.interval;
    }

    public long getLastHandleTime() {
        return this.lastHandleTime;
    }

    public long getOffDayLimit() {
        return this.offDayLimit;
    }

    public long getPackageLimitId() {
        return this.packageLimitId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public long getRelationId() {
        return this.relationId;
    }

    public int getState() {
        return this.state;
    }

    public long getVersion() {
        return this.version;
    }

    public long getWorkdayLimit() {
        return this.workdayLimit;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isInstalled() {
        return hasFlag(2);
    }

    public boolean isNotifyOnly() {
        return this.notifyOnly;
    }

    public boolean isSuspended() {
        return hasFlag(1);
    }

    public boolean isWatched() {
        return isEnable() && isInstalled() && !isSuspended();
    }

    public void setEnable(boolean z5) {
        this.enable = z5;
    }

    public void setInstalled(boolean z5) {
        setFlag(2, z5);
    }

    public void setInterval(int i5) {
        this.interval = i5;
    }

    public void setLastHandleTime(long j5) {
        this.lastHandleTime = j5;
    }

    public void setNotifyOnly(boolean z5) {
        this.notifyOnly = z5;
    }

    public void setOffDayLimit(long j5) {
        this.offDayLimit = j5;
    }

    public void setPackageLimitId(long j5) {
        this.packageLimitId = j5;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRelationId(long j5) {
        this.relationId = j5;
    }

    public void setState(int i5) {
        this.state = i5;
    }

    public void setSuspended(boolean z5) {
        setFlag(1, z5);
    }

    public void setVersion(long j5) {
        this.version = j5;
    }

    public void setWorkdayLimit(long j5) {
        this.workdayLimit = j5;
    }

    public PackageLimit toPackageLimit() {
        PackageLimit packageLimit = new PackageLimit(getInterval(), getPackageName(), getWorkdayLimit(), getOffDayLimit(), getState(), isEnable(), isNotifyOnly(), getRelationId(), false);
        packageLimit.setId(getPackageLimitId());
        return packageLimit;
    }

    public String toString() {
        return "PackageLimitCache{, packageLimitId=" + this.packageLimitId + ", packageName='" + this.packageName + "', workdayLimit=" + this.workdayLimit + ", offDayLimit=" + this.offDayLimit + ", notifyOnly=" + this.notifyOnly + ", state=" + this.state + ", interval=" + this.interval + ", lastHandleTime=" + this.lastHandleTime + ", relationId=" + this.relationId + '}';
    }

    public PackageLimitCache(int i5, String str, long j5, long j6, int i6, boolean z5, boolean z6, long j7, long j8, long j9) {
        this.packageName = str;
        this.workdayLimit = j5;
        this.offDayLimit = j6;
        this.state = i6;
        this.interval = i5;
        this.notifyOnly = z6;
        this.relationId = j8;
        this.packageLimitId = j7;
        this.enable = z5;
        this.version = j9;
    }
}
