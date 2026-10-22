package com.amap.api.mapcore.util;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes28.dex */
class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RandomAccessFile f27985a;

    public t1(String r100, long r101) throws IOException {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L5;
    L13:
        RandomAccessFile r103 = new RandomAccessFile(r100, "rw");
        this.f27985a = r103;
        r103.seek(r101);
        return;
    L5:
        if (r102.getParentFile().exists() == true) goto L15;
        r102.getParentFile().mkdirs();
    L15:
    L11:
        e = move-exception;
        t6.a(e, "FileAccessI", "create");
        e.printStackTrace();
        goto L13
    L8:
        if (r102.exists() == true) goto L13;
        r102.createNewFile();     // Catch: IOException -> L11
        goto L13
    }
}
