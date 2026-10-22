package com.bumptech.glide.disklrucache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class Util {
    static final Charset US_ASCII = null;
    static final Charset UTF_8 = null;

    static {
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
    }

    private Util() {
    }

    public static void closeQuietly(Closeable r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        r10.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static void deleteContents(File r10) throws IOException {
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L16;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        File r14 = r11[r13];
        if (r14.isDirectory() == false) goto L10;
        deleteContents(r14);
    L10:
        if (r14.delete() == false) goto L13;
        r13 = r13 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: " + r14);
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: " + r10);
    }

    public static String readFully(Reader r10) throws IOException {
        StringWriter r11 = new StringWriter();     // Catch: Throwable -> L6
        char[] r12 = new char[1024];     // Catch: Throwable -> L6
    L3:
        int r13 = r10.read(r12);     // Catch: Throwable -> L6
        if (r13 == (-1)) goto L8;
        r11.write(r12, 0, r13);     // Catch: Throwable -> L6
        goto L3
    L8:
        String r14 = r11.toString();     // Catch: Throwable -> L6
        r10.close();
        return r14;
    L6:
        th = move-exception;
        r10.close();
        throw th;
    }
}
