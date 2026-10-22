package com.ttnet.org.chromium.base;

import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
public class ApkAssets {
    @CalledByNative
    public static long[] open(String r12) {
        AssetFileDescriptor r10 = null;
        r10 = e.d().getAssets().openNonAssetFd(r12);     // Catch: Throwable -> L9 IOException -> L11
        long[] r11 = {r10.getParcelFileDescriptor().detachFd(), r10.getStartOffset(), r10.getLength()};     // Catch: Throwable -> L9 IOException -> L11
    L37:
        r10.close();     // Catch: IOException -> L6
    L8:
        return r11;
    L6:
        e = move-exception;
        Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e);
    L11:
        e = move-exception;
        if (e.getMessage().equals("") == false) goto L15;
    L17:
        long[] r13 = {-1, -1, -1};     // Catch: Throwable -> L9
        if (r10 != null) goto L32;
    L23:
        return r13;
    L32:
        r10.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e);
        goto L23
    L15:
        if (e.getMessage().equals(r12) == true) goto L17;
        Log.e("ApkAssets", "Error while loading asset " + r12 + ": " + e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r10 != null) goto L35;
    L29:
        throw th;
    L35:
        r10.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e);
        goto L29
    }
}
