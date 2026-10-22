package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements e {
    private static final String TAG = "LruBitmapPool";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bitmap.Config f3545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f3546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Bitmap.Config> f3547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f3548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f3549e;
    private long f;
    private long g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private interface a {
        void a(Bitmap r1);

        void b(Bitmap r1);
    }

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private static final class b implements a {
        @Override // com.bumptech.glide.load.engine.a.k.a
        public void a(Bitmap r1) {
        }

        @Override // com.bumptech.glide.load.engine.a.k.a
        public void b(Bitmap r1) {
        }

        b() {
        }
    }

    static {
        f3545a = Bitmap.Config.ARGB_8888;
    }

    k(long r3, l r5, Set<Bitmap.Config> r6) {
        l r7 = (l) ZeusTransformUtils.wrapperContextForParams(r5, l.class, "com.obric.aiagent.plugin");
        Set<Bitmap.Config> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        this.f3548d = r3;
        this.f = r3;
        this.f3546b = r7;
        this.f3547c = r8;
        this.f3549e = new b();
    }

    public k(long r3) {
        this(r3, f(), g());
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public long a() {
        return this.f;
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public synchronized void a(float r3) {
        monitor-enter(this);
        this.f = Math.round(this.f3548d * r3);     // Catch: Throwable -> L6
        c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public synchronized void a(Bitmap r7) {
        monitor-enter(this);
        if (r7 == null) goto L30;
        if (r7.isRecycled() == true) goto L26;
        if (r7.isMutable() == false) goto L20;
        if (this.f3546b.c(r7) > this.f) goto L20;
        if (this.f3547c.contains(r7.getConfig()) == false) goto L20;
        int r0 = this.f3546b.c(r7);     // Catch: Throwable -> L27
        this.f3546b.a(r7);     // Catch: Throwable -> L27
        this.f3549e.a(r7);     // Catch: Throwable -> L27
        this.j++;     // Catch: Throwable -> L27
        this.g += (long) r0;     // Catch: Throwable -> L27
        if (a(TAG, 2) == false) goto L16;
        a(TAG, "Put bitmap in pool=" + this.f3546b.b(r7));     // Catch: Throwable -> L27
    L16:
        d();     // Catch: Throwable -> L27
        c();     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L20:
        if (a(TAG, 2) == false) goto L22;
        a(TAG, "Reject bitmap from pool, bitmap: " + this.f3546b.b(r7) + ", is mutable: " + r7.isMutable() + ", is allowed config: " + this.f3547c.contains(r7.getConfig()));     // Catch: Throwable -> L27
    L22:
        r7.recycle();     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L26:
        throw new IllegalStateException("Cannot pool recycled bitmap");     // Catch: Throwable -> L27
    L30:
        throw new NullPointerException("Bitmap must not be null");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private void c() {
        a(this.f);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap a(int r1, int r2, Bitmap.Config r3) {
        Bitmap r0 = d(r1, r2, r3);
        if (r0 == null) goto L6;
        r0.eraseColor(0);
        return r0;
    L6:
        return c(r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap b(int r1, int r2, Bitmap.Config r3) {
        Bitmap r0 = d(r1, r2, r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return c(r1, r2, r3);
    }

    private static Bitmap c(int r0, int r1, Bitmap.Config r2) {
        if (r2 != null) goto L6;
        r2 = f3545a;
    L6:
        return Bitmap.createBitmap(r0, r1, r2);
    }

    private static void a(Bitmap.Config r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        if (r3 == Bitmap.Config.HARDWARE) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + r3 + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    private synchronized Bitmap d(int r6, int r7, Bitmap.Config r8) {
        monitor-enter(this);
        a(r8);     // Catch: Throwable -> L20
        l r0 = this.f3546b;     // Catch: Throwable -> L20
        if (r8 == null) goto L6;
        Bitmap.Config r1 = r8;
    L7:
        Bitmap r2 = r0.a(r6, r7, r1);     // Catch: Throwable -> L20
        if (r2 == null) goto L10;
        this.h++;     // Catch: Throwable -> L20
        this.g -= (long) this.f3546b.c(r2);     // Catch: Throwable -> L20
        this.f3549e.b(r2);     // Catch: Throwable -> L20
        b(r2);     // Catch: Throwable -> L20
    L15:
        if (a(TAG, 2) == false) goto L17;
        a(TAG, "Get bitmap=" + this.f3546b.b(r6, r7, r8));     // Catch: Throwable -> L20
    L17:
        d();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r2;
    L10:
        if (a(TAG, 3) == false) goto L12;
        b(TAG, "Missing bitmap=" + this.f3546b.b(r6, r7, r8));     // Catch: Throwable -> L20
    L12:
        this.i++;     // Catch: Throwable -> L20
        goto L15
    L6:
        r1 = f3545a;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private static void b(Bitmap r1) {
        r1.setHasAlpha(true);
        c(r1);
    }

    private static void c(Bitmap r2) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r2.setPremultiplied(true);
        return;
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void b() {
        if (a(TAG, 3) == false) goto L5;
        b(TAG, "clearMemory");
    L5:
        a(0);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void a(int r5) {
        if (a(TAG, 3) == false) goto L6;
        b(TAG, "trimMemory, level=" + r5);
    L6:
        if (r5 < 40) goto L8;
    L15:
        b();
        return;
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        if (r5 >= 20) goto L15;
    L11:
        if (r5 < 20) goto L13;
    L14:
        a(a() / 2);
        return;
    L13:
        if (r5 == 15) goto L14;
    }

    private synchronized void a(long r6) {
        monitor-enter(this);
    L23:
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.g <= r6) goto L18;
        Bitmap r0 = this.f3546b.a();     // Catch: Throwable -> L20
        if (r0 == null) goto L8;
        this.f3549e.b(r0);     // Catch: Throwable -> L20
        this.g -= (long) this.f3546b.c(r0);     // Catch: Throwable -> L20
        this.k++;     // Catch: Throwable -> L20
        if (a(TAG, 3) == false) goto L16;
        b(TAG, "Evicting bitmap=" + this.f3546b.b(r0));     // Catch: Throwable -> L20
    L16:
        d();     // Catch: Throwable -> L20
        r0.recycle();     // Catch: Throwable -> L20
        goto L23
    L8:
        if (a(TAG, 5) == false) goto L10;
        c(TAG, "Size mismatch, resetting");     // Catch: Throwable -> L20
        e();     // Catch: Throwable -> L20
    L10:
        this.g = 0;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L18:
        monitor-exit(this);
    }

    private void d() {
        if (a(TAG, 2) == false) goto L6;
        e();
        return;
    }

    private void e() {
        a(TAG, "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.f3546b);
    }

    private static l f() {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        return new n();
    L6:
        return new c();
    }

    private static Set<Bitmap.Config> g() {
        HashSet r0 = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r0.add(null);
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        r0.remove(Bitmap.Config.HARDWARE);
    L9:
        return Collections.unmodifiableSet(r0);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
