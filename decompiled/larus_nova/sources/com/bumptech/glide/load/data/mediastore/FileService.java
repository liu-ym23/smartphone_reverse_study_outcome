package com.bumptech.glide.load.data.mediastore;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
class FileService {
    public FileService() {
    }

    public boolean exists(File r100) {
        return r100.exists();
    }

    public File get(String r100) {
        return new PolarisFileWrapper(r100);
    }

    public long length(File r100) {
        return r100.length();
    }
}
