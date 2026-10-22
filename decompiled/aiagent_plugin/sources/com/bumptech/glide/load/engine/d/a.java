package com.bumptech.glide.load.engine.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.f.k;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.engine.b.h;
import com.bumptech.glide.load.g;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BitmapPreFillRunner.java */
/* JADX INFO: loaded from: classes.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f3614a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C0095a f3615b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f3616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f3617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f3618e;
    private final C0095a f;
    private final Set<d> g;
    private final Handler h;
    private long i;
    private boolean j;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BitmapPreFillRunner.java */
    static class C0095a {
        C0095a() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: compiled from: BitmapPreFillRunner.java */
    private static final class b implements g {
        b() {
        }

        @Override // com.bumptech.glide.load.g
        public void a(MessageDigest r1) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        f3615b = new C0095a();
        f3614a = TimeUnit.SECONDS.toMillis(1);
    }

    public a(e r9, h r10, c r11) {
        this((e) ZeusTransformUtils.wrapperContextForParams(r9, e.class, "com.obric.aiagent.plugin"), (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.aiagent.plugin"), r11, f3615b, new Handler(Looper.getMainLooper()));
    }

    a(e r3, h r4, c r5, C0095a r6, Handler r7) {
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        this.g = new HashSet();
        this.i = 40;
        this.f3616c = r8;
        this.f3617d = r9;
        this.f3618e = r5;
        this.f = r6;
        this.h = r7;
    }

    public void a() {
        this.j = true;
    }

    boolean b() {
        long r0 = this.f.a();
    L4:
        if (this.f3618e.b() == true) goto L19;
        if (a(r0) == true) goto L19;
        d r2 = this.f3618e.a();
        if (this.g.contains(r2) == true) goto L10;
        this.g.add(r2);
        Bitmap r3 = this.f3616c.b(r2.a(), r2.b(), r2.c());
    L11:
        int r4 = k.a(r3);
        if (c() < r4) goto L14;
        this.f3617d.b(new b(), com.bumptech.glide.load.resource.bitmap.e.a(r3, this.f3616c));
    L16:
        if (a("PreFillRunner", 3) == false) goto L4;
        a("PreFillRunner", "allocated [" + r2.a() + "x" + r2.b() + "] " + r2.c() + " size: " + r4);
        goto L4
    L14:
        this.f3616c.a(r3);
        goto L16
    L10:
        r3 = Bitmap.createBitmap(r2.a(), r2.b(), r2.c());
    L19:
        if (this.j == false) goto L21;
    L23:
        return false;
    L21:
        if (this.f3618e.b() == true) goto L23;
        return true;
    }

    private boolean a(long r3) {
        if ((this.f.a() - r3) < 32) goto L5;
        return true;
    L5:
        return false;
    }

    private long c() {
        return this.f3617d.b() - this.f3617d.a();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (b() == false) goto L6;
        this.h.postDelayed(this, d());
        return;
    }

    private long d() {
        long r0 = this.i;
        this.i = Math.min(4 * r0, f3614a);
        return r0;
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
        return Log.d(r1, r2);
    }
}
