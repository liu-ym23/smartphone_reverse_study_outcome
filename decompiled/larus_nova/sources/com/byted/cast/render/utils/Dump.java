package com.byted.cast.render.utils;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes43.dex */
public class Dump {
    private File dumpFile;
    private boolean isReady;

    public Dump() {
        this.isReady = false;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public void writeData(byte[] r100) {
        if (this.isReady == true) goto L12;
        return;
    L12:
        BufferedOutputStream r101 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(this.dumpFile, true));     // Catch: OutOfMemoryError -> L7 IOException -> L9
        r101.write(r100);     // Catch: OutOfMemoryError -> L7 IOException -> L9
        r101.flush();     // Catch: OutOfMemoryError -> L7 IOException -> L9
        r101.close();     // Catch: OutOfMemoryError -> L7 IOException -> L9
    L15:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean setFilePath(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L5;
    L8:
        this.dumpFile = new PolarisFileWrapper(r100 + File.separator + r101);
        this.isReady = true;
        return true;
    L5:
        if (r102.mkdir() == true) goto L8;
        return false;
    }
}
