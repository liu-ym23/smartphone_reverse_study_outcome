package com.bytedanceos.common.toolbox;

import com.bytedanceos.common.BaseApplication;
import com.tencent.mmkv.MMKV;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f10054b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g0 f10055c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MMKV f10056a;

    static {
    }

    public g0() {
        if (f10054b == false) goto L6;
        this.f10056a = MMKV.f();
        return;
    }

    public static g0 a() {
        if (f10055c != null) goto L16;
        monitor-enter(g0.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f10055c != null) goto L11;
        f10055c = new g0();     // Catch: Throwable -> L9
    L11:
        monitor-exit(g0.class);     // Catch: Throwable -> L9
    L16:
        return f10055c;
    }

    public boolean b() {
        if (f10054b == true) goto L5;
        return false;
    L5:
        if (this.f10056a.c("autoUpdateNoPrompt") != 100003070) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean c() {
        if (f10054b == true) goto L5;
        return true;
    L5:
        if (BaseApplication.c().o() == false) goto L9;
        return this.f10056a.b("firstBoot_AppStore", true);
    L9:
        return this.f10056a.b("firstBoot_GameStore", true);
    }

    public boolean d() {
        if (f10054b == true) goto L5;
        return true;
    L5:
        return this.f10056a.b("showNavigationCount", true);
    }

    public void e(boolean r10) {
        if (f10054b == false) goto L6;
        this.f10056a.i("autoUpdate", r10);
        return;
    }

    public void f(int r10) {
        if (f10054b == false) goto L6;
        this.f10056a.g("autoUpdateNoPrompt", r10);
        return;
    }

    public void g(boolean r10) {
        if (f10054b == false) goto L6;
        this.f10056a.i("showNavigationCount", r10);
        return;
    }

    public void h(boolean r10) {
        if (f10054b == false) goto L6;
        this.f10056a.i("showRecommendNotification", r10);
        return;
    }

    public void i(boolean r10) {
        if (f10054b == false) goto L6;
        this.f10056a.i("showDesktopCount", r10);
        return;
    }

    public void j(boolean r10) {
        if (f10054b == false) goto L6;
        this.f10056a.i("showUpdateNotification", r10);
        return;
    }
}
