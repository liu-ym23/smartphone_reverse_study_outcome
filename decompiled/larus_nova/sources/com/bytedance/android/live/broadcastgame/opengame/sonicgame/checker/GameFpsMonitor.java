package com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.config.le0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class GameFpsMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f61041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f61042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f61043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GameFpsMonitor$fpsCheckTask$1 f61044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final na4.b f61045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PluginContext f61046f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (le0.f120673a.getValue().c() == true) goto L6;
        return;
    L6:
        if (this.f61041a <= this.f61042b) goto L8;
        return;
    L8:
        MainThreadPostUtils.c(this.f61044d, this.f61043c);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker.GameFpsMonitor$fpsCheckTask$1] */
    public GameFpsMonitor(na4.b r100, PluginContext r101) {
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f61045e = r100;
        this.f61046f = r101;
        le0 r102 = le0.f120673a;
        this.f61042b = r102.getValue().b();
        this.f61043c = r102.getValue().a();
        this.f61044d = new GameFpsMonitor$fpsCheckTask$1(this);
    }
}
