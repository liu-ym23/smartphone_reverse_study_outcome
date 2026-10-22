package com.baidu.mapapi.http.wrapper;

import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public class FileWrapper {
    private byte[] file;
    private String mimeType;
    private String name;
    private File rawFile;

    public byte[] getFile() {
        return this.file;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public File getRawFile() {
        return this.rawFile;
    }

    public FileWrapper(File r100) {
        this.rawFile = r100;
    }

    public void setFile(byte[] r100) {
        this.file = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setRawFile(File r100) {
        this.rawFile = r100;
    }

    public FileWrapper(byte[] r100, String r101, String r102) {
        this.file = r100;
        this.name = r101;
        this.mimeType = r102;
    }
}
