package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.io.File;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: HardwareConfigState.java */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final File f3824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile r f3825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f3826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3828e;
    private int f;
    private boolean g;

    static {
        f3824a = new File("/proc/self/fd");
    }

    public static r a() {
        if (f3825b != null) goto L15;
        monitor-enter(r.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3825b != null) goto L9;
        f3825b = new r();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r.class);     // Catch: Throwable -> L11
    L15:
        return f3825b;
    }

    r() {
        this.g = true;
        this.f3826c = b();
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.f3827d = 20000;
        this.f3828e = 0;
        return;
    L5:
        this.f3827d = 700;
        this.f3828e = 128;
    }

    public boolean a(int r3, int r4, boolean r5, boolean r6) {
        if (r5 == true) goto L5;
        return false;
    L5:
        if (this.f3826c == true) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 26) goto L19;
        if (r6 == true) goto L23;
        int r7 = this.f3828e;
        if (r3 < r7) goto L20;
        if (r4 >= r7) goto L14;
        return false;
    L14:
        if (c() == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        return false;
    L23:
        return false;
    L19:
        return false;
    }

    boolean a(int r1, int r2, BitmapFactory.Options r3, boolean r4, boolean r5) {
        boolean r0 = a(r1, r2, r4, r5);
        if (r0 == false) goto L5;
        r3.inPreferredConfig = Bitmap.Config.HARDWARE;
        r3.inMutable = false;
    L5:
        return r0;
    }

    private static boolean b() {
        if (Build.MODEL != null) goto L5;
        return true;
    L5:
        if (Build.MODEL.length() < 7) goto L46;
        String r0 = Build.MODEL.substring(0, 7);
        r0.hashCode();
        byte r2 = -1;
        switch(r0.hashCode()) {
            case -1398613787: goto L35;
            case -1398431166: goto L31;
            case -1398431161: goto L27;
            case -1398431073: goto L23;
            case -1398431068: goto L19;
            case -1398343746: goto L15;
            case -1398222624: goto L11;
            default: goto L38;
        };
    L38:
        switch(r2) {
            case 0: goto L41;
            case 1: goto L41;
            case 2: goto L41;
            case 3: goto L41;
            case 4: goto L41;
            case 5: goto L41;
            case 6: goto L41;
            default: goto L39;
        };
    L39:
        return true;
    L41:
        if (Build.VERSION.SDK_INT == 26) goto L44;
        return true;
    L44:
        return false;
    L11:
        if (r0.equals("SM-N935") == false) goto L38;
        r2 = 6;
        goto L38
    L15:
        if (r0.equals("SM-J720") == false) goto L38;
        r2 = 5;
        goto L38
    L19:
        if (r0.equals("SM-G965") == false) goto L38;
        r2 = 4;
        goto L38
    L23:
        if (r0.equals("SM-G960") == false) goto L38;
        r2 = 3;
        goto L38
    L27:
        if (r0.equals("SM-G935") == false) goto L38;
        r2 = 2;
        goto L38
    L31:
        if (r0.equals("SM-G930") == false) goto L38;
        r2 = 1;
        goto L38
    L35:
        if (r0.equals("SM-A520") == false) goto L38;
        r2 = 0;
        goto L38
    L46:
        return true;
    }

    private synchronized boolean c() {
        monitor-enter(this);
        boolean r1 = true;
        int r0 = this.f + 1;     // Catch: Throwable -> L17
        this.f = r0;     // Catch: Throwable -> L17
        if (r0 < 50) goto L14;
        this.f = 0;     // Catch: Throwable -> L17
        int r2 = f3824a.list().length;     // Catch: Throwable -> L17
        if (r2 < this.f3827d) goto L9;
        r1 = false;
    L9:
        this.g = r1;     // Catch: Throwable -> L17
        if (r1 == true) goto L14;
        if (a("Downsampler", 5) == false) goto L14;
        a("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + r2 + ", limit " + this.f3827d);     // Catch: Throwable -> L17
    L14:
        boolean r3 = this.g;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r3;
    L17:
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
        return Log.w(r1, r2);
    }
}
