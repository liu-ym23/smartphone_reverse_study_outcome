package com.bytedance.android.livesdk.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes11.dex */
public final class n1 {
    public static File a(Context r100) {
        File r101 = r100.getCacheDir();
        if (r101 != null) goto L6;
        String r102 = "/data/data/" + r100.getPackageName() + "/cache/";
        String.format("Can't define system cache directory! '%s' will be used.", new Object[]{r102});
        return new PolarisFileWrapper(r102);
    L6:
        return r101;
    }
}
