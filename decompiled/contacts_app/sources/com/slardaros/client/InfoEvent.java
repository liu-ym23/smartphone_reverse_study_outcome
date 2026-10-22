package com.slardaros.client;

/* JADX INFO: loaded from: classes4.dex */
public class InfoEvent extends AgentEvent {
    public boolean isDelete;
    public String mFileType;
    public String mLogId;
    public String mLogPath;
    public String mLogType;

    public InfoEvent(String r1, String r2, boolean r3, String r4) {
        this.mLogType = r1;
        this.mLogPath = r2;
        this.isDelete = r3;
        this.mFileType = r4;
    }

    public InfoEvent(String r1, String r2, String r3, boolean r4, String r5) {
        this.mLogId = r1;
        this.mLogType = r2;
        this.mLogPath = r3;
        this.isDelete = r4;
        this.mFileType = r5;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public void setLogId(String r1) {
        this.mLogId = r1;
    }

    public String getLogType() {
        return this.mLogType;
    }

    public void setLogType(String r1) {
        this.mLogType = r1;
    }

    public String getLogPath() {
        return this.mLogPath;
    }

    public void setLogPath(String r1) {
        this.mLogPath = r1;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public void setDelete(boolean r1) {
        this.isDelete = r1;
    }

    public String getFileType() {
        return this.mFileType;
    }

    public void setFileType(String r1) {
        this.mFileType = r1;
    }

    public String toString() {
        return "InfoEvent{mLogType='" + this.mLogType + "', mLogPath='" + this.mLogPath + "', mFileType='" + this.mFileType + "', isDelete=" + this.isDelete + '}';
    }
}
