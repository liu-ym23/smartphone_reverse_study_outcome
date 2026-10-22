package com.stepos.digitalwellbeing.server.limit.data.room;

import android.content.Context;
import android.text.TextUtils;
import f2.C0711p;
import f2.C0718w;

/* loaded from: classes.dex */
public class PackageLimit implements Cloneable {
    private static final int MASK = 3;
    private static final int MASK_INSTALLED = 2;
    private static final int MASK_SUSPENDED = 1;
    private long adminId;
    private boolean enable;
    private long id;
    private int interval;
    private boolean isChild;
    private long lastHandleTime;
    private boolean notifyOnly;
    private long offDayLimit;
    private String packageName;
    private int state;
    private long workdayLimit;

    public PackageLimit() {
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
        if (!(obj instanceof PackageLimit)) {
            return false;
        }
        PackageLimit packageLimit = (PackageLimit) obj;
        return this.id == packageLimit.id && this.interval == packageLimit.interval && this.workdayLimit == packageLimit.workdayLimit && this.offDayLimit == packageLimit.offDayLimit && this.notifyOnly == packageLimit.notifyOnly && TextUtils.equals(this.packageName, packageLimit.packageName) && this.state == packageLimit.state && packageLimit.adminId == this.adminId && this.enable == packageLimit.enable;
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

    public String getPackageName() {
        return this.packageName;
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

    public void setPackageName(String str) {
        this.packageName = str;
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
        sb.append("PackageLimit{id=");
        sb.append(this.id);
        sb.append(", packageName='");
        sb.append(this.packageName);
        sb.append('\'');
        sb.append(", workdayLimit=");
        sb.append(this.workdayLimit < 0 ? "未设置" : C0711p.m(P1.a.a(), this.workdayLimit));
        sb.append(", offDayLimit=");
        sb.append(this.offDayLimit >= 0 ? C0711p.m(P1.a.a(), this.offDayLimit) : "未设置");
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", interval=");
        sb.append(this.interval);
        sb.append(", mLastHandleTime=");
        long j5 = this.lastHandleTime;
        sb.append(j5 < 0 ? "未处理" : C0711p.j(j5));
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

    public PackageLimit(int i5, String str, long j5, long j6, int i6, boolean z5, boolean z6, long j7, boolean z7) {
        this.packageName = str;
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
    public PackageLimit m4clone() {
        PackageLimit packageLimit = null;
        try {
            PackageLimit packageLimit2 = (PackageLimit) super.clone();
            try {
                packageLimit2.packageName = this.packageName;
                packageLimit2.workdayLimit = this.workdayLimit;
                packageLimit2.offDayLimit = this.offDayLimit;
                packageLimit2.state = this.state;
                packageLimit2.interval = this.interval;
                packageLimit2.notifyOnly = this.notifyOnly;
                packageLimit2.enable = this.enable;
                packageLimit2.adminId = this.adminId;
                packageLimit2.id = getId();
                packageLimit2.isChild = this.isChild;
                return packageLimit2;
            } catch (CloneNotSupportedException e6) {
                e = e6;
                packageLimit = packageLimit2;
                e.printStackTrace();
                return packageLimit;
            }
        } catch (CloneNotSupportedException e7) {
            e = e7;
        }
    }
}
