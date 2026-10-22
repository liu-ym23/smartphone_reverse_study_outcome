package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import com.bytedance.android.livesdk.chatroom.replay_api.model.ReplayVideoPositionInfo;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayVideoInfoApi;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import lm1.d;

/* JADX INFO: loaded from: classes7.dex */
public abstract class m<T extends lm1.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dl1.f f108616a;

    public abstract boolean a(T r100);

    public abstract Observable<ReplayVideoInfoApi.b> b(T r100);

    public abstract ReplayVideoPositionInfo c(pm1.c r100, Episode r101);

    public void d(T r100, Episode r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "episode");
    }

    public m(dl1.f r100) {
        Intrinsics.checkNotNullParameter(r100, "preloadCallback");
        this.f108616a = r100;
    }
}
