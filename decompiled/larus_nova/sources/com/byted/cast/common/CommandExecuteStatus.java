package com.byted.cast.common;

/* JADX INFO: loaded from: classes39.dex */
public class CommandExecuteStatus {
    private String description;
    private String exception;
    private boolean isUpnpError;
    private String localAddrHost;
    private int playErrorCode;

    public String toString() {
        return "CommandExecuteStatus{playErrorCode='" + this.playErrorCode + "', description='" + this.description + "', exception='" + this.exception + "'}";
    }

    public CommandExecuteStatus() {
        this.isUpnpError = false;
        setDescription("");
        setException("");
    }

    public String getDescription() {
        return this.description;
    }

    public String getException() {
        return this.exception;
    }

    public String getLocalAddrHost() {
        return this.localAddrHost;
    }

    public int getPlayErrorCode() {
        return this.playErrorCode;
    }

    public boolean isUpnpError() {
        return this.isUpnpError;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setException(String r100) {
        this.exception = r100;
    }

    public void setLocalAddrHost(String r100) {
        this.localAddrHost = r100;
    }

    public void setPlayErrorCode(int r100) {
        this.playErrorCode = r100;
    }

    public void setUpnpError(boolean r100) {
        this.isUpnpError = r100;
    }

    public CommandExecuteStatus(int r100, String r101, String r102) {
        this.isUpnpError = false;
        setPlayErrorCode(r100);
        setDescription(r101);
        setException(r102);
    }
}
