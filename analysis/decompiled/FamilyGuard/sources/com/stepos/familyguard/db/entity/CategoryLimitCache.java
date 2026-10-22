package com.stepos.familyguard.db.entity;

import android.content.Context;
import com.stepos.digitalwellbeing.server.limit.data.room.CategoryLimit;
import f2.C0718w;

/* loaded from: classes.dex */
public class CategoryLimitCache implements Cloneable {
    private static final int MASK = 1;
    private static final int MASK_SUSPENDED = 1;
    private int categoryId;
    private long categoryLimitId;
    private boolean enable;
    private int interval;
    private long lastHandleTime;
    private boolean notifyOnly;
    private long offDayLimit;
    private long relationId;
    private int state;
    private long version;
    private long workdayLimit;

    public CategoryLimitCache() {
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

    public int getCategoryId() {
        return this.categoryId;
    }

    public long getCategoryLimitId() {
        return this.categoryLimitId;
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

    public boolean isNotifyOnly() {
        return this.notifyOnly;
    }

    public boolean isSuspended() {
        return hasFlag(1);
    }

    public boolean isWatched() {
        return isEnable() && !isSuspended();
    }

    public void setCategoryId(int i5) {
        this.categoryId = i5;
    }

    public void setCategoryLimitId(long j5) {
        this.categoryLimitId = j5;
    }

    public void setEnable(boolean z5) {
        this.enable = z5;
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

    public CategoryLimit toCategoryLimit() {
        CategoryLimit categoryLimit = new CategoryLimit(getInterval(), getCategoryId(), getWorkdayLimit(), getOffDayLimit(), getState(), isEnable(), isNotifyOnly(), getRelationId(), false);
        categoryLimit.setId(getCategoryLimitId());
        return categoryLimit;
    }

    public String toString() {
        return "CategoryLimitCache{, categoryId=" + this.categoryId + ", workdayLimit=" + this.workdayLimit + ", offDayLimit=" + this.offDayLimit + ", notifyOnly=" + this.notifyOnly + ", state=" + this.state + ", interval=" + this.interval + ", lastHandleTime=" + this.lastHandleTime + ", categoryLimitId=" + this.categoryLimitId + ", relationId=" + this.relationId + ", enable = " + this.enable + '}';
    }

    public CategoryLimitCache(int i5, int i6, long j5, long j6, boolean z5, boolean z6, int i7, long j7, long j8, long j9, long j10) {
        this.interval = i5;
        this.categoryId = i6;
        this.workdayLimit = j5;
        this.offDayLimit = j6;
        this.enable = z5;
        this.notifyOnly = z6;
        this.state = i7;
        this.lastHandleTime = j7;
        this.categoryLimitId = j8;
        this.relationId = j9;
        this.version = j10;
    }
}
