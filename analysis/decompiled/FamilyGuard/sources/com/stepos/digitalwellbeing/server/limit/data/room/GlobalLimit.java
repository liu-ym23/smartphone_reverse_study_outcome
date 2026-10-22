package com.stepos.digitalwellbeing.server.limit.data.room;

import android.content.Context;
import f2.C0711p;
import f2.C0718w;

/* loaded from: classes.dex */
public class GlobalLimit implements Cloneable {
    private static final int MASK = 1;
    private static final int MASK_SUSPENDED = 1;
    private long adminId;
    private boolean enable;
    private long id;
    private int interval;
    private boolean isChild;
    private long lastHandleTime;
    private boolean notifyOnly;
    private long offDayLimit;
    private int state;
    private long workdayLimit;

    public GlobalLimit() {
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

    public boolean equals(Object obj) {
        if (!(obj instanceof GlobalLimit)) {
            return false;
        }
        GlobalLimit globalLimit = (GlobalLimit) obj;
        return this.id == globalLimit.id && this.interval == globalLimit.interval && this.workdayLimit == globalLimit.workdayLimit && this.offDayLimit == globalLimit.offDayLimit && this.notifyOnly == globalLimit.notifyOnly && this.state == globalLimit.state && this.adminId == globalLimit.adminId && this.enable == globalLimit.enable;
    }

    public long getAdminId() {
        return this.adminId;
    }

    public long getCurrentLimit(Context context) {
        return C0718w.g().i() ? getWorkdayLimit() : getOffDayLimit();
    }

    public long getId() {
        return this.id;
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

    public int getState() {
        return this.state;
    }

    public long getWorkdayLimit() {
        return this.workdayLimit;
    }

    public boolean isChild() {
        return this.isChild;
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

    public void setAdminId(long j5) {
        this.adminId = j5;
    }

    public void setChild(boolean z5) {
        this.isChild = z5;
    }

    public void setEnable(boolean z5) {
        this.enable = z5;
    }

    public void setId(long j5) {
        this.id = j5;
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

    public void setState(int i5) {
        this.state = i5;
    }

    public void setSuspended(boolean z5) {
        setFlag(1, z5);
    }

    public void setWorkdayLimit(long j5) {
        this.workdayLimit = j5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GlobalLimit{id=");
        sb.append(this.id);
        sb.append(", workdayLimit=");
        sb.append(this.workdayLimit < 0 ? "未设置" : C0711p.m(P1.a.a(), this.workdayLimit));
        sb.append(", offDayLimit=");
        sb.append(this.offDayLimit < 0 ? "未设置" : C0711p.m(P1.a.a(), this.offDayLimit));
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", interval=");
        sb.append(this.interval);
        sb.append(", mLastHandleTime=");
        long j5 = this.lastHandleTime;
        sb.append(j5 >= 0 ? C0711p.j(j5) : "未设置");
        sb.append(", notifyOnly=");
        sb.append(this.notifyOnly);
        sb.append(", enable = ");
        sb.append(this.enable);
        sb.append(", admin = ");
        sb.append(this.adminId);
        sb.append(", isChild = ");
        sb.append(this.isChild);
        sb.append('}');
        return sb.toString();
    }

    public GlobalLimit(int i5, long j5, long j6, int i6, boolean z5, boolean z6, long j7, boolean z7) {
        this.workdayLimit = j5;
        this.offDayLimit = j6;
        this.state = i6;
        this.interval = i5;
        this.notifyOnly = z6;
        this.enable = z5;
        this.adminId = j7;
        this.isChild = z7;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GlobalLimit m3clone() {
        GlobalLimit globalLimit = null;
        try {
            GlobalLimit globalLimit2 = (GlobalLimit) super.clone();
            try {
                globalLimit2.interval = this.interval;
                globalLimit2.workdayLimit = this.workdayLimit;
                globalLimit2.offDayLimit = this.offDayLimit;
                globalLimit2.state = this.state;
                globalLimit2.enable = this.enable;
                globalLimit2.notifyOnly = this.notifyOnly;
                globalLimit2.adminId = this.adminId;
                globalLimit2.id = getId();
                globalLimit2.isChild = this.isChild;
                return globalLimit2;
            } catch (CloneNotSupportedException e6) {
                e = e6;
                globalLimit = globalLimit2;
                e.printStackTrace();
                return globalLimit;
            }
        } catch (CloneNotSupportedException e7) {
            e = e7;
        }
    }
}
