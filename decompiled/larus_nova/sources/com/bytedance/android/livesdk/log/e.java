package com.bytedance.android.livesdk.log;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livehostapi.platform.IHostConfig;
import com.bytedance.android.livesdkapi.feed.IFeedSceneTracer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements IFeedSceneTracer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f153282d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f153283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f153284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f153285c;

    static {
        f153282d = new e();
    }

    public e() {
        this.f153285c = false;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IFeedSceneTracer
    public final void end(String r100) {
        if (TextUtils.equals(r100, this.f153284b) == true) goto L5;
        return;
    L5:
        if (this.f153285c == false) goto L18;
        this.f153285c = false;
        this.f153284b = null;
        long r101 = SystemClock.elapsedRealtime() - this.f153283a;
        HashMap r102 = new HashMap();
        r102.put("scene_type", r100);
        r102.put("duration", Long.valueOf(r101));
        if (jc1.k.f(IHostConfig.class) != null) goto L10;
    L15:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_feed_first_frame_scene_monitor_all", 0, r101, r102);
        return;
    L10:
        if (((IHostConfig) jc1.k.f(IHostConfig.class)).appConfig() == null) goto L15;
        if (((IHostConfig) jc1.k.f(IHostConfig.class)).appConfig().enableLiveVideoMixOpt() == false) goto L14;
        r102.put("opt_enable", 1);
        goto L15
    L14:
        r102.put("opt_enable", 0);
        goto L15
    }

    @Override // com.bytedance.android.livesdkapi.feed.IFeedSceneTracer
    public final void realStart(String r100) {
        if (TextUtils.equals(r100, this.f153284b) == true) goto L6;
        this.f153284b = null;
        this.f153285c = false;
        return;
    L6:
        this.f153285c = true;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IFeedSceneTracer
    public final void start(String r100) {
        this.f153284b = r100;
        this.f153283a = SystemClock.elapsedRealtime();
    }
}
