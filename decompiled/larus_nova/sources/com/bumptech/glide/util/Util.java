package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class Util {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 31;
    private static final char[] HEX_CHAR_ARRAY = null;
    private static final char[] MD5_CHARS = null;
    private static final char[] SHA_256_CHARS = null;

    /* JADX INFO: renamed from: com.bumptech.glide.util.Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = null;

        static {
            int[] r100 = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = r100;
            r100[Bitmap.Config.ALPHA_8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static int hashCode(int r100, int r101) {
        return (r101 * 31) + r100;
    }

    private static boolean isValidDimension(int r100) {
        if (r100 <= 0) goto L4;
    L7:
        return true;
    L4:
        if (r100 == Integer.MIN_VALUE) goto L7;
        return false;
    }

    static {
        HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
        SHA_256_CHARS = new char[64];
        MD5_CHARS = new char[32];
    }

    public static void assertBackgroundThread() {
        if (isOnBackgroundThread() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You must call this method on a background thread");
    }

    public static void assertMainThread() {
        if (isOnMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static boolean isOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    private Util() {
    }

    public static <T> Queue<T> createQueue(int r100) {
        return new ArrayDeque(r100);
    }

    public static int getBitmapByteSize(Bitmap r100) {
        if (r100.isRecycled() == true) goto L9;
        return r100.getAllocationByteCount();
    L7:
        return r100.getHeight() * r100.getRowBytes();
    L9:
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + r100 + "[" + r100.getWidth() + "x" + r100.getHeight() + "] " + r100.getConfig());
    }

    private static int getBytesPerPixel(Bitmap.Config r100) {
        if (r100 != null) goto L4;
        r100 = Bitmap.Config.ARGB_8888;
    L4:
        int r101 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[r100.ordinal()];
        if (r101 != 1) goto L7;
        return 1;
    L7:
        if (r101 != 2) goto L9;
        return 2;
    L9:
        if (r101 != 3) goto L11;
        return 2;
    L11:
        if (r101 != 4) goto L18;
        return 8;
    L18:
        return 4;
    }

    public static int getSize(Bitmap r100) {
        return getBitmapByteSize(r100);
    }

    public static <T> List<T> getSnapshot(Collection<T> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        T r103 = r102.next();
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    public static int hashCode(float r100) {
        return hashCode(r100, 17);
    }

    public static String md5BytesToHex(byte[] r100) {
        char[] r101 = MD5_CHARS;
        monitor-enter(r101);
        String r102 = bytesToHex(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static String sha256BytesToHex(byte[] r100) {
        char[] r101 = SHA_256_CHARS;
        monitor-enter(r101);
        String r102 = bytesToHex(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static int hashCode(int r100) {
        return hashCode(r100, 17);
    }

    public static int hashCode(boolean r100) {
        return hashCode(r100, 17);
    }

    public static boolean bothModelsNullEquivalentOrEquals(Object r100, Object r101) {
        if (r100 != null) goto L8;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        if ((r100 instanceof Model) == false) goto L12;
        return ((Model) r100).isEquivalentTo(r101);
    L12:
        return r100.equals(r101);
    }

    public static boolean bothNullOrEqual(Object r100, Object r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r100.equals(r101);
    }

    private static String bytesToHex(byte[] r100, char[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        int r103 = r100[r102] & UByte.MAX_VALUE;
        int r104 = r102 * 2;
        char[] r105 = HEX_CHAR_ARRAY;
        r101[r104] = r105[r103 >>> 4];
        r101[r104 + 1] = r105[r103 & 15];
        r102 = r102 + 1;
        goto L4
    L7:
        return new String(r101);
    }

    public static int hashCode(Object r100, int r101) {
        if (r100 != null) goto L4;
        int r102 = 0;
    L6:
        return hashCode(r102, r101);
    L4:
        r102 = r100.hashCode();
        goto L6
    }

    public static boolean isValidDimensions(int r100, int r101) {
        if (isValidDimension(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidDimension(r101) == false) goto L7;
        return true;
    }

    public static int hashCode(float r100, int r101) {
        return hashCode(Float.floatToIntBits(r100), r101);
    }

    public static int hashCode(boolean r100, int r101) {
        return hashCode(r100 ? 1 : 0, r101);
    }

    public static int getBitmapByteSize(int r100, int r101, Bitmap.Config r102) {
        return (r100 * r101) * getBytesPerPixel(r102);
    }
}
