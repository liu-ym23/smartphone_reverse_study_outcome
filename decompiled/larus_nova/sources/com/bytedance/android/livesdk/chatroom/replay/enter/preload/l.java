package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayVideoInfoApi;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSRoomIDData;
import io.reactivex.functions.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pm1.e f108615a;

    public l(pm1.e r100) {
        this.f108615a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        ReplayVideoInfoApi.b r102 = new ReplayVideoInfoApi.b();
        VSRoomIDData r103 = (VSRoomIDData) r101.data;
        if (r103.episodeStage != EpisodeMod.EpisodeStageType.RECORD) goto L7;
        Episode r104 = r103.episode;
        if (r104 == null) goto L7;
        r104.getId();
        this.f108615a.getClass();
        Episode r105 = ((VSRoomIDData) r101.data).episode;
        Intrinsics.checkNotNull(r105);
        r102.c(CollectionsKt.mutableListOf(new Episode[]{r105}));
    L7:
        return r102;
    }
}
