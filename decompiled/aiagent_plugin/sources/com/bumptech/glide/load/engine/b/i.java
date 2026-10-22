package com.bumptech.glide.load.engine.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MemorySizeCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    private static final String TAG = "MemorySizeCalculator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f3576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3577d;

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f3578a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f3579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ActivityManager f3580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c f3581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f3582e;
        float f;
        float g;
        float h;
        int i;

        static {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            int r0 = 4;
        L6:
            f3578a = r0;
            return;
        L5:
            r0 = 1;
            goto L6
        }

        public a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f3582e = 2.0f;
            this.f = f3578a;
            this.g = 0.4f;
            this.h = 0.33f;
            this.i = UiType.FLAG_NO_FEEDBACK;
            this.f3579b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            this.f3580c = (ActivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
            this.f3581d = new b(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            return;
        L5:
            if (i.a(this.f3580c) == false) goto L9;
            this.f = 0.0f;
            return;
        }

        public i a() {
            return new i(this);
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f3583a;

        b(DisplayMetrics r1) {
            this.f3583a = r1;
        }

        @Override // com.bumptech.glide.load.engine.b.i.c
        public int a() {
            return this.f3583a.widthPixels;
        }

        @Override // com.bumptech.glide.load.engine.b.i.c
        public int b() {
            return this.f3583a.heightPixels;
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    interface c {
        int a();

        int b();
    }

    i(a r7) {
        this.f3576c = ZeusTransformUtils.wrapperContext(r7.f3579b, "com.obric.aiagent.plugin");
        if (a(r7.f3580c) == false) goto L5;
        int r0 = r7.i / 2;
    L6:
        this.f3577d = r0;
        int r1 = a(r7.f3580c, r7.g, r7.h);
        float r2 = (r7.f3581d.a() * r7.f3581d.b()) * 4;
        int r3 = Math.round(r7.f * r2);
        int r4 = Math.round(r2 * r7.f3582e);
        int r5 = r1 - r0;
        int r6 = r4 + r3;
        if (r6 > r5) goto L9;
        this.f3575b = r4;
        this.f3574a = r3;
    L11:
        if (a(TAG, 3) == false) goto L18;
        StringBuilder r8 = new StringBuilder().append("Calculation complete, Calculated memory cache size: ").append(a(this.f3575b)).append(", pool size: ").append(a(this.f3574a)).append(", byte array size: ").append(a(r0)).append(", memory class limited? ");
        if (r6 <= r1) goto L15;
        boolean r9 = true;
    L16:
        a(TAG, r8.append(r9).append(", max size: ").append(a(r1)).append(", memoryClass: ").append(r7.f3580c.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(r7.f3580c)).toString());
        return;
    L15:
        r9 = false;
        goto L16
    L18:
        return;
    L9:
        float r10 = r5 / (r7.f + r7.f3582e);
        this.f3575b = Math.round(r7.f3582e * r10);
        this.f3574a = Math.round(r10 * r7.f);
        goto L11
    L5:
        r0 = r7.i;
        goto L6
    }

    public int a() {
        return this.f3575b;
    }

    public int b() {
        return this.f3574a;
    }

    public int c() {
        return this.f3577d;
    }

    private static int a(ActivityManager r1, float r2, float r3) {
        float r0 = (r1.getMemoryClass() * 1024) * 1024;
        if (a(r1) == false) goto L6;
        r2 = r3;
    L6:
        return Math.round(r0 * r2);
    }

    private String a(int r3) {
        return Formatter.formatFileSize(this.f3576c, r3);
    }

    static boolean a(ActivityManager r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return true;
    L5:
        return r2.isLowRamDevice();
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
