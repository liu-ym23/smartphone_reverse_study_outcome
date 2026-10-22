package com.monitor.cloudmessage.upload.entity;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class UploadInfo {
    protected int cloudMsgResponseCode;
    protected String commandId;
    protected String errorMsg;
    protected boolean isUploading;
    protected long lastUploadTime;
    protected long operateTime;
    protected HashMap<String, String> specificParams;

    public UploadInfo(long r3, boolean r5, String r6, HashMap<String, String> r7) {
        this.cloudMsgResponseCode = 2;
        this.errorMsg = "no error";
        this.operateTime = 0;
        this.specificParams = null;
        this.lastUploadTime = r3;
        this.isUploading = r5;
        this.commandId = r6;
        this.operateTime = System.currentTimeMillis();
        this.specificParams = r7;
    }

    public long getLastUploadTime() {
        return this.lastUploadTime;
    }

    public void setLastUploadTime(long r1) {
        this.lastUploadTime = r1;
    }

    public boolean isUploading() {
        return this.isUploading;
    }

    public void setUploading(boolean r1) {
        this.isUploading = r1;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String r1) {
        this.commandId = r1;
    }

    public int getCloudMsgResponseCode() {
        return this.cloudMsgResponseCode;
    }

    public void setCloudMsgResponseCode(int r1) {
        this.cloudMsgResponseCode = r1;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public long getOperateTime() {
        return this.operateTime;
    }

    public void setOperateTime(long r1) {
        this.operateTime = r1;
    }

    public HashMap<String, String> getSpecificParams() {
        return this.specificParams;
    }

    public void setSpecificParams(HashMap<String, String> r1) {
        this.specificParams = r1;
    }

    public String toString() {
        return "UploadInfo{lastUploadTime=" + this.lastUploadTime + ", isUploading=" + this.isUploading + ", commandId='" + this.commandId + "', cloudMsgResponseCode=" + this.cloudMsgResponseCode + ", errorMsg='" + this.errorMsg + "', operateTime=" + this.operateTime + ", specificParams=" + this.specificParams + '}';
    }
}
