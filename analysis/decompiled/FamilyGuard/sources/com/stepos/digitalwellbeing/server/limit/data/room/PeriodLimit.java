package com.stepos.digitalwellbeing.server.limit.data.room;

import java.util.Objects;

/* loaded from: classes.dex */
public class PeriodLimit implements Cloneable {
    private static final String TAG = "PeriodLimit";
    public static final int TYPE_CATEGORY = 1;
    public static final int TYPE_GLOBAL = 2;
    public static final int TYPE_PACKAGE = 0;
    private long adminId;
    private long categoryId;
    private boolean enable;
    private long id;
    private boolean isChild;
    private boolean notifyOnly;
    private String packageName;
    private int type;
    private long version;

    public PeriodLimit() {
        this.type = -1;
        this.packageName = null;
        this.categoryId = -1L;
        this.adminId = -1L;
        this.notifyOnly = false;
        this.isChild = false;
        this.enable = false;
        this.version = 1L;
    }

    protected Object clone() {
        try {
            PeriodLimit periodLimit = (PeriodLimit) super.clone();
            periodLimit.setType(this.type);
            periodLimit.setPackageName(this.packageName);
            periodLimit.setCategoryId(this.categoryId);
            periodLimit.setAdminId(this.adminId);
            periodLimit.setNotifyOnly(this.notifyOnly);
            periodLimit.setChild(this.isChild);
            periodLimit.setEnable(this.enable);
            periodLimit.setVersion(this.version);
            return periodLimit;
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PeriodLimit)) {
            return false;
        }
        PeriodLimit periodLimit = (PeriodLimit) obj;
        return getType() == periodLimit.getType() && getCategoryId() == periodLimit.getCategoryId() && getAdminId() == periodLimit.getAdminId() && isNotifyOnly() == periodLimit.isNotifyOnly() && isChild() == periodLimit.isChild() && isEnable() == periodLimit.isEnable() && getVersion() == periodLimit.getVersion() && Objects.equals(getPackageName(), periodLimit.getPackageName());
    }

    public long getAdminId() {
        return this.adminId;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public long getId() {
        return this.id;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getType() {
        return this.type;
    }

    public long getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(getType()), getPackageName(), Long.valueOf(getCategoryId()), Long.valueOf(getAdminId()), Boolean.valueOf(isNotifyOnly()), Boolean.valueOf(isChild()), Boolean.valueOf(isEnable()), Long.valueOf(getVersion()));
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

    public void setAdminId(long j5) {
        this.adminId = j5;
    }

    public void setCategoryId(long j5) {
        this.categoryId = j5;
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

    public void setNotifyOnly(boolean z5) {
        this.notifyOnly = z5;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    public void setVersion(long j5) {
        this.version = j5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PeriodLimit{id=");
        sb.append(this.id);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", packageName='");
        sb.append(this.packageName);
        sb.append('\'');
        sb.append(", categoryId=");
        long j5 = this.categoryId;
        sb.append(j5 < 0 ? "-1" : P1.a.b(W1.c.m((int) j5), new Object[0]));
        sb.append(", adminId=");
        sb.append(this.adminId);
        sb.append(", notifyOnly=");
        sb.append(this.notifyOnly);
        sb.append(", isChild=");
        sb.append(this.isChild);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(", version=");
        sb.append(this.version);
        sb.append('}');
        return sb.toString();
    }

    public PeriodLimit(int i5, String str, long j5, long j6, boolean z5, boolean z6, boolean z7, long j7) {
        this.type = i5;
        this.packageName = str;
        this.categoryId = j5;
        this.adminId = j6;
        this.notifyOnly = z5;
        this.isChild = z6;
        this.enable = z7;
        this.version = j7;
    }
}
