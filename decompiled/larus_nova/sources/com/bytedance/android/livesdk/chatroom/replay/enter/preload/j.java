package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import com.bytedance.android.livesdk.chatroom.replay_api.model.ReplayVideoPositionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f108609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Episode f108610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f108611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReplayVideoPositionInfo f108612d;

    public interface a {
        void a(long r100);

        void b(long r100);

        void c(long r100);
    }

    public j(Episode r100, c r101, ReplayVideoPositionInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "episode");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f108610b = r100;
        this.f108611c = r101;
        this.f108612d = r102;
    }
}
