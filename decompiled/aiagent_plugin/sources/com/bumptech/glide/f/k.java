package com.bumptech.glide.f;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.bumptech.glide.load.b.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f3337a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f3338b = null;

    /* JADX INFO: renamed from: com.bumptech.glide.f.k$1, reason: invalid class name */
    /* JADX INFO: compiled from: Util.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3339a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            f3339a = r0;
            r0[Bitmap.Config.ALPHA_8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f3339a[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f3339a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f3339a[Bitmap.Config.RGBA_F16.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f3339a[Bitmap.Config.ARGB_8888.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static int b(int r0, int r1) {
        return (r1 * 31) + r0;
    }

    private static boolean b(int r1) {
        if (r1 <= 0) goto L4;
    L7:
        return true;
    L4:
        if (r1 == Integer.MIN_VALUE) goto L7;
        return false;
    }

    static {
        f3337a = "0123456789abcdef".toCharArray();
        f3338b = new char[64];
    }

    public static String a(byte[] r1) {
        char[] r0 = f3338b;
        monitor-enter(r0);
        String r2 = a(r1, r0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private static String a(byte[] r5, char[] r6) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L7;
        int r1 = r5[r0] & 255;
        int r2 = r0 * 2;
        char[] r3 = f3337a;
        r6[r2] = r3[r1 >>> 4];
        r6[r2 + 1] = r3[r1 & 15];
        r0 = r0 + 1;
        goto L4
    L7:
        return new String(r6);
    }

    public static int a(Bitmap r3) {
        if (r3.isRecycled() == true) goto L11;
        if (Build.VERSION.SDK_INT < 19) goto L9;
        return r3.getAllocationByteCount();
    L9:
        return r3.getHeight() * r3.getRowBytes();
    L11:
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + r3 + "[" + r3.getWidth() + "x" + r3.getHeight() + "] " + r3.getConfig());
    }

    public static int a(int r0, int r1, Bitmap.Config r2) {
        return (r0 * r1) * a(r2);
    }

    private static int a(Bitmap.Config r3) {
        if (r3 != null) goto L4;
        r3 = Bitmap.Config.ARGB_8888;
    L4:
        int r4 = AnonymousClass1.f3339a[r3.ordinal()];
        if (r4 == 1) goto L14;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L16;
        if (r4 != 4) goto L17;
        return 8;
    L17:
        return 4;
    L16:
        return 2;
    L14:
        return 1;
    }

    public static boolean a(int r0, int r1) {
        if (b(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (b(r1) == false) goto L7;
        return true;
    }

    public static void a() {
        if (c() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    public static void b() {
        if (d() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You must call this method on a background thread");
    }

    public static boolean c() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean d() {
        return !c();
    }

    public static <T> Queue<T> a(int r1) {
        return new ArrayDeque(r1);
    }

    public static <T> List<T> a(Collection<T> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList(r3.size());
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static boolean b(Object r2, Object r3) {
        if (r2 != null) goto L8;
        if (r3 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L12;
        return ((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.aiagent.plugin")).a(r3);
    L12:
        return r2.equals(r3);
    }

    public static int a(float r1) {
        return a(r1, 17);
    }

    public static int a(float r0, int r1) {
        return b(Float.floatToIntBits(r0), r1);
    }

    public static int a(Object r0, int r1) {
        if (r0 != null) goto L4;
        int r2 = 0;
    L6:
        return b(r2, r1);
    L4:
        r2 = r0.hashCode();
        goto L6
    }

    public static int a(boolean r0, int r1) {
        return b(r0 ? 1 : 0, r1);
    }
}
