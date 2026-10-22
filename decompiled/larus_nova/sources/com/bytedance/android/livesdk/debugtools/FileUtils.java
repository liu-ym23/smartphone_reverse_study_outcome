package com.bytedance.android.livesdk.debugtools;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes8.dex */
public final class FileUtils {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilePatchStatus {
    }

    public static void a() {
        File r100 = s1.getContext().getExternalFilesDir("/live/performance/enterRoom/");
        if (r100 == null) goto L5;
        String r101 = r100.getAbsolutePath();
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L9;
        return;
    L9:
        if (r102.isDirectory() == false) goto L13;
        b(r102);
        return;
    L13:
        return;
    L5:
        r101 = "";
        goto L6
    }

    public static void b(File r100) {
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L14;
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L19;
        if (r101[r102].isFile() == false) goto L11;
        r101[r102].delete();
    L13:
        r101[r102].delete();
        r102 = r102 + 1;
        goto L6
    L11:
        if (r101[r102].isDirectory() == false) goto L13;
        b(r101[r102]);
        goto L13
    L19:
        return;
    }
}
