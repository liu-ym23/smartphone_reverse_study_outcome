package com.bumptech.glide.load.a.a;

import java.io.File;

/* JADX INFO: compiled from: FileService.java */
/* JADX INFO: loaded from: classes.dex */
class a {
    a() {
    }

    public boolean a(File r1) {
        return r1.exists();
    }

    public long b(File r1) {
        return r1.length();
    }

    public File a(String r1) {
        return new File(r1);
    }
}
