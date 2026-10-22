package com.bytedance.android.livesdk.chatroom.vsplayer.api;

import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface d {

    public static final class a {
        public static void a(EpisodeHighLight r100, Pair r101) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r101, "pair");
        }

        public static void b(EpisodeHighLight r100, Pair r101) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r101, "pair");
        }
    }

    void C5();

    void D5();

    void E5();

    void F5(EpisodeHighLight r100, Pair<Integer, Boolean> r101);

    void G5(boolean r100);

    void H5();

    void I5(EpisodeHighLight r100, Pair<Integer, Boolean> r101);

    void P1();

    void g5();

    void k2();

    void l3();

    void onRenderStart();

    void v2(EpisodeHighLight r100);

    void z();
}
