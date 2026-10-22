package com.stepos.familyguard.db.entity;

import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class PeriodLimitCache implements Cloneable {
    private static final String TAG = "PeriodLimitCache";
    private long categoryId;
    private boolean enable;
    private long id;
    private boolean notifyOnly;
    private String packageName;
    private long periodLimitId;
    private long relationId;
    private long remoteVersion;
    private int type;

    public PeriodLimitCache() {
        this.id = 0L;
        this.periodLimitId = -1L;
        this.type = 0;
        this.packageName = BuildConfig.FLAVOR;
        this.categoryId = -1L;
        this.relationId = -1L;
        this.notifyOnly = false;
        this.enable = false;
        this.remoteVersion = -1L;
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

    public long getPeriodLimitId() {
        return this.periodLimitId;
    }

    public long getRelationId() {
        return this.relationId;
    }

    public long getRemoteVersion() {
        return this.remoteVersion;
    }

    public int getType() {
        return this.type;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isNotifyOnly() {
        return this.notifyOnly;
    }

    public void setCategoryId(long j5) {
        this.categoryId = j5;
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

    public void setPeriodLimitId(long j5) {
        this.periodLimitId = j5;
    }

    public void setRelationId(long j5) {
        this.relationId = j5;
    }

    public void setRemoteVersion(long j5) {
        this.remoteVersion = j5;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    public String toString() {
        return "PeriodLimitCache{  id=" + this.id + ", periodLimitId=" + this.periodLimitId + ", type=" + this.type + ", packageName='" + this.packageName + "', categoryId=" + this.categoryId + ", notifyOnly=" + this.notifyOnly + ", enable=" + this.enable + ", remoteVersion=" + this.remoteVersion + ", relationId=" + this.relationId + '}';
    }

    public PeriodLimitCache(long j5, long j6, int i5, String str, long j7, boolean z5, boolean z6, long j8, long j9) {
        this.id = j5;
        this.periodLimitId = j6;
        this.type = i5;
        this.packageName = str;
        this.categoryId = j7;
        this.relationId = j9;
        this.notifyOnly = z5;
        this.enable = z6;
        this.remoteVersion = j8;
    }

    public PeriodLimitCache(int i5, String str, long j5, boolean z5, boolean z6, long j6, long j7) {
        this.id = 0L;
        this.periodLimitId = -1L;
        this.type = i5;
        this.packageName = str;
        this.categoryId = j5;
        this.notifyOnly = z5;
        this.enable = z6;
        this.remoteVersion = j6;
        this.relationId = j7;
    }
}
