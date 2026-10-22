package com.airbnb.lottie.network;

import android.util.Pair;
import com.airbnb.lottie.utils.Logger;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class NetworkCache {
    private final LottieNetworkCacheProvider cacheProvider;

    public NetworkCache(LottieNetworkCacheProvider r1) {
        this.cacheProvider = r1;
    }

    public void clear() {
        File r4 = parentDir();
        if (r4.exists() == false) goto L14;
        File[] r0 = r4.listFiles();
        if (r0 != null) goto L7;
    L11:
        r4.delete();
        return;
    L7:
        if (r0.length <= 0) goto L11;
        File[] r1 = r4.listFiles();
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        r1[r3].delete();
        r3 = r3 + 1;
        goto L9
    }

    Pair<FileExtension, InputStream> fetch(String r5) {
        File r4 = getCachedFile(r5);     // Catch: FileNotFoundException -> L13
        if (r4 != null) goto L6;
        return null;
    L6:
        FileInputStream r1 = new FileInputStream(r4);     // Catch: FileNotFoundException -> L13
        if (r4.getAbsolutePath().endsWith(".zip") == false) goto L10;
        FileExtension r0 = FileExtension.ZIP;
    L11:
        Logger.debug("Cache hit for " + r5 + " at " + r4.getAbsolutePath());
        return new Pair(r0, r1);
    L10:
        r0 = FileExtension.JSON;
    L13:
        return null;
    }

    File writeTempCacheFile(String r3, InputStream r4, FileExtension r5) throws IOException {
        String r6 = filenameForUrl(r3, r5, true);
        File r7 = new File(parentDir(), r6);
        FileOutputStream r2 = new FileOutputStream(r7);     // Catch: Throwable -> L16
        byte[] r8 = new byte[1024];     // Catch: Throwable -> L13
    L6:
        int r0 = r4.read(r8);     // Catch: Throwable -> L13
        if (r0 == (-1)) goto L9;
        r2.write(r8, 0, r0);     // Catch: Throwable -> L13
        goto L6
    L9:
        r2.flush();     // Catch: Throwable -> L13
        r2.close();     // Catch: Throwable -> L16
        r4.close();
        return r7;
    L13:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r4.close();
        throw th;
    }

    void renameTempFile(String r3, FileExtension r4) {
        File r5 = new File(parentDir(), filenameForUrl(r3, r4, true));
        File r6 = new File(r5.getAbsolutePath().replace(".temp", ""));
        boolean r2 = r5.renameTo(r6);
        Logger.debug("Copying temp file to real file (" + r6 + ")");
        if (r2 == true) goto L6;
        Logger.warning("Unable to rename cache file " + r5.getAbsolutePath() + " to " + r6.getAbsolutePath() + LibrarianImpl.Constants.DOT);
        return;
    }

    private File getCachedFile(String r5) throws FileNotFoundException {
        File r0 = new File(parentDir(), filenameForUrl(r5, FileExtension.JSON, false));
        if (r0.exists() == false) goto L5;
        return r0;
    L5:
        File r1 = new File(parentDir(), filenameForUrl(r5, FileExtension.ZIP, false));
        if (r1.exists() == false) goto L8;
        return r1;
    L8:
        return null;
    }

    private File parentDir() {
        File r1 = this.cacheProvider.getCacheDir();
        if (r1.isFile() == false) goto L6;
        r1.delete();
    L6:
        if (r1.exists() == true) goto L8;
        r1.mkdirs();
    L8:
        return r1;
    }

    private static String filenameForUrl(String r1, FileExtension r2, boolean r3) {
        if (r3 == false) goto L4;
        String r4 = r2.tempExtension();
    L5:
        String r5 = r1.replaceAll("\\W+", "");
        int r6 = 242 - r4.length();
        if (r5.length() <= r6) goto L9;
        r5 = getMD5(r5, r6);
    L9:
        return "lottie_cache_" + r5 + r4;
    L4:
        r4 = r2.extension;
        goto L5
    }

    private static String getMD5(String r4, int r5) {
        byte[] r6 = MessageDigest.getInstance(StringEncryptUtils.MD5).digest(r4.getBytes());
        StringBuilder r7 = new StringBuilder();
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L9;
        r7.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r1])}));
        r1 = r1 + 1;
        goto L6
    L9:
        return r7.toString();
    L11:
        return r4.substring(0, r5);
    }
}
