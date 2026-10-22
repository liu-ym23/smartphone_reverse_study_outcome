package com.bytedanceos.common.core.account.cloudsync.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class CloudSyncFile extends File {
    private static final long serialVersionUID = 1;
    private long downloadLength;
    private String fileName;
    private String uploadFilePath;
    private long uploadedLength;

    public CloudSyncFile(String r10) {
        super(r10);
        this.uploadedLength = 0;
        this.downloadLength = 0;
        this.uploadFilePath = "";
        this.fileName = "";
    }

    public long getDownloadedLength() {
        return this.downloadLength;
    }

    public long getFileLength() {
        return length();
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public long getUploadedLength() {
        return this.uploadedLength;
    }

    public void setDownloadedLength(long r10) {
        this.downloadLength = r10;
    }

    public void setFileName(String r10) {
        this.fileName = r10;
    }

    public void setUploadFilePath(String r10) {
        this.uploadFilePath = r10;
    }

    public void setUploadedLength(long r10) {
        this.uploadedLength = r10;
    }

    public byte[] toByteArray() {
        FileInputStream r10 = new FileInputStream(this);     // Catch: IOException -> L6
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(4096);     // Catch: IOException -> L6
        byte[] r12 = new byte[4096];     // Catch: IOException -> L6
    L3:
        int r13 = r10.read(r12);     // Catch: IOException -> L6
        if (r13 == (-1)) goto L8;
        r11.write(r12, 0, r13);     // Catch: IOException -> L6
        goto L3
    L8:
        r10.close();     // Catch: IOException -> L6
        r11.close();     // Catch: IOException -> L6
        return r11.toByteArray();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public CloudSyncFile(File r10, String r11) {
        super(r10, r11);
        this.uploadedLength = 0;
        this.downloadLength = 0;
        this.uploadFilePath = "";
        this.fileName = "";
    }
}
