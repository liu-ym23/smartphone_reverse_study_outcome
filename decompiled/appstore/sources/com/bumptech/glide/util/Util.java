package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.Model;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class Util {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 31;
    private static final char[] HEX_CHAR_ARRAY = null;
    private static final char[] SHA_256_CHARS = null;

    /* JADX INFO: renamed from: com.bumptech.glide.util.Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = null;

        static {
            int[] r10 = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = r10;
            r10[Bitmap.Config.ALPHA_8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
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

    static {
        HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
        SHA_256_CHARS = new char[64];
    }

    private Util() {
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

    public static boolean bothModelsNullEquivalentOrEquals(@Nullable Object r10, @Nullable Object r11) {
        if (r10 != null) goto L8;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        if ((r10 instanceof Model) == false) goto L12;
        return ((Model) r10).isEquivalentTo(r11);
    L12:
        return r10.equals(r11);
    }

    public static boolean bothNullOrEqual(@Nullable Object r10, @Nullable Object r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r10.equals(r11);
    }

    @NonNull
    private static String bytesToHex(@NonNull byte[] r10, @NonNull char[] r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L7;
        byte r13 = r10[r12];
        int r14 = r13 & UnsignedBytes.MAX_VALUE;
        int r15 = r12 * 2;
        char[] r16 = HEX_CHAR_ARRAY;
        r11[r15] = r16[r14 >>> 4];
        r11[r15 + 1] = r16[r13 & Ascii.SI];
        r12 = r12 + 1;
        goto L4
    L7:
        return new String(r11);
    }

    @NonNull
    public static <T> Queue<T> createQueue(int r10) {
        return new ArrayDeque(r10);
    }

    @TargetApi(19)
    public static int getBitmapByteSize(@NonNull Bitmap r10) {
        if (r10.isRecycled() == true) goto L9;
        return r10.getAllocationByteCount();
    L7:
        return r10.getHeight() * r10.getRowBytes();
    L9:
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + r10 + "[" + r10.getWidth() + FixCard.FixStyle.KEY_X + r10.getHeight() + "] " + r10.getConfig());
    }

    private static int getBytesPerPixel(@Nullable Bitmap.Config r10) {
        if (r10 != null) goto L4;
        r10 = Bitmap.Config.ARGB_8888;
    L4:
        int r11 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[r10.ordinal()];
        if (r11 != 1) goto L7;
        return 1;
    L7:
        if (r11 != 2) goto L9;
        return 2;
    L9:
        if (r11 != 3) goto L11;
        return 2;
    L11:
        if (r11 != 4) goto L18;
        return 8;
    L18:
        return 4;
    }

    @Deprecated
    public static int getSize(@NonNull Bitmap r10) {
        return getBitmapByteSize(r10);
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        T r13 = r12.next();
        if (r13 == null) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public static int hashCode(int r10, int r11) {
        return (r11 * 31) + r10;
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

    private static boolean isValidDimension(int r10) {
        if (r10 <= 0) goto L4;
    L7:
        return true;
    L4:
        if (r10 == Integer.MIN_VALUE) goto L7;
        return false;
    }

    public static boolean isValidDimensions(int r10, int r11) {
        if (isValidDimension(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidDimension(r11) == false) goto L7;
        return true;
    }

    @NonNull
    public static String sha256BytesToHex(@NonNull byte[] r10) {
        char[] r11 = SHA_256_CHARS;
        monitor-enter(r11);
        String r12 = bytesToHex(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static int hashCode(int r10) {
        return hashCode(r10, 17);
    }

    public static int hashCode(float r10) {
        return hashCode(r10, 17);
    }

    public static int hashCode(float r10, int r11) {
        return hashCode(Float.floatToIntBits(r10), r11);
    }

    public static int hashCode(@Nullable Object r10, int r11) {
        if (r10 != null) goto L4;
        int r12 = 0;
    L6:
        return hashCode(r12, r11);
    L4:
        r12 = r10.hashCode();
        goto L6
    }

    public static int getBitmapByteSize(int r10, int r11, @Nullable Bitmap.Config r12) {
        return (r10 * r11) * getBytesPerPixel(r12);
    }

    public static int hashCode(boolean r10, int r11) {
        return hashCode(r10 ? 1 : 0, r11);
    }

    public static int hashCode(boolean r10) {
        return hashCode(r10, 17);
    }
}
