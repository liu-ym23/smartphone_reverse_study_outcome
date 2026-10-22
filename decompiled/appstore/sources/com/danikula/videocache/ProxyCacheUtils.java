package com.danikula.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyCacheUtils {
    static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int MAX_ARRAY_PREVIEW = 16;

    public ProxyCacheUtils() {
    }

    public static void assertBuffer(byte[] r10, long r11, int r12) {
        Preconditions.checkNotNull(r10, "Buffer must be not null!");
        boolean r13 = false;
        if (r11 < 0) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14, "Data offset must be positive!");
        if (r12 >= 0) goto L9;
    L11:
        Preconditions.checkArgument(r13, "Length must be in range [0..buffer.length]");
        return;
    L9:
        if (r12 > r10.length) goto L11;
        r13 = true;
        goto L11
    L5:
        r14 = false;
        goto L6
    }

    private static String bytesToHexString(byte[] r10) {
        StringBuffer r11 = new StringBuffer();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11.append(String.format("%02x", new Object[]{Byte.valueOf(r10[r13])}));
        r13 = r13 + 1;
        goto L3
    L6:
        return r11.toString();
    }

    public static void close(Closeable r10) {
        if (r10 == null) goto L10;
        r10.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        KLog.e("Error closing resource", new Object[]{e});
        return;
    }

    public static String computeMD5(String r10) {
        return bytesToHexString(MessageDigest.getInstance("MD5").digest(r10.getBytes()));
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String decode(String r10) {
        return URLDecoder.decode(r10, "utf-8");
    L4:
        e = move-exception;
        throw new RuntimeException("Error decoding url", e);
    }

    public static String encode(String r10) {
        return URLEncoder.encode(r10, "utf-8");
    L4:
        e = move-exception;
        throw new RuntimeException("Error encoding url", e);
    }

    public static String getSupposablyMime(String r10) {
        MimeTypeMap r11 = MimeTypeMap.getSingleton();
        String r12 = MimeTypeMap.getFileExtensionFromUrl(r10);
        if (TextUtils.isEmpty(r12) == false) goto L6;
        return null;
    L6:
        return r11.getMimeTypeFromExtension(r12);
    }

    public static String preview(byte[] r10, int r11) {
        int r12 = Math.min(16, Math.max(r11, 0));
        String r13 = Arrays.toString(Arrays.copyOfRange(r10, 0, r12));
        if (r12 < r11) goto L5;
        return r13;
    L5:
        return r13.substring(0, r13.length() - 1) + ", ...]";
    }
}
