package com.bytedance.android.livesdk.livecommerce.playback.video;

import android.content.Context;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExplainPlaybackVideoInfo f150012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECReplayVideo f150013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f150014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f150015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final da3.b f150016e;

    public final boolean a() {
        int r100 = bj2.a.f19209a;
        bj2.a.b("VideoPlayBackPlayController", "isPlaying:" + this.f150016e.isPlaying());
        return this.f150016e.isPlaying();
    }

    public final void b() {
        bj2.a.b("VideoPlayBackPlayController", "pauseVideo");
        this.f150016e.b();
    }

    public final void d() {
        bj2.a.b("VideoPlayBackPlayController", "resumeVideo");
        this.f150016e.c();
    }

    public final Context getContext() {
        return this.f150015d;
    }

    public final void c(boolean r100) {
        bj2.a.b("VideoPlayBackPlayController", "release");
        this.f150016e.release(r100);
    }

    public final void e(da3.d r100) {
        int r101 = bj2.a.f19209a;
        bj2.a.b("VideoPlayBackPlayController", "setECVideoListener:" + r100);
        this.f150016e.e(r100);
    }

    public e(Context r100, da3.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "playbackVideoView");
        this.f150015d = r100;
        this.f150016e = r101;
        this.f150014c = aj2.a.a();
    }
}
