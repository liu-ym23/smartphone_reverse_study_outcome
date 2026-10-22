package com.monitor.cloudmessage.upload.entity;

import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FileUploadInfo extends UploadInfo {
    protected IFileUploadCallback callback;
    protected String fileType;
    protected boolean forceUseState;
    protected boolean isCompress;
    protected boolean isDelSourceFile;
    protected boolean isMultiFileInOneZip;
    protected boolean isSkipUploadInternal;
    private List<String> mUploadFileAbsluteNames;

    public FileUploadInfo(String r7, long r8, boolean r10, String r11, IFileUploadCallback r12, HashMap<String, String> r13) {
        super(r8, r10, r11, r13);
        this.isSkipUploadInternal = true;
        this.isCompress = true;
        this.isMultiFileInOneZip = true;
        this.isDelSourceFile = false;
        this.forceUseState = false;
        this.fileType = r7;
        this.callback = r12;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String r1) {
        this.fileType = r1;
    }

    public IFileUploadCallback getCallback() {
        return this.callback;
    }

    public void setCallback(IFileUploadCallback r1) {
        this.callback = r1;
    }

    public boolean isSkipUploadInternal() {
        return this.isSkipUploadInternal;
    }

    public void setSkipUploadInternal(boolean r1) {
        this.isSkipUploadInternal = r1;
    }

    public boolean isCompress() {
        return this.isCompress;
    }

    public void setCompress(boolean r1) {
        this.isCompress = r1;
    }

    public boolean isMultiFileInOneZip() {
        return this.isMultiFileInOneZip;
    }

    public void setMultiFileInOneZip(boolean r1) {
        this.isMultiFileInOneZip = r1;
    }

    public boolean isDelSourceFile() {
        return this.isDelSourceFile;
    }

    public void setDelSourceFile(boolean r1) {
        this.isDelSourceFile = r1;
    }

    public List<String> getUploadFileAbsluteNames() {
        return this.mUploadFileAbsluteNames;
    }

    public void setUploadFileAbsluteNames(List<String> r1) {
        this.mUploadFileAbsluteNames = r1;
    }

    public boolean isForceUseState() {
        return this.forceUseState;
    }

    public void setForceUseState(boolean r1) {
        this.forceUseState = r1;
    }
}
