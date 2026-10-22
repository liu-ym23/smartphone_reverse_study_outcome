package com.android.server.am;

import android.app.ActivityThread;
import android.content.ContentResolver;
import android.provider.Settings;
import android.util.ArrayMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class ActivityManagerUtils {
    private static Integer sAndroidIdHash;
    private static final ArrayMap<String, Integer> sHashCache = null;
    private static String sInjectedAndroidId;

    private ActivityManagerUtils() {
    }

    static {
        sHashCache = new ArrayMap();
    }

    static void injectAndroidIdForTest(String androidId) {
        sInjectedAndroidId = androidId;
        sAndroidIdHash = null;
    }

    static int getAndroidIdHash() {
        if (sAndroidIdHash != null) goto L10;
        ContentResolver resolver = ActivityThread.currentApplication().getContentResolver();
        String androidId = Settings.Secure.getStringForUser(resolver, "android_id", resolver.getUserId());
        if (sInjectedAndroidId == null) goto L7;
        String r2 = sInjectedAndroidId;
    L8:
        sAndroidIdHash = Integer.valueOf(getUnsignedHashUnCached(r2));
        goto L10
    L7:
        r2 = androidId;
    L10:
        return sAndroidIdHash.intValue();
    }

    static int getUnsignedHashCached(String s) {
        ArrayMap<String, Integer> r0 = sHashCache;
        monitor-enter(r0);
        Integer cached = sHashCache.get(s);     // Catch: Throwable -> L9
        if (cached == null) goto L11;
        int r2 = cached.intValue();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        int hash = getUnsignedHashUnCached(s);     // Catch: Throwable -> L9
        sHashCache.put(s.intern(), Integer.valueOf(hash));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return hash;
    L9:
        th = move-exception;
        throw th;
    }

    private static int getUnsignedHashUnCached(String s) {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L4
        digest.update(s.getBytes());     // Catch: NoSuchAlgorithmException -> L4
        return unsignedIntFromBytes(digest.digest());
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    static int unsignedIntFromBytes(byte[] longEnoughBytes) {
        return (((extractByte(longEnoughBytes, 0) | extractByte(longEnoughBytes, 1)) | extractByte(longEnoughBytes, 2)) | extractByte(longEnoughBytes, 3)) & Integer.MAX_VALUE;
    }

    private static int extractByte(byte[] bytes, int index) {
        return (bytes[index] & 255) << (index * 8);
    }

    public static boolean shouldSamplePackageForAtom(String packageName, float rate) {
        if (rate > 0.0f) goto L6;
        return false;
    L6:
        if (rate < 1.0f) goto L8;
        return true;
    L8:
        int hash = getUnsignedHashCached(packageName) ^ getAndroidIdHash();
        if ((((double) hash) / 2.147483647E9d) <= rate) goto L11;
        return false;
    L11:
        return true;
    }
}
