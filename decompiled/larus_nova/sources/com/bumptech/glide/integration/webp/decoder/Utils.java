package com.bumptech.glide.integration.webp.decoder;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
class Utils {
    private static final String TAG = "Utils";

    public Utils() {
    }

    public static byte[] inputStreamToBytes(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(16384);
        byte[] r102 = new byte[16384];     // Catch: IOException -> L10
    L4:
        int r103 = r100.read(r102);     // Catch: IOException -> L10
        if (r103 == (-1)) goto L7;
        r101.write(r102, 0, r103);     // Catch: IOException -> L10
        goto L4
    L7:
        r101.flush();     // Catch: IOException -> L10
        return r101.toByteArray();
    L10:
        return null;
    }

    public static int getSampleSize(int r100, int r101, int r102, int r103) {
        int r104 = Math.min(r101 / r103, r100 / r102);
        if (r104 != 0) goto L5;
        int r105 = 0;
    L6:
        int r106 = Math.max(1, r105);
        if (Log.isLoggable(TAG, 2) == false) goto L10;
        if (r106 > 1) goto L10;
    L10:
        return r106;
    L5:
        r105 = Integer.highestOneBit(r104);
        goto L6
    }
}
