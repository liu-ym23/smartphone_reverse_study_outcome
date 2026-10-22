package com.android.server.locales;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSupportedLocalesChangedAtomRecord {
    final int mCallingUid;
    int mNumLocales;
    boolean mOverrideRemoved;
    boolean mSameAsPrevConfig;
    boolean mSameAsResConfig;
    int mStatus;
    int mTargetUid;

    AppSupportedLocalesChangedAtomRecord(int callingUid) {
        this.mTargetUid = -1;
        this.mNumLocales = -1;
        this.mOverrideRemoved = false;
        this.mSameAsResConfig = false;
        this.mSameAsPrevConfig = false;
        this.mStatus = 0;
        this.mCallingUid = callingUid;
    }

    void setTargetUid(int targetUid) {
        this.mTargetUid = targetUid;
    }

    void setNumLocales(int numLocales) {
        this.mNumLocales = numLocales;
    }

    void setOverrideRemoved(boolean overrideRemoved) {
        this.mOverrideRemoved = overrideRemoved;
    }

    void setSameAsResConfig(boolean sameAsResConfig) {
        this.mSameAsResConfig = sameAsResConfig;
    }

    void setSameAsPrevConfig(boolean sameAsPrevConfig) {
        this.mSameAsPrevConfig = sameAsPrevConfig;
    }

    void setStatus(int status) {
        this.mStatus = status;
    }
}
