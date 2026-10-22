package com.obric.olog;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public class OLogConfig {
    private Context mContext;
    private int mLevel;
    private String mLogDirPath;
    private int mLogFileExpDays;
    private int mMaxDirSize;
    private boolean mReport;
    private boolean mSaveToDisk;

    /* JADX INFO: renamed from: com.obric.olog.OLogConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Context mContext;
        private int mLevel;
        private String mLogDirPath;
        private int mLogFileExpDays;
        private int mMaxDirSize;
        private boolean mReport;
        private boolean mSaveToDisk;

        public Builder(Context r2) {
            this.mReport = false;
            this.mLevel = 3;
            this.mSaveToDisk = true;
            this.mLogFileExpDays = 14;
            if (r2 == null) goto L14;
            Context r0 = r2.getApplicationContext();
            if (r0 == null) goto L7;
            r2 = r0;
        L7:
            this.mContext = r2;
            if (isUserdebugVersion() == false) goto L10;
            int r3 = 31457280;
        L11:
            this.mMaxDirSize = r3;
            return;
        L10:
            r3 = 20971520;
            goto L11
        L14:
            throw new RuntimeException("context must not be null");
        }

        public Builder setReport(boolean r1) {
            this.mReport = r1;
            return this;
        }

        public Builder setLevel(int r1) {
            this.mLevel = r1;
            return this;
        }

        public Builder setSaveToDisk(boolean r1) {
            this.mSaveToDisk = r1;
            return this;
        }

        public Builder setLogDirPath(String r1) {
            this.mLogDirPath = r1;
            return this;
        }

        public Builder setMaxDirSize(int r1) {
            this.mMaxDirSize = r1;
            return this;
        }

        public Builder setLogFileExpDays(int r1) {
            this.mLogFileExpDays = r1;
            return this;
        }

        public OLogConfig build() {
            OLogConfig r0 = new OLogConfig(null);
            r0.setContext(this.mContext);
            r0.setReport(this.mReport);
            r0.setLevel(this.mLevel);
            r0.setSaveToDisk(this.mSaveToDisk);
            r0.setLogDirPath(this.mLogDirPath);
            r0.setMaxDirSize(this.mMaxDirSize);
            r0.setLogFileExpDays(this.mLogFileExpDays);
            return r0;
        }

        private boolean isAppInDebug(Context r1) {
            if ((r1.getApplicationInfo().flags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean isUserdebugVersion() {
            return Build.TYPE.equals("userdebug");
        }
    }

    /* synthetic */ OLogConfig(AnonymousClass1 r1) {
        this();
    }

    private OLogConfig() {
        this.mReport = false;
        this.mLevel = 3;
        this.mSaveToDisk = true;
        this.mLogFileExpDays = 14;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context r1) {
        this.mContext = r1;
    }

    public boolean isReport() {
        return this.mReport;
    }

    public void setReport(boolean r1) {
        this.mReport = r1;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public void setLevel(int r1) {
        this.mLevel = r1;
    }

    public boolean isSaveToDisk() {
        return this.mSaveToDisk;
    }

    public void setSaveToDisk(boolean r1) {
        this.mSaveToDisk = r1;
    }

    public String getLogDirPath() {
        return this.mLogDirPath;
    }

    public void setLogDirPath(String r1) {
        this.mLogDirPath = r1;
    }

    public int getMaxDirSize() {
        return this.mMaxDirSize;
    }

    public void setMaxDirSize(int r1) {
        this.mMaxDirSize = r1;
    }

    public int getLogFileExpDays() {
        return this.mLogFileExpDays;
    }

    public void setLogFileExpDays(int r1) {
        this.mLogFileExpDays = r1;
    }
}
