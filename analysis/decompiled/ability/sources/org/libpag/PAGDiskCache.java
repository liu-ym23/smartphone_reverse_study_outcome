package org.libpag;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import z2.l;

/* loaded from: classes4.dex */
public class PAGDiskCache {
    static {
        l.j("pag");
    }

    private static String GetCacheDir() {
        Context context = l.c;
        if (context == null) {
            return "";
        }
        File externalCacheDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        return externalCacheDir == null ? "" : externalCacheDir.getPath();
    }

    public static native long MaxDiskSize();

    public static native byte[] ReadFile(String str);

    public static native void RemoveAll();

    public static native void SetMaxDiskSize(long j5);

    public static native boolean WriteFile(String str, byte[] bArr);
}
