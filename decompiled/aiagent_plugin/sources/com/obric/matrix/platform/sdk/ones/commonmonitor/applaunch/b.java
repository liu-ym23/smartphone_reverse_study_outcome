package com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch;

/* JADX INFO: compiled from: LaunchSceneMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "LaunchSceneMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f33639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f33640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f33641d;

    private b() {
    }

    public final int a() {
        return f33639b;
    }

    public final void a(int r1) {
        f33639b = r1;
    }

    public final void a(String r1) {
        f33640c = r1;
    }

    public final String b() {
        return f33640c;
    }

    static {
        f33638a = new b();
        f33641d = -1;
    }

    public final long c() {
        return f33641d;
    }

    public final boolean d() {
        if (f33639b == 2) goto L5;
        return true;
    L5:
        return false;
    }
}
