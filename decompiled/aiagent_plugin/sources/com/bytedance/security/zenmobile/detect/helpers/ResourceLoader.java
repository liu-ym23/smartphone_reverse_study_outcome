package com.bytedance.security.zenmobile.detect.helpers;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class ResourceLoader {
    public ResourceLoader() {
    }

    public static byte[] loadBytes(ClassLoader r5, String r6) {
        InputStream r7 = r5.getResourceAsStream(r6);
        if (r7 == null) goto L11;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        byte[] r1 = new byte[1024];
    L5:
        int r3 = r7.read(r1, 0, 1024);
        if (r3 == (-1)) goto L9;
        r8.write(r1, 0, r3);
        goto L5
    L9:
        return r8.toByteArray();
    L11:
        throw new IllegalArgumentException("file not found: " + r6);
    }

    public static String loadString(ClassLoader r1, String r2) {
        return new String(loadBytes(r1, r2), StandardCharsets.UTF_8);
    }
}
