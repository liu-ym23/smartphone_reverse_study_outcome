package com.bef.effectsdk.text;

import android.graphics.Typeface;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import java.io.File;
import java.util.Hashtable;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes39.dex */
public class FontCache {
    private static final int MAX_CACHE_SIZE = 32;
    private static Hashtable<String, Typeface> fontCache;
    private static LinkedList<String> lruQueue;

    public FontCache() {
    }

    public static /* synthetic */ Typeface access$000(File r100) {
        return Typeface.createFromFile(r100);
    }

    static {
        fontCache = new Hashtable();
        lruQueue = new LinkedList();
    }

    public static Typeface INVOKESTATIC_com_bef_effectsdk_text_FontCache_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(File r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L15;
        String r101 = r100.getPath();
        if (r101 == null) goto L15;
        if (TypeFaceLancet.cache.contains(r101) == true) goto L9;
        Typeface r102 = access$000(r100);
        if (r102 == null) goto L15;
        TypeFaceLancet.cache.put(r101, r102);
        return r102;
    L9:
        return (Typeface) TypeFaceLancet.cache.get(r101);
    L15:
        return access$000(r100);
    }

    public static synchronized Typeface getFromFile(String r100, String r101) {
        monitor-enter(FontCache.class);
        String r102 = "FILE_" + r100 + "_" + r101;     // Catch: Throwable -> L18
        Typeface r103 = fontCache.get(r102);     // Catch: Throwable -> L18
        if (r103 == null) goto L22;
        lruQueue.remove(r102);     // Catch: Throwable -> L18
        lruQueue.addFirst(r102);     // Catch: Throwable -> L18
    L16:
        monitor-exit(FontCache.class);
        return r103;
    L22:
        r103 = INVOKESTATIC_com_bef_effectsdk_text_FontCache_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(new PolarisFileWrapper(r100, r101));     // Catch: Exception -> L12 Throwable -> L18
        if (lruQueue.size() < 32) goto L10;
        fontCache.remove(lruQueue.removeLast());     // Catch: Throwable -> L18
        System.gc();     // Catch: Throwable -> L18
    L10:
        fontCache.put(r102, r103);     // Catch: Throwable -> L18
        lruQueue.addFirst(r102);     // Catch: Throwable -> L18
    L13:
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized Typeface getFromSystem(String r100, int r101) {
        monitor-enter(FontCache.class);
        String r102 = "SYSTEM_" + r100 + "_" + r101;     // Catch: Throwable -> L18
        Typeface r103 = fontCache.get(r102);     // Catch: Throwable -> L18
        if (r103 == null) goto L21;
        lruQueue.remove(r102);     // Catch: Throwable -> L18
        lruQueue.addFirst(r102);     // Catch: Throwable -> L18
    L16:
        monitor-exit(FontCache.class);
        return r103;
    L21:
        r103 = Typeface.create(r100, r101);     // Catch: Exception -> L12 Throwable -> L18
        if (lruQueue.size() < 32) goto L10;
        fontCache.remove(lruQueue.removeLast());     // Catch: Throwable -> L18
        System.gc();     // Catch: Throwable -> L18
    L10:
        fontCache.put(r102, r103);     // Catch: Throwable -> L18
        lruQueue.addFirst(r102);     // Catch: Throwable -> L18
    L13:
        return null;
    L18:
        th = move-exception;
        throw th;
    }
}
