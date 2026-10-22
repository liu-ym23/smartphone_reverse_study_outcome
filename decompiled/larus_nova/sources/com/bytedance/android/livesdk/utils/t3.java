package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.ev;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f159166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f159167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f159168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f159169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f159170e;

    static {
        f159168c = true;
        f159169d = true;
        f159170e = true;
    }

    @JvmStatic
    public static final boolean b() {
        if (f159166a == true) goto L5;
    L19:
        return false;
    L5:
        if (f159167b == true) goto L19;
        if (f159168c == true) goto L19;
        if (f159169d == true) goto L19;
        if (f159170e == true) goto L19;
        if (e5.n() == true) goto L19;
        if (ev.f120156a.getValue().booleanValue() == false) goto L19;
        com.bytedance.android.livesdk.e.b().getClass();
        if (com.bytedance.android.livesdk.e.c() == true) goto L19;
        return true;
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d("LiveF2RoomInfoManager", r100 + ": isAllowF2PopWindow: " + b() + ", isLiveScene: " + f159166a + ", isClearMode: " + f159167b + ", isMediaRoom: " + f159168c + ", isPaidLive: " + f159169d);
        return;
    }

    @JvmStatic
    public static final void c(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        f159167b = r100;
        a("setCleanMode_".concat(r101));
    }

    @JvmStatic
    public static final void d(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        f159166a = r100;
        a("setLiveScene_".concat(r101));
    }
}
