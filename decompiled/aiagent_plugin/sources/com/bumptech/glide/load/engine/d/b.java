package com.bumptech.glide.load.engine.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.f.k;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.engine.b.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: BitmapPreFiller.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f3619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f3620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.b f3621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f3622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f3623e;

    public b(h r3, e r4, com.bumptech.glide.load.b r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        this.f3622d = new Handler(Looper.getMainLooper());
        this.f3619a = r6;
        this.f3620b = r7;
        this.f3621c = r5;
    }

    public void a(d.a... r6) {
        a r0 = this.f3623e;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        d[] r1 = new d[r6.length];
        int r2 = 0;
    L7:
        if (r2 >= r6.length) goto L16;
        d.a r3 = r6[r2];
        if (r3.a() != null) goto L15;
        if (this.f3621c != com.bumptech.glide.load.b.f3394a) goto L13;
        Bitmap.Config r4 = Bitmap.Config.ARGB_8888;
    L14:
        r3.a(r4);
        goto L15
    L13:
        r4 = Bitmap.Config.RGB_565;
    L15:
        r1[r2] = r3.b();
        r2 = r2 + 1;
        goto L7
    L16:
        c r7 = a(r1);
        a r5 = new a(this.f3620b, this.f3619a, r7);
        this.f3623e = r5;
        this.f3622d.post(r5);
    }

    c a(d... r7) {
        long r0 = (this.f3619a.b() - this.f3619a.a()) + this.f3620b.a();
        int r6 = r7.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r6) goto L5;
        r4 = r4 + r7[r3].d();
        r3 = r3 + 1;
        goto L3
    L5:
        float r8 = r0 / r4;
        HashMap r1 = new HashMap();
        int r5 = r7.length;
    L6:
        if (r2 >= r5) goto L9;
        d r9 = r7[r2];
        r1.put(r9, Integer.valueOf(Math.round(r9.d() * r8) / a(r9)));
        r2 = r2 + 1;
        goto L6
    L9:
        return new c(r1);
    }

    private static int a(d r2) {
        return k.a(r2.a(), r2.b(), r2.c());
    }
}
