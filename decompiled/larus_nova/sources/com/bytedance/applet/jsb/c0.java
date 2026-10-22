package com.bytedance.applet.jsb;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.lynx.canvas.KryptonCamera;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c0 implements a88.c, a88.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f192045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f192046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f192047c;

    public c0() {
    }

    @Override // a88.b
    public final void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
    }

    static {
        c0 r100 = new c0();
        f192045a = r100;
        f192047c = "stopped";
        MusicPlayManagerDelegate r101 = MusicPlayManagerDelegate.f290176b;
        r101.l();
        r101.k(r100);
    }

    @Override // a88.c
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f192046b = r100;
        f192047c = "prepare";
        g.a(r100, "prepare");
        j(r100, "prepare");
    }

    @Override // a88.b
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f.a(r100, 0);
        c(r100, 0);
    }

    @Override // a88.c
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f192046b = r100;
        g.a(r100, VideoEventOneOutSync.END_TYPE_FINISH);
        j(r100, VideoEventOneOutSync.END_TYPE_FINISH);
    }

    @Override // a88.c
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f192046b = r100;
        f192047c = "error";
        g.a(r100, "error");
        j(r100, "error");
    }

    public final String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originalResolution");
        switch(r100.hashCode()) {
            case 2249154: goto L18;
            case 68069317: goto L14;
            case 1377272541: goto L10;
            case 1670753181: goto L6;
            default: goto L21;
        };
    L21:
        return null;
    L6:
        if (r100.equals("SuperHigh") == false) goto L21;
        return "highest";
    L10:
        if (r100.equals("Standard") == false) goto L21;
        return KryptonCamera.Config.RESOLUTION_MEDIUM;
    L14:
        if (r100.equals("FourK") == false) goto L21;
        return "lossless";
    L18:
        if (r100.equals("High") == false) goto L21;
        return "higher";
    }

    @Override // a88.c
    public final void onError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f192046b = r100;
        f192047c = "error";
        g.a(r100, "error");
        j(r100, "error");
    }

    public static void c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        HashSet<AppletRuntime> r102 = AppletRuntime.c.f36736a;
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.put("music_id", r100);
        r103.put("action_type", Integer.valueOf(r101));
        Unit r104 = Unit.INSTANCE;
        AppletRuntime.c.a("musicActionTriggered", r103);
    }

    public static void j(String r100, String r101) {
        HashSet<AppletRuntime> r102 = AppletRuntime.c.f36736a;
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.put("music_id", r100);
        r103.put("status", r101);
        Unit r104 = Unit.INSTANCE;
        AppletRuntime.c.a("musicPlayStatusChanged", r103);
    }

    @Override // a88.c
    public final void g(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        if (r101 != 0) goto L5;
        String r102 = "stopped";
    L12:
        f192046b = r100;
        f192047c = r102;
        g.a(r100, r102);
        j(r100, r102);
        return;
    L5:
        if (r101 != 1) goto L7;
        r102 = "playing";
        goto L12
    L7:
        if (r101 == 2) goto L9;
        r102 = "unknown";
        goto L12
    L9:
        r102 = "paused";
        goto L12
    }

    @Override // a88.c
    public final void i(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f192046b = r100;
        if (r101 != 3) goto L6;
        f192047c = "error";
        g.a(r100, "error");
        j(r100, "error");
        return;
    }

    @Override // a88.b
    public final void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Intrinsics.checkNotNullParameter(r101, "fromProgress");
        Intrinsics.checkNotNullParameter(r102, "toProgress");
        f.a(r100, 3);
        c(r100, 3);
    }
}
