package com.bumptech.glide.load.engine.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DiskLruCacheWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {
    private static final String TAG = "DiskLruCacheWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f3566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f3567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f3568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f3569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.a.a f3570e;

    public static a a(File r1, long r2) {
        return new e(r1, r2);
    }

    @Deprecated
    public e(File r2, long r3) {
        this.f3569d = new c();
        this.f3567b = r2;
        this.f3568c = r3;
        this.f3566a = new j();
    }

    private synchronized com.bumptech.glide.a.a b() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f3570e != null) goto L6;
        this.f3570e = com.bumptech.glide.a.a.a(this.f3567b, 1, 1, this.f3568c);     // Catch: Throwable -> L9
    L6:
        com.bumptech.glide.a.a r0 = this.f3570e;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public File a(com.bumptech.glide.load.g r5) {
        com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        String r0 = this.f3566a.a(r6);
        if (a(TAG, 2) == false) goto L15;
        a(TAG, "Get: Obtained: " + r0 + " for for Key: " + r6);
    L15:
        com.bumptech.glide.a.a.d r4 = b().a(r0);     // Catch: IOException -> L10
        if (r4 == null) goto L17;
        return r4.a(0);
    L17:
        return null;
    L10:
        e = move-exception;
        if (a(TAG, 5) == false) goto L19;
        a(TAG, "Unable to get from disk cache", e);
        return null;
    L19:
        return null;
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public void a(com.bumptech.glide.load.g r5, a.b r6) {
        com.bumptech.glide.load.g r7 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        a.b r8 = (a.b) ZeusTransformUtils.wrapperContextForParams(r6, a.b.class, "com.obric.aiagent.plugin");
        String r1 = this.f3566a.a(r7);
        this.f3569d.a(r1);
    L29:
        th = move-exception;
        this.f3569d.b(r1);
        throw th;
    L4:
        if (a(TAG, 2) == false) goto L34;
        a(TAG, "Put: Obtained: " + r1 + " for for Key: " + r7);     // Catch: Throwable -> L29
    L34:
        com.bumptech.glide.a.a r9 = b();     // Catch: IOException -> L22 Throwable -> L29
        if (r9.a(r1) == null) goto L10;
        this.f3569d.b(r1);
        return;
    L10:
        com.bumptech.glide.a.a.b r10 = r9.b(r1);     // Catch: IOException -> L22 Throwable -> L29
        if (r10 == null) goto L21;
    L17:
        th = move-exception;
        r10.c();     // Catch: IOException -> L22 Throwable -> L29
        throw th;     // Catch: IOException -> L22 Throwable -> L29
    L14:
        if (r8.a(r10.a(0)) == false) goto L16;
        r10.a();     // Catch: Throwable -> L17
    L16:
        r10.c();     // Catch: IOException -> L22 Throwable -> L29
    L27:
        this.f3569d.b(r1);
        return;
    L21:
        throw new IllegalStateException("Had two simultaneous puts for: " + r1);     // Catch: IOException -> L22 Throwable -> L29
    L22:
        e = move-exception;
        if (a(TAG, 5) == false) goto L27;
        a(TAG, "Unable to put to disk cache", e);     // Catch: Throwable -> L29
        goto L27
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public void delete(com.bumptech.glide.load.g r3) {
        com.bumptech.glide.load.g r4 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        String r5 = this.f3566a.a(r4);
        b().c(r5);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        if (a(TAG, 5) == false) goto L12;
        a(TAG, "Unable to delete from disk cache", e);
        return;
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public synchronized void a() {
        monitor-enter(this);
        b().delete();     // Catch: Throwable -> L6 IOException -> L8
    L4:
        c();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L8:
        e = move-exception;
        if (a(TAG, 5) == false) goto L4;
        a(TAG, "Unable to clear disk cache or disk cache cleared externally", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        c();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private synchronized void c() {
        monitor-enter(this);
        this.f3570e = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
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
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
