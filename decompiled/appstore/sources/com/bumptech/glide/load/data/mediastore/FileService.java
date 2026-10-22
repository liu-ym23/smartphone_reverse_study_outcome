package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class FileService {
    public FileService() {
    }

    public boolean exists(File r10) {
        return r10.exists();
    }

    public File get(String r10) {
        return new File(r10);
    }

    public long length(File r10) {
        return r10.length();
    }
}
