package org.libpag;

import android.content.Context;
import android.os.Environment;
import gc.AbstractC4115a;
import java.io.File;

/* loaded from: classes5.dex */
public class PAGDiskCache {
    static {
        AbstractC4115a.e("pag");
    }

    private static String GetCacheDir() {
        Context contextA = AbstractC4115a.a();
        if (contextA == null) {
            return "";
        }
        File externalCacheDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? contextA.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = contextA.getCacheDir();
        }
        return externalCacheDir == null ? "" : externalCacheDir.getPath();
    }

    public static native long MaxDiskSize();

    public static native byte[] ReadFile(String str);

    public static native void RemoveAll();

    public static native void SetMaxDiskSize(long j10);

    public static native boolean WriteFile(String str, byte[] bArr);
}
